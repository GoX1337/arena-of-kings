/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class aye
extends ayf {
    protected Sprite a;

    @Deprecated
    public aye() {
    }

    public aye(int n2, int n3, TextureAtlas textureAtlas, String string, String string2, String string3, boolean bl2) {
        this.b = new Sprite(textureAtlas.createSprite(string));
        this.b.setPosition(n2, n3);
        this.c = new Sprite(textureAtlas.createSprite(string2));
        this.a = new Sprite(textureAtlas.createSprite(string3));
        this.a.setPosition(n2, n3);
        float f2 = 0.0f;
        float f3 = 0.0f;
        this.c.setPosition((float)n2 + f2, (float)n3 + f3);
        this.e = bl2;
    }

    public void a(int n2, int n3) {
        this.b.setPosition(n2, n3);
        this.c.setPosition(n2, n3);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.e) {
            this.a.draw(engine.var_azi_a);
            if (!this.b) {
                this.b.draw(engine.var_azi_a);
            } else {
                this.c.draw(engine.var_azi_a);
            }
        }
    }
}

