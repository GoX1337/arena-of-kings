/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.utils.NumberUtils;

public class Color {
    public static final Color WHITE = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public static final Color LIGHT_GRAY = new Color(-1077952513);
    public static final Color GRAY = new Color(0x7F7F7FFF);
    public static final Color DARK_GRAY = new Color(0x3F3F3FFF);
    public static final Color BLACK = new Color(0.0f, 0.0f, 0.0f, 1.0f);
    public static final float WHITE_FLOAT_BITS = WHITE.toFloatBits();
    public static final Color CLEAR = new Color(0.0f, 0.0f, 0.0f, 0.0f);
    public static final Color BLUE = new Color(0.0f, 0.0f, 1.0f, 1.0f);
    public static final Color NAVY = new Color(0.0f, 0.0f, 0.5f, 1.0f);
    public static final Color ROYAL = new Color(1097458175);
    public static final Color SLATE = new Color(1887473919);
    public static final Color SKY = new Color(-2016482305);
    public static final Color CYAN = new Color(0.0f, 1.0f, 1.0f, 1.0f);
    public static final Color TEAL = new Color(0.0f, 0.5f, 0.5f, 1.0f);
    public static final Color GREEN = new Color(0xFF00FF);
    public static final Color CHARTREUSE = new Color(0x7FFF00FF);
    public static final Color LIME = new Color(852308735);
    public static final Color FOREST = new Color(579543807);
    public static final Color OLIVE = new Color(1804477439);
    public static final Color YELLOW = new Color(-65281);
    public static final Color GOLD = new Color(-2686721);
    public static final Color GOLDENROD = new Color(-626712321);
    public static final Color ORANGE = new Color(-5963521);
    public static final Color BROWN = new Color(-1958407169);
    public static final Color TAN = new Color(-759919361);
    public static final Color FIREBRICK = new Color(-1306385665);
    public static final Color RED = new Color(-16776961);
    public static final Color SCARLET = new Color(-13361921);
    public static final Color CORAL = new Color(-8433409);
    public static final Color SALMON = new Color(-92245249);
    public static final Color PINK = new Color(-9849601);
    public static final Color MAGENTA = new Color(1.0f, 0.0f, 1.0f, 1.0f);
    public static final Color PURPLE = new Color(-1608453889);
    public static final Color VIOLET = new Color(-293409025);
    public static final Color MAROON = new Color(-1339006721);
    public float r;
    public float g;
    public float b;
    public float a;

    public Color() {
    }

    public Color(int n2) {
        Color.rgba8888ToColor(this, n2);
    }

    public Color(float f2, float f3, float f4, float f5) {
        this.r = f2;
        this.g = f3;
        this.b = f4;
        this.a = f5;
        this.clamp();
    }

    public Color(Color color) {
        this.set(color);
    }

    public Color set(Color color) {
        this.r = color.r;
        this.g = color.g;
        this.b = color.b;
        this.a = color.a;
        return this;
    }

    public Color mul(Color color) {
        this.r *= color.r;
        this.g *= color.g;
        this.b *= color.b;
        this.a *= color.a;
        return this.clamp();
    }

    public Color mul(float f2) {
        this.r *= f2;
        this.g *= f2;
        this.b *= f2;
        this.a *= f2;
        return this.clamp();
    }

    public Color add(Color color) {
        this.r += color.r;
        this.g += color.g;
        this.b += color.b;
        this.a += color.a;
        return this.clamp();
    }

    public Color sub(Color color) {
        this.r -= color.r;
        this.g -= color.g;
        this.b -= color.b;
        this.a -= color.a;
        return this.clamp();
    }

    public Color clamp() {
        if (this.r < 0.0f) {
            this.r = 0.0f;
        } else if (this.r > 1.0f) {
            this.r = 1.0f;
        }
        if (this.g < 0.0f) {
            this.g = 0.0f;
        } else if (this.g > 1.0f) {
            this.g = 1.0f;
        }
        if (this.b < 0.0f) {
            this.b = 0.0f;
        } else if (this.b > 1.0f) {
            this.b = 1.0f;
        }
        if (this.a < 0.0f) {
            this.a = 0.0f;
        } else if (this.a > 1.0f) {
            this.a = 1.0f;
        }
        return this;
    }

    public Color set(float f2, float f3, float f4, float f5) {
        this.r = f2;
        this.g = f3;
        this.b = f4;
        this.a = f5;
        return this.clamp();
    }

    public Color set(int n2) {
        Color.rgba8888ToColor(this, n2);
        return this;
    }

    public Color add(float f2, float f3, float f4, float f5) {
        this.r += f2;
        this.g += f3;
        this.b += f4;
        this.a += f5;
        return this.clamp();
    }

    public Color sub(float f2, float f3, float f4, float f5) {
        this.r -= f2;
        this.g -= f3;
        this.b -= f4;
        this.a -= f5;
        return this.clamp();
    }

    public Color mul(float f2, float f3, float f4, float f5) {
        this.r *= f2;
        this.g *= f3;
        this.b *= f4;
        this.a *= f5;
        return this.clamp();
    }

    public Color lerp(Color color, float f2) {
        this.r += f2 * (color.r - this.r);
        this.g += f2 * (color.g - this.g);
        this.b += f2 * (color.b - this.b);
        this.a += f2 * (color.a - this.a);
        return this.clamp();
    }

    public Color lerp(float f2, float f3, float f4, float f5, float f6) {
        this.r += f6 * (f2 - this.r);
        this.g += f6 * (f3 - this.g);
        this.b += f6 * (f4 - this.b);
        this.a += f6 * (f5 - this.a);
        return this.clamp();
    }

    public Color premultiplyAlpha() {
        this.r *= this.a;
        this.g *= this.a;
        this.b *= this.a;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Color color = (Color)object;
        return this.toIntBits() == color.toIntBits();
    }

    public int hashCode() {
        int n2 = this.r != 0.0f ? NumberUtils.floatToIntBits(this.r) : 0;
        n2 = 31 * n2 + (this.g != 0.0f ? NumberUtils.floatToIntBits(this.g) : 0);
        n2 = 31 * n2 + (this.b != 0.0f ? NumberUtils.floatToIntBits(this.b) : 0);
        n2 = 31 * n2 + (this.a != 0.0f ? NumberUtils.floatToIntBits(this.a) : 0);
        return n2;
    }

    public float toFloatBits() {
        int n2 = (int)(255.0f * this.a) << 24 | (int)(255.0f * this.b) << 16 | (int)(255.0f * this.g) << 8 | (int)(255.0f * this.r);
        return NumberUtils.intToFloatColor(n2);
    }

    public int toIntBits() {
        return (int)(255.0f * this.a) << 24 | (int)(255.0f * this.b) << 16 | (int)(255.0f * this.g) << 8 | (int)(255.0f * this.r);
    }

    public String toString() {
        String string = Integer.toHexString((int)(255.0f * this.r) << 24 | (int)(255.0f * this.g) << 16 | (int)(255.0f * this.b) << 8 | (int)(255.0f * this.a));
        while (string.length() < 8) {
            string = "0" + string;
        }
        return string;
    }

    public static Color valueOf(String string) {
        return Color.valueOf(string, new Color());
    }

    public static Color valueOf(String string, Color color) {
        string = string.charAt(0) == '#' ? string.substring(1) : string;
        color.r = (float)Integer.parseInt(string.substring(0, 2), 16) / 255.0f;
        color.g = (float)Integer.parseInt(string.substring(2, 4), 16) / 255.0f;
        color.b = (float)Integer.parseInt(string.substring(4, 6), 16) / 255.0f;
        color.a = string.length() != 8 ? 1.0f : (float)Integer.parseInt(string.substring(6, 8), 16) / 255.0f;
        return color;
    }

    public static float toFloatBits(int n2, int n3, int n4, int n5) {
        int n6 = n5 << 24 | n4 << 16 | n3 << 8 | n2;
        float f2 = NumberUtils.intToFloatColor(n6);
        return f2;
    }

    public static float toFloatBits(float f2, float f3, float f4, float f5) {
        int n2 = (int)(255.0f * f5) << 24 | (int)(255.0f * f4) << 16 | (int)(255.0f * f3) << 8 | (int)(255.0f * f2);
        return NumberUtils.intToFloatColor(n2);
    }

    public static int toIntBits(int n2, int n3, int n4, int n5) {
        return n5 << 24 | n4 << 16 | n3 << 8 | n2;
    }

    public static int alpha(float f2) {
        return (int)(f2 * 255.0f);
    }

    public static int luminanceAlpha(float f2, float f3) {
        return (int)(f2 * 255.0f) << 8 | (int)(f3 * 255.0f);
    }

    public static int rgb565(float f2, float f3, float f4) {
        return (int)(f2 * 31.0f) << 11 | (int)(f3 * 63.0f) << 5 | (int)(f4 * 31.0f);
    }

    public static int rgba4444(float f2, float f3, float f4, float f5) {
        return (int)(f2 * 15.0f) << 12 | (int)(f3 * 15.0f) << 8 | (int)(f4 * 15.0f) << 4 | (int)(f5 * 15.0f);
    }

    public static int rgb888(float f2, float f3, float f4) {
        return (int)(f2 * 255.0f) << 16 | (int)(f3 * 255.0f) << 8 | (int)(f4 * 255.0f);
    }

    public static int rgba8888(float f2, float f3, float f4, float f5) {
        return (int)(f2 * 255.0f) << 24 | (int)(f3 * 255.0f) << 16 | (int)(f4 * 255.0f) << 8 | (int)(f5 * 255.0f);
    }

    public static int argb8888(float f2, float f3, float f4, float f5) {
        return (int)(f2 * 255.0f) << 24 | (int)(f3 * 255.0f) << 16 | (int)(f4 * 255.0f) << 8 | (int)(f5 * 255.0f);
    }

    public static int rgb565(Color color) {
        return (int)(color.r * 31.0f) << 11 | (int)(color.g * 63.0f) << 5 | (int)(color.b * 31.0f);
    }

    public static int rgba4444(Color color) {
        return (int)(color.r * 15.0f) << 12 | (int)(color.g * 15.0f) << 8 | (int)(color.b * 15.0f) << 4 | (int)(color.a * 15.0f);
    }

    public static int rgb888(Color color) {
        return (int)(color.r * 255.0f) << 16 | (int)(color.g * 255.0f) << 8 | (int)(color.b * 255.0f);
    }

    public static int rgba8888(Color color) {
        return (int)(color.r * 255.0f) << 24 | (int)(color.g * 255.0f) << 16 | (int)(color.b * 255.0f) << 8 | (int)(color.a * 255.0f);
    }

    public static int argb8888(Color color) {
        return (int)(color.a * 255.0f) << 24 | (int)(color.r * 255.0f) << 16 | (int)(color.g * 255.0f) << 8 | (int)(color.b * 255.0f);
    }

    public static void rgb565ToColor(Color color, int n2) {
        color.r = (float)((n2 & 0xF800) >>> 11) / 31.0f;
        color.g = (float)((n2 & 0x7E0) >>> 5) / 63.0f;
        color.b = (float)((n2 & 0x1F) >>> 0) / 31.0f;
    }

    public static void rgba4444ToColor(Color color, int n2) {
        color.r = (float)((n2 & 0xF000) >>> 12) / 15.0f;
        color.g = (float)((n2 & 0xF00) >>> 8) / 15.0f;
        color.b = (float)((n2 & 0xF0) >>> 4) / 15.0f;
        color.a = (float)(n2 & 0xF) / 15.0f;
    }

    public static void rgb888ToColor(Color color, int n2) {
        color.r = (float)((n2 & 0xFF0000) >>> 16) / 255.0f;
        color.g = (float)((n2 & 0xFF00) >>> 8) / 255.0f;
        color.b = (float)(n2 & 0xFF) / 255.0f;
    }

    public static void rgba8888ToColor(Color color, int n2) {
        color.r = (float)((n2 & 0xFF000000) >>> 24) / 255.0f;
        color.g = (float)((n2 & 0xFF0000) >>> 16) / 255.0f;
        color.b = (float)((n2 & 0xFF00) >>> 8) / 255.0f;
        color.a = (float)(n2 & 0xFF) / 255.0f;
    }

    public static void argb8888ToColor(Color color, int n2) {
        color.a = (float)((n2 & 0xFF000000) >>> 24) / 255.0f;
        color.r = (float)((n2 & 0xFF0000) >>> 16) / 255.0f;
        color.g = (float)((n2 & 0xFF00) >>> 8) / 255.0f;
        color.b = (float)(n2 & 0xFF) / 255.0f;
    }

    public static void abgr8888ToColor(Color color, int n2) {
        color.a = (float)((n2 & 0xFF000000) >>> 24) / 255.0f;
        color.b = (float)((n2 & 0xFF0000) >>> 16) / 255.0f;
        color.g = (float)((n2 & 0xFF00) >>> 8) / 255.0f;
        color.r = (float)(n2 & 0xFF) / 255.0f;
    }

    public static void abgr8888ToColor(Color color, float f2) {
        int n2 = NumberUtils.floatToIntColor(f2);
        color.a = (float)((n2 & 0xFF000000) >>> 24) / 255.0f;
        color.b = (float)((n2 & 0xFF0000) >>> 16) / 255.0f;
        color.g = (float)((n2 & 0xFF00) >>> 8) / 255.0f;
        color.r = (float)(n2 & 0xFF) / 255.0f;
    }

    public Color fromHsv(float f2, float f3, float f4) {
        float f5 = (f2 / 60.0f + 6.0f) % 6.0f;
        int n2 = (int)f5;
        float f6 = f5 - (float)n2;
        float f7 = f4 * (1.0f - f3);
        float f8 = f4 * (1.0f - f3 * f6);
        float f9 = f4 * (1.0f - f3 * (1.0f - f6));
        switch (n2) {
            case 0: {
                this.r = f4;
                this.g = f9;
                this.b = f7;
                break;
            }
            case 1: {
                this.r = f8;
                this.g = f4;
                this.b = f7;
                break;
            }
            case 2: {
                this.r = f7;
                this.g = f4;
                this.b = f9;
                break;
            }
            case 3: {
                this.r = f7;
                this.g = f8;
                this.b = f4;
                break;
            }
            case 4: {
                this.r = f9;
                this.g = f7;
                this.b = f4;
                break;
            }
            default: {
                this.r = f4;
                this.g = f7;
                this.b = f8;
            }
        }
        return this.clamp();
    }

    public Color fromHsv(float[] fArray) {
        return this.fromHsv(fArray[0], fArray[1], fArray[2]);
    }

    public float[] toHsv(float[] fArray) {
        float f2;
        float f3 = Math.max(Math.max(this.r, this.g), this.b);
        float f4 = f3 - (f2 = Math.min(Math.min(this.r, this.g), this.b));
        fArray[0] = f4 == 0.0f ? 0.0f : (f3 == this.r ? (60.0f * (this.g - this.b) / f4 + 360.0f) % 360.0f : (f3 == this.g ? 60.0f * (this.b - this.r) / f4 + 120.0f : 60.0f * (this.r - this.g) / f4 + 240.0f));
        fArray[1] = f3 > 0.0f ? 1.0f - f2 / f3 : 0.0f;
        fArray[2] = f3;
        return fArray;
    }

    public Color cpy() {
        return new Color(this);
    }
}

