/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mb
extends ue {
    public mb() {
        super(new ue.a().a(SpellName.HeavensStrike, "HeavensStrike", 0L, 24000L, gx.c, 285, hc.c, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.fY, "HeavensStrike_on_tick", 12, 0.034f, Animation.PlayMode.NORMAL, -30, 60).a(ajw.fZ).a("[WHITE]Deals [ORANGE]%d[] magic damage to target enemy and applies [YELLOW]Shock[] for 2 seconds and [YELLOW]Stun[] for 1.5 seconds.\n\n[YELLOW]Shock[]: Amplifies all damage received by 12%.\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.", mb.a(1.19065)));
    }
}

