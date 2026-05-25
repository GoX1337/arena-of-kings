/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class le
extends ul {
    public le() {
        super(new ul.a().a(SpellName.Nihilist_Basic, "Nihilist", 0L, 0L, gx.c, 0, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.fb, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -54, 19).a(ajw.fc).b(ajw.fe).b(ajw.fd, "BasicImpact_on_tick", 23, 0.030303031f, Animation.PlayMode.NORMAL, -110, -47).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] physical damage", le.a(0.835f)));
    }
}

