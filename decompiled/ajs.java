/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class ajs
implements Comparable<ajs> {
    private String var_java_lang_String_a;
    private int var_int_a;
    private String b;

    public ajs(String string, int n2) {
        this.var_java_lang_String_a = string;
        this.var_int_a = n2;
        try {
            this.b = String.valueOf(n2) + "  " + SpellName.getFormattedName(SpellName.valueOf(string));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.b = String.valueOf(n2) + "  " + string;
        }
    }

    public int int_a() {
        return this.var_int_a;
    }

    public String java_lang_String_a() {
        return this.b;
    }

    public int a(ajs ajs2) {
        if (ajs2.var_int_a >= this.var_int_a) {
            return 1;
        }
        return -1;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((ajs)object);
    }
}

