/*
 * Decompiled with CFR 0.152.
 */
package com.google.api.detect;

import com.google.api.GoogleAPI;
import com.google.api.detect.DetectResult;
import com.google.api.translate.Language;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

public class Detect
extends GoogleAPI {
    private static String URL = "http://ajax.googleapis.com/ajax/services/language/detect?v=1.0&q=";

    public static DetectResult execute(String string) {
        Detect.validateReferrer();
        URL uRL = new URL(URL + URLEncoder.encode(string, "UTF-8"));
        JSONObject jSONObject = Detect.retrieveJSON(uRL);
        return new DetectResult(Language.fromString(jSONObject.getJSONObject("responseData").getString("language")), jSONObject.getJSONObject("responseData").getBoolean("isReliable"), jSONObject.getJSONObject("responseData").getDouble("confidence"));
    }
}

