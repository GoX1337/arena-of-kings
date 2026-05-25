/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ol
extends uf {
    public ol() {
        super(new uf.a().a(SpellName.Teleport, "Teleport", 0L, 14000L, gx.c, 250, hc.f, -1L, uj.var_uj_a, uh.b, uk.d, LocationType.POSITIONAL, true, true).a(ajw.iO, "Teleport_on_tick", 25, 0.04f, Animation.PlayMode.NORMAL, -167, -90).a(850).a(ajw.iP).a("[WHITE]Teleport to your cursor's location, healing for 837 and applying [GREEN]Teleport[] for 1 seconds.\n\n[GREEN]Teleport[]: Reduces damage taken by 75%.", new Object[0]));
    }
}

