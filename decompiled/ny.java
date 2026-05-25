/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ny
extends uf {
    public ny() {
        super(new uf.a().a(SpellName.EyeOfTheStorm, "EyeOfTheStorm", 750L, 16000L, gx.c, 300, hc.e, 3000L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(ajw.ij, "EyeOfTheStorm_on_tick", 30, 0.04f, Animation.PlayMode.LOOP, -294, -170).a(1.0f, 0.0f).a(200).a(ajw.ik).a("[WHITE]Creates a violent [VIOLET]Eye Of The Storm[] at your cursor's location for 3 seconds.\n\n[VIOLET]Eye Of The Storm[]: Deals [ORANGE]%d[] magic damage and applies [RED]Chill[] and [YELLOW]Shock[] for 2 seconds when cast and every second thereafter.\n\n[RED]Chill[]: Decreases Movement Speed by 30%.\n\n[YELLOW]Shock[]: Amplifies all damage received by 12%.", ny.a(0.45)));
    }
}

