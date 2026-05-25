/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ni
extends ue {
    public ni() {
        super(new ue.a().a(SpellName.GospelOfPurity, "GospelOfPurity", 0L, 10000L, gx.c, 360, 999, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.NONE, true, false).a(ajw.hC, "GospelOfPurity_on_tick", 40, 0.04f, Animation.PlayMode.NORMAL, 36, 33).a(ajw.hD).b(0.2f).a("[WHITE]Cleanse the most recently applied [YELLOW]Status Ailment[] or [RED]Debuff[] from all allies and heals [ORANGE]%d[] if cleaned.", ni.a(0.788)));
    }

    @Override
    public void void_a() {
        if (ay.ay_a().boolean_a(this.a)) {
            this.void_c();
        } else {
            this.d();
        }
    }
}

