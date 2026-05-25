/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

@bgp
public class bqb
extends bqn
implements Serializable {
    public static final Object var_java_lang_Object_a;
    protected final bee var_bee_a;
    protected final bgj var_bgj_a;
    protected final bfw var_bfw_a;
    protected final bfw var_bfw_b;
    protected bfw c;
    protected final transient bud var_bud_a;
    protected final bmn var_bmn_a;
    protected transient Method var_java_lang_reflect_Method_a;
    protected transient Field var_java_lang_reflect_Field_a;
    protected bgb<Object> var_bgb_java_lang_Object__a;
    protected bgb<Object> var_bgb_java_lang_Object__b;
    protected bog var_bog_a;
    protected transient bre var_bre_a;
    protected final boolean var_boolean_a;
    protected final Object var_java_lang_Object_b;
    protected final Class<?>[] var_java_lang_Class____arr_a;
    protected transient HashMap<Object, Object> cfr_renamed_39;

    public bqb(bmx bmx2, bmn bmn2, bud bud2, bfw bfw2, bgb<?> bgb2, bog bog2, bfw bfw3, boolean bl2, Object object, Class<?>[] classArray) {
        super(bmx2);
        this.var_bmn_a = bmn2;
        this.var_bud_a = bud2;
        this.var_bee_a = new bee(bmx2.java_lang_String_a());
        this.var_bgj_a = bmx2.bgj_b();
        this.var_bfw_a = bfw2;
        this.var_java_lang_Object_a = bgb2;
        this.var_bre_a = bgb2 == null ? bre.a() : null;
        this.var_bog_a = bog2;
        this.var_bfw_b = bfw3;
        if (bmn2 instanceof bml) {
            this.var_java_lang_reflect_Method_a = null;
            this.var_java_lang_reflect_Field_a = (Field)bmn2.java_lang_reflect_Member_a();
        } else if (bmn2 instanceof bmo) {
            this.var_java_lang_reflect_Method_a = (Method)bmn2.java_lang_reflect_Member_a();
            this.var_java_lang_reflect_Field_a = null;
        } else {
            this.var_java_lang_reflect_Method_a = null;
            this.var_java_lang_reflect_Field_a = null;
        }
        this.var_boolean_a = bl2;
        this.var_java_lang_Object_b = object;
        this.var_bfw_b = null;
        this.var_java_lang_Object_a = classArray;
    }

    protected bqb() {
        super(bgi.c);
        this.var_bmn_a = null;
        this.var_bud_a = null;
        this.var_bee_a = null;
        this.var_bgj_a = null;
        this.var_java_lang_Object_a = null;
        this.var_bfw_a = null;
        this.var_java_lang_Object_a = null;
        this.var_bre_a = null;
        this.var_bog_a = null;
        this.var_bfw_b = null;
        this.var_java_lang_reflect_Method_a = null;
        this.var_java_lang_reflect_Field_a = null;
        this.var_boolean_a = false;
        this.var_java_lang_Object_b = null;
        this.var_bfw_b = null;
    }

    protected bqb(bqb bqb2) {
        this(bqb2, bqb2.var_bee_a);
    }

    protected bqb(bqb bqb2, bgj bgj2) {
        super(bqb2);
        this.var_bee_a = new bee(bgj2.java_lang_String_a());
        this.var_bgj_a = bqb2.var_bgj_a;
        this.var_bud_a = bqb2.var_bud_a;
        this.var_bfw_a = bqb2.var_bfw_a;
        this.var_bmn_a = bqb2.var_bmn_a;
        this.var_java_lang_reflect_Method_a = bqb2.var_java_lang_reflect_Method_a;
        this.var_java_lang_reflect_Field_a = bqb2.var_java_lang_reflect_Field_a;
        this.var_java_lang_Object_a = bqb2.var_java_lang_Object_a;
        this.var_bfw_b = bqb2.var_bfw_b;
        if (bqb2.var_java_lang_Object_a != null) {
            this.var_java_lang_Object_a = new HashMap(bqb2.var_java_lang_Object_a);
        }
        this.var_bfw_b = bqb2.var_bfw_b;
        this.var_bre_a = bqb2.var_bre_a;
        this.var_boolean_a = bqb2.var_boolean_a;
        this.var_java_lang_Object_b = bqb2.var_java_lang_Object_b;
        this.var_java_lang_Object_a = bqb2.var_java_lang_Object_a;
        this.var_bog_a = bqb2.var_bog_a;
        this.c = bqb2.c;
    }

    protected bqb(bqb bqb2, bee bee2) {
        super(bqb2);
        this.var_bee_a = bee2;
        this.var_bgj_a = bqb2.var_bgj_a;
        this.var_bmn_a = bqb2.var_bmn_a;
        this.var_bud_a = bqb2.var_bud_a;
        this.var_bfw_a = bqb2.var_bfw_a;
        this.var_java_lang_reflect_Method_a = bqb2.var_java_lang_reflect_Method_a;
        this.var_java_lang_reflect_Field_a = bqb2.var_java_lang_reflect_Field_a;
        this.var_java_lang_Object_a = bqb2.var_java_lang_Object_a;
        this.var_bfw_b = bqb2.var_bfw_b;
        if (bqb2.var_java_lang_Object_a != null) {
            this.var_java_lang_Object_a = new HashMap(bqb2.var_java_lang_Object_a);
        }
        this.var_bfw_b = bqb2.var_bfw_b;
        this.var_bre_a = bqb2.var_bre_a;
        this.var_boolean_a = bqb2.var_boolean_a;
        this.var_java_lang_Object_b = bqb2.var_java_lang_Object_b;
        this.var_java_lang_Object_a = bqb2.var_java_lang_Object_a;
        this.var_bog_a = bqb2.var_bog_a;
        this.c = bqb2.c;
    }

    public bqb a(but but2) {
        String string = but2.a(this.var_bee_a.java_lang_String_a());
        if (string.equals(this.var_bee_a.toString())) {
            return this;
        }
        return this.bqb_a(bgj.bgj_a(string));
    }

    protected bqb bqb_a(bgj bgj2) {
        return new bqb(this, bgj2);
    }

    public void a(bog bog2) {
        this.var_bog_a = bog2;
    }

    public void a(bgb<Object> bgb2) {
        if (this.var_java_lang_Object_a != null && this.var_java_lang_Object_a != bgb2) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", buk.c(this.var_java_lang_Object_a), buk.c(bgb2)));
        }
        this.var_java_lang_Object_a = bgb2;
    }

    public void b(bgb<Object> bgb2) {
        if (this.var_bfw_b != null && this.var_bfw_b != bgb2) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", buk.c(this.var_bfw_b), buk.c(bgb2)));
        }
        this.var_bfw_b = bgb2;
    }

    public bqb b(but but2) {
        return new brn(this, but2);
    }

    public void a(bfw bfw2) {
        this.c = bfw2;
    }

    public void a(bgm bgm2) {
        this.var_bmn_a.a(bgm2.a(bgd.o));
    }

    @Override
    public String java_lang_String_a() {
        return this.var_bee_a.java_lang_String_a();
    }

    @Override
    public bgj bgj_a() {
        return new bgj(this.var_bee_a.java_lang_String_a());
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    @Override
    public bmn bmn_a() {
        return this.var_bmn_a;
    }

    public boolean boolean_a() {
        return this.var_java_lang_Object_a != null;
    }

    public boolean boolean_b() {
        return this.var_bfw_b != null;
    }

    public bog bog_a() {
        return this.var_bog_a;
    }

    public boolean c() {
        return this.var_boolean_a;
    }

    public boolean boolean_a(bgj bgj2) {
        if (this.var_bgj_a != null) {
            return this.var_bgj_a.equals(bgj2);
        }
        return bgj2.boolean_a(this.var_bee_a.java_lang_String_a()) && !bgj2.b();
    }

    public bfw bfw_b() {
        return this.var_bfw_b;
    }

    public Class<?>[] java_lang_Class____arr_a() {
        return this.var_java_lang_Object_a;
    }

    @Override
    public void void_a(Object object, bcy bcy2, bgo bgo2) {
        Class<?> clazz;
        bre bre2;
        Object object2;
        Object object3 = object2 = this.var_java_lang_reflect_Method_a == null ? this.var_java_lang_reflect_Field_a.get(object) : this.var_java_lang_reflect_Method_a.invoke(object, (Object[])null);
        if (object2 == null) {
            if (this.var_bfw_b != null) {
                bcy2.void_a(this.var_bee_a);
                ((bgb)((Object)this.var_bfw_b)).a(null, bcy2, bgo2);
            }
            return;
        }
        bgb<Object> bgb2 = this.var_java_lang_Object_a;
        if (bgb2 == null && (bgb2 = (bre2 = this.var_bre_a).a(clazz = object2.getClass())) == null) {
            bgb2 = this.a(bre2, clazz, bgo2);
        }
        if (this.var_java_lang_Object_b != null && (var_java_lang_Object_a == this.var_java_lang_Object_b ? bgb2.a(bgo2, object2) : this.var_java_lang_Object_b.equals(object2))) {
            return;
        }
        if (object2 == object && this.a(object, bcy2, bgo2, bgb2)) {
            return;
        }
        bcy2.void_a(this.var_bee_a);
        if (this.var_bog_a == null) {
            bgb2.a(object2, bcy2, bgo2);
        } else {
            bgb2.a(object2, bcy2, bgo2, this.var_bog_a);
        }
    }

    @Override
    public void b(Object object, bcy bcy2, bgo bgo2) {
        if (!bcy2.boolean_d()) {
            bcy2.f(this.var_bee_a.java_lang_String_a());
        }
    }

    public void c(Object object, bcy bcy2, bgo bgo2) {
        Class<?> clazz;
        bre bre2;
        Object object2;
        Object object3 = object2 = this.var_java_lang_reflect_Method_a == null ? this.var_java_lang_reflect_Field_a.get(object) : this.var_java_lang_reflect_Method_a.invoke(object, (Object[])null);
        if (object2 == null) {
            if (this.var_bfw_b != null) {
                ((bgb)((Object)this.var_bfw_b)).a(null, bcy2, bgo2);
            } else {
                bcy2.e();
            }
            return;
        }
        bgb<Object> bgb2 = this.var_java_lang_Object_a;
        if (bgb2 == null && (bgb2 = (bre2 = this.var_bre_a).a(clazz = object2.getClass())) == null) {
            bgb2 = this.a(bre2, clazz, bgo2);
        }
        if (this.var_java_lang_Object_b != null) {
            if (var_java_lang_Object_a == this.var_java_lang_Object_b) {
                if (bgb2.a(bgo2, object2)) {
                    this.d(object, bcy2, bgo2);
                    return;
                }
            } else if (this.var_java_lang_Object_b.equals(object2)) {
                this.d(object, bcy2, bgo2);
                return;
            }
        }
        if (object2 == object && this.a(object, bcy2, bgo2, bgb2)) {
            return;
        }
        if (this.var_bog_a == null) {
            bgb2.a(object2, bcy2, bgo2);
        } else {
            bgb2.a(object2, bcy2, bgo2, this.var_bog_a);
        }
    }

    public void d(Object object, bcy bcy2, bgo bgo2) {
        if (this.var_bfw_b != null) {
            ((bgb)((Object)this.var_bfw_b)).a(null, bcy2, bgo2);
        } else {
            bcy2.e();
        }
    }

    protected bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
        bre.d d2;
        if (this.c != null) {
            bfw bfw2 = bgo2.a(this.c, clazz);
            d2 = bre2.a(bfw2, bgo2, (bfp)this);
        } else {
            d2 = bre2.a(clazz, bgo2, (bfp)this);
        }
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    public final Object a(Object object) {
        return this.var_java_lang_reflect_Method_a == null ? this.var_java_lang_reflect_Field_a.get(object) : this.var_java_lang_reflect_Method_a.invoke(object, (Object[])null);
    }

    protected boolean a(Object object, bcy bcy2, bgo bgo2, bgb<?> bgb2) {
        if (!bgb2.a()) {
            if (bgo2.a(bgn.d)) {
                if (bgb2 instanceof brt) {
                    bgo2.b(this.bfw_a(), "Direct self-reference leading to cycle");
                }
            } else if (bgo2.a(bgn.g)) {
                if (this.var_bfw_b != null) {
                    if (!bcy2.bde_a().boolean_a()) {
                        bcy2.void_a(this.var_bee_a);
                    }
                    ((bgb)((Object)this.var_bfw_b)).a(null, bcy2, bgo2);
                }
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("property '").append(this.java_lang_String_a()).append("' (");
        if (this.var_java_lang_reflect_Method_a != null) {
            stringBuilder.append("via method ").append(this.var_java_lang_reflect_Method_a.getDeclaringClass().getName()).append("#").append(this.var_java_lang_reflect_Method_a.getName());
        } else if (this.var_java_lang_reflect_Field_a != null) {
            stringBuilder.append("field \"").append(this.var_java_lang_reflect_Field_a.getDeclaringClass().getName()).append("#").append(this.var_java_lang_reflect_Field_a.getName());
        } else {
            stringBuilder.append("virtual");
        }
        if (this.var_java_lang_Object_a == null) {
            stringBuilder.append(", no static serializer");
        } else {
            stringBuilder.append(", static serializer of type " + this.var_java_lang_Object_a.getClass().getName());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    static {
        var_java_lang_Object_a = bbr.a.d;
    }
}

