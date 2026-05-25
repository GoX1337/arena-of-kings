/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ox
extends rc {
    public ox(Engine engine) {
        super(engine, EffectList.DarkInoculation, "skill_472", ajw.eX.a(), "SpiritForm_on_tick", 30, 0.028571429f, Animation.PlayMode.LOOP, -137, -72, 0.25f, 0.25f);
        this.a(Color.BLACK);
    }
}

