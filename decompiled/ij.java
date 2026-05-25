/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ij
extends ue {
    public ij() {
        super(new ue.a().a(SpellName.Champion_Basic, "Champion", 0L, 0L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, false).a(ajw.cn, "Basic", 10, 0.034f, Animation.PlayMode.NORMAL, 10, 45).a(ajw.co).a("Instantly strike your target dealing [ORANGE]%d[] physical damage. Generates 2-6 [RED]Rage[].\n\n[GREEN](Passive) Enrage[]: When reaching 100 [RED]Rage[] increases your Power by 10% and provides [GOLD]Immunity to Slows[]. The Enrage period depletes over 4 seconds.", ij.a(1.12f)));
    }
}

