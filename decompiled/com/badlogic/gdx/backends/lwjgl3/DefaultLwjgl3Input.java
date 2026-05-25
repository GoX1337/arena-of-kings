/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.AbstractInput;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputEventQueue;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class DefaultLwjgl3Input
extends AbstractInput
implements Lwjgl3Input {
    final Lwjgl3Window window;
    private InputProcessor inputProcessor;
    final InputEventQueue eventQueue = new InputEventQueue();
    int mouseX;
    int mouseY;
    int mousePressed;
    int deltaX;
    int deltaY;
    boolean justTouched;
    final boolean[] justPressedButtons = new boolean[5];
    char lastCharacter;
    private GLFWKeyCallback keyCallback = new GLFWKeyCallback(){

        @Override
        public void invoke(long l2, int n2, int n3, int n4, int n5) {
            DefaultLwjgl3Input.this.keyCallback(l2, n2, n3, n4, n5);
        }
    };
    GLFWCharCallback charCallback = new GLFWCharCallback(){

        @Override
        public void invoke(long l2, int n2) {
            if ((n2 & 0xFF00) == 63232) {
                return;
            }
            DefaultLwjgl3Input.this.lastCharacter = (char)n2;
            DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
            DefaultLwjgl3Input.this.eventQueue.keyTyped((char)n2, System.nanoTime());
        }
    };
    private GLFWScrollCallback scrollCallback = new GLFWScrollCallback(){

        @Override
        public void invoke(long l2, double d2, double d3) {
            DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
            DefaultLwjgl3Input.this.eventQueue.scrolled(-((float)d2), -((float)d3), System.nanoTime());
        }
    };
    private GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback(){
        private int logicalMouseY;
        private int logicalMouseX;

        @Override
        public void invoke(long l2, double d2, double d3) {
            DefaultLwjgl3Input.this.deltaX = (int)d2 - this.logicalMouseX;
            DefaultLwjgl3Input.this.deltaY = (int)d3 - this.logicalMouseY;
            DefaultLwjgl3Input.this.mouseX = this.logicalMouseX = (int)d2;
            DefaultLwjgl3Input.this.mouseY = this.logicalMouseY = (int)d3;
            if (DefaultLwjgl3Input.this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
                float f2 = (float)DefaultLwjgl3Input.this.window.getGraphics().getBackBufferWidth() / (float)DefaultLwjgl3Input.this.window.getGraphics().getLogicalWidth();
                float f3 = (float)DefaultLwjgl3Input.this.window.getGraphics().getBackBufferHeight() / (float)DefaultLwjgl3Input.this.window.getGraphics().getLogicalHeight();
                DefaultLwjgl3Input.this.deltaX = (int)((float)DefaultLwjgl3Input.this.deltaX * f2);
                DefaultLwjgl3Input.this.deltaY = (int)((float)DefaultLwjgl3Input.this.deltaY * f3);
                DefaultLwjgl3Input.this.mouseX = (int)((float)DefaultLwjgl3Input.this.mouseX * f2);
                DefaultLwjgl3Input.this.mouseY = (int)((float)DefaultLwjgl3Input.this.mouseY * f3);
            }
            DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
            long l3 = System.nanoTime();
            if (DefaultLwjgl3Input.this.mousePressed > 0) {
                DefaultLwjgl3Input.this.eventQueue.touchDragged(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, l3);
            } else {
                DefaultLwjgl3Input.this.eventQueue.mouseMoved(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, l3);
            }
        }
    };
    private GLFWMouseButtonCallback mouseButtonCallback = new GLFWMouseButtonCallback(){

        @Override
        public void invoke(long l2, int n2, int n3, int n4) {
            int n5 = this.toGdxButton(n2);
            if (n2 != -1 && n5 == -1) {
                return;
            }
            long l3 = System.nanoTime();
            if (n3 == 1) {
                ++DefaultLwjgl3Input.this.mousePressed;
                DefaultLwjgl3Input.this.justTouched = true;
                DefaultLwjgl3Input.this.justPressedButtons[n5] = true;
                DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
                DefaultLwjgl3Input.this.eventQueue.touchDown(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, n5, l3);
            } else {
                DefaultLwjgl3Input.this.mousePressed = Math.max(0, DefaultLwjgl3Input.this.mousePressed - 1);
                DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
                DefaultLwjgl3Input.this.eventQueue.touchUp(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, n5, l3);
            }
        }

        private int toGdxButton(int n2) {
            if (n2 == 0) {
                return 0;
            }
            if (n2 == 1) {
                return 1;
            }
            if (n2 == 2) {
                return 2;
            }
            if (n2 == 3) {
                return 3;
            }
            if (n2 == 4) {
                return 4;
            }
            return -1;
        }
    };

    public DefaultLwjgl3Input(Lwjgl3Window lwjgl3Window) {
        this.window = lwjgl3Window;
        this.windowHandleChanged(lwjgl3Window.getWindowHandle());
    }

    void keyCallback(long l2, int n2, int n3, int n4, int n5) {
        switch (n4) {
            case 1: {
                n2 = this.getGdxKeyCode(n2);
                this.eventQueue.keyDown(n2, System.nanoTime());
                ++this.pressedKeyCount;
                this.keyJustPressed = true;
                this.pressedKeys[n2] = true;
                this.justPressedKeys[n2] = true;
                this.window.getGraphics().requestRendering();
                this.lastCharacter = '\u0000';
                char c2 = this.characterForKeyCode(n2);
                if (c2 == '\u0000') break;
                this.charCallback.invoke(l2, c2);
                break;
            }
            case 0: {
                n2 = this.getGdxKeyCode(n2);
                --this.pressedKeyCount;
                this.pressedKeys[n2] = false;
                this.window.getGraphics().requestRendering();
                this.eventQueue.keyUp(n2, System.nanoTime());
                break;
            }
            case 2: {
                if (this.lastCharacter == '\u0000') break;
                this.window.getGraphics().requestRendering();
                this.eventQueue.keyTyped(this.lastCharacter, System.nanoTime());
            }
        }
    }

    @Override
    public void resetPollingStates() {
        int n2;
        this.justTouched = false;
        this.keyJustPressed = false;
        for (n2 = 0; n2 < this.justPressedKeys.length; ++n2) {
            this.justPressedKeys[n2] = false;
        }
        for (n2 = 0; n2 < this.justPressedButtons.length; ++n2) {
            this.justPressedButtons[n2] = false;
        }
        this.eventQueue.drain(null);
    }

    @Override
    public void windowHandleChanged(long l2) {
        this.resetPollingStates();
        GLFW.glfwSetKeyCallback(this.window.getWindowHandle(), this.keyCallback);
        GLFW.glfwSetCharCallback(this.window.getWindowHandle(), this.charCallback);
        GLFW.glfwSetScrollCallback(this.window.getWindowHandle(), this.scrollCallback);
        GLFW.glfwSetCursorPosCallback(this.window.getWindowHandle(), this.cursorPosCallback);
        GLFW.glfwSetMouseButtonCallback(this.window.getWindowHandle(), this.mouseButtonCallback);
    }

    @Override
    public void update() {
        this.eventQueue.drain(this.inputProcessor);
    }

    @Override
    public void prepareNext() {
        int n2;
        if (this.justTouched) {
            this.justTouched = false;
            for (n2 = 0; n2 < this.justPressedButtons.length; ++n2) {
                this.justPressedButtons[n2] = false;
            }
        }
        if (this.keyJustPressed) {
            this.keyJustPressed = false;
            for (n2 = 0; n2 < this.justPressedKeys.length; ++n2) {
                this.justPressedKeys[n2] = false;
            }
        }
        this.deltaX = 0;
        this.deltaY = 0;
    }

    @Override
    public int getMaxPointers() {
        return 1;
    }

    @Override
    public int getX() {
        return this.mouseX;
    }

    @Override
    public int getX(int n2) {
        return n2 == 0 ? this.mouseX : 0;
    }

    @Override
    public int getDeltaX() {
        return this.deltaX;
    }

    @Override
    public int getDeltaX(int n2) {
        return n2 == 0 ? this.deltaX : 0;
    }

    @Override
    public int getY() {
        return this.mouseY;
    }

    @Override
    public int getY(int n2) {
        return n2 == 0 ? this.mouseY : 0;
    }

    @Override
    public int getDeltaY() {
        return this.deltaY;
    }

    @Override
    public int getDeltaY(int n2) {
        return n2 == 0 ? this.deltaY : 0;
    }

    @Override
    public boolean isTouched() {
        return GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 0) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 1) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 2) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 3) == 1 || GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 4) == 1;
    }

    @Override
    public boolean justTouched() {
        return this.justTouched;
    }

    @Override
    public boolean isTouched(int n2) {
        return n2 == 0 ? this.isTouched() : false;
    }

    @Override
    public float getPressure() {
        return this.getPressure(0);
    }

    @Override
    public float getPressure(int n2) {
        return this.isTouched(n2) ? 1.0f : 0.0f;
    }

    @Override
    public boolean isButtonPressed(int n2) {
        return GLFW.glfwGetMouseButton(this.window.getWindowHandle(), n2) == 1;
    }

    @Override
    public boolean isButtonJustPressed(int n2) {
        if (n2 < 0 || n2 >= this.justPressedButtons.length) {
            return false;
        }
        return this.justPressedButtons[n2];
    }

    @Override
    public void getTextInput(Input.TextInputListener textInputListener, String string, String string2, String string3) {
        this.getTextInput(textInputListener, string, string2, string3, Input.OnscreenKeyboardType.Default);
    }

    @Override
    public void getTextInput(Input.TextInputListener textInputListener, String string, String string2, String string3, Input.OnscreenKeyboardType onscreenKeyboardType) {
        textInputListener.canceled();
    }

    @Override
    public long getCurrentEventTime() {
        return this.eventQueue.getCurrentEventTime();
    }

    @Override
    public void setInputProcessor(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

    @Override
    public InputProcessor getInputProcessor() {
        return this.inputProcessor;
    }

    @Override
    public void setCursorCatched(boolean bl2) {
        GLFW.glfwSetInputMode(this.window.getWindowHandle(), 208897, bl2 ? 212995 : 212993);
    }

    @Override
    public boolean isCursorCatched() {
        return GLFW.glfwGetInputMode(this.window.getWindowHandle(), 208897) == 212995;
    }

    @Override
    public void setCursorPosition(int n2, int n3) {
        if (this.window.getConfig().hdpiMode == HdpiMode.Pixels) {
            float f2 = (float)this.window.getGraphics().getLogicalWidth() / (float)this.window.getGraphics().getBackBufferWidth();
            float f3 = (float)this.window.getGraphics().getLogicalHeight() / (float)this.window.getGraphics().getBackBufferHeight();
            n2 = (int)((float)n2 * f2);
            n3 = (int)((float)n3 * f3);
        }
        GLFW.glfwSetCursorPos(this.window.getWindowHandle(), n2, n3);
    }

    protected char characterForKeyCode(int n2) {
        switch (n2) {
            case 67: {
                return '\b';
            }
            case 61: {
                return '\t';
            }
            case 112: {
                return '\u007f';
            }
            case 66: 
            case 160: {
                return '\n';
            }
        }
        return '\u0000';
    }

    public int getGdxKeyCode(int n2) {
        switch (n2) {
            case 32: {
                return 62;
            }
            case 39: {
                return 75;
            }
            case 44: {
                return 55;
            }
            case 45: {
                return 69;
            }
            case 46: {
                return 56;
            }
            case 47: {
                return 76;
            }
            case 48: {
                return 7;
            }
            case 49: {
                return 8;
            }
            case 50: {
                return 9;
            }
            case 51: {
                return 10;
            }
            case 52: {
                return 11;
            }
            case 53: {
                return 12;
            }
            case 54: {
                return 13;
            }
            case 55: {
                return 14;
            }
            case 56: {
                return 15;
            }
            case 57: {
                return 16;
            }
            case 59: {
                return 74;
            }
            case 61: {
                return 70;
            }
            case 65: {
                return 29;
            }
            case 66: {
                return 30;
            }
            case 67: {
                return 31;
            }
            case 68: {
                return 32;
            }
            case 69: {
                return 33;
            }
            case 70: {
                return 34;
            }
            case 71: {
                return 35;
            }
            case 72: {
                return 36;
            }
            case 73: {
                return 37;
            }
            case 74: {
                return 38;
            }
            case 75: {
                return 39;
            }
            case 76: {
                return 40;
            }
            case 77: {
                return 41;
            }
            case 78: {
                return 42;
            }
            case 79: {
                return 43;
            }
            case 80: {
                return 44;
            }
            case 81: {
                return 45;
            }
            case 82: {
                return 46;
            }
            case 83: {
                return 47;
            }
            case 84: {
                return 48;
            }
            case 85: {
                return 49;
            }
            case 86: {
                return 50;
            }
            case 87: {
                return 51;
            }
            case 88: {
                return 52;
            }
            case 89: {
                return 53;
            }
            case 90: {
                return 54;
            }
            case 91: {
                return 71;
            }
            case 92: {
                return 73;
            }
            case 93: {
                return 72;
            }
            case 96: {
                return 68;
            }
            case 161: 
            case 162: {
                return 0;
            }
            case 256: {
                return 111;
            }
            case 257: {
                return 66;
            }
            case 258: {
                return 61;
            }
            case 259: {
                return 67;
            }
            case 260: {
                return 124;
            }
            case 261: {
                return 112;
            }
            case 262: {
                return 22;
            }
            case 263: {
                return 21;
            }
            case 264: {
                return 20;
            }
            case 265: {
                return 19;
            }
            case 266: {
                return 92;
            }
            case 267: {
                return 93;
            }
            case 268: {
                return 3;
            }
            case 269: {
                return 123;
            }
            case 280: {
                return 115;
            }
            case 281: {
                return 116;
            }
            case 283: {
                return 120;
            }
            case 284: {
                return 121;
            }
            case 290: {
                return 131;
            }
            case 291: {
                return 132;
            }
            case 292: {
                return 133;
            }
            case 293: {
                return 134;
            }
            case 294: {
                return 135;
            }
            case 295: {
                return 136;
            }
            case 296: {
                return 137;
            }
            case 297: {
                return 138;
            }
            case 298: {
                return 139;
            }
            case 299: {
                return 140;
            }
            case 300: {
                return 141;
            }
            case 301: {
                return 142;
            }
            case 302: {
                return 183;
            }
            case 303: {
                return 184;
            }
            case 304: {
                return 185;
            }
            case 305: {
                return 186;
            }
            case 306: {
                return 187;
            }
            case 307: {
                return 188;
            }
            case 308: {
                return 189;
            }
            case 309: {
                return 190;
            }
            case 310: {
                return 191;
            }
            case 311: {
                return 192;
            }
            case 312: {
                return 193;
            }
            case 313: {
                return 194;
            }
            case 314: {
                return 0;
            }
            case 282: {
                return 143;
            }
            case 320: {
                return 144;
            }
            case 321: {
                return 145;
            }
            case 322: {
                return 146;
            }
            case 323: {
                return 147;
            }
            case 324: {
                return 148;
            }
            case 325: {
                return 149;
            }
            case 326: {
                return 150;
            }
            case 327: {
                return 151;
            }
            case 328: {
                return 152;
            }
            case 329: {
                return 153;
            }
            case 330: {
                return 158;
            }
            case 331: {
                return 154;
            }
            case 332: {
                return 155;
            }
            case 333: {
                return 156;
            }
            case 334: {
                return 157;
            }
            case 335: {
                return 160;
            }
            case 336: {
                return 161;
            }
            case 340: {
                return 59;
            }
            case 341: {
                return 129;
            }
            case 342: {
                return 57;
            }
            case 343: {
                return 63;
            }
            case 344: {
                return 60;
            }
            case 345: {
                return 130;
            }
            case 346: {
                return 58;
            }
            case 347: {
                return 63;
            }
            case 348: {
                return 82;
            }
        }
        return 0;
    }

    @Override
    public void dispose() {
        this.keyCallback.free();
        this.charCallback.free();
        this.scrollCallback.free();
        this.cursorPosCallback.free();
        this.mouseButtonCallback.free();
    }

    @Override
    public float getAccelerometerX() {
        return 0.0f;
    }

    @Override
    public float getAccelerometerY() {
        return 0.0f;
    }

    @Override
    public float getAccelerometerZ() {
        return 0.0f;
    }

    @Override
    public boolean isPeripheralAvailable(Input.Peripheral peripheral) {
        return peripheral == Input.Peripheral.HardwareKeyboard;
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public Input.Orientation getNativeOrientation() {
        return Input.Orientation.Landscape;
    }

    @Override
    public void setOnscreenKeyboardVisible(boolean bl2) {
    }

    @Override
    public void setOnscreenKeyboardVisible(boolean bl2, Input.OnscreenKeyboardType onscreenKeyboardType) {
    }

    @Override
    public void vibrate(int n2) {
    }

    @Override
    public void vibrate(long[] lArray, int n2) {
    }

    @Override
    public void cancelVibrate() {
    }

    @Override
    public float getAzimuth() {
        return 0.0f;
    }

    @Override
    public float getPitch() {
        return 0.0f;
    }

    @Override
    public float getRoll() {
        return 0.0f;
    }

    @Override
    public void getRotationMatrix(float[] fArray) {
    }

    @Override
    public float getGyroscopeX() {
        return 0.0f;
    }

    @Override
    public float getGyroscopeY() {
        return 0.0f;
    }

    @Override
    public float getGyroscopeZ() {
        return 0.0f;
    }
}

