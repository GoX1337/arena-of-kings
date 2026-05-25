/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kn
extends ue {
    public kn() {
        super(new ue.a().a(SpellName.Aegis, "Aegis", 0L, 20000L, gx.c, 260, hc.e, 8000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.ey, "Aegis_on_tick", 26, 0.05f, Animation.PlayMode.NORMAL, 54, 105).a("[WHITE]Applies [GREEN]Aegis[] to target ally for 7 seconds.\n\n[GREEN]Aegis[]: Reduces all damage taken by 30%. Provides [GOLD]Immunity[] to the next incoming [RED]Hard Disable[]\n\n[RED]Hard Disable[]: Any debuff that prevents the use of abilities", kn.a(0.05289)).a(ajw.ez));
    }
}

