/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 */
package com.arcbees.stripe.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class BankAccount
extends JavaScriptObject {
    protected BankAccount() {
    }

    public final native String getCountry();

    public final native String getBankName();

    public final native String getLast4();

    public final native boolean getValidated();

    public final native String getFingerprint();

    public final native String getObject();
}

