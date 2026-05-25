/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemLink;
import com.arenaofkings.packets.misc.items.ItemLocale;
import java.util.ArrayList;
import java.util.List;

public class PUB_MISC_CHAT_MESSAGE
extends PublicPacket {
    public String channel;
    public String message;
    public String header = " ";
    public ArrayList<ItemLocale> itemData = new ArrayList();
    public String key;
    public int membershipMonths;

    public PUB_MISC_CHAT_MESSAGE() {
    }

    public PUB_MISC_CHAT_MESSAGE(String string) {
        this.message = string;
        System.out.println("DEBUG SEND MSG: " + string);
    }

    public PUB_MISC_CHAT_MESSAGE(String string, String string2) {
        this.header = string;
        this.message = string2;
    }

    public PUB_MISC_CHAT_MESSAGE(String string, String string2, String string3, List<ItemLink> list) {
        this.channel = string;
        this.header = string2;
        this.message = string3;
        if (this.itemData != null && !this.itemData.isEmpty()) {
            for (ItemLocale object : this.itemData) {
                if (object.linkLeft != 0 && object.linkRight != 0 && object.itemData != null && object.itemData.itemRarity != null && object.itemData.itemRarity.isEmpty()) continue;
                return;
            }
        }
        for (ItemLink itemLink : list) {
            Engine.b("Adding item link to msg");
            this.itemData.add(new ItemLocale(itemLink));
        }
        list.clear();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
    }

    public void setChannel(String string) {
        this.channel = string;
    }

    public void setHeader(String string) {
        this.header = string;
    }

    @Override
    public void handle(Engine engine) {
        if (this.message != null && this.message.length() > 0) {
            if (t.a(we.class, engine)) {
                Engine.b("Header: " + this.header + " Message: " + this.message);
                we we2 = (we)engine.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                wg2.a(this, this.channel, true);
            } else if (t.a(agd.class, engine) && (this.channel == null || !this.channel.startsWith("General") && !this.channel.startsWith("LFG") && !this.channel.startsWith("Help"))) {
                ((agd)engine.axc_a()).agn_a().i_a().l();
                ((agd)engine.axc_a()).agn_a().i_a().a(this, this.channel, true);
            }
            engine.a(this);
        }
    }

    public void chatHistoryHandle(Engine engine) {
        Engine.b("msg inc");
        if (this.message != null && this.message.length() > 0) {
            Engine.b("handling msg: " + this.message);
            if (t.a(we.class, engine)) {
                Engine.b("Header: " + this.header + " Message: " + this.message);
                we we2 = (we)engine.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                wg2.a(this, this.channel, true);
            } else if (t.a(agd.class, engine)) {
                if (!engine.var_aj_a.boolean_a(ai.U)) {
                    ((agd)engine.axc_a()).agn_a().i_a().l();
                }
                ((agd)engine.axc_a()).agn_a().i_a().a(this, this.channel, true);
            }
        }
    }
}

