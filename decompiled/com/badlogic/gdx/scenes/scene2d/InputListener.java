/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Null;

public class InputListener
implements EventListener {
    private static final Vector2 tmpCoords = new Vector2();

    @Override
    public boolean handle(Event event) {
        if (!(event instanceof InputEvent)) {
            return false;
        }
        InputEvent inputEvent = (InputEvent)event;
        switch (inputEvent.getType()) {
            case keyDown: {
                return this.keyDown(inputEvent, inputEvent.getKeyCode());
            }
            case keyUp: {
                return this.keyUp(inputEvent, inputEvent.getKeyCode());
            }
            case keyTyped: {
                return this.keyTyped(inputEvent, inputEvent.getCharacter());
            }
        }
        inputEvent.toCoordinates(inputEvent.getListenerActor(), tmpCoords);
        switch (inputEvent.getType()) {
            case touchDown: {
                boolean bl2 = this.touchDown(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y, inputEvent.getPointer(), inputEvent.getButton());
                if (bl2 && inputEvent.getTouchFocus()) {
                    inputEvent.getStage().addTouchFocus(this, inputEvent.getListenerActor(), inputEvent.getTarget(), inputEvent.getPointer(), inputEvent.getButton());
                }
                return bl2;
            }
            case touchUp: {
                this.touchUp(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y, inputEvent.getPointer(), inputEvent.getButton());
                return true;
            }
            case touchDragged: {
                this.touchDragged(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y, inputEvent.getPointer());
                return true;
            }
            case mouseMoved: {
                return this.mouseMoved(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y);
            }
            case scrolled: {
                return this.scrolled(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y, inputEvent.getScrollAmountX(), inputEvent.getScrollAmountY());
            }
            case enter: {
                this.enter(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y, inputEvent.getPointer(), inputEvent.getRelatedActor());
                return false;
            }
            case exit: {
                this.exit(inputEvent, InputListener.tmpCoords.x, InputListener.tmpCoords.y, inputEvent.getPointer(), inputEvent.getRelatedActor());
                return false;
            }
        }
        return false;
    }

    public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
        return false;
    }

    public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
    }

    public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
    }

    public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
        return false;
    }

    public void enter(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
    }

    public void exit(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
    }

    public boolean scrolled(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
        return false;
    }

    public boolean keyDown(InputEvent inputEvent, int n2) {
        return false;
    }

    public boolean keyUp(InputEvent inputEvent, int n2) {
        return false;
    }

    public boolean keyTyped(InputEvent inputEvent, char c2) {
        return false;
    }
}

