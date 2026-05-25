/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class in
extends ue {
    public in() {
        super(new ue.a().a(SpellName.CrushingBlow, "CrushingBlow", 0L, 18000L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a(ajw.cs, "CrushingBlow_on_tick", 25, 0.034f, Animation.PlayMode.NORMAL, 34, 12).a(ajw.ct).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Stun[] for 2 seconds to target enemy. [GOLD]Ignores global cooldown[].\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.", in.a(0.52)));
    }
}

