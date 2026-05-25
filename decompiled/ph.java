/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ph
extends pe {
    public ph(Engine engine) {
        super(engine, EffectList.VexathrasExhaustion, "Exhaustion", "packed/spells/lich/Exhaustion/Exhaustion_on_tick.atlas", "Exhaustion_on_tick", 32, 0.04f, Animation.PlayMode.NORMAL, -15, -2, 0.5f, 0.5f);
        this.a(ajw.dU);
    }

    @Override
    protected void d() {
        this.b(0.9f, true);
    }

    @Override
    public void c() {
        super.c();
        this.b(0.9f, true);
    }
}

