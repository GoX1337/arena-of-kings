/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g2d.PolygonBatch;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;

public class PolygonSpriteBatch
implements PolygonBatch {
    private Mesh mesh;
    private final float[] vertices;
    private final short[] triangles;
    private int vertexIndex;
    private int triangleIndex;
    private Texture lastTexture;
    private float invTexWidth = 0.0f;
    private float invTexHeight = 0.0f;
    private boolean drawing;
    private final Matrix4 transformMatrix = new Matrix4();
    private final Matrix4 projectionMatrix = new Matrix4();
    private final Matrix4 combinedMatrix = new Matrix4();
    private boolean blendingDisabled;
    private int blendSrcFunc = 770;
    private int blendDstFunc = 771;
    private int blendSrcFuncAlpha = 770;
    private int blendDstFuncAlpha = 771;
    private final ShaderProgram shader;
    private ShaderProgram customShader;
    private boolean ownsShader;
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    float colorPacked = Color.WHITE_FLOAT_BITS;
    public int renderCalls = 0;
    public int totalRenderCalls = 0;
    public int maxTrianglesInBatch = 0;

    public PolygonSpriteBatch() {
        this(2000, null);
    }

    public PolygonSpriteBatch(int n2) {
        this(n2, n2 * 2, null);
    }

    public PolygonSpriteBatch(int n2, ShaderProgram shaderProgram) {
        this(n2, n2 * 2, shaderProgram);
    }

    public PolygonSpriteBatch(int n2, int n3, ShaderProgram shaderProgram) {
        if (n2 > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Can't have more than 32767 vertices per batch: " + n2);
        }
        Mesh.VertexDataType vertexDataType = Mesh.VertexDataType.VertexArray;
        if (Gdx.gl30 != null) {
            vertexDataType = Mesh.VertexDataType.VertexBufferObjectWithVAO;
        }
        this.mesh = new Mesh(vertexDataType, false, n2, n3 * 3, new VertexAttribute(1, 2, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0"));
        this.vertices = new float[n2 * 5];
        this.triangles = new short[n3 * 3];
        if (shaderProgram == null) {
            this.shader = SpriteBatch.createDefaultShader();
            this.ownsShader = true;
        } else {
            this.shader = shaderProgram;
        }
        this.projectionMatrix.setToOrtho2D(0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void begin() {
        if (this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.end must be called before begin.");
        }
        this.renderCalls = 0;
        Gdx.gl.glDepthMask(false);
        if (this.customShader != null) {
            this.customShader.bind();
        } else {
            this.shader.bind();
        }
        this.setupMatrices();
        this.drawing = true;
    }

    @Override
    public void end() {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before end.");
        }
        if (this.vertexIndex > 0) {
            this.flush();
        }
        this.lastTexture = null;
        this.drawing = false;
        GL20 gL20 = Gdx.gl;
        gL20.glDepthMask(true);
        if (this.isBlendingEnabled()) {
            gL20.glDisable(3042);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color.set(color);
        this.colorPacked = color.toFloatBits();
    }

    @Override
    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.colorPacked = this.color.toFloatBits();
    }

    @Override
    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        this.colorPacked = f2;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public float getPackedColor() {
        return this.colorPacked;
    }

    @Override
    public void draw(PolygonRegion polygonRegion, float f2, float f3) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        short[] sArray2 = polygonRegion.triangles;
        int n2 = sArray2.length;
        float[] fArray = polygonRegion.vertices;
        int n3 = fArray.length;
        Texture texture = polygonRegion.region.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + n2 > sArray.length || this.vertexIndex + n3 * 5 / 2 > this.vertices.length) {
            this.flush();
        }
        int n4 = this.triangleIndex;
        int n5 = this.vertexIndex;
        int n6 = n5 / 5;
        for (int i2 = 0; i2 < n2; ++i2) {
            sArray[n4++] = (short)(sArray2[i2] + n6);
        }
        this.triangleIndex = n4;
        float[] fArray2 = this.vertices;
        float f4 = this.colorPacked;
        float[] fArray3 = polygonRegion.textureCoords;
        for (int i3 = 0; i3 < n3; i3 += 2) {
            fArray2[n5++] = fArray[i3] + f2;
            fArray2[n5++] = fArray[i3 + 1] + f3;
            fArray2[n5++] = f4;
            fArray2[n5++] = fArray3[i3];
            fArray2[n5++] = fArray3[i3 + 1];
        }
        this.vertexIndex = n5;
    }

    @Override
    public void draw(PolygonRegion polygonRegion, float f2, float f3, float f4, float f5) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        short[] sArray2 = polygonRegion.triangles;
        int n2 = sArray2.length;
        float[] fArray = polygonRegion.vertices;
        int n3 = fArray.length;
        TextureRegion textureRegion = polygonRegion.region;
        Texture texture = textureRegion.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + n2 > sArray.length || this.vertexIndex + n3 * 5 / 2 > this.vertices.length) {
            this.flush();
        }
        int n4 = this.triangleIndex;
        int n5 = this.vertexIndex;
        int n6 = n5 / 5;
        int n7 = sArray2.length;
        for (int i2 = 0; i2 < n7; ++i2) {
            sArray[n4++] = (short)(sArray2[i2] + n6);
        }
        this.triangleIndex = n4;
        float[] fArray2 = this.vertices;
        float f6 = this.colorPacked;
        float[] fArray3 = polygonRegion.textureCoords;
        float f7 = f4 / (float)textureRegion.regionWidth;
        float f8 = f5 / (float)textureRegion.regionHeight;
        for (int i3 = 0; i3 < n3; i3 += 2) {
            fArray2[n5++] = fArray[i3] * f7 + f2;
            fArray2[n5++] = fArray[i3 + 1] * f8 + f3;
            fArray2[n5++] = f6;
            fArray2[n5++] = fArray3[i3];
            fArray2[n5++] = fArray3[i3 + 1];
        }
        this.vertexIndex = n5;
    }

    @Override
    public void draw(PolygonRegion polygonRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        short[] sArray2 = polygonRegion.triangles;
        int n2 = sArray2.length;
        float[] fArray = polygonRegion.vertices;
        int n3 = fArray.length;
        TextureRegion textureRegion = polygonRegion.region;
        Texture texture = textureRegion.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + n2 > sArray.length || this.vertexIndex + n3 * 5 / 2 > this.vertices.length) {
            this.flush();
        }
        int n4 = this.triangleIndex;
        int n5 = this.vertexIndex;
        int n6 = n5 / 5;
        for (int i2 = 0; i2 < n2; ++i2) {
            sArray[n4++] = (short)(sArray2[i2] + n6);
        }
        this.triangleIndex = n4;
        float[] fArray2 = this.vertices;
        float f11 = this.colorPacked;
        float[] fArray3 = polygonRegion.textureCoords;
        float f12 = f2 + f4;
        float f13 = f3 + f5;
        float f14 = f6 / (float)textureRegion.regionWidth;
        float f15 = f7 / (float)textureRegion.regionHeight;
        float f16 = MathUtils.cosDeg(f10);
        float f17 = MathUtils.sinDeg(f10);
        for (int i3 = 0; i3 < n3; i3 += 2) {
            float f18 = (fArray[i3] * f14 - f4) * f8;
            float f19 = (fArray[i3 + 1] * f15 - f5) * f9;
            fArray2[n5++] = f16 * f18 - f17 * f19 + f12;
            fArray2[n5++] = f17 * f18 + f16 * f19 + f13;
            fArray2[n5++] = f11;
            fArray2[n5++] = fArray3[i3];
            fArray2[n5++] = fArray3[i3 + 1];
        }
        this.vertexIndex = n5;
    }

    @Override
    public void draw(Texture texture, float[] fArray, int n2, int n3, short[] sArray, int n4, int n5) {
        int n6;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray2 = this.triangles;
        float[] fArray2 = this.vertices;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + n5 > sArray2.length || this.vertexIndex + n3 > fArray2.length) {
            this.flush();
        }
        int n7 = this.triangleIndex;
        int n8 = this.vertexIndex;
        int n9 = n8 / 5;
        int n10 = n6 + n5;
        for (n6 = n4; n6 < n10; ++n6) {
            sArray2[n7++] = (short)(sArray[n6] + n9);
        }
        this.triangleIndex = n7;
        System.arraycopy(fArray, n2, fArray2, n8, n3);
        this.vertexIndex += n3;
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
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
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n6 = this.triangleIndex;
        int n7 = this.vertexIndex / 5;
        sArray[n6++] = (short)n7;
        sArray[n6++] = (short)(n7 + 1);
        sArray[n6++] = (short)(n7 + 2);
        sArray[n6++] = (short)(n7 + 2);
        sArray[n6++] = (short)(n7 + 3);
        sArray[n6++] = (short)n7;
        this.triangleIndex = n6;
        float f22 = f2 + f4;
        float f23 = f3 + f5;
        float f24 = -f4;
        float f25 = -f5;
        float f26 = f6 - f4;
        float f27 = f7 - f5;
        if (f8 != 1.0f || f9 != 1.0f) {
            f24 *= f8;
            f25 *= f9;
            f26 *= f8;
            f27 *= f9;
        }
        float f28 = f24;
        float f29 = f25;
        float f30 = f24;
        float f31 = f27;
        float f32 = f26;
        float f33 = f27;
        float f34 = f26;
        float f35 = f25;
        if (f10 != 0.0f) {
            f21 = MathUtils.cosDeg(f10);
            f20 = MathUtils.sinDeg(f10);
            f19 = f21 * f28 - f20 * f29;
            f18 = f20 * f28 + f21 * f29;
            f17 = f21 * f30 - f20 * f31;
            f16 = f20 * f30 + f21 * f31;
            f15 = f21 * f32 - f20 * f33;
            f14 = f20 * f32 + f21 * f33;
            f13 = f19 + (f15 - f17);
            f12 = f14 - (f16 - f18);
        } else {
            f19 = f28;
            f18 = f29;
            f17 = f30;
            f16 = f31;
            f15 = f32;
            f14 = f33;
            f13 = f34;
            f12 = f35;
        }
        f19 += f22;
        f18 += f23;
        f17 += f22;
        f16 += f23;
        f15 += f22;
        f14 += f23;
        f13 += f22;
        f12 += f23;
        f21 = (float)n2 * this.invTexWidth;
        f20 = (float)(n3 + n5) * this.invTexHeight;
        float f36 = (float)(n2 + n4) * this.invTexWidth;
        float f37 = (float)n3 * this.invTexHeight;
        if (bl2) {
            f11 = f21;
            f21 = f36;
            f36 = f11;
        }
        if (bl3) {
            f11 = f20;
            f20 = f37;
            f37 = f11;
        }
        f11 = this.colorPacked;
        int n8 = this.vertexIndex;
        fArray[n8++] = f19;
        fArray[n8++] = f18;
        fArray[n8++] = f11;
        fArray[n8++] = f21;
        fArray[n8++] = f20;
        fArray[n8++] = f17;
        fArray[n8++] = f16;
        fArray[n8++] = f11;
        fArray[n8++] = f21;
        fArray[n8++] = f37;
        fArray[n8++] = f15;
        fArray[n8++] = f14;
        fArray[n8++] = f11;
        fArray[n8++] = f36;
        fArray[n8++] = f37;
        fArray[n8++] = f13;
        fArray[n8++] = f12;
        fArray[n8++] = f11;
        fArray[n8++] = f36;
        fArray[n8++] = f20;
        this.vertexIndex = n8;
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        float f6;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n6 = this.triangleIndex;
        int n7 = this.vertexIndex / 5;
        sArray[n6++] = (short)n7;
        sArray[n6++] = (short)(n7 + 1);
        sArray[n6++] = (short)(n7 + 2);
        sArray[n6++] = (short)(n7 + 2);
        sArray[n6++] = (short)(n7 + 3);
        sArray[n6++] = (short)n7;
        this.triangleIndex = n6;
        float f7 = (float)n2 * this.invTexWidth;
        float f8 = (float)(n3 + n5) * this.invTexHeight;
        float f9 = (float)(n2 + n4) * this.invTexWidth;
        float f10 = (float)n3 * this.invTexHeight;
        float f11 = f2 + f4;
        float f12 = f3 + f5;
        if (bl2) {
            f6 = f7;
            f7 = f9;
            f9 = f6;
        }
        if (bl3) {
            f6 = f8;
            f8 = f10;
            f10 = f6;
        }
        f6 = this.colorPacked;
        int n8 = this.vertexIndex;
        fArray[n8++] = f2;
        fArray[n8++] = f3;
        fArray[n8++] = f6;
        fArray[n8++] = f7;
        fArray[n8++] = f8;
        fArray[n8++] = f2;
        fArray[n8++] = f12;
        fArray[n8++] = f6;
        fArray[n8++] = f7;
        fArray[n8++] = f10;
        fArray[n8++] = f11;
        fArray[n8++] = f12;
        fArray[n8++] = f6;
        fArray[n8++] = f9;
        fArray[n8++] = f10;
        fArray[n8++] = f11;
        fArray[n8++] = f3;
        fArray[n8++] = f6;
        fArray[n8++] = f9;
        fArray[n8++] = f8;
        this.vertexIndex = n8;
    }

    @Override
    public void draw(Texture texture, float f2, float f3, int n2, int n3, int n4, int n5) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n6 = this.triangleIndex;
        int n7 = this.vertexIndex / 5;
        sArray[n6++] = (short)n7;
        sArray[n6++] = (short)(n7 + 1);
        sArray[n6++] = (short)(n7 + 2);
        sArray[n6++] = (short)(n7 + 2);
        sArray[n6++] = (short)(n7 + 3);
        sArray[n6++] = (short)n7;
        this.triangleIndex = n6;
        float f4 = (float)n2 * this.invTexWidth;
        float f5 = (float)(n3 + n5) * this.invTexHeight;
        float f6 = (float)(n2 + n4) * this.invTexWidth;
        float f7 = (float)n3 * this.invTexHeight;
        float f8 = f2 + (float)n4;
        float f9 = f3 + (float)n5;
        float f10 = this.colorPacked;
        int n8 = this.vertexIndex;
        fArray[n8++] = f2;
        fArray[n8++] = f3;
        fArray[n8++] = f10;
        fArray[n8++] = f4;
        fArray[n8++] = f5;
        fArray[n8++] = f2;
        fArray[n8++] = f9;
        fArray[n8++] = f10;
        fArray[n8++] = f4;
        fArray[n8++] = f7;
        fArray[n8++] = f8;
        fArray[n8++] = f9;
        fArray[n8++] = f10;
        fArray[n8++] = f6;
        fArray[n8++] = f7;
        fArray[n8++] = f8;
        fArray[n8++] = f3;
        fArray[n8++] = f10;
        fArray[n8++] = f6;
        fArray[n8++] = f5;
        this.vertexIndex = n8;
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n2 = this.triangleIndex;
        int n3 = this.vertexIndex / 5;
        sArray[n2++] = (short)n3;
        sArray[n2++] = (short)(n3 + 1);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 3);
        sArray[n2++] = (short)n3;
        this.triangleIndex = n2;
        float f10 = f2 + f4;
        float f11 = f3 + f5;
        float f12 = this.colorPacked;
        int n4 = this.vertexIndex;
        fArray[n4++] = f2;
        fArray[n4++] = f3;
        fArray[n4++] = f12;
        fArray[n4++] = f6;
        fArray[n4++] = f7;
        fArray[n4++] = f2;
        fArray[n4++] = f11;
        fArray[n4++] = f12;
        fArray[n4++] = f6;
        fArray[n4++] = f9;
        fArray[n4++] = f10;
        fArray[n4++] = f11;
        fArray[n4++] = f12;
        fArray[n4++] = f8;
        fArray[n4++] = f9;
        fArray[n4++] = f10;
        fArray[n4++] = f3;
        fArray[n4++] = f12;
        fArray[n4++] = f8;
        fArray[n4++] = f7;
        this.vertexIndex = n4;
    }

    @Override
    public void draw(Texture texture, float f2, float f3) {
        this.draw(texture, f2, f3, (float)texture.getWidth(), (float)texture.getHeight());
    }

    @Override
    public void draw(Texture texture, float f2, float f3, float f4, float f5) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n2 = this.triangleIndex;
        int n3 = this.vertexIndex / 5;
        sArray[n2++] = (short)n3;
        sArray[n2++] = (short)(n3 + 1);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 3);
        sArray[n2++] = (short)n3;
        this.triangleIndex = n2;
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float f8 = 0.0f;
        float f9 = 1.0f;
        float f10 = 1.0f;
        float f11 = 0.0f;
        float f12 = this.colorPacked;
        int n4 = this.vertexIndex;
        fArray[n4++] = f2;
        fArray[n4++] = f3;
        fArray[n4++] = f12;
        fArray[n4++] = 0.0f;
        fArray[n4++] = 1.0f;
        fArray[n4++] = f2;
        fArray[n4++] = f7;
        fArray[n4++] = f12;
        fArray[n4++] = 0.0f;
        fArray[n4++] = 0.0f;
        fArray[n4++] = f6;
        fArray[n4++] = f7;
        fArray[n4++] = f12;
        fArray[n4++] = 1.0f;
        fArray[n4++] = 0.0f;
        fArray[n4++] = f6;
        fArray[n4++] = f3;
        fArray[n4++] = f12;
        fArray[n4++] = 1.0f;
        fArray[n4++] = 1.0f;
        this.vertexIndex = n4;
    }

    @Override
    public void draw(Texture texture, float[] fArray, int n2, int n3) {
        int n4;
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray2 = this.vertices;
        int n5 = n3 / 20 * 6;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
            n4 = Math.min(Math.min(n3, fArray2.length - fArray2.length % 20), sArray.length / 6 * 20);
            n5 = n4 / 20 * 6;
        } else if (this.triangleIndex + n5 > sArray.length || this.vertexIndex + n3 > fArray2.length) {
            this.flush();
            n4 = Math.min(Math.min(n3, fArray2.length - fArray2.length % 20), sArray.length / 6 * 20);
            n5 = n4 / 20 * 6;
        } else {
            n4 = n3;
        }
        int n6 = this.vertexIndex;
        short s2 = (short)(n6 / 5);
        int n7 = this.triangleIndex;
        int n8 = n7 + n5;
        while (n7 < n8) {
            sArray[n7] = s2;
            sArray[n7 + 1] = (short)(s2 + 1);
            sArray[n7 + 2] = (short)(s2 + 2);
            sArray[n7 + 3] = (short)(s2 + 2);
            sArray[n7 + 4] = (short)(s2 + 3);
            sArray[n7 + 5] = s2;
            n7 += 6;
            s2 = (short)(s2 + 4);
        }
        while (true) {
            System.arraycopy(fArray, n2, fArray2, n6, n4);
            this.vertexIndex = n6 + n4;
            this.triangleIndex = n7;
            if ((n3 -= n4) == 0) break;
            n2 += n4;
            this.flush();
            n6 = 0;
            if (n4 <= n3) continue;
            n4 = Math.min(n3, sArray.length / 6 * 20);
            n7 = n4 / 20 * 6;
        }
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3) {
        this.draw(textureRegion, f2, f3, (float)textureRegion.getRegionWidth(), (float)textureRegion.getRegionHeight());
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        Texture texture = textureRegion.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n2 = this.triangleIndex;
        int n3 = this.vertexIndex / 5;
        sArray[n2++] = (short)n3;
        sArray[n2++] = (short)(n3 + 1);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 3);
        sArray[n2++] = (short)n3;
        this.triangleIndex = n2;
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float f8 = textureRegion.u;
        float f9 = textureRegion.v2;
        float f10 = textureRegion.u2;
        float f11 = textureRegion.v;
        float f12 = this.colorPacked;
        int n4 = this.vertexIndex;
        fArray[n4++] = f2;
        fArray[n4++] = f3;
        fArray[n4++] = f12;
        fArray[n4++] = f8;
        fArray[n4++] = f9;
        fArray[n4++] = f2;
        fArray[n4++] = f7;
        fArray[n4++] = f12;
        fArray[n4++] = f8;
        fArray[n4++] = f11;
        fArray[n4++] = f6;
        fArray[n4++] = f7;
        fArray[n4++] = f12;
        fArray[n4++] = f10;
        fArray[n4++] = f11;
        fArray[n4++] = f6;
        fArray[n4++] = f3;
        fArray[n4++] = f12;
        fArray[n4++] = f10;
        fArray[n4++] = f9;
        this.vertexIndex = n4;
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
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
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        Texture texture = textureRegion.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n2 = this.triangleIndex;
        int n3 = this.vertexIndex / 5;
        sArray[n2++] = (short)n3;
        sArray[n2++] = (short)(n3 + 1);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 3);
        sArray[n2++] = (short)n3;
        this.triangleIndex = n2;
        float f21 = f2 + f4;
        float f22 = f3 + f5;
        float f23 = -f4;
        float f24 = -f5;
        float f25 = f6 - f4;
        float f26 = f7 - f5;
        if (f8 != 1.0f || f9 != 1.0f) {
            f23 *= f8;
            f24 *= f9;
            f25 *= f8;
            f26 *= f9;
        }
        float f27 = f23;
        float f28 = f24;
        float f29 = f23;
        float f30 = f26;
        float f31 = f25;
        float f32 = f26;
        float f33 = f25;
        float f34 = f24;
        if (f10 != 0.0f) {
            f20 = MathUtils.cosDeg(f10);
            f19 = MathUtils.sinDeg(f10);
            f18 = f20 * f27 - f19 * f28;
            f17 = f19 * f27 + f20 * f28;
            f16 = f20 * f29 - f19 * f30;
            f15 = f19 * f29 + f20 * f30;
            f14 = f20 * f31 - f19 * f32;
            f13 = f19 * f31 + f20 * f32;
            f12 = f18 + (f14 - f16);
            f11 = f13 - (f15 - f17);
        } else {
            f18 = f27;
            f17 = f28;
            f16 = f29;
            f15 = f30;
            f14 = f31;
            f13 = f32;
            f12 = f33;
            f11 = f34;
        }
        f18 += f21;
        f17 += f22;
        f16 += f21;
        f15 += f22;
        f14 += f21;
        f13 += f22;
        f12 += f21;
        f11 += f22;
        f20 = textureRegion.u;
        f19 = textureRegion.v2;
        float f35 = textureRegion.u2;
        float f36 = textureRegion.v;
        float f37 = this.colorPacked;
        int n4 = this.vertexIndex;
        fArray[n4++] = f18;
        fArray[n4++] = f17;
        fArray[n4++] = f37;
        fArray[n4++] = f20;
        fArray[n4++] = f19;
        fArray[n4++] = f16;
        fArray[n4++] = f15;
        fArray[n4++] = f37;
        fArray[n4++] = f20;
        fArray[n4++] = f36;
        fArray[n4++] = f14;
        fArray[n4++] = f13;
        fArray[n4++] = f37;
        fArray[n4++] = f35;
        fArray[n4++] = f36;
        fArray[n4++] = f12;
        fArray[n4++] = f11;
        fArray[n4++] = f37;
        fArray[n4++] = f35;
        fArray[n4++] = f19;
        this.vertexIndex = n4;
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean bl2) {
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
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        Texture texture = textureRegion.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n2 = this.triangleIndex;
        int n3 = this.vertexIndex / 5;
        sArray[n2++] = (short)n3;
        sArray[n2++] = (short)(n3 + 1);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 3);
        sArray[n2++] = (short)n3;
        this.triangleIndex = n2;
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
        float f41 = this.colorPacked;
        int n4 = this.vertexIndex;
        fArray[n4++] = f24;
        fArray[n4++] = f23;
        fArray[n4++] = f41;
        fArray[n4++] = f26;
        fArray[n4++] = f25;
        fArray[n4++] = f22;
        fArray[n4++] = f21;
        fArray[n4++] = f41;
        fArray[n4++] = f16;
        fArray[n4++] = f15;
        fArray[n4++] = f20;
        fArray[n4++] = f19;
        fArray[n4++] = f41;
        fArray[n4++] = f14;
        fArray[n4++] = f13;
        fArray[n4++] = f18;
        fArray[n4++] = f17;
        fArray[n4++] = f41;
        fArray[n4++] = f12;
        fArray[n4++] = f11;
        this.vertexIndex = n4;
    }

    @Override
    public void draw(TextureRegion textureRegion, float f2, float f3, Affine2 affine2) {
        if (!this.drawing) {
            throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArray = this.triangles;
        float[] fArray = this.vertices;
        Texture texture = textureRegion.texture;
        if (texture != this.lastTexture) {
            this.switchTexture(texture);
        } else if (this.triangleIndex + 6 > sArray.length || this.vertexIndex + 20 > fArray.length) {
            this.flush();
        }
        int n2 = this.triangleIndex;
        int n3 = this.vertexIndex / 5;
        sArray[n2++] = (short)n3;
        sArray[n2++] = (short)(n3 + 1);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 2);
        sArray[n2++] = (short)(n3 + 3);
        sArray[n2++] = (short)n3;
        this.triangleIndex = n2;
        float f4 = affine2.m02;
        float f5 = affine2.m12;
        float f6 = affine2.m01 * f3 + affine2.m02;
        float f7 = affine2.m11 * f3 + affine2.m12;
        float f8 = affine2.m00 * f2 + affine2.m01 * f3 + affine2.m02;
        float f9 = affine2.m10 * f2 + affine2.m11 * f3 + affine2.m12;
        float f10 = affine2.m00 * f2 + affine2.m02;
        float f11 = affine2.m10 * f2 + affine2.m12;
        float f12 = textureRegion.u;
        float f13 = textureRegion.v2;
        float f14 = textureRegion.u2;
        float f15 = textureRegion.v;
        float f16 = this.colorPacked;
        int n4 = this.vertexIndex;
        fArray[n4++] = f4;
        fArray[n4++] = f5;
        fArray[n4++] = f16;
        fArray[n4++] = f12;
        fArray[n4++] = f13;
        fArray[n4++] = f6;
        fArray[n4++] = f7;
        fArray[n4++] = f16;
        fArray[n4++] = f12;
        fArray[n4++] = f15;
        fArray[n4++] = f8;
        fArray[n4++] = f9;
        fArray[n4++] = f16;
        fArray[n4++] = f14;
        fArray[n4++] = f15;
        fArray[n4++] = f10;
        fArray[n4++] = f11;
        fArray[n4++] = f16;
        fArray[n4++] = f14;
        fArray[n4++] = f13;
        this.vertexIndex = n4;
    }

    @Override
    public void flush() {
        if (this.vertexIndex == 0) {
            return;
        }
        ++this.renderCalls;
        ++this.totalRenderCalls;
        int n2 = this.triangleIndex;
        if (n2 > this.maxTrianglesInBatch) {
            this.maxTrianglesInBatch = n2;
        }
        this.lastTexture.bind();
        Mesh mesh = this.mesh;
        mesh.setVertices(this.vertices, 0, this.vertexIndex);
        mesh.setIndices(this.triangles, 0, n2);
        if (this.blendingDisabled) {
            Gdx.gl.glDisable(3042);
        } else {
            Gdx.gl.glEnable(3042);
            if (this.blendSrcFunc != -1) {
                Gdx.gl.glBlendFuncSeparate(this.blendSrcFunc, this.blendDstFunc, this.blendSrcFuncAlpha, this.blendDstFuncAlpha);
            }
        }
        mesh.render(this.customShader != null ? this.customShader : this.shader, 4, 0, n2);
        this.vertexIndex = 0;
        this.triangleIndex = 0;
    }

    @Override
    public void disableBlending() {
        this.flush();
        this.blendingDisabled = true;
    }

    @Override
    public void enableBlending() {
        this.flush();
        this.blendingDisabled = false;
    }

    @Override
    public void setBlendFunction(int n2, int n3) {
        this.setBlendFunctionSeparate(n2, n3, n2, n3);
    }

    @Override
    public void setBlendFunctionSeparate(int n2, int n3, int n4, int n5) {
        if (this.blendSrcFunc == n2 && this.blendDstFunc == n3 && this.blendSrcFuncAlpha == n4 && this.blendDstFuncAlpha == n5) {
            return;
        }
        this.flush();
        this.blendSrcFunc = n2;
        this.blendDstFunc = n3;
        this.blendSrcFuncAlpha = n4;
        this.blendDstFuncAlpha = n5;
    }

    @Override
    public int getBlendSrcFunc() {
        return this.blendSrcFunc;
    }

    @Override
    public int getBlendDstFunc() {
        return this.blendDstFunc;
    }

    @Override
    public int getBlendSrcFuncAlpha() {
        return this.blendSrcFuncAlpha;
    }

    @Override
    public int getBlendDstFuncAlpha() {
        return this.blendDstFuncAlpha;
    }

    @Override
    public void dispose() {
        this.mesh.dispose();
        if (this.ownsShader && this.shader != null) {
            this.shader.dispose();
        }
    }

    @Override
    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    @Override
    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override
    public void setProjectionMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            this.flush();
        }
        this.projectionMatrix.set(matrix4);
        if (this.drawing) {
            this.setupMatrices();
        }
    }

    @Override
    public void setTransformMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            this.flush();
        }
        this.transformMatrix.set(matrix4);
        if (this.drawing) {
            this.setupMatrices();
        }
    }

    protected void setupMatrices() {
        this.combinedMatrix.set(this.projectionMatrix).mul(this.transformMatrix);
        if (this.customShader != null) {
            this.customShader.setUniformMatrix("u_projTrans", this.combinedMatrix);
            this.customShader.setUniformi("u_texture", 0);
        } else {
            this.shader.setUniformMatrix("u_projTrans", this.combinedMatrix);
            this.shader.setUniformi("u_texture", 0);
        }
    }

    private void switchTexture(Texture texture) {
        this.flush();
        this.lastTexture = texture;
        this.invTexWidth = 1.0f / (float)texture.getWidth();
        this.invTexHeight = 1.0f / (float)texture.getHeight();
    }

    @Override
    public void setShader(ShaderProgram shaderProgram) {
        if (this.drawing) {
            this.flush();
        }
        this.customShader = shaderProgram;
        if (this.drawing) {
            if (this.customShader != null) {
                this.customShader.bind();
            } else {
                this.shader.bind();
            }
            this.setupMatrices();
        }
    }

    @Override
    public ShaderProgram getShader() {
        if (this.customShader == null) {
            return this.shader;
        }
        return this.customShader;
    }

    @Override
    public boolean isBlendingEnabled() {
        return !this.blendingDisabled;
    }

    @Override
    public boolean isDrawing() {
        return this.drawing;
    }
}

