/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class io
extends ue {
    public io() {
        super(new ue.a().a(SpellName.Decapitate, "Decapitate", 0L, 15000L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.cu, "Decapitate_on_tick", 24, 0.05f, Animation.PlayMode.NORMAL, 3, -8).a(1.0f, 0.0f).a(ajw.cv).a("[WHITE]Deals [ORANGE]%d[] physical damage. While [GREEN]Enraged[], or if your target is below 20% health, Decapitate is a guaranteed Critical Strike and deals 250% more damage.", io.a(0.861)));
    }
}

