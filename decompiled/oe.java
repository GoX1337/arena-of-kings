/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oe
extends ue {
    public oe() {
        super(new ue.a().a(SpellName.LightningStrike, "LightningStrike", 0L, 15000L, gx.c, 240, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.iA, "LightningStrike_on_tick", 13, 0.034f, Animation.PlayMode.NORMAL, -170, 90).a(ajw.iB).a("[WHITE]Deals [ORANGE]%d[] magic damage to target enemy and applies [YELLOW]Incapacitate[] and [YELLOW]Blind[] for 1.8 seconds.\n\n[YELLOW]Incapacitate[]: Disables movement and prevents the use of abilities. Breaks on receiving damage.\n\n[YELLOW]Blind[]: Reduces Power by 12%.", oe.a(1.575)));
    }
}

