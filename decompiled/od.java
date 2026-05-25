/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class od
extends ue {
    public od() {
        super(new ue.a().a(SpellName.IceSpikes, "IceSpikes", 0L, 20000L, gx.c, 220, hc.d, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.iy, "IceSpikes_on_tick", 28, 0.05f, Animation.PlayMode.NORMAL, 25, 39).b(0.3f).a(1.0f, 0.2f).a(ajw.iz).a(1.5f).a("[WHITE]Deals [ORANGE]%d[] magic damage to target enemy and applies [RED]Hypothermia[] for 3 seconds. If your target is [RED]Frozen[], this spell is a guaranteed Critical Strike and applies [YELLOW]Stun[] and [RED]Freeze[] for 1.6 seconds.\n\n[RED]Hypothermia[]: Amplifies all damage taken by 4%, prevents movement, and reduces healing received by 20%. Hypothermia counts as a Chill effect.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.", od.a(1.14)));
    }
}

