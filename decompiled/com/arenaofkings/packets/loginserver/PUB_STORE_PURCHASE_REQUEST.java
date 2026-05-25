/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.StorePayableItem;

public class PUB_STORE_PURCHASE_REQUEST
extends PublicPacket {
    private StorePayableItem storePayableItem;
    private String source;
    private String brand = "";
    private int last4 = 0;
    private int exp_month = 0;
    private int exp_year = 0;
    private String holder = "";
    private String zip = "";

    public PUB_STORE_PURCHASE_REQUEST() {
    }

    public PUB_STORE_PURCHASE_REQUEST(StorePayableItem storePayableItem, String string, String string2, int n2, int n3, int n4, String string3, String string4) {
        this.storePayableItem = storePayableItem;
        this.source = string;
        this.brand = string2;
        this.last4 = n2;
        this.exp_month = n3;
        this.exp_year = n4;
        this.holder = string3;
        this.zip = string4;
        Engine.a("new purchase request: " + this.toString());
    }

    @Override
    public void handle(Engine engine) {
    }

    public String toString() {
        return "PUB_STORE_PURCHASE_REQUEST [storePayableItem=" + this.storePayableItem + ", source=" + this.source + ", brand=" + this.brand + ", last4=" + this.last4 + ", exp_month=" + this.exp_month + ", exp_year=" + this.exp_year + ", holder=" + this.holder + ", zip=" + this.zip + "]";
    }
}

