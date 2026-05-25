/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.StringBuilder;

public class Label
extends Widget {
    private static final Color tempColor = new Color();
    private static final GlyphLayout prefSizeLayout = new GlyphLayout();
    private LabelStyle style;
    private final GlyphLayout layout = new GlyphLayout();
    private float prefWidth;
    private float prefHeight;
    private final StringBuilder text = new StringBuilder();
    private int intValue = Integer.MIN_VALUE;
    private BitmapFontCache cache;
    private int labelAlign = 8;
    private int lineAlign = 8;
    private boolean wrap;
    private float lastPrefHeight;
    private boolean prefSizeInvalid = true;
    private float fontScaleX = 1.0f;
    private float fontScaleY = 1.0f;
    private boolean fontScaleChanged = false;
    @Null
    private String ellipsis;

    public Label(@Null CharSequence charSequence, Skin skin) {
        this(charSequence, skin.get(LabelStyle.class));
    }

    public Label(@Null CharSequence charSequence, Skin skin, String string) {
        this(charSequence, skin.get(string, LabelStyle.class));
    }

    public Label(@Null CharSequence charSequence, Skin skin, String string, Color color) {
        this(charSequence, new LabelStyle(skin.getFont(string), color));
    }

    public Label(@Null CharSequence charSequence, Skin skin, String string, String string2) {
        this(charSequence, new LabelStyle(skin.getFont(string), skin.getColor(string2)));
    }

    public Label(@Null CharSequence charSequence, LabelStyle labelStyle) {
        if (charSequence != null) {
            this.text.append(charSequence);
        }
        this.setStyle(labelStyle);
        if (charSequence != null && charSequence.length() > 0) {
            this.setSize(this.getPrefWidth(), this.getPrefHeight());
        }
    }

    public void setStyle(LabelStyle labelStyle) {
        if (labelStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        if (labelStyle.font == null) {
            throw new IllegalArgumentException("Missing LabelStyle font.");
        }
        this.style = labelStyle;
        this.cache = labelStyle.font.newFontCache();
        this.invalidateHierarchy();
    }

    public LabelStyle getStyle() {
        return this.style;
    }

    public boolean setText(int n2) {
        if (this.intValue == n2) {
            return false;
        }
        this.text.clear();
        this.text.append(n2);
        this.intValue = n2;
        this.invalidateHierarchy();
        return true;
    }

    public void setText(@Null CharSequence charSequence) {
        if (charSequence == null) {
            if (this.text.length == 0) {
                return;
            }
            this.text.clear();
        } else if (charSequence instanceof StringBuilder) {
            if (this.text.equals(charSequence)) {
                return;
            }
            this.text.clear();
            this.text.append((StringBuilder)charSequence);
        } else {
            if (this.textEquals(charSequence)) {
                return;
            }
            this.text.clear();
            this.text.append(charSequence);
        }
        this.intValue = Integer.MIN_VALUE;
        this.invalidateHierarchy();
    }

    public boolean textEquals(CharSequence charSequence) {
        int n2 = this.text.length;
        char[] cArray = this.text.chars;
        if (n2 != charSequence.length()) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (cArray[i2] == charSequence.charAt(i2)) continue;
            return false;
        }
        return true;
    }

    public StringBuilder getText() {
        return this.text;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.prefSizeInvalid = true;
    }

    private void scaleAndComputePrefSize() {
        BitmapFont bitmapFont = this.cache.getFont();
        float f2 = bitmapFont.getScaleX();
        float f3 = bitmapFont.getScaleY();
        if (this.fontScaleChanged) {
            bitmapFont.getData().setScale(this.fontScaleX, this.fontScaleY);
        }
        this.computePrefSize(prefSizeLayout);
        if (this.fontScaleChanged) {
            bitmapFont.getData().setScale(f2, f3);
        }
    }

    protected void computePrefSize(GlyphLayout glyphLayout) {
        this.prefSizeInvalid = false;
        if (this.wrap && this.ellipsis == null) {
            float f2 = this.getWidth();
            if (this.style.background != null) {
                f2 = Math.max(f2, this.style.background.getMinWidth()) - this.style.background.getLeftWidth() - this.style.background.getRightWidth();
            }
            glyphLayout.setText(this.cache.getFont(), this.text, Color.WHITE, f2, 8, true);
        } else {
            glyphLayout.setText(this.cache.getFont(), this.text);
        }
        this.prefWidth = glyphLayout.width;
        this.prefHeight = glyphLayout.height;
    }

    @Override
    public void layout() {
        float f2;
        float f3;
        float f4;
        boolean bl2;
        BitmapFont bitmapFont = this.cache.getFont();
        float f5 = bitmapFont.getScaleX();
        float f6 = bitmapFont.getScaleY();
        if (this.fontScaleChanged) {
            bitmapFont.getData().setScale(this.fontScaleX, this.fontScaleY);
        }
        boolean bl3 = bl2 = this.wrap && this.ellipsis == null;
        if (bl2 && (f4 = this.getPrefHeight()) != this.lastPrefHeight) {
            this.lastPrefHeight = f4;
            this.invalidateHierarchy();
        }
        f4 = this.getWidth();
        float f7 = this.getHeight();
        Drawable drawable = this.style.background;
        float f8 = 0.0f;
        float f9 = 0.0f;
        if (drawable != null) {
            f8 = drawable.getLeftWidth();
            f9 = drawable.getBottomHeight();
            f4 -= drawable.getLeftWidth() + drawable.getRightWidth();
            f7 -= drawable.getBottomHeight() + drawable.getTopHeight();
        }
        GlyphLayout glyphLayout = this.layout;
        if (bl2 || this.text.indexOf("\n") != -1) {
            glyphLayout.setText(bitmapFont, this.text, 0, this.text.length, Color.WHITE, f4, this.lineAlign, bl2, this.ellipsis);
            f3 = glyphLayout.width;
            f2 = glyphLayout.height;
            if ((this.labelAlign & 8) == 0) {
                f8 = (this.labelAlign & 0x10) != 0 ? (f8 += f4 - f3) : (f8 += (f4 - f3) / 2.0f);
            }
        } else {
            f3 = f4;
            f2 = bitmapFont.getData().capHeight;
        }
        if ((this.labelAlign & 2) != 0) {
            f9 += this.cache.getFont().isFlipped() ? 0.0f : f7 - f2;
            f9 += this.style.font.getDescent();
        } else if ((this.labelAlign & 4) != 0) {
            f9 += this.cache.getFont().isFlipped() ? f7 - f2 : 0.0f;
            f9 -= this.style.font.getDescent();
        } else {
            f9 += (f7 - f2) / 2.0f;
        }
        if (!this.cache.getFont().isFlipped()) {
            f9 += f2;
        }
        glyphLayout.setText(bitmapFont, this.text, 0, this.text.length, Color.WHITE, f3, this.lineAlign, bl2, this.ellipsis);
        this.cache.setText(glyphLayout, f8, f9);
        if (this.fontScaleChanged) {
            bitmapFont.getData().setScale(f5, f6);
        }
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.validate();
        Color color = tempColor.set(this.getColor());
        color.a *= f2;
        if (this.style.background != null) {
            batch.setColor(color.r, color.g, color.b, color.a);
            this.style.background.draw(batch, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
        if (this.style.fontColor != null) {
            color.mul(this.style.fontColor);
        }
        this.cache.tint(color);
        this.cache.setPosition(this.getX(), this.getY());
        this.cache.draw(batch);
    }

    @Override
    public float getPrefWidth() {
        if (this.wrap) {
            return 0.0f;
        }
        if (this.prefSizeInvalid) {
            this.scaleAndComputePrefSize();
        }
        float f2 = this.prefWidth;
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(f2 + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
        }
        return f2;
    }

    @Override
    public float getPrefHeight() {
        if (this.prefSizeInvalid) {
            this.scaleAndComputePrefSize();
        }
        float f2 = 1.0f;
        if (this.fontScaleChanged) {
            f2 = this.fontScaleY / this.style.font.getScaleY();
        }
        float f3 = this.prefHeight - this.style.font.getDescent() * f2 * 2.0f;
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f3 = Math.max(f3 + drawable.getTopHeight() + drawable.getBottomHeight(), drawable.getMinHeight());
        }
        return f3;
    }

    public GlyphLayout getGlyphLayout() {
        return this.layout;
    }

    public void setWrap(boolean bl2) {
        this.wrap = bl2;
        this.invalidateHierarchy();
    }

    public boolean getWrap() {
        return this.wrap;
    }

    public int getLabelAlign() {
        return this.labelAlign;
    }

    public int getLineAlign() {
        return this.lineAlign;
    }

    public void setAlignment(int n2) {
        this.setAlignment(n2, n2);
    }

    public void setAlignment(int n2, int n3) {
        this.labelAlign = n2;
        this.lineAlign = (n3 & 8) != 0 ? 8 : ((n3 & 0x10) != 0 ? 16 : 1);
        this.invalidate();
    }

    public void setFontScale(float f2) {
        this.setFontScale(f2, f2);
    }

    public void setFontScale(float f2, float f3) {
        this.fontScaleChanged = true;
        this.fontScaleX = f2;
        this.fontScaleY = f3;
        this.invalidateHierarchy();
    }

    public float getFontScaleX() {
        return this.fontScaleX;
    }

    public void setFontScaleX(float f2) {
        this.setFontScale(f2, this.fontScaleY);
    }

    public float getFontScaleY() {
        return this.fontScaleY;
    }

    public void setFontScaleY(float f2) {
        this.setFontScale(this.fontScaleX, f2);
    }

    public void setEllipsis(@Null String string) {
        this.ellipsis = string;
    }

    public void setEllipsis(boolean bl2) {
        this.ellipsis = bl2 ? "..." : null;
    }

    protected BitmapFontCache getBitmapFontCache() {
        return this.cache;
    }

    @Override
    public String toString() {
        String string = this.getName();
        if (string != null) {
            return string;
        }
        String string2 = this.getClass().getName();
        int n2 = string2.lastIndexOf(46);
        if (n2 != -1) {
            string2 = string2.substring(n2 + 1);
        }
        return (string2.indexOf(36) != -1 ? "Label " : "") + string2 + ": " + this.text;
    }

    public static class LabelStyle {
        public BitmapFont font;
        @Null
        public Color fontColor;
        @Null
        public Drawable background;

        public LabelStyle() {
        }

        public LabelStyle(BitmapFont bitmapFont, @Null Color color) {
            this.font = bitmapFont;
            this.fontColor = color;
        }

        public LabelStyle(LabelStyle labelStyle) {
            this.font = labelStyle.font;
            if (labelStyle.fontColor != null) {
                this.fontColor = new Color(labelStyle.fontColor);
            }
            this.background = labelStyle.background;
        }
    }
}

