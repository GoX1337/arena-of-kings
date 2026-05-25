/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class me
extends ue {
    public me() {
        super(new ue.a().a(SpellName.Prudence, "Prudence", 0L, 16000L, gx.c, 60, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, true, false).a(ajw.ge, "Prudence_on_tick", 43, 0.034f, Animation.PlayMode.NORMAL, 0, 27).a(ajw.gf).a("[WHITE]Deals [ORANGE]%d[] magic damage to target enemy and applies [RED]Prudence[] for 7 seconds.\n\n [GREEN]Seal of the Crusader Bonus:[] Applies [YELLOW]Incapacitate[] for 1 second.\n [GREEN]Seal of the Heavens Bonus:[] Restores 300 [SKY]Mana[].\n\n[RED]Prudence[]: Restore [SKY]Mana[] equal to 15% of damage dealt when dealing damage to a player suffering from [RED]Prudence[]. Ends after restoring 350 [SKY]Mana[].", me.a(1.298892)));
    }
}

