/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kl
extends ue {
    public kl() {
        super(new ue.a().a(SpellName.Torment, "Torment", 0L, 0L, gx.c, 180, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.eq, "Torment_on_tick", 34, 0.04f, Animation.PlayMode.NORMAL, -15, -3).a(ajw.er).a("[WHITE]Applies [RED]Torment[] to target enemy for 10 seconds.\n\n[RED]Torment[]: Deals [ORANGE]%d[] magic damage every second. The amount of damage dealt increases by 6 every tick.", kl.a(0.2058)));
    }
}

