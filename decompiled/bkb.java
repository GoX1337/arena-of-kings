/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicLong;

public class bkb
extends blg<AtomicLong> {
    public bkb() {
        super(AtomicLong.class);
    }

    @Override
    public AtomicLong a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_e()) {
            return new AtomicLong(bdc2.long_a());
        }
        Class<AtomicLong> clazz = this.a(bdc2, bfs2, AtomicLong.class);
        return clazz == null ? null : new AtomicLong(((Long)((Object)clazz)).intValue());
    }

    @Override
    public btq a() {
        return btq.f;
    }

    @Override
    public Object b(bfs bfs2) {
        return new AtomicLong();
    }
}

