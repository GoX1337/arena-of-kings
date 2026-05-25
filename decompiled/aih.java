/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class aih {
    private Array<aif> var_com_badlogic_gdx_utils_Array_aif__a = new Array();
    private Array<aif> var_com_badlogic_gdx_utils_Array_aif__b = new Array();
    private Array<aia> var_com_badlogic_gdx_utils_Array_aia__c = new Array();
    private Array<aia> d = new Array();
    private Array<aia> e = new Array();
    private Array<aia> f = new Array();
    private ayh var_ayh_a;
    private final el var_el_a;
    private final azv var_azv_a;
    private final azv var_azv_b;
    private azv var_azv_c = new azv(350L, true);
    private int var_int_a = 0;
    private int var_int_b = 0;

    public aih(el el2) {
        this.var_el_a = el2;
        this.var_azv_a = new azv(150L, true);
        this.var_azv_b = new azv(350L, true);
    }

    public void a(TextureAtlas textureAtlas) {
        this.var_ayh_a = new ayh(0, 0, textureAtlas, "SilverCoin", true);
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.175f);
    }

    public void a(float f2, Engine engine) {
        if (this.var_azv_a.boolean_b()) {
            this.var_azv_a.void_c();
        }
        if (this.var_com_badlogic_gdx_utils_Array_aif__b.size >= 2) {
            aif aif2 = new aif(engine, 0.0, "", Color.BLUE, false, 0.0f, 0.0f, 2);
            aif aif3 = new aif(engine, 0.0, "", Color.SKY, false, 0.0f, 0.0f, 0);
            for (aif aif4 : this.var_com_badlogic_gdx_utils_Array_aif__b) {
                if (aif4.boolean_a()) {
                    Engine.a("handling emphasized event");
                    continue;
                }
                Engine.a("handling unemphasized event");
                if (aif4.double_a() < 0.0) {
                    aif2.a(aif2.double_a() + aif4.double_a(), aif4.com_badlogic_gdx_graphics_Color_a(), aif4.float_a(), aif4.float_b());
                    continue;
                }
                if (!(aif4.double_a() > 0.0)) continue;
                aif3.a(aif3.double_a() + aif4.double_a(), aif4.com_badlogic_gdx_graphics_Color_a(), aif4.float_a(), aif4.float_b());
            }
            if (aif2.boolean_b()) {
                aif2.a(aif2.java_lang_String_a() + " " + gx.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()));
                this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif2);
            }
            if (aif3.boolean_b()) {
                aif3.a(aif3.java_lang_String_a() + " " + gx.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()));
                this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif3);
            }
            Engine.a("post size: " + this.var_com_badlogic_gdx_utils_Array_aia__c.size);
        } else if (this.var_com_badlogic_gdx_utils_Array_aif__b.size == 1) {
            this.a(this.var_com_badlogic_gdx_utils_Array_aif__b.get(0));
        }
        this.var_com_badlogic_gdx_utils_Array_aif__b.clear();
        if (this.var_azv_b.boolean_b()) {
            this.var_azv_b.void_c();
            if (this.var_int_a <= 2) {
                this.a(engine);
            } else {
                this.b(engine);
            }
            this.var_int_a = 0;
            this.var_int_b = 0;
        }
        if (this.var_com_badlogic_gdx_utils_Array_aia__c.size > 0 && (!this.var_el_a.boolean_b() || ay.ay_a().boolean_a(this.var_el_a.java_lang_String_a()) && this.var_el_a.boolean_b())) {
            for (int i2 = 0; i2 < this.var_com_badlogic_gdx_utils_Array_aia__c.size; ++i2) {
                if (this.var_com_badlogic_gdx_utils_Array_aia__c.get(i2).azv_a().boolean_b()) {
                    this.e.add(this.var_com_badlogic_gdx_utils_Array_aia__c.get(i2));
                    continue;
                }
                this.var_com_badlogic_gdx_utils_Array_aia__c.get(i2).b(f2, engine);
            }
            if (this.e.size > 0) {
                this.var_com_badlogic_gdx_utils_Array_aia__c.removeAll(this.e, true);
                this.e.clear();
            }
        }
        if (this.d.size > 0 && (!this.var_el_a.boolean_b() || ay.ay_a().boolean_a(this.var_el_a.java_lang_String_a()) && this.var_el_a.boolean_b())) {
            for (int i3 = 0; i3 < this.d.size; ++i3) {
                if (this.d.get(i3).azv_a().boolean_b()) {
                    this.e.add(this.d.get(i3));
                    continue;
                }
                this.d.get(i3).b(f2, engine);
            }
            if (this.e.size > 0) {
                this.d.removeAll(this.e, true);
                this.e.clear();
            }
        }
    }

    public void b(float f2, Engine engine) {
        for (int i2 = 0; i2 < this.f.size; ++i2) {
            if (this.f.get(i2).azv_a().boolean_b()) {
                this.e.add(this.f.get(i2));
                continue;
            }
            this.f.get(i2).b(f2, engine);
        }
        if (this.e.size > 0) {
            this.f.removeAll(this.e, true);
            this.e.clear();
        }
    }

    public void a(aif aif2) {
        if (aif2.boolean_a()) {
            this.d.add(aif2);
        } else {
            this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif2);
        }
    }

    private void a(Engine engine) {
        for (aif aif2 : this.var_com_badlogic_gdx_utils_Array_aif__a) {
            this.a(aif2);
        }
        this.var_com_badlogic_gdx_utils_Array_aif__a.clear();
    }

    private void b(Engine engine) {
        aif aif2;
        aif aif3;
        if (this.var_com_badlogic_gdx_utils_Array_aif__b.size >= 2) {
            aif3 = new aif(engine, 0.0, "", Color.BLUE, false, 0.0f, 0.0f, 2);
            aif2 = new aif(engine, 0.0, "", Color.SKY, false, 0.0f, 0.0f, 0);
            for (aif aif4 : this.var_com_badlogic_gdx_utils_Array_aif__b) {
                if (aif4.boolean_a()) {
                    Engine.a("handling emphasized event");
                    continue;
                }
                Engine.a("handling unemphasized event");
                if (aif4.double_a() < 0.0) {
                    aif3.a(aif3.double_a() + aif4.double_a(), aif4.com_badlogic_gdx_graphics_Color_a(), aif4.float_a(), aif4.float_b());
                    continue;
                }
                if (!(aif4.double_a() > 0.0)) continue;
                aif2.a(aif2.double_a() + aif4.double_a(), aif4.com_badlogic_gdx_graphics_Color_a(), aif4.float_a(), aif4.float_b());
            }
            if (aif3.boolean_b()) {
                aif3.a(aif3.java_lang_String_a() + " " + gx.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()));
                this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif3);
            }
            if (aif2.boolean_b()) {
                aif2.a(aif2.java_lang_String_a() + " " + gx.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()));
                this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif2);
            }
            Engine.a("post size: " + this.var_com_badlogic_gdx_utils_Array_aia__c.size);
        } else if (this.var_com_badlogic_gdx_utils_Array_aif__b.size == 1) {
            this.a(this.var_com_badlogic_gdx_utils_Array_aif__b.get(0));
        }
        this.var_com_badlogic_gdx_utils_Array_aif__b.clear();
        if (this.var_com_badlogic_gdx_utils_Array_aif__a.size >= 2) {
            aif aif4;
            aif3 = new aif(engine, 0.0, "", Color.GOLD, true, 0.0f, 0.0f, 2);
            aif2 = new aif(engine, 0.0, "", Color.GOLD, false, 0.0f, 0.0f, 2);
            aif aif5 = new aif(engine, 0.0, "", Color.GREEN, true, 0.0f, 0.0f, 1);
            aif4 = new aif(engine, 0.0, "", Color.GREEN, false, 0.0f, 0.0f, 1);
            for (aif aif6 : this.var_com_badlogic_gdx_utils_Array_aif__a) {
                if (aif6.boolean_a()) {
                    Engine.a("handling emphasized event");
                    if (aif6.double_a() < 0.0) {
                        aif3.a(aif3.double_a() + aif6.double_a(), aif6.com_badlogic_gdx_graphics_Color_a(), aif6.float_a(), aif6.float_b());
                        continue;
                    }
                    if (!(aif6.double_a() > 0.0)) continue;
                    aif5.a(aif5.double_a() + aif6.double_a(), aif6.com_badlogic_gdx_graphics_Color_a(), aif6.float_a(), aif6.float_b());
                    continue;
                }
                Engine.a("handling unemphasized event");
                if (aif6.double_a() < 0.0) {
                    aif2.a(aif2.double_a() + aif6.double_a(), aif6.com_badlogic_gdx_graphics_Color_a(), aif6.float_a(), aif6.float_b());
                    continue;
                }
                if (!(aif6.double_a() > 0.0)) continue;
                aif4.a(aif4.double_a() + aif6.double_a(), aif6.com_badlogic_gdx_graphics_Color_a(), aif6.float_a(), aif6.float_b());
            }
            if (aif3.boolean_b()) {
                this.d.add(aif3);
            }
            if (aif2.boolean_b()) {
                this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif2);
            }
            if (aif5.boolean_b()) {
                this.d.add(aif5);
            }
            if (aif4.boolean_b()) {
                this.var_com_badlogic_gdx_utils_Array_aia__c.add(aif4);
            }
            Engine.a("post size: " + this.var_com_badlogic_gdx_utils_Array_aia__c.size);
        } else if (this.var_com_badlogic_gdx_utils_Array_aif__a.size == 1) {
            this.a(this.var_com_badlogic_gdx_utils_Array_aif__a.get(0));
        }
        this.var_com_badlogic_gdx_utils_Array_aif__a.clear();
    }

    public void b(aif aif2) {
        if (aif2.boolean_a()) {
            this.b((aia)aif2);
        } else {
            this.b((aia)aif2);
        }
    }

    public void c(aif aif2) {
        this.var_com_badlogic_gdx_utils_Array_aif__b.add(aif2);
    }

    public void a(aia aia2) {
        if (this.var_azv_c.boolean_b()) {
            this.var_azv_c.void_c();
            this.f.clear();
            if (aia2 instanceof aib) {
                aia2.a(0);
            } else if (aia2 instanceof aid) {
                aia2.a(0);
            } else {
                aia2.a(MathUtils.random(3));
            }
            this.f.add(aia2);
        }
    }

    public void b(aia aia2) {
        Engine.a("pushed gui event: " + aia2.float_a() + " " + aia2.float_b() + " " + aia2.getClass().getName());
        if (aia2 instanceof aif) {
            aif aif2 = (aif)aia2;
            if (aif2.boolean_a()) {
                aia2.a(0);
                if (this.var_int_b != 0) {
                    aia2.var_float_a += (float)MathUtils.random(-50, 50);
                    System.out.println("Recent emph: " + this.var_int_b);
                }
                ++this.var_int_b;
            } else {
                if (this.var_int_a % 2 == 1) {
                    aia2.a(1);
                    aia2.var_float_a += (float)MathUtils.random(25, 75);
                } else {
                    aia2.a(2);
                    aia2.var_float_a += (float)(MathUtils.random(25, 75) * -1);
                }
                ++this.var_int_a;
            }
        } else {
            aia2.a(MathUtils.random(3));
        }
        if (!aia2.c) {
            boolean bl2 = true;
            while (bl2) {
                Iterator iterator = this.d.iterator();
                while (iterator.hasNext()) {
                    int n2;
                    int n3;
                    aia aia3 = (aia)iterator.next();
                    if (aia2.var_float_a >= aia3.var_float_a - 24.0f && aia2.var_float_a <= aia3.var_float_a + 24.0f && aia2.var_float_b >= aia3.var_float_b - 24.0f && aia2.var_float_b <= aia3.var_float_b + 24.0f && aia3.azv_a().int_b() < 200) {
                        iterator.remove();
                        bl2 = false;
                        break;
                    }
                    if (aia2.var_float_b >= aia3.var_float_b - 24.0f && aia2.var_float_b <= aia3.var_float_b + 24.0f && aia3.azv_a().int_b() >= 200) {
                        n3 = (int)(aia2.var_float_b - aia3.var_float_b);
                        n2 = 25 - n3;
                        aia2.var_float_b += (float)n2;
                        bl2 = true;
                        continue;
                    }
                    if (!(aia2.var_float_a >= aia3.var_float_a - 24.0f) || !(aia2.var_float_a <= aia3.var_float_a + 24.0f) || aia3.azv_a().int_b() < 200) continue;
                    n3 = (int)(aia2.var_float_b - aia3.var_float_b);
                    n2 = 25 - n3;
                    aia2.var_float_b += (float)n2;
                    bl2 = true;
                }
                bl2 = false;
            }
        }
        if (aia2.boolean_a()) {
            this.d.add(aia2);
        } else {
            this.var_com_badlogic_gdx_utils_Array_aia__c.add(aia2);
        }
    }

    public ayh a() {
        return this.var_ayh_a;
    }
}

