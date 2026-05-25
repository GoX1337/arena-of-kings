/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hw
extends ug {
    public hw() {
        super(new ug.a().a(SpellName.DisappearingAct, "DisappearingAct", 0L, 30000L, gx.d, 0, 200, -1L, uj.var_uj_a, uh.f, uk.d, LocationType.NONE, true, true).a(200).a(ajw.bS, "DustCloud_on_tick", 39, 0.034f, Animation.PlayMode.NORMAL, 0, 0).a(ajw.bT).a("[WHITE]Removes all movement impairing [RED]Debuffs[] and applies [GREEN]Empowered Stealth[] to you for 10 seconds. Applies [YELLOW]Blind[] to all enemies within 20 yards for 1.2 seconds.\n\n[GREEN]Empowered Stealth[]: You leave Combat instantly and become invisible to enemies, generating [GOLD]1 Combo Point[] every second. Increases [SKY]Energy Regeneration[] by 50%. Increases Movement Speed by 25%. [RED]Breaks upon receiving 1000 damage.[]\n\n[YELLOW]Blind[]: Reduces Power by 12%.", new Object[0]));
    }
}

