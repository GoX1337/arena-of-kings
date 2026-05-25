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

public class CheckBox
extends TextButton {
    private Image image;
    private Cell imageCell;
    private CheckBoxStyle style;

    public CheckBox(@Null String string, Skin skin) {
        this(string, skin.get(CheckBoxStyle.class));
    }

    public CheckBox(@Null String string, Skin skin, String string2) {
        this(string, skin.get(string2, CheckBoxStyle.class));
    }

    public CheckBox(@Null String string, CheckBoxStyle checkBoxStyle) {
        super(string, checkBoxStyle);
        Label label = this.getLabel();
        label.setAlignment(8);
        this.image = this.newImage();
        this.image.setDrawable(checkBoxStyle.checkboxOff);
        this.clearChildren();
        this.imageCell = this.add(this.image);
        this.add(label);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    protected Image newImage() {
        return new Image((Drawable)null, Scaling.none);
    }

    @Override
    public void setStyle(Button.ButtonStyle buttonStyle) {
        if (!(buttonStyle instanceof CheckBoxStyle)) {
            throw new IllegalArgumentException("style must be a CheckBoxStyle.");
        }
        this.style = (CheckBoxStyle)buttonStyle;
        super.setStyle(buttonStyle);
    }

    @Override
    public CheckBoxStyle getStyle() {
        return this.style;
    }

    @Override
    public void draw(Batch batch, float f2) {
        Drawable drawable = null;
        if (this.isDisabled()) {
            drawable = this.isChecked && this.style.checkboxOnDisabled != null ? this.style.checkboxOnDisabled : this.style.checkboxOffDisabled;
        }
        if (drawable == null) {
            boolean bl2;
            boolean bl3 = bl2 = this.isOver() && !this.isDisabled();
            drawable = this.isChecked && this.style.checkboxOn != null ? (bl2 && this.style.checkboxOnOver != null ? this.style.checkboxOnOver : this.style.checkboxOn) : (bl2 && this.style.checkboxOver != null ? this.style.checkboxOver : this.style.checkboxOff);
        }
        this.image.setDrawable(drawable);
        super.draw(batch, f2);
    }

    public Image getImage() {
        return this.image;
    }

    public Cell getImageCell() {
        return this.imageCell;
    }

    public static class CheckBoxStyle
    extends TextButton.TextButtonStyle {
        public Drawable checkboxOn;
        public Drawable checkboxOff;
        @Null
        public Drawable checkboxOnOver;
        @Null
        public Drawable checkboxOver;
        @Null
        public Drawable checkboxOnDisabled;
        @Null
        public Drawable checkboxOffDisabled;

        public CheckBoxStyle() {
        }

        public CheckBoxStyle(Drawable drawable, Drawable drawable2, BitmapFont bitmapFont, @Null Color color) {
            this.checkboxOff = drawable;
            this.checkboxOn = drawable2;
            this.font = bitmapFont;
            this.fontColor = color;
        }

        public CheckBoxStyle(CheckBoxStyle checkBoxStyle) {
            super(checkBoxStyle);
            this.checkboxOff = checkBoxStyle.checkboxOff;
            this.checkboxOn = checkBoxStyle.checkboxOn;
            this.checkboxOnOver = checkBoxStyle.checkboxOnOver;
            this.checkboxOver = checkBoxStyle.checkboxOver;
            this.checkboxOnDisabled = checkBoxStyle.checkboxOnDisabled;
            this.checkboxOffDisabled = checkBoxStyle.checkboxOffDisabled;
        }
    }
}

