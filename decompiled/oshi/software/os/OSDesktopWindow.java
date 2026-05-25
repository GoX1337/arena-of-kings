/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os;

import java.awt.Rectangle;
import oshi.annotation.concurrent.Immutable;

@Immutable
public class OSDesktopWindow {
    private final long windowId;
    private final String title;
    private final String command;
    private final Rectangle locAndSize;
    private final long owningProcessId;
    private final int order;
    private final boolean visible;

    public OSDesktopWindow(long l2, String string, String string2, Rectangle rectangle, long l3, int n2, boolean bl2) {
        this.windowId = l2;
        this.title = string;
        this.command = string2;
        this.locAndSize = rectangle;
        this.owningProcessId = l3;
        this.order = n2;
        this.visible = bl2;
    }

    public long getWindowId() {
        return this.windowId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCommand() {
        return this.command;
    }

    public Rectangle getLocAndSize() {
        return this.locAndSize;
    }

    public long getOwningProcessId() {
        return this.owningProcessId;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public String toString() {
        return "OSDesktopWindow [windowId=" + this.windowId + ", title=" + this.title + ", command=" + this.command + ", locAndSize=" + this.locAndSize.toString() + ", owningProcessId=" + this.owningProcessId + ", order=" + this.order + ", visible=" + this.visible + "]";
    }
}

