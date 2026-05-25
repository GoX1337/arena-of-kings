/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lk
extends ue {
    public lk() {
        super(new ue.a().a(SpellName.LingeringDemise, "LingeringDemise", 1000L, 11000L, gx.c, 295, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.fr, "LingeringDemise_on_tick", 27, 0.057f, Animation.PlayMode.NORMAL, 60, 49).a(ajw.fs).a("[WHITE]Applies [RED]Lingering Demise[] to target enemy for 7 seconds.\n\n[RED]Lingering Demise[]: Upon ending, deals [ORANGE]%d[] magic damage. If that enemy was below 20% health, Lingering Demise is a guaranteed Critical Strike. Cannot be dispelled.", 8 * lk.a(0.366)));
    }
}

