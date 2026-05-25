/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.environment.ShadowMap;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Environment
extends Attributes {
    public ShadowMap shadowMap;

    public Environment add(BaseLight ... baseLightArray) {
        for (BaseLight baseLight : baseLightArray) {
            this.add(baseLight);
        }
        return this;
    }

    public Environment add(Array<BaseLight> array) {
        for (BaseLight baseLight : array) {
            this.add(baseLight);
        }
        return this;
    }

    public Environment add(BaseLight baseLight) {
        if (baseLight instanceof DirectionalLight) {
            this.add((DirectionalLight)baseLight);
        } else if (baseLight instanceof PointLight) {
            this.add((PointLight)baseLight);
        } else if (baseLight instanceof SpotLight) {
            this.add((SpotLight)baseLight);
        } else {
            throw new GdxRuntimeException("Unknown light type");
        }
        return this;
    }

    public Environment add(DirectionalLight directionalLight) {
        DirectionalLightsAttribute directionalLightsAttribute = (DirectionalLightsAttribute)this.get(DirectionalLightsAttribute.Type);
        if (directionalLightsAttribute == null) {
            directionalLightsAttribute = new DirectionalLightsAttribute();
            this.set((Attribute)directionalLightsAttribute);
        }
        directionalLightsAttribute.lights.add(directionalLight);
        return this;
    }

    public Environment add(PointLight pointLight) {
        PointLightsAttribute pointLightsAttribute = (PointLightsAttribute)this.get(PointLightsAttribute.Type);
        if (pointLightsAttribute == null) {
            pointLightsAttribute = new PointLightsAttribute();
            this.set((Attribute)pointLightsAttribute);
        }
        pointLightsAttribute.lights.add(pointLight);
        return this;
    }

    public Environment add(SpotLight spotLight) {
        SpotLightsAttribute spotLightsAttribute = (SpotLightsAttribute)this.get(SpotLightsAttribute.Type);
        if (spotLightsAttribute == null) {
            spotLightsAttribute = new SpotLightsAttribute();
            this.set((Attribute)spotLightsAttribute);
        }
        spotLightsAttribute.lights.add(spotLight);
        return this;
    }

    public Environment remove(BaseLight ... baseLightArray) {
        for (BaseLight baseLight : baseLightArray) {
            this.remove(baseLight);
        }
        return this;
    }

    public Environment remove(Array<BaseLight> array) {
        for (BaseLight baseLight : array) {
            this.remove(baseLight);
        }
        return this;
    }

    public Environment remove(BaseLight baseLight) {
        if (baseLight instanceof DirectionalLight) {
            this.remove((DirectionalLight)baseLight);
        } else if (baseLight instanceof PointLight) {
            this.remove((PointLight)baseLight);
        } else if (baseLight instanceof SpotLight) {
            this.remove((SpotLight)baseLight);
        } else {
            throw new GdxRuntimeException("Unknown light type");
        }
        return this;
    }

    public Environment remove(DirectionalLight directionalLight) {
        if (this.has(DirectionalLightsAttribute.Type)) {
            DirectionalLightsAttribute directionalLightsAttribute = (DirectionalLightsAttribute)this.get(DirectionalLightsAttribute.Type);
            directionalLightsAttribute.lights.removeValue(directionalLight, false);
            if (directionalLightsAttribute.lights.size == 0) {
                this.remove(DirectionalLightsAttribute.Type);
            }
        }
        return this;
    }

    public Environment remove(PointLight pointLight) {
        if (this.has(PointLightsAttribute.Type)) {
            PointLightsAttribute pointLightsAttribute = (PointLightsAttribute)this.get(PointLightsAttribute.Type);
            pointLightsAttribute.lights.removeValue(pointLight, false);
            if (pointLightsAttribute.lights.size == 0) {
                this.remove(PointLightsAttribute.Type);
            }
        }
        return this;
    }

    public Environment remove(SpotLight spotLight) {
        if (this.has(SpotLightsAttribute.Type)) {
            SpotLightsAttribute spotLightsAttribute = (SpotLightsAttribute)this.get(SpotLightsAttribute.Type);
            spotLightsAttribute.lights.removeValue(spotLight, false);
            if (spotLightsAttribute.lights.size == 0) {
                this.remove(SpotLightsAttribute.Type);
            }
        }
        return this;
    }
}

