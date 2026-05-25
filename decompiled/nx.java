/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nx
extends ue {
    public nx() {
        super(new ue.a().a(SpellName.Crystallize, "Crystallize", 0L, 60000L, gx.c, 0, 0, 3000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.ih, "FlashFreezeDebuff_on_tick", 30, 0.034f, Animation.PlayMode.LOOP, 12, 26).a(1.0f, 0.0f).b(0.7f).a(ajw.ii).a("[WHITE]Applies [GREEN]Crystallize[] to you for 3 seconds. [GOLD]Ignores global cooldown[].\n\n[GREEN]Crystallize[]: Covers you in ice, rendering you unable to move or cast. Cleanses all [YELLOW]Status Ailments[] and [RED]Debuffs[], providing [GOLD]Immunity[] to all hostile effects and all forms of damage. Restores a total of 65% of missing [RED]Health[] and 40% of missing [SKY]Mana[] over the duration.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

