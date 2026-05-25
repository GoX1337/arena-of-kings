/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lu
extends ue {
    public lu() {
        super(new ue.a().a(SpellName.AngelicStrike, "AngelicStrike", 0L, 4000L, gx.c, 235, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.fN, "AngelicStrike_on_tick", 31, 0.048f, Animation.PlayMode.NORMAL, -11, 0).a(ajw.fO).a("[WHITE]Deals [ORANGE]%d[] physical damage. Has a 35% chance to trigger [GOLD]Angelic Favor[].\n\n[GOLD]Angelic Favor[]: Causes one of the events to occur:\n[GOLD]Justice:[] Applies a 0.8 second [YELLOW]Stun[] to target enemy.\n[GOLD]Prayer:[] Heals you for 8% of your maximum health.\n[GOLD]Insight:[] Restores 2% of missing [SKY]Mana[].\n[GOLD]Fanatacism:[] Deals 515 bonus true damage to target enemy.", lu.a(1.32)));
    }
}

