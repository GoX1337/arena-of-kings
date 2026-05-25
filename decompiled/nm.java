/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nm
extends ue {
    public nm() {
        super(new ue.a().a(SpellName.Mesmerize, "Mesmerize", 0L, 16000L, gx.c, 180, 220, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.NONE, true, false).a(ajw.hK, "Mesmerize_on_tick", 40, 0.04f, Animation.PlayMode.NORMAL, 36, 80).a(220).a(ajw.hL).a("[WHITE]Deals [ORANGE]%d[] and applies [YELLOW]Hobble[] for 4 seconds and [YELLOW]Incapacitate[] for 2 seconds to all enemies within 22 yards of you.\n\n[YELLOW]Hobble:[] Decreases Movement Speed by 60% and increases physical damage taken by 3%.\n\n[YELLOW]Incapacitate[]: Disables movement and prevents the use of abilities. Breaks on receiving damage.", nm.a(0.8929)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

