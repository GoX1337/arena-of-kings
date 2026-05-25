/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 */
package com.arcbees.stripe.client.jso;

import com.arcbees.stripe.client.jso.BankAccount;
import com.google.gwt.core.client.JavaScriptObject;

public class BankAccountResponse
extends JavaScriptObject {
    protected BankAccountResponse() {
    }

    public final native String getId();

    public final native int getCreated();

    public final native boolean getLiveMode();

    public final native String getType();

    public final native String getObject();

    public final native boolean getUsed();

    public final native BankAccount getBankAccount();
}

