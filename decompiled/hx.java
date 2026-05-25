/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hx
extends ue {
    public hx() {
        super(new ue.a().a(SpellName.Envenom, "skill_249", 0L, 5000L, gx.d, 20, hc.a, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a(ajw.bX, "Puncture_on_tick", 30, 0.034f, Animation.PlayMode.NORMAL, -32, -15).a(ajw.bU).a(Color.GREEN).a("[WHITE]Deals [ORANGE]%d[] physical damage and instantly applies your [GOLD]Weapon Toxins[] in addition to [YELLOW]Hobble[] for 2 seconds. Breaks [GREEN]Stealth[].\n\n[YELLOW]Weapon Toxin - Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage.\n\n[YELLOW]Weapon Toxin - Infection[]: Reduces maximum health by 10%, all healing received by 30% and deals 1% of maximum health every second as physical damage.\n\n  [GOLD]Generates 1 Combo Point.[]", hx.a(0.425)));
    }
}

