/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_ITEM_SELL;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.loginserver.PUB_TRADE_ITEM_MOVE;
import com.arenaofkings.packets.loginserver.PUB_TRADE_ITEM_REMOVE;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.PUB_CONSUMABLE_USE;
import com.arenaofkings.packets.misc.items.PUB_ITEM_MOVE_REQUEST;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class aav
extends aan {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private boolean var_boolean_a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private int var_int_a;
    private fm var_fm_a = null;
    private boolean i = false;

    public aav(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
    }

    @Override
    public boolean a(we we2, int n2, int n3, int n4, int n5) {
        if (n5 == 1 || n5 == 0) {
            this.var_int_a = n3;
            if (we2.wh_a().ya_a().azq_a().c.boolean_a()) {
                Engine.b("knob is now dragging");
                this.c = true;
            } else if (we2.wh_a().ya_a().aze_a().c.boolean_a()) {
                this.d = true;
            } else if (we2.wh_a().ya_a().azh_a().c.boolean_a()) {
                this.e = true;
            } else if (we2.wh_a().yu_a().abr_a().ayh_a().boolean_a()) {
                this.f = true;
            } else if (we2.wh_a().yu_a().acg_a().ayh_a().boolean_a()) {
                this.g = true;
            } else if (we2.wh_a().yu_a().ach_a().ayh_a().boolean_a()) {
                this.h = true;
            }
            return false;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    public boolean b(we we2, int n2, int n3, int n4, int n5) {
        block69: {
            int n6;
            block68: {
                Object object;
                block74: {
                    Iterator<axr> iterator;
                    block71: {
                        block73: {
                            block72: {
                                block70: {
                                    Engine.b("knob is not dragging");
                                    if (n5 == 1 || n5 == 0) {
                                        if (this.c) {
                                            we2.wh_a().ya_a().azq_a().b();
                                        } else if (this.d) {
                                            we2.wh_a().ya_a().aze_a().b();
                                        } else if (this.e) {
                                            we2.wh_a().ya_a().azh_a().b();
                                        } else if (this.f) {
                                            we2.wh_a().yu_a().abr_a().d();
                                        } else if (this.g) {
                                            we2.wh_a().yu_a().acg_a().d();
                                        } else if (this.h) {
                                            we2.wh_a().yu_a().ach_a().d();
                                        }
                                        this.c = false;
                                        this.d = false;
                                        this.e = false;
                                        this.f = false;
                                        this.g = false;
                                        this.h = false;
                                    }
                                    if (n5 != 0) break block70;
                                    if (Gdx.input.isKeyPressed(59)) {
                                        if (ay.ay_a().gd_a().ca_a().boolean_a()) {
                                            for (fm fm2 : ay.ay_a().gd_a().ca_a().a()) {
                                                if (!(fm2 instanceof fh) || !fm2.boolean_a()) continue;
                                                we2.wh_a().wg_a().axh_a().a(fm2);
                                                we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(we2.wh_a().wg_a().axh_a());
                                                return false;
                                            }
                                            for (fm fm3 : ay.ay_a().gd_a().ca_a().b()) {
                                                if (!(fm3 instanceof fh) || !fm3.boolean_a()) continue;
                                                we2.wh_a().wg_a().axh_a().a(fm3);
                                                we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(we2.wh_a().wg_a().axh_a());
                                                return false;
                                            }
                                        }
                                        for (fm fm4 : ay.ay_a().gd_a().as_a().a()) {
                                            if (!(fm4 instanceof fh) || !fm4.boolean_a()) continue;
                                            we2.wh_a().wg_a().axh_a().a(fm4);
                                            we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(we2.wh_a().wg_a().axh_a());
                                            return false;
                                        }
                                        if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                                            for (fm fm5 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                                                if (!(fm5 instanceof fh) || !fm5.boolean_a()) continue;
                                                we2.wh_a().wg_a().axh_a().a(fm5);
                                                we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(we2.wh_a().wg_a().axh_a());
                                                return false;
                                            }
                                        }
                                        for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                                            if (am2.fh_a() == null || !am2.fh_a().boolean_a()) continue;
                                            we2.wh_a().wg_a().axh_a().a(am2.fh_a());
                                            we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(we2.wh_a().wg_a().axh_a());
                                            return false;
                                        }
                                    }
                                    if (!this.i || ay.ay_a().gd_a().cg_a().boolean_a()) break block69;
                                    iterator = ay.ay_a().gd_a().as_a().a().iterator();
                                    break block71;
                                }
                                if (n5 != 1) break block69;
                                if (ay.ay_a().gd_a().cg_a().boolean_a()) {
                                    for (fm fm6 : ay.ay_a().gd_a().as_a().a()) {
                                        if (!(fm6 instanceof fh) || !fm6.boolean_a()) continue;
                                        object = new PUB_ITEM_MOVE_REQUEST();
                                        ((PUB_ITEM_MOVE_REQUEST)object).grabItemPosition = fm6.int_a();
                                        ((PUB_ITEM_MOVE_REQUEST)object).grabItemLocation = ItemLocation.INVENTORY;
                                        PUB_ITEM_SELL pUB_ITEM_SELL = new PUB_ITEM_SELL(((PUB_ITEM_MOVE_REQUEST)object).grabItemLocation, ((PUB_ITEM_MOVE_REQUEST)object).grabItemPosition, fm6.int_d());
                                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_ITEM_SELL);
                                        break;
                                    }
                                }
                                if (ay.ay_a().gd_a().cg_a().boolean_a()) {
                                    Engine.b("SELL1");
                                    if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                                        for (fm fm7 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                                            if (!(fm7 instanceof fh) || !fm7.boolean_a()) continue;
                                            Engine.b("SELL2");
                                            if (fm7 instanceof ff) break;
                                            Engine.b("SELL3");
                                            object = new PUB_ITEM_MOVE_REQUEST();
                                            ((PUB_ITEM_MOVE_REQUEST)object).grabItemPosition = fm7.int_a();
                                            ((PUB_ITEM_MOVE_REQUEST)object).grabItemLocation = ItemLocation.STASH;
                                            PUB_ITEM_SELL pUB_ITEM_SELL = new PUB_ITEM_SELL(((PUB_ITEM_MOVE_REQUEST)object).grabItemLocation, ((PUB_ITEM_MOVE_REQUEST)object).grabItemPosition, fm7.int_d());
                                            this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_ITEM_SELL);
                                            Engine.b("SELL4");
                                            break;
                                        }
                                    }
                                }
                                n6 = -1;
                                Object var7_27 = null;
                                if (!ay.ay_a().gd_a().ca_a().boolean_a()) break block72;
                                if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                                    for (fm fm8 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                                        if (!(fm8 instanceof fh) || !fm8.boolean_a()) continue;
                                        if (!(fm8 instanceof ff) && (n6 = ay.ay_a().gd_a().ca_a().int_a()) != -1) {
                                            PUB_TRADE_ITEM_MOVE pUB_TRADE_ITEM_MOVE = new PUB_TRADE_ITEM_MOVE();
                                            pUB_TRADE_ITEM_MOVE.grabItemPosition = fm8.int_a();
                                            pUB_TRADE_ITEM_MOVE.grabItemLocation = ItemLocation.STASH;
                                            pUB_TRADE_ITEM_MOVE.grabStashTabIndex = fm8.int_d();
                                            pUB_TRADE_ITEM_MOVE.dropItemPosition = n6;
                                            ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_TRADE_ITEM_MOVE);
                                            this.a();
                                        }
                                        break block68;
                                    }
                                }
                                break block68;
                            }
                            if (!Gdx.input.isKeyPressed(59) && !Gdx.input.isKeyPressed(60) || ay.ay_a().gd_a().as_a().boolean_b()) break block73;
                            if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                                for (fm fm9 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                                    if (!(fm9 instanceof fh) || !fm9.boolean_a()) continue;
                                    if (!(fm9 instanceof ff)) {
                                        PUB_ITEM_MOVE_REQUEST pUB_ITEM_MOVE_REQUEST = new PUB_ITEM_MOVE_REQUEST();
                                        pUB_ITEM_MOVE_REQUEST.grabItemPosition = fm9.int_a();
                                        pUB_ITEM_MOVE_REQUEST.grabItemLocation = ItemLocation.STASH;
                                        pUB_ITEM_MOVE_REQUEST.grabStashTabIndex = fm9.int_d();
                                        pUB_ITEM_MOVE_REQUEST.dropItemPosition = ay.ay_a().gd_a().as_a().int_a();
                                        pUB_ITEM_MOVE_REQUEST.dropItemLocation = ItemLocation.INVENTORY;
                                        Engine.b("stash -> inventory here");
                                        ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_ITEM_MOVE_REQUEST);
                                        this.a();
                                    }
                                    break block68;
                                }
                            }
                            break block68;
                        }
                        if (ay.ay_a().gd_a().cg_a().boolean_a() || ay.ay_a().gd_a().bu_a().bz_a() == null) break block68;
                        object = ay.ay_a().gd_a().bu_a().bz_a().a().iterator();
                        break block74;
                    }
                    while (iterator.hasNext()) {
                        fm fm10 = iterator.next();
                        if (!(fm10 instanceof fh) || !fm10.boolean_a()) continue;
                        if (fm10 instanceof ff || fm10 instanceof fx) {
                            this.var_fm_a = null;
                            this.i = false;
                            break;
                        }
                        if (this.var_fm_a == null) continue;
                        object = new PUB_CONSUMABLE_USE();
                        ((PUB_CONSUMABLE_USE)object).grabItemPosition = this.var_fm_a.int_a();
                        ((PUB_CONSUMABLE_USE)object).grabItemLocation = this.var_fm_a.com_arenaofkings_packets_misc_items_ItemLocation_a();
                        ((PUB_CONSUMABLE_USE)object).grabStashTabIndex = this.var_fm_a.int_d();
                        ((PUB_CONSUMABLE_USE)object).dropItemPosition = fm10.int_a();
                        ((PUB_CONSUMABLE_USE)object).dropItemLocation = ItemLocation.INVENTORY;
                        ((PUB_CONSUMABLE_USE)object).dropStashTabIndex = 0;
                        ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(object);
                        this.var_fm_a = null;
                        this.i = false;
                        break;
                    }
                    if (!ay.ay_a().gd_a().cg_a().boolean_a() && ay.ay_a().gd_a().bu_a().bz_a() != null) {
                        for (fm fm11 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                            if (!(fm11 instanceof fh) || !fm11.boolean_a()) continue;
                            if (fm11 instanceof ff || fm11 instanceof fx) {
                                this.var_fm_a = null;
                                this.i = false;
                                break block69;
                            } else {
                                if (this.var_fm_a == null) continue;
                                object = new PUB_CONSUMABLE_USE();
                                ((PUB_CONSUMABLE_USE)object).grabItemPosition = this.var_fm_a.int_a();
                                ((PUB_CONSUMABLE_USE)object).grabItemLocation = this.var_fm_a.com_arenaofkings_packets_misc_items_ItemLocation_a();
                                ((PUB_CONSUMABLE_USE)object).grabStashTabIndex = this.var_fm_a.int_d();
                                ((PUB_CONSUMABLE_USE)object).dropItemPosition = fm11.int_a();
                                ((PUB_CONSUMABLE_USE)object).dropItemLocation = ItemLocation.STASH;
                                ((PUB_CONSUMABLE_USE)object).dropStashTabIndex = fm11.int_d();
                                ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(object);
                                this.var_fm_a = null;
                                this.i = false;
                            }
                            break block69;
                        }
                    }
                    break block69;
                }
                block11: while (object.hasNext()) {
                    fm fm12 = (fm)object.next();
                    if (!(fm12 instanceof fh) || !fm12.boolean_a()) continue;
                    if (!(fm12 instanceof ff)) {
                        if (fm12 instanceof fx) {
                            if (!((fx)fm12).boolean_d()) continue;
                            Engine.b("Set on use to this");
                            this.var_fm_a = fm12;
                            this.i = true;
                            continue;
                        }
                        PUB_ITEM_MOVE_REQUEST pUB_ITEM_MOVE_REQUEST = new PUB_ITEM_MOVE_REQUEST();
                        pUB_ITEM_MOVE_REQUEST.grabItemPosition = fm12.int_a();
                        pUB_ITEM_MOVE_REQUEST.grabItemLocation = ItemLocation.STASH;
                        pUB_ITEM_MOVE_REQUEST.grabStashTabIndex = fm12.int_d();
                        for (am am3 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                            if (am3.com_arenaofkings_packets_misc_items_ItemSlot_a() != ((fh)fm12).com_arenaofkings_packets_misc_items_ItemSlot_a()) continue;
                            n6 = am3.fh_a().int_a();
                            ItemLocation itemLocation = ItemLocation.EQUIPPED;
                            pUB_ITEM_MOVE_REQUEST.dropItemPosition = n6;
                            pUB_ITEM_MOVE_REQUEST.dropItemLocation = itemLocation;
                            ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_ITEM_MOVE_REQUEST);
                            Engine.b("equip from stash here");
                            this.a();
                            continue block11;
                        }
                        continue;
                    }
                    break;
                }
            }
            if (ay.ay_a().gd_a().cg_a().boolean_a()) {
                ay.ay_a().gd_a().cg_a().a(this.var_com_arenaofkings_client_core_Engine_a);
            }
            if (!ay.ay_a().gd_a().as_a().boolean_b()) {
                for (am am4 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                    if (!am4.boolean_a()) continue;
                    PUB_ITEM_MOVE_REQUEST pUB_ITEM_MOVE_REQUEST = new PUB_ITEM_MOVE_REQUEST();
                    pUB_ITEM_MOVE_REQUEST.grabItemPosition = am4.fh_a().int_a();
                    pUB_ITEM_MOVE_REQUEST.grabItemLocation = ItemLocation.EQUIPPED;
                    n6 = ay.ay_a().gd_a().as_a().int_a();
                    ItemLocation itemLocation = ItemLocation.INVENTORY;
                    pUB_ITEM_MOVE_REQUEST.dropItemPosition = n6;
                    pUB_ITEM_MOVE_REQUEST.dropItemLocation = itemLocation;
                    ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_ITEM_MOVE_REQUEST);
                    Engine.b("unequip an item");
                    this.a();
                }
            }
            block14: for (fm fm13 : ay.ay_a().gd_a().as_a().a()) {
                if (!(fm13 instanceof fh) || !fm13.boolean_a()) continue;
                if (fm13 instanceof ff) break;
                if (ay.ay_a().gd_a().ca_a().boolean_a()) {
                    n6 = ay.ay_a().gd_a().ca_a().int_a();
                    if (n6 == -1) break;
                    PUB_TRADE_ITEM_MOVE pUB_TRADE_ITEM_MOVE = new PUB_TRADE_ITEM_MOVE();
                    pUB_TRADE_ITEM_MOVE.grabItemPosition = fm13.int_a();
                    pUB_TRADE_ITEM_MOVE.grabItemLocation = ItemLocation.INVENTORY;
                    pUB_TRADE_ITEM_MOVE.dropItemPosition = n6;
                    ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_TRADE_ITEM_MOVE);
                    this.a();
                    break;
                }
                if ((Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) && ay.ay_a().gd_a().bu_a().bz_a() != null && !ay.ay_a().gd_a().bu_a().boolean_b()) {
                    PUB_ITEM_MOVE_REQUEST pUB_ITEM_MOVE_REQUEST = new PUB_ITEM_MOVE_REQUEST();
                    pUB_ITEM_MOVE_REQUEST.grabItemPosition = fm13.int_a();
                    pUB_ITEM_MOVE_REQUEST.grabItemLocation = ItemLocation.INVENTORY;
                    pUB_ITEM_MOVE_REQUEST.dropItemPosition = ay.ay_a().gd_a().bu_a().bz_a().b();
                    pUB_ITEM_MOVE_REQUEST.dropItemLocation = ItemLocation.STASH;
                    pUB_ITEM_MOVE_REQUEST.dropStashTabIndex = ay.ay_a().gd_a().bu_a().bz_a().int_a();
                    Engine.b("inventory -> stash here");
                    ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_ITEM_MOVE_REQUEST);
                    this.a();
                    break;
                }
                if (fm13 instanceof fx) {
                    if (((fx)fm13).boolean_d()) {
                        Engine.b("Set on use to this");
                        this.var_fm_a = fm13;
                        this.i = true;
                        break;
                    }
                    if (!ay.ay_a().gd_a().cg_a().boolean_a()) {
                        PUB_CONSUMABLE_USE pUB_CONSUMABLE_USE = new PUB_CONSUMABLE_USE();
                        pUB_CONSUMABLE_USE.grabItemPosition = fm13.int_a();
                        pUB_CONSUMABLE_USE.grabItemLocation = ItemLocation.INVENTORY;
                        pUB_CONSUMABLE_USE.grabStashTabIndex = 0;
                        ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_CONSUMABLE_USE);
                        break;
                    }
                    this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.kG, 0.3f);
                    break;
                }
                PUB_ITEM_MOVE_REQUEST pUB_ITEM_MOVE_REQUEST = new PUB_ITEM_MOVE_REQUEST();
                pUB_ITEM_MOVE_REQUEST.grabItemPosition = fm13.int_a();
                pUB_ITEM_MOVE_REQUEST.grabItemLocation = ItemLocation.INVENTORY;
                for (am am3 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                    if (am3.com_arenaofkings_packets_misc_items_ItemSlot_a() != ((fh)fm13).com_arenaofkings_packets_misc_items_ItemSlot_a()) continue;
                    n6 = am3.fh_a().int_a();
                    ItemLocation itemLocation = ItemLocation.EQUIPPED;
                    pUB_ITEM_MOVE_REQUEST.dropItemPosition = n6;
                    pUB_ITEM_MOVE_REQUEST.dropItemLocation = itemLocation;
                    ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_ITEM_MOVE_REQUEST);
                    Engine.b("equip drop here");
                    this.a();
                    continue block14;
                }
            }
            if (ay.ay_a().gd_a().ca_a() != null && ay.ay_a().gd_a().ca_a().a() != null) {
                for (fm fm14 : ay.ay_a().gd_a().ca_a().a()) {
                    if (!(fm14 instanceof fh) || !fm14.boolean_a()) continue;
                    PUB_TRADE_ITEM_REMOVE pUB_TRADE_ITEM_REMOVE = new PUB_TRADE_ITEM_REMOVE();
                    pUB_TRADE_ITEM_REMOVE.position = fm14.int_a();
                    this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_TRADE_ITEM_REMOVE);
                    break;
                }
            }
        }
        if (n5 == 0 || n5 == 1) {
            if (this.b) {
                this.b = false;
                if (Gdx.input.isKeyPressed(59)) {
                    this.a();
                } else {
                    int n7 = -1;
                    Object var7_35 = null;
                    int n8 = 0;
                    for (fm fm15 : ay.ay_a().gd_a().as_a().a()) {
                        if (!fm15.boolean_a()) continue;
                        n7 = fm15.int_a();
                        ItemLocation itemLocation = ItemLocation.INVENTORY;
                        Engine.b("inv drop here");
                    }
                    for (am am5 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                        if (!am5.boolean_a()) continue;
                        n7 = am5.fh_a().int_a();
                        ItemLocation itemLocation = ItemLocation.EQUIPPED;
                        Engine.b("equip drop here");
                    }
                    if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                        for (fm fm16 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                            if (!fm16.boolean_a()) continue;
                            n7 = fm16.int_a();
                            ItemLocation itemLocation = ItemLocation.STASH;
                            if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                                n8 = ay.ay_a().gd_a().bu_a().bz_a().int_a();
                            }
                            Engine.b("stash drop here " + n7 + " " + (Object)((Object)itemLocation));
                        }
                    }
                    if (!Gdx.input.isKeyPressed(59) && ay.ay_a().gd_a().as_a().fm_a() != null) {
                        void var7_40;
                        if (n7 != -1 && var7_40 != null) {
                            Engine.b("Sending the move: " + ay.ay_a().gd_a().as_a().fm_a().int_d() + " " + n8);
                            PUB_ITEM_MOVE_REQUEST pUB_ITEM_MOVE_REQUEST = new PUB_ITEM_MOVE_REQUEST();
                            pUB_ITEM_MOVE_REQUEST.grabItemPosition = ay.ay_a().gd_a().as_a().fm_a().int_a();
                            pUB_ITEM_MOVE_REQUEST.grabItemLocation = ay.ay_a().gd_a().as_a().fm_a().com_arenaofkings_packets_misc_items_ItemLocation_a();
                            pUB_ITEM_MOVE_REQUEST.grabStashTabIndex = ay.ay_a().gd_a().as_a().fm_a().int_d();
                            pUB_ITEM_MOVE_REQUEST.dropItemPosition = n7;
                            pUB_ITEM_MOVE_REQUEST.dropItemLocation = var7_40;
                            pUB_ITEM_MOVE_REQUEST.dropStashTabIndex = n8;
                            ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_ITEM_MOVE_REQUEST);
                        }
                        ay.ay_a().gd_a().as_a().fm_a().a(false);
                    }
                    ay.ay_a().gd_a().as_a().b((fm)null);
                }
            }
            if (this.var_boolean_a) {
                this.var_boolean_a = false;
                if ((float)n2 >= ay.ay_a().gu_a().ui_a(1).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - ay.ay_a().gu_a().ui_a(1).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f - 8.0f && (float)n2 <= ay.ay_a().gu_a().ui_a(8).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + ay.ay_a().gu_a().ui_a(8).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f + 47.0f && (float)n3 >= ay.ay_a().gu_a().ui_a(1).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - ay.ay_a().gu_a().ui_a(1).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() / 2.0f && (float)n3 <= ay.ay_a().gu_a().ui_a(1).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + ay.ay_a().gu_a().ui_a(1).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() / 2.0f + 47.0f) {
                    int n9 = 0;
                    int n10 = 9999;
                    for (int i2 = 1; i2 < ay.ay_a().gu_a().ui_arr_a().length; ++i2) {
                        int n11;
                        int n12 = (int)Math.abs((float)n2 - ay.ay_a().gu_a().ui_a(i2).hd_a().ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - 30.0f);
                        if (n12 >= n11) continue;
                        n11 = n12;
                        n9 = i2;
                    }
                    ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE("/spell " + we2.wh_a().boolean_a() + " " + (++n9 - 1) + " " + (Object)((Object)we2.wh_a().hd_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a())));
                } else {
                    ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE("/spell false " + (we2.wh_a().hd_a().int_a() - 1) + " Empty"));
                }
                we2.wh_a().a(false);
                we2.wh_a().a((hd)null);
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (this.b) {
            this.b = false;
            ay.ay_a().gd_a().as_a().fm_a().a(false);
            ay.ay_a().gd_a().as_a().b((fm)null);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean a(we we2, int n2, int n3, int n4) {
        if (n4 == 0) {
            if (this.f) {
                we2.wh_a().yu_a().abr_a().a(this.var_int_a - n3);
                return false;
            }
            if (this.g) {
                we2.wh_a().yu_a().acg_a().a(this.var_int_a - n3);
                return false;
            }
            if (this.h) {
                we2.wh_a().yu_a().ach_a().a(this.var_int_a - n3);
                return false;
            }
            if (!Gdx.input.isKeyPressed(59) && (ay.ay_a().gd_a().as_a().boolean_a() || ay.ay_a().gd_a().bu_a().boolean_a())) {
                if (!(this.var_boolean_a || this.b || ay.ay_a().gd_a().ca_a().boolean_a())) {
                    for (fm object : ay.ay_a().gd_a().as_a().a()) {
                        if (object instanceof ff) continue;
                        if (ay.ay_a().gd_a().ca_a().boolean_a()) {
                            this.b = false;
                            object.a(false);
                            ay.ay_a().gd_a().as_a().b((fm)null);
                            continue;
                        }
                        if (!object.boolean_a()) continue;
                        this.b = true;
                        object.a(true);
                        ay.ay_a().gd_a().as_a().b(object);
                        ay.ay_a().gd_a().as_a().a(n2 - 29, n3 - 29);
                        ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_baa_a.a(ajw.jZ, 0.7f);
                        return true;
                    }
                    if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                        for (fm fm2 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                            if (fm2 instanceof ff || !fm2.boolean_a()) continue;
                            this.b = true;
                            fm2.a(true);
                            ay.ay_a().gd_a().as_a().b(fm2);
                            ay.ay_a().gd_a().as_a().a(n2 - 29, n3 - 29);
                            ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_baa_a.a(ajw.jZ, 0.7f);
                            return true;
                        }
                    }
                    for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                        if (am2.fh_a() instanceof ff || !am2.boolean_a()) continue;
                        this.b = true;
                        am2.fh_a().a(true);
                        ay.ay_a().gd_a().as_a().b(am2.fh_a());
                        ay.ay_a().gd_a().as_a().a(n2 - 29, n3 - 29);
                        ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_baa_a.a(ajw.jZ, 0.7f);
                        return true;
                    }
                } else if (this.b) {
                    ay.ay_a().gd_a().as_a().a(n2 - 29, n3 - 29);
                }
            } else {
                this.b = false;
                if (ay.ay_a().gd_a().as_a().fm_a() != null) {
                    ay.ay_a().gd_a().as_a().fm_a().a(false);
                }
                ay.ay_a().gd_a().as_a().b((fm)null);
            }
            if (we2.wh_a().ya_a().boolean_b()) {
                if (this.c) {
                    we2.wh_a().ya_a().azq_a().b(this.var_int_a - n3);
                    return false;
                }
                if (this.d) {
                    we2.wh_a().ya_a().aze_a().b(this.var_int_a - n3);
                    return false;
                }
                if (this.e) {
                    we2.wh_a().ya_a().azh_a().b(this.var_int_a - n3);
                    return false;
                }
                if (!this.var_boolean_a && !ay.ay_a().gd_a().bu_a().boolean_a()) {
                    void var6_14;
                    boolean bl2 = false;
                    Iterator iterator = ((Array)((Object)we2.wh_a().ya_a().azq_a().a)).iterator();
                    while (iterator.hasNext()) {
                        ha ha2 = (ha)iterator.next();
                        if (!ha2.a().ayh_a().boolean_a() || !ay.ay_a().gd_a().a(ha2.a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a())) continue;
                        bl2 = true;
                        this.var_boolean_a = true;
                        we2.wh_a().a(new hd(ha2.a()));
                        we2.wh_a().hd_a().a(n2 - 24, n3 - 24);
                        we2.wh_a().a(n2 - 24, n3 - 24);
                        we2.wh_a().a(true);
                        we2.wh_a().b(false);
                        break;
                    }
                    boolean bl3 = false;
                    while (var6_14 < ay.ay_a().gu_a().ui_arr_a().length) {
                        if (ay.ay_a().gu_a().ui_a((int)var6_14).hd_a().boolean_a() && ay.ay_a().gu_a().ui_a((int)var6_14).hd_a().ayh_a().boolean_a()) {
                            bl2 = true;
                            this.var_boolean_a = true;
                            we2.wh_a().a(new hd(ay.ay_a().gu_a().ui_a((int)var6_14).hd_a()));
                            we2.wh_a().a(n2 - 24, n3 - 24);
                            we2.wh_a().a(true);
                            we2.wh_a().b(true);
                        }
                        ++var6_14;
                    }
                    if (bl2) {
                        ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_baa_a.a(ajw.jT, 0.3f);
                    }
                }
                if (this.var_boolean_a && we2.wh_a().hd_a().boolean_a()) {
                    we2.wh_a().hd_a().a(n2 - 24, n3 - 24);
                }
            }
        }
        return false;
    }

    @Override
    public boolean a(we we2, float f2) {
        if (!(this.c || this.d || this.e || this.f)) {
            if (we2.wh_a().ya_a().boolean_b() && ((ayh)((Object)we2.wh_a().ya_a().azq_a().a)).boolean_a()) {
                if (f2 == 1.0f) {
                    we2.wh_a().ya_a().azq_a().c();
                    return true;
                }
                if (f2 == -1.0f) {
                    we2.wh_a().ya_a().azq_a().d();
                    return true;
                }
            }
            if (ay.ay_a().gd_a().ev_a().b() != null && ay.ay_a().gd_a().ev_a().b().boolean_c()) {
                if (f2 == 1.0f) {
                    ay.ay_a().gd_a().ev_a().b().void_a();
                    return true;
                }
                if (f2 == -1.0f) {
                    ay.ay_a().gd_a().ev_a().b().void_b();
                    return true;
                }
            }
        }
        return false;
    }
}

