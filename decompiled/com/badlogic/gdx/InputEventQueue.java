/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.NumberUtils;

public class InputEventQueue {
    private static final int SKIP = -1;
    private static final int KEY_DOWN = 0;
    private static final int KEY_UP = 1;
    private static final int KEY_TYPED = 2;
    private static final int TOUCH_DOWN = 3;
    private static final int TOUCH_UP = 4;
    private static final int TOUCH_DRAGGED = 5;
    private static final int MOUSE_MOVED = 6;
    private static final int SCROLLED = 7;
    private final IntArray queue = new IntArray();
    private final IntArray processingQueue = new IntArray();
    private long currentEventTime;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void drain(@Null InputProcessor inputProcessor) {
        Object object = this;
        synchronized (object) {
            if (inputProcessor == null) {
                this.queue.clear();
                return;
            }
            this.processingQueue.addAll(this.queue);
            this.queue.clear();
        }
        object = this.processingQueue.items;
        int n2 = 0;
        int n3 = this.processingQueue.size;
        block14: while (n2 < n3) {
            Object object2 = object[n2++];
            this.currentEventTime = (long)object[n2++] << 32 | (long)object[n2++] & 0xFFFFFFFFL;
            switch (object2) {
                case -1: {
                    n2 += object[n2];
                    continue block14;
                }
                case 0: {
                    inputProcessor.keyDown((int)object[n2++]);
                    continue block14;
                }
                case 1: {
                    inputProcessor.keyUp((int)object[n2++]);
                    continue block14;
                }
                case 2: {
                    inputProcessor.keyTyped((char)object[n2++]);
                    continue block14;
                }
                case 3: {
                    inputProcessor.touchDown((int)object[n2++], (int)object[n2++], (int)object[n2++], (int)object[n2++]);
                    continue block14;
                }
                case 4: {
                    inputProcessor.touchUp((int)object[n2++], (int)object[n2++], (int)object[n2++], (int)object[n2++]);
                    continue block14;
                }
                case 5: {
                    inputProcessor.touchDragged((int)object[n2++], (int)object[n2++], (int)object[n2++]);
                    continue block14;
                }
                case 6: {
                    inputProcessor.mouseMoved((int)object[n2++], (int)object[n2++]);
                    continue block14;
                }
                case 7: {
                    inputProcessor.scrolled(NumberUtils.intBitsToFloat((int)object[n2++]), NumberUtils.intBitsToFloat((int)object[n2++]));
                    continue block14;
                }
            }
            throw new RuntimeException();
        }
        this.processingQueue.clear();
    }

    private synchronized int next(int n2, int n3) {
        int[] nArray = this.queue.items;
        int n4 = this.queue.size;
        block11: while (n3 < n4) {
            int n5 = nArray[n3];
            if (n5 == n2) {
                return n3;
            }
            n3 += 3;
            switch (n5) {
                case -1: {
                    n3 += nArray[n3];
                    continue block11;
                }
                case 0: {
                    ++n3;
                    continue block11;
                }
                case 1: {
                    ++n3;
                    continue block11;
                }
                case 2: {
                    ++n3;
                    continue block11;
                }
                case 3: {
                    n3 += 4;
                    continue block11;
                }
                case 4: {
                    n3 += 4;
                    continue block11;
                }
                case 5: {
                    n3 += 3;
                    continue block11;
                }
                case 6: {
                    n3 += 2;
                    continue block11;
                }
                case 7: {
                    n3 += 2;
                    continue block11;
                }
            }
            throw new RuntimeException();
        }
        return -1;
    }

    private void queueTime(long l2) {
        this.queue.add((int)(l2 >> 32));
        this.queue.add((int)l2);
    }

    public synchronized boolean keyDown(int n2, long l2) {
        this.queue.add(0);
        this.queueTime(l2);
        this.queue.add(n2);
        return false;
    }

    public synchronized boolean keyUp(int n2, long l2) {
        this.queue.add(1);
        this.queueTime(l2);
        this.queue.add(n2);
        return false;
    }

    public synchronized boolean keyTyped(char c2, long l2) {
        this.queue.add(2);
        this.queueTime(l2);
        this.queue.add(c2);
        return false;
    }

    public synchronized boolean touchDown(int n2, int n3, int n4, int n5, long l2) {
        this.queue.add(3);
        this.queueTime(l2);
        this.queue.add(n2);
        this.queue.add(n3);
        this.queue.add(n4);
        this.queue.add(n5);
        return false;
    }

    public synchronized boolean touchUp(int n2, int n3, int n4, int n5, long l2) {
        this.queue.add(4);
        this.queueTime(l2);
        this.queue.add(n2);
        this.queue.add(n3);
        this.queue.add(n4);
        this.queue.add(n5);
        return false;
    }

    public synchronized boolean touchDragged(int n2, int n3, int n4, long l2) {
        int n5 = this.next(5, 0);
        while (n5 >= 0) {
            if (this.queue.get(n5 + 5) == n4) {
                this.queue.set(n5, -1);
                this.queue.set(n5 + 3, 3);
            }
            n5 = this.next(5, n5 + 6);
        }
        this.queue.add(5);
        this.queueTime(l2);
        this.queue.add(n2);
        this.queue.add(n3);
        this.queue.add(n4);
        return false;
    }

    public synchronized boolean mouseMoved(int n2, int n3, long l2) {
        int n4 = this.next(6, 0);
        while (n4 >= 0) {
            this.queue.set(n4, -1);
            this.queue.set(n4 + 3, 2);
            n4 = this.next(6, n4 + 5);
        }
        this.queue.add(6);
        this.queueTime(l2);
        this.queue.add(n2);
        this.queue.add(n3);
        return false;
    }

    public synchronized boolean scrolled(float f2, float f3, long l2) {
        this.queue.add(7);
        this.queueTime(l2);
        this.queue.add(NumberUtils.floatToIntBits(f2));
        this.queue.add(NumberUtils.floatToIntBits(f3));
        return false;
    }

    public long getCurrentEventTime() {
        return this.currentEventTime;
    }
}

