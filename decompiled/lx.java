/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lx
extends ue {
    public lx() {
        super(new ue.a().a(SpellName.SealOfTheCrusader, "HeavensGuidance", 0L, 60000L, gx.c, 100, 0, 2000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.fV, "HeavensGuidance_on_tick", 15, 0.04f, Animation.PlayMode.LOOP, 90, 140).a(ajw.fS).a("[WHITE]Applies [GREEN]Crusader's Fury[] to you for 2 minutes.\n\n[GREEN]Crusader's Fury[]: Your damaging abilities deal an additional [ORANGE]120[] magic damage, restore 1% of your missing [SKY]Mana[], and have a 20% chance to cause Crusader's Fury to deal double damage. For each different damaging ability used, the effectiveness increases by 4% (maximum 20%). [RED]Reduces healing done by 30%.[]\n\n[RED]You can only have one Seal active at a time.[] Your seal cannot be dispelled.", new Object[0]));
    }
}

