/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hu
extends ue {
    public hu() {
        super(new ue.a().a(SpellName.Dash, "Dash", 0L, 14000L, gx.d, 0, 0, 3000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.bO, "Dash_on_tick", 24, 0.034f, Animation.PlayMode.LOOP, 22, 2).a(0.2f, 1.0f).a(ajw.bP).ue$a_a().a("[WHITE]Removes all movement impairing [RED]Debuffs[] and applies [GREEN]Dash[] to you for 3 seconds. [GOLD]Ignores global cooldown[]. Does not break [GREEN]Stealth[].\n\n[GREEN]Dash[]: Applies a 25% [GOLD]Fading Haste[], restores 5 [SKY]Energy[] every second, and increases Armor by [ORANGE]%d[].", hu.a(0.17712)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

