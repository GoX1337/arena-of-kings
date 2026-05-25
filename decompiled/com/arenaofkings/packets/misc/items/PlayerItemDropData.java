/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.misc.items.ItemData;

public class PlayerItemDropData
extends PlayerSnapshot {
    protected int x;
    protected int y;
    protected ItemData itemData;
    protected int itemID;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.b("new PlayerItemDropData " + this.x + " " + this.y);
        if (this.itemData.bottomFlavorText == null) {
            this.itemData.bottomFlavorText = "";
        }
        if (this.itemData.getItemSlot() != null) {
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
            if (fh2 != null && t.a(agd.class, engine)) {
                Engine.b("create item drop");
                ((agd)engine.axc_a()).aga_a().a(engine, fh2, string, this.itemID, this.x, this.y);
            }
        }
    }
}

