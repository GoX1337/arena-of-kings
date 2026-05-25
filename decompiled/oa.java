/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oa
extends ug {
    public oa() {
        super(new ug.a().a(SpellName.FlashFreeze, "FlashFreeze", 0L, 14000L, gx.c, 240, 350, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.NONE, true, false).a(350).a(ajw.it, "FlashFreeze_on_tick", 26, 0.05f, Animation.PlayMode.NORMAL, -110, -20).a(0.2f, 1.0f).a(0.95f).a(ajw.iu).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [RED]Freeze[] for 3 seconds to all enemies within 35 yards of you.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.", oa.a(1.16)));
    }
}

