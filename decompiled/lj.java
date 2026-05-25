/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lj
extends ue {
    public lj() {
        super(new ue.a().a(SpellName.Karma, "Karma", 0L, 0L, gx.c, 240, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.fp, "Karma_on_tick", 30, 0.05f, Animation.PlayMode.NORMAL, 83, 153).a(ajw.fq).a("[WHITE]Applies [RED]Karma[] to target enemy for 8 seconds.\n\n[RED]Karma[]: Deals [ORANGE]%d[] magic damage every second. Steals [ORANGE]%d[] Life whenever target uses an ability.", lj.a(0.2), lj.a(0.1)));
    }
}

