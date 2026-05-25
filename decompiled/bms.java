/*
 * Decompiled with CFR 0.152.
 */
public abstract class bms
extends bmn {
    protected final bmu[] a;

    protected bms(bns bns2, bmu bmu2, bmu[] bmuArray) {
        super(bns2, bmu2);
        this.a = bmuArray;
    }

    protected bmr a(int n2, bmu bmu2) {
        this.a[n2] = bmu2;
        return this.bmr_a(n2);
    }

    public final bmu bmu_a(int n2) {
        if (this.a != null && n2 >= 0 && n2 < this.a.length) {
            return this.a[n2];
        }
        return null;
    }

    public final bmr bmr_a(int n2) {
        return new bmr(this, this.bfw_a(n2), (bns)this.a, this.bmu_a(n2), n2);
    }

    public abstract int int_a();

    public abstract Class<?> a(int var1);

    public abstract bfw bfw_a(int var1);

    public abstract Object java_lang_Object_a();

    public abstract Object a(Object[] var1);

    public abstract Object a(Object var1);
}

