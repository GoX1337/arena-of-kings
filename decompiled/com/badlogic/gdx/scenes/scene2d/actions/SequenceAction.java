/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.utils.Pool;

public class SequenceAction
extends ParallelAction {
    private int index;

    public SequenceAction() {
    }

    public SequenceAction(Action action) {
        this.addAction(action);
    }

    public SequenceAction(Action action, Action action2) {
        this.addAction(action);
        this.addAction(action2);
    }

    public SequenceAction(Action action, Action action2, Action action3) {
        this.addAction(action);
        this.addAction(action2);
        this.addAction(action3);
    }

    public SequenceAction(Action action, Action action2, Action action3, Action action4) {
        this.addAction(action);
        this.addAction(action2);
        this.addAction(action3);
        this.addAction(action4);
    }

    public SequenceAction(Action action, Action action2, Action action3, Action action4, Action action5) {
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
        if (this.index >= this.actions.size) {
            return true;
        }
        Pool pool = this.getPool();
        this.setPool(null);
        try {
            if (((Action)this.actions.get(this.index)).act(f2)) {
                if (this.actor == null) {
                    boolean bl2 = true;
                    return bl2;
                }
                ++this.index;
                if (this.index >= this.actions.size) {
                    boolean bl3 = true;
                    return bl3;
                }
            }
            boolean bl4 = false;
            return bl4;
        }
        finally {
            this.setPool(pool);
        }
    }

    @Override
    public void restart() {
        super.restart();
        this.index = 0;
    }
}

