/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jf
extends ul {
    public jf() {
        super(new ul.a().a(SpellName.CorrosiveAsp, "CorrosiveAsp", 750L, 10000L, gx.c, 225, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.dh, "NaturesFury_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -154, 3).a(1.0f, 0.0f).b(-0.25f).a(ajw.dj).b(ajw.di, "NaturesFuryImpact_on_tick", 20, 0.025f, Animation.PlayMode.NORMAL, -152, -81).b(ajw.dk).a("[WHITE]Shoots a projectile at target enemy dealing [ORANGE]%d[] magic damage and applies [YELLOW]Poison[], [YELLOW]Hobble[], for 3 seconds and [YELLOW]Blind[] for 1 seconds on impact.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.\n\n[YELLOW]Hobble:[] Slows Movement Speed by 50%.\n\n[YELLOW]Blind[]: Reduces Power by 12%.", jf.a(1.43)));
    }
}

