/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

public class InputMultiplexer
implements InputProcessor {
    private SnapshotArray<InputProcessor> processors = new SnapshotArray(4);

    public InputMultiplexer() {
    }

    public InputMultiplexer(InputProcessor ... inputProcessorArray) {
        this.processors.addAll((InputProcessor[])inputProcessorArray);
    }

    public void addProcessor(int n2, InputProcessor inputProcessor) {
        if (inputProcessor == null) {
            throw new NullPointerException("processor cannot be null");
        }
        this.processors.insert(n2, inputProcessor);
    }

    public void removeProcessor(int n2) {
        this.processors.removeIndex(n2);
    }

    public void addProcessor(InputProcessor inputProcessor) {
        if (inputProcessor == null) {
            throw new NullPointerException("processor cannot be null");
        }
        this.processors.add(inputProcessor);
    }

    public void removeProcessor(InputProcessor inputProcessor) {
        this.processors.removeValue(inputProcessor, true);
    }

    public int size() {
        return this.processors.size;
    }

    public void clear() {
        this.processors.clear();
    }

    public void setProcessors(InputProcessor ... inputProcessorArray) {
        this.processors.clear();
        this.processors.addAll((InputProcessor[])inputProcessorArray);
    }

    public void setProcessors(Array<InputProcessor> array) {
        this.processors.clear();
        this.processors.addAll(array);
    }

    public SnapshotArray<InputProcessor> getProcessors() {
        return this.processors;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean keyDown(int n2) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n3 = this.processors.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!inputProcessorArray[i2].keyDown(n2)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean keyUp(int n2) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n3 = this.processors.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!inputProcessorArray[i2].keyUp(n2)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean keyTyped(char c2) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n2 = this.processors.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!inputProcessorArray[i2].keyTyped(c2)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n6 = this.processors.size;
            for (int i2 = 0; i2 < n6; ++i2) {
                if (!inputProcessorArray[i2].touchDown(n2, n3, n4, n5)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n6 = this.processors.size;
            for (int i2 = 0; i2 < n6; ++i2) {
                if (!inputProcessorArray[i2].touchUp(n2, n3, n4, n5)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n5 = this.processors.size;
            for (int i2 = 0; i2 < n5; ++i2) {
                if (!inputProcessorArray[i2].touchDragged(n2, n3, n4)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean mouseMoved(int n2, int n3) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n4 = this.processors.size;
            for (int i2 = 0; i2 < n4; ++i2) {
                if (!inputProcessorArray[i2].mouseMoved(n2, n3)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean scrolled(float f2, float f3) {
        InputProcessor[] inputProcessorArray = this.processors.begin();
        try {
            int n2 = this.processors.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!inputProcessorArray[i2].scrolled(f2, f3)) continue;
                boolean bl2 = true;
                return bl2;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }
}

