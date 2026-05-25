/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public class StripeCustomerData {
    private String stripe_card_id = "";
    private String stripe_cust_id = "";
    private String brand = "";
    private int last4 = 0;
    private int exp_month = 0;
    private int exp_year = 0;
    private String holder = "";
    private String zip = "";

    public StripeCustomerData() {
    }

    public StripeCustomerData(String string, String string2, String string3, int n2, int n3, int n4, String string4, String string5) {
        this.stripe_card_id = string;
        this.stripe_cust_id = string2;
        this.brand = string3;
        this.last4 = n2;
        this.exp_month = n3;
        this.exp_year = n4;
        this.holder = string4;
        this.zip = string5;
    }
}

