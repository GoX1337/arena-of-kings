/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ly
extends ue {
    public ly() {
        super(new ue.a().a(SpellName.DivineLight, "DivineLight", 1000L, 0L, gx.c, 320, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, false, false).a(ajw.fT, "DivineLight_on_tick", 26, 0.045f, Animation.PlayMode.NORMAL, 81, 67).a(0.7f, 0.3f).a(ajw.fU).a("[WHITE]Heals target ally for [ORANGE]%d[] and applies [GREEN]Grace[] for 3 seconds. When healing an ally with [GREEN]Grace[], heals for an additional 220.\n\n[GREEN]Grace[]: Heals [ORANGE]%d[] every second.", ly.a(2.4f), ly.a(0.2706)));
    }
}

