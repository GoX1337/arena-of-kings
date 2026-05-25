/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kg
extends ug {
    public kg() {
        super(new ug.a().a(SpellName.PoisonNova, "PoisonNova", 0L, 0L, gx.c, 300, 270, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.NONE, true, false).a(ajw.ef, "PoisonNova_on_tick", 29, 0.04f, Animation.PlayMode.NORMAL, -44, -11).a(0.95f).a(0.2f, 1.0f).a(290).a(ajw.eg).a("[WHITE]Creates a nova of poisonous death around you applying [YELLOW]Poison[] for 4 seconds to all enemies within 29 yards. Poison Nova heals you for 254 for each enemy struck. The amount healed is doubled if that enemy was already suffering from [YELLOW]Poison[].\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", kg.a(0.7245)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

