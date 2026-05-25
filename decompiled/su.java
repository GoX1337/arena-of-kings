/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class su
extends rc {
    public su(Engine engine) {
        super(engine, EffectList.Enlightenment, "skill_207", "packed/spells/lich/Exhaustion/Exhaustion_on_tick.atlas", "Exhaustion_on_tick", 32, 0.04f, Animation.PlayMode.NORMAL, -136, -76, 0.9f, 0.0f);
        this.b(Color.YELLOW);
    }
}

