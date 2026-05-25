/*
 * Decompiled with CFR 0.152.
 */
package com.arcbees.stripe.client;

import com.arcbees.stripe.client.Stripe;
import com.arcbees.stripe.client.StripeImpl;
import com.google.gwt.inject.client.AbstractGinModule;

public class StripeModule
extends AbstractGinModule {
    public void configure() {
        this.bind(Stripe.class).to(StripeImpl.class);
    }
}

