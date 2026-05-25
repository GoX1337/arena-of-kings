/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class aae
implements axr {
    private final zz var_zz_a = new ArrayList();
    private final Map<String, ayh> cfr_renamed_0;
    private ayh var_ayh_a;
    private int var_int_a;
    private int b;
    private List<String> var_java_util_List_java_lang_String__a;
    private String var_java_lang_String_a = "unknown";

    public aae(zz zz2, Map<String, ayh> map, ayh ayh2, int n2, int n3) {
        this.var_zz_a = zz2;
        this.var_zz_a = map;
        this.var_int_a = n2;
        this.b = n3;
        this.var_ayh_a = ayh2;
        this.var_zz_a.add(this.a("[RARITY_LEGENDARY]1st[] ", zz2.var_java_lang_String_d, zz2.var_int_e));
        this.var_zz_a.add(this.a("2nd ", zz2.var_java_lang_String_e, zz2.var_int_f));
        this.var_zz_a.add(this.a("3-4th ", zz2.var_java_lang_String_f, zz2.var_int_g));
        this.var_zz_a.add(this.a("5-8th ", zz2.var_java_lang_String_g, zz2.var_int_h));
        this.var_zz_a.add(this.a("9-16th ", zz2.var_java_lang_String_h, zz2.var_int_i));
        this.var_zz_a.add(this.b("17-32nd ", zz2.var_java_lang_String_i, zz2.var_int_j));
        this.var_zz_a.add(this.b("33-64th ", zz2.var_java_lang_String_j, zz2.var_int_k));
        if (zz2.var_java_lang_String_k.contains("blue")) {
            this.var_java_lang_String_a = "blue";
        } else if (zz2.var_java_lang_String_k.contains("purple")) {
            this.var_java_lang_String_a = "purple";
        } else if (zz2.var_java_lang_String_k.contains("orange")) {
            this.var_java_lang_String_a = "orange";
        }
    }

    private String a(String string, String string2, int n2) {
        return string + "      Trophy [RARITY_UNCOMMON]" + n2 + " QP[] " + string2;
    }

    private String b(String string, String string2, int n2) {
        return string + "[RARITY_UNCOMMON]" + n2 + " QP[] " + string2;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        for (int i2 = 0; i2 < this.var_zz_a.size(); ++i2) {
            this.var_ayh_a.a(f2, engine.var_azi_a, this.var_int_a, this.b - 24 * i2, 1.0f);
            engine.a((String)this.var_zz_a.get(i2), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 4), (float)(this.b + 15 - 24 * i2), 8, 1.0f);
            if (i2 == 0) {
                if (this.var_java_lang_String_a.equals("unknown")) continue;
                ((ayh)this.var_zz_a.get(this.var_java_lang_String_a + "_cup")).a(f2, engine.var_azi_a, this.var_int_a + 22, this.b - 12, 1.0f);
                continue;
            }
            if (i2 > 4 || this.var_java_lang_String_a.equals("unknown")) continue;
            if (i2 == 1) {
                ((ayh)this.var_zz_a.get(this.var_java_lang_String_a + "_star")).a(f2, engine.var_azi_a, this.var_int_a + 32, this.b - 24 * i2, 1.0f);
                continue;
            }
            if (i2 == 2) {
                ((ayh)this.var_zz_a.get(this.var_java_lang_String_a + "_star")).a(f2, engine.var_azi_a, this.var_int_a + 46, this.b - 24 * i2, 1.0f);
                continue;
            }
            if (i2 == 3) {
                ((ayh)this.var_zz_a.get(this.var_java_lang_String_a + "_star")).a(f2, engine.var_azi_a, this.var_int_a + 44, this.b - 24 * i2, 1.0f);
                continue;
            }
            if (i2 != 4) continue;
            ((ayh)this.var_zz_a.get(this.var_java_lang_String_a + "_star")).a(f2, engine.var_azi_a, this.var_int_a + 55, this.b - 24 * i2, 1.0f);
        }
    }
}

