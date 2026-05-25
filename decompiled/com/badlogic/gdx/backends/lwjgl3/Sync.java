/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import org.lwjgl.glfw.GLFW;

class Sync {
    private static final long NANOS_IN_SECOND = 1000000000L;
    private long nextFrame = 0L;
    private boolean initialised = false;
    private RunningAvg sleepDurations = new RunningAvg(10);
    private RunningAvg yieldDurations = new RunningAvg(10);

    public void sync(int n2) {
        if (n2 <= 0) {
            return;
        }
        if (!this.initialised) {
            this.initialise();
        }
        try {
            long l2;
            long l3 = this.getTime();
            while (this.nextFrame - l3 > this.sleepDurations.avg()) {
                Thread.sleep(1L);
                l2 = this.getTime();
                this.sleepDurations.add(l2 - l3);
                l3 = l2;
            }
            this.sleepDurations.dampenForLowResTicker();
            l3 = this.getTime();
            while (this.nextFrame - l3 > this.yieldDurations.avg()) {
                Thread.yield();
                l2 = this.getTime();
                this.yieldDurations.add(l2 - l3);
                l3 = l2;
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.nextFrame = Math.max(this.nextFrame + 1000000000L / (long)n2, this.getTime());
    }

    private void initialise() {
        this.initialised = true;
        this.sleepDurations.init(1000000L);
        this.yieldDurations.init((int)((double)(-(this.getTime() - this.getTime())) * 1.333));
        this.nextFrame = this.getTime();
        String string = System.getProperty("os.name");
        if (string.startsWith("Win")) {
            Thread thread = new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            });
            thread.setName("LWJGL3 Timer");
            thread.setDaemon(true);
            thread.start();
        }
    }

    private long getTime() {
        return (long)(GLFW.glfwGetTime() * 1.0E9);
    }

    class RunningAvg {
        private final long[] slots;
        private int offset;
        private static final long DAMPEN_THRESHOLD = 10000000L;
        private static final float DAMPEN_FACTOR = 0.9f;

        public RunningAvg(int n2) {
            this.slots = new long[n2];
            this.offset = 0;
        }

        public void init(long l2) {
            while (this.offset < this.slots.length) {
                this.slots[this.offset++] = l2;
            }
        }

        public void add(long l2) {
            this.slots[this.offset++ % this.slots.length] = l2;
            this.offset %= this.slots.length;
        }

        public long avg() {
            long l2 = 0L;
            for (int i2 = 0; i2 < this.slots.length; ++i2) {
                l2 += this.slots[i2];
            }
            return l2 / (long)this.slots.length;
        }

        public void dampenForLowResTicker() {
            if (this.avg() > 10000000L) {
                int n2 = 0;
                while (n2 < this.slots.length) {
                    int n3 = n2++;
                    this.slots[n3] = (long)((float)this.slots[n3] * 0.9f);
                }
            }
        }
    }
}

