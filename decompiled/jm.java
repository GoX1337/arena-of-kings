/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jm
extends ue {
    public jm() {
        super(new ue.a().a(SpellName.SeedOfLife, "SeedOfLife", 0L, 12000L, gx.c, 320, hc.e, 0L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.dq, "SeedOfLife_on_tick", 38, 0.05f, Animation.PlayMode.NORMAL, -15, -10).a(ajw.dr).ue$a_a().a("[WHITE]Applies [GREEN]Seed of Life[] to target ally for 9 seconds with 2 bounce charges.\n\n[GREEN]Seed of Life[]: Heals for [ORANGE]%d[] when applied and an additional [ORANGE]%d[] every second. Reduces all damage taken by 20%. After 3 seconds, [GREEN]Seed of Life[] bounces to the nearest, lowest health other ally within 65 yards. If there are no valid targets for a bounce, [GREEN]Seed of Life[] expires.", jm.a(0.86158), jm.a(0.38075)));
    }
}

