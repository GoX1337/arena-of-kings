/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mq
extends ul {
    public mq() {
        super(new ul.a().a(SpellName.HeadShot, "HeadShot", 1000L, 11000L, gx.d, 65, hc.e, 1950L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, false, false).a(ajw.gK, "HeadShot_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -80, 12).a(1.0f, 0.0f).a(ajw.gL).b(ajw.gM, "HeadShotImpact_on_tick", 11, 0.025f, Animation.PlayMode.NORMAL, -165, -10).b(ajw.gN).a("[WHITE]Shoots an arrow at target enemy dealing [ORANGE]%d[] physical damage, applying [YELLOW]Bleeding[] and [YELLOW]Hobble[] for 2 seconds and [YELLOW]Stun[] for 1.25 seconds.\n\n[YELLOW]Bleeding[]: Deals 1.85% of maximum health every second as true damage. Deals 1% of maximum health whenever an ability is used.\n\n[YELLOW]Hobble:[] Decreases Movement Speed by 60% and increases physical damage taken by 3%.\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.", mq.a(1.613)));
    }
}

