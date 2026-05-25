/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mv
extends ul {
    public mv() {
        super(new ul.a().a(SpellName.PoisonousShot, "PoisonousShot", 0L, 7000L, gx.d, 40, hc.e, 1650L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.hg, "PoisonousShot_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -60, 26).a(1.0f, 0.0f).a(ajw.hh).b(ajw.hi, "PoisonousShotImpact_on_tick", 28, 0.025f, Animation.PlayMode.NORMAL, -112, -65).b(ajw.hj).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] physical damage on impact and applies [YELLOW]Infection[] and [YELLOW]Poison[] for 3 seconds.\n\n[YELLOW]Infection[]: Reduces maximum health by 10%, all healing received by 30% and deals 1% of maximum health every second as physical damage.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", mv.a(1.12)));
    }
}

