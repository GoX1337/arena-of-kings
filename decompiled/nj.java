/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nj
extends ue {
    public nj() {
        super(new ue.a().a(SpellName.Immortality, "Immortality", 0L, 60000L, gx.c, 250, hc.f, 4000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.hE, "Immortality_on_tick", 39, 0.035714287f, Animation.PlayMode.LOOP, -90, 17).a(0.8f, 1.0f).a(ajw.hF).a("[WHITE]Applies [GREEN]Immortality[] for 4 seconds and [RED]Ethereal[] for 60 seconds to target ally. [GOLD]Ignores global cooldown[].\n\n[GREEN]Immortality[]: Provides [GOLD]Immunity[] to all forms of damage, [RED]Debuffs[] and [YELLOW]Status Ailments[].\n\n[RED]Ethereal[]: Cannot be the target of Immortality. Cannot be dispelled.", new Object[0]));
    }
}

