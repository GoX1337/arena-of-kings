/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jb
extends ug {
    public jb() {
        super(new ug.a().a(SpellName.Bear, "skill_137", 0L, 500L, gx.c, 350, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.du, "Shapeshift_on_tick", 22, 0.04f, Animation.PlayMode.NORMAL, 7, 36).a(1.0f, 0.5f).a(ajw.dw).a("[WHITE]Transform into a [GREEN]Bear[], removing root and slowing [RED]Debuffs[]. Unleash your Feral instincts, applying [RED]Deafening Roar[] to enemies within 30 yards for 2 seconds. Casting a spell breaks [GREEN]Bear[], returning you to Human form.\n\n[RED]Deafening Roar[]: Reduces Power by 6% and Movement Speed by 15%.\n\n[GREEN]Bear[]: While shapeshifted you gain 650 Armor, 20% increased Health, and restore 4% of your missing Health every other second. Healing received from all sources is increased by 10%. You are immune to [SKY]Mana Burn[] abilities while Shapeshifted.\n[BROWN]Bear Charge[]: Charge towards target enemy interrupting their cast and immobilizing them for 1 second. [GOLD](20sec Cooldown)[]\n[BROWN]Bear Smash[]: Stuns your target for 2 seconds. [GOLD](25sec Cooldown)[]\n[BROWN]Bear Ironhide[]: Provides you with 40% damage reduction for 4 seconds. [GOLD](45sec Cooldown)[]", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

