/*
 * Decompiled with CFR 0.152.
 */
import java.util.Set;

public class bqu
extends brt {
    protected final brt a;

    public bqu(brt brt2) {
        super(brt2, (brc)null);
        this.a = brt2;
    }

    protected bqu(brt brt2, Set<String> set, Set<String> set2) {
        super(brt2, set, set2);
        this.a = brt2;
    }

    protected bqu(brt brt2, brc brc2, Object object) {
        super(brt2, brc2, object);
        this.a = brt2;
    }

    @Override
    public bgb<Object> a(but but2) {
        return this.a.a(but2);
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public brt a(brc brc2) {
        return this.a.a(brc2);
    }

    @Override
    public brt a(Object object) {
        return new bqu((brt)this, (brc)((Object)this.a), object);
    }

    @Override
    protected bqu a(Set<String> set, Set<String> set2) {
        return new bqu((brt)this, set, set2);
    }

    @Override
    protected brt a(bqb[] bqbArray, bqb[] bqbArray2) {
        return this;
    }

    @Override
    protected brt brt_a() {
        return this;
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        if (this.a != null) {
            this.b(object, bcy2, bgo2, bog2);
            return;
        }
        beu beu2 = this.a(bog2, object, bdf.var_bdf_d);
        bog2.a(bcy2, beu2);
        bcy2.a(object);
        this.b(object, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    @Override
    public final void a(Object object, bcy bcy2, bgo bgo2) {
        if (bgo2.a(bgn.t) && this.boolean_a(bgo2)) {
            this.b(object, bcy2, bgo2);
            return;
        }
        bcy2.b(object);
        this.b(object, bcy2, bgo2);
        bcy2.void_b();
    }

    private boolean boolean_a(bgo bgo2) {
        bqb[] bqbArray = this.c != null && bgo2.a() != null ? this.c : this.b;
        return bqbArray.length == 1;
    }

    protected final void b(Object object, bcy bcy2, bgo bgo2) {
        int n2;
        bqb[] bqbArray = this.c != null && bgo2.a() != null ? this.c : this.b;
        try {
            for (bqb bqb2 : bqbArray) {
                if (bqb2 == null) {
                    bcy2.e();
                    continue;
                }
                bqb2.c(object, bcy2, bgo2);
            }
        }
        catch (Exception exception) {
            String string = n2 == bqbArray.length ? "[anySetter]" : bqbArray[n2].java_lang_String_a();
            this.a(bgo2, (Throwable)exception, object, string);
        }
        catch (StackOverflowError stackOverflowError) {
            bfy bfy2 = bfy.a(bcy2, "Infinite recursion (StackOverflowError)", (Throwable)stackOverflowError);
            String string = n2 == bqbArray.length ? "[anySetter]" : bqbArray[n2].java_lang_String_a();
            bfy2.a(new bfy.a(object, string));
            throw bfy2;
        }
    }

    public String toString() {
        return "BeanAsArraySerializer for " + this.a().getName();
    }
}

