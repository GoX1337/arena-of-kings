/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mz
extends ue {
    public mz() {
        super(new ue.a().a(SpellName.RejuvinationPotion, "RejuvenationPotion", 500L, 28000L, gx.d, 0, 350, 3000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.hd, "RejuvinationPotion_on_tick", 30, 0.034f, Animation.PlayMode.LOOP, 0, 100).b(-0.45f).a(ajw.he).a("[WHITE]Heals target ally for [ORANGE]%d[] and restores 400 [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] and [SKY]Rage[]) and applies [GREEN]Rejuvenation Potion[] for 3 seconds. Can be used while moving.\n\n[GREEN]Rejuvenation Potion[]: Heals for [ORANGE]%d[] every second, and restores 75 [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] and [SKY]Rage[]) every second.", mz.a(2.7367), mz.a(0.29008)));
    }
}

