/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ms
extends ul {
    public ms() {
        super(new ul.a().a(SpellName.LightningArrow, "LightningArrow", 0L, 12000L, gx.d, 60, hc.e, 1700L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a(ajw.gO, "LightningArrow_on_tick", 16, 0.025f, Animation.PlayMode.LOOP, -105, 18).a(1.0f, 0.0f).a(ajw.gP).b(ajw.gQ, "LightningArrowImpact_on_tick", 14, 0.025f, Animation.PlayMode.NORMAL, -104, -42).b(ajw.gR).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] magic damage on impact, removing the most recently applied [GREEN]Buff[] and applies [YELLOW]Shock[] for 3 seconds.\n\n[YELLOW]Shock[]: Amplifies all damage received by 12%.", ms.a(1.387)));
    }
}

