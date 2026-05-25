/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class TextArea
extends TextField {
    IntArray linesBreak;
    private String lastText;
    int cursorLine;
    int firstLineShowing;
    private int linesShowing;
    float moveOffset;
    private float prefRows;

    public TextArea(String string, Skin skin) {
        super(string, skin);
    }

    public TextArea(String string, Skin skin, String string2) {
        super(string, skin, string2);
    }

    public TextArea(String string, TextField.TextFieldStyle textFieldStyle) {
        super(string, textFieldStyle);
    }

    @Override
    protected void initialize() {
        super.initialize();
        this.writeEnters = true;
        this.linesBreak = new IntArray();
        this.cursorLine = 0;
        this.firstLineShowing = 0;
        this.moveOffset = -1.0f;
        this.linesShowing = 0;
    }

    @Override
    protected int letterUnderCursor(float f2) {
        if (this.linesBreak.size > 0) {
            int n2;
            if (this.cursorLine * 2 >= this.linesBreak.size) {
                return this.text.length();
            }
            float[] fArray = this.glyphPositions.items;
            int n3 = this.linesBreak.items[this.cursorLine * 2];
            f2 += fArray[n3];
            int n4 = this.linesBreak.items[this.cursorLine * 2 + 1];
            for (n2 = n3; n2 < n4 && !(fArray[n2] > f2); ++n2) {
            }
            if (n2 > 0 && fArray[n2] - f2 <= f2 - fArray[n2 - 1]) {
                return n2;
            }
            return Math.max(0, n2 - 1);
        }
        return 0;
    }

    @Override
    public void setStyle(TextField.TextFieldStyle textFieldStyle) {
        if (textFieldStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = textFieldStyle;
        this.textHeight = textFieldStyle.font.getCapHeight() - textFieldStyle.font.getDescent();
        if (this.text != null) {
            this.updateDisplayText();
        }
        this.invalidateHierarchy();
    }

    public void setPrefRows(float f2) {
        this.prefRows = f2;
    }

    @Override
    public float getPrefHeight() {
        if (this.prefRows <= 0.0f) {
            return super.getPrefHeight();
        }
        float f2 = MathUtils.ceil(this.style.font.getLineHeight() * this.prefRows);
        if (this.style.background != null) {
            f2 = Math.max(f2 + this.style.background.getBottomHeight() + this.style.background.getTopHeight(), this.style.background.getMinHeight());
        }
        return f2;
    }

    public int getLines() {
        return this.linesBreak.size / 2 + (this.newLineAtEnd() ? 1 : 0);
    }

    public boolean newLineAtEnd() {
        return this.text.length() != 0 && (this.text.charAt(this.text.length() - 1) == '\n' || this.text.charAt(this.text.length() - 1) == '\r');
    }

    public void moveCursorLine(int n2) {
        if (n2 < 0) {
            this.cursorLine = 0;
            this.cursor = 0;
            this.moveOffset = -1.0f;
        } else if (n2 >= this.getLines()) {
            int n3 = this.getLines() - 1;
            this.cursor = this.text.length();
            if (n2 > this.getLines() || n3 == this.cursorLine) {
                this.moveOffset = -1.0f;
            }
            this.cursorLine = n3;
        } else if (n2 != this.cursorLine) {
            if (this.moveOffset < 0.0f) {
                this.moveOffset = this.linesBreak.size <= this.cursorLine * 2 ? 0.0f : this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.linesBreak.get(this.cursorLine * 2));
            }
            this.cursorLine = n2;
            int n4 = this.cursor = this.cursorLine * 2 >= this.linesBreak.size ? this.text.length() : this.linesBreak.get(this.cursorLine * 2);
            while (this.cursor < this.text.length() && this.cursor <= this.linesBreak.get(this.cursorLine * 2 + 1) - 1 && this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.linesBreak.get(this.cursorLine * 2)) < this.moveOffset) {
                ++this.cursor;
            }
            this.showCursor();
        }
    }

    void updateCurrentLine() {
        int n2 = this.calculateCurrentLineIndex(this.cursor);
        int n3 = n2 / 2;
        if (!(n2 % 2 != 0 && n2 + 1 < this.linesBreak.size && this.cursor == this.linesBreak.items[n2] && this.linesBreak.items[n2 + 1] == this.linesBreak.items[n2] || n3 >= this.linesBreak.size / 2 && this.text.length() != 0 && this.text.charAt(this.text.length() - 1) != '\n' && this.text.charAt(this.text.length() - 1) != '\r')) {
            this.cursorLine = n3;
        }
        this.updateFirstLineShowing();
    }

    void showCursor() {
        this.updateCurrentLine();
        this.updateFirstLineShowing();
    }

    void updateFirstLineShowing() {
        if (this.cursorLine != this.firstLineShowing) {
            int n2;
            int n3 = n2 = this.cursorLine >= this.firstLineShowing ? 1 : -1;
            while (this.firstLineShowing > this.cursorLine || this.firstLineShowing + this.linesShowing - 1 < this.cursorLine) {
                this.firstLineShowing += n2;
            }
        }
    }

    private int calculateCurrentLineIndex(int n2) {
        int n3;
        for (n3 = 0; n3 < this.linesBreak.size && n2 > this.linesBreak.items[n3]; ++n3) {
        }
        return n3;
    }

    @Override
    public void sizeChanged() {
        this.lastText = null;
        BitmapFont bitmapFont = this.style.font;
        Drawable drawable = this.style.background;
        float f2 = this.getHeight() - (drawable == null ? 0.0f : drawable.getBottomHeight() + drawable.getTopHeight());
        this.linesShowing = (int)Math.floor(f2 / bitmapFont.getLineHeight());
    }

    @Override
    protected float getTextY(BitmapFont bitmapFont, @Null Drawable drawable) {
        float f2 = this.getHeight();
        if (drawable != null) {
            f2 -= drawable.getTopHeight();
        }
        if (bitmapFont.usesIntegerPositions()) {
            f2 = (int)f2;
        }
        return f2;
    }

    @Override
    protected void drawSelection(Drawable drawable, Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        float f4 = 0.0f;
        int n2 = Math.min(this.cursor, this.selectionStart);
        int n3 = Math.max(this.cursor, this.selectionStart);
        BitmapFont.BitmapFontData bitmapFontData = bitmapFont.getData();
        float f5 = this.style.font.getLineHeight();
        for (int i2 = this.firstLineShowing * 2; i2 + 1 < this.linesBreak.size && i2 < (this.firstLineShowing + this.linesShowing) * 2; i2 += 2) {
            int n4 = this.linesBreak.get(i2);
            int n5 = this.linesBreak.get(i2 + 1);
            if (!(n2 < n4 && n2 < n5 && n3 < n4 && n3 < n5 || n2 > n4 && n2 > n5 && n3 > n4 && n3 > n5)) {
                int n6 = Math.max(n4, n2);
                int n7 = Math.min(n5, n3);
                float f6 = 0.0f;
                float f7 = 0.0f;
                BitmapFont.Glyph glyph = bitmapFontData.getGlyph(this.displayText.charAt(n4));
                if (glyph != null) {
                    if (n6 == n4) {
                        f7 = glyph.fixedWidth ? 0.0f : (float)(-glyph.xoffset) * bitmapFontData.scaleX - bitmapFontData.padLeft;
                    } else {
                        f6 = glyph.fixedWidth ? 0.0f : (float)(-glyph.xoffset) * bitmapFontData.scaleX - bitmapFontData.padLeft;
                    }
                }
                float f8 = this.glyphPositions.get(n6) - this.glyphPositions.get(n4);
                float f9 = this.glyphPositions.get(n7) - this.glyphPositions.get(n6);
                drawable.draw(batch, f2 + f8 + f6, f3 - f5 - f4, f9 + f7, bitmapFont.getLineHeight());
            }
            f4 += bitmapFont.getLineHeight();
        }
    }

    @Override
    protected void drawText(Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        float f4 = -(this.style.font.getLineHeight() - this.textHeight) / 2.0f;
        for (int i2 = this.firstLineShowing * 2; i2 < (this.firstLineShowing + this.linesShowing) * 2 && i2 < this.linesBreak.size; i2 += 2) {
            bitmapFont.draw(batch, this.displayText, f2, f3 + f4, this.linesBreak.items[i2], this.linesBreak.items[i2 + 1], 0.0f, 8, false);
            f4 -= bitmapFont.getLineHeight();
        }
    }

    @Override
    protected void drawCursor(Drawable drawable, Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        drawable.draw(batch, f2 + this.getCursorX(), f3 + this.getCursorY(), drawable.getMinWidth(), bitmapFont.getLineHeight());
    }

    @Override
    protected void calculateOffsets() {
        super.calculateOffsets();
        if (!this.text.equals(this.lastText)) {
            this.lastText = this.text;
            BitmapFont bitmapFont = this.style.font;
            float f2 = this.getWidth() - (this.style.background != null ? this.style.background.getLeftWidth() + this.style.background.getRightWidth() : 0.0f);
            this.linesBreak.clear();
            int n2 = 0;
            int n3 = 0;
            Pool<GlyphLayout> pool = Pools.get(GlyphLayout.class);
            GlyphLayout glyphLayout = pool.obtain();
            for (int i2 = 0; i2 < this.text.length(); ++i2) {
                char c2 = this.text.charAt(i2);
                if (c2 == '\r' || c2 == '\n') {
                    this.linesBreak.add(n2);
                    this.linesBreak.add(i2);
                    n2 = i2 + 1;
                    continue;
                }
                n3 = this.continueCursor(i2, 0) ? n3 : i2;
                glyphLayout.setText(bitmapFont, this.text.subSequence(n2, i2 + 1));
                if (!(glyphLayout.width > f2)) continue;
                if (n2 >= n3) {
                    n3 = i2 - 1;
                }
                this.linesBreak.add(n2);
                this.linesBreak.add(n3 + 1);
                n3 = n2 = n3 + 1;
            }
            pool.free(glyphLayout);
            if (n2 < this.text.length()) {
                this.linesBreak.add(n2);
                this.linesBreak.add(this.text.length());
            }
            this.showCursor();
        }
    }

    @Override
    protected InputListener createInputListener() {
        return new TextAreaListener();
    }

    @Override
    public void setSelection(int n2, int n3) {
        super.setSelection(n2, n3);
        this.updateCurrentLine();
    }

    @Override
    protected void moveCursor(boolean bl2, boolean bl3) {
        int n2 = bl2 ? 1 : -1;
        int n3 = this.cursorLine * 2 + n2;
        if (n3 >= 0 && n3 + 1 < this.linesBreak.size && this.linesBreak.items[n3] == this.cursor && this.linesBreak.items[n3 + 1] == this.cursor) {
            this.cursorLine += n2;
            if (bl3) {
                super.moveCursor(bl2, bl3);
            }
            this.showCursor();
        } else {
            super.moveCursor(bl2, bl3);
        }
        this.updateCurrentLine();
    }

    @Override
    protected boolean continueCursor(int n2, int n3) {
        int n4 = this.calculateCurrentLineIndex(n2 + n3);
        return super.continueCursor(n2, n3) && (n4 < 0 || n4 >= this.linesBreak.size - 2 || this.linesBreak.items[n4 + 1] != n2 || this.linesBreak.items[n4 + 1] == this.linesBreak.items[n4 + 2]);
    }

    public int getCursorLine() {
        return this.cursorLine;
    }

    public int getFirstLineShowing() {
        return this.firstLineShowing;
    }

    public int getLinesShowing() {
        return this.linesShowing;
    }

    public float getCursorX() {
        float f2 = 0.0f;
        BitmapFont.BitmapFontData bitmapFontData = this.style.font.getData();
        if (this.cursor < this.glyphPositions.size && this.cursorLine * 2 < this.linesBreak.size) {
            int n2 = this.linesBreak.items[this.cursorLine * 2];
            float f3 = 0.0f;
            BitmapFont.Glyph glyph = bitmapFontData.getGlyph(this.displayText.charAt(n2));
            if (glyph != null) {
                f3 = glyph.fixedWidth ? 0.0f : (float)(-glyph.xoffset) * bitmapFontData.scaleX - bitmapFontData.padLeft;
            }
            f2 = this.glyphPositions.get(this.cursor) - this.glyphPositions.get(n2) + f3;
        }
        return f2 + bitmapFontData.cursorX;
    }

    public float getCursorY() {
        BitmapFont bitmapFont = this.style.font;
        return (float)(-(this.cursorLine - this.firstLineShowing + 1)) * bitmapFont.getLineHeight();
    }

    public class TextAreaListener
    extends TextField.TextFieldClickListener {
        public TextAreaListener() {
            super(TextArea.this);
        }

        @Override
        protected void setCursorPosition(float f2, float f3) {
            TextArea.this.moveOffset = -1.0f;
            Drawable drawable = TextArea.this.style.background;
            BitmapFont bitmapFont = TextArea.this.style.font;
            float f4 = TextArea.this.getHeight();
            if (drawable != null) {
                f4 -= drawable.getTopHeight();
                f2 -= drawable.getLeftWidth();
            }
            f2 = Math.max(0.0f, f2);
            if (drawable != null) {
                f3 -= drawable.getTopHeight();
            }
            TextArea.this.cursorLine = (int)Math.floor((f4 - f3) / bitmapFont.getLineHeight()) + TextArea.this.firstLineShowing;
            TextArea.this.cursorLine = Math.max(0, Math.min(TextArea.this.cursorLine, TextArea.this.getLines() - 1));
            super.setCursorPosition(f2, f3);
            TextArea.this.updateCurrentLine();
        }

        @Override
        public boolean keyDown(InputEvent inputEvent, int n2) {
            boolean bl2 = super.keyDown(inputEvent, n2);
            if (TextArea.this.hasKeyboardFocus()) {
                boolean bl3;
                boolean bl4 = false;
                boolean bl5 = bl3 = Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60);
                if (n2 == 20) {
                    if (bl3) {
                        if (!TextArea.this.hasSelection) {
                            TextArea.this.selectionStart = TextArea.this.cursor;
                            TextArea.this.hasSelection = true;
                        }
                    } else {
                        TextArea.this.clearSelection();
                    }
                    TextArea.this.moveCursorLine(TextArea.this.cursorLine + 1);
                    bl4 = true;
                } else if (n2 == 19) {
                    if (bl3) {
                        if (!TextArea.this.hasSelection) {
                            TextArea.this.selectionStart = TextArea.this.cursor;
                            TextArea.this.hasSelection = true;
                        }
                    } else {
                        TextArea.this.clearSelection();
                    }
                    TextArea.this.moveCursorLine(TextArea.this.cursorLine - 1);
                    bl4 = true;
                } else {
                    TextArea.this.moveOffset = -1.0f;
                }
                if (bl4) {
                    this.scheduleKeyRepeatTask(n2);
                }
                TextArea.this.showCursor();
                return true;
            }
            return bl2;
        }

        @Override
        protected boolean checkFocusTraversal(char c2) {
            return TextArea.this.focusTraversal && c2 == '\t';
        }

        @Override
        public boolean keyTyped(InputEvent inputEvent, char c2) {
            boolean bl2 = super.keyTyped(inputEvent, c2);
            TextArea.this.showCursor();
            return bl2;
        }

        @Override
        protected void goHome(boolean bl2) {
            if (bl2) {
                TextArea.this.cursor = 0;
            } else if (TextArea.this.cursorLine * 2 < TextArea.this.linesBreak.size) {
                TextArea.this.cursor = TextArea.this.linesBreak.get(TextArea.this.cursorLine * 2);
            }
        }

        @Override
        protected void goEnd(boolean bl2) {
            if (bl2 || TextArea.this.cursorLine >= TextArea.this.getLines()) {
                TextArea.this.cursor = TextArea.this.text.length();
            } else if (TextArea.this.cursorLine * 2 + 1 < TextArea.this.linesBreak.size) {
                TextArea.this.cursor = TextArea.this.linesBreak.get(TextArea.this.cursorLine * 2 + 1);
            }
        }
    }
}

