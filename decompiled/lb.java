/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lb
extends ug {
    public lb() {
        super(new ug.a().a(SpellName.SpiritForm, "SpiritForm", 0L, 45000L, gx.c, 245, hc.f, 2000L, uj.var_uj_a, uh.d, uk.d, LocationType.TARGETED, true, true).a(ajw.eX, "SpiritForm_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, -20, 2).a(ajw.eY).a("[WHITE]Target ally transcends this plane, providing [GOLD]Immunity[] to all [RED]Debuffs[] and [YELLOW]Status Ailments[] for 2.5 seconds. Casting Spirit Form applies [YELLOW]Silence[] to target ally for 1 second. Upon using an ability, [GREEN]Spirit Form[] ends. Every second and when [GREEN]Spirit Form[] ends, heals all allies within 20 yards for 15% of missing health plus an additional [ORANGE]%d[]. [GOLD]Ignores global cooldown[].\n\n[GREEN]Spirit Form[]: You are invisible to enemies and are immune to all sources of damage.\n\n[YELLOW]Silence[]: Prevents the use of abilities.", lb.a(0.9298)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

