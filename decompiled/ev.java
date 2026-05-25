/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.ArrayList;
import java.util.Locale;

public class ev {
    private Engine var_com_arenaofkings_client_core_Engine_a = new ArrayMap();
    private en var_en_a;
    private en b;
    private ArrayMap<String, en> cfr_renamed_54;
    private int var_int_a = 5;

    public ev(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.b = new en(this, "Game", 0, fd.d, engine);
        this.b.c("Party");
        this.a(this.b);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            this.a(new en(this, arrayList.get(i2), i2 + 1, fd.e, engine));
        }
        Engine.b("Channel stuff 1");
        if (!arrayList.isEmpty()) {
            int n2;
            if (((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).containsKey(arrayList.get(0).toLowerCase(Locale.US))) {
                Engine.b("Channel stuff 3");
                en en2 = (en)((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(arrayList.get(0).toLowerCase(Locale.US));
                this.b(en2);
                n2 = 0;
                for (String string : arrayList2) {
                    en2.a(new ew(string, n2++));
                    Engine.b("Channel stuff 4");
                }
                Engine.b("Channel stuff 5");
            }
            if (((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).containsKey(arrayList.get(1).toLowerCase(Locale.US))) {
                Engine.b("Channel stuff 3");
                en en3 = (en)((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(arrayList.get(1).toLowerCase(Locale.US));
                this.b(en3);
                n2 = 0;
                for (String string : arrayList2) {
                    en3.a(new ew(string, n2++));
                    Engine.b("Channel stuff 4");
                }
                Engine.b("Channel stuff 5");
            }
            if (((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).containsKey(arrayList.get(2).toLowerCase(Locale.US))) {
                Engine.b("Channel stuff 3");
                en en4 = (en)((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(arrayList.get(2).toLowerCase(Locale.US));
                this.b(en4);
                n2 = 0;
                for (String string : arrayList2) {
                    en4.a(new ew(string, n2++));
                    Engine.b("Channel stuff 4");
                }
                Engine.b("Channel stuff 5");
            }
        }
        this.b(this.b);
    }

    public void a(en en2) {
        if (((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size < this.var_int_a) {
            ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(en2.java_lang_String_a().toLowerCase(Locale.US), en2);
        }
    }

    public void b(en en2) {
        this.var_en_a = en2;
    }

    public void void_a(String string) {
        if (((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(string) != null) {
            this.var_en_a = (en)((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(string.toLowerCase(Locale.US));
        }
    }

    public en en_a(String string) {
        Engine.b("Trying to findChannel: " + string);
        if (string == null) {
            return this.b;
        }
        if (string.equalsIgnoreCase("Game")) {
            Engine.b("returning Game Channel");
            return this.b;
        }
        for (en en2 : ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).values()) {
            if (!en2.java_lang_String_a().equalsIgnoreCase(string) && !en2.java_lang_String_b().equalsIgnoreCase(string)) continue;
            Engine.b("returning " + en2.java_lang_String_a() + " Channel");
            return en2;
        }
        Engine.b("Returning a null find");
        return null;
    }

    public en a(String string, String string2) {
        for (en en2 : ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).values()) {
            if (!en2.java_lang_String_a().equalsIgnoreCase(string) || en2.fd_a() != fd.c) continue;
            return en2;
        }
        en en3 = new en(this, string, ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size, fd.c, this.var_com_arenaofkings_client_core_Engine_a);
        en3.c(string2);
        ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(string.toLowerCase(Locale.US), en3);
        Engine.b("Created whisperChannel: " + string);
        en3.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a());
        en3.a(string2);
        return en3;
    }

    public en b(String string) {
        for (en en2 : ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).values()) {
            Engine.b("KEY: " + string + " channelName: " + en2.java_lang_String_a() + " renderName: " + en2.java_lang_String_b() + " channelType: " + (Object)((Object)en2.fd_a()));
            if (en2.java_lang_String_b().equalsIgnoreCase(string)) {
                Engine.b("match");
            }
            if (!en2.java_lang_String_a().equalsIgnoreCase(string) && !en2.java_lang_String_b().equalsIgnoreCase(string) || en2.fd_a() != fd.c) continue;
            Engine.b("HIT! returning channel: " + string);
            return en2;
        }
        return null;
    }

    public en a(int n2) {
        for (en en2 : ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).values()) {
            if (en2.int_a() != n2) continue;
            return en2;
        }
        return null;
    }

    public en en_a() {
        return this.b;
    }

    public en b() {
        return this.var_en_a;
    }

    public ArrayMap<String, en> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public void a(TextureAtlas textureAtlas) {
        for (ObjectMap.Entry entry : ((ArrayMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).entries()) {
            ((en)entry.value).a(textureAtlas);
        }
    }

    public void void_a() {
        this.var_en_a = this.b;
    }
}

