/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jw
extends ue {
    public jw() {
        super(new ue.a().a(SpellName.BloodOfTheDying, "skill_130", 0L, 60000L, gx.c, 0, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.ek, "SacrificeSoul_on_tick", 30, 0.025f, Animation.PlayMode.NORMAL, -20, -7).a(ajw.dN).a("[WHITE]Restores 40% of target ally's missing Health and 20% of their missing [SKY]Mana[]. If casted on an ally other than yourself, [RED]Sacrifice[] 40% Health.[]", new Object[0]).a(Color.RED));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

