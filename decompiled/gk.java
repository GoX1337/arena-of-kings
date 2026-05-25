/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class gk {
    protected Array<String> var_com_badlogic_gdx_utils_Array_java_lang_String__a = new Array();
    protected Array<ajw> b = new Array();
    protected ayi<String, br> cfr_renamed_55;

    public gk() {
        this.var_com_badlogic_gdx_utils_Array_java_lang_String__a = new ayi();
    }

    public ayi<String, br> a() {
        return this.var_com_badlogic_gdx_utils_Array_java_lang_String__a;
    }

    public void a(br br2) {
        ((HashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).put(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), br2);
    }

    public void a(Engine engine, br br2) {
        ((HashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).put(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), br2);
        for (int i2 = 0; i2 < br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().size; ++i2) {
            ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().get(i2);
            engine.a(ajw2);
        }
    }

    public void a(Engine engine) {
        for (int i2 = 0; i2 < this.b.size; ++i2) {
            ajw ajw2 = this.b.get(i2);
            engine.b(ajw2);
        }
        this.b.clear();
    }

    public void a(Engine engine, String string) {
        br br2 = (br)((LinkedHashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).get(string);
        if (br2 != null) {
            for (int i2 = 0; i2 < br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().size; ++i2) {
                ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().get(i2);
                Engine.a("unloading ScreenDependency: " + (Object)((Object)ajw2));
                engine.axc_a().axm_a().boolean_a(ajw2);
                this.b.add(ajw2);
            }
        }
    }

    public void b(Engine engine, br br2) {
        Engine.a("unloadingPlayer " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + " dependencies Size: " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().size);
        for (int i2 = 0; i2 < br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().size; ++i2) {
            ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().get(i2);
            Engine.a("unloading asset: " + (Object)((Object)ajw2));
            engine.b(ajw2);
        }
    }

    public void b(Engine engine, String string) {
        br br2 = (br)((LinkedHashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).get(string);
        if (br2 != null) {
            this.b(engine, br2);
            ((HashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).remove(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a());
        } else {
            Engine.a("couldn't remove player, doesn't exist in party. MEM LEAK MAYBE");
        }
    }

    public void c(Engine engine, String string) {
        br br2 = (br)((LinkedHashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).get(string);
        if (br2 != null) {
            this.var_com_badlogic_gdx_utils_Array_java_lang_String__a.add(string);
        } else {
            Engine.a("couldn't remove player, doesn't exist in party. MEM LEAK MAYBE");
        }
    }

    public void b(Engine engine) {
        for (String string : this.var_com_badlogic_gdx_utils_Array_java_lang_String__a) {
            br br2 = (br)((LinkedHashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).get(string);
            if (br2 == null) continue;
            this.b(engine, br2);
            ((HashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).remove(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a());
        }
        this.var_com_badlogic_gdx_utils_Array_java_lang_String__a.clear();
    }

    public void a(Engine engine, boolean bl2) {
        for (br br2 : ((LinkedHashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).values()) {
            ajw ajw2;
            int n2;
            if (bl2) {
                for (n2 = 0; n2 < br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().size; ++n2) {
                    ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().get(n2);
                    engine.b(ajw2);
                    engine.axc_a().axm_a().boolean_a(ajw2);
                }
                continue;
            }
            if (br2 == ay.ay_a()) continue;
            for (n2 = 0; n2 < br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().size; ++n2) {
                ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a().get(n2);
                engine.b(ajw2);
                engine.axc_a().axm_a().boolean_a(ajw2);
            }
        }
        ((LinkedHashMap)((Object)this.var_com_badlogic_gdx_utils_Array_java_lang_String__a)).clear();
    }
}

