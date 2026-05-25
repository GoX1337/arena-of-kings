/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.sct;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.sct.SCT_Event;
import com.badlogic.gdx.graphics.Color;
import java.util.Locale;

public class SCT_FloatingFeedbackText
extends SCT_Event {
    private String color;
    private String text;

    public SCT_FloatingFeedbackText() {
    }

    public SCT_FloatingFeedbackText(String string, String string2) {
        this.color = string;
        this.text = string2;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        br br2 = ay.ay_a().br_a(this.character_name);
        Engine.a("SCT_FloatingFeedbackText: " + string + " " + string + " " + this.text);
        if (br2 != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
            if (this.color.toLowerCase(Locale.US).equals("purple")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.PURPLE, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            } else if (this.color.toLowerCase(Locale.US).equals("green")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.GREEN, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            } else if (this.color.toLowerCase(Locale.US).equals("red")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.RED, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            } else if (this.color.toLowerCase(Locale.US).equals("gold")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.GOLD, false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            } else if (this.color.toLowerCase(Locale.US).equals("orange")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.ORANGE, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            } else if (this.color.toLowerCase(Locale.US).equals("white")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.WHITE, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            } else if (this.color.toLowerCase(Locale.US).equals("sky")) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, this.text, Color.SKY, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 218.0f));
            }
        }
    }
}

