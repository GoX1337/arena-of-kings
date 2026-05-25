/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Pools;
import java.util.Iterator;

public class Selection<T>
implements Disableable,
Iterable<T> {
    @Null
    private Actor actor;
    final OrderedSet<T> selected = new OrderedSet();
    private final OrderedSet<T> old = new OrderedSet();
    boolean isDisabled;
    private boolean toggle;
    boolean multiple;
    boolean required;
    private boolean programmaticChangeEvents = true;
    @Null
    T lastSelected;

    public void setActor(@Null Actor actor) {
        this.actor = actor;
    }

    public void choose(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("item cannot be null.");
        }
        if (this.isDisabled) {
            return;
        }
        this.snapshot();
        try {
            if ((this.toggle || UIUtils.ctrl()) && this.selected.contains(t2)) {
                if (this.required && this.selected.size == 1) {
                    return;
                }
                this.selected.remove(t2);
                this.lastSelected = null;
            } else {
                boolean bl2 = false;
                if (!this.multiple || !this.toggle && !UIUtils.ctrl()) {
                    if (this.selected.size == 1 && this.selected.contains(t2)) {
                        return;
                    }
                    bl2 = this.selected.size > 0;
                    this.selected.clear(8);
                }
                if (!this.selected.add(t2) && !bl2) {
                    return;
                }
                this.lastSelected = t2;
            }
            if (this.fireChangeEvent()) {
                this.revert();
            } else {
                this.changed();
            }
        }
        finally {
            this.cleanup();
        }
    }

    @Deprecated
    public boolean hasItems() {
        return this.selected.size > 0;
    }

    public boolean notEmpty() {
        return this.selected.size > 0;
    }

    public boolean isEmpty() {
        return this.selected.size == 0;
    }

    public int size() {
        return this.selected.size;
    }

    public OrderedSet<T> items() {
        return this.selected;
    }

    @Null
    public T first() {
        return this.selected.size == 0 ? null : (T)this.selected.first();
    }

    void snapshot() {
        this.old.clear(this.selected.size);
        this.old.addAll(this.selected);
    }

    void revert() {
        this.selected.clear(this.old.size);
        this.selected.addAll(this.old);
    }

    void cleanup() {
        this.old.clear(32);
    }

    public void set(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("item cannot be null.");
        }
        if (this.selected.size == 1 && this.selected.first() == t2) {
            return;
        }
        this.snapshot();
        this.selected.clear(8);
        this.selected.add(t2);
        if (this.programmaticChangeEvents && this.fireChangeEvent()) {
            this.revert();
        } else {
            this.lastSelected = t2;
            this.changed();
        }
        this.cleanup();
    }

    public void setAll(Array<T> array) {
        boolean bl2 = false;
        this.snapshot();
        this.lastSelected = null;
        this.selected.clear(array.size);
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = array.get(i2);
            if (t2 == null) {
                throw new IllegalArgumentException("item cannot be null.");
            }
            if (!this.selected.add(t2)) continue;
            bl2 = true;
        }
        if (bl2) {
            if (this.programmaticChangeEvents && this.fireChangeEvent()) {
                this.revert();
            } else if (array.size > 0) {
                this.lastSelected = array.peek();
                this.changed();
            }
        }
        this.cleanup();
    }

    public void add(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("item cannot be null.");
        }
        if (!this.selected.add(t2)) {
            return;
        }
        if (this.programmaticChangeEvents && this.fireChangeEvent()) {
            this.selected.remove(t2);
        } else {
            this.lastSelected = t2;
            this.changed();
        }
    }

    public void addAll(Array<T> array) {
        boolean bl2 = false;
        this.snapshot();
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = array.get(i2);
            if (t2 == null) {
                throw new IllegalArgumentException("item cannot be null.");
            }
            if (!this.selected.add(t2)) continue;
            bl2 = true;
        }
        if (bl2) {
            if (this.programmaticChangeEvents && this.fireChangeEvent()) {
                this.revert();
            } else {
                this.lastSelected = array.peek();
                this.changed();
            }
        }
        this.cleanup();
    }

    public void remove(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("item cannot be null.");
        }
        if (!this.selected.remove(t2)) {
            return;
        }
        if (this.programmaticChangeEvents && this.fireChangeEvent()) {
            this.selected.add(t2);
        } else {
            this.lastSelected = null;
            this.changed();
        }
    }

    public void removeAll(Array<T> array) {
        boolean bl2 = false;
        this.snapshot();
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = array.get(i2);
            if (t2 == null) {
                throw new IllegalArgumentException("item cannot be null.");
            }
            if (!this.selected.remove(t2)) continue;
            bl2 = true;
        }
        if (bl2) {
            if (this.programmaticChangeEvents && this.fireChangeEvent()) {
                this.revert();
            } else {
                this.lastSelected = null;
                this.changed();
            }
        }
        this.cleanup();
    }

    public void clear() {
        if (this.selected.size == 0) {
            this.lastSelected = null;
            return;
        }
        this.snapshot();
        this.selected.clear(8);
        if (this.programmaticChangeEvents && this.fireChangeEvent()) {
            this.revert();
        } else {
            this.lastSelected = null;
            this.changed();
        }
        this.cleanup();
    }

    protected void changed() {
    }

    public boolean fireChangeEvent() {
        if (this.actor == null) {
            return false;
        }
        ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
        try {
            boolean bl2 = this.actor.fire(changeEvent);
            return bl2;
        }
        finally {
            Pools.free(changeEvent);
        }
    }

    public boolean contains(@Null T t2) {
        if (t2 == null) {
            return false;
        }
        return this.selected.contains(t2);
    }

    @Null
    public T getLastSelected() {
        if (this.lastSelected != null) {
            return this.lastSelected;
        }
        if (this.selected.size > 0) {
            return this.selected.first();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return this.selected.iterator();
    }

    public Array<T> toArray() {
        return ((OrderedSet.OrderedSetIterator)this.selected.iterator()).toArray();
    }

    public Array<T> toArray(Array<T> array) {
        return ((OrderedSet.OrderedSetIterator)this.selected.iterator()).toArray(array);
    }

    @Override
    public void setDisabled(boolean bl2) {
        this.isDisabled = bl2;
    }

    @Override
    public boolean isDisabled() {
        return this.isDisabled;
    }

    public boolean getToggle() {
        return this.toggle;
    }

    public void setToggle(boolean bl2) {
        this.toggle = bl2;
    }

    public boolean getMultiple() {
        return this.multiple;
    }

    public void setMultiple(boolean bl2) {
        this.multiple = bl2;
    }

    public boolean getRequired() {
        return this.required;
    }

    public void setRequired(boolean bl2) {
        this.required = bl2;
    }

    public void setProgrammaticChangeEvents(boolean bl2) {
        this.programmaticChangeEvents = bl2;
    }

    public String toString() {
        return this.selected.toString();
    }
}

