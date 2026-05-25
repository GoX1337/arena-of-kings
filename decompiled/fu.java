/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.Animation;

public class fu {
    protected hd var_hd_a;
    protected da var_da_a;
    protected ajw var_ajw_a;
    protected hf var_hf_a;
    protected boolean var_boolean_a = false;
    protected ajw b;

    public void a(axm axm2) {
        Engine.a("trinket loadGFX() in");
        this.var_hd_a.b(axm2);
        Engine.a("trinket loadGFX() in 2");
        this.var_hd_a.a(1146, 10);
        Engine.a("trinket loadGFX() in 3");
    }

    public void a(ajw ajw2, String string, int n2, float f2, float f3, Animation.PlayMode playMode, int n3, int n4) {
        this.var_da_a = new da(ajw2, string, n2, f2, f3, playMode, n3, n4);
    }

    public void a(ajw ajw2) {
        this.b = ajw2;
    }

    public void a(String string) {
        this.var_hf_a.a(string);
    }

    public void void_a() {
        this.var_boolean_a = true;
    }

    public void b() {
        this.var_boolean_a = false;
        this.var_hf_a.azv_c().d();
        this.var_hf_a.azv_b().d();
        this.var_hf_a.azv_a().d();
        this.var_hd_a.void_c();
        this.var_da_a.b(false);
    }

    public void c() {
        this.var_boolean_a = false;
        this.var_hf_a.azv_c().void_c();
        if (this.var_hf_a.azv_b().boolean_a()) {
            this.var_hf_a.azv_b().void_b();
        }
        this.var_hf_a.azv_b().e();
        if (this.var_hf_a.azv_a().boolean_a()) {
            this.var_hf_a.azv_a().d();
        }
        this.var_hf_a.azv_a().void_a();
        this.var_da_a.b(false);
        this.var_hd_a.void_c();
    }

    public boolean boolean_a() {
        if (this.var_boolean_a) {
            return false;
        }
        return this.var_hf_a.azv_c().boolean_b() || !this.var_hf_a.azv_c().boolean_a();
    }

    public da da_a() {
        return this.var_da_a;
    }

    public hd hd_a() {
        return this.var_hd_a;
    }

    public hf hf_a() {
        return this.var_hf_a;
    }

    public ajw ajw_a() {
        return this.b;
    }
}

