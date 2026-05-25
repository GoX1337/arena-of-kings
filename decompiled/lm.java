/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lm
extends uf {
    public lm() {
        super(new uf.a().a(SpellName.OrbOfAbsolution, "OrbOfAbsolution", 0L, 14000L, gx.c, 100, hc.e, 3000L, uj.var_uj_a, uh.b, uk.d, LocationType.POSITIONAL, true, false).a(ajw.fv, "OrbOfAbsolution_on_tick", 49, 0.05f, Animation.PlayMode.LOOP, -75, -80).a(1.0f, 1.0f).a(new int[0]).a().a(ajw.fw).a(Color.YELLOW).a("[WHITE]Create an [VIOLET]Orb of Absolution[] at your cursor's location for 3 seconds.\n\n[VIOLET]Orb of Absolution[]: While not in [GREEN]Dark Inoculation[], dispel the most recently applied [RED]Debuff[] or [YELLOW]Status Ailment[] when created. Afterwards, dispel every second from allies within 35 yards. Heals that ally for [ORANGE]%d[] whenever they are cleansed. [VIOLET]Orb of Absolution[] has [ORANGE]1[] health and can be targeted. [RED]Your party can only have one[] [VIOLET]Orb of Absolution[] [RED]active at a time.[]", lm.a(0.536)));
    }
}

