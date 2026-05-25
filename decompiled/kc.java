/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kc
extends ue {
    public kc() {
        super(new ue.a().a(SpellName.Miasma, "Miasma", 0L, 4000L, gx.c, 220, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, true).a(ajw.dX, "Miasma_on_tick", 40, 0.04f, Animation.PlayMode.LOOP, -15, -5).a(ajw.dY).a("[WHITE]Applies [RED]Miasma[] for 8 seconds to target enemy. [GOLD]Ignores global cooldown[].\n\n[RED]Miasma[]: Deals [ORANGE]%d[] magic damage every second and increases damage received from all sources by [ORANGE]%d[]. If [RED]Miasma[] is dispelled, applies [YELLOW]Silence[] for 1.4 seconds.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", kc.a(0.213), kc.a(0.0258)));
    }
}

