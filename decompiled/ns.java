/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ns
extends ul {
    public ns() {
        super(new ul.a().a(SpellName.AganothsDescent, "AganothsDescent", 0L, 5000L, gx.c, 290, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.hV, "AganothsDescent_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -80, -130).a(1.0f, 0.0f).a(ajw.hW).b(ajw.io).b(ajw.im, "FireballImpact_on_tick", 25, 0.025f, Animation.PlayMode.NORMAL, -110, -47).a("[WHITE]Calls upon Aganoth to fly towards target enemy, exploding on impact to deal [ORANGE]%d[] magic damage to all enemies within 14 yards of the impact location. Aganoth\u2019s Descent is a guaranteed Critical Strike and refunds 50% of the casting cost for each struck enemy that was [YELLOW]Burning[].\n\n[YELLOW]Burning[]: Deals 2.85% of target's health per second as magic damage and increases chance to be Critically Hit by 5%.", ns.a(1.32)));
    }
}

