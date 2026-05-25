/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_MEMBER_CHANGE
extends PublicPacket {
    private String arenaTeamName;
    private String username;
    private boolean joined;

    @Override
    public void handle(Engine engine) {
        Engine.b("Arena Team Change " + this.arenaTeamName + " " + this.username + " " + this.joined);
        if (this.username.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getAccount_name())) {
            Engine.b("found me");
            if (this.joined) {
                if (this.arenaTeamName != null) {
                    if (t.a(agd.class, engine)) {
                        ((agd)engine.axc_a()).agn_a().i_a().a("You joined Arena Team '" + this.arenaTeamName + "'.");
                    } else if (t.a(we.class, engine)) {
                        ((we)engine.axc_a()).wh_a().wg_a().a("You joined Arena Team '" + this.arenaTeamName + "'.");
                    }
                }
            } else {
                Engine.b("i left");
                if (this.arenaTeamName != null) {
                    if (t.a(agd.class, engine)) {
                        ((agd)engine.axc_a()).agn_a().i_a().a("You left Arena Team '" + this.arenaTeamName + "'.");
                    } else if (t.a(we.class, engine)) {
                        ((we)engine.axc_a()).wh_a().wg_a().a("You left Arena Team '" + this.arenaTeamName + "'.");
                        ((we)engine.axc_a()).wh_a().zi_a().zu_a().a(this.arenaTeamName);
                    }
                    ay.ay_a().gd_a().a(this.arenaTeamName);
                }
            }
        } else if (this.joined) {
            if (this.arenaTeamName != null) {
                if (t.a(agd.class, engine)) {
                    ((agd)engine.axc_a()).agn_a().i_a().a(this.username + " has joined Arena Team '" + this.arenaTeamName + "'.");
                } else if (t.a(we.class, engine)) {
                    ((we)engine.axc_a()).wh_a().wg_a().a(this.username + " has joined Arena Team '" + this.arenaTeamName + "'.");
                }
            }
        } else if (this.arenaTeamName != null) {
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().i_a().a(this.username + " has left Arena Team '" + this.arenaTeamName + "'.");
            } else if (t.a(we.class, engine)) {
                ((we)engine.axc_a()).wh_a().wg_a().a(this.username + " has left Arena Team '" + this.arenaTeamName + "'.");
            }
        }
    }
}

