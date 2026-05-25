/*
 * Decompiled with CFR 0.152.
 */
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class axy {
    private BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a;
    private Color var_com_badlogic_gdx_graphics_Color_a;
    private final float var_float_a;
    private float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    public axy(BitmapFont bitmapFont) {
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = bitmapFont;
        BitmapFont.BitmapFontData bitmapFontData = bitmapFont.getData();
        this.var_float_a = bitmapFontData.lineHeight;
        this.b = bitmapFontData.spaceXadvance;
        this.c = bitmapFontData.xHeight;
        this.d = bitmapFontData.capHeight;
        this.e = bitmapFontData.ascent;
        this.f = bitmapFontData.descent;
        this.g = bitmapFontData.down;
        this.h = bitmapFontData.scaleX;
        this.i = bitmapFontData.scaleY;
        this.var_com_badlogic_gdx_graphics_Color_a = bitmapFont.getColor();
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a.setUseIntegerPositions(false);
    }

    public BitmapFont a() {
        return this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a;
    }
}

