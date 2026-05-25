/*
 * Decompiled with CFR 0.152.
 */
public class bva
implements bga {
    protected Object a;

    public bva(String string) {
        this.a = string;
    }

    @Override
    public void a(bcy bcy2, bgo bgo2) {
        if (this.a instanceof bga) {
            ((bga)this.a).a(bcy2, bgo2);
        } else {
            this.b(bcy2);
        }
    }

    @Override
    public void a(bcy bcy2, bgo bgo2, bog bog2) {
        if (this.a instanceof bga) {
            ((bga)this.a).a(bcy2, bgo2, bog2);
        } else if (this.a instanceof bdi) {
            this.a(bcy2, bgo2);
        }
    }

    public void a(bcy bcy2) {
        if (this.a instanceof bga) {
            bcy2.h(this.a);
        } else {
            this.b(bcy2);
        }
    }

    protected void b(bcy bcy2) {
        if (this.a instanceof bdi) {
            bcy2.d((bdi)this.a);
        } else {
            bcy2.d(String.valueOf(this.a));
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof bva)) {
            return false;
        }
        bva bva2 = (bva)object;
        if (this.a == bva2.a) {
            return true;
        }
        return this.a != null && this.a.equals(bva2.a);
    }

    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    public String toString() {
        return String.format("[RawValue of type %s]", buk.c(this.a));
    }
}

