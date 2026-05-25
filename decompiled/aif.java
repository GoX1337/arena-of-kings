/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;

public class aif
extends aib {
    private double a;
    private boolean d = false;

    public aif(Engine engine, double d2, String string, Color color, boolean bl2, float f2, float f3, int n2) {
        super(engine, string, color, bl2, f2, f3);
        this.a = d2 < 100.0 ? (double)new axy(engine.u) : (d2 < 300.0 ? (double)new axy(engine.v) : (d2 < 500.0 ? (double)new axy(engine.x) : (double)new axy(engine.y)));
        if (color == Color.ORANGE) {
            bl2 = true;
        }
        this.a = d2;
        this.a = n2;
    }

    @Override
    public void a(float f2, Engine engine) {
        super.a(f2, engine);
    }

    public void a(double d2, Color color, float f2, float f3) {
        this.a = d2;
        this.b = color;
        this.a = f2;
        this.b = f3;
        this.void_a();
    }

    private void void_a() {
        if (this.a > 0.0) {
            this.a = (double)String.valueOf((int)this.a);
        } else if (this.a < 0.0) {
            this.a = (double)String.valueOf((int)this.a);
        }
        if (this.a != false) {
            this.a.concat("!");
        }
        this.d = true;
    }

    public double double_a() {
        return this.a;
    }

    public boolean boolean_b() {
        return this.d;
    }
}

