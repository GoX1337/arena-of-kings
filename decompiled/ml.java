/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ml
extends ue {
    public ml() {
        super(new ue.a().a(SpellName.Valor, "Valor", 0L, 40000L, gx.c, 190, hc.e, 8000L, uj.var_uj_a, uh.d, uk.d, LocationType.NONE, true, true).a(ajw.gp, "Valor_on_tick", 24, 0.04f, Animation.PlayMode.LOOP, 53, 67).a(ajw.gq).a("[WHITE]Applies [GREEN]Valor[] to you with [GOLD]9 Charges[] for 8 seconds.\n\n[GREEN]Valor[]: Provides [GOLD]Immunity[] to [YELLOW]Silence[] and [BROWN]Interrupts[]. Increases Armor and Magic Resist by [ORANGE]%d[]. [RED]Loses a [GOLD]Charge[] upon receiving 500 damage. Valor ends when out of [GOLD]Charges[].[WHITE] \n\n[YELLOW]Silence[]: Prevents the use of abilities.\n\n[BROWN]Interrupt[]: Prevents the current casting spell from being performed and locks it for a short period of time if the spell has a cooldown.", ml.a(0.625), ml.a(0.25)));
    }
}

