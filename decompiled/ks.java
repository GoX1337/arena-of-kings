/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ks
extends ue {
    public ks() {
        super(new ue.a().a(SpellName.Cleanse, "Cleanse", 0L, 7000L, gx.c, 230, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.eG, "Cleanse_on_tick", 35, 0.04f, Animation.PlayMode.NORMAL, -27, 17).a(0.7f, 0.3f).a(ajw.eH).a("[WHITE]Cleanse up to 3 total [YELLOW]Status Ailments[] and/or [RED]Debuffs[] from target ally. For each effect cleansed that ally is healed for [ORANGE]%d[]. ", ks.a(0.561)));
    }
}

