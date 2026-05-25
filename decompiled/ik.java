/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class ik
extends ul {
    public ik() {
        super(new ul.a().a(SpellName.Charge, "Charge", 0L, 18000L, gx.e, 0, hc.c, 1200L, 1000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a("[WHITE]Charge towards target enemy dealing [ORANGE]%d[] physical damage and applying [RED]Charge[] for 1 second. You gain 25 [SKY]Rage[]. [RED]Cannot be used while Rooted[].\n\n[RED]Charge[]: Decreases Movement Speed to 0%.", ik.a(0.89)).a(ajw.cp).b(ajw.co));
    }

    @Override
    public void a(float f2, Engine engine) {
    }
}

