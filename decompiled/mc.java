/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mc
extends ue {
    public mc() {
        super(new ue.a().a(SpellName.HolyNova, "HolyNova", 750L, 45000L, gx.c, 450, 400, -1L, uj.var_uj_a, uh.b, uk.d, LocationType.NONE, false, false).a(ajw.ga, "HolyNova_on_tick", 20, 0.025f, Animation.PlayMode.NORMAL, -310, -230).a(ajw.gb).a("[WHITE]Deals [ORANGE]%d[] magic damage and applies [YELLOW]Burning[] for 2 seconds to all enemies within 40 yards. Heals [ORANGE]%d[] and applies [GREEN]Grace[] for 3 seconds to all allies within 40 yards.\n\n [GREEN]Seal of the Crusader Bonus:[] Applies [YELLOW]Blind[] for 1 second.\n [GREEN]Seal of the Heavens Bonus:[] Restores 350 [SKY]Mana[] for each ally hit.\n\n[YELLOW]Burning[]: Deals 3.25% of maximum health every second as magic damage and increases chance to be Critically Hit by 5%.\n\n[GREEN]Grace[]: Heals [ORANGE]%d[] every second.", mc.a(1.780288), mc.a(1.77408), mc.a(0.2706)));
    }
}

