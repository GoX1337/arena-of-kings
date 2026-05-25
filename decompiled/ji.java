/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ji
extends ue {
    public ji() {
        super(new ue.a().a(SpellName.MendingSpirit, "MendingSpirit", 0L, 0L, gx.c, 210, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.df, "MendingSpirit_on_tick", 39, 0.05f, Animation.PlayMode.NORMAL, -62, 12).a(ajw.dg).a("[WHITE]Heals for [ORANGE]%d[] and applies 1 stack of [GREEN]Mending Spirit[] to target ally for 7 seconds.\n\n[GREEN]Mending Spirit[]: Heals for [ORANGE]%d[] health every second and provides 2% damage reduction. When [GREEN]Mending Spirit[] expires, heals for [ORANGE]%d[]. Stacks up to 3 times.", ji.a(0.287), ji.a(0.287), ji.a(1.28)));
    }
}

