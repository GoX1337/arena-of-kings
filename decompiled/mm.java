/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mm
extends ue {
    public mm() {
        super(new ue.a().a(SpellName.WrathOfHeaven, "WrathOfHeaven", 0L, 15000L, gx.c, 245, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.gr, "WrathOfHeaven_on_tick", 38, 0.045f, Animation.PlayMode.NORMAL, -8, -4).a(ajw.gs).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [YELLOW]Blind[] for 1.3 seconds to target enemy and all enemies within 12 yards.\n\n[YELLOW]Blind[]: Reduces Power by 12%.", mm.a(1.4865)));
    }
}

