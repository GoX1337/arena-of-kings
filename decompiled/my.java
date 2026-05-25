/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class my
extends uf {
    public my() {
        super(new uf.a().a(SpellName.RainOfArrows, "RainOfArrows", 1000L, 15000L, gx.d, 60, hc.e, 2000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.POSITIONAL, false, false).a(ajw.ha, "RainOfArrows_on_tick", 31, 0.04f, Animation.PlayMode.LOOP, -145, -110).a(150).a(ajw.hb).a("[WHITE]Creates [VIOLET]Rain of Arrows[] at your cursor's location for 2 seconds.\n\n[VIOLET]Rain of Arrows[]: Critically deals [ORANGE]%d[] physical damage.", my.a(0.91875)));
    }
}

