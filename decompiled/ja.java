/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ja
extends ul {
    public ja() {
        super(new ul.a().a(SpellName.Elder_Basic, "Elder", 0L, 0L, gx.c, 0, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.cU, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -40, 24).a(ajw.cV).b(ajw.cX).b(ajw.cW, "BasicImpact_on_tick", 15, 0.030303031f, Animation.PlayMode.NORMAL, -116, -47).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] magic damage", ja.a(0.7f)));
    }
}

