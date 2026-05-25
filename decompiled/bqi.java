/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public abstract class bqi
extends bgo
implements Serializable {
    protected transient Map<Object, brp> cfr_renamed_40;
    protected transient ArrayList<bck<?>> var_java_util_ArrayList_bck_____a;
    protected transient bcy var_bcy_a;

    protected bqi() {
    }

    protected bqi(bgo bgo2, bgm bgm2, bqq bqq2) {
        super(bgo2, bgm2, bqq2);
    }

    public abstract bqi a(bgm var1, bqq var2);

    @Override
    public bgb<Object> a(bmg bmg2, Object object) {
        bgb bgb2;
        if (object == null) {
            return null;
        }
        if (object instanceof bgb) {
            bgb2 = (bgb)object;
        } else {
            bhl bhl2;
            Class clazz;
            if (!(object instanceof Class)) {
                this.b(bmg2.bfw_a(), "AnnotationIntrospector returned serializer definition of type " + object.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
            }
            if ((clazz = (Class)object) == bgb.a.class || buk.c(clazz)) {
                return null;
            }
            if (!bgb.class.isAssignableFrom(clazz)) {
                this.b(bmg2.bfw_a(), "AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<JsonSerializer>");
            }
            bgb bgb3 = bgb2 = (bhl2 = ((bhm)((Object)this.cfr_renamed_40)).bhl_a()) == null ? null : bhl2.a((bgm)((Object)this.cfr_renamed_40), bmg2, (Class<?>)clazz);
            if (bgb2 == null) {
                bgb2 = (bgb)buk.a(clazz, ((bhm)((Object)this.cfr_renamed_40)).c());
            }
        }
        return this.a(bgb2);
    }

    @Override
    public Object a(bmx bmx2, Class<?> clazz) {
        Object object;
        if (clazz == null) {
            return null;
        }
        bhl bhl2 = ((bhm)((Object)this.cfr_renamed_40)).bhl_a();
        Object object2 = object = bhl2 == null ? null : bhl2.a((bgm)((Object)this.cfr_renamed_40), bmx2, clazz);
        if (object == null) {
            object = buk.a(clazz, ((bhm)((Object)this.cfr_renamed_40)).c());
        }
        return object;
    }

    @Override
    public boolean boolean_a(Object object) {
        if (object == null) {
            return true;
        }
        try {
            return object.equals(null);
        }
        catch (Throwable throwable) {
            String string = String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", object.getClass().getName(), throwable.getClass().getName(), buk.java_lang_String_a(throwable));
            this.a(object.getClass(), string, throwable);
            return false;
        }
    }

    @Override
    public brp a(Object object, bck<?> bck2) {
        Object object2;
        if (this.cfr_renamed_40 == null) {
            this.cfr_renamed_40 = this.a();
        } else {
            object2 = this.cfr_renamed_40.get(object);
            if (object2 != null) {
                return object2;
            }
        }
        object2 = null;
        if (this.cfr_renamed_40 == null) {
            this.cfr_renamed_40 = new ArrayList(8);
        } else {
            int n2 = ((ArrayList)((Object)this.cfr_renamed_40)).size();
            for (int i2 = 0; i2 < n2; ++i2) {
                bck bck3 = (bck)((ArrayList)((Object)this.cfr_renamed_40)).get(i2);
                if (!bck3.a(bck2)) continue;
                object2 = bck3;
                break;
            }
        }
        if (object2 == null) {
            object2 = bck2.a(this);
            ((ArrayList)((Object)this.cfr_renamed_40)).add(object2);
        }
        brp brp2 = new brp((bck<?>)object2);
        this.cfr_renamed_40.put(object, brp2);
        return brp2;
    }

    protected Map<Object, brp> a() {
        if (this.a(bgn.y)) {
            return new HashMap<Object, brp>();
        }
        return new IdentityHashMap<Object, brp>();
    }

    @Override
    public bcy bcy_a() {
        return this.var_bcy_a;
    }

    public void a(bcy bcy2, Object object) {
        this.var_bcy_a = bcy2;
        if (object == null) {
            this.b(bcy2);
            return;
        }
        Class<?> clazz = object.getClass();
        bgb<Object> bgb2 = this.a(clazz, true, null);
        bgj bgj2 = ((bhn)((Object)this.cfr_renamed_40)).bgj_a();
        if (bgj2 == null) {
            if (((bgm)((Object)this.cfr_renamed_40)).a(bgn.var_bgn_a)) {
                this.a(bcy2, object, bgb2, ((bhn)((Object)this.cfr_renamed_40)).bgj_a(clazz));
                return;
            }
        } else if (!bgj2.c()) {
            this.a(bcy2, object, bgb2, bgj2);
            return;
        }
        this.a(bcy2, object, bgb2);
    }

    public void a(bcy bcy2, Object object, bfw bfw2) {
        this.var_bcy_a = bcy2;
        if (object == null) {
            this.b(bcy2);
            return;
        }
        if (!((Class)bfw2.a()).isAssignableFrom(object.getClass())) {
            this.a(object, bfw2);
        }
        bgb<Object> bgb2 = this.a(bfw2, true, null);
        bgj bgj2 = ((bhn)((Object)this.cfr_renamed_40)).bgj_a();
        if (bgj2 == null) {
            if (((bgm)((Object)this.cfr_renamed_40)).a(bgn.var_bgn_a)) {
                this.a(bcy2, object, bgb2, ((bhn)((Object)this.cfr_renamed_40)).a(bfw2));
                return;
            }
        } else if (!bgj2.c()) {
            this.a(bcy2, object, bgb2, bgj2);
            return;
        }
        this.a(bcy2, object, bgb2);
    }

    public void a(bcy bcy2, Object object, bfw bfw2, bgb<Object> bgb2) {
        bgj bgj2;
        this.var_bcy_a = bcy2;
        if (object == null) {
            this.b(bcy2);
            return;
        }
        if (bfw2 != null && !((Class)bfw2.a()).isAssignableFrom(object.getClass())) {
            this.a(object, bfw2);
        }
        if (bgb2 == null) {
            bgb2 = this.a(bfw2, true, null);
        }
        if ((bgj2 = ((bhn)((Object)this.cfr_renamed_40)).bgj_a()) == null) {
            if (((bgm)((Object)this.cfr_renamed_40)).a(bgn.var_bgn_a)) {
                bgj2 = bfw2 == null ? ((bhn)((Object)this.cfr_renamed_40)).bgj_a(object.getClass()) : ((bhn)((Object)this.cfr_renamed_40)).a(bfw2);
                this.a(bcy2, object, bgb2, bgj2);
                return;
            }
        } else if (!bgj2.c()) {
            this.a(bcy2, object, bgb2, bgj2);
            return;
        }
        this.a(bcy2, object, bgb2);
    }

    public void a(bcy bcy2, Object object, bfw bfw2, bgb<Object> bgb2, bog bog2) {
        boolean bl2;
        bgj bgj2;
        this.var_bcy_a = bcy2;
        if (object == null) {
            this.b(bcy2);
            return;
        }
        if (bfw2 != null && !((Class)bfw2.a()).isAssignableFrom(object.getClass())) {
            this.a(object, bfw2);
        }
        if (bgb2 == null) {
            bgb2 = bfw2 != null && bfw2.m() ? this.a(bfw2, (bfp)null) : this.a(object.getClass(), (bfp)null);
        }
        if ((bgj2 = ((bhn)((Object)this.cfr_renamed_40)).bgj_a()) == null) {
            bl2 = ((bgm)((Object)this.cfr_renamed_40)).a(bgn.var_bgn_a);
            if (bl2) {
                bcy2.void_c();
                bgj bgj3 = ((bhn)((Object)this.cfr_renamed_40)).bgj_a(object.getClass());
                bcy2.void_a(bgj3.a((bhm<?>)((Object)this.cfr_renamed_40)));
            }
        } else if (bgj2.c()) {
            bl2 = false;
        } else {
            bl2 = true;
            bcy2.void_c();
            bcy2.a(bgj2.java_lang_String_a());
        }
        try {
            bgb2.a(object, bcy2, this, bog2);
            if (bl2) {
                bcy2.void_d();
            }
        }
        catch (Exception exception) {
            throw this.a(bcy2, exception);
        }
    }

    private final void a(bcy bcy2, Object object, bgb<Object> bgb2, bgj bgj2) {
        try {
            bcy2.void_c();
            bcy2.void_a(bgj2.a((bhm<?>)((Object)this.cfr_renamed_40)));
            bgb2.a(object, bcy2, this);
            bcy2.void_d();
        }
        catch (Exception exception) {
            throw this.a(bcy2, exception);
        }
    }

    private final void a(bcy bcy2, Object object, bgb<Object> bgb2) {
        try {
            bgb2.a(object, bcy2, this);
        }
        catch (Exception exception) {
            throw this.a(bcy2, exception);
        }
    }

    protected void b(bcy bcy2) {
        bgb<Object> bgb2 = this.a();
        try {
            bgb2.a(null, bcy2, this);
        }
        catch (Exception exception) {
            throw this.a(bcy2, exception);
        }
    }

    private IOException a(bcy bcy2, Exception exception) {
        if (exception instanceof IOException) {
            return (IOException)exception;
        }
        String string = buk.java_lang_String_a(exception);
        if (string == null) {
            string = "[no message for " + exception.getClass().getName() + "]";
        }
        return new bfy((Closeable)bcy2, string, (Throwable)exception);
    }

    public static final class a
    extends bqi {
        public a() {
        }

        protected a(bgo bgo2, bgm bgm2, bqq bqq2) {
            super(bgo2, bgm2, bqq2);
        }

        @Override
        public a a(bgm bgm2, bqq bqq2) {
            return new a(this, bgm2, bqq2);
        }
    }
}

