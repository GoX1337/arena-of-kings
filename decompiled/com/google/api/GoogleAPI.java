/*
 * Decompiled with CFR 0.152.
 */
package com.google.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public abstract class GoogleAPI {
    protected static final String ENCODING = "UTF-8";
    protected static String referrer;
    protected static String key;

    public static void setHttpReferrer(String string) {
        referrer = string;
    }

    public static void setKey(String string) {
        key = string;
    }

    public static void validateReferrer() {
        if (referrer == null || referrer.length() == 0) {
            throw new Exception("[google-api-translate-java] Referrer is not set. Call setHttpReferrer().");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static JSONObject retrieveJSON(URL uRL) {
        JSONObject jSONObject;
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestProperty("referer", referrer);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoOutput(true);
        try {
            String string = GoogleAPI.inputStreamToString(httpURLConnection.getInputStream());
            jSONObject = new JSONObject(string);
        }
        catch (Throwable throwable) {
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
                throw throwable;
            }
            catch (Exception exception) {
                throw new Exception("[google-api-translate-java] Error retrieving translation.", exception);
            }
        }
        httpURLConnection.getInputStream().close();
        if (httpURLConnection.getErrorStream() != null) {
            httpURLConnection.getErrorStream().close();
        }
        return jSONObject;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static JSONObject retrieveJSON(URL uRL, String string) {
        JSONObject jSONObject;
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestProperty("referer", referrer);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
        printWriter.write(string);
        printWriter.close();
        httpURLConnection.getOutputStream().close();
        try {
            String string2 = GoogleAPI.inputStreamToString(httpURLConnection.getInputStream());
            jSONObject = new JSONObject(string2);
        }
        catch (Throwable throwable) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    httpURLConnection.getInputStream().close();
                }
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw throwable;
            }
            catch (Exception exception) {
                throw new Exception("[google-api-translate-java] Error retrieving translation.", exception);
            }
        }
        if (httpURLConnection.getInputStream() != null) {
            httpURLConnection.getInputStream().close();
        }
        if (httpURLConnection.getErrorStream() != null) {
            httpURLConnection.getErrorStream().close();
        }
        if (printWriter != null) {
            printWriter.close();
        }
        return jSONObject;
    }

    private static String inputStreamToString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (inputStream != null) {
                String string;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));
                while (null != (string = bufferedReader.readLine())) {
                    stringBuilder.append(string).append('\n');
                }
            }
        }
        catch (Exception exception) {
            throw new Exception("[google-api-translate-java] Error reading translation stream.", exception);
        }
        return stringBuilder.toString();
    }
}

