/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jh
extends ue {
    public jh() {
        super(new ue.a().a(SpellName.Inspiration, "Inspiration", 0L, 60000L, gx.c, 0, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.dd, "Inspiration_on_tick", 27, 0.05f, Animation.PlayMode.NORMAL, 59, 16).a(ajw.de).a("[WHITE]Applies [GREEN]Inspiration[] to target ally for 10 seconds.\n\n[GREEN]Inspiration[]: Restores [ORANGE]45[] plus 2.5% of missing [SKY]Mana[] every second (95% reduced effectiveness for [SKY]Energy[] and [SKY]Rage[]).", new Object[0]));
    }
}

