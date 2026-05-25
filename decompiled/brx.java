/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;

public class brx
extends btd<ByteBuffer> {
    public brx() {
        super(ByteBuffer.class);
    }

    @Override
    public void a(ByteBuffer byteBuffer, bcy bcy2, bgo bgo2) {
        if (byteBuffer.hasArray()) {
            int n2 = byteBuffer.position();
            bcy2.a(byteBuffer.array(), byteBuffer.arrayOffset() + n2, byteBuffer.limit() - n2);
            return;
        }
        ByteBuffer byteBuffer2 = byteBuffer.asReadOnlyBuffer();
        if (byteBuffer2.position() > 0) {
            byteBuffer2.rewind();
        }
        bui bui2 = new bui(byteBuffer2);
        bcy2.a(bui2, byteBuffer2.remaining());
        bui2.close();
    }
}

