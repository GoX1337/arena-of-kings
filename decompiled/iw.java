/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class iw
extends ul {
    public iw() {
        super(new ul.a().a(SpellName.Safeguard, "skill_339", 0L, 20000L, gx.e, 0, hc.d, 1200L, 100000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a("[WHITE]Applies [GREEN]Safeguard[] to target ally for 2 seconds. If used on an ally other than yourself, Charge towards them. You gain 15 [SKY]Rage[]. [RED]Cannot be used while Rooted[].\n\n[GREEN]Safeguard[]: Decreases damage taken by 65% and increases Movement Speed by 15%.", iw.a(0.89)).a(ajw.cp));
    }

    @Override
    public void a(float f2, Engine engine) {
    }
}

