/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jl
extends ue {
    public jl() {
        super(new ue.a().a(SpellName.Ritual, "Ritual", 0L, 0L, gx.var_gx_a, 0, 800, 1000000000L, uj.var_uj_a, uh.d, uk.b, LocationType.NONE, true, true).a(ajw.dp, "Ritual_on_tick", 15, 0.05f, Animation.PlayMode.LOOP, -145, -122).a("[WHITE][TEAL]Aura[]: Passively applies [GREEN]Ritual[] to all allies within 80 yards.\n\n[GREEN]Ritual[]: Heals for 3% of missing health every 4 seconds. The amount of Health restored is doubled for the Elder while in Human form and tripled while [BROWN]Shapeshifted[].", new Object[0]));
    }
}

