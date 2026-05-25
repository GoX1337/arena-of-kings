/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class pf
extends ou {
    public pf(Engine engine) {
        super(engine, EffectList.VexathrasContagion, "skill_125", ot.b, "packed/spells/lich/Contagion/Contagion_on_tick.atlas", "Contagion_on_tick", 16, 0.04f, Animation.PlayMode.LOOP, -110, -52, 1.0f, 0.1f);
        this.a(Color.BLACK);
    }
}

