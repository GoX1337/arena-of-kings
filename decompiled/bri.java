/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Objects;

@bgp
public class bri
extends brq<String[]> {
    private static final bfw var_bfw_a;
    public static final bri var_bri_a;
    protected final bgb<Object> var_bgb_java_lang_Object__a;

    protected bri() {
        super(String[].class);
        this.var_bfw_a = null;
    }

    public bri(bri bri2, bfp bfp2, bgb<?> bgb2, Boolean bl2) {
        super(bri2, bfp2, bl2);
        this.var_bfw_a = bgb2;
    }

    @Override
    public bgb<?> a(bfp bfp2, Boolean bl2) {
        return new bri(this, bfp2, (bgb<?>)((Object)this.var_bfw_a), bl2);
    }

    @Override
    public bqg<?> b(bog bog2) {
        return this;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Serializable serializable;
        bgb<Object> bgb2 = null;
        if (bfp2 != null) {
            Object object;
            serializable = bgo2.bfn_a();
            bmn bmn2 = bfp2.bmn_a();
            if (bmn2 != null && (object = ((bfn)serializable).java_lang_Object_d(bmn2)) != null) {
                bgb2 = bgo2.a((bmg)bmn2, object);
            }
        }
        serializable = this.a(bgo2, bfp2, String[].class, bbk.a.f);
        if (bgb2 == null) {
            bgb2 = this.var_bfw_a;
        }
        if ((bgb2 = this.a(bgo2, bfp2, bgb2)) == null) {
            bgb2 = bgo2.c(String.class, bfp2);
        }
        if (((bqg)this).a(bgb2)) {
            bgb2 = null;
        }
        if (bgb2 == this.var_bfw_a && Objects.equals(serializable, this.var_bfw_a)) {
            return this;
        }
        return new bri(this, bfp2, bgb2, (Boolean)serializable);
    }

    @Override
    public boolean a(bgo bgo2, String[] stringArray) {
        return stringArray.length == 0;
    }

    @Override
    public boolean a(String[] stringArray) {
        return stringArray.length == 1;
    }

    @Override
    public final void a(String[] stringArray, bcy bcy2, bgo bgo2) {
        int n2 = stringArray.length;
        if (n2 == 1 && (this.var_bfw_a == null && bgo2.a(bgn.t) || this.var_bfw_a == Boolean.TRUE)) {
            this.b(stringArray, bcy2, bgo2);
            return;
        }
        bcy2.a(stringArray, n2);
        this.b(stringArray, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void b(String[] stringArray, bcy bcy2, bgo bgo2) {
        int n2 = stringArray.length;
        if (n2 == 0) {
            return;
        }
        if (this.var_bfw_a != null) {
            this.a(stringArray, bcy2, bgo2, (bgb<Object>)((Object)this.var_bfw_a));
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = stringArray[i2];
            if (string == null) {
                bcy2.e();
                continue;
            }
            bcy2.b(stringArray[i2]);
        }
    }

    private void a(String[] stringArray, bcy bcy2, bgo bgo2, bgb<Object> bgb2) {
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = stringArray[i2];
            if (string == null) {
                bgo2.a(bcy2);
                continue;
            }
            bgb2.a(stringArray[i2], bcy2, bgo2);
        }
    }

    static {
        var_bfw_a = btz.btz_a().a(String.class);
        var_bri_a = new bri();
    }
}

