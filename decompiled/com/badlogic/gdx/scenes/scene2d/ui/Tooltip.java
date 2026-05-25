/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.TooltipManager;
import com.badlogic.gdx.utils.Null;

public class Tooltip<T extends Actor>
extends InputListener {
    static Vector2 tmp = new Vector2();
    private final TooltipManager manager;
    final Container<T> container;
    boolean instant;
    boolean always;
    boolean touchIndependent;
    Actor targetActor;

    public Tooltip(@Null T t2) {
        this(t2, TooltipManager.getInstance());
    }

    public Tooltip(@Null T t2, TooltipManager tooltipManager) {
        this.manager = tooltipManager;
        this.container = new Container((Actor)t2){

            @Override
            public void act(float f2) {
                super.act(f2);
                if (Tooltip.this.targetActor != null && Tooltip.this.targetActor.getStage() == null) {
                    this.remove();
                }
            }
        };
        this.container.setTouchable(Touchable.disabled);
    }

    public TooltipManager getManager() {
        return this.manager;
    }

    public Container<T> getContainer() {
        return this.container;
    }

    public void setActor(@Null T t2) {
        this.container.setActor(t2);
    }

    @Null
    public T getActor() {
        return this.container.getActor();
    }

    public void setInstant(boolean bl2) {
        this.instant = bl2;
    }

    public void setAlways(boolean bl2) {
        this.always = bl2;
    }

    public void setTouchIndependent(boolean bl2) {
        this.touchIndependent = bl2;
    }

    @Override
    public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
        if (this.instant) {
            this.container.toFront();
            return false;
        }
        this.manager.touchDown(this);
        return false;
    }

    @Override
    public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
        if (this.container.hasParent()) {
            return false;
        }
        this.setContainerPosition(inputEvent.getListenerActor(), f2, f3);
        return true;
    }

    private void setContainerPosition(Actor actor, float f2, float f3) {
        this.targetActor = actor;
        Stage stage = actor.getStage();
        if (stage == null) {
            return;
        }
        this.container.setSize(this.manager.maxWidth, 2.1474836E9f);
        this.container.validate();
        this.container.width(((Actor)this.container.getActor()).getWidth());
        this.container.pack();
        float f4 = this.manager.offsetX;
        float f5 = this.manager.offsetY;
        float f6 = this.manager.edgeDistance;
        Vector2 vector2 = actor.localToStageCoordinates(tmp.set(f2 + f4, f3 - f5 - this.container.getHeight()));
        if (vector2.y < f6) {
            vector2 = actor.localToStageCoordinates(tmp.set(f2 + f4, f3 + f5));
        }
        if (vector2.x < f6) {
            vector2.x = f6;
        }
        if (vector2.x + this.container.getWidth() > stage.getWidth() - f6) {
            vector2.x = stage.getWidth() - f6 - this.container.getWidth();
        }
        if (vector2.y + this.container.getHeight() > stage.getHeight() - f6) {
            vector2.y = stage.getHeight() - f6 - this.container.getHeight();
        }
        this.container.setPosition(vector2.x, vector2.y);
        vector2 = actor.localToStageCoordinates(tmp.set(actor.getWidth() / 2.0f, actor.getHeight() / 2.0f));
        vector2.sub(this.container.getX(), this.container.getY());
        this.container.setOrigin(vector2.x, vector2.y);
    }

    @Override
    public void enter(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
        if (n2 != -1) {
            return;
        }
        if (this.touchIndependent && Gdx.input.isTouched()) {
            return;
        }
        Actor actor2 = inputEvent.getListenerActor();
        if (actor != null && actor.isDescendantOf(actor2)) {
            return;
        }
        this.setContainerPosition(actor2, f2, f3);
        this.manager.enter(this);
    }

    @Override
    public void exit(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
        if (actor != null && actor.isDescendantOf(inputEvent.getListenerActor())) {
            return;
        }
        this.hide();
    }

    public void hide() {
        this.manager.hide(this);
    }
}

