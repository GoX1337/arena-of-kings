/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;

public class DragAndDrop {
    static final Vector2 tmpVector = new Vector2();
    Source dragSource;
    Payload payload;
    Actor dragActor;
    boolean removeDragActor;
    Target target;
    boolean isValidTarget;
    final Array<Target> targets = new Array(8);
    final ObjectMap<Source, DragListener> sourceListeners = new ObjectMap(8);
    private float tapSquareSize = 8.0f;
    private int button;
    float dragActorX = 0.0f;
    float dragActorY = 0.0f;
    float touchOffsetX;
    float touchOffsetY;
    long dragValidTime;
    int dragTime = 250;
    int activePointer = -1;
    boolean cancelTouchFocus = true;
    boolean keepWithinStage = true;

    public void addSource(final Source source) {
        DragListener dragListener = new DragListener(){

            @Override
            public void dragStart(InputEvent inputEvent, float f2, float f3, int n2) {
                Stage stage;
                if (DragAndDrop.this.activePointer != -1) {
                    inputEvent.stop();
                    return;
                }
                DragAndDrop.this.activePointer = n2;
                DragAndDrop.this.dragValidTime = System.currentTimeMillis() + (long)DragAndDrop.this.dragTime;
                DragAndDrop.this.dragSource = source;
                DragAndDrop.this.payload = source.dragStart(inputEvent, this.getTouchDownX(), this.getTouchDownY(), n2);
                inputEvent.stop();
                if (DragAndDrop.this.cancelTouchFocus && DragAndDrop.this.payload != null && (stage = source.getActor().getStage()) != null) {
                    stage.cancelTouchFocusExcept(this, source.getActor());
                }
            }

            @Override
            public void drag(InputEvent inputEvent, float f2, float f3, int n2) {
                if (DragAndDrop.this.payload == null) {
                    return;
                }
                if (n2 != DragAndDrop.this.activePointer) {
                    return;
                }
                source.drag(inputEvent, f2, f3, n2);
                Stage stage = inputEvent.getStage();
                Actor actor = DragAndDrop.this.dragActor;
                float f4 = 0.0f;
                float f5 = 0.0f;
                if (actor != null) {
                    f4 = actor.getX();
                    f5 = actor.getY();
                    actor.setPosition(2.1474836E9f, 2.1474836E9f);
                }
                float f6 = inputEvent.getStageX() + DragAndDrop.this.touchOffsetX;
                float f7 = inputEvent.getStageY() + DragAndDrop.this.touchOffsetY;
                Actor actor2 = inputEvent.getStage().hit(f6, f7, true);
                if (actor2 == null) {
                    actor2 = inputEvent.getStage().hit(f6, f7, false);
                }
                if (actor != null) {
                    actor.setPosition(f4, f5);
                }
                Target target = null;
                DragAndDrop.this.isValidTarget = false;
                if (actor2 != null) {
                    int n3 = DragAndDrop.this.targets.size;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        Target target2 = DragAndDrop.this.targets.get(i2);
                        if (!target2.actor.isAscendantOf(actor2)) continue;
                        target = target2;
                        target2.actor.stageToLocalCoordinates(tmpVector.set(f6, f7));
                        break;
                    }
                }
                if (target != DragAndDrop.this.target) {
                    if (DragAndDrop.this.target != null) {
                        DragAndDrop.this.target.reset(source, DragAndDrop.this.payload);
                    }
                    DragAndDrop.this.target = target;
                }
                if (target != null) {
                    DragAndDrop.this.isValidTarget = target.drag(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, n2);
                }
                Actor actor3 = null;
                if (DragAndDrop.this.target != null) {
                    Actor actor4 = actor3 = DragAndDrop.this.isValidTarget ? DragAndDrop.this.payload.validDragActor : DragAndDrop.this.payload.invalidDragActor;
                }
                if (actor3 == null) {
                    actor3 = DragAndDrop.this.payload.dragActor;
                }
                if (actor3 != actor) {
                    if (actor != null && DragAndDrop.this.removeDragActor) {
                        actor.remove();
                    }
                    DragAndDrop.this.dragActor = actor3;
                    boolean bl2 = DragAndDrop.this.removeDragActor = actor3.getStage() == null;
                    if (DragAndDrop.this.removeDragActor) {
                        stage.addActor(actor3);
                    }
                }
                if (actor3 == null) {
                    return;
                }
                float f8 = inputEvent.getStageX() - actor3.getWidth() + DragAndDrop.this.dragActorX;
                float f9 = inputEvent.getStageY() + DragAndDrop.this.dragActorY;
                if (DragAndDrop.this.keepWithinStage) {
                    if (f8 < 0.0f) {
                        f8 = 0.0f;
                    }
                    if (f9 < 0.0f) {
                        f9 = 0.0f;
                    }
                    if (f8 + actor3.getWidth() > stage.getWidth()) {
                        f8 = stage.getWidth() - actor3.getWidth();
                    }
                    if (f9 + actor3.getHeight() > stage.getHeight()) {
                        f9 = stage.getHeight() - actor3.getHeight();
                    }
                }
                actor3.setPosition(f8, f9);
            }

            @Override
            public void dragStop(InputEvent inputEvent, float f2, float f3, int n2) {
                float f4;
                float f5;
                if (n2 != DragAndDrop.this.activePointer) {
                    return;
                }
                DragAndDrop.this.activePointer = -1;
                if (DragAndDrop.this.payload == null) {
                    return;
                }
                if (System.currentTimeMillis() < DragAndDrop.this.dragValidTime) {
                    DragAndDrop.this.isValidTarget = false;
                } else if (!DragAndDrop.this.isValidTarget && DragAndDrop.this.target != null) {
                    f5 = inputEvent.getStageX() + DragAndDrop.this.touchOffsetX;
                    f4 = inputEvent.getStageY() + DragAndDrop.this.touchOffsetY;
                    DragAndDrop.this.target.actor.stageToLocalCoordinates(tmpVector.set(f5, f4));
                    DragAndDrop.this.isValidTarget = DragAndDrop.this.target.drag(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, n2);
                }
                if (DragAndDrop.this.dragActor != null && DragAndDrop.this.removeDragActor) {
                    DragAndDrop.this.dragActor.remove();
                }
                if (DragAndDrop.this.isValidTarget) {
                    f5 = inputEvent.getStageX() + DragAndDrop.this.touchOffsetX;
                    f4 = inputEvent.getStageY() + DragAndDrop.this.touchOffsetY;
                    DragAndDrop.this.target.actor.stageToLocalCoordinates(tmpVector.set(f5, f4));
                    DragAndDrop.this.target.drop(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, n2);
                }
                source.dragStop(inputEvent, f2, f3, n2, DragAndDrop.this.payload, DragAndDrop.this.isValidTarget ? DragAndDrop.this.target : null);
                if (DragAndDrop.this.target != null) {
                    DragAndDrop.this.target.reset(source, DragAndDrop.this.payload);
                }
                DragAndDrop.this.dragSource = null;
                DragAndDrop.this.payload = null;
                DragAndDrop.this.target = null;
                DragAndDrop.this.isValidTarget = false;
                DragAndDrop.this.dragActor = null;
            }
        };
        dragListener.setTapSquareSize(this.tapSquareSize);
        dragListener.setButton(this.button);
        source.actor.addCaptureListener(dragListener);
        this.sourceListeners.put(source, dragListener);
    }

    public void removeSource(Source source) {
        DragListener dragListener = this.sourceListeners.remove(source);
        source.actor.removeCaptureListener(dragListener);
    }

    public void addTarget(Target target) {
        this.targets.add(target);
    }

    public void removeTarget(Target target) {
        this.targets.removeValue(target, true);
    }

    public void clear() {
        this.targets.clear();
        for (ObjectMap.Entry entry : this.sourceListeners.entries()) {
            ((Source)entry.key).actor.removeCaptureListener((EventListener)entry.value);
        }
        this.sourceListeners.clear(8);
    }

    public void cancelTouchFocusExcept(Source source) {
        DragListener dragListener = this.sourceListeners.get(source);
        if (dragListener == null) {
            return;
        }
        Stage stage = source.getActor().getStage();
        if (stage != null) {
            stage.cancelTouchFocusExcept(dragListener, source.getActor());
        }
    }

    public void setTapSquareSize(float f2) {
        this.tapSquareSize = f2;
    }

    public void setButton(int n2) {
        this.button = n2;
    }

    public void setDragActorPosition(float f2, float f3) {
        this.dragActorX = f2;
        this.dragActorY = f3;
    }

    public void setTouchOffset(float f2, float f3) {
        this.touchOffsetX = f2;
        this.touchOffsetY = f3;
    }

    public boolean isDragging() {
        return this.payload != null;
    }

    @Null
    public Actor getDragActor() {
        return this.dragActor;
    }

    @Null
    public Payload getDragPayload() {
        return this.payload;
    }

    @Null
    public Source getDragSource() {
        return this.dragSource;
    }

    public void setDragTime(int n2) {
        this.dragTime = n2;
    }

    public int getDragTime() {
        return this.dragTime;
    }

    public boolean isDragValid() {
        return this.payload != null && System.currentTimeMillis() >= this.dragValidTime;
    }

    public void setCancelTouchFocus(boolean bl2) {
        this.cancelTouchFocus = bl2;
    }

    public void setKeepWithinStage(boolean bl2) {
        this.keepWithinStage = bl2;
    }

    public static class Payload {
        @Null
        Actor dragActor;
        @Null
        Actor validDragActor;
        @Null
        Actor invalidDragActor;
        @Null
        Object object;

        public void setDragActor(@Null Actor actor) {
            this.dragActor = actor;
        }

        @Null
        public Actor getDragActor() {
            return this.dragActor;
        }

        public void setValidDragActor(@Null Actor actor) {
            this.validDragActor = actor;
        }

        @Null
        public Actor getValidDragActor() {
            return this.validDragActor;
        }

        public void setInvalidDragActor(@Null Actor actor) {
            this.invalidDragActor = actor;
        }

        @Null
        public Actor getInvalidDragActor() {
            return this.invalidDragActor;
        }

        @Null
        public Object getObject() {
            return this.object;
        }

        public void setObject(@Null Object object) {
            this.object = object;
        }
    }

    public static abstract class Target {
        final Actor actor;

        public Target(Actor actor) {
            if (actor == null) {
                throw new IllegalArgumentException("actor cannot be null.");
            }
            this.actor = actor;
            Stage stage = actor.getStage();
            if (stage != null && actor == stage.getRoot()) {
                throw new IllegalArgumentException("The stage root cannot be a drag and drop target.");
            }
        }

        public abstract boolean drag(Source var1, Payload var2, float var3, float var4, int var5);

        public void reset(Source source, Payload payload) {
        }

        public abstract void drop(Source var1, Payload var2, float var3, float var4, int var5);

        public Actor getActor() {
            return this.actor;
        }
    }

    public static abstract class Source {
        final Actor actor;

        public Source(Actor actor) {
            if (actor == null) {
                throw new IllegalArgumentException("actor cannot be null.");
            }
            this.actor = actor;
        }

        @Null
        public abstract Payload dragStart(InputEvent var1, float var2, float var3, int var4);

        public void drag(InputEvent inputEvent, float f2, float f3, int n2) {
        }

        public void dragStop(InputEvent inputEvent, float f2, float f3, int n2, @Null Payload payload, @Null Target target) {
        }

        public Actor getActor() {
            return this.actor;
        }
    }
}

