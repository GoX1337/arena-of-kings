/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Set;

public class bro
extends brt
implements Serializable {
    protected final but a;

    public bro(brt brt2, but but2) {
        super(brt2, but2);
        this.a = but2;
    }

    public bro(bro bro2, brc brc2) {
        super((brt)bro2, brc2);
        this.a = bro2.a;
    }

    public bro(bro bro2, brc brc2, Object object) {
        super((brt)bro2, brc2, object);
        this.a = bro2.a;
    }

    protected bro(bro bro2, Set<String> set, Set<String> set2) {
        super((brt)bro2, set, set2);
        this.a = bro2.a;
    }

    protected bro(bro bro2, bqb[] bqbArray, bqb[] bqbArray2) {
        super((brt)bro2, bqbArray, bqbArray2);
        this.a = bro2.a;
    }

    @Override
    public bgb<Object> a(but but2) {
        return new bro((brt)this, but2);
    }

    @Override
    public boolean b() {
        return true;
    }

    @Override
    public brt a(brc brc2) {
        return new bro(this, brc2);
    }

    @Override
    public brt a(Object object) {
        return new bro(this, (brc)((Object)this.a), object);
    }

    @Override
    protected brt a(Set<String> set, Set<String> set2) {
        return new bro(this, set, set2);
    }

    @Override
    protected brt a(bqb[] bqbArray, bqb[] bqbArray2) {
        return new bro(this, bqbArray, bqbArray2);
    }

    @Override
    protected brt brt_a() {
        return this;
    }

    @Override
    public final void a(Object object, bcy bcy2, bgo bgo2) {
        bcy2.a(object);
        if (this.a != null) {
            this.a(object, bcy2, bgo2, false);
            return;
        }
        if (this.a != null) {
            this.d(object, bcy2, bgo2);
        } else {
            this.c(object, bcy2, bgo2);
        }
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        if (bgo2.a(bgn.f)) {
            bgo2.a(this.a(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        bcy2.a(object);
        if (this.a != null) {
            this.b(object, bcy2, bgo2, bog2);
            return;
        }
        if (this.a != null) {
            this.d(object, bcy2, bgo2);
        } else {
            this.c(object, bcy2, bgo2);
        }
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + this.a().getName();
    }
}

