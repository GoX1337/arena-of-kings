/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ii
extends ue {
    public ii() {
        super(new ue.a().a(SpellName.ArmorBreak, "DisruptingBlade", 0L, 16000L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a(ajw.cw, "DisruptingBlade_on_tick", 11, 0.05f, Animation.PlayMode.NORMAL, 23, 22).a(ajw.cx).a("[WHITE]Deals [ORANGE]%d[] physical damage and [BROWN]Interrupts[] for 2.5 seconds. If an ability was [BROWN]Interrupted[], deals an additional [ORANGE]%d[] physical damage, and applies [YELLOW]Silence[] for 1 second. [GOLD]Ignores global cooldown[].\n\n[YELLOW]Silence[]: Prevents the use of abilities.\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.", ii.a(0.6075), ii.a(0.543)));
    }
}

