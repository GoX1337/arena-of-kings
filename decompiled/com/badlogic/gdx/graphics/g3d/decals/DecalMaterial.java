/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DecalMaterial {
    public static final int NO_BLEND = -1;
    protected TextureRegion textureRegion;
    protected int srcBlendFactor;
    protected int dstBlendFactor;

    public void set() {
        this.textureRegion.getTexture().bind(0);
        if (!this.isOpaque()) {
            Gdx.gl.glBlendFunc(this.srcBlendFactor, this.dstBlendFactor);
        }
    }

    public boolean isOpaque() {
        return this.srcBlendFactor == -1;
    }

    public int getSrcBlendFactor() {
        return this.srcBlendFactor;
    }

    public int getDstBlendFactor() {
        return this.dstBlendFactor;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        DecalMaterial decalMaterial = (DecalMaterial)object;
        return this.dstBlendFactor == decalMaterial.dstBlendFactor && this.srcBlendFactor == decalMaterial.srcBlendFactor && this.textureRegion.getTexture() == decalMaterial.textureRegion.getTexture();
    }

    public int hashCode() {
        int n2 = this.textureRegion.getTexture() != null ? this.textureRegion.getTexture().hashCode() : 0;
        n2 = 31 * n2 + this.srcBlendFactor;
        n2 = 31 * n2 + this.dstBlendFactor;
        return n2;
    }
}

