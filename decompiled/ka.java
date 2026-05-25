/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ka
extends ue {
    public ka() {
        super(new ue.a().a(SpellName.Exhaustion, "Exhaustion", 0L, 10000L, gx.c, 230, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.dT, "Exhaustion_on_tick", 32, 0.04f, Animation.PlayMode.NORMAL, -15, -2).a(ajw.dU).a(Color.BLACK).a("[WHITE]Applies [RED]Exhaustion[] to target enemy for 4 seconds.\n\n[RED]Exhaustion[]: Reduces Power by 15% and inflicts a 50% [SALMON]Ramping Snare[].", new Object[0]));
    }
}

