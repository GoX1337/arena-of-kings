/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hy
extends ue {
    public hy() {
        super(new ue.a().a(SpellName.MurderousInstincts, "MurderousInstincts", 0L, 45000L, gx.d, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.bV, "MurderousInstincts_on_tick", 9, 0.06f, Animation.PlayMode.NORMAL, 30, 95).a(ajw.bW).a("[GOLD]Your mind expands from a memory of mastery and perfection.[]\n\nFor 5 seconds your [GREEN]Stealth[] detection is greatly improved\u2661. Increases your Power by 13% and Critical Strike rating by 50%. Restores 10 [SKY]Energy[] every second.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

