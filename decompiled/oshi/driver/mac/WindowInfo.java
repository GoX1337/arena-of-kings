/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.mac;

import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.CoreFoundation;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.mac.CoreGraphics;
import oshi.software.os.OSDesktopWindow;
import oshi.util.FormatUtil;
import oshi.util.platform.mac.CFUtil;

@ThreadSafe
public final class WindowInfo {
    private WindowInfo() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<OSDesktopWindow> queryDesktopWindows(boolean bl2) {
        CoreFoundation.CFArrayRef cFArrayRef = CoreGraphics.INSTANCE.CGWindowListCopyWindowInfo(bl2 ? 17 : 0, 0);
        int n2 = cFArrayRef.getCount();
        ArrayList<OSDesktopWindow> arrayList = new ArrayList<OSDesktopWindow>();
        CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("kCGWindowIsOnscreen");
        CoreFoundation.CFStringRef cFStringRef2 = CoreFoundation.CFStringRef.createCFString("kCGWindowNumber");
        CoreFoundation.CFStringRef cFStringRef3 = CoreFoundation.CFStringRef.createCFString("kCGWindowOwnerPID");
        CoreFoundation.CFStringRef cFStringRef4 = CoreFoundation.CFStringRef.createCFString("kCGWindowLayer");
        CoreFoundation.CFStringRef cFStringRef5 = CoreFoundation.CFStringRef.createCFString("kCGWindowBounds");
        CoreFoundation.CFStringRef cFStringRef6 = CoreFoundation.CFStringRef.createCFString("kCGWindowName");
        CoreFoundation.CFStringRef cFStringRef7 = CoreFoundation.CFStringRef.createCFString("kCGWindowOwnerName");
        try {
            for (int i2 = 0; i2 < n2; ++i2) {
                boolean bl3;
                Pointer pointer = cFArrayRef.getValueAtIndex(i2);
                CoreFoundation.CFDictionaryRef cFDictionaryRef = new CoreFoundation.CFDictionaryRef(pointer);
                boolean bl4 = bl3 = (pointer = cFDictionaryRef.getValue(cFStringRef)) == null || new CoreFoundation.CFBooleanRef(pointer).booleanValue();
                if (bl2 && !bl3) continue;
                pointer = cFDictionaryRef.getValue(cFStringRef2);
                long l2 = new CoreFoundation.CFNumberRef(pointer).longValue();
                pointer = cFDictionaryRef.getValue(cFStringRef3);
                long l3 = new CoreFoundation.CFNumberRef(pointer).longValue();
                pointer = cFDictionaryRef.getValue(cFStringRef4);
                int n3 = new CoreFoundation.CFNumberRef(pointer).intValue();
                pointer = cFDictionaryRef.getValue(cFStringRef5);
                CoreGraphics.CGRect cGRect = new CoreGraphics.CGRect();
                CoreGraphics.INSTANCE.CGRectMakeWithDictionaryRepresentation(new CoreFoundation.CFDictionaryRef(pointer), cGRect);
                Rectangle rectangle = new Rectangle(FormatUtil.roundToInt(cGRect.origin.x), FormatUtil.roundToInt(cGRect.origin.y), FormatUtil.roundToInt(cGRect.size.width), FormatUtil.roundToInt(cGRect.size.height));
                pointer = cFDictionaryRef.getValue(cFStringRef6);
                String string = CFUtil.cfPointerToString(pointer, false);
                pointer = cFDictionaryRef.getValue(cFStringRef7);
                String string2 = CFUtil.cfPointerToString(pointer, false);
                string = string.isEmpty() ? string2 : string + "(" + string2 + ")";
                arrayList.add(new OSDesktopWindow(l2, string, string2, rectangle, l3, n3, bl3));
            }
        }
        finally {
            cFStringRef.release();
            cFStringRef2.release();
            cFStringRef3.release();
            cFStringRef4.release();
            cFStringRef5.release();
            cFStringRef6.release();
            cFStringRef7.release();
            cFArrayRef.release();
        }
        return arrayList;
    }
}

