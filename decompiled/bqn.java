/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class bqn
extends bna
implements Serializable {
    protected bqn(bgi bgi2) {
        super(bgi2);
    }

    protected bqn(bmx bmx2) {
        super(bmx2.bgi_a());
    }

    protected bqn(bqn bqn2) {
        super(bqn2);
    }

    public abstract void void_a(Object var1, bcy var2, bgo var3);

    public abstract void b(Object var1, bcy var2, bgo var3);
}

