/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class oh
extends uf {
    public oh() {
        super(new uf.a().a(SpellName.Meteor, "Meteor", 1250L, 16000L, gx.c, 300, hc.f, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(ajw.iH, "Meteor_on_tick", 36, 0.04f, Animation.PlayMode.NORMAL, -516, -253).a(220).a(ajw.iI).a(2.0f).a("[WHITE]Calls down a massive [VIOLET]Meteor[] at your cursor's location that lands after 1 second.\n\n[VIOLET]Meteor[]: Critically deals 3% maximum health plus an additional [ORANGE]%d[] physical and [ORANGE]%d[] magical damage. Applies [YELLOW]Stun[] for 1.7 seconds to all enemies within 20 yards.\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.", oh.a(1.32), oh.a(1.32)));
    }
}

