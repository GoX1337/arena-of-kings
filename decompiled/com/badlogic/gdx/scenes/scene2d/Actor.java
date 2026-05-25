/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public class Actor {
    @Null
    private Stage stage;
    @Null
    Group parent;
    private final DelayedRemovalArray<EventListener> listeners = new DelayedRemovalArray(0);
    private final DelayedRemovalArray<EventListener> captureListeners = new DelayedRemovalArray(0);
    private final Array<Action> actions = new Array(0);
    @Null
    private String name;
    private Touchable touchable = Touchable.enabled;
    private boolean visible = true;
    private boolean debug;
    float x;
    float y;
    float width;
    float height;
    float originX;
    float originY;
    float scaleX = 1.0f;
    float scaleY = 1.0f;
    float rotation;
    final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    @Null
    private Object userObject;

    public void draw(Batch batch, float f2) {
    }

    public void act(float f2) {
        Array<Action> array = this.actions;
        if (array.size == 0) {
            return;
        }
        if (this.stage != null && this.stage.getActionsRequestRendering()) {
            Gdx.graphics.requestRendering();
        }
        try {
            for (int i2 = 0; i2 < array.size; ++i2) {
                int n2;
                Action action = array.get(i2);
                if (!action.act(f2) || i2 >= array.size) continue;
                Action action2 = array.get(i2);
                int n3 = n2 = action2 == action ? i2 : array.indexOf(action, true);
                if (n2 == -1) continue;
                array.removeIndex(n2);
                action.setActor(null);
                --i2;
            }
        }
        catch (RuntimeException runtimeException) {
            String string = this.toString();
            throw new RuntimeException("Actor: " + string.substring(0, Math.min(string.length(), 128)), runtimeException);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean fire(Event event) {
        if (event.getStage() == null) {
            event.setStage(this.getStage());
        }
        event.setTarget(this);
        Array array = Pools.obtain(Array.class);
        Group group = this.parent;
        while (group != null) {
            array.add(group);
            group = group.parent;
        }
        try {
            int n2;
            T[] TArray = array.items;
            for (n2 = array.size - 1; n2 >= 0; --n2) {
                Group group2 = (Group)TArray[n2];
                group2.notify(event, true);
                if (!event.isStopped()) continue;
                boolean bl2 = event.isCancelled();
                return bl2;
            }
            this.notify(event, true);
            if (event.isStopped()) {
                n2 = event.isCancelled() ? 1 : 0;
                return n2 != 0;
            }
            this.notify(event, false);
            if (!event.getBubbles()) {
                n2 = event.isCancelled();
                return n2 != 0;
            }
            if (event.isStopped()) {
                n2 = event.isCancelled();
                return n2 != 0;
            }
            int n3 = array.size;
            for (n2 = 0; n2 < n3; ++n2) {
                ((Group)TArray[n2]).notify(event, false);
                if (!event.isStopped()) continue;
                boolean bl3 = event.isCancelled();
                return bl3;
            }
            n2 = event.isCancelled() ? 1 : 0;
            return n2 != 0;
        }
        finally {
            array.clear();
            Pools.free(array);
        }
    }

    public boolean notify(Event event, boolean bl2) {
        DelayedRemovalArray<EventListener> delayedRemovalArray;
        if (event.getTarget() == null) {
            throw new IllegalArgumentException("The event target cannot be null.");
        }
        DelayedRemovalArray<EventListener> delayedRemovalArray2 = delayedRemovalArray = bl2 ? this.captureListeners : this.listeners;
        if (delayedRemovalArray.size == 0) {
            return event.isCancelled();
        }
        event.setListenerActor(this);
        event.setCapture(bl2);
        if (event.getStage() == null) {
            event.setStage(this.stage);
        }
        try {
            delayedRemovalArray.begin();
            int n2 = delayedRemovalArray.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!((EventListener)delayedRemovalArray.get(i2)).handle(event)) continue;
                event.handle();
            }
            delayedRemovalArray.end();
        }
        catch (RuntimeException runtimeException) {
            String string = this.toString();
            throw new RuntimeException("Actor: " + string.substring(0, Math.min(string.length(), 128)), runtimeException);
        }
        return event.isCancelled();
    }

    @Null
    public Actor hit(float f2, float f3, boolean bl2) {
        if (bl2 && this.touchable != Touchable.enabled) {
            return null;
        }
        if (!this.isVisible()) {
            return null;
        }
        return f2 >= 0.0f && f2 < this.width && f3 >= 0.0f && f3 < this.height ? this : null;
    }

    public boolean remove() {
        if (this.parent != null) {
            return this.parent.removeActor(this, true);
        }
        return false;
    }

    public boolean addListener(EventListener eventListener) {
        if (eventListener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        if (!this.listeners.contains(eventListener, true)) {
            this.listeners.add(eventListener);
            return true;
        }
        return false;
    }

    public boolean removeListener(EventListener eventListener) {
        if (eventListener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        return this.listeners.removeValue(eventListener, true);
    }

    public DelayedRemovalArray<EventListener> getListeners() {
        return this.listeners;
    }

    public boolean addCaptureListener(EventListener eventListener) {
        if (eventListener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        if (!this.captureListeners.contains(eventListener, true)) {
            this.captureListeners.add(eventListener);
        }
        return true;
    }

    public boolean removeCaptureListener(EventListener eventListener) {
        if (eventListener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        return this.captureListeners.removeValue(eventListener, true);
    }

    public DelayedRemovalArray<EventListener> getCaptureListeners() {
        return this.captureListeners;
    }

    public void addAction(Action action) {
        action.setActor(this);
        this.actions.add(action);
        if (this.stage != null && this.stage.getActionsRequestRendering()) {
            Gdx.graphics.requestRendering();
        }
    }

    public void removeAction(@Null Action action) {
        if (action != null && this.actions.removeValue(action, true)) {
            action.setActor(null);
        }
    }

    public Array<Action> getActions() {
        return this.actions;
    }

    public boolean hasActions() {
        return this.actions.size > 0;
    }

    public void clearActions() {
        for (int i2 = this.actions.size - 1; i2 >= 0; --i2) {
            this.actions.get(i2).setActor(null);
        }
        this.actions.clear();
    }

    public void clearListeners() {
        this.listeners.clear();
        this.captureListeners.clear();
    }

    public void clear() {
        this.clearActions();
        this.clearListeners();
    }

    @Null
    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isDescendantOf(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        Actor actor2 = this;
        do {
            if (actor2 != actor) continue;
            return true;
        } while ((actor2 = actor2.parent) != null);
        return false;
    }

    public boolean isAscendantOf(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        do {
            if (actor != this) continue;
            return true;
        } while ((actor = actor.parent) != null);
        return false;
    }

    @Null
    public <T extends Actor> T firstAscendant(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        Actor actor = this;
        do {
            if (!ClassReflection.isInstance(clazz, actor)) continue;
            return (T)actor;
        } while ((actor = actor.parent) != null);
        return null;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    @Null
    public Group getParent() {
        return this.parent;
    }

    protected void setParent(@Null Group group) {
        this.parent = group;
    }

    public boolean isTouchable() {
        return this.touchable == Touchable.enabled;
    }

    public Touchable getTouchable() {
        return this.touchable;
    }

    public void setTouchable(Touchable touchable) {
        this.touchable = touchable;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl2) {
        this.visible = bl2;
    }

    public boolean ascendantsVisible() {
        Actor actor = this;
        do {
            if (actor.isVisible()) continue;
            return false;
        } while ((actor = actor.parent) != null);
        return true;
    }

    @Deprecated
    public boolean ancestorsVisible() {
        return this.ascendantsVisible();
    }

    public boolean hasKeyboardFocus() {
        Stage stage = this.getStage();
        return stage != null && stage.getKeyboardFocus() == this;
    }

    public boolean hasScrollFocus() {
        Stage stage = this.getStage();
        return stage != null && stage.getScrollFocus() == this;
    }

    public boolean isTouchFocusTarget() {
        Stage stage = this.getStage();
        if (stage == null) {
            return false;
        }
        int n2 = stage.touchFocuses.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((Stage.TouchFocus)stage.touchFocuses.get((int)i2)).target != this) continue;
            return true;
        }
        return false;
    }

    public boolean isTouchFocusListener() {
        Stage stage = this.getStage();
        if (stage == null) {
            return false;
        }
        int n2 = stage.touchFocuses.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((Stage.TouchFocus)stage.touchFocuses.get((int)i2)).listenerActor != this) continue;
            return true;
        }
        return false;
    }

    @Null
    public Object getUserObject() {
        return this.userObject;
    }

    public void setUserObject(@Null Object object) {
        this.userObject = object;
    }

    public float getX() {
        return this.x;
    }

    public float getX(int n2) {
        float f2 = this.x;
        if ((n2 & 0x10) != 0) {
            f2 += this.width;
        } else if ((n2 & 8) == 0) {
            f2 += this.width / 2.0f;
        }
        return f2;
    }

    public void setX(float f2) {
        if (this.x != f2) {
            this.x = f2;
            this.positionChanged();
        }
    }

    public void setX(float f2, int n2) {
        if ((n2 & 0x10) != 0) {
            f2 -= this.width;
        } else if ((n2 & 8) == 0) {
            f2 -= this.width / 2.0f;
        }
        if (this.x != f2) {
            this.x = f2;
            this.positionChanged();
        }
    }

    public float getY() {
        return this.y;
    }

    public void setY(float f2) {
        if (this.y != f2) {
            this.y = f2;
            this.positionChanged();
        }
    }

    public void setY(float f2, int n2) {
        if ((n2 & 2) != 0) {
            f2 -= this.height;
        } else if ((n2 & 4) == 0) {
            f2 -= this.height / 2.0f;
        }
        if (this.y != f2) {
            this.y = f2;
            this.positionChanged();
        }
    }

    public float getY(int n2) {
        float f2 = this.y;
        if ((n2 & 2) != 0) {
            f2 += this.height;
        } else if ((n2 & 4) == 0) {
            f2 += this.height / 2.0f;
        }
        return f2;
    }

    public void setPosition(float f2, float f3) {
        if (this.x != f2 || this.y != f3) {
            this.x = f2;
            this.y = f3;
            this.positionChanged();
        }
    }

    public void setPosition(float f2, float f3, int n2) {
        if ((n2 & 0x10) != 0) {
            f2 -= this.width;
        } else if ((n2 & 8) == 0) {
            f2 -= this.width / 2.0f;
        }
        if ((n2 & 2) != 0) {
            f3 -= this.height;
        } else if ((n2 & 4) == 0) {
            f3 -= this.height / 2.0f;
        }
        if (this.x != f2 || this.y != f3) {
            this.x = f2;
            this.y = f3;
            this.positionChanged();
        }
    }

    public void moveBy(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.x += f2;
            this.y += f3;
            this.positionChanged();
        }
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float f2) {
        if (this.width != f2) {
            this.width = f2;
            this.sizeChanged();
        }
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float f2) {
        if (this.height != f2) {
            this.height = f2;
            this.sizeChanged();
        }
    }

    public float getTop() {
        return this.y + this.height;
    }

    public float getRight() {
        return this.x + this.width;
    }

    protected void positionChanged() {
    }

    protected void sizeChanged() {
    }

    public void scaleChanged() {
    }

    protected void rotationChanged() {
    }

    public void setSize(float f2, float f3) {
        if (this.width != f2 || this.height != f3) {
            this.width = f2;
            this.height = f3;
            this.sizeChanged();
        }
    }

    public void sizeBy(float f2) {
        if (f2 != 0.0f) {
            this.width += f2;
            this.height += f2;
            this.sizeChanged();
        }
    }

    public void sizeBy(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.width += f2;
            this.height += f3;
            this.sizeChanged();
        }
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        if (this.x != f2 || this.y != f3) {
            this.x = f2;
            this.y = f3;
            this.positionChanged();
        }
        if (this.width != f4 || this.height != f5) {
            this.width = f4;
            this.height = f5;
            this.sizeChanged();
        }
    }

    public float getOriginX() {
        return this.originX;
    }

    public void setOriginX(float f2) {
        this.originX = f2;
    }

    public float getOriginY() {
        return this.originY;
    }

    public void setOriginY(float f2) {
        this.originY = f2;
    }

    public void setOrigin(float f2, float f3) {
        this.originX = f2;
        this.originY = f3;
    }

    public void setOrigin(int n2) {
        this.originX = (n2 & 8) != 0 ? 0.0f : ((n2 & 0x10) != 0 ? this.width : this.width / 2.0f);
        this.originY = (n2 & 4) != 0 ? 0.0f : ((n2 & 2) != 0 ? this.height : this.height / 2.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f2) {
        if (this.scaleX != f2) {
            this.scaleX = f2;
            this.scaleChanged();
        }
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f2) {
        if (this.scaleY != f2) {
            this.scaleY = f2;
            this.scaleChanged();
        }
    }

    public void setScale(float f2) {
        if (this.scaleX != f2 || this.scaleY != f2) {
            this.scaleX = f2;
            this.scaleY = f2;
            this.scaleChanged();
        }
    }

    public void setScale(float f2, float f3) {
        if (this.scaleX != f2 || this.scaleY != f3) {
            this.scaleX = f2;
            this.scaleY = f3;
            this.scaleChanged();
        }
    }

    public void scaleBy(float f2) {
        if (f2 != 0.0f) {
            this.scaleX += f2;
            this.scaleY += f2;
            this.scaleChanged();
        }
    }

    public void scaleBy(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.scaleX += f2;
            this.scaleY += f3;
            this.scaleChanged();
        }
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float f2) {
        if (this.rotation != f2) {
            this.rotation = f2;
            this.rotationChanged();
        }
    }

    public void rotateBy(float f2) {
        if (f2 != 0.0f) {
            this.rotation = (this.rotation + f2) % 360.0f;
            this.rotationChanged();
        }
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
    }

    public Color getColor() {
        return this.color;
    }

    @Null
    public String getName() {
        return this.name;
    }

    public void setName(@Null String string) {
        this.name = string;
    }

    public void toFront() {
        this.setZIndex(Integer.MAX_VALUE);
    }

    public void toBack() {
        this.setZIndex(0);
    }

    public boolean setZIndex(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("ZIndex cannot be < 0.");
        }
        Group group = this.parent;
        if (group == null) {
            return false;
        }
        SnapshotArray<Actor> snapshotArray = group.children;
        if (snapshotArray.size <= 1) {
            return false;
        }
        if (snapshotArray.get(n2 = Math.min(n2, snapshotArray.size - 1)) == this) {
            return false;
        }
        if (!((Array)snapshotArray).removeValue(this, true)) {
            return false;
        }
        ((Array)snapshotArray).insert(n2, this);
        return true;
    }

    public int getZIndex() {
        Group group = this.parent;
        if (group == null) {
            return -1;
        }
        return group.children.indexOf(this, true);
    }

    public boolean clipBegin() {
        return this.clipBegin(this.x, this.y, this.width, this.height);
    }

    public boolean clipBegin(float f2, float f3, float f4, float f5) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return false;
        }
        Stage stage = this.stage;
        if (stage == null) {
            return false;
        }
        Rectangle rectangle = Rectangle.tmp;
        rectangle.x = f2;
        rectangle.y = f3;
        rectangle.width = f4;
        rectangle.height = f5;
        Rectangle rectangle2 = Pools.obtain(Rectangle.class);
        stage.calculateScissors(rectangle, rectangle2);
        if (ScissorStack.pushScissors(rectangle2)) {
            return true;
        }
        Pools.free(rectangle2);
        return false;
    }

    public void clipEnd() {
        Pools.free(ScissorStack.popScissors());
    }

    public Vector2 screenToLocalCoordinates(Vector2 vector2) {
        Stage stage = this.stage;
        if (stage == null) {
            return vector2;
        }
        return this.stageToLocalCoordinates(stage.screenToStageCoordinates(vector2));
    }

    public Vector2 stageToLocalCoordinates(Vector2 vector2) {
        if (this.parent != null) {
            this.parent.stageToLocalCoordinates(vector2);
        }
        this.parentToLocalCoordinates(vector2);
        return vector2;
    }

    public Vector2 parentToLocalCoordinates(Vector2 vector2) {
        float f2 = this.rotation;
        float f3 = this.scaleX;
        float f4 = this.scaleY;
        float f5 = this.x;
        float f6 = this.y;
        if (f2 == 0.0f) {
            if (f3 == 1.0f && f4 == 1.0f) {
                vector2.x -= f5;
                vector2.y -= f6;
            } else {
                float f7 = this.originX;
                float f8 = this.originY;
                vector2.x = (vector2.x - f5 - f7) / f3 + f7;
                vector2.y = (vector2.y - f6 - f8) / f4 + f8;
            }
        } else {
            float f9 = (float)Math.cos(f2 * ((float)Math.PI / 180));
            float f10 = (float)Math.sin(f2 * ((float)Math.PI / 180));
            float f11 = this.originX;
            float f12 = this.originY;
            float f13 = vector2.x - f5 - f11;
            float f14 = vector2.y - f6 - f12;
            vector2.x = (f13 * f9 + f14 * f10) / f3 + f11;
            vector2.y = (f13 * -f10 + f14 * f9) / f4 + f12;
        }
        return vector2;
    }

    public Vector2 localToScreenCoordinates(Vector2 vector2) {
        Stage stage = this.stage;
        if (stage == null) {
            return vector2;
        }
        return stage.stageToScreenCoordinates(this.localToAscendantCoordinates(null, vector2));
    }

    public Vector2 localToStageCoordinates(Vector2 vector2) {
        return this.localToAscendantCoordinates(null, vector2);
    }

    public Vector2 localToParentCoordinates(Vector2 vector2) {
        float f2 = -this.rotation;
        float f3 = this.scaleX;
        float f4 = this.scaleY;
        float f5 = this.x;
        float f6 = this.y;
        if (f2 == 0.0f) {
            if (f3 == 1.0f && f4 == 1.0f) {
                vector2.x += f5;
                vector2.y += f6;
            } else {
                float f7 = this.originX;
                float f8 = this.originY;
                vector2.x = (vector2.x - f7) * f3 + f7 + f5;
                vector2.y = (vector2.y - f8) * f4 + f8 + f6;
            }
        } else {
            float f9 = (float)Math.cos(f2 * ((float)Math.PI / 180));
            float f10 = (float)Math.sin(f2 * ((float)Math.PI / 180));
            float f11 = this.originX;
            float f12 = this.originY;
            float f13 = (vector2.x - f11) * f3;
            float f14 = (vector2.y - f12) * f4;
            vector2.x = f13 * f9 + f14 * f10 + f11 + f5;
            vector2.y = f13 * -f10 + f14 * f9 + f12 + f6;
        }
        return vector2;
    }

    public Vector2 localToAscendantCoordinates(@Null Actor actor, Vector2 vector2) {
        Actor actor2 = this;
        do {
            actor2.localToParentCoordinates(vector2);
        } while ((actor2 = actor2.parent) != actor && actor2 != null);
        return vector2;
    }

    public Vector2 localToActorCoordinates(Actor actor, Vector2 vector2) {
        this.localToStageCoordinates(vector2);
        return actor.stageToLocalCoordinates(vector2);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        this.drawDebugBounds(shapeRenderer);
    }

    public void drawDebugBounds(ShapeRenderer shapeRenderer) {
        if (!this.debug) {
            return;
        }
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        if (this.stage != null) {
            shapeRenderer.setColor(this.stage.getDebugColor());
        }
        shapeRenderer.rect(this.x, this.y, this.originX, this.originY, this.width, this.height, this.scaleX, this.scaleY, this.rotation);
    }

    public void setDebug(boolean bl2) {
        this.debug = bl2;
        if (bl2) {
            Stage.debug = true;
        }
    }

    public boolean getDebug() {
        return this.debug;
    }

    public Actor debug() {
        this.setDebug(true);
        return this;
    }

    public String toString() {
        int n2;
        String string = this.name;
        if (string == null && (n2 = (string = this.getClass().getName()).lastIndexOf(46)) != -1) {
            string = string.substring(n2 + 1);
        }
        return string;
    }
}

