/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
import org.java_websocket.handshake.HandshakeBuilder;

public class HandshakedataImpl1
implements HandshakeBuilder {
    private byte[] content;
    private TreeMap<String, String> map = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    @Override
    public Iterator<String> iterateHttpFields() {
        return Collections.unmodifiableSet(this.map.keySet()).iterator();
    }

    @Override
    public String getFieldValue(String string) {
        String string2 = this.map.get(string);
        if (string2 == null) {
            return "";
        }
        return string2;
    }

    @Override
    public byte[] getContent() {
        return this.content;
    }

    @Override
    public void setContent(byte[] byArray) {
        this.content = byArray;
    }

    @Override
    public void put(String string, String string2) {
        this.map.put(string, string2);
    }

    @Override
    public boolean hasFieldValue(String string) {
        return this.map.containsKey(string);
    }
}

