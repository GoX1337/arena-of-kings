/*
 * Decompiled with CFR 0.152.
 */
@bgp
public class blk
extends blg<String> {
    public static final blk a = new blk();

    public blk() {
        super(String.class);
    }

    @Override
    public btq btq_a() {
        return btq.j;
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public Object b(bfs bfs2) {
        return "";
    }

    public String b(bdc bdc2, bfs bfs2) {
        String string;
        if (bdc2.boolean_a(bdf.h)) {
            return bdc2.java_lang_String_e();
        }
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_d) {
            return (String)this.e(bdc2, bfs2);
        }
        if (bdf2 == bdf.g) {
            Object object = bdc2.java_lang_Object_a();
            if (object == null) {
                return null;
            }
            if (object instanceof byte[]) {
                return bfs2.bcq_a().a((byte[])object, false);
            }
            return object.toString();
        }
        if (bdf2 == bdf.var_bdf_b) {
            return bfs2.a(bdc2, this, this.b);
        }
        if (bdf2.d() && (string = bdc2.java_lang_String_f()) != null) {
            return string;
        }
        return (String)bfs2.a(this.b, bdc2);
    }

    @Override
    public String a(bdc bdc2, bfs bfs2, boc boc2) {
        return this.b(bdc2, bfs2);
    }

    @Override
    public /* synthetic */ Object a(bdc bdc2, bfs bfs2) {
        return this.b(bdc2, bfs2);
    }
}

