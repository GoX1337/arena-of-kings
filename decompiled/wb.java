/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class wb
extends axb {
    public wb(Engine engine, ayl ayl2) {
        super(engine, ayl2);
    }

    @Override
    public void show() {
        super.show();
        this.a = new wc(this.a, this.a);
    }

    @Override
    public void render(float f2) {
        this.a.setScreen(new vj(this.a, this.ayl_a()));
    }
}

