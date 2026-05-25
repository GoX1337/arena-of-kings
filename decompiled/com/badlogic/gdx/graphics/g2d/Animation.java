/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.reflect.ArrayReflection;

public class Animation<T> {
    T[] keyFrames;
    private float frameDuration;
    private float animationDuration;
    private int lastFrameNumber;
    private float lastStateTime;
    private PlayMode playMode = PlayMode.NORMAL;

    public Animation(float f2, Array<? extends T> array) {
        this.frameDuration = f2;
        Class<?> clazz = array.items.getClass().getComponentType();
        Object[] objectArray = (Object[])ArrayReflection.newInstance(clazz, array.size);
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = array.get(i2);
        }
        this.setKeyFrames(objectArray);
    }

    public Animation(float f2, Array<? extends T> array, PlayMode playMode) {
        this(f2, array);
        this.setPlayMode(playMode);
    }

    public Animation(float f2, T ... TArray) {
        this.frameDuration = f2;
        this.setKeyFrames(TArray);
    }

    public T getKeyFrame(float f2, boolean bl2) {
        PlayMode playMode = this.playMode;
        if (bl2 && (this.playMode == PlayMode.NORMAL || this.playMode == PlayMode.REVERSED)) {
            this.playMode = this.playMode == PlayMode.NORMAL ? PlayMode.LOOP : PlayMode.LOOP_REVERSED;
        } else if (!bl2 && this.playMode != PlayMode.NORMAL && this.playMode != PlayMode.REVERSED) {
            this.playMode = this.playMode == PlayMode.LOOP_REVERSED ? PlayMode.REVERSED : PlayMode.LOOP;
        }
        T t2 = this.getKeyFrame(f2);
        this.playMode = playMode;
        return t2;
    }

    public T getKeyFrame(float f2) {
        int n2 = this.getKeyFrameIndex(f2);
        return this.keyFrames[n2];
    }

    public int getKeyFrameIndex(float f2) {
        if (this.keyFrames.length == 1) {
            return 0;
        }
        int n2 = (int)(f2 / this.frameDuration);
        switch (this.playMode) {
            case NORMAL: {
                n2 = Math.min(this.keyFrames.length - 1, n2);
                break;
            }
            case LOOP: {
                n2 %= this.keyFrames.length;
                break;
            }
            case LOOP_PINGPONG: {
                if ((n2 %= this.keyFrames.length * 2 - 2) < this.keyFrames.length) break;
                n2 = this.keyFrames.length - 2 - (n2 - this.keyFrames.length);
                break;
            }
            case LOOP_RANDOM: {
                int n3 = (int)(this.lastStateTime / this.frameDuration);
                if (n3 != n2) {
                    n2 = MathUtils.random(this.keyFrames.length - 1);
                    break;
                }
                n2 = this.lastFrameNumber;
                break;
            }
            case REVERSED: {
                n2 = Math.max(this.keyFrames.length - n2 - 1, 0);
                break;
            }
            case LOOP_REVERSED: {
                n2 %= this.keyFrames.length;
                n2 = this.keyFrames.length - n2 - 1;
            }
        }
        this.lastFrameNumber = n2;
        this.lastStateTime = f2;
        return n2;
    }

    public T[] getKeyFrames() {
        return this.keyFrames;
    }

    protected void setKeyFrames(T ... TArray) {
        this.keyFrames = TArray;
        this.animationDuration = (float)TArray.length * this.frameDuration;
    }

    public PlayMode getPlayMode() {
        return this.playMode;
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public boolean isAnimationFinished(float f2) {
        int n2 = (int)(f2 / this.frameDuration);
        return this.keyFrames.length - 1 < n2;
    }

    public void setFrameDuration(float f2) {
        this.frameDuration = f2;
        this.animationDuration = (float)this.keyFrames.length * f2;
    }

    public float getFrameDuration() {
        return this.frameDuration;
    }

    public float getAnimationDuration() {
        return this.animationDuration;
    }

    public static enum PlayMode {
        NORMAL,
        REVERSED,
        LOOP,
        LOOP_REVERSED,
        LOOP_PINGPONG,
        LOOP_RANDOM;

    }
}

