/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class DepthShader
extends DefaultShader {
    private static String defaultVertexShader = null;
    private static String defaultFragmentShader = null;
    public final int numBones;
    public final int weights;
    private final FloatAttribute alphaTestAttribute;
    private static final Attributes tmpAttributes = new Attributes();

    public static final String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public static final String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public static String createPrefix(Renderable renderable, Config config) {
        String string = DefaultShader.createPrefix(renderable, config);
        if (!config.depthBufferOnly) {
            string = string + "#define PackedDepthFlag\n";
        }
        return string;
    }

    public DepthShader(Renderable renderable) {
        this(renderable, new Config());
    }

    public DepthShader(Renderable renderable, Config config) {
        this(renderable, config, DepthShader.createPrefix(renderable, config));
    }

    public DepthShader(Renderable renderable, Config config, String string) {
        this(renderable, config, string, config.vertexShader != null ? config.vertexShader : DepthShader.getDefaultVertexShader(), config.fragmentShader != null ? config.fragmentShader : DepthShader.getDefaultFragmentShader());
    }

    public DepthShader(Renderable renderable, Config config, String string, String string2, String string3) {
        this(renderable, config, new ShaderProgram(string + string2, string + string3));
    }

    public DepthShader(Renderable renderable, Config config, ShaderProgram shaderProgram) {
        super(renderable, (DefaultShader.Config)config, shaderProgram);
        Attributes attributes = DepthShader.combineAttributes(renderable);
        if (renderable.bones != null && renderable.bones.length > config.numBones) {
            throw new GdxRuntimeException("too many bones: " + renderable.bones.length + ", max configured: " + config.numBones);
        }
        this.numBones = renderable.bones == null ? 0 : config.numBones;
        int n2 = 0;
        int n3 = renderable.meshPart.mesh.getVertexAttributes().size();
        for (int i2 = 0; i2 < n3; ++i2) {
            VertexAttribute vertexAttribute = renderable.meshPart.mesh.getVertexAttributes().get(i2);
            if (vertexAttribute.usage != 64) continue;
            n2 |= 1 << vertexAttribute.unit;
        }
        this.weights = n2;
        this.alphaTestAttribute = new FloatAttribute(FloatAttribute.AlphaTest, config.defaultAlphaTest);
    }

    @Override
    public void begin(Camera camera, RenderContext renderContext) {
        super.begin(camera, renderContext);
    }

    @Override
    public void end() {
        super.end();
    }

    @Override
    public boolean canRender(Renderable renderable) {
        if (renderable.bones != null && renderable.bones.length > this.numBones) {
            return false;
        }
        Attributes attributes = DepthShader.combineAttributes(renderable);
        if (attributes.has(BlendingAttribute.Type)) {
            if ((this.attributesMask & BlendingAttribute.Type) != BlendingAttribute.Type) {
                return false;
            }
            if (attributes.has(TextureAttribute.Diffuse) != ((this.attributesMask & TextureAttribute.Diffuse) == TextureAttribute.Diffuse)) {
                return false;
            }
        }
        boolean bl2 = (renderable.meshPart.mesh.getVertexAttributes().getMask() & 0x40L) == 64L;
        return bl2 == this.weights > 0;
    }

    @Override
    public void render(Renderable renderable, Attributes attributes) {
        if (attributes.has(BlendingAttribute.Type)) {
            BlendingAttribute blendingAttribute = (BlendingAttribute)attributes.get(BlendingAttribute.Type);
            attributes.remove(BlendingAttribute.Type);
            boolean bl2 = attributes.has(FloatAttribute.AlphaTest);
            if (!bl2) {
                attributes.set((Attribute)this.alphaTestAttribute);
            }
            if (blendingAttribute.opacity >= ((FloatAttribute)attributes.get((long)FloatAttribute.AlphaTest)).value) {
                super.render(renderable, attributes);
            }
            if (!bl2) {
                attributes.remove(FloatAttribute.AlphaTest);
            }
            attributes.set((Attribute)blendingAttribute);
        } else {
            super.render(renderable, attributes);
        }
    }

    private static final Attributes combineAttributes(Renderable renderable) {
        tmpAttributes.clear();
        if (renderable.environment != null) {
            tmpAttributes.set(renderable.environment);
        }
        if (renderable.material != null) {
            tmpAttributes.set(renderable.material);
        }
        return tmpAttributes;
    }

    public static class Config
    extends DefaultShader.Config {
        public boolean depthBufferOnly = false;
        public float defaultAlphaTest = 0.5f;

        public Config() {
            this.defaultCullFace = 1028;
        }

        public Config(String string, String string2) {
            super(string, string2);
        }
    }
}

