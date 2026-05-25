/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class km
extends ue {
    public km() {
        super(new ue.a().a(SpellName.UnderworldArmor, "UnderworldArmor", 0L, 5000L, gx.c, 195, 0, 3000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.es, "UnderworldArmor_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, -32, 95).a(ajw.et).a("[WHITE]Heals you for [ORANGE]%d[] and applies [GREEN]Underworld Armor[] for 120 seconds.\n\n[GREEN]Underworld Armor[]: Reduces Physical damage taken by 8%. Restores 0.5% of maximum Health and Mana every second. Reduces the amount of health lost when performing [RED]Sacrificing[] spells by 25% and 3% [PURPLE]Lifesteal[]. All healing received from all sources is increased by 5%.\n\n[PURPLE]Lifesteal[]: Gain Health equal to a percentage of damage dealt from any source.", km.a(0.5)));
    }
}

