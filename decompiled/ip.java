/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ip
extends ug {
    public ip() {
        super(new ug.a().a(SpellName.EnduringWarcry, "EnduringWarcry", 0L, 16000L, gx.e, 0, 600, -1L, uj.var_uj_a, uh.b, uk.d, LocationType.NONE, true, false).a(ajw.cy, "EnduringWarcry_on_tick", 27, 0.05f, Animation.PlayMode.NORMAL, -365, -348).a(600).a(ajw.cz).a("[WHITE]Heals 7% of missing health and applies [GREEN]Enduring Warcry[] to all allies within 60 yards for 10 seconds. Generates 5 [SKY]Rage[] for each ally that hears the Warcry.\n\n[GREEN]Enduring Warcry[]: Increases maximum health by [ORANGE]%d[] and restores 2% of missing health every other second.", ip.a(1.3)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

