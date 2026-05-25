/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class pu
extends pe {
    public pu(Engine engine) {
        super(engine, EffectList.DeathsGrasp, "Hobble", "packed/spells/harm/Hobble/Hobble_on_tick.atlas", "Hobble_on_tick", 30, 0.035f, Animation.PlayMode.LOOP, -90, -70, 1.0f, 0.2f);
        this.b(1.0f);
    }
}

