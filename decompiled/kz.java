/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kz
extends ue {
    public kz() {
        super(new ue.a().a(SpellName.LightsWrath, "BlindingGlare", 750L, 0L, gx.c, 230, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.eT, "LightsWrath_on_tick", 20, 0.034f, Animation.PlayMode.NORMAL, 47, 89).a(ajw.eU).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [YELLOW]Shock[] for 1 second to target enemy.\n\n[YELLOW]Shock[]: Amplifies all damage received by 12%.", kz.a(1.366)));
    }
}

