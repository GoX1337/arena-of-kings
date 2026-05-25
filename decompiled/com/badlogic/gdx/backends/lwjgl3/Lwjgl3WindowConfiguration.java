/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;
import com.badlogic.gdx.graphics.Color;
import java.util.Arrays;

public class Lwjgl3WindowConfiguration {
    int windowX = -1;
    int windowY = -1;
    int windowWidth = 640;
    int windowHeight = 480;
    int windowMinWidth = -1;
    int windowMinHeight = -1;
    int windowMaxWidth = -1;
    int windowMaxHeight = -1;
    boolean windowResizable = true;
    boolean windowDecorated = true;
    boolean windowMaximized = false;
    Lwjgl3Graphics.Lwjgl3Monitor maximizedMonitor;
    boolean autoIconify = true;
    Files.FileType windowIconFileType;
    String[] windowIconPaths;
    Lwjgl3WindowListener windowListener;
    Lwjgl3Graphics.Lwjgl3DisplayMode fullscreenMode;
    String title;
    Color initialBackgroundColor = Color.BLACK;
    boolean initialVisible = true;
    boolean vSyncEnabled = true;

    void setWindowConfiguration(Lwjgl3WindowConfiguration lwjgl3WindowConfiguration) {
        this.windowX = lwjgl3WindowConfiguration.windowX;
        this.windowY = lwjgl3WindowConfiguration.windowY;
        this.windowWidth = lwjgl3WindowConfiguration.windowWidth;
        this.windowHeight = lwjgl3WindowConfiguration.windowHeight;
        this.windowMinWidth = lwjgl3WindowConfiguration.windowMinWidth;
        this.windowMinHeight = lwjgl3WindowConfiguration.windowMinHeight;
        this.windowMaxWidth = lwjgl3WindowConfiguration.windowMaxWidth;
        this.windowMaxHeight = lwjgl3WindowConfiguration.windowMaxHeight;
        this.windowResizable = lwjgl3WindowConfiguration.windowResizable;
        this.windowDecorated = lwjgl3WindowConfiguration.windowDecorated;
        this.windowMaximized = lwjgl3WindowConfiguration.windowMaximized;
        this.maximizedMonitor = lwjgl3WindowConfiguration.maximizedMonitor;
        this.autoIconify = lwjgl3WindowConfiguration.autoIconify;
        this.windowIconFileType = lwjgl3WindowConfiguration.windowIconFileType;
        if (lwjgl3WindowConfiguration.windowIconPaths != null) {
            this.windowIconPaths = Arrays.copyOf(lwjgl3WindowConfiguration.windowIconPaths, lwjgl3WindowConfiguration.windowIconPaths.length);
        }
        this.windowListener = lwjgl3WindowConfiguration.windowListener;
        this.fullscreenMode = lwjgl3WindowConfiguration.fullscreenMode;
        this.title = lwjgl3WindowConfiguration.title;
        this.initialBackgroundColor = lwjgl3WindowConfiguration.initialBackgroundColor;
        this.initialVisible = lwjgl3WindowConfiguration.initialVisible;
        this.vSyncEnabled = lwjgl3WindowConfiguration.vSyncEnabled;
    }

    public void setInitialVisible(boolean bl2) {
        this.initialVisible = bl2;
    }

    public void setWindowedMode(int n2, int n3) {
        this.windowWidth = n2;
        this.windowHeight = n3;
    }

    public void setResizable(boolean bl2) {
        this.windowResizable = bl2;
    }

    public void setDecorated(boolean bl2) {
        this.windowDecorated = bl2;
    }

    public void setMaximized(boolean bl2) {
        this.windowMaximized = bl2;
    }

    public void setMaximizedMonitor(Graphics.Monitor monitor) {
        this.maximizedMonitor = (Lwjgl3Graphics.Lwjgl3Monitor)monitor;
    }

    public void setAutoIconify(boolean bl2) {
        this.autoIconify = bl2;
    }

    public void setWindowPosition(int n2, int n3) {
        this.windowX = n2;
        this.windowY = n3;
    }

    public void setWindowSizeLimits(int n2, int n3, int n4, int n5) {
        this.windowMinWidth = n2;
        this.windowMinHeight = n3;
        this.windowMaxWidth = n4;
        this.windowMaxHeight = n5;
    }

    public void setWindowIcon(String ... stringArray) {
        this.setWindowIcon(Files.FileType.Internal, stringArray);
    }

    public void setWindowIcon(Files.FileType fileType, String ... stringArray) {
        this.windowIconFileType = fileType;
        this.windowIconPaths = stringArray;
    }

    public void setWindowListener(Lwjgl3WindowListener lwjgl3WindowListener) {
        this.windowListener = lwjgl3WindowListener;
    }

    public void setFullscreenMode(Graphics.DisplayMode displayMode) {
        this.fullscreenMode = (Lwjgl3Graphics.Lwjgl3DisplayMode)displayMode;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public void setInitialBackgroundColor(Color color) {
        this.initialBackgroundColor = color;
    }

    public void useVsync(boolean bl2) {
        this.vSyncEnabled = bl2;
    }
}

