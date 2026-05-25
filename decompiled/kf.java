/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kf
extends ue {
    public kf() {
        super(new ue.a().a(SpellName.Pestilence, "Pestilence", 750L, 14000L, gx.c, 265, hc.e, 0L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.eo, "Pestilence_on_tick", 29, 0.04f, Animation.PlayMode.NORMAL, -120, -47).a(ajw.ep).ue$a_a().a("[WHITE]Applies [RED]Pestilence[] to target enemy for 7 seconds.\n\n[RED]Pestilence[]: Deals [ORANGE]%d[] magic damage every second and applies [YELLOW]Poison[] for the duration of [RED]Pestilence[]. Spreads [RED]Pestilence[] with the remaining duration to other allies within 17 yards every second. Whenever [YELLOW]Poison[] deals damage, you are healed for 30% of the amount dealt.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", kf.a(0.232)));
    }
}

