/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ok
extends ug {
    public ok() {
        super(new ug.a().a(SpellName.ShockNova, "ShockNova", 0L, 0L, gx.c, 350, 350, -1L, uj.var_uj_a, uh.var_uh_a, uk.d, LocationType.NONE, true, false).a(350).a(ajw.iM, "ShockNova_on_tick", 16, 0.04f, Animation.PlayMode.NORMAL, -122, -37).a(0.2f, 1.0f).a(0.85f).a(ajw.iN).a("[WHITE]Creates a nova of lightning around you, applying [YELLOW]Shock[] for 2 seconds and dealing [ORANGE]%d[] magic damage to all enemies within 35 yards of you.\n\n[YELLOW]Shock[]: Amplifies all damage received by 12%.", ok.a(0.77)));
    }
}

