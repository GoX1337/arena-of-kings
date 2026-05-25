/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class _if
extends ug {
    public _if() {
        super(new ug.a().a(SpellName.Stealth, "Stealth", 0L, 18000L, gx.d, 0, 0, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(ajw.ch, "Stealth_on_tick", 34, 0.034f, Animation.PlayMode.NORMAL, 0, 0).a(ajw.ci).a("[WHITE]Applies [GREEN]Stealth[] to you for 12 seconds.\n\n[GREEN]Stealth[]: You are invisible to enemies and generate [GOLD]1 Combo Point[] every second. Increases [SKY]Energy Regeneration[] by 50%. After 2 seconds you leave Combat, empowering some of your attacks. Increases Movement Speed by 25%. [RED]Breaks upon receiving 500 damage.[]", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

