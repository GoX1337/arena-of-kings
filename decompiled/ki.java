/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ki
extends ue {
    public ki() {
        super(new ue.a().a(SpellName.SacrificeSoul, "SacrificeSoul", 0L, 0L, gx.c, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, false).a(ajw.ek, "SacrificeSoul_on_tick", 30, 0.04f, Animation.PlayMode.NORMAL, -20, -7).a(ajw.el).a("[WHITE][RED]Sacrifice[] 8% Maximum Health in exchange for 10% [SKY]Mana[] and applies [GREEN]Sacrifice Soul[] to you for 5 seconds.\n\n[GREEN]Sacrifice Soul[]: Increases Power by 10%.", new Object[0]).a(Color.TEAL));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

