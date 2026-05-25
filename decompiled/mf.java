/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mf
extends ue {
    public mf() {
        super(new ue.a().a(SpellName.Purify, "Purify", 0L, 6000L, gx.c, 180, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.gg, "Purify_on_tick", 21, 0.05f, Animation.PlayMode.NORMAL, 56, 30).a(ajw.gh).a("[WHITE]Cleanses the most recently applied [YELLOW]Status Ailment[] and [RED]Debuff[] from target ally and heals [ORANGE]%d[] for each effect cleansed.\n\n [GREEN]Seal of the Heavens Bonus:[] Cleanses an additional negative effect.", mf.a(0.65)));
    }
}

