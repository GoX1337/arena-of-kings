/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lf
extends uf {
    public lf() {
        super(new uf.a().a(SpellName.Blink, "Blink", 0L, 9000L, gx.c, 200, hc.f, -1L, uj.var_uj_a, uh.b, uk.d, LocationType.POSITIONAL, true, true).a(ajw.fg, "Blink_on_tick", 25, 0.045f, Animation.PlayMode.NORMAL, -144, -60).a(0.35f, 1.0f).a(850).a(ajw.fh).a("[WHITE]Teleport to your cursor's location dealing [ORANGE]%d[] magic damage to all enemies within 12 yards. [RED]Deals 900 magic damage to the Nihilist when cast[].", lf.a(0.957)));
    }
}

