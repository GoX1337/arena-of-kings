/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kv
extends ue {
    public kv() {
        super(new ue.a().a(SpellName.Divination, "Divination", 0L, 20000L, gx.c, 0, 0, 8000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.eL, "Divination_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, 55, 138).a(Color.WHITE).a(ajw.eM).a("[WHITE]Applies [GREEN]Divination[] to you for 8 seconds. [GOLD]Ignores global cooldown[].\n\n[GREEN]Divination[]: Causes your next damaging, healing, or protective spell to be [GOLD]Empowered[], causing all components of the spell to be 20% more effective. After empowering a spell, Divination refunds 100% of the [SKY]Mana[] cost.", kv.a(0.5)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

