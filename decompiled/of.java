/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class of
extends ul {
    public of() {
        super(new ul.a().a(SpellName.MagicMissiles, "MagicMissiles", 0L, 0L, gx.c, 240, hc.e, 1000L, 100000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.iC, "MagicMissiles_on_tick", 20, 0.025f, Animation.PlayMode.LOOP, -85, 0).a(1.0f, 0.0f).b(0.15f).a(ajw.iD).b(ajw.is).a("[WHITE]Shoots an icy projectile at target enemy dealing [ORANGE]%d[] magic damage on impact. If the target is [RED]Chilled[], deals double damage. If the target is [RED]Frozen[], deals triple damage.\n\n[RED]Freeze[]: Decreases Movement Speed to 0%. Breaks upon receiving damage equal to 20% of your maximum health.", of.a(0.75)).b(ajw.iE, "MagicMissilesImpact_on_tick", 21, 0.025f, Animation.PlayMode.NORMAL, -113, -52));
    }
}

