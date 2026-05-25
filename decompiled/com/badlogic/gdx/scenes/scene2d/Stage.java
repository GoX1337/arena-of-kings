/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Stage
extends InputAdapter
implements Disposable {
    static boolean debug;
    private Viewport viewport;
    private final Batch batch;
    private boolean ownsBatch;
    private Group root;
    private final Vector2 tempCoords = new Vector2();
    private final Actor[] pointerOverActors = new Actor[20];
    private final boolean[] pointerTouched = new boolean[20];
    private final int[] pointerScreenX = new int[20];
    private final int[] pointerScreenY = new int[20];
    private int mouseScreenX;
    private int mouseScreenY;
    @Null
    private Actor mouseOverActor;
    @Null
    private Actor keyboardFocus;
    @Null
    private Actor scrollFocus;
    final SnapshotArray<TouchFocus> touchFocuses = new SnapshotArray(true, 4, TouchFocus.class);
    private boolean actionsRequestRendering = true;
    private ShapeRenderer debugShapes;
    private boolean debugInvisible;
    private boolean debugAll;
    private boolean debugUnderMouse;
    private boolean debugParentUnderMouse;
    private Table.Debug debugTableUnderMouse = Table.Debug.none;
    private final Color debugColor = new Color(0.0f, 1.0f, 0.0f, 0.85f);

    public Stage() {
        this(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera()), new SpriteBatch());
        this.ownsBatch = true;
    }

    public Stage(Viewport viewport) {
        this(viewport, new SpriteBatch());
        this.ownsBatch = true;
    }

    public Stage(Viewport viewport, Batch batch) {
        if (viewport == null) {
            throw new IllegalArgumentException("viewport cannot be null.");
        }
        if (batch == null) {
            throw new IllegalArgumentException("batch cannot be null.");
        }
        this.viewport = viewport;
        this.batch = batch;
        this.root = new Group();
        this.root.setStage(this);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
    }

    public void draw() {
        Camera camera = this.viewport.getCamera();
        camera.update();
        if (!this.root.isVisible()) {
            return;
        }
        Batch batch = this.batch;
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        this.root.draw(batch, 1.0f);
        batch.end();
        if (debug) {
            this.drawDebug();
        }
    }

    private void drawDebug() {
        if (this.debugShapes == null) {
            this.debugShapes = new ShapeRenderer();
            this.debugShapes.setAutoShapeType(true);
        }
        if (this.debugUnderMouse || this.debugParentUnderMouse || this.debugTableUnderMouse != Table.Debug.none) {
            this.screenToStageCoordinates(this.tempCoords.set(Gdx.input.getX(), Gdx.input.getY()));
            Actor actor = this.hit(this.tempCoords.x, this.tempCoords.y, true);
            if (actor == null) {
                return;
            }
            if (this.debugParentUnderMouse && actor.parent != null) {
                actor = actor.parent;
            }
            if (this.debugTableUnderMouse == Table.Debug.none) {
                actor.setDebug(true);
            } else {
                while (actor != null && !(actor instanceof Table)) {
                    actor = actor.parent;
                }
                if (actor == null) {
                    return;
                }
                ((Table)actor).debug(this.debugTableUnderMouse);
            }
            if (this.debugAll && actor instanceof Group) {
                ((Group)actor).debugAll();
            }
            this.disableDebug(this.root, actor);
        } else if (this.debugAll) {
            this.root.debugAll();
        }
        Gdx.gl.glEnable(3042);
        this.debugShapes.setProjectionMatrix(this.viewport.getCamera().combined);
        this.debugShapes.begin();
        this.root.drawDebug(this.debugShapes);
        this.debugShapes.end();
        Gdx.gl.glDisable(3042);
    }

    private void disableDebug(Actor actor, Actor actor2) {
        if (actor == actor2) {
            return;
        }
        actor.setDebug(false);
        if (actor instanceof Group) {
            SnapshotArray<Actor> snapshotArray = ((Group)actor).children;
            int n2 = snapshotArray.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.disableDebug((Actor)snapshotArray.get(i2), actor2);
            }
        }
    }

    public void act() {
        this.act(Math.min(Gdx.graphics.getDeltaTime(), 0.033333335f));
    }

    public void act(float f2) {
        int n2 = this.pointerOverActors.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Actor actor = this.pointerOverActors[i2];
            if (!this.pointerTouched[i2]) {
                if (actor == null) continue;
                this.pointerOverActors[i2] = null;
                this.screenToStageCoordinates(this.tempCoords.set(this.pointerScreenX[i2], this.pointerScreenY[i2]));
                InputEvent inputEvent = Pools.obtain(InputEvent.class);
                inputEvent.setType(InputEvent.Type.exit);
                inputEvent.setStage(this);
                inputEvent.setStageX(this.tempCoords.x);
                inputEvent.setStageY(this.tempCoords.y);
                inputEvent.setRelatedActor(actor);
                inputEvent.setPointer(i2);
                actor.fire(inputEvent);
                Pools.free(inputEvent);
                continue;
            }
            this.pointerOverActors[i2] = this.fireEnterAndExit(actor, this.pointerScreenX[i2], this.pointerScreenY[i2], i2);
        }
        Application.ApplicationType applicationType = Gdx.app.getType();
        if (applicationType == Application.ApplicationType.Desktop || applicationType == Application.ApplicationType.Applet || applicationType == Application.ApplicationType.WebGL) {
            this.mouseOverActor = this.fireEnterAndExit(this.mouseOverActor, this.mouseScreenX, this.mouseScreenY, -1);
        }
        this.root.act(f2);
    }

    @Null
    private Actor fireEnterAndExit(@Null Actor actor, int n2, int n3, int n4) {
        InputEvent inputEvent;
        this.screenToStageCoordinates(this.tempCoords.set(n2, n3));
        Actor actor2 = this.hit(this.tempCoords.x, this.tempCoords.y, true);
        if (actor2 == actor) {
            return actor;
        }
        if (actor != null) {
            inputEvent = Pools.obtain(InputEvent.class);
            inputEvent.setStage(this);
            inputEvent.setStageX(this.tempCoords.x);
            inputEvent.setStageY(this.tempCoords.y);
            inputEvent.setPointer(n4);
            inputEvent.setType(InputEvent.Type.exit);
            inputEvent.setRelatedActor(actor2);
            actor.fire(inputEvent);
            Pools.free(inputEvent);
        }
        if (actor2 != null) {
            inputEvent = Pools.obtain(InputEvent.class);
            inputEvent.setStage(this);
            inputEvent.setStageX(this.tempCoords.x);
            inputEvent.setStageY(this.tempCoords.y);
            inputEvent.setPointer(n4);
            inputEvent.setType(InputEvent.Type.enter);
            inputEvent.setRelatedActor(actor);
            actor2.fire(inputEvent);
            Pools.free(inputEvent);
        }
        return actor2;
    }

    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        if (!this.isInsideViewport(n2, n3)) {
            return false;
        }
        this.pointerTouched[n4] = true;
        this.pointerScreenX[n4] = n2;
        this.pointerScreenY[n4] = n3;
        this.screenToStageCoordinates(this.tempCoords.set(n2, n3));
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setType(InputEvent.Type.touchDown);
        inputEvent.setStage(this);
        inputEvent.setStageX(this.tempCoords.x);
        inputEvent.setStageY(this.tempCoords.y);
        inputEvent.setPointer(n4);
        inputEvent.setButton(n5);
        Actor actor = this.hit(this.tempCoords.x, this.tempCoords.y, true);
        if (actor == null) {
            if (this.root.getTouchable() == Touchable.enabled) {
                this.root.fire(inputEvent);
            }
        } else {
            actor.fire(inputEvent);
        }
        boolean bl2 = inputEvent.isHandled();
        Pools.free(inputEvent);
        return bl2;
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        int n5;
        this.pointerScreenX[n4] = n2;
        this.pointerScreenY[n4] = n3;
        this.mouseScreenX = n2;
        this.mouseScreenY = n3;
        if (this.touchFocuses.size == 0) {
            return false;
        }
        this.screenToStageCoordinates(this.tempCoords.set(n2, n3));
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setType(InputEvent.Type.touchDragged);
        inputEvent.setStage(this);
        inputEvent.setStageX(this.tempCoords.x);
        inputEvent.setStageY(this.tempCoords.y);
        inputEvent.setPointer(n4);
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArray = snapshotArray.begin();
        int n6 = snapshotArray.size;
        for (n5 = 0; n5 < n6; ++n5) {
            TouchFocus touchFocus = touchFocusArray[n5];
            if (touchFocus.pointer != n4 || !snapshotArray.contains(touchFocus, true)) continue;
            inputEvent.setTarget(touchFocus.target);
            inputEvent.setListenerActor(touchFocus.listenerActor);
            if (!touchFocus.listener.handle(inputEvent)) continue;
            inputEvent.handle();
        }
        snapshotArray.end();
        n5 = inputEvent.isHandled() ? 1 : 0;
        Pools.free(inputEvent);
        return n5 != 0;
    }

    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        int n6;
        this.pointerTouched[n4] = false;
        this.pointerScreenX[n4] = n2;
        this.pointerScreenY[n4] = n3;
        if (this.touchFocuses.size == 0) {
            return false;
        }
        this.screenToStageCoordinates(this.tempCoords.set(n2, n3));
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setType(InputEvent.Type.touchUp);
        inputEvent.setStage(this);
        inputEvent.setStageX(this.tempCoords.x);
        inputEvent.setStageY(this.tempCoords.y);
        inputEvent.setPointer(n4);
        inputEvent.setButton(n5);
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArray = snapshotArray.begin();
        int n7 = snapshotArray.size;
        for (n6 = 0; n6 < n7; n6 += 1) {
            TouchFocus touchFocus = touchFocusArray[n6];
            if (touchFocus.pointer != n4 || touchFocus.button != n5 || !snapshotArray.removeValue(touchFocus, true)) continue;
            inputEvent.setTarget(touchFocus.target);
            inputEvent.setListenerActor(touchFocus.listenerActor);
            if (touchFocus.listener.handle(inputEvent)) {
                inputEvent.handle();
            }
            Pools.free(touchFocus);
        }
        snapshotArray.end();
        n6 = inputEvent.isHandled() ? 1 : 0;
        Pools.free(inputEvent);
        return n6 != 0;
    }

    @Override
    public boolean mouseMoved(int n2, int n3) {
        this.mouseScreenX = n2;
        this.mouseScreenY = n3;
        if (!this.isInsideViewport(n2, n3)) {
            return false;
        }
        this.screenToStageCoordinates(this.tempCoords.set(n2, n3));
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setStage(this);
        inputEvent.setType(InputEvent.Type.mouseMoved);
        inputEvent.setStageX(this.tempCoords.x);
        inputEvent.setStageY(this.tempCoords.y);
        Actor actor = this.hit(this.tempCoords.x, this.tempCoords.y, true);
        if (actor == null) {
            actor = this.root;
        }
        actor.fire(inputEvent);
        boolean bl2 = inputEvent.isHandled();
        Pools.free(inputEvent);
        return bl2;
    }

    @Override
    public boolean scrolled(float f2, float f3) {
        Actor actor = this.scrollFocus == null ? this.root : this.scrollFocus;
        this.screenToStageCoordinates(this.tempCoords.set(this.mouseScreenX, this.mouseScreenY));
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setStage(this);
        inputEvent.setType(InputEvent.Type.scrolled);
        inputEvent.setScrollAmountX(f2);
        inputEvent.setScrollAmountY(f3);
        inputEvent.setStageX(this.tempCoords.x);
        inputEvent.setStageY(this.tempCoords.y);
        actor.fire(inputEvent);
        boolean bl2 = inputEvent.isHandled();
        Pools.free(inputEvent);
        return bl2;
    }

    @Override
    public boolean keyDown(int n2) {
        Actor actor = this.keyboardFocus == null ? this.root : this.keyboardFocus;
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setStage(this);
        inputEvent.setType(InputEvent.Type.keyDown);
        inputEvent.setKeyCode(n2);
        actor.fire(inputEvent);
        boolean bl2 = inputEvent.isHandled();
        Pools.free(inputEvent);
        return bl2;
    }

    @Override
    public boolean keyUp(int n2) {
        Actor actor = this.keyboardFocus == null ? this.root : this.keyboardFocus;
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setStage(this);
        inputEvent.setType(InputEvent.Type.keyUp);
        inputEvent.setKeyCode(n2);
        actor.fire(inputEvent);
        boolean bl2 = inputEvent.isHandled();
        Pools.free(inputEvent);
        return bl2;
    }

    @Override
    public boolean keyTyped(char c2) {
        Actor actor = this.keyboardFocus == null ? this.root : this.keyboardFocus;
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setStage(this);
        inputEvent.setType(InputEvent.Type.keyTyped);
        inputEvent.setCharacter(c2);
        actor.fire(inputEvent);
        boolean bl2 = inputEvent.isHandled();
        Pools.free(inputEvent);
        return bl2;
    }

    public void addTouchFocus(EventListener eventListener, Actor actor, Actor actor2, int n2, int n3) {
        TouchFocus touchFocus = Pools.obtain(TouchFocus.class);
        touchFocus.listenerActor = actor;
        touchFocus.target = actor2;
        touchFocus.listener = eventListener;
        touchFocus.pointer = n2;
        touchFocus.button = n3;
        this.touchFocuses.add(touchFocus);
    }

    public void removeTouchFocus(EventListener eventListener, Actor actor, Actor actor2, int n2, int n3) {
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        for (int i2 = snapshotArray.size - 1; i2 >= 0; --i2) {
            TouchFocus touchFocus = (TouchFocus)snapshotArray.get(i2);
            if (touchFocus.listener != eventListener || touchFocus.listenerActor != actor || touchFocus.target != actor2 || touchFocus.pointer != n2 || touchFocus.button != n3) continue;
            snapshotArray.removeIndex(i2);
            Pools.free(touchFocus);
        }
    }

    public void cancelTouchFocus(Actor actor) {
        InputEvent inputEvent = null;
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArray = snapshotArray.begin();
        int n2 = snapshotArray.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            TouchFocus touchFocus = touchFocusArray[i2];
            if (touchFocus.listenerActor != actor || !snapshotArray.removeValue(touchFocus, true)) continue;
            if (inputEvent == null) {
                inputEvent = Pools.obtain(InputEvent.class);
                inputEvent.setStage(this);
                inputEvent.setType(InputEvent.Type.touchUp);
                inputEvent.setStageX(-2.1474836E9f);
                inputEvent.setStageY(-2.1474836E9f);
            }
            inputEvent.setTarget(touchFocus.target);
            inputEvent.setListenerActor(touchFocus.listenerActor);
            inputEvent.setPointer(touchFocus.pointer);
            inputEvent.setButton(touchFocus.button);
            touchFocus.listener.handle(inputEvent);
        }
        snapshotArray.end();
        if (inputEvent != null) {
            Pools.free(inputEvent);
        }
    }

    public void cancelTouchFocus() {
        this.cancelTouchFocusExcept(null, null);
    }

    public void cancelTouchFocusExcept(@Null EventListener eventListener, @Null Actor actor) {
        InputEvent inputEvent = Pools.obtain(InputEvent.class);
        inputEvent.setStage(this);
        inputEvent.setType(InputEvent.Type.touchUp);
        inputEvent.setStageX(-2.1474836E9f);
        inputEvent.setStageY(-2.1474836E9f);
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArray = snapshotArray.begin();
        int n2 = snapshotArray.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            TouchFocus touchFocus = touchFocusArray[i2];
            if (touchFocus.listener == eventListener && touchFocus.listenerActor == actor || !snapshotArray.removeValue(touchFocus, true)) continue;
            inputEvent.setTarget(touchFocus.target);
            inputEvent.setListenerActor(touchFocus.listenerActor);
            inputEvent.setPointer(touchFocus.pointer);
            inputEvent.setButton(touchFocus.button);
            touchFocus.listener.handle(inputEvent);
        }
        snapshotArray.end();
        Pools.free(inputEvent);
    }

    public void addActor(Actor actor) {
        this.root.addActor(actor);
    }

    public void addAction(Action action) {
        this.root.addAction(action);
    }

    public Array<Actor> getActors() {
        return this.root.children;
    }

    public boolean addListener(EventListener eventListener) {
        return this.root.addListener(eventListener);
    }

    public boolean removeListener(EventListener eventListener) {
        return this.root.removeListener(eventListener);
    }

    public boolean addCaptureListener(EventListener eventListener) {
        return this.root.addCaptureListener(eventListener);
    }

    public boolean removeCaptureListener(EventListener eventListener) {
        return this.root.removeCaptureListener(eventListener);
    }

    public void clear() {
        this.unfocusAll();
        this.root.clear();
    }

    public void unfocusAll() {
        this.setScrollFocus(null);
        this.setKeyboardFocus(null);
        this.cancelTouchFocus();
    }

    public void unfocus(Actor actor) {
        this.cancelTouchFocus(actor);
        if (this.scrollFocus != null && this.scrollFocus.isDescendantOf(actor)) {
            this.setScrollFocus(null);
        }
        if (this.keyboardFocus != null && this.keyboardFocus.isDescendantOf(actor)) {
            this.setKeyboardFocus(null);
        }
    }

    public boolean setKeyboardFocus(@Null Actor actor) {
        boolean bl2;
        if (this.keyboardFocus == actor) {
            return true;
        }
        FocusListener.FocusEvent focusEvent = Pools.obtain(FocusListener.FocusEvent.class);
        focusEvent.setStage(this);
        focusEvent.setType(FocusListener.FocusEvent.Type.keyboard);
        Actor actor2 = this.keyboardFocus;
        if (actor2 != null) {
            focusEvent.setFocused(false);
            focusEvent.setRelatedActor(actor);
            actor2.fire(focusEvent);
        }
        boolean bl3 = bl2 = !focusEvent.isCancelled();
        if (bl2) {
            this.keyboardFocus = actor;
            if (actor != null) {
                focusEvent.setFocused(true);
                focusEvent.setRelatedActor(actor2);
                actor.fire(focusEvent);
                boolean bl4 = bl2 = !focusEvent.isCancelled();
                if (!bl2) {
                    this.keyboardFocus = actor2;
                }
            }
        }
        Pools.free(focusEvent);
        return bl2;
    }

    @Null
    public Actor getKeyboardFocus() {
        return this.keyboardFocus;
    }

    public boolean setScrollFocus(@Null Actor actor) {
        boolean bl2;
        if (this.scrollFocus == actor) {
            return true;
        }
        FocusListener.FocusEvent focusEvent = Pools.obtain(FocusListener.FocusEvent.class);
        focusEvent.setStage(this);
        focusEvent.setType(FocusListener.FocusEvent.Type.scroll);
        Actor actor2 = this.scrollFocus;
        if (actor2 != null) {
            focusEvent.setFocused(false);
            focusEvent.setRelatedActor(actor);
            actor2.fire(focusEvent);
        }
        boolean bl3 = bl2 = !focusEvent.isCancelled();
        if (bl2) {
            this.scrollFocus = actor;
            if (actor != null) {
                focusEvent.setFocused(true);
                focusEvent.setRelatedActor(actor2);
                actor.fire(focusEvent);
                boolean bl4 = bl2 = !focusEvent.isCancelled();
                if (!bl2) {
                    this.scrollFocus = actor2;
                }
            }
        }
        Pools.free(focusEvent);
        return bl2;
    }

    @Null
    public Actor getScrollFocus() {
        return this.scrollFocus;
    }

    public Batch getBatch() {
        return this.batch;
    }

    public Viewport getViewport() {
        return this.viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public float getWidth() {
        return this.viewport.getWorldWidth();
    }

    public float getHeight() {
        return this.viewport.getWorldHeight();
    }

    public Camera getCamera() {
        return this.viewport.getCamera();
    }

    public Group getRoot() {
        return this.root;
    }

    public void setRoot(Group group) {
        if (group.parent != null) {
            group.parent.removeActor(group, false);
        }
        this.root = group;
        group.setParent(null);
        group.setStage(this);
    }

    @Null
    public Actor hit(float f2, float f3, boolean bl2) {
        this.root.parentToLocalCoordinates(this.tempCoords.set(f2, f3));
        return this.root.hit(this.tempCoords.x, this.tempCoords.y, bl2);
    }

    public Vector2 screenToStageCoordinates(Vector2 vector2) {
        this.viewport.unproject(vector2);
        return vector2;
    }

    public Vector2 stageToScreenCoordinates(Vector2 vector2) {
        this.viewport.project(vector2);
        vector2.y = (float)Gdx.graphics.getHeight() - vector2.y;
        return vector2;
    }

    public Vector2 toScreenCoordinates(Vector2 vector2, Matrix4 matrix4) {
        return this.viewport.toScreenCoordinates(vector2, matrix4);
    }

    public void calculateScissors(Rectangle rectangle, Rectangle rectangle2) {
        Matrix4 matrix4 = this.debugShapes != null && this.debugShapes.isDrawing() ? this.debugShapes.getTransformMatrix() : this.batch.getTransformMatrix();
        this.viewport.calculateScissors(matrix4, rectangle, rectangle2);
    }

    public void setActionsRequestRendering(boolean bl2) {
        this.actionsRequestRendering = bl2;
    }

    public boolean getActionsRequestRendering() {
        return this.actionsRequestRendering;
    }

    public Color getDebugColor() {
        return this.debugColor;
    }

    public void setDebugInvisible(boolean bl2) {
        this.debugInvisible = bl2;
    }

    public void setDebugAll(boolean bl2) {
        if (this.debugAll == bl2) {
            return;
        }
        this.debugAll = bl2;
        if (bl2) {
            debug = true;
        } else {
            this.root.setDebug(false, true);
        }
    }

    public boolean isDebugAll() {
        return this.debugAll;
    }

    public void setDebugUnderMouse(boolean bl2) {
        if (this.debugUnderMouse == bl2) {
            return;
        }
        this.debugUnderMouse = bl2;
        if (bl2) {
            debug = true;
        } else {
            this.root.setDebug(false, true);
        }
    }

    public void setDebugParentUnderMouse(boolean bl2) {
        if (this.debugParentUnderMouse == bl2) {
            return;
        }
        this.debugParentUnderMouse = bl2;
        if (bl2) {
            debug = true;
        } else {
            this.root.setDebug(false, true);
        }
    }

    public void setDebugTableUnderMouse(@Null Table.Debug debug) {
        if (debug == null) {
            debug = Table.Debug.none;
        }
        if (this.debugTableUnderMouse == debug) {
            return;
        }
        this.debugTableUnderMouse = debug;
        if (debug != Table.Debug.none) {
            Stage.debug = true;
        } else {
            this.root.setDebug(false, true);
        }
    }

    public void setDebugTableUnderMouse(boolean bl2) {
        this.setDebugTableUnderMouse(bl2 ? Table.Debug.all : Table.Debug.none);
    }

    @Override
    public void dispose() {
        this.clear();
        if (this.ownsBatch) {
            this.batch.dispose();
        }
        if (this.debugShapes != null) {
            this.debugShapes.dispose();
        }
    }

    protected boolean isInsideViewport(int n2, int n3) {
        int n4 = this.viewport.getScreenX();
        int n5 = n4 + this.viewport.getScreenWidth();
        int n6 = this.viewport.getScreenY();
        int n7 = n6 + this.viewport.getScreenHeight();
        n3 = Gdx.graphics.getHeight() - 1 - n3;
        return n2 >= n4 && n2 < n5 && n3 >= n6 && n3 < n7;
    }

    public static final class TouchFocus
    implements Pool.Poolable {
        EventListener listener;
        Actor listenerActor;
        Actor target;
        int pointer;
        int button;

        @Override
        public void reset() {
            this.listenerActor = null;
            this.listener = null;
            this.target = null;
        }
    }
}

