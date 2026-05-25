/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class is
extends ue {
    public is() {
        super(new ue.a().a(SpellName.Lacerate, "Lacerate", 0L, 5000L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.cE, "Lacerate_on_tick", 26, 0.1f, Animation.PlayMode.NORMAL, 15, -17).a(ajw.cF).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Infection[] for 6 seconds to target enemy.\n\n[YELLOW]Infection[]: Reduces maximum health by 10%, all healing received by 30% and deals 1% of maximum health every second as physical damage.", is.a(1.45)));
    }
}

