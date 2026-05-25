/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class yn
extends yf {
    public yn(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2) {
        super(402, 365, textureAtlas, "news_panel_10_19");
        this.a.a(true);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.a.boolean_b()) {
            super.b(f2, engine);
        }
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
    }
}

