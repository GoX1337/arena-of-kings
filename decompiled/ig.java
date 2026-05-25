/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ig
extends ue {
    public ig() {
        super(new ue.a().a(SpellName.TempleStrike, "TempleStrike", 0L, 13000L, gx.d, 30, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.cj, "TempleStrike_on_tick", 26, 0.04f, Animation.PlayMode.NORMAL, 34, 10).a(ajw.ck).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Incapacitate[] for 2.5 seconds. Breaks [GREEN]Stealth[].\n\n[GREEN]Out of Combat Stealth Bonus:[] Increases [YELLOW]Incapacitate[] duration by 50% and causes Temple Strike to not break [GREEN]Stealth[].\n\n[YELLOW]Incapacitate[]: Disables movement and prevents the use of abilities. Breaks on receiving damage.\n\n  [GOLD]Generates 1 Combo Point.[]", ig.a(0.6978)));
    }
}

