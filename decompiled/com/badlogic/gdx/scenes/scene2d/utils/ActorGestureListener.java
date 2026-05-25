/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Null;

public class ActorGestureListener
implements EventListener {
    static final Vector2 tmpCoords = new Vector2();
    static final Vector2 tmpCoords2 = new Vector2();
    private final GestureDetector detector;
    InputEvent event;
    Actor actor;
    Actor touchDownTarget;

    public ActorGestureListener() {
        this(20.0f, 0.4f, 1.1f, 2.1474836E9f);
    }

    public ActorGestureListener(float f2, float f3, float f4, float f5) {
        this.detector = new GestureDetector(f2, f3, f4, f5, new GestureDetector.GestureAdapter(){
            private final Vector2 initialPointer1 = new Vector2();
            private final Vector2 initialPointer2 = new Vector2();
            private final Vector2 pointer1 = new Vector2();
            private final Vector2 pointer2 = new Vector2();

            @Override
            public boolean tap(float f2, float f3, int n2, int n3) {
                ActorGestureListener.this.actor.stageToLocalCoordinates(tmpCoords.set(f2, f3));
                ActorGestureListener.this.tap(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, n2, n3);
                return true;
            }

            @Override
            public boolean longPress(float f2, float f3) {
                ActorGestureListener.this.actor.stageToLocalCoordinates(tmpCoords.set(f2, f3));
                return ActorGestureListener.this.longPress(ActorGestureListener.this.actor, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y);
            }

            @Override
            public boolean fling(float f2, float f3, int n2) {
                this.stageToLocalAmount(tmpCoords.set(f2, f3));
                ActorGestureListener.this.fling(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, n2);
                return true;
            }

            @Override
            public boolean pan(float f2, float f3, float f4, float f5) {
                this.stageToLocalAmount(tmpCoords.set(f4, f5));
                f4 = ActorGestureListener.tmpCoords.x;
                f5 = ActorGestureListener.tmpCoords.y;
                ActorGestureListener.this.actor.stageToLocalCoordinates(tmpCoords.set(f2, f3));
                ActorGestureListener.this.pan(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, f4, f5);
                return true;
            }

            @Override
            public boolean panStop(float f2, float f3, int n2, int n3) {
                ActorGestureListener.this.actor.stageToLocalCoordinates(tmpCoords.set(f2, f3));
                ActorGestureListener.this.panStop(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, n2, n3);
                return true;
            }

            @Override
            public boolean zoom(float f2, float f3) {
                ActorGestureListener.this.zoom(ActorGestureListener.this.event, f2, f3);
                return true;
            }

            @Override
            public boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
                ActorGestureListener.this.actor.stageToLocalCoordinates(this.initialPointer1.set(vector2));
                ActorGestureListener.this.actor.stageToLocalCoordinates(this.initialPointer2.set(vector22));
                ActorGestureListener.this.actor.stageToLocalCoordinates(this.pointer1.set(vector23));
                ActorGestureListener.this.actor.stageToLocalCoordinates(this.pointer2.set(vector24));
                ActorGestureListener.this.pinch(ActorGestureListener.this.event, this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
                return true;
            }

            private void stageToLocalAmount(Vector2 vector2) {
                ActorGestureListener.this.actor.stageToLocalCoordinates(vector2);
                vector2.sub(ActorGestureListener.this.actor.stageToLocalCoordinates(tmpCoords2.set(0.0f, 0.0f)));
            }
        });
    }

    @Override
    public boolean handle(Event event) {
        if (!(event instanceof InputEvent)) {
            return false;
        }
        InputEvent inputEvent = (InputEvent)event;
        switch (inputEvent.getType()) {
            case touchDown: {
                this.actor = inputEvent.getListenerActor();
                this.touchDownTarget = inputEvent.getTarget();
                this.detector.touchDown(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer(), inputEvent.getButton());
                this.actor.stageToLocalCoordinates(tmpCoords.set(inputEvent.getStageX(), inputEvent.getStageY()));
                this.touchDown(inputEvent, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, inputEvent.getPointer(), inputEvent.getButton());
                if (inputEvent.getTouchFocus()) {
                    inputEvent.getStage().addTouchFocus(this, inputEvent.getListenerActor(), inputEvent.getTarget(), inputEvent.getPointer(), inputEvent.getButton());
                }
                return true;
            }
            case touchUp: {
                if (inputEvent.isTouchFocusCancel()) {
                    this.detector.reset();
                    return false;
                }
                this.event = inputEvent;
                this.actor = inputEvent.getListenerActor();
                this.detector.touchUp(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer(), inputEvent.getButton());
                this.actor.stageToLocalCoordinates(tmpCoords.set(inputEvent.getStageX(), inputEvent.getStageY()));
                this.touchUp(inputEvent, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, inputEvent.getPointer(), inputEvent.getButton());
                return true;
            }
            case touchDragged: {
                this.event = inputEvent;
                this.actor = inputEvent.getListenerActor();
                this.detector.touchDragged(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer());
                return true;
            }
        }
        return false;
    }

    public void touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
    }

    public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
    }

    public void tap(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
    }

    public boolean longPress(Actor actor, float f2, float f3) {
        return false;
    }

    public void fling(InputEvent inputEvent, float f2, float f3, int n2) {
    }

    public void pan(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
    }

    public void panStop(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
    }

    public void zoom(InputEvent inputEvent, float f2, float f3) {
    }

    public void pinch(InputEvent inputEvent, Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
    }

    public GestureDetector getGestureDetector() {
        return this.detector;
    }

    @Null
    public Actor getTouchDownTarget() {
        return this.touchDownTarget;
    }
}

