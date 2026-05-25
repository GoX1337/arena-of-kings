/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ju
extends uf {
    public ju() {
        super(new uf.a().a(SpellName.AcidRain, "AcidRain", 750L, 8000L, gx.c, 280, hc.e, 6000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(ajw.dL, "AcidRain_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, -244, -170).a(0.0f, 1.0f).a(120).a(ajw.dM).a("[WHITE]Creates [VIOLET]Acid Rain[] at your cursor's location for 6 seconds.\n\n[VIOLET]Acid Rain[]: Deals [ORANGE]%d[] magic damage and applies [YELLOW]Poison[] for 2 seconds every second.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", ju.a(0.569)));
    }
}

