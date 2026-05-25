/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jn
extends uf {
    public jn() {
        super(new uf.a().a(SpellName.Serenity, "Serenity", 750L, 10000L, gx.c, 350, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.POSITIONAL, false, false).a(ajw.ds, "Serenity_on_tick", 50, 0.1f, Animation.PlayMode.NORMAL, -385, -268).a(0.0f, 1.0f).a(250).a(ajw.dt).a("[WHITE]Creates [VIOLET]Serenity[] at your cursor's location for 4 seconds.\n\n[VIOLET]Serenity[]: Applies [GREEN]Serenity[] for 12 seconds to all allies within 40 yards.\n\n[GREEN]Serenity[]: Heals for [ORANGE]%d[] health every second.", jn.a(0.271)));
    }
}

