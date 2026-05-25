/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jt
extends ue {
    public jt() {
        super(new ue.a().a(SpellName.AbyssalSpike, "AbyssalSpike", 0L, 16000L, gx.c, 230, hc.c, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.dJ, "AbyssalSpike_on_tick", 22, 0.04f, Animation.PlayMode.NORMAL, -22, -32).a(ajw.dK).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [YELLOW]Stun[] for 1.2 second to target enemy. Deals an additional [ORANGE]%d[] if your target is under the effects of [YELLOW]Poison[].\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", jt.a(1.22), jt.a(0.57)));
    }
}

