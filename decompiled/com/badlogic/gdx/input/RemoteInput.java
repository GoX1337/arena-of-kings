/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteInput
implements Input,
Runnable {
    private static final int MAX_TOUCHES = 20;
    public static int DEFAULT_PORT = 8190;
    private ServerSocket serverSocket;
    private float[] accel = new float[3];
    private float[] gyrate = new float[3];
    private float[] compass = new float[3];
    private boolean multiTouch = false;
    private float remoteWidth = 0.0f;
    private float remoteHeight = 0.0f;
    private boolean connected = false;
    private RemoteInputListener listener;
    int keyCount = 0;
    boolean[] keys = new boolean[256];
    boolean keyJustPressed = false;
    boolean[] justPressedKeys = new boolean[256];
    int[] deltaX = new int[20];
    int[] deltaY = new int[20];
    int[] touchX = new int[20];
    int[] touchY = new int[20];
    boolean[] isTouched = new boolean[20];
    boolean justTouched = false;
    InputProcessor processor = null;
    private final int port;
    public final String[] ips;

    public RemoteInput() {
        this(DEFAULT_PORT);
    }

    public RemoteInput(RemoteInputListener remoteInputListener) {
        this(DEFAULT_PORT, remoteInputListener);
    }

    public RemoteInput(int n2) {
        this(n2, null);
    }

    public RemoteInput(int n2, RemoteInputListener remoteInputListener) {
        this.listener = remoteInputListener;
        try {
            this.port = n2;
            this.serverSocket = new ServerSocket(n2);
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.start();
            InetAddress[] inetAddressArray = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
            this.ips = new String[inetAddressArray.length];
            for (int i2 = 0; i2 < inetAddressArray.length; ++i2) {
                this.ips[i2] = inetAddressArray[i2].getHostAddress();
            }
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Couldn't open listening socket at port '" + n2 + "'", exception);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.connected = false;
                if (this.listener != null) {
                    this.listener.onDisconnected();
                }
                System.out.println("listening, port " + this.port);
                Socket socket = null;
                socket = this.serverSocket.accept();
                socket.setTcpNoDelay(true);
                socket.setSoTimeout(3000);
                this.connected = true;
                if (this.listener != null) {
                    this.listener.onConnected();
                }
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                this.multiTouch = dataInputStream.readBoolean();
                while (true) {
                    int n2 = dataInputStream.readInt();
                    KeyEvent keyEvent = null;
                    TouchEvent touchEvent = null;
                    switch (n2) {
                        case 6: {
                            this.accel[0] = dataInputStream.readFloat();
                            this.accel[1] = dataInputStream.readFloat();
                            this.accel[2] = dataInputStream.readFloat();
                            break;
                        }
                        case 7: {
                            this.compass[0] = dataInputStream.readFloat();
                            this.compass[1] = dataInputStream.readFloat();
                            this.compass[2] = dataInputStream.readFloat();
                            break;
                        }
                        case 8: {
                            this.remoteWidth = dataInputStream.readFloat();
                            this.remoteHeight = dataInputStream.readFloat();
                            break;
                        }
                        case 9: {
                            this.gyrate[0] = dataInputStream.readFloat();
                            this.gyrate[1] = dataInputStream.readFloat();
                            this.gyrate[2] = dataInputStream.readFloat();
                            break;
                        }
                        case 0: {
                            keyEvent = new KeyEvent();
                            keyEvent.keyCode = dataInputStream.readInt();
                            keyEvent.type = 0;
                            break;
                        }
                        case 1: {
                            keyEvent = new KeyEvent();
                            keyEvent.keyCode = dataInputStream.readInt();
                            keyEvent.type = 1;
                            break;
                        }
                        case 2: {
                            keyEvent = new KeyEvent();
                            keyEvent.keyChar = dataInputStream.readChar();
                            keyEvent.type = 2;
                            break;
                        }
                        case 3: {
                            touchEvent = new TouchEvent();
                            touchEvent.x = (int)((float)dataInputStream.readInt() / this.remoteWidth * (float)Gdx.graphics.getWidth());
                            touchEvent.y = (int)((float)dataInputStream.readInt() / this.remoteHeight * (float)Gdx.graphics.getHeight());
                            touchEvent.pointer = dataInputStream.readInt();
                            touchEvent.type = 0;
                            break;
                        }
                        case 4: {
                            touchEvent = new TouchEvent();
                            touchEvent.x = (int)((float)dataInputStream.readInt() / this.remoteWidth * (float)Gdx.graphics.getWidth());
                            touchEvent.y = (int)((float)dataInputStream.readInt() / this.remoteHeight * (float)Gdx.graphics.getHeight());
                            touchEvent.pointer = dataInputStream.readInt();
                            touchEvent.type = 1;
                            break;
                        }
                        case 5: {
                            touchEvent = new TouchEvent();
                            touchEvent.x = (int)((float)dataInputStream.readInt() / this.remoteWidth * (float)Gdx.graphics.getWidth());
                            touchEvent.y = (int)((float)dataInputStream.readInt() / this.remoteHeight * (float)Gdx.graphics.getHeight());
                            touchEvent.pointer = dataInputStream.readInt();
                            touchEvent.type = 2;
                        }
                    }
                    Gdx.app.postRunnable(new EventTrigger(touchEvent, keyEvent));
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                continue;
            }
            break;
        }
    }

    public boolean isConnected() {
        return this.connected;
    }

    @Override
    public float getAccelerometerX() {
        return this.accel[0];
    }

    @Override
    public float getAccelerometerY() {
        return this.accel[1];
    }

    @Override
    public float getAccelerometerZ() {
        return this.accel[2];
    }

    @Override
    public float getGyroscopeX() {
        return this.gyrate[0];
    }

    @Override
    public float getGyroscopeY() {
        return this.gyrate[1];
    }

    @Override
    public float getGyroscopeZ() {
        return this.gyrate[2];
    }

    @Override
    public int getMaxPointers() {
        return 20;
    }

    @Override
    public int getX() {
        return this.touchX[0];
    }

    @Override
    public int getX(int n2) {
        return this.touchX[n2];
    }

    @Override
    public int getY() {
        return this.touchY[0];
    }

    @Override
    public int getY(int n2) {
        return this.touchY[n2];
    }

    @Override
    public boolean isTouched() {
        return this.isTouched[0];
    }

    @Override
    public boolean justTouched() {
        return this.justTouched;
    }

    @Override
    public boolean isTouched(int n2) {
        return this.isTouched[n2];
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
        if (n2 != 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.isTouched.length; ++i2) {
            if (!this.isTouched[i2]) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isButtonJustPressed(int n2) {
        return n2 == 0 && this.justTouched;
    }

    @Override
    public boolean isKeyPressed(int n2) {
        if (n2 == -1) {
            return this.keyCount > 0;
        }
        if (n2 < 0 || n2 > 255) {
            return false;
        }
        return this.keys[n2];
    }

    @Override
    public boolean isKeyJustPressed(int n2) {
        if (n2 == -1) {
            return this.keyJustPressed;
        }
        if (n2 < 0 || n2 > 255) {
            return false;
        }
        return this.justPressedKeys[n2];
    }

    @Override
    public void getTextInput(Input.TextInputListener textInputListener, String string, String string2, String string3) {
        Gdx.app.getInput().getTextInput(textInputListener, string, string2, string3);
    }

    @Override
    public void getTextInput(Input.TextInputListener textInputListener, String string, String string2, String string3, Input.OnscreenKeyboardType onscreenKeyboardType) {
        Gdx.app.getInput().getTextInput(textInputListener, string, string2, string3, onscreenKeyboardType);
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
        return this.compass[0];
    }

    @Override
    public float getPitch() {
        return this.compass[1];
    }

    @Override
    public float getRoll() {
        return this.compass[2];
    }

    @Override
    public void setCatchBackKey(boolean bl2) {
    }

    @Override
    public boolean isCatchBackKey() {
        return false;
    }

    @Override
    public void setCatchMenuKey(boolean bl2) {
    }

    @Override
    public boolean isCatchMenuKey() {
        return false;
    }

    @Override
    public void setCatchKey(int n2, boolean bl2) {
    }

    @Override
    public boolean isCatchKey(int n2) {
        return false;
    }

    @Override
    public void setInputProcessor(InputProcessor inputProcessor) {
        this.processor = inputProcessor;
    }

    @Override
    public InputProcessor getInputProcessor() {
        return this.processor;
    }

    public String[] getIPs() {
        return this.ips;
    }

    @Override
    public boolean isPeripheralAvailable(Input.Peripheral peripheral) {
        if (peripheral == Input.Peripheral.Accelerometer) {
            return true;
        }
        if (peripheral == Input.Peripheral.Compass) {
            return true;
        }
        if (peripheral == Input.Peripheral.MultitouchScreen) {
            return this.multiTouch;
        }
        return false;
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
    public void setCursorCatched(boolean bl2) {
    }

    @Override
    public boolean isCursorCatched() {
        return false;
    }

    @Override
    public int getDeltaX() {
        return this.deltaX[0];
    }

    @Override
    public int getDeltaX(int n2) {
        return this.deltaX[n2];
    }

    @Override
    public int getDeltaY() {
        return this.deltaY[0];
    }

    @Override
    public int getDeltaY(int n2) {
        return this.deltaY[n2];
    }

    @Override
    public void setCursorPosition(int n2, int n3) {
    }

    @Override
    public long getCurrentEventTime() {
        return 0L;
    }

    @Override
    public void getRotationMatrix(float[] fArray) {
    }

    class EventTrigger
    implements Runnable {
        TouchEvent touchEvent;
        KeyEvent keyEvent;

        public EventTrigger(TouchEvent touchEvent, KeyEvent keyEvent) {
            this.touchEvent = touchEvent;
            this.keyEvent = keyEvent;
        }

        @Override
        public void run() {
            RemoteInput.this.justTouched = false;
            if (RemoteInput.this.keyJustPressed) {
                RemoteInput.this.keyJustPressed = false;
                for (int i2 = 0; i2 < RemoteInput.this.justPressedKeys.length; ++i2) {
                    RemoteInput.this.justPressedKeys[i2] = false;
                }
            }
            if (RemoteInput.this.processor != null) {
                if (this.touchEvent != null) {
                    switch (this.touchEvent.type) {
                        case 0: {
                            RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
                            RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
                            RemoteInput.this.processor.touchDown(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer, 0);
                            RemoteInput.this.isTouched[this.touchEvent.pointer] = true;
                            RemoteInput.this.justTouched = true;
                            break;
                        }
                        case 1: {
                            RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
                            RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
                            RemoteInput.this.processor.touchUp(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer, 0);
                            RemoteInput.this.isTouched[this.touchEvent.pointer] = false;
                            break;
                        }
                        case 2: {
                            RemoteInput.this.deltaX[this.touchEvent.pointer] = this.touchEvent.x - RemoteInput.this.touchX[this.touchEvent.pointer];
                            RemoteInput.this.deltaY[this.touchEvent.pointer] = this.touchEvent.y - RemoteInput.this.touchY[this.touchEvent.pointer];
                            RemoteInput.this.processor.touchDragged(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer);
                        }
                    }
                    RemoteInput.this.touchX[this.touchEvent.pointer] = this.touchEvent.x;
                    RemoteInput.this.touchY[this.touchEvent.pointer] = this.touchEvent.y;
                }
                if (this.keyEvent != null) {
                    switch (this.keyEvent.type) {
                        case 0: {
                            RemoteInput.this.processor.keyDown(this.keyEvent.keyCode);
                            if (!RemoteInput.this.keys[this.keyEvent.keyCode]) {
                                ++RemoteInput.this.keyCount;
                                RemoteInput.this.keys[this.keyEvent.keyCode] = true;
                            }
                            RemoteInput.this.keyJustPressed = true;
                            RemoteInput.this.justPressedKeys[this.keyEvent.keyCode] = true;
                            break;
                        }
                        case 1: {
                            RemoteInput.this.processor.keyUp(this.keyEvent.keyCode);
                            if (!RemoteInput.this.keys[this.keyEvent.keyCode]) break;
                            --RemoteInput.this.keyCount;
                            RemoteInput.this.keys[this.keyEvent.keyCode] = false;
                            break;
                        }
                        case 2: {
                            RemoteInput.this.processor.keyTyped(this.keyEvent.keyChar);
                        }
                    }
                }
            } else {
                if (this.touchEvent != null) {
                    switch (this.touchEvent.type) {
                        case 0: {
                            RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
                            RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
                            RemoteInput.this.isTouched[this.touchEvent.pointer] = true;
                            RemoteInput.this.justTouched = true;
                            break;
                        }
                        case 1: {
                            RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
                            RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
                            RemoteInput.this.isTouched[this.touchEvent.pointer] = false;
                            break;
                        }
                        case 2: {
                            RemoteInput.this.deltaX[this.touchEvent.pointer] = this.touchEvent.x - RemoteInput.this.touchX[this.touchEvent.pointer];
                            RemoteInput.this.deltaY[this.touchEvent.pointer] = this.touchEvent.y - RemoteInput.this.touchY[this.touchEvent.pointer];
                        }
                    }
                    RemoteInput.this.touchX[this.touchEvent.pointer] = this.touchEvent.x;
                    RemoteInput.this.touchY[this.touchEvent.pointer] = this.touchEvent.y;
                }
                if (this.keyEvent != null) {
                    if (this.keyEvent.type == 0) {
                        if (!RemoteInput.this.keys[this.keyEvent.keyCode]) {
                            ++RemoteInput.this.keyCount;
                            RemoteInput.this.keys[this.keyEvent.keyCode] = true;
                        }
                        RemoteInput.this.keyJustPressed = true;
                        RemoteInput.this.justPressedKeys[this.keyEvent.keyCode] = true;
                    }
                    if (this.keyEvent.type == 1 && RemoteInput.this.keys[this.keyEvent.keyCode]) {
                        --RemoteInput.this.keyCount;
                        RemoteInput.this.keys[this.keyEvent.keyCode] = false;
                    }
                }
            }
        }
    }

    class TouchEvent {
        static final int TOUCH_DOWN = 0;
        static final int TOUCH_UP = 1;
        static final int TOUCH_DRAGGED = 2;
        long timeStamp;
        int type;
        int x;
        int y;
        int pointer;

        TouchEvent() {
        }
    }

    class KeyEvent {
        static final int KEY_DOWN = 0;
        static final int KEY_UP = 1;
        static final int KEY_TYPED = 2;
        long timeStamp;
        int type;
        int keyCode;
        char keyChar;

        KeyEvent() {
        }
    }

    public static interface RemoteInputListener {
        public void onConnected();

        public void onDisconnected();
    }
}

