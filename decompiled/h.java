/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public final class h
extends Enum<h> {
    public static final /* enum */ h var_h_a;
    private static final /* synthetic */ h[] var_h_arr_a;

    public static h[] values() {
        return (h[])var_h_arr_a.clone();
    }

    public static h valueOf(String string) {
        return Enum.valueOf(h.class, string);
    }

    public static String a(SpellName spellName) {
        if (spellName.name().contains("Basic")) {
            return "null";
        }
        if (spellName == SpellName.PoisonedBlades) {
            return "";
        }
        return spellName.name();
    }

    static {
        var_h_a = new h();
        var_h_arr_a = new h[]{var_h_a};
    }
}

