/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class qy
extends pe {
    public qy(Engine engine) {
        super(engine, EffectList.Freeze, "FlashFreeze", "packed/spells/wizard/FlashFreeze/FlashFreezeDebuff_on_tick.atlas", "FlashFreezeDebuff_on_tick", 30, 0.02f, Animation.PlayMode.LOOP, -110, -45, 0.0f, 1.0f);
        this.b(1.0f);
        this.a(ajw.iv);
    }
}

