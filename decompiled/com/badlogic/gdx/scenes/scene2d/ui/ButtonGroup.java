/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;

public class ButtonGroup<T extends Button> {
    private final Array<T> buttons = new Array();
    private Array<T> checkedButtons = new Array(1);
    private int minCheckCount;
    private int maxCheckCount = 1;
    private boolean uncheckLast = true;
    private T lastChecked;

    public ButtonGroup() {
        this.minCheckCount = 1;
    }

    public ButtonGroup(T ... TArray) {
        this.minCheckCount = 0;
        this.add((T)TArray);
        this.minCheckCount = 1;
    }

    public void add(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("button cannot be null.");
        }
        ((Button)t2).buttonGroup = null;
        boolean bl2 = ((Button)t2).isChecked() || this.buttons.size < this.minCheckCount;
        ((Button)t2).setChecked(false);
        ((Button)t2).buttonGroup = this;
        this.buttons.add(t2);
        ((Button)t2).setChecked(bl2);
    }

    public void add(T ... TArray) {
        if (TArray == null) {
            throw new IllegalArgumentException("buttons cannot be null.");
        }
        int n2 = TArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.add(TArray[i2]);
        }
    }

    public void remove(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("button cannot be null.");
        }
        ((Button)t2).buttonGroup = null;
        this.buttons.removeValue(t2, true);
        this.checkedButtons.removeValue(t2, true);
    }

    public void remove(T ... TArray) {
        if (TArray == null) {
            throw new IllegalArgumentException("buttons cannot be null.");
        }
        int n2 = TArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.remove(TArray[i2]);
        }
    }

    public void clear() {
        this.buttons.clear();
        this.checkedButtons.clear();
    }

    public void setChecked(String string) {
        if (string == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        int n2 = this.buttons.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Button button = (Button)this.buttons.get(i2);
            if (!(button instanceof TextButton) || !string.contentEquals(((TextButton)button).getText())) continue;
            button.setChecked(true);
            return;
        }
    }

    protected boolean canCheck(T t2, boolean bl2) {
        if (((Button)t2).isChecked == bl2) {
            return false;
        }
        if (!bl2) {
            if (this.checkedButtons.size <= this.minCheckCount) {
                return false;
            }
            this.checkedButtons.removeValue(t2, true);
        } else {
            block8: {
                if (this.maxCheckCount != -1 && this.checkedButtons.size >= this.maxCheckCount) {
                    if (!this.uncheckLast) {
                        return false;
                    }
                    int n2 = 0;
                    do {
                        int n3 = this.minCheckCount;
                        this.minCheckCount = 0;
                        ((Button)this.lastChecked).setChecked(false);
                        this.minCheckCount = n3;
                        if (((Button)t2).isChecked == bl2) {
                            return false;
                        }
                        if (this.checkedButtons.size < this.maxCheckCount) break block8;
                    } while (n2++ <= 10);
                    return false;
                }
            }
            this.checkedButtons.add(t2);
            this.lastChecked = t2;
        }
        return true;
    }

    public void uncheckAll() {
        int n2 = this.minCheckCount;
        this.minCheckCount = 0;
        int n3 = this.buttons.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            Button button = (Button)this.buttons.get(i2);
            button.setChecked(false);
        }
        this.minCheckCount = n2;
    }

    @Null
    public T getChecked() {
        if (this.checkedButtons.size > 0) {
            return (T)((Button)this.checkedButtons.get(0));
        }
        return null;
    }

    public int getCheckedIndex() {
        if (this.checkedButtons.size > 0) {
            return this.buttons.indexOf(this.checkedButtons.get(0), true);
        }
        return -1;
    }

    public Array<T> getAllChecked() {
        return this.checkedButtons;
    }

    public Array<T> getButtons() {
        return this.buttons;
    }

    public void setMinCheckCount(int n2) {
        this.minCheckCount = n2;
    }

    public void setMaxCheckCount(int n2) {
        if (n2 == 0) {
            n2 = -1;
        }
        this.maxCheckCount = n2;
    }

    public void setUncheckLast(boolean bl2) {
        this.uncheckLast = bl2;
    }
}

