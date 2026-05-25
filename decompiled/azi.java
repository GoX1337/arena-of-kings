/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class azi
extends SpriteBatch {
    private final Engine a;

    public azi(Engine engine) {
        this.a = engine;
    }

    public void a(float f2, Array<axr> array) {
        if (!this.isDrawing()) {
            this.begin();
        }
        for (int i2 = 0; i2 < array.size; ++i2) {
            array.get(i2).b(f2, this.a);
        }
        if (this.isDrawing()) {
            this.end();
        }
    }

    public void b(float f2, Array<axr> array) {
        for (int i2 = 0; i2 < array.size; ++i2) {
            array.get(i2).b(f2, this.a);
        }
    }

    public void c(float f2, Array<axr> array) {
        for (int i2 = 0; i2 < array.size; ++i2) {
            if (array.get(i2) == null) continue;
            array.get(i2).a(f2, this.a);
        }
    }
}

