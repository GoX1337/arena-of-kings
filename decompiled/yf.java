/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class yf
implements axr {
    protected ayh a;

    public yf(int n2, int n3, TextureAtlas textureAtlas, String string) {
        System.out.println("Lobby pannel in");
        this.a = new ayh(397, 370, textureAtlas, string, false);
        System.out.println("Lobby pannel out");
    }

    public boolean boolean_b() {
        return this.a.boolean_b();
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a.b(f2, engine);
    }

    public void a(Stage stage) {
        this.a.a(true);
    }

    public void b(Stage stage) {
        this.a.a(false);
    }
}

