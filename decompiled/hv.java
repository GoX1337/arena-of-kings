/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hv
extends ue {
    public hv() {
        super(new ue.a().a(SpellName.Daze, "Daze", 0L, 20000L, gx.d, 25, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.bQ, "Daze_on_tick", 26, 0.04f, Animation.PlayMode.NORMAL, 28, 0).a(ajw.bR).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Stun[] based on the number of [GOLD]Combo Points[] you have. Breaks [GREEN]Stealth[].\n  1 point   [ORANGE]2.0[] seconds\n  2 point   [ORANGE]2.3[] seconds\n  3 point   [ORANGE]2.6[] seconds\n  4 point   [ORANGE]2.9[] seconds\n  5 point   [ORANGE]3.2[] seconds\n\n[GREEN]Out of Combat Stealth Bonus:[] Increases [YELLOW]Stun[] duration by 10% and applies [RED]Expose Vulnerabilities[] for 4 seconds.\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.\n\n[RED]Expose Vulnerabilities[]: Amplifies all damage taken by 8%.", hv.a(0.796208)));
    }
}

