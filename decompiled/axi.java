/*
 * Decompiled with CFR 0.152.
 */
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class axi
extends ayh {
    private String var_java_lang_String_a;
    private int var_int_a;

    public axi(int n2, int n3, TextureAtlas textureAtlas, String string, int n4, boolean bl2) {
        this.var_java_lang_String_a = new Sprite(textureAtlas.createSprite(string));
        ((Sprite)((Object)this.var_java_lang_String_a)).setPosition(n2, n3);
        this.var_int_a = n4;
        this.b = bl2;
        this.var_java_lang_String_a = string;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }
}

