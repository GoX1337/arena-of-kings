/*
 * Decompiled with CFR 0.152.
 */
public class bid
extends bio {
    protected final bmr var_bmr_a;
    protected final bba.a var_bba$a_a;
    protected bio var_bio_a;
    protected final int var_int_a;
    protected boolean var_boolean_a;

    protected bid(bgj bgj2, bfw bfw2, bgj bgj3, boc boc2, bud bud2, bmr bmr2, int n2, bba.a a2, bgi bgi2) {
        super(bgj2, bfw2, bgj3, boc2, bud2, bgi2);
        this.var_bmr_a = bmr2;
        this.var_int_a = n2;
        this.var_bba$a_a = a2;
        this.var_bio_a = null;
    }

    public static bid a(bgj bgj2, bfw bfw2, bgj bgj3, boc boc2, bud bud2, bmr bmr2, int n2, bba.a a2, bgi bgi2) {
        return new bid(bgj2, bfw2, bgj3, boc2, bud2, bmr2, n2, a2, bgi2);
    }

    protected bid(bid bid2, bgj bgj2) {
        super(bid2, bgj2);
        this.var_bmr_a = bid2.var_bmr_a;
        this.var_bba$a_a = bid2.var_bba$a_a;
        this.var_bio_a = bid2.var_bio_a;
        this.var_int_a = bid2.var_int_a;
        this.var_boolean_a = bid2.var_boolean_a;
    }

    protected bid(bid bid2, bfx<?> bfx2, bil bil2) {
        super(bid2, bfx2, bil2);
        this.var_bmr_a = bid2.var_bmr_a;
        this.var_bba$a_a = bid2.var_bba$a_a;
        this.var_bio_a = bid2.var_bio_a;
        this.var_int_a = bid2.var_int_a;
        this.var_boolean_a = bid2.var_boolean_a;
    }

    @Override
    public bio a(bgj bgj2) {
        return new bid(this, bgj2);
    }

    @Override
    public bio a(bfx<?> bfx2) {
        if (this.b == bfx2) {
            return this;
        }
        Object object = this.b == this.var_bmr_a ? bfx2 : this.var_bmr_a;
        return new bid(this, bfx2, (bil)object);
    }

    @Override
    public bio a(bil bil2) {
        return new bid(this, this.b, bil2);
    }

    @Override
    public void a(bfr bfr2) {
        if (this.var_bio_a != null) {
            this.var_bio_a.a(bfr2);
        }
    }

    public void a(bio bio2) {
        this.var_bio_a = bio2;
    }

    @Override
    public void void_a() {
        this.var_boolean_a = true;
    }

    @Override
    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public bmn bmn_a() {
        return this.var_bmr_a;
    }

    @Override
    public int int_a() {
        return this.var_int_a;
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        this.void_b();
        this.var_bio_a.void_a(object, this.java_lang_Object_a(bdc2, bfs2));
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        this.void_b();
        return this.var_bio_a.java_lang_Object_a(object, this.java_lang_Object_a(bdc2, bfs2));
    }

    @Override
    public void void_a(Object object, Object object2) {
        this.void_b();
        this.var_bio_a.void_a(object, object2);
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        this.void_b();
        return this.var_bio_a.java_lang_Object_a(object, object2);
    }

    @Override
    public bgi bgi_a() {
        Object object = super.java_lang_Object_a();
        if (this.var_bio_a != null) {
            return ((bgi)object).a(((bgi)this.var_bio_a.java_lang_Object_a()).bgi$a_a());
        }
        return object;
    }

    @Override
    public Object java_lang_Object_a() {
        return this.var_bba$a_a == null ? null : this.var_bba$a_a.java_lang_Object_a();
    }

    @Override
    public boolean boolean_b() {
        return this.var_bba$a_a != null && !this.var_bba$a_a.a(true);
    }

    @Override
    public String toString() {
        return "[creator property, name " + buk.b((String)this.java_lang_Object_a()) + "; inject id '" + this.java_lang_Object_a() + "']";
    }

    private final void void_b() {
        if (this.var_bio_a == null) {
            this.void_a((bdc)null, (bfs)null);
        }
    }

    private void void_a(bdc bdc2, bfs bfs2) {
        String string = "No fallback setter/field defined for creator property " + buk.b((String)this.java_lang_Object_a());
        if (bfs2 == null) {
            throw blq.a(bdc2, string, (bfw)this.java_lang_Object_a());
        }
        bfs2.b((bfw)this.java_lang_Object_a(), string);
    }
}

