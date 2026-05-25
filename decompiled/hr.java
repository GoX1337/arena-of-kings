/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hr
extends ue {
    public hr() {
        super(new ue.a().a(SpellName.Annihilate, "Annihilate", 0L, 0L, gx.d, 45, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.bK, "Annihilate_on_tick", 26, 0.034f, Animation.PlayMode.NORMAL, -22, -15).a(ajw.bL).a("[WHITE]Instantly strike your target with both daggers, dealing [ORANGE]%d[] (main-hand) and [ORANGE]%d[] (off-hand) physical damage. Your passive chance to apply [GOLD]Weapon Toxins[] is increased by 25%. Breaks [GREEN]Stealth[].\n\n[GREEN]Out of Combat Stealth Bonus:[] Annihilate deals an additional 20% damage.\n\n  [GOLD]Generates 2 Combo Points[].", hr.a(1.218), hr.a(0.609)));
    }
}

