/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Scaling;

public class ImageButton
extends Button {
    private final Image image = this.newImage();
    private ImageButtonStyle style;

    public ImageButton(Skin skin) {
        this(skin.get(ImageButtonStyle.class));
        this.setSkin(skin);
    }

    public ImageButton(Skin skin, String string) {
        this(skin.get(string, ImageButtonStyle.class));
        this.setSkin(skin);
    }

    public ImageButton(ImageButtonStyle imageButtonStyle) {
        super(imageButtonStyle);
        this.add(this.image);
        this.setStyle(imageButtonStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public ImageButton(@Null Drawable drawable) {
        this(new ImageButtonStyle(null, null, null, drawable, null, null));
    }

    public ImageButton(@Null Drawable drawable, @Null Drawable drawable2) {
        this(new ImageButtonStyle(null, null, null, drawable, drawable2, null));
    }

    public ImageButton(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3) {
        this(new ImageButtonStyle(null, null, null, drawable, drawable2, drawable3));
    }

    protected Image newImage() {
        return new Image((Drawable)null, Scaling.fit);
    }

    @Override
    public void setStyle(Button.ButtonStyle buttonStyle) {
        if (!(buttonStyle instanceof ImageButtonStyle)) {
            throw new IllegalArgumentException("style must be an ImageButtonStyle.");
        }
        this.style = (ImageButtonStyle)buttonStyle;
        super.setStyle(buttonStyle);
        if (this.image != null) {
            this.updateImage();
        }
    }

    @Override
    public ImageButtonStyle getStyle() {
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

    @Override
    public void draw(Batch batch, float f2) {
        this.updateImage();
        super.draw(batch, f2);
    }

    public Image getImage() {
        return this.image;
    }

    public Cell getImageCell() {
        return this.getCell(this.image);
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
        return (string2.indexOf(36) != -1 ? "ImageButton " : "") + string2 + ": " + this.image.getDrawable();
    }

    public static class ImageButtonStyle
    extends Button.ButtonStyle {
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

        public ImageButtonStyle() {
        }

        public ImageButtonStyle(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3, @Null Drawable drawable4, @Null Drawable drawable5, @Null Drawable drawable6) {
            super(drawable, drawable2, drawable3);
            this.imageUp = drawable4;
            this.imageDown = drawable5;
            this.imageChecked = drawable6;
        }

        public ImageButtonStyle(ImageButtonStyle imageButtonStyle) {
            super(imageButtonStyle);
            this.imageUp = imageButtonStyle.imageUp;
            this.imageDown = imageButtonStyle.imageDown;
            this.imageOver = imageButtonStyle.imageOver;
            this.imageDisabled = imageButtonStyle.imageDisabled;
            this.imageChecked = imageButtonStyle.imageChecked;
            this.imageCheckedDown = imageButtonStyle.imageCheckedDown;
            this.imageCheckedOver = imageButtonStyle.imageCheckedOver;
        }

        public ImageButtonStyle(Button.ButtonStyle buttonStyle) {
            super(buttonStyle);
        }
    }
}

