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

@Deprecated
public final class TranslateV1
extends GoogleAPI
implements Translate {
    private static final String LANG_PARAM = "&langpair=";
    private static final String TEXT_PARAM = "&q=";
    private static final String PIPE_PARAM = "%7C";
    private static final String URL = "http://ajax.googleapis.com/ajax/services/language/translate";
    private static final String PARAMETERS = "v=2.0&langpair=#FROM#%7C#TO#&q=";

    @Override
    public String execute(String string, Language language, Language language2) {
        try {
            TranslateV1.validateReferrer();
            URL uRL = new URL(URL);
            String string2 = PARAMETERS.replaceAll("#FROM#", language.toString()).replaceAll("#TO#", language2.toString()) + URLEncoder.encode(string, "UTF-8") + (key != null ? "&key=" + key : "");
            JSONObject jSONObject = TranslateV1.retrieveJSON(uRL, string2);
            return TranslateV1.getJSONResponse(jSONObject);
        }
        catch (Exception exception) {
            throw new GoogleAPIException(exception);
        }
    }

    @Override
    public String[] execute(String[] stringArray, Language language, Language language2) {
        try {
            TranslateV1.validateReferrer();
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
            TranslateV1.validateReferrer();
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
            TranslateV1.validateReferrer();
            if (stringArray.length != languageArray.length || languageArray.length != languageArray2.length) {
                throw new Exception("[google-api-translate-java] The same number of texts, from and to languages must be supplied.");
            }
            if (stringArray.length == 1) {
                return new String[]{this.execute(stringArray[0], languageArray[0], languageArray2[0])};
            }
            String[] stringArray2 = new String[stringArray.length];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PARAMETERS.replaceAll("#FROM#", languageArray[0].toString()).replaceAll("#TO#", languageArray2[0].toString()) + (key != null ? "&key=" + key : ""));
            stringBuilder.append(URLEncoder.encode(stringArray[0], "UTF-8"));
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                stringBuilder.append(LANG_PARAM);
                stringBuilder.append(languageArray[i2].toString());
                stringBuilder.append(PIPE_PARAM);
                stringBuilder.append(languageArray2[i2].toString());
                stringBuilder.append(TEXT_PARAM);
                stringBuilder.append(URLEncoder.encode(stringArray[i2].toString(), "UTF-8"));
            }
            URL uRL = new URL(URL);
            JSONArray jSONArray = TranslateV1.retrieveJSON(uRL, stringBuilder.toString()).getJSONArray("responseData");
            for (int i3 = 0; i3 < jSONArray.length(); ++i3) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                stringArray2[i3] = TranslateV1.getJSONResponse(jSONObject);
            }
            return stringArray2;
        }
        catch (Exception exception) {
            throw new GoogleAPIException(exception);
        }
    }

    private static String getJSONResponse(JSONObject jSONObject) {
        if (jSONObject.getString("responseStatus").equals("200")) {
            String string = jSONObject.getJSONObject("responseData").getString("translatedText");
            return bwn.a(string);
        }
        throw new GoogleAPIException("Google returned the following error: [" + jSONObject.getString("responseStatus") + "] " + jSONObject.getString("responseDetails"));
    }
}

