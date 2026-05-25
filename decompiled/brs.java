/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicReference;

public class brs
extends bsu<AtomicReference<?>> {
    public brs(btu btu2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        super(btu2, bl2, bog2, bgb2);
    }

    protected brs(brs brs2, bfp bfp2, bog bog2, bgb<?> bgb2, but but2, Object object, boolean bl2) {
        super(brs2, bfp2, bog2, bgb2, but2, object, bl2);
    }

    @Override
    protected bsu<AtomicReference<?>> a(bfp bfp2, bog bog2, bgb<?> bgb2, but but2) {
        return new brs(this, bfp2, bog2, bgb2, but2, this.b, this.a);
    }

    @Override
    public bsu<AtomicReference<?>> a(Object object, boolean bl2) {
        return new brs(this, this.a, this.a, this.a, this.a, object, bl2);
    }

    @Override
    protected boolean boolean_a(AtomicReference<?> atomicReference) {
        return atomicReference.get() != null;
    }

    @Override
    protected Object java_lang_Object_a(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override
    protected Object b(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override
    protected /* synthetic */ Object a(Object object) {
        return this.b((AtomicReference)object);
    }

    @Override
    protected /* synthetic */ Object b(Object object) {
        return this.java_lang_Object_a((AtomicReference)object);
    }
}

