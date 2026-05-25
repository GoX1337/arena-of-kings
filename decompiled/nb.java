/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nb
extends ue {
    public nb() {
        super(new ue.a().a(SpellName.Vigor, "Vigor", 0L, 20000L, gx.d, 0, 0, 1000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.hm, "Vigor_on_tick", 20, 0.04f, Animation.PlayMode.LOOP, 95, 53).a(1.0f, 1.0f).a(ajw.hn).a("[WHITE]Removes all movement impairing [RED]Debuffs[], and applies [GREEN]Vigor[] to you for 1 second. Using an attack skill breaks [GREEN]Vigor[]\n\n[GREEN]Vigor[]: You are invisible, immune to all forms of Crowd Control and damage. Movement Speed is increased by 25%.", new Object[0]));
    }
}

