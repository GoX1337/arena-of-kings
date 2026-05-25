/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lp
extends uf {
    public lp() {
        super(new uf.a().a(SpellName.OrbOfWisdom, "OrbOfWisdom", 0L, 15000L, gx.c, 50, hc.e, 4000L, uj.var_uj_a, uh.b, uk.d, LocationType.POSITIONAL, true, false).a(ajw.fB, "OrbOfWisdom_on_tick", 49, 0.05f, Animation.PlayMode.LOOP, -75, -80).a(1.0f, 1.0f).a(new int[0]).a().a(ajw.fC).a("[WHITE]Create an [VIOLET]Orb of Wisdom[] at target location for 4 seconds.\n\n[VIOLET]Orb of Wisdom[]: Restores 75 [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] or [SKY]Rage[]) when created and every second thereafter to all allies within 50 yards. Amount of [SKY]Mana[] restored increases by 15 every second. [VIOLET]Orb of Wisdom[] has [ORANGE]1[] Health and can be targeted. [RED]Your party can only have one[] [VIOLET]Orb of Wisdom[] [RED]active at a time.[]", new Object[0]));
    }
}

