/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PlayerStatus;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.RelationshipStatus;
import com.badlogic.gdx.utils.Array;

public class PUB_FRIEND_STATUS_UPDATE
extends PublicPacket {
    public String account_name;
    public String character_name;
    public PlayerStatus playerStatus;
    public RelationshipStatus relationshipStatus;

    @Override
    public void handle(Engine engine) {
        Object object;
        Engine.a("PUB_FRIEND_STATUS_UPDATE handle() in");
        System.out.println("ToString: " + this.toString());
        if (ay.ay_a() == null) {
            return;
        }
        if (ay.ay_a().gd_a() == null) {
            return;
        }
        if (ay.ay_a().gd_a().axz_a() == null) {
            return;
        }
        if (ay.ay_a().gd_a().axz_a().a(this.account_name) == null && this.relationshipStatus != RelationshipStatus.PENDING) {
            return;
        }
        ayq ayq2 = ay.ay_a().gd_a().axz_a().a(this.account_name);
        if (this.relationshipStatus != null && this.relationshipStatus == RelationshipStatus.IGNORED) {
            for (ayq ayq3 : ay.ay_a().gd_a().axz_a().a()) {
                if (!ayq3.a().equals(this.account_name)) continue;
                ayq3.a(this.character_name);
                return;
            }
        }
        Engine.b("Update trace 1");
        if (this.relationshipStatus != null && this.relationshipStatus == RelationshipStatus.NONE) {
            Engine.b("Update trace 2");
            if (this.character_name.equals("-1")) {
                Engine.b("Update trace 3");
                object = ay.ay_a().gd_a().axz_a().a().iterator();
                Engine.b("Update trace 4");
                while (object.hasNext()) {
                    ayq ayq3;
                    Engine.b("Update trace 5");
                    ayq3 = (ayq)object.next();
                    if (!this.account_name.equals(ayq3.a())) continue;
                    Engine.b("Update trace 6");
                    object.remove();
                    Engine.b("Removing friend: " + this.account_name);
                }
                Engine.b("RETURNING");
                return;
            }
        }
        Engine.b("Update trace 7");
        if (ayq2 != null) {
            Engine.a("updating friend entry status");
            ay.ay_a().gd_a().axz_a().a(this.account_name).a(this.character_name, this.playerStatus, this.relationshipStatus);
            ((Array)((Object)ay.ay_a().gd_a().axz_a().var_azv_a)).sort();
        } else {
            Engine.a("adding new friend list entry");
            ay.ay_a().gd_a().axz_a().a(new ayq(0, this.account_name, this.character_name, this.playerStatus, this.relationshipStatus, "TODO"));
        }
        switch (this.playerStatus) {
            case AVAILABLE: {
                if (this.relationshipStatus == RelationshipStatus.PENDING) break;
                object = new PUB_MISC_CHAT_MESSAGE("[RARITY_UNCOMMON]" + this.account_name + " (" + this.character_name + ") has come online.");
                ((PUB_MISC_CHAT_MESSAGE)object).channel = ay.ay_a().gd_a().ev_a().b().java_lang_String_a();
                ((PUB_MISC_CHAT_MESSAGE)object).header = "/1 ";
                ((PUB_MISC_CHAT_MESSAGE)object).handle(engine);
                break;
            }
            case BUSY: {
                break;
            }
            case OFFLINE: {
                if (this.relationshipStatus == RelationshipStatus.PENDING) break;
                object = new PUB_MISC_CHAT_MESSAGE("[RARITY_POOR]" + this.account_name + " (" + this.character_name + ") has gone offline.");
                ((PUB_MISC_CHAT_MESSAGE)object).channel = ay.ay_a().gd_a().ev_a().b().java_lang_String_a();
                ((PUB_MISC_CHAT_MESSAGE)object).header = "/1 ";
                ((PUB_MISC_CHAT_MESSAGE)object).handle(engine);
                break;
            }
            case QUEUED: {
                break;
            }
        }
        Engine.b("herea 1");
        if (this.relationshipStatus == RelationshipStatus.PENDING) {
            Engine.b("herea 2");
            object = new PUB_MISC_CHAT_MESSAGE("[RARITY_UNCOMMON]" + this.account_name + " (" + this.character_name + ") sent a Friend Request.");
            ((PUB_MISC_CHAT_MESSAGE)object).channel = ay.ay_a().gd_a().ev_a().b().java_lang_String_a();
            ((PUB_MISC_CHAT_MESSAGE)object).header = "/1 ";
            ((PUB_MISC_CHAT_MESSAGE)object).handle(engine);
        }
        Engine.a("PUB_FRIEND_STATUS_UPDATE handle() out");
    }

    public String toString() {
        return "PUB_FRIEND_STATUS_UPDATE [account_name=" + this.account_name + ", character_name=" + this.character_name + ", playerStatus=" + (Object)((Object)this.playerStatus) + ", relationshipStatus=" + (Object)((Object)this.relationshipStatus) + "]";
    }
}

