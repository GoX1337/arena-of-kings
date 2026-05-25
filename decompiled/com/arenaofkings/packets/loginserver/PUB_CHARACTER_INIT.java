/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemData;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;

public class PUB_CHARACTER_INIT
extends PublicPacket {
    private CharacterClass character_class;
    private int character_outfit;
    private int character_id;
    private int character_level;
    private int character_experience;
    private String character_name;
    private ArrayList<ItemData> itemData = new ArrayList();

    @Override
    public void handle(Engine engine) {
        if (t.a(vj.class, engine)) {
            engine.var_baa_a.a(ajw.kH, 1.0f);
        }
        Array<String> array = CharacterClass.getStarterSpells(this.character_class);
        ej ej2 = new ej(engine, this.character_name, this.character_class, array.get(0), array.get(1), array.get(2), array.get(3), array.get(4), array.get(5), array.get(6), array.get(7), this.character_id, this.character_outfit, "NONE", "PE_0", "PE_0", "PE_0", this.character_level, this.character_experience, 1500, 1500, 0, 0, 0, 0, 0, 0, 0, 0, this.itemData);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().add(ej2);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().setActive_character_entity(ej2);
        ay.ay_a().gf_a().a(ay.ay_a());
        engine.var_agc_a = new agc(null);
        engine.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE("/tutorial"));
        if (engine.axc_a().getClass() != we.class) {
            engine.a(xw.class, null);
        } else {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().setActive_character_entity(ej2);
        }
    }
}

