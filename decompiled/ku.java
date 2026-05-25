/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ku
extends uf {
    public ku() {
        super(new uf.a().a(SpellName.Disenchant, "Disenchant", 500L, 8000L, gx.c, 380, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.POSITIONAL, false, false).a(250).a(ajw.eJ, "Disenchant_on_tick", 31, 0.0285f, Animation.PlayMode.NORMAL, -135, -94).a("[WHITE]After a short delay, hard dispels the most recently applied [RED]Debuff[] from allies and the most recently applied [GREEN]Buff[] from enemies within 25 yards of your cursor's location. Returns 20 Mana to you for each enemy [GREEN]Buff[] removed.", new Object[0]).a(ajw.eK));
    }
}

