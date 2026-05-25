/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;

public class bhh
implements Serializable {
    protected Map<Class<?>, Object> cfr_renamed_13;
    protected bbr.b var_bbr$b_a;
    protected bcb.a var_bcb$a_a;
    protected bnu<?> var_bnu____a;
    protected Boolean var_java_lang_Boolean_a;
    protected Boolean b;

    public bhh() {
        this(null, bbr.b.bbr$b_a(), bcb.a.bcb$a_a(), bnu.a.a(), null, null);
    }

    protected bhh(Map<Class<?>, Object> map, bbr.b b2, bcb.a a2, bnu<?> bnu2, Boolean bl2, Boolean bl3) {
        this.cfr_renamed_13 = map;
        this.var_bbr$b_a = b2;
        this.var_bcb$a_a = a2;
        this.cfr_renamed_13 = bnu2;
        this.var_java_lang_Boolean_a = bl2;
        this.b = bl3;
    }

    public bhg bhg_a(Class<?> clazz) {
        if (this.cfr_renamed_13 == null) {
            return null;
        }
        return (bhg)this.cfr_renamed_13.get(clazz);
    }

    public bbk.d bbk$d_a(Class<?> clazz) {
        bbk.d d2;
        bhg bhg2;
        if (this.cfr_renamed_13 != null && (bhg2 = (bhg)this.cfr_renamed_13.get(clazz)) != null && (d2 = bhg2.bbk$d_a()) != null) {
            if (!d2.e()) {
                return d2.a(this.b);
            }
            return d2;
        }
        if (this.b == null) {
            return bbk.d.bbk$d_a();
        }
        return bbk.d.a(this.b);
    }

    public bbr.b bbr$b_a() {
        return this.var_bbr$b_a;
    }

    public bcb.a bcb$a_a() {
        return this.var_bcb$a_a;
    }

    public Boolean java_lang_Boolean_a() {
        return this.var_java_lang_Boolean_a;
    }

    public bnu<?> a() {
        return this.cfr_renamed_13;
    }

    public void a(bnu<?> bnu2) {
        this.cfr_renamed_13 = bnu2;
    }
}

