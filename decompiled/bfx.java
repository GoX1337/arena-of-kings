/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;

public abstract class bfx<T>
implements bil {
    public abstract T a(bdc var1, bfs var2);

    public T a(bdc bdc2, bfs bfs2, T t2) {
        bfs2.a(this);
        return this.a(bdc2, bfs2);
    }

    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.d(bdc2, bfs2);
    }

    public Object a(bdc bdc2, bfs bfs2, boc boc2, T t2) {
        bfs2.a(this);
        return this.a(bdc2, bfs2, boc2);
    }

    public bfx<T> a(but but2) {
        return this;
    }

    public Class<?> a() {
        return null;
    }

    public btq btq_a() {
        return null;
    }

    public boolean boolean_a() {
        return false;
    }

    public Collection<Object> a() {
        return null;
    }

    public T a(bfs bfs2) {
        return this.a();
    }

    public buc buc_a() {
        return buc.c;
    }

    public Object b(bfs bfs2) {
        return this.a(bfs2);
    }

    public bjl bjl_a() {
        return null;
    }

    public bio a(String string) {
        throw new IllegalArgumentException("Cannot handle managed/back reference '" + string + "': type: value deserializer of type " + this.getClass().getName() + " does not support them");
    }

    public Boolean a(bfr bfr2) {
        return null;
    }

    @Deprecated
    public T a() {
        return null;
    }

    public static abstract class a
    extends bfx<Object> {
        private a() {
        }
    }
}

