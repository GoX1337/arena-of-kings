/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ls
extends ue {
    public ls() {
        super(new ue.a().a(SpellName.SiphonMana, "SiphonMana", 0L, 12000L, gx.c, 240, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.fH, "SiphonMana_on_tick", 26, 0.05f, Animation.PlayMode.NORMAL, 60, 45).a(ajw.fI).a("[WHITE]Applies [RED]Siphon Mana[] to target enemy for 7 seconds.\n\n[RED]Siphon Mana[]: Burns 1.25% of current [SKY]Mana[] every second (95% reduced effectiveness for [SKY]Energy[] or [SKY]Rage[]), dealing damage equal to 400% of the amount burned. Ally hits have [PURPLE]{Mana Rift}[].\n\n[PURPLE]{Mana Rift}[]: Steal [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] or [SKY]Rage[]) and deal additional damage equal to [PURPLE]3%[] of damage dealt.", new Object[0]));
    }
}

