/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicBoolean;

public class bjz
extends blg<AtomicBoolean> {
    public bjz() {
        super(AtomicBoolean.class);
    }

    @Override
    public AtomicBoolean a(bdc bdc2, bfs bfs2) {
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.k) {
            return new AtomicBoolean(true);
        }
        if (bdf2 == bdf.l) {
            return new AtomicBoolean(false);
        }
        Class<AtomicBoolean> clazz = this.a(bdc2, bfs2, AtomicBoolean.class);
        return clazz == null ? null : new AtomicBoolean((Boolean)((Object)clazz));
    }

    @Override
    public btq a() {
        return btq.h;
    }

    @Override
    public Object b(bfs bfs2) {
        return new AtomicBoolean(false);
    }
}

