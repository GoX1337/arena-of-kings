/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class no
extends ue {
    public no() {
        super(new ue.a().a(SpellName.RiteOfPassage, "RiteOfPassage", 0L, 20000L, gx.c, 135, hc.f, 5000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.hO, "RiteOfPassage_on_tick", 38, 0.05f, Animation.PlayMode.LOOP, 9, 0).a(0.0f, 1.0f).a(ajw.hP).a("[WHITE]Applies [GREEN]Rite of Passage[] to target ally for 5 seconds.\n\n[GREEN]Rite of Passage[]: Increases Movement Speed by 15%. Provides [GOLD]Immunity[] to all root and slowing [RED]Debuffs[]. Heals for [ORANGE]%d[] every second.", no.a(0.417)));
    }
}

