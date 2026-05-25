/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_SPELL_REQUEST;
import com.arenaofkings.packets.gameserver.requests.input.SPELL_REQUEST;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.math.Vector3;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class gu
extends gt {
    private ui[] var_ui_arr_a = new ui[9];
    private ui[] var_ui_arr_b = new ui[9];
    private boolean var_boolean_b = true;
    private Map<Integer, ui> cfr_renamed_56;
    private List<ui> var_java_util_List_ui__a;
    private azv var_azv_a;
    private azv var_azv_b;
    private azv var_azv_c;
    private DecimalFormat var_java_text_DecimalFormat_a;
    private String var_java_lang_String_a = "";
    private boolean var_boolean_c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    public gu(Engine engine, CharacterClass characterClass, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        super(engine, 1);
        this.var_ui_arr_a = new HashMap();
        this.var_ui_arr_a = new ArrayList();
        this.var_azv_a = new azv(1000L, false);
        this.var_azv_b = new azv(650L, true);
        this.var_azv_c = new azv(650L, true);
        this.var_java_text_DecimalFormat_a = new DecimalFormat("#.#");
        Engine.b("[LOADING SPELLBAR]");
        this.b(CharacterClass.convertToString(characterClass) + "_Basic", 1);
        this.b(string, 2);
        this.b(string2, 3);
        this.b(string3, 4);
        this.b(string4, 5);
        this.b(string5, 6);
        this.b(string6, 7);
        this.b(string7, 8);
        this.b(string8, 9);
        if (characterClass == CharacterClass.ELDER) {
            this.void_a(SpellName.Bear);
        }
    }

    public void void_a(SpellName spellName) {
        if (spellName == SpellName.Bear) {
            Engine.b("LOADED BEAR BAR");
            this.a(this.var_ui_arr_b, "Elder_Basic", 1);
            this.a(this.var_ui_arr_b, "Bear_Charge", 2);
            this.a(this.var_ui_arr_b, "Bear_Smash", 3);
            this.a(this.var_ui_arr_b, "Bear_Ironhide", 4);
            this.a(this.var_ui_arr_b, "Empty", 5);
            this.a(this.var_ui_arr_b, "Empty", 6);
            this.a(this.var_ui_arr_b, "Empty", 7);
            this.a(this.var_ui_arr_b, "Empty", 8);
            this.a(this.var_ui_arr_b, "Bear", 9);
        }
    }

    @Override
    public void b(String string, int n2) {
        Engine.a("Loading:\t[" + n2 + "] = " + string);
        this.var_ui_arr_a.var_hg_a.a(this.var_ui_arr_a, string, n2);
        if (ay.ay_a().gd_a() != null && !string.contains("_Basic")) {
            Engine.b("Attempting to unlock: " + string);
            if (!string.equalsIgnoreCase("Empty")) {
                ay.ay_a().gd_a().a((Engine)this.var_ui_arr_a, abi.valueOf(string));
            }
        }
        Engine.a("Loaded:\t[" + n2 + "] = " + string);
    }

    public void a(ui[] uiArray, String string, int n2) {
        Engine.a("Loading:\t[" + n2 + "] = " + string);
        this.var_ui_arr_a.var_hg_a.a(uiArray, string, n2);
        Engine.a("Loaded:\t[" + n2 + "] = " + string);
    }

    @Override
    public void a(String string, int n2) {
        this.var_ui_arr_a.var_baa_a.a(ajw.jS, 0.7f);
        this.var_ui_arr_a.var_hg_a.b(this.var_ui_arr_a, string, n2);
    }

    public void void_a() {
        for (ui ui2 : this.var_ui_arr_a) {
            ui2.hf_a().azv_c().d();
        }
    }

    public boolean a(Engine engine, boolean bl2) {
        Object object;
        this.var_boolean_c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        boolean bl3 = true;
        this.var_ui_arr_b.hf_a().a().clear();
        if (!this.a(this.var_ui_arr_b.hf_a().boolean_d())) {
            Engine.a("GCD is running - setting status to false");
            this.e = true;
            bl3 = false;
        }
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Empty) {
            bl3 = false;
        }
        if ((this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Charge || this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear_Charge || this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Safeguard) && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().isRooted()) {
            this.var_boolean_c = true;
            bl3 = false;
        }
        Engine.a("cooldownTimer:   Running=" + this.var_ui_arr_b.hf_a().azv_c().boolean_a() + " Elapsed" + this.var_ui_arr_b.hf_a().azv_c().a(TimeUnit.MILLISECONDS) + " isDone=" + this.var_ui_arr_b.hf_a().azv_c().boolean_b());
        if (this.var_ui_arr_b.hf_a().azv_c().boolean_a()) {
            Engine.a("spell cooldown is running - setting status to false");
            if (this.var_ui_arr_b.hf_a().azv_c().boolean_b()) {
                Engine.a("spell cooldown done - resetting it");
                this.d = false;
                this.var_ui_arr_b.hf_a().azv_c().d();
            } else {
                bl3 = false;
                this.d = true;
                if (this.var_azv_b.boolean_b()) {
                    this.var_azv_b.void_c();
                    this.var_java_lang_String_a = this.var_java_text_DecimalFormat_a.format((float)this.var_ui_arr_b.hf_a().azv_c().int_b() / 1000.0f);
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aig(engine, this.var_ui_arr_b.hd_a().ayh_a(), 950, 180, "Cooldown " + this.var_java_lang_String_a, Color.WHITE, true, 960.0f, 190.0f));
                }
            }
        } else if (!this.var_ui_arr_b.hf_a().boolean_d() && this.var_azv_a.boolean_a()) {
            this.e = true;
        }
        Engine.a("Status-1 : " + bl3);
        if (!(this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() != LocationType.TARGETED || this.var_ui_arr_b.hf_a().uh_a() != uh.d && this.var_ui_arr_b.hf_a().uh_a() != uh.f && this.var_ui_arr_b.hf_a().uh_a() != uh.b || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null || ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) && ay.ay_a() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
            this.var_ui_arr_b.hf_a().a(new Target(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a()));
            Engine.a("Added me. " + (Object)((Object)this.var_ui_arr_b.hf_a().uh_a()));
        }
        Engine.a("Status0 : " + bl3);
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.TARGETED && !this.var_ui_arr_b.hf_a().azv_b().boolean_a() && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null) {
            if (this.var_ui_arr_b.hf_a().uh_a() == uh.c && ay.ay_a() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() || this.var_ui_arr_b.hf_a().uh_a() == uh.d && ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) || this.var_ui_arr_b.hf_a().uh_a() == uh.var_uh_a && !ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                object = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer();
                float f2 = axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
                if (f2 >= (float)this.var_ui_arr_b.hf_a().int_a()) {
                    bl3 = false;
                }
                if (bl3 && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(((br)object).double_a(), ((br)object).double_b())) {
                    bl3 = false;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Not in line of sight", Color.RED, true, 960.0f, 190.0f));
                } else {
                    this.var_ui_arr_b.hf_a().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a());
                    Engine.a("Added my target.");
                }
            } else if (this.var_ui_arr_b.hf_a().uh_a() == uh.var_uh_a && ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                Engine.a("Setting to false");
                bl3 = false;
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Invalid target", Color.RED, true, 960.0f, 190.0f));
            }
        }
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.POSITIONAL) {
            float f3 = axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y);
            if (f3 >= (float)this.var_ui_arr_b.hf_a().int_a()) {
                bl3 = false;
                if (this.var_azv_c.boolean_b()) {
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                }
            }
            if (bl3 && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().b(engine.var_com_badlogic_gdx_math_Vector3_b.x, (double)engine.var_com_badlogic_gdx_math_Vector3_b.y)) {
                bl3 = false;
                if (this.var_azv_c.boolean_b()) {
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                }
            } else {
                this.var_ui_arr_b.a().clear();
                this.var_ui_arr_b.a().add(new Location(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y));
                Engine.a("coords2 : " + engine.var_com_badlogic_gdx_math_Vector3_b.x + "," + engine.var_com_badlogic_gdx_math_Vector3_b.y);
            }
        }
        if (!(this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() != LocationType.TARGETED || this.var_ui_arr_b.hf_a().uh_a() != uh.var_uh_a || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() != null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() == null)) {
            bl3 = false;
            if (this.var_azv_c.boolean_b()) {
                this.var_azv_c.void_c();
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Invalid target.", Color.RED, true, 960.0f, 190.0f));
            }
        }
        Engine.a("Status.5 : " + bl3);
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() != LocationType.NONE) {
            object = this.var_ui_arr_b.hf_a().uh_a();
            switch (gv.a[((Enum)object).ordinal()]) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null || ay.ay_a() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) break;
                    bl3 = false;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Invalid target.", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
            }
        }
        Engine.a("Status1 : " + bl3 + " size: " + this.var_ui_arr_b.a().size());
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.TARGETED && !this.var_ui_arr_b.a().isEmpty()) {
            object = this.var_ui_arr_b.hf_a().uh_a();
            boolean bl4 = ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer());
            switch (gv.a[((Enum)object).ordinal()]) {
                case 1: {
                    if (!bl4 || !(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_b.hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 2: {
                    if (!bl4 || ay.ay_a() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() || !(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_b.hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 3: {
                    if (bl4 || !(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_b.hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 4: {
                    if (!(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_b.hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 5: {
                    if (ay.ay_a() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) {
                        if (!(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_b.hf_a().int_a())) break;
                        bl3 = false;
                        this.g = true;
                        if (!this.var_azv_c.boolean_b()) break;
                        this.var_azv_c.void_c();
                        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                        break;
                    }
                    Engine.a("here is the else case");
                    break;
                }
                case 6: {
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null) {
                        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a()));
                    }
                    if (ay.ay_a() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) break;
                    bl3 = false;
                    break;
                }
            }
        }
        Engine.a("Status1.5 : " + bl3 + " size: " + this.var_ui_arr_b.a().size());
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.TARGETED && !this.var_ui_arr_b.a().isEmpty() && axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_b.a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_b.hf_a().int_a()) {
            bl3 = false;
            this.g = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
        }
        if (this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.POSITIONAL && !this.var_ui_arr_b.a().isEmpty() && axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_b.a().get(0).getX(), this.var_ui_arr_b.a().get(0).getY()) > (float)this.var_ui_arr_b.hf_a().int_a()) {
            bl3 = false;
            this.g = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
        }
        Engine.a("Status2 : " + bl3);
        if (!this.var_ui_arr_b.hf_a().boolean_c() && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b()) {
            bl3 = false;
            this.h = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Can't do that while moving", Color.RED, true, 960.0f, 190.0f));
        }
        Engine.a("Status3 : " + bl3);
        if (ay.ay_a().a(false)) {
            bl3 = false;
            this.var_boolean_c = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Can't do that right now", Color.RED, true, 960.0f, 190.0f));
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue() < (double)this.var_ui_arr_b.hf_a().int_b()) {
            bl3 = false;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Not enough resource", Colors.get("RARITY_RARE"), true, 960.0f, 190.0f));
        }
        Engine.a("status:  " + bl3 + "name : " + (Object)((Object)this.var_ui_arr_b.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
        if (this.var_ui_arr_a != null) {
            Engine.a("current spell: " + (Object)((Object)this.var_ui_arr_a.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) + " " + this.var_ui_arr_a.hf_a().azv_c().a(TimeUnit.MILLISECONDS) + " " + this.var_ui_arr_a.hf_a().azv_b().a(TimeUnit.MILLISECONDS));
        } else {
            Engine.a("current spell is null");
        }
        if (bl3) {
            if (this.var_ui_arr_b.hf_a().boolean_d() && this.var_ui_arr_a != null && this.var_ui_arr_b != this.var_ui_arr_a) {
                this.var_ui_arr_b.hf_a().azv_b().d();
                this.var_ui_arr_b.hf_a().azv_c().d();
            }
            this.a(-1, bl2);
        }
        return bl3;
    }

    public boolean a(Engine engine, int n2, boolean bl2) {
        Object object;
        this.var_boolean_c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        boolean bl3 = true;
        if (this.var_ui_arr_a[n2] == null) {
            return false;
        }
        if (this.var_ui_arr_a[n2].hf_a() == null) {
            return false;
        }
        if (this.var_ui_arr_a[n2].hf_a().a() == null) {
            return false;
        }
        this.var_ui_arr_a[n2].hf_a().a().clear();
        if (!this.a(this.var_ui_arr_a[n2].hf_a().boolean_d())) {
            Engine.a("GCD is running - setting status to false");
            this.e = true;
            bl3 = false;
        }
        if (this.var_ui_arr_a[n2].hf_a().uk_a() == uk.b) {
            return false;
        }
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Empty) {
            bl3 = false;
        }
        if ((this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Charge || this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Safeguard || this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear_Charge) && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().isRooted()) {
            this.var_boolean_c = true;
            bl3 = false;
        }
        Engine.a("cooldownTimer:   Running=" + this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a() + " Elapsed" + this.var_ui_arr_a[n2].hf_a().azv_c().a(TimeUnit.MILLISECONDS) + " isDone=" + this.var_ui_arr_a[n2].hf_a().azv_c().boolean_b());
        if (this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a()) {
            Engine.a("spell cooldown is running - setting status to false");
            bl3 = false;
            this.d = true;
            if (this.var_azv_b.boolean_b()) {
                this.var_azv_b.void_c();
                this.var_java_lang_String_a = this.var_java_text_DecimalFormat_a.format((float)this.var_ui_arr_a[n2].hf_a().azv_c().int_b() / 1000.0f);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aig(engine, this.var_ui_arr_a[n2].hd_a().ayh_a(), 950, 180, "Cooldown " + this.var_java_lang_String_a, Color.WHITE, true, 960.0f, 190.0f));
            }
        } else if (!this.var_ui_arr_a[n2].hf_a().boolean_d() && this.var_azv_a.boolean_a()) {
            this.e = true;
            if (this.var_azv_b.boolean_b()) {
                this.var_azv_b.void_c();
                this.var_java_lang_String_a = this.var_java_text_DecimalFormat_a.format((float)this.var_azv_a.int_b() / 1000.0f);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aig(engine, this.var_ui_arr_a[n2].hd_a().ayh_a(), 950, 180, "Cooldown " + this.var_java_lang_String_a, Color.WHITE, true, 960.0f, 190.0f));
            }
        }
        if (this.var_ui_arr_a[n2].hf_a().azv_c().boolean_b()) {
            Engine.a("spell cooldown done - resetting it");
            this.d = false;
            this.var_ui_arr_a[n2].hf_a().azv_c().d();
        }
        Engine.a("Status-1 : " + bl3);
        if (!(this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() != LocationType.TARGETED || this.var_ui_arr_a[n2].hf_a().uh_a() != uh.d && this.var_ui_arr_a[n2].hf_a().uh_a() != uh.f && this.var_ui_arr_a[n2].hf_a().uh_a() != uh.b || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null || ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) && ay.ay_a() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
            this.var_ui_arr_a[n2].hf_a().a(new Target(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a()));
            Engine.a("Added me. " + (Object)((Object)this.var_ui_arr_a[n2].hf_a().uh_a()));
        }
        Engine.a("Status0 : " + bl3);
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.TARGETED && !this.var_ui_arr_a[n2].hf_a().azv_b().boolean_a() && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null) {
            if (this.var_ui_arr_a[n2].hf_a().uh_a() == uh.c && ay.ay_a() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() || this.var_ui_arr_a[n2].hf_a().uh_a() == uh.d && ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) || this.var_ui_arr_a[n2].hf_a().uh_a() == uh.var_uh_a && !ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                object = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer();
                float f2 = axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
                if (f2 >= (float)this.var_ui_arr_a[n2].hf_a().int_a()) {
                    bl3 = false;
                }
                if (bl3 && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(((br)object).double_a(), ((br)object).double_b())) {
                    bl3 = false;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Not in line of sight", Color.RED, true, 960.0f, 190.0f));
                } else {
                    this.var_ui_arr_a[n2].hf_a().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a());
                    Engine.a("Added my target.");
                }
            } else if (this.var_ui_arr_a[n2].hf_a().uh_a() == uh.var_uh_a && ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                Engine.a("Setting to false");
                bl3 = false;
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Invalid target", Color.RED, true, 960.0f, 190.0f));
            }
        }
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.POSITIONAL) {
            float f3 = axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y);
            boolean bl4 = f3 >= (float)this.var_ui_arr_a[n2].hf_a().int_a();
            Vector3 vector3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y, this.var_ui_arr_a[n2].hf_a().var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a);
            if (f3 >= (float)this.var_ui_arr_a[n2].hf_a().int_a()) {
                bl3 = false;
                if (this.var_azv_c.boolean_b()) {
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                }
            }
            if (bl3 && vector3.z == -1.0f) {
                bl3 = false;
                if (this.var_azv_c.boolean_b()) {
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                }
            } else {
                this.var_ui_arr_a[n2].a().clear();
                this.var_ui_arr_a[n2].a().add(new Location(vector3.x, vector3.y));
                Engine.a("coords2 : " + engine.var_com_badlogic_gdx_math_Vector3_b.x + "," + engine.var_com_badlogic_gdx_math_Vector3_b.y);
            }
        }
        if (!(this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() != LocationType.TARGETED || this.var_ui_arr_a[n2].hf_a().uh_a() != uh.var_uh_a || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() != null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() == null)) {
            bl3 = false;
            if (this.var_azv_c.boolean_b()) {
                this.var_azv_c.void_c();
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Invalid target.", Color.RED, true, 960.0f, 190.0f));
            }
        }
        Engine.a("Status.5 : " + bl3);
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() != LocationType.NONE) {
            object = this.var_ui_arr_a[n2].hf_a().uh_a();
            switch (gv.a[((Enum)object).ordinal()]) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null || ay.ay_a() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) break;
                    bl3 = false;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Invalid target.", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
            }
        }
        Engine.a("Status1 : " + bl3 + " size: " + this.var_ui_arr_a[n2].a().size());
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.TARGETED && !this.var_ui_arr_a[n2].a().isEmpty()) {
            object = this.var_ui_arr_a[n2].hf_a().uh_a();
            boolean bl5 = ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer());
            switch (gv.a[((Enum)object).ordinal()]) {
                case 1: {
                    if (!bl5 || !(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 2: {
                    if (!bl5 || ay.ay_a() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() || !(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 3: {
                    if (bl5 || !(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 4: {
                    if (!(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a())) break;
                    bl3 = false;
                    this.g = true;
                    if (!this.var_azv_c.boolean_b()) break;
                    this.var_azv_c.void_c();
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                    break;
                }
                case 5: {
                    if (ay.ay_a() != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) {
                        if (!(axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a())) break;
                        bl3 = false;
                        this.g = true;
                        if (!this.var_azv_c.boolean_b()) break;
                        this.var_azv_c.void_c();
                        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
                        break;
                    }
                    Engine.a("here is the else case");
                    break;
                }
                case 6: {
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null) {
                        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a()));
                    }
                    if (ay.ay_a() == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()) break;
                    bl3 = false;
                    break;
                }
            }
        }
        Engine.a("Status1.5 : " + bl3 + " size: " + this.var_ui_arr_a[n2].a().size());
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.TARGETED && !this.var_ui_arr_a[n2].a().isEmpty() && axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_ui_arr_a[n2].a().get(0).getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a()) {
            bl3 = false;
            this.g = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
        }
        if (this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a() == LocationType.POSITIONAL && !this.var_ui_arr_a[n2].a().isEmpty() && axp.float_a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_ui_arr_a[n2].a().get(0).getX(), this.var_ui_arr_a[n2].a().get(0).getY()) > (float)this.var_ui_arr_a[n2].hf_a().int_a()) {
            bl3 = false;
            this.g = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Out of range", Color.RED, true, 960.0f, 190.0f));
        }
        Engine.a("Status2 : " + bl3);
        if (!this.var_ui_arr_a[n2].hf_a().boolean_c() && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b()) {
            bl3 = false;
            this.h = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Can't do that while moving", Color.RED, true, 960.0f, 190.0f));
        }
        Engine.a("Status3 : " + bl3);
        if (ay.ay_a().a(false)) {
            bl3 = false;
            this.var_boolean_c = true;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Can't do that right now", Color.RED, true, 960.0f, 190.0f));
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue() < (double)this.var_ui_arr_a[n2].hf_a().int_b() && (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().contains(EffectList.Bear) || this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Bear)) {
            bl3 = false;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(new aid(engine, "Not enough resource", Colors.get("RARITY_RARE"), true, 960.0f, 190.0f));
        }
        Engine.a("status:  " + bl3 + " spellSlot: " + n2 + "name : " + (Object)((Object)this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
        if (this.var_ui_arr_a != null) {
            Engine.a("current spell: " + (Object)((Object)this.var_ui_arr_a.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) + " " + this.var_ui_arr_a.hf_a().azv_c().a(TimeUnit.MILLISECONDS) + " " + this.var_ui_arr_a.hf_a().azv_b().a(TimeUnit.MILLISECONDS));
        } else {
            Engine.a("current spell is null");
        }
        if (bl3) {
            if (this.var_ui_arr_a[n2].hf_a().boolean_d() && this.var_ui_arr_a != null && this.var_ui_arr_a[n2] != this.var_ui_arr_a) {
                this.var_ui_arr_a[n2].hf_a().azv_b().d();
                this.var_ui_arr_a[n2].hf_a().azv_c().d();
            }
            this.a(n2, bl2);
        }
        return bl3;
    }

    public boolean a(boolean bl2) {
        int n2;
        boolean bl3 = false;
        if (!bl2 && this.var_azv_a.long_a() == 0L) {
            Engine.a("First pass. Running=" + this.var_azv_a.boolean_a() + " Elapsed=" + this.var_azv_a.a(TimeUnit.MILLISECONDS));
            this.var_azv_a.d();
            bl3 = true;
        }
        if (!bl3 && !this.var_azv_a.boolean_a()) {
            bl3 = true;
        }
        if (!bl3 && this.var_azv_a.boolean_b()) {
            Engine.a("GCD is done, resetting it. Running=" + this.var_azv_a.boolean_a() + " Elapsed=" + this.var_azv_a.a(TimeUnit.MILLISECONDS));
            this.var_azv_a.d();
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a() || this.var_ui_arr_a[n2].hf_a().boolean_d()) continue;
                this.var_ui_arr_a[n2].hd_a().da_c().void_a();
            }
            bl3 = true;
        }
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hf_a() == null || this.var_ui_arr_a[n2].hf_a().azv_c() == null || this.var_azv_a.boolean_a() || !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_b() && !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_c()) continue;
            this.var_ui_arr_a[n2].hd_a().da_a().void_a();
        }
        if (bl2) {
            return true;
        }
        return bl3;
    }

    public boolean boolean_a() {
        int n2;
        boolean bl2 = false;
        if (this.var_azv_a.long_a() == 0L) {
            this.var_azv_a = new azv(1000L, false);
            bl2 = true;
        }
        if (!bl2 && !this.var_azv_a.boolean_a()) {
            bl2 = true;
        }
        if (!bl2 && this.var_azv_a.boolean_b()) {
            this.var_azv_a.d();
            for (n2 = 1; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hf_a() == null || this.var_ui_arr_a[n2].hf_a().azv_c() == null || this.var_ui_arr_a[n2].hd_a().da_c() == null || this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a() || this.var_ui_arr_a[n2].hf_a().boolean_d()) continue;
                this.var_ui_arr_a[n2].hd_a().da_c().void_a();
            }
            bl2 = true;
        }
        for (n2 = 1; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hf_a().azv_c() == null || this.var_ui_arr_a[n2].hd_a() == null || this.var_ui_arr_a[n2].hd_a().da_c() == null || this.var_ui_arr_a[n2].hd_a().da_a() == null || this.var_azv_a.boolean_a() || !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_b() && !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_c()) continue;
            this.var_ui_arr_a[n2].hd_a().da_a().void_a();
        }
        if (this.var_ui_arr_a.hf_a().azv_c().boolean_b() || this.var_ui_arr_a.hf_a().azv_c().boolean_c()) {
            this.var_ui_arr_a.hd_a().da_a().void_a();
        }
        return bl2;
    }

    public void void_b() {
        this.var_azv_a.d();
        Engine.b("RESET GCD");
    }

    public void c() {
        Engine.a("Picking it up and resetting it.");
        this.var_azv_a.d();
        this.var_azv_a.void_a();
        for (int i2 = 1; i2 < this.var_ui_arr_a.length; ++i2) {
            if (this.var_ui_arr_a[i2].hf_a().azv_c().boolean_a() || this.var_ui_arr_a[i2].hf_a().boolean_d()) continue;
            this.var_ui_arr_a[i2].hd_a().da_a().void_a();
        }
    }

    public void a(int n2, boolean bl2) {
        System.out.println("Fire spell slot: " + n2);
        switch (n2) {
            case -1: {
                if (bl2) break;
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, -1));
                break;
            }
            case 0: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 0));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 0));
                    this.var_ui_arr_a.var_ag_a.b(new SPELL_REQUEST(null, 0));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 0));
                break;
            }
            case 1: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 1));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 1));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 1));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 1));
                break;
            }
            case 2: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 2));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 2));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 2));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 2));
                break;
            }
            case 3: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 3));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 3));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 3));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 3));
                break;
            }
            case 4: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 4));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 4));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 4));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 4));
                break;
            }
            case 5: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 5));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 5));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 5));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 5));
                break;
            }
            case 6: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 6));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 6));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 6));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 6));
                break;
            }
            case 7: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 7));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 7));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 7));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 7));
                break;
            }
            case 8: {
                if (bl2) {
                    if (this.var_ui_arr_a[n2].a().isEmpty()) {
                        this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(null, 8));
                        break;
                    }
                    this.var_ui_arr_a.var_ag_a.a(new MOVE_SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 8));
                    break;
                }
                if (this.var_ui_arr_a[n2].a().isEmpty()) {
                    this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(null, 8));
                    break;
                }
                this.var_ui_arr_a.var_ag_a.a(new SPELL_REQUEST(this.var_ui_arr_a[n2].a().get(0), 8));
            }
        }
        if (n2 != -1) {
            this.var_ui_arr_a[n2].a().clear();
        }
    }

    public ui ui_a(SpellName spellName) {
        for (ui ui2 : this.var_ui_arr_a) {
            if (ui2 == null || ui2.hf_a() == null || ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != spellName) continue;
            return ui2;
        }
        for (ui ui2 : this.var_ui_arr_b) {
            if (ui2 == null || ui2.hf_a() == null || ui2 == null || ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != spellName) continue;
            return ui2;
        }
        return null;
    }

    @Override
    public void a(float f2, Engine engine) {
        for (int i2 = 0; i2 < this.var_ui_arr_a.length; ++i2) {
            if (this.var_ui_arr_a[i2] == null || this.var_ui_arr_a[i2].hf_a().azv_c() == null || !SpellName.isBasic(this.var_ui_arr_a[i2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) && (this.var_ui_arr_a[i2].hd_a() == null || this.var_ui_arr_a[i2].hd_a().da_c() == null) || !this.var_ui_arr_a[i2].hf_a().azv_c().boolean_a() || !this.var_ui_arr_a[i2].hf_a().azv_c().boolean_b()) continue;
            this.var_ui_arr_a[i2].hf_a().azv_c().d();
            if (!this.var_azv_a.boolean_a() && this.var_ui_arr_a[i2].hd_a() != null && this.var_ui_arr_a[i2].hd_a().da_c() != null) {
                this.var_ui_arr_a[i2].hd_a().da_c().void_a();
            }
            this.var_ui_arr_a[i2].hd_a().void_c();
        }
        if (this.var_ui_arr_a.hf_a().azv_c().boolean_a() && this.var_ui_arr_a.hf_a().azv_c().boolean_b()) {
            this.var_ui_arr_a.hf_a().azv_c().d();
            this.var_ui_arr_a.hd_a().da_c().void_a();
            this.var_ui_arr_a.hd_a().da_b().void_a();
        }
        if (this.var_azv_a.boolean_b()) {
            this.var_azv_a.d();
        }
    }

    @Override
    public void a(axm axm2) {
        for (ui ui2 : this.var_ui_arr_a) {
            if (ui2 == null) continue;
            ui2.b(axm2);
        }
        if (this.var_ui_arr_b != null) {
            for (ui ui2 : this.var_ui_arr_b) {
                if (ui2 == null) continue;
                ui2.b(axm2);
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        int n2;
        for (n2 = 1; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null) continue;
            this.var_ui_arr_a[n2].a(f2, engine, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_h(), n2, 0);
        }
        for (n2 = 1; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null || !this.var_ui_arr_a[n2].hd_a().ayh_a().boolean_a()) continue;
            this.var_ui_arr_a[n2].a(f2, engine, 1, n2);
        }
    }

    public void d(float f2, Engine engine) {
        int n2;
        if (this.var_ui_arr_a != null) {
            this.a(f2, engine);
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hd_a() == null) continue;
                this.var_ui_arr_a[n2].hd_a().f(f2, engine);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a != null && this.var_ui_arr_a[n2] != null && this.var_ui_arr_a[n2].hf_a() != null && this.var_ui_arr_a[n2].hf_a().azv_b() != null && this.var_ui_arr_a.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() && this.var_ui_arr_a[n2].hf_a().azv_b().long_a() > 0L) {
                    if (this.var_ui_arr_a.hf_a().azv_b().boolean_a()) {
                        this.var_ui_arr_a[n2].hd_a().void_a();
                    } else {
                        this.var_ui_arr_a[n2].hd_a().void_b();
                    }
                }
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hd_a() == null) continue;
                this.var_ui_arr_a[n2].hd_a().g(f2, engine);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hd_a() == null) continue;
                this.var_ui_arr_a[n2].hd_a().h(f2, engine);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hd_a() == null) continue;
                this.var_ui_arr_a[n2].hd_a().j(f2, engine);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hd_a() == null) continue;
                this.var_ui_arr_a[n2].hd_a().i(f2, engine);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hf_a() == null || this.var_ui_arr_a[n2].hf_a().azv_c() == null || this.var_ui_arr_a == null || this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Empty || this.var_ui_arr_a[n2].hf_a().boolean_d() && this.var_ui_arr_a.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() && !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a()) continue;
                if (!this.var_azv_a.boolean_a() && !this.var_ui_arr_a[n2].hf_a().azv_b().boolean_a() && this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a()) {
                    this.var_ui_arr_a[n2].hd_a().da_a().a((float)this.var_azv_a.long_a() / (float)this.var_ui_arr_a[n2].hf_a().azv_c().long_a() * (float)this.var_ui_arr_a[n2].hf_a().azv_c().a(TimeUnit.MILLISECONDS) / 1000.0f, engine.var_azi_a);
                    continue;
                }
                if (!this.var_ui_arr_a[n2].hf_a().boolean_d() && this.var_azv_a.boolean_a() && this.var_ui_arr_a.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() && this.var_ui_arr_a.hf_a().azv_b().boolean_a() && this.var_ui_arr_a.hf_a().azv_c().long_a() >= this.var_azv_a.long_a()) {
                    this.var_ui_arr_a[n2].hd_a().da_a().b(0.0f, engine);
                    continue;
                }
                if (this.var_azv_a.boolean_a() && !this.var_ui_arr_a[n2].hf_a().boolean_d()) {
                    if (this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a()) {
                        if (this.var_ui_arr_a[n2].hf_a().azv_c().int_b() > this.var_azv_a.int_b()) {
                            this.var_ui_arr_a[n2].hd_a().da_a().a((float)this.var_azv_a.long_a() / (float)this.var_ui_arr_a[n2].hf_a().azv_c().long_a() * (float)this.var_ui_arr_a[n2].hf_a().azv_c().a(TimeUnit.MILLISECONDS) / 1000.0f, engine.var_azi_a);
                            continue;
                        }
                        if (!this.var_ui_arr_a[n2].hd_a().boolean_b()) {
                            this.var_ui_arr_a[n2].hd_a().d();
                        }
                        this.var_ui_arr_a[n2].hd_a().da_a().b(f2, engine);
                        continue;
                    }
                    this.var_ui_arr_a[n2].hd_a().da_a().b(f2, engine);
                    continue;
                }
                if (!this.var_ui_arr_a[n2].hf_a().boolean_d() || !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a()) continue;
                if (!this.var_ui_arr_a[n2].hd_a().boolean_b()) {
                    this.var_ui_arr_a[n2].hd_a().d();
                }
                this.var_ui_arr_a[n2].hd_a().da_a().a((float)this.var_azv_a.long_a() / (float)this.var_ui_arr_a[n2].hf_a().azv_c().long_a() * (float)this.var_ui_arr_a[n2].hf_a().azv_c().a(TimeUnit.MILLISECONDS) / 1000.0f, engine.var_azi_a);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hf_a() == null || this.var_ui_arr_a[n2].hf_a().azv_c() == null || this.var_ui_arr_a == null || this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Empty || this.var_ui_arr_a[n2] == null || !this.var_ui_arr_a[n2].hf_a().azv_c().boolean_a()) continue;
                if (this.var_ui_arr_a[n2].hf_a().azv_c().int_a() <= 3) {
                    this.var_java_lang_String_a = this.var_java_text_DecimalFormat_a.format((float)this.var_ui_arr_a[n2].hf_a().azv_c().int_b() / 1000.0f);
                    engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d, this.var_java_lang_String_a, engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d.getColor(), 0.0f, 1, false);
                    engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 18.0f + engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width / 2.0f, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 32.0f, 1, 1);
                    continue;
                }
                this.var_java_lang_String_a = String.valueOf(this.var_ui_arr_a[n2].hf_a().azv_c().int_a());
                engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d, this.var_java_lang_String_a, Color.WHITE, 0.0f, 1, false);
                if (this.var_ui_arr_a[n2].hf_a().azv_c().int_a() >= 10) {
                    engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 18.0f + engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width / 2.0f, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 32.0f, 1, 1);
                    continue;
                }
                engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 18.0f + engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width / 2.0f, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 32.0f, 1, 1);
            }
            for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
                if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hf_a() == null || this.var_ui_arr_a[n2].hf_a().azv_c() == null || this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Empty || (n2 != 0 || engine.var_agc_a.a().get(InputIdentifier.BASIC) == null || engine.var_agc_a.a().get(InputIdentifier.BASIC).int_a() == 9999) && (n2 == 0 || engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)) == null || engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)).int_a() == 9999) || this.var_ui_arr_a[n2].hf_a().uk_a() == uk.b) continue;
                if (ay.ay_a().a(true) || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue() < (double)this.var_ui_arr_a[n2].hf_a().int_b()) {
                    if (n2 == 0) {
                        engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.BASIC).int_a()), engine.var_axy_c.a(), axe.v, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 44.0f, 18.0f, 16, 1);
                        continue;
                    }
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().contains(EffectList.Bear) && this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear) {
                        engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)).int_a()), engine.var_axy_c.a(), axe.A, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 44.0f, 78.0f, 16, 1);
                        continue;
                    }
                    engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)).int_a()), engine.var_axy_c.a(), axe.v, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 44.0f, 78.0f, 16, 1);
                    continue;
                }
                if (n2 == 0) {
                    engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.BASIC).int_a()), engine.var_axy_c.a(), axe.A, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 44.0f, 18.0f, 16, 1);
                    continue;
                }
                engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)).int_a()), engine.var_axy_c.a(), axe.A, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a[n2].hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 44.0f, 78.0f, 16, 1);
            }
            this.var_ui_arr_a.hd_a().e(f2, engine);
            this.var_ui_arr_b.hd_a().a(1195, 10);
            this.var_ui_arr_b.hd_a().e(f2, engine);
            if (this.var_ui_arr_a.hf_a().azv_c().boolean_a()) {
                this.var_ui_arr_a.hd_a().da_a().d(-0.175f);
                this.var_ui_arr_a.hd_a().da_a().a(this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - 1.0f, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
                this.var_ui_arr_a.hd_a().da_a().a((float)this.var_azv_a.long_a() / (float)this.var_ui_arr_a.hf_a().azv_c().long_a() * (float)this.var_ui_arr_a.hf_a().azv_c().a(TimeUnit.MILLISECONDS) / 1000.0f, engine.var_azi_a);
                this.var_ui_arr_a.hd_a().da_a().d(0.175f);
            }
            if (engine.var_agc_a.a().get(InputIdentifier.valueOf("MEDITATE")) != null && engine.var_agc_a.a().get(InputIdentifier.valueOf("MEDITATE")).int_a() != 9999 && this.var_ui_arr_b.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() != null) {
                engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.valueOf("MEDITATE")).int_a()), engine.var_axy_c.a(), axe.A, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_b.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 37.0f, 28.0f, 1, 1);
            }
            if (engine.var_agc_a.a().get(InputIdentifier.valueOf("TRINKET_1")) != null && engine.var_agc_a.a().get(InputIdentifier.valueOf("TRINKET_1")).int_a() != 9999 && this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() != null) {
                engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.valueOf("TRINKET_1")).int_a()), engine.var_axy_c.a(), axe.A, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 37.0f, 28.0f, 1, 1);
            }
            if (this.var_ui_arr_a.hf_a().azv_c().boolean_a()) {
                if (this.var_ui_arr_a.hf_a().azv_c().int_a() <= 3) {
                    this.var_java_lang_String_a = this.var_java_text_DecimalFormat_a.format((float)this.var_ui_arr_a.hf_a().azv_c().int_b() / 1000.0f);
                    engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d, this.var_java_lang_String_a, engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d.getColor(), 0.0f, 1, false);
                    if (this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() != null) {
                        engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 14.0f + engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width / 2.0f, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 30.0f, 1, 1);
                    }
                } else {
                    this.var_java_lang_String_a = String.valueOf(this.var_ui_arr_a.hf_a().azv_c().int_a());
                    engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d, this.var_java_lang_String_a, Color.WHITE, 0.0f, 1, false);
                    if (this.var_ui_arr_a.hf_a().azv_c().int_a() >= 10) {
                        if (this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() != null) {
                            engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 14.0f + engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width / 2.0f, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 30.0f, 1, 1);
                        }
                    } else if (this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() != null) {
                        engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 14.0f + engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width / 2.0f, this.var_ui_arr_a.hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 30.0f, 1, 1);
                    }
                }
            }
        }
        ((agd)engine.axc_a()).e(false);
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null || this.var_ui_arr_a[n2].hd_a() == null) continue;
            this.var_ui_arr_a[n2].hd_a().k(f2, engine);
        }
    }

    public void d() {
        int n2;
        this.var_boolean_b = !this.var_boolean_b;
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            this.var_ui_arr_a.put(n2, this.var_ui_arr_a[n2]);
        }
        for (n2 = 0; n2 < this.var_ui_arr_b.length; ++n2) {
            this.var_ui_arr_a[n2] = this.var_ui_arr_b[n2];
        }
        for (n2 = 0; n2 < this.var_ui_arr_a.values().size(); ++n2) {
            this.var_ui_arr_b[n2] = (ui)this.var_ui_arr_a.get(n2);
        }
    }

    public void e() {
        if (!this.var_boolean_b) {
            this.d();
            this.var_boolean_b = true;
        }
    }

    @Override
    public ui[] ui_arr_a() {
        return this.var_ui_arr_a;
    }

    public ui ui_a(int n2) {
        return this.var_ui_arr_a[n2];
    }

    public azv azv_a() {
        return this.var_azv_a;
    }

    @Override
    public SpellBarState com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a() {
        return this.var_ui_arr_a;
    }
}

