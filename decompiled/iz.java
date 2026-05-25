/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class iz
extends ue {
    public iz() {
        super(new ue.a().a(SpellName.Whirlwind, "Whirlwind", 0L, 7000L, gx.e, 0, 240, 1000L, uj.var_uj_a, uh.f, uk.var_uk_a, LocationType.NONE, true, false).a(ajw.cS, "Whirlwind_on_tick", 26, 0.045f, Animation.PlayMode.LOOP, -30, 25).a(0.4f, 1.0f).b(0.21f).a(220).a(Color.RED).a(ajw.cT).a("[WHITE]Creates a [VIOLET]Whirlwind[] around you, critically striking each nearby enemy twice for [ORANGE]%d[] physical damage. Restore health equal to 20% of the damage dealt.", iz.a(0.6), iz.a(0.6)));
    }
}

