/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinGDI;
import com.sun.jna.platform.win32.WinNT;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class GDI32Util {
    private static final DirectColorModel SCREENSHOT_COLOR_MODEL = new DirectColorModel(24, 0xFF0000, 65280, 255);
    private static final int[] SCREENSHOT_BAND_MASKS = new int[]{SCREENSHOT_COLOR_MODEL.getRedMask(), SCREENSHOT_COLOR_MODEL.getGreenMask(), SCREENSHOT_COLOR_MODEL.getBlueMask()};

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static BufferedImage getScreenshot(WinDef.HWND hWND) {
        BufferedImage bufferedImage;
        Object object;
        block27: {
            Object object2;
            Object object3;
            WinDef.RECT rECT = new WinDef.RECT();
            if (!User32.INSTANCE.GetWindowRect(hWND, rECT)) {
                throw new Win32Exception(Native.getLastError());
            }
            Rectangle rectangle = rECT.toRectangle();
            int n2 = rectangle.width;
            int n3 = rectangle.height;
            if (n2 == 0 || n3 == 0) {
                throw new IllegalStateException("Window width and/or height were 0 even though GetWindowRect did not appear to fail.");
            }
            WinDef.HDC hDC = User32.INSTANCE.GetDC(hWND);
            if (hDC == null) {
                throw new Win32Exception(Native.getLastError());
            }
            object = null;
            WinDef.HDC hDC2 = null;
            WinDef.HBITMAP hBITMAP = null;
            WinNT.HANDLE hANDLE = null;
            bufferedImage = null;
            try {
                hDC2 = GDI32.INSTANCE.CreateCompatibleDC(hDC);
                if (hDC2 == null) {
                    throw new Win32Exception(Native.getLastError());
                }
                hBITMAP = GDI32.INSTANCE.CreateCompatibleBitmap(hDC, n2, n3);
                if (hBITMAP == null) {
                    throw new Win32Exception(Native.getLastError());
                }
                hANDLE = GDI32.INSTANCE.SelectObject(hDC2, hBITMAP);
                if (hANDLE == null) {
                    throw new Win32Exception(Native.getLastError());
                }
                if (!GDI32.INSTANCE.BitBlt(hDC2, 0, 0, n2, n3, hDC, 0, 0, 0xCC0020)) {
                    throw new Win32Exception(Native.getLastError());
                }
                object3 = new WinGDI.BITMAPINFO();
                ((WinGDI.BITMAPINFO)object3).bmiHeader.biWidth = n2;
                ((WinGDI.BITMAPINFO)object3).bmiHeader.biHeight = -n3;
                ((WinGDI.BITMAPINFO)object3).bmiHeader.biPlanes = 1;
                ((WinGDI.BITMAPINFO)object3).bmiHeader.biBitCount = (short)32;
                ((WinGDI.BITMAPINFO)object3).bmiHeader.biCompression = 0;
                object2 = new Memory(n2 * n3 * 4);
                int n4 = GDI32.INSTANCE.GetDIBits(hDC, hBITMAP, 0, n3, (Pointer)object2, (WinGDI.BITMAPINFO)object3, 0);
                if (n4 == 0 || n4 == 87) {
                    throw new Win32Exception(Native.getLastError());
                }
                int n5 = n2 * n3;
                DataBufferInt dataBufferInt = new DataBufferInt(((Pointer)object2).getIntArray(0L, n5), n5);
                WritableRaster writableRaster = Raster.createPackedRaster(dataBufferInt, n2, n3, n2, SCREENSHOT_BAND_MASKS, null);
                bufferedImage = new BufferedImage(SCREENSHOT_COLOR_MODEL, writableRaster, false, null);
            }
            catch (Win32Exception win32Exception) {
                object = win32Exception;
                return object;
            }
            finally {
                Object object4;
                if (hANDLE != null && ((object4 = GDI32.INSTANCE.SelectObject(hDC2, hANDLE)) == null || WinGDI.HGDI_ERROR.equals(object4))) {
                    Win32Exception win32Exception = new Win32Exception(Native.getLastError());
                    if (object != null) {
                        win32Exception.addSuppressedReflected((Throwable)object);
                    }
                    object = win32Exception;
                }
                if (hBITMAP != null && !GDI32.INSTANCE.DeleteObject(hBITMAP)) {
                    object4 = new Win32Exception(Native.getLastError());
                    if (object != null) {
                        ((Win32Exception)object4).addSuppressedReflected((Throwable)object);
                    }
                    object = object4;
                }
                if (hDC2 != null && !GDI32.INSTANCE.DeleteDC(hDC2)) {
                    object4 = new Win32Exception(Native.getLastError());
                    if (object != null) {
                        ((Win32Exception)object4).addSuppressedReflected((Throwable)object);
                    }
                    object = object4;
                }
                if (hDC == null || 0 != User32.INSTANCE.ReleaseDC(hWND, hDC)) break block27;
                throw new IllegalStateException("Device context did not release properly.");
            }
            if (hANDLE != null && ((object3 = GDI32.INSTANCE.SelectObject(hDC2, hANDLE)) == null || WinGDI.HGDI_ERROR.equals(object3))) {
                object2 = new Win32Exception(Native.getLastError());
                if (object != null) {
                    ((Win32Exception)object2).addSuppressedReflected((Throwable)object);
                }
                object = object2;
            }
            if (hBITMAP != null && !GDI32.INSTANCE.DeleteObject(hBITMAP)) {
                object3 = new Win32Exception(Native.getLastError());
                if (object != null) {
                    ((Win32Exception)object3).addSuppressedReflected((Throwable)object);
                }
                object = object3;
            }
            if (hDC2 != null && !GDI32.INSTANCE.DeleteDC(hDC2)) {
                object3 = new Win32Exception(Native.getLastError());
                if (object != null) {
                    ((Win32Exception)object3).addSuppressedReflected((Throwable)object);
                }
                object = object3;
            }
            if (hDC != null && 0 == User32.INSTANCE.ReleaseDC(hWND, hDC)) {
                throw new IllegalStateException("Device context did not release properly.");
            }
        }
        if (object != null) {
            throw object;
        }
        return bufferedImage;
    }
}

