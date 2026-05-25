/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lr
extends ue {
    public lr() {
        super(new ue.a().a(SpellName.ShadowAffinity, "ShadowAffinity", 750L, 0L, gx.c, 265, hc.f, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, false, false).a(ajw.fF, "ShadowAffinity_on_tick", 31, 0.05f, Animation.PlayMode.NORMAL, 42, 54).a(0.5f, 1.0f).a(ajw.fG).a("[WHITE]Heal target ally for [ORANGE]%d[] and applies [GREEN]Shadow Affinity[] for 6 seconds.\n\n[GREEN]Shadow Affinity[]: Provides 8% [PURPLE]Lifesteal[].\n\n[PURPLE]Lifesteal[]: Gain Health equal to a percentage of damage dealt from any source.", lr.a(3.38)));
    }
}

