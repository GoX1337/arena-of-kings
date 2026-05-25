/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class rr
extends rc {
    private final Engine a;
    private azv b;

    public rr(Engine engine) {
        super(engine, EffectList.Meditate, "Meditate", ajw.ld.a(), "Meditate_on_tick", 20, 0.05f, Animation.PlayMode.LOOP, -100, -40, 0.0f, 1.0f);
        this.a(ajw.le);
        this.b = new azv(2000L, true);
        this.a = engine;
    }

    @Override
    public void c(float f2) {
        if (this.b.boolean_b()) {
            this.a.var_baa_a.a(((azo)((Object)this.a)).ajw_a());
            this.b.void_c();
        }
    }
}

