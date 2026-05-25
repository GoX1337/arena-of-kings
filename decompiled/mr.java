/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mr
extends ul {
    public mr() {
        super(new ul.a().a(SpellName.TwistingShot, "HobblingArrow", 500L, 3000L, gx.d, 35, hc.e, 1600L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.gG, "HobblingArrow_on_tick", 25, 0.025f, Animation.PlayMode.LOOP, -65, 30).a(1.0f, 0.0f).a(ajw.gH).b(ajw.gI, "HobblingArrowImpact_on_tick", 12, 0.025f, Animation.PlayMode.NORMAL, -117, -41).b(ajw.gJ).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] physical damage on impact, applying [RED]Pierce[] for 3 seconds.\n\n[RED]Pierce[]: Causes the next instance of physical damage to deal an additional [ORANGE]%d[].", mr.a(1.435), mr.a(0.45)));
    }
}

