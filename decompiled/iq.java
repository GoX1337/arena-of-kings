/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class iq
extends ue {
    public iq() {
        super(new ue.a().a(SpellName.Enrage, "Enrage", 0L, 40000L, gx.e, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.cB, "Enrage_on_tick", 28, 0.05f, Animation.PlayMode.NORMAL, 87, 180).a(ajw.cC).a("[WHITE]Applies [GREEN]Enrage[] to you for 4 seconds and you gain 20 [SKY]Rage[].\n\n[GREEN]Enrage[]: Increases Power by 103 and all damage received by 20%. Generates 2 [SKY]Rage[] every second. Generates [SKY]Rage[] equal to 1% of the damage dealt with attacks.", new Object[0]));
    }
}

