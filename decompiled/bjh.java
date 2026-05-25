/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;

public final class bjh
extends bio {
    protected final bmo var_bmo_a;
    protected final transient Method var_java_lang_reflect_Method_a;
    protected final boolean var_boolean_a;

    public bjh(bmx bmx2, bfw bfw2, boc boc2, bud bud2, bmo bmo2) {
        super(bmx2, bfw2, boc2, bud2);
        this.var_bmo_a = bmo2;
        this.var_java_lang_reflect_Method_a = bmo2.java_lang_reflect_Method_a();
        this.var_boolean_a = bjj.a((bil)((Object)this.var_bmo_a));
    }

    protected bjh(bjh bjh2, bfx<?> bfx2, bil bil2) {
        super(bjh2, bfx2, bil2);
        this.var_bmo_a = bjh2.var_bmo_a;
        this.var_java_lang_reflect_Method_a = bjh2.var_java_lang_reflect_Method_a;
        this.var_boolean_a = bjj.a(bil2);
    }

    protected bjh(bjh bjh2, bgj bgj2) {
        super(bjh2, bgj2);
        this.var_bmo_a = bjh2.var_bmo_a;
        this.var_java_lang_reflect_Method_a = bjh2.var_java_lang_reflect_Method_a;
        this.var_boolean_a = bjh2.var_boolean_a;
    }

    @Override
    public bio a(bgj bgj2) {
        return new bjh(this, bgj2);
    }

    @Override
    public bio a(bfx<?> bfx2) {
        if (this.b == bfx2) {
            return this;
        }
        Object object = this.b == this.var_bmo_a ? bfx2 : this.var_bmo_a;
        return new bjh(this, bfx2, (bil)object);
    }

    @Override
    public bio a(bil bil2) {
        return new bjh(this, this.b, bil2);
    }

    @Override
    public void a(bfr bfr2) {
        this.var_bmo_a.a(bfr2.a(bgd.o));
    }

    @Override
    public bmn bmn_a() {
        return this.var_bmo_a;
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        if (bdc2.boolean_a(bdf.m)) {
            if (this.var_boolean_a) {
                return;
            }
            object2 = this.var_bmo_a.a(bfs2);
        } else if (this.var_bmo_a == null) {
            object2 = this.b.a(bdc2, bfs2);
            if (object2 == null) {
                if (this.var_boolean_a) {
                    return;
                }
                object2 = this.var_bmo_a.a(bfs2);
            }
        } else {
            object2 = this.b.a(bdc2, bfs2, (boc)((Object)this.var_bmo_a));
        }
        try {
            this.var_java_lang_reflect_Method_a.invoke(object, object2);
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
            object2 = this.var_bmo_a.a(bfs2);
        } else if (this.var_bmo_a == null) {
            object2 = this.b.a(bdc2, bfs2);
            if (object2 == null) {
                if (this.var_boolean_a) {
                    return object;
                }
                object2 = this.var_bmo_a.a(bfs2);
            }
        } else {
            object2 = this.b.a(bdc2, bfs2, (boc)((Object)this.var_bmo_a));
        }
        try {
            Object object3 = this.var_java_lang_reflect_Method_a.invoke(object, object2);
            return object3 == null ? object : object3;
        }
        catch (Exception exception) {
            this.a(bdc2, exception, object2);
            return null;
        }
    }

    @Override
    public final void void_a(Object object, Object object2) {
        try {
            this.var_java_lang_reflect_Method_a.invoke(object, object2);
        }
        catch (Exception exception) {
            this.a(exception, object2);
        }
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        try {
            Object object3 = this.var_java_lang_reflect_Method_a.invoke(object, object2);
            return object3 == null ? object : object3;
        }
        catch (Exception exception) {
            this.a(exception, object2);
            return null;
        }
    }
}

