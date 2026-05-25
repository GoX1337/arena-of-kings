/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemSlot;
import java.util.Locale;

public class am
implements axr {
    protected ItemSlot var_com_arenaofkings_packets_misc_items_ItemSlot_a;
    protected ayh var_ayh_a;
    protected fh var_fh_a;
    protected int var_int_a;
    protected int b;
    protected boolean var_boolean_a = false;

    public am(ItemSlot itemSlot, ItemLocation itemLocation, fh fh2) {
        this.var_com_arenaofkings_packets_misc_items_ItemSlot_a = itemSlot;
        this.var_fh_a = fh2 == null ? new ff(itemLocation, -1) : fh2;
        this.a(itemSlot);
    }

    public void a(ItemSlot itemSlot) {
        switch (itemSlot) {
            case HEAD: {
                this.var_fh_a.a(0);
                this.var_int_a = 1548;
                this.b = 645;
                break;
            }
            case NECK: {
                this.var_fh_a.a(1);
                this.var_int_a = 1606;
                this.b = 645;
                break;
            }
            case SHOULDER: {
                this.var_fh_a.a(2);
                this.var_int_a = 1664;
                this.b = 645;
                break;
            }
            case BACK: {
                this.var_fh_a.a(3);
                this.var_int_a = 1722;
                this.b = 645;
                break;
            }
            case CHEST: {
                this.var_fh_a.a(4);
                this.var_int_a = 1780;
                this.b = 645;
                break;
            }
            case WRIST: {
                this.var_fh_a.a(5);
                this.var_int_a = 1838;
                this.b = 645;
                break;
            }
            case WEAPON: {
                this.var_fh_a.a(6);
                this.var_int_a = 1548;
                this.b = 587;
                break;
            }
            case HANDS: {
                this.var_fh_a.a(7);
                this.var_int_a = 1606;
                this.b = 587;
                break;
            }
            case LEGS: {
                this.var_fh_a.a(8);
                this.var_int_a = 1664;
                this.b = 587;
                break;
            }
            case FEET: {
                this.var_fh_a.a(9);
                this.var_int_a = 1722;
                this.b = 587;
                break;
            }
            case RING: {
                this.var_fh_a.a(10);
                this.var_int_a = 1780;
                this.b = 587;
                break;
            }
            case TRINKET: {
                this.var_fh_a.a(11);
                this.var_int_a = 1838;
                this.b = 587;
                break;
            }
        }
    }

    public void a(axm axm2) {
        this.var_ayh_a = new ayh(this.var_int_a, this.b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_slot_" + this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.name().toLowerCase(Locale.US), true);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_ayh_a == null) {
            this.a(engine.axm_a());
        }
        if (this.var_ayh_a != null) {
            this.var_ayh_a.a(f2, engine);
            if (this.var_fh_a != null) {
                if (this.var_fh_a instanceof ff) {
                    this.var_ayh_a.b(f2, engine);
                } else {
                    this.var_fh_a.b(f2, engine);
                }
            }
        }
    }

    public ItemSlot com_arenaofkings_packets_misc_items_ItemSlot_a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemSlot_a;
    }

    public boolean boolean_a() {
        if (this.var_ayh_a == null) {
            return false;
        }
        return this.var_ayh_a.boolean_a();
    }

    public fh fh_a() {
        return this.var_fh_a;
    }

    public void a(fh fh2, Engine engine) {
        this.var_fh_a = fh2;
        this.a(this.var_com_arenaofkings_packets_misc_items_ItemSlot_a);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() != null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a(), -1, -1);
            engine.var_hg_a.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().ui_arr_a());
            switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    break;
                }
                case CHAMPION: {
                    break;
                }
                case ELDER: {
                    break;
                }
                case LICH: {
                    break;
                }
                case MYSTIC: {
                    break;
                }
                case NIHILIST: {
                    break;
                }
                case PALADIN: {
                    break;
                }
                case RANGER: {
                    break;
                }
                case SCHOLAR: {
                    break;
                }
                case WIZARD: {
                    break;
                }
            }
            if (t.a(we.class, engine)) {
                we we2 = (we)engine.axc_a();
                ay.ay_a().gd_a().as_a().b(we2.axm_a());
            }
        }
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public boolean b() {
        return this.var_boolean_a;
    }
}

