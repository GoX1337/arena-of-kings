/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lo
extends uf {
    public lo() {
        super(new uf.a().a(SpellName.OrbOfSmoke, "OrbOfSmoke", 0L, 8000L, gx.c, 100, hc.e, 8000L, uj.var_uj_a, uh.b, uk.d, LocationType.POSITIONAL, true, false).a(ajw.fz, "OrbOfSmoke_on_tick", 49, 0.05f, Animation.PlayMode.LOOP, -75, -80).a(1.0f, 1.0f).a(new int[0]).a().a(ajw.fA).a("[WHITE]Create an [VIOLET]Orb of Smoke[] at your cursor's location for 8 seconds.\n\n[VIOLET]Orb of Smoke[]: Reduces damage taken by 8% and increases Power by 35, Critical Strike by 6%, and 3% [PURPLE]Lifesteal[] to all allies within 50 yards. [VIOLET]Orb of Smoke[] has [ORANGE]1[] Health and can be targeted. [RED]Your party can only have one[] [VIOLET]Orb of Smoke[] [RED]active at a time.[]\n\n[PURPLE]Lifesteal[]: Gain Health equal to a percentage of damage dealt from any source.", lo.a(0.51)));
    }
}

