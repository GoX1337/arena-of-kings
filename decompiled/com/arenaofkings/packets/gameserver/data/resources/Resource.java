/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.resources;

public abstract class Resource {
    protected gx resourceType;
    protected double currentValue;
    protected double maxValue;

    public Resource() {
    }

    public Resource(double d2, double d3) {
        this.currentValue = d2;
        this.maxValue = d3;
    }

    public abstract void onTick();

    public void grantValue(double d2) {
        double d3 = this.maxValue - this.currentValue;
        if (d2 >= d3) {
            this.setCurrentValue(this.currentValue + d3);
        } else if (d2 >= 0.0) {
            this.setCurrentValue(this.currentValue + d2);
        } else {
            double d4 = 0.0 - this.currentValue;
            if (d2 >= d4) {
                this.setCurrentValue(this.currentValue + d2);
            } else {
                this.setCurrentValue(this.currentValue + d4);
            }
        }
    }

    public double getCurrentValue() {
        return this.currentValue;
    }

    public double getMaxValue() {
        return this.maxValue;
    }

    public gx getResourceType() {
        return this.resourceType;
    }

    public void setCurrentValue(double d2) {
        this.currentValue = d2;
    }

    public void setMaxValue(double d2) {
        this.maxValue = d2;
    }
}

