/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class jp
extends ug {
    public jp() {
        super(new ug.a().a(SpellName.SpiritWolf, "SpiritWolf", 0L, 0L, gx.c, 125, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.du, "Shapeshift_on_tick", 22, 0.04f, Animation.PlayMode.NORMAL, 7, 36).a(1.0f, 0.5f).a(ajw.dv).a("[WHITE]Transform into a [GREEN]Spirit Wolf[], removing root and slowing [RED]Debuffs[]. Casting a spell breaks [GREEN]Spirit Wolf[], returning you to Human form.\n\n[GREEN]Spirit Wolf[]: While Shapeshifted increases Movement Speed by 40%, reduces Magic damage taken by 25%, and restores 1.5% of missing [SKY]Mana[] every second. You are immune to [SKY]Mana Burn[] abilities while Shapeshifted.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

