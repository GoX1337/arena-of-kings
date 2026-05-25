/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.AddAction;
import com.badlogic.gdx.scenes.scene2d.actions.AddListenerAction;
import com.badlogic.gdx.scenes.scene2d.actions.AfterAction;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.LayoutAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveActorAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveListenerAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.badlogic.gdx.scenes.scene2d.actions.TimeScaleAction;
import com.badlogic.gdx.scenes.scene2d.actions.TouchableAction;
import com.badlogic.gdx.scenes.scene2d.actions.VisibleAction;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class Actions {
    public static <T extends Action> T action(Class<T> clazz) {
        Pool<T> pool = Pools.get(clazz);
        Action action = (Action)pool.obtain();
        action.setPool(pool);
        return (T)action;
    }

    public static AddAction addAction(Action action) {
        AddAction addAction = Actions.action(AddAction.class);
        addAction.setAction(action);
        return addAction;
    }

    public static AddAction addAction(Action action, Actor actor) {
        AddAction addAction = Actions.action(AddAction.class);
        addAction.setTarget(actor);
        addAction.setAction(action);
        return addAction;
    }

    public static RemoveAction removeAction(Action action) {
        RemoveAction removeAction = Actions.action(RemoveAction.class);
        removeAction.setAction(action);
        return removeAction;
    }

    public static RemoveAction removeAction(Action action, Actor actor) {
        RemoveAction removeAction = Actions.action(RemoveAction.class);
        removeAction.setTarget(actor);
        removeAction.setAction(action);
        return removeAction;
    }

    public static MoveToAction moveTo(float f2, float f3) {
        return Actions.moveTo(f2, f3, 0.0f, null);
    }

    public static MoveToAction moveTo(float f2, float f3, float f4) {
        return Actions.moveTo(f2, f3, f4, null);
    }

    public static MoveToAction moveTo(float f2, float f3, float f4, @Null Interpolation interpolation) {
        MoveToAction moveToAction = Actions.action(MoveToAction.class);
        moveToAction.setPosition(f2, f3);
        moveToAction.setDuration(f4);
        moveToAction.setInterpolation(interpolation);
        return moveToAction;
    }

    public static MoveToAction moveToAligned(float f2, float f3, int n2) {
        return Actions.moveToAligned(f2, f3, n2, 0.0f, null);
    }

    public static MoveToAction moveToAligned(float f2, float f3, int n2, float f4) {
        return Actions.moveToAligned(f2, f3, n2, f4, null);
    }

    public static MoveToAction moveToAligned(float f2, float f3, int n2, float f4, @Null Interpolation interpolation) {
        MoveToAction moveToAction = Actions.action(MoveToAction.class);
        moveToAction.setPosition(f2, f3, n2);
        moveToAction.setDuration(f4);
        moveToAction.setInterpolation(interpolation);
        return moveToAction;
    }

    public static MoveByAction moveBy(float f2, float f3) {
        return Actions.moveBy(f2, f3, 0.0f, null);
    }

    public static MoveByAction moveBy(float f2, float f3, float f4) {
        return Actions.moveBy(f2, f3, f4, null);
    }

    public static MoveByAction moveBy(float f2, float f3, float f4, @Null Interpolation interpolation) {
        MoveByAction moveByAction = Actions.action(MoveByAction.class);
        moveByAction.setAmount(f2, f3);
        moveByAction.setDuration(f4);
        moveByAction.setInterpolation(interpolation);
        return moveByAction;
    }

    public static SizeToAction sizeTo(float f2, float f3) {
        return Actions.sizeTo(f2, f3, 0.0f, null);
    }

    public static SizeToAction sizeTo(float f2, float f3, float f4) {
        return Actions.sizeTo(f2, f3, f4, null);
    }

    public static SizeToAction sizeTo(float f2, float f3, float f4, @Null Interpolation interpolation) {
        SizeToAction sizeToAction = Actions.action(SizeToAction.class);
        sizeToAction.setSize(f2, f3);
        sizeToAction.setDuration(f4);
        sizeToAction.setInterpolation(interpolation);
        return sizeToAction;
    }

    public static SizeByAction sizeBy(float f2, float f3) {
        return Actions.sizeBy(f2, f3, 0.0f, null);
    }

    public static SizeByAction sizeBy(float f2, float f3, float f4) {
        return Actions.sizeBy(f2, f3, f4, null);
    }

    public static SizeByAction sizeBy(float f2, float f3, float f4, @Null Interpolation interpolation) {
        SizeByAction sizeByAction = Actions.action(SizeByAction.class);
        sizeByAction.setAmount(f2, f3);
        sizeByAction.setDuration(f4);
        sizeByAction.setInterpolation(interpolation);
        return sizeByAction;
    }

    public static ScaleToAction scaleTo(float f2, float f3) {
        return Actions.scaleTo(f2, f3, 0.0f, null);
    }

    public static ScaleToAction scaleTo(float f2, float f3, float f4) {
        return Actions.scaleTo(f2, f3, f4, null);
    }

    public static ScaleToAction scaleTo(float f2, float f3, float f4, @Null Interpolation interpolation) {
        ScaleToAction scaleToAction = Actions.action(ScaleToAction.class);
        scaleToAction.setScale(f2, f3);
        scaleToAction.setDuration(f4);
        scaleToAction.setInterpolation(interpolation);
        return scaleToAction;
    }

    public static ScaleByAction scaleBy(float f2, float f3) {
        return Actions.scaleBy(f2, f3, 0.0f, null);
    }

    public static ScaleByAction scaleBy(float f2, float f3, float f4) {
        return Actions.scaleBy(f2, f3, f4, null);
    }

    public static ScaleByAction scaleBy(float f2, float f3, float f4, @Null Interpolation interpolation) {
        ScaleByAction scaleByAction = Actions.action(ScaleByAction.class);
        scaleByAction.setAmount(f2, f3);
        scaleByAction.setDuration(f4);
        scaleByAction.setInterpolation(interpolation);
        return scaleByAction;
    }

    public static RotateToAction rotateTo(float f2) {
        return Actions.rotateTo(f2, 0.0f, null);
    }

    public static RotateToAction rotateTo(float f2, float f3) {
        return Actions.rotateTo(f2, f3, null);
    }

    public static RotateToAction rotateTo(float f2, float f3, @Null Interpolation interpolation) {
        RotateToAction rotateToAction = Actions.action(RotateToAction.class);
        rotateToAction.setRotation(f2);
        rotateToAction.setDuration(f3);
        rotateToAction.setInterpolation(interpolation);
        return rotateToAction;
    }

    public static RotateByAction rotateBy(float f2) {
        return Actions.rotateBy(f2, 0.0f, null);
    }

    public static RotateByAction rotateBy(float f2, float f3) {
        return Actions.rotateBy(f2, f3, null);
    }

    public static RotateByAction rotateBy(float f2, float f3, @Null Interpolation interpolation) {
        RotateByAction rotateByAction = Actions.action(RotateByAction.class);
        rotateByAction.setAmount(f2);
        rotateByAction.setDuration(f3);
        rotateByAction.setInterpolation(interpolation);
        return rotateByAction;
    }

    public static ColorAction color(Color color) {
        return Actions.color(color, 0.0f, null);
    }

    public static ColorAction color(Color color, float f2) {
        return Actions.color(color, f2, null);
    }

    public static ColorAction color(Color color, float f2, @Null Interpolation interpolation) {
        ColorAction colorAction = Actions.action(ColorAction.class);
        colorAction.setEndColor(color);
        colorAction.setDuration(f2);
        colorAction.setInterpolation(interpolation);
        return colorAction;
    }

    public static AlphaAction alpha(float f2) {
        return Actions.alpha(f2, 0.0f, null);
    }

    public static AlphaAction alpha(float f2, float f3) {
        return Actions.alpha(f2, f3, null);
    }

    public static AlphaAction alpha(float f2, float f3, @Null Interpolation interpolation) {
        AlphaAction alphaAction = Actions.action(AlphaAction.class);
        alphaAction.setAlpha(f2);
        alphaAction.setDuration(f3);
        alphaAction.setInterpolation(interpolation);
        return alphaAction;
    }

    public static AlphaAction fadeOut(float f2) {
        return Actions.alpha(0.0f, f2, null);
    }

    public static AlphaAction fadeOut(float f2, @Null Interpolation interpolation) {
        AlphaAction alphaAction = Actions.action(AlphaAction.class);
        alphaAction.setAlpha(0.0f);
        alphaAction.setDuration(f2);
        alphaAction.setInterpolation(interpolation);
        return alphaAction;
    }

    public static AlphaAction fadeIn(float f2) {
        return Actions.alpha(1.0f, f2, null);
    }

    public static AlphaAction fadeIn(float f2, @Null Interpolation interpolation) {
        AlphaAction alphaAction = Actions.action(AlphaAction.class);
        alphaAction.setAlpha(1.0f);
        alphaAction.setDuration(f2);
        alphaAction.setInterpolation(interpolation);
        return alphaAction;
    }

    public static VisibleAction show() {
        return Actions.visible(true);
    }

    public static VisibleAction hide() {
        return Actions.visible(false);
    }

    public static VisibleAction visible(boolean bl2) {
        VisibleAction visibleAction = Actions.action(VisibleAction.class);
        visibleAction.setVisible(bl2);
        return visibleAction;
    }

    public static TouchableAction touchable(Touchable touchable) {
        TouchableAction touchableAction = Actions.action(TouchableAction.class);
        touchableAction.setTouchable(touchable);
        return touchableAction;
    }

    public static RemoveActorAction removeActor() {
        return Actions.action(RemoveActorAction.class);
    }

    public static RemoveActorAction removeActor(Actor actor) {
        RemoveActorAction removeActorAction = Actions.action(RemoveActorAction.class);
        removeActorAction.setTarget(actor);
        return removeActorAction;
    }

    public static DelayAction delay(float f2) {
        DelayAction delayAction = Actions.action(DelayAction.class);
        delayAction.setDuration(f2);
        return delayAction;
    }

    public static DelayAction delay(float f2, Action action) {
        DelayAction delayAction = Actions.action(DelayAction.class);
        delayAction.setDuration(f2);
        delayAction.setAction(action);
        return delayAction;
    }

    public static TimeScaleAction timeScale(float f2, Action action) {
        TimeScaleAction timeScaleAction = Actions.action(TimeScaleAction.class);
        timeScaleAction.setScale(f2);
        timeScaleAction.setAction(action);
        return timeScaleAction;
    }

    public static SequenceAction sequence(Action action) {
        SequenceAction sequenceAction = Actions.action(SequenceAction.class);
        sequenceAction.addAction(action);
        return sequenceAction;
    }

    public static SequenceAction sequence(Action action, Action action2) {
        SequenceAction sequenceAction = Actions.action(SequenceAction.class);
        sequenceAction.addAction(action);
        sequenceAction.addAction(action2);
        return sequenceAction;
    }

    public static SequenceAction sequence(Action action, Action action2, Action action3) {
        SequenceAction sequenceAction = Actions.action(SequenceAction.class);
        sequenceAction.addAction(action);
        sequenceAction.addAction(action2);
        sequenceAction.addAction(action3);
        return sequenceAction;
    }

    public static SequenceAction sequence(Action action, Action action2, Action action3, Action action4) {
        SequenceAction sequenceAction = Actions.action(SequenceAction.class);
        sequenceAction.addAction(action);
        sequenceAction.addAction(action2);
        sequenceAction.addAction(action3);
        sequenceAction.addAction(action4);
        return sequenceAction;
    }

    public static SequenceAction sequence(Action action, Action action2, Action action3, Action action4, Action action5) {
        SequenceAction sequenceAction = Actions.action(SequenceAction.class);
        sequenceAction.addAction(action);
        sequenceAction.addAction(action2);
        sequenceAction.addAction(action3);
        sequenceAction.addAction(action4);
        sequenceAction.addAction(action5);
        return sequenceAction;
    }

    public static SequenceAction sequence(Action ... actionArray) {
        SequenceAction sequenceAction = Actions.action(SequenceAction.class);
        int n2 = actionArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            sequenceAction.addAction(actionArray[i2]);
        }
        return sequenceAction;
    }

    public static SequenceAction sequence() {
        return Actions.action(SequenceAction.class);
    }

    public static ParallelAction parallel(Action action) {
        ParallelAction parallelAction = Actions.action(ParallelAction.class);
        parallelAction.addAction(action);
        return parallelAction;
    }

    public static ParallelAction parallel(Action action, Action action2) {
        ParallelAction parallelAction = Actions.action(ParallelAction.class);
        parallelAction.addAction(action);
        parallelAction.addAction(action2);
        return parallelAction;
    }

    public static ParallelAction parallel(Action action, Action action2, Action action3) {
        ParallelAction parallelAction = Actions.action(ParallelAction.class);
        parallelAction.addAction(action);
        parallelAction.addAction(action2);
        parallelAction.addAction(action3);
        return parallelAction;
    }

    public static ParallelAction parallel(Action action, Action action2, Action action3, Action action4) {
        ParallelAction parallelAction = Actions.action(ParallelAction.class);
        parallelAction.addAction(action);
        parallelAction.addAction(action2);
        parallelAction.addAction(action3);
        parallelAction.addAction(action4);
        return parallelAction;
    }

    public static ParallelAction parallel(Action action, Action action2, Action action3, Action action4, Action action5) {
        ParallelAction parallelAction = Actions.action(ParallelAction.class);
        parallelAction.addAction(action);
        parallelAction.addAction(action2);
        parallelAction.addAction(action3);
        parallelAction.addAction(action4);
        parallelAction.addAction(action5);
        return parallelAction;
    }

    public static ParallelAction parallel(Action ... actionArray) {
        ParallelAction parallelAction = Actions.action(ParallelAction.class);
        int n2 = actionArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            parallelAction.addAction(actionArray[i2]);
        }
        return parallelAction;
    }

    public static ParallelAction parallel() {
        return Actions.action(ParallelAction.class);
    }

    public static RepeatAction repeat(int n2, Action action) {
        RepeatAction repeatAction = Actions.action(RepeatAction.class);
        repeatAction.setCount(n2);
        repeatAction.setAction(action);
        return repeatAction;
    }

    public static RepeatAction forever(Action action) {
        RepeatAction repeatAction = Actions.action(RepeatAction.class);
        repeatAction.setCount(-1);
        repeatAction.setAction(action);
        return repeatAction;
    }

    public static RunnableAction run(Runnable runnable) {
        RunnableAction runnableAction = Actions.action(RunnableAction.class);
        runnableAction.setRunnable(runnable);
        return runnableAction;
    }

    public static LayoutAction layout(boolean bl2) {
        LayoutAction layoutAction = Actions.action(LayoutAction.class);
        layoutAction.setLayoutEnabled(bl2);
        return layoutAction;
    }

    public static AfterAction after(Action action) {
        AfterAction afterAction = Actions.action(AfterAction.class);
        afterAction.setAction(action);
        return afterAction;
    }

    public static AddListenerAction addListener(EventListener eventListener, boolean bl2) {
        AddListenerAction addListenerAction = Actions.action(AddListenerAction.class);
        addListenerAction.setListener(eventListener);
        addListenerAction.setCapture(bl2);
        return addListenerAction;
    }

    public static AddListenerAction addListener(EventListener eventListener, boolean bl2, Actor actor) {
        AddListenerAction addListenerAction = Actions.action(AddListenerAction.class);
        addListenerAction.setTarget(actor);
        addListenerAction.setListener(eventListener);
        addListenerAction.setCapture(bl2);
        return addListenerAction;
    }

    public static RemoveListenerAction removeListener(EventListener eventListener, boolean bl2) {
        RemoveListenerAction removeListenerAction = Actions.action(RemoveListenerAction.class);
        removeListenerAction.setListener(eventListener);
        removeListenerAction.setCapture(bl2);
        return removeListenerAction;
    }

    public static RemoveListenerAction removeListener(EventListener eventListener, boolean bl2, Actor actor) {
        RemoveListenerAction removeListenerAction = Actions.action(RemoveListenerAction.class);
        removeListenerAction.setTarget(actor);
        removeListenerAction.setListener(eventListener);
        removeListenerAction.setCapture(bl2);
        return removeListenerAction;
    }

    public static Action targeting(Actor actor, Action action) {
        action.setTarget(actor);
        return action;
    }
}

