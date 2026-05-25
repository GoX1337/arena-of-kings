/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lc
extends ue {
    public lc() {
        super(new ue.a().a(SpellName.TemporalBarrier, "TemporalBarrier", 0L, 14000L, gx.c, 270, hc.e, 7000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.eZ, "TemporalBarrier_on_tick", 10, 0.05f, Animation.PlayMode.LOOP, 32, 38).a(0.7f, 1.0f).b(0.175f).a(ajw.fa).a("[WHITE]Applies [GREEN]Temporal Barrier[] to target ally for 7 seconds. When [GREEN]Temporal Barrier[] expires, heal that ally for [ORANGE]%d[]. If [GREEN]Temporal Barrier[] depletes from absorbing damage, you are refunded 115 [SKY]Mana[] and applies [RED]Slow Time[] to enemies within 22 yards for 2 seconds.\n\n[GREEN]Temporal Barrier[]: Absorbs [ORANGE]%d[] damage and increases Movement Speed by 15%.\n\n[RED]Slow Time[]: Slows movement speed by 8%.", lc.a(0.5), lc.a(4.04)));
    }
}

