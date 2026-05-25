/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemLocation;
import java.util.ArrayList;
import java.util.List;

public class bz
implements axr {
    protected int var_int_a = (int)new ArrayList();
    protected List<fm> var_java_util_List_fm__a;

    public bz(int n2) {
        Engine.b("Stash make index: " + n2);
        this.var_int_a = n2;
        this.var_int_a = (int)new ArrayList(112);
        for (int i2 = 0; i2 < 112; ++i2) {
            this.var_int_a.add(new ff(ItemLocation.STASH, i2));
        }
    }

    public boolean boolean_a(fm fm2) {
        for (int i2 = 0; i2 < this.var_int_a.size(); ++i2) {
            if (!(this.var_int_a.get(i2) instanceof ff)) continue;
            fm2.b(ItemLocation.STASH);
            fm2.c(this.var_int_a);
            fm2.a(((fm)this.var_int_a.get(i2)).int_a());
            this.var_int_a.set(i2, fm2);
            fm2.void_a();
            return true;
        }
        return false;
    }

    public void void_a(fm fm2) {
        fm2.b(ItemLocation.STASH);
        fm2.c(this.var_int_a);
        this.var_int_a.set(fm2.int_a(), fm2);
        fm2.void_a();
    }

    public void a(fm fm2, int n2) {
        fm2.a(n2);
        this.void_a(fm2);
    }

    public boolean boolean_a() {
        for (int i2 = 0; i2 < this.var_int_a.size(); ++i2) {
            if (!(this.var_int_a.get(i2) instanceof ff)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        for (fm fm2 : this.var_int_a) {
            fm2.b(f2, engine);
        }
    }

    public void c(float f2, Engine engine) {
        for (fm fm2 : this.var_int_a) {
            fm2.d(f2, engine);
        }
    }

    public void d(float f2, Engine engine) {
        for (fm fm2 : this.var_int_a) {
            fm2.c(f2, engine);
        }
    }

    public boolean boolean_a(int n2) {
        return n2 >= 0 && n2 < this.var_int_a.size();
    }

    public List<fm> a() {
        return this.var_int_a;
    }

    public fm fm_a(int n2) {
        if (this.boolean_a(n2)) {
            return (fm)this.var_int_a.get(n2);
        }
        return null;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public int b() {
        for (int i2 = 0; i2 < this.var_int_a.size(); ++i2) {
            if (!(this.var_int_a.get(i2) instanceof ff)) continue;
            return i2;
        }
        return -1;
    }

    public String toString() {
        return "Tab " + (this.var_int_a + 1);
    }
}

