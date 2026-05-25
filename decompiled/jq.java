/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jq
extends ue {
    public jq() {
        super(new ue.a().a(SpellName.Symbiosis, "Symbiosis", 0L, 6000L, gx.c, 395, 0, 4000L, uj.var_uj_a, uh.d, uk.d, LocationType.NONE, true, false).a(ajw.dz, "Symbiosis_on_tick", 38, 0.05f, Animation.PlayMode.LOOP, -12, -15).a(ajw.dA).a("[WHITE]Heals for [ORANGE]%d[] and applies [GREEN]Symbiosis[] to all allies for 4 seconds.\n\n[GREEN]Symbiosis[]: Heals for [ORANGE]%d[] every second. The amount healed is reduced by 54 every tick.", jq.a(0.5793), jq.a(0.5793)));
    }

    @Override
    public void void_a() {
        this.void_b();
    }
}

