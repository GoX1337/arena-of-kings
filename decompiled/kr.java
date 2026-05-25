/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kr
extends ue {
    public kr() {
        super(new ue.a().a(SpellName.BlessingSunAndMoon, "BlessingSunAndMoon", 0L, 4000L, gx.c, 225, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.eE, "BlessingSunAndMoon_on_tick", 29, 0.05f, Animation.PlayMode.NORMAL, 33, 64).a(1.0f, 0.0f).a(ajw.eF).a("[WHITE]Applies [GREEN]Blessing of the Sun and Moon[] to target ally for 8 seconds.\n\n[GREEN]Blessing of the Sun and Moon[]: Heals [ORANGE]%d[] every second and reduces all damage taken by 15%.", kr.a(0.515)));
    }
}

