/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

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
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.Timer;

public class TextField
extends Widget
implements Disableable {
    protected static final char BACKSPACE = '\b';
    protected static final char CARRIAGE_RETURN = '\r';
    protected static final char NEWLINE = '\n';
    protected static final char TAB = '\t';
    protected static final char DELETE = '\u007f';
    protected static final char BULLET = '\u0095';
    private static final Vector2 tmp1 = new Vector2();
    private static final Vector2 tmp2 = new Vector2();
    private static final Vector2 tmp3 = new Vector2();
    public static float keyRepeatInitialTime = 0.4f;
    public static float keyRepeatTime = 0.1f;
    protected String text;
    protected int cursor;
    protected int selectionStart;
    protected boolean hasSelection;
    protected boolean writeEnters;
    protected final GlyphLayout layout = new GlyphLayout();
    protected final FloatArray glyphPositions = new FloatArray();
    TextFieldStyle style;
    private String messageText;
    protected CharSequence displayText;
    Clipboard clipboard;
    InputListener inputListener;
    @Null
    TextFieldListener listener;
    @Null
    TextFieldFilter filter;
    OnscreenKeyboard keyboard = new DefaultOnscreenKeyboard();
    boolean focusTraversal = true;
    boolean onlyFontChars = true;
    boolean disabled;
    private int textHAlign = 8;
    private float selectionX;
    private float selectionWidth;
    String undoText = "";
    long lastChangeTime;
    boolean passwordMode;
    private StringBuilder passwordBuffer;
    private char passwordCharacter = (char)149;
    protected float fontOffset;
    protected float textHeight;
    protected float textOffset;
    float renderOffset;
    protected int visibleTextStart;
    protected int visibleTextEnd;
    private int maxLength;
    boolean focused;
    boolean cursorOn;
    float blinkTime = 0.32f;
    final Timer.Task blinkTask = new Timer.Task(){

        @Override
        public void run() {
            if (TextField.this.getStage() == null) {
                this.cancel();
                return;
            }
            TextField.this.cursorOn = !TextField.this.cursorOn;
            Gdx.graphics.requestRendering();
        }
    };
    final KeyRepeatTask keyRepeatTask = new KeyRepeatTask();
    boolean programmaticChangeEvents;

    public TextField(@Null String string, Skin skin) {
        this(string, skin.get(TextFieldStyle.class));
    }

    public TextField(@Null String string, Skin skin, String string2) {
        this(string, skin.get(string2, TextFieldStyle.class));
    }

    public TextField(@Null String string, TextFieldStyle textFieldStyle) {
        this.setStyle(textFieldStyle);
        this.clipboard = Gdx.app.getClipboard();
        this.initialize();
        this.setText(string);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    protected void initialize() {
        this.inputListener = this.createInputListener();
        this.addListener(this.inputListener);
    }

    protected InputListener createInputListener() {
        return new TextFieldClickListener();
    }

    protected int letterUnderCursor(float f2) {
        f2 -= this.textOffset + this.fontOffset - this.style.font.getData().cursorX - this.glyphPositions.get(this.visibleTextStart);
        Drawable drawable = this.getBackgroundDrawable();
        if (drawable != null) {
            f2 -= this.style.background.getLeftWidth();
        }
        int n2 = this.glyphPositions.size;
        float[] fArray = this.glyphPositions.items;
        for (int i2 = 1; i2 < n2; ++i2) {
            if (!(fArray[i2] > f2)) continue;
            if (fArray[i2] - f2 <= f2 - fArray[i2 - 1]) {
                return i2;
            }
            return i2 - 1;
        }
        return n2 - 1;
    }

    protected boolean isWordCharacter(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    protected int[] wordUnderCursor(int n2) {
        String string = this.text;
        int n3 = n2;
        int n4 = string.length();
        int n5 = 0;
        if (n2 >= string.length()) {
            n5 = string.length();
            n4 = 0;
        } else {
            int n6;
            for (n6 = n3; n6 < n4; ++n6) {
                if (this.isWordCharacter(string.charAt(n6))) continue;
                n4 = n6;
                break;
            }
            for (n6 = n3 - 1; n6 > -1; --n6) {
                if (this.isWordCharacter(string.charAt(n6))) continue;
                n5 = n6 + 1;
                break;
            }
        }
        return new int[]{n5, n4};
    }

    int[] wordUnderCursor(float f2) {
        return this.wordUnderCursor(this.letterUnderCursor(f2));
    }

    boolean withinMaxLength(int n2) {
        return this.maxLength <= 0 || n2 < this.maxLength;
    }

    public void setMaxLength(int n2) {
        this.maxLength = n2;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setOnlyFontChars(boolean bl2) {
        this.onlyFontChars = bl2;
    }

    public void setStyle(TextFieldStyle textFieldStyle) {
        if (textFieldStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = textFieldStyle;
        this.textHeight = textFieldStyle.font.getCapHeight() - textFieldStyle.font.getDescent() * 2.0f;
        if (this.text != null) {
            this.updateDisplayText();
        }
        this.invalidateHierarchy();
    }

    public TextFieldStyle getStyle() {
        return this.style;
    }

    protected void calculateOffsets() {
        int n2;
        float f2;
        float f3;
        float f4 = this.getWidth();
        Drawable drawable = this.getBackgroundDrawable();
        if (drawable != null) {
            f4 -= drawable.getLeftWidth() + drawable.getRightWidth();
        }
        int n3 = this.glyphPositions.size;
        float[] fArray = this.glyphPositions.items;
        this.cursor = MathUtils.clamp(this.cursor, 0, n3 - 1);
        float f5 = fArray[Math.max(0, this.cursor - 1)] + this.renderOffset;
        if (f5 <= 0.0f) {
            this.renderOffset -= f5;
        } else {
            int n4 = Math.min(n3 - 1, this.cursor + 1);
            f3 = fArray[n4] - f4;
            if (-this.renderOffset < f3) {
                this.renderOffset = -f3;
            }
        }
        float f6 = 0.0f;
        f3 = fArray[n3 - 1];
        for (int i2 = n3 - 2; i2 >= 0 && !(f3 - (f2 = fArray[i2]) > f4); --i2) {
            f6 = f2;
        }
        if (-this.renderOffset > f6) {
            this.renderOffset = -f6;
        }
        this.visibleTextStart = 0;
        float f7 = 0.0f;
        for (n2 = 0; n2 < n3; ++n2) {
            if (!(fArray[n2] >= -this.renderOffset)) continue;
            this.visibleTextStart = n2;
            f7 = fArray[n2];
            break;
        }
        float f8 = f4 - this.renderOffset;
        int n5 = Math.min(this.displayText.length(), n3);
        for (n2 = this.visibleTextStart + 1; n2 <= n5 && !(fArray[n2] > f8); ++n2) {
        }
        this.visibleTextEnd = Math.max(0, n2 - 1);
        if ((this.textHAlign & 8) == 0) {
            this.textOffset = f4 - fArray[this.visibleTextEnd] - this.fontOffset + f7;
            if ((this.textHAlign & 1) != 0) {
                this.textOffset = Math.round(this.textOffset * 0.5f);
            }
        } else {
            this.textOffset = f7 + this.renderOffset;
        }
        if (this.hasSelection) {
            n5 = Math.min(this.cursor, this.selectionStart);
            int n6 = Math.max(this.cursor, this.selectionStart);
            float f9 = Math.max(fArray[n5] - fArray[this.visibleTextStart], -this.textOffset);
            float f10 = Math.min(fArray[n6] - fArray[this.visibleTextStart], f4 - this.textOffset);
            this.selectionX = f9;
            this.selectionWidth = f10 - f9 - this.style.font.getData().cursorX;
        }
    }

    @Null
    protected Drawable getBackgroundDrawable() {
        if (this.disabled && this.style.disabledBackground != null) {
            return this.style.disabledBackground;
        }
        if (this.style.focusedBackground != null && this.hasKeyboardFocus()) {
            return this.style.focusedBackground;
        }
        return this.style.background;
    }

    @Override
    public void draw(Batch batch, float f2) {
        float f3;
        boolean bl2 = this.hasKeyboardFocus();
        if (bl2 != this.focused || bl2 && !this.blinkTask.isScheduled()) {
            this.focused = bl2;
            this.blinkTask.cancel();
            this.cursorOn = bl2;
            if (bl2) {
                Timer.schedule(this.blinkTask, this.blinkTime, this.blinkTime);
            } else {
                this.keyRepeatTask.cancel();
            }
        } else if (!bl2) {
            this.cursorOn = false;
        }
        BitmapFont bitmapFont = this.style.font;
        Color color = this.disabled && this.style.disabledFontColor != null ? this.style.disabledFontColor : (bl2 && this.style.focusedFontColor != null ? this.style.focusedFontColor : this.style.fontColor);
        Drawable drawable = this.style.selection;
        Drawable drawable2 = this.style.cursor;
        Drawable drawable3 = this.getBackgroundDrawable();
        Color color2 = this.getColor();
        float f4 = this.getX();
        float f5 = this.getY();
        float f6 = this.getWidth();
        float f7 = this.getHeight();
        batch.setColor(color2.r, color2.g, color2.b, color2.a * f2);
        float f8 = 0.0f;
        float f9 = 0.0f;
        if (drawable3 != null) {
            drawable3.draw(batch, f4, f5, f6, f7);
            f8 = drawable3.getLeftWidth();
            f9 = drawable3.getRightWidth();
        }
        float f10 = this.getTextY(bitmapFont, drawable3);
        this.calculateOffsets();
        if (bl2 && this.hasSelection && drawable != null) {
            this.drawSelection(drawable, batch, bitmapFont, f4 + f8, f5 + f10);
        }
        float f11 = f3 = bitmapFont.isFlipped() ? -this.textHeight : 0.0f;
        if (this.displayText.length() == 0) {
            if ((!bl2 || this.disabled) && this.messageText != null) {
                BitmapFont bitmapFont2;
                BitmapFont bitmapFont3 = bitmapFont2 = this.style.messageFont != null ? this.style.messageFont : bitmapFont;
                if (this.style.messageFontColor != null) {
                    bitmapFont2.setColor(this.style.messageFontColor.r, this.style.messageFontColor.g, this.style.messageFontColor.b, this.style.messageFontColor.a * color2.a * f2);
                } else {
                    bitmapFont2.setColor(0.7f, 0.7f, 0.7f, color2.a * f2);
                }
                this.drawMessageText(batch, bitmapFont2, f4 + f8, f5 + f10 + f3, f6 - f8 - f9);
            }
        } else {
            bitmapFont.setColor(color.r, color.g, color.b, color.a * color2.a * f2);
            this.drawText(batch, bitmapFont, f4 + f8, f5 + f10 + f3);
        }
        if (!this.disabled && this.cursorOn && drawable2 != null) {
            this.drawCursor(drawable2, batch, bitmapFont, f4 + f8, f5 + f10);
        }
    }

    protected float getTextY(BitmapFont bitmapFont, @Null Drawable drawable) {
        float f2 = this.getHeight();
        float f3 = this.textHeight / 2.0f + bitmapFont.getDescent();
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

    protected void drawSelection(Drawable drawable, Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        drawable.draw(batch, f2 + this.textOffset + this.selectionX + this.fontOffset, f3 - this.textHeight - bitmapFont.getDescent(), this.selectionWidth, this.textHeight);
    }

    protected void drawText(Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        bitmapFont.draw(batch, this.displayText, f2 + this.textOffset, f3, this.visibleTextStart, this.visibleTextEnd, 0.0f, 8, false);
    }

    protected void drawMessageText(Batch batch, BitmapFont bitmapFont, float f2, float f3, float f4) {
        bitmapFont.draw(batch, this.messageText, f2, f3, 0, this.messageText.length(), f4, this.textHAlign, false, "...");
    }

    protected void drawCursor(Drawable drawable, Batch batch, BitmapFont bitmapFont, float f2, float f3) {
        drawable.draw(batch, f2 + this.textOffset + this.glyphPositions.get(this.cursor) - this.glyphPositions.get(this.visibleTextStart) + this.fontOffset + bitmapFont.getData().cursorX, f3 - this.textHeight - bitmapFont.getDescent(), drawable.getMinWidth(), this.textHeight);
    }

    void updateDisplayText() {
        int n2;
        BitmapFont bitmapFont = this.style.font;
        BitmapFont.BitmapFontData bitmapFontData = bitmapFont.getData();
        String string = this.text;
        int n3 = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = string.charAt(i2);
            stringBuilder.append((char)(bitmapFontData.hasGlyph((char)n2) ? n2 : 32));
        }
        String string2 = stringBuilder.toString();
        if (this.passwordMode && bitmapFontData.hasGlyph(this.passwordCharacter)) {
            if (this.passwordBuffer == null) {
                this.passwordBuffer = new StringBuilder(string2.length());
            }
            if (this.passwordBuffer.length() > n3) {
                this.passwordBuffer.setLength(n3);
            } else {
                for (n2 = this.passwordBuffer.length(); n2 < n3; ++n2) {
                    this.passwordBuffer.append(this.passwordCharacter);
                }
            }
            this.displayText = this.passwordBuffer;
        } else {
            this.displayText = string2;
        }
        this.layout.setText(bitmapFont, this.displayText.toString().replace('\r', ' ').replace('\n', ' '));
        this.glyphPositions.clear();
        float f2 = 0.0f;
        if (this.layout.runs.size > 0) {
            GlyphLayout.GlyphRun glyphRun = this.layout.runs.first();
            FloatArray floatArray = glyphRun.xAdvances;
            this.fontOffset = floatArray.first();
            int n4 = floatArray.size;
            for (int i3 = 1; i3 < n4; ++i3) {
                this.glyphPositions.add(f2);
                f2 += floatArray.get(i3);
            }
        } else {
            this.fontOffset = 0.0f;
        }
        this.glyphPositions.add(f2);
        this.visibleTextStart = Math.min(this.visibleTextStart, this.glyphPositions.size - 1);
        this.visibleTextEnd = MathUtils.clamp(this.visibleTextEnd, this.visibleTextStart, this.glyphPositions.size - 1);
        if (this.selectionStart > string2.length()) {
            this.selectionStart = n3;
        }
    }

    public void copy() {
        if (this.hasSelection && !this.passwordMode) {
            this.clipboard.setContents(this.text.substring(Math.min(this.cursor, this.selectionStart), Math.max(this.cursor, this.selectionStart)));
        }
    }

    public void cut() {
        this.cut(this.programmaticChangeEvents);
    }

    void cut(boolean bl2) {
        if (this.hasSelection && !this.passwordMode) {
            this.copy();
            this.cursor = this.delete(bl2);
            this.updateDisplayText();
        }
    }

    void paste(@Null String string, boolean bl2) {
        if (string == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.text.length();
        if (this.hasSelection) {
            n2 -= Math.abs(this.cursor - this.selectionStart);
        }
        BitmapFont.BitmapFontData bitmapFontData = this.style.font.getData();
        int n3 = string.length();
        for (int i2 = 0; i2 < n3 && this.withinMaxLength(n2 + stringBuilder.length()); ++i2) {
            char c2 = string.charAt(i2);
            if ((!this.writeEnters || c2 != '\n' && c2 != '\r') && (c2 == '\r' || c2 == '\n' || this.onlyFontChars && !bitmapFontData.hasGlyph(c2) || this.filter != null && !this.filter.acceptChar(this, c2))) continue;
            stringBuilder.append(c2);
        }
        string = stringBuilder.toString();
        if (this.hasSelection) {
            this.cursor = this.delete(bl2);
        }
        if (bl2) {
            this.changeText(this.text, this.insert(this.cursor, string, this.text));
        } else {
            this.text = this.insert(this.cursor, string, this.text);
        }
        this.updateDisplayText();
        this.cursor += string.length();
    }

    String insert(int n2, CharSequence charSequence, String string) {
        if (string.length() == 0) {
            return charSequence.toString();
        }
        return string.substring(0, n2) + charSequence + string.substring(n2, string.length());
    }

    int delete(boolean bl2) {
        int n2 = this.selectionStart;
        int n3 = this.cursor;
        int n4 = Math.min(n2, n3);
        int n5 = Math.max(n2, n3);
        String string = (n4 > 0 ? this.text.substring(0, n4) : "") + (n5 < this.text.length() ? this.text.substring(n5, this.text.length()) : "");
        if (bl2) {
            this.changeText(this.text, string);
        } else {
            this.text = string;
        }
        this.clearSelection();
        return n4;
    }

    public void next(boolean bl2) {
        Stage stage = this.getStage();
        if (stage == null) {
            return;
        }
        TextField textField = this;
        Vector2 vector2 = textField.getParent().localToStageCoordinates(tmp2.set(textField.getX(), textField.getY()));
        Vector2 vector22 = tmp1;
        while (true) {
            TextField textField2;
            if ((textField2 = textField.findNextTextField(stage.getActors(), null, vector22, vector2, bl2)) == null) {
                if (bl2) {
                    vector2.set(-3.4028235E38f, -3.4028235E38f);
                } else {
                    vector2.set(Float.MAX_VALUE, Float.MAX_VALUE);
                }
                textField2 = textField.findNextTextField(stage.getActors(), null, vector22, vector2, bl2);
            }
            if (textField2 == null) {
                Gdx.input.setOnscreenKeyboardVisible(false);
                break;
            }
            if (stage.setKeyboardFocus(textField2)) {
                textField2.selectAll();
                break;
            }
            textField = textField2;
            vector2.set(vector22);
        }
    }

    @Null
    private TextField findNextTextField(Array<Actor> array, @Null TextField textField, Vector2 vector2, Vector2 vector22, boolean bl2) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Actor actor = array.get(i2);
            if (actor instanceof TextField) {
                boolean bl3;
                boolean bl4;
                boolean bl5;
                TextField textField2;
                if (actor == this || (textField2 = (TextField)actor).isDisabled() || !textField2.focusTraversal || !textField2.ascendantsVisible()) continue;
                Vector2 vector23 = actor.getParent().localToStageCoordinates(tmp3.set(actor.getX(), actor.getY()));
                boolean bl6 = vector23.y != vector22.y && vector23.y < vector22.y ^ bl2 ? true : (bl5 = false);
                boolean bl7 = vector23.y == vector22.y && vector23.x > vector22.x ^ bl2 ? true : (bl4 = false);
                if (!bl5 && !bl4) continue;
                boolean bl8 = textField == null || vector23.y != vector2.y && vector23.y > vector2.y ^ bl2 ? true : (bl3 = false);
                if (!bl3) {
                    boolean bl9 = vector23.y == vector2.y && vector23.x < vector2.x ^ bl2 ? true : (bl3 = false);
                }
                if (!bl3) continue;
                textField = (TextField)actor;
                vector2.set(vector23);
                continue;
            }
            if (!(actor instanceof Group)) continue;
            textField = this.findNextTextField(((Group)actor).getChildren(), textField, vector2, vector22, bl2);
        }
        return textField;
    }

    public InputListener getDefaultInputListener() {
        return this.inputListener;
    }

    public void setTextFieldListener(@Null TextFieldListener textFieldListener) {
        this.listener = textFieldListener;
    }

    public void setTextFieldFilter(@Null TextFieldFilter textFieldFilter) {
        this.filter = textFieldFilter;
    }

    @Null
    public TextFieldFilter getTextFieldFilter() {
        return this.filter;
    }

    public void setFocusTraversal(boolean bl2) {
        this.focusTraversal = bl2;
    }

    @Null
    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(@Null String string) {
        this.messageText = string;
    }

    public void appendText(@Null String string) {
        if (string == null) {
            string = "";
        }
        this.clearSelection();
        this.cursor = this.text.length();
        this.paste(string, this.programmaticChangeEvents);
    }

    public void setText(@Null String string) {
        if (string == null) {
            string = "";
        }
        if (string.equals(this.text)) {
            return;
        }
        this.clearSelection();
        String string2 = this.text;
        this.text = "";
        this.paste(string, false);
        if (this.programmaticChangeEvents) {
            this.changeText(string2, this.text);
        }
        this.cursor = 0;
    }

    public String getText() {
        return this.text;
    }

    boolean changeText(String string, String string2) {
        if (string2.equals(string)) {
            return false;
        }
        this.text = string2;
        ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
        boolean bl2 = this.fire(changeEvent);
        if (bl2) {
            this.text = string;
        }
        Pools.free(changeEvent);
        return !bl2;
    }

    public void setProgrammaticChangeEvents(boolean bl2) {
        this.programmaticChangeEvents = bl2;
    }

    public boolean getProgrammaticChangeEvents() {
        return this.programmaticChangeEvents;
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public String getSelection() {
        return this.hasSelection ? this.text.substring(Math.min(this.selectionStart, this.cursor), Math.max(this.selectionStart, this.cursor)) : "";
    }

    public void setSelection(int n2, int n3) {
        if (n2 < 0) {
            throw new IllegalArgumentException("selectionStart must be >= 0");
        }
        if (n3 < 0) {
            throw new IllegalArgumentException("selectionEnd must be >= 0");
        }
        n2 = Math.min(this.text.length(), n2);
        n3 = Math.min(this.text.length(), n3);
        if (n3 == n2) {
            this.clearSelection();
            return;
        }
        if (n3 < n2) {
            int n4 = n3;
            n3 = n2;
            n2 = n4;
        }
        this.hasSelection = true;
        this.selectionStart = n2;
        this.cursor = n3;
    }

    public void selectAll() {
        this.setSelection(0, this.text.length());
    }

    public void clearSelection() {
        this.hasSelection = false;
    }

    public void setCursorPosition(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("cursorPosition must be >= 0");
        }
        this.clearSelection();
        this.cursor = Math.min(n2, this.text.length());
    }

    public int getCursorPosition() {
        return this.cursor;
    }

    public OnscreenKeyboard getOnscreenKeyboard() {
        return this.keyboard;
    }

    public void setOnscreenKeyboard(OnscreenKeyboard onscreenKeyboard) {
        this.keyboard = onscreenKeyboard;
    }

    public void setClipboard(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    @Override
    public float getPrefWidth() {
        return 150.0f;
    }

    @Override
    public float getPrefHeight() {
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (this.style.background != null) {
            f2 = Math.max(f2, this.style.background.getBottomHeight() + this.style.background.getTopHeight());
            f3 = Math.max(f3, this.style.background.getMinHeight());
        }
        if (this.style.focusedBackground != null) {
            f2 = Math.max(f2, this.style.focusedBackground.getBottomHeight() + this.style.focusedBackground.getTopHeight());
            f3 = Math.max(f3, this.style.focusedBackground.getMinHeight());
        }
        if (this.style.disabledBackground != null) {
            f2 = Math.max(f2, this.style.disabledBackground.getBottomHeight() + this.style.disabledBackground.getTopHeight());
            f3 = Math.max(f3, this.style.disabledBackground.getMinHeight());
        }
        return Math.max(f2 + this.textHeight, f3);
    }

    public void setAlignment(int n2) {
        this.textHAlign = n2;
    }

    public int getAlignment() {
        return this.textHAlign;
    }

    public void setPasswordMode(boolean bl2) {
        this.passwordMode = bl2;
        this.updateDisplayText();
    }

    public boolean isPasswordMode() {
        return this.passwordMode;
    }

    public void setPasswordCharacter(char c2) {
        this.passwordCharacter = c2;
        if (this.passwordMode) {
            this.updateDisplayText();
        }
    }

    public void setBlinkTime(float f2) {
        this.blinkTime = f2;
    }

    @Override
    public void setDisabled(boolean bl2) {
        this.disabled = bl2;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    protected void moveCursor(boolean bl2, boolean bl3) {
        int n2;
        int n3 = bl2 ? this.text.length() : 0;
        int n4 = n2 = bl2 ? 0 : -1;
        while ((bl2 ? ++this.cursor < n3 : --this.cursor > n3) && bl3 && this.continueCursor(this.cursor, n2)) {
        }
    }

    protected boolean continueCursor(int n2, int n3) {
        char c2 = this.text.charAt(n2 + n3);
        return this.isWordCharacter(c2);
    }

    public static class TextFieldStyle {
        public BitmapFont font;
        public Color fontColor;
        @Null
        public Color focusedFontColor;
        @Null
        public Color disabledFontColor;
        @Null
        public Drawable background;
        @Null
        public Drawable focusedBackground;
        @Null
        public Drawable disabledBackground;
        @Null
        public Drawable cursor;
        @Null
        public Drawable selection;
        @Null
        public BitmapFont messageFont;
        @Null
        public Color messageFontColor;

        public TextFieldStyle() {
        }

        public TextFieldStyle(BitmapFont bitmapFont, Color color, @Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3) {
            this.font = bitmapFont;
            this.fontColor = color;
            this.cursor = drawable;
            this.selection = drawable2;
            this.background = drawable3;
        }

        public TextFieldStyle(TextFieldStyle textFieldStyle) {
            this.font = textFieldStyle.font;
            if (textFieldStyle.fontColor != null) {
                this.fontColor = new Color(textFieldStyle.fontColor);
            }
            if (textFieldStyle.focusedFontColor != null) {
                this.focusedFontColor = new Color(textFieldStyle.focusedFontColor);
            }
            if (textFieldStyle.disabledFontColor != null) {
                this.disabledFontColor = new Color(textFieldStyle.disabledFontColor);
            }
            this.background = textFieldStyle.background;
            this.focusedBackground = textFieldStyle.focusedBackground;
            this.disabledBackground = textFieldStyle.disabledBackground;
            this.cursor = textFieldStyle.cursor;
            this.selection = textFieldStyle.selection;
            this.messageFont = textFieldStyle.messageFont;
            if (textFieldStyle.messageFontColor != null) {
                this.messageFontColor = new Color(textFieldStyle.messageFontColor);
            }
        }
    }

    public class TextFieldClickListener
    extends ClickListener {
        @Override
        public void clicked(InputEvent inputEvent, float f2, float f3) {
            int n2 = this.getTapCount() % 4;
            if (n2 == 0) {
                TextField.this.clearSelection();
            }
            if (n2 == 2) {
                int[] nArray = TextField.this.wordUnderCursor(f2);
                TextField.this.setSelection(nArray[0], nArray[1]);
            }
            if (n2 == 3) {
                TextField.this.selectAll();
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
            if (TextField.this.disabled) {
                return true;
            }
            this.setCursorPosition(f2, f3);
            TextField.this.selectionStart = TextField.this.cursor;
            Stage stage = TextField.this.getStage();
            if (stage != null) {
                stage.setKeyboardFocus(TextField.this);
            }
            TextField.this.keyboard.show(true);
            TextField.this.hasSelection = true;
            return true;
        }

        @Override
        public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
            super.touchDragged(inputEvent, f2, f3, n2);
            this.setCursorPosition(f2, f3);
        }

        @Override
        public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
            if (TextField.this.selectionStart == TextField.this.cursor) {
                TextField.this.hasSelection = false;
            }
            super.touchUp(inputEvent, f2, f3, n2, n3);
        }

        protected void setCursorPosition(float f2, float f3) {
            TextField.this.cursor = TextField.this.letterUnderCursor(f2);
            TextField.this.cursorOn = TextField.this.focused;
            TextField.this.blinkTask.cancel();
            if (TextField.this.focused) {
                Timer.schedule(TextField.this.blinkTask, TextField.this.blinkTime, TextField.this.blinkTime);
            }
        }

        protected void goHome(boolean bl2) {
            TextField.this.cursor = 0;
        }

        protected void goEnd(boolean bl2) {
            TextField.this.cursor = TextField.this.text.length();
        }

        @Override
        public boolean keyDown(InputEvent inputEvent, int n2) {
            boolean bl2;
            boolean bl3;
            block30: {
                boolean bl4;
                block29: {
                    if (TextField.this.disabled) {
                        return false;
                    }
                    TextField.this.cursorOn = TextField.this.focused;
                    TextField.this.blinkTask.cancel();
                    if (TextField.this.focused) {
                        Timer.schedule(TextField.this.blinkTask, TextField.this.blinkTime, TextField.this.blinkTime);
                    }
                    if (!TextField.this.hasKeyboardFocus()) {
                        return false;
                    }
                    bl3 = false;
                    boolean bl5 = UIUtils.ctrl();
                    bl4 = bl5 && !TextField.this.passwordMode;
                    bl2 = true;
                    if (bl5) {
                        switch (n2) {
                            case 50: {
                                TextField.this.paste(TextField.this.clipboard.getContents(), true);
                                bl3 = true;
                                break;
                            }
                            case 31: 
                            case 124: {
                                TextField.this.copy();
                                return true;
                            }
                            case 52: {
                                TextField.this.cut(true);
                                return true;
                            }
                            case 29: {
                                TextField.this.selectAll();
                                return true;
                            }
                            case 54: {
                                String string = TextField.this.text;
                                TextField.this.setText(TextField.this.undoText);
                                TextField.this.undoText = string;
                                TextField.this.updateDisplayText();
                                return true;
                            }
                            default: {
                                bl2 = false;
                            }
                        }
                    }
                    if (!UIUtils.shift()) break block29;
                    switch (n2) {
                        case 124: {
                            TextField.this.paste(TextField.this.clipboard.getContents(), true);
                            break;
                        }
                        case 112: {
                            TextField.this.cut(true);
                        }
                    }
                    int n3 = TextField.this.cursor;
                    switch (n2) {
                        case 21: {
                            TextField.this.moveCursor(false, bl4);
                            bl3 = true;
                            bl2 = true;
                            break;
                        }
                        case 22: {
                            TextField.this.moveCursor(true, bl4);
                            bl3 = true;
                            bl2 = true;
                            break;
                        }
                        case 3: {
                            this.goHome(bl4);
                            bl2 = true;
                            break;
                        }
                        case 123: {
                            this.goEnd(bl4);
                            bl2 = true;
                            break;
                        }
                        default: {
                            break block30;
                        }
                    }
                    if (!TextField.this.hasSelection) {
                        TextField.this.selectionStart = n3;
                        TextField.this.hasSelection = true;
                    }
                    break block30;
                }
                switch (n2) {
                    case 21: {
                        TextField.this.moveCursor(false, bl4);
                        TextField.this.clearSelection();
                        bl3 = true;
                        bl2 = true;
                        break;
                    }
                    case 22: {
                        TextField.this.moveCursor(true, bl4);
                        TextField.this.clearSelection();
                        bl3 = true;
                        bl2 = true;
                        break;
                    }
                    case 3: {
                        this.goHome(bl4);
                        TextField.this.clearSelection();
                        bl2 = true;
                        break;
                    }
                    case 123: {
                        this.goEnd(bl4);
                        TextField.this.clearSelection();
                        bl2 = true;
                    }
                }
            }
            TextField.this.cursor = MathUtils.clamp(TextField.this.cursor, 0, TextField.this.text.length());
            if (bl3) {
                this.scheduleKeyRepeatTask(n2);
            }
            return bl2;
        }

        protected void scheduleKeyRepeatTask(int n2) {
            if (!TextField.this.keyRepeatTask.isScheduled() || TextField.this.keyRepeatTask.keycode != n2) {
                TextField.this.keyRepeatTask.keycode = n2;
                TextField.this.keyRepeatTask.cancel();
                Timer.schedule(TextField.this.keyRepeatTask, keyRepeatInitialTime, keyRepeatTime);
            }
        }

        @Override
        public boolean keyUp(InputEvent inputEvent, int n2) {
            if (TextField.this.disabled) {
                return false;
            }
            TextField.this.keyRepeatTask.cancel();
            return true;
        }

        protected boolean checkFocusTraversal(char c2) {
            return !(!TextField.this.focusTraversal || c2 != '\t' && (c2 != '\r' && c2 != '\n' || !UIUtils.isAndroid && !UIUtils.isIos));
        }

        @Override
        public boolean keyTyped(InputEvent inputEvent, char c2) {
            if (TextField.this.disabled) {
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
            if (!TextField.this.hasKeyboardFocus()) {
                return false;
            }
            if (UIUtils.isMac && Gdx.input.isKeyPressed(63)) {
                return true;
            }
            if (this.checkFocusTraversal(c2)) {
                TextField.this.next(UIUtils.shift());
            } else {
                boolean bl2;
                boolean bl3;
                boolean bl4 = c2 == '\r' || c2 == '\n';
                boolean bl5 = c2 == '\u007f';
                boolean bl6 = bl3 = c2 == '\b';
                boolean bl7 = bl4 ? TextField.this.writeEnters : !TextField.this.onlyFontChars || TextField.this.style.font.getData().hasGlyph(c2);
                boolean bl8 = bl2 = bl3 || bl5;
                if (bl7 || bl2) {
                    String string;
                    String string2 = TextField.this.text;
                    int n2 = TextField.this.cursor;
                    if (bl2) {
                        if (TextField.this.hasSelection) {
                            TextField.this.cursor = TextField.this.delete(false);
                        } else {
                            if (bl3 && TextField.this.cursor > 0) {
                                TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor - 1) + TextField.this.text.substring(TextField.this.cursor--);
                                TextField.this.renderOffset = 0.0f;
                            }
                            if (bl5 && TextField.this.cursor < TextField.this.text.length()) {
                                TextField.this.text = TextField.this.text.substring(0, TextField.this.cursor) + TextField.this.text.substring(TextField.this.cursor + 1);
                            }
                        }
                    }
                    if (bl7 && !bl2) {
                        if (!bl4 && TextField.this.filter != null && !TextField.this.filter.acceptChar(TextField.this, c2)) {
                            return true;
                        }
                        if (!TextField.this.withinMaxLength(TextField.this.text.length() - (TextField.this.hasSelection ? Math.abs(TextField.this.cursor - TextField.this.selectionStart) : 0))) {
                            return true;
                        }
                        if (TextField.this.hasSelection) {
                            TextField.this.cursor = TextField.this.delete(false);
                        }
                        string = bl4 ? "\n" : String.valueOf(c2);
                        TextField.this.text = TextField.this.insert(TextField.this.cursor++, string, TextField.this.text);
                    }
                    string = TextField.this.undoText;
                    if (TextField.this.changeText(string2, TextField.this.text)) {
                        long l2 = System.currentTimeMillis();
                        if (l2 - 750L > TextField.this.lastChangeTime) {
                            TextField.this.undoText = string2;
                        }
                        TextField.this.lastChangeTime = l2;
                        TextField.this.updateDisplayText();
                    } else {
                        TextField.this.cursor = n2;
                    }
                }
            }
            if (TextField.this.listener != null) {
                TextField.this.listener.keyTyped(TextField.this, c2);
            }
            return true;
        }
    }

    public static class DefaultOnscreenKeyboard
    implements OnscreenKeyboard {
        @Override
        public void show(boolean bl2) {
            Gdx.input.setOnscreenKeyboardVisible(bl2);
        }
    }

    public static interface OnscreenKeyboard {
        public void show(boolean var1);
    }

    public static interface TextFieldFilter {
        public boolean acceptChar(TextField var1, char var2);

        public static class DigitsOnlyFilter
        implements TextFieldFilter {
            @Override
            public boolean acceptChar(TextField textField, char c2) {
                return Character.isDigit(c2);
            }
        }
    }

    public static interface TextFieldListener {
        public void keyTyped(TextField var1, char var2);
    }

    class KeyRepeatTask
    extends Timer.Task {
        int keycode;

        KeyRepeatTask() {
        }

        @Override
        public void run() {
            if (TextField.this.getStage() == null) {
                this.cancel();
                return;
            }
            TextField.this.inputListener.keyDown(null, this.keycode);
        }
    }
}

