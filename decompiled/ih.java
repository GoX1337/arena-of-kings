/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ih
extends ug {
    public ih() {
        super(new ug.a().a(SpellName.WhirlingKnives, "WhirlingKnives", 0L, 5000L, gx.d, 45, 220, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.NONE, true, false).a(220).a(ajw.cl, "WhirlingKnives_on_tick", 29, 0.04f, Animation.PlayMode.NORMAL, 0, 0).a(0.175f).a(ajw.cm).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Bleeding[] and [YELLOW]Hobble[] for 2 seconds to all enemies within 22 yards. Damage dealt can also apply your [GOLD]Weapon Toxins[] [YELLOW]Infection[] and [YELLOW]Poison[] (30% chance). Does not break [GREEN]Stealth[].\n\n[YELLOW]Bleeding[]: Deals 1.85% of maximum health every second as true damage. Deals 1% of maximum health whenever an ability is used.\n\n  [GOLD]Generates 1 Combo Point for each enemy hit[].", ih.a(0.9f)));
    }
}

