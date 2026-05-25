/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ng
extends ue {
    public ng() {
        super(new ue.a().a(SpellName.GospelOfHarmony, "GospelOfHarmony", 1250L, 6000L, gx.c, 420, 999, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.NONE, false, false).a(ajw.hy, "GospelOfHarmony_on_tick", 22, 0.04f, Animation.PlayMode.NORMAL, -20, -30).a(ajw.hz).b(0.2f).a("[WHITE]Heals all party members for [ORANGE]%d[] and applies [GREEN]Gospel of Harmony[] to them for 8 seconds.\n\n[GREEN]Gospel of Harmony[]: Heals [ORANGE]%d[] every second.", ng.a(1.74), ng.a(0.286)));
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

