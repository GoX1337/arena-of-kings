/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows;

import com.sun.jna.Pointer;
import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSDesktopWindow;

@ThreadSafe
public final class EnumWindows {
    private static final WinDef.DWORD GW_HWNDNEXT = new WinDef.DWORD(2L);

    private EnumWindows() {
    }

    public static List<OSDesktopWindow> queryDesktopWindows(boolean bl2) {
        List<DesktopWindow> list = WindowUtils.getAllWindows(true);
        ArrayList<OSDesktopWindow> arrayList = new ArrayList<OSDesktopWindow>();
        HashMap<WinDef.HWND, Integer> hashMap = new HashMap<WinDef.HWND, Integer>();
        for (DesktopWindow desktopWindow : list) {
            WinDef.HWND hWND = desktopWindow.getHWND();
            if (hWND == null) continue;
            boolean bl3 = User32.INSTANCE.IsWindowVisible(hWND);
            if (bl2 && !bl3) continue;
            if (!hashMap.containsKey(hWND)) {
                EnumWindows.updateWindowZOrderMap(hWND, hashMap);
            }
            IntByReference intByReference = new IntByReference();
            User32.INSTANCE.GetWindowThreadProcessId(hWND, intByReference);
            arrayList.add(new OSDesktopWindow(Pointer.nativeValue(hWND.getPointer()), desktopWindow.getTitle(), desktopWindow.getFilePath(), desktopWindow.getLocAndSize(), intByReference.getValue(), (Integer)hashMap.get(hWND), bl3));
        }
        return arrayList;
    }

    private static void updateWindowZOrderMap(WinDef.HWND hWND2, Map<WinDef.HWND, Integer> map) {
        if (hWND2 != null) {
            int n2 = 1;
            WinDef.HWND hWND3 = new WinDef.HWND(hWND2.getPointer());
            do {
                map.put(hWND3, --n2);
            } while ((hWND3 = User32.INSTANCE.GetWindow(hWND3, GW_HWNDNEXT)) != null);
            int n4 = n2 * -1;
            map.replaceAll((hWND, n3) -> n3 + n4);
        }
    }
}

