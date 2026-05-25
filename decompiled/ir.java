/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ir
extends ue {
    public ir() {
        super(new ue.a().a(SpellName.Intimidation, "Intimidation", 0L, 0L, gx.var_gx_a, 0, 300, -1L, uj.var_uj_a, uh.d, uk.b, LocationType.NONE, true, true).a(ajw.cD, "Intimidation_on_tick", 25, 0.05f, Animation.PlayMode.LOOP, 0, 0).a("[WHITE][TEAL]Aura[]: Passively applies [RED]Intimidation[] to all enemies within 30 yards.\n\n[RED]Intimidation[]: Lowers Armor by 18% and Movement Speed by 8%.", new Object[0]));
    }
}

