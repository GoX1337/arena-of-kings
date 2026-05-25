/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class li
extends ue {
    public li() {
        super(new ue.a().a(SpellName.Infuse, "Infuse", 0L, 3000L, gx.c, 250, hc.f, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.fn, "Infuse_on_tick", 27, 0.045f, Animation.PlayMode.NORMAL, -20, 25).a(0.7f, 0.8f).a(ajw.fo).a("[WHITE]Heals target ally for [ORANGE]%d[] plus an additional 20% for each alive [VIOLET]Orb[]. Bonus healing effectiveness is reduced by 4% for each additional [VIOLET]Orb[] you have active. Additionally, provides the following bonuses to target ally for each [VIOLET]Orb[] currently placed on the battlefield.\n\n [VIOLET]Orb of Absolution[]: Dispels 1 [RED]Debuff[].\n [VIOLET]Orb of Replenishment[]: Heals for an additional 30%.\n [VIOLET]Orb of Smoke[]: Increases Movement Speed by 15% and Health by 750 for 3 seconds\n [VIOLET]Orb of Wisdom[]: Restores 200 [SKY]Mana[].\n", li.a(2.22024)));
    }
}

