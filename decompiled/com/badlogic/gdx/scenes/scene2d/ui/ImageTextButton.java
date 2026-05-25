/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Scaling;

public class ImageTextButton
extends Button {
    private final Image image;
    private Label label;
    private ImageTextButtonStyle style;

    public ImageTextButton(@Null String string, Skin skin) {
        this(string, skin.get(ImageTextButtonStyle.class));
        this.setSkin(skin);
    }

    public ImageTextButton(@Null String string, Skin skin, String string2) {
        this(string, skin.get(string2, ImageTextButtonStyle.class));
        this.setSkin(skin);
    }

    public ImageTextButton(@Null String string, ImageTextButtonStyle imageTextButtonStyle) {
        super(imageTextButtonStyle);
        this.style = imageTextButtonStyle;
        this.defaults().space(3.0f);
        this.image = this.newImage();
        this.label = this.newLabel(string, new Label.LabelStyle(imageTextButtonStyle.font, imageTextButtonStyle.fontColor));
        this.label.setAlignment(1);
        this.add(this.image);
        this.add(this.label);
        this.setStyle(imageTextButtonStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    protected Image newImage() {
        return new Image((Drawable)null, Scaling.fit);
    }

    protected Label newLabel(String string, Label.LabelStyle labelStyle) {
        return new Label((CharSequence)string, labelStyle);
    }

    @Override
    public void setStyle(Button.ButtonStyle buttonStyle) {
        if (!(buttonStyle instanceof ImageTextButtonStyle)) {
            throw new IllegalArgumentException("style must be a ImageTextButtonStyle.");
        }
        this.style = (ImageTextButtonStyle)buttonStyle;
        super.setStyle(buttonStyle);
        if (this.image != null) {
            this.updateImage();
        }
        if (this.label != null) {
            ImageTextButtonStyle imageTextButtonStyle = (ImageTextButtonStyle)buttonStyle;
            Label.LabelStyle labelStyle = this.label.getStyle();
            labelStyle.font = imageTextButtonStyle.font;
            labelStyle.fontColor = this.getFontColor();
            this.label.setStyle(labelStyle);
        }
    }

    @Override
    public ImageTextButtonStyle getStyle() {
        return this.style;
    }

    @Null
    protected Drawable getImageDrawable() {
        if (this.isDisabled() && this.style.imageDisabled != null) {
            return this.style.imageDisabled;
        }
        if (this.isPressed()) {
            if (this.isChecked() && this.style.imageCheckedDown != null) {
                return this.style.imageCheckedDown;
            }
            if (this.style.imageDown != null) {
                return this.style.imageDown;
            }
        }
        if (this.isOver()) {
            if (this.isChecked()) {
                if (this.style.imageCheckedOver != null) {
                    return this.style.imageCheckedOver;
                }
            } else if (this.style.imageOver != null) {
                return this.style.imageOver;
            }
        }
        if (this.isChecked()) {
            if (this.style.imageChecked != null) {
                return this.style.imageChecked;
            }
            if (this.isOver() && this.style.imageOver != null) {
                return this.style.imageOver;
            }
        }
        return this.style.imageUp;
    }

    protected void updateImage() {
        this.image.setDrawable(this.getImageDrawable());
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
        this.updateImage();
        this.label.getStyle().fontColor = this.getFontColor();
        super.draw(batch, f2);
    }

    public Image getImage() {
        return this.image;
    }

    public Cell getImageCell() {
        return this.getCell(this.image);
    }

    public void setLabel(Label label) {
        this.getLabelCell().setActor(label);
        this.label = label;
    }

    public Label getLabel() {
        return this.label;
    }

    public Cell getLabelCell() {
        return this.getCell(this.label);
    }

    public void setText(CharSequence charSequence) {
        this.label.setText(charSequence);
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
        return (string2.indexOf(36) != -1 ? "ImageTextButton " : "") + string2 + ": " + this.image.getDrawable() + " " + this.label.getText();
    }

    public static class ImageTextButtonStyle
    extends TextButton.TextButtonStyle {
        @Null
        public Drawable imageUp;
        @Null
        public Drawable imageDown;
        @Null
        public Drawable imageOver;
        @Null
        public Drawable imageDisabled;
        @Null
        public Drawable imageChecked;
        @Null
        public Drawable imageCheckedDown;
        @Null
        public Drawable imageCheckedOver;

        public ImageTextButtonStyle() {
        }

        public ImageTextButtonStyle(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3, BitmapFont bitmapFont) {
            super(drawable, drawable2, drawable3, bitmapFont);
        }

        public ImageTextButtonStyle(ImageTextButtonStyle imageTextButtonStyle) {
            super(imageTextButtonStyle);
            this.imageUp = imageTextButtonStyle.imageUp;
            this.imageDown = imageTextButtonStyle.imageDown;
            this.imageOver = imageTextButtonStyle.imageOver;
            this.imageDisabled = imageTextButtonStyle.imageDisabled;
            this.imageChecked = imageTextButtonStyle.imageChecked;
            this.imageCheckedDown = imageTextButtonStyle.imageCheckedDown;
            this.imageCheckedOver = imageTextButtonStyle.imageCheckedOver;
        }

        public ImageTextButtonStyle(TextButton.TextButtonStyle textButtonStyle) {
            super(textButtonStyle);
        }
    }
}

