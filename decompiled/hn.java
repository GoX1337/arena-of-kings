/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hn
extends ul {
    public hn() {
        super(new ul.a().a(SpellName.Fireball, "Fireball", 750L, 0L, gx.c, 280, hc.e, 1000L, 100000L, uj.b, uh.var_uh_a, uk.d, LocationType.TARGETED, false, true).a(ajw.il, "Fireball_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -55, 30).a(1.0f, 0.0f).b(0.2f).a(ajw.in).b(ajw.io).b(ajw.im, "FireballImpact_on_tick", 25, 0.025f, Animation.PlayMode.NORMAL, -110, -47).a(Color.GREEN));
    }
}

