/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemLink;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axh
extends Widget
implements Disableable {
    private static final Vector2 var_com_badlogic_gdx_math_Vector2_a;
    private static final Vector2 var_com_badlogic_gdx_math_Vector2_b;
    private static final Vector2 var_com_badlogic_gdx_math_Vector2_c;
    public static float var_float_a;
    public static float var_float_b;
    protected String var_java_lang_String_a;
    protected int var_int_a;
    protected int var_int_b;
    protected boolean var_boolean_a;
    protected boolean var_boolean_b;
    protected final GlyphLayout var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = new GlyphLayout();
    protected final FloatArray var_com_badlogic_gdx_utils_FloatArray_a = new FloatArray();
    private boolean var_boolean_i = true;
    private int var_int_c;
    private int var_int_d = 0;
    TextField.TextFieldStyle var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a;
    private String var_java_lang_String_c;
    protected CharSequence var_java_lang_CharSequence_a;
    Clipboard var_com_badlogic_gdx_utils_Clipboard_a;
    InputListener var_com_badlogic_gdx_scenes_scene2d_InputListener_a;
    f var_axh$f_a;
    e var_axh$e_a;
    c var_axh$c_a = new a();
    boolean var_boolean_c = true;
    boolean var_boolean_d = true;
    boolean var_boolean_e;
    private int var_int_e = 8;
    private float var_float_g;
    private float var_float_h;
    String var_java_lang_String_b = "";
    long var_long_a;
    boolean var_boolean_f;
    private StringBuilder var_java_lang_StringBuilder_a;
    private char var_char_a = (char)149;
    protected float var_float_c;
    protected float var_float_d;
    protected float var_float_e;
    float var_float_f;
    private int var_int_f;
    private int var_int_g;
    private int var_int_h = 0;
    private float var_float_i = 0.32f;
    boolean var_boolean_g = true;
    long var_long_b;
    b var_axh$b_a = new b(this);
    boolean var_boolean_h;
    private List<ItemLink> var_java_util_List_com_arenaofkings_packets_misc_items_ItemLink__a;
    private Iterator<ItemLink> var_java_util_Iterator_com_arenaofkings_packets_misc_items_ItemLink__a;

    public axh(String string, Skin skin) {
        this(string, skin.get(TextField.TextFieldStyle.class));
    }

    public axh(String string, TextField.TextFieldStyle textFieldStyle) {
        this.a(textFieldStyle);
        this.var_com_badlogic_gdx_utils_Clipboard_a = Gdx.app.getClipboard();
        this.void_a();
        this.b(string);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.var_com_badlogic_gdx_math_Vector2_a = new ArrayList();
    }

    protected void void_a() {
        this.var_com_badlogic_gdx_scenes_scene2d_InputListener_a = this.com_badlogic_gdx_scenes_scene2d_InputListener_a();
        this.addListener(this.var_com_badlogic_gdx_scenes_scene2d_InputListener_a);
    }

    protected InputListener com_badlogic_gdx_scenes_scene2d_InputListener_a() {
        return new d();
    }

    protected int int_a(float f2) {
        f2 -= this.var_float_e + this.var_float_c - this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.font.getData().cursorX - this.var_com_badlogic_gdx_utils_FloatArray_a.get(this.var_int_f);
        Drawable drawable = this.com_badlogic_gdx_scenes_scene2d_utils_Drawable_a();
        if (drawable != null) {
            f2 -= this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.background.getLeftWidth();
        }
        int n2 = this.var_com_badlogic_gdx_utils_FloatArray_a.size;
        float[] fArray = this.var_com_badlogic_gdx_utils_FloatArray_a.items;
        for (int i2 = 1; i2 < n2; ++i2) {
            if (!(fArray[i2] > f2)) continue;
            if (fArray[i2] - f2 <= f2 - fArray[i2 - 1]) {
                return i2;
            }
            return i2 - 1;
        }
        return n2 - 1;
    }

    protected boolean a(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    protected int[] int_arr_a(int n2) {
        String string = this.var_java_lang_String_a;
        int n3 = n2;
        int n4 = string.length();
        int n5 = 0;
        if (n2 >= string.length()) {
            n5 = string.length();
            n4 = 0;
        } else {
            int n6;
            for (n6 = n3; n6 < n4; ++n6) {
                if (this.a(string.charAt(n6))) continue;
                n4 = n6;
                break;
            }
            for (n6 = n3 - 1; n6 > -1; --n6) {
                if (this.a(string.charAt(n6))) continue;
                n5 = n6 + 1;
                break;
            }
        }
        return new int[]{n5, n4};
    }

    int[] int_arr_a(float f2) {
        return this.int_arr_a(this.int_a(f2));
    }

    boolean boolean_a(int n2) {
        return this.var_int_h <= 0 || n2 < this.var_int_h;
    }

    public void void_a(int n2) {
        this.var_int_h = n2;
    }

    public void a(TextField.TextFieldStyle textFieldStyle) {
        if (textFieldStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a = textFieldStyle;
        this.var_float_d = textFieldStyle.font.getCapHeight() - textFieldStyle.font.getDescent() * 2.0f;
        this.invalidateHierarchy();
    }

    public TextField.TextFieldStyle com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a;
    }

    protected void b() {
        int n2;
        float f2;
        float f3;
        float f4 = this.getWidth();
        Drawable drawable = this.com_badlogic_gdx_scenes_scene2d_utils_Drawable_a();
        if (drawable != null) {
            f4 -= drawable.getLeftWidth() + drawable.getRightWidth();
        }
        int n3 = this.var_com_badlogic_gdx_utils_FloatArray_a.size;
        float[] fArray = this.var_com_badlogic_gdx_utils_FloatArray_a.items;
        float f5 = fArray[Math.max(0, this.var_int_a - 1)] + this.var_float_f;
        if (f5 <= 0.0f) {
            this.var_float_f -= f5;
        } else {
            int n4 = Math.min(n3 - 1, this.var_int_a + 1);
            f3 = fArray[n4] - f4;
            if (-this.var_float_f < f3) {
                this.var_float_f = -f3;
            }
        }
        float f6 = 0.0f;
        f3 = fArray[n3 - 1];
        for (int i2 = n3 - 2; i2 >= 0 && !(f3 - (f2 = fArray[i2]) > f4); --i2) {
            f6 = f2;
        }
        if (-this.var_float_f > f6) {
            this.var_float_f = -f6;
        }
        this.var_int_f = 0;
        float f7 = 0.0f;
        for (n2 = 0; n2 < n3; ++n2) {
            if (!(fArray[n2] >= -this.var_float_f)) continue;
            this.var_int_f = Math.max(0, n2);
            f7 = fArray[n2];
            break;
        }
        n2 = Math.min(this.var_java_lang_CharSequence_a.length(), fArray.length - 1);
        this.var_int_g = Math.min(n2, this.var_int_a + 1);
        while (this.var_int_g <= n2 && !(fArray[this.var_int_g] > f7 + f4)) {
            ++this.var_int_g;
        }
        this.var_int_g = Math.max(0, this.var_int_g - 1);
        if ((this.var_int_e & 8) == 0) {
            this.var_float_e = f4 - (fArray[this.var_int_g] - f7);
            if ((this.var_int_e & 1) != 0) {
                this.var_float_e = Math.round(this.var_float_e * 0.5f);
            }
        } else {
            this.var_float_e = f7 + this.var_float_f;
        }
        if (this.var_boolean_a) {
            int n5 = Math.min(this.var_int_a, this.var_int_b);
            int n6 = Math.max(this.var_int_a, this.var_int_b);
            float f8 = Math.max(fArray[n5] - fArray[this.var_int_f], -this.var_float_e);
            float f9 = Math.min(fArray[n6] - fArray[this.var_int_f], f4 - this.var_float_e);
            this.var_float_g = f8;
            this.var_float_h = f9 - f8 - this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.font.getData().cursorX;
        }
    }

    private Drawable com_badlogic_gdx_scenes_scene2d_utils_Drawable_a() {
        boolean bl2;
        Stage stage = this.getStage();
        boolean bl3 = bl2 = stage != null && stage.getKeyboardFocus() == this;
        return this.var_boolean_e && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledBackground != null ? this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledBackground : (bl2 && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedBackground != null ? this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedBackground : this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.background);
    }

    @Override
    public void draw(Batch batch, float f2) {
        float f3;
        boolean bl2;
        Stage stage = this.getStage();
        boolean bl3 = bl2 = stage != null && stage.getKeyboardFocus() == this;
        if (!bl2) {
            this.var_axh$b_a.cancel();
        }
        BitmapFont bitmapFont = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.font;
        Color color = this.var_boolean_e && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledFontColor != null ? this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledFontColor : (bl2 && this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedFontColor != null ? this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedFontColor : this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.fontColor);
        Drawable drawable = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.selection;
        Drawable drawable2 = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.cursor;
        Drawable drawable3 = this.com_badlogic_gdx_scenes_scene2d_utils_Drawable_a();
        Color color2 = this.getColor();
        float f4 = this.getX();
        float f5 = this.getY();
        float f6 = this.getWidth();
        float f7 = this.getHeight();
        batch.setColor(color2.r, color2.g, color2.b, color2.a * f2);
        float f8 = 0.0f;
        float f9 = 0.0f;
        if (drawable3 != null) {
            // empty if block
        }
        float f10 = this.a(bitmapFont, drawable3);
        this.b();
        if (bl2 && this.var_boolean_a && drawable != null) {
            this.a(drawable, batch, bitmapFont, f4 + f8, f5 + f10);
        }
        float f11 = f3 = bitmapFont.isFlipped() ? -this.var_float_d : 0.0f;
        if (this.var_java_lang_CharSequence_a.length() == 0) {
            if (!bl2 && this.var_java_lang_String_c != null) {
                if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFontColor != null) {
                    bitmapFont.setColor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFontColor.r, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFontColor.g, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFontColor.b, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFontColor.a * color2.a * f2);
                } else {
                    bitmapFont.setColor(0.7f, 0.7f, 0.7f, color2.a * f2);
                }
                BitmapFont bitmapFont2 = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFont != null ? this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.messageFont : bitmapFont;
                bitmapFont2.draw(batch, this.var_java_lang_String_c, f4 + f8, f5 + f10 + f3, 0, this.var_java_lang_String_c.length(), f6 - f8 - f9, this.var_int_e, false, "...");
            }
        } else {
            bitmapFont.setColor(color.r, color.g, color.b, color.a * color2.a * f2);
            this.a(batch, bitmapFont, f4 + f8, f5 + f10 + f3);
        }
        if (bl2 && !this.var_boolean_e) {
            this.g();
            if (this.var_boolean_g && drawable2 != null) {
                this.b(drawable2, batch, bitmapFont, f4 + f8, f5 + f10);
            }
        }
    }

    protected float a(BitmapFont bitmapFont, Drawable drawable) {
        float f2 = this.getHeight();
        float f3 = this.var_float_d / 2.0f + bitmapFont.getDescent();
        if (drawable != null) {
            float f4 = drawable.getBottomHeight();
            f3 = f3 + (f2 - drawable.getTopHeight() - f4) / 2.0f + f4;
        } else {
            f3 += f2 / 2.0f;
        }
        if (bitmapFont.usesIntegerPositions()) {
            f3 = (int)f3;
        }
        return f3;
    }

    protected void a(Drawable drawable, Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        drawable.draw(batch, f2 + this.var_float_e + this.var_float_g + this.var_float_c, f3 - this.var_float_d - bitmapFont.getDescent(), this.var_float_h, this.var_float_d);
    }

    protected void a(Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        bitmapFont.draw(batch, this.var_java_lang_CharSequence_a, f2 + this.var_float_e, f3, this.var_int_f, this.var_int_g, 0.0f, 8, false);
    }

    protected void b(Drawable drawable, Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        drawable.draw(batch, f2 + this.var_float_e + this.var_com_badlogic_gdx_utils_FloatArray_a.get(this.var_int_a) - this.var_com_badlogic_gdx_utils_FloatArray_a.get(this.var_int_f) + this.var_float_c + bitmapFont.getData().cursorX, f3 - this.var_float_d - bitmapFont.getDescent(), drawable.getMinWidth(), this.var_float_d);
    }

    void c() {
        int n2;
        BitmapFont bitmapFont = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.font;
        BitmapFont.BitmapFontData bitmapFontData = bitmapFont.getData();
        String string = this.var_java_lang_String_a;
        int n3 = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = string.charAt(i2);
            stringBuilder.append((char)(bitmapFontData.hasGlyph((char)n2) ? n2 : 32));
        }
        String string2 = stringBuilder.toString();
        if (this.var_boolean_f && bitmapFontData.hasGlyph(this.var_char_a)) {
            if (this.var_java_lang_StringBuilder_a == null) {
                this.var_java_lang_StringBuilder_a = new StringBuilder(string2.length());
            }
            if (this.var_java_lang_StringBuilder_a.length() > n3) {
                this.var_java_lang_StringBuilder_a.setLength(n3);
            } else {
                for (n2 = this.var_java_lang_StringBuilder_a.length(); n2 < n3; ++n2) {
                    this.var_java_lang_StringBuilder_a.append(this.var_char_a);
                }
            }
            this.var_java_lang_CharSequence_a = this.var_java_lang_StringBuilder_a;
        } else {
            this.var_java_lang_CharSequence_a = string2;
        }
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, this.var_java_lang_CharSequence_a);
        this.var_com_badlogic_gdx_utils_FloatArray_a.clear();
        float f2 = 0.0f;
        if (this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.runs.size > 0) {
            GlyphLayout.GlyphRun glyphRun = this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.runs.first();
            FloatArray floatArray = glyphRun.xAdvances;
            this.var_float_c = floatArray.first();
            int n4 = floatArray.size;
            for (int i3 = 1; i3 < n4; ++i3) {
                this.var_com_badlogic_gdx_utils_FloatArray_a.add(f2);
                f2 += floatArray.get(i3);
            }
        } else {
            this.var_float_c = 0.0f;
        }
        this.var_com_badlogic_gdx_utils_FloatArray_a.add(f2);
        if (this.var_int_b > string2.length()) {
            this.var_int_b = n3;
        }
    }

    private void g() {
        if (!Gdx.graphics.isContinuousRendering()) {
            this.var_boolean_g = true;
            return;
        }
        this.var_int_c = (int)(this.var_float_i / (float)Gdx.graphics.getFramesPerSecond());
        if (this.var_boolean_i && this.var_int_d <= this.var_int_c) {
            this.var_boolean_g = true;
            ++this.var_int_d;
            long l2 = TimeUtils.nanoTime();
            if ((float)(l2 - this.var_long_b) / 1.0E9f > this.var_float_i) {
                Engine.a("2");
                this.var_boolean_i = false;
            }
        } else {
            long l3 = TimeUtils.nanoTime();
            if ((float)(l3 - this.var_long_b) / 1.0E9f > this.var_float_i) {
                this.var_boolean_g = !this.var_boolean_g;
                this.var_long_b = l3;
            }
        }
    }

    public void d() {
        if (this.var_boolean_a && !this.var_boolean_f) {
            this.var_com_badlogic_gdx_utils_Clipboard_a.setContents(this.var_java_lang_String_a.substring(Math.min(this.var_int_a, this.var_int_b), Math.max(this.var_int_a, this.var_int_b)));
        }
    }

    void void_a(boolean bl2) {
        if (this.var_boolean_a && !this.var_boolean_f) {
            this.d();
            this.var_int_a = this.int_a(bl2);
            this.c();
        }
    }

    void a(String string, boolean bl2) {
        if (string == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.var_java_lang_String_a.length();
        if (this.var_boolean_a) {
            n2 -= Math.abs(this.var_int_a - this.var_int_b);
        }
        BitmapFont.BitmapFontData bitmapFontData = this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.font.getData();
        int n3 = string.length();
        for (int i2 = 0; i2 < n3 && this.boolean_a(n2 + stringBuilder.length()); ++i2) {
            char c2 = string.charAt(i2);
            if ((!this.var_boolean_b || c2 != '\n' && c2 != '\r') && (c2 == '\r' || c2 == '\n' || this.var_boolean_d && !bitmapFontData.hasGlyph(c2) || this.var_axh$e_a != null && !this.var_axh$e_a.a(this, c2))) continue;
            stringBuilder.append(c2);
        }
        string = stringBuilder.toString();
        if (this.var_boolean_a) {
            this.var_int_a = this.int_a(bl2);
        }
        if (bl2) {
            this.a(this.var_java_lang_String_a, this.a(this.var_int_a, string, this.var_java_lang_String_a));
        } else {
            this.var_java_lang_String_a = this.a(this.var_int_a, string, this.var_java_lang_String_a);
        }
        this.c();
        this.var_int_a += string.length();
    }

    String a(int n2, CharSequence charSequence, String string) {
        if (string.length() == 0) {
            return charSequence.toString();
        }
        return string.substring(0, n2) + charSequence + string.substring(n2, string.length());
    }

    int int_a(boolean bl2) {
        int n2 = this.var_int_b;
        int n3 = this.var_int_a;
        int n4 = Math.min(n2, n3);
        int n5 = Math.max(n2, n3);
        String string = (n4 > 0 ? this.var_java_lang_String_a.substring(0, n4) : "") + (n5 < this.var_java_lang_String_a.length() ? this.var_java_lang_String_a.substring(n5, this.var_java_lang_String_a.length()) : "");
        if (bl2) {
            this.a(this.var_java_lang_String_a, string);
        } else {
            this.var_java_lang_String_a = string;
        }
        this.f();
        return n4;
    }

    public void b(boolean bl2) {
        Stage stage = this.getStage();
        if (stage == null) {
            return;
        }
        axh axh2 = this;
        while (true) {
            axh2.getParent().localToStageCoordinates(var_com_badlogic_gdx_math_Vector2_a.set(this.getX(), this.getY()));
            axh axh3 = axh2.a(stage.getActors(), null, var_com_badlogic_gdx_math_Vector2_b, var_com_badlogic_gdx_math_Vector2_a, bl2);
            if (axh3 == null) {
                if (bl2) {
                    var_com_badlogic_gdx_math_Vector2_a.set(Float.MIN_VALUE, Float.MIN_VALUE);
                } else {
                    var_com_badlogic_gdx_math_Vector2_a.set(Float.MAX_VALUE, Float.MAX_VALUE);
                }
                axh3 = axh2.a(this.getStage().getActors(), null, var_com_badlogic_gdx_math_Vector2_b, var_com_badlogic_gdx_math_Vector2_a, bl2);
            }
            if (axh3 == null) {
                Gdx.input.setOnscreenKeyboardVisible(false);
                break;
            }
            if (stage.setKeyboardFocus(axh3)) break;
            axh2 = axh3;
        }
    }

    private axh a(Array<Actor> array, axh axh2, Vector2 vector2, Vector2 vector22, boolean bl2) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Actor actor = array.get(i2);
            if (actor == this) continue;
            if (actor instanceof axh) {
                axh axh3 = (axh)actor;
                if (axh3.isDisabled() || !axh3.var_boolean_c) continue;
                Vector2 vector23 = actor.getParent().localToStageCoordinates(var_com_badlogic_gdx_math_Vector2_c.set(actor.getX(), actor.getY()));
                if (!((vector23.y < vector22.y || vector23.y == vector22.y && vector23.x > vector22.x) ^ bl2) || axh2 != null && !((vector23.y > vector2.y || vector23.y == vector2.y && vector23.x < vector2.x) ^ bl2)) continue;
                axh2 = (axh)actor;
                vector2.set(vector23);
                continue;
            }
            if (!(actor instanceof Group)) continue;
            axh2 = this.a(((Group)actor).getChildren(), axh2, vector2, vector22, bl2);
        }
        return axh2;
    }

    public void c(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public void a(String string) {
        if (string == null) {
            string = "";
        }
        this.f();
        this.var_int_a = this.var_java_lang_String_a.length();
        this.a(string, this.var_boolean_h);
    }

    public void b(String string) {
        if (string == null) {
            string = "";
        }
        if (string.equals(this.var_java_lang_String_a)) {
            return;
        }
        this.f();
        String string2 = this.var_java_lang_String_a;
        this.var_java_lang_String_a = "";
        this.a(string, false);
        if (this.var_boolean_h) {
            this.a(string2, this.var_java_lang_String_a);
        }
        this.var_int_a = 0;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    boolean a(String string, String string2) {
        if (string2.equals(string)) {
            return false;
        }
        this.var_java_lang_String_a = string2;
        ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
        boolean bl2 = this.fire(changeEvent);
        this.var_java_lang_String_a = bl2 ? string : string2;
        Pools.free(changeEvent);
        return !bl2;
    }

    public void void_a(int n2, int n3) {
        if (n2 < 0) {
            throw new IllegalArgumentException("selectionStart must be >= 0");
        }
        if (n3 < 0) {
            throw new IllegalArgumentException("selectionEnd must be >= 0");
        }
        n2 = Math.min(this.var_java_lang_String_a.length(), n2);
        n3 = Math.min(this.var_java_lang_String_a.length(), n3);
        if (n3 == n2) {
            this.f();
            return;
        }
        if (n3 < n2) {
            int n4 = n3;
            n3 = n2;
            n2 = n4;
        }
        this.var_boolean_a = true;
        this.var_int_b = n2;
        this.var_int_a = n3;
    }

    public void e() {
        this.void_a(0, this.var_java_lang_String_a.length());
    }

    public void f() {
        this.var_boolean_a = false;
    }

    public void b(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("cursorPosition must be >= 0");
        }
        this.f();
        this.var_int_a = Math.min(n2, this.var_java_lang_String_a.length());
    }

    public int int_a() {
        return this.var_int_a;
    }

    @Override
    public float getPrefWidth() {
        return 150.0f;
    }

    @Override
    public float getPrefHeight() {
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.background != null) {
            f2 = Math.max(f2, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.background.getBottomHeight() + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.background.getTopHeight());
            f3 = Math.max(f3, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.background.getMinHeight());
        }
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedBackground != null) {
            f2 = Math.max(f2, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedBackground.getBottomHeight() + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedBackground.getTopHeight());
            f3 = Math.max(f3, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.focusedBackground.getMinHeight());
        }
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledBackground != null) {
            f2 = Math.max(f2, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledBackground.getBottomHeight() + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledBackground.getTopHeight());
            f3 = Math.max(f3, this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.disabledBackground.getMinHeight());
        }
        return Math.max(f2 + this.var_float_d, f3);
    }

    public void c(int n2) {
        this.var_int_e = n2;
    }

    public void void_a(float f2) {
        this.var_float_i = f2;
    }

    @Override
    public void setDisabled(boolean bl2) {
        this.var_boolean_e = bl2;
    }

    @Override
    public boolean isDisabled() {
        return this.var_boolean_e;
    }

    protected void a(boolean bl2, boolean bl3) {
        int n2;
        int n3 = bl2 ? this.var_java_lang_String_a.length() : 0;
        int n4 = n2 = bl2 ? 0 : -1;
        while ((bl2 ? ++this.var_int_a < n3 : --this.var_int_a > n3) && bl3 && this.boolean_a(this.var_int_a, n2)) {
        }
    }

    protected boolean boolean_a(int n2, int n3) {
        char c2 = this.var_java_lang_String_a.charAt(n2 + n3);
        return this.a(c2);
    }

    public void a(fm fm2) {
        Engine.b("LinkItem() in");
        if (fm2 == null) {
            return;
        }
        if (fm2 instanceof ff) {
            return;
        }
        Engine.b("item name: " + fm2.java_lang_String_a());
        if (this.boolean_a(this.var_java_lang_String_a.length() + fm2.java_lang_String_a().length() + 2)) {
            int n2 = this.int_a();
            this.a("[" + fm2.java_lang_String_a() + "]");
            int n3 = this.int_a();
            Engine.b("Item at: " + n2 + " " + n3);
            this.var_com_badlogic_gdx_math_Vector2_a.add(new ItemLink(n2, n3, fm2));
        }
        Engine.b("LinkItem() out");
    }

    public List<ItemLink> a() {
        return this.var_com_badlogic_gdx_math_Vector2_a;
    }

    static {
        var_com_badlogic_gdx_math_Vector2_a = new Vector2();
        var_com_badlogic_gdx_math_Vector2_b = new Vector2();
        var_com_badlogic_gdx_math_Vector2_c = new Vector2();
        var_float_a = 0.4f;
        var_float_b = 0.1f;
    }

    public static class a
    implements c {
        @Override
        public void a(boolean bl2) {
            Gdx.input.setOnscreenKeyboardVisible(bl2);
        }
    }

    public static interface c {
        public void a(boolean var1);
    }

    class b
    extends Timer.Task {
        int var_int_a;
        final /* synthetic */ axh var_axh_a;

        b(axh axh2) {
            this.var_axh_a = axh2;
        }

        @Override
        public void run() {
            this.var_axh_a.var_com_badlogic_gdx_scenes_scene2d_InputListener_a.keyDown(null, this.var_int_a);
        }
    }

    public class d
    extends ClickListener {
        @Override
        public void clicked(InputEvent inputEvent, float f2, float f3) {
            int n2 = this.getTapCount() % 4;
            if (n2 == 0) {
                axh.this.f();
            }
            if (n2 == 2) {
                int[] nArray = axh.this.int_arr_a(f2);
                axh.this.void_a(nArray[0], nArray[1]);
            }
            if (n2 == 3) {
                axh.this.e();
            }
        }

        @Override
        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
            if (!super.touchDown(inputEvent, f2, f3, n2, n3)) {
                return false;
            }
            if (n2 == 0 && n3 != 0) {
                return false;
            }
            if (axh.this.var_boolean_e) {
                return true;
            }
            this.a(f2, f3);
            axh.this.var_int_b = axh.this.var_int_a;
            Stage stage = axh.this.getStage();
            if (stage != null) {
                stage.setKeyboardFocus(axh.this);
            }
            axh.this.var_axh$c_a.a(true);
            axh.this.var_boolean_a = true;
            return true;
        }

        @Override
        public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
            super.touchDragged(inputEvent, f2, f3, n2);
            this.a(f2, f3);
        }

        @Override
        public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
            if (axh.this.var_int_b == axh.this.var_int_a) {
                axh.this.var_boolean_a = false;
            }
            super.touchUp(inputEvent, f2, f3, n2, n3);
        }

        protected void a(float f2, float f3) {
            axh.this.var_long_b = 0L;
            axh.this.var_boolean_g = false;
            axh.this.var_int_a = axh.this.int_a(f2);
        }

        protected void a(boolean bl2) {
            axh.this.var_int_a = 0;
        }

        protected void b(boolean bl2) {
            axh.this.var_int_a = axh.this.var_java_lang_String_a.length();
        }

        @Override
        public boolean keyDown(InputEvent inputEvent, int n2) {
            boolean bl2;
            block23: {
                boolean bl3;
                block18: {
                    int n3;
                    block20: {
                        block22: {
                            block21: {
                                block19: {
                                    if (axh.this.var_boolean_e) {
                                        return false;
                                    }
                                    axh.this.var_long_b = 0L;
                                    axh.this.var_boolean_g = false;
                                    Stage stage = axh.this.getStage();
                                    if (stage == null || stage.getKeyboardFocus() != axh.this) {
                                        return false;
                                    }
                                    bl2 = false;
                                    boolean bl4 = UIUtils.ctrl();
                                    boolean bl5 = bl3 = bl4 && !axh.this.var_boolean_f;
                                    if (bl4) {
                                        if (n2 == 50) {
                                            axh.this.a(axh.this.var_com_badlogic_gdx_utils_Clipboard_a.getContents(), true);
                                            bl2 = true;
                                        }
                                        if (n2 == 31 || n2 == 124) {
                                            axh.this.d();
                                            return true;
                                        }
                                        if (n2 == 52) {
                                            axh.this.void_a(true);
                                            return true;
                                        }
                                        if (n2 == 29) {
                                            axh.this.e();
                                            return true;
                                        }
                                        if (n2 == 54) {
                                            String string = axh.this.var_java_lang_String_a;
                                            axh.this.b(axh.this.var_java_lang_String_b);
                                            axh.this.var_java_lang_String_b = string;
                                            axh.this.c();
                                            return true;
                                        }
                                    }
                                    if (!UIUtils.shift()) break block18;
                                    if (n2 == 124) {
                                        axh.this.a(axh.this.var_com_badlogic_gdx_utils_Clipboard_a.getContents(), true);
                                    }
                                    if (n2 == 112) {
                                        axh.this.void_a(true);
                                    }
                                    n3 = axh.this.var_int_a;
                                    if (n2 != 21) break block19;
                                    axh.this.a(false, bl3);
                                    bl2 = true;
                                    break block20;
                                }
                                if (n2 != 22) break block21;
                                axh.this.a(true, bl3);
                                bl2 = true;
                                break block20;
                            }
                            if (n2 != 3) break block22;
                            this.a(bl3);
                            break block20;
                        }
                        if (n2 != 123) break block23;
                        this.b(bl3);
                    }
                    if (!axh.this.var_boolean_a) {
                        axh.this.var_int_b = n3;
                        axh.this.var_boolean_a = true;
                    }
                    break block23;
                }
                if (n2 == 21) {
                    axh.this.a(false, bl3);
                    axh.this.f();
                    bl2 = true;
                }
                if (n2 == 22) {
                    axh.this.a(true, bl3);
                    axh.this.f();
                    bl2 = true;
                }
                if (n2 == 3) {
                    this.a(bl3);
                    axh.this.f();
                }
                if (n2 == 123) {
                    this.b(bl3);
                    axh.this.f();
                }
            }
            axh.this.var_int_a = MathUtils.clamp(axh.this.var_int_a, 0, axh.this.var_java_lang_String_a.length());
            if (bl2) {
                this.a(n2);
            }
            return true;
        }

        protected void a(int n2) {
            if (!axh.this.var_axh$b_a.isScheduled() || axh.this.var_axh$b_a.var_int_a != n2) {
                axh.this.var_axh$b_a.var_int_a = n2;
                axh.this.var_axh$b_a.cancel();
                Timer.schedule(axh.this.var_axh$b_a, var_float_a, var_float_b);
            }
        }

        @Override
        public boolean keyUp(InputEvent inputEvent, int n2) {
            if (axh.this.var_boolean_e) {
                return false;
            }
            axh.this.var_axh$b_a.cancel();
            return true;
        }

        @Override
        public boolean keyTyped(InputEvent inputEvent, char c2) {
            if (axh.this.var_boolean_e) {
                return false;
            }
            switch (c2) {
                case '\b': 
                case '\t': 
                case '\n': 
                case '\r': {
                    break;
                }
                default: {
                    if (c2 >= ' ') break;
                    return false;
                }
            }
            Stage stage = axh.this.getStage();
            if (stage == null || stage.getKeyboardFocus() != axh.this) {
                return false;
            }
            if (UIUtils.isMac && Gdx.input.isKeyPressed(63)) {
                return true;
            }
            if ((c2 == '\t' || c2 == '\n') && axh.this.var_boolean_c) {
                axh.this.b(UIUtils.shift());
            } else {
                boolean bl2;
                boolean bl3 = c2 == '\u007f';
                boolean bl4 = c2 == '\b';
                boolean bl5 = bl2 = c2 == '\r' || c2 == '\n';
                boolean bl6 = bl2 ? axh.this.var_boolean_b : !axh.this.var_boolean_d || axh.this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a.font.getData().hasGlyph(c2);
                boolean bl7 = bl4 || bl3;
                Engine.b("[1] Text Length: " + axh.this.var_java_lang_String_a.length() + " Cursor: " + axh.this.var_int_a);
                if (bl6 || bl7) {
                    Object object;
                    Engine.b("add || remove");
                    String string = axh.this.var_java_lang_String_a;
                    int n2 = axh.this.var_int_a;
                    if (axh.this.var_boolean_a) {
                        Engine.b("delete(false)");
                        axh.this.var_int_a = axh.this.int_a(false);
                    } else {
                        if (bl4 && axh.this.var_int_a > 0) {
                            Object object2;
                            Engine.b("else delete case.");
                            Engine.b("[2] Text Length: " + axh.this.var_java_lang_String_a.length() + " Cursor: " + axh.this.var_int_a);
                            object = null;
                            axh.this.var_com_badlogic_gdx_math_Vector2_a = axh.this.var_com_badlogic_gdx_math_Vector2_a.iterator();
                            while (axh.this.var_com_badlogic_gdx_math_Vector2_a.hasNext()) {
                                object2 = (ItemLink)axh.this.var_com_badlogic_gdx_math_Vector2_a.next();
                                if (axh.this.var_int_a < ((ItemLink)object2).linkLeft || axh.this.var_int_a > ((ItemLink)object2).linkRight) continue;
                                object = object2;
                                axh.this.var_com_badlogic_gdx_math_Vector2_a.remove();
                                break;
                            }
                            if (object != null) {
                                Engine.b("Debug: 0, " + ((ItemLink)object).linkLeft + ", " + ((ItemLink)object).linkRight + ", " + axh.this.var_java_lang_String_a.length());
                                object2 = axh.this.var_java_lang_String_a.substring(0, ((ItemLink)object).linkLeft);
                                Engine.b("t1 done: " + (String)object2);
                                String string2 = axh.this.var_java_lang_String_a.substring(((ItemLink)object).linkRight, axh.this.var_java_lang_String_a.length());
                                Engine.b("t2 done: " + string2);
                                axh.this.var_java_lang_String_a = (String)object2 + string2;
                                Engine.b("new text: " + axh.this.var_java_lang_String_a);
                                axh.this.var_int_a = ((ItemLink)object).linkLeft;
                                axh.this.var_com_badlogic_gdx_math_Vector2_a = axh.this.var_com_badlogic_gdx_math_Vector2_a.iterator();
                                while (axh.this.var_com_badlogic_gdx_math_Vector2_a.hasNext()) {
                                    ItemLink itemLink = (ItemLink)axh.this.var_com_badlogic_gdx_math_Vector2_a.next();
                                    if (((ItemLink)object).linkLeft >= itemLink.linkLeft) continue;
                                    itemLink.shift(((ItemLink)object).name.length());
                                }
                            } else {
                                axh.this.var_java_lang_String_a = axh.this.var_java_lang_String_a.substring(0, axh.this.var_int_a - 1) + axh.this.var_java_lang_String_a.substring(axh.this.var_int_a--);
                            }
                            axh.this.var_float_f = 0.0f;
                        }
                        if (bl3 && axh.this.var_int_a < axh.this.var_java_lang_String_a.length()) {
                            axh.this.var_java_lang_String_a = axh.this.var_java_lang_String_a.substring(0, axh.this.var_int_a) + axh.this.var_java_lang_String_a.substring(axh.this.var_int_a + 1);
                        }
                    }
                    if (bl6 && !bl7) {
                        if (!bl2 && axh.this.var_axh$e_a != null && !axh.this.var_axh$e_a.a(axh.this, c2)) {
                            return true;
                        }
                        if (!axh.this.boolean_a(axh.this.var_java_lang_String_a.length())) {
                            return true;
                        }
                        object = bl2 ? "\n" : String.valueOf(c2);
                        axh.this.var_java_lang_String_a = axh.this.a(axh.this.var_int_a++, (CharSequence)object, axh.this.var_java_lang_String_a);
                    }
                    object = axh.this.var_java_lang_String_b;
                    Engine.b("find 1");
                    if (axh.this.a(string, axh.this.var_java_lang_String_a)) {
                        long l2 = System.currentTimeMillis();
                        if (l2 - 750L > axh.this.var_long_a) {
                            axh.this.var_java_lang_String_b = string;
                        }
                        axh.this.var_long_a = l2;
                    } else {
                        axh.this.var_int_a = n2;
                    }
                    Engine.b("find 2");
                    axh.this.c();
                    Engine.b("find 3");
                }
            }
            Engine.b("find 4");
            if (axh.this.var_axh$f_a != null) {
                axh.this.var_axh$f_a.a(axh.this, c2);
            }
            Engine.b("find 5");
            return true;
        }
    }

    public static interface e {
        public boolean a(axh var1, char var2);
    }

    public static interface f {
        public void a(axh var1, char var2);
    }
}

