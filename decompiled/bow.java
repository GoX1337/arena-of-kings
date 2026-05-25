/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;
import java.util.Collection;

public class bow
implements bof<bow> {
    protected bce.b var_bce$b_a;
    protected bce.a var_bce$a_a;
    protected String var_java_lang_String_a;
    protected boolean var_boolean_a = false;
    protected Class<?> var_java_lang_Class____a;
    protected boe var_boe_a;

    public static bow a() {
        return new bow().a(bce.b.var_bce$b_a, null);
    }

    @Override
    public bow a(bce.b b2, boe boe2) {
        if (b2 == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this.var_bce$b_a = b2;
        this.var_boe_a = boe2;
        this.var_java_lang_String_a = b2.a();
        return this;
    }

    @Override
    public bog a(bgm bgm2, bfw bfw2, Collection<bnz> collection) {
        if (this.var_bce$b_a == bce.b.var_bce$b_a) {
            return null;
        }
        if (bfw2.k() && !this.boolean_a(bgm2, bfw2)) {
            return null;
        }
        boe boe2 = this.a(bgm2, bfw2, this.a(bgm2), collection, true, false);
        if (this.var_bce$b_a == bce.b.e) {
            return new bol(boe2, null, this.var_java_lang_String_a);
        }
        switch (this.var_bce$a_a) {
            case c: {
                return new boj(boe2, null);
            }
            case var_bce$a_a: {
                return new bop(boe2, null, this.var_java_lang_String_a);
            }
            case b: {
                return new bor(boe2, null);
            }
            case d: {
                return new bon(boe2, null, this.var_java_lang_String_a);
            }
            case e: {
                return new bol(boe2, null, this.var_java_lang_String_a);
            }
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + (Object)((Object)this.var_bce$a_a));
    }

    @Override
    public boc a(bfr bfr2, bfw bfw2, Collection<bnz> collection) {
        if (this.var_bce$b_a == bce.b.var_bce$b_a) {
            return null;
        }
        if (bfw2.k() && !this.boolean_a((bhm<?>)bfr2, bfw2)) {
            return null;
        }
        boa boa2 = this.boa_a((bhm<?>)bfr2, bfw2);
        boe boe2 = this.a(bfr2, bfw2, boa2, collection, false, true);
        bfw bfw3 = this.a(bfr2, bfw2);
        if (this.var_bce$b_a == bce.b.e) {
            return new bok(bfw2, boe2, bfw3, bfr2, collection);
        }
        switch (this.var_bce$a_a) {
            case c: {
                return new boi(bfw2, boe2, this.var_java_lang_String_a, this.var_boolean_a, bfw3);
            }
            case var_bce$a_a: 
            case e: {
                return new boo(bfw2, boe2, this.var_java_lang_String_a, this.var_boolean_a, bfw3, this.var_bce$a_a);
            }
            case b: {
                return new boq(bfw2, boe2, this.var_java_lang_String_a, this.var_boolean_a, bfw3);
            }
            case d: {
                return new bom(bfw2, boe2, this.var_java_lang_String_a, this.var_boolean_a, bfw3);
            }
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + (Object)((Object)this.var_bce$a_a));
    }

    protected bfw a(bfr bfr2, bfw bfw2) {
        bfw bfw3 = this.var_bce$b_a == null ? (bfr2.a(bgd.q) && !bfw2.boolean_c() ? bfw2 : null) : (this.var_bce$b_a == Void.class || this.var_bce$b_a == bgy.class ? bfr2.btz_a().a((Type)((Object)this.var_bce$b_a)) : (bfw2.boolean_a((Class<?>)((Object)this.var_bce$b_a)) ? bfw2 : (bfw2.c((Class<?>)((Object)this.var_bce$b_a)) ? bfr2.btz_a().bfw_a(bfw2, (Class<?>)((Object)this.var_bce$b_a)) : null)));
        return bfw3;
    }

    @Override
    public bow a(bce.a a2) {
        if (a2 == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this.var_bce$a_a = a2;
        return this;
    }

    @Override
    public bow a(String string) {
        if (string == null || string.isEmpty()) {
            string = this.var_bce$b_a.a();
        }
        this.var_java_lang_String_a = string;
        return this;
    }

    @Override
    public bow a(Class<?> clazz) {
        this.var_bce$b_a = clazz;
        return this;
    }

    @Override
    public bow a(boolean bl2) {
        this.var_boolean_a = bl2;
        return this;
    }

    @Override
    public Class<?> a() {
        return this.var_bce$b_a;
    }

    protected boe a(bhm<?> bhm2, bfw bfw2, boa boa2, Collection<bnz> collection, boolean bl2, boolean bl3) {
        if (this.var_boe_a != null) {
            return this.var_boe_a;
        }
        if (this.var_bce$b_a == null) {
            throw new IllegalStateException("Cannot build, 'init()' not yet called");
        }
        switch (this.var_bce$b_a) {
            case e: 
            case b: {
                return bos.a(bfw2, bhm2, boa2);
            }
            case c: {
                return bou.a(bfw2, bhm2, boa2);
            }
            case d: {
                return bpb.a(bhm2, bfw2, collection, bl2, bl3);
            }
            case var_bce$b_a: {
                return null;
            }
        }
        throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + (Object)((Object)this.var_bce$b_a));
    }

    @Override
    public boa a(bhm<?> bhm2) {
        return bhm2.boa_a();
    }

    protected boa boa_a(bhm<?> bhm2, bfw bfw2) {
        boa boa2 = this.a(bhm2);
        if (this.var_bce$b_a == bce.b.b || this.var_bce$b_a == bce.b.c) {
            boa.b b2 = boa2.boa$b_a(bhm2, bfw2);
            if (b2 == boa.b.b) {
                return this.a(bhm2, bfw2, boa2);
            }
            if (b2 == boa.b.var_boa$b_a) {
                return bot.a;
            }
        }
        return boa2;
    }

    protected boa a(bhm<?> bhm2, bfw bfw2, boa boa2) {
        throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", buk.c(boa2), buk.c(bfw2.a())));
    }

    protected boolean boolean_a(bhm<?> bhm2, bfw bfw2) {
        return false;
    }
}

