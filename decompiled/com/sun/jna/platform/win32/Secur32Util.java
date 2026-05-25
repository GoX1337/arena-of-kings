/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Secur32;
import com.sun.jna.platform.win32.Sspi;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;

public abstract class Secur32Util {
    public static String getUserNameEx(int n2) {
        char[] cArray = new char[128];
        IntByReference intByReference = new IntByReference(cArray.length);
        boolean bl2 = Secur32.INSTANCE.GetUserNameEx(n2, cArray, intByReference);
        if (!bl2) {
            int n3 = Kernel32.INSTANCE.GetLastError();
            switch (n3) {
                case 234: {
                    cArray = new char[intByReference.getValue() + 1];
                    break;
                }
                default: {
                    throw new Win32Exception(Native.getLastError());
                }
            }
            bl2 = Secur32.INSTANCE.GetUserNameEx(n2, cArray, intByReference);
        }
        if (!bl2) {
            throw new Win32Exception(Native.getLastError());
        }
        return Native.toString(cArray);
    }

    public static SecurityPackage[] getSecurityPackages() {
        IntByReference intByReference = new IntByReference();
        Sspi.PSecPkgInfo pSecPkgInfo = new Sspi.PSecPkgInfo();
        int n2 = Secur32.INSTANCE.EnumerateSecurityPackages(intByReference, pSecPkgInfo);
        if (0 != n2) {
            throw new Win32Exception(n2);
        }
        Sspi.SecPkgInfo.ByReference[] byReferenceArray = pSecPkgInfo.com_sun_jna_platform_win32_Sspi$SecPkgInfo$ByReference_arr_toArray(intByReference.getValue());
        ArrayList<SecurityPackage> arrayList = new ArrayList<SecurityPackage>(intByReference.getValue());
        for (Sspi.SecPkgInfo.ByReference byReference : byReferenceArray) {
            SecurityPackage securityPackage = new SecurityPackage();
            securityPackage.name = byReference.Name.toString();
            securityPackage.comment = byReference.Comment.toString();
            arrayList.add(securityPackage);
        }
        n2 = Secur32.INSTANCE.FreeContextBuffer(pSecPkgInfo.pPkgInfo.getPointer());
        if (0 != n2) {
            throw new Win32Exception(n2);
        }
        return arrayList.toArray(new SecurityPackage[0]);
    }

    public static class SecurityPackage {
        public String name;
        public String comment;
    }
}

