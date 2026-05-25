/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hs
extends ue {
    public hs() {
        super(new ue.a().a(SpellName.Bandage, "Bandage", 0L, 6000L, gx.d, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.bM, "Bandage_on_tick", 33, 0.034f, Animation.PlayMode.NORMAL, -18, 19).a(ajw.bN).a("[WHITE]Heals you for [ORANGE]%d[] and applies [GREEN]Bandage[] for 6 seconds and removes the most recently applied [YELLOW]Status Ailment[] or [RED]Debuff[]. Does not break [GREEN]Stealth[].\n\n[GREEN]Bandage[]: Provides 10% damage reduction. Heals for [ORANGE]%d[] every second. The amount healed increases by [ORANGE]%d[] every tick. [GREEN]Bandage[] [RED]ends upon receiving 750 damage.[]", hs.a(1.3899), hs.a(0.29), hs.a(0.0713)));
    }
}

