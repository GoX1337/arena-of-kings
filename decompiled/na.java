/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class na
extends ul {
    public na() {
        super(new ul.a().a(SpellName.SilencingShot, "SilencingShot", 0L, 16000L, gx.d, 30, hc.e, 1800L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a(ajw.gy, "SilencingShot_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -65, 30).a(1.0f, 0.0f).a(ajw.gz).b(ajw.gA, "SilencingShot_on_tick", 19, 0.025f, Animation.PlayMode.NORMAL, -112, -48).b(ajw.gB).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] physical damage to target and [BROWN]Interrupts[] for 3 seconds. If an ability was [BROWN]Interrupted[], applies [RED]Silence[] for 1.5 seconds and deals an additional [ORANGE]%d[] physical damage. [GOLD]Ignores global cooldown[].\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", na.a(0.69), na.a(0.69)));
    }
}

