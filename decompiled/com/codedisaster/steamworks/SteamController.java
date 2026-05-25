/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamControllerActionSetHandle;
import com.codedisaster.steamworks.SteamControllerAnalogActionData;
import com.codedisaster.steamworks.SteamControllerAnalogActionHandle;
import com.codedisaster.steamworks.SteamControllerDigitalActionData;
import com.codedisaster.steamworks.SteamControllerDigitalActionHandle;
import com.codedisaster.steamworks.SteamControllerHandle;
import com.codedisaster.steamworks.SteamControllerMotionData;
import com.codedisaster.steamworks.SteamInterface;

public class SteamController
extends SteamInterface {
    public static final int STEAM_CONTROLLER_MAX_COUNT = 16;
    public static final int STEAM_CONTROLLER_MAX_ANALOG_ACTIONS = 16;
    public static final int STEAM_CONTROLLER_MAX_DIGITAL_ACTIONS = 128;
    public static final int STEAM_CONTROLLER_MAX_ORIGINS = 8;
    public static final long STEAM_CONTROLLER_HANDLE_ALL_CONTROLLERS = -1L;
    public static final float STEAM_CONTROLLER_MIN_ANALOG_ACTION_DATA = -1.0f;
    public static final float STEAM_CONTROLLER_MAX_ANALOG_ACTION_DATA = 1.0f;
    private long[] controllerHandles = new long[16];
    private int[] actionOrigins = new int[8];

    public SteamController() {
        super(SteamAPI.getSteamControllerPointer());
    }

    public boolean init() {
        return SteamController.init(this.pointer);
    }

    public boolean shutdown() {
        return SteamController.shutdown(this.pointer);
    }

    public void runFrame() {
        SteamController.runFrame(this.pointer);
    }

    public int getConnectedControllers(SteamControllerHandle[] steamControllerHandleArray) {
        if (steamControllerHandleArray.length < 16) {
            throw new IllegalArgumentException("Array size must be at least STEAM_CONTROLLER_MAX_COUNT");
        }
        int n2 = SteamController.getConnectedControllers(this.pointer, this.controllerHandles);
        for (int i2 = 0; i2 < n2; ++i2) {
            steamControllerHandleArray[i2] = new SteamControllerHandle(this.controllerHandles[i2]);
        }
        return n2;
    }

    public boolean showBindingPanel(SteamControllerHandle steamControllerHandle) {
        return SteamController.showBindingPanel(this.pointer, steamControllerHandle.handle);
    }

    public SteamControllerActionSetHandle getActionSetHandle(String string) {
        return new SteamControllerActionSetHandle(SteamController.getActionSetHandle(this.pointer, string));
    }

    public void activateActionSet(SteamControllerHandle steamControllerHandle, SteamControllerActionSetHandle steamControllerActionSetHandle) {
        SteamController.activateActionSet(this.pointer, steamControllerHandle.handle, steamControllerActionSetHandle.handle);
    }

    public SteamControllerActionSetHandle getCurrentActionSet(SteamControllerHandle steamControllerHandle) {
        return new SteamControllerActionSetHandle(SteamController.getCurrentActionSet(this.pointer, steamControllerHandle.handle));
    }

    public SteamControllerDigitalActionHandle getDigitalActionHandle(String string) {
        return new SteamControllerDigitalActionHandle(SteamController.getDigitalActionHandle(this.pointer, string));
    }

    public void getDigitalActionData(SteamControllerHandle steamControllerHandle, SteamControllerDigitalActionHandle steamControllerDigitalActionHandle, SteamControllerDigitalActionData steamControllerDigitalActionData) {
        SteamController.getDigitalActionData(this.pointer, steamControllerHandle.handle, steamControllerDigitalActionHandle.handle, steamControllerDigitalActionData);
    }

    public int getDigitalActionOrigins(SteamControllerHandle steamControllerHandle, SteamControllerActionSetHandle steamControllerActionSetHandle, SteamControllerDigitalActionHandle steamControllerDigitalActionHandle, ActionOrigin[] actionOriginArray) {
        if (actionOriginArray.length < 8) {
            throw new IllegalArgumentException("Array size must be at least STEAM_CONTROLLER_MAX_ORIGINS");
        }
        int n2 = SteamController.getDigitalActionOrigins(this.pointer, steamControllerHandle.handle, steamControllerActionSetHandle.handle, steamControllerDigitalActionHandle.handle, this.actionOrigins);
        for (int i2 = 0; i2 < n2; ++i2) {
            actionOriginArray[i2] = ActionOrigin.byOrdinal(this.actionOrigins[i2]);
        }
        return n2;
    }

    public SteamControllerAnalogActionHandle getAnalogActionHandle(String string) {
        return new SteamControllerAnalogActionHandle(SteamController.getAnalogActionHandle(this.pointer, string));
    }

    public void getAnalogActionData(SteamControllerHandle steamControllerHandle, SteamControllerAnalogActionHandle steamControllerAnalogActionHandle, SteamControllerAnalogActionData steamControllerAnalogActionData) {
        SteamController.getAnalogActionData(this.pointer, steamControllerHandle.handle, steamControllerAnalogActionHandle.handle, steamControllerAnalogActionData);
    }

    public int getAnalogActionOrigins(SteamControllerHandle steamControllerHandle, SteamControllerActionSetHandle steamControllerActionSetHandle, SteamControllerAnalogActionHandle steamControllerAnalogActionHandle, ActionOrigin[] actionOriginArray) {
        if (actionOriginArray.length < 8) {
            throw new IllegalArgumentException("Array size must be at least STEAM_CONTROLLER_MAX_ORIGINS");
        }
        int n2 = SteamController.getAnalogActionOrigins(this.pointer, steamControllerHandle.handle, steamControllerActionSetHandle.handle, steamControllerAnalogActionHandle.handle, this.actionOrigins);
        for (int i2 = 0; i2 < n2; ++i2) {
            actionOriginArray[i2] = ActionOrigin.byOrdinal(this.actionOrigins[i2]);
        }
        return n2;
    }

    public void stopAnalogActionMomentum(SteamControllerHandle steamControllerHandle, SteamControllerAnalogActionHandle steamControllerAnalogActionHandle) {
        SteamController.stopAnalogActionMomentum(this.pointer, steamControllerHandle.handle, steamControllerAnalogActionHandle.handle);
    }

    public void triggerHapticPulse(SteamControllerHandle steamControllerHandle, Pad pad, int n2) {
        SteamController.triggerHapticPulse(this.pointer, steamControllerHandle.handle, pad.ordinal(), n2);
    }

    public void triggerRepeatedHapticPulse(SteamControllerHandle steamControllerHandle, Pad pad, int n2, int n3, int n4, int n5) {
        SteamController.triggerRepeatedHapticPulse(this.pointer, steamControllerHandle.handle, pad.ordinal(), n2, n3, n4, n5);
    }

    public void triggerVibration(SteamControllerHandle steamControllerHandle, short s2, short s3) {
        SteamController.triggerVibration(this.pointer, steamControllerHandle.handle, s2, s3);
    }

    public void setLEDColor(SteamControllerHandle steamControllerHandle, int n2, int n3, int n4, LEDFlag lEDFlag) {
        SteamController.setLEDColor(this.pointer, steamControllerHandle.handle, (byte)(n2 & 0xFF), (byte)(n3 & 0xFF), (byte)(n4 & 0xFF), lEDFlag.ordinal());
    }

    public int getGamepadIndexForController(SteamControllerHandle steamControllerHandle) {
        return SteamController.getGamepadIndexForController(this.pointer, steamControllerHandle.handle);
    }

    public SteamControllerHandle getControllerForGamepadIndex(int n2) {
        return new SteamControllerHandle(SteamController.getControllerForGamepadIndex(this.pointer, n2));
    }

    public void getMotionData(SteamControllerHandle steamControllerHandle, SteamControllerMotionData steamControllerMotionData) {
        SteamController.getMotionData(this.pointer, steamControllerHandle.handle, steamControllerMotionData.data);
    }

    public boolean showDigitalActionOrigins(SteamControllerHandle steamControllerHandle, SteamControllerDigitalActionHandle steamControllerDigitalActionHandle, float f2, float f3, float f4) {
        return SteamController.showDigitalActionOrigins(this.pointer, steamControllerHandle.handle, steamControllerDigitalActionHandle.handle, f2, f3, f4);
    }

    public boolean showAnalogActionOrigins(SteamControllerHandle steamControllerHandle, SteamControllerAnalogActionHandle steamControllerAnalogActionHandle, float f2, float f3, float f4) {
        return SteamController.showAnalogActionOrigins(this.pointer, steamControllerHandle.handle, steamControllerAnalogActionHandle.handle, f2, f3, f4);
    }

    public String getStringForActionOrigin(ActionOrigin actionOrigin) {
        return SteamController.getStringForActionOrigin(this.pointer, actionOrigin.ordinal());
    }

    public String getGlyphForActionOrigin(ActionOrigin actionOrigin) {
        return SteamController.getGlyphForActionOrigin(this.pointer, actionOrigin.ordinal());
    }

    public InputType getInputTypeForHandle(SteamControllerHandle steamControllerHandle) {
        return InputType.byOrdinal(SteamController.getInputTypeForHandle(this.pointer, steamControllerHandle.handle));
    }

    private static native boolean init(long var0);

    private static native boolean shutdown(long var0);

    private static native void runFrame(long var0);

    private static native int getConnectedControllers(long var0, long[] var2);

    private static native boolean showBindingPanel(long var0, long var2);

    private static native long getActionSetHandle(long var0, String var2);

    private static native void activateActionSet(long var0, long var2, long var4);

    private static native long getCurrentActionSet(long var0, long var2);

    private static native long getDigitalActionHandle(long var0, String var2);

    private static native void getDigitalActionData(long var0, long var2, long var4, SteamControllerDigitalActionData var6);

    private static native int getDigitalActionOrigins(long var0, long var2, long var4, long var6, int[] var8);

    private static native long getAnalogActionHandle(long var0, String var2);

    private static native void getAnalogActionData(long var0, long var2, long var4, SteamControllerAnalogActionData var6);

    private static native int getAnalogActionOrigins(long var0, long var2, long var4, long var6, int[] var8);

    private static native void stopAnalogActionMomentum(long var0, long var2, long var4);

    private static native void triggerHapticPulse(long var0, long var2, int var4, int var5);

    private static native void triggerRepeatedHapticPulse(long var0, long var2, int var4, int var5, int var6, int var7, int var8);

    private static native void triggerVibration(long var0, long var2, short var4, short var5);

    private static native void setLEDColor(long var0, long var2, byte var4, byte var5, byte var6, int var7);

    private static native int getGamepadIndexForController(long var0, long var2);

    private static native long getControllerForGamepadIndex(long var0, int var2);

    private static native void getMotionData(long var0, long var2, float[] var4);

    private static native boolean showDigitalActionOrigins(long var0, long var2, long var4, float var6, float var7, float var8);

    private static native boolean showAnalogActionOrigins(long var0, long var2, long var4, float var6, float var7, float var8);

    private static native String getStringForActionOrigin(long var0, int var2);

    private static native String getGlyphForActionOrigin(long var0, int var2);

    private static native int getInputTypeForHandle(long var0, long var2);

    public static enum InputType {
        Unknown,
        SteamController,
        XBox360Controller,
        XBoxOneController,
        GenericXInput,
        PS4Controller;

        private static final InputType[] values;

        static InputType byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = InputType.values();
        }
    }

    public static enum LEDFlag {
        SetColor,
        RestoreUserDefault;

    }

    public static enum ActionOrigin {
        None,
        A,
        B,
        X,
        Y,
        LeftBumper,
        RightBumper,
        LeftGrip,
        RightGrip,
        Start,
        Back,
        LeftPad_Touch,
        LeftPad_Swipe,
        LeftPad_Click,
        LeftPad_DPadNorth,
        LeftPad_DPadSouth,
        LeftPad_DPadWest,
        LeftPad_DPadEast,
        RightPad_Touch,
        RightPad_Swipe,
        RightPad_Click,
        RightPad_DPadNorth,
        RightPad_DPadSouth,
        RightPad_DPadWest,
        RightPad_DPadEast,
        LeftTrigger_Pull,
        LeftTrigger_Click,
        RightTrigger_Pull,
        RightTrigger_Click,
        LeftStick_Move,
        LeftStick_Click,
        LeftStick_DPadNorth,
        LeftStick_DPadSouth,
        LeftStick_DPadWest,
        LeftStick_DPadEast,
        Gyro_Move,
        Gyro_Pitch,
        Gyro_Yaw,
        Gyro_Roll,
        PS4_X,
        PS4_Circle,
        PS4_Triangle,
        PS4_Square,
        PS4_LeftBumper,
        PS4_RightBumper,
        PS4_Options,
        PS4_Share,
        PS4_LeftPad_Touch,
        PS4_LeftPad_Swipe,
        PS4_LeftPad_Click,
        PS4_LeftPad_DPadNorth,
        PS4_LeftPad_DPadSouth,
        PS4_LeftPad_DPadWest,
        PS4_LeftPad_DPadEast,
        PS4_RightPad_Touch,
        PS4_RightPad_Swipe,
        PS4_RightPad_Click,
        PS4_RightPad_DPadNorth,
        PS4_RightPad_DPadSouth,
        PS4_RightPad_DPadWest,
        PS4_RightPad_DPadEast,
        PS4_CenterPad_Touch,
        PS4_CenterPad_Swipe,
        PS4_CenterPad_Click,
        PS4_CenterPad_DPadNorth,
        PS4_CenterPad_DPadSouth,
        PS4_CenterPad_DPadWest,
        PS4_CenterPad_DPadEast,
        PS4_LeftTrigger_Pull,
        PS4_LeftTrigger_Click,
        PS4_RightTrigger_Pull,
        PS4_RightTrigger_Click,
        PS4_LeftStick_Move,
        PS4_LeftStick_Click,
        PS4_LeftStick_DPadNorth,
        PS4_LeftStick_DPadSouth,
        PS4_LeftStick_DPadWest,
        PS4_LeftStick_DPadEast,
        PS4_RightStick_Move,
        PS4_RightStick_Click,
        PS4_RightStick_DPadNorth,
        PS4_RightStick_DPadSouth,
        PS4_RightStick_DPadWest,
        PS4_RightStick_DPadEast,
        PS4_DPad_North,
        PS4_DPad_South,
        PS4_DPad_West,
        PS4_DPad_East,
        PS4_Gyro_Move,
        PS4_Gyro_Pitch,
        PS4_Gyro_Yaw,
        PS4_Gyro_Roll,
        XBoxOne_A,
        XBoxOne_B,
        XBoxOne_X,
        XBoxOne_Y,
        XBoxOne_LeftBumper,
        XBoxOne_RightBumper,
        XBoxOne_Menu,
        XBoxOne_View,
        XBoxOne_LeftTrigger_Pull,
        XBoxOne_LeftTrigger_Click,
        XBoxOne_RightTrigger_Pull,
        XBoxOne_RightTrigger_Click,
        XBoxOne_LeftStick_Move,
        XBoxOne_LeftStick_Click,
        XBoxOne_LeftStick_DPadNorth,
        XBoxOne_LeftStick_DPadSouth,
        XBoxOne_LeftStick_DPadWest,
        XBoxOne_LeftStick_DPadEast,
        XBoxOne_RightStick_Move,
        XBoxOne_RightStick_Click,
        XBoxOne_RightStick_DPadNorth,
        XBoxOne_RightStick_DPadSouth,
        XBoxOne_RightStick_DPadWest,
        XBoxOne_RightStick_DPadEast,
        XBoxOne_DPad_North,
        XBoxOne_DPad_South,
        XBoxOne_DPad_West,
        XBoxOne_DPad_East,
        XBox360_A,
        XBox360_B,
        XBox360_X,
        XBox360_Y,
        XBox360_LeftBumper,
        XBox360_RightBumper,
        XBox360_Start,
        XBox360_Back,
        XBox360_LeftTrigger_Pull,
        XBox360_LeftTrigger_Click,
        XBox360_RightTrigger_Pull,
        XBox360_RightTrigger_Click,
        XBox360_LeftStick_Move,
        XBox360_LeftStick_Click,
        XBox360_LeftStick_DPadNorth,
        XBox360_LeftStick_DPadSouth,
        XBox360_LeftStick_DPadWest,
        XBox360_LeftStick_DPadEast,
        XBox360_RightStick_Move,
        XBox360_RightStick_Click,
        XBox360_RightStick_DPadNorth,
        XBox360_RightStick_DPadSouth,
        XBox360_RightStick_DPadWest,
        XBox360_RightStick_DPadEast,
        XBox360_DPad_North,
        XBox360_DPad_South,
        XBox360_DPad_West,
        XBox360_DPad_East,
        SteamV2_A,
        SteamV2_B,
        SteamV2_X,
        SteamV2_Y,
        SteamV2_LeftBumper,
        SteamV2_RightBumper,
        SteamV2_LeftGrip,
        SteamV2_RightGrip,
        SteamV2_LeftGrip_Upper,
        SteamV2_RightGrip_Upper,
        SteamV2_LeftBumper_Pressure,
        SteamV2_RightBumper_Pressure,
        SteamV2_LeftGrip_Pressure,
        SteamV2_RightGrip_Pressure,
        SteamV2_LeftGrip_Upper_Pressure,
        SteamV2_RightGrip_Upper_Pressure,
        SteamV2_Start,
        SteamV2_Back,
        SteamV2_LeftPad_Touch,
        SteamV2_LeftPad_Swipe,
        SteamV2_LeftPad_Click,
        SteamV2_LeftPad_Pressure,
        SteamV2_LeftPad_DPadNorth,
        SteamV2_LeftPad_DPadSouth,
        SteamV2_LeftPad_DPadWest,
        SteamV2_LeftPad_DPadEast,
        SteamV2_RightPad_Touch,
        SteamV2_RightPad_Swipe,
        SteamV2_RightPad_Click,
        SteamV2_RightPad_Pressure,
        SteamV2_RightPad_DPadNorth,
        SteamV2_RightPad_DPadSouth,
        SteamV2_RightPad_DPadWest,
        SteamV2_RightPad_DPadEast,
        SteamV2_LeftTrigger_Pull,
        SteamV2_LeftTrigger_Click,
        SteamV2_RightTrigger_Pull,
        SteamV2_RightTrigger_Click,
        SteamV2_LeftStick_Move,
        SteamV2_LeftStick_Click,
        SteamV2_LeftStick_DPadNorth,
        SteamV2_LeftStick_DPadSouth,
        SteamV2_LeftStick_DPadWest,
        SteamV2_LeftStick_DPadEast,
        SteamV2_Gyro_Move,
        SteamV2_Gyro_Pitch,
        SteamV2_Gyro_Yaw,
        SteamV2_Gyro_Roll;

        private static final ActionOrigin[] values;

        static ActionOrigin byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = ActionOrigin.values();
        }
    }

    public static enum SourceMode {
        None,
        Dpad,
        Buttons,
        FourButtons,
        AbsoluteMouse,
        RelativeMouse,
        JoystickMove,
        JoystickMouse,
        JoystickCamera,
        ScrollWheel,
        Trigger,
        TouchMenu,
        MouseJoystick,
        MouseRegion,
        RadialMenu,
        SingleButton,
        Switches;

        private static final SourceMode[] values;

        static SourceMode byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = SourceMode.values();
        }
    }

    public static enum Source {
        None,
        LeftTrackpad,
        RightTrackpad,
        Joystick,
        ABXY,
        Switch,
        LeftTrigger,
        RightTrigger,
        Gyro,
        CenterTrackpad,
        RightJoystick,
        DPad,
        Key,
        Mouse;

    }

    public static enum Pad {
        Left,
        Right;

    }
}

