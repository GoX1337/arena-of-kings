/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mp
extends ul {
    public mp() {
        super(new ul.a().a(SpellName.ElementalArrow, "ElementalArrow", 0L, 8000L, gx.d, 50, hc.e, 1700L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.gW, "ElementalArrow_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -65, 30).a(1.0f, 0.0f).a(ajw.gX).b(ajw.gY, "ElementalArrowImpact_on_tick", 12, 0.025f, Animation.PlayMode.NORMAL, -112, -47).b(ajw.gZ).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] magic damage, applies [YELLOW]Burning[] and [RED]Chill[] for 2 seconds, and [RED]Freeze[] for 1 second to target enemy.\n\n[YELLOW]Burning[]: Deals 3.25% of maximum health every second as magic damage and increases chance to be Critically Hit by 5%.\n\n[RED]Chill[]: Decreases Movement Speed by 30%.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.", mp.a(1.315)));
    }
}

