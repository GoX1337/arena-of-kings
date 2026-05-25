/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lt
extends ue {
    public lt() {
        super(new ue.a().a(SpellName.SpellBreaker, "SpellBreaker", 0L, 20000L, gx.c, 315, hc.f, 5000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, false).a(ajw.fJ, "SpellBreaker_on_tick", 16, 0.05f, Animation.PlayMode.LOOP, 52, 77).a(0.5f, 0.9f).a(ajw.fK).a("[WHITE]Applies [GREEN]Spell Breaker[] to target ally for 5 seconds.\n\n[GREEN]Spell Breaker[]: Absorbs [ORANGE]%d[] damage (reduced by 30% while in [GREEN]Dark Inoculation[]). Upon absorbing damage, heal for 50% of the absorbed amount.", lt.a(3.31)));
    }
}

