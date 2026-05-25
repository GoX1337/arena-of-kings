/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.DelegateAction;
import com.badlogic.gdx.utils.Array;

public class AfterAction
extends DelegateAction {
    private Array<Action> waitForActions = new Array(false, 4);

    @Override
    public void setTarget(Actor actor) {
        if (actor != null) {
            this.waitForActions.addAll(actor.getActions());
        }
        super.setTarget(actor);
    }

    @Override
    public void restart() {
        super.restart();
        this.waitForActions.clear();
    }

    @Override
    protected boolean delegate(float f2) {
        Array<Action> array = this.target.getActions();
        if (array.size == 1) {
            this.waitForActions.clear();
        }
        for (int i2 = this.waitForActions.size - 1; i2 >= 0; --i2) {
            Action action = this.waitForActions.get(i2);
            int n2 = array.indexOf(action, true);
            if (n2 != -1) continue;
            this.waitForActions.removeIndex(i2);
        }
        if (this.waitForActions.size > 0) {
            return false;
        }
        return this.action.act(f2);
    }
}

