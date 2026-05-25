/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.linux.Visual;
import org.lwjgl.system.linux.XEvent;
import org.lwjgl.system.linux.XSetWindowAttributes;
import org.lwjgl.system.linux.XTimeCoord;

public class X11 {
    private static final SharedLibrary X11 = Library.loadNative(X11.class, "org.lwjgl", null, "libX11.so.6", "libX11.so");
    public static final int True = 1;
    public static final int False = 0;
    public static final int None = 0;
    public static final int ParentRelative = 1;
    public static final int CopyFromParent = 0;
    public static final int PointerWindow = 0;
    public static final int InputFocus = 1;
    public static final int PointerRoot = 1;
    public static final int AnyPropertyType = 0;
    public static final int AnyKey = 0;
    public static final int AnyButton = 0;
    public static final int AllTemporary = 0;
    public static final int CurrentTime = 0;
    public static final int NoSymbol = 0;
    public static final int Success = 0;
    public static final int BadRequest = 1;
    public static final int BadValue = 2;
    public static final int BadWindow = 3;
    public static final int BadPixmap = 4;
    public static final int BadAtom = 5;
    public static final int BadCursor = 6;
    public static final int BadFont = 7;
    public static final int BadMatch = 8;
    public static final int BadDrawable = 9;
    public static final int BadAccess = 10;
    public static final int BadAlloc = 11;
    public static final int BadColor = 12;
    public static final int BadGC = 13;
    public static final int BadIDChoice = 14;
    public static final int BadName = 15;
    public static final int BadLength = 16;
    public static final int BadImplementation = 17;
    public static final int FirstExtensionError = 128;
    public static final int LastExtensionError = 255;
    public static final int CWBackPixmap = 1;
    public static final int CWBackPixel = 2;
    public static final int CWBorderPixmap = 4;
    public static final int CWBorderPixel = 8;
    public static final int CWBitGravity = 16;
    public static final int CWWinGravity = 32;
    public static final int CWBackingStore = 64;
    public static final int CWBackingPlanes = 128;
    public static final int CWBackingPixel = 256;
    public static final int CWOverrideRedirect = 512;
    public static final int CWSaveUnder = 1024;
    public static final int CWEventMask = 2048;
    public static final int CWDontPropagate = 4096;
    public static final int CWColormap = 8192;
    public static final int CWCursor = 16384;
    public static final int NoEventMask = 0;
    public static final int KeyPressMask = 1;
    public static final int KeyReleaseMask = 2;
    public static final int ButtonPressMask = 4;
    public static final int ButtonReleaseMask = 8;
    public static final int EnterWindowMask = 16;
    public static final int LeaveWindowMask = 32;
    public static final int PointerMotionMask = 64;
    public static final int PointerMotionHintMask = 128;
    public static final int Button1MotionMask = 256;
    public static final int Button2MotionMask = 512;
    public static final int Button3MotionMask = 1024;
    public static final int Button4MotionMask = 2048;
    public static final int Button5MotionMask = 4096;
    public static final int ButtonMotionMask = 8192;
    public static final int KeymapStateMask = 16384;
    public static final int ExposureMask = 32768;
    public static final int VisibilityChangeMask = 65536;
    public static final int StructureNotifyMask = 131072;
    public static final int ResizeRedirectMask = 262144;
    public static final int SubstructureNotifyMask = 524288;
    public static final int SubstructureRedirectMask = 0x100000;
    public static final int FocusChangeMask = 0x200000;
    public static final int PropertyChangeMask = 0x400000;
    public static final int ColormapChangeMask = 0x800000;
    public static final int OwnerGrabButtonMask = 0x1000000;
    public static final int KeyPress = 2;
    public static final int KeyRelease = 3;
    public static final int ButtonPress = 4;
    public static final int ButtonRelease = 5;
    public static final int MotionNotify = 6;
    public static final int EnterNotify = 7;
    public static final int LeaveNotify = 8;
    public static final int FocusIn = 9;
    public static final int FocusOut = 10;
    public static final int KeymapNotify = 11;
    public static final int Expose = 12;
    public static final int GraphicsExpose = 13;
    public static final int NoExpose = 14;
    public static final int VisibilityNotify = 15;
    public static final int CreateNotify = 16;
    public static final int DestroyNotify = 17;
    public static final int UnmapNotify = 18;
    public static final int MapNotify = 19;
    public static final int MapRequest = 20;
    public static final int ReparentNotify = 21;
    public static final int ConfigureNotify = 22;
    public static final int ConfigureRequest = 23;
    public static final int GravityNotify = 24;
    public static final int ResizeRequest = 25;
    public static final int CirculateNotify = 26;
    public static final int CirculateRequest = 27;
    public static final int PropertyNotify = 28;
    public static final int SelectionClear = 29;
    public static final int SelectionRequest = 30;
    public static final int SelectionNotify = 31;
    public static final int ColormapNotify = 32;
    public static final int ClientMessage = 33;
    public static final int MappingNotify = 34;
    public static final int GenericEvent = 35;
    public static final int LASTEvent = 36;
    public static final int ShiftMask = 1;
    public static final int LockMask = 2;
    public static final int ControlMask = 4;
    public static final int Mod1Mask = 8;
    public static final int Mod2Mask = 16;
    public static final int Mod3Mask = 32;
    public static final int Mod4Mask = 64;
    public static final int Mod5Mask = 128;
    public static final int ShiftMapIndex = 0;
    public static final int LockMapIndex = 1;
    public static final int ControlMapIndex = 2;
    public static final int Mod1MapIndex = 3;
    public static final int Mod2MapIndex = 4;
    public static final int Mod3MapIndex = 5;
    public static final int Mod4MapIndex = 6;
    public static final int Mod5MapIndex = 7;
    public static final int Button1Mask = 256;
    public static final int Button2Mask = 512;
    public static final int Button3Mask = 1024;
    public static final int Button4Mask = 2048;
    public static final int Button5Mask = 4096;
    public static final int AnyModifier = 32768;
    public static final int Button1 = 1;
    public static final int Button2 = 2;
    public static final int Button3 = 3;
    public static final int Button4 = 4;
    public static final int Button5 = 5;
    public static final int NotifyNormal = 0;
    public static final int NotifyGrab = 1;
    public static final int NotifyUngrab = 2;
    public static final int NotifyWhileGrabbed = 3;
    public static final int NotifyHint = 1;
    public static final int NotifyAncestor = 0;
    public static final int NotifyVirtual = 1;
    public static final int NotifyInferior = 2;
    public static final int NotifyNonlinear = 3;
    public static final int NotifyNonlinearVirtual = 4;
    public static final int NotifyPointer = 5;
    public static final int NotifyPointerRoot = 6;
    public static final int NotifyDetailNone = 7;
    public static final int VisibilityUnobscured = 0;
    public static final int VisibilityPartiallyObscured = 1;
    public static final int VisibilityFullyObscured = 2;
    public static final int PlaceOnTop = 0;
    public static final int PlaceOnBottom = 1;
    public static final int PropertyNewValue = 0;
    public static final int PropertyDelete = 1;
    public static final int ColormapUninstalled = 0;
    public static final int ColormapInstalled = 1;
    public static final int GrabModeSync = 0;
    public static final int GrabModeAsync = 1;
    public static final int GrabSuccess = 0;
    public static final int AlreadyGrabbed = 1;
    public static final int GrabInvalidTime = 2;
    public static final int GrabNotViewable = 3;
    public static final int GrabFrozen = 4;
    public static final int AsyncPointer = 0;
    public static final int SyncPointer = 1;
    public static final int ReplayPointer = 2;
    public static final int AsyncKeyboard = 3;
    public static final int SyncKeyboard = 4;
    public static final int ReplayKeyboard = 5;
    public static final int AsyncBoth = 6;
    public static final int SyncBoth = 7;
    public static final int AllocNone = 0;
    public static final int AllocAll = 1;
    public static final int RevertToNone = 0;
    public static final int RevertToPointerRoot = 1;
    public static final int RevertToParent = 2;
    public static final int InputOutput = 1;
    public static final int InputOnly = 2;
    public static final int DontPreferBlanking = 0;
    public static final int PreferBlanking = 1;
    public static final int DefaultBlanking = 2;
    public static final int DisableScreenSaver = 0;
    public static final int DisableScreenInterval = 0;
    public static final int DontAllowExposures = 0;
    public static final int AllowExposures = 1;
    public static final int DefaultExposures = 2;
    public static final int ScreenSaverReset = 0;
    public static final int ScreenSaverActive = 1;
    public static final int PropModeReplace = 0;
    public static final int PropModePrepend = 1;
    public static final int PropModeAppend = 2;
    public static final int GXclear = 0;
    public static final int GXand = 1;
    public static final int GXandReverse = 2;
    public static final int GXcopy = 3;
    public static final int GXandInverted = 4;
    public static final int GXnoop = 5;
    public static final int GXxor = 6;
    public static final int GXor = 7;
    public static final int GXnor = 8;
    public static final int GXequiv = 9;
    public static final int GXinvert = 10;
    public static final int GXorReverse = 11;
    public static final int GXcopyInverted = 12;
    public static final int GXorInverted = 13;
    public static final int GXnand = 14;
    public static final int GXset = 15;
    public static final int LineSolid = 0;
    public static final int LineOnOffDash = 1;
    public static final int LineDoubleDash = 2;
    public static final int CapNotLast = 0;
    public static final int CapButt = 1;
    public static final int CapRound = 2;
    public static final int CapProjecting = 3;
    public static final int JoinMiter = 0;
    public static final int JoinRound = 1;
    public static final int JoinBevel = 2;
    public static final int FillSolid = 0;
    public static final int FillTiled = 1;
    public static final int FillStippled = 2;
    public static final int FillOpaqueStippled = 3;
    public static final int EvenOddRule = 0;
    public static final int WindingRule = 1;
    public static final int ClipByChildren = 0;
    public static final int IncludeInferiors = 1;
    public static final int Unsorted = 0;
    public static final int YSorted = 1;
    public static final int YXSorted = 2;
    public static final int YXBanded = 3;
    public static final int CoordModeOrigin = 0;
    public static final int CoordModePrevious = 1;
    public static final int Complex = 0;
    public static final int Nonconvex = 1;
    public static final int Convex = 2;
    public static final int ArcChord = 0;
    public static final int ArcPieSlice = 1;
    public static final int GCFunction = 1;
    public static final int GCPlaneMask = 2;
    public static final int GCForeground = 4;
    public static final int GCBackground = 8;
    public static final int GCLineWidth = 16;
    public static final int GCLineStyle = 32;
    public static final int GCCapStyle = 64;
    public static final int GCJoinStyle = 128;
    public static final int GCFillStyle = 256;
    public static final int GCFillRule = 512;
    public static final int GCTile = 1024;
    public static final int GCStipple = 2048;
    public static final int GCTileStipXOrigin = 4096;
    public static final int GCTileStipYOrigin = 8192;
    public static final int GCFont = 16384;
    public static final int GCSubwindowMode = 32768;
    public static final int GCGraphicsExposures = 65536;
    public static final int GCClipXOrigin = 131072;
    public static final int GCClipYOrigin = 262144;
    public static final int GCClipMask = 524288;
    public static final int GCDashOffset = 0x100000;
    public static final int GCDashList = 0x200000;
    public static final int GCArcMode = 0x400000;
    public static final int GCLastBit = 22;
    public static final int Above = 0;
    public static final int Below = 1;
    public static final int TopIf = 2;
    public static final int BottomIf = 3;
    public static final int Opposite = 4;
    public static final int MappingModifier = 0;
    public static final int MappingKeyboard = 1;
    public static final int MappingPointer = 2;

    public static SharedLibrary getLibrary() {
        return X11;
    }

    protected X11() {
        throw new UnsupportedOperationException();
    }

    public static long nXOpenDisplay(long l2) {
        long l3 = Functions.XOpenDisplay;
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="Display *")
    public static long XOpenDisplay(@Nullable @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(byteBuffer);
        }
        return org.lwjgl.system.linux.X11.nXOpenDisplay(MemoryUtil.memAddressSafe(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="Display *")
    public static long XOpenDisplay(@Nullable @NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCIISafe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l3 = org.lwjgl.system.linux.X11.nXOpenDisplay(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static void XCloseDisplay(@NativeType(value="Display *") long l2) {
        long l3 = Functions.XCloseDisplay;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(l2, l3);
    }

    public static int XDefaultScreen(@NativeType(value="Display *") long l2) {
        long l3 = Functions.XDefaultScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePI(l2, l3);
    }

    @NativeType(value="Window")
    public static long XRootWindow(@NativeType(value="Display *") long l2, int n2) {
        long l3 = Functions.XRootWindow;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePN(l2, n2, l3);
    }

    public static long nXCreateColormap(long l2, long l3, long l4, int n2) {
        long l5 = Functions.XCreateColormap;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNPN(l2, l3, l4, n2, l5);
    }

    @NativeType(value="Colormap")
    public static long XCreateColormap(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3, @NativeType(value="Visual *") Visual visual, int n2) {
        return org.lwjgl.system.linux.X11.nXCreateColormap(l2, l3, visual.address(), n2);
    }

    public static int XFreeColormap(@NativeType(value="Display *") long l2, @NativeType(value="Colormap") long l3) {
        long l4 = Functions.XFreeColormap;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNI(l2, l3, l4);
    }

    public static long nXCreateWindow(long l2, long l3, int n2, int n3, int n4, int n5, int n6, int n7, int n8, long l4, long l5, long l6) {
        long l7 = Functions.XCreateWindow;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNPNPN(l2, l3, n2, n3, n4, n5, n6, n7, n8, l4, l5, l6, l7);
    }

    @NativeType(value="Window")
    public static long XCreateWindow(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3, int n2, int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="unsigned int") int n5, @NativeType(value="unsigned int") int n6, int n7, @NativeType(value="unsigned int") int n8, @NativeType(value="Visual *") Visual visual, @NativeType(value="unsigned long") long l4, @NativeType(value="XSetWindowAttributes *") XSetWindowAttributes xSetWindowAttributes) {
        return org.lwjgl.system.linux.X11.nXCreateWindow(l2, l3, n2, n3, n4, n5, n6, n7, n8, visual.address(), l4, xSetWindowAttributes.address());
    }

    public static int XDestroyWindow(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3) {
        long l4 = Functions.XDestroyWindow;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNI(l2, l3, l4);
    }

    public static int nXFree(long l2) {
        long l3 = Functions.XFree;
        return JNI.invokePI(l2, l3);
    }

    public static int XFree(@NativeType(value="void *") ByteBuffer byteBuffer) {
        return org.lwjgl.system.linux.X11.nXFree(MemoryUtil.memAddress(byteBuffer));
    }

    public static int XFree(@NativeType(value="void *") PointerBuffer pointerBuffer) {
        return org.lwjgl.system.linux.X11.nXFree(MemoryUtil.memAddress(pointerBuffer));
    }

    public static int nXSendEvent(long l2, long l3, int n2, long l4, long l5) {
        long l6 = Functions.XSendEvent;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNNPI(l2, l3, n2, l4, l5, l6);
    }

    @NativeType(value="Status")
    public static int XSendEvent(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3, @NativeType(value="Bool") boolean bl2, long l4, @NativeType(value="XEvent *") XEvent xEvent) {
        return org.lwjgl.system.linux.X11.nXSendEvent(l2, l3, bl2 ? 1 : 0, l4, xEvent.address());
    }

    @NativeType(value="unsigned long")
    public static long XDisplayMotionBufferSize(@NativeType(value="Display *") long l2) {
        long l3 = Functions.XDisplayMotionBufferSize;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePN(l2, l3);
    }

    public static long nXGetMotionEvents(long l2, long l3, long l4, long l5, long l6) {
        long l7 = Functions.XGetMotionEvents;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNNNPP(l2, l3, l4, l5, l6, l7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="XTimeCoord *")
    public static XTimeCoord.Buffer XGetMotionEvents(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3, @NativeType(value="Time") long l4, @NativeType(value="Time") long l5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l6 = org.lwjgl.system.linux.X11.nXGetMotionEvents(l2, l3, l4, l5, MemoryUtil.memAddress(intBuffer));
            XTimeCoord.Buffer buffer = XTimeCoord.createSafe(l6, intBuffer.get(0));
            return buffer;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static int nXTranslateCoordinates(long l2, long l3, long l4, int n2, int n3, long l5, long l6, long l7) {
        long l8 = Functions.XTranslateCoordinates;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePNNPPPI(l2, l3, l4, n2, n3, l5, l6, l7, l8);
    }

    @NativeType(value="Bool")
    public static boolean XTranslateCoordinates(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3, @NativeType(value="Window") long l4, int n2, int n3, @NativeType(value="int *") IntBuffer intBuffer, @NativeType(value="int *") IntBuffer intBuffer2, @NativeType(value="Window *") CLongBuffer cLongBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
            Checks.check(cLongBuffer, 1);
        }
        return org.lwjgl.system.linux.X11.nXTranslateCoordinates(l2, l3, l4, n2, n3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(cLongBuffer)) != 0;
    }

    @NativeType(value="Bool")
    public static boolean XTranslateCoordinates(@NativeType(value="Display *") long l2, @NativeType(value="Window") long l3, @NativeType(value="Window") long l4, int n2, int n3, @NativeType(value="int *") int[] nArray, @NativeType(value="int *") int[] nArray2, @NativeType(value="Window *") CLongBuffer cLongBuffer) {
        long l5 = Functions.XTranslateCoordinates;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
            Checks.check(cLongBuffer, 1);
        }
        return JNI.invokePNNPPPI(l2, l3, l4, n2, n3, nArray, nArray2, MemoryUtil.memAddress(cLongBuffer), l5) != 0;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return X11;
    }

    public static final class Functions {
        public static final long XOpenDisplay = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XOpenDisplay");
        public static final long XCloseDisplay = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XCloseDisplay");
        public static final long XDefaultScreen = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XDefaultScreen");
        public static final long XRootWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XRootWindow");
        public static final long XCreateColormap = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XCreateColormap");
        public static final long XFreeColormap = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XFreeColormap");
        public static final long XCreateWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XCreateWindow");
        public static final long XDestroyWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XDestroyWindow");
        public static final long XFree = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XFree");
        public static final long XSendEvent = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XSendEvent");
        public static final long XDisplayMotionBufferSize = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XDisplayMotionBufferSize");
        public static final long XGetMotionEvents = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XGetMotionEvents");
        public static final long XTranslateCoordinates = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XTranslateCoordinates");

        private Functions() {
        }
    }
}

