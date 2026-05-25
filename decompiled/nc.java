/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class nc
extends uf {
    public nc() {
        super(new uf.a().a(SpellName.Armageddon, "Armageddon", 1250L, 15000L, gx.c, 315, hc.f, 4000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(ajw.hs, "Armageddon_on_tick", 24, 0.041666668f, Animation.PlayMode.LOOP, -194, -130).a(120).a(ajw.ht).a("[WHITE]Creates a fiery [VIOLET]Armageddon[] at your cursor's location for 4 seconds.\n\n[VIOLET]Armageddon[]: Deals [ORANGE]%d[] magic damage every second and applies [YELLOW]Burning[] for 2 seconds to all enemies within 27 yards.\n\n[YELLOW]Burning[]: Deals 3.25% of maximum health every second as magic damage and increases chance to be Critically Hit by 5%.", nc.a(1.37)));
    }
}

