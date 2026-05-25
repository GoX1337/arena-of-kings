/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ItemAttributes;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemModifier;
import com.arenaofkings.packets.misc.items.ItemRarity;
import java.util.Map;
import java.util.TreeMap;

public abstract class fm
implements axr {
    protected ayh var_ayh_a;
    protected ayh var_ayh_b;
    protected ayh var_ayh_c;
    protected boolean var_boolean_a;
    protected String var_java_lang_String_a;
    protected String var_java_lang_String_b = "";
    protected ItemRarity var_com_arenaofkings_packets_misc_items_ItemRarity_a = ItemRarity.COMMON;
    protected fp var_fp_a;
    protected int var_int_a;
    protected int var_int_b;
    protected ItemLocation var_com_arenaofkings_packets_misc_items_ItemLocation_a;
    protected int var_int_c;
    protected int var_int_d = -1;
    protected int e;
    protected int f;
    protected boolean var_boolean_b = false;
    protected ajw var_ajw_a;
    protected ayf var_ayf_a;
    protected ayh var_ayh_d;
    protected int g = 0;
    protected int h = 1;
    protected boolean var_boolean_c;

    @Deprecated
    public fm(ItemLocation itemLocation, int n2) {
        this.var_com_arenaofkings_packets_misc_items_ItemLocation_a = itemLocation;
        this.var_int_c = n2;
    }

    public fm(ItemData itemData) {
        this.var_java_lang_String_a = itemData.getName();
        this.var_java_lang_String_b = itemData.getBottomFlavorText();
        this.var_com_arenaofkings_packets_misc_items_ItemRarity_a = ItemRarity.valueOf(itemData.getItemRarity());
        this.var_fp_a = fp.valueOf(itemData.getItemBase());
        this.var_int_a = itemData.augment;
        this.var_int_b = 1;
        this.var_int_c = itemData.getItemPosition();
        this.var_com_arenaofkings_packets_misc_items_ItemLocation_a = itemData.getItemLocation();
        this.var_int_d = itemData.getStashTabIndex();
        this.void_a();
    }

    public void void_a() {
        switch (this.var_com_arenaofkings_packets_misc_items_ItemLocation_a) {
            case EQUIPPED: {
                this.e = 1552 + this.var_int_c % 6 * 58;
                this.f = (int)(649.0 - Math.floor(this.var_int_c / 6) * 58.0);
                break;
            }
            case GROUND: {
                break;
            }
            case INVENTORY: {
                this.e = 1554 + this.var_int_c % 6 * 57;
                this.f = (int)(359.0 - Math.floor(this.var_int_c / 6) * 57.0);
                break;
            }
            case STASH: {
                this.e = 1074 + this.var_int_c % 8 * 57;
                this.f = (int)(852.0 - Math.floor(this.var_int_c / 8) * 57.0);
                break;
            }
            case VENDOR: {
                this.e = 49 + this.var_int_c % 2 * 241;
                this.f = (int)(814.0 - Math.floor(this.var_int_c / 2) * 90.0);
                break;
            }
            case TRADE: {
                this.e = 434 + this.var_int_c % 6 * 57;
                this.f = (int)(641.0 - Math.floor(this.var_int_c / 6) * 57.0);
            }
        }
    }

    public void a(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void a(Engine engine, int n2, int n3, int n4, boolean bl2, boolean bl3) {
    }

    public abstract void c(float var1, Engine var2);

    public void a(axm axm2, boolean bl2) {
        if (this.var_java_lang_String_a.equals("")) {
            this.var_boolean_a = true;
            return;
        }
    }

    protected void b(axm axm2, boolean bl2) {
        if (bl2 || this.var_ayh_b == null) {
            switch (this.var_com_arenaofkings_packets_misc_items_ItemRarity_a) {
                case COMMON: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_common_border_unhovered", true);
                    break;
                }
                case UNCOMMON: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_uncommon_border_unhovered", true);
                    break;
                }
                case RARE: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_rare_border_unhovered", true);
                    break;
                }
                case EPIC: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_epic_border_unhovered", true);
                    break;
                }
                case LEGENDARY: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_legendary_border_unhovered", true);
                    break;
                }
                case UNIQUE: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_unique_border_unhovered", true);
                    break;
                }
                case ANCIENT: {
                    this.var_ayh_b = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_ancient_border_unhovered", true);
                    break;
                }
            }
        }
    }

    public void a(int n2, int n3) {
        this.e = n2;
        this.f = n3;
    }

    public ayh ayh_a() {
        return this.var_ayh_a;
    }

    protected void c(axm axm2, boolean bl2) {
        if (this.g > 0) {
            this.var_ayh_d = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "detail", true);
            this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.25f);
        }
        if (bl2 || this.var_ayh_c == null) {
            this.var_ayh_c = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), "inventory_hover_glow", true);
        }
    }

    public void a(Engine engine, axm axm2) {
        this.var_ayf_a = new fn(this, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "x_button_default", "x_button_hovered", true, engine);
    }

    public boolean boolean_a() {
        if (this.var_ayh_a == null) {
            return false;
        }
        return this.var_ayh_a != null && this.var_ayh_a.boolean_a();
    }

    public int int_a() {
        return this.var_int_c;
    }

    public ItemLocation com_arenaofkings_packets_misc_items_ItemLocation_a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemLocation_a;
    }

    public void b(ItemLocation itemLocation) {
        this.var_com_arenaofkings_packets_misc_items_ItemLocation_a = itemLocation;
    }

    public void a(int n2) {
        this.var_int_c = n2;
        this.void_a();
    }

    public void a(int n2, ItemLocation itemLocation) {
        this.var_int_c = n2;
        this.var_com_arenaofkings_packets_misc_items_ItemLocation_a = itemLocation;
        this.void_a();
        switch (this.var_com_arenaofkings_packets_misc_items_ItemLocation_a) {
            case EQUIPPED: {
                this.var_int_d = -1;
                break;
            }
            case GROUND: {
                this.var_int_d = -1;
                break;
            }
            case INVENTORY: {
                this.var_int_d = -1;
                break;
            }
            case STASH: {
                break;
            }
            case TRADE: {
                this.var_int_d = -1;
                break;
            }
            case VENDOR: {
                this.var_int_d = -1;
                break;
            }
            default: {
                this.var_int_d = -1;
            }
        }
    }

    public fp fp_a() {
        return this.var_fp_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public ajw ajw_a() {
        return this.var_ajw_a;
    }

    public ItemRarity com_arenaofkings_packets_misc_items_ItemRarity_a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemRarity_a;
    }

    public void d(float f2, Engine engine) {
        if (this.var_boolean_b && this.var_ayh_b != null && this.var_ayh_a != null) {
            ay.ay_a().gd_a().cg_a().da_b().d(0.016f, this.e + 123, this.f + 80, engine.var_azi_a);
            if (!(this instanceof fx) && this instanceof fh) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)((fh)this).com_arenaofkings_packets_misc_items_ItemSlot_a()).a(true);
            }
            this.var_ayh_b.a(f2, engine.var_azi_a, ay.ay_a().gd_a().as_a().int_b(), ay.ay_a().gd_a().as_a().int_c(), 1.0f);
            this.var_ayh_a.a(f2, engine.var_azi_a, ay.ay_a().gd_a().as_a().int_b() + 1, ay.ay_a().gd_a().as_a().int_c() + 1, 1.0f);
        }
    }

    public int int_b() {
        return this.e;
    }

    public void b(int n2) {
        this.e -= n2;
    }

    public int int_c() {
        return this.f;
    }

    public static String a(fh fh2, fh fh3) {
        String string = "\n";
        TreeMap<fr, ItemModifier> treeMap = new TreeMap<fr, ItemModifier>();
        treeMap.put(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, 0.0f));
        treeMap.put(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.ARMOR, 0.0f));
        treeMap.put(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.HP5, 0.0f));
        TreeMap<fr, ItemModifier> treeMap2 = new TreeMap<fr, ItemModifier>();
        treeMap2.put(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, 0.0f));
        treeMap2.put(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.ARMOR, 0.0f));
        treeMap2.put(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.HP5, 0.0f));
        TreeMap<fr, ItemModifier> treeMap3 = new TreeMap<fr, ItemModifier>();
        treeMap3.put(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, 0.0f));
        treeMap3.put(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.ARMOR, 0.0f));
        treeMap3.put(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.HP5, 0.0f));
        if (fh2.com_arenaofkings_packets_misc_items_ItemModifier_a() != null) {
            fm.a(null, fh2.com_arenaofkings_packets_misc_items_ItemModifier_a(), treeMap);
        }
        if (fh2.com_arenaofkings_packets_misc_items_ItemModifier_b() != null) {
            fm.a(null, fh2.com_arenaofkings_packets_misc_items_ItemModifier_b(), treeMap);
        }
        for (ItemModifier object : fh2.a()) {
            fm.a(null, object, treeMap);
        }
        if (fh3.com_arenaofkings_packets_misc_items_ItemModifier_a() != null) {
            fm.a(null, fh3.com_arenaofkings_packets_misc_items_ItemModifier_a(), treeMap2);
        }
        if (fh3.com_arenaofkings_packets_misc_items_ItemModifier_b() != null) {
            fm.a(null, fh3.com_arenaofkings_packets_misc_items_ItemModifier_b(), treeMap2);
        }
        for (ItemModifier itemModifier : fh3.a()) {
            fm.a(null, itemModifier, treeMap2);
        }
        ((ItemModifier)treeMap2.get((Object)fr.var_fr_a)).subtractValue(((ItemModifier)treeMap.get((Object)fr.var_fr_a)).getFloatValue());
        ((ItemModifier)treeMap2.get((Object)fr.b)).subtractValue(((ItemModifier)treeMap.get((Object)fr.b)).getFloatValue());
        ((ItemModifier)treeMap2.get((Object)fr.c)).subtractValue(((ItemModifier)treeMap.get((Object)fr.c)).getFloatValue());
        for (Map.Entry entry : treeMap2.entrySet()) {
            if (((ItemModifier)entry.getValue()).getFloatValue() > 0.0f) {
                string = string + "   [GREEN]+" + (int)((ItemModifier)entry.getValue()).getFloatValue() + "[]\n";
                continue;
            }
            if (((ItemModifier)entry.getValue()).getFloatValue() < 0.0f) {
                string = string + "   [RED]" + (int)((ItemModifier)entry.getValue()).getFloatValue() + "[]\n";
                continue;
            }
            string = string + "   [WHITE]" + (int)((ItemModifier)entry.getValue()).getFloatValue() + "[]\n";
        }
        return string;
    }

    public static void a(fr fr2, ItemModifier itemModifier, Map<fr, ItemModifier> map) {
        if (fr2 != null) {
            map.get((Object)fr2).addValue(itemModifier.getValue());
        } else if (itemModifier.getAttribute() == ItemAttributes.AGILITY || itemModifier.getAttribute() == ItemAttributes.STRENGTH || itemModifier.getAttribute() == ItemAttributes.INTELLIGENCE || itemModifier.getAttribute() == ItemAttributes.WISDOM) {
            if (itemModifier.getAttribute() == ItemAttributes.AGILITY) {
                if (fm.a(itemModifier.getAttribute())) {
                    fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, (float)itemModifier.getValue() * 0.125f), map);
                }
                fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.ARMOR, (float)itemModifier.getValue() * 0.15f), map);
                fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.CRITICAL_CHANCE, (float)itemModifier.getValue() * 0.2f), map);
            } else if (itemModifier.getAttribute() == ItemAttributes.STRENGTH) {
                if (fm.a(itemModifier.getAttribute())) {
                    fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, (float)itemModifier.getValue() * 0.15f), map);
                }
                fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.HEALTH, (float)itemModifier.getValue() * 0.325f), map);
            } else if (itemModifier.getAttribute() == ItemAttributes.INTELLIGENCE) {
                if (fm.a(itemModifier.getAttribute())) {
                    fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, (float)itemModifier.getValue() * 0.125f), map);
                }
                fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MAGIC_RESIST, (float)itemModifier.getValue() * 0.1f), map);
                fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MANA, (float)itemModifier.getValue() * 0.1f), map);
                fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.CRITICAL_CHANCE, (float)itemModifier.getValue() * 0.2f), map);
            } else if (itemModifier.getAttribute() == ItemAttributes.WISDOM) {
                if (fm.a(itemModifier.getAttribute())) {
                    fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, (float)itemModifier.getValue() * 0.15f), map);
                }
                fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MANA, (float)itemModifier.getValue() * 0.2f), map);
                fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MP5, (float)itemModifier.getValue() * 0.175f), map);
            }
        } else if (itemModifier.getAttribute() != ItemAttributes.SOCKETS) {
            switch (itemModifier.getAttribute()) {
                case ARMOR: {
                    fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.ARMOR, itemModifier.getValue() * 2), map);
                    break;
                }
                case CRITICAL_CHANCE: {
                    fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.CRITICAL_CHANCE, itemModifier.getValue()), map);
                    break;
                }
                case HEALTH: {
                    fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.HEALTH, (float)itemModifier.getValue() / 2.0f), map);
                    break;
                }
                case HP5: {
                    fm.a(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.HP5, itemModifier.getValue() * 5), map);
                    break;
                }
                case INCREASED_RARITY: {
                    fm.a(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.INCREASED_RARITY, (float)itemModifier.getValue() / 2.0f), map);
                    break;
                }
                case LIFE_STEAL: {
                    fm.a(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.LIFE_STEAL, itemModifier.getValue()), map);
                    break;
                }
                case MAGIC_RESIST: {
                    fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MAGIC_RESIST, itemModifier.getValue() * 2), map);
                    break;
                }
                case MANA: {
                    fm.a(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MANA, (float)itemModifier.getValue() / 2.0f), map);
                    break;
                }
                case MP5: {
                    fm.a(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.MP5, itemModifier.getValue() * 3), map);
                    break;
                }
                case POWER: {
                    fm.a(fr.var_fr_a, new ItemModifier(ItemRarity.COMMON, ItemAttributes.POWER, itemModifier.getValue() * 4), map);
                    break;
                }
                case RESILIENCE: {
                    fm.a(fr.c, new ItemModifier(ItemRarity.COMMON, ItemAttributes.RESILIENCE, itemModifier.getValue()), map);
                    break;
                }
                case TENACITY: {
                    fm.a(fr.b, new ItemModifier(ItemRarity.COMMON, ItemAttributes.TENACITY, itemModifier.getValue()), map);
                    break;
                }
            }
        }
    }

    public static boolean a(ItemAttributes itemAttributes) {
        if (itemAttributes == null) {
            return false;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ASSASSIN && (itemAttributes == ItemAttributes.AGILITY || itemAttributes == ItemAttributes.STRENGTH)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.CHAMPION && (itemAttributes == ItemAttributes.AGILITY || itemAttributes == ItemAttributes.STRENGTH)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ELDER && (itemAttributes == ItemAttributes.AGILITY || itemAttributes == ItemAttributes.WISDOM)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.LICH && (itemAttributes == ItemAttributes.STRENGTH || itemAttributes == ItemAttributes.INTELLIGENCE)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.MYSTIC && (itemAttributes == ItemAttributes.INTELLIGENCE || itemAttributes == ItemAttributes.WISDOM)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.NIHILIST && (itemAttributes == ItemAttributes.STRENGTH || itemAttributes == ItemAttributes.INTELLIGENCE)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.PALADIN && (itemAttributes == ItemAttributes.STRENGTH || itemAttributes == ItemAttributes.WISDOM)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.RANGER && (itemAttributes == ItemAttributes.AGILITY || itemAttributes == ItemAttributes.STRENGTH)) {
            return true;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.SCHOLAR && (itemAttributes == ItemAttributes.INTELLIGENCE || itemAttributes == ItemAttributes.WISDOM)) {
            return true;
        }
        return ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.WIZARD && (itemAttributes == ItemAttributes.INTELLIGENCE || itemAttributes == ItemAttributes.WISDOM);
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_b;
    }

    public void a(String string) {
        this.var_java_lang_String_b = string;
    }

    public boolean boolean_c() {
        return this.var_boolean_a;
    }

    public void b(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public void c(int n2) {
        this.var_int_d = n2;
    }

    public int int_d() {
        return this.var_int_d;
    }

    public void c(boolean bl2) {
        this.var_boolean_c = bl2;
    }
}

