/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

public class GestureDetector
extends InputAdapter {
    final GestureListener listener;
    private float tapRectangleWidth;
    private float tapRectangleHeight;
    private long tapCountInterval;
    private float longPressSeconds;
    private long maxFlingDelay;
    private boolean inTapRectangle;
    private int tapCount;
    private long lastTapTime;
    private float lastTapX;
    private float lastTapY;
    private int lastTapButton;
    private int lastTapPointer;
    boolean longPressFired;
    private boolean pinching;
    private boolean panning;
    private final VelocityTracker tracker = new VelocityTracker();
    private float tapRectangleCenterX;
    private float tapRectangleCenterY;
    private long touchDownTime;
    Vector2 pointer1 = new Vector2();
    private final Vector2 pointer2 = new Vector2();
    private final Vector2 initialPointer1 = new Vector2();
    private final Vector2 initialPointer2 = new Vector2();
    private final Timer.Task longPressTask = new Timer.Task(){

        @Override
        public void run() {
            if (!GestureDetector.this.longPressFired) {
                GestureDetector.this.longPressFired = GestureDetector.this.listener.longPress(GestureDetector.this.pointer1.x, GestureDetector.this.pointer1.y);
            }
        }
    };

    public GestureDetector(GestureListener gestureListener) {
        this(20.0f, 0.4f, 1.1f, 2.1474836E9f, gestureListener);
    }

    public GestureDetector(float f2, float f3, float f4, float f5, GestureListener gestureListener) {
        this(f2, f2, f3, f4, f5, gestureListener);
    }

    public GestureDetector(float f2, float f3, float f4, float f5, float f6, GestureListener gestureListener) {
        if (gestureListener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        this.tapRectangleWidth = f2;
        this.tapRectangleHeight = f3;
        this.tapCountInterval = (long)(f4 * 1.0E9f);
        this.longPressSeconds = f5;
        this.maxFlingDelay = (long)(f6 * 1.0E9f);
        this.listener = gestureListener;
    }

    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        return this.touchDown((float)n2, (float)n3, n4, n5);
    }

    public boolean touchDown(float f2, float f3, int n2, int n3) {
        if (n2 > 1) {
            return false;
        }
        if (n2 == 0) {
            this.pointer1.set(f2, f3);
            this.touchDownTime = Gdx.input.getCurrentEventTime();
            this.tracker.start(f2, f3, this.touchDownTime);
            if (Gdx.input.isTouched(1)) {
                this.inTapRectangle = false;
                this.pinching = true;
                this.initialPointer1.set(this.pointer1);
                this.initialPointer2.set(this.pointer2);
                this.longPressTask.cancel();
            } else {
                this.inTapRectangle = true;
                this.pinching = false;
                this.longPressFired = false;
                this.tapRectangleCenterX = f2;
                this.tapRectangleCenterY = f3;
                if (!this.longPressTask.isScheduled()) {
                    Timer.schedule(this.longPressTask, this.longPressSeconds);
                }
            }
        } else {
            this.pointer2.set(f2, f3);
            this.inTapRectangle = false;
            this.pinching = true;
            this.initialPointer1.set(this.pointer1);
            this.initialPointer2.set(this.pointer2);
            this.longPressTask.cancel();
        }
        return this.listener.touchDown(f2, f3, n2, n3);
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        return this.touchDragged((float)n2, (float)n3, n4);
    }

    public boolean touchDragged(float f2, float f3, int n2) {
        if (n2 > 1) {
            return false;
        }
        if (this.longPressFired) {
            return false;
        }
        if (n2 == 0) {
            this.pointer1.set(f2, f3);
        } else {
            this.pointer2.set(f2, f3);
        }
        if (this.pinching) {
            if (this.listener != null) {
                boolean bl2 = this.listener.pinch(this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
                return this.listener.zoom(this.initialPointer1.dst(this.initialPointer2), this.pointer1.dst(this.pointer2)) || bl2;
            }
            return false;
        }
        this.tracker.update(f2, f3, Gdx.input.getCurrentEventTime());
        if (this.inTapRectangle && !this.isWithinTapRectangle(f2, f3, this.tapRectangleCenterX, this.tapRectangleCenterY)) {
            this.longPressTask.cancel();
            this.inTapRectangle = false;
        }
        if (!this.inTapRectangle) {
            this.panning = true;
            return this.listener.pan(f2, f3, this.tracker.deltaX, this.tracker.deltaY);
        }
        return false;
    }

    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        return this.touchUp((float)n2, (float)n3, n4, n5);
    }

    public boolean touchUp(float f2, float f3, int n2, int n3) {
        long l2;
        if (n2 > 1) {
            return false;
        }
        if (this.inTapRectangle && !this.isWithinTapRectangle(f2, f3, this.tapRectangleCenterX, this.tapRectangleCenterY)) {
            this.inTapRectangle = false;
        }
        boolean bl2 = this.panning;
        this.panning = false;
        this.longPressTask.cancel();
        if (this.longPressFired) {
            return false;
        }
        if (this.inTapRectangle) {
            if (this.lastTapButton != n3 || this.lastTapPointer != n2 || TimeUtils.nanoTime() - this.lastTapTime > this.tapCountInterval || !this.isWithinTapRectangle(f2, f3, this.lastTapX, this.lastTapY)) {
                this.tapCount = 0;
            }
            ++this.tapCount;
            this.lastTapTime = TimeUtils.nanoTime();
            this.lastTapX = f2;
            this.lastTapY = f3;
            this.lastTapButton = n3;
            this.lastTapPointer = n2;
            this.touchDownTime = 0L;
            return this.listener.tap(f2, f3, this.tapCount, n3);
        }
        if (this.pinching) {
            this.pinching = false;
            this.listener.pinchStop();
            this.panning = true;
            if (n2 == 0) {
                this.tracker.start(this.pointer2.x, this.pointer2.y, Gdx.input.getCurrentEventTime());
            } else {
                this.tracker.start(this.pointer1.x, this.pointer1.y, Gdx.input.getCurrentEventTime());
            }
            return false;
        }
        boolean bl3 = false;
        if (bl2 && !this.panning) {
            bl3 = this.listener.panStop(f2, f3, n2, n3);
        }
        if ((l2 = Gdx.input.getCurrentEventTime()) - this.touchDownTime <= this.maxFlingDelay) {
            this.tracker.update(f2, f3, l2);
            bl3 = this.listener.fling(this.tracker.getVelocityX(), this.tracker.getVelocityY(), n3) || bl3;
        }
        this.touchDownTime = 0L;
        return bl3;
    }

    public void cancel() {
        this.longPressTask.cancel();
        this.longPressFired = true;
    }

    public boolean isLongPressed() {
        return this.isLongPressed(this.longPressSeconds);
    }

    public boolean isLongPressed(float f2) {
        if (this.touchDownTime == 0L) {
            return false;
        }
        return TimeUtils.nanoTime() - this.touchDownTime > (long)(f2 * 1.0E9f);
    }

    public boolean isPanning() {
        return this.panning;
    }

    public void reset() {
        this.touchDownTime = 0L;
        this.panning = false;
        this.inTapRectangle = false;
        this.tracker.lastTime = 0L;
    }

    private boolean isWithinTapRectangle(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f4) < this.tapRectangleWidth && Math.abs(f3 - f5) < this.tapRectangleHeight;
    }

    public void invalidateTapSquare() {
        this.inTapRectangle = false;
    }

    public void setTapSquareSize(float f2) {
        this.setTapRectangleSize(f2, f2);
    }

    public void setTapRectangleSize(float f2, float f3) {
        this.tapRectangleWidth = f2;
        this.tapRectangleHeight = f3;
    }

    public void setTapCountInterval(float f2) {
        this.tapCountInterval = (long)(f2 * 1.0E9f);
    }

    public void setLongPressSeconds(float f2) {
        this.longPressSeconds = f2;
    }

    public void setMaxFlingDelay(long l2) {
        this.maxFlingDelay = l2;
    }

    static class VelocityTracker {
        int sampleSize = 10;
        float lastX;
        float lastY;
        float deltaX;
        float deltaY;
        long lastTime;
        int numSamples;
        float[] meanX = new float[this.sampleSize];
        float[] meanY = new float[this.sampleSize];
        long[] meanTime = new long[this.sampleSize];

        VelocityTracker() {
        }

        public void start(float f2, float f3, long l2) {
            this.lastX = f2;
            this.lastY = f3;
            this.deltaX = 0.0f;
            this.deltaY = 0.0f;
            this.numSamples = 0;
            for (int i2 = 0; i2 < this.sampleSize; ++i2) {
                this.meanX[i2] = 0.0f;
                this.meanY[i2] = 0.0f;
                this.meanTime[i2] = 0L;
            }
            this.lastTime = l2;
        }

        public void update(float f2, float f3, long l2) {
            this.deltaX = f2 - this.lastX;
            this.deltaY = f3 - this.lastY;
            this.lastX = f2;
            this.lastY = f3;
            long l3 = l2 - this.lastTime;
            this.lastTime = l2;
            int n2 = this.numSamples % this.sampleSize;
            this.meanX[n2] = this.deltaX;
            this.meanY[n2] = this.deltaY;
            this.meanTime[n2] = l3;
            ++this.numSamples;
        }

        public float getVelocityX() {
            float f2 = this.getAverage(this.meanX, this.numSamples);
            float f3 = (float)this.getAverage(this.meanTime, this.numSamples) / 1.0E9f;
            if (f3 == 0.0f) {
                return 0.0f;
            }
            return f2 / f3;
        }

        public float getVelocityY() {
            float f2 = this.getAverage(this.meanY, this.numSamples);
            float f3 = (float)this.getAverage(this.meanTime, this.numSamples) / 1.0E9f;
            if (f3 == 0.0f) {
                return 0.0f;
            }
            return f2 / f3;
        }

        private float getAverage(float[] fArray, int n2) {
            n2 = Math.min(this.sampleSize, n2);
            float f2 = 0.0f;
            for (int i2 = 0; i2 < n2; ++i2) {
                f2 += fArray[i2];
            }
            return f2 / (float)n2;
        }

        private long getAverage(long[] lArray, int n2) {
            n2 = Math.min(this.sampleSize, n2);
            long l2 = 0L;
            for (int i2 = 0; i2 < n2; ++i2) {
                l2 += lArray[i2];
            }
            if (n2 == 0) {
                return 0L;
            }
            return l2 / (long)n2;
        }

        private float getSum(float[] fArray, int n2) {
            n2 = Math.min(this.sampleSize, n2);
            float f2 = 0.0f;
            for (int i2 = 0; i2 < n2; ++i2) {
                f2 += fArray[i2];
            }
            if (n2 == 0) {
                return 0.0f;
            }
            return f2;
        }
    }

    public static class GestureAdapter
    implements GestureListener {
        @Override
        public boolean touchDown(float f2, float f3, int n2, int n3) {
            return false;
        }

        @Override
        public boolean tap(float f2, float f3, int n2, int n3) {
            return false;
        }

        @Override
        public boolean longPress(float f2, float f3) {
            return false;
        }

        @Override
        public boolean fling(float f2, float f3, int n2) {
            return false;
        }

        @Override
        public boolean pan(float f2, float f3, float f4, float f5) {
            return false;
        }

        @Override
        public boolean panStop(float f2, float f3, int n2, int n3) {
            return false;
        }

        @Override
        public boolean zoom(float f2, float f3) {
            return false;
        }

        @Override
        public boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
            return false;
        }

        @Override
        public void pinchStop() {
        }
    }

    public static interface GestureListener {
        public boolean touchDown(float var1, float var2, int var3, int var4);

        public boolean tap(float var1, float var2, int var3, int var4);

        public boolean longPress(float var1, float var2);

        public boolean fling(float var1, float var2, int var3);

        public boolean pan(float var1, float var2, float var3, float var4);

        public boolean panStop(float var1, float var2, int var3, int var4);

        public boolean zoom(float var1, float var2);

        public boolean pinch(Vector2 var1, Vector2 var2, Vector2 var3, Vector2 var4);

        public void pinchStop();
    }
}

