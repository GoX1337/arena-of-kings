/*
 * Decompiled with CFR 0.152.
 */
public final class brc {
    public final bfw var_bfw_a;
    public final bdi var_bdi_a;
    public final bck<?> var_bck____a;
    public final bgb<Object> var_bgb_java_lang_Object__a;
    public final boolean var_boolean_a;

    protected brc(bfw bfw2, bdi bdi2, bck<?> bck2, bgb<?> bgb2, boolean bl2) {
        this.var_bfw_a = bfw2;
        this.var_bdi_a = bdi2;
        this.var_bfw_a = bck2;
        this.var_bfw_a = bgb2;
        this.var_boolean_a = bl2;
    }

    public static brc a(bfw bfw2, bgj bgj2, bck<?> bck2, boolean bl2) {
        String string = bgj2 == null ? null : bgj2.java_lang_String_a();
        bee bee2 = string == null ? null : new bee(string);
        return new brc(bfw2, bee2, bck2, null, bl2);
    }

    public brc a(bgb<?> bgb2) {
        return new brc(this.var_bfw_a, this.var_bdi_a, (bck<?>)((Object)this.var_bfw_a), bgb2, this.var_boolean_a);
    }

    public brc a(boolean bl2) {
        if (bl2 == this.var_boolean_a) {
            return this;
        }
        return new brc(this.var_bfw_a, this.var_bdi_a, (bck<?>)((Object)this.var_bfw_a), (bgb<?>)((Object)this.var_bfw_a), bl2);
    }
}

