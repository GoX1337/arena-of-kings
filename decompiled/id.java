/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class id
extends ue {
    public id() {
        super(new ue.a().a(SpellName.Slap, "Slap", 0L, 16000L, gx.d, 20, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.cd, "Slap_on_tick", 11, 0.04f, Animation.PlayMode.NORMAL, 25, 25).a(ajw.ce).a("[WHITE]Deals [ORANGE]%d[] physical damage and [BROWN]Interrupts[] for 2.5 seconds. If an ability was [BROWN]Interrupted[], Slap [GOLD]Generates 1 Combo Point[], deals an additional [ORANGE]%d[] physical damage, and applies [YELLOW]Silence[] for 1 second. [GOLD]Ignores global cooldown[]. Breaks [GREEN]Stealth[].\n\n[YELLOW]Silence[]: Prevents the use of abilities.\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.", id.a(0.485), id.a(0.485)));
    }
}

