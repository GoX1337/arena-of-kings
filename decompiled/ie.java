/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ie
extends ue {
    public ie() {
        super(new ue.a().a(SpellName.Slash, "Slash", 0L, 0L, gx.d, 35, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.cf, "Slash_on_tick", 24, 0.034f, Animation.PlayMode.NORMAL, -8, 30).a(ajw.cg).a("[WHITE]Spend all of your combo points to deal [ORANGE]%d[] physical damage. The amount of damage dealt is increased by spending more [GOLD]Combo Points[].\n  1 point   [ORANGE]%d[] physical damage\n  2 points [ORANGE]%d[] physical damage\n  3 points [ORANGE]%d[] physical damage\n  4 points [ORANGE]%d[] physical damage\n  5 points [ORANGE]%d[] physical damage\n\n[GREEN]Out of Combat Stealth Bonus:[] Deals 15% additional damage.", ie.a(1.0), ie.a(0.18) + ie.a(0.025), ie.a(0.18) * 2 + ie.a(0.025) * 2, ie.a(0.18) * 3 + ie.a(0.025) * 3, ie.a(0.18) * 4 + ie.a(0.025) * 4, ie.a(0.18) * 5 + ie.a(0.025) * 5));
    }
}

