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
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class SpriteCache
implements Disposable {
    private static final float[] tempVertices = new float[30];
    private final Mesh mesh;
    private boolean drawing;
    private final Matrix4 transformMatrix = new Matrix4();
    private final Matrix4 projectionMatrix = new Matrix4();
    private Array<Cache> caches = new Array();
    private final Matrix4 combinedMatrix = new Matrix4();
    private final ShaderProgram shader;
    private Cache currentCache;
    private final Array<Texture> textures = new Array(8);
    private final IntArray counts = new IntArray(8);
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private float colorPacked = Color.WHITE_FLOAT_BITS;
    private ShaderProgram customShader = null;
    public int renderCalls = 0;
    public int totalRenderCalls = 0;

    public SpriteCache() {
        this(1000, false);
    }

    public SpriteCache(int n2, boolean bl2) {
        this(n2, SpriteCache.createDefaultShader(), bl2);
    }

    public SpriteCache(int n2, ShaderProgram shaderProgram, boolean bl2) {
        this.shader = shaderProgram;
        if (bl2 && n2 > 8191) {
            throw new IllegalArgumentException("Can't have more than 8191 sprites per batch: " + n2);
        }
        this.mesh = new Mesh(true, n2 * (bl2 ? 4 : 6), bl2 ? n2 * 6 : 0, new VertexAttribute(1, 2, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0"));
        this.mesh.setAutoBind(false);
        if (bl2) {
            int n3 = n2 * 6;
            short[] sArray = new short[n3];
            short s2 = 0;
            int n4 = 0;
            while (n4 < n3) {
                sArray[n4 + 0] = s2;
                sArray[n4 + 1] = (short)(s2 + 1);
                sArray[n4 + 2] = (short)(s2 + 2);
                sArray[n4 + 3] = (short)(s2 + 2);
                sArray[n4 + 4] = (short)(s2 + 3);
                sArray[n4 + 5] = s2;
                n4 += 6;
                s2 = (short)(s2 + 4);
            }
            this.mesh.setIndices(sArray);
        }
        this.projectionMatrix.setToOrtho2D(0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void setColor(Color color) {
        this.color.set(color);
        this.colorPacked = color.toFloatBits();
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.colorPacked = this.color.toFloatBits();
    }

    public Color getColor() {
        return this.color;
    }

    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        this.colorPacked = f2;
    }

    public float getPackedColor() {
        return this.colorPacked;
    }

    public void beginCache() {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before beginCache");
        }
        if (this.currentCache != null) {
            throw new IllegalStateException("endCache must be called before begin.");
        }
        int n2 = this.mesh.getNumIndices() > 0 ? 4 : 6;
        this.currentCache = new Cache(this.caches.size, this.mesh.getVerticesBuffer().limit());
        this.caches.add(this.currentCache);
        this.mesh.getVerticesBuffer().compact();
    }

    public void beginCache(int n2) {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before beginCache");
        }
        if (this.currentCache != null) {
            throw new IllegalStateException("endCache must be called before begin.");
        }
        if (n2 == this.caches.size - 1) {
            Cache cache = this.caches.removeIndex(n2);
            ((Buffer)this.mesh.getVerticesBuffer()).limit(cache.offset);
            this.beginCache();
            return;
        }
        this.currentCache = this.caches.get(n2);
        ((Buffer)this.mesh.getVerticesBuffer()).position(this.currentCache.offset);
    }

    public int endCache() {
        if (this.currentCache == null) {
            throw new IllegalStateException("beginCache must be called before endCache.");
        }
        Cache cache = this.currentCache;
        int n2 = this.mesh.getVerticesBuffer().position() - cache.offset;
        if (cache.textures == null) {
            cache.maxCount = n2;
            cache.textureCount = this.textures.size;
            cache.textures = this.textures.toArray(Texture.class);
            cache.counts = new int[cache.textureCount];
            int n3 = this.counts.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                cache.counts[i2] = this.counts.get(i2);
            }
            ((Buffer)this.mesh.getVerticesBuffer()).flip();
        } else {
            int n4;
            if (n2 > cache.maxCount) {
                throw new GdxRuntimeException("If a cache is not the last created, it cannot be redefined with more entries than when it was first created: " + n2 + " (" + cache.maxCount + " max)");
            }
            cache.textureCount = this.textures.size;
            if (cache.textures.length < cache.textureCount) {
                cache.textures = new Texture[cache.textureCount];
            }
            int n5 = cache.textureCount;
            for (n4 = 0; n4 < n5; ++n4) {
                cache.textures[n4] = this.textures.get(n4);
            }
            if (cache.counts.length < cache.textureCount) {
                cache.counts = new int[cache.textureCount];
            }
            n5 = cache.textureCount;
            for (n4 = 0; n4 < n5; ++n4) {
                cache.counts[n4] = this.counts.get(n4);
            }
            FloatBuffer floatBuffer = this.mesh.getVerticesBuffer();
            ((Buffer)floatBuffer).position(0);
            Cache cache2 = this.caches.get(this.caches.size - 1);
            ((Buffer)floatBuffer).limit(cache2.offset + cache2.maxCount);
        }
        this.currentCache = null;
        this.textures.clear();
        this.counts.clear();
        return cache.id;
    }

    public void clear() {
        this.caches.clear();
        ((Buffer)this.mesh.getVerticesBuffer()).clear().flip();
    }

    public void add(Texture texture, float[] fArray, int n2, int n3) {
        if (this.currentCache == null) {
            throw new IllegalStateException("beginCache must be called before add.");
        }
        int n4 = this.mesh.getNumIndices() > 0 ? 4 : 6;
        int n5 = n3 / (n4 * 5) * 6;
        int n6 = this.textures.size - 1;
        if (n6 < 0 || this.textures.get(n6) != texture) {
            this.textures.add(texture);
            this.counts.add(n5);
        } else {
            this.counts.incr(n6, n5);
        }
        this.mesh.getVerticesBuffer().put(fArray, n2, n3);
    }

    public void add(Texture texture, float f2, float f3) {
        float f4 = f2 + (float)texture.getWidth();
        float f5 = f3 + (float)texture.getHeight();
        SpriteCache.tempVertices[0] = f2;
        SpriteCache.tempVertices[1] = f3;
        SpriteCache.tempVertices[2] = this.colorPacked;
        SpriteCache.tempVertices[3] = 0.0f;
        SpriteCache.tempVertices[4] = 1.0f;
        SpriteCache.tempVertices[5] = f2;
        SpriteCache.tempVertices[6] = f5;
        SpriteCache.tempVertices[7] = this.colorPacked;
        SpriteCache.tempVertices[8] = 0.0f;
        SpriteCache.tempVertices[9] = 0.0f;
        SpriteCache.tempVertices[10] = f4;
        SpriteCache.tempVertices[11] = f5;
        SpriteCache.tempVertices[12] = this.colorPacked;
        SpriteCache.tempVertices[13] = 1.0f;
        SpriteCache.tempVertices[14] = 0.0f;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f4;
            SpriteCache.tempVertices[16] = f3;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = 1.0f;
            SpriteCache.tempVertices[19] = 1.0f;
            this.add(texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f4;
            SpriteCache.tempVertices[16] = f5;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = 1.0f;
            SpriteCache.tempVertices[19] = 0.0f;
            SpriteCache.tempVertices[20] = f4;
            SpriteCache.tempVertices[21] = f3;
            SpriteCache.tempVertices[22] = this.colorPacked;
            SpriteCache.tempVertices[23] = 1.0f;
            SpriteCache.tempVertices[24] = 1.0f;
            SpriteCache.tempVertices[25] = f2;
            SpriteCache.tempVertices[26] = f3;
            SpriteCache.tempVertices[27] = this.colorPacked;
            SpriteCache.tempVertices[28] = 0.0f;
            SpriteCache.tempVertices[29] = 1.0f;
            this.add(texture, tempVertices, 0, 30);
        }
    }

    public void add(Texture texture, float f2, float f3, int n2, int n3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f2 + (float)n2;
        float f10 = f3 + (float)n3;
        SpriteCache.tempVertices[0] = f2;
        SpriteCache.tempVertices[1] = f3;
        SpriteCache.tempVertices[2] = f8;
        SpriteCache.tempVertices[3] = f4;
        SpriteCache.tempVertices[4] = f5;
        SpriteCache.tempVertices[5] = f2;
        SpriteCache.tempVertices[6] = f10;
        SpriteCache.tempVertices[7] = f8;
        SpriteCache.tempVertices[8] = f4;
        SpriteCache.tempVertices[9] = f7;
        SpriteCache.tempVertices[10] = f9;
        SpriteCache.tempVertices[11] = f10;
        SpriteCache.tempVertices[12] = f8;
        SpriteCache.tempVertices[13] = f6;
        SpriteCache.tempVertices[14] = f7;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f9;
            SpriteCache.tempVertices[16] = f3;
            SpriteCache.tempVertices[17] = f8;
            SpriteCache.tempVertices[18] = f6;
            SpriteCache.tempVertices[19] = f5;
            this.add(texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f9;
            SpriteCache.tempVertices[16] = f10;
            SpriteCache.tempVertices[17] = f8;
            SpriteCache.tempVertices[18] = f6;
            SpriteCache.tempVertices[19] = f7;
            SpriteCache.tempVertices[20] = f9;
            SpriteCache.tempVertices[21] = f3;
            SpriteCache.tempVertices[22] = f8;
            SpriteCache.tempVertices[23] = f6;
            SpriteCache.tempVertices[24] = f5;
            SpriteCache.tempVertices[25] = f2;
            SpriteCache.tempVertices[26] = f3;
            SpriteCache.tempVertices[27] = f8;
            SpriteCache.tempVertices[28] = f4;
            SpriteCache.tempVertices[29] = f5;
            this.add(texture, tempVertices, 0, 30);
        }
    }

    public void add(Texture texture, float f2, float f3, int n2, int n3, int n4, int n5) {
        float f4 = 1.0f / (float)texture.getWidth();
        float f5 = 1.0f / (float)texture.getHeight();
        float f6 = (float)n2 * f4;
        float f7 = (float)(n3 + n5) * f5;
        float f8 = (float)(n2 + n4) * f4;
        float f9 = (float)n3 * f5;
        float f10 = f2 + (float)n4;
        float f11 = f3 + (float)n5;
        SpriteCache.tempVertices[0] = f2;
        SpriteCache.tempVertices[1] = f3;
        SpriteCache.tempVertices[2] = this.colorPacked;
        SpriteCache.tempVertices[3] = f6;
        SpriteCache.tempVertices[4] = f7;
        SpriteCache.tempVertices[5] = f2;
        SpriteCache.tempVertices[6] = f11;
        SpriteCache.tempVertices[7] = this.colorPacked;
        SpriteCache.tempVertices[8] = f6;
        SpriteCache.tempVertices[9] = f9;
        SpriteCache.tempVertices[10] = f10;
        SpriteCache.tempVertices[11] = f11;
        SpriteCache.tempVertices[12] = this.colorPacked;
        SpriteCache.tempVertices[13] = f8;
        SpriteCache.tempVertices[14] = f9;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f10;
            SpriteCache.tempVertices[16] = f3;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f8;
            SpriteCache.tempVertices[19] = f7;
            this.add(texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f10;
            SpriteCache.tempVertices[16] = f11;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f8;
            SpriteCache.tempVertices[19] = f9;
            SpriteCache.tempVertices[20] = f10;
            SpriteCache.tempVertices[21] = f3;
            SpriteCache.tempVertices[22] = this.colorPacked;
            SpriteCache.tempVertices[23] = f8;
            SpriteCache.tempVertices[24] = f7;
            SpriteCache.tempVertices[25] = f2;
            SpriteCache.tempVertices[26] = f3;
            SpriteCache.tempVertices[27] = this.colorPacked;
            SpriteCache.tempVertices[28] = f6;
            SpriteCache.tempVertices[29] = f7;
            this.add(texture, tempVertices, 0, 30);
        }
    }

    public void add(Texture texture, float f2, float f3, float f4, float f5, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        float f6;
        float f7 = 1.0f / (float)texture.getWidth();
        float f8 = 1.0f / (float)texture.getHeight();
        float f9 = (float)n2 * f7;
        float f10 = (float)(n3 + n5) * f8;
        float f11 = (float)(n2 + n4) * f7;
        float f12 = (float)n3 * f8;
        float f13 = f2 + f4;
        float f14 = f3 + f5;
        if (bl2) {
            f6 = f9;
            f9 = f11;
            f11 = f6;
        }
        if (bl3) {
            f6 = f10;
            f10 = f12;
            f12 = f6;
        }
        SpriteCache.tempVertices[0] = f2;
        SpriteCache.tempVertices[1] = f3;
        SpriteCache.tempVertices[2] = this.colorPacked;
        SpriteCache.tempVertices[3] = f9;
        SpriteCache.tempVertices[4] = f10;
        SpriteCache.tempVertices[5] = f2;
        SpriteCache.tempVertices[6] = f14;
        SpriteCache.tempVertices[7] = this.colorPacked;
        SpriteCache.tempVertices[8] = f9;
        SpriteCache.tempVertices[9] = f12;
        SpriteCache.tempVertices[10] = f13;
        SpriteCache.tempVertices[11] = f14;
        SpriteCache.tempVertices[12] = this.colorPacked;
        SpriteCache.tempVertices[13] = f11;
        SpriteCache.tempVertices[14] = f12;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f13;
            SpriteCache.tempVertices[16] = f3;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f11;
            SpriteCache.tempVertices[19] = f10;
            this.add(texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f13;
            SpriteCache.tempVertices[16] = f14;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f11;
            SpriteCache.tempVertices[19] = f12;
            SpriteCache.tempVertices[20] = f13;
            SpriteCache.tempVertices[21] = f3;
            SpriteCache.tempVertices[22] = this.colorPacked;
            SpriteCache.tempVertices[23] = f11;
            SpriteCache.tempVertices[24] = f10;
            SpriteCache.tempVertices[25] = f2;
            SpriteCache.tempVertices[26] = f3;
            SpriteCache.tempVertices[27] = this.colorPacked;
            SpriteCache.tempVertices[28] = f9;
            SpriteCache.tempVertices[29] = f10;
            this.add(texture, tempVertices, 0, 30);
        }
    }

    public void add(Texture texture, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
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
        f21 = 1.0f / (float)texture.getWidth();
        f20 = 1.0f / (float)texture.getHeight();
        float f36 = (float)n2 * f21;
        float f37 = (float)(n3 + n5) * f20;
        float f38 = (float)(n2 + n4) * f21;
        float f39 = (float)n3 * f20;
        if (bl2) {
            f11 = f36;
            f36 = f38;
            f38 = f11;
        }
        if (bl3) {
            f11 = f37;
            f37 = f39;
            f39 = f11;
        }
        SpriteCache.tempVertices[0] = f19;
        SpriteCache.tempVertices[1] = f18;
        SpriteCache.tempVertices[2] = this.colorPacked;
        SpriteCache.tempVertices[3] = f36;
        SpriteCache.tempVertices[4] = f37;
        SpriteCache.tempVertices[5] = f17;
        SpriteCache.tempVertices[6] = f16;
        SpriteCache.tempVertices[7] = this.colorPacked;
        SpriteCache.tempVertices[8] = f36;
        SpriteCache.tempVertices[9] = f39;
        SpriteCache.tempVertices[10] = f15;
        SpriteCache.tempVertices[11] = f14;
        SpriteCache.tempVertices[12] = this.colorPacked;
        SpriteCache.tempVertices[13] = f38;
        SpriteCache.tempVertices[14] = f39;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f13;
            SpriteCache.tempVertices[16] = f12;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f38;
            SpriteCache.tempVertices[19] = f37;
            this.add(texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f15;
            SpriteCache.tempVertices[16] = f14;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f38;
            SpriteCache.tempVertices[19] = f39;
            SpriteCache.tempVertices[20] = f13;
            SpriteCache.tempVertices[21] = f12;
            SpriteCache.tempVertices[22] = this.colorPacked;
            SpriteCache.tempVertices[23] = f38;
            SpriteCache.tempVertices[24] = f37;
            SpriteCache.tempVertices[25] = f19;
            SpriteCache.tempVertices[26] = f18;
            SpriteCache.tempVertices[27] = this.colorPacked;
            SpriteCache.tempVertices[28] = f36;
            SpriteCache.tempVertices[29] = f37;
            this.add(texture, tempVertices, 0, 30);
        }
    }

    public void add(TextureRegion textureRegion, float f2, float f3) {
        this.add(textureRegion, f2, f3, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public void add(TextureRegion textureRegion, float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float f8 = textureRegion.u;
        float f9 = textureRegion.v2;
        float f10 = textureRegion.u2;
        float f11 = textureRegion.v;
        SpriteCache.tempVertices[0] = f2;
        SpriteCache.tempVertices[1] = f3;
        SpriteCache.tempVertices[2] = this.colorPacked;
        SpriteCache.tempVertices[3] = f8;
        SpriteCache.tempVertices[4] = f9;
        SpriteCache.tempVertices[5] = f2;
        SpriteCache.tempVertices[6] = f7;
        SpriteCache.tempVertices[7] = this.colorPacked;
        SpriteCache.tempVertices[8] = f8;
        SpriteCache.tempVertices[9] = f11;
        SpriteCache.tempVertices[10] = f6;
        SpriteCache.tempVertices[11] = f7;
        SpriteCache.tempVertices[12] = this.colorPacked;
        SpriteCache.tempVertices[13] = f10;
        SpriteCache.tempVertices[14] = f11;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f6;
            SpriteCache.tempVertices[16] = f3;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f10;
            SpriteCache.tempVertices[19] = f9;
            this.add(textureRegion.texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f6;
            SpriteCache.tempVertices[16] = f7;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f10;
            SpriteCache.tempVertices[19] = f11;
            SpriteCache.tempVertices[20] = f6;
            SpriteCache.tempVertices[21] = f3;
            SpriteCache.tempVertices[22] = this.colorPacked;
            SpriteCache.tempVertices[23] = f10;
            SpriteCache.tempVertices[24] = f9;
            SpriteCache.tempVertices[25] = f2;
            SpriteCache.tempVertices[26] = f3;
            SpriteCache.tempVertices[27] = this.colorPacked;
            SpriteCache.tempVertices[28] = f8;
            SpriteCache.tempVertices[29] = f9;
            this.add(textureRegion.texture, tempVertices, 0, 30);
        }
    }

    public void add(TextureRegion textureRegion, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
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
        SpriteCache.tempVertices[0] = f18;
        SpriteCache.tempVertices[1] = f17;
        SpriteCache.tempVertices[2] = this.colorPacked;
        SpriteCache.tempVertices[3] = f20;
        SpriteCache.tempVertices[4] = f19;
        SpriteCache.tempVertices[5] = f16;
        SpriteCache.tempVertices[6] = f15;
        SpriteCache.tempVertices[7] = this.colorPacked;
        SpriteCache.tempVertices[8] = f20;
        SpriteCache.tempVertices[9] = f36;
        SpriteCache.tempVertices[10] = f14;
        SpriteCache.tempVertices[11] = f13;
        SpriteCache.tempVertices[12] = this.colorPacked;
        SpriteCache.tempVertices[13] = f35;
        SpriteCache.tempVertices[14] = f36;
        if (this.mesh.getNumIndices() > 0) {
            SpriteCache.tempVertices[15] = f12;
            SpriteCache.tempVertices[16] = f11;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f35;
            SpriteCache.tempVertices[19] = f19;
            this.add(textureRegion.texture, tempVertices, 0, 20);
        } else {
            SpriteCache.tempVertices[15] = f14;
            SpriteCache.tempVertices[16] = f13;
            SpriteCache.tempVertices[17] = this.colorPacked;
            SpriteCache.tempVertices[18] = f35;
            SpriteCache.tempVertices[19] = f36;
            SpriteCache.tempVertices[20] = f12;
            SpriteCache.tempVertices[21] = f11;
            SpriteCache.tempVertices[22] = this.colorPacked;
            SpriteCache.tempVertices[23] = f35;
            SpriteCache.tempVertices[24] = f19;
            SpriteCache.tempVertices[25] = f18;
            SpriteCache.tempVertices[26] = f17;
            SpriteCache.tempVertices[27] = this.colorPacked;
            SpriteCache.tempVertices[28] = f20;
            SpriteCache.tempVertices[29] = f19;
            this.add(textureRegion.texture, tempVertices, 0, 30);
        }
    }

    public void add(Sprite sprite) {
        if (this.mesh.getNumIndices() > 0) {
            this.add(sprite.getTexture(), sprite.getVertices(), 0, 20);
            return;
        }
        float[] fArray = sprite.getVertices();
        System.arraycopy(fArray, 0, tempVertices, 0, 15);
        System.arraycopy(fArray, 10, tempVertices, 15, 5);
        System.arraycopy(fArray, 15, tempVertices, 20, 5);
        System.arraycopy(fArray, 0, tempVertices, 25, 5);
        this.add(sprite.getTexture(), tempVertices, 0, 30);
    }

    public void begin() {
        if (this.drawing) {
            throw new IllegalStateException("end must be called before begin.");
        }
        if (this.currentCache != null) {
            throw new IllegalStateException("endCache must be called before begin");
        }
        this.renderCalls = 0;
        this.combinedMatrix.set(this.projectionMatrix).mul(this.transformMatrix);
        Gdx.gl20.glDepthMask(false);
        if (this.customShader != null) {
            this.customShader.bind();
            this.customShader.setUniformMatrix("u_proj", this.projectionMatrix);
            this.customShader.setUniformMatrix("u_trans", this.transformMatrix);
            this.customShader.setUniformMatrix("u_projTrans", this.combinedMatrix);
            this.customShader.setUniformi("u_texture", 0);
            this.mesh.bind(this.customShader);
        } else {
            this.shader.bind();
            this.shader.setUniformMatrix("u_projectionViewMatrix", this.combinedMatrix);
            this.shader.setUniformi("u_texture", 0);
            this.mesh.bind(this.shader);
        }
        this.drawing = true;
    }

    public void end() {
        if (!this.drawing) {
            throw new IllegalStateException("begin must be called before end.");
        }
        this.drawing = false;
        GL20 gL20 = Gdx.gl20;
        gL20.glDepthMask(true);
        if (this.customShader != null) {
            this.mesh.unbind(this.customShader);
        } else {
            this.mesh.unbind(this.shader);
        }
    }

    public void draw(int n2) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteCache.begin must be called before draw.");
        }
        Cache cache = this.caches.get(n2);
        int n3 = this.mesh.getNumIndices() > 0 ? 4 : 6;
        int n4 = cache.offset / (n3 * 5) * 6;
        Texture[] textureArray = cache.textures;
        int[] nArray = cache.counts;
        int n5 = cache.textureCount;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = nArray[i2];
            textureArray[i2].bind();
            if (this.customShader != null) {
                this.mesh.render(this.customShader, 4, n4, n6);
            } else {
                this.mesh.render(this.shader, 4, n4, n6);
            }
            n4 += n6;
        }
        this.renderCalls += n5;
        this.totalRenderCalls += n5;
    }

    public void draw(int n2, int n3, int n4) {
        if (!this.drawing) {
            throw new IllegalStateException("SpriteCache.begin must be called before draw.");
        }
        Cache cache = this.caches.get(n2);
        int n5 = this.mesh.getNumIndices() > 0 ? 4 : 6;
        n3 = cache.offset / (n5 * 5) * 6 + n3 * 6;
        n4 *= 6;
        Texture[] textureArray = cache.textures;
        int[] nArray = cache.counts;
        int n6 = cache.textureCount;
        for (int i2 = 0; i2 < n6; ++i2) {
            textureArray[i2].bind();
            int n7 = nArray[i2];
            if (n7 > n4) {
                i2 = n6;
                n7 = n4;
            } else {
                n4 -= n7;
            }
            if (this.customShader != null) {
                this.mesh.render(this.customShader, 4, n3, n7);
            } else {
                this.mesh.render(this.shader, 4, n3, n7);
            }
            n3 += n7;
        }
        this.renderCalls += cache.textureCount;
        this.totalRenderCalls += n6;
    }

    @Override
    public void dispose() {
        this.mesh.dispose();
        if (this.shader != null) {
            this.shader.dispose();
        }
    }

    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public void setProjectionMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            throw new IllegalStateException("Can't set the matrix within begin/end.");
        }
        this.projectionMatrix.set(matrix4);
    }

    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        if (this.drawing) {
            throw new IllegalStateException("Can't set the matrix within begin/end.");
        }
        this.transformMatrix.set(matrix4);
    }

    static ShaderProgram createDefaultShader() {
        String string = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n";
        String string2 = "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}";
        ShaderProgram shaderProgram = new ShaderProgram(string, string2);
        if (!shaderProgram.isCompiled()) {
            throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
        }
        return shaderProgram;
    }

    public void setShader(ShaderProgram shaderProgram) {
        this.customShader = shaderProgram;
    }

    public ShaderProgram getCustomShader() {
        return this.customShader;
    }

    public boolean isDrawing() {
        return this.drawing;
    }

    static class Cache {
        final int id;
        final int offset;
        int maxCount;
        int textureCount;
        Texture[] textures;
        int[] counts;

        public Cache(int n2, int n3) {
            this.id = n2;
            this.offset = n3;
        }
    }
}

