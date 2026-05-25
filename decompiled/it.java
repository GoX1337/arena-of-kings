/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class it
extends ue {
    public it() {
        super(new ue.a().a(SpellName.MasterOfTheSword, "MasterOfTheSword", 0L, 10000L, gx.e, 0, 0, 1200L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.cG, "MasterOfTheSword_on_tick", 25, 0.05f, Animation.PlayMode.LOOP, 57, 105).a(ajw.cH).a("[WHITE]Applies [GREEN]Master Of The Sword[] to you for 1.6 seconds.\n\n[GREEN]Master Of The Sword[]: All damage taken is redirected to two floating blades. Upon expiration, the blades deal 25% of their stored damage to all enemies within 20 yards.", new Object[0]));
    }
}

