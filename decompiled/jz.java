/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jz
extends ue {
    public jz() {
        super(new ue.a().a(SpellName.Depravity, "Depravity", 0L, 14000L, gx.c, 230, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.dR, "Depravity_on_tick", 27, 0.04f, Animation.PlayMode.NORMAL, -30, -20).a(ajw.dS).a("[WHITE][BROWN]Interrupts[] target enemy for 3 seconds. If an ability was [BROWN]Interrupted[], applies [YELLOW]Silence[] for 2 seconds and burns [ORANGE]%d[] [SKY]Mana[] plus an additional 6% of current [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] or [SKY]Rage[]) whenever an ability is used. [GOLD]Ignores global cooldown[].\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", jz.a(0.4624)));
    }
}

