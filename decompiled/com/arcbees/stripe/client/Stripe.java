/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Callback
 */
package com.arcbees.stripe.client;

import com.arcbees.stripe.client.BankAccount;
import com.arcbees.stripe.client.BankAccountResponseHandler;
import com.arcbees.stripe.client.CreditCard;
import com.arcbees.stripe.client.CreditCardResponseHandler;
import com.google.gwt.core.client.Callback;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface Stripe {
    public void inject(Callback<Void, Exception> var1);

    public boolean isInjected();

    public void setPublishableKey(String var1);

    public void getCreditCardToken(CreditCard var1, CreditCardResponseHandler var2);

    public void getBankAccountToken(BankAccount var1, BankAccountResponseHandler var2);

    public boolean validateCardNumber(String var1);

    public boolean validateCardExpiry(String var1, String var2);

    public boolean validateCardCvc(String var1);

    public String getCardType(String var1);

    public boolean validateRoutingNumber(String var1, String var2);

    public boolean validateAccountNumber(String var1, String var2);

    public void getCreditCard(String var1, CreditCardResponseHandler var2);

    public void getBankAccount(String var1, BankAccountResponseHandler var2);
}

