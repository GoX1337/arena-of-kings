/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.Serializable;

public abstract class bio
extends bna
implements Serializable {
    protected static final bfx<Object> var_bfx_java_lang_Object__a;
    protected final bgj var_bgj_a;
    protected final bfw var_bfw_a;
    protected final bgj var_bgj_b;
    protected final transient bud var_bud_a;
    protected final bfx<Object> var_bfx_java_lang_Object__b;
    protected final boc var_boc_a;
    protected final bil var_bil_a;
    protected String var_java_lang_String_a;
    protected bni var_bni_a;
    protected bvi var_bvi_a;
    protected int var_int_b = -1;

    protected bio(bmx bmx2, bfw bfw2, boc boc2, bud bud2) {
        this(bmx2.bgj_a(), bfw2, bmx2.bgj_b(), boc2, bud2, bmx2.bgi_a());
    }

    protected bio(bgj bgj2, bfw bfw2, bgj bgj3, boc boc2, bud bud2, bgi bgi2) {
        super(bgi2);
        this.var_bgj_a = bgj2 == null ? bgj.var_bgj_b : bgj2.bgj_a();
        this.var_bfw_a = bfw2;
        this.var_bgj_b = bgj3;
        this.var_bud_a = bud2;
        this.var_bvi_a = null;
        if (boc2 != null) {
            boc2 = boc2.a(this);
        }
        this.var_boc_a = boc2;
        this.var_bgj_b = var_bfx_java_lang_Object__a;
        this.var_bil_a = var_bfx_java_lang_Object__a;
    }

    protected bio(bgj bgj2, bfw bfw2, bgi bgi2, bfx<Object> bfx2) {
        super(bgi2);
        this.var_bgj_a = bgj2 == null ? bgj.var_bgj_b : bgj2.bgj_a();
        this.var_bfw_a = bfw2;
        this.var_bgj_b = null;
        this.var_bud_a = null;
        this.var_bvi_a = null;
        this.var_boc_a = null;
        this.var_bgj_b = bfx2;
        this.var_bil_a = bfx2;
    }

    protected bio(bio bio2) {
        super(bio2);
        this.var_bgj_a = bio2.var_bgj_a;
        this.var_bfw_a = bio2.var_bfw_a;
        this.var_bgj_b = bio2.var_bgj_b;
        this.var_bud_a = bio2.var_bud_a;
        this.var_bgj_b = bio2.var_bgj_b;
        this.var_boc_a = bio2.var_boc_a;
        this.var_java_lang_String_a = bio2.var_java_lang_String_a;
        this.var_int_b = bio2.var_int_b;
        this.var_bvi_a = bio2.var_bvi_a;
        this.var_bil_a = bio2.var_bil_a;
    }

    protected bio(bio bio2, bfx<?> bfx2, bil object) {
        super(bio2);
        this.var_bgj_a = bio2.var_bgj_a;
        this.var_bfw_a = bio2.var_bfw_a;
        this.var_bgj_b = bio2.var_bgj_b;
        this.var_bud_a = bio2.var_bud_a;
        this.var_boc_a = bio2.var_boc_a;
        this.var_java_lang_String_a = bio2.var_java_lang_String_a;
        this.var_int_b = bio2.var_int_b;
        this.var_bgj_b = bfx2 == null ? var_bfx_java_lang_Object__a : bfx2;
        this.var_bvi_a = bio2.var_bvi_a;
        if (object == var_bfx_java_lang_Object__a) {
            object = this.var_bgj_b;
        }
        this.var_bil_a = object;
    }

    protected bio(bio bio2, bgj bgj2) {
        super(bio2);
        this.var_bgj_a = bgj2;
        this.var_bfw_a = bio2.var_bfw_a;
        this.var_bgj_b = bio2.var_bgj_b;
        this.var_bud_a = bio2.var_bud_a;
        this.var_bgj_b = bio2.var_bgj_b;
        this.var_boc_a = bio2.var_boc_a;
        this.var_java_lang_String_a = bio2.var_java_lang_String_a;
        this.var_int_b = bio2.var_int_b;
        this.var_bvi_a = bio2.var_bvi_a;
        this.var_bil_a = bio2.var_bil_a;
    }

    public abstract bio a(bfx<?> var1);

    public abstract bio a(bgj var1);

    public bio bio_a(String string) {
        bgj bgj2 = this.var_bgj_a == null ? new bgj(string) : this.var_bgj_a.b(string);
        return bgj2 == this.var_bgj_a ? this : this.a(bgj2);
    }

    public abstract bio a(bil var1);

    public void void_a(String string) {
        this.var_java_lang_String_a = string;
    }

    public void a(bni bni2) {
        this.var_bni_a = bni2;
    }

    public void a(Class<?>[] classArray) {
        this.var_bvi_a = classArray == null ? null : bvi.a(classArray);
    }

    public void a(int n2) {
        if (this.var_int_b != -1) {
            throw new IllegalStateException("Property '" + this.java_lang_String_a() + "' already had index (" + this.var_int_b + "), trying to assign " + n2);
        }
        this.var_int_b = n2;
    }

    public void a(bfr bfr2) {
    }

    public void void_a() {
    }

    public boolean boolean_a() {
        return false;
    }

    @Override
    public final String java_lang_String_a() {
        return this.var_bgj_a.java_lang_String_a();
    }

    @Override
    public bgj bgj_a() {
        return this.var_bgj_a;
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    @Override
    public abstract bmn bmn_a();

    protected Class<?> a() {
        return this.bmn_a().b();
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_a;
    }

    public bni bni_a() {
        return this.var_bni_a;
    }

    public boolean c() {
        return this.var_bgj_b != null && this.var_bgj_b != var_bfx_java_lang_Object__a;
    }

    public boolean d() {
        return this.var_boc_a != null;
    }

    public bfx<Object> a() {
        bgj bgj2 = this.var_bgj_b;
        if (bgj2 == var_bfx_java_lang_Object__a) {
            return null;
        }
        return bgj2;
    }

    public boc boc_a() {
        return this.var_boc_a;
    }

    public bil bil_a() {
        return this.var_bil_a;
    }

    public boolean a(Class<?> clazz) {
        return this.var_bvi_a == null || this.var_bvi_a.a(clazz);
    }

    public boolean e() {
        return this.var_bvi_a != null;
    }

    public int int_a() {
        throw new IllegalStateException(String.format("Internal error: no creator index for property '%s' (of type %s)", this.java_lang_String_a(), this.getClass().getName()));
    }

    public Object java_lang_Object_a() {
        return null;
    }

    public boolean boolean_b() {
        return false;
    }

    public abstract void void_a(bdc var1, bfs var2, Object var3);

    public abstract Object java_lang_Object_a(bdc var1, bfs var2, Object var3);

    public abstract void void_a(Object var1, Object var2);

    public abstract Object java_lang_Object_a(Object var1, Object var2);

    public final Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.m)) {
            return this.var_bil_a.a(bfs2);
        }
        if (this.var_boc_a != null) {
            return ((bfx)((Object)this.var_bgj_b)).a(bdc2, bfs2, this.var_boc_a);
        }
        Object object = ((bfx)((Object)this.var_bgj_b)).a(bdc2, bfs2);
        if (object == null) {
            object = this.var_bil_a.a(bfs2);
        }
        return object;
    }

    public final Object b(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        if (bdc2.boolean_a(bdf.m)) {
            if (bjj.a(this.var_bil_a)) {
                return object;
            }
            return this.var_bil_a.a(bfs2);
        }
        if (this.var_boc_a != null) {
            bfs2.b(this.bfw_a(), String.format("Cannot merge polymorphic property '%s'", this.java_lang_String_a()));
        }
        if ((object2 = ((bfx)((Object)this.var_bgj_b)).a(bdc2, bfs2, object)) == null) {
            if (bjj.a(this.var_bil_a)) {
                return object;
            }
            object2 = this.var_bil_a.a(bfs2);
        }
        return object2;
    }

    protected void a(bdc bdc2, Exception exception, Object object) {
        if (exception instanceof IllegalArgumentException) {
            String string = buk.c(object);
            StringBuilder stringBuilder = new StringBuilder("Problem deserializing property '").append(this.java_lang_String_a()).append("' (expected type: ").append(this.bfw_a()).append("; actual type: ").append(string).append(")");
            String string2 = buk.java_lang_String_a(exception);
            if (string2 != null) {
                stringBuilder.append(", problem: ").append(string2);
            } else {
                stringBuilder.append(" (no error message provided)");
            }
            throw bfy.a(bdc2, stringBuilder.toString(), (Throwable)exception);
        }
        this.a(bdc2, exception);
    }

    protected IOException a(bdc bdc2, Exception exception) {
        buk.c(exception);
        buk.java_lang_Throwable_b(exception);
        Throwable throwable = buk.d(exception);
        throw bfy.a(bdc2, buk.java_lang_String_a(throwable), throwable);
    }

    protected void a(Exception exception, Object object) {
        this.a((bdc)null, exception, object);
    }

    public String toString() {
        return "[property '" + this.java_lang_String_a() + "']";
    }

    static {
        var_bfx_java_lang_Object__a = new bja("No _valueDeserializer assigned");
    }

    public static abstract class a
    extends bio {
        protected final bio a;

        protected a(bio bio2) {
            super(bio2);
            this.a = bio2;
        }

        protected abstract bio a(bio var1);

        protected bio b(bio bio2) {
            if (bio2 == this.a) {
                return this;
            }
            return this.a(bio2);
        }

        @Override
        public bio a(bfx<?> bfx2) {
            return this.b(this.a.a(bfx2));
        }

        @Override
        public bio a(bgj bgj2) {
            return this.b(this.a.a(bgj2));
        }

        @Override
        public bio a(bil bil2) {
            return this.b(this.a.a(bil2));
        }

        @Override
        public void a(int n2) {
            this.a.a(n2);
        }

        @Override
        public void a(bfr bfr2) {
            this.a.a(bfr2);
        }

        @Override
        protected Class<?> a() {
            return this.a.java_lang_Object_a();
        }

        @Override
        public String java_lang_String_b() {
            return this.a.java_lang_String_b();
        }

        @Override
        public bni bni_a() {
            return this.a.bni_a();
        }

        @Override
        public boolean c() {
            return this.a.c();
        }

        @Override
        public boolean d() {
            return this.a.d();
        }

        @Override
        public bfx<Object> a() {
            return this.a.bil_a();
        }

        @Override
        public boc boc_a() {
            return this.a.boc_a();
        }

        @Override
        public boolean a(Class<?> clazz) {
            return this.a.a(clazz);
        }

        @Override
        public boolean e() {
            return this.a.e();
        }

        @Override
        public int int_a() {
            return this.a.int_a();
        }

        @Override
        public Object java_lang_Object_a() {
            return this.a.java_lang_Object_a();
        }

        @Override
        public boolean boolean_b() {
            return this.a.boolean_b();
        }

        @Override
        public bmn bmn_a() {
            return this.a.bmn_a();
        }

        @Override
        public void void_a(bdc bdc2, bfs bfs2, Object object) {
            this.a.void_a(bdc2, bfs2, object);
        }

        @Override
        public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
            return this.a.java_lang_Object_a(bdc2, bfs2, object);
        }

        @Override
        public void void_a(Object object, Object object2) {
            this.a.void_a(object, object2);
        }

        @Override
        public Object java_lang_Object_a(Object object, Object object2) {
            return this.a.java_lang_Object_a(object, object2);
        }
    }
}

