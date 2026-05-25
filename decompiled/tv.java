/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.Animation;

public class tv
extends tr {
    public tv(Engine engine) {
        super(engine, EffectList.Fear, "packed/spells/harm/Fear/Fear_on_tick.atlas", "Fear_on_tick", 20, 0.075f, Animation.PlayMode.LOOP, -64, 48, 1.0f, 1.0f);
        this.a(ajw.bH);
    }
}

