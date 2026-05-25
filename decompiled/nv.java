/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nv
extends ue {
    public nv() {
        super(new ue.a().a(SpellName.Combust, "Combust", 0L, 3000L, gx.c, 235, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.ib, "Combust_on_tick", 26, 0.04f, Animation.PlayMode.NORMAL, 55, 50).a(ajw.ic).a("[WHITE]Deals [ORANGE]%d[] magic damage to all [YELLOW]Burning[] enemies within 16 yards of target enemy. Applies [YELLOW]Burning[] for 2 seconds to target enemy and all enemies within 14 yards that aren't already [YELLOW]Burning[]. [GOLD]Ignores global cooldown[].\n\n[YELLOW]Burning[]: Deals 2.85% of target's health per second as magic damage and increases chance to be Critically Hit by 5%.", nv.a(0.945)));
    }
}

