/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ky
extends ue {
    public ky() {
        super(new ue.a().a(SpellName.LifeStream, "LifeStream", 0L, 30000L, gx.c, 370, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.eR, "LifeStream_on_tick", 27, 0.048f, Animation.PlayMode.NORMAL, 70, 41).a(ajw.eS).a("[WHITE]Applies [GREEN]Life Stream[] to target ally for 30 seconds. [GOLD]Ignores global cooldown[].\n\n[GREEN]Life Stream[]: 20% of all damage and 10% of all healing done by you also heals the [GREEN]Life Stream[] target. [RED]You can only have one Life Stream active.[]", new Object[0]));
    }
}

