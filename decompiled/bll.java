/*
 * Decompiled with CFR 0.152.
 */
public class bll
extends bht {
    public bll(bht bht2) {
        super(bht2);
        this.b = false;
    }

    protected bll(bht bht2, but but2) {
        super((bhv)bht2, but2);
    }

    @Override
    public bfx<Object> a(but but2) {
        if (this.getClass() != bll.class) {
            return this;
        }
        return new bll(this, but2);
    }

    @Override
    public Object b(bdc bdc2, bfs bfs2) {
        if (this.a != null) {
            return this.c(bdc2, bfs2);
        }
        if (this.a != null) {
            return this.a.a(bfs2, this.a.a(bdc2, bfs2));
        }
        if (this.a.boolean_c()) {
            return bfs2.a(this.a(), this.bir_a(), bdc2, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean bl2 = this.a.boolean_b();
        boolean bl3 = this.a.i();
        if (!bl2 && !bl3) {
            return bfs2.a(this.a(), this.bir_a(), bdc2, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
        }
        Object object = null;
        Object[] objectArray = null;
        int n2 = 0;
        while (!bdc2.boolean_a(bdf.var_bdf_c)) {
            int n3;
            String string = bdc2.java_lang_String_d();
            bio bio2 = this.a.bio_a(string);
            bdc2.bdf_a();
            if (bio2 != null) {
                if (object != null) {
                    bio2.void_a(bdc2, bfs2, object);
                } else {
                    if (objectArray == null) {
                        n3 = this.a.int_a();
                        objectArray = new Object[n3 + n3];
                    }
                    objectArray[n2++] = bio2;
                    objectArray[n2++] = bio2.java_lang_Object_a(bdc2, bfs2);
                }
            } else {
                n3 = "message".equals(string);
                if (n3 != 0 && bl2) {
                    object = this.a.a(bfs2, bdc2.java_lang_String_f());
                    if (objectArray != null) {
                        int n4 = n2;
                        for (int i2 = 0; i2 < n4; i2 += 2) {
                            bio2 = (bio)objectArray[i2];
                            bio2.void_a(object, objectArray[i2 + 1]);
                        }
                        objectArray = null;
                    }
                } else if (this.a != null && this.a.contains(string)) {
                    bdc2.bdc_a();
                } else if (this.a != null) {
                    this.a.a(bdc2, bfs2, object, string);
                } else {
                    this.b(bdc2, bfs2, object, string);
                }
            }
            bdc2.bdf_a();
        }
        if (object == null) {
            object = bl2 ? this.a.a(bfs2, (String)null) : this.a.a(bfs2);
            if (objectArray != null) {
                int n5 = n2;
                for (int i3 = 0; i3 < n5; i3 += 2) {
                    bio bio3 = (bio)objectArray[i3];
                    bio3.void_a(object, objectArray[i3 + 1]);
                }
            }
        }
        return object;
    }
}

