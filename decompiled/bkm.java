/*
 * Decompiled with CFR 0.152.
 */
import java.util.EnumSet;
import java.util.Objects;

public class bkm
extends blc<EnumSet<?>>
implements bib {
    protected final bfw var_bfw_a;
    protected bfx<Enum<?>> var_bfx_java_lang_Enum_____a;
    protected final bil var_bil_a;
    protected final boolean var_boolean_a;
    protected final Boolean var_java_lang_Boolean_a;

    public bkm(bfw bfw2, bfx<?> bfx2) {
        super(EnumSet.class);
        this.var_bfw_a = bfw2;
        if (!bfw2.g()) {
            throw new IllegalArgumentException("Type " + bfw2 + " not Java Enum type");
        }
        this.var_bfw_a = bfx2;
        this.var_java_lang_Boolean_a = null;
        this.var_bil_a = null;
        this.var_boolean_a = false;
    }

    protected bkm(bkm bkm2, bfx<?> bfx2, bil bil2, Boolean bl2) {
        super(bkm2);
        this.var_bfw_a = bkm2.var_bfw_a;
        this.var_bfw_a = bfx2;
        this.var_bil_a = bil2;
        this.var_boolean_a = bjj.a(bil2);
        this.var_java_lang_Boolean_a = bl2;
    }

    public bkm a(bfx<?> bfx2, bil bil2, Boolean bl2) {
        if (Objects.equals(this.var_java_lang_Boolean_a, bl2) && this.var_bfw_a == bfx2 && this.var_bil_a == bfx2) {
            return this;
        }
        return new bkm(this, bfx2, bil2, bl2);
    }

    @Override
    public boolean boolean_a() {
        return this.var_bfw_a.a() == null;
    }

    @Override
    public btq btq_a() {
        return btq.b;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.TRUE;
    }

    @Override
    public Object b(bfs bfs2) {
        return this.java_util_EnumSet_a();
    }

    @Override
    public buc buc_a() {
        return buc.c;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        Boolean bl2 = this.a(bfs2, bfp2, EnumSet.class, bbk.a.var_bbk$a_a);
        Object object = this.var_bfw_a;
        object = object == null ? bfs2.a(this.var_bfw_a, bfp2) : bfs2.b((bfx<?>)object, bfp2, this.var_bfw_a);
        return this.a((bfx<?>)object, this.a(bfs2, bfp2, (bfx<?>)object), bl2);
    }

    @Override
    public EnumSet<?> a(bdc bdc2, bfs bfs2) {
        EnumSet enumSet = this.java_util_EnumSet_a();
        if (!bdc2.boolean_c()) {
            return this.c(bdc2, bfs2, enumSet);
        }
        return this.b(bdc2, bfs2, enumSet);
    }

    @Override
    public EnumSet<?> a(bdc bdc2, bfs bfs2, EnumSet<?> enumSet) {
        if (!bdc2.boolean_c()) {
            return this.c(bdc2, bfs2, enumSet);
        }
        return this.b(bdc2, bfs2, enumSet);
    }

    protected final EnumSet<?> b(bdc bdc2, bfs bfs2, EnumSet enumSet) {
        try {
            bdf bdf2;
            while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                Enum enum_;
                if (bdf2 == bdf.m) {
                    if (this.var_boolean_a) continue;
                    enum_ = (Enum)this.var_bil_a.a(bfs2);
                } else {
                    enum_ = (Enum)((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2);
                }
                if (enum_ == null) continue;
                enumSet.add(enum_);
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, (Object)enumSet, enumSet.size());
        }
        return enumSet;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.b(bdc2, bfs2);
    }

    @Override
    private EnumSet java_util_EnumSet_a() {
        return EnumSet.noneOf(this.var_bfw_a.a());
    }

    protected EnumSet<?> c(bdc bdc2, bfs bfs2, EnumSet enumSet) {
        boolean bl2;
        boolean bl3 = bl2 = this.var_java_lang_Boolean_a == Boolean.TRUE || this.var_java_lang_Boolean_a == null && bfs2.a(bfu.q);
        if (!bl2) {
            return (EnumSet)bfs2.a(EnumSet.class, bdc2);
        }
        if (bdc2.boolean_a(bdf.m)) {
            return (EnumSet)bfs2.a(this.var_bfw_a, bdc2);
        }
        try {
            Enum enum_ = (Enum)((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2);
            if (enum_ != null) {
                enumSet.add(enum_);
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, (Object)enumSet, enumSet.size());
        }
        return enumSet;
    }
}

