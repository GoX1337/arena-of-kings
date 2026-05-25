/*
 * Decompiled with CFR 0.152.
 */
package com.google.api.translate;

import com.google.api.GoogleAPI;
import com.google.api.GoogleAPIException;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

public final class TranslateV2
extends GoogleAPI
implements Translate {
    private static final String URL_TEMPLATE = "https://www.googleapis.com/language/translate/v2?key=%s&q=%s&target=%s";

    @Override
    public String execute(String string, Language language, Language language2) {
        try {
            TranslateV2.validateReferrer();
            if (key == null) {
                throw new IllegalStateException("You MUST have a Google API Key to use the V2 APIs. See http://code.google.com/apis/language/translate/v2/getting_started.html");
            }
            String string2 = String.format(URL_TEMPLATE, key, URLEncoder.encode(string, "UTF-8"), language2.toString());
            URL uRL = new URL(Language.AUTO_DETECT.equals((Object)language) ? string2 : string2 + String.format("&source=%s", language.toString()));
            JSONObject jSONObject = TranslateV2.retrieveJSON(uRL);
            return TranslateV2.getJSONResponse(jSONObject);
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            throw new GoogleAPIException(exception);
        }
    }

    @Override
    public String[] execute(String[] stringArray, Language language, Language language2) {
        try {
            TranslateV2.validateReferrer();
            Language[] languageArray = new Language[stringArray.length];
            Language[] languageArray2 = new Language[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                languageArray[i2] = language;
                languageArray2[i2] = language2;
            }
            return this.execute(stringArray, languageArray, languageArray2);
        }
        catch (Exception exception) {
            throw new GoogleAPIException(exception);
        }
    }

    @Override
    public String[] execute(String string, Language language, Language[] languageArray) {
        try {
            TranslateV2.validateReferrer();
            String[] stringArray = new String[languageArray.length];
            Language[] languageArray2 = new Language[languageArray.length];
            for (int i2 = 0; i2 < languageArray.length; ++i2) {
                stringArray[i2] = string;
                languageArray2[i2] = language;
            }
            return this.execute(stringArray, languageArray2, languageArray);
        }
        catch (Exception exception) {
            throw new GoogleAPIException(exception);
        }
    }

    @Override
    public String[] execute(String[] stringArray, Language[] languageArray, Language[] languageArray2) {
        try {
            TranslateV2.validateReferrer();
            if (stringArray.length != languageArray.length || languageArray.length != languageArray2.length) {
                throw new Exception("[google-api-translate-java] The same number of texts, from and to languages must be supplied.");
            }
            if (stringArray.length == 1) {
                return new String[]{this.execute(stringArray[0], languageArray[0], languageArray2[0])};
            }
            String[] stringArray2 = new String[stringArray.length];
            for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                stringArray2[i2] = this.execute(stringArray[i2], languageArray[i2], languageArray2[i2]);
            }
            return stringArray2;
        }
        catch (Exception exception) {
            throw new GoogleAPIException(exception);
        }
    }

    private static String getJSONResponse(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        JSONArray jSONArray = jSONObject2.getJSONArray("translations");
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        String string = jSONObject3.getString("translatedText");
        return bwn.a(string);
    }
}

