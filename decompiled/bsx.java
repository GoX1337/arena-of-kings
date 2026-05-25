/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Objects;

public abstract class bsx<T extends Collection<?>>
extends bte<T>
implements bqh {
    protected final Boolean a;

    protected bsx(Class<?> clazz) {
        super(clazz, false);
        this.a = null;
    }

    protected bsx(bsx<?> bsx2, Boolean bl2) {
        super(bsx2);
        this.a = bl2;
    }

    public abstract bgb<?> a(bfp var1, Boolean var2);

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Serializable serializable;
        bgb<Object> bgb2 = null;
        Boolean bl2 = null;
        if (bfp2 != null) {
            Object object;
            serializable = bgo2.bfn_a();
            bmn bmn2 = bfp2.bmn_a();
            if (bmn2 != null && (object = ((bfn)serializable).java_lang_Object_d(bmn2)) != null) {
                bgb2 = bgo2.a((bmg)bmn2, object);
            }
        }
        if ((serializable = this.bbk$d_a(bgo2, bfp2, this.a())) != null) {
            bl2 = ((bbk.d)serializable).a(bbk.a.f);
        }
        if ((bgb2 = this.a(bgo2, bfp2, bgb2)) == null) {
            bgb2 = bgo2.c(String.class, bfp2);
        }
        if (this.a(bgb2)) {
            if (Objects.equals(bl2, this.a)) {
                return this;
            }
            return this.a(bfp2, bl2);
        }
        return new bsa(bgo2.a((Type)((Object)String.class)), true, null, bgb2);
    }

    @Override
    public boolean a(bgo bgo2, T t2) {
        return t2 == null || t2.size() == 0;
    }

    @Override
    public abstract void a(T var1, bcy var2, bgo var3, bog var4);
}

