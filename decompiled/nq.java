/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nq
extends ue {
    public nq() {
        super(new ue.a().a(SpellName.TransferLife, "TransferLife", 500L, 0L, gx.c, 295, hc.f, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, false, false).a(ajw.hS, "TransferLife_on_tick", 23, 0.05263158f, Animation.PlayMode.NORMAL, 12, 6).a(ajw.hT).a("[WHITE]Heals target ally for [ORANGE]%d[]. When cast on yourself heals an additional [ORANGE]%d[], otherwise transfer 4% of your current health to target ally. Heals an additional 4% for each [GREEN]Gospel[] on target ally.", nq.a(2.56f), nq.a(0.46f)));
    }
}

