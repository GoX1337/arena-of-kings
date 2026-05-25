/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.InputProcessor;

public class InputAdapter
implements InputProcessor {
    @Override
    public boolean keyDown(int n2) {
        return false;
    }

    @Override
    public boolean keyUp(int n2) {
        return false;
    }

    @Override
    public boolean keyTyped(char c2) {
        return false;
    }

    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        return false;
    }

    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        return false;
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        return false;
    }

    @Override
    public boolean mouseMoved(int n2, int n3) {
        return false;
    }

    @Override
    public boolean scrolled(float f2, float f3) {
        return false;
    }
}

