/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;

public abstract class Action
implements Pool.Poolable {
    protected Actor actor;
    protected Actor target;
    @Null
    private Pool pool;

    public abstract boolean act(float var1);

    public void restart() {
    }

    public void setActor(Actor actor) {
        this.actor = actor;
        if (this.target == null) {
            this.setTarget(actor);
        }
        if (actor == null && this.pool != null) {
            this.pool.free(this);
            this.pool = null;
        }
    }

    public Actor getActor() {
        return this.actor;
    }

    public void setTarget(Actor actor) {
        this.target = actor;
    }

    public Actor getTarget() {
        return this.target;
    }

    @Override
    public void reset() {
        this.actor = null;
        this.target = null;
        this.pool = null;
        this.restart();
    }

    @Null
    public Pool getPool() {
        return this.pool;
    }

    public void setPool(@Null Pool pool) {
        this.pool = pool;
    }

    public String toString() {
        String string = this.getClass().getName();
        int n2 = string.lastIndexOf(46);
        if (n2 != -1) {
            string = string.substring(n2 + 1);
        }
        if (string.endsWith("Action")) {
            string = string.substring(0, string.length() - 6);
        }
        return string;
    }
}

