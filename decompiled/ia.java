/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ia
extends ue {
    public ia() {
        super(new ue.a().a(SpellName.Puncture, "skill_121", 0L, 0L, gx.d, 20, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.bX, "Puncture_on_tick", 30, 0.034f, Animation.PlayMode.NORMAL, -32, -15).a(ajw.bY).a("[WHITE]Spend all of your combo points, applying [RED]Puncture[] to target enemy for 10 seconds.\n\n[RED]Puncture[]: Deals [ORANGE]%d[] physical damage every second and restores [SKY]2 Energy[] every second. The amount of damage dealt is increased by spending more [GOLD]Combo Points[]. Cannot be dispelled.\n  1 point   [ORANGE]%d[] physical damage\n  2 points [ORANGE]%d[] physical damage\n  3 points [ORANGE]%d[] physical damage\n  4 points [ORANGE]%d[] physical damage\n  5 points [ORANGE]%d[] physical damage\n\n[GREEN]Out of Combat Stealth Bonus:[] Applies [YELLOW]Silence[] for 1-2 seconds based on the number of [GOLD]Combo Points[] you spent.", ia.a(0.069), ia.a(0.069) * 2, ia.a(0.069) * 3, ia.a(0.069) * 4, ia.a(0.069) * 5, ia.a(0.069) * 6));
    }
}

