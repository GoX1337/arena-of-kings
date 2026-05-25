/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kd
extends ul {
    public kd() {
        super(new ul.a().a(SpellName.NetherBolt, "NetherBolt", 1250L, 7000L, gx.c, 250, hc.e, 600L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.dZ, "NetherBolt_on_tick", 30, 0.025f, Animation.PlayMode.LOOP, -65, 20).a(1.0f, 0.0f).b(0.1f).b(ajw.ec, "NetherBoltImpact_on_tick", 25, 0.025f, Animation.PlayMode.NORMAL, -135, -69).a(ajw.ea).a("[WHITE]Launches a slow moving projectile toward target enemy dealing [ORANGE]%d[] magic damage on impact. Applies [RED]Malediction[] for 6 seconds.\n\n[RED]Malediction[]: Amplifies all damage taken by 8% and reduces all healing received by 20%.", kd.a(2.1)).b(ajw.eb));
    }
}

