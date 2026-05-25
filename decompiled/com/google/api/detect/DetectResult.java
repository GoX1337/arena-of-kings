/*
 * Decompiled with CFR 0.152.
 */
package com.google.api.detect;

import com.google.api.translate.Language;

public class DetectResult {
    private Language language;
    private boolean reliable;
    private double confidence;

    public DetectResult(Language language, boolean bl2, double d2) {
        this.language = language;
        this.reliable = bl2;
        this.confidence = d2;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isReliable() {
        return this.reliable;
    }

    public void setReliable(boolean bl2) {
        this.reliable = bl2;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public void setConfidence(double d2) {
        this.confidence = d2;
    }
}

