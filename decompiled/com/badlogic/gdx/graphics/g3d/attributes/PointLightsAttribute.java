/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.utils.Array;

public class PointLightsAttribute
extends Attribute {
    public static final String Alias = "pointLights";
    public static final long Type = PointLightsAttribute.register("pointLights");
    public final Array<PointLight> lights = new Array(1);

    public static final boolean is(long l2) {
        return (l2 & Type) == l2;
    }

    public PointLightsAttribute() {
        super(Type);
    }

    public PointLightsAttribute(PointLightsAttribute pointLightsAttribute) {
        this();
        this.lights.addAll(pointLightsAttribute.lights);
    }

    @Override
    public PointLightsAttribute copy() {
        return new PointLightsAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        for (PointLight pointLight : this.lights) {
            n2 = 1231 * n2 + (pointLight == null ? 0 : pointLight.hashCode());
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

