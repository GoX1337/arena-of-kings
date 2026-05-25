/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nf
extends ue {
    public nf() {
        super(new ue.a().a(SpellName.GospelOfDefiance, "GospelOfDefiance", 0L, 12000L, gx.c, 330, 999, 4000L, uj.var_uj_a, uh.d, uk.d, LocationType.NONE, true, false).a(ajw.hw, "GospelOfDefiance_on_tick", 40, 0.035714287f, Animation.PlayMode.LOOP, -22, -15).a(0.385f, 1.0f).a(ajw.hx).a("[WHITE]Applies [GREEN]Gospel of Defiance[] to all party members for 4 seconds.\n\n[GREEN]Gospel of Defiance[]: Reduces damage taken by 25%. Deals [ORANGE]%d[] magic damge to all enemies within 12 yards every second. Explodes after receiving a total of 1000 damage, dealing [ORANGE]%d[] and applying [RED]Burning[] to all enemies within 16 yards for 2 seconds.\n\n[YELLOW]Burning[]: Deals 3.25% of maximum health every second as magic damage and increases chance to be Critically Hit by 5%.", nf.a(0.475), nf.a(0.727)));
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

