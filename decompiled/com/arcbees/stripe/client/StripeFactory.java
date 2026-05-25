/*
 * Decompiled with CFR 0.152.
 */
package com.arcbees.stripe.client;

import com.arcbees.stripe.client.Stripe;
import com.arcbees.stripe.client.StripeImpl;

public class StripeFactory {
    public static Stripe get() {
        return new StripeImpl();
    }
}

