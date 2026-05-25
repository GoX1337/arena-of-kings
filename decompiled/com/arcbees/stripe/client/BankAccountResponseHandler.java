/*
 * Decompiled with CFR 0.152.
 */
package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.BankAccountResponse;

public interface BankAccountResponseHandler {
    public void onBankAccountReceived(int var1, BankAccountResponse var2);
}

