/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ll
extends ue {
    public ll() {
        super(new ue.a().a(SpellName.MindLeech, "MindLeech", 750L, 0L, gx.c, 235, hc.e, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.TARGETED, false, false).a(ajw.ft, "MindLeech_on_tick", 26, 0.05f, Animation.PlayMode.NORMAL, 97, 153).a(ajw.fu).a("[WHITE]Applies [RED]Mind Leech[] to target enemy for 8 seconds.\n\n[RED]Mind Leech[]: Deals [ORANGE]%d[] every second, healing the Nihilist's party for 5% of damage dealt. The amount of healing received is doubled for the Nihilist. If Mind Leech expires, all party members are healed for [ORANGE]%d[]. If dispelled, deals [ORANGE]%d[] magic damage to the dispeller.", ll.a(0.33), ll.a(0.5976), ll.a(0.85)));
    }
}

