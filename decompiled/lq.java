/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class lq
extends uf {
    public lq() {
        super(new uf.a().a(SpellName.Rockslide, "Rockslide", 500L, 14000L, gx.c, 270, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(ajw.fD, "Rockslide_on_tick", 23, 0.05f, Animation.PlayMode.NORMAL, -239, -114).a(120).a(ajw.fE).a("[WHITE]Creates a [VIOLET]Rockslide[] at your cursor's location.\n\n[VIOLET]Rockslide[]: Deals [ORANGE]%d[] magic damage and applies [YELLOW]Stun[] for 1 second to all enemies within 20 yards.\n\n[YELLOW]Stun[]: Disables movement and prevents the use of abilities.", lq.a(1.4956)));
    }
}

