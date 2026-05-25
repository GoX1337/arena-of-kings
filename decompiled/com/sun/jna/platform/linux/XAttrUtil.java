/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.linux;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.linux.XAttr;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.LinkedHashSet;

public abstract class XAttrUtil {
    private XAttrUtil() {
    }

    public static void setXAttr(String string, String string2, String string3) {
        XAttrUtil.setXAttr(string, string2, string3, Native.getDefaultStringEncoding());
    }

    public static void setXAttr(String string, String string2, String string3, String string4) {
        XAttrUtil.setXAttr(string, string2, string3.getBytes(string4));
    }

    public static void setXAttr(String string, String string2, byte[] byArray) {
        int n2 = XAttr.INSTANCE.setxattr(string, string2, byArray, new XAttr.size_t((long)byArray.length), 0);
        if (n2 != 0) {
            int n3 = Native.getLastError();
            throw new IOException("errno: " + n3);
        }
    }

    public static void lSetXAttr(String string, String string2, String string3) {
        XAttrUtil.lSetXAttr(string, string2, string3, Native.getDefaultStringEncoding());
    }

    public static void lSetXAttr(String string, String string2, String string3, String string4) {
        XAttrUtil.lSetXAttr(string, string2, string3.getBytes(string4));
    }

    public static void lSetXAttr(String string, String string2, byte[] byArray) {
        int n2 = XAttr.INSTANCE.lsetxattr(string, string2, byArray, new XAttr.size_t((long)byArray.length), 0);
        if (n2 != 0) {
            int n3 = Native.getLastError();
            throw new IOException("errno: " + n3);
        }
    }

    public static void fSetXAttr(int n2, String string, String string2) {
        XAttrUtil.fSetXAttr(n2, string, string2, Native.getDefaultStringEncoding());
    }

    public static void fSetXAttr(int n2, String string, String string2, String string3) {
        XAttrUtil.fSetXAttr(n2, string, string2.getBytes(string3));
    }

    public static void fSetXAttr(int n2, String string, byte[] byArray) {
        int n3 = XAttr.INSTANCE.fsetxattr(n2, string, byArray, new XAttr.size_t((long)byArray.length), 0);
        if (n3 != 0) {
            int n4 = Native.getLastError();
            throw new IOException("errno: " + n4);
        }
    }

    public static String getXAttr(String string, String string2) {
        return XAttrUtil.getXAttr(string, string2, Native.getDefaultStringEncoding());
    }

    public static String getXAttr(String string, String string2, String string3) {
        byte[] byArray = XAttrUtil.getXAttrBytes(string, string2);
        return new String(byArray, Charset.forName(string3));
    }

    public static byte[] getXAttrBytes(String string, String string2) {
        byte[] byArray;
        XAttr.ssize_t ssize_t2;
        int n2 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.getxattr(string, string2, (byte[])null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n2 = Native.getLastError();
                throw new IOException("errno: " + n2);
            }
            byArray = new byte[ssize_t2.intValue()];
            if ((ssize_t2 = XAttr.INSTANCE.getxattr(string, string2, byArray, new XAttr.size_t((long)byArray.length))).longValue() >= 0L || (n2 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n2);
        } while (ssize_t2.longValue() < 0L && n2 == 34);
        return byArray;
    }

    public static Memory getXAttrAsMemory(String string, String string2) {
        Memory memory;
        XAttr.ssize_t ssize_t2;
        int n2 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.getxattr(string, string2, (Pointer)null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n2 = Native.getLastError();
                throw new IOException("errno: " + n2);
            }
            if (ssize_t2.longValue() == 0L) {
                return null;
            }
            memory = new Memory(ssize_t2.longValue());
            if ((ssize_t2 = XAttr.INSTANCE.getxattr(string, string2, memory, new XAttr.size_t(memory.size()))).longValue() >= 0L || (n2 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n2);
        } while (ssize_t2.longValue() < 0L && n2 == 34);
        return memory;
    }

    public static String lGetXAttr(String string, String string2) {
        return XAttrUtil.lGetXAttr(string, string2, Native.getDefaultStringEncoding());
    }

    public static String lGetXAttr(String string, String string2, String string3) {
        byte[] byArray = XAttrUtil.lGetXAttrBytes(string, string2);
        return new String(byArray, Charset.forName(string3));
    }

    public static byte[] lGetXAttrBytes(String string, String string2) {
        byte[] byArray;
        XAttr.ssize_t ssize_t2;
        int n2 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.lgetxattr(string, string2, (byte[])null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n2 = Native.getLastError();
                throw new IOException("errno: " + n2);
            }
            byArray = new byte[ssize_t2.intValue()];
            if ((ssize_t2 = XAttr.INSTANCE.lgetxattr(string, string2, byArray, new XAttr.size_t((long)byArray.length))).longValue() >= 0L || (n2 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n2);
        } while (ssize_t2.longValue() < 0L && n2 == 34);
        return byArray;
    }

    public static Memory lGetXAttrAsMemory(String string, String string2) {
        Memory memory;
        XAttr.ssize_t ssize_t2;
        int n2 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.lgetxattr(string, string2, (Pointer)null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n2 = Native.getLastError();
                throw new IOException("errno: " + n2);
            }
            if (ssize_t2.longValue() == 0L) {
                return null;
            }
            memory = new Memory(ssize_t2.longValue());
            if ((ssize_t2 = XAttr.INSTANCE.lgetxattr(string, string2, memory, new XAttr.size_t(memory.size()))).longValue() >= 0L || (n2 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n2);
        } while (ssize_t2.longValue() < 0L && n2 == 34);
        return memory;
    }

    public static String fGetXAttr(int n2, String string) {
        return XAttrUtil.fGetXAttr(n2, string, Native.getDefaultStringEncoding());
    }

    public static String fGetXAttr(int n2, String string, String string2) {
        byte[] byArray = XAttrUtil.fGetXAttrBytes(n2, string);
        return new String(byArray, Charset.forName(string2));
    }

    public static byte[] fGetXAttrBytes(int n2, String string) {
        byte[] byArray;
        XAttr.ssize_t ssize_t2;
        int n3 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.fgetxattr(n2, string, (byte[])null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n3 = Native.getLastError();
                throw new IOException("errno: " + n3);
            }
            byArray = new byte[ssize_t2.intValue()];
            if ((ssize_t2 = XAttr.INSTANCE.fgetxattr(n2, string, byArray, new XAttr.size_t((long)byArray.length))).longValue() >= 0L || (n3 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n3);
        } while (ssize_t2.longValue() < 0L && n3 == 34);
        return byArray;
    }

    public static Memory fGetXAttrAsMemory(int n2, String string) {
        Memory memory;
        XAttr.ssize_t ssize_t2;
        int n3 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.fgetxattr(n2, string, (Pointer)null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n3 = Native.getLastError();
                throw new IOException("errno: " + n3);
            }
            if (ssize_t2.longValue() == 0L) {
                return null;
            }
            memory = new Memory(ssize_t2.longValue());
            if ((ssize_t2 = XAttr.INSTANCE.fgetxattr(n2, string, memory, new XAttr.size_t(memory.size()))).longValue() >= 0L || (n3 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n3);
        } while (ssize_t2.longValue() < 0L && n3 == 34);
        return memory;
    }

    public static Collection<String> listXAttr(String string) {
        return XAttrUtil.listXAttr(string, Native.getDefaultStringEncoding());
    }

    public static Collection<String> listXAttr(String string, String string2) {
        byte[] byArray;
        XAttr.ssize_t ssize_t2;
        int n2 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.listxattr(string, (byte[])null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n2 = Native.getLastError();
                throw new IOException("errno: " + n2);
            }
            byArray = new byte[ssize_t2.intValue()];
            if ((ssize_t2 = XAttr.INSTANCE.listxattr(string, byArray, new XAttr.size_t((long)byArray.length))).longValue() >= 0L || (n2 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n2);
        } while (ssize_t2.longValue() < 0L && n2 == 34);
        return XAttrUtil.splitBufferToStrings(byArray, string2);
    }

    public static Collection<String> lListXAttr(String string) {
        return XAttrUtil.lListXAttr(string, Native.getDefaultStringEncoding());
    }

    public static Collection<String> lListXAttr(String string, String string2) {
        byte[] byArray;
        XAttr.ssize_t ssize_t2;
        int n2 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.llistxattr(string, (byte[])null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n2 = Native.getLastError();
                throw new IOException("errno: " + n2);
            }
            byArray = new byte[ssize_t2.intValue()];
            if ((ssize_t2 = XAttr.INSTANCE.llistxattr(string, byArray, new XAttr.size_t((long)byArray.length))).longValue() >= 0L || (n2 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n2);
        } while (ssize_t2.longValue() < 0L && n2 == 34);
        return XAttrUtil.splitBufferToStrings(byArray, string2);
    }

    public static Collection<String> fListXAttr(int n2) {
        return XAttrUtil.fListXAttr(n2, Native.getDefaultStringEncoding());
    }

    public static Collection<String> fListXAttr(int n2, String string) {
        byte[] byArray;
        XAttr.ssize_t ssize_t2;
        int n3 = 0;
        do {
            if ((ssize_t2 = XAttr.INSTANCE.flistxattr(n2, (byte[])null, XAttr.size_t.ZERO)).longValue() < 0L) {
                n3 = Native.getLastError();
                throw new IOException("errno: " + n3);
            }
            byArray = new byte[ssize_t2.intValue()];
            if ((ssize_t2 = XAttr.INSTANCE.flistxattr(n2, byArray, new XAttr.size_t((long)byArray.length))).longValue() >= 0L || (n3 = Native.getLastError()) == 34) continue;
            throw new IOException("errno: " + n3);
        } while (ssize_t2.longValue() < 0L && n3 == 34);
        return XAttrUtil.splitBufferToStrings(byArray, string);
    }

    public static void removeXAttr(String string, String string2) {
        int n2 = XAttr.INSTANCE.removexattr(string, string2);
        if (n2 != 0) {
            int n3 = Native.getLastError();
            throw new IOException("errno: " + n3);
        }
    }

    public static void lRemoveXAttr(String string, String string2) {
        int n2 = XAttr.INSTANCE.lremovexattr(string, string2);
        if (n2 != 0) {
            int n3 = Native.getLastError();
            throw new IOException("errno: " + n3);
        }
    }

    public static void fRemoveXAttr(int n2, String string) {
        int n3 = XAttr.INSTANCE.fremovexattr(n2, string);
        if (n3 != 0) {
            int n4 = Native.getLastError();
            throw new IOException("errno: " + n4);
        }
    }

    private static Collection<String> splitBufferToStrings(byte[] byArray, String string) {
        Charset charset = Charset.forName(string);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(1);
        int n2 = 0;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (byArray[i2] != 0) continue;
            String string2 = new String(byArray, n2, i2 - n2, charset);
            linkedHashSet.add(string2);
            n2 = i2 + 1;
        }
        return linkedHashSet;
    }
}

