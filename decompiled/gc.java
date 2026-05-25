/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class gc
extends fu {
    public gc() {
        this.a = ajw.la;
        this.a = new hf(SpellName.TrinketOfResolve, 0L, 60000L, gx.var_gx_a, 0, 0, -1L, uh.f, uk.d, LocationType.NONE, true, true);
        this.a(this.a, SpellName.TrinketOfResolve.name() + "_on_tick", 40, 0.034f, 0.0f, Animation.PlayMode.NORMAL, -19, 9);
        this.a = new hd(this.a, "Trinket_Of_Resolve");
        this.a(ajw.lb);
        this.a("[GREEN]Use[]: Removes all [RED]Movement Impairing[] and [RED]Crowd Control[] effects from you. Usable while [RED]Crowd Controlled[]. [GOLD]Ignores Global Cooldown[].");
    }
}

