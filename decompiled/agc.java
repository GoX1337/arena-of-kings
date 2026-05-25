/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_KEYBIND_UPDATE;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.ArrayList;

public class agc {
    private ObjectMap<InputIdentifier, agb> cfr_renamed_5 = new ObjectMap();
    private final ObjectMap<InputIdentifier, agb> b = new ObjectMap();
    @Deprecated
    private Array<agb> var_com_badlogic_gdx_utils_Array_agb__a;

    public agc(ArrayList<PUB_KEYBIND_UPDATE> arrayList) {
        this.cfr_renamed_5 = new Array();
        this.a(this.b);
        if (arrayList == null || arrayList != null && arrayList.size() == 0) {
            this.a();
        } else {
            this.a(arrayList);
        }
    }

    public void a(ArrayList<PUB_KEYBIND_UPDATE> arrayList) {
        Engine.a("loadKeyBinds() " + arrayList.size());
        this.cfr_renamed_5.clear();
        for (PUB_KEYBIND_UPDATE pUB_KEYBIND_UPDATE : arrayList) {
            agb agb2 = this.b.get(pUB_KEYBIND_UPDATE.inputIdentifier);
            if (agb2 == null) continue;
            Engine.a("loading keybind: " + (Object)((Object)pUB_KEYBIND_UPDATE.inputIdentifier) + " " + pUB_KEYBIND_UPDATE.key);
            agb2.a(pUB_KEYBIND_UPDATE.key);
            this.cfr_renamed_5.put(pUB_KEYBIND_UPDATE.inputIdentifier, agb2);
        }
        this.cfr_renamed_5.put(InputIdentifier.TARGET_HOVERABLE, new ain(0));
        this.cfr_renamed_5.put(InputIdentifier.MOVE_TOWARD_CURSOR, new air(1));
    }

    private void a(ObjectMap<InputIdentifier, agb> objectMap) {
        objectMap.clear();
        objectMap.put(InputIdentifier.MOVE_NORTH, new aip(51));
        objectMap.put(InputIdentifier.MOVE_SOUTH, new aiq(47));
        objectMap.put(InputIdentifier.MOVE_EAST, new aio(32));
        objectMap.put(InputIdentifier.MOVE_WEST, new ait(29));
        objectMap.put(InputIdentifier.BASIC, new ajc(62));
        objectMap.put(InputIdentifier.ABILITY_1, new aiu(8));
        objectMap.put(InputIdentifier.ABILITY_2, new aiv(9));
        objectMap.put(InputIdentifier.ABILITY_3, new aiw(10));
        objectMap.put(InputIdentifier.ABILITY_4, new aix(11));
        objectMap.put(InputIdentifier.ABILITY_5, new aiy(12));
        objectMap.put(InputIdentifier.ABILITY_6, new aiz(13));
        objectMap.put(InputIdentifier.ABILITY_7, new aja(45));
        objectMap.put(InputIdentifier.ABILITY_8, new ajb(33));
        objectMap.put(InputIdentifier.TRINKET_1, new ajk(48));
        objectMap.put(InputIdentifier.MEDITATE, new ajm(54));
        objectMap.put(InputIdentifier.TARGET_SELF, new ajj(131));
        objectMap.put(InputIdentifier.TARGET_ALLY_2, new aje(132));
        objectMap.put(InputIdentifier.TARGET_ALLY_3, new ajf(133));
        objectMap.put(InputIdentifier.TARGET_ENEMY_1, new ajg(46));
        objectMap.put(InputIdentifier.TARGET_ENEMY_2, new ajh(34));
        objectMap.put(InputIdentifier.TARGET_ENEMY_3, new aji(50));
        objectMap.put(InputIdentifier.TARGET_TAB, new ajd(61));
        objectMap.put(InputIdentifier.TARGET_CLEAR, new aii(111));
        objectMap.put(InputIdentifier.TARGET_NEAREST_ENEMY, new aij(31));
        objectMap.put(InputIdentifier.TARGET_HOVERABLE, new ain(0));
        objectMap.put(InputIdentifier.MOVE_TOWARD_CURSOR, new air(1));
    }

    public void a() {
        ((Array)((Object)this.cfr_renamed_5)).clear();
        this.cfr_renamed_5.clear();
        this.cfr_renamed_5.put(InputIdentifier.MOVE_NORTH, new aip(51));
        this.cfr_renamed_5.put(InputIdentifier.MOVE_SOUTH, new aiq(47));
        this.cfr_renamed_5.put(InputIdentifier.MOVE_EAST, new aio(32));
        this.cfr_renamed_5.put(InputIdentifier.MOVE_WEST, new ait(29));
        this.cfr_renamed_5.put(InputIdentifier.BASIC, new ajc(62));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_1, new aiu(8));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_2, new aiv(9));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_3, new aiw(10));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_4, new aix(11));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_5, new aiy(12));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_6, new aiz(13));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_7, new aja(45));
        this.cfr_renamed_5.put(InputIdentifier.ABILITY_8, new ajb(33));
        this.cfr_renamed_5.put(InputIdentifier.TRINKET_1, new ajk(48));
        this.cfr_renamed_5.put(InputIdentifier.MEDITATE, new ajm(54));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_SELF, new ajj(131));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_ALLY_2, new aje(132));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_ALLY_3, new ajf(133));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_ENEMY_1, new ajg(46));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_ENEMY_2, new ajh(34));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_ENEMY_3, new aji(50));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_TAB, new ajd(61));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_CLEAR, new aii(111));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_NEAREST_ENEMY, new aij(31));
        this.cfr_renamed_5.put(InputIdentifier.TARGET_HOVERABLE, new ain(0));
        this.cfr_renamed_5.put(InputIdentifier.MOVE_TOWARD_CURSOR, new air(1));
    }

    public ObjectMap<InputIdentifier, agb> a() {
        return this.cfr_renamed_5;
    }

    public String a(InputIdentifier inputIdentifier) {
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 9999) {
            return "";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5002) {
            return "M3";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5003) {
            return "M4";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5004) {
            return "M5";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5005) {
            return "M6";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5006) {
            return "M7";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5007) {
            return "M8";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5008) {
            return "M9";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5008) {
            return "M9";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5009) {
            return "M10";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5010) {
            return "M11";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5011) {
            return "M12";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5012) {
            return "M13";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5013) {
            return "M14";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5014) {
            return "M15";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5015) {
            return "M16";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5016) {
            return "M17";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5017) {
            return "M18";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5018) {
            return "M19";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5019) {
            return "M20";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 5020) {
            return "M21";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 6000) {
            return "DWN";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() == 6001) {
            return "UP";
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() >= 7000 && this.cfr_renamed_5.get(inputIdentifier).int_a() < 8000) {
            return "s-" + Input.Keys.toString(this.cfr_renamed_5.get(inputIdentifier).int_a() % 1000);
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() >= 8000 && this.cfr_renamed_5.get(inputIdentifier).int_a() < 9000) {
            return "a-" + Input.Keys.toString(this.cfr_renamed_5.get(inputIdentifier).int_a() % 1000);
        }
        if (this.cfr_renamed_5.get(inputIdentifier).int_a() >= 9000 && this.cfr_renamed_5.get(inputIdentifier).int_a() < 10000) {
            return "c-" + Input.Keys.toString(this.cfr_renamed_5.get(inputIdentifier).int_a() % 1000);
        }
        return Input.Keys.toString(this.cfr_renamed_5.get(inputIdentifier).int_a());
    }

    public void a(int n2, agb agb2, InputIdentifier inputIdentifier) {
        for (ObjectMap.Entry entry : this.cfr_renamed_5.entries()) {
            if (((agb)entry.value).int_a() != n2) continue;
            ((agb)entry.value).a(9999);
        }
        if (agb2 instanceof ail) {
            if (this.cfr_renamed_5.containsKey(inputIdentifier)) {
                this.cfr_renamed_5.remove(inputIdentifier);
            }
            this.cfr_renamed_5.put(inputIdentifier, agb2);
            ((ail)agb2).a(n2);
        }
    }

    public static String a(int n2) {
        if (n2 < 255) {
            String string = Input.Keys.toString(n2);
            if (string.length() > 3) {
                return string.substring(0, 3);
            }
            return string;
        }
        if (n2 == 9999) {
            return "";
        }
        if (n2 == 5002) {
            return "M3";
        }
        if (n2 == 5003) {
            return "M4";
        }
        if (n2 == 5004) {
            return "M5";
        }
        if (n2 == 5005) {
            return "M6";
        }
        if (n2 == 5006) {
            return "M7";
        }
        if (n2 == 5007) {
            return "M8";
        }
        if (n2 == 5008) {
            return "M9";
        }
        if (n2 == 5009) {
            return "M10";
        }
        if (n2 == 5010) {
            return "M11";
        }
        if (n2 == 5011) {
            return "M12";
        }
        if (n2 == 5012) {
            return "M13";
        }
        if (n2 == 5013) {
            return "M14";
        }
        if (n2 == 5014) {
            return "M15";
        }
        if (n2 == 5015) {
            return "M16";
        }
        if (n2 == 5016) {
            return "M17";
        }
        if (n2 == 5017) {
            return "M18";
        }
        if (n2 == 5018) {
            return "M19";
        }
        if (n2 == 5019) {
            return "M20";
        }
        if (n2 == 5020) {
            return "M21";
        }
        if (n2 == 6000) {
            return "DWN";
        }
        if (n2 == 6001) {
            return "UP";
        }
        if (n2 >= 7000 && n2 < 8000) {
            return "s-" + Input.Keys.toString(n2 % 1000);
        }
        if (n2 >= 8000 && n2 < 9000) {
            return "a-" + Input.Keys.toString(n2 % 1000);
        }
        if (n2 >= 9000 && n2 < 10000) {
            return "c-" + Input.Keys.toString(n2 % 1000);
        }
        return "";
    }
}

