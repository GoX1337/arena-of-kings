/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mu
extends ul {
    public mu() {
        super(new ul.a().a(SpellName.NightmareShot, "NightmareShot", 0L, 22000L, gx.d, 40, hc.e, 1350L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.gS, "NightmareShot_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -65, 30).a(1.0f, 0.0f).a(ajw.gT).b(ajw.gU, "NightmareShotImpact_on_tick", 18, 0.025f, Animation.PlayMode.NORMAL, -114, -37).b(ajw.gV).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] physical damage on impact and applies [YELLOW]Fear[] for 1.6 seconds.\n\n[YELLOW]Fear[]: Causes you to run in a random direction and prevents the use of abilities. Breaks upon receiving damage equal to 6% of your maximum health.", mu.a(1.2)));
    }
}

