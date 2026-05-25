/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ko
extends ue {
    public ko() {
        super(new ue.a().a(SpellName.AstralShock, "AstralShock", 0L, 8000L, gx.c, 225, hc.d, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.eA, "AstralShock_on_tick", 17, 0.055f, Animation.PlayMode.NORMAL, 0, 4).a(ajw.ez).a("[WHITE]Deals [ORANGE]%d[] magic damage to target enemy, applies [RED]Astral Shock[] for 4 seconds, and [BROWN]Interrupts[] for 2.5 seconds. If an ability was [BROWN]Interrupted[], applies [YELLOW]Silence[] for 1 second.\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.\n\n[RED]Astral Shock[]: Reduces Power, Armor, Magic Resist, and Movement Speed by 8%. Deals [ORANGE]%d[] magic damage every second.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", ko.a(1.1898), ko.a(0.23)));
    }
}

