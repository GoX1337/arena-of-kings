/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jj
extends ue {
    public jj() {
        super(new ue.a().a(SpellName.Remedy, "Remedy", 0L, 12000L, gx.c, 245, hc.e, 0L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.dl, "Remedy_on_tick", 30, 0.05f, Animation.PlayMode.NORMAL, -16, -15).a(0.7f, 1.0f).a(ajw.dm).ue$a_a().a("[WHITE]Cleanses the most recently applied [YELLOW]Status Ailment[] or [RED]Debuff[] from target ally and heals for [ORANGE]%d[] if a [YELLOW]Status Ailment[] or [RED]Debuff[] was cleansed. Applies [GREEN]Remedy[] for 6 seconds.\n\n[GREEN]Remedy[]: Every 2 seconds cleanse the most recently applied [YELLOW]Status Ailment[] or [RED]Debuff[] and heals for [ORANGE]%d[] if a [YELLOW]Status Ailment[] or [RED]Debuff[] was cleansed.", jj.a(0.7244), jj.a(0.7244)));
    }
}

