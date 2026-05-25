/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.IntSet;

public abstract class AbstractInput
implements Input {
    protected final boolean[] pressedKeys;
    protected final boolean[] justPressedKeys;
    private final IntSet keysToCatch = new IntSet();
    protected int pressedKeyCount;
    protected boolean keyJustPressed;

    public AbstractInput() {
        this.pressedKeys = new boolean[256];
        this.justPressedKeys = new boolean[256];
    }

    @Override
    public boolean isKeyPressed(int n2) {
        if (n2 == -1) {
            return this.pressedKeyCount > 0;
        }
        if (n2 < 0 || n2 > 255) {
            return false;
        }
        return this.pressedKeys[n2];
    }

    @Override
    public boolean isKeyJustPressed(int n2) {
        if (n2 == -1) {
            return this.keyJustPressed;
        }
        if (n2 < 0 || n2 > 255) {
            return false;
        }
        return this.justPressedKeys[n2];
    }

    @Override
    public boolean isCatchBackKey() {
        return this.keysToCatch.contains(4);
    }

    @Override
    public void setCatchBackKey(boolean bl2) {
        this.setCatchKey(4, bl2);
    }

    @Override
    public boolean isCatchMenuKey() {
        return this.keysToCatch.contains(82);
    }

    @Override
    public void setCatchMenuKey(boolean bl2) {
        this.setCatchKey(82, bl2);
    }

    @Override
    public void setCatchKey(int n2, boolean bl2) {
        if (!bl2) {
            this.keysToCatch.remove(n2);
        } else {
            this.keysToCatch.add(n2);
        }
    }

    @Override
    public boolean isCatchKey(int n2) {
        return this.keysToCatch.contains(n2);
    }
}

