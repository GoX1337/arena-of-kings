/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.utils.Array;

public class SpotLightsAttribute
extends Attribute {
    public static final String Alias = "spotLights";
    public static final long Type = SpotLightsAttribute.register("spotLights");
    public final Array<SpotLight> lights = new Array(1);

    public static final boolean is(long l2) {
        return (l2 & Type) == l2;
    }

    public SpotLightsAttribute() {
        super(Type);
    }

    public SpotLightsAttribute(SpotLightsAttribute spotLightsAttribute) {
        this();
        this.lights.addAll(spotLightsAttribute.lights);
    }

    @Override
    public SpotLightsAttribute copy() {
        return new SpotLightsAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        for (SpotLight spotLight : this.lights) {
            n2 = 1237 * n2 + (spotLight == null ? 0 : spotLight.hashCode());
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

