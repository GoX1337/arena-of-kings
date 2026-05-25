/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kp
extends ul {
    public kp() {
        super(new ul.a().a(SpellName.Mystic_Basic, "Mystic", 0L, 0L, gx.c, 0, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.eu, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -55, 18).b(0.2f).a(ajw.ev).b(ajw.ex).b(ajw.ew, "BasicImpact_on_tick", 20, 0.030303031f, Animation.PlayMode.NORMAL, -114, -47).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] magic damage", kp.a(0.775f)));
    }
}

