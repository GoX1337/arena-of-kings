/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class kh
extends uf {
    public kh() {
        super(new uf.a().a(SpellName.PoolOfSouls, "PoolOfSouls", 1000L, 8000L, gx.c, 300, hc.e, 16000L, uj.var_uj_a, uh.d, uk.d, LocationType.POSITIONAL, false, false).a(ajw.ei, "PoolOfSouls_on_tick", 15, 0.04f, Animation.PlayMode.LOOP, -367, -237).a(0.0f, 1.0f).a(240).a(ajw.ej).a("[WHITE]Creates a [VIOLET]Pool Of Souls[] at your cursor's location for 16 seconds.\n\n[VIOLET]Pool Of Souls[]Restores 1% of missing [SKY]Resource[] every second you stand in it.", new Object[0]));
    }
}

