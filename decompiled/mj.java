/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mj
extends ue {
    public mj() {
        super(new ue.a().a(SpellName.ShatteringSlash, "ShatteringSlash", 0L, 9000L, gx.c, 230, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.gj, "ShatteringSlash_on_tick", 26, 0.07f, Animation.PlayMode.NORMAL, -43, -45).a(ajw.gk).a("[WHITE]Deals [ORANGE]%d[] physical damage to target enemy and removes their most recently applied [GREEN]Buff[]. If a [GREEN]Buff[] was removed, deals an additional [ORANGE]476[] true damage", mj.a(1.36273), mj.a(0.585485)));
    }
}

