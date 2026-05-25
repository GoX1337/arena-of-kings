/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ParallelAction
extends Action {
    Array<Action> actions = new Array(4);
    private boolean complete;

    public ParallelAction() {
    }

    public ParallelAction(Action action) {
        this.addAction(action);
    }

    public ParallelAction(Action action, Action action2) {
        this.addAction(action);
        this.addAction(action2);
    }

    public ParallelAction(Action action, Action action2, Action action3) {
        this.addAction(action);
        this.addAction(action2);
        this.addAction(action3);
    }

    public ParallelAction(Action action, Action action2, Action action3, Action action4) {
        this.addAction(action);
        this.addAction(action2);
        this.addAction(action3);
        this.addAction(action4);
    }

    public ParallelAction(Action action, Action action2, Action action3, Action action4, Action action5) {
        this.addAction(action);
        this.addAction(action2);
        this.addAction(action3);
        this.addAction(action4);
        this.addAction(action5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean act(float f2) {
        if (this.complete) {
            return true;
        }
        this.complete = true;
        Pool pool = this.getPool();
        this.setPool(null);
        try {
            int n2;
            Array<Action> array = this.actions;
            int n3 = array.size;
            for (n2 = 0; n2 < n3 && this.actor != null; ++n2) {
                Action action = array.get(n2);
                if (action.getActor() != null && !action.act(f2)) {
                    this.complete = false;
                }
                if (this.actor != null) continue;
                boolean bl2 = true;
                return bl2;
            }
            n2 = this.complete ? 1 : 0;
            return n2 != 0;
        }
        finally {
            this.setPool(pool);
        }
    }

    @Override
    public void restart() {
        this.complete = false;
        Array<Action> array = this.actions;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            array.get(i2).restart();
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.actions.clear();
    }

    public void addAction(Action action) {
        this.actions.add(action);
        if (this.actor != null) {
            action.setActor(this.actor);
        }
    }

    @Override
    public void setActor(Actor actor) {
        Array<Action> array = this.actions;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            array.get(i2).setActor(actor);
        }
        super.setActor(actor);
    }

    public Array<Action> getActions() {
        return this.actions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(super.toString());
        stringBuilder.append('(');
        Array<Action> array = this.actions;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(array.get(i2));
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

