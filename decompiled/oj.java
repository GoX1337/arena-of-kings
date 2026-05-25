/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oj
extends ug {
    public oj() {
        super(new ug.a().a(SpellName.Sheepify, "Sheepify", 750L, 12000L, gx.c, 175, hc.d, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.du, "Shapeshift_on_tick", 22, 0.04f, Animation.PlayMode.NORMAL, 7, 36).a(1.0f, 0.5f).a(ajw.iL).a("[WHITE]Applies [RED]Sheepify[] to target enemy for 3.2 seconds.\n\n[RED]Sheepify[]: Transform into a sheep, decreasing Movement Speed by 20% and causes you to wander aimlessly, preventing the use of abilities. Breaks upon receiving damage equal to 6% of your maximum health.", new Object[0]));
    }
}

