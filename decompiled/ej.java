/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.items.ItemAttributes;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemModifier;
import com.arenaofkings.packets.misc.items.ItemSlot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ej
extends el {
    private eh var_eh_a;
    private int p;
    private Target var_com_arenaofkings_packets_gameserver_data_Target_a = new Target("");
    private ui var_ui_a;
    private Map<ItemSlot, am> cfr_renamed_52;
    private int q;
    private int r;
    private int s;

    public ej(Engine engine, String string, CharacterClass characterClass, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int n2, int n3, String string10, String string11, String string12, String string13, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, ArrayList<ItemData> arrayList) {
        super(characterClass);
        this.a(string);
        this.g(n3);
        this.a(characterClass);
        this.q = n13;
        this.r = n14;
        this.s = n15;
        this.k = n10;
        this.l = n11;
        this.var_eh_a = new HashMap(11);
        this.var_eh_a.put(ItemSlot.WEAPON, new am(ItemSlot.WEAPON, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.HEAD, new am(ItemSlot.HEAD, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.SHOULDER, new am(ItemSlot.SHOULDER, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.CHEST, new am(ItemSlot.CHEST, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.BACK, new am(ItemSlot.BACK, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.WRIST, new am(ItemSlot.WRIST, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.HANDS, new am(ItemSlot.HANDS, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.LEGS, new am(ItemSlot.LEGS, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.FEET, new am(ItemSlot.FEET, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.NECK, new am(ItemSlot.NECK, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.RING, new am(ItemSlot.RING, ItemLocation.EQUIPPED, null));
        this.var_eh_a.put(ItemSlot.TRINKET, new am(ItemSlot.TRINKET, ItemLocation.EQUIPPED, null));
        if (arrayList != null) {
            for (ItemData itemData : arrayList) {
                Engine.b("Loading equipped item data: " + itemData.getName() + " " + (Object)((Object)itemData.getItemSlot()));
                switch (itemData.getItemSlot()) {
                    case HEAD: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.HEAD)).a(new fv(itemData), engine);
                        break;
                    }
                    case SHOULDER: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.SHOULDER)).a(new fv(itemData), engine);
                        break;
                    }
                    case CHEST: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.CHEST)).a(new fv(itemData), engine);
                        break;
                    }
                    case HANDS: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.HANDS)).a(new fv(itemData), engine);
                        break;
                    }
                    case WRIST: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.WRIST)).a(new fv(itemData), engine);
                        break;
                    }
                    case LEGS: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.LEGS)).a(new fv(itemData), engine);
                        break;
                    }
                    case FEET: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.FEET)).a(new fv(itemData), engine);
                        break;
                    }
                    case BACK: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.BACK)).a(new fv(itemData), engine);
                        break;
                    }
                    case NECK: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.NECK)).a(new fy(itemData), engine);
                        break;
                    }
                    case RING: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.RING)).a(new fy(itemData), engine);
                        break;
                    }
                    case TRINKET: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.TRINKET)).a(new fy(itemData), engine);
                        break;
                    }
                    case WEAPON: {
                        ((am)this.var_eh_a.get((Object)ItemSlot.WEAPON)).a(new ga(itemData), engine);
                        break;
                    }
                }
            }
        }
        this.a(characterClass, -1, -1);
        this.a(new gu(engine, characterClass, string2, string3, string4, string5, string6, string7, string8, string9));
        this.e(n2);
        this.f(n4);
        Engine.b("set character level: " + n4);
        this.p = n5;
        this.var_eh_a = eh.a(n4);
        this.g = n6;
        this.h = n7;
        this.m = n12;
        this.i = n8;
        this.j = n9;
        this.r = n14;
        this.s = n15;
        this.var_eh_a = db.var_db_a;
        this.var_eh_a = new EffectManager(engine);
        this.var_eh_a = new cr(engine, (HitCircle)((Object)this.var_eh_a), (gz)((Object)this.var_eh_a), characterClass, (db)((Object)this.var_eh_a), n3);
        this.var_eh_a = new bb(engine, (HitCircle)((Object)this.var_eh_a), (cr)((Object)this.var_eh_a), (EffectManager)((Object)this.var_eh_a), characterClass);
        ((EffectManager)((Object)this.var_eh_a)).setMovementManager((az)((Object)this.var_eh_a));
        ((cr)((Object)this.var_eh_a)).a((az)((Object)this.var_eh_a));
        this.a(engine, true);
        this.a(ProfileBackgrounds.valueOf(string10));
        this.a(abi.valueOf(string11), 1);
        this.a(abi.valueOf(string12), 2);
        this.a(abi.valueOf(string13), 3);
        this.void_b();
        this.void_g();
    }

    @Override
    public void void_a() {
        Engine.b("calcAllAttributes");
        this.b.b();
        for (am am2 : this.var_eh_a.values()) {
            Class<? extends dc> clazz;
            Object object;
            fh fh2 = am2.fh_a();
            if (fh2 instanceof ff) continue;
            if (fh2.com_arenaofkings_packets_misc_items_ItemModifier_a() != null && (object = this.b.dc_a(clazz = ItemAttributes.getAttributeClass(fh2.com_arenaofkings_packets_misc_items_ItemModifier_a().getAttribute()))) != null) {
                ((dc)object).b(fh2.com_arenaofkings_packets_misc_items_ItemModifier_a().getValue());
            }
            if (fh2.com_arenaofkings_packets_misc_items_ItemModifier_b() != null && (object = this.b.dc_a(clazz = ItemAttributes.getAttributeClass(fh2.com_arenaofkings_packets_misc_items_ItemModifier_b().getAttribute()))) != null) {
                ((dc)object).b(fh2.com_arenaofkings_packets_misc_items_ItemModifier_b().getValue());
            }
            clazz = fh2.a().iterator();
            while (clazz.hasNext()) {
                Class<? extends dc> clazz2;
                dc dc2;
                object = (ItemModifier)clazz.next();
                if (object == null || (dc2 = this.b.dc_a(clazz2 = ItemAttributes.getAttributeClass(((ItemModifier)object).getAttribute()))) == null) continue;
                dc2.b(((ItemModifier)object).getValue());
            }
        }
        super.void_a();
        Engine.b("current armor values: " + this.b.dc_a(dj.class).double_a() + " " + this.b.dc_a(dj.class).double_b() + " " + this.c.double_a(dj.class) + " " + this.c.b(dj.class));
    }

    private void void_g() {
    }

    public Target com_arenaofkings_packets_gameserver_data_Target_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_Target_a;
    }

    public void a(Target target) {
        this.var_com_arenaofkings_packets_gameserver_data_Target_a = target;
        if (target.getPlayer() != null) {
            target.getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ahs_a().void_a();
        }
    }

    @Override
    public bb bb_a() {
        return (bb)((Object)this.var_eh_a);
    }

    @Override
    public gu gu_a() {
        return (gu)((Object)this.var_eh_a);
    }

    public void a(ui ui2) {
        this.var_ui_a = ui2;
    }

    public ui ui_a() {
        return this.var_ui_a;
    }

    public Map<ItemSlot, am> a() {
        return this.var_eh_a;
    }

    public am am_a(int n2) {
        System.out.println("getEquippableSlot()");
        am am2 = null;
        for (am am3 : this.var_eh_a.values()) {
            System.out.println("s: " + (Object)((Object)am3.com_arenaofkings_packets_misc_items_ItemSlot_a()));
            if (am3.fh_a() == null) {
                System.out.println("item is null");
            } else {
                System.out.println("item pos: " + am3.fh_a().int_a());
            }
            if (am3.fh_a().int_a() != n2) continue;
            System.out.println("Found slot: " + (Object)((Object)am3.com_arenaofkings_packets_misc_items_ItemSlot_a()));
            am2 = am3;
            break;
        }
        return am2;
    }

    public void a(Engine engine, int n2, boolean bl2, boolean bl3) {
        if (this.b == 20) {
            return;
        }
        String string = "";
        string = n2 == 72 ? "[RARITY_UNCOMMON]You gained " + n2 + " Experience [AOK_GOLD_GAIN](+10% Recruit A Friend!).[]" : "[RARITY_UNCOMMON]You gained " + n2 + " Experience.[]";
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).agn_a().i_a().a(string);
        } else if (t.a(we.class, engine)) {
            ((we)engine.axc_a()).wh_a().wg_a().a(string);
        }
        this.p += n2;
        if (eh.boolean_a(this.b, this.p)) {
            int n3 = eh.int_a(this.b, this.p);
            ++this.b;
            this.p = Math.abs(n3);
            this.var_eh_a = eh.a(this.b);
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().i_a().a("[RARITY_UNCOMMON]Congratulations! you've reached level " + this.b + ".");
            } else if (t.a(we.class, engine)) {
                ((we)engine.axc_a()).wh_a().wg_a().a("[RARITY_UNCOMMON]Congratulations! you've reached level " + this.b + ".");
            }
        }
    }

    public eh eh_a() {
        return this.var_eh_a;
    }

    public int int_a() {
        return this.p;
    }

    public int int_b() {
        return this.q;
    }

    public void b(int n2) {
        this.q = n2;
    }

    public int int_c() {
        return this.r;
    }

    public int int_d() {
        return this.s;
    }

    public void c(int n2) {
        this.r = n2;
    }

    public void d(int n2) {
        this.s = n2;
    }

    public String toString() {
        return this.var_eh_a;
    }
}

