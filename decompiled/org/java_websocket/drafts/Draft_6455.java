/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Draft_6455
extends Draft {
    private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
    private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
    private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String UPGRADE = "Upgrade";
    private static final String CONNECTION = "Connection";
    private final Logger log = LoggerFactory.getLogger(Draft_6455.class);
    private IExtension extension = new DefaultExtension();
    private List<IExtension> knownExtensions;
    private IProtocol protocol;
    private List<IProtocol> knownProtocols;
    private Framedata currentContinuousFrame;
    private final List<ByteBuffer> byteBufferList;
    private ByteBuffer incompleteframe;
    private final SecureRandom reuseableRandom = new SecureRandom();
    private int maxFrameSize;

    public Draft_6455() {
        this(Collections.emptyList());
    }

    public Draft_6455(IExtension iExtension) {
        this(Collections.singletonList(iExtension));
    }

    public Draft_6455(List<IExtension> list) {
        this(list, Collections.singletonList(new Protocol("")));
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public Draft_6455(List<IExtension> list, int n2) {
        this(list, Collections.singletonList(new Protocol("")), n2);
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2, int n2) {
        if (list == null || list2 == null || n2 < 1) {
            throw new IllegalArgumentException();
        }
        this.knownExtensions = new ArrayList<IExtension>(list.size());
        this.knownProtocols = new ArrayList<IProtocol>(list2.size());
        boolean bl2 = false;
        this.byteBufferList = new ArrayList<ByteBuffer>();
        for (IExtension iExtension : list) {
            if (!iExtension.getClass().equals(DefaultExtension.class)) continue;
            bl2 = true;
        }
        this.knownExtensions.addAll(list);
        if (!bl2) {
            this.knownExtensions.add(this.knownExtensions.size(), this.extension);
        }
        this.knownProtocols.addAll(list2);
        this.maxFrameSize = n2;
    }

    @Override
    public HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        int n2 = this.readVersion(clientHandshake);
        if (n2 != 13) {
            this.log.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String string = clientHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Object object = this.knownExtensions.iterator();
        while (object.hasNext()) {
            IExtension iExtension = object.next();
            if (!iExtension.acceptProvidedExtensionAsServer(string)) continue;
            this.extension = iExtension;
            handshakeState = HandshakeState.MATCHED;
            this.log.trace("acceptHandshakeAsServer - Matching extension found: {}", (Object)this.extension);
            break;
        }
        if ((object = this.containsRequestedProtocol(clientHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL))) == HandshakeState.MATCHED && handshakeState == HandshakeState.MATCHED) {
            return HandshakeState.MATCHED;
        }
        this.log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    private HandshakeState containsRequestedProtocol(String string) {
        for (IProtocol iProtocol : this.knownProtocols) {
            if (!iProtocol.acceptProvidedProtocol(string)) continue;
            this.protocol = iProtocol;
            this.log.trace("acceptHandshake - Matching protocol found: {}", (Object)this.protocol);
            return HandshakeState.MATCHED;
        }
        return HandshakeState.NOT_MATCHED;
    }

    @Override
    public HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (!this.basicAccept(serverHandshake)) {
            this.log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        }
        if (!clientHandshake.hasFieldValue(SEC_WEB_SOCKET_KEY) || !serverHandshake.hasFieldValue(SEC_WEB_SOCKET_ACCEPT)) {
            this.log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        }
        String string = serverHandshake.getFieldValue(SEC_WEB_SOCKET_ACCEPT);
        String string2 = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (!(string2 = this.generateFinalKey(string2)).equals(string)) {
            this.log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String string3 = serverHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Object object = this.knownExtensions.iterator();
        while (object.hasNext()) {
            IExtension iExtension = object.next();
            if (!iExtension.acceptProvidedExtensionAsClient(string3)) continue;
            this.extension = iExtension;
            handshakeState = HandshakeState.MATCHED;
            this.log.trace("acceptHandshakeAsClient - Matching extension found: {}", (Object)this.extension);
            break;
        }
        if ((object = this.containsRequestedProtocol(serverHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL))) == HandshakeState.MATCHED && handshakeState == HandshakeState.MATCHED) {
            return HandshakeState.MATCHED;
        }
        this.log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    public IExtension getExtension() {
        return this.extension;
    }

    public List<IExtension> getKnownExtensions() {
        return this.knownExtensions;
    }

    public IProtocol getProtocol() {
        return this.protocol;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public List<IProtocol> getKnownProtocols() {
        return this.knownProtocols;
    }

    @Override
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put(UPGRADE, "websocket");
        clientHandshakeBuilder.put(CONNECTION, UPGRADE);
        byte[] byArray = new byte[16];
        this.reuseableRandom.nextBytes(byArray);
        clientHandshakeBuilder.put(SEC_WEB_SOCKET_KEY, Base64.encodeBytes(byArray));
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        StringBuilder stringBuilder = new StringBuilder();
        for (IExtension object : this.knownExtensions) {
            if (object.getProvidedExtensionAsClient() == null || object.getProvidedExtensionAsClient().length() == 0) continue;
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object.getProvidedExtensionAsClient());
        }
        if (stringBuilder.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.getProvidedProtocol().length() == 0) continue;
            if (stringBuilder2.length() > 0) {
                stringBuilder2.append(", ");
            }
            stringBuilder2.append(iProtocol.getProvidedProtocol());
        }
        if (stringBuilder2.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, stringBuilder2.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) {
        serverHandshakeBuilder.put(UPGRADE, "websocket");
        serverHandshakeBuilder.put(CONNECTION, clientHandshake.getFieldValue(CONNECTION));
        String string = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (string == null || "".equals(string)) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.put(SEC_WEB_SOCKET_ACCEPT, this.generateFinalKey(string));
        if (this.getExtension().getProvidedExtensionAsServer().length() != 0) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, this.getExtension().getProvidedExtensionAsServer());
        }
        if (this.getProtocol() != null && this.getProtocol().getProvidedProtocol().length() != 0) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, this.getProtocol().getProvidedProtocol());
        }
        serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
        serverHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
        serverHandshakeBuilder.put("Date", this.getServerTime());
        return serverHandshakeBuilder;
    }

    @Override
    public Draft copyInstance() {
        ArrayList<IExtension> arrayList = new ArrayList<IExtension>();
        for (IExtension object : this.getKnownExtensions()) {
            arrayList.add(object.copyInstance());
        }
        ArrayList arrayList2 = new ArrayList();
        for (IProtocol iProtocol : this.getKnownProtocols()) {
            arrayList2.add(iProtocol.copyInstance());
        }
        return new Draft_6455(arrayList, arrayList2, this.maxFrameSize);
    }

    @Override
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        this.getExtension().encodeFrame(framedata);
        if (this.log.isTraceEnabled()) {
            this.log.trace("afterEnconding({}): {}", (Object)framedata.getPayloadData().remaining(), (Object)(framedata.getPayloadData().remaining() > 1000 ? "too big to display" : new String(framedata.getPayloadData().array())));
        }
        return this.createByteBufferFromFramedata(framedata);
    }

    private ByteBuffer createByteBufferFromFramedata(Framedata framedata) {
        ByteBuffer byteBuffer = framedata.getPayloadData();
        boolean bl2 = this.role == Role.CLIENT;
        int n2 = this.getSizeBytes(byteBuffer);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1 + (n2 > 1 ? n2 + 1 : n2) + (bl2 ? 4 : 0) + byteBuffer.remaining());
        byte by2 = this.fromOpcode(framedata.getOpcode());
        byte by3 = (byte)(framedata.isFin() ? -128 : 0);
        by3 = (byte)(by3 | by2);
        if (framedata.isRSV1()) {
            by3 = (byte)(by3 | this.getRSVByte(1));
        }
        if (framedata.isRSV2()) {
            by3 = (byte)(by3 | this.getRSVByte(2));
        }
        if (framedata.isRSV3()) {
            by3 = (byte)(by3 | this.getRSVByte(3));
        }
        byteBuffer2.put(by3);
        byte[] byArray = this.toByteArray(byteBuffer.remaining(), n2);
        assert (byArray.length == n2);
        if (n2 == 1) {
            byteBuffer2.put((byte)(byArray[0] | this.getMaskByte(bl2)));
        } else if (n2 == 2) {
            byteBuffer2.put((byte)(0x7E | this.getMaskByte(bl2)));
            byteBuffer2.put(byArray);
        } else if (n2 == 8) {
            byteBuffer2.put((byte)(0x7F | this.getMaskByte(bl2)));
            byteBuffer2.put(byArray);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (bl2) {
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(4);
            byteBuffer3.putInt(this.reuseableRandom.nextInt());
            byteBuffer2.put(byteBuffer3.array());
            int n3 = 0;
            while (byteBuffer.hasRemaining()) {
                byteBuffer2.put((byte)(byteBuffer.get() ^ byteBuffer3.get(n3 % 4)));
                ++n3;
            }
        } else {
            byteBuffer2.put(byteBuffer);
            byteBuffer.flip();
        }
        assert (byteBuffer2.remaining() == 0) : byteBuffer2.remaining();
        byteBuffer2.flip();
        return byteBuffer2;
    }

    private Framedata translateSingleFrame(ByteBuffer byteBuffer) {
        Object object;
        Object object2;
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int n2 = byteBuffer.remaining();
        int n3 = 2;
        this.translateSingleFrameCheckPacketSize(n2, n3);
        byte by2 = byteBuffer.get();
        boolean bl2 = by2 >> 8 != 0;
        boolean bl3 = (by2 & 0x40) != 0;
        boolean bl4 = (by2 & 0x20) != 0;
        boolean bl5 = (by2 & 0x10) != 0;
        byte by3 = byteBuffer.get();
        boolean bl6 = (by3 & 0xFFFFFF80) != 0;
        int n4 = by3 & 0x7F;
        Opcode opcode = this.toOpcode((byte)(by2 & 0xF));
        if (n4 < 0 || n4 > 125) {
            object2 = this.translateSingleFramePayloadLength(byteBuffer, opcode, n4, n2, n3);
            n4 = ((a)object2).a();
            n3 = ((a)object2).b();
        }
        this.translateSingleFrameCheckLengthLimit(n4);
        n3 += bl6 ? 4 : 0;
        this.translateSingleFrameCheckPacketSize(n2, n3 += n4);
        object2 = ByteBuffer.allocate(this.checkAlloc(n4));
        if (bl6) {
            object = new byte[4];
            byteBuffer.get((byte[])object);
            for (int i2 = 0; i2 < n4; ++i2) {
                ((ByteBuffer)object2).put((byte)(byteBuffer.get() ^ object[i2 % 4]));
            }
        } else {
            ((ByteBuffer)object2).put(byteBuffer.array(), byteBuffer.position(), ((Buffer)object2).limit());
            byteBuffer.position(byteBuffer.position() + ((Buffer)object2).limit());
        }
        object = FramedataImpl1.get(opcode);
        ((FramedataImpl1)object).setFin(bl2);
        ((FramedataImpl1)object).setRSV1(bl3);
        ((FramedataImpl1)object).setRSV2(bl4);
        ((FramedataImpl1)object).setRSV3(bl5);
        ((ByteBuffer)object2).flip();
        ((FramedataImpl1)object).setPayload((ByteBuffer)object2);
        this.getExtension().isFrameValid((Framedata)object);
        this.getExtension().decodeFrame((Framedata)object);
        if (this.log.isTraceEnabled()) {
            this.log.trace("afterDecoding({}): {}", (Object)((FramedataImpl1)object).getPayloadData().remaining(), (Object)(((FramedataImpl1)object).getPayloadData().remaining() > 1000 ? "too big to display" : new String(((FramedataImpl1)object).getPayloadData().array())));
        }
        ((FramedataImpl1)object).isValid();
        return object;
    }

    private a translateSingleFramePayloadLength(ByteBuffer byteBuffer, Opcode opcode, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = n4;
        if (opcode == Opcode.PING || opcode == Opcode.PONG || opcode == Opcode.CLOSING) {
            this.log.trace("Invalid frame: more than 125 octets");
            throw new InvalidFrameException("more than 125 octets");
        }
        if (n5 == 126) {
            this.translateSingleFrameCheckPacketSize(n3, n6 += 2);
            byte[] byArray = new byte[3];
            byArray[1] = byteBuffer.get();
            byArray[2] = byteBuffer.get();
            n5 = new BigInteger(byArray).intValue();
        } else {
            this.translateSingleFrameCheckPacketSize(n3, n6 += 8);
            byte[] byArray = new byte[8];
            for (int i2 = 0; i2 < 8; ++i2) {
                byArray[i2] = byteBuffer.get();
            }
            long l2 = new BigInteger(byArray).longValue();
            this.translateSingleFrameCheckLengthLimit(l2);
            n5 = (int)l2;
        }
        return new a(this, n5, n6);
    }

    private void translateSingleFrameCheckLengthLimit(long l2) {
        if (l2 > Integer.MAX_VALUE) {
            this.log.trace("Limit exedeed: Payloadsize is to big...");
            throw new LimitExceededException("Payloadsize is to big...");
        }
        if (l2 > (long)this.maxFrameSize) {
            this.log.trace("Payload limit reached. Allowed: {} Current: {}", (Object)this.maxFrameSize, (Object)l2);
            throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
        }
        if (l2 < 0L) {
            this.log.trace("Limit underflow: Payloadsize is to little...");
            throw new LimitExceededException("Payloadsize is to little...");
        }
    }

    private void translateSingleFrameCheckPacketSize(int n2, int n3) {
        if (n2 < n3) {
            this.log.trace("Incomplete frame: maxpacketsize < realpacketsize");
            throw new IncompleteException(n3);
        }
    }

    private byte getRSVByte(int n2) {
        switch (n2) {
            case 1: {
                return 64;
            }
            case 2: {
                return 32;
            }
            case 3: {
                return 16;
            }
        }
        return 0;
    }

    private byte getMaskByte(boolean bl2) {
        return bl2 ? (byte)-128 : 0;
    }

    private int getSizeBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        if (byteBuffer.remaining() <= 65535) {
            return 2;
        }
        return 8;
    }

    @Override
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) {
        Framedata framedata;
        int n2;
        LinkedList<Framedata> linkedList;
        while (true) {
            linkedList = new LinkedList<Framedata>();
            if (this.incompleteframe == null) break;
            try {
                byteBuffer.mark();
                int n3 = byteBuffer.remaining();
                n2 = this.incompleteframe.remaining();
                if (n2 > n3) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), n3);
                    byteBuffer.position(byteBuffer.position() + n3);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), n2);
                byteBuffer.position(byteBuffer.position() + n2);
                framedata = this.translateSingleFrame(this.incompleteframe.duplicate().position(0));
                linkedList.add(framedata);
                this.incompleteframe = null;
            }
            catch (IncompleteException incompleteException) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(this.checkAlloc(incompleteException.getPreferredSize()));
                assert (byteBuffer2.limit() > this.incompleteframe.limit());
                this.incompleteframe.rewind();
                byteBuffer2.put(this.incompleteframe);
                this.incompleteframe = byteBuffer2;
                continue;
            }
            break;
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                framedata = this.translateSingleFrame(byteBuffer);
                linkedList.add(framedata);
            }
            catch (IncompleteException incompleteException) {
                byteBuffer.reset();
                n2 = incompleteException.getPreferredSize();
                this.incompleteframe = ByteBuffer.allocate(this.checkAlloc(n2));
                this.incompleteframe.put(byteBuffer);
                break;
            }
        }
        return linkedList;
    }

    @Override
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean bl2) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.setPayload(byteBuffer);
        binaryFrame.setTransferemasked(bl2);
        try {
            binaryFrame.isValid();
        }
        catch (InvalidDataException invalidDataException) {
            throw new NotSendableException(invalidDataException);
        }
        return Collections.singletonList(binaryFrame);
    }

    @Override
    public List<Framedata> createFrames(String string, boolean bl2) {
        TextFrame textFrame = new TextFrame();
        textFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(string)));
        textFrame.setTransferemasked(bl2);
        try {
            textFrame.isValid();
        }
        catch (InvalidDataException invalidDataException) {
            throw new NotSendableException(invalidDataException);
        }
        return Collections.singletonList(textFrame);
    }

    @Override
    public void reset() {
        this.incompleteframe = null;
        if (this.extension != null) {
            this.extension.reset();
        }
        this.extension = new DefaultExtension();
        this.protocol = null;
    }

    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String generateFinalKey(String string) {
        MessageDigest messageDigest;
        String string2 = string.trim();
        String string3 = string2 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new IllegalStateException(noSuchAlgorithmException);
        }
        return Base64.encodeBytes(messageDigest.digest(string3.getBytes()));
    }

    private byte[] toByteArray(long l2, int n2) {
        byte[] byArray = new byte[n2];
        int n3 = 8 * n2 - 8;
        for (int i2 = 0; i2 < n2; ++i2) {
            byArray[i2] = (byte)(l2 >>> n3 - 8 * i2);
        }
        return byArray;
    }

    private byte fromOpcode(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return 0;
        }
        if (opcode == Opcode.TEXT) {
            return 1;
        }
        if (opcode == Opcode.BINARY) {
            return 2;
        }
        if (opcode == Opcode.CLOSING) {
            return 8;
        }
        if (opcode == Opcode.PING) {
            return 9;
        }
        if (opcode == Opcode.PONG) {
            return 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private Opcode toOpcode(byte by2) {
        switch (by2) {
            case 0: {
                return Opcode.CONTINUOUS;
            }
            case 1: {
                return Opcode.TEXT;
            }
            case 2: {
                return Opcode.BINARY;
            }
            case 8: {
                return Opcode.CLOSING;
            }
            case 9: {
                return Opcode.PING;
            }
            case 10: {
                return Opcode.PONG;
            }
        }
        throw new InvalidFrameException("Unknown opcode " + (short)by2);
    }

    @Override
    public void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) {
        Opcode opcode = framedata.getOpcode();
        if (opcode == Opcode.CLOSING) {
            this.processFrameClosing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PING) {
            webSocketImpl.getWebSocketListener().onWebsocketPing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PONG) {
            webSocketImpl.updateLastPong();
            webSocketImpl.getWebSocketListener().onWebsocketPong(webSocketImpl, framedata);
        } else if (!framedata.isFin() || opcode == Opcode.CONTINUOUS) {
            this.processFrameContinuousAndNonFin(webSocketImpl, framedata, opcode);
        } else {
            if (this.currentContinuousFrame != null) {
                this.log.error("Protocol error: Continuous frame sequence not completed.");
                throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
            }
            if (opcode == Opcode.TEXT) {
                this.processFrameText(webSocketImpl, framedata);
            } else if (opcode == Opcode.BINARY) {
                this.processFrameBinary(webSocketImpl, framedata);
            } else {
                this.log.error("non control or continious frame expected");
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    private void processFrameContinuousAndNonFin(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) {
        if (opcode != Opcode.CONTINUOUS) {
            this.processFrameIsNotFin(framedata);
        } else if (framedata.isFin()) {
            this.processFrameIsFin(webSocketImpl, framedata);
        } else if (this.currentContinuousFrame == null) {
            this.log.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.isValidUTF8(framedata.getPayloadData())) {
            this.log.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        }
        if (opcode == Opcode.CONTINUOUS && this.currentContinuousFrame != null) {
            this.addToBufferList(framedata.getPayloadData());
        }
    }

    private void processFrameBinary(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, framedata.getPayloadData());
        }
        catch (RuntimeException runtimeException) {
            this.logRuntimeException(webSocketImpl, runtimeException);
        }
    }

    private void logRuntimeException(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        this.log.error("Runtime exception during onWebsocketMessage", runtimeException);
        webSocketImpl.getWebSocketListener().onWebsocketError(webSocketImpl, runtimeException);
    }

    private void processFrameText(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
        }
        catch (RuntimeException runtimeException) {
            this.logRuntimeException(webSocketImpl, runtimeException);
        }
    }

    private void processFrameIsFin(WebSocketImpl webSocketImpl, Framedata framedata) {
        if (this.currentContinuousFrame == null) {
            this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        this.addToBufferList(framedata.getPayloadData());
        this.checkBufferLimit();
        if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT) {
            ((FramedataImpl1)this.currentContinuousFrame).setPayload(this.getPayloadFromByteBufferList());
            ((FramedataImpl1)this.currentContinuousFrame).isValid();
            try {
                webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
            }
            catch (RuntimeException runtimeException) {
                this.logRuntimeException(webSocketImpl, runtimeException);
            }
        } else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY) {
            ((FramedataImpl1)this.currentContinuousFrame).setPayload(this.getPayloadFromByteBufferList());
            ((FramedataImpl1)this.currentContinuousFrame).isValid();
            try {
                webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, this.currentContinuousFrame.getPayloadData());
            }
            catch (RuntimeException runtimeException) {
                this.logRuntimeException(webSocketImpl, runtimeException);
            }
        }
        this.currentContinuousFrame = null;
        this.clearBufferList();
    }

    private void processFrameIsNotFin(Framedata framedata) {
        if (this.currentContinuousFrame != null) {
            this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
        }
        this.currentContinuousFrame = framedata;
        this.addToBufferList(framedata.getPayloadData());
        this.checkBufferLimit();
    }

    private void processFrameClosing(WebSocketImpl webSocketImpl, Framedata framedata) {
        int n2 = 1005;
        String string = "";
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame)framedata;
            n2 = closeFrame.getCloseCode();
            string = closeFrame.getMessage();
        }
        if (webSocketImpl.getReadyState() == ReadyState.CLOSING) {
            webSocketImpl.closeConnection(n2, string, true);
        } else if (this.getCloseHandshakeType() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.close(n2, string, true);
        } else {
            webSocketImpl.flushAndClose(n2, string, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearBufferList() {
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            this.byteBufferList.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addToBufferList(ByteBuffer byteBuffer) {
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            this.byteBufferList.add(byteBuffer);
        }
    }

    private void checkBufferLimit() {
        long l2 = this.getByteBufferListSize();
        if (l2 > (long)this.maxFrameSize) {
            this.clearBufferList();
            this.log.trace("Payload limit reached. Allowed: {} Current: {}", (Object)this.maxFrameSize, (Object)l2);
            throw new LimitExceededException(this.maxFrameSize);
        }
    }

    @Override
    public CloseHandshakeType getCloseHandshakeType() {
        return CloseHandshakeType.TWOWAY;
    }

    @Override
    public String toString() {
        String string = super.toString();
        if (this.getExtension() != null) {
            string = string + " extension: " + this.getExtension().toString();
        }
        if (this.getProtocol() != null) {
            string = string + " protocol: " + this.getProtocol().toString();
        }
        string = string + " max frame size: " + this.maxFrameSize;
        return string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Draft_6455 draft_6455 = (Draft_6455)object;
        if (this.maxFrameSize != draft_6455.getMaxFrameSize()) {
            return false;
        }
        if (this.extension != null ? !this.extension.equals(draft_6455.getExtension()) : draft_6455.getExtension() != null) {
            return false;
        }
        return this.protocol != null ? this.protocol.equals(draft_6455.getProtocol()) : draft_6455.getProtocol() == null;
    }

    public int hashCode() {
        int n2 = this.extension != null ? this.extension.hashCode() : 0;
        n2 = 31 * n2 + (this.protocol != null ? this.protocol.hashCode() : 0);
        n2 = 31 * n2 + (this.maxFrameSize ^ this.maxFrameSize >>> 32);
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ByteBuffer getPayloadFromByteBufferList() {
        ByteBuffer byteBuffer;
        long l2 = 0L;
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            for (ByteBuffer byteBuffer2 : this.byteBufferList) {
                l2 += (long)byteBuffer2.limit();
            }
            this.checkBufferLimit();
            byteBuffer = ByteBuffer.allocate((int)l2);
            for (ByteBuffer byteBuffer2 : this.byteBufferList) {
                byteBuffer.put(byteBuffer2);
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private long getByteBufferListSize() {
        long l2 = 0L;
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            for (ByteBuffer byteBuffer : this.byteBufferList) {
                l2 += (long)byteBuffer.limit();
            }
        }
        return l2;
    }

    class a {
        private int var_int_a;
        private int b;
        final /* synthetic */ Draft_6455 var_org_java_websocket_drafts_Draft_6455_a;

        private int a() {
            return this.var_int_a;
        }

        private int b() {
            return this.b;
        }

        a(Draft_6455 draft_6455, int n2, int n3) {
            this.var_org_java_websocket_drafts_Draft_6455_a = draft_6455;
            this.var_int_a = n2;
            this.b = n3;
        }
    }
}

