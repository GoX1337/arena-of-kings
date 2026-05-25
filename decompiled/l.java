/*
 * Decompiled with CFR 0.152.
 */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public abstract class l
extends Game {
    @Override
    public void create() {
    }

    @Override
    public void render() {
        if (this.screen != null) {
            this.screen.render(Gdx.graphics.getDeltaTime());
        }
        this.void_a();
    }

    public abstract void void_a();
}

