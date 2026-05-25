/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class la
extends ue {
    public la() {
        super(new ue.a().a(SpellName.ManaTap, "ManaTap", 1000L, 0L, gx.c, 180, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.eV, "ManaTap_on_tick", 31, 0.04f, Animation.PlayMode.NORMAL, 30, 30).a(0.8f, 0.2f).a(ajw.eW).a("[WHITE]Deals [ORANGE]%d[] magic damage plus an additional 5% of target's current [SKY]Resource[] value. Burns [ORANGE]%d[] [SKY]Mana[] plus an additional 5% of target's current [SKY]Mana[] (95% reduced effectiveness for [SKY]Energy[] or [SKY]Rage[]).", la.a(1.04), la.a(0.16099)));
    }
}

