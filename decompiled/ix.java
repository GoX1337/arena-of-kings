/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ix
extends ue {
    public ix() {
        super(new ue.a().a(SpellName.SlashingStrike, "SlashingStrike", 0L, 3000L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.cO, "SlashingStrike_on_tick", 24, 0.034f, Animation.PlayMode.NORMAL, 5, 0).a(ajw.cP).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Bleeding[] for 2 seconds to target enemy. Applies [GREEN]Bloodthirst[] to you for 6 seconds.\n\n[YELLOW]Bleeding[]: Deals 1.85% of maximum health every second as true damage. Deals 1% of maximum health whenever an ability is used.\n\n[GREEN]Bloodthirst[]: Heals for 20% of [YELLOW]Bleeding[] damage dealt.", ix.a(0.81)));
    }
}

