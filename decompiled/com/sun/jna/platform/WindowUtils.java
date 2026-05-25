/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.RasterRangesUtils;
import com.sun.jna.platform.unix.X11;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.PsapiUtil;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinGDI;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.AWTEvent;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

public class WindowUtils {
    private static final Logger LOG = Logger.getLogger(WindowUtils.class.getName());
    private static final String TRANSPARENT_OLD_BG = "transparent-old-bg";
    private static final String TRANSPARENT_OLD_OPAQUE = "transparent-old-opaque";
    private static final String TRANSPARENT_ALPHA = "transparent-alpha";
    public static final Shape MASK_NONE = null;

    private static NativeWindowUtils getInstance() {
        return Holder.INSTANCE;
    }

    public static void setWindowMask(Window window, Shape shape) {
        WindowUtils.getInstance().setWindowMask((Component)window, shape);
    }

    public static void setComponentMask(Component component, Shape shape) {
        WindowUtils.getInstance().setWindowMask(component, shape);
    }

    public static void setWindowMask(Window window, Icon icon) {
        WindowUtils.getInstance().setWindowMask((Component)window, icon);
    }

    public static boolean isWindowAlphaSupported() {
        return WindowUtils.getInstance().isWindowAlphaSupported();
    }

    public static GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
        return WindowUtils.getInstance().getAlphaCompatibleGraphicsConfiguration();
    }

    public static void setWindowAlpha(Window window, float f2) {
        WindowUtils.getInstance().setWindowAlpha(window, Math.max(0.0f, Math.min(f2, 1.0f)));
    }

    public static void setWindowTransparent(Window window, boolean bl2) {
        WindowUtils.getInstance().setWindowTransparent(window, bl2);
    }

    public static BufferedImage getWindowIcon(WinDef.HWND hWND) {
        return WindowUtils.getInstance().getWindowIcon(hWND);
    }

    public static Dimension getIconSize(WinDef.HICON hICON) {
        return WindowUtils.getInstance().getIconSize(hICON);
    }

    public static List<DesktopWindow> getAllWindows(boolean bl2) {
        return WindowUtils.getInstance().getAllWindows(bl2);
    }

    public static String getWindowTitle(WinDef.HWND hWND) {
        return WindowUtils.getInstance().getWindowTitle(hWND);
    }

    public static String getProcessFilePath(WinDef.HWND hWND) {
        return WindowUtils.getInstance().getProcessFilePath(hWND);
    }

    public static Rectangle getWindowLocationAndSize(WinDef.HWND hWND) {
        return WindowUtils.getInstance().getWindowLocationAndSize(hWND);
    }

    static class X11WindowUtils
    extends NativeWindowUtils {
        private boolean didCheck;
        private long[] alphaVisualIDs = new long[0];
        private static final long OPAQUE = 0xFFFFFFFFL;
        private static final String OPACITY = "_NET_WM_WINDOW_OPACITY";

        private X11WindowUtils() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private static X11.Pixmap createBitmap(X11.Display display, X11.Window window, Raster raster) {
            X11 x11 = X11.INSTANCE;
            Rectangle rectangle = raster.getBounds();
            int n2 = rectangle.x + rectangle.width;
            int n3 = rectangle.y + rectangle.height;
            X11.Pixmap pixmap = x11.XCreatePixmap(display, window, n2, n3, 1);
            X11.GC gC = x11.XCreateGC(display, pixmap, new NativeLong(0L), null);
            if (gC == null) {
                return null;
            }
            x11.XSetForeground(display, gC, new NativeLong(0L));
            x11.XFillRectangle(display, pixmap, gC, 0, 0, n2, n3);
            final ArrayList arrayList = new ArrayList();
            try {
                int n4;
                RasterRangesUtils.outputOccupiedRanges(raster, new RasterRangesUtils.RangesOutput(){

                    @Override
                    public boolean outputRange(int n2, int n3, int n4, int n5) {
                        arrayList.add(new Rectangle(n2, n3, n4, n5));
                        return true;
                    }
                });
                X11.XRectangle[] xRectangleArray = (X11.XRectangle[])new X11.XRectangle().com_sun_jna_Structure_arr_toArray(arrayList.size());
                for (n4 = 0; n4 < xRectangleArray.length; ++n4) {
                    Rectangle rectangle2 = (Rectangle)arrayList.get(n4);
                    xRectangleArray[n4].x = (short)rectangle2.x;
                    xRectangleArray[n4].y = (short)rectangle2.y;
                    xRectangleArray[n4].width = (short)rectangle2.width;
                    xRectangleArray[n4].height = (short)rectangle2.height;
                    Pointer pointer = xRectangleArray[n4].getPointer();
                    pointer.setShort(0L, (short)rectangle2.x);
                    pointer.setShort(2L, (short)rectangle2.y);
                    pointer.setShort(4L, (short)rectangle2.width);
                    pointer.setShort(6L, (short)rectangle2.height);
                    xRectangleArray[n4].setAutoSynch(false);
                }
                n4 = 1;
                x11.XSetForeground(display, gC, new NativeLong(1L));
                x11.XFillRectangles(display, pixmap, gC, xRectangleArray, xRectangleArray.length);
            }
            finally {
                x11.XFreeGC(display, gC);
            }
            return pixmap;
        }

        @Override
        public boolean isWindowAlphaSupported() {
            return this.getAlphaVisualIDs().length > 0;
        }

        private static long getVisualID(GraphicsConfiguration graphicsConfiguration) {
            try {
                Object object = graphicsConfiguration.getClass().getMethod("getVisual", null).invoke((Object)graphicsConfiguration, (Object[])null);
                return ((Number)object).longValue();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return -1L;
            }
        }

        @Override
        public GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
            if (this.isWindowAlphaSupported()) {
                GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] graphicsDeviceArray = graphicsEnvironment.getScreenDevices();
                for (int i2 = 0; i2 < graphicsDeviceArray.length; ++i2) {
                    GraphicsConfiguration[] graphicsConfigurationArray = graphicsDeviceArray[i2].getConfigurations();
                    for (int i3 = 0; i3 < graphicsConfigurationArray.length; ++i3) {
                        long l2 = X11WindowUtils.getVisualID(graphicsConfigurationArray[i3]);
                        long[] lArray = this.getAlphaVisualIDs();
                        for (int i4 = 0; i4 < lArray.length; ++i4) {
                            if (l2 != lArray[i4]) continue;
                            return graphicsConfigurationArray[i3];
                        }
                    }
                }
            }
            return super.getAlphaCompatibleGraphicsConfiguration();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private synchronized long[] getAlphaVisualIDs() {
            if (this.didCheck) {
                return this.alphaVisualIDs;
            }
            this.didCheck = true;
            X11 x11 = X11.INSTANCE;
            X11.Display display = x11.XOpenDisplay(null);
            if (display == null) {
                return this.alphaVisualIDs;
            }
            Structure structure = null;
            try {
                int n2 = x11.XDefaultScreen(display);
                X11.XVisualInfo xVisualInfo = new X11.XVisualInfo();
                xVisualInfo.screen = n2;
                xVisualInfo.depth = 32;
                xVisualInfo.c_class = 4;
                NativeLong nativeLong = new NativeLong(14L);
                IntByReference intByReference = new IntByReference();
                structure = x11.XGetVisualInfo(display, nativeLong, xVisualInfo, intByReference);
                if (structure != null) {
                    int n3;
                    ArrayList<X11.VisualID> arrayList = new ArrayList<X11.VisualID>();
                    X11.XVisualInfo[] xVisualInfoArray = (X11.XVisualInfo[])structure.com_sun_jna_Structure_arr_toArray(intByReference.getValue());
                    for (n3 = 0; n3 < xVisualInfoArray.length; ++n3) {
                        X11.Xrender.XRenderPictFormat xRenderPictFormat = X11.Xrender.INSTANCE.XRenderFindVisualFormat(display, xVisualInfoArray[n3].visual);
                        if (xRenderPictFormat.type != 1 || xRenderPictFormat.direct.alphaMask == 0) continue;
                        arrayList.add(xVisualInfoArray[n3].visualid);
                    }
                    this.alphaVisualIDs = new long[arrayList.size()];
                    for (n3 = 0; n3 < this.alphaVisualIDs.length; ++n3) {
                        this.alphaVisualIDs[n3] = ((Number)arrayList.get(n3)).longValue();
                    }
                    long[] lArray = this.alphaVisualIDs;
                    return lArray;
                }
            }
            finally {
                if (structure != null) {
                    x11.XFree(structure.getPointer());
                }
                x11.XCloseDisplay(display);
            }
            return this.alphaVisualIDs;
        }

        private static X11.Window getContentWindow(Window window, X11.Display display, X11.Window window2, Point point) {
            if (window instanceof Frame && !((Frame)window).isUndecorated() || window instanceof Dialog && !((Dialog)window).isUndecorated()) {
                int[] nArray;
                X11 x11 = X11.INSTANCE;
                X11.WindowByReference windowByReference = new X11.WindowByReference();
                X11.WindowByReference windowByReference2 = new X11.WindowByReference();
                PointerByReference pointerByReference = new PointerByReference();
                IntByReference intByReference = new IntByReference();
                x11.XQueryTree(display, window2, windowByReference, windowByReference2, pointerByReference, intByReference);
                Pointer pointer = pointerByReference.getValue();
                int[] nArray2 = nArray = pointer.getIntArray(0L, intByReference.getValue());
                int n2 = nArray2.length;
                int n3 = 0;
                if (n3 < n2) {
                    int n4 = nArray2[n3];
                    X11.Window window3 = new X11.Window((long)n4);
                    X11.XWindowAttributes xWindowAttributes = new X11.XWindowAttributes();
                    x11.XGetWindowAttributes(display, window3, xWindowAttributes);
                    point.x = -xWindowAttributes.x;
                    point.y = -xWindowAttributes.y;
                    window2 = window3;
                }
                if (pointer != null) {
                    x11.XFree(pointer);
                }
            }
            return window2;
        }

        private static X11.Window getDrawable(Component component) {
            int n2 = (int)Native.getComponentID(component);
            if (n2 == 0) {
                return null;
            }
            return new X11.Window((long)n2);
        }

        @Override
        public void setWindowAlpha(final Window window, final float f2) {
            if (!this.isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("This X11 display does not provide a 32-bit visual");
            }
            Runnable runnable = new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    X11 x11 = X11.INSTANCE;
                    X11.Display display = x11.XOpenDisplay(null);
                    if (display == null) {
                        return;
                    }
                    try {
                        X11.Window window2 = X11WindowUtils.getDrawable(window);
                        if (f2 == 1.0f) {
                            x11.XDeleteProperty(display, window2, x11.XInternAtom(display, X11WindowUtils.OPACITY, false));
                        } else {
                            int n2 = (int)((long)(f2 * 4.2949673E9f) & 0xFFFFFFFFFFFFFFFFL);
                            IntByReference intByReference = new IntByReference(n2);
                            x11.XChangeProperty(display, window2, x11.XInternAtom(display, X11WindowUtils.OPACITY, false), X11.XA_CARDINAL, 32, 0, intByReference.getPointer(), 1);
                        }
                    }
                    finally {
                        x11.XCloseDisplay(display);
                    }
                }
            };
            this.whenDisplayable(window, runnable);
        }

        @Override
        public void setWindowTransparent(final Window window, final boolean bl2) {
            boolean bl3;
            if (!(window instanceof RootPaneContainer)) {
                throw new IllegalArgumentException("Window must be a RootPaneContainer");
            }
            if (!this.isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("This X11 display does not provide a 32-bit visual");
            }
            if (!window.getGraphicsConfiguration().equals(this.getAlphaCompatibleGraphicsConfiguration())) {
                throw new IllegalArgumentException("Window GraphicsConfiguration '" + window.getGraphicsConfiguration() + "' does not support transparency");
            }
            boolean bl4 = bl3 = window.getBackground() != null && window.getBackground().getAlpha() == 0;
            if (bl2 == bl3) {
                return;
            }
            this.whenDisplayable(window, new Runnable(){

                @Override
                public void run() {
                    JRootPane jRootPane = ((RootPaneContainer)((Object)window)).getRootPane();
                    JLayeredPane jLayeredPane = jRootPane.getLayeredPane();
                    Container container = jRootPane.getContentPane();
                    if (container instanceof X11TransparentContentPane) {
                        ((X11TransparentContentPane)container).setTransparent(bl2);
                    } else if (bl2) {
                        X11TransparentContentPane x11TransparentContentPane = new X11TransparentContentPane(container);
                        jRootPane.setContentPane(x11TransparentContentPane);
                        jLayeredPane.add((Component)new RepaintTrigger(x11TransparentContentPane), JLayeredPane.DRAG_LAYER);
                    }
                    X11WindowUtils.this.setLayersTransparent(window, bl2);
                    X11WindowUtils.this.setForceHeavyweightPopups(window, bl2);
                    X11WindowUtils.this.setDoubleBuffered(window, !bl2);
                }
            });
        }

        private void setWindowShape(final Window window, final PixmapSource pixmapSource) {
            Runnable runnable = new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    X11.Pixmap pixmap;
                    X11.Display display;
                    X11 x11;
                    block4: {
                        x11 = X11.INSTANCE;
                        display = x11.XOpenDisplay(null);
                        if (display == null) {
                            return;
                        }
                        pixmap = null;
                        try {
                            X11.Window window2 = X11WindowUtils.getDrawable(window);
                            pixmap = pixmapSource.getPixmap(display, window2);
                            X11.Xext xext = X11.Xext.INSTANCE;
                            xext.XShapeCombineMask(display, window2, 0, 0, 0, pixmap == null ? X11.Pixmap.None : pixmap, 0);
                            if (pixmap == null) break block4;
                            x11.XFreePixmap(display, pixmap);
                        }
                        catch (Throwable throwable) {
                            if (pixmap != null) {
                                x11.XFreePixmap(display, pixmap);
                            }
                            x11.XCloseDisplay(display);
                            throw throwable;
                        }
                    }
                    x11.XCloseDisplay(display);
                    X11WindowUtils.this.setForceHeavyweightPopups(X11WindowUtils.this.getWindow(window), pixmap != null);
                }
            };
            this.whenDisplayable(window, runnable);
        }

        @Override
        protected void setMask(Component component, final Raster raster) {
            this.setWindowShape(this.getWindow(component), new PixmapSource(){

                @Override
                public X11.Pixmap getPixmap(X11.Display display, X11.Window window) {
                    return raster != null ? X11WindowUtils.createBitmap(display, window, raster) : null;
                }
            });
        }

        static interface PixmapSource {
            public X11.Pixmap getPixmap(X11.Display var1, X11.Window var2);
        }

        class X11TransparentContentPane
        extends NativeWindowUtils.TransparentContentPane {
            private static final long serialVersionUID = 1L;
            private Memory buffer;
            private int[] pixels;
            private final int[] pixel;

            public X11TransparentContentPane(Container container) {
                super(container);
                this.pixel = new int[4];
            }

            @Override
            protected void paintDirect(BufferedImage bufferedImage, Rectangle rectangle) {
                Window window = SwingUtilities.getWindowAncestor(this);
                X11 x11 = X11.INSTANCE;
                X11.Display display = x11.XOpenDisplay(null);
                X11.Window window2 = X11WindowUtils.getDrawable(window);
                Point point = new Point();
                window2 = X11WindowUtils.getContentWindow(window, display, window2, point);
                X11.GC gC = x11.XCreateGC(display, window2, new NativeLong(0L), null);
                Raster raster = bufferedImage.getData();
                int n2 = rectangle.width;
                int n3 = rectangle.height;
                if (this.buffer == null || this.buffer.size() != (long)(n2 * n3 * 4)) {
                    this.buffer = new Memory(n2 * n3 * 4);
                    this.pixels = new int[n2 * n3];
                }
                for (int i2 = 0; i2 < n3; ++i2) {
                    for (int i3 = 0; i3 < n2; ++i3) {
                        raster.getPixel(i3, i2, this.pixel);
                        int n4 = this.pixel[3] & 0xFF;
                        int n5 = this.pixel[2] & 0xFF;
                        int n6 = this.pixel[1] & 0xFF;
                        int n7 = this.pixel[0] & 0xFF;
                        this.pixels[i2 * n2 + i3] = n4 << 24 | n7 << 16 | n6 << 8 | n5;
                    }
                }
                X11.XWindowAttributes xWindowAttributes = new X11.XWindowAttributes();
                x11.XGetWindowAttributes(display, window2, xWindowAttributes);
                X11.XImage xImage = x11.XCreateImage(display, xWindowAttributes.visual, 32, 2, 0, this.buffer, n2, n3, 32, n2 * 4);
                this.buffer.write(0L, this.pixels, 0, this.pixels.length);
                point.x += rectangle.x;
                point.y += rectangle.y;
                x11.XPutImage(display, window2, gC, xImage, 0, 0, point.x, point.y, n2, n3);
                x11.XFree(xImage.getPointer());
                x11.XFreeGC(display, gC);
                x11.XCloseDisplay(display);
            }
        }
    }

    static class MacWindowUtils
    extends NativeWindowUtils {
        private static final String WDRAG = "apple.awt.draggableWindowBackground";

        private MacWindowUtils() {
        }

        @Override
        public boolean isWindowAlphaSupported() {
            return true;
        }

        private OSXMaskingContentPane installMaskingPane(Window window) {
            OSXMaskingContentPane oSXMaskingContentPane;
            if (window instanceof RootPaneContainer) {
                RootPaneContainer rootPaneContainer = (RootPaneContainer)((Object)window);
                Container container = rootPaneContainer.getContentPane();
                if (container instanceof OSXMaskingContentPane) {
                    oSXMaskingContentPane = (OSXMaskingContentPane)container;
                } else {
                    oSXMaskingContentPane = new OSXMaskingContentPane(container);
                    rootPaneContainer.setContentPane(oSXMaskingContentPane);
                }
            } else {
                Component component;
                Component component2 = component = window.getComponentCount() > 0 ? window.getComponent(0) : null;
                if (component instanceof OSXMaskingContentPane) {
                    oSXMaskingContentPane = (OSXMaskingContentPane)component;
                } else {
                    oSXMaskingContentPane = new OSXMaskingContentPane(component);
                    window.add(oSXMaskingContentPane);
                }
            }
            return oSXMaskingContentPane;
        }

        @Override
        public void setWindowTransparent(Window window, boolean bl2) {
            boolean bl3;
            boolean bl4 = bl3 = window.getBackground() != null && window.getBackground().getAlpha() == 0;
            if (bl2 != bl3) {
                this.setBackgroundTransparent(window, bl2, "setWindowTransparent");
            }
        }

        private void fixWindowDragging(Window window, String string) {
            JRootPane jRootPane;
            Boolean bl2;
            if (window instanceof RootPaneContainer && (bl2 = (Boolean)(jRootPane = ((RootPaneContainer)((Object)window)).getRootPane()).getClientProperty(WDRAG)) == null) {
                jRootPane.putClientProperty(WDRAG, Boolean.FALSE);
                if (window.isDisplayable()) {
                    LOG.log(Level.WARNING, "{0}(): To avoid content dragging, {1}() must be called before the window is realized, or apple.awt.draggableWindowBackground must be set to Boolean.FALSE before the window is realized.  If you really want content dragging, set apple.awt.draggableWindowBackground on the window''s root pane to Boolean.TRUE before calling {2}() to hide this message.", new Object[]{string, string, string});
                }
            }
        }

        @Override
        public void setWindowAlpha(final Window window, final float f2) {
            if (window instanceof RootPaneContainer) {
                JRootPane jRootPane = ((RootPaneContainer)((Object)window)).getRootPane();
                jRootPane.putClientProperty("Window.alpha", Float.valueOf(f2));
                this.fixWindowDragging(window, "setWindowAlpha");
            }
            this.whenDisplayable(window, new Runnable(){

                @Override
                public void run() {
                    try {
                        Method method = window.getClass().getMethod("getPeer", new Class[0]);
                        Object object = method.invoke((Object)window, new Object[0]);
                        Method method2 = object.getClass().getMethod("setAlpha", Float.TYPE);
                        method2.invoke(object, Float.valueOf(f2));
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            });
        }

        @Override
        protected void setWindowMask(Component component, Raster raster) {
            if (raster != null) {
                this.setWindowMask(component, this.toShape(raster));
            } else {
                this.setWindowMask(component, new Rectangle(0, 0, component.getWidth(), component.getHeight()));
            }
        }

        @Override
        public void setWindowMask(Component component, Shape shape) {
            if (component instanceof Window) {
                Window window = (Window)component;
                OSXMaskingContentPane oSXMaskingContentPane = this.installMaskingPane(window);
                oSXMaskingContentPane.setMask(shape);
                this.setBackgroundTransparent(window, shape != MASK_NONE, "setWindowMask");
            }
        }

        private void setBackgroundTransparent(Window window, boolean bl2, String string) {
            JRootPane jRootPane;
            JRootPane jRootPane2 = jRootPane = window instanceof RootPaneContainer ? ((RootPaneContainer)((Object)window)).getRootPane() : null;
            if (bl2) {
                if (jRootPane != null) {
                    jRootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, window.getBackground());
                }
                window.setBackground(new Color(0, 0, 0, 0));
            } else if (jRootPane != null) {
                Color color = (Color)jRootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_BG);
                if (color != null) {
                    color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
                }
                window.setBackground(color);
                jRootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, null);
            } else {
                window.setBackground(null);
            }
            this.fixWindowDragging(window, string);
        }

        static class OSXMaskingContentPane
        extends JPanel {
            private static final long serialVersionUID = 1L;
            private Shape shape;

            public OSXMaskingContentPane(Component component) {
                super(new BorderLayout());
                if (component != null) {
                    this.add(component, "Center");
                }
            }

            public void setMask(Shape shape) {
                this.shape = shape;
                this.repaint();
            }

            @Override
            public void paint(Graphics graphics) {
                Graphics2D graphics2D = (Graphics2D)graphics.create();
                graphics2D.setComposite(AlphaComposite.Clear);
                graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
                graphics2D.dispose();
                if (this.shape != null) {
                    graphics2D = (Graphics2D)graphics.create();
                    graphics2D.setClip(this.shape);
                    super.paint(graphics2D);
                    graphics2D.dispose();
                } else {
                    super.paint(graphics);
                }
            }
        }
    }

    static class W32WindowUtils
    extends NativeWindowUtils {
        private W32WindowUtils() {
        }

        private WinDef.HWND getHWnd(Component component) {
            WinDef.HWND hWND = new WinDef.HWND();
            hWND.setPointer(Native.getComponentPointer(component));
            return hWND;
        }

        @Override
        public boolean isWindowAlphaSupported() {
            return Boolean.getBoolean("sun.java2d.noddraw");
        }

        private boolean usingUpdateLayeredWindow(Window window) {
            if (window instanceof RootPaneContainer) {
                JRootPane jRootPane = ((RootPaneContainer)((Object)window)).getRootPane();
                return jRootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_BG) != null;
            }
            return false;
        }

        private void storeAlpha(Window window, byte by2) {
            if (window instanceof RootPaneContainer) {
                JRootPane jRootPane = ((RootPaneContainer)((Object)window)).getRootPane();
                Byte by3 = by2 == -1 ? null : Byte.valueOf(by2);
                jRootPane.putClientProperty(WindowUtils.TRANSPARENT_ALPHA, by3);
            }
        }

        private byte getAlpha(Window window) {
            JRootPane jRootPane;
            Byte by2;
            if (window instanceof RootPaneContainer && (by2 = (Byte)(jRootPane = ((RootPaneContainer)((Object)window)).getRootPane()).getClientProperty(WindowUtils.TRANSPARENT_ALPHA)) != null) {
                return by2;
            }
            return -1;
        }

        @Override
        public void setWindowAlpha(final Window window, final float f2) {
            if (!this.isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("Set sun.java2d.noddraw=true to enable transparent windows");
            }
            this.whenDisplayable(window, new Runnable(){

                @Override
                public void run() {
                    WinDef.HWND hWND = W32WindowUtils.this.getHWnd(window);
                    User32 user32 = User32.INSTANCE;
                    int n2 = user32.GetWindowLong(hWND, -20);
                    byte by2 = (byte)((int)(255.0f * f2) & 0xFF);
                    if (W32WindowUtils.this.usingUpdateLayeredWindow(window)) {
                        WinUser.BLENDFUNCTION bLENDFUNCTION = new WinUser.BLENDFUNCTION();
                        bLENDFUNCTION.SourceConstantAlpha = by2;
                        bLENDFUNCTION.AlphaFormat = 1;
                        user32.UpdateLayeredWindow(hWND, null, null, null, null, null, 0, bLENDFUNCTION, 2);
                    } else if (f2 == 1.0f) {
                        user32.SetWindowLong(hWND, -20, n2 &= 0xFFF7FFFF);
                    } else {
                        user32.SetWindowLong(hWND, -20, n2 |= 0x80000);
                        user32.SetLayeredWindowAttributes(hWND, 0, by2, 2);
                    }
                    W32WindowUtils.this.setForceHeavyweightPopups(window, f2 != 1.0f);
                    W32WindowUtils.this.storeAlpha(window, by2);
                }
            });
        }

        @Override
        public void setWindowTransparent(final Window window, final boolean bl2) {
            boolean bl3;
            if (!(window instanceof RootPaneContainer)) {
                throw new IllegalArgumentException("Window must be a RootPaneContainer");
            }
            if (!this.isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("Set sun.java2d.noddraw=true to enable transparent windows");
            }
            boolean bl4 = bl3 = window.getBackground() != null && window.getBackground().getAlpha() == 0;
            if (bl2 == bl3) {
                return;
            }
            this.whenDisplayable(window, new Runnable(){

                @Override
                public void run() {
                    User32 user32 = User32.INSTANCE;
                    WinDef.HWND hWND = W32WindowUtils.this.getHWnd(window);
                    int n2 = user32.GetWindowLong(hWND, -20);
                    JRootPane jRootPane = ((RootPaneContainer)((Object)window)).getRootPane();
                    JLayeredPane jLayeredPane = jRootPane.getLayeredPane();
                    Container container = jRootPane.getContentPane();
                    if (container instanceof W32TransparentContentPane) {
                        ((W32TransparentContentPane)container).setTransparent(bl2);
                    } else if (bl2) {
                        W32TransparentContentPane w32TransparentContentPane = new W32TransparentContentPane(container);
                        jRootPane.setContentPane(w32TransparentContentPane);
                        jLayeredPane.add((Component)new RepaintTrigger(w32TransparentContentPane), JLayeredPane.DRAG_LAYER);
                    }
                    if (bl2 && !W32WindowUtils.this.usingUpdateLayeredWindow(window)) {
                        user32.SetWindowLong(hWND, -20, n2 |= 0x80000);
                    } else if (!bl2 && W32WindowUtils.this.usingUpdateLayeredWindow(window)) {
                        user32.SetWindowLong(hWND, -20, n2 &= 0xFFF7FFFF);
                    }
                    W32WindowUtils.this.setLayersTransparent(window, bl2);
                    W32WindowUtils.this.setForceHeavyweightPopups(window, bl2);
                    W32WindowUtils.this.setDoubleBuffered(window, !bl2);
                }
            });
        }

        @Override
        public void setWindowMask(Component component, Shape shape) {
            if (shape instanceof Area && ((Area)shape).isPolygonal()) {
                this.setMask(component, (Area)shape);
            } else {
                super.setWindowMask(component, shape);
            }
        }

        private void setWindowRegion(final Component component, final WinDef.HRGN hRGN) {
            this.whenDisplayable(component, new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    GDI32 gDI32 = GDI32.INSTANCE;
                    User32 user32 = User32.INSTANCE;
                    WinDef.HWND hWND = W32WindowUtils.this.getHWnd(component);
                    try {
                        user32.SetWindowRgn(hWND, hRGN, true);
                        W32WindowUtils.this.setForceHeavyweightPopups(W32WindowUtils.this.getWindow(component), hRGN != null);
                    }
                    finally {
                        gDI32.DeleteObject(hRGN);
                    }
                }
            });
        }

        private void setMask(Component component, Area area) {
            GDI32 gDI32 = GDI32.INSTANCE;
            PathIterator pathIterator = area.getPathIterator(null);
            int n2 = pathIterator.getWindingRule() == 1 ? 2 : 1;
            float[] fArray = new float[6];
            ArrayList<WinDef.POINT> arrayList = new ArrayList<WinDef.POINT>();
            int n3 = 0;
            ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
            while (!pathIterator.isDone()) {
                int n4 = pathIterator.currentSegment(fArray);
                if (n4 == 0) {
                    n3 = 1;
                    arrayList.add(new WinDef.POINT((int)fArray[0], (int)fArray[1]));
                } else if (n4 == 1) {
                    ++n3;
                    arrayList.add(new WinDef.POINT((int)fArray[0], (int)fArray[1]));
                } else if (n4 == 4) {
                    arrayList2.add(n3);
                } else {
                    throw new RuntimeException("Area is not polygonal: " + area);
                }
                pathIterator.next();
            }
            WinDef.POINT[] pOINTArray = (WinDef.POINT[])new WinDef.POINT().com_sun_jna_Structure_arr_toArray(arrayList.size());
            WinDef.POINT[] pOINTArray2 = arrayList.toArray(new WinDef.POINT[arrayList.size()]);
            for (int i2 = 0; i2 < pOINTArray.length; ++i2) {
                pOINTArray[i2].x = pOINTArray2[i2].x;
                pOINTArray[i2].y = pOINTArray2[i2].y;
            }
            int[] nArray = new int[arrayList2.size()];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                nArray[i3] = (Integer)arrayList2.get(i3);
            }
            WinDef.HRGN hRGN = gDI32.CreatePolyPolygonRgn(pOINTArray, nArray, nArray.length, n2);
            this.setWindowRegion(component, hRGN);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        protected void setMask(Component component, Raster raster) {
            WinDef.HRGN hRGN;
            GDI32 gDI32 = GDI32.INSTANCE;
            WinDef.HRGN hRGN2 = hRGN = raster != null ? gDI32.CreateRectRgn(0, 0, 0, 0) : null;
            if (hRGN != null) {
                final WinDef.HRGN hRGN3 = gDI32.CreateRectRgn(0, 0, 0, 0);
                try {
                    RasterRangesUtils.outputOccupiedRanges(raster, new RasterRangesUtils.RangesOutput(){

                        @Override
                        public boolean outputRange(int n2, int n3, int n4, int n5) {
                            GDI32 gDI32 = GDI32.INSTANCE;
                            gDI32.SetRectRgn(hRGN3, n2, n3, n2 + n4, n3 + n5);
                            return gDI32.CombineRgn(hRGN, hRGN, hRGN3, 2) != 0;
                        }
                    });
                }
                finally {
                    gDI32.DeleteObject(hRGN3);
                }
            }
            this.setWindowRegion(component, hRGN);
        }

        @Override
        public BufferedImage getWindowIcon(WinDef.HWND hWND) {
            WinGDI.BITMAPINFOHEADER bITMAPINFOHEADER;
            WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
            WinDef.LRESULT lRESULT = User32.INSTANCE.SendMessageTimeout(hWND, 127, new WinDef.WPARAM(1L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
            if (lRESULT.intValue() == 0) {
                lRESULT = User32.INSTANCE.SendMessageTimeout(hWND, 127, new WinDef.WPARAM(0L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
            }
            if (lRESULT.intValue() == 0) {
                lRESULT = User32.INSTANCE.SendMessageTimeout(hWND, 127, new WinDef.WPARAM(2L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
            }
            if (lRESULT.intValue() == 0) {
                lRESULT = new WinDef.LRESULT((long)User32.INSTANCE.GetClassLongPtr(hWND, -14).intValue());
                dWORDByReference.getValue().setValue(lRESULT.intValue());
            }
            if (lRESULT.intValue() == 0) {
                lRESULT = new WinDef.LRESULT((long)User32.INSTANCE.GetClassLongPtr(hWND, -34).intValue());
                dWORDByReference.getValue().setValue(lRESULT.intValue());
            }
            if (lRESULT.intValue() == 0) {
                return null;
            }
            WinDef.HICON hICON = new WinDef.HICON(new Pointer(dWORDByReference.getValue().longValue()));
            Dimension dimension = this.getIconSize(hICON);
            if (dimension.width == 0 || dimension.height == 0) {
                return null;
            }
            int n2 = dimension.width;
            int n3 = dimension.height;
            int n4 = 24;
            byte[] byArray = new byte[n2 * n3 * 24 / 8];
            Memory memory = new Memory(byArray.length);
            byte[] byArray2 = new byte[n2 * n3 * 24 / 8];
            Memory memory2 = new Memory(byArray2.length);
            WinGDI.BITMAPINFO bITMAPINFO = new WinGDI.BITMAPINFO();
            bITMAPINFO.bmiHeader = bITMAPINFOHEADER = new WinGDI.BITMAPINFOHEADER();
            bITMAPINFOHEADER.biWidth = n2;
            bITMAPINFOHEADER.biHeight = n3;
            bITMAPINFOHEADER.biPlanes = 1;
            bITMAPINFOHEADER.biBitCount = (short)24;
            bITMAPINFOHEADER.biCompression = 0;
            bITMAPINFOHEADER.write();
            bITMAPINFO.write();
            WinDef.HDC hDC = User32.INSTANCE.GetDC(null);
            WinGDI.ICONINFO iCONINFO = new WinGDI.ICONINFO();
            User32.INSTANCE.GetIconInfo(hICON, iCONINFO);
            iCONINFO.read();
            GDI32.INSTANCE.GetDIBits(hDC, iCONINFO.hbmColor, 0, n3, memory, bITMAPINFO, 0);
            ((Pointer)memory).read(0L, byArray, 0, byArray.length);
            GDI32.INSTANCE.GetDIBits(hDC, iCONINFO.hbmMask, 0, n3, memory2, bITMAPINFO, 0);
            ((Pointer)memory2).read(0L, byArray2, 0, byArray2.length);
            BufferedImage bufferedImage = new BufferedImage(n2, n3, 2);
            int n5 = 0;
            int n6 = n3 - 1;
            for (int i2 = 0; i2 < byArray.length; i2 += 3) {
                int n7 = byArray[i2] & 0xFF;
                int n8 = byArray[i2 + 1] & 0xFF;
                int n9 = byArray[i2 + 2] & 0xFF;
                int n10 = 255 - byArray2[i2] & 0xFF;
                int n11 = n10 << 24 | n9 << 16 | n8 << 8 | n7;
                bufferedImage.setRGB(n5, n6, n11);
                n5 = (n5 + 1) % n2;
                if (n5 != 0) continue;
                --n6;
            }
            User32.INSTANCE.ReleaseDC(null, hDC);
            return bufferedImage;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Dimension getIconSize(WinDef.HICON hICON) {
            WinGDI.ICONINFO iCONINFO = new WinGDI.ICONINFO();
            try {
                if (!User32.INSTANCE.GetIconInfo(hICON, iCONINFO)) {
                    Dimension dimension = new Dimension();
                    return dimension;
                }
                iCONINFO.read();
                WinGDI.BITMAP bITMAP = new WinGDI.BITMAP();
                if (iCONINFO.hbmColor != null && iCONINFO.hbmColor.getPointer() != Pointer.NULL) {
                    int n2 = GDI32.INSTANCE.GetObject(iCONINFO.hbmColor, bITMAP.size(), bITMAP.getPointer());
                    bITMAP.read();
                    if (n2 > 0) {
                        Dimension dimension = new Dimension(bITMAP.bmWidth.intValue(), bITMAP.bmHeight.intValue());
                        return dimension;
                    }
                } else if (iCONINFO.hbmMask != null && iCONINFO.hbmMask.getPointer() != Pointer.NULL) {
                    int n3 = GDI32.INSTANCE.GetObject(iCONINFO.hbmMask, bITMAP.size(), bITMAP.getPointer());
                    bITMAP.read();
                    if (n3 > 0) {
                        Dimension dimension = new Dimension(bITMAP.bmWidth.intValue(), bITMAP.bmHeight.intValue() / 2);
                        return dimension;
                    }
                }
            }
            finally {
                if (iCONINFO.hbmColor != null && iCONINFO.hbmColor.getPointer() != Pointer.NULL) {
                    GDI32.INSTANCE.DeleteObject(iCONINFO.hbmColor);
                }
                if (iCONINFO.hbmMask != null && iCONINFO.hbmMask.getPointer() != Pointer.NULL) {
                    GDI32.INSTANCE.DeleteObject(iCONINFO.hbmMask);
                }
            }
            return new Dimension();
        }

        @Override
        public List<DesktopWindow> getAllWindows(final boolean bl2) {
            final LinkedList<DesktopWindow> linkedList = new LinkedList<DesktopWindow>();
            WinUser.WNDENUMPROC wNDENUMPROC = new WinUser.WNDENUMPROC(){

                @Override
                public boolean callback(WinDef.HWND hWND, Pointer pointer) {
                    try {
                        boolean bl22;
                        boolean bl3 = bl22 = !bl2 || User32.INSTANCE.IsWindowVisible(hWND);
                        if (bl22) {
                            String string = W32WindowUtils.this.getWindowTitle(hWND);
                            String string2 = W32WindowUtils.this.getProcessFilePath(hWND);
                            Rectangle rectangle = W32WindowUtils.this.getWindowLocationAndSize(hWND);
                            linkedList.add(new DesktopWindow(hWND, string, string2, rectangle));
                        }
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    return true;
                }
            };
            if (!User32.INSTANCE.EnumWindows(wNDENUMPROC, null)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            return linkedList;
        }

        @Override
        public String getWindowTitle(WinDef.HWND hWND) {
            int n2 = User32.INSTANCE.GetWindowTextLength(hWND) + 1;
            char[] cArray = new char[n2];
            int n3 = User32.INSTANCE.GetWindowText(hWND, cArray, cArray.length);
            return Native.toString(Arrays.copyOfRange(cArray, 0, n3));
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public String getProcessFilePath(WinDef.HWND hWND) {
            IntByReference intByReference = new IntByReference();
            User32.INSTANCE.GetWindowThreadProcessId(hWND, intByReference);
            WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, intByReference.getValue());
            if (hANDLE == null) {
                if (Kernel32.INSTANCE.GetLastError() != 5) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                hANDLE = Kernel32.INSTANCE.OpenProcess(4096, false, intByReference.getValue());
                if (hANDLE == null) {
                    if (Kernel32.INSTANCE.GetLastError() != 5) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    return "";
                }
            }
            try {
                String string;
                String string2 = PsapiUtil.GetProcessImageFileName(hANDLE);
                if (string2.startsWith("\\Device\\Mup\\")) {
                    String string3 = "\\" + string2.substring(11);
                    return string3;
                }
                char[] cArray = new char[50];
                WinNT.HANDLE hANDLE2 = Kernel32.INSTANCE.FindFirstVolume(cArray, 50);
                if (hANDLE2 == null || hANDLE2.equals(WinBase.INVALID_HANDLE_VALUE)) {
                    throw new Win32Exception(Native.getLastError());
                }
                try {
                    do {
                        string = Native.toString(cArray);
                        for (String string4 : Kernel32Util.getVolumePathNamesForVolumeName(string)) {
                            if (!string4.matches("[a-zA-Z]:\\\\")) continue;
                            for (String string5 : Kernel32Util.queryDosDevice(string4.substring(0, 2), 1024)) {
                                if (!string2.startsWith(string5)) continue;
                                String string6 = string4 + string2.substring(string5.length() + 1);
                                return string6;
                            }
                        }
                    } while (Kernel32.INSTANCE.FindNextVolume(hANDLE2, cArray, 50));
                    if (Native.getLastError() != 18) {
                        throw new Win32Exception(Native.getLastError());
                    }
                }
                finally {
                    Kernel32.INSTANCE.FindVolumeClose(hANDLE2);
                }
                string = string2;
                return string;
            }
            finally {
                Kernel32.INSTANCE.CloseHandle(hANDLE);
            }
        }

        @Override
        public Rectangle getWindowLocationAndSize(WinDef.HWND hWND) {
            WinDef.RECT rECT = new WinDef.RECT();
            if (!User32.INSTANCE.GetWindowRect(hWND, rECT)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            return new Rectangle(rECT.left, rECT.top, Math.abs(rECT.right - rECT.left), Math.abs(rECT.bottom - rECT.top));
        }

        class W32TransparentContentPane
        extends NativeWindowUtils.TransparentContentPane {
            private static final long serialVersionUID = 1L;
            private WinDef.HDC memDC;
            private WinDef.HBITMAP hBitmap;
            private Pointer pbits;
            private Dimension bitmapSize;

            public W32TransparentContentPane(Container container) {
                super(container);
            }

            private void disposeBackingStore() {
                GDI32 gDI32 = GDI32.INSTANCE;
                if (this.hBitmap != null) {
                    gDI32.DeleteObject(this.hBitmap);
                    this.hBitmap = null;
                }
                if (this.memDC != null) {
                    gDI32.DeleteDC(this.memDC);
                    this.memDC = null;
                }
            }

            @Override
            public void removeNotify() {
                super.removeNotify();
                this.disposeBackingStore();
            }

            @Override
            public void setTransparent(boolean bl2) {
                super.setTransparent(bl2);
                if (!bl2) {
                    this.disposeBackingStore();
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            protected void paintDirect(BufferedImage bufferedImage, Rectangle rectangle) {
                Window window = SwingUtilities.getWindowAncestor(this);
                GDI32 gDI32 = GDI32.INSTANCE;
                User32 user32 = User32.INSTANCE;
                int n2 = rectangle.x;
                int n3 = rectangle.y;
                Point point = SwingUtilities.convertPoint(this, n2, n3, window);
                int n4 = rectangle.width;
                int n5 = rectangle.height;
                int n6 = window.getWidth();
                int n7 = window.getHeight();
                WinDef.HDC hDC = user32.GetDC(null);
                WinNT.HANDLE hANDLE = null;
                try {
                    Object object;
                    Object object2;
                    if (this.memDC == null) {
                        this.memDC = gDI32.CreateCompatibleDC(hDC);
                    }
                    if (this.hBitmap == null || !window.getSize().equals(this.bitmapSize)) {
                        if (this.hBitmap != null) {
                            gDI32.DeleteObject(this.hBitmap);
                            this.hBitmap = null;
                        }
                        object2 = new WinGDI.BITMAPINFO();
                        ((WinGDI.BITMAPINFO)object2).bmiHeader.biWidth = n6;
                        ((WinGDI.BITMAPINFO)object2).bmiHeader.biHeight = n7;
                        ((WinGDI.BITMAPINFO)object2).bmiHeader.biPlanes = 1;
                        ((WinGDI.BITMAPINFO)object2).bmiHeader.biBitCount = (short)32;
                        ((WinGDI.BITMAPINFO)object2).bmiHeader.biCompression = 0;
                        ((WinGDI.BITMAPINFO)object2).bmiHeader.biSizeImage = n6 * n7 * 4;
                        object = new PointerByReference();
                        this.hBitmap = gDI32.CreateDIBSection(this.memDC, (WinGDI.BITMAPINFO)object2, 0, (PointerByReference)object, null, 0);
                        this.pbits = ((PointerByReference)object).getValue();
                        this.bitmapSize = new Dimension(n6, n7);
                    }
                    hANDLE = gDI32.SelectObject(this.memDC, this.hBitmap);
                    object2 = bufferedImage.getData();
                    object = new int[4];
                    int[] nArray = new int[n4];
                    for (int i2 = 0; i2 < n5; ++i2) {
                        int n8;
                        for (n8 = 0; n8 < n4; ++n8) {
                            ((Raster)object2).getPixel(n8, i2, (int[])object);
                            int n9 = (object[3] & 0xFF) << 24;
                            int n10 = object[2] & 0xFF;
                            int n11 = (object[1] & 0xFF) << 8;
                            int n12 = (object[0] & 0xFF) << 16;
                            nArray[n8] = n9 | n10 | n11 | n12;
                        }
                        n8 = n7 - (point.y + i2) - 1;
                        this.pbits.write((long)((n8 * n6 + point.x) * 4), nArray, 0, nArray.length);
                    }
                    WinUser.SIZE sIZE = new WinUser.SIZE();
                    sIZE.cx = window.getWidth();
                    sIZE.cy = window.getHeight();
                    WinDef.POINT pOINT = new WinDef.POINT();
                    pOINT.x = window.getX();
                    pOINT.y = window.getY();
                    WinDef.POINT pOINT2 = new WinDef.POINT();
                    WinUser.BLENDFUNCTION bLENDFUNCTION = new WinUser.BLENDFUNCTION();
                    WinDef.HWND hWND = W32WindowUtils.this.getHWnd(window);
                    ByteByReference byteByReference = new ByteByReference();
                    IntByReference intByReference = new IntByReference();
                    byte by2 = W32WindowUtils.this.getAlpha(window);
                    try {
                        if (user32.GetLayeredWindowAttributes(hWND, null, byteByReference, intByReference) && (intByReference.getValue() & 2) != 0) {
                            by2 = byteByReference.getValue();
                        }
                    }
                    catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                        // empty catch block
                    }
                    bLENDFUNCTION.SourceConstantAlpha = by2;
                    bLENDFUNCTION.AlphaFormat = 1;
                    user32.UpdateLayeredWindow(hWND, hDC, pOINT, sIZE, this.memDC, pOINT2, 0, bLENDFUNCTION, 2);
                    user32.ReleaseDC(null, hDC);
                }
                catch (Throwable throwable) {
                    user32.ReleaseDC(null, hDC);
                    if (this.memDC != null && hANDLE != null) {
                        gDI32.SelectObject(this.memDC, hANDLE);
                    }
                    throw throwable;
                }
                if (this.memDC != null && hANDLE != null) {
                    gDI32.SelectObject(this.memDC, hANDLE);
                }
            }
        }
    }

    static class Holder {
        public static boolean requiresVisible;
        public static final NativeWindowUtils INSTANCE;

        private Holder() {
        }

        static {
            if (Platform.isWindows()) {
                INSTANCE = new W32WindowUtils();
            } else if (Platform.isMac()) {
                INSTANCE = new MacWindowUtils();
            } else if (Platform.isX11()) {
                INSTANCE = new X11WindowUtils();
                requiresVisible = System.getProperty("java.version").matches("^1\\.4\\..*");
            } else {
                String string = System.getProperty("os.name");
                throw new UnsupportedOperationException("No support for " + string);
            }
        }
    }

    public static abstract class NativeWindowUtils {
        protected Window getWindow(Component component) {
            return component instanceof Window ? (Window)component : SwingUtilities.getWindowAncestor(component);
        }

        protected void whenDisplayable(Component component, final Runnable runnable) {
            if (component.isDisplayable() && (!Holder.requiresVisible || component.isVisible())) {
                runnable.run();
            } else if (Holder.requiresVisible) {
                this.getWindow(component).addWindowListener(new WindowAdapter(){

                    @Override
                    public void windowOpened(WindowEvent windowEvent) {
                        windowEvent.getWindow().removeWindowListener(this);
                        runnable.run();
                    }

                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        windowEvent.getWindow().removeWindowListener(this);
                    }
                });
            } else {
                component.addHierarchyListener(new HierarchyListener(){

                    @Override
                    public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
                        if ((hierarchyEvent.getChangeFlags() & 2L) != 0L && hierarchyEvent.getComponent().isDisplayable()) {
                            hierarchyEvent.getComponent().removeHierarchyListener(this);
                            runnable.run();
                        }
                    }
                });
            }
        }

        protected Raster toRaster(Shape shape) {
            WritableRaster writableRaster = null;
            if (shape != MASK_NONE) {
                Rectangle rectangle = shape.getBounds();
                if (rectangle.width > 0 && rectangle.height > 0) {
                    BufferedImage bufferedImage = new BufferedImage(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 12);
                    Graphics2D graphics2D = bufferedImage.createGraphics();
                    graphics2D.setColor(Color.black);
                    graphics2D.fillRect(0, 0, rectangle.x + rectangle.width, rectangle.y + rectangle.height);
                    graphics2D.setColor(Color.white);
                    graphics2D.fill(shape);
                    writableRaster = bufferedImage.getRaster();
                }
            }
            return writableRaster;
        }

        protected Raster toRaster(Component component, Icon icon) {
            WritableRaster writableRaster = null;
            if (icon != null) {
                Rectangle rectangle = new Rectangle(0, 0, icon.getIconWidth(), icon.getIconHeight());
                BufferedImage bufferedImage = new BufferedImage(rectangle.width, rectangle.height, 2);
                Graphics2D graphics2D = bufferedImage.createGraphics();
                graphics2D.setComposite(AlphaComposite.Clear);
                graphics2D.fillRect(0, 0, rectangle.width, rectangle.height);
                graphics2D.setComposite(AlphaComposite.SrcOver);
                icon.paintIcon(component, graphics2D, 0, 0);
                writableRaster = bufferedImage.getAlphaRaster();
            }
            return writableRaster;
        }

        protected Shape toShape(Raster raster) {
            final Area area = new Area(new Rectangle(0, 0, 0, 0));
            RasterRangesUtils.outputOccupiedRanges(raster, new RasterRangesUtils.RangesOutput(){

                @Override
                public boolean outputRange(int n2, int n3, int n4, int n5) {
                    area.add(new Area(new Rectangle(n2, n3, n4, n5)));
                    return true;
                }
            });
            return area;
        }

        public void setWindowAlpha(Window window, float f2) {
        }

        public boolean isWindowAlphaSupported() {
            return false;
        }

        public GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
            return graphicsDevice.getDefaultConfiguration();
        }

        public void setWindowTransparent(Window window, boolean bl2) {
        }

        protected void setDoubleBuffered(Component component, boolean bl2) {
            if (component instanceof JComponent) {
                ((JComponent)component).setDoubleBuffered(bl2);
            }
            if (component instanceof JRootPane && bl2) {
                ((JRootPane)component).setDoubleBuffered(true);
            } else if (component instanceof Container) {
                Component[] componentArray = ((Container)component).getComponents();
                for (int i2 = 0; i2 < componentArray.length; ++i2) {
                    this.setDoubleBuffered(componentArray[i2], bl2);
                }
            }
        }

        protected void setLayersTransparent(Window window, boolean bl2) {
            Color color;
            Color color2 = color = bl2 ? new Color(0, 0, 0, 0) : null;
            if (window instanceof RootPaneContainer) {
                JComponent jComponent;
                RootPaneContainer rootPaneContainer = (RootPaneContainer)((Object)window);
                JRootPane jRootPane = rootPaneContainer.getRootPane();
                JLayeredPane jLayeredPane = jRootPane.getLayeredPane();
                Container container = jRootPane.getContentPane();
                JComponent jComponent2 = jComponent = container instanceof JComponent ? (JComponent)container : null;
                if (bl2) {
                    jLayeredPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, jLayeredPane.isOpaque());
                    jLayeredPane.setOpaque(false);
                    jRootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, jRootPane.isOpaque());
                    jRootPane.setOpaque(false);
                    if (jComponent != null) {
                        jComponent.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, jComponent.isOpaque());
                        jComponent.setOpaque(false);
                    }
                    jRootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, jRootPane.getParent().getBackground());
                } else {
                    jLayeredPane.setOpaque(Boolean.TRUE.equals(jLayeredPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE)));
                    jLayeredPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, null);
                    jRootPane.setOpaque(Boolean.TRUE.equals(jRootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE)));
                    jRootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, null);
                    if (jComponent != null) {
                        jComponent.setOpaque(Boolean.TRUE.equals(jComponent.getClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE)));
                        jComponent.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, null);
                    }
                    color = (Color)jRootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_BG);
                    jRootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, null);
                }
            }
            window.setBackground(color);
        }

        protected void setMask(Component component, Raster raster) {
            throw new UnsupportedOperationException("Window masking is not available");
        }

        protected void setWindowMask(Component component, Raster raster) {
            if (component.isLightweight()) {
                throw new IllegalArgumentException("Component must be heavyweight: " + component);
            }
            this.setMask(component, raster);
        }

        public void setWindowMask(Component component, Shape shape) {
            this.setWindowMask(component, this.toRaster(shape));
        }

        public void setWindowMask(Component component, Icon icon) {
            this.setWindowMask(component, this.toRaster(component, icon));
        }

        protected void setForceHeavyweightPopups(Window window, boolean bl2) {
            if (!(window instanceof HeavyweightForcer)) {
                Window[] windowArray = window.getOwnedWindows();
                for (int i2 = 0; i2 < windowArray.length; ++i2) {
                    if (!(windowArray[i2] instanceof HeavyweightForcer)) continue;
                    if (bl2) {
                        return;
                    }
                    windowArray[i2].dispose();
                }
                Boolean bl3 = Boolean.valueOf(System.getProperty("jna.force_hw_popups", "true"));
                if (bl2 && bl3.booleanValue()) {
                    new HeavyweightForcer(window);
                }
            }
        }

        protected BufferedImage getWindowIcon(WinDef.HWND hWND) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected Dimension getIconSize(WinDef.HICON hICON) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected List<DesktopWindow> getAllWindows(boolean bl2) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected String getWindowTitle(WinDef.HWND hWND) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected String getProcessFilePath(WinDef.HWND hWND) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected Rectangle getWindowLocationAndSize(WinDef.HWND hWND) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected abstract class TransparentContentPane
        extends JPanel
        implements AWTEventListener {
            private static final long serialVersionUID = 1L;
            private boolean transparent;

            public TransparentContentPane(Container container) {
                super(new BorderLayout());
                this.add((Component)container, "Center");
                this.setTransparent(true);
                if (container instanceof JPanel) {
                    ((JComponent)container).setOpaque(false);
                }
            }

            @Override
            public void addNotify() {
                super.addNotify();
                Toolkit.getDefaultToolkit().addAWTEventListener(this, 2L);
            }

            @Override
            public void removeNotify() {
                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                super.removeNotify();
            }

            public void setTransparent(boolean bl2) {
                this.transparent = bl2;
                this.setOpaque(!bl2);
                this.setDoubleBuffered(!bl2);
                this.repaint();
            }

            @Override
            public void eventDispatched(AWTEvent aWTEvent) {
                if (aWTEvent.getID() == 300 && SwingUtilities.isDescendingFrom(((ContainerEvent)aWTEvent).getChild(), this)) {
                    Component component = ((ContainerEvent)aWTEvent).getChild();
                    NativeWindowUtils.this.setDoubleBuffered(component, false);
                }
            }

            @Override
            public void paint(Graphics graphics) {
                if (this.transparent) {
                    Rectangle rectangle = graphics.getClipBounds();
                    int n2 = rectangle.width;
                    int n3 = rectangle.height;
                    if (this.getWidth() > 0 && this.getHeight() > 0) {
                        BufferedImage bufferedImage = new BufferedImage(n2, n3, 3);
                        Graphics2D graphics2D = bufferedImage.createGraphics();
                        graphics2D.setComposite(AlphaComposite.Clear);
                        graphics2D.fillRect(0, 0, n2, n3);
                        graphics2D.dispose();
                        graphics2D = bufferedImage.createGraphics();
                        graphics2D.translate(-rectangle.x, -rectangle.y);
                        super.paint(graphics2D);
                        graphics2D.dispose();
                        this.paintDirect(bufferedImage, rectangle);
                    }
                } else {
                    super.paint(graphics);
                }
            }

            protected abstract void paintDirect(BufferedImage var1, Rectangle var2);
        }
    }

    protected static class RepaintTrigger
    extends JComponent {
        private static final long serialVersionUID = 1L;
        private final Listener listener = this.createListener();
        private final JComponent content;
        private Rectangle dirty;

        public RepaintTrigger(JComponent jComponent) {
            this.content = jComponent;
        }

        @Override
        public void addNotify() {
            super.addNotify();
            Window window = SwingUtilities.getWindowAncestor(this);
            this.setSize(this.getParent().getSize());
            window.addComponentListener(this.listener);
            window.addWindowListener(this.listener);
            Toolkit.getDefaultToolkit().addAWTEventListener(this.listener, 48L);
        }

        @Override
        public void removeNotify() {
            Toolkit.getDefaultToolkit().removeAWTEventListener(this.listener);
            Window window = SwingUtilities.getWindowAncestor(this);
            window.removeComponentListener(this.listener);
            window.removeWindowListener(this.listener);
            super.removeNotify();
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            Rectangle rectangle = graphics.getClipBounds();
            if (this.dirty == null || !this.dirty.contains(rectangle)) {
                this.dirty = this.dirty == null ? rectangle : this.dirty.union(rectangle);
                this.content.repaint(this.dirty);
            } else {
                this.dirty = null;
            }
        }

        protected Listener createListener() {
            return new Listener();
        }

        protected class Listener
        extends WindowAdapter
        implements AWTEventListener,
        ComponentListener,
        HierarchyListener {
            protected Listener() {
            }

            @Override
            public void windowOpened(WindowEvent windowEvent) {
                RepaintTrigger.this.repaint();
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {
            }

            @Override
            public void componentResized(ComponentEvent componentEvent) {
                RepaintTrigger.this.setSize(RepaintTrigger.this.getParent().getSize());
                RepaintTrigger.this.repaint();
            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                RepaintTrigger.this.repaint();
            }

            @Override
            public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
                RepaintTrigger.this.repaint();
            }

            @Override
            public void eventDispatched(AWTEvent aWTEvent) {
                Component component;
                if (aWTEvent instanceof MouseEvent && (component = ((MouseEvent)aWTEvent).getComponent()) != null && SwingUtilities.isDescendingFrom(component, RepaintTrigger.this.content)) {
                    MouseEvent mouseEvent = SwingUtilities.convertMouseEvent(component, (MouseEvent)aWTEvent, RepaintTrigger.this.content);
                    Component component2 = SwingUtilities.getDeepestComponentAt(RepaintTrigger.this.content, mouseEvent.getX(), mouseEvent.getY());
                    if (component2 != null) {
                        RepaintTrigger.this.setCursor(component2.getCursor());
                    }
                }
            }
        }
    }

    static class HeavyweightForcer
    extends Window {
        private static final long serialVersionUID = 1L;
        private final boolean packed;

        public HeavyweightForcer(Window window) {
            super(window);
            this.pack();
            this.packed = true;
        }

        @Override
        public boolean isVisible() {
            return this.packed;
        }

        @Override
        public Rectangle getBounds() {
            return this.getOwner().getBounds();
        }
    }
}

