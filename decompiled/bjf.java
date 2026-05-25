/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Map;

public final class bjf
extends bio.a {
    protected final String var_java_lang_String_b;
    protected final boolean a;
    protected final bio var_bio_b;

    public bjf(bio bio2, String string, bio bio3, boolean bl2) {
        super(bio2);
        this.var_java_lang_String_b = string;
        this.var_bio_b = bio3;
        this.a = bl2;
    }

    @Override
    protected bio a(bio bio2) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    @Override
    public void a(bfr bfr2) {
        this.a.a(bfr2);
        this.var_bio_b.a(bfr2);
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        this.void_a(object, this.a.java_lang_Object_a(bdc2, bfs2));
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        return this.java_lang_Object_a(object, this.java_lang_Object_a(bdc2, bfs2));
    }

    @Override
    public final void void_a(Object object, Object object2) {
        this.java_lang_Object_a(object, object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        if (object2 == null) return this.a.java_lang_Object_a(object, object2);
        if (this.a) {
            if (object2 instanceof Object[]) {
                for (Object object3 : (Object[])object2) {
                    if (object3 == null) continue;
                    this.var_bio_b.void_a(object3, object);
                }
                return this.a.java_lang_Object_a(object, object2);
            } else if (object2 instanceof Collection) {
                for (Object e2 : (Collection)object2) {
                    if (e2 == null) continue;
                    this.var_bio_b.void_a(e2, object);
                }
                return this.a.java_lang_Object_a(object, object2);
            } else {
                if (!(object2 instanceof Map)) throw new IllegalStateException("Unsupported container type (" + object2.getClass().getName() + ") when resolving reference '" + this.var_java_lang_String_b + "'");
                for (Object v2 : ((Map)object2).values()) {
                    if (v2 == null) continue;
                    this.var_bio_b.void_a(v2, object);
                }
            }
            return this.a.java_lang_Object_a(object, object2);
        } else {
            this.var_bio_b.void_a(object2, object);
        }
        return this.a.java_lang_Object_a(object, object2);
    }
}

