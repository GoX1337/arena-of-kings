/*
 * Decompiled with CFR 0.152.
 */
import java.util.AbstractCollection;
import java.util.AbstractSequentialList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class bjs {
    protected Object var_java_lang_Object_a;
    protected final bck.a var_bck$a_a;
    protected LinkedList<a> var_java_util_LinkedList_bjs$a__a;
    protected bcm var_bcm_a;

    public bjs(bck.a a2) {
        this.var_bck$a_a = a2;
    }

    public void a(bcm bcm2) {
        this.var_bcm_a = bcm2;
    }

    public bck.a bck$a_a() {
        return this.var_bck$a_a;
    }

    public void a(a a2) {
        if (this.var_java_lang_Object_a == null) {
            this.var_java_lang_Object_a = new LinkedList();
        }
        ((LinkedList)this.var_java_lang_Object_a).add(a2);
    }

    public void a(Object object) {
        this.var_bcm_a.a(this.var_bck$a_a, object);
        this.var_java_lang_Object_a = object;
        Object object2 = this.var_bck$a_a.var_java_lang_Object_a;
        if (this.var_java_lang_Object_a != null) {
            Iterator iterator = ((AbstractSequentialList)this.var_java_lang_Object_a).iterator();
            this.var_java_lang_Object_a = null;
            while (iterator.hasNext()) {
                ((a)iterator.next()).a(object2, object);
            }
        }
    }

    public Object java_lang_Object_a() {
        this.var_java_lang_Object_a = this.var_bcm_a.a(this.var_bck$a_a);
        return this.var_java_lang_Object_a;
    }

    public boolean boolean_a() {
        return this.var_java_lang_Object_a != null && !((AbstractCollection)this.var_java_lang_Object_a).isEmpty();
    }

    public Iterator<a> a() {
        if (this.var_java_lang_Object_a == null) {
            return Collections.emptyList().iterator();
        }
        return ((AbstractSequentialList)this.var_java_lang_Object_a).iterator();
    }

    public boolean a(bfs bfs2) {
        return false;
    }

    public String toString() {
        return String.valueOf(this.var_bck$a_a);
    }

    public static abstract class a {
        private final bip var_bip_a;
        private final Class<?> var_java_lang_Class____a;

        public a(bip bip2, Class<?> clazz) {
            this.var_bip_a = bip2;
            this.var_bip_a = clazz;
        }

        public a(bip bip2, bfw bfw2) {
            this.var_bip_a = bip2;
            this.var_bip_a = bfw2.a();
        }

        public bda a() {
            return this.var_bip_a.java_lang_String_a();
        }

        public Class<?> a() {
            return this.var_bip_a;
        }

        public abstract void a(Object var1, Object var2);

        public boolean boolean_a(Object object) {
            return object.equals(this.var_bip_a.java_lang_Object_b());
        }
    }
}

