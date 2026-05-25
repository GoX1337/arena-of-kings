/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class bqs
extends bqb
implements Serializable {
    protected bqs() {
    }

    protected bqs(bmx bmx2, bud bud2, bfw bfw2, bgb<?> bgb2, bog bog2, bfw bfw3, bbr.b b2, Class<?>[] classArray) {
        super(bmx2, bmx2.bmn_d(), bud2, bfw2, bgb2, bog2, bfw3, bqs.boolean_a(b2), bqs.java_lang_Object_a(b2), classArray);
    }

    protected static boolean boolean_a(bbr.b b2) {
        if (b2 == null) {
            return false;
        }
        bbr.a a2 = b2.bbr$a_a();
        return a2 != bbr.a.var_bbr$a_a && a2 != bbr.a.g;
    }

    protected static Object java_lang_Object_a(bbr.b b2) {
        if (b2 == null) {
            return false;
        }
        bbr.a a2 = b2.bbr$a_a();
        if (a2 == bbr.a.var_bbr$a_a || a2 == bbr.a.b || a2 == bbr.a.g) {
            return null;
        }
        return a;
    }

    protected abstract Object java_lang_Object_a(Object var1, bcy var2, bgo var3);

    public abstract bqs a(bhm<?> var1, bmh var2, bmx var3, bfw var4);

    @Override
    public void void_a(Object object, bcy bcy2, bgo bgo2) {
        Class<?> clazz;
        bre bre2;
        Object object2 = this.java_lang_Object_a(object, bcy2, bgo2);
        if (object2 == null) {
            if (this.b != null) {
                bcy2.void_a(this.a);
                this.b.a(null, bcy2, bgo2);
            }
            return;
        }
        bgb<Object> bgb2 = this.a;
        if (bgb2 == null && (bgb2 = (bre2 = this.a).a(clazz = object2.getClass())) == null) {
            bgb2 = this.a(bre2, clazz, bgo2);
        }
        if (this.b != null && (a == this.b ? bgb2.a(bgo2, object2) : this.b.equals(object2))) {
            return;
        }
        if (object2 == object && this.a(object, bcy2, bgo2, bgb2)) {
            return;
        }
        bcy2.void_a(this.a);
        if (this.a == null) {
            bgb2.a(object2, bcy2, bgo2);
        } else {
            bgb2.a(object2, bcy2, bgo2, this.a);
        }
    }

    @Override
    public void c(Object object, bcy bcy2, bgo bgo2) {
        Class<?> clazz;
        bre bre2;
        Object object2 = this.java_lang_Object_a(object, bcy2, bgo2);
        if (object2 == null) {
            if (this.b != null) {
                this.b.a(null, bcy2, bgo2);
            } else {
                bcy2.e();
            }
            return;
        }
        bgb<Object> bgb2 = this.a;
        if (bgb2 == null && (bgb2 = (bre2 = this.a).a(clazz = object2.getClass())) == null) {
            bgb2 = this.a(bre2, clazz, bgo2);
        }
        if (this.b != null) {
            if (a == this.b) {
                if (bgb2.a(bgo2, object2)) {
                    this.d(object, bcy2, bgo2);
                    return;
                }
            } else if (this.b.equals(object2)) {
                this.d(object, bcy2, bgo2);
                return;
            }
        }
        if (object2 == object && this.a(object, bcy2, bgo2, bgb2)) {
            return;
        }
        if (this.a == null) {
            bgb2.a(object2, bcy2, bgo2);
        } else {
            bgb2.a(object2, bcy2, bgo2, this.a);
        }
    }
}

