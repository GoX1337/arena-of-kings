/*
 * Decompiled with CFR 0.152.
 */
import java.util.Set;

public class bqc
extends brt {
    public bqc(bfw bfw2, bqd bqd2, bqb[] bqbArray, bqb[] bqbArray2) {
        super(bfw2, bqd2, bqbArray, bqbArray2);
    }

    protected bqc(brt brt2, brc brc2, Object object) {
        super(brt2, brc2, object);
    }

    protected bqc(brt brt2, Set<String> set, Set<String> set2) {
        super(brt2, set, set2);
    }

    protected bqc(brt brt2, bqb[] bqbArray, bqb[] bqbArray2) {
        super(brt2, bqbArray, bqbArray2);
    }

    public static bqc a(bfw bfw2, bqd bqd2) {
        return new bqc(bfw2, bqd2, a, null);
    }

    @Override
    public bgb<Object> a(but but2) {
        return new bro((brt)this, but2);
    }

    @Override
    public brt a(brc brc2) {
        return new bqc((brt)this, brc2, this.a);
    }

    @Override
    public brt a(Object object) {
        return new bqc((brt)this, this.a, object);
    }

    @Override
    protected brt a(Set<String> set, Set<String> set2) {
        return new bqc((brt)this, set, set2);
    }

    @Override
    protected brt a(bqb[] bqbArray, bqb[] bqbArray2) {
        return new bqc((brt)this, bqbArray, bqbArray2);
    }

    @Override
    protected brt brt_a() {
        if (this.a == null && this.a == null && this.a == null) {
            return new bqu(this);
        }
        return this;
    }

    @Override
    public final void a(Object object, bcy bcy2, bgo bgo2) {
        if (this.a != null) {
            bcy2.a(object);
            this.a(object, bcy2, bgo2, true);
            return;
        }
        bcy2.c(object);
        if (this.a != null) {
            this.d(object, bcy2, bgo2);
        } else {
            this.c(object, bcy2, bgo2);
        }
        bcy2.void_d();
    }

    public String toString() {
        return "BeanSerializer for " + this.a().getName();
    }
}

