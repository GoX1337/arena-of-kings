/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;

public final class btn {
    protected final btn var_btn_a;
    protected final Class<?> var_java_lang_Class____a;
    private ArrayList<btv> var_java_util_ArrayList_btv__a;

    public btn(Class<?> clazz) {
        this(null, clazz);
    }

    private btn(btn btn2, Class<?> clazz) {
        this.var_btn_a = btn2;
        this.var_btn_a = clazz;
    }

    public btn a(Class<?> clazz) {
        return new btn(this, clazz);
    }

    public void a(btv btv2) {
        if (this.var_btn_a == null) {
            this.var_btn_a = new ArrayList();
        }
        ((ArrayList)((Object)this.var_btn_a)).add(btv2);
    }

    public void a(bfw bfw2) {
        if (this.var_btn_a != null) {
            Iterator iterator = ((ArrayList)((Object)this.var_btn_a)).iterator();
            while (iterator.hasNext()) {
                btv btv2 = (btv)iterator.next();
                btv2.void_a(bfw2);
            }
        }
    }

    public btn b(Class<?> clazz) {
        if (this.var_btn_a == clazz) {
            return this;
        }
        btn btn2 = this.var_btn_a;
        while (btn2 != null) {
            if (btn2.var_btn_a == clazz) {
                return btn2;
            }
            btn2 = btn2.var_btn_a;
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ClassStack (self-refs: ").append(this.var_btn_a == null ? "0" : String.valueOf(((ArrayList)((Object)this.var_btn_a)).size())).append(')');
        btn btn2 = this;
        while (btn2 != null) {
            stringBuilder.append(' ').append(((Class)((Object)btn2.var_btn_a)).getName());
            btn2 = btn2.var_btn_a;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

