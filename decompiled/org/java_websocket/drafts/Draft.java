/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public abstract class Draft {
    protected Role role = null;
    protected Opcode continuousFrameType = null;

    public static ByteBuffer readLine(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.remaining());
        byte by2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte by3 = by2;
            by2 = byteBuffer.get();
            byteBuffer2.put(by2);
            if (by3 != 13 || by2 != 10) continue;
            byteBuffer2.limit(byteBuffer2.position() - 2);
            byteBuffer2.position(0);
            return byteBuffer2;
        }
        byteBuffer.position(byteBuffer.position() - byteBuffer2.position());
        return null;
    }

    public static String readStringLine(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = Draft.readLine(byteBuffer);
        return byteBuffer2 == null ? null : Charsetfunctions.stringAscii(byteBuffer2.array(), 0, byteBuffer2.limit());
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer byteBuffer, Role role) {
        String string = Draft.readStringLine(byteBuffer);
        if (string == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] stringArray = string.split(" ", 3);
        if (stringArray.length != 3) {
            throw new InvalidHandshakeException();
        }
        HandshakeBuilder handshakeBuilder = role == Role.CLIENT ? Draft.translateHandshakeHttpClient(stringArray, string) : Draft.translateHandshakeHttpServer(stringArray, string);
        string = Draft.readStringLine(byteBuffer);
        while (string != null && string.length() > 0) {
            String[] stringArray2 = string.split(":", 2);
            if (stringArray2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            if (handshakeBuilder.hasFieldValue(stringArray2[0])) {
                handshakeBuilder.put(stringArray2[0], handshakeBuilder.getFieldValue(stringArray2[0]) + "; " + stringArray2[1].replaceFirst("^ +", ""));
            } else {
                handshakeBuilder.put(stringArray2[0], stringArray2[1].replaceFirst("^ +", ""));
            }
            string = Draft.readStringLine(byteBuffer);
        }
        if (string == null) {
            throw new IncompleteHandshakeException();
        }
        return handshakeBuilder;
    }

    private static HandshakeBuilder translateHandshakeHttpServer(String[] stringArray, String string) {
        if (!"GET".equalsIgnoreCase(stringArray[0])) {
            throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", stringArray[0], string));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(stringArray[2])) {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", stringArray[2], string));
        }
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(stringArray[1]);
        return handshakeImpl1Client;
    }

    private static HandshakeBuilder translateHandshakeHttpClient(String[] stringArray, String string) {
        if (!"101".equals(stringArray[1])) {
            throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", stringArray[1], string));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(stringArray[0])) {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", stringArray[0], string));
        }
        HandshakeImpl1Server handshakeImpl1Server = new HandshakeImpl1Server();
        ServerHandshakeBuilder serverHandshakeBuilder = handshakeImpl1Server;
        serverHandshakeBuilder.setHttpStatus(Short.parseShort(stringArray[1]));
        serverHandshakeBuilder.setHttpStatusMessage(stringArray[2]);
        return handshakeImpl1Server;
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake var1, ServerHandshake var2);

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake var1);

    protected boolean basicAccept(Handshakedata handshakedata) {
        return handshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket") && handshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public abstract ByteBuffer createBinaryFrame(Framedata var1);

    public abstract List<Framedata> createFrames(ByteBuffer var1, boolean var2);

    public abstract List<Framedata> createFrames(String var1, boolean var2);

    public abstract void processFrame(WebSocketImpl var1, Framedata var2);

    public List<Framedata> continuousFrame(Opcode opcode, ByteBuffer byteBuffer, boolean bl2) {
        if (opcode != Opcode.BINARY && opcode != Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        DataFrame dataFrame = null;
        if (this.continuousFrameType != null) {
            dataFrame = new ContinuousFrame();
        } else {
            this.continuousFrameType = opcode;
            if (opcode == Opcode.BINARY) {
                dataFrame = new BinaryFrame();
            } else if (opcode == Opcode.TEXT) {
                dataFrame = new TextFrame();
            }
        }
        dataFrame.setPayload(byteBuffer);
        dataFrame.setFin(bl2);
        try {
            dataFrame.isValid();
        }
        catch (InvalidDataException invalidDataException) {
            throw new IllegalArgumentException(invalidDataException);
        }
        this.continuousFrameType = bl2 ? null : opcode;
        return Collections.singletonList(dataFrame);
    }

    public abstract void reset();

    @Deprecated
    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, Role role) {
        return this.createHandshake(handshakedata);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata) {
        return this.createHandshake(handshakedata, true);
    }

    @Deprecated
    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, Role role, boolean bl2) {
        return this.createHandshake(handshakedata, bl2);
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, boolean bl2) {
        Object object;
        Object object2;
        StringBuilder stringBuilder = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            stringBuilder.append("GET ").append(((ClientHandshake)handshakedata).getResourceDescriptor()).append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            stringBuilder.append("HTTP/1.1 101 ").append(((ServerHandshake)handshakedata).getHttpStatusMessage());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        stringBuilder.append("\r\n");
        Iterator<String> iterator = handshakedata.iterateHttpFields();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            object = handshakedata.getFieldValue((String)object2);
            stringBuilder.append((String)object2);
            stringBuilder.append(": ");
            stringBuilder.append((String)object);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        object2 = Charsetfunctions.asciiBytes(stringBuilder.toString());
        object = bl2 ? handshakedata.getContent() : null;
        ByteBuffer byteBuffer = ByteBuffer.allocate((object == null ? 0 : ((Object)object).length) + ((Object)object2).length);
        byteBuffer.put((byte[])object2);
        if (object != null) {
            byteBuffer.put((byte[])object);
        }
        byteBuffer.flip();
        return Collections.singletonList(byteBuffer);
    }

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder var1);

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake var1, ServerHandshakeBuilder var2);

    public abstract List<Framedata> translateFrame(ByteBuffer var1);

    public abstract CloseHandshakeType getCloseHandshakeType();

    public abstract Draft copyInstance();

    public Handshakedata translateHandshake(ByteBuffer byteBuffer) {
        return Draft.translateHandshakeHttp(byteBuffer, this.role);
    }

    public int checkAlloc(int n2) {
        if (n2 < 0) {
            throw new InvalidDataException(1002, "Negative count");
        }
        return n2;
    }

    int readVersion(Handshakedata handshakedata) {
        String string = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (string.length() > 0) {
            try {
                int n2 = new Integer(string.trim());
                return n2;
            }
            catch (NumberFormatException numberFormatException) {
                return -1;
            }
        }
        return -1;
    }

    public void setParseMode(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return this.role;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

