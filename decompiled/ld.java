/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ld
extends ue {
    public ld() {
        super(new ue.a().a(SpellName.Amalgamation, "Amalgamation", 0L, 0L, gx.var_gx_a, 0, 400, -1L, uj.var_uj_a, uh.d, uk.b, LocationType.NONE, true, true).a(ajw.ff, "Amalgamation_on_tick", 30, 0.05f, Animation.PlayMode.LOOP, 0, 0).a("[WHITE][TEAL]Aura[]: Passively applies [RED]Amalgamation[] to all enemies within 40 yards.\n\nSteals 1% of health every other second. Steals an additional .5% health for every 25% of maximum health the Nihilist is missing.", new Object[0]));
    }
}

