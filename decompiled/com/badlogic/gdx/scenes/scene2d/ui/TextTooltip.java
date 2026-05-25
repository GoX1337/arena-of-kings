/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Tooltip;
import com.badlogic.gdx.scenes.scene2d.ui.TooltipManager;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;

public class TextTooltip
extends Tooltip<Label> {
    public TextTooltip(@Null String string, Skin skin) {
        this(string, TooltipManager.getInstance(), skin.get(TextTooltipStyle.class));
    }

    public TextTooltip(@Null String string, Skin skin, String string2) {
        this(string, TooltipManager.getInstance(), skin.get(string2, TextTooltipStyle.class));
    }

    public TextTooltip(@Null String string, TextTooltipStyle textTooltipStyle) {
        this(string, TooltipManager.getInstance(), textTooltipStyle);
    }

    public TextTooltip(@Null String string, TooltipManager tooltipManager, Skin skin) {
        this(string, tooltipManager, skin.get(TextTooltipStyle.class));
    }

    public TextTooltip(@Null String string, TooltipManager tooltipManager, Skin skin, String string2) {
        this(string, tooltipManager, skin.get(string2, TextTooltipStyle.class));
    }

    public TextTooltip(@Null String string, TooltipManager tooltipManager, TextTooltipStyle textTooltipStyle) {
        super(null, tooltipManager);
        Label label = this.newLabel(string, textTooltipStyle.label);
        label.setWrap(true);
        this.container.fill().setActor(label);
        this.setStyle(textTooltipStyle);
    }

    protected Label newLabel(String string, Label.LabelStyle labelStyle) {
        return new Label((CharSequence)string, labelStyle);
    }

    public void setStyle(TextTooltipStyle textTooltipStyle) {
        if (textTooltipStyle == null) {
            throw new NullPointerException("style cannot be null");
        }
        ((Label)this.container.getActor()).setStyle(textTooltipStyle.label);
        this.container.setBackground(textTooltipStyle.background);
        this.container.maxWidth(textTooltipStyle.wrapWidth);
    }

    public static class TextTooltipStyle {
        public Label.LabelStyle label;
        @Null
        public Drawable background;
        public float wrapWidth;

        public TextTooltipStyle() {
        }

        public TextTooltipStyle(Label.LabelStyle labelStyle, @Null Drawable drawable) {
            this.label = labelStyle;
            this.background = drawable;
        }

        public TextTooltipStyle(TextTooltipStyle textTooltipStyle) {
            this.label = new Label.LabelStyle(textTooltipStyle.label);
            this.background = textTooltipStyle.background;
            this.wrapWidth = textTooltipStyle.wrapWidth;
        }
    }
}

