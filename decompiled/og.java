/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class og
extends ue {
    public og() {
        super(new ue.a().a(SpellName.MasterOfMagic, "MasterOfMagic", 0L, 12000L, gx.c, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.iF, "MasterOfMagic_on_tick", 26, 0.034f, Animation.PlayMode.LOOP, 76, 155).a(ajw.iG).a("[WHITE]Applies [GREEN]Master of Magic[] to you for 10 seconds. [GOLD]Ignores global cooldown[].\n\n[GREEN]Master of Magic[]: Increases the damage of your next spell by 20% and restores [SKY]Mana[] equal to its casting cost.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

