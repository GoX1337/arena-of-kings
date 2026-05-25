/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class bcp
implements bcm {
    protected Map<bck.a, Object> a;

    @Override
    public void a(bck.a a2, Object object) {
        if (this.a == null) {
            this.a = new HashMap<bck.a, Object>();
        } else {
            Object object2 = this.a.get(a2);
            if (object2 != null) {
                if (object2 == object) {
                    return;
                }
                throw new IllegalStateException("Already had POJO for id (" + a2.var_java_lang_Object_a.getClass().getName() + ") [" + a2 + "]");
            }
        }
        this.a.put(a2, object);
    }

    @Override
    public Object a(bck.a a2) {
        return this.a == null ? null : this.a.get(a2);
    }

    @Override
    public boolean a(bcm bcm2) {
        return bcm2.getClass() == this.getClass();
    }

    @Override
    public bcm a(Object object) {
        return new bcp();
    }
}

