/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;

public class Button
extends Table
implements Disableable {
    private ButtonStyle style;
    boolean isChecked;
    boolean isDisabled;
    ButtonGroup buttonGroup;
    private ClickListener clickListener;
    private boolean programmaticChangeEvents = true;

    public Button(Skin skin) {
        super(skin);
        this.initialize();
        this.setStyle(skin.get(ButtonStyle.class));
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public Button(Skin skin, String string) {
        super(skin);
        this.initialize();
        this.setStyle(skin.get(string, ButtonStyle.class));
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public Button(Actor actor, Skin skin, String string) {
        this(actor, skin.get(string, ButtonStyle.class));
        this.setSkin(skin);
    }

    public Button(Actor actor, ButtonStyle buttonStyle) {
        this.initialize();
        this.add(actor);
        this.setStyle(buttonStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public Button(ButtonStyle buttonStyle) {
        this.initialize();
        this.setStyle(buttonStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public Button() {
        this.initialize();
    }

    private void initialize() {
        this.setTouchable(Touchable.enabled);
        this.clickListener = new ClickListener(){

            @Override
            public void clicked(InputEvent inputEvent, float f2, float f3) {
                if (Button.this.isDisabled()) {
                    return;
                }
                Button.this.setChecked(!Button.this.isChecked, true);
            }
        };
        this.addListener(this.clickListener);
    }

    public Button(@Null Drawable drawable) {
        this(new ButtonStyle(drawable, null, null));
    }

    public Button(@Null Drawable drawable, @Null Drawable drawable2) {
        this(new ButtonStyle(drawable, drawable2, null));
    }

    public Button(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3) {
        this(new ButtonStyle(drawable, drawable2, drawable3));
    }

    public Button(Actor actor, Skin skin) {
        this(actor, skin.get(ButtonStyle.class));
    }

    public void setChecked(boolean bl2) {
        this.setChecked(bl2, this.programmaticChangeEvents);
    }

    void setChecked(boolean bl2, boolean bl3) {
        if (this.isChecked == bl2) {
            return;
        }
        if (this.buttonGroup != null && !this.buttonGroup.canCheck(this, bl2)) {
            return;
        }
        this.isChecked = bl2;
        if (bl3) {
            ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
            if (this.fire(changeEvent)) {
                this.isChecked = !bl2;
            }
            Pools.free(changeEvent);
        }
    }

    public void toggle() {
        this.setChecked(!this.isChecked);
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isPressed() {
        return this.clickListener.isVisualPressed();
    }

    public boolean isOver() {
        return this.clickListener.isOver();
    }

    public ClickListener getClickListener() {
        return this.clickListener;
    }

    @Override
    public boolean isDisabled() {
        return this.isDisabled;
    }

    @Override
    public void setDisabled(boolean bl2) {
        this.isDisabled = bl2;
    }

    public void setProgrammaticChangeEvents(boolean bl2) {
        this.programmaticChangeEvents = bl2;
    }

    public void setStyle(ButtonStyle buttonStyle) {
        if (buttonStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = buttonStyle;
        this.setBackground(this.getBackgroundDrawable());
    }

    public ButtonStyle getStyle() {
        return this.style;
    }

    @Null
    public ButtonGroup getButtonGroup() {
        return this.buttonGroup;
    }

    @Null
    protected Drawable getBackgroundDrawable() {
        if (this.isDisabled() && this.style.disabled != null) {
            return this.style.disabled;
        }
        if (this.isPressed()) {
            if (this.isChecked() && this.style.checkedDown != null) {
                return this.style.checkedDown;
            }
            if (this.style.down != null) {
                return this.style.down;
            }
        }
        if (this.isOver()) {
            if (this.isChecked()) {
                if (this.style.checkedOver != null) {
                    return this.style.checkedOver;
                }
            } else if (this.style.over != null) {
                return this.style.over;
            }
        }
        boolean bl2 = this.hasKeyboardFocus();
        if (this.isChecked()) {
            if (bl2 && this.style.checkedFocused != null) {
                return this.style.checkedFocused;
            }
            if (this.style.checked != null) {
                return this.style.checked;
            }
            if (this.isOver() && this.style.over != null) {
                return this.style.over;
            }
        }
        if (bl2 && this.style.focused != null) {
            return this.style.focused;
        }
        return this.style.up;
    }

    @Override
    public void draw(Batch batch, float f2) {
        Stage stage;
        int n2;
        this.validate();
        this.setBackground(this.getBackgroundDrawable());
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (this.isPressed() && !this.isDisabled()) {
            f3 = this.style.pressedOffsetX;
            f4 = this.style.pressedOffsetY;
        } else if (this.isChecked() && !this.isDisabled()) {
            f3 = this.style.checkedOffsetX;
            f4 = this.style.checkedOffsetY;
        } else {
            f3 = this.style.unpressedOffsetX;
            f4 = this.style.unpressedOffsetY;
        }
        boolean bl2 = f3 != 0.0f || f4 != 0.0f;
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        if (bl2) {
            for (n2 = 0; n2 < snapshotArray.size; ++n2) {
                ((Actor)snapshotArray.get(n2)).moveBy(f3, f4);
            }
        }
        super.draw(batch, f2);
        if (bl2) {
            for (n2 = 0; n2 < snapshotArray.size; ++n2) {
                ((Actor)snapshotArray.get(n2)).moveBy(-f3, -f4);
            }
        }
        if ((stage = this.getStage()) != null && stage.getActionsRequestRendering() && this.isPressed() != this.clickListener.isPressed()) {
            Gdx.graphics.requestRendering();
        }
    }

    @Override
    public float getPrefWidth() {
        float f2 = super.getPrefWidth();
        if (this.style.up != null) {
            f2 = Math.max(f2, this.style.up.getMinWidth());
        }
        if (this.style.down != null) {
            f2 = Math.max(f2, this.style.down.getMinWidth());
        }
        if (this.style.checked != null) {
            f2 = Math.max(f2, this.style.checked.getMinWidth());
        }
        return f2;
    }

    @Override
    public float getPrefHeight() {
        float f2 = super.getPrefHeight();
        if (this.style.up != null) {
            f2 = Math.max(f2, this.style.up.getMinHeight());
        }
        if (this.style.down != null) {
            f2 = Math.max(f2, this.style.down.getMinHeight());
        }
        if (this.style.checked != null) {
            f2 = Math.max(f2, this.style.checked.getMinHeight());
        }
        return f2;
    }

    @Override
    public float getMinWidth() {
        return this.getPrefWidth();
    }

    @Override
    public float getMinHeight() {
        return this.getPrefHeight();
    }

    public static class ButtonStyle {
        @Null
        public Drawable up;
        @Null
        public Drawable down;
        @Null
        public Drawable over;
        @Null
        public Drawable focused;
        @Null
        public Drawable disabled;
        @Null
        public Drawable checked;
        @Null
        public Drawable checkedOver;
        @Null
        public Drawable checkedDown;
        @Null
        public Drawable checkedFocused;
        public float pressedOffsetX;
        public float pressedOffsetY;
        public float unpressedOffsetX;
        public float unpressedOffsetY;
        public float checkedOffsetX;
        public float checkedOffsetY;

        public ButtonStyle() {
        }

        public ButtonStyle(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3) {
            this.up = drawable;
            this.down = drawable2;
            this.checked = drawable3;
        }

        public ButtonStyle(ButtonStyle buttonStyle) {
            this.up = buttonStyle.up;
            this.down = buttonStyle.down;
            this.over = buttonStyle.over;
            this.focused = buttonStyle.focused;
            this.disabled = buttonStyle.disabled;
            this.checked = buttonStyle.checked;
            this.checkedOver = buttonStyle.checkedOver;
            this.checkedDown = buttonStyle.checkedDown;
            this.checkedFocused = buttonStyle.checkedFocused;
            this.pressedOffsetX = buttonStyle.pressedOffsetX;
            this.pressedOffsetY = buttonStyle.pressedOffsetY;
            this.unpressedOffsetX = buttonStyle.unpressedOffsetX;
            this.unpressedOffsetY = buttonStyle.unpressedOffsetY;
            this.checkedOffsetX = buttonStyle.checkedOffsetX;
            this.checkedOffsetY = buttonStyle.checkedOffsetY;
        }
    }
}

