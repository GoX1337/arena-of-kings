/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oz
extends ou {
    public oz(Engine engine) {
        super(engine, EffectList.Intimidation, ot.b, "packed/spells/champion/Intimidation/Intimidation_on_tick.atlas", "Intimidation_on_tick", 25, 0.04f, Animation.PlayMode.LOOP, -110, -62, 0.3f, 0.1f);
        this.b(0.08f);
    }
}

