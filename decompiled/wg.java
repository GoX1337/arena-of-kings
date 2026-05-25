/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.chat.Chat;
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class wg
extends Chat {
    public wg(Engine engine, axm axm2, BitmapFont bitmapFont, Skin skin, int n2, boolean bl2, Stage stage, int n3, int n4, int n5, int n6) {
        super(engine, axm2, bitmapFont, skin, n2, stage, n3, n4, n5, n6, 15, 150);
        this.e = 735;
        this.f = 25;
        this.g = 557;
        this.h = 6;
        this.void_b();
        if (bl2) {
            this.void_a();
        }
    }

    public void l() {
        this.a(this.e);
        this.void_d();
    }

    @Override
    public void void_b() {
        this.a.setPosition(this.g, this.h);
        this.a.setSize(500.0f, this.f);
    }
}

