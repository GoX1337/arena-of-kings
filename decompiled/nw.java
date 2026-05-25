/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nw
extends ue {
    public nw() {
        super(new ue.a().a(SpellName.Counterspell, "Counterspell", 0L, 20000L, gx.c, 210, hc.d, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.id, "Counterspell_on_tick", 50, 0.034f, Animation.PlayMode.NORMAL, 25, 90).a(ajw.ie).a(0.7f, 0.3f).a("[WHITE][BROWN]Interrupts[] target enemy for 3 seconds. Applies [YELLOW]Silence[] for 1.5 second. If an ability was [BROWN]Interrupted[], instead applies [YELLOW]Silence[] for 2.5 seconds. [GOLD]Ignores global cooldown[].\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", new Object[0]));
    }
}

