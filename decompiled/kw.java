/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kw
extends ue {
    public kw() {
        super(new ue.a().a(SpellName.DreamOfProsperity, "DreamOfProsperity", 0L, 10000L, gx.c, 300, hc.e, 0L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.eN, "DreamOfProsperity_on_tick", 38, 0.04f, Animation.PlayMode.NORMAL, 30, 110).a(ajw.eO).ue$a_a().a("[WHITE]Applies [GREEN]Dream of Prosperity[] to target ally for 7 seconds with 4 bounce charges.\n\n[GREEN]Dream of Prosperity[]: After receiving a total of 750 damage, heals for [ORANGE]%d[] and [GREEN]Dream of Prosperity[] bounces to the nearest, lowest health other ally within 85 yards. If there are no valid targets for a bounce, [GREEN]Dream of Prosperity[] expires.", kw.a(1.75)));
    }
}

