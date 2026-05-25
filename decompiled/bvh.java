/*
 * Decompiled with CFR 0.152.
 */
public class bvh {
    protected int var_int_a;
    protected Class<?> var_java_lang_Class____a;
    protected bfw var_bfw_a;
    protected boolean var_boolean_a;

    public bvh() {
    }

    public bvh(Class<?> clazz, boolean bl2) {
        this.var_int_a = (int)clazz;
        this.var_bfw_a = null;
        this.var_boolean_a = bl2;
        this.var_int_a = bl2 ? bvh.b(clazz) : bvh.a(clazz);
    }

    public bvh(bfw bfw2, boolean bl2) {
        this.var_bfw_a = bfw2;
        this.var_int_a = (int)null;
        this.var_boolean_a = bl2;
        this.var_int_a = bl2 ? bvh.b(bfw2) : bvh.a(bfw2);
    }

    public static final int a(Class<?> clazz) {
        return clazz.getName().hashCode();
    }

    public static final int b(Class<?> clazz) {
        return clazz.getName().hashCode() + 1;
    }

    public static final int a(bfw bfw2) {
        return bfw2.hashCode() - 1;
    }

    public static final int b(bfw bfw2) {
        return bfw2.hashCode() - 2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public Class<?> a() {
        return this.var_int_a;
    }

    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    public final int hashCode() {
        return this.var_int_a;
    }

    public final String toString() {
        if (this.var_int_a != null) {
            return "{class: " + this.var_int_a.getName() + ", typed? " + this.var_boolean_a + "}";
        }
        return "{type: " + this.var_bfw_a + ", typed? " + this.var_boolean_a + "}";
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        bvh bvh2 = (bvh)object;
        if (bvh2.var_boolean_a == this.var_boolean_a) {
            if (this.var_int_a != null) {
                return bvh2.var_int_a == this.var_int_a;
            }
            return this.var_bfw_a.equals(bvh2.var_bfw_a);
        }
        return false;
    }
}

