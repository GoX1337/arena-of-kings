/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mh
extends ue {
    public mh() {
        super(new ue.a().a(SpellName.Sanctuary, "Sanctuary", 0L, 0L, gx.var_gx_a, 0, 500, -1L, uj.var_uj_a, uh.d, uk.b, LocationType.NONE, true, true).a(ajw.gi, "Sanctuary_on_tick", 20, 0.1f, Animation.PlayMode.LOOP, 0, 0).a(0.0f, 0.0f).a("[WHITE][TEAL]Aura[]: Passively applies [GREEN]Sanctuary[] to all allies within 50 yards.\n\n[GREEN]Sanctuary[]: Reduces damage taken by 6%.", mh.a(0.1685f)));
    }
}

