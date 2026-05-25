/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.framing.PongFrame;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.util.ByteBufferUtils;

public abstract class FramedataImpl1
implements Framedata {
    private boolean fin;
    private Opcode optcode;
    private ByteBuffer unmaskedpayload;
    private boolean transferemasked;
    private boolean rsv1;
    private boolean rsv2;
    private boolean rsv3;

    public abstract void isValid();

    public FramedataImpl1(Opcode opcode) {
        this.optcode = opcode;
        this.unmaskedpayload = ByteBufferUtils.getEmptyByteBuffer();
        this.fin = true;
        this.transferemasked = false;
        this.rsv1 = false;
        this.rsv2 = false;
        this.rsv3 = false;
    }

    @Override
    public boolean isRSV1() {
        return this.rsv1;
    }

    @Override
    public boolean isRSV2() {
        return this.rsv2;
    }

    @Override
    public boolean isRSV3() {
        return this.rsv3;
    }

    @Override
    public boolean isFin() {
        return this.fin;
    }

    @Override
    public Opcode getOpcode() {
        return this.optcode;
    }

    @Override
    public boolean getTransfereMasked() {
        return this.transferemasked;
    }

    @Override
    public ByteBuffer getPayloadData() {
        return this.unmaskedpayload;
    }

    @Override
    public void append(Framedata framedata) {
        ByteBuffer byteBuffer = framedata.getPayloadData();
        if (this.unmaskedpayload == null) {
            this.unmaskedpayload = ByteBuffer.allocate(byteBuffer.remaining());
            byteBuffer.mark();
            this.unmaskedpayload.put(byteBuffer);
            byteBuffer.reset();
        } else {
            byteBuffer.mark();
            this.unmaskedpayload.position(this.unmaskedpayload.limit());
            this.unmaskedpayload.limit(this.unmaskedpayload.capacity());
            if (byteBuffer.remaining() > this.unmaskedpayload.remaining()) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.remaining() + this.unmaskedpayload.capacity());
                this.unmaskedpayload.flip();
                byteBuffer2.put(this.unmaskedpayload);
                byteBuffer2.put(byteBuffer);
                this.unmaskedpayload = byteBuffer2;
            } else {
                this.unmaskedpayload.put(byteBuffer);
            }
            this.unmaskedpayload.rewind();
            byteBuffer.reset();
        }
        this.fin = framedata.isFin();
    }

    public String toString() {
        return "Framedata{ opcode:" + (Object)((Object)this.getOpcode()) + ", fin:" + this.isFin() + ", rsv1:" + this.isRSV1() + ", rsv2:" + this.isRSV2() + ", rsv3:" + this.isRSV3() + ", payload length:[pos:" + this.unmaskedpayload.position() + ", len:" + this.unmaskedpayload.remaining() + "], payload:" + (this.unmaskedpayload.remaining() > 1000 ? "(too big to display)" : new String(this.unmaskedpayload.array())) + '}';
    }

    public void setPayload(ByteBuffer byteBuffer) {
        this.unmaskedpayload = byteBuffer;
    }

    public void setFin(boolean bl2) {
        this.fin = bl2;
    }

    public void setRSV1(boolean bl2) {
        this.rsv1 = bl2;
    }

    public void setRSV2(boolean bl2) {
        this.rsv2 = bl2;
    }

    public void setRSV3(boolean bl2) {
        this.rsv3 = bl2;
    }

    public void setTransferemasked(boolean bl2) {
        this.transferemasked = bl2;
    }

    public static FramedataImpl1 get(Opcode opcode) {
        if (opcode == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (opcode) {
            case PING: {
                return new PingFrame();
            }
            case PONG: {
                return new PongFrame();
            }
            case TEXT: {
                return new TextFrame();
            }
            case BINARY: {
                return new BinaryFrame();
            }
            case CLOSING: {
                return new CloseFrame();
            }
            case CONTINUOUS: {
                return new ContinuousFrame();
            }
        }
        throw new IllegalArgumentException("Supplied opcode is invalid");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        FramedataImpl1 framedataImpl1 = (FramedataImpl1)object;
        if (this.fin != framedataImpl1.fin) {
            return false;
        }
        if (this.transferemasked != framedataImpl1.transferemasked) {
            return false;
        }
        if (this.rsv1 != framedataImpl1.rsv1) {
            return false;
        }
        if (this.rsv2 != framedataImpl1.rsv2) {
            return false;
        }
        if (this.rsv3 != framedataImpl1.rsv3) {
            return false;
        }
        if (this.optcode != framedataImpl1.optcode) {
            return false;
        }
        return this.unmaskedpayload != null ? this.unmaskedpayload.equals(framedataImpl1.unmaskedpayload) : framedataImpl1.unmaskedpayload == null;
    }

    public int hashCode() {
        int n2 = this.fin ? 1 : 0;
        n2 = 31 * n2 + this.optcode.hashCode();
        n2 = 31 * n2 + (this.unmaskedpayload != null ? this.unmaskedpayload.hashCode() : 0);
        n2 = 31 * n2 + (this.transferemasked ? 1 : 0);
        n2 = 31 * n2 + (this.rsv1 ? 1 : 0);
        n2 = 31 * n2 + (this.rsv2 ? 1 : 0);
        n2 = 31 * n2 + (this.rsv3 ? 1 : 0);
        return n2;
    }
}

