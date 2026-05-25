/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.client.core.Engine;

public class Target {
    private String identifying_name;
    private int ID = -1;

    public Target() {
    }

    public Target(String string) {
        this.identifying_name = string;
    }

    public Target(String string, int n2) {
        this.identifying_name = string;
        this.ID = n2;
    }

    public void setData(String string, int n2) {
        this.identifying_name = string;
        this.ID = n2;
    }

    public void setID(int n2) {
        this.ID = n2;
    }

    public br getPlayer() {
        if (this.identifying_name == "") {
            return null;
        }
        return ay.ay_a().br_a(this.identifying_name);
    }

    public ui getTargetableSpell(Engine engine) {
        Engine.a("getTargetableSpell() " + this.identifying_name + "," + this.ID);
        for (ui ui2 : ((agd)engine.axc_a()).hi_a().a()) {
            Engine.a("Checking Spell: " + ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a().name() + "," + ui2.hf_a().int_d() + " VS " + this.identifying_name + "," + this.ID);
            if (ui2.hf_a().int_d() != this.ID) continue;
            return ui2;
        }
        return null;
    }

    public void setIdentifyingName(String string) {
        this.identifying_name = string;
    }

    public void clearTarget() {
        this.identifying_name = "";
    }

    public String getIdentifyingName() {
        return this.identifying_name;
    }

    public int getID() {
        return this.ID;
    }

    public String toString() {
        return "Target [identifying_name=" + this.identifying_name + ", ID=" + this.ID + "]";
    }
}

