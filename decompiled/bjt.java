/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;

public final class bjt
extends bio {
    protected final bmo var_bmo_a;
    protected final Method var_java_lang_reflect_Method_a;

    public bjt(bmx bmx2, bfw bfw2, boc boc2, bud bud2, bmo bmo2) {
        super(bmx2, bfw2, boc2, bud2);
        this.var_bmo_a = bmo2;
        this.var_java_lang_reflect_Method_a = bmo2.java_lang_reflect_Method_a();
    }

    protected bjt(bjt bjt2, bfx<?> bfx2, bil bil2) {
        super(bjt2, bfx2, bil2);
        this.var_bmo_a = bjt2.var_bmo_a;
        this.var_java_lang_reflect_Method_a = bjt2.var_java_lang_reflect_Method_a;
    }

    protected bjt(bjt bjt2, bgj bgj2) {
        super(bjt2, bgj2);
        this.var_bmo_a = bjt2.var_bmo_a;
        this.var_java_lang_reflect_Method_a = bjt2.var_java_lang_reflect_Method_a;
    }

    @Override
    public bio a(bgj bgj2) {
        return new bjt(this, bgj2);
    }

    @Override
    public bio a(bfx<?> bfx2) {
        if (this.b == bfx2) {
            return this;
        }
        Object object = this.b == this.var_bmo_a ? bfx2 : this.var_bmo_a;
        return new bjt(this, bfx2, (bil)object);
    }

    @Override
    public bio a(bil bil2) {
        return new bjt(this, this.b, bil2);
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
    public final void void_a(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        if (bdc2.boolean_a(bdf.m)) {
            return;
        }
        if (this.var_bmo_a != null) {
            bfs2.b(this.bfw_a(), String.format("Problem deserializing 'setterless' property (\"%s\"): no way to handle typed deser with setterless yet", this.java_lang_String_a()));
        }
        try {
            object2 = this.var_java_lang_reflect_Method_a.invoke(object, (Object[])null);
        }
        catch (Exception exception) {
            this.a(bdc2, exception);
            return;
        }
        if (object2 == null) {
            bfs2.b(this.bfw_a(), String.format("Problem deserializing 'setterless' property '%s': get method returned null", this.java_lang_String_a()));
        }
        this.b.a(bdc2, bfs2, object2);
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        this.void_a(bdc2, bfs2, object);
        return object;
    }

    @Override
    public final void void_a(Object object, Object object2) {
        throw new UnsupportedOperationException("Should never call `set()` on setterless property ('" + this.java_lang_String_a() + "')");
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        this.void_a(object, object2);
        return object;
    }
}

