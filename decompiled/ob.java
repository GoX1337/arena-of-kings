/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ob
extends ul {
    public ob() {
        super(new ul.a().a(SpellName.Frostbolt, "Frostbolt", 1000L, 0L, gx.c, 200, hc.e, 1100L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.ip, "Frostbolt_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -40, 49).a(1.0f, 0.0f).b(0.15f).a(ajw.iq).b(ajw.is).b(ajw.ir, "FrostboltImpact_on_tick", 21, 0.033333335f, Animation.PlayMode.NORMAL, -110, -47).a("[WHITE]Shoots an icy projectile at target enemy dealing [ORANGE]%d[] magic damage and applies [RED]Chill[] for 2 seconds on impact. You have a 15% chance to [RED]Freeze[] for 1 second. Deals 50% more damage to [RED]Frozen[] enemies and has an additional 50% chance to Critically Strike.\n\n[RED]Chill[]: Decreases Movement Speed by 30%.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.", ob.a(1.7)));
    }
}

