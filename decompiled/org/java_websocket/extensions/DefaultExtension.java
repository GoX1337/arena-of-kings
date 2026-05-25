/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.extensions;

import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.Framedata;

public class DefaultExtension
implements IExtension {
    @Override
    public void decodeFrame(Framedata framedata) {
    }

    @Override
    public void encodeFrame(Framedata framedata) {
    }

    @Override
    public boolean acceptProvidedExtensionAsServer(String string) {
        return true;
    }

    @Override
    public boolean acceptProvidedExtensionAsClient(String string) {
        return true;
    }

    @Override
    public void isFrameValid(Framedata framedata) {
        if (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        }
    }

    @Override
    public String getProvidedExtensionAsClient() {
        return "";
    }

    @Override
    public String getProvidedExtensionAsServer() {
        return "";
    }

    @Override
    public IExtension copyInstance() {
        return new DefaultExtension();
    }

    @Override
    public void reset() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public boolean equals(Object object) {
        return this == object || object != null && this.getClass() == object.getClass();
    }
}

