/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;

public class Lwjgl3Cursor
implements Cursor {
    static final Array<Lwjgl3Cursor> cursors = new Array();
    static final Map<Cursor.SystemCursor, Long> systemCursors = new HashMap<Cursor.SystemCursor, Long>();
    final Lwjgl3Window window;
    Pixmap pixmapCopy;
    GLFWImage glfwImage;
    final long glfwCursor;

    Lwjgl3Cursor(Lwjgl3Window lwjgl3Window, Pixmap pixmap, int n2, int n3) {
        this.window = lwjgl3Window;
        if (pixmap.getFormat() != Pixmap.Format.RGBA8888) {
            throw new GdxRuntimeException("Cursor image pixmap is not in RGBA8888 format.");
        }
        if ((pixmap.getWidth() & pixmap.getWidth() - 1) != 0) {
            throw new GdxRuntimeException("Cursor image pixmap width of " + pixmap.getWidth() + " is not a power-of-two greater than zero.");
        }
        if ((pixmap.getHeight() & pixmap.getHeight() - 1) != 0) {
            throw new GdxRuntimeException("Cursor image pixmap height of " + pixmap.getHeight() + " is not a power-of-two greater than zero.");
        }
        if (n2 < 0 || n2 >= pixmap.getWidth()) {
            throw new GdxRuntimeException("xHotspot coordinate of " + n2 + " is not within image width bounds: [0, " + pixmap.getWidth() + ").");
        }
        if (n3 < 0 || n3 >= pixmap.getHeight()) {
            throw new GdxRuntimeException("yHotspot coordinate of " + n3 + " is not within image height bounds: [0, " + pixmap.getHeight() + ").");
        }
        this.pixmapCopy = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), Pixmap.Format.RGBA8888);
        this.pixmapCopy.setBlending(Pixmap.Blending.None);
        this.pixmapCopy.drawPixmap(pixmap, 0, 0);
        this.glfwImage = GLFWImage.malloc();
        this.glfwImage.width(this.pixmapCopy.getWidth());
        this.glfwImage.height(this.pixmapCopy.getHeight());
        this.glfwImage.pixels(this.pixmapCopy.getPixels());
        this.glfwCursor = GLFW.glfwCreateCursor(this.glfwImage, n2, n3);
        cursors.add(this);
    }

    @Override
    public void dispose() {
        if (this.pixmapCopy == null) {
            throw new GdxRuntimeException("Cursor already disposed");
        }
        cursors.removeValue(this, true);
        this.pixmapCopy.dispose();
        this.pixmapCopy = null;
        this.glfwImage.free();
        GLFW.glfwDestroyCursor(this.glfwCursor);
    }

    static void dispose(Lwjgl3Window lwjgl3Window) {
        for (int i2 = Lwjgl3Cursor.cursors.size - 1; i2 >= 0; --i2) {
            Lwjgl3Cursor lwjgl3Cursor = cursors.get(i2);
            if (!lwjgl3Cursor.window.equals(lwjgl3Window)) continue;
            cursors.removeIndex(i2).dispose();
        }
    }

    static void disposeSystemCursors() {
        for (long l2 : systemCursors.values()) {
            GLFW.glfwDestroyCursor(l2);
        }
        systemCursors.clear();
    }

    static void setSystemCursor(long l2, Cursor.SystemCursor systemCursor) {
        if (systemCursor == Cursor.SystemCursor.None) {
            GLFW.glfwSetInputMode(l2, 208897, 212994);
            return;
        }
        GLFW.glfwSetInputMode(l2, 208897, 212993);
        Long l3 = systemCursors.get((Object)systemCursor);
        if (l3 == null) {
            long l4 = 0L;
            if (systemCursor == Cursor.SystemCursor.Arrow) {
                l4 = GLFW.glfwCreateStandardCursor(221185);
            } else if (systemCursor == Cursor.SystemCursor.Crosshair) {
                l4 = GLFW.glfwCreateStandardCursor(221187);
            } else if (systemCursor == Cursor.SystemCursor.Hand) {
                l4 = GLFW.glfwCreateStandardCursor(221188);
            } else if (systemCursor == Cursor.SystemCursor.HorizontalResize) {
                l4 = GLFW.glfwCreateStandardCursor(221189);
            } else if (systemCursor == Cursor.SystemCursor.VerticalResize) {
                l4 = GLFW.glfwCreateStandardCursor(221190);
            } else if (systemCursor == Cursor.SystemCursor.Ibeam) {
                l4 = GLFW.glfwCreateStandardCursor(221186);
            } else if (systemCursor == Cursor.SystemCursor.NWSEResize) {
                l4 = GLFW.glfwCreateStandardCursor(221191);
            } else if (systemCursor == Cursor.SystemCursor.NESWResize) {
                l4 = GLFW.glfwCreateStandardCursor(221192);
            } else if (systemCursor == Cursor.SystemCursor.AllResize) {
                l4 = GLFW.glfwCreateStandardCursor(221193);
            } else if (systemCursor == Cursor.SystemCursor.NotAllowed) {
                l4 = GLFW.glfwCreateStandardCursor(221194);
            } else {
                throw new GdxRuntimeException("Unknown system cursor " + (Object)((Object)systemCursor));
            }
            if (l4 == 0L) {
                return;
            }
            l3 = l4;
            systemCursors.put(systemCursor, l3);
        }
        GLFW.glfwSetCursor(l2, l3);
    }
}

