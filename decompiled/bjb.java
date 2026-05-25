/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Field;

public final class bjb
extends bio {
    protected final bml var_bml_a;
    protected final transient Field var_java_lang_reflect_Field_a;
    protected final boolean var_boolean_a;

    public bjb(bmx bmx2, bfw bfw2, boc boc2, bud bud2, bml bml2) {
        super(bmx2, bfw2, boc2, bud2);
        this.var_bml_a = bml2;
        this.var_java_lang_reflect_Field_a = bml2.java_lang_reflect_Field_a();
        this.var_boolean_a = bjj.a((bil)((Object)this.var_bml_a));
    }

    protected bjb(bjb bjb2, bfx<?> bfx2, bil bil2) {
        super(bjb2, bfx2, bil2);
        this.var_bml_a = bjb2.var_bml_a;
        this.var_java_lang_reflect_Field_a = bjb2.var_java_lang_reflect_Field_a;
        this.var_boolean_a = bjj.a(bil2);
    }

    protected bjb(bjb bjb2, bgj bgj2) {
        super(bjb2, bgj2);
        this.var_bml_a = bjb2.var_bml_a;
        this.var_java_lang_reflect_Field_a = bjb2.var_java_lang_reflect_Field_a;
        this.var_boolean_a = bjb2.var_boolean_a;
    }

    @Override
    public bio a(bgj bgj2) {
        return new bjb(this, bgj2);
    }

    @Override
    public bio a(bfx<?> bfx2) {
        if (this.b == bfx2) {
            return this;
        }
        Object object = this.b == this.var_bml_a ? bfx2 : this.var_bml_a;
        return new bjb(this, bfx2, (bil)object);
    }

    @Override
    public bio a(bil bil2) {
        return new bjb(this, this.b, bil2);
    }

    @Override
    public void a(bfr bfr2) {
        buk.a(this.var_java_lang_reflect_Field_a, bfr2.a(bgd.o));
    }

    @Override
    public bmn bmn_a() {
        return this.var_bml_a;
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        if (bdc2.boolean_a(bdf.m)) {
            if (this.var_boolean_a) {
                return;
            }
            object2 = this.var_bml_a.a(bfs2);
        } else if (this.var_bml_a == null) {
            object2 = this.b.a(bdc2, bfs2);
            if (object2 == null) {
                if (this.var_boolean_a) {
                    return;
                }
                object2 = this.var_bml_a.a(bfs2);
            }
        } else {
            object2 = this.b.a(bdc2, bfs2, (boc)((Object)this.var_bml_a));
        }
        try {
            this.var_java_lang_reflect_Field_a.set(object, object2);
        }
        catch (Exception exception) {
            this.a(bdc2, exception, object2);
        }
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        if (bdc2.boolean_a(bdf.m)) {
            if (this.var_boolean_a) {
                return object;
            }
            object2 = this.var_bml_a.a(bfs2);
        } else if (this.var_bml_a == null) {
            object2 = this.b.a(bdc2, bfs2);
            if (object2 == null) {
                if (this.var_boolean_a) {
                    return object;
                }
                object2 = this.var_bml_a.a(bfs2);
            }
        } else {
            object2 = this.b.a(bdc2, bfs2, (boc)((Object)this.var_bml_a));
        }
        try {
            this.var_java_lang_reflect_Field_a.set(object, object2);
        }
        catch (Exception exception) {
            this.a(bdc2, exception, object2);
        }
        return object;
    }

    @Override
    public void void_a(Object object, Object object2) {
        try {
            this.var_java_lang_reflect_Field_a.set(object, object2);
        }
        catch (Exception exception) {
            this.a(exception, object2);
        }
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        try {
            this.var_java_lang_reflect_Field_a.set(object, object2);
        }
        catch (Exception exception) {
            this.a(exception, object2);
        }
        return object;
    }
}

