/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;

public class bke
extends blg<ByteBuffer> {
    protected bke() {
        super(ByteBuffer.class);
    }

    @Override
    public btq a() {
        return btq.k;
    }

    @Override
    public ByteBuffer a(bdc bdc2, bfs bfs2) {
        byte[] byArray = bdc2.byte_arr_a();
        return ByteBuffer.wrap(byArray);
    }

    @Override
    public ByteBuffer a(bdc bdc2, bfs bfs2, ByteBuffer byteBuffer) {
        buj buj2 = new buj(byteBuffer);
        bdc2.a(bfs2.bcq_a(), buj2);
        buj2.close();
        return byteBuffer;
    }
}

