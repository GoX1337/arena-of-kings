/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jv
extends ul {
    public jv() {
        super(new ul.a().a(SpellName.Lich_Basic, "Lich", 0L, 0L, gx.c, 0, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.dF, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -36, 22).a(ajw.dG).b(ajw.dI).b(ajw.dH, "BasicImpact_on_tick", 19, 0.030303031f, Animation.PlayMode.NORMAL, -110, -56).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] magic damage", jv.a(0.85f)));
    }
}

