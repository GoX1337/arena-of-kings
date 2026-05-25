/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kj
extends ue {
    public kj() {
        super(new ue.a().a(SpellName.ShatterMagic, "ShatterMagic", 750L, 18000L, gx.c, 230, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.em, "ShatterMagic_on_tick", 10, 0.04f, Animation.PlayMode.NORMAL, -20, 25).a(ajw.en).a("[WHITE]Removes all [GREEN]Buffs[] from target enemy, dealing [ORANGE]%d[] magic damage for each [GREEN]Buff[] removed (maximum 2000 damage).", kj.a(0.6838)));
    }
}

