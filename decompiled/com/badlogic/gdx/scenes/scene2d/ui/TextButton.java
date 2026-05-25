/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;

public class TextButton
extends Button {
    private Label label;
    private TextButtonStyle style;

    public TextButton(@Null String string, Skin skin) {
        this(string, skin.get(TextButtonStyle.class));
        this.setSkin(skin);
    }

    public TextButton(@Null String string, Skin skin, String string2) {
        this(string, skin.get(string2, TextButtonStyle.class));
        this.setSkin(skin);
    }

    public TextButton(@Null String string, TextButtonStyle textButtonStyle) {
        this.setStyle(textButtonStyle);
        this.label = this.newLabel(string, new Label.LabelStyle(textButtonStyle.font, textButtonStyle.fontColor));
        this.label.setAlignment(1);
        this.add(this.label).expand().fill();
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    protected Label newLabel(String string, Label.LabelStyle labelStyle) {
        return new Label((CharSequence)string, labelStyle);
    }

    @Override
    public void setStyle(Button.ButtonStyle buttonStyle) {
        if (buttonStyle == null) {
            throw new NullPointerException("style cannot be null");
        }
        if (!(buttonStyle instanceof TextButtonStyle)) {
            throw new IllegalArgumentException("style must be a TextButtonStyle.");
        }
        this.style = (TextButtonStyle)buttonStyle;
        super.setStyle(buttonStyle);
        if (this.label != null) {
            TextButtonStyle textButtonStyle = (TextButtonStyle)buttonStyle;
            Label.LabelStyle labelStyle = this.label.getStyle();
            labelStyle.font = textButtonStyle.font;
            labelStyle.fontColor = textButtonStyle.fontColor;
            this.label.setStyle(labelStyle);
        }
    }

    @Override
    public TextButtonStyle getStyle() {
        return this.style;
    }

    @Null
    protected Color getFontColor() {
        if (this.isDisabled() && this.style.disabledFontColor != null) {
            return this.style.disabledFontColor;
        }
        if (this.isPressed()) {
            if (this.isChecked() && this.style.checkedDownFontColor != null) {
                return this.style.checkedDownFontColor;
            }
            if (this.style.downFontColor != null) {
                return this.style.downFontColor;
            }
        }
        if (this.isOver()) {
            if (this.isChecked()) {
                if (this.style.checkedOverFontColor != null) {
                    return this.style.checkedOverFontColor;
                }
            } else if (this.style.overFontColor != null) {
                return this.style.overFontColor;
            }
        }
        boolean bl2 = this.hasKeyboardFocus();
        if (this.isChecked()) {
            if (bl2 && this.style.checkedFocusedFontColor != null) {
                return this.style.checkedFocusedFontColor;
            }
            if (this.style.checkedFontColor != null) {
                return this.style.checkedFontColor;
            }
            if (this.isOver() && this.style.overFontColor != null) {
                return this.style.overFontColor;
            }
        }
        if (bl2 && this.style.focusedFontColor != null) {
            return this.style.focusedFontColor;
        }
        return this.style.fontColor;
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.label.getStyle().fontColor = this.getFontColor();
        super.draw(batch, f2);
    }

    public void setLabel(Label label) {
        if (label == null) {
            throw new IllegalArgumentException("label cannot be null.");
        }
        this.getLabelCell().setActor(label);
        this.label = label;
    }

    public Label getLabel() {
        return this.label;
    }

    public Cell<Label> getLabelCell() {
        return this.getCell(this.label);
    }

    public void setText(@Null String string) {
        this.label.setText(string);
    }

    public CharSequence getText() {
        return this.label.getText();
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
        return (string2.indexOf(36) != -1 ? "TextButton " : "") + string2 + ": " + this.label.getText();
    }

    public static class TextButtonStyle
    extends Button.ButtonStyle {
        public BitmapFont font;
        @Null
        public Color fontColor;
        @Null
        public Color downFontColor;
        @Null
        public Color overFontColor;
        @Null
        public Color focusedFontColor;
        @Null
        public Color disabledFontColor;
        @Null
        public Color checkedFontColor;
        @Null
        public Color checkedDownFontColor;
        @Null
        public Color checkedOverFontColor;
        @Null
        public Color checkedFocusedFontColor;

        public TextButtonStyle() {
        }

        public TextButtonStyle(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3, @Null BitmapFont bitmapFont) {
            super(drawable, drawable2, drawable3);
            this.font = bitmapFont;
        }

        public TextButtonStyle(TextButtonStyle textButtonStyle) {
            super(textButtonStyle);
            this.font = textButtonStyle.font;
            if (textButtonStyle.fontColor != null) {
                this.fontColor = new Color(textButtonStyle.fontColor);
            }
            if (textButtonStyle.downFontColor != null) {
                this.downFontColor = new Color(textButtonStyle.downFontColor);
            }
            if (textButtonStyle.overFontColor != null) {
                this.overFontColor = new Color(textButtonStyle.overFontColor);
            }
            if (textButtonStyle.focusedFontColor != null) {
                this.focusedFontColor = new Color(textButtonStyle.focusedFontColor);
            }
            if (textButtonStyle.disabledFontColor != null) {
                this.disabledFontColor = new Color(textButtonStyle.disabledFontColor);
            }
            if (textButtonStyle.checkedFontColor != null) {
                this.checkedFontColor = new Color(textButtonStyle.checkedFontColor);
            }
            if (textButtonStyle.checkedDownFontColor != null) {
                this.checkedDownFontColor = new Color(textButtonStyle.checkedDownFontColor);
            }
            if (textButtonStyle.checkedOverFontColor != null) {
                this.checkedOverFontColor = new Color(textButtonStyle.checkedOverFontColor);
            }
            if (textButtonStyle.checkedFocusedFontColor != null) {
                this.checkedFocusedFontColor = new Color(textButtonStyle.checkedFocusedFontColor);
            }
        }
    }
}

