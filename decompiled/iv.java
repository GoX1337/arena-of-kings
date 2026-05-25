/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class iv
extends ug {
    public iv() {
        super(new ug.a().a(SpellName.ResoundingWarcry, "ResoundingWarcry", 0L, 30000L, gx.e, 0, 600, -1L, uj.var_uj_a, uh.b, uk.d, LocationType.NONE, true, true).a(ajw.cL, "ResoundingWarcry_on_tick", 24, 0.055f, Animation.PlayMode.NORMAL, -365, -348).a(600).a(ajw.cM).a("[WHITE]Applies [GREEN]Resounding Warcry[] to all allies within 60 yards for 3 seconds. Generates 15 [SKY]Rage[] for each ally that hears the Warcry\n\n[GREEN]Resounding Warcry[]: Increases Power by 48 and reduces all damage taken by 40%.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

