/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ne
extends ue {
    public ne() {
        super(new ue.a().a(SpellName.EtherealBindings, "EtherealBindings", 0L, 15000L, gx.c, 260, hc.d, 3000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.hu, "EtherealBindings_on_tick", 38, 0.033333335f, Animation.PlayMode.NORMAL, 24, 30).a(ajw.hv).a("[WHITE]Applies [RED]Ethereal Binding[] to target enemy for 3 seconds.\n\n[RED]Ethereal Bindings[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 30% of your maximum health.", new Object[0]));
    }
}

