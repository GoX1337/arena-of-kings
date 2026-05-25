/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ArmorRequirement;
import com.arenaofkings.packets.misc.items.ClassRequirement;
import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemArmorType;
import com.arenaofkings.packets.misc.items.ItemAttributes;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemModData;
import com.arenaofkings.packets.misc.items.ItemModifier;
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.arenaofkings.packets.misc.items.ItemSlot;
import com.arenaofkings.packets.misc.items.LevelRequirement;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class fh
extends fm {
    protected ItemSlot var_com_arenaofkings_packets_misc_items_ItemSlot_a = new ArrayList();
    protected List<ItemModifier> var_java_util_List_com_arenaofkings_packets_misc_items_ItemModifier__a;
    protected ItemModifier var_com_arenaofkings_packets_misc_items_ItemModifier_a;
    protected ItemModifier var_com_arenaofkings_packets_misc_items_ItemModifier_b = new ArrayList();
    protected List<EquippableRequirement> var_java_util_List_com_arenaofkings_packets_misc_items_EquippableRequirement__b;
    protected fh var_fh_a = null;
    private String c = "";
    private boolean d = true;
    private int i;

    public fh(ItemLocation itemLocation, int n2) {
        super(itemLocation, n2);
    }

    public fh(ItemData itemData) {
        super(itemData);
        Engine.b("ITEM DATA in " + itemData.toString());
        this.var_com_arenaofkings_packets_misc_items_ItemSlot_a = itemData.getItemSlot();
        if (itemData.getItemModifiers() != null) {
            for (ItemModData itemModData : itemData.getItemModifiers()) {
                ItemModifier itemModifier = new ItemModifier(itemModData);
                this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.add(itemModifier);
                if (itemModifier.getAttribute() == ItemAttributes.SOCKETS) {
                    this.g = itemModifier.getValue();
                }
                Engine.b(itemModData.toString());
            }
        }
        if (itemData.getBaseMod1() != null) {
            this.var_com_arenaofkings_packets_misc_items_ItemModifier_a = new ItemModifier(itemData.getBaseMod1());
        }
        if (itemData.getBaseMod2() != null) {
            this.var_com_arenaofkings_packets_misc_items_ItemModifier_b = new ItemModifier(itemData.getBaseMod2());
        }
        this.var_com_arenaofkings_packets_misc_items_ItemModifier_b = itemData.getRequirements();
        this.void_b();
        Engine.b("ITEM DATA out");
    }

    private void void_b() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        float f2 = 1.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        int n7 = ((fp)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).int_a();
        if (n7 == 1) {
            f3 = 1.0f;
        } else if (n7 == 2) {
            f3 = 1.45f;
        } else if (n7 == 3) {
            f3 = 1.85f;
        } else if (n7 == 4) {
            f3 = 2.35f;
        } else if (n7 == 5) {
            f3 = 3.0f;
        }
        switch (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a) {
            case BACK: {
                f4 *= 0.75f;
                break;
            }
            case CHEST: {
                f4 *= 1.5f;
                break;
            }
            case FEET: {
                f4 *= 0.9f;
                break;
            }
            case HANDS: {
                f4 *= 0.9f;
                break;
            }
            case HEAD: {
                f4 *= 1.15f;
                break;
            }
            case LEGS: {
                f4 *= 1.35f;
                break;
            }
            case NECK: {
                f4 *= 1.75f;
                break;
            }
            case RING: {
                f4 *= 1.75f;
                break;
            }
            case SHOULDER: {
                f4 *= 1.25f;
                break;
            }
            case TRINKET: {
                f4 *= 1.75f;
                break;
            }
            case WEAPON: {
                f4 *= 2.0f;
                break;
            }
            case WRIST: {
                f4 *= 0.8f;
                break;
            }
        }
        Iterator iterator = this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.iterator();
        while (iterator.hasNext()) {
            ItemModifier itemModifier = (ItemModifier)iterator.next();
            n2 += itemModifier.getValue();
            switch (itemModifier.getRarity()) {
                case COMMON: {
                    break;
                }
                case UNCOMMON: {
                    ++n3;
                    break;
                }
                case RARE: {
                    ++n4;
                    break;
                }
                case EPIC: {
                    ++n5;
                    break;
                }
                case LEGENDARY: {
                    ++n6;
                    break;
                }
                case UNIQUE: {
                    ++n6;
                    break;
                }
            }
        }
        this.h = (int)((float)n2 * f4 * f3 * (f2 += 0.05f * (float)n3 + 0.09f * (float)n4 + 0.14f * (float)n5 + 0.2f * (float)n6));
        switch (fi.b[this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.ordinal()]) {
            case 1: {
                this.h = (int)((float)this.h * 0.18f);
                break;
            }
            case 2: {
                this.h = (int)((float)this.h * 0.25f);
                break;
            }
            case 3: {
                this.h = (int)((float)this.h * 0.4f);
                break;
            }
            case 4: {
                this.h = (int)((float)this.h * 0.75f);
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
        }
        if (this.h == 0) {
            this.h = 1;
        } else if (this.h > 1) {
            this.h = (int)((float)this.h * 0.5f);
        }
        if (((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).startsWith("Starter") || ((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).startsWith("Gladiator's")) {
            this.h = 0;
        }
    }

    @Override
    public void a(Engine engine, int n2, int n3, int n4, boolean bl2, boolean bl3) {
        Object object;
        engine.var_azi_a.end();
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        engine.var_axf_a.begin();
        engine.var_axf_a.set(ShapeRenderer.ShapeType.Filled);
        n2 -= n4;
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemLocation.TRADE) {
            n3 -= 120;
            n2 += 5;
        }
        String string = "";
        if (bl2) {
            string = string + "[GRAY]Currently Equipped[]\n";
        }
        string = string + ItemRarity.getColorCode((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)) + (String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a) + "[]";
        String string2 = ItemRarity.getColorCode((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)) + ItemRarity.getFormattedName((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)) + " " + ItemSlot.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemSlot_a) + "[]";
        String string3 = "";
        String string4 = "";
        if (this.var_com_arenaofkings_packets_misc_items_ItemModifier_a != null) {
            string3 = this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getAttribute() != ItemAttributes.MP5 && this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getAttribute() != ItemAttributes.HP5 ? string3 + "+" + this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getValue() + " " + ItemAttributes.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getAttribute()) : string3 + "+" + this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getValue() + " " + ItemAttributes.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getAttribute());
            if (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58)) {
                string3 = string3 + "[GRAY] " + ItemAttributes.getAdvancedTooltipName(this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getAttribute(), this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getValue(), ItemRarity.getColorCode(this.var_com_arenaofkings_packets_misc_items_ItemModifier_a.getRarity())) + "[]";
            }
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemModifier_b != null) {
            string4 = this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getAttribute() != ItemAttributes.MP5 && this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getAttribute() != ItemAttributes.HP5 ? string4 + "+" + this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getValue() + " " + ItemAttributes.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getAttribute()) : string4 + "+" + this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getValue() + " " + ItemAttributes.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getAttribute());
            if (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58)) {
                string4 = string4 + "[GRAY] " + ItemAttributes.getAdvancedTooltipName(this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getAttribute(), this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getValue(), ItemRarity.getColorCode(this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.getRarity())) + "[]";
            }
        }
        String string5 = "";
        boolean bl4 = true;
        if (this.var_com_arenaofkings_packets_misc_items_ItemModifier_b != null && !this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.isEmpty()) {
            for (int i2 = 0; i2 < this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.size(); ++i2) {
                EquippableRequirement equippableRequirement = (EquippableRequirement)this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.get(i2);
                if (equippableRequirement instanceof ClassRequirement) {
                    object = (ClassRequirement)equippableRequirement;
                    if (((ClassRequirement)object).getClassRequirement() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
                        string5 = string5 + "[RED]Requires " + CharacterClass.simpleName(((ClassRequirement)object).getClassRequirement()) + "[]\n";
                        bl4 = false;
                        continue;
                    }
                    string5 = string5 + "Requires " + CharacterClass.simpleName(((ClassRequirement)object).getClassRequirement()) + "\n";
                    continue;
                }
                if (equippableRequirement instanceof ArmorRequirement) {
                    object = (ArmorRequirement)equippableRequirement;
                    switch (((ArmorRequirement)object).getArmorType()) {
                        case CLOTH: {
                            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.LICH) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.MYSTIC) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.SCHOLAR) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.WIZARD)) {
                                string5 = string5 + "Requires " + ItemArmorType.getFormattedName(((ArmorRequirement)object).getArmorType()) + "\n";
                                break;
                            }
                            string5 = string5 + "[RED]Requires " + ItemArmorType.getFormattedName(((ArmorRequirement)object).getArmorType()) + "[]\n";
                            bl4 = false;
                            break;
                        }
                        case LEATHER: {
                            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.ASSASSIN) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.ELDER) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.NIHILIST) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.RANGER)) {
                                string5 = string5 + "Requires " + ItemArmorType.getFormattedName(((ArmorRequirement)object).getArmorType()) + "\n";
                                break;
                            }
                            string5 = string5 + "[RED]Requires " + ItemArmorType.getFormattedName(((ArmorRequirement)object).getArmorType()) + "[]\n";
                            bl4 = false;
                            break;
                        }
                        case MISC: {
                            break;
                        }
                        case PLATE: {
                            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.CHAMPION) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.PALADIN)) {
                                string5 = string5 + "Requires " + ItemArmorType.getFormattedName(((ArmorRequirement)object).getArmorType()) + "\n";
                                break;
                            }
                            string5 = string5 + "[RED]Requires " + ItemArmorType.getFormattedName(((ArmorRequirement)object).getArmorType()) + "[]\n";
                            bl4 = false;
                            break;
                        }
                    }
                    continue;
                }
                if (!(equippableRequirement instanceof LevelRequirement)) continue;
                object = (LevelRequirement)equippableRequirement;
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_e() < ((LevelRequirement)object).getLevelRequirement()) {
                    string5 = string5 + "[RED]Requires Level " + ((LevelRequirement)object).getLevelRequirement() + "[]\n";
                    bl4 = false;
                    continue;
                }
                string5 = string5 + "Requires Level " + ((LevelRequirement)object).getLevelRequirement() + "\n";
            }
        }
        String string6 = "";
        if (((fp)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ASSASSIN) {
            string6 = string6 + "[GREEN]Instant Poison (30%)[]\n";
            string6 = string6 + "[GREEN]Infectious Poison (30%)[]\n";
        }
        if (t.a(agd.class, engine)) {
            string6 = this instanceof fx ? string6 + "[RED]Cannot use while in-game[]\n" : string6 + "[RED]Cannot equip while in-game[]\n";
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == true) {
            string6 = string6 + "[RED]*Corrupted*[]\n";
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != null && !this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.isEmpty()) {
            for (int i3 = 0; i3 < this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.size(); ++i3) {
                if (i3 >= 1) {
                    string6 = string6 + "\n";
                }
                object = (ItemModifier)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.get(i3);
                if (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58)) {
                    string6 = ((ItemModifier)object).getAttribute() == ItemAttributes.MP5 || ((ItemModifier)object).getAttribute() == ItemAttributes.HP5 ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + ((ItemModifier)object).getValue() + " " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.SOCKETS ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "(" + ((ItemModifier)object).getValue() + ")" : (((ItemModifier)object).getAttribute() == ItemAttributes.CRITICAL_CHANCE ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.TENACITY ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% []" : (((ItemModifier)object).getAttribute() == ItemAttributes.RESILIENCE ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.INCREASED_RARITY ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.LIFE_STEAL ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + ((ItemModifier)object).getValue() + " " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]"))))));
                    string6 = string6 + "[GRAY] " + ItemAttributes.getAdvancedTooltipName(((ItemModifier)object).getAttribute(), ((ItemModifier)object).getValue(), ItemRarity.getColorCode(((ItemModifier)object).getRarity())) + "[]";
                    continue;
                }
                string6 = ((ItemModifier)object).getAttribute() == ItemAttributes.MP5 || ((ItemModifier)object).getAttribute() == ItemAttributes.HP5 ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + ((ItemModifier)object).getValue() + " " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.SOCKETS ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + " (" + ((ItemModifier)object).getValue() + ")" : (((ItemModifier)object).getAttribute() == ItemAttributes.CRITICAL_CHANCE ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.TENACITY ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% []" : (((ItemModifier)object).getAttribute() == ItemAttributes.RESILIENCE ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.INCREASED_RARITY ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : (((ItemModifier)object).getAttribute() == ItemAttributes.LIFE_STEAL ? string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()), (double)((ItemModifier)object).getValue()) * 100.0, 2) + "% " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]" : string6 + ItemRarity.getColorCode(((ItemModifier)object).getRarity()) + "+" + ((ItemModifier)object).getValue() + " " + ItemAttributes.getFormattedName(((ItemModifier)object).getAttribute()) + "[]"))))));
            }
        }
        string6 = string6 + (String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemModifier_b);
        String string7 = "";
        if (!((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("Mysterious") && !((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("Membership")) {
            string7 = string7 + "\n\n[GRAY]Press ALT to view advanced tooltip[]";
            if (this.boolean_a() && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && this != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a()) {
                string7 = string7 + "\n[GRAY]Press SHIFT to compare with equipped[]";
                if (ay.ay_a().gd_a().cg_a().boolean_a() && bl3 && !((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("S1")) {
                    string7 = string7 + "\n" + ItemRarity.getColorCode((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)) + "Sell Value: " + this.h;
                }
            }
        }
        int n5 = 154;
        int n6 = 16;
        int n7 = -20;
        int n8 = -8;
        int n9 = 0;
        int n10 = Math.max(300, 48 + azu.a(engine, engine.var_axy_c.a(), string));
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemLocation.TRADE && bl2 && n10 > 300) {
            n2 -= n10 - 300;
        }
        String string8 = "";
        if (!string2.equals("")) {
            string = string + "\n" + string2;
        }
        if (!string3.equals("")) {
            string8 = string8 + string3 + "\n";
        }
        if (!string4.equals("")) {
            string8 = string8 + string4 + "\n";
        }
        if (!string5.equals("")) {
            string8 = string8 + string5;
        }
        if (!string6.equals("")) {
            string8 = string8 + string6 + "\n";
        }
        if (this.boolean_a()) {
            if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a) != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() != null && this != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a()) {
                if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() instanceof ff) {
                    this.c = "";
                    this.c = fm.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a(), this);
                } else if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE) {
                    this.c = fm.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a(), this);
                }
            }
            if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && this == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a()) {
                this.c = "";
            }
        } else {
            this.c = "";
        }
        string8 = azu.a(engine, engine.var_axy_b.a(), string8, n10);
        int n11 = 0;
        n11 = this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && this != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() && !((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("Mysterious") ? azu.b(engine, engine.var_axy_c.a(), string) + azu.b(engine, engine.var_axy_b.a(), string8) + azu.b(engine, engine.var_axy_b.a(), this.c) + azu.b(engine, engine.var_axy_b.a(), string7) : azu.b(engine, engine.var_axy_c.a(), string) + azu.b(engine, engine.var_axy_b.a(), string8) + azu.b(engine, engine.var_axy_b.a(), string7);
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemLocation.TRADE && n11 + this.f > 980) {
            if (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58)) {
                if (((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("Membership")) {
                    n2 -= 200;
                    n3 -= n11 + this.f - 900;
                }
            } else if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemLocation.STASH) {
                n2 -= 200;
                n3 -= n11 + this.f - 900;
            }
        }
        engine.var_axf_a.a((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a), (int)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a, n2, n3 + 4, n10 + 25, n11 + 36, 10.0f);
        n11 += 25;
        engine.var_axf_a.end();
        Gdx.gl.glDisable(3042);
        engine.var_azi_a.begin();
        if (this.boolean_a() && (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) && (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemSlot.CONSUMABLE || !(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() instanceof ff)) && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a) != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() != this) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a().a(engine, n2, n3, 335, true, bl3);
        }
        ((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemModifier_b)).b(0.0f, engine, n2 + 6, n3 + 5 + n11 - 48);
        ((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).b(0.0f, engine, n2 + 2 + 6, n3 + 7 + n11 - 48);
        for (int i4 = 0; i4 < ((fp)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).int_a(); ++i4) {
            if (bl2) {
                ay.ay_a().gd_a().cg_a().ayh_b().a(0.0f, engine.var_azi_a, n2 + 72 + i4 * 21 + (int)((float)engine.a(String.valueOf(ItemRarity.getFormattedName((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)) + " " + ItemSlot.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)), engine.var_axy_b.a()) * 1.0f), n3 + 7 + n11 - 56, 1.0f);
                continue;
            }
            ay.ay_a().gd_a().cg_a().ayh_b().a(0.0f, engine.var_azi_a, n2 + 72 + i4 * 21 + (int)((float)engine.a(String.valueOf(ItemRarity.getFormattedName((ItemRarity)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)) + " " + ItemSlot.getFormattedName(this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)), engine.var_axy_b.a()) * 1.0f), n3 + 7 + n11 - 44, 1.0f);
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemRarity.LEGENDARY || this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemRarity.UNIQUE) {
            ay.ay_a().gd_a().cg_a().ayh_c().a(0.0f, engine.var_azi_a, n2 + (n10 - 58) / 2 - 7, n3 + 5 + n11, 1.0f);
            ay.ay_a().gd_a().cg_a().da_a().a(0.016f, engine, n2 + (n10 - 58) / 2 - 200, n3 + 5 + n11 - 160);
        }
        if (bl2) {
            engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 10 + n2 + 54, n11 + 1 + n3 + 9, 8);
        } else {
            engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 10 + n2 + 54, n11 + 1 + n3, 8);
            if (ay.ay_a().gd_a().cg_a().boolean_a() && bl3) {
                if (((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).startsWith("Gladiator")) {
                    ay.ay_a().gd_a().cg_a().ayh_d().a(0.0f, engine.var_azi_a, 10 + n2 + 197 + (int)((float)engine.a(String.valueOf(this.h), engine.var_axy_b.a()) * 0.6f), n3 + 14, 1.0f);
                } else if (!((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("S1")) {
                    ay.ay_a().gd_a().cg_a().ayh_a().a(0.0f, engine.var_azi_a, 10 + n2 + 197 + (int)((float)engine.a(String.valueOf(this.h), engine.var_axy_b.a()) * 0.6f), n3 + 14, 1.0f);
                }
            }
        }
        engine.a(string8, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2, n11 + n3 + -20 * n9 + -8 - 41, 8);
        if (this.boolean_a() && Gdx.input.isKeyPressed(129) && Gdx.input.isKeyJustPressed(31)) {
            Gdx.app.getClipboard().setContents(azu.a(string + string8));
        }
        if (this.boolean_a() && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && this != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a() && !((String)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).contains("Mysterious")) {
            engine.a("[GRAY]_______________________________________\nSummary if Equipped:\n[]", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2 + 153, n11 + n3 - azu.b(engine, engine.var_axy_b.a(), string8) - 50, 1);
            engine.a(this.c, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2 + 89, n11 + n3 - azu.b(engine, engine.var_axy_b.a(), string8) - 79, 16);
            engine.a(fr.a(fr.var_fr_a), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2 + 100, n11 + n3 - azu.b(engine, engine.var_axy_b.a(), string8) - 100, 8);
            engine.a(fr.a(fr.b), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2 + 100, n11 + n3 - azu.b(engine, engine.var_axy_b.a(), string8) - 123, 8);
            engine.a(fr.a(fr.c), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2 + 100, n11 + n3 - azu.b(engine, engine.var_axy_b.a(), string8) - 146, 8);
        }
        engine.a(string7, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 10 + n2 + 156, n11 + n3 - azu.b(engine, engine.var_axy_b.a(), string8) - azu.b(engine, engine.var_axy_b.a(), this.c) - 41, 1);
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != null) {
            ((ayf)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).a(n2 + n10 - 8, n3 + n11 - 14);
            ((ayf)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).a(16.0f, engine);
            ((ayf)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).b(16.0f, engine);
        }
    }

    public ItemSlot com_arenaofkings_packets_misc_items_ItemSlot_a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemSlot_a;
    }

    public ItemModifier com_arenaofkings_packets_misc_items_ItemModifier_a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemModifier_a;
    }

    public ItemModifier com_arenaofkings_packets_misc_items_ItemModifier_b() {
        return this.var_com_arenaofkings_packets_misc_items_ItemModifier_b;
    }

    public List<ItemModifier> a() {
        return this.var_com_arenaofkings_packets_misc_items_ItemSlot_a;
    }

    public boolean boolean_b() {
        boolean bl2 = true;
        if (this.var_com_arenaofkings_packets_misc_items_ItemModifier_b != null && !this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.isEmpty()) {
            for (int i2 = 0; i2 < this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.size(); ++i2) {
                EquippableRequirement equippableRequirement;
                EquippableRequirement equippableRequirement2 = (EquippableRequirement)this.var_com_arenaofkings_packets_misc_items_ItemModifier_b.get(i2);
                if (equippableRequirement2 instanceof ClassRequirement) {
                    equippableRequirement = (ClassRequirement)equippableRequirement2;
                    if (((ClassRequirement)equippableRequirement).getClassRequirement() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) continue;
                    bl2 = false;
                    continue;
                }
                if (equippableRequirement2 instanceof ArmorRequirement) {
                    equippableRequirement = (ArmorRequirement)equippableRequirement2;
                    switch (((ArmorRequirement)equippableRequirement).getArmorType()) {
                        case CLOTH: {
                            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.LICH) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.MYSTIC) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.SCHOLAR) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.WIZARD)) break;
                            bl2 = false;
                            break;
                        }
                        case LEATHER: {
                            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.ASSASSIN) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.ELDER) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.NIHILIST) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.RANGER)) break;
                            bl2 = false;
                            break;
                        }
                        case MISC: {
                            break;
                        }
                        case PLATE: {
                            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.CHAMPION) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a().equals((Object)CharacterClass.PALADIN)) break;
                            bl2 = false;
                            break;
                        }
                    }
                    continue;
                }
                if (!(equippableRequirement2 instanceof LevelRequirement)) continue;
                equippableRequirement = (LevelRequirement)equippableRequirement2;
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_e() >= ((LevelRequirement)equippableRequirement).getLevelRequirement()) continue;
                bl2 = false;
            }
        }
        return bl2;
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == false) {
            if (t.a(we.class, engine)) {
                this.a(((we)engine.axc_a()).axm_a(), true);
            } else if (t.a(agd.class, engine)) {
                this.a(((agd)engine.axc_a()).axm_a(), true);
            }
        }
        if (this.boolean_a() && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != ItemSlot.CONSUMABLE && this != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).fh_a()) {
            ay.ay_a().gd_a().cg_a().da_b().d(0.016f, this.e + 123, this.f + 80, engine.var_azi_a);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().get((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a).a(true);
            ay.ay_a().gd_a().as_a().a(this.var_com_arenaofkings_packets_misc_items_ItemSlot_a);
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemModifier_b != null) {
            ((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemModifier_b)).b(f2, engine, this.e, this.f);
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != null) {
            ((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).a(this.e + 2, this.f + 2);
            ((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).b(f2, engine);
        }
    }

    @Override
    public void c(float f2, Engine engine) {
        if (this.c != false && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != null && !((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).boolean_a() && this.c != null) {
            ay.ay_a().gd_a().cg_a().da_b().d(0.016f, this.e + 123, this.f + 80, engine.var_azi_a);
            if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != null) {
                switch (fi.b[this.var_com_arenaofkings_packets_misc_items_ItemSlot_a.ordinal()]) {
                    case 1: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.i, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                        break;
                    }
                    case 2: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.j, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                        break;
                    }
                    case 3: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.k, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                        break;
                    }
                    case 4: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.l, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                        break;
                    }
                    case 5: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.m, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                        break;
                    }
                    case 6: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.o, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                    }
                    case 7: {
                        engine.a("NEW", engine.var_axy_b.a(), axe.n, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
                        break;
                    }
                }
            } else {
                engine.a("NEW", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.e + 26), (float)(this.f + 26), 1, 1);
            }
        }
        if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != null && ((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).boolean_a() && this.c != null) {
            if (this.c != false) {
                engine.var_baa_a.a(ajw.ke, ItemRarity.COMMON);
            }
            this.c = (String)false;
            ((ayh)((Object)this.c)).a(f2, engine.var_azi_a, this.e + 1, this.f + 1, 0.8f);
            if (this.d != null) {
                if (this.g == 1) {
                    this.d.a(16.0f, engine.var_azi_a, this.e, this.f + 24, 0.9f);
                } else if (this.g == 2) {
                    this.d.a(16.0f, engine.var_azi_a, this.e, this.f + 24, 0.9f);
                    this.d.a(16.0f, engine.var_azi_a, this.e + 1 + 24, this.f + 24, 0.9f);
                } else if (this.g == 3) {
                    this.d.a(16.0f, engine.var_azi_a, this.e, this.f + 24, 0.9f);
                    this.d.a(16.0f, engine.var_azi_a, this.e + 1 + 24, this.f + 24, 0.9f);
                    this.d.a(16.0f, engine.var_azi_a, this.e, this.f, 0.9f);
                } else if (this.g == 4) {
                    this.d.a(16.0f, engine.var_azi_a, this.e, this.f + 24, 0.9f);
                    this.d.a(16.0f, engine.var_azi_a, this.e + 1 + 24, this.f + 24, 0.9f);
                    this.d.a(16.0f, engine.var_azi_a, this.e, this.f, 0.9f);
                    this.d.a(16.0f, engine.var_azi_a, this.e + 1 + 24, this.f, 0.9f);
                }
            }
            if ((Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58)) && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != fp.bU && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != fp.bV && this.var_com_arenaofkings_packets_misc_items_ItemSlot_a != fp.bW) {
                if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemLocation.STASH) {
                    this.a(engine, 725, 175, 0, false, true);
                } else {
                    this.a(engine, 1180, 175, 0, false, true);
                }
                return;
            }
            if (this.var_com_arenaofkings_packets_misc_items_ItemSlot_a == ItemLocation.TRADE) {
                this.a(engine, 1575, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 50, 0, false, true);
            } else if ((int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 160 < 1920 && (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getX() > 300) {
                if ((int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + this.i < 1080) {
                    this.a(engine, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - 139, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 50, 0, false, true);
                } else {
                    this.a(engine, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - 139, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 50 - (int)(((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)this.i - 1080.0f), 0, false, true);
                }
            } else if ((int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + this.i < 1080) {
                this.a(engine, 1575, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 50, 0, false, true);
            } else {
                this.a(engine, 1575, (int)((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 50 - (int)(((ayh)((Object)this.var_com_arenaofkings_packets_misc_items_ItemSlot_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)this.i - 1080.0f), 0, false, true);
            }
        }
    }

    public List<EquippableRequirement> b() {
        return this.var_com_arenaofkings_packets_misc_items_ItemModifier_b;
    }
}

