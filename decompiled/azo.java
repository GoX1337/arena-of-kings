/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class azo {
    private ajw var_ajw_a;
    private boolean var_boolean_a;
    private float var_float_a = 1.0f;

    public azo(ajw ajw2) {
        this.var_ajw_a = ajw2;
        this.var_boolean_a = false;
    }

    public void a(axm axm2) {
        Engine.a("loadSound()");
        this.var_boolean_a = true;
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public ajw ajw_a() {
        return this.var_ajw_a;
    }

    public float float_a() {
        return this.var_float_a;
    }

    public void a(float f2) {
        this.var_float_a = f2;
    }

    public void b(float f2) {
        this.var_float_a *= f2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }
}

