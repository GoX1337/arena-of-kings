/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jk
extends ue {
    public jk() {
        super(new ue.a().a(SpellName.Revitalize, "Revitalize", 750L, 0L, gx.c, 350, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, false, false).a(ajw.dn, "Revitalize_on_tick", 39, 0.05f, Animation.PlayMode.NORMAL, -71, -36).a(0.3f, 1.0f).a(ajw.cfr_renamed_3).a("[WHITE]Heals target ally for [ORANGE]%d[] plus an additional [ORANGE]%d[] for each [GREEN]Buff[] on the target and applies [GREEN]Revitalize[] for 8 seconds.\n\n[GREEN]Revitalize:[] Heals [ORANGE]%d[] plus an additional [ORANGE]%d[] for each [GREEN]Buff[].", jk.a(2.47), jk.a(0.145), jk.a(0.21), jk.a(0.052)));
    }
}

