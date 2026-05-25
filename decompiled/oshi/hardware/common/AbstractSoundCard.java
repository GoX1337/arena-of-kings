/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;

@Immutable
public abstract class AbstractSoundCard
implements SoundCard {
    private String kernelVersion;
    private String name;
    private String codec;

    public AbstractSoundCard(String string, String string2, String string3) {
        this.kernelVersion = string;
        this.name = string2;
        this.codec = string3;
    }

    @Override
    public String getDriverVersion() {
        return this.kernelVersion;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCodec() {
        return this.codec;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SoundCard@");
        stringBuilder.append(Integer.toHexString(this.hashCode()));
        stringBuilder.append(" [name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", kernelVersion=");
        stringBuilder.append(this.kernelVersion);
        stringBuilder.append(", codec=");
        stringBuilder.append(this.codec);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

