/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.SnapshotArray;

public class Group
extends Actor
implements Cullable {
    private static final Vector2 tmp = new Vector2();
    final SnapshotArray<Actor> children = new SnapshotArray(true, 4, Actor.class);
    private final Affine2 worldTransform = new Affine2();
    private final Matrix4 computedTransform = new Matrix4();
    private final Matrix4 oldTransform = new Matrix4();
    boolean transform = true;
    @Null
    private Rectangle cullingArea;

    @Override
    public void act(float f2) {
        super.act(f2);
        Actor[] actorArray = this.children.begin();
        int n2 = this.children.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            actorArray[i2].act(f2);
        }
        this.children.end();
    }

    @Override
    public void draw(Batch batch, float f2) {
        if (this.transform) {
            this.applyTransform(batch, this.computeTransform());
        }
        this.drawChildren(batch, f2);
        if (this.transform) {
            this.resetTransform(batch);
        }
    }

    protected void drawChildren(Batch batch, float f2) {
        f2 *= this.color.a;
        SnapshotArray<Actor> snapshotArray = this.children;
        Actor[] actorArray = snapshotArray.begin();
        Rectangle rectangle = this.cullingArea;
        if (rectangle != null) {
            float f3 = rectangle.x;
            float f4 = f3 + rectangle.width;
            float f5 = rectangle.y;
            float f6 = f5 + rectangle.height;
            if (this.transform) {
                int n2 = snapshotArray.size;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Actor actor = actorArray[i2];
                    if (!actor.isVisible()) continue;
                    float f7 = actor.x;
                    float f8 = actor.y;
                    if (!(f7 <= f4) || !(f8 <= f6) || !(f7 + actor.width >= f3) || !(f8 + actor.height >= f5)) continue;
                    actor.draw(batch, f2);
                }
            } else {
                float f9 = this.x;
                float f10 = this.y;
                this.x = 0.0f;
                this.y = 0.0f;
                int n3 = snapshotArray.size;
                for (int i3 = 0; i3 < n3; ++i3) {
                    Actor actor = actorArray[i3];
                    if (!actor.isVisible()) continue;
                    float f11 = actor.x;
                    float f12 = actor.y;
                    if (!(f11 <= f4) || !(f12 <= f6) || !(f11 + actor.width >= f3) || !(f12 + actor.height >= f5)) continue;
                    actor.x = f11 + f9;
                    actor.y = f12 + f10;
                    actor.draw(batch, f2);
                    actor.x = f11;
                    actor.y = f12;
                }
                this.x = f9;
                this.y = f10;
            }
        } else if (this.transform) {
            int n4 = snapshotArray.size;
            for (int i4 = 0; i4 < n4; ++i4) {
                Actor actor = actorArray[i4];
                if (!actor.isVisible()) continue;
                actor.draw(batch, f2);
            }
        } else {
            float f13 = this.x;
            float f14 = this.y;
            this.x = 0.0f;
            this.y = 0.0f;
            int n5 = snapshotArray.size;
            for (int i5 = 0; i5 < n5; ++i5) {
                Actor actor = actorArray[i5];
                if (!actor.isVisible()) continue;
                float f15 = actor.x;
                float f16 = actor.y;
                actor.x = f15 + f13;
                actor.y = f16 + f14;
                actor.draw(batch, f2);
                actor.x = f15;
                actor.y = f16;
            }
            this.x = f13;
            this.y = f14;
        }
        snapshotArray.end();
    }

    @Override
    public void drawDebug(ShapeRenderer shapeRenderer) {
        this.drawDebugBounds(shapeRenderer);
        if (this.transform) {
            this.applyTransform(shapeRenderer, this.computeTransform());
        }
        this.drawDebugChildren(shapeRenderer);
        if (this.transform) {
            this.resetTransform(shapeRenderer);
        }
    }

    protected void drawDebugChildren(ShapeRenderer shapeRenderer) {
        SnapshotArray<Actor> snapshotArray = this.children;
        Actor[] actorArray = snapshotArray.begin();
        if (this.transform) {
            int n2 = snapshotArray.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                Actor actor = actorArray[i2];
                if (!actor.isVisible() || !actor.getDebug() && !(actor instanceof Group)) continue;
                actor.drawDebug(shapeRenderer);
            }
            shapeRenderer.flush();
        } else {
            float f2 = this.x;
            float f3 = this.y;
            this.x = 0.0f;
            this.y = 0.0f;
            int n3 = snapshotArray.size;
            for (int i3 = 0; i3 < n3; ++i3) {
                Actor actor = actorArray[i3];
                if (!actor.isVisible() || !actor.getDebug() && !(actor instanceof Group)) continue;
                float f4 = actor.x;
                float f5 = actor.y;
                actor.x = f4 + f2;
                actor.y = f5 + f3;
                actor.drawDebug(shapeRenderer);
                actor.x = f4;
                actor.y = f5;
            }
            this.x = f2;
            this.y = f3;
        }
        snapshotArray.end();
    }

    protected Matrix4 computeTransform() {
        Affine2 affine2 = this.worldTransform;
        float f2 = this.originX;
        float f3 = this.originY;
        affine2.setToTrnRotScl(this.x + f2, this.y + f3, this.rotation, this.scaleX, this.scaleY);
        if (f2 != 0.0f || f3 != 0.0f) {
            affine2.translate(-f2, -f3);
        }
        Group group = this.parent;
        while (group != null && !group.transform) {
            group = group.parent;
        }
        if (group != null) {
            affine2.preMul(group.worldTransform);
        }
        this.computedTransform.set(affine2);
        return this.computedTransform;
    }

    protected void applyTransform(Batch batch, Matrix4 matrix4) {
        this.oldTransform.set(batch.getTransformMatrix());
        batch.setTransformMatrix(matrix4);
    }

    protected void resetTransform(Batch batch) {
        batch.setTransformMatrix(this.oldTransform);
    }

    protected void applyTransform(ShapeRenderer shapeRenderer, Matrix4 matrix4) {
        this.oldTransform.set(shapeRenderer.getTransformMatrix());
        shapeRenderer.setTransformMatrix(matrix4);
        shapeRenderer.flush();
    }

    protected void resetTransform(ShapeRenderer shapeRenderer) {
        shapeRenderer.setTransformMatrix(this.oldTransform);
    }

    @Override
    public void setCullingArea(@Null Rectangle rectangle) {
        this.cullingArea = rectangle;
    }

    @Null
    public Rectangle getCullingArea() {
        return this.cullingArea;
    }

    @Override
    @Null
    public Actor hit(float f2, float f3, boolean bl2) {
        if (bl2 && this.getTouchable() == Touchable.disabled) {
            return null;
        }
        if (!this.isVisible()) {
            return null;
        }
        Vector2 vector2 = tmp;
        Actor[] actorArray = (Actor[])this.children.items;
        for (int i2 = this.children.size - 1; i2 >= 0; --i2) {
            Actor actor = actorArray[i2];
            actor.parentToLocalCoordinates(vector2.set(f2, f3));
            Actor actor2 = actor.hit(vector2.x, vector2.y, bl2);
            if (actor2 == null) continue;
            return actor2;
        }
        return super.hit(f2, f3, bl2);
    }

    protected void childrenChanged() {
    }

    public void addActor(Actor actor) {
        if (actor.parent != null) {
            if (actor.parent == this) {
                return;
            }
            actor.parent.removeActor(actor, false);
        }
        this.children.add(actor);
        actor.setParent(this);
        actor.setStage(this.getStage());
        this.childrenChanged();
    }

    public void addActorAt(int n2, Actor actor) {
        if (actor.parent != null) {
            if (actor.parent == this) {
                return;
            }
            actor.parent.removeActor(actor, false);
        }
        if (n2 >= this.children.size) {
            this.children.add(actor);
        } else {
            this.children.insert(n2, actor);
        }
        actor.setParent(this);
        actor.setStage(this.getStage());
        this.childrenChanged();
    }

    public void addActorBefore(Actor actor, Actor actor2) {
        if (actor2.parent != null) {
            if (actor2.parent == this) {
                return;
            }
            actor2.parent.removeActor(actor2, false);
        }
        int n2 = this.children.indexOf(actor, true);
        this.children.insert(n2, actor2);
        actor2.setParent(this);
        actor2.setStage(this.getStage());
        this.childrenChanged();
    }

    public void addActorAfter(Actor actor, Actor actor2) {
        int n2;
        if (actor2.parent != null) {
            if (actor2.parent == this) {
                return;
            }
            actor2.parent.removeActor(actor2, false);
        }
        if ((n2 = this.children.indexOf(actor, true)) == this.children.size || n2 == -1) {
            this.children.add(actor2);
        } else {
            this.children.insert(n2 + 1, actor2);
        }
        actor2.setParent(this);
        actor2.setStage(this.getStage());
        this.childrenChanged();
    }

    public boolean removeActor(Actor actor) {
        return this.removeActor(actor, true);
    }

    public boolean removeActor(Actor actor, boolean bl2) {
        int n2 = this.children.indexOf(actor, true);
        if (n2 == -1) {
            return false;
        }
        this.removeActorAt(n2, bl2);
        return true;
    }

    public Actor removeActorAt(int n2, boolean bl2) {
        Stage stage;
        Actor actor = this.children.removeIndex(n2);
        if (bl2 && (stage = this.getStage()) != null) {
            stage.unfocus(actor);
        }
        actor.setParent(null);
        actor.setStage(null);
        this.childrenChanged();
        return actor;
    }

    public void clearChildren() {
        this.clearChildren(true);
    }

    public void clearChildren(boolean bl2) {
        Actor[] actorArray = this.children.begin();
        int n2 = this.children.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Stage stage;
            Actor actor = actorArray[i2];
            if (bl2 && (stage = this.getStage()) != null) {
                stage.unfocus(actor);
            }
            actor.setStage(null);
            actor.setParent(null);
        }
        this.children.end();
        this.children.clear();
        this.childrenChanged();
    }

    @Override
    public void clear() {
        super.clear();
        this.clearChildren(true);
    }

    public void clear(boolean bl2) {
        super.clear();
        this.clearChildren(bl2);
    }

    @Null
    public <T extends Actor> T findActor(String string) {
        int n2;
        SnapshotArray<Actor> snapshotArray = this.children;
        int n3 = snapshotArray.size;
        for (n2 = 0; n2 < n3; ++n2) {
            if (!string.equals(((Actor)snapshotArray.get(n2)).getName())) continue;
            return (T)((Actor)snapshotArray.get(n2));
        }
        n3 = snapshotArray.size;
        for (n2 = 0; n2 < n3; ++n2) {
            T t2;
            Actor actor = (Actor)snapshotArray.get(n2);
            if (!(actor instanceof Group) || (t2 = ((Group)actor).findActor(string)) == null) continue;
            return t2;
        }
        return null;
    }

    @Override
    public void setStage(Stage stage) {
        super.setStage(stage);
        Actor[] actorArray = (Actor[])this.children.items;
        int n2 = this.children.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            actorArray[i2].setStage(stage);
        }
    }

    public boolean swapActor(int n2, int n3) {
        int n4 = this.children.size;
        if (n2 < 0 || n2 >= n4) {
            return false;
        }
        if (n3 < 0 || n3 >= n4) {
            return false;
        }
        this.children.swap(n2, n3);
        return true;
    }

    public boolean swapActor(Actor actor, Actor actor2) {
        int n2 = this.children.indexOf(actor, true);
        int n3 = this.children.indexOf(actor2, true);
        if (n2 == -1 || n3 == -1) {
            return false;
        }
        this.children.swap(n2, n3);
        return true;
    }

    public Actor getChild(int n2) {
        return (Actor)this.children.get(n2);
    }

    public SnapshotArray<Actor> getChildren() {
        return this.children;
    }

    public boolean hasChildren() {
        return this.children.size > 0;
    }

    public void setTransform(boolean bl2) {
        this.transform = bl2;
    }

    public boolean isTransform() {
        return this.transform;
    }

    public Vector2 localToDescendantCoordinates(Actor actor, Vector2 vector2) {
        Group group = actor.parent;
        if (group == null) {
            throw new IllegalArgumentException("Child is not a descendant: " + actor);
        }
        if (group != this) {
            this.localToDescendantCoordinates(group, vector2);
        }
        actor.parentToLocalCoordinates(vector2);
        return vector2;
    }

    public void setDebug(boolean bl2, boolean bl3) {
        this.setDebug(bl2);
        if (bl3) {
            for (Actor actor : this.children) {
                if (actor instanceof Group) {
                    ((Group)actor).setDebug(bl2, bl3);
                    continue;
                }
                actor.setDebug(bl2);
            }
        }
    }

    public Group debugAll() {
        this.setDebug(true, true);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        this.toString(stringBuilder, 1);
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    void toString(StringBuilder stringBuilder, int n2) {
        stringBuilder.append(super.toString());
        stringBuilder.append('\n');
        Actor[] actorArray = this.children.begin();
        int n3 = this.children.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                stringBuilder.append("|  ");
            }
            Actor actor = actorArray[i2];
            if (actor instanceof Group) {
                ((Group)actor).toString(stringBuilder, n2 + 1);
                continue;
            }
            stringBuilder.append(actor);
            stringBuilder.append('\n');
        }
        this.children.end();
    }
}

