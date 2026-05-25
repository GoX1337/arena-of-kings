/*
 * Decompiled with CFR 0.152.
 */
package com.arcbees.stripe.client;

public class CreditCard {
    private final String creditCardNumber;
    private final String cvc;
    private final Integer expirationMonth;
    private final Integer expirationYear;
    private final String name;
    private final String addressLine1;
    private final String addressLine2;
    private final String addressCity;
    private final String addressState;
    private final String addressZip;
    private final String addressCountry;

    public static Builder with() {
        return new Builder();
    }

    private CreditCard(String string, String string2, Integer n2, Integer n3, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        this.creditCardNumber = string;
        this.cvc = string2;
        this.expirationMonth = n2;
        this.expirationYear = n3;
        this.name = string3;
        this.addressLine1 = string4;
        this.addressLine2 = string5;
        this.addressCity = string6;
        this.addressState = string7;
        this.addressZip = string8;
        this.addressCountry = string9;
    }

    public String getAddressCity() {
        return this.addressCity;
    }

    public String getName() {
        return this.name;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public String getAddressState() {
        return this.addressState;
    }

    public String getAddressZip() {
        return this.addressZip;
    }

    public String getAddressCountry() {
        return this.addressCountry;
    }

    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public String getCvc() {
        return this.cvc;
    }

    public Integer getExpirationMonth() {
        return this.expirationMonth;
    }

    public Integer getExpirationYear() {
        return this.expirationYear;
    }

    public static class Builder {
        private String creditCardNumber;
        private String cvc;
        private Integer expirationMonth;
        private Integer expirationYear;
        private String name;
        private String addressLine1;
        private String addressLine2;
        private String addressCity;
        private String addressState;
        private String addressZip;
        private String addressCountry;

        public Builder creditCardNumber(String string) {
            this.creditCardNumber = string;
            return this;
        }

        public Builder cvc(String string) {
            this.cvc = string;
            return this;
        }

        public Builder expirationMonth(Integer n2) {
            this.expirationMonth = n2;
            return this;
        }

        public Builder expirationYear(Integer n2) {
            this.expirationYear = n2;
            return this;
        }

        public Builder name(String string) {
            this.name = string;
            return this;
        }

        public Builder addressLine1(String string) {
            this.addressLine1 = string;
            return this;
        }

        public Builder addressLine2(String string) {
            this.addressLine2 = string;
            return this;
        }

        public Builder addressCity(String string) {
            this.addressCity = string;
            return this;
        }

        public Builder addressState(String string) {
            this.addressState = string;
            return this;
        }

        public Builder addressZip(String string) {
            this.addressZip = string;
            return this;
        }

        public Builder addressCountry(String string) {
            this.addressCountry = string;
            return this;
        }

        public CreditCard build() {
            return new CreditCard(this.creditCardNumber, this.cvc, this.expirationMonth, this.expirationYear, this.name, this.addressLine1, this.addressLine2, this.addressCity, this.addressState, this.addressZip, this.addressCountry);
        }
    }
}

