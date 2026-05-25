/*
 * Decompiled with CFR 0.152.
 */
package com.arcbees.stripe.client;

import com.arcbees.stripe.client.jso.CreditCardResponse;

public interface CreditCardResponseHandler {
    public void onCreditCardReceived(int var1, CreditCardResponse var2);
}

