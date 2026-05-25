/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.protocols;

import java.util.regex.Pattern;
import org.java_websocket.protocols.IProtocol;

public class Protocol
implements IProtocol {
    private static final Pattern patternSpace = Pattern.compile(" ");
    private static final Pattern patternComma = Pattern.compile(",");
    private final String providedProtocol;

    public Protocol(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.providedProtocol = string;
    }

    @Override
    public boolean acceptProvidedProtocol(String string) {
        String[] stringArray;
        if ("".equals(this.providedProtocol)) {
            return true;
        }
        String string2 = patternSpace.matcher(string).replaceAll("");
        for (String string3 : stringArray = patternComma.split(string2)) {
            if (!this.providedProtocol.equals(string3)) continue;
            return true;
        }
        return false;
    }

    @Override
    public String getProvidedProtocol() {
        return this.providedProtocol;
    }

    @Override
    public IProtocol copyInstance() {
        return new Protocol(this.getProvidedProtocol());
    }

    @Override
    public String toString() {
        return this.getProvidedProtocol();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Protocol protocol = (Protocol)object;
        return this.providedProtocol.equals(protocol.providedProtocol);
    }

    public int hashCode() {
        return this.providedProtocol.hashCode();
    }
}

