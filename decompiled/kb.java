/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kb
extends ue {
    public kb() {
        super(new ue.a().a(SpellName.Inflame, "Inflame", 750L, 0L, gx.c, 215, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.dV, "Inflame_on_tick", 37, 0.04f, Animation.PlayMode.NORMAL, -57, -53).a(ajw.dW).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [RED]Inflame[] to target enemy for 7 seconds.\n\n[RED]Inflame[]: Deals [ORANGE]%d[] magic damage every second and has a 20% chance to apply [YELLOW]Burning[] for 1 second. Cannot be dispelled.\n\n[YELLOW]Burning[]: Deals 2.85% of target's health per second as magic damage and increases chance to be Critically Hit by 5%.", kb.a(0.78), kb.a(0.21)));
    }
}

