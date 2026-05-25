/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class np
extends ue {
    public np() {
        super(new ue.a().a(SpellName.Silence, "Silence", 0L, 30000L, gx.c, 260, hc.d, 3300L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.hQ, "Silence_on_tick", 38, 0.02f, Animation.PlayMode.LOOP, 94, 135).a(1.0f, 1.0f).a(ajw.hR).a("[WHITE]Applies [YELLOW]Silence[] to target enemy for 2.5 seconds.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", new Object[0]));
    }
}

