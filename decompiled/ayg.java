/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;

public class ayg {
    protected boolean b;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected boolean c;

    public ayg(int n2, int n3, int n4, int n5) {
        this.i = n2;
        this.j = n3;
        this.k = n4;
        this.l = n5;
    }

    public ayg(float f2, float f3, float f4, float f5) {
        this((int)f2, (int)f3, (int)f4, (int)f5);
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.i = n2;
        this.j = n3;
        this.k = n4;
        this.l = n5;
    }

    public void b(Engine engine) {
        this.a(engine);
        this.r();
        if (this.c) {
            this.f();
        }
    }

    public boolean boolean_e() {
        return this.b;
    }

    public void a(Engine engine) {
        if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= (float)this.i && engine.var_com_badlogic_gdx_math_Vector3_a.x <= (float)this.k && engine.var_com_badlogic_gdx_math_Vector3_a.y >= (float)this.j && engine.var_com_badlogic_gdx_math_Vector3_a.y <= (float)this.l) {
            this.b = true;
            this.a_();
        } else {
            this.b = false;
            this.b_();
        }
    }

    public void a_() {
        this.b = true;
    }

    public void b_() {
        this.b = false;
    }

    public void r() {
        this.c = Gdx.input.isButtonPressed(0) && Gdx.input.justTouched() && this.b;
    }

    public void f() {
    }

    public String toString() {
        return "HoverableRegion [hovered=" + this.b + ", xMin=" + this.i + ", yMin=" + this.j + ", xMax=" + this.k + ", yMax=" + this.l + ", clicked=" + this.c + "]";
    }
}

