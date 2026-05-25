/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mn
extends ul {
    public mn() {
        super(new ul.a().a(SpellName.AetherShot, "AetherShot", 750L, 9000L, gx.d, 40, hc.e, 1450L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, false, false).a(ajw.gC, "AetherShot_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -65, 30).a(1.0f, 0.0f).a(ajw.gD).b(ajw.gE, "AetherShotImpact_on_tick", 30, 0.025f, Animation.PlayMode.NORMAL, -85, -26).b(ajw.gF).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] magic damage on impact and applies [RED]Aether Shot[] for 6 seconds.\n\n[RED]Aether Shot[]: Burns 25 [SKY]Mana[] plus an additional 1% of current [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] or [SKY]Rage[]) every second. Deals [ORANGE]%d[] magic damage and burns 30 [SKY]Mana[] whenever an ability is used.", mn.a(0.55), mn.a(0.21)));
    }
}

