/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemData;

public class PUB_TRADE_ITEM_OFFER
extends PublicPacket {
    public String traderName;
    public ItemData itemData;
    public int position;

    @Override
    public void handle(Engine engine) {
        fh fh2 = null;
        switch (this.itemData.getItemSlot()) {
            case HEAD: {
                fh2 = new fv(this.itemData);
                break;
            }
            case SHOULDER: {
                fh2 = new fv(this.itemData);
                break;
            }
            case CHEST: {
                fh2 = new fv(this.itemData);
                break;
            }
            case HANDS: {
                fh2 = new fv(this.itemData);
                break;
            }
            case WRIST: {
                fh2 = new fv(this.itemData);
                break;
            }
            case LEGS: {
                fh2 = new fv(this.itemData);
                break;
            }
            case FEET: {
                fh2 = new fv(this.itemData);
                break;
            }
            case BACK: {
                fh2 = new fv(this.itemData);
                break;
            }
            case NECK: {
                fh2 = new fy(this.itemData);
                break;
            }
            case RING: {
                fh2 = new fy(this.itemData);
                break;
            }
            case TRINKET: {
                fh2 = new fy(this.itemData);
                break;
            }
            case WEAPON: {
                fh2 = new ga(this.itemData);
                break;
            }
            case CONSUMABLE: {
                fh2 = new fx(this.itemData);
                break;
            }
        }
        if (fh2 != null) {
            ay.ay_a().gd_a().ca_a().a(this.traderName, fh2, this.position);
        }
    }
}

