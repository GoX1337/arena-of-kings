/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.utils.Null;

public class InputEvent
extends Event {
    private Type type;
    private float stageX;
    private float stageY;
    private float scrollAmountX;
    private float scrollAmountY;
    private int pointer;
    private int button;
    private int keyCode;
    private char character;
    @Null
    private Actor relatedActor;
    private boolean touchFocus = true;

    @Override
    public void reset() {
        super.reset();
        this.relatedActor = null;
        this.button = -1;
    }

    public float getStageX() {
        return this.stageX;
    }

    public void setStageX(float f2) {
        this.stageX = f2;
    }

    public float getStageY() {
        return this.stageY;
    }

    public void setStageY(float f2) {
        this.stageY = f2;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setPointer(int n2) {
        this.pointer = n2;
    }

    public int getButton() {
        return this.button;
    }

    public void setButton(int n2) {
        this.button = n2;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public void setKeyCode(int n2) {
        this.keyCode = n2;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setCharacter(char c2) {
        this.character = c2;
    }

    public float getScrollAmountX() {
        return this.scrollAmountX;
    }

    public float getScrollAmountY() {
        return this.scrollAmountY;
    }

    public void setScrollAmountX(float f2) {
        this.scrollAmountX = f2;
    }

    public void setScrollAmountY(float f2) {
        this.scrollAmountY = f2;
    }

    @Null
    public Actor getRelatedActor() {
        return this.relatedActor;
    }

    public void setRelatedActor(@Null Actor actor) {
        this.relatedActor = actor;
    }

    public Vector2 toCoordinates(Actor actor, Vector2 vector2) {
        vector2.set(this.stageX, this.stageY);
        actor.stageToLocalCoordinates(vector2);
        return vector2;
    }

    public boolean isTouchFocusCancel() {
        return this.stageX == -2.1474836E9f || this.stageY == -2.1474836E9f;
    }

    public boolean getTouchFocus() {
        return this.touchFocus;
    }

    public void setTouchFocus(boolean bl2) {
        this.touchFocus = bl2;
    }

    public String toString() {
        return this.type.toString();
    }

    public static enum Type {
        touchDown,
        touchUp,
        touchDragged,
        mouseMoved,
        enter,
        exit,
        scrolled,
        keyDown,
        keyUp,
        keyTyped;

    }
}

