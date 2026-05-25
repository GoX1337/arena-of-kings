/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Callback
 *  com.google.gwt.core.client.ScriptInjector
 */
package com.arcbees.stripe.client;

import com.arcbees.stripe.client.BankAccount;
import com.arcbees.stripe.client.BankAccountResponseHandler;
import com.arcbees.stripe.client.CreditCard;
import com.arcbees.stripe.client.CreditCardResponseHandler;
import com.arcbees.stripe.client.Stripe;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class StripeImpl
implements Stripe {
    private static final String STRIPE_JAVASCRIPT_URL = "https://js.stripe.com/v2/";

    @Override
    public void inject(Callback<Void, Exception> callback) {
        if (!this.isInjected()) {
            ScriptInjector.fromUrl((String)STRIPE_JAVASCRIPT_URL).setWindow(ScriptInjector.TOP_WINDOW).setCallback((Callback)new a(this, callback)).inject();
        }
    }

    @Override
    public void getCreditCardToken(CreditCard creditCard, CreditCardResponseHandler creditCardResponseHandler) {
        this.getCreditCardToken(creditCard.getCreditCardNumber(), creditCard.getCvc(), creditCard.getExpirationMonth(), creditCard.getExpirationYear(), creditCard.getName(), creditCard.getAddressLine1(), creditCard.getAddressLine2(), creditCard.getAddressCity(), creditCard.getAddressState(), creditCard.getAddressZip(), creditCard.getAddressCountry(), creditCardResponseHandler);
    }

    @Override
    public void getBankAccountToken(BankAccount bankAccount, BankAccountResponseHandler bankAccountResponseHandler) {
        this.getBankAccountToken(bankAccount.getCountry(), bankAccount.getRoutingNumber(), bankAccount.getAccountNumber(), bankAccountResponseHandler);
    }

    @Override
    public native boolean validateCardNumber(String var1);

    @Override
    public native boolean validateCardExpiry(String var1, String var2);

    @Override
    public native boolean validateCardCvc(String var1);

    @Override
    public native boolean validateRoutingNumber(String var1, String var2);

    @Override
    public native boolean validateAccountNumber(String var1, String var2);

    @Override
    public native void getCreditCard(String var1, CreditCardResponseHandler var2);

    @Override
    public native void getBankAccount(String var1, BankAccountResponseHandler var2);

    @Override
    public native String getCardType(String var1);

    @Override
    public native boolean isInjected();

    @Override
    public native void setPublishableKey(String var1);

    private native void getCreditCardToken(String var1, String var2, int var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, CreditCardResponseHandler var12);

    private native void getBankAccountToken(String var1, String var2, String var3, BankAccountResponseHandler var4);
}

