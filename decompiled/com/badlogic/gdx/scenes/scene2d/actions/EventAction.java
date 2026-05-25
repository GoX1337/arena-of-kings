/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public abstract class EventAction<T extends Event>
extends Action {
    final Class<? extends T> eventClass;
    boolean result;
    boolean active;
    private final EventListener listener = new EventListener(){

        @Override
        public boolean handle(Event event) {
            if (!EventAction.this.active || !ClassReflection.isInstance(EventAction.this.eventClass, event)) {
                return false;
            }
            EventAction.this.result = EventAction.this.handle(event);
            return EventAction.this.result;
        }
    };

    public EventAction(Class<? extends T> clazz) {
        this.eventClass = clazz;
    }

    @Override
    public void restart() {
        this.result = false;
        this.active = false;
    }

    @Override
    public void setTarget(Actor actor) {
        if (this.target != null) {
            this.target.removeListener(this.listener);
        }
        super.setTarget(actor);
        if (actor != null) {
            actor.addListener(this.listener);
        }
    }

    public abstract boolean handle(T var1);

    @Override
    public boolean act(float f2) {
        this.active = true;
        return this.result;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean bl2) {
        this.active = bl2;
    }
}

