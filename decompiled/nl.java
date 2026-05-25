/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nl
extends ue {
    public nl() {
        super(new ue.a().a(SpellName.LifeBurst, "LifeBurst", 0L, 4000L, gx.c, 265, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.hI, "LifeBurst_on_tick", 29, 0.03846154f, Animation.PlayMode.NORMAL, -19, -44).a(ajw.hJ).a("[WHITE]Applies [GREEN]Life Burst[] to target ally for 8 seconds.\n\n[GREEN]Life Burst[]: Heals [ORANGE]%d[] every second. The next source of damage that would deal over 400 damage is [GOLD]Absorbed[] and instantly heals for [ORANGE]%d[], causing Life Burst to expire.", nl.a(0.425), nl.a(2.0)));
    }
}

