/*
 * Decompiled with CFR 0.152.
 */
public final class brp {
    public final bck<?> var_bck____a;
    public Object var_java_lang_Object_a;
    protected boolean var_boolean_a = false;

    public brp(bck<?> bck2) {
        this.var_bck____a = bck2;
    }

    public boolean boolean_a(bcy bcy2, bgo bgo2, brc brc2) {
        if (this.var_java_lang_Object_a != null && (this.var_boolean_a || brc2.var_boolean_a)) {
            if (bcy2.boolean_a()) {
                bcy2.f((Object)String.valueOf(this.var_java_lang_Object_a));
            } else {
                ((bgb)((Object)brc2.var_bfw_a)).a(this.var_java_lang_Object_a, bcy2, bgo2);
            }
            return true;
        }
        return false;
    }

    public Object a(Object object) {
        if (this.var_java_lang_Object_a == null) {
            this.var_java_lang_Object_a = this.var_bck____a.a(object);
        }
        return this.var_java_lang_Object_a;
    }

    public void void_a(bcy bcy2, bgo bgo2, brc brc2) {
        this.var_boolean_a = true;
        if (bcy2.boolean_a()) {
            String string = this.var_java_lang_Object_a == null ? null : String.valueOf(this.var_java_lang_Object_a);
            bcy2.e((Object)string);
            return;
        }
        bdi bdi2 = brc2.var_bdi_a;
        if (bdi2 != null) {
            bcy2.void_a(bdi2);
            ((bgb)((Object)brc2.var_bfw_a)).a(this.var_java_lang_Object_a, bcy2, bgo2);
        }
    }
}

