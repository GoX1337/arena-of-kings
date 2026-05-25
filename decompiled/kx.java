/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kx
extends ue {
    public kx() {
        super(new ue.a().a(SpellName.HealingVision, "HealingVision", 750L, 0L, gx.c, 295, hc.e, -1L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, false, false).a(ajw.eP, "HealingVision_on_tick", 38, 0.04f, Animation.PlayMode.NORMAL, 28, 42).a(0.7f, 0.3f).b(0.175f).a(ajw.eQ).a("[WHITE]Heal target ally for [ORANGE]%d[] and you for [ORANGE]%d[].", kx.a(2.942), kx.a(0.5175)));
    }
}

