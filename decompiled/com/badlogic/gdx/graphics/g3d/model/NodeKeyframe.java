/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.model;

public class NodeKeyframe<T> {
    public float keytime;
    public final T value;

    public NodeKeyframe(float f2, T t2) {
        this.keytime = f2;
        this.value = t2;
    }
}

