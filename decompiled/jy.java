/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jy
extends uf {
    public jy() {
        super(new uf.a().a(SpellName.DeathsGrasp, "DeathsGrasp", 0L, 15000L, gx.c, 280, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, true, false).a(220).a(ajw.dP, "DeathsGrasp_on_tick", 22, 0.05f, Animation.PlayMode.NORMAL, -147, -80).a(ajw.dQ).a("[WHITE]Death's hand spawns at your cursor's location dealing [ORANGE]%d[] magic damage and applies [YELLOW]Deaths Grasp[] for 2 seconds. If an enemy is suffering from [RED]Malediction[], consume it and deal an additional 50% damage. If an enemy is below 25% health, Deaths Grasp is a guaranteed Critical Strike.\n\n[RED]Malediction[]: Amplifies all damage taken by 8% and reduces all healing received by 20%.\n\n[RED]Deaths Grasp[]: Decreases Movement Speed by 100%.", jy.a(1.22)));
    }
}

