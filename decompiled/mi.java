/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mi
extends ue {
    public mi() {
        super(new ue.a().a(SpellName.Sear, "InfernalStrike", 0L, 7000L, gx.c, 270, hc.c, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.gc, "InfernalStrike_on_tick", 18, 0.05f, Animation.PlayMode.NORMAL, 19, 9).a(ajw.gd).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [RED]Sear[] for 4 seconds. If target is [YELLOW]Burning[], dealing an additional [ORANGE]%d[] magic damage for each second remaining on the [YELLOW]Burning[] duration. [GOLD]Ignores global cooldown[].\n\n[RED]Sear[]: Increases damage taken from [YELLOW]Burning[] by 20% and decreases Movement Speed by 20%.\n\n[YELLOW]Burning[]: Deals 3.25% of maximum health every second as magic damage and increases chance to be Critically Hit by 5%.", mi.a(0.7), mi.a(0.278)));
    }
}

