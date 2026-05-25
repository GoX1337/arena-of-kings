/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Texture;

public class TextureRegion {
    Texture texture;
    float u;
    float v;
    float u2;
    float v2;
    int regionWidth;
    int regionHeight;

    public TextureRegion() {
    }

    public TextureRegion(Texture texture) {
        if (texture == null) {
            throw new IllegalArgumentException("texture cannot be null.");
        }
        this.texture = texture;
        this.setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public TextureRegion(Texture texture, int n2, int n3) {
        this.texture = texture;
        this.setRegion(0, 0, n2, n3);
    }

    public TextureRegion(Texture texture, int n2, int n3, int n4, int n5) {
        this.texture = texture;
        this.setRegion(n2, n3, n4, n5);
    }

    public TextureRegion(Texture texture, float f2, float f3, float f4, float f5) {
        this.texture = texture;
        this.setRegion(f2, f3, f4, f5);
    }

    public TextureRegion(TextureRegion textureRegion) {
        this.setRegion(textureRegion);
    }

    public TextureRegion(TextureRegion textureRegion, int n2, int n3, int n4, int n5) {
        this.setRegion(textureRegion, n2, n3, n4, n5);
    }

    public void setRegion(Texture texture) {
        this.texture = texture;
        this.setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public void setRegion(int n2, int n3, int n4, int n5) {
        float f2 = 1.0f / (float)this.texture.getWidth();
        float f3 = 1.0f / (float)this.texture.getHeight();
        this.setRegion((float)n2 * f2, (float)n3 * f3, (float)(n2 + n4) * f2, (float)(n3 + n5) * f3);
        this.regionWidth = Math.abs(n4);
        this.regionHeight = Math.abs(n5);
    }

    public void setRegion(float f2, float f3, float f4, float f5) {
        int n2 = this.texture.getWidth();
        int n3 = this.texture.getHeight();
        this.regionWidth = Math.round(Math.abs(f4 - f2) * (float)n2);
        this.regionHeight = Math.round(Math.abs(f5 - f3) * (float)n3);
        if (this.regionWidth == 1 && this.regionHeight == 1) {
            float f6 = 0.25f / (float)n2;
            f2 += f6;
            f4 -= f6;
            float f7 = 0.25f / (float)n3;
            f3 += f7;
            f5 -= f7;
        }
        this.u = f2;
        this.v = f3;
        this.u2 = f4;
        this.v2 = f5;
    }

    public void setRegion(TextureRegion textureRegion) {
        this.texture = textureRegion.texture;
        this.setRegion(textureRegion.u, textureRegion.v, textureRegion.u2, textureRegion.v2);
    }

    public void setRegion(TextureRegion textureRegion, int n2, int n3, int n4, int n5) {
        this.texture = textureRegion.texture;
        this.setRegion(textureRegion.getRegionX() + n2, textureRegion.getRegionY() + n3, n4, n5);
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getU() {
        return this.u;
    }

    public void setU(float f2) {
        this.u = f2;
        this.regionWidth = Math.round(Math.abs(this.u2 - f2) * (float)this.texture.getWidth());
    }

    public float getV() {
        return this.v;
    }

    public void setV(float f2) {
        this.v = f2;
        this.regionHeight = Math.round(Math.abs(this.v2 - f2) * (float)this.texture.getHeight());
    }

    public float getU2() {
        return this.u2;
    }

    public void setU2(float f2) {
        this.u2 = f2;
        this.regionWidth = Math.round(Math.abs(f2 - this.u) * (float)this.texture.getWidth());
    }

    public float getV2() {
        return this.v2;
    }

    public void setV2(float f2) {
        this.v2 = f2;
        this.regionHeight = Math.round(Math.abs(f2 - this.v) * (float)this.texture.getHeight());
    }

    public int getRegionX() {
        return Math.round(this.u * (float)this.texture.getWidth());
    }

    public void setRegionX(int n2) {
        this.setU((float)n2 / (float)this.texture.getWidth());
    }

    public int getRegionY() {
        return Math.round(this.v * (float)this.texture.getHeight());
    }

    public void setRegionY(int n2) {
        this.setV((float)n2 / (float)this.texture.getHeight());
    }

    public int getRegionWidth() {
        return this.regionWidth;
    }

    public void setRegionWidth(int n2) {
        if (this.isFlipX()) {
            this.setU(this.u2 + (float)n2 / (float)this.texture.getWidth());
        } else {
            this.setU2(this.u + (float)n2 / (float)this.texture.getWidth());
        }
    }

    public int getRegionHeight() {
        return this.regionHeight;
    }

    public void setRegionHeight(int n2) {
        if (this.isFlipY()) {
            this.setV(this.v2 + (float)n2 / (float)this.texture.getHeight());
        } else {
            this.setV2(this.v + (float)n2 / (float)this.texture.getHeight());
        }
    }

    public void flip(boolean bl2, boolean bl3) {
        float f2;
        if (bl2) {
            f2 = this.u;
            this.u = this.u2;
            this.u2 = f2;
        }
        if (bl3) {
            f2 = this.v;
            this.v = this.v2;
            this.v2 = f2;
        }
    }

    public boolean isFlipX() {
        return this.u > this.u2;
    }

    public boolean isFlipY() {
        return this.v > this.v2;
    }

    public void scroll(float f2, float f3) {
        float f4;
        if (f2 != 0.0f) {
            f4 = (this.u2 - this.u) * (float)this.texture.getWidth();
            this.u = (this.u + f2) % 1.0f;
            this.u2 = this.u + f4 / (float)this.texture.getWidth();
        }
        if (f3 != 0.0f) {
            f4 = (this.v2 - this.v) * (float)this.texture.getHeight();
            this.v = (this.v + f3) % 1.0f;
            this.v2 = this.v + f4 / (float)this.texture.getHeight();
        }
    }

    public TextureRegion[][] split(int n2, int n3) {
        int n4 = this.getRegionX();
        int n5 = this.getRegionY();
        int n6 = this.regionWidth;
        int n7 = this.regionHeight;
        int n8 = n7 / n3;
        int n9 = n6 / n2;
        int n10 = n4;
        TextureRegion[][] textureRegionArray = new TextureRegion[n8][n9];
        int n11 = 0;
        while (n11 < n8) {
            n4 = n10;
            int n12 = 0;
            while (n12 < n9) {
                textureRegionArray[n11][n12] = new TextureRegion(this.texture, n4, n5, n2, n3);
                ++n12;
                n4 += n2;
            }
            ++n11;
            n5 += n3;
        }
        return textureRegionArray;
    }

    public static TextureRegion[][] split(Texture texture, int n2, int n3) {
        TextureRegion textureRegion = new TextureRegion(texture);
        return textureRegion.split(n2, n3);
    }
}

