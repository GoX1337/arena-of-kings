/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ic
extends ue {
    public ic() {
        super(new ue.a().a(SpellName.Shroud, "Shroud", 0L, 35000L, gx.d, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.cb, "Shroud_on_tick", 39, 0.034f, Animation.PlayMode.NORMAL, -12, 26).a(0.8f, 0.2f).a(ajw.cc).a("[WHITE]Applies [GREEN]Shroud[] to you for 2 seconds. [GOLD]Ignores global cooldown[]. Does not break [GREEN]Stealth[].\n\n[GREEN]Shroud[]: Provides 90% damage reduction, makes you immune to all harmful effects, and increases healing received from all sources by 30%.", ic.a(0.2829)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

