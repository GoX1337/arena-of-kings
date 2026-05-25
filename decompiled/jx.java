/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jx
extends ue {
    public jx() {
        super(new ue.a().a(SpellName.Contagion, "Contagion", 0L, 0L, gx.var_gx_a, 0, 500, -1L, uj.var_uj_a, uh.d, uk.b, LocationType.NONE, true, true).a(ajw.dO, "Contagion_on_tick", 16, 0.04f, Animation.PlayMode.LOOP, 0, 0).a("[WHITE][TEAL]Aura[]: Passively applies [RED]Contagion[] to all enemies within 50 yards.\n\n[RED]Contagion[]: Lowers Magic Resistance by 13%. Increases damage taken by [YELLOW]Poison[] by 6%.\n\n[YELLOW]Poison[]: Decreases Movement Speed by 15% and deals 2% of maximum health every second as true damage. Cannot be removed as a slowing effect.", new Object[0]));
    }
}

