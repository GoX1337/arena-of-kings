/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemLocation;

public class PUB_CONSUMABLE_USE
extends PublicPacket {
    public int grabItemPosition;
    public ItemLocation grabItemLocation;
    public int grabStashTabIndex;
    public int dropItemPosition;
    public ItemLocation dropItemLocation;
    public int dropStashTabIndex;
    public String callbackText;

    @Override
    public void handle(Engine engine) {
        ff ff2 = new ff(this.grabItemLocation, this.grabItemPosition);
        if (this.grabItemLocation == ItemLocation.INVENTORY) {
            ay.ay_a().gd_a().as_a().a().set(this.grabItemPosition, ff2);
        } else if (this.grabItemLocation == ItemLocation.STASH) {
            ay.ay_a().gd_a().bu_a().a(ff2, this.grabItemPosition, this.grabStashTabIndex);
        }
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            engine.var_baa_a.a(ajw.kz, 0.6f);
            if (this.callbackText != null && this.callbackText.length() > 0) {
                wg2.a(this.callbackText);
            }
        }
    }
}

