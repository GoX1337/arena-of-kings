/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.actions.EventAction;

public class CountdownEventAction<T extends Event>
extends EventAction<T> {
    int count;
    int current;

    public CountdownEventAction(Class<? extends T> clazz, int n2) {
        super(clazz);
        this.count = n2;
    }

    @Override
    public boolean handle(T t2) {
        ++this.current;
        return this.current >= this.count;
    }
}

