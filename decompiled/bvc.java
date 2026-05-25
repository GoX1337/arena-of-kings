/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.Iterator;

public class bvc
extends bmx {
    protected final bfn var_bfn_a;
    protected final bmn var_bmn_a;
    protected final bgi var_bgi_a;
    protected final bgj var_bgj_a;
    protected final bbr.b b;

    protected bvc(bfn bfn2, bmn bmn2, bgj bgj2, bgi bgi2, bbr.b b2) {
        this.var_bfn_a = bfn2;
        this.var_bmn_a = bmn2;
        this.var_bgj_a = bgj2;
        this.var_bgi_a = bgi2 == null ? bgi.var_bgi_b : bgi2;
        this.b = b2;
    }

    public static bvc a(bhm<?> bhm2, bmn bmn2, bgj bgj2) {
        return bvc.a(bhm2, bmn2, bgj2, null, (bbr.b)((Object)var_bfn_a));
    }

    public static bvc a(bhm<?> bhm2, bmn bmn2, bgj bgj2, bgi bgi2, bbr.a a2) {
        bfn bfn2 = a2 == null || a2 == bbr.a.g ? var_bfn_a : bbr.b.a(a2, null);
        return new bvc(bhm2.bfn_a(), bmn2, bgj2, bgi2, (bbr.b)((Object)bfn2));
    }

    public static bvc a(bhm<?> bhm2, bmn bmn2, bgj bgj2, bgi bgi2, bbr.b b2) {
        return new bvc(bhm2.bfn_a(), bmn2, bgj2, bgi2, b2);
    }

    @Override
    public String java_lang_String_a() {
        return this.var_bgj_a.java_lang_String_a();
    }

    @Override
    public bgj bgj_a() {
        return this.var_bgj_a;
    }

    @Override
    public boolean boolean_a(bgj bgj2) {
        return this.var_bgj_a.equals(bgj2);
    }

    @Override
    public bgj bgj_b() {
        if (this.var_bfn_a == null || this.var_bmn_a == null) {
            return null;
        }
        return this.var_bfn_a.java_lang_Object_a((bmg)this.var_bmn_a);
    }

    @Override
    public boolean boolean_a() {
        return false;
    }

    @Override
    public boolean boolean_b() {
        return false;
    }

    @Override
    public bgi bgi_a() {
        return this.var_bgi_a;
    }

    @Override
    public bfw bfw_a() {
        if (this.var_bmn_a == null) {
            return btz.bfw_a();
        }
        return this.var_bmn_a.bfw_a();
    }

    @Override
    public Class<?> a() {
        if (this.var_bmn_a == null) {
            return Object.class;
        }
        return this.var_bmn_a.java_lang_reflect_AnnotatedElement_a();
    }

    @Override
    public bbr.b bbr$b_a() {
        return this.b;
    }

    @Override
    public boolean boolean_e() {
        return this.bmo_b() != null;
    }

    @Override
    public boolean f() {
        return this.var_bmn_a instanceof bml;
    }

    @Override
    public boolean g() {
        return this.var_bmn_a instanceof bmr;
    }

    @Override
    public bmo bmo_a() {
        if (this.var_bmn_a instanceof bmo && ((bmo)this.var_bmn_a).int_a() == 0) {
            return (bmo)this.var_bmn_a;
        }
        return null;
    }

    @Override
    public bmo bmo_b() {
        if (this.var_bmn_a instanceof bmo && ((bmo)this.var_bmn_a).int_a() == 1) {
            return (bmo)this.var_bmn_a;
        }
        return null;
    }

    @Override
    public bml bml_a() {
        return this.var_bmn_a instanceof bml ? (bml)this.var_bmn_a : null;
    }

    @Override
    public bmr bmr_a() {
        return this.var_bmn_a instanceof bmr ? (bmr)this.var_bmn_a : null;
    }

    @Override
    public Iterator<bmr> a() {
        bmr bmr2 = this.bmr_a();
        if (bmr2 == null) {
            return buk.a();
        }
        return Collections.singleton(bmr2).iterator();
    }

    @Override
    public bmn bmn_d() {
        return this.var_bmn_a;
    }
}

