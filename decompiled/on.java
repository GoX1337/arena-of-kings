/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class on
extends uf {
    public on() {
        super(new uf.a().a(SpellName.VolcanicEruption, "VolcanicEruption", 500L, 10000L, gx.c, 240, hc.e, 3000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(ajw.iS, "VolcanicEruption_on_tick", 27, 0.04f, Animation.PlayMode.LOOP, -140, -123).a(1.0f, 1.0f).b(0.285f).a(130).a(ajw.iT).a("[WHITE]Creates an unstable [VIOLET]Volcanic Eruption[] at your cursor's location that erupts every second for 3 seconds.\n\n[VIOLET]Volcanic Eruption[]: Deals [ORANGE]%d[] magic damage to all enemies within 15 yards and applies [YELLOW]Burning[] for 1 second.\n\n[YELLOW]Burning[]: Deals 2.85% of target's health per second as magic damage and increases chance to be Critically Hit by 5%.", on.a(0.92)));
    }
}

