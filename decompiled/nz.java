/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nz
extends ul {
    public nz() {
        super(new ul.a().a(SpellName.Fireball, "Fireball", 1250L, 0L, gx.c, 260, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.il, "Fireball_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -55, 30).a(1.0f, 0.0f).b(0.2f).a(ajw.in).b(ajw.io).b(ajw.im, "FireballImpact_on_tick", 25, 0.025f, Animation.PlayMode.NORMAL, -110, -47).a("[WHITE]Shoots a fiery projectile that explodes at target enemy dealing [ORANGE]%d[] magic damage plus an additional 2.5% damage equal to the target's maximum health. Applies [YELLOW]Burning[] for 2 seconds on impact.\n\n[YELLOW]Burning[]: Deals 2.85% of target's health per second as magic damage and increases chance to be Critically Hit by 5%.", nz.a(1.44)));
    }
}

