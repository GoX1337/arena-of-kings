/*
 * Decompiled with CFR 0.152.
 */
package com.arcbees.stripe.client;

public class BankAccount {
    private final Builder builder;

    public static Builder with() {
        return new Builder();
    }

    private BankAccount(Builder builder) {
        this.builder = builder;
    }

    public String getCountry() {
        return this.builder.country;
    }

    public String getRoutingNumber() {
        return this.builder.routingNumber;
    }

    public String getAccountNumber() {
        return this.builder.acountNumber;
    }

    public static class Builder {
        private String country;
        private String routingNumber;
        private String acountNumber;

        public Builder country(String string) {
            this.country = string;
            return this;
        }

        public Builder routingNumber(String string) {
            this.routingNumber = string;
            return this;
        }

        public Builder accountNumber(String string) {
            this.acountNumber = string;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }
}

