/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lz
extends ue {
    public lz() {
        super(new ue.a().a(SpellName.GlimmerOfLight, "skill_332", 500L, 0L, gx.c, 175, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, false, false).a(ajw.fT, "DivineLight_on_tick", 26, 0.045f, Animation.PlayMode.NORMAL, 81, 67).a(0.7f, 0.3f).a(Color.GOLD).a(ajw.fX).a("[WHITE]Heals target ally for [ORANGE]%d[]. Critical Heals cause you to be [GREEN]Enlightened[] for 6 seconds.\n\n[GREEN]Enlightenment[]: Your next [GOLD]Divine Light[] is a guaranteed Critical Strike, heals an additional 10%, and refunds 50% of the casting cost.", lz.a(1.56f)));
    }
}

