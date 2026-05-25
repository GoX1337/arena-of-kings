/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ho
extends ue {
    public ho() {
        super(new ue.a().a(SpellName.VexathrasShatter, "skill_200", 750L, 0L, gx.c, 0, hc.e, -1L, uj.b, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.em, "ShatterMagic_on_tick", 10, 0.04f, Animation.PlayMode.NORMAL, -20, 25).a(ajw.en).a(Color.PURPLE));
    }
}

