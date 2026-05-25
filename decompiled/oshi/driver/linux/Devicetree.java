/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FileUtil;

@ThreadSafe
public final class Devicetree {
    private Devicetree() {
    }

    public static String queryModel() {
        String string = FileUtil.getStringFromFile("/sys/firmware/devicetree/base/model");
        if (!string.isEmpty()) {
            return string.replace("Machine: ", "");
        }
        return null;
    }
}

