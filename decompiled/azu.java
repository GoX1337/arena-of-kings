/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;
import java.util.List;

public class azu {
    public static String a(String string, String string2, Object ... objectArray) {
        String[] stringArray = string.split(string2);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < stringArray.length - 1; ++i2) {
            stringBuffer.append(stringArray[i2]);
            stringBuffer.append(objectArray[i2]);
        }
        stringBuffer.append(stringArray[stringArray.length - 1]);
        return stringBuffer.toString();
    }

    public static int a(Engine engine, BitmapFont bitmapFont, String string) {
        int n2 = 0;
        engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string);
        n2 = (int)engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width;
        return n2;
    }

    public static int b(Engine engine, BitmapFont bitmapFont, String string) {
        int n2 = 0;
        engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string);
        n2 = (int)engine.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.height;
        return n2;
    }

    public static String a(String string) {
        String string2 = "";
        boolean bl2 = true;
        for (char c2 : string.toCharArray()) {
            if (c2 == '[') {
                bl2 = false;
                continue;
            }
            if (c2 == ']') {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            string2 = string2 + c2;
        }
        return string2;
    }

    public static String a(Engine engine, BitmapFont bitmapFont, String string, int n2) {
        String string2 = string;
        String[] stringArray = string2.trim().split("\\ +");
        String string3 = "";
        String string4 = "";
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2].equals("\n")) {
                Engine.a("newline case");
                string4 = string4 + "\n";
            } else {
                string4 = string4 + stringArray[i2] + " ";
            }
            if (azu.a(engine, bitmapFont, string4) > n2) {
                string4 = string3;
                string4 = string4 + "\n" + stringArray[i2] + " ";
            }
            string3 = string4;
        }
        return string3;
    }

    public static List<String> a(Engine engine, BitmapFont bitmapFont, String string, int n2) {
        String string2 = string;
        Engine.b("splitStringList() in. s: " + string2 + " maxLineWidth: " + n2);
        String[] stringArray = string2.trim().split("\\ +");
        boolean bl2 = true;
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = "";
        String string4 = "";
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            string4 = string4 + string2.charAt(i2);
            Engine.b("in: " + i2 + " liveString: " + string3 + " futureString: " + string4 + " len: " + azu.a(engine, bitmapFont, string4));
            if (bl2 && azu.a(engine, bitmapFont, string4) > n2 || !bl2 && azu.a(engine, bitmapFont, string4) > n2) {
                Engine.b("Can't fit more than this this on a line. firstRow: " + bl2 + "+" + azu.a(engine, bitmapFont, string4) + " > " + n2);
                bl2 = false;
                arrayList.add(string4);
                string4 = "";
            }
            string3 = string4;
        }
        Engine.b("future string length: " + string4.length() + " is:" + string4);
        if (string4.length() > 1 && !arrayList.contains(string4)) {
            arrayList.add(string4);
        }
        Engine.b("Returning splitStringList size: " + arrayList.size());
        for (String string5 : arrayList) {
            Engine.b(string5);
        }
        Engine.b("--- out ---");
        return arrayList;
    }
}

