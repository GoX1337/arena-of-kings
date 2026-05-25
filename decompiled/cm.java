/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_ITEM_MYSTERY_PURCHASE;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemSlot;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

public class cm
extends cj {
    private List<fp> b = new ArrayList<fp>();
    private List<fp> c = new ArrayList<fp>();

    public cm(Engine engine, cg cg2) {
        super(engine, cg2);
        this.c.add(fp.bU);
        this.c.add(fp.bV);
        this.c.add(fp.bW);
        this.c.add(fp.bX);
        this.c.add(fp.bY);
        this.c.add(fp.bZ);
        this.c.add(fp.ca);
        this.c.add(fp.cb);
        this.c.add(fp.cc);
        this.c.add(fp.cd);
        this.c.add(fp.ce);
        this.c.add(fp.cf);
        this.c.add(fp.cg);
        this.c.add(fp.ch);
        this.c.add(fp.ci);
        for (fp fp2 : fp.values()) {
            if (fp2.int_a() != 1 || this.c.contains((Object)fp2)) continue;
            this.b.add(fp2);
        }
        TextureAtlas textureAtlas = engine.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.a = new cn(this, 163, 887, textureAtlas, "vendor_mystery_default", "vendor_mystery_hovered", true, cg2);
    }

    public void void_a() {
        Engine.b("repopulateDropTable in");
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() == null) {
            Engine.b("NOT YET LOADED");
            return;
        }
        this.b.clear();
        for (fp fp2 : fp.values()) {
            if (fp2.int_b() > ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_e() || this.c.contains((Object)fp2)) continue;
            this.b.add(fp2);
        }
        Engine.b("repopulateDropTable out");
    }

    public void b() {
        this.a.clear();
        for (int i2 = 0; i2 < 8 + MathUtils.random(4); ++i2) {
            fh fh2;
            ItemData itemData = new ItemData();
            fp fp2 = this.b.get(MathUtils.random(this.b.size() - 1));
            itemData.itemBase = String.valueOf((Object)fp2);
            itemData.itemRarity = "UNIQUE";
            itemData.itemSlot = fp2.com_arenaofkings_packets_misc_items_ItemSlot_a();
            itemData.requirements = (ArrayList)fp2.a();
            itemData.name = "Mysterious " + fp2.java_lang_String_a();
            itemData.itemLocation = ItemLocation.VENDOR;
            itemData.itemPosition = i2;
            if (fp2.com_arenaofkings_packets_misc_items_ItemSlot_a() == ItemSlot.WEAPON) {
                fh2 = new ga(itemData);
                fh2.a("[RARITY_UNIQUE]\"Imbued with varying levels of ordinary and mystical powers.\" - Adali[]\n[PARCHMENT]Right click to buy");
                this.a.add(fh2);
                continue;
            }
            if (fp2.com_arenaofkings_packets_misc_items_ItemSlot_a() == ItemSlot.RING || fp2.com_arenaofkings_packets_misc_items_ItemSlot_a() == ItemSlot.NECK || fp2.com_arenaofkings_packets_misc_items_ItemSlot_a() == ItemSlot.TRINKET) {
                fh2 = new fy(itemData);
                fh2.a("[RARITY_UNIQUE]\"Imbued with varying levels of ordinary and mystical powers.\" - Adali[]\n[PARCHMENT]Right click to buy");
                this.a.add(fh2);
                continue;
            }
            fh2 = new fv(itemData);
            fh2.a("[RARITY_UNIQUE]\"Imbued with varying levels of ordinary and mystical powers.\" - Adali[]\n[PARCHMENT]Right click to buy");
            this.a.add(fh2);
        }
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.a) {
            for (fm fm2 : this.a) {
                fm2.b(f2, this.a);
                this.a.a("Mysterious " + fp.a(fm2.fp_a()), this.a.var_axy_b.a(), axe.o, this.a.var_axy_b.a(), Color.BLACK, (float)(fm2.int_b() + 60), (float)(fm2.int_c() + 48), 8, 1);
                this.a.var_ayh_a.b(f2, this.a, fm2.int_b() + 184, fm2.int_c() - 4);
                this.a.a("" + fm2.fp_a().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_e(), fm2.fp_a()), this.a.var_axy_b.a(), Color.WHITE, this.a.var_axy_b.a(), Color.BLACK, (float)(fm2.int_b() + 180), (float)(fm2.int_c() + 12), 16, 1);
                if (!(fm2 instanceof fh) || ((fh)fm2).boolean_b()) continue;
                this.a.e.b(f2, this.a, fm2.int_b() - 10, fm2.int_c() - 10);
                this.a.e.b(f2, this.a, fm2.int_b() - 10, fm2.int_c() - 10);
            }
        }
    }

    public void c() {
        for (fm fm2 : this.a) {
            PublicPacket publicPacket;
            if (!(fm2 instanceof fh) || !fm2.boolean_a()) continue;
            if (ay.ay_a().gd_a().as_a().boolean_b()) {
                publicPacket = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Your Inventory is full.");
                publicPacket.channel = " ";
                ((we)this.a.axc_a()).wh_a().wg_a().a((PUB_MISC_CHAT_MESSAGE)publicPacket, " ", true);
                this.a.var_baa_a.a(ajw.kG, 0.6f);
                break;
            }
            if (ay.ay_a().gd_a().int_a() < fm2.fp_a().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_e(), fm2.fp_a())) {
                publicPacket = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Not enough Silver.");
                publicPacket.channel = " ";
                ((we)this.a.axc_a()).wh_a().wg_a().a((PUB_MISC_CHAT_MESSAGE)publicPacket, " ", true);
                this.a.var_baa_a.a(ajw.kG, 0.6f);
                break;
            }
            publicPacket = new PUB_ITEM_MYSTERY_PURCHASE();
            ((PUB_ITEM_MYSTERY_PURCHASE)publicPacket).itemBase = fm2.fp_a().name();
            ((PUB_ITEM_MYSTERY_PURCHASE)publicPacket).position = fm2.int_a();
            this.a.var_z_a.void_a(publicPacket);
        }
    }

    public void d() {
        for (fm fm2 : this.a) {
            if (!fm2.boolean_a()) continue;
            fm2.a(this.a, (int)this.a.var_com_badlogic_gdx_math_Vector3_a.x + 125, (int)this.a.var_com_badlogic_gdx_math_Vector3_a.y, 0, false, false);
        }
    }
}

