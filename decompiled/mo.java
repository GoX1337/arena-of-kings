/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mo
extends ul {
    public mo() {
        super(new ul.a().a(SpellName.Ranger_Basic, "Ranger", 0L, 0L, gx.d, 0, hc.e, 1400L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.gt, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -57, 30).a(ajw.gu).b(ajw.gw).b(ajw.gv, "BasicImpact_on_tick", 11, 0.025f, Animation.PlayMode.NORMAL, -118, -47).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] physical damage", mo.a(0.9f)));
    }
}

