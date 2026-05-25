/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nu
extends ue {
    public nu() {
        super(new ue.a().a(SpellName.ChillingArmor, "ChillingArmor", 0L, 15000L, gx.c, 205, 0, 3000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.cfr_renamed_6, "ChillingArmor_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, -32, 95).a(ajw.ig).a("[WHITE]Applies [GREEN]Chilling Armor[] to you for 120 seconds.\n\n[GREEN]Chilling Armor[]: Increases Armor by 384. Restores .5% of maximum [SKY]Mana[] every second. Physical attacks that damage you for more than 500 apply [RED]Chill[] for 2 second to the attacker and have a 20% chance to [RED]Freeze[] for 2 seconds.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.", new Object[0]));
    }
}

