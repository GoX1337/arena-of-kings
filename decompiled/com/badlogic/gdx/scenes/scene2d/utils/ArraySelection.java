/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;

public class ArraySelection<T>
extends Selection<T> {
    private Array<T> array;
    private boolean rangeSelect = true;
    private T rangeStart;

    public ArraySelection(Array<T> array) {
        this.array = array;
    }

    @Override
    public void choose(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("item cannot be null.");
        }
        if (this.isDisabled) {
            return;
        }
        if (!this.rangeSelect || !this.multiple) {
            super.choose(t2);
            return;
        }
        if (this.selected.size > 0 && UIUtils.shift()) {
            int n2;
            int n3 = n2 = this.rangeStart == null ? -1 : this.array.indexOf(this.rangeStart, false);
            if (n2 != -1) {
                int n4;
                T t3 = this.rangeStart;
                this.snapshot();
                int n5 = n2;
                int n6 = this.array.indexOf(t2, false);
                if (n5 > n6) {
                    n4 = n6;
                    n6 = n5;
                    n5 = n4;
                }
                if (!UIUtils.ctrl()) {
                    this.selected.clear(8);
                }
                for (n4 = n5; n4 <= n6; ++n4) {
                    this.selected.add(this.array.get(n4));
                }
                if (this.fireChangeEvent()) {
                    this.revert();
                } else {
                    this.changed();
                }
                this.rangeStart = t3;
                this.cleanup();
                return;
            }
        }
        super.choose(t2);
        this.rangeStart = t2;
    }

    @Override
    protected void changed() {
        this.rangeStart = null;
    }

    public boolean getRangeSelect() {
        return this.rangeSelect;
    }

    public void setRangeSelect(boolean bl2) {
        this.rangeSelect = bl2;
    }

    public void validate() {
        Array array = this.array;
        if (array.size == 0) {
            this.clear();
            return;
        }
        boolean bl2 = false;
        ObjectSet.ObjectSetIterator objectSetIterator = this.items().iterator();
        while (objectSetIterator.hasNext()) {
            Object e2 = objectSetIterator.next();
            if (array.contains(e2, false)) continue;
            objectSetIterator.remove();
            bl2 = true;
        }
        if (this.required && this.selected.size == 0) {
            this.set(array.first());
        } else if (bl2) {
            this.changed();
        }
    }
}

