/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mk
extends ul {
    public mk() {
        super(new ul.a().a(SpellName.StreamOfLight, "StreamOfLight", 0L, 4000L, gx.c, 270, hc.e, 1750L, 100000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.gl, "StreamOfLight_on_tick", 15, 0.025f, Animation.PlayMode.LOOP, -78, 42).a(1.0f, 0.0f).b(0.15f).a(ajw.gm).b(ajw.gn, "StreamOfLightImpact_on_tick", 25, 0.025f, Animation.PlayMode.NORMAL, -110, -57).b(ajw.go).a("[WHITE]Shoots a projectile at target ally healing for [ORANGE]%d[] and applies [GREEN]Grace[] for 3 seconds. Heals an additional [ORANGE]%d[] if that ally already had [GREEN]Grace[].\n\n[GREEN]Grace[]: Heals [ORANGE]%d[] every second.", mk.a(1.89), mk.a(1.0), mk.a(0.2706)));
    }
}

