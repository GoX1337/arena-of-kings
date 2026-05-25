/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oc
extends uf {
    public oc() {
        super(new uf.a().a(SpellName.Geyser, "Geyser", 0L, 20000L, gx.c, 210, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, true, true).a(ajw.iw, "Geyser_on_tick", 33, 0.04f, Animation.PlayMode.NORMAL, -192, -86).b(0.35f).a(180).a(ajw.ix).a("[WHITE]Creates a [VIOLET]Geyser[] at your cursor's location that erupts instantly.\n\n[VIOLET]Geyser[]: Deals [ORANGE]%d[] magic damage and applies [RED]Chill[] and [RED]Freeze[] for 2 seconds to all enemies within 25 yards. Cleanses [YELLOW]Burning[] from all allies in the [VIOLET]Geyser[].\n\n[RED]Chill[]: Decreases Movement Speed by 30%.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.\n\n[YELLOW]Burning[]: Deals 2.85% of target's health per second as magic damage and increases chance to be Critically Hit by 5%.", oc.a(0.257269)));
    }
}

