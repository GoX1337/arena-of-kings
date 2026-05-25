/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.extensions.permessage_deflate;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.extensions.CompressionExtension;
import org.java_websocket.extensions.ExtensionRequestData;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;

public class PerMessageDeflateExtension
extends CompressionExtension {
    private static final String EXTENSION_REGISTERED_NAME = "permessage-deflate";
    private static final String SERVER_NO_CONTEXT_TAKEOVER = "server_no_context_takeover";
    private static final String CLIENT_NO_CONTEXT_TAKEOVER = "client_no_context_takeover";
    private static final String SERVER_MAX_WINDOW_BITS = "server_max_window_bits";
    private static final String CLIENT_MAX_WINDOW_BITS = "client_max_window_bits";
    private static final int serverMaxWindowBits = 32768;
    private static final int clientMaxWindowBits = 32768;
    private static final byte[] TAIL_BYTES = new byte[]{0, 0, -1, -1};
    private static final int BUFFER_SIZE = 1024;
    private int threshold = 1024;
    private boolean serverNoContextTakeover = true;
    private boolean clientNoContextTakeover = false;
    private Map<String, String> requestedParameters = new LinkedHashMap<String, String>();
    private Inflater inflater = new Inflater(true);
    private Deflater deflater = new Deflater(-1, true);

    public Inflater getInflater() {
        return this.inflater;
    }

    public void setInflater(Inflater inflater) {
        this.inflater = inflater;
    }

    public Deflater getDeflater() {
        return this.deflater;
    }

    public void setDeflater(Deflater deflater) {
        this.deflater = deflater;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public void setThreshold(int n2) {
        this.threshold = n2;
    }

    public boolean isServerNoContextTakeover() {
        return this.serverNoContextTakeover;
    }

    public void setServerNoContextTakeover(boolean bl2) {
        this.serverNoContextTakeover = bl2;
    }

    public boolean isClientNoContextTakeover() {
        return this.clientNoContextTakeover;
    }

    public void setClientNoContextTakeover(boolean bl2) {
        this.clientNoContextTakeover = bl2;
    }

    @Override
    public void decodeFrame(Framedata framedata) {
        if (!(framedata instanceof DataFrame)) {
            return;
        }
        if (framedata.getOpcode() == Opcode.CONTINUOUS && framedata.isRSV1()) {
            throw new InvalidDataException(1008, "RSV1 bit can only be set for the first frame.");
        }
        if (!framedata.isRSV1()) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.decompress(framedata.getPayloadData().array(), byteArrayOutputStream);
            if (this.inflater.getRemaining() > 0) {
                this.inflater = new Inflater(true);
                this.decompress(framedata.getPayloadData().array(), byteArrayOutputStream);
            }
            if (framedata.isFin()) {
                this.decompress(TAIL_BYTES, byteArrayOutputStream);
                if (this.clientNoContextTakeover) {
                    this.inflater = new Inflater(true);
                }
            }
        }
        catch (DataFormatException dataFormatException) {
            throw new InvalidDataException(1008, dataFormatException.getMessage());
        }
        if (framedata.isRSV1()) {
            ((DataFrame)framedata).setRSV1(false);
        }
        ((FramedataImpl1)framedata).setPayload(ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()));
    }

    private void decompress(byte[] byArray, ByteArrayOutputStream byteArrayOutputStream) {
        int n2;
        this.inflater.setInput(byArray);
        byte[] byArray2 = new byte[1024];
        while ((n2 = this.inflater.inflate(byArray2)) > 0) {
            byteArrayOutputStream.write(byArray2, 0, n2);
        }
    }

    @Override
    public void encodeFrame(Framedata framedata) {
        int n2;
        if (!(framedata instanceof DataFrame)) {
            return;
        }
        byte[] byArray = framedata.getPayloadData().array();
        if (byArray.length < this.threshold) {
            return;
        }
        if (!(framedata instanceof ContinuousFrame)) {
            ((DataFrame)framedata).setRSV1(true);
        }
        this.deflater.setInput(byArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray2 = new byte[1024];
        while ((n2 = this.deflater.deflate(byArray2, 0, byArray2.length, 2)) > 0) {
            byteArrayOutputStream.write(byArray2, 0, n2);
        }
        byte[] byArray3 = byteArrayOutputStream.toByteArray();
        int n3 = byArray3.length;
        if (framedata.isFin()) {
            if (PerMessageDeflateExtension.endsWithTail(byArray3)) {
                n3 -= TAIL_BYTES.length;
            }
            if (this.serverNoContextTakeover) {
                this.deflater.end();
                this.deflater = new Deflater(-1, true);
            }
        }
        ((FramedataImpl1)framedata).setPayload(ByteBuffer.wrap(byArray3, 0, n3));
    }

    private static boolean endsWithTail(byte[] byArray) {
        if (byArray.length < 4) {
            return false;
        }
        int n2 = byArray.length;
        for (int i2 = 0; i2 < TAIL_BYTES.length; ++i2) {
            if (TAIL_BYTES[i2] == byArray[n2 - TAIL_BYTES.length + i2]) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean acceptProvidedExtensionAsServer(String string) {
        String[] stringArray;
        for (String string2 : stringArray = string.split(",")) {
            ExtensionRequestData extensionRequestData = ExtensionRequestData.parseExtensionRequest(string2);
            if (!EXTENSION_REGISTERED_NAME.equalsIgnoreCase(extensionRequestData.getExtensionName())) continue;
            Map<String, String> map = extensionRequestData.getExtensionParameters();
            this.requestedParameters.putAll(map);
            if (this.requestedParameters.containsKey(CLIENT_NO_CONTEXT_TAKEOVER)) {
                this.clientNoContextTakeover = true;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean acceptProvidedExtensionAsClient(String string) {
        String[] stringArray;
        for (String string2 : stringArray = string.split(",")) {
            ExtensionRequestData extensionRequestData = ExtensionRequestData.parseExtensionRequest(string2);
            if (!EXTENSION_REGISTERED_NAME.equalsIgnoreCase(extensionRequestData.getExtensionName())) continue;
            Map<String, String> map = extensionRequestData.getExtensionParameters();
            return true;
        }
        return false;
    }

    @Override
    public String getProvidedExtensionAsClient() {
        this.requestedParameters.put(CLIENT_NO_CONTEXT_TAKEOVER, "");
        this.requestedParameters.put(SERVER_NO_CONTEXT_TAKEOVER, "");
        return "permessage-deflate; server_no_context_takeover; client_no_context_takeover";
    }

    @Override
    public String getProvidedExtensionAsServer() {
        return "permessage-deflate; server_no_context_takeover" + (this.clientNoContextTakeover ? "; client_no_context_takeover" : "");
    }

    @Override
    public IExtension copyInstance() {
        return new PerMessageDeflateExtension();
    }

    @Override
    public void isFrameValid(Framedata framedata) {
        if (framedata instanceof ContinuousFrame && (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3())) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        }
        super.isFrameValid(framedata);
    }

    @Override
    public String toString() {
        return "PerMessageDeflateExtension";
    }
}

