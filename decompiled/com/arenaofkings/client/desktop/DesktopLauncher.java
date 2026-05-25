/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.client.desktop;

import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] stringArray) {
        aj aj2 = new aj();
        Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration = new Lwjgl3ApplicationConfiguration();
        lwjgl3ApplicationConfiguration.setTitle("Arena of Kings");
        lwjgl3ApplicationConfiguration.setWindowIcon("aoklogo.png");
        Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode();
        if (aj2.boolean_a(ai.d)) {
            lwjgl3ApplicationConfiguration.setAutoIconify(true);
            lwjgl3ApplicationConfiguration.setFullscreenMode(displayMode);
            if (aj2.boolean_a(ai.c)) {
                lwjgl3ApplicationConfiguration.useVsync(true);
            } else {
                DesktopLauncher.a(aj2, lwjgl3ApplicationConfiguration, displayMode);
            }
        } else {
            lwjgl3ApplicationConfiguration.setDecorated(false);
            lwjgl3ApplicationConfiguration.setAutoIconify(true);
            lwjgl3ApplicationConfiguration.setWindowedMode(displayMode.width, displayMode.height + 1);
            DesktopLauncher.a(aj2, lwjgl3ApplicationConfiguration, displayMode);
        }
        new Lwjgl3Application(new Engine(aj2), lwjgl3ApplicationConfiguration);
    }

    private static void a(aj aj2, Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration, Graphics.DisplayMode displayMode) {
        lwjgl3ApplicationConfiguration.useVsync(false);
        if (aj2.java_lang_String_a(ai.var_ai_a).equalsIgnoreCase("REFRESH_RATE")) {
            lwjgl3ApplicationConfiguration.setIdleFPS(displayMode.refreshRate);
        } else {
            lwjgl3ApplicationConfiguration.setIdleFPS(aj2.int_a(ai.var_ai_a));
        }
        if (aj2.java_lang_String_a(ai.b).equalsIgnoreCase("REFRESH_RATE")) {
            lwjgl3ApplicationConfiguration.setForegroundFPS(displayMode.refreshRate);
        } else {
            lwjgl3ApplicationConfiguration.setForegroundFPS(aj2.int_a(ai.b));
        }
    }
}

