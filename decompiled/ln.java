/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ln
extends uf {
    public ln() {
        super(new uf.a().a(SpellName.OrbOfReplenishment, "OrbOfReplenishment", 0L, 6000L, gx.c, 100, hc.e, 8000L, uj.var_uj_a, uh.b, uk.d, LocationType.POSITIONAL, true, false).a(ajw.fx, "OrbOfReplenishment_on_tick", 49, 0.05f, Animation.PlayMode.LOOP, -75, -80).a(1.0f, 1.0f).a(new int[0]).a().a(ajw.fy).a("[WHITE]Create an [VIOLET]Orb of Replenishment[] at your cursor's location for 8 seconds.\n\n[VIOLET]Orb of Replenishment[]: Heals for [ORANGE]%d[] when created and every second thereafter to allies within 50 yards. [VIOLET]Orb of Replenishment[] has [ORANGE]1[] health and can be targeted. [RED]Your party can only have one[] [VIOLET]Orb of Replenishment[] [RED]active at a time.[]", ln.a(0.45)));
    }
}

