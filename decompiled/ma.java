/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ma
extends ue {
    public ma() {
        super(new ue.a().a(SpellName.SealOfTheHeavens, "CelestialProtection", 0L, 60000L, gx.c, 300, 0, 2000L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.fR, "CelestialProtection_on_tick", 18, 0.04f, Animation.PlayMode.LOOP, 0, 0).a(ajw.fW).a("[WHITE]Applies [GREEN]Heavens Guidance[] to you for 2 minutes.\n\n[GREEN]Heavens Guidance[]: Increases your Healing Power by 45% and restores 8 [SKY]Mana[] every second. Causes your Basic Attacks to restore 2% of your Party's missing health. [RED]Reduces damage dealt by 30%.[]\n\n[RED]You can only have one Seal active at a time.[] Your seal cannot be dispelled.", new Object[0]));
    }
}

