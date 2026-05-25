/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jg
extends ue {
    public jg() {
        super(new ue.a().a(SpellName.GraspingVines, "GraspingVines", 750L, 12000L, gx.c, 220, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.db, "GraspingVines_on_tick", 39, 0.05f, Animation.PlayMode.LOOP, 54, 27).a(ajw.dc).ue$a_a().a("[WHITE]Applies [RED]Grasping Vines[] to target enemy for 3 seconds.\n\n[RED]Grasping Vines[]: Disables movement and deals [ORANGE]%d[] damage per second. Breaks upon receiving damage equal to 25% of your maximum health.", jg.a(0.44)));
    }
}

