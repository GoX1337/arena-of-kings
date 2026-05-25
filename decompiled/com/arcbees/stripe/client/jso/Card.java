/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 */
package com.arcbees.stripe.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class Card
extends JavaScriptObject {
    protected Card() {
    }

    public final native String getName();

    public final native String getAddressLine1();

    public final native String getAddressLine2();

    public final native String getAddressCity();

    public final native String getAddressState();

    public final native String getAddressZip();

    public final native String getAddressCountry();

    public final native String getCountry();

    public final native int getExpirationMonth();

    public final native int getExpirationYear();

    public final native String getLast4();

    public final native String getFingerprint();

    public final native String getObject();

    public final native String getType();
}

