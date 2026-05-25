/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ke
extends ue {
    public ke() {
        super(new ue.a().a(SpellName.Parasite, "Parasite", 750L, 6000L, gx.c, 235, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.ed, "Parasite_on_tick", 26, 0.04f, Animation.PlayMode.NORMAL, 42, 9).a(0.8f, 1.0f).a(ajw.ee).a("[WHITE]Applies [RED]Parasite[] to target enemy for 7 seconds.\n\n[RED]Parasite[]: Steals life equal to 1.75% of maximum health every second. If dispelled, deals [ORANGE]%d[] magic damage to the player suffering from [RED]Parasite[].", ke.a(1.54)));
    }
}

