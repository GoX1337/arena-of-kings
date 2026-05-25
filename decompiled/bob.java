/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;

public abstract class bob {
    public Collection<bnz> a(bhm<?> bhm2, bmn bmn2, bfw bfw2) {
        return this.a(bmn2, bhm2, bhm2.bfn_a(), bfw2);
    }

    public Collection<bnz> a(bhm<?> bhm2, bmh bmh2) {
        return this.a(bmh2, bhm2, bhm2.bfn_a());
    }

    public Collection<bnz> b(bhm<?> bhm2, bmn bmn2, bfw bfw2) {
        return this.a(bmn2, bhm2, bhm2.bfn_a(), bfw2);
    }

    public Collection<bnz> b(bhm<?> bhm2, bmh bmh2) {
        return this.a(bmh2, bhm2, bhm2.bfn_a());
    }

    @Deprecated
    public Collection<bnz> a(bmn bmn2, bhm<?> bhm2, bfn bfn2, bfw bfw2) {
        return this.a(bhm2, bmn2, bfw2);
    }

    @Deprecated
    public Collection<bnz> a(bmh bmh2, bhm<?> bhm2, bfn bfn2) {
        return this.a(bhm2, bmh2);
    }
}

