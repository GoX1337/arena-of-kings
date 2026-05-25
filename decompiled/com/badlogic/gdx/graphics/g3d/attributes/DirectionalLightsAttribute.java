/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;

public class DirectionalLightsAttribute
extends Attribute {
    public static final String Alias = "directionalLights";
    public static final long Type = DirectionalLightsAttribute.register("directionalLights");
    public final Array<DirectionalLight> lights = new Array(1);

    public static final boolean is(long l2) {
        return (l2 & Type) == l2;
    }

    public DirectionalLightsAttribute() {
        super(Type);
    }

    public DirectionalLightsAttribute(DirectionalLightsAttribute directionalLightsAttribute) {
        this();
        this.lights.addAll(directionalLightsAttribute.lights);
    }

    @Override
    public DirectionalLightsAttribute copy() {
        return new DirectionalLightsAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        for (DirectionalLight directionalLight : this.lights) {
            n2 = 1229 * n2 + (directionalLight == null ? 0 : directionalLight.hashCode());
        }
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return this.type < attribute.type ? -1 : 1;
        }
        return 0;
    }
}

