/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.BaseAnimationController;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Pool;

public class AnimationController
extends BaseAnimationController {
    protected final Pool<AnimationDesc> animationPool = new Pool<AnimationDesc>(){

        @Override
        protected AnimationDesc newObject() {
            return new AnimationDesc();
        }
    };
    public AnimationDesc current;
    public AnimationDesc queued;
    public float queuedTransitionTime;
    public AnimationDesc previous;
    public float transitionCurrentTime;
    public float transitionTargetTime;
    public boolean inAction;
    public boolean paused;
    public boolean allowSameAnimation;
    private boolean justChangedAnimation = false;

    public AnimationController(ModelInstance modelInstance) {
        super(modelInstance);
    }

    private AnimationDesc obtain(Animation animation, float f2, float f3, int n2, float f4, AnimationListener animationListener) {
        if (animation == null) {
            return null;
        }
        AnimationDesc animationDesc = this.animationPool.obtain();
        animationDesc.animation = animation;
        animationDesc.listener = animationListener;
        animationDesc.loopCount = n2;
        animationDesc.speed = f4;
        animationDesc.offset = f2;
        animationDesc.duration = f3 < 0.0f ? animation.duration - f2 : f3;
        animationDesc.time = f4 < 0.0f ? animationDesc.duration : 0.0f;
        return animationDesc;
    }

    private AnimationDesc obtain(String string, float f2, float f3, int n2, float f4, AnimationListener animationListener) {
        if (string == null) {
            return null;
        }
        Animation animation = this.target.getAnimation(string);
        if (animation == null) {
            throw new GdxRuntimeException("Unknown animation: " + string);
        }
        return this.obtain(animation, f2, f3, n2, f4, animationListener);
    }

    private AnimationDesc obtain(AnimationDesc animationDesc) {
        return this.obtain(animationDesc.animation, animationDesc.offset, animationDesc.duration, animationDesc.loopCount, animationDesc.speed, animationDesc.listener);
    }

    public void update(float f2) {
        if (this.paused) {
            return;
        }
        if (this.previous != null) {
            float f3;
            this.transitionCurrentTime += f2;
            if (f3 >= this.transitionTargetTime) {
                this.removeAnimation(this.previous.animation);
                this.justChangedAnimation = true;
                this.animationPool.free(this.previous);
                this.previous = null;
            }
        }
        if (this.justChangedAnimation) {
            this.target.calculateTransforms();
            this.justChangedAnimation = false;
        }
        if (this.current == null || this.current.loopCount == 0 || this.current.animation == null) {
            return;
        }
        float f4 = this.current.update(f2);
        if (f4 >= 0.0f && this.queued != null) {
            this.inAction = false;
            this.animate(this.queued, this.queuedTransitionTime);
            this.queued = null;
            if (f4 > 0.0f) {
                this.update(f4);
            }
            return;
        }
        if (this.previous != null) {
            this.applyAnimations(this.previous.animation, this.previous.offset + this.previous.time, this.current.animation, this.current.offset + this.current.time, this.transitionCurrentTime / this.transitionTargetTime);
        } else {
            this.applyAnimation(this.current.animation, this.current.offset + this.current.time);
        }
    }

    public AnimationDesc setAnimation(String string) {
        return this.setAnimation(string, 1, 1.0f, null);
    }

    public AnimationDesc setAnimation(String string, int n2) {
        return this.setAnimation(string, n2, 1.0f, null);
    }

    public AnimationDesc setAnimation(String string, AnimationListener animationListener) {
        return this.setAnimation(string, 1, 1.0f, animationListener);
    }

    public AnimationDesc setAnimation(String string, int n2, AnimationListener animationListener) {
        return this.setAnimation(string, n2, 1.0f, animationListener);
    }

    public AnimationDesc setAnimation(String string, int n2, float f2, AnimationListener animationListener) {
        return this.setAnimation(string, 0.0f, -1.0f, n2, f2, animationListener);
    }

    public AnimationDesc setAnimation(String string, float f2, float f3, int n2, float f4, AnimationListener animationListener) {
        return this.setAnimation(this.obtain(string, f2, f3, n2, f4, animationListener));
    }

    protected AnimationDesc setAnimation(Animation animation, float f2, float f3, int n2, float f4, AnimationListener animationListener) {
        return this.setAnimation(this.obtain(animation, f2, f3, n2, f4, animationListener));
    }

    protected AnimationDesc setAnimation(AnimationDesc animationDesc) {
        if (this.current == null) {
            this.current = animationDesc;
        } else {
            if (!this.allowSameAnimation && animationDesc != null && this.current.animation == animationDesc.animation) {
                animationDesc.time = this.current.time;
            } else {
                this.removeAnimation(this.current.animation);
            }
            this.animationPool.free(this.current);
            this.current = animationDesc;
        }
        this.justChangedAnimation = true;
        return animationDesc;
    }

    public AnimationDesc animate(String string, float f2) {
        return this.animate(string, 1, 1.0f, null, f2);
    }

    public AnimationDesc animate(String string, AnimationListener animationListener, float f2) {
        return this.animate(string, 1, 1.0f, animationListener, f2);
    }

    public AnimationDesc animate(String string, int n2, AnimationListener animationListener, float f2) {
        return this.animate(string, n2, 1.0f, animationListener, f2);
    }

    public AnimationDesc animate(String string, int n2, float f2, AnimationListener animationListener, float f3) {
        return this.animate(string, 0.0f, -1.0f, n2, f2, animationListener, f3);
    }

    public AnimationDesc animate(String string, float f2, float f3, int n2, float f4, AnimationListener animationListener, float f5) {
        return this.animate(this.obtain(string, f2, f3, n2, f4, animationListener), f5);
    }

    protected AnimationDesc animate(Animation animation, float f2, float f3, int n2, float f4, AnimationListener animationListener, float f5) {
        return this.animate(this.obtain(animation, f2, f3, n2, f4, animationListener), f5);
    }

    protected AnimationDesc animate(AnimationDesc animationDesc, float f2) {
        if (this.current == null || this.current.loopCount == 0) {
            this.current = animationDesc;
        } else if (this.inAction) {
            this.queue(animationDesc, f2);
        } else if (!this.allowSameAnimation && animationDesc != null && this.current.animation == animationDesc.animation) {
            animationDesc.time = this.current.time;
            this.animationPool.free(this.current);
            this.current = animationDesc;
        } else {
            if (this.previous != null) {
                this.removeAnimation(this.previous.animation);
                this.animationPool.free(this.previous);
            }
            this.previous = this.current;
            this.current = animationDesc;
            this.transitionCurrentTime = 0.0f;
            this.transitionTargetTime = f2;
        }
        return animationDesc;
    }

    public AnimationDesc queue(String string, int n2, float f2, AnimationListener animationListener, float f3) {
        return this.queue(string, 0.0f, -1.0f, n2, f2, animationListener, f3);
    }

    public AnimationDesc queue(String string, float f2, float f3, int n2, float f4, AnimationListener animationListener, float f5) {
        return this.queue(this.obtain(string, f2, f3, n2, f4, animationListener), f5);
    }

    protected AnimationDesc queue(Animation animation, float f2, float f3, int n2, float f4, AnimationListener animationListener, float f5) {
        return this.queue(this.obtain(animation, f2, f3, n2, f4, animationListener), f5);
    }

    protected AnimationDesc queue(AnimationDesc animationDesc, float f2) {
        if (this.current == null || this.current.loopCount == 0) {
            this.animate(animationDesc, f2);
        } else {
            if (this.queued != null) {
                this.animationPool.free(this.queued);
            }
            this.queued = animationDesc;
            this.queuedTransitionTime = f2;
            if (this.current.loopCount < 0) {
                this.current.loopCount = 1;
            }
        }
        return animationDesc;
    }

    public AnimationDesc action(String string, int n2, float f2, AnimationListener animationListener, float f3) {
        return this.action(string, 0.0f, -1.0f, n2, f2, animationListener, f3);
    }

    public AnimationDesc action(String string, float f2, float f3, int n2, float f4, AnimationListener animationListener, float f5) {
        return this.action(this.obtain(string, f2, f3, n2, f4, animationListener), f5);
    }

    protected AnimationDesc action(Animation animation, float f2, float f3, int n2, float f4, AnimationListener animationListener, float f5) {
        return this.action(this.obtain(animation, f2, f3, n2, f4, animationListener), f5);
    }

    protected AnimationDesc action(AnimationDesc animationDesc, float f2) {
        if (animationDesc.loopCount < 0) {
            throw new GdxRuntimeException("An action cannot be continuous");
        }
        if (this.current == null || this.current.loopCount == 0) {
            this.animate(animationDesc, f2);
        } else {
            AnimationDesc animationDesc2 = this.inAction ? null : this.obtain(this.current);
            this.inAction = false;
            this.animate(animationDesc, f2);
            this.inAction = true;
            if (animationDesc2 != null) {
                this.queue(animationDesc2, f2);
            }
        }
        return animationDesc;
    }

    public static class AnimationDesc {
        public AnimationListener listener;
        public Animation animation;
        public float speed;
        public float time;
        public float offset;
        public float duration;
        public int loopCount;

        protected AnimationDesc() {
        }

        protected float update(float f2) {
            if (this.loopCount != 0 && this.animation != null) {
                int n2;
                float f3 = this.speed * f2;
                if (!MathUtils.isZero(this.duration)) {
                    this.time += f3;
                    if (this.speed < 0.0f) {
                        float f4 = this.duration - this.time;
                        n2 = (int)Math.abs(f4 / this.duration);
                        f4 = Math.abs(f4 % this.duration);
                        this.time = this.duration - f4;
                    } else {
                        n2 = (int)Math.abs(this.time / this.duration);
                        this.time = Math.abs(this.time % this.duration);
                    }
                } else {
                    n2 = 1;
                }
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (this.loopCount > 0) {
                        --this.loopCount;
                    }
                    if (this.loopCount != 0 && this.listener != null) {
                        this.listener.onLoop(this);
                    }
                    if (this.loopCount != 0) continue;
                    float f5 = (float)(n2 - 1 - i2) * this.duration + (f3 < 0.0f ? this.duration - this.time : this.time);
                    float f6 = this.time = f3 < 0.0f ? 0.0f : this.duration;
                    if (this.listener != null) {
                        this.listener.onEnd(this);
                    }
                    return f5;
                }
                return -1.0f;
            }
            return f2;
        }
    }

    public static interface AnimationListener {
        public void onEnd(AnimationDesc var1);

        public void onLoop(AnimationDesc var1);
    }
}

