/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ib
extends ug {
    public ib() {
        super(new ug.a().a(SpellName.ShadowWalk, "ShadowWalk", 0L, 20000L, gx.d, 15, hc.d, -1L, uj.var_uj_a, uh.c, uk.d, LocationType.TARGETED, true, true).a(ajw.bZ, "ShadowWalk_on_tick", 42, 0.034f, Animation.PlayMode.NORMAL, 0, 0).a(ajw.ca).a("[WHITE]Teleport to target and applies [GREEN]Dash[] to you for 2 seconds. [GOLD]Ignores global cooldown[]. Does not break [GREEN]Stealth[].\n\n[GREEN]Dash[]: Applies a 25% [GOLD]Fading Haste[], restores 5 [SKY]Energy[] every second, and increases Armor by [ORANGE]%d[].", ib.a(0.17712)));
    }
}

