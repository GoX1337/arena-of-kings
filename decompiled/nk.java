/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nk
extends ug {
    public nk() {
        super(new ug.a().a(SpellName.Judgement, "Judgement", 0L, 0L, gx.c, 230, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.hG, "Judgement_on_tick", 28, 0.03448276f, Animation.PlayMode.NORMAL, -121, -128).a(ajw.hH).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [RED]Judgement[] for 5 seconds to target and all enemies within 15 yards. Enemies struck have a 20% chance to be [YELLOW]Blind[] for 0.4 seconds.\n\n[RED]Judgement[]: Deals [ORANGE]%d[] magic damage every second.\n\n[YELLOW]Blind[]: Reduces Power by 12%.", nk.a(0.91758), nk.a(0.26322)));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

