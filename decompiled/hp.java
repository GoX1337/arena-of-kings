/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.g2d.Animation;

public class hp
extends ue {
    public hp() {
        super(new ue.a().a(SpellName.Meditate, "Meditate", 1000L, 0L, gx.var_gx_a, 0, 0, -1L, uj.var_uj_a, uh.b, uk.d, LocationType.NONE, false, false).a(ajw.ld, "Meditate_on_tick", 20, 0.025f, Animation.PlayMode.NORMAL, -100, -40).a(0.0f, 0.0f).a(ajw.le).a("[GREEN]Channel[]: After 1 second of channeling restore [SKY]250 Mana[] every second. The amount restored increases by 50 every tick.\nClasses that do not have [SKY]Mana[] restore [GREEN]500 Health[] instead, that increases by 100 every tick.\n[RED]Moving, Casting, or receiving a total of 400 damage ends Meditation.[] Channel lasts up to 10 seconds.", new Object[0]));
    }

    @Override
    public void void_a() {
        this.e();
    }
}

