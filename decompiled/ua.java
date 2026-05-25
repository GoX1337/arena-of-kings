/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ua
extends tr {
    public ua(Engine engine) {
        super(engine, EffectList.Poison, "packed/spells/harm/Poison/Poison_on_tick.atlas", "Poison_on_tick", 25, 0.045f, Animation.PlayMode.LOOP, -132, -75, 1.0f, 1.0f);
        this.b(0.15f);
    }
}

