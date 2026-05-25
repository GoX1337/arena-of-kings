/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.utils.Array;

public class Material
extends Attributes {
    private static int counter = 0;
    public String id;

    public Material() {
        this("mtl" + ++counter);
    }

    public Material(String string) {
        this.id = string;
    }

    public Material(Attribute ... attributeArray) {
        this();
        this.set(attributeArray);
    }

    public Material(String string, Attribute ... attributeArray) {
        this(string);
        this.set(attributeArray);
    }

    public Material(Array<Attribute> array) {
        this();
        this.set(array);
    }

    public Material(String string, Array<Attribute> array) {
        this(string);
        this.set(array);
    }

    public Material(Material material) {
        this(material.id, material);
    }

    public Material(String string, Material material) {
        this(string);
        for (Attribute attribute : material) {
            this.set(attribute.copy());
        }
    }

    public Material copy() {
        return new Material(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 3 * this.id.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Material && (object == this || ((Material)object).id.equals(this.id) && super.equals(object));
    }
}

