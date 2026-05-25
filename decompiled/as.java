/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ItemAttributes;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemSlot;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class as
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private int var_int_a;
    private int var_int_b;
    private ayh var_ayh_a;
    private boolean var_boolean_a = false;
    private List<fm> var_java_util_List_fm__a;
    private int c = 0;
    private fm var_fm_a = null;
    private int d;
    private int e = 0;
    private ListIterator<fm> var_java_util_ListIterator_fm__a;
    private ayg var_ayg_a;
    private ItemSlot var_com_arenaofkings_packets_misc_items_ItemSlot_a = null;
    private List<ayh> var_java_util_List_ayh__b;
    private ayh var_ayh_b = null;
    private String var_java_lang_String_a = "";
    private int f;
    private int g;

    public as(Engine engine, ArrayList<ItemData> arrayList) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_int_a = 1533;
        this.var_int_b = 85;
        this.var_ayg_a = new at(this, 1862, 930, 1892, 960);
        int n2 = 24;
        this.var_com_arenaofkings_client_core_Engine_a = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.var_com_arenaofkings_client_core_Engine_a.add(new ff(ItemLocation.INVENTORY, i2));
        }
        for (ItemData itemData : arrayList) {
            switch (itemData.getItemSlot()) {
                case HEAD: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case SHOULDER: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case CHEST: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case HANDS: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case WRIST: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case LEGS: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case FEET: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case BACK: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fv(itemData));
                    break;
                }
                case NECK: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fy(itemData));
                    break;
                }
                case RING: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fy(itemData));
                    break;
                }
                case TRINKET: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fy(itemData));
                    break;
                }
                case WEAPON: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new ga(itemData));
                    break;
                }
                case CONSUMABLE: {
                    this.var_com_arenaofkings_client_core_Engine_a.set(itemData.getItemPosition(), new fx(itemData));
                    break;
                }
            }
        }
        this.var_int_b = (int)new ArrayList();
    }

    public void a(fm fm2) {
        this.var_com_arenaofkings_client_core_Engine_a = this.var_com_arenaofkings_client_core_Engine_a.listIterator();
        while (this.var_com_arenaofkings_client_core_Engine_a.hasNext()) {
            fm fm3 = (fm)this.var_com_arenaofkings_client_core_Engine_a.next();
            if (!(fm3 instanceof ff)) continue;
            this.var_com_arenaofkings_client_core_Engine_a.set(fm2);
            fm2.a(fm3.int_a());
            fm2.b(ItemLocation.INVENTORY);
            fm2.void_a();
            Engine.b("Inserted new item " + fm2.java_lang_String_a());
            return;
        }
    }

    public void void_a(int n2) {
        this.var_com_arenaofkings_client_core_Engine_a.set(n2, new ff(ItemLocation.INVENTORY, n2));
    }

    public void a(axm axm2) {
        this.var_ayh_a = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "inventory_frame", true);
        this.b(axm2);
        for (int i2 = 0; i2 < ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size(); ++i2) {
            ej object = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().get(i2);
            for (am am2 : object.a().values()) {
                am2.a(axm2);
                if (am2.fh_a() == null) continue;
                am2.fh_a().a(axm2, true);
            }
        }
        for (fm fm2 : ay.ay_a().gd_a().as_a().a()) {
            fm2.a(axm2, true);
        }
    }

    public void b(axm axm2) {
        this.var_int_b.clear();
        this.c = 0;
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.AGILITY, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case CHAMPION: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.STRENGTH, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case ELDER: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.WISDOM, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case LICH: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.INTELLIGENCE, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case MYSTIC: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.WISDOM, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case NIHILIST: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.INTELLIGENCE, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case PALADIN: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.STRENGTH, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case RANGER: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.AGILITY, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case SCHOLAR: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.WISDOM, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
            case WIZARD: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.INTELLIGENCE, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), "[RARITY_UNCOMMON]"), 0, this.c++);
                break;
            }
        }
        this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.POWER, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dz.class), "[RARITY_UNCOMMON]"), 0, this.c++);
        this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.CRITICAL_CHANCE, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dm.class), "[RARITY_UNCOMMON]"), 0, this.c++);
        this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.ARMOR, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dj.class), "[RARITY_UNCOMMON]"), 0, this.c++);
        this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MAGIC_RESIST, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dv.class), "[RARITY_UNCOMMON]"), 0, this.c++);
        this.c = 0;
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.STRENGTH, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case CHAMPION: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.AGILITY, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case ELDER: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.AGILITY, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case LICH: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.STRENGTH, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case MYSTIC: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.INTELLIGENCE, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case NIHILIST: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.STRENGTH, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case PALADIN: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.WISDOM, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case RANGER: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.STRENGTH, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case SCHOLAR: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.INTELLIGENCE, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case WIZARD: {
                this.a(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.WISDOM, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
        }
        this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HEALTH, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_b(), "[RARITY_UNCOMMON]"), 1, this.c++);
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.b(axm2, "[RARITY_UNIQUE]Energy: [][RARITY_UNCOMMON]100\n [WHITE]Your Maximum Energy pool.", 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, "[RARITY_UNIQUE]Energy Regeneration: [][RARITY_UNCOMMON]10/sec\n [WHITE]Restores Energy every second.", 1, this.c++);
                break;
            }
            case CHAMPION: {
                this.b(axm2, "[RARITY_UNIQUE]Rage: [][RARITY_UNCOMMON]100\n [WHITE]Your Maximum Rage pool.", 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case ELDER: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case LICH: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case MYSTIC: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case NIHILIST: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case PALADIN: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case RANGER: {
                this.b(axm2, "[RARITY_UNIQUE]Energy: [][RARITY_UNCOMMON]100\n [WHITE]Your Maximum Energy pool.", 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, "[RARITY_UNIQUE]Energy Regeneration: [][RARITY_UNCOMMON]10/sec\n [WHITE]Restores Energy every second.", 1, this.c++);
                break;
            }
            case SCHOLAR: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
            case WIZARD: {
                this.b(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MANA, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.HP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.MP5, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), "[RARITY_UNCOMMON]"), 1, this.c++);
                break;
            }
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.CHAMPION) {
            this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.LIFE_STEAL, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dt.class), "[RARITY_UNCOMMON]"), 0, this.c + 1);
        } else {
            this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.LIFE_STEAL, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dt.class), "[RARITY_UNCOMMON]"), 0, this.c);
        }
        this.c(axm2, ItemAttributes.getAttributeInfo(ItemAttributes.INCREASED_RARITY, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dr.class), "[RARITY_UNCOMMON]"), 1, this.c);
    }

    public int int_a() {
        for (int i2 = 0; i2 < this.var_com_arenaofkings_client_core_Engine_a.size(); ++i2) {
            if (!(this.var_com_arenaofkings_client_core_Engine_a.get(i2) instanceof ff)) continue;
            return i2;
        }
        return -1;
    }

    public void void_a() {
        this.var_boolean_a = true;
    }

    public void void_b() {
        this.var_boolean_a = false;
    }

    public void void_c() {
        boolean bl2 = this.var_boolean_a = !this.var_boolean_a;
        if (this.var_boolean_a) {
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jY);
        } else {
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jS);
        }
    }

    public void void_d() {
        if (!this.var_boolean_a) {
            this.var_boolean_a = true;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jY);
        }
    }

    public void e() {
        if (!this.var_boolean_a) {
            this.var_boolean_a = true;
        }
    }

    public void f() {
        if (this.var_boolean_a) {
            this.var_boolean_a = false;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jS);
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_a) {
            this.var_ayg_a.b(engine);
            this.var_ayh_a.b(f2, engine);
            this.c = 0;
            engine.a("[WHITE]Primary Attributes[]", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 1724.0f, 574.0f, 1);
            engine.a("[GRAY]______________________________________________[]", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1724.0f, 548.0f, 1);
            engine.a("[GRAY]______________________________________________[]", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1724.0f, 498.0f, 1);
            switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    this.e(engine, "[WHITE]Agility", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), 0, this.c++);
                    break;
                }
                case CHAMPION: {
                    this.e(engine, "[WHITE]Strength", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), 0, this.c++);
                    break;
                }
                case ELDER: {
                    this.e(engine, "[WHITE]Wisdom", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), 0, this.c++);
                    break;
                }
                case LICH: {
                    this.e(engine, "[WHITE]Intelligence", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), 0, this.c++);
                    break;
                }
                case MYSTIC: {
                    this.e(engine, "[WHITE]Wisdom", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), 0, this.c++);
                    break;
                }
                case NIHILIST: {
                    this.e(engine, "[WHITE]Intelligence", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), 0, this.c++);
                    break;
                }
                case PALADIN: {
                    this.e(engine, "[WHITE]Strength", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), 0, this.c++);
                    break;
                }
                case RANGER: {
                    this.e(engine, "[WHITE]Agility", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), 0, this.c++);
                    break;
                }
                case SCHOLAR: {
                    this.e(engine, "[WHITE]Wisdom", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), 0, this.c++);
                    break;
                }
                case WIZARD: {
                    this.e(engine, "[WHITE]Intelligence", 0, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), 0, this.c++);
                    break;
                }
            }
            this.c(engine, "[WHITE]Power", 0, this.c);
            this.d(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dz.class), 0, this.c++);
            this.c(engine, "[WHITE]Crit Chance ", 0, this.c);
            this.d(engine, "[ATTRIBUTE_GREEN]" + Engine.a(100.0f * ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dm.class), 2) + "%", 0, this.c++);
            this.a(engine, "[WHITE]Armor", 0, this.c);
            this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dj.class), 0, this.c++);
            this.a(engine, "[WHITE]Magic Resist", 0, this.c);
            this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dv.class), 0, this.c++);
            this.c = 0;
            switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    this.e(engine, "[WHITE]Strength ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), 1, this.c++);
                    break;
                }
                case CHAMPION: {
                    this.e(engine, "[WHITE]Agility ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), 1, this.c++);
                    break;
                }
                case ELDER: {
                    this.e(engine, "[WHITE]Agility ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(di.class), 1, this.c++);
                    break;
                }
                case LICH: {
                    this.e(engine, "[WHITE]Strength ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), 1, this.c++);
                    break;
                }
                case MYSTIC: {
                    this.e(engine, "[WHITE]Intelligence ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), 1, this.c++);
                    break;
                }
                case NIHILIST: {
                    this.e(engine, "[WHITE]Strength ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), 1, this.c++);
                    break;
                }
                case PALADIN: {
                    this.e(engine, "[WHITE]Wisdom ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), 1, this.c++);
                    break;
                }
                case RANGER: {
                    this.e(engine, "[WHITE]Strength ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(eb.class), 1, this.c++);
                    break;
                }
                case SCHOLAR: {
                    this.e(engine, "[WHITE]Intelligence ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ds.class), 1, this.c++);
                    break;
                }
                case WIZARD: {
                    this.e(engine, "[WHITE]Wisdom ", 1, this.c);
                    this.f(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(ee.class), 1, this.c++);
                    break;
                }
            }
            this.c(engine, "[WHITE]Health", 1, this.c);
            this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_b(), 1, this.c++);
            switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    this.c(engine, "[WHITE]Energy", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Energy Regen", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]11/sec", 1, this.c++);
                    break;
                }
                case CHAMPION: {
                    this.c(engine, "[WHITE]Rage", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]15", 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    break;
                }
                case ELDER: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
                case LICH: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
                case MYSTIC: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
                case NIHILIST: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
                case PALADIN: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
                case RANGER: {
                    this.c(engine, "[WHITE]Energy", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Energy Regen", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]20/sec", 1, this.c++);
                    break;
                }
                case SCHOLAR: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
                case WIZARD: {
                    this.c(engine, "[WHITE]Mana", 1, this.c);
                    this.d(engine, "[ATTRIBUTE_GREEN]" + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), 1, this.c++);
                    this.a(engine, "[WHITE]Health/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dq.class), 1, this.c++);
                    this.a(engine, "[WHITE]Mana/sec", 1, this.c);
                    this.b(engine, "[ATTRIBUTE_GREEN]" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dy.class), 1, this.c++);
                    break;
                }
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.CHAMPION) {
                this.a(engine, "[WHITE]Lifesteal ", 0, this.c + 1);
                this.b(engine, "[ATTRIBUTE_GREEN]" + Engine.a((float)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dt.class) / 100.0f, 2) + "%", 0, this.c + 1);
            } else {
                this.a(engine, "[WHITE]Lifesteal ", 0, this.c);
                this.b(engine, "[ATTRIBUTE_GREEN]" + Engine.a((float)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dt.class) / 100.0f, 2) + "%", 0, this.c);
            }
            this.a(engine, "[WHITE]Item Rarity ", 1, this.c);
            this.b(engine, "[ATTRIBUTE_GREEN]" + Engine.a(100.0f * ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dr.class), 2) + "%", 1, this.c);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().a(f2, engine, this.var_int_a + 7, this.var_int_b + 610, false, false, false, true);
            Iterator<Object> iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (iterator.hasNext()) {
                fm axr2 = (fm)iterator.next();
                axr2.b(f2, engine);
            }
            if (this.var_fm_a != null && this.var_fm_a instanceof fh && !(this.var_fm_a instanceof fx)) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)((fh)this.var_fm_a).com_arenaofkings_packets_misc_items_ItemSlot_a()).a(true);
            }
            for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                am2.b(f2, engine);
                if (am2.com_arenaofkings_packets_misc_items_ItemSlot_a() != this.var_com_arenaofkings_packets_misc_items_ItemSlot_a && !am2.b()) continue;
                ay.ay_a().gd_a().cg_a().da_b().d(0.016f, am2.fh_a().int_b() + 123, am2.fh_a().int_c() + 80, engine.var_azi_a);
            }
        }
    }

    public void a(float f2) {
        if (this.var_boolean_a) {
            for (ayh ayh2 : this.var_int_b) {
                ayh2.a(f2, this.var_com_arenaofkings_client_core_Engine_a);
                ayh2.b(f2, this.var_com_arenaofkings_client_core_Engine_a);
            }
            if (this.var_ayh_b != null) {
                this.var_com_arenaofkings_client_core_Engine_a.a(this.var_java_lang_String_a, this.f, this.g, 325);
                this.var_com_arenaofkings_client_core_Engine_a.a(this.var_java_lang_String_a, this.f, this.g);
            }
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_boolean_a) {
            Iterator<Object> iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (iterator.hasNext()) {
                fm axr2 = (fm)iterator.next();
                axr2.d(f2, engine);
            }
            for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                am2.fh_a().d(f2, engine);
            }
        }
    }

    public List<fm> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public fm fm_a() {
        return this.var_fm_a;
    }

    public void b(fm fm2) {
        this.var_fm_a = fm2;
    }

    public void a(int n2, int n3) {
        this.d = n2;
        this.e = n3;
    }

    public int int_b() {
        return this.d;
    }

    public int int_c() {
        return this.e;
    }

    public void a(Engine engine, String string, int n2, int n3) {
        engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 170 * n2 + 30, this.var_int_b + 456 - n3 * 21, 8);
    }

    public void b(Engine engine, String string, int n2, int n3) {
        engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 170 * n2 + 179, this.var_int_b + 456 - n3 * 21, 16);
    }

    public void c(Engine engine, String string, int n2, int n3) {
        engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 170 * n2 + 30, this.var_int_b + 459 - n3 * 20, 8);
    }

    public void d(Engine engine, String string, int n2, int n3) {
        engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 170 * n2 + 179, this.var_int_b + 459 - n3 * 20, 16);
    }

    private void a(axm axm2, String string, int n2, int n3) {
        int n4 = this.var_int_a;
        int n5 = this.var_int_b;
        au au2 = new au(this, this.var_int_a + 9 + 170 * n2, this.var_int_b + 456 - n3 * 20, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "InformationSmall", string, n4, n2, n5, n3);
        au2.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.var_int_b.add(au2);
    }

    private void b(axm axm2, String string, int n2, int n3) {
        int n4 = this.var_int_a;
        int n5 = this.var_int_b;
        av av2 = new av(this, this.var_int_a + 9 + 170 * n2, this.var_int_b + 445 - n3 * 21, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "InformationSmall", string, n4, n2, n5, n3);
        av2.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.var_int_b.add(av2);
    }

    private void c(axm axm2, String string, int n2, int n3) {
        int n4 = this.var_int_a;
        int n5 = this.var_int_b;
        aw aw2 = new aw(this, this.var_int_a + 9 + 170 * n2, this.var_int_b + 442 - n3 * 21, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "InformationSmall", string, n4, n2, n5, n3);
        aw2.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.var_int_b.add(aw2);
    }

    public void e(Engine engine, String string, int n2, int n3) {
        engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 170 * n2 + 30, this.var_int_b + 471 - n3 * 18, 8);
    }

    public void f(Engine engine, String string, int n2, int n3) {
        engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 170 * n2 + 179, this.var_int_b + 471 - n3 * 18, 16);
    }

    public am am_a(int n2) {
        am am2 = null;
        for (am am3 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
            if (am3.var_fh_a.int_a() != n2) continue;
            am2 = am3;
            break;
        }
        return am2;
    }

    public boolean boolean_b() {
        for (int i2 = 0; i2 < this.var_com_arenaofkings_client_core_Engine_a.size(); ++i2) {
            if (!(this.var_com_arenaofkings_client_core_Engine_a.get(i2) instanceof ff)) continue;
            return false;
        }
        return true;
    }

    public int int_d() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.var_com_arenaofkings_client_core_Engine_a.size(); ++i2) {
            if (!(this.var_com_arenaofkings_client_core_Engine_a.get(i2) instanceof ff)) continue;
            ++n2;
        }
        return n2;
    }

    public void d(float f2, Engine engine) {
        if (this.var_boolean_a) {
            Iterator iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (iterator.hasNext()) {
                fm fm2 = (fm)iterator.next();
                fm2.c(f2, engine);
            }
        }
    }

    public void a(ItemSlot itemSlot) {
        this.var_com_arenaofkings_packets_misc_items_ItemSlot_a = itemSlot;
    }

    static /* synthetic */ boolean boolean_a(as as2) {
        return as2.var_boolean_a;
    }

    static /* synthetic */ ayh ayh_a(as as2) {
        return as2.var_ayh_b;
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(as as2) {
        return as2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ ayh a(as as2, ayh ayh2) {
        as2.var_ayh_b = ayh2;
        return as2.var_ayh_b;
    }

    static /* synthetic */ String a(as as2, String string) {
        as2.var_java_lang_String_a = string;
        return as2.var_java_lang_String_a;
    }

    static /* synthetic */ int a(as as2, int n2) {
        as2.f = n2;
        return as2.f;
    }

    static /* synthetic */ int b(as as2, int n2) {
        as2.g = n2;
        return as2.g;
    }
}

