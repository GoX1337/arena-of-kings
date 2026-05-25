/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GLVersion {
    private int majorVersion;
    private int minorVersion;
    private int releaseVersion;
    private final String vendorString;
    private final String rendererString;
    private final Type type;
    private final String TAG = "GLVersion";

    public GLVersion(Application.ApplicationType applicationType, String string, String string2, String string3) {
        this.type = applicationType == Application.ApplicationType.Android ? Type.GLES : (applicationType == Application.ApplicationType.iOS ? Type.GLES : (applicationType == Application.ApplicationType.Desktop ? Type.OpenGL : (applicationType == Application.ApplicationType.Applet ? Type.OpenGL : (applicationType == Application.ApplicationType.WebGL ? Type.WebGL : Type.NONE))));
        if (this.type == Type.GLES) {
            this.extractVersion("OpenGL ES (\\d(\\.\\d){0,2})", string);
        } else if (this.type == Type.WebGL) {
            this.extractVersion("WebGL (\\d(\\.\\d){0,2})", string);
        } else if (this.type == Type.OpenGL) {
            this.extractVersion("(\\d(\\.\\d){0,2})", string);
        } else {
            this.majorVersion = -1;
            this.minorVersion = -1;
            this.releaseVersion = -1;
            string2 = "";
            string3 = "";
        }
        this.vendorString = string2;
        this.rendererString = string3;
    }

    private void extractVersion(String string, String string2) {
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(string2);
        boolean bl2 = matcher.find();
        if (bl2) {
            String string3 = matcher.group(1);
            String[] stringArray = string3.split("\\.");
            this.majorVersion = this.parseInt(stringArray[0], 2);
            this.minorVersion = stringArray.length < 2 ? 0 : this.parseInt(stringArray[1], 0);
            this.releaseVersion = stringArray.length < 3 ? 0 : this.parseInt(stringArray[2], 0);
        } else {
            Gdx.app.log("GLVersion", "Invalid version string: " + string2);
            this.majorVersion = 2;
            this.minorVersion = 0;
            this.releaseVersion = 0;
        }
    }

    private int parseInt(String string, int n2) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            Gdx.app.error("libGDX GL", "Error parsing number: " + string + ", assuming: " + n2);
            return n2;
        }
    }

    public Type getType() {
        return this.type;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getReleaseVersion() {
        return this.releaseVersion;
    }

    public String getVendorString() {
        return this.vendorString;
    }

    public String getRendererString() {
        return this.rendererString;
    }

    public boolean isVersionEqualToOrHigher(int n2, int n3) {
        return this.majorVersion > n2 || this.majorVersion == n2 && this.minorVersion >= n3;
    }

    public String getDebugVersionString() {
        return "Type: " + (Object)((Object)this.type) + "\nVersion: " + this.majorVersion + ":" + this.minorVersion + ":" + this.releaseVersion + "\nVendor: " + this.vendorString + "\nRenderer: " + this.rendererString;
    }

    public static enum Type {
        OpenGL,
        GLES,
        WebGL,
        NONE;

    }
}

