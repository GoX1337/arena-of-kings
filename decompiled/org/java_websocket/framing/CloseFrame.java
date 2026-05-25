/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.ControlFrame;
import org.java_websocket.util.ByteBufferUtils;
import org.java_websocket.util.Charsetfunctions;

public class CloseFrame
extends ControlFrame {
    public static final int NORMAL = 1000;
    public static final int GOING_AWAY = 1001;
    public static final int PROTOCOL_ERROR = 1002;
    public static final int REFUSE = 1003;
    public static final int NOCODE = 1005;
    public static final int ABNORMAL_CLOSE = 1006;
    public static final int NO_UTF8 = 1007;
    public static final int POLICY_VALIDATION = 1008;
    public static final int TOOBIG = 1009;
    public static final int EXTENSION = 1010;
    public static final int UNEXPECTED_CONDITION = 1011;
    public static final int SERVICE_RESTART = 1012;
    public static final int TRY_AGAIN_LATER = 1013;
    public static final int BAD_GATEWAY = 1014;
    public static final int TLS_ERROR = 1015;
    public static final int NEVER_CONNECTED = -1;
    public static final int BUGGYCLOSE = -2;
    public static final int FLASHPOLICY = -3;
    private int code;
    private String reason;

    public CloseFrame() {
        super(Opcode.CLOSING);
        this.setReason("");
        this.setCode(1000);
    }

    public void setCode(int n2) {
        this.code = n2;
        if (n2 == 1015) {
            this.code = 1005;
            this.reason = "";
        }
        this.updatePayload();
    }

    public void setReason(String string) {
        if (string == null) {
            string = "";
        }
        this.reason = string;
        this.updatePayload();
    }

    public int getCloseCode() {
        return this.code;
    }

    public String getMessage() {
        return this.reason;
    }

    @Override
    public String toString() {
        return super.toString() + "code: " + this.code;
    }

    @Override
    public void isValid() {
        super.isValid();
        if (this.code == 1007 && this.reason.isEmpty()) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
        if (this.code == 1005 && 0 < this.reason.length()) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        if (this.code > 1015 && this.code < 3000) {
            throw new InvalidDataException(1002, "Trying to send an illegal close code!");
        }
        if (this.code == 1006 || this.code == 1015 || this.code == 1005 || this.code > 4999 || this.code < 1000 || this.code == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.code);
        }
    }

    @Override
    public void setPayload(ByteBuffer byteBuffer) {
        this.code = 1005;
        this.reason = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.code = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.code = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(4);
                byteBuffer2.position(2);
                byteBuffer2.putShort(byteBuffer.getShort());
                byteBuffer2.position(0);
                this.code = byteBuffer2.getInt();
            }
            byteBuffer.reset();
            try {
                int n2 = byteBuffer.position();
                this.validateUtf8(byteBuffer, n2);
            }
            catch (InvalidDataException invalidDataException) {
                this.code = 1007;
                this.reason = null;
            }
        }
    }

    private void validateUtf8(ByteBuffer byteBuffer, int n2) {
        try {
            byteBuffer.position(byteBuffer.position() + 2);
            this.reason = Charsetfunctions.stringUtf8(byteBuffer);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidDataException(1007);
        }
        finally {
            byteBuffer.position(n2);
        }
    }

    private void updatePayload() {
        byte[] byArray = Charsetfunctions.utf8Bytes(this.reason);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.putInt(this.code);
        byteBuffer.position(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2 + byArray.length);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.put(byArray);
        byteBuffer2.rewind();
        super.setPayload(byteBuffer2);
    }

    @Override
    public ByteBuffer getPayloadData() {
        if (this.code == 1005) {
            return ByteBufferUtils.getEmptyByteBuffer();
        }
        return super.getPayloadData();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CloseFrame closeFrame = (CloseFrame)object;
        if (this.code != closeFrame.code) {
            return false;
        }
        return this.reason != null ? this.reason.equals(closeFrame.reason) : closeFrame.reason == null;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 31 * n2 + this.code;
        n2 = 31 * n2 + (this.reason != null ? this.reason.hashCode() : 0);
        return n2;
    }
}

