/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nh
extends ue {
    public nh() {
        super(new ue.a().a(SpellName.GospelOfOnslaught, "GospelOfOnslaught", 0L, 45000L, gx.c, 185, 999, 7000L, uj.var_uj_a, uh.d, uk.d, LocationType.NONE, true, true).a(ajw.hA, "GospelOfOnslaught_on_tick", 39, 0.025641026f, Animation.PlayMode.LOOP, 4, 85).a(ajw.hB).a("[WHITE]Applies [GREEN]Gospel of Onslaught[] to all party members for 8 seconds.\n\n[GREEN]Gospel of Onslaught[]: Increases Power by 13%.", new Object[0]));
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

