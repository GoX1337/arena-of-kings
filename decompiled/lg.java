/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lg
extends ul {
    public lg() {
        super(new ul.a().a(SpellName.ChaosWave, "ChaosWave", 0L, 22000L, gx.c, 250, hc.e, 1100L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.fi, "ChaosWave_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -70, 57).a(1.0f, 0.0f).a(ajw.fj).b(ajw.fl).b(ajw.fk, "ChaosWaveImpact_on_tick", 24, 0.025f, Animation.PlayMode.NORMAL, -140, -81).a(1.85f).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[]-[ORANGE]%d[] magic damage and applies [YELLOW]Fear[] for 1.8 seconds on impact. You gain Life equal to 100% of the damage dealt.\n\n[YELLOW]Fear[]: Causes you to run in a random direction and prevents the use of abilities. Breaks upon receiving damage equal to 6% of your maximum health.", lg.a(1.0), lg.a(2.0)));
    }
}

