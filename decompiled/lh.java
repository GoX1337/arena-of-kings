/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lh
extends ue {
    public lh() {
        super(new ue.a().a(SpellName.DarkInoculation, "skill_472", 0L, 500L, gx.c, 350, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.eX, "SpiritForm_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, -20, 2).a(0.0f, 0.0f).a(Color.BLACK).a(ajw.fm).a("Commune with The Underworld, causing all offensive Spell casts to apply 1 stack of [RED]Gloom[] for 7 seconds. In addition, your shadowy presence grants you 10% Physical Damage Reduction and you restore 0.5% of maximum [SKY]Mana[] every second.\n\n[RED]Gloom[]: Deals 0.33% of maximum health every second, reduces Healing received by 5%, and increases Damage taken by 2%. Stacks up to 3 times and cannot be dispelled.\n\n[RED]Lasts until canceled or upon casting Shadow Affinity, Infuse, or Orb of Replenishment.[] Your presence cannot be dispelled.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

