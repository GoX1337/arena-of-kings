/*
 * Decompiled with CFR 0.152.
 */
public class brg
implements bqa,
bqm {
    public static bqm a(bqa bqa2) {
        return new brh(bqa2);
    }

    protected boolean a(bqb bqb2) {
        return true;
    }

    protected boolean a(bqn bqn2) {
        return true;
    }

    @Override
    @Deprecated
    public void a(Object object, bcy bcy2, bgo bgo2, bqb bqb2) {
        if (this.a(bqb2)) {
            bqb2.void_a(object, bcy2, bgo2);
        } else if (!bcy2.boolean_d()) {
            bqb2.b(object, bcy2, bgo2);
        }
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bqn bqn2) {
        if (this.a(bqn2)) {
            bqn2.void_a(object, bcy2, bgo2);
        } else if (!bcy2.boolean_d()) {
            bqn2.b(object, bcy2, bgo2);
        }
    }
}

