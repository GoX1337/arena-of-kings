/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kt
extends ue {
    public kt() {
        super(new ue.a().a(SpellName.CosmicInfusion, "skill_276", 0L, 45000L, gx.c, 0, hc.e, 7000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.eL, "Divination_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, 55, 138).a(ajw.eI).a(Color.RED).a("[WHITE]Applies [GREEN]Cosmic Infusion[] to target ally for 7 seconds. [GOLD]Ignores global cooldown[].\n\n[GREEN]Cosmic Infusion[]: Increases Magic Damage and Healing done by 12%.", new Object[0]));
    }
}

