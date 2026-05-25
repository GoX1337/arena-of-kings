/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemLocation;
import java.util.Collections;

public class PUB_ITEM_MOVE_REQUEST
extends PublicPacket {
    public int grabItemPosition;
    public ItemLocation grabItemLocation;
    public int grabStashTabIndex;
    public int dropItemPosition;
    public ItemLocation dropItemLocation;
    public int dropStashTabIndex;

    @Override
    public void handle(Engine engine) {
        fm fm2 = null;
        fm fm3 = null;
        am am2 = null;
        switch (this.grabItemLocation) {
            case EQUIPPED: {
                am2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().am_a(this.grabItemPosition);
                for (am am3 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                    if (am3.fh_a().int_a() != this.grabItemPosition) continue;
                    fm2 = am3.fh_a();
                }
                break;
            }
            case GROUND: {
                break;
            }
            case INVENTORY: {
                fm2 = ay.ay_a().gd_a().as_a().a().get(this.grabItemPosition);
                break;
            }
            case STASH: {
                fm2 = ay.ay_a().gd_a().bu_a().fm_a(this.grabStashTabIndex, this.grabItemPosition);
                break;
            }
        }
        switch (this.dropItemLocation) {
            case EQUIPPED: {
                am2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().am_a(this.dropItemPosition);
                for (am am3 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                    if (am3.fh_a().int_a() != this.dropItemPosition) continue;
                    fm3 = am3.fh_a();
                }
                break;
            }
            case GROUND: {
                break;
            }
            case INVENTORY: {
                fm3 = ay.ay_a().gd_a().as_a().a().get(this.dropItemPosition);
                break;
            }
            case STASH: {
                fm3 = ay.ay_a().gd_a().bu_a().fm_a(this.dropStashTabIndex, this.dropItemPosition);
                break;
            }
        }
        Engine.b("received: " + this.toString());
        if (fm2 == null) {
            Engine.b("GI null");
        }
        if (fm3 == null) {
            Engine.b("DI null");
        }
        if (fm2 != null && fm3 != null) {
            Engine.b("Set new positions");
            boolean bl2 = false;
            if (this.grabItemLocation == ItemLocation.INVENTORY && this.dropItemLocation == ItemLocation.INVENTORY) {
                Engine.b("CASE Inventory <-> Inventory");
                Collections.swap(ay.ay_a().gd_a().as_a().a(), this.grabItemPosition, this.dropItemPosition);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.INVENTORY && this.dropItemLocation == ItemLocation.EQUIPPED) {
                Engine.b("CASE Inventory <-> Equip");
                ay.ay_a().gd_a().as_a().a().set(this.grabItemPosition, fm3);
                ay.ay_a().gd_a().as_a().am_a(this.dropItemPosition).a((fh)fm2, engine);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.INVENTORY && this.dropItemLocation == ItemLocation.STASH) {
                ay.ay_a().gd_a().as_a().a().set(this.grabItemPosition, fm3);
                ay.ay_a().gd_a().bu_a().a(fm2, this.dropItemPosition, this.dropStashTabIndex);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.STASH && this.dropItemLocation == ItemLocation.INVENTORY) {
                ay.ay_a().gd_a().bu_a().a(fm3, this.grabItemPosition, this.grabStashTabIndex);
                ay.ay_a().gd_a().as_a().a().set(this.dropItemPosition, fm2);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.STASH && this.dropItemLocation == ItemLocation.EQUIPPED) {
                ay.ay_a().gd_a().bu_a().a(fm3, this.grabItemPosition, this.grabStashTabIndex);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)am2.com_arenaofkings_packets_misc_items_ItemSlot_a()).a((fh)fm2, engine);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.EQUIPPED && this.dropItemLocation == ItemLocation.STASH) {
                ay.ay_a().gd_a().as_a().am_a(this.grabItemPosition).a((fh)fm3, engine);
                ay.ay_a().gd_a().bu_a().a(fm2, this.dropItemPosition, this.dropStashTabIndex);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.STASH && this.dropItemLocation == ItemLocation.STASH) {
                ay.ay_a().gd_a().bu_a().a(fm2, this.dropItemPosition, this.dropStashTabIndex);
                ay.ay_a().gd_a().bu_a().a(fm3, this.grabItemPosition, this.grabStashTabIndex);
                bl2 = this.swapPositions(fm2, fm3);
            } else if (this.grabItemLocation == ItemLocation.EQUIPPED && this.dropItemLocation == ItemLocation.INVENTORY) {
                ay.ay_a().gd_a().as_a().am_a(this.grabItemPosition).a((fh)fm3, engine);
                ay.ay_a().gd_a().as_a().a().set(this.dropItemPosition, fm2);
                bl2 = this.swapPositions(fm2, fm3);
            }
            engine.var_baa_a.a(fm2.ajw_a(), fm2.com_arenaofkings_packets_misc_items_ItemRarity_a());
        } else {
            Engine.b("didn't set the new positions");
        }
    }

    private boolean swapPositions(fm fm2, fm fm3) {
        fm2.a(this.dropItemPosition, this.dropItemLocation);
        fm3.a(this.grabItemPosition, this.grabItemLocation);
        Engine.b("Grab item: " + fm2.int_a() + " " + (Object)((Object)fm2.com_arenaofkings_packets_misc_items_ItemLocation_a()));
        Engine.b("Drop item: " + fm3.int_a() + " " + (Object)((Object)fm3.com_arenaofkings_packets_misc_items_ItemLocation_a()));
        return true;
    }

    public String toString() {
        return "PUB_ITEM_MOVE_REQUEST [grabItemPosition=" + this.grabItemPosition + ", grabItemLocation=" + (Object)((Object)this.grabItemLocation) + ", dropItemPosition=" + this.dropItemPosition + ", dropItemLocation=" + (Object)((Object)this.dropItemLocation) + "]";
    }
}

