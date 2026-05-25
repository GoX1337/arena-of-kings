/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;

public abstract class bmx
implements bux {
    protected static final bbr.b a = bbr.b.bbr$b_a();

    @Override
    public abstract String java_lang_String_a();

    public abstract bgj bgj_a();

    public boolean boolean_a(bgj bgj2) {
        return this.bgj_a().equals(bgj2);
    }

    public abstract bgj bgj_b();

    public abstract boolean boolean_a();

    public boolean boolean_b() {
        return this.boolean_a();
    }

    public abstract bfw bfw_a();

    public abstract Class<?> a();

    public abstract bgi bgi_a();

    public boolean boolean_c() {
        return this.bmn_b() != null;
    }

    public boolean boolean_d() {
        return this.bmn_a() != null;
    }

    public abstract boolean boolean_e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract bmo bmo_a();

    public abstract bmo bmo_b();

    public abstract bml bml_a();

    public abstract bmr bmr_a();

    public Iterator<bmr> a() {
        return buk.a();
    }

    public bmn bmn_a() {
        bmn bmn2 = this.bmo_a();
        if (bmn2 == null) {
            bmn2 = this.bml_a();
        }
        return bmn2;
    }

    public bmn bmn_b() {
        bmn bmn2 = this.bmr_a();
        if (bmn2 == null && (bmn2 = this.bmo_b()) == null) {
            bmn2 = this.bml_a();
        }
        return bmn2;
    }

    public bmn bmn_c() {
        bmn bmn2 = this.bmo_b();
        if (bmn2 == null) {
            bmn2 = this.bml_a();
        }
        return bmn2;
    }

    public abstract bmn bmn_d();

    public Class<?>[] java_lang_Class____arr_a() {
        return null;
    }

    public bfn.a bfn$a_a() {
        return null;
    }

    public String java_lang_String_b() {
        bfn.a a2 = this.bfn$a_a();
        return a2 == null ? null : a2.java_lang_String_a();
    }

    public boolean h() {
        return false;
    }

    public bni bni_a() {
        return null;
    }

    public abstract bbr.b bbr$b_a();
}

