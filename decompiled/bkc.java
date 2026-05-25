/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicReference;

public class bkc
extends bkz<AtomicReference<Object>> {
    public bkc(bfw bfw2, bir bir2, boc boc2, bfx<?> bfx2) {
        super(bfw2, bir2, boc2, bfx2);
    }

    public bkc a(boc boc2, bfx<?> bfx2) {
        return new bkc(this.a, this.a, boc2, bfx2);
    }

    @Override
    public AtomicReference<Object> a(bfs bfs2) {
        return new AtomicReference<Object>(this.a.a(bfs2));
    }

    @Override
    public Object b(bfs bfs2) {
        return this.a(bfs2);
    }

    public AtomicReference<Object> a(Object object) {
        return new AtomicReference<Object>(object);
    }

    @Override
    public Object a(AtomicReference<Object> atomicReference) {
        return atomicReference.get();
    }

    @Override
    public AtomicReference<Object> a(AtomicReference<Object> atomicReference, Object object) {
        atomicReference.set(object);
        return atomicReference;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.TRUE;
    }

    @Override
    public /* synthetic */ Object b(Object object) {
        return this.a(object);
    }
}

