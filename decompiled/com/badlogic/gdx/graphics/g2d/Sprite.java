/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Sprite
extends TextureRegion {
    static final int VERTEX_SIZE = 5;
    static final int SPRITE_SIZE = 20;
    final float[] vertices = new float[20];
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private float x;
    private float y;
    float width;
    float height;
    private float originX;
    private float originY;
    private float rotation;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private boolean dirty = true;
    private Rectangle bounds;

    public Sprite() {
        this.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public Sprite(Texture texture) {
        this(texture, 0, 0, texture.getWidth(), texture.getHeight());
    }

    public Sprite(Texture texture, int n2, int n3) {
        this(texture, 0, 0, n2, n3);
    }

    public Sprite(Texture texture, int n2, int n3, int n4, int n5) {
        if (texture == null) {
            throw new IllegalArgumentException("texture cannot be null.");
        }
        this.texture = texture;
        this.setRegion(n2, n3, n4, n5);
        this.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.setSize(Math.abs(n4), Math.abs(n5));
        this.setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(TextureRegion textureRegion) {
        this.setRegion(textureRegion);
        this.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        this.setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(TextureRegion textureRegion, int n2, int n3, int n4, int n5) {
        this.setRegion(textureRegion, n2, n3, n4, n5);
        this.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.setSize(Math.abs(n4), Math.abs(n5));
        this.setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public Sprite(Sprite sprite) {
        this.set(sprite);
    }

    public void set(Sprite sprite) {
        if (sprite == null) {
            throw new IllegalArgumentException("sprite cannot be null.");
        }
        System.arraycopy(sprite.vertices, 0, this.vertices, 0, 20);
        this.texture = sprite.texture;
        this.u = sprite.u;
        this.v = sprite.v;
        this.u2 = sprite.u2;
        this.v2 = sprite.v2;
        this.x = sprite.x;
        this.y = sprite.y;
        this.width = sprite.width;
        this.height = sprite.height;
        this.regionWidth = sprite.regionWidth;
        this.regionHeight = sprite.regionHeight;
        this.originX = sprite.originX;
        this.originY = sprite.originY;
        this.rotation = sprite.rotation;
        this.scaleX = sprite.scaleX;
        this.scaleY = sprite.scaleY;
        this.color.set(sprite.color);
        this.dirty = sprite.dirty;
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float[] fArray = this.vertices;
        fArray[0] = f2;
        fArray[1] = f3;
        fArray[5] = f2;
        fArray[6] = f7;
        fArray[10] = f6;
        fArray[11] = f7;
        fArray[15] = f6;
        fArray[16] = f3;
    }

    public void setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float f4 = this.x + f2;
        float f5 = this.y + f3;
        float[] fArray = this.vertices;
        fArray[0] = this.x;
        fArray[1] = this.y;
        fArray[5] = this.x;
        fArray[6] = f5;
        fArray[10] = f4;
        fArray[11] = f5;
        fArray[15] = f4;
        fArray[16] = this.y;
    }

    public void setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float f4 = f2 + this.width;
        float f5 = f3 + this.height;
        float[] fArray = this.vertices;
        fArray[0] = f2;
        fArray[1] = f3;
        fArray[5] = f2;
        fArray[6] = f5;
        fArray[10] = f4;
        fArray[11] = f5;
        fArray[15] = f4;
        fArray[16] = f3;
    }

    public void setOriginBasedPosition(float f2, float f3) {
        this.setPosition(f2 - this.originX, f3 - this.originY);
    }

    public void setX(float f2) {
        this.x = f2;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float f3 = f2 + this.width;
        float[] fArray = this.vertices;
        fArray[0] = f2;
        fArray[5] = f2;
        fArray[10] = f3;
        fArray[15] = f3;
    }

    public void setY(float f2) {
        this.y = f2;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float f3 = f2 + this.height;
        float[] fArray = this.vertices;
        fArray[1] = f2;
        fArray[6] = f3;
        fArray[11] = f3;
        fArray[16] = f2;
    }

    public void setCenterX(float f2) {
        this.setX(f2 - this.width / 2.0f);
    }

    public void setCenterY(float f2) {
        this.setY(f2 - this.height / 2.0f);
    }

    public void setCenter(float f2, float f3) {
        this.setPosition(f2 - this.width / 2.0f, f3 - this.height / 2.0f);
    }

    public void translateX(float f2) {
        this.x += f2;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float[] fArray = this.vertices;
        fArray[0] = fArray[0] + f2;
        fArray[5] = fArray[5] + f2;
        fArray[10] = fArray[10] + f2;
        fArray[15] = fArray[15] + f2;
    }

    public void translateY(float f2) {
        this.y += f2;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float[] fArray = this.vertices;
        fArray[1] = fArray[1] + f2;
        fArray[6] = fArray[6] + f2;
        fArray[11] = fArray[11] + f2;
        fArray[16] = fArray[16] + f2;
    }

    public void translate(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        if (this.dirty) {
            return;
        }
        if (this.rotation != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f) {
            this.dirty = true;
            return;
        }
        float[] fArray = this.vertices;
        fArray[0] = fArray[0] + f2;
        fArray[1] = fArray[1] + f3;
        fArray[5] = fArray[5] + f2;
        fArray[6] = fArray[6] + f3;
        fArray[10] = fArray[10] + f2;
        fArray[11] = fArray[11] + f3;
        fArray[15] = fArray[15] + f2;
        fArray[16] = fArray[16] + f3;
    }

    public void setColor(Color color) {
        this.color.set(color);
        float f2 = color.toFloatBits();
        float[] fArray = this.vertices;
        fArray[2] = f2;
        fArray[7] = f2;
        fArray[12] = f2;
        fArray[17] = f2;
    }

    public void setAlpha(float f2) {
        float f3;
        this.color.a = f2;
        this.vertices[2] = f3 = this.color.toFloatBits();
        this.vertices[7] = f3;
        this.vertices[12] = f3;
        this.vertices[17] = f3;
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        float f6 = this.color.toFloatBits();
        float[] fArray = this.vertices;
        fArray[2] = f6;
        fArray[7] = f6;
        fArray[12] = f6;
        fArray[17] = f6;
    }

    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        float[] fArray = this.vertices;
        fArray[2] = f2;
        fArray[7] = f2;
        fArray[12] = f2;
        fArray[17] = f2;
    }

    public void setOrigin(float f2, float f3) {
        this.originX = f2;
        this.originY = f3;
        this.dirty = true;
    }

    public void setOriginCenter() {
        this.originX = this.width / 2.0f;
        this.originY = this.height / 2.0f;
        this.dirty = true;
    }

    public void setRotation(float f2) {
        this.rotation = f2;
        this.dirty = true;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void rotate(float f2) {
        if (f2 == 0.0f) {
            return;
        }
        this.rotation += f2;
        this.dirty = true;
    }

    public void rotate90(boolean bl2) {
        float[] fArray = this.vertices;
        if (bl2) {
            float f2 = fArray[4];
            fArray[4] = fArray[19];
            fArray[19] = fArray[14];
            fArray[14] = fArray[9];
            fArray[9] = f2;
            f2 = fArray[3];
            fArray[3] = fArray[18];
            fArray[18] = fArray[13];
            fArray[13] = fArray[8];
            fArray[8] = f2;
        } else {
            float f3 = fArray[4];
            fArray[4] = fArray[9];
            fArray[9] = fArray[14];
            fArray[14] = fArray[19];
            fArray[19] = f3;
            f3 = fArray[3];
            fArray[3] = fArray[8];
            fArray[8] = fArray[13];
            fArray[13] = fArray[18];
            fArray[18] = f3;
        }
    }

    public void setScale(float f2) {
        this.scaleX = f2;
        this.scaleY = f2;
        this.dirty = true;
    }

    public void setScale(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.dirty = true;
    }

    public void scale(float f2) {
        this.scaleX += f2;
        this.scaleY += f2;
        this.dirty = true;
    }

    public float[] getVertices() {
        if (this.dirty) {
            this.dirty = false;
            float[] fArray = this.vertices;
            float f2 = -this.originX;
            float f3 = -this.originY;
            float f4 = f2 + this.width;
            float f5 = f3 + this.height;
            float f6 = this.x - f2;
            float f7 = this.y - f3;
            if (this.scaleX != 1.0f || this.scaleY != 1.0f) {
                f2 *= this.scaleX;
                f3 *= this.scaleY;
                f4 *= this.scaleX;
                f5 *= this.scaleY;
            }
            if (this.rotation != 0.0f) {
                float f8 = MathUtils.cosDeg(this.rotation);
                float f9 = MathUtils.sinDeg(this.rotation);
                float f10 = f2 * f8;
                float f11 = f2 * f9;
                float f12 = f3 * f8;
                float f13 = f3 * f9;
                float f14 = f4 * f8;
                float f15 = f4 * f9;
                float f16 = f5 * f8;
                float f17 = f5 * f9;
                float f18 = f10 - f13 + f6;
                float f19 = f12 + f11 + f7;
                fArray[0] = f18;
                fArray[1] = f19;
                float f20 = f10 - f17 + f6;
                float f21 = f16 + f11 + f7;
                fArray[5] = f20;
                fArray[6] = f21;
                float f22 = f14 - f17 + f6;
                float f23 = f16 + f15 + f7;
                fArray[10] = f22;
                fArray[11] = f23;
                fArray[15] = f18 + (f22 - f20);
                fArray[16] = f23 - (f21 - f19);
            } else {
                float f24 = f2 + f6;
                float f25 = f3 + f7;
                float f26 = f4 + f6;
                float f27 = f5 + f7;
                fArray[0] = f24;
                fArray[1] = f25;
                fArray[5] = f24;
                fArray[6] = f27;
                fArray[10] = f26;
                fArray[11] = f27;
                fArray[15] = f26;
                fArray[16] = f25;
            }
        }
        return this.vertices;
    }

    public Rectangle getBoundingRectangle() {
        float[] fArray = this.getVertices();
        float f2 = fArray[0];
        float f3 = fArray[1];
        float f4 = fArray[0];
        float f5 = fArray[1];
        f2 = f2 > fArray[5] ? fArray[5] : f2;
        f2 = f2 > fArray[10] ? fArray[10] : f2;
        f2 = f2 > fArray[15] ? fArray[15] : f2;
        f4 = f4 < fArray[5] ? fArray[5] : f4;
        f4 = f4 < fArray[10] ? fArray[10] : f4;
        f4 = f4 < fArray[15] ? fArray[15] : f4;
        f3 = f3 > fArray[6] ? fArray[6] : f3;
        f3 = f3 > fArray[11] ? fArray[11] : f3;
        f3 = f3 > fArray[16] ? fArray[16] : f3;
        f5 = f5 < fArray[6] ? fArray[6] : f5;
        f5 = f5 < fArray[11] ? fArray[11] : f5;
        float f6 = f5 = f5 < fArray[16] ? fArray[16] : f5;
        if (this.bounds == null) {
            this.bounds = new Rectangle();
        }
        this.bounds.x = f2;
        this.bounds.y = f3;
        this.bounds.width = f4 - f2;
        this.bounds.height = f5 - f3;
        return this.bounds;
    }

    public void draw(Batch batch) {
        batch.draw(this.texture, this.getVertices(), 0, 20);
    }

    public void draw(Batch batch, float f2) {
        float f3 = this.getColor().a;
        this.setAlpha(f3 * f2);
        this.draw(batch);
        this.setAlpha(f3);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public void setRegion(float f2, float f3, float f4, float f5) {
        super.setRegion(f2, f3, f4, f5);
        float[] fArray = this.vertices;
        fArray[3] = f2;
        fArray[4] = f5;
        fArray[8] = f2;
        fArray[9] = f3;
        fArray[13] = f4;
        fArray[14] = f3;
        fArray[18] = f4;
        fArray[19] = f5;
    }

    @Override
    public void setU(float f2) {
        super.setU(f2);
        this.vertices[3] = f2;
        this.vertices[8] = f2;
    }

    @Override
    public void setV(float f2) {
        super.setV(f2);
        this.vertices[9] = f2;
        this.vertices[14] = f2;
    }

    @Override
    public void setU2(float f2) {
        super.setU2(f2);
        this.vertices[13] = f2;
        this.vertices[18] = f2;
    }

    @Override
    public void setV2(float f2) {
        super.setV2(f2);
        this.vertices[4] = f2;
        this.vertices[19] = f2;
    }

    public void setFlip(boolean bl2, boolean bl3) {
        boolean bl4 = false;
        boolean bl5 = false;
        if (this.isFlipX() != bl2) {
            bl4 = true;
        }
        if (this.isFlipY() != bl3) {
            bl5 = true;
        }
        this.flip(bl4, bl5);
    }

    @Override
    public void flip(boolean bl2, boolean bl3) {
        float f2;
        super.flip(bl2, bl3);
        float[] fArray = this.vertices;
        if (bl2) {
            f2 = fArray[3];
            fArray[3] = fArray[13];
            fArray[13] = f2;
            f2 = fArray[8];
            fArray[8] = fArray[18];
            fArray[18] = f2;
        }
        if (bl3) {
            f2 = fArray[4];
            fArray[4] = fArray[14];
            fArray[14] = f2;
            f2 = fArray[9];
            fArray[9] = fArray[19];
            fArray[19] = f2;
        }
    }

    @Override
    public void scroll(float f2, float f3) {
        float f4;
        float f5;
        float[] fArray = this.vertices;
        if (f2 != 0.0f) {
            f5 = (fArray[3] + f2) % 1.0f;
            f4 = f5 + this.width / (float)this.texture.getWidth();
            this.u = f5;
            this.u2 = f4;
            fArray[3] = f5;
            fArray[8] = f5;
            fArray[13] = f4;
            fArray[18] = f4;
        }
        if (f3 != 0.0f) {
            f5 = (fArray[9] + f3) % 1.0f;
            f4 = f5 + this.height / (float)this.texture.getHeight();
            this.v = f5;
            this.v2 = f4;
            fArray[4] = f4;
            fArray[9] = f5;
            fArray[14] = f5;
            fArray[19] = f4;
        }
    }
}

