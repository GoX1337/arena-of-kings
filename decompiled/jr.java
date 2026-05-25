/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jr
extends uf {
    public jr() {
        super(new uf.a().a(SpellName.ToxicSpore, "ToxicSpore", 0L, 6000L, gx.c, 200, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, true, false).a(ajw.dB, "ToxicSpore_on_tick", 33, 0.05f, Animation.PlayMode.NORMAL, -200, -195).a(85).a(ajw.dC).a("[WHITE]Creates a [VIOLET]Toxic Spore[] at your cursor's location that explodes after 1 second.\n\n[VIOLET]Toxic Spore[]: Deals [ORANGE]%d[] magic damage and applies [YELLOW]Poison[] to all enemies within 15 yards for 3 seconds.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", jr.a(1.3997)));
    }
}

