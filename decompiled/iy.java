/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class iy
extends ue {
    public iy() {
        super(new ue.a().a(SpellName.Sprint, "Sprint", 0L, 18000L, gx.e, 0, 0, 4000L, uj.var_uj_a, uh.b, uk.d, LocationType.NONE, true, true).a(ajw.cQ, "Sprint_on_tick", 16, 0.034f, Animation.PlayMode.LOOP, 94, 60).a(1.0f, 1.0f).a(ajw.cR).a("[WHITE]Removes all movement impairing [RED]Debuffs[], heals you for 5% of your maximum health and applies [GREEN]Sprint[] to you for 4 seconds. [GOLD]Ignores global cooldown[].\n\n[GREEN]Sprint[]: Applies a 25% [GOLD]Fading Haste[] and restores 5% (reduced by 1% every tick) health every second.", iy.a(1.3776)));
    }
}

