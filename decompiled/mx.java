/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mx
extends uf {
    public mx() {
        super(new uf.a().a(SpellName.Quicksand, "Quicksand", 0L, 22000L, gx.d, 50, 400, 6000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.hk, "Quicksand_on_tick", 25, 0.035f, Animation.PlayMode.LOOP, -232, -135).a(205).b(0.45f).a(0.0f, 1.0f).a(ajw.hl).a("[WHITE]Creates [VIOLET]Quicksand[] at your feet for 6 seconds.\n\n[VIOLET]Quicksand[]: Applies [YELLOW]Hobble[] for 2 seconds to all enemies within 40 yards every second. Has a 15% chance to apply [RED]Grasping Vines[] for 1 second.\n\n[YELLOW]Hobble:[] Decreases Movement Speed by 60% and increases physical damage taken by 3%.\n\n[RED]Grasping Vines[]: Decreases Movement Speed to 0 and deals [ORANGE]%d[] damage per second. Breaks upon receiving damage equal to 25% of your maximum health.", mx.a(0.44)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

