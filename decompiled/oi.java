/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oi
extends ue {
    public oi() {
        super(new ue.a().a(SpellName.RunicShield, "RunicShield", 0L, 25000L, gx.c, 115, hc.e, 5000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.iJ, "RunicShield_on_tick", 25, 0.04f, Animation.PlayMode.LOOP, -20, 0).a(0.5f, 0.5f).a(ajw.iK).a("[WHITE]Applies [GREEN]Runic Shield[] to target ally for 5 seconds.\n\n[GREEN]Runic Shield[]: Absorbs [ORANGE]%d[] damage and reduces damage taken by 25%. Restores [ORANGE]%d[] [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] and [SKY]Rage[]) every second.", oi.a(3.58), oi.a(0.125)));
    }
}

