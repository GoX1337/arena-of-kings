/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class js
extends ue {
    public js() {
        super(new ue.a().a(SpellName.Windstorm, "Windstorm", 1000L, 16000L, gx.c, 175, hc.d, 3000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.dD, "Windstorm_on_tick", 29, 0.05f, Animation.PlayMode.LOOP, -172, -90).b(-0.55f).a(ajw.dE).a("[WHITE]Applies [RED]Windstorm[] to target enemy for 3 seconds.\n\n[RED]Windstorm[]: You are immune to healing, all sources of damage, effects and cannot move or use any abilities.", new Object[0]));
    }
}

