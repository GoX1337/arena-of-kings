/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CpuSpriteBatch
extends SpriteBatch {
    private final Matrix4 virtualMatrix = new Matrix4();
    private final Affine2 adjustAffine = new Affine2();
    private boolean adjustNeeded;
    private boolean haveIdentityRealMatrix = true;
    private final Affine2 tmpAffine = new Affine2();

    public CpuSpriteBatch() {
        this(1000);
    }

    public CpuSpriteBatch(int n2) {
        this(n2, null);
    }

    public CpuSpriteBatch(int n2, ShaderProgram shaderProgram) {
        super(n2, shaderProgram);
    }

    public void flushAndSyncTransformMatrix() {
        this.flush();
        if (this.adjustNeeded) {
            this.haveIdentityRealMatrix = CpuSpriteBatch.checkIdt(this.virtualMatrix);
            if (!this.haveIdentityRealMatrix && this.virtualMatrix.det() == 0.0f) {
                throw new GdxRuntimeException("Transform matrix is singular, can't sync");
            }
            this.adjustNeeded = false;
            super.setTransformMatrix(this.virtualMatrix);
        }
    }

    @Override
    public Matrix4 getTransformMatrix() {
        return this.adjustNeeded ? this.virtualMatrix : super.getTransformMatrix();
    }

    @Override
    public void setTransformMatrix(Matrix4 matrix4) {
        Matrix4 matrix42 = super.getTransformMatrix();
        if (CpuSpriteBatch.checkEqual(matrix42, matrix4)) {
            this.adjustNeeded = false;
        } else if (this.isDrawing()) {
            this.virtualMatrix.setAsAffine(matrix4);
            this.adjustNeeded = true;
            if (this.haveIdentityRealMatrix) {
                this.adjustAffine.set(matrix4);
            } else {
                this.tmpAffine.set(matrix4);
                this.adjustAffine.set(matrix42).inv().mul(this.tmpAffine);
            }
        } else {
            matrix42.setAsAffine(matrix4);
            this.haveIdentityRealMatrix = CpuSpriteBatch.checkIdt(matrix42);
        }
    }

    public void setTransformMatrix(Affine2 affine2) {
        Matrix4 matrix4 = super.getTransformMatrix();
        if (CpuSpriteBatch.checkEqual(matrix4, affine2)) {
            this.adjustNeeded = false;
        } else {
            this.virtualMatrix.setAsAffine(affine2);
            if (this.isDrawing()) {
                this.adjustNeeded = true;
                if (this.haveIdentityRealMatrix) {
                    this.adjustAffine.set(affine2);
                } else {
                    this.adjustAffine.set(matrix4).inv().mul(affine2);
                }
            } else {
                matrix4.setAsAffine(affine2);
                this.haveIdentityRealMatrix = CpuSpriteBatch.checkIdt(matrix4);
            }
        }
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, n2, n3, n4, n5, bl2, bl3);
        } else {
            this.drawAdjusted(texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, n2, n3, n4, n5, bl2, bl3);
        }
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5, n2, n3, n4, n5, bl2, bl3);
        } else {
            this.drawAdjusted(texture, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f, n2, n3, n4, n5, bl2, bl3);
        }
    }

    @Override
    public void draw(Texture texture, float f2, float f3, int n2, int n3, int n4, int n5) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, n2, n3, n4, n5);
        } else {
            this.drawAdjusted(texture, f2, f3, 0.0f, 0.0f, n4, n5, 1.0f, 1.0f, 0.0f, n2, n3, n4, n5, false, false);
        }
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5, f6, f7, f8, f9);
        } else {
            this.drawAdjustedUV(texture, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f, f6, f7, f8, f9, false, false);
        }
    }

    @Override
    public void draw(Texture texture, float f2, float f3) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3);
        } else {
            this.drawAdjusted(texture, f2, f3, 0.0f, 0.0f, texture.getWidth(), texture.getHeight(), 1.0f, 1.0f, 0.0f, 0, 1, 1, 0, false, false);
        }
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5) {
        if (!this.adjustNeeded) {
            super.draw(texture, f2, f3, f4, f5);
        } else {
            this.drawAdjusted(texture, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f, 0, 1, 1, 0, false, false);
        }
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3);
        } else {
            this.drawAdjusted(textureRegion, f2, f3, 0.0f, 0.0f, textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), 1.0f, 1.0f, 0.0f);
        }
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, f4, f5);
        } else {
            this.drawAdjusted(textureRegion, f2, f3, 0.0f, 0.0f, f4, f5, 1.0f, 1.0f, 0.0f);
        }
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        } else {
            this.drawAdjusted(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean bl2) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10, bl2);
        } else {
            this.drawAdjusted(textureRegion, f2, f3, f4, f5, f6, f7, f8, f9, f10, bl2);
        }
    }

    @Override
    public void draw(Texture texture, float[] fArray, int n2, int n3) {
        if (n3 % 20 != 0) {
            throw new GdxRuntimeException("invalid vertex count");
        }
        if (!this.adjustNeeded) {
            super.draw(texture, fArray, n2, n3);
        } else {
            this.drawAdjusted(texture, fArray, n2, n3);
        }
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        if (!this.adjustNeeded) {
            super.draw(textureRegion, f2, f3, affine2);
        } else {
            this.drawAdjusted(textureRegion, f2, f3, affine2);
        }
    }

    private void drawAdjusted(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.drawAdjustedUV(textureRegion.texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, textureRegion.u, textureRegion.v2, textureRegion.u2, textureRegion.v, false, false);
    }

    private void drawAdjusted(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        float f11 = 1.0f / (float)texture.getWidth();
        float f12 = 1.0f / (float)texture.getHeight();
        float f13 = (float)n2 * f11;
        float f14 = (float)(n3 + n5) * f12;
        float f15 = (float)(n2 + n4) * f11;
        float f16 = (float)n3 * f12;
        this.drawAdjustedUV(texture, f2, f3, f4, f5, f6, f7, f8, f9, f10, f13, f14, f15, f16, bl2, bl3);
    }

    private void drawAdjustedUV(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, boolean bl2, boolean bl3) {
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.idx == this.vertices.length) {
            super.flush();
        }
        float f24 = f2 + f4;
        float f25 = f3 + f5;
        float f26 = -f4;
        float f27 = -f5;
        float f28 = f6 - f4;
        float f29 = f7 - f5;
        if (f8 != 1.0f || f9 != 1.0f) {
            f26 *= f8;
            f27 *= f9;
            f28 *= f8;
            f29 *= f9;
        }
        float f30 = f26;
        float f31 = f27;
        float f32 = f26;
        float f33 = f29;
        float f34 = f28;
        float f35 = f29;
        float f36 = f28;
        float f37 = f27;
        if (f10 != 0.0f) {
            f23 = MathUtils.cosDeg(f10);
            float f38 = MathUtils.sinDeg(f10);
            f22 = f23 * f30 - f38 * f31;
            f21 = f38 * f30 + f23 * f31;
            f20 = f23 * f32 - f38 * f33;
            f19 = f38 * f32 + f23 * f33;
            f18 = f23 * f34 - f38 * f35;
            f17 = f38 * f34 + f23 * f35;
            f16 = f22 + (f18 - f20);
            f15 = f17 - (f19 - f21);
        } else {
            f22 = f30;
            f21 = f31;
            f20 = f32;
            f19 = f33;
            f18 = f34;
            f17 = f35;
            f16 = f36;
            f15 = f37;
        }
        f22 += f24;
        f21 += f25;
        f20 += f24;
        f19 += f25;
        f18 += f24;
        f17 += f25;
        f16 += f24;
        f15 += f25;
        if (bl2) {
            f23 = f11;
            f11 = f13;
            f13 = f23;
        }
        if (bl3) {
            f23 = f12;
            f12 = f14;
            f14 = f23;
        }
        Affine2 affine2 = this.adjustAffine;
        this.vertices[this.idx + 0] = affine2.m00 * f22 + affine2.m01 * f21 + affine2.m02;
        this.vertices[this.idx + 1] = affine2.m10 * f22 + affine2.m11 * f21 + affine2.m12;
        this.vertices[this.idx + 2] = this.colorPacked;
        this.vertices[this.idx + 3] = f11;
        this.vertices[this.idx + 4] = f12;
        this.vertices[this.idx + 5] = affine2.m00 * f20 + affine2.m01 * f19 + affine2.m02;
        this.vertices[this.idx + 6] = affine2.m10 * f20 + affine2.m11 * f19 + affine2.m12;
        this.vertices[this.idx + 7] = this.colorPacked;
        this.vertices[this.idx + 8] = f11;
        this.vertices[this.idx + 9] = f14;
        this.vertices[this.idx + 10] = affine2.m00 * f18 + affine2.m01 * f17 + affine2.m02;
        this.vertices[this.idx + 11] = affine2.m10 * f18 + affine2.m11 * f17 + affine2.m12;
        this.vertices[this.idx + 12] = this.colorPacked;
        this.vertices[this.idx + 13] = f13;
        this.vertices[this.idx + 14] = f14;
        this.vertices[this.idx + 15] = affine2.m00 * f16 + affine2.m01 * f15 + affine2.m02;
        this.vertices[this.idx + 16] = affine2.m10 * f16 + affine2.m11 * f15 + affine2.m12;
        this.vertices[this.idx + 17] = this.colorPacked;
        this.vertices[this.idx + 18] = f13;
        this.vertices[this.idx + 19] = f12;
        this.idx += 20;
    }

    private void drawAdjusted(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean bl2) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (textureRegion.texture != this.lastTexture) {
            this.switchTexture(textureRegion.texture);
        } else if (this.idx == this.vertices.length) {
            super.flush();
        }
        float f27 = f2 + f4;
        float f28 = f3 + f5;
        float f29 = -f4;
        float f30 = -f5;
        float f31 = f6 - f4;
        float f32 = f7 - f5;
        if (f8 != 1.0f || f9 != 1.0f) {
            f29 *= f8;
            f30 *= f9;
            f31 *= f8;
            f32 *= f9;
        }
        float f33 = f29;
        float f34 = f30;
        float f35 = f29;
        float f36 = f32;
        float f37 = f31;
        float f38 = f32;
        float f39 = f31;
        float f40 = f30;
        if (f10 != 0.0f) {
            f26 = MathUtils.cosDeg(f10);
            f25 = MathUtils.sinDeg(f10);
            f24 = f26 * f33 - f25 * f34;
            f23 = f25 * f33 + f26 * f34;
            f22 = f26 * f35 - f25 * f36;
            f21 = f25 * f35 + f26 * f36;
            f20 = f26 * f37 - f25 * f38;
            f19 = f25 * f37 + f26 * f38;
            f18 = f24 + (f20 - f22);
            f17 = f19 - (f21 - f23);
        } else {
            f24 = f33;
            f23 = f34;
            f22 = f35;
            f21 = f36;
            f20 = f37;
            f19 = f38;
            f18 = f39;
            f17 = f40;
        }
        f24 += f27;
        f23 += f28;
        f22 += f27;
        f21 += f28;
        f20 += f27;
        f19 += f28;
        f18 += f27;
        f17 += f28;
        if (bl2) {
            f26 = textureRegion.u2;
            f25 = textureRegion.v2;
            f16 = textureRegion.u;
            f15 = textureRegion.v2;
            f14 = textureRegion.u;
            f13 = textureRegion.v;
            f12 = textureRegion.u2;
            f11 = textureRegion.v;
        } else {
            f26 = textureRegion.u;
            f25 = textureRegion.v;
            f16 = textureRegion.u2;
            f15 = textureRegion.v;
            f14 = textureRegion.u2;
            f13 = textureRegion.v2;
            f12 = textureRegion.u;
            f11 = textureRegion.v2;
        }
        Affine2 affine2 = this.adjustAffine;
        this.vertices[this.idx + 0] = affine2.m00 * f24 + affine2.m01 * f23 + affine2.m02;
        this.vertices[this.idx + 1] = affine2.m10 * f24 + affine2.m11 * f23 + affine2.m12;
        this.vertices[this.idx + 2] = this.colorPacked;
        this.vertices[this.idx + 3] = f26;
        this.vertices[this.idx + 4] = f25;
        this.vertices[this.idx + 5] = affine2.m00 * f22 + affine2.m01 * f21 + affine2.m02;
        this.vertices[this.idx + 6] = affine2.m10 * f22 + affine2.m11 * f21 + affine2.m12;
        this.vertices[this.idx + 7] = this.colorPacked;
        this.vertices[this.idx + 8] = f16;
        this.vertices[this.idx + 9] = f15;
        this.vertices[this.idx + 10] = affine2.m00 * f20 + affine2.m01 * f19 + affine2.m02;
        this.vertices[this.idx + 11] = affine2.m10 * f20 + affine2.m11 * f19 + affine2.m12;
        this.vertices[this.idx + 12] = this.colorPacked;
        this.vertices[this.idx + 13] = f14;
        this.vertices[this.idx + 14] = f13;
        this.vertices[this.idx + 15] = affine2.m00 * f18 + affine2.m01 * f17 + affine2.m02;
        this.vertices[this.idx + 16] = affine2.m10 * f18 + affine2.m11 * f17 + affine2.m12;
        this.vertices[this.idx + 17] = this.colorPacked;
        this.vertices[this.idx + 18] = f12;
        this.vertices[this.idx + 19] = f11;
        this.idx += 20;
    }

    private void drawAdjusted(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (textureRegion.texture != this.lastTexture) {
            this.switchTexture(textureRegion.texture);
        } else if (this.idx == this.vertices.length) {
            super.flush();
        }
        Affine2 affine22 = affine2;
        float f4 = affine22.m02;
        float f5 = affine22.m12;
        float f6 = affine22.m01 * f3 + affine22.m02;
        float f7 = affine22.m11 * f3 + affine22.m12;
        float f8 = affine22.m00 * f2 + affine22.m01 * f3 + affine22.m02;
        float f9 = affine22.m10 * f2 + affine22.m11 * f3 + affine22.m12;
        float f10 = affine22.m00 * f2 + affine22.m02;
        float f11 = affine22.m10 * f2 + affine22.m12;
        float f12 = textureRegion.u;
        float f13 = textureRegion.v2;
        float f14 = textureRegion.u2;
        float f15 = textureRegion.v;
        affine22 = this.adjustAffine;
        this.vertices[this.idx + 0] = affine22.m00 * f4 + affine22.m01 * f5 + affine22.m02;
        this.vertices[this.idx + 1] = affine22.m10 * f4 + affine22.m11 * f5 + affine22.m12;
        this.vertices[this.idx + 2] = this.colorPacked;
        this.vertices[this.idx + 3] = f12;
        this.vertices[this.idx + 4] = f13;
        this.vertices[this.idx + 5] = affine22.m00 * f6 + affine22.m01 * f7 + affine22.m02;
        this.vertices[this.idx + 6] = affine22.m10 * f6 + affine22.m11 * f7 + affine22.m12;
        this.vertices[this.idx + 7] = this.colorPacked;
        this.vertices[this.idx + 8] = f12;
        this.vertices[this.idx + 9] = f15;
        this.vertices[this.idx + 10] = affine22.m00 * f8 + affine22.m01 * f9 + affine22.m02;
        this.vertices[this.idx + 11] = affine22.m10 * f8 + affine22.m11 * f9 + affine22.m12;
        this.vertices[this.idx + 12] = this.colorPacked;
        this.vertices[this.idx + 13] = f14;
        this.vertices[this.idx + 14] = f15;
        this.vertices[this.idx + 15] = affine22.m00 * f10 + affine22.m01 * f11 + affine22.m02;
        this.vertices[this.idx + 16] = affine22.m10 * f10 + affine22.m11 * f11 + affine22.m12;
        this.vertices[this.idx + 17] = this.colorPacked;
        this.vertices[this.idx + 18] = f14;
        this.vertices[this.idx + 19] = f13;
        this.idx += 20;
    }

    private void drawAdjusted(Texture texture, float[] fArray, int n2, int n3) {
        if (!this.drawing) {
            throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
        }
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        }
        Affine2 affine2 = this.adjustAffine;
        int n4 = Math.min(this.vertices.length - this.idx, n3);
        do {
            n3 -= n4;
            while (n4 > 0) {
                float f2 = fArray[n2];
                float f3 = fArray[n2 + 1];
                this.vertices[this.idx] = affine2.m00 * f2 + affine2.m01 * f3 + affine2.m02;
                this.vertices[this.idx + 1] = affine2.m10 * f2 + affine2.m11 * f3 + affine2.m12;
                this.vertices[this.idx + 2] = fArray[n2 + 2];
                this.vertices[this.idx + 3] = fArray[n2 + 3];
                this.vertices[this.idx + 4] = fArray[n2 + 4];
                this.idx += 5;
                n2 += 5;
                n4 -= 5;
            }
            if (n3 <= 0) continue;
            super.flush();
            n4 = Math.min(this.vertices.length, n3);
        } while (n3 > 0);
    }

    private static boolean checkEqual(Matrix4 matrix4, Matrix4 matrix42) {
        if (matrix4 == matrix42) {
            return true;
        }
        return matrix4.val[0] == matrix42.val[0] && matrix4.val[1] == matrix42.val[1] && matrix4.val[4] == matrix42.val[4] && matrix4.val[5] == matrix42.val[5] && matrix4.val[12] == matrix42.val[12] && matrix4.val[13] == matrix42.val[13];
    }

    private static boolean checkEqual(Matrix4 matrix4, Affine2 affine2) {
        float[] fArray = matrix4.getValues();
        return fArray[0] == affine2.m00 && fArray[1] == affine2.m10 && fArray[4] == affine2.m01 && fArray[5] == affine2.m11 && fArray[12] == affine2.m02 && fArray[13] == affine2.m12;
    }

    private static boolean checkIdt(Matrix4 matrix4) {
        float[] fArray = matrix4.getValues();
        return fArray[0] == 1.0f && fArray[1] == 0.0f && fArray[4] == 0.0f && fArray[5] == 1.0f && fArray[12] == 0.0f && fArray[13] == 0.0f;
    }
}

