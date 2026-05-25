/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class WidgetGroup
extends Group
implements Layout {
    private boolean needsLayout = true;
    private boolean fillParent;
    private boolean layoutEnabled = true;

    public WidgetGroup() {
    }

    public WidgetGroup(Actor ... actorArray) {
        for (Actor actor : actorArray) {
            this.addActor(actor);
        }
    }

    @Override
    public float getMinWidth() {
        return this.getPrefWidth();
    }

    @Override
    public float getMinHeight() {
        return this.getPrefHeight();
    }

    @Override
    public float getPrefWidth() {
        return 0.0f;
    }

    @Override
    public float getPrefHeight() {
        return 0.0f;
    }

    @Override
    public float getMaxWidth() {
        return 0.0f;
    }

    @Override
    public float getMaxHeight() {
        return 0.0f;
    }

    @Override
    public void setLayoutEnabled(boolean bl2) {
        this.layoutEnabled = bl2;
        this.setLayoutEnabled(this, bl2);
    }

    private void setLayoutEnabled(Group group, boolean bl2) {
        SnapshotArray<Actor> snapshotArray = group.getChildren();
        int n2 = snapshotArray.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Actor actor = (Actor)snapshotArray.get(i2);
            if (actor instanceof Layout) {
                ((Layout)((Object)actor)).setLayoutEnabled(bl2);
                continue;
            }
            if (!(actor instanceof Group)) continue;
            this.setLayoutEnabled((Group)actor, bl2);
        }
    }

    @Override
    public void validate() {
        if (!this.layoutEnabled) {
            return;
        }
        Group group = this.getParent();
        if (this.fillParent && group != null) {
            float f2;
            float f3;
            Stage stage = this.getStage();
            if (stage != null && group == stage.getRoot()) {
                f3 = stage.getWidth();
                f2 = stage.getHeight();
            } else {
                f3 = group.getWidth();
                f2 = group.getHeight();
            }
            if (this.getWidth() != f3 || this.getHeight() != f2) {
                this.setWidth(f3);
                this.setHeight(f2);
                this.invalidate();
            }
        }
        if (!this.needsLayout) {
            return;
        }
        this.needsLayout = false;
        this.layout();
        if (this.needsLayout) {
            if (group instanceof WidgetGroup) {
                return;
            }
            for (int i2 = 0; i2 < 5; ++i2) {
                this.needsLayout = false;
                this.layout();
                if (!this.needsLayout) break;
            }
        }
    }

    public boolean needsLayout() {
        return this.needsLayout;
    }

    @Override
    public void invalidate() {
        this.needsLayout = true;
    }

    @Override
    public void invalidateHierarchy() {
        this.invalidate();
        Group group = this.getParent();
        if (group instanceof Layout) {
            ((Layout)((Object)group)).invalidateHierarchy();
        }
    }

    @Override
    public void childrenChanged() {
        this.invalidateHierarchy();
    }

    @Override
    public void sizeChanged() {
        this.invalidate();
    }

    @Override
    public void pack() {
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.validate();
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.validate();
    }

    @Override
    public void setFillParent(boolean bl2) {
        this.fillParent = bl2;
    }

    @Override
    public void layout() {
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.validate();
        super.draw(batch, f2);
    }
}

