/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nn
extends ue {
    public nn() {
        super(new ue.a().a(SpellName.Portal, "Portal", 0L, 18000L, gx.c, 300, hc.f, -1L, uj.var_uj_a, uh.c, uk.d, LocationType.TARGETED, true, true).a(ajw.hM, "Portal_on_tick", 33, 0.05263158f, Animation.PlayMode.NORMAL, 44, -16).a(ajw.hN).b(0.2f).a("[WHITE]Swap position with your target. If your target is an enemy, [BROWN]Interrupts[] for 2 seconds and applies [RED]Portal[] for 1 second. If your target is an ally, you are both healed for [ORANGE]%d[].\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.\n\n[RED]Portal[]: Decreases Movement Speed by 66%.", nn.a(1.46)));
    }
}

