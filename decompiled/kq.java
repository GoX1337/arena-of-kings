/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kq
extends ug {
    public kq() {
        super(new ug.a().a(SpellName.Blackout, "Blackout", 0L, 20000L, gx.c, 190, 250, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.NONE, true, false).a(250).a(ajw.eC, "Blackout_on_tick", 40, 0.04f, Animation.PlayMode.NORMAL, 34, 105).a(1.0f, 0.0f).a(ajw.eD).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [RED]Amnesia[] for 4 seconds and [YELLOW]Fear[] for 2.0 seconds to all enemies within 25 yards of you.\n\n[RED]Amnesia[]: Reduces Power by 12%.\n\n[YELLOW]Fear[]: Causes you to run in a random direction and prevents the use of abilities. Breaks upon receiving damage equal to 6% of your maximum health.", kq.a(1.07)));
    }
}

