/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nt
extends ul {
    public nt() {
        super(new ul.a().a(SpellName.Wizard_Basic, "Wizard", 0L, 0L, gx.c, 0, hc.e, 1100L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.hX, "Basic", 20, 0.025f, Animation.PlayMode.LOOP, -40, 30).a(ajw.hY).b(ajw.hZ, "BasicImpact_on_tick", 8, 0.025f, Animation.PlayMode.NORMAL, -86, -32).b(ajw.ia).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] magic damage", nt.a(0.85f)));
    }
}

