/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class jc
extends ul {
    public jc() {
        super(new ul.a().a(SpellName.Bear_Charge, "skill_144", 0L, 20000L, gx.c, 0, hc.e, 1200L, 1000L, uj.var_uj_a, uh.var_uh_a, uk.var_uk_a, LocationType.TARGETED, true, true).a("[WHITE]Charge towards target enemy [BROWN]Interrupting[] for 1 second dealing [ORANGE]%d[] physical damage and applying [RED]Charge[] for 1 second. [RED]Cannot be used while Rooted[].\n\n[RED]Charge[]: Decreases Movement Speed to 0%.", jc.a(0.59)).a(ajw.cY));
        Engine.b("Charge icon: " + (Object)((Object)this.a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) + " " + this.a.java_lang_String_a());
    }

    @Override
    public void a(float f2, Engine engine) {
    }
}

