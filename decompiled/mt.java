/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class mt
extends ue {
    public mt() {
        super(new ue.a().a(SpellName.MarkOfDeath, "MarkOfDeath", 0L, 0L, gx.var_gx_a, 0, 300, -1L, uj.var_uj_a, uh.d, uk.b, LocationType.NONE, true, true).a(ajw.gx, "Precision_on_tick", 39, 0.04f, Animation.PlayMode.LOOP, -283, -144).b(-0.15f).a(0.0f, 1.0f).a("[WHITE][TEAL]Aura[]: Passively permanently applies [RED]Mark of Death[] to all enemies within 100 yards that are below 50% Health.\n\n[RED]Mark of Death[]: You are being hunted! Being vulnerable causes you to to receive 5% increased damage from all sources. This effect is doubled when under 25% Health and tripled when under 10% Health.", new Object[0]));
    }
}

