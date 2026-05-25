/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class boq
extends boz
implements Serializable {
    public boq(bfw bfw2, boe boe2, String string, boolean bl2, bfw bfw3) {
        super(bfw2, boe2, string, bl2, bfw3);
    }

    protected boq(boq boq2, bfp bfp2) {
        super(boq2, bfp2);
    }

    @Override
    public boc a(bfp bfp2) {
        return bfp2 == this.a ? this : new boq(this, bfp2);
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.b;
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
        return this.e(bdc2, bfs2);
    }

    @Override
    public Object b(bdc bdc2, bfs bfs2) {
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
        object2 = bdc2.bdf_c();
        if (object2 == bdf.var_bdf_b) {
            if (bdc2.bdf_a() != bdf.f) {
                bfs2.a(this.bfw_a(), bdf.f, "need JSON String that contains type id (for subtype of " + this.java_lang_String_b() + ")", new Object[0]);
            }
        } else if (object2 != bdf.f) {
            bfs2.a(this.bfw_a(), bdf.var_bdf_b, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + this.java_lang_String_b(), new Object[0]);
        }
        String string = bdc2.java_lang_String_e();
        bfx<Object> bfx2 = this.a(bfs2, string);
        bdc2.bdf_a();
        if (this.a && bdc2.boolean_a(bdf.var_bdf_b)) {
            object = new bve(null, false);
            ((bve)object).void_c();
            ((bve)object).a(this.b);
            ((bve)object).b(string);
            bdc2.void_a();
            bdc2 = bff.a(false, ((bve)object).bdc_a(bdc2), bdc2);
            bdc2.bdf_a();
        }
        object = bfx2.a(bdc2, bfs2);
        if (bdc2.bdf_a() != bdf.var_bdf_c) {
            bfs2.a(this.bfw_a(), bdf.var_bdf_c, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        }
        return object;
    }
}

