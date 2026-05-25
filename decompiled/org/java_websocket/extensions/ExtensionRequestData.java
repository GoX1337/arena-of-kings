/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.extensions;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExtensionRequestData {
    public static final String EMPTY_VALUE = "";
    private Map<String, String> extensionParameters = new LinkedHashMap<String, String>();
    private String extensionName;

    private ExtensionRequestData() {
    }

    public static ExtensionRequestData parseExtensionRequest(String string) {
        ExtensionRequestData extensionRequestData = new ExtensionRequestData();
        String[] stringArray = string.split(";");
        extensionRequestData.extensionName = stringArray[0].trim();
        for (int i2 = 1; i2 < stringArray.length; ++i2) {
            String[] stringArray2 = stringArray[i2].split("=");
            String string2 = EMPTY_VALUE;
            if (stringArray2.length > 1) {
                String string3 = stringArray2[1].trim();
                if (string3.startsWith("\"") && string3.endsWith("\"") || string3.startsWith("'") && string3.endsWith("'") && string3.length() > 2) {
                    string3 = string3.substring(1, string3.length() - 1);
                }
                string2 = string3;
            }
            extensionRequestData.extensionParameters.put(stringArray2[0].trim(), string2);
        }
        return extensionRequestData;
    }

    public String getExtensionName() {
        return this.extensionName;
    }

    public Map<String, String> getExtensionParameters() {
        return this.extensionParameters;
    }
}

