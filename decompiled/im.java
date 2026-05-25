/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class im
extends ue {
    public im() {
        super(new ue.a().a(SpellName.CripplingSlash, "CripplingSlash", 0L, 6000L, gx.e, 0, hc.b, -1L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a(ajw.cq, "CripplingSlash_on_tick", 26, 0.09f, Animation.PlayMode.NORMAL, 70, 55).a(ajw.cr).a("[WHITE]Deals [ORANGE]%d[] physical damage and applies [YELLOW]Hobble[] for 4 seconds to target enemy. Has a 20% chance to apply [RED]Crippling Slash[] for 2 seconds. [GOLD]Ignores global cooldown[].\n\n[YELLOW]Hobble:[] Decreases Movement Speed by 60% and increases physical damage taken by 3%.\n\n[RED]Crippling Slash[]: Decreases Movement Speed to 0%.", im.a(0.5814)));
    }
}

