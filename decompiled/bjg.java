/*
 * Decompiled with CFR 0.152.
 */
public class bjg
extends bio.a {
    protected final bmn a;

    protected bjg(bio bio2, bmn bmn2) {
        super(bio2);
        this.a = bmn2;
    }

    public static bjg a(bio bio2, bmn bmn2) {
        return new bjg(bio2, bmn2);
    }

    @Override
    protected bio a(bio bio2) {
        return new bjg(bio2, this.a);
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2 = this.a.b(object);
        Object object3 = object2 == null ? ((bio)((Object)this.a)).java_lang_Object_a(bdc2, bfs2) : ((bio)((Object)this.a)).b(bdc2, bfs2, object2);
        if (object3 != object2) {
            ((bio)((Object)this.a)).void_a(object, object3);
        }
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2 = this.a.b(object);
        Object object3 = object2 == null ? ((bio)((Object)this.a)).java_lang_Object_a(bdc2, bfs2) : ((bio)((Object)this.a)).b(bdc2, bfs2, object2);
        if (object3 != object2 && object3 != null) {
            return ((bio)((Object)this.a)).java_lang_Object_a(object, object3);
        }
        return object;
    }

    @Override
    public void void_a(Object object, Object object2) {
        if (object2 != null) {
            ((bio)((Object)this.a)).void_a(object, object2);
        }
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        if (object2 != null) {
            return ((bio)((Object)this.a)).java_lang_Object_a(object, object2);
        }
        return object;
    }
}

