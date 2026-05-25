/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nd
extends ul {
    public nd() {
        super(new ul.a().a(SpellName.Scholar_Basic, "Scholar", 0L, 0L, gx.c, 0, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.ho, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -40, 29).b(0.2f).a(ajw.hp).b(ajw.hr).b(ajw.hq, "BasicImpact_on_tick", 15, 0.030303031f, Animation.PlayMode.NORMAL, -115, -47).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] magic damage", nd.a(0.7f)));
    }
}

