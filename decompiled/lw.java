/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lw
extends ue {
    public lw() {
        super(new ue.a().a(SpellName.BlazingSlash, "BlazingSlash", 0L, 4000L, gx.c, 240, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.fP, "BlazingSlash_on_tick", 21, 0.075f, Animation.PlayMode.NORMAL, 31, 23).a(ajw.fQ).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Burning[] for 2 seconds to all enemies within 20 yards.\n\n[YELLOW]Burning[]: Deals 3.25% of maximum health every second as magic damage and increases chance to be Critically Hit by 5%.", lw.a(1.22515)));
    }
}

