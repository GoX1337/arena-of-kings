/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class boi
extends boz
implements Serializable {
    public boi(bfw bfw2, boe boe2, String string, boolean bl2, bfw bfw3) {
        super(bfw2, boe2, string, bl2, bfw3);
    }

    public boi(boi boi2, bfp bfp2) {
        super(boi2, bfp2);
    }

    @Override
    public boc a(bfp bfp2) {
        return bfp2 == this.a ? this : new boi(this, bfp2);
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.c;
    }

    @Override
    public Object b(bdc bdc2, bfs bfs2) {
        return this.e(bdc2, bfs2);
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
        return this.e(bdc2, bfs2);
    }

    @Override
    public Object c(bdc bdc2, bfs bfs2) {
        return this.e(bdc2, bfs2);
    }

    @Override
    public Object d(bdc bdc2, bfs bfs2) {
        return this.e(bdc2, bfs2);
    }

    protected Object e(bdc bdc2, bfs bfs2) {
        Object object;
        Object object2;
        if (bdc2.boolean_i() && (object2 = bdc2.java_lang_Object_c()) != null) {
            return this.a(bdc2, bfs2, object2);
        }
        boolean bl2 = bdc2.boolean_c();
        Object object3 = this.java_lang_Object_a(bdc2, bfs2);
        bfx<Object> bfx2 = this.a(bfs2, (String)object3);
        if (this.a && !this.boolean_b() && bdc2.boolean_a(bdf.var_bdf_b)) {
            object = new bve(null, false);
            ((bve)object).void_c();
            ((bve)object).a(this.b);
            ((bve)object).b((String)object3);
            bdc2.void_a();
            bdc2 = bff.a(false, ((bve)object).bdc_a(bdc2), bdc2);
            bdc2.bdf_a();
        }
        if (bl2 && bdc2.bdf_c() == bdf.var_bdf_e) {
            return bfx2.a(bfs2);
        }
        object = bfx2.a(bdc2, bfs2);
        if (bl2 && bdc2.bdf_a() != bdf.var_bdf_e) {
            bfs2.a(this.bfw_a(), bdf.var_bdf_e, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
        }
        return object;
    }

    @Override
    protected String java_lang_String_a(bdc bdc2, bfs bfs2) {
        if (!bdc2.boolean_c()) {
            if (this.b != null) {
                return this.a.a();
            }
            bfs2.a(this.bfw_a(), bdf.var_bdf_d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + this.java_lang_String_b(), new Object[0]);
            return null;
        }
        bdf bdf2 = bdc2.bdf_a();
        if (bdf2 == bdf.h) {
            String string = bdc2.java_lang_String_e();
            bdc2.bdf_a();
            return string;
        }
        bfs2.a(this.bfw_a(), bdf.h, "need JSON String that contains type id (for subtype of %s)", this.java_lang_String_b());
        return null;
    }

    protected boolean boolean_b() {
        return false;
    }
}

