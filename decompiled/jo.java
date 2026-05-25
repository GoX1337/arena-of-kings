/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jo
extends ue {
    public jo() {
        super(new ue.a().a(SpellName.Soothe, "Soothe", 0L, 45000L, gx.c, 280, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.dx, "Soothe_on_tick", 30, 0.05f, Animation.PlayMode.NORMAL, 39, 22).a(ajw.dy).a("[WHITE]Critically heal target ally for [ORANGE]%d[] plus 20% of their missing Health. Heals an additional [ORANGE]%d[] for each [GREEN]Buff[] on the target. [GOLD]Ignores global cooldown[].", jo.a(1.2), jo.a(0.2238)));
    }
}

