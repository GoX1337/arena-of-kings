/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class bka
extends blg<AtomicInteger> {
    public bka() {
        super(AtomicInteger.class);
    }

    @Override
    public AtomicInteger a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_e()) {
            return new AtomicInteger(bdc2.int_e());
        }
        Class<AtomicInteger> clazz = this.a(bdc2, bfs2, AtomicInteger.class);
        return clazz == null ? null : new AtomicInteger((Integer)((Object)clazz));
    }

    @Override
    public btq a() {
        return btq.f;
    }

    @Override
    public Object b(bfs bfs2) {
        return new AtomicInteger();
    }
}

