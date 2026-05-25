/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;

public final class bjc
extends bio.a {
    protected final transient Constructor<?> a;

    public bjc(bio bio2, Constructor<?> constructor) {
        super(bio2);
        this.a = constructor;
    }

    @Override
    protected bio a(bio bio2) {
        if (bio2 == this.a) {
            return this;
        }
        return new bjc(bio2, this.a);
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.m) {
            object2 = this.b.a(bfs2);
        } else if (this.a != null) {
            object2 = this.b.a(bdc2, bfs2, (boc)((Object)this.a));
        } else {
            try {
                object2 = this.a.newInstance(object);
            }
            catch (Exception exception) {
                buk.b(exception, String.format("Failed to instantiate class %s, problem: %s", this.a.getDeclaringClass().getName(), exception.getMessage()));
                object2 = null;
            }
            this.b.a(bdc2, bfs2, object2);
        }
        this.void_a(object, object2);
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        return this.java_lang_Object_a(object, this.java_lang_Object_a(bdc2, bfs2));
    }
}

