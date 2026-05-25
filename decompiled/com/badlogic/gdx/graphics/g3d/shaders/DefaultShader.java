/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class DefaultShader
extends BaseShader {
    private static String defaultVertexShader = null;
    private static String defaultFragmentShader = null;
    protected static long implementedFlags = BlendingAttribute.Type | TextureAttribute.Diffuse | ColorAttribute.Diffuse | ColorAttribute.Specular | FloatAttribute.Shininess;
    @Deprecated
    public static int defaultCullFace = 1029;
    @Deprecated
    public static int defaultDepthFunc = 515;
    public final int u_projTrans;
    public final int u_viewTrans;
    public final int u_projViewTrans;
    public final int u_cameraPosition;
    public final int u_cameraDirection;
    public final int u_cameraUp;
    public final int u_cameraNearFar;
    public final int u_time;
    public final int u_worldTrans;
    public final int u_viewWorldTrans;
    public final int u_projViewWorldTrans;
    public final int u_normalMatrix;
    public final int u_bones;
    public final int u_shininess;
    public final int u_opacity;
    public final int u_diffuseColor;
    public final int u_diffuseTexture;
    public final int u_diffuseUVTransform;
    public final int u_specularColor;
    public final int u_specularTexture;
    public final int u_specularUVTransform;
    public final int u_emissiveColor;
    public final int u_emissiveTexture;
    public final int u_emissiveUVTransform;
    public final int u_reflectionColor;
    public final int u_reflectionTexture;
    public final int u_reflectionUVTransform;
    public final int u_normalTexture;
    public final int u_normalUVTransform;
    public final int u_ambientTexture;
    public final int u_ambientUVTransform;
    public final int u_alphaTest;
    protected final int u_ambientCubemap;
    protected final int u_environmentCubemap;
    protected final int u_dirLights0color = this.register(new BaseShader.Uniform("u_dirLights[0].color"));
    protected final int u_dirLights0direction = this.register(new BaseShader.Uniform("u_dirLights[0].direction"));
    protected final int u_dirLights1color = this.register(new BaseShader.Uniform("u_dirLights[1].color"));
    protected final int u_pointLights0color = this.register(new BaseShader.Uniform("u_pointLights[0].color"));
    protected final int u_pointLights0position = this.register(new BaseShader.Uniform("u_pointLights[0].position"));
    protected final int u_pointLights0intensity = this.register(new BaseShader.Uniform("u_pointLights[0].intensity"));
    protected final int u_pointLights1color = this.register(new BaseShader.Uniform("u_pointLights[1].color"));
    protected final int u_spotLights0color = this.register(new BaseShader.Uniform("u_spotLights[0].color"));
    protected final int u_spotLights0position = this.register(new BaseShader.Uniform("u_spotLights[0].position"));
    protected final int u_spotLights0intensity = this.register(new BaseShader.Uniform("u_spotLights[0].intensity"));
    protected final int u_spotLights0direction = this.register(new BaseShader.Uniform("u_spotLights[0].direction"));
    protected final int u_spotLights0cutoffAngle = this.register(new BaseShader.Uniform("u_spotLights[0].cutoffAngle"));
    protected final int u_spotLights0exponent = this.register(new BaseShader.Uniform("u_spotLights[0].exponent"));
    protected final int u_spotLights1color = this.register(new BaseShader.Uniform("u_spotLights[1].color"));
    protected final int u_fogColor = this.register(new BaseShader.Uniform("u_fogColor"));
    protected final int u_shadowMapProjViewTrans = this.register(new BaseShader.Uniform("u_shadowMapProjViewTrans"));
    protected final int u_shadowTexture = this.register(new BaseShader.Uniform("u_shadowTexture"));
    protected final int u_shadowPCFOffset = this.register(new BaseShader.Uniform("u_shadowPCFOffset"));
    protected int dirLightsLoc;
    protected int dirLightsColorOffset;
    protected int dirLightsDirectionOffset;
    protected int dirLightsSize;
    protected int pointLightsLoc;
    protected int pointLightsColorOffset;
    protected int pointLightsPositionOffset;
    protected int pointLightsIntensityOffset;
    protected int pointLightsSize;
    protected int spotLightsLoc;
    protected int spotLightsColorOffset;
    protected int spotLightsPositionOffset;
    protected int spotLightsDirectionOffset;
    protected int spotLightsIntensityOffset;
    protected int spotLightsCutoffAngleOffset;
    protected int spotLightsExponentOffset;
    protected int spotLightsSize;
    protected final boolean lighting;
    protected final boolean environmentCubemap;
    protected final boolean shadowMap;
    protected final AmbientCubemap ambientCubemap = new AmbientCubemap();
    protected final DirectionalLight[] directionalLights;
    protected final PointLight[] pointLights;
    protected final SpotLight[] spotLights;
    private Renderable renderable;
    protected final long attributesMask;
    private final long vertexMask;
    protected final Config config;
    private static final long optionalAttributes = IntAttribute.CullFace | DepthTestAttribute.Type;
    private static final Attributes tmpAttributes = new Attributes();
    private final Matrix3 normalMatrix = new Matrix3();
    private float time;
    private boolean lightsSet;
    private final Vector3 tmpV1 = new Vector3();

    public static String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public static String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public DefaultShader(Renderable renderable) {
        this(renderable, new Config());
    }

    public DefaultShader(Renderable renderable, Config config) {
        this(renderable, config, DefaultShader.createPrefix(renderable, config));
    }

    public DefaultShader(Renderable renderable, Config config, String string) {
        this(renderable, config, string, config.vertexShader != null ? config.vertexShader : DefaultShader.getDefaultVertexShader(), config.fragmentShader != null ? config.fragmentShader : DefaultShader.getDefaultFragmentShader());
    }

    public DefaultShader(Renderable renderable, Config config, String string, String string2, String string3) {
        this(renderable, config, new ShaderProgram(string + string2, string + string3));
    }

    public DefaultShader(Renderable renderable, Config config, ShaderProgram shaderProgram) {
        int n2;
        Attributes attributes = DefaultShader.combineAttributes(renderable);
        this.config = config;
        this.program = shaderProgram;
        this.lighting = renderable.environment != null;
        this.environmentCubemap = attributes.has(CubemapAttribute.EnvironmentMap) || this.lighting && attributes.has(CubemapAttribute.EnvironmentMap);
        this.shadowMap = this.lighting && renderable.environment.shadowMap != null;
        this.renderable = renderable;
        this.attributesMask = attributes.getMask() | optionalAttributes;
        this.vertexMask = renderable.meshPart.mesh.getVertexAttributes().getMaskWithSizePacked();
        this.directionalLights = new DirectionalLight[this.lighting && config.numDirectionalLights > 0 ? config.numDirectionalLights : 0];
        for (n2 = 0; n2 < this.directionalLights.length; ++n2) {
            this.directionalLights[n2] = new DirectionalLight();
        }
        this.pointLights = new PointLight[this.lighting && config.numPointLights > 0 ? config.numPointLights : 0];
        for (n2 = 0; n2 < this.pointLights.length; ++n2) {
            this.pointLights[n2] = new PointLight();
        }
        this.spotLights = new SpotLight[this.lighting && config.numSpotLights > 0 ? config.numSpotLights : 0];
        for (n2 = 0; n2 < this.spotLights.length; ++n2) {
            this.spotLights[n2] = new SpotLight();
        }
        if (!config.ignoreUnimplemented && (implementedFlags & this.attributesMask) != this.attributesMask) {
            throw new GdxRuntimeException("Some attributes not implemented yet (" + this.attributesMask + ")");
        }
        if (renderable.bones != null && renderable.bones.length > config.numBones) {
            throw new GdxRuntimeException("too many bones: " + renderable.bones.length + ", max configured: " + config.numBones);
        }
        this.u_projTrans = this.register(Inputs.projTrans, Setters.projTrans);
        this.u_viewTrans = this.register(Inputs.viewTrans, Setters.viewTrans);
        this.u_projViewTrans = this.register(Inputs.projViewTrans, Setters.projViewTrans);
        this.u_cameraPosition = this.register(Inputs.cameraPosition, Setters.cameraPosition);
        this.u_cameraDirection = this.register(Inputs.cameraDirection, Setters.cameraDirection);
        this.u_cameraUp = this.register(Inputs.cameraUp, Setters.cameraUp);
        this.u_cameraNearFar = this.register(Inputs.cameraNearFar, Setters.cameraNearFar);
        this.u_time = this.register(new BaseShader.Uniform("u_time"));
        this.u_worldTrans = this.register(Inputs.worldTrans, Setters.worldTrans);
        this.u_viewWorldTrans = this.register(Inputs.viewWorldTrans, Setters.viewWorldTrans);
        this.u_projViewWorldTrans = this.register(Inputs.projViewWorldTrans, Setters.projViewWorldTrans);
        this.u_normalMatrix = this.register(Inputs.normalMatrix, Setters.normalMatrix);
        this.u_bones = renderable.bones != null && config.numBones > 0 ? this.register(Inputs.bones, (BaseShader.Setter)new Setters.Bones(config.numBones)) : -1;
        this.u_shininess = this.register(Inputs.shininess, Setters.shininess);
        this.u_opacity = this.register(Inputs.opacity);
        this.u_diffuseColor = this.register(Inputs.diffuseColor, Setters.diffuseColor);
        this.u_diffuseTexture = this.register(Inputs.diffuseTexture, Setters.diffuseTexture);
        this.u_diffuseUVTransform = this.register(Inputs.diffuseUVTransform, Setters.diffuseUVTransform);
        this.u_specularColor = this.register(Inputs.specularColor, Setters.specularColor);
        this.u_specularTexture = this.register(Inputs.specularTexture, Setters.specularTexture);
        this.u_specularUVTransform = this.register(Inputs.specularUVTransform, Setters.specularUVTransform);
        this.u_emissiveColor = this.register(Inputs.emissiveColor, Setters.emissiveColor);
        this.u_emissiveTexture = this.register(Inputs.emissiveTexture, Setters.emissiveTexture);
        this.u_emissiveUVTransform = this.register(Inputs.emissiveUVTransform, Setters.emissiveUVTransform);
        this.u_reflectionColor = this.register(Inputs.reflectionColor, Setters.reflectionColor);
        this.u_reflectionTexture = this.register(Inputs.reflectionTexture, Setters.reflectionTexture);
        this.u_reflectionUVTransform = this.register(Inputs.reflectionUVTransform, Setters.reflectionUVTransform);
        this.u_normalTexture = this.register(Inputs.normalTexture, Setters.normalTexture);
        this.u_normalUVTransform = this.register(Inputs.normalUVTransform, Setters.normalUVTransform);
        this.u_ambientTexture = this.register(Inputs.ambientTexture, Setters.ambientTexture);
        this.u_ambientUVTransform = this.register(Inputs.ambientUVTransform, Setters.ambientUVTransform);
        this.u_alphaTest = this.register(Inputs.alphaTest);
        this.u_ambientCubemap = this.lighting ? this.register(Inputs.ambientCube, (BaseShader.Setter)new Setters.ACubemap(config.numDirectionalLights, config.numPointLights)) : -1;
        this.u_environmentCubemap = this.environmentCubemap ? this.register(Inputs.environmentCubemap, Setters.environmentCubemap) : -1;
    }

    @Override
    public void init() {
        ShaderProgram shaderProgram = this.program;
        this.program = null;
        this.init(shaderProgram, this.renderable);
        this.renderable = null;
        this.dirLightsLoc = this.loc(this.u_dirLights0color);
        this.dirLightsColorOffset = this.loc(this.u_dirLights0color) - this.dirLightsLoc;
        this.dirLightsDirectionOffset = this.loc(this.u_dirLights0direction) - this.dirLightsLoc;
        this.dirLightsSize = this.loc(this.u_dirLights1color) - this.dirLightsLoc;
        if (this.dirLightsSize < 0) {
            this.dirLightsSize = 0;
        }
        this.pointLightsLoc = this.loc(this.u_pointLights0color);
        this.pointLightsColorOffset = this.loc(this.u_pointLights0color) - this.pointLightsLoc;
        this.pointLightsPositionOffset = this.loc(this.u_pointLights0position) - this.pointLightsLoc;
        this.pointLightsIntensityOffset = this.has(this.u_pointLights0intensity) ? this.loc(this.u_pointLights0intensity) - this.pointLightsLoc : -1;
        this.pointLightsSize = this.loc(this.u_pointLights1color) - this.pointLightsLoc;
        if (this.pointLightsSize < 0) {
            this.pointLightsSize = 0;
        }
        this.spotLightsLoc = this.loc(this.u_spotLights0color);
        this.spotLightsColorOffset = this.loc(this.u_spotLights0color) - this.spotLightsLoc;
        this.spotLightsPositionOffset = this.loc(this.u_spotLights0position) - this.spotLightsLoc;
        this.spotLightsDirectionOffset = this.loc(this.u_spotLights0direction) - this.spotLightsLoc;
        this.spotLightsIntensityOffset = this.has(this.u_spotLights0intensity) ? this.loc(this.u_spotLights0intensity) - this.spotLightsLoc : -1;
        this.spotLightsCutoffAngleOffset = this.loc(this.u_spotLights0cutoffAngle) - this.spotLightsLoc;
        this.spotLightsExponentOffset = this.loc(this.u_spotLights0exponent) - this.spotLightsLoc;
        this.spotLightsSize = this.loc(this.u_spotLights1color) - this.spotLightsLoc;
        if (this.spotLightsSize < 0) {
            this.spotLightsSize = 0;
        }
    }

    private static final boolean and(long l2, long l3) {
        return (l2 & l3) == l3;
    }

    private static final boolean or(long l2, long l3) {
        return (l2 & l3) != 0L;
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

    private static final long combineAttributeMasks(Renderable renderable) {
        long l2 = 0L;
        if (renderable.environment != null) {
            l2 |= renderable.environment.getMask();
        }
        if (renderable.material != null) {
            l2 |= renderable.material.getMask();
        }
        return l2;
    }

    public static String createPrefix(Renderable renderable, Config config) {
        Attributes attributes = DefaultShader.combineAttributes(renderable);
        String string = "";
        long l2 = attributes.getMask();
        long l3 = renderable.meshPart.mesh.getVertexAttributes().getMask();
        if (DefaultShader.and(l3, 1L)) {
            string = string + "#define positionFlag\n";
        }
        if (DefaultShader.or(l3, 6L)) {
            string = string + "#define colorFlag\n";
        }
        if (DefaultShader.and(l3, 256L)) {
            string = string + "#define binormalFlag\n";
        }
        if (DefaultShader.and(l3, 128L)) {
            string = string + "#define tangentFlag\n";
        }
        if (DefaultShader.and(l3, 8L)) {
            string = string + "#define normalFlag\n";
        }
        if ((DefaultShader.and(l3, 8L) || DefaultShader.and(l3, 384L)) && renderable.environment != null) {
            string = string + "#define lightingFlag\n";
            string = string + "#define ambientCubemapFlag\n";
            string = string + "#define numDirectionalLights " + config.numDirectionalLights + "\n";
            string = string + "#define numPointLights " + config.numPointLights + "\n";
            string = string + "#define numSpotLights " + config.numSpotLights + "\n";
            if (attributes.has(ColorAttribute.Fog)) {
                string = string + "#define fogFlag\n";
            }
            if (renderable.environment.shadowMap != null) {
                string = string + "#define shadowMapFlag\n";
            }
            if (attributes.has(CubemapAttribute.EnvironmentMap)) {
                string = string + "#define environmentCubemapFlag\n";
            }
        }
        int n2 = renderable.meshPart.mesh.getVertexAttributes().size();
        for (int i2 = 0; i2 < n2; ++i2) {
            VertexAttribute vertexAttribute = renderable.meshPart.mesh.getVertexAttributes().get(i2);
            if (vertexAttribute.usage == 64) {
                string = string + "#define boneWeight" + vertexAttribute.unit + "Flag\n";
                continue;
            }
            if (vertexAttribute.usage != 16) continue;
            string = string + "#define texCoord" + vertexAttribute.unit + "Flag\n";
        }
        if ((l2 & BlendingAttribute.Type) == BlendingAttribute.Type) {
            string = string + "#define blendedFlag\n";
        }
        if ((l2 & TextureAttribute.Diffuse) == TextureAttribute.Diffuse) {
            string = string + "#define diffuseTextureFlag\n";
            string = string + "#define diffuseTextureCoord texCoord0\n";
        }
        if ((l2 & TextureAttribute.Specular) == TextureAttribute.Specular) {
            string = string + "#define specularTextureFlag\n";
            string = string + "#define specularTextureCoord texCoord0\n";
        }
        if ((l2 & TextureAttribute.Normal) == TextureAttribute.Normal) {
            string = string + "#define normalTextureFlag\n";
            string = string + "#define normalTextureCoord texCoord0\n";
        }
        if ((l2 & TextureAttribute.Emissive) == TextureAttribute.Emissive) {
            string = string + "#define emissiveTextureFlag\n";
            string = string + "#define emissiveTextureCoord texCoord0\n";
        }
        if ((l2 & TextureAttribute.Reflection) == TextureAttribute.Reflection) {
            string = string + "#define reflectionTextureFlag\n";
            string = string + "#define reflectionTextureCoord texCoord0\n";
        }
        if ((l2 & TextureAttribute.Ambient) == TextureAttribute.Ambient) {
            string = string + "#define ambientTextureFlag\n";
            string = string + "#define ambientTextureCoord texCoord0\n";
        }
        if ((l2 & ColorAttribute.Diffuse) == ColorAttribute.Diffuse) {
            string = string + "#define diffuseColorFlag\n";
        }
        if ((l2 & ColorAttribute.Specular) == ColorAttribute.Specular) {
            string = string + "#define specularColorFlag\n";
        }
        if ((l2 & ColorAttribute.Emissive) == ColorAttribute.Emissive) {
            string = string + "#define emissiveColorFlag\n";
        }
        if ((l2 & ColorAttribute.Reflection) == ColorAttribute.Reflection) {
            string = string + "#define reflectionColorFlag\n";
        }
        if ((l2 & FloatAttribute.Shininess) == FloatAttribute.Shininess) {
            string = string + "#define shininessFlag\n";
        }
        if ((l2 & FloatAttribute.AlphaTest) == FloatAttribute.AlphaTest) {
            string = string + "#define alphaTestFlag\n";
        }
        if (renderable.bones != null && config.numBones > 0) {
            string = string + "#define numBones " + config.numBones + "\n";
        }
        return string;
    }

    @Override
    public boolean canRender(Renderable renderable) {
        if (renderable.bones != null && renderable.bones.length > this.config.numBones) {
            return false;
        }
        long l2 = DefaultShader.combineAttributeMasks(renderable);
        return this.attributesMask == (l2 | optionalAttributes) && this.vertexMask == renderable.meshPart.mesh.getVertexAttributes().getMaskWithSizePacked() && renderable.environment != null == this.lighting;
    }

    @Override
    public int compareTo(Shader shader) {
        if (shader == null) {
            return -1;
        }
        if (shader == this) {
            return 0;
        }
        return 0;
    }

    public boolean equals(Object object) {
        return object instanceof DefaultShader && this.equals((DefaultShader)object);
    }

    public boolean equals(DefaultShader defaultShader) {
        return defaultShader == this;
    }

    @Override
    public void begin(Camera camera, RenderContext renderContext) {
        super.begin(camera, renderContext);
        for (DirectionalLight baseLight : this.directionalLights) {
            baseLight.set(0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f);
        }
        for (BaseLight baseLight : this.pointLights) {
            ((PointLight)baseLight).set(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        for (BaseLight baseLight : this.spotLights) {
            ((SpotLight)baseLight).set(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        }
        this.lightsSet = false;
        if (this.has(this.u_time)) {
            this.set(this.u_time, this.time += Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void render(Renderable renderable, Attributes attributes) {
        if (!attributes.has(BlendingAttribute.Type)) {
            this.context.setBlending(false, 770, 771);
        }
        this.bindMaterial(attributes);
        if (this.lighting) {
            this.bindLights(renderable, attributes);
        }
        super.render(renderable, attributes);
    }

    @Override
    public void end() {
        super.end();
    }

    protected void bindMaterial(Attributes attributes) {
        int n2 = this.config.defaultCullFace == -1 ? defaultCullFace : this.config.defaultCullFace;
        int n3 = this.config.defaultDepthFunc == -1 ? defaultDepthFunc : this.config.defaultDepthFunc;
        float f2 = 0.0f;
        float f3 = 1.0f;
        boolean bl2 = true;
        for (Attribute attribute : attributes) {
            long l2 = attribute.type;
            if (BlendingAttribute.is(l2)) {
                this.context.setBlending(true, ((BlendingAttribute)attribute).sourceFunction, ((BlendingAttribute)attribute).destFunction);
                this.set(this.u_opacity, ((BlendingAttribute)attribute).opacity);
                continue;
            }
            if ((l2 & IntAttribute.CullFace) == IntAttribute.CullFace) {
                n2 = ((IntAttribute)attribute).value;
                continue;
            }
            if ((l2 & FloatAttribute.AlphaTest) == FloatAttribute.AlphaTest) {
                this.set(this.u_alphaTest, ((FloatAttribute)attribute).value);
                continue;
            }
            if ((l2 & DepthTestAttribute.Type) == DepthTestAttribute.Type) {
                DepthTestAttribute depthTestAttribute = (DepthTestAttribute)attribute;
                n3 = depthTestAttribute.depthFunc;
                f2 = depthTestAttribute.depthRangeNear;
                f3 = depthTestAttribute.depthRangeFar;
                bl2 = depthTestAttribute.depthMask;
                continue;
            }
            if (this.config.ignoreUnimplemented) continue;
            throw new GdxRuntimeException("Unknown material attribute: " + attribute.toString());
        }
        this.context.setCullFace(n2);
        this.context.setDepthTest(n3, f2, f3);
        this.context.setDepthMask(bl2);
    }

    protected void bindLights(Renderable renderable, Attributes attributes) {
        int n2;
        int n3;
        Array<SpotLight> array;
        Environment environment = renderable.environment;
        DirectionalLightsAttribute directionalLightsAttribute = attributes.get(DirectionalLightsAttribute.class, DirectionalLightsAttribute.Type);
        Array<DirectionalLight> array2 = directionalLightsAttribute == null ? null : directionalLightsAttribute.lights;
        PointLightsAttribute pointLightsAttribute = attributes.get(PointLightsAttribute.class, PointLightsAttribute.Type);
        Array<PointLight> array3 = pointLightsAttribute == null ? null : pointLightsAttribute.lights;
        SpotLightsAttribute spotLightsAttribute = attributes.get(SpotLightsAttribute.class, SpotLightsAttribute.Type);
        Array<SpotLight> array4 = array = spotLightsAttribute == null ? null : spotLightsAttribute.lights;
        if (this.dirLightsLoc >= 0) {
            for (n3 = 0; n3 < this.directionalLights.length; ++n3) {
                if (array2 == null || n3 >= array2.size) {
                    if (this.lightsSet && this.directionalLights[n3].color.r == 0.0f && this.directionalLights[n3].color.g == 0.0f && this.directionalLights[n3].color.b == 0.0f) continue;
                    this.directionalLights[n3].color.set(0.0f, 0.0f, 0.0f, 1.0f);
                } else {
                    if (this.lightsSet && this.directionalLights[n3].equals(array2.get(n3))) continue;
                    this.directionalLights[n3].set(array2.get(n3));
                }
                n2 = this.dirLightsLoc + n3 * this.dirLightsSize;
                this.program.setUniformf(n2 + this.dirLightsColorOffset, this.directionalLights[n3].color.r, this.directionalLights[n3].color.g, this.directionalLights[n3].color.b);
                this.program.setUniformf(n2 + this.dirLightsDirectionOffset, this.directionalLights[n3].direction.x, this.directionalLights[n3].direction.y, this.directionalLights[n3].direction.z);
                if (this.dirLightsSize <= 0) break;
            }
        }
        if (this.pointLightsLoc >= 0) {
            for (n3 = 0; n3 < this.pointLights.length; ++n3) {
                if (array3 == null || n3 >= array3.size) {
                    if (this.lightsSet && this.pointLights[n3].intensity == 0.0f) continue;
                    this.pointLights[n3].intensity = 0.0f;
                } else {
                    if (this.lightsSet && this.pointLights[n3].equals(array3.get(n3))) continue;
                    this.pointLights[n3].set(array3.get(n3));
                }
                n2 = this.pointLightsLoc + n3 * this.pointLightsSize;
                this.program.setUniformf(n2 + this.pointLightsColorOffset, this.pointLights[n3].color.r * this.pointLights[n3].intensity, this.pointLights[n3].color.g * this.pointLights[n3].intensity, this.pointLights[n3].color.b * this.pointLights[n3].intensity);
                this.program.setUniformf(n2 + this.pointLightsPositionOffset, this.pointLights[n3].position.x, this.pointLights[n3].position.y, this.pointLights[n3].position.z);
                if (this.pointLightsIntensityOffset >= 0) {
                    this.program.setUniformf(n2 + this.pointLightsIntensityOffset, this.pointLights[n3].intensity);
                }
                if (this.pointLightsSize <= 0) break;
            }
        }
        if (this.spotLightsLoc >= 0) {
            for (n3 = 0; n3 < this.spotLights.length; ++n3) {
                if (array == null || n3 >= array.size) {
                    if (this.lightsSet && this.spotLights[n3].intensity == 0.0f) continue;
                    this.spotLights[n3].intensity = 0.0f;
                } else {
                    if (this.lightsSet && this.spotLights[n3].equals(array.get(n3))) continue;
                    this.spotLights[n3].set(array.get(n3));
                }
                n2 = this.spotLightsLoc + n3 * this.spotLightsSize;
                this.program.setUniformf(n2 + this.spotLightsColorOffset, this.spotLights[n3].color.r * this.spotLights[n3].intensity, this.spotLights[n3].color.g * this.spotLights[n3].intensity, this.spotLights[n3].color.b * this.spotLights[n3].intensity);
                this.program.setUniformf(n2 + this.spotLightsPositionOffset, this.spotLights[n3].position);
                this.program.setUniformf(n2 + this.spotLightsDirectionOffset, this.spotLights[n3].direction);
                this.program.setUniformf(n2 + this.spotLightsCutoffAngleOffset, this.spotLights[n3].cutoffAngle);
                this.program.setUniformf(n2 + this.spotLightsExponentOffset, this.spotLights[n3].exponent);
                if (this.spotLightsIntensityOffset >= 0) {
                    this.program.setUniformf(n2 + this.spotLightsIntensityOffset, this.spotLights[n3].intensity);
                }
                if (this.spotLightsSize <= 0) break;
            }
        }
        if (attributes.has(ColorAttribute.Fog)) {
            this.set(this.u_fogColor, ((ColorAttribute)attributes.get((long)ColorAttribute.Fog)).color);
        }
        if (environment != null && environment.shadowMap != null) {
            this.set(this.u_shadowMapProjViewTrans, environment.shadowMap.getProjViewTrans());
            this.set(this.u_shadowTexture, environment.shadowMap.getDepthMap());
            this.set(this.u_shadowPCFOffset, 1.0f / (2.0f * (float)((GLTexture)environment.shadowMap.getDepthMap().texture).getWidth()));
        }
        this.lightsSet = true;
    }

    @Override
    public void dispose() {
        this.program.dispose();
        super.dispose();
    }

    public int getDefaultCullFace() {
        return this.config.defaultCullFace == -1 ? defaultCullFace : this.config.defaultCullFace;
    }

    public void setDefaultCullFace(int n2) {
        this.config.defaultCullFace = n2;
    }

    public int getDefaultDepthFunc() {
        return this.config.defaultDepthFunc == -1 ? defaultDepthFunc : this.config.defaultDepthFunc;
    }

    public void setDefaultDepthFunc(int n2) {
        this.config.defaultDepthFunc = n2;
    }

    public static class Setters {
        public static final BaseShader.Setter projTrans = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.projection);
            }
        };
        public static final BaseShader.Setter viewTrans = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.view);
            }
        };
        public static final BaseShader.Setter projViewTrans = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.combined);
            }
        };
        public static final BaseShader.Setter cameraPosition = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.position.x, baseShader.camera.position.y, baseShader.camera.position.z, 1.1881f / (baseShader.camera.far * baseShader.camera.far));
            }
        };
        public static final BaseShader.Setter cameraDirection = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.direction);
            }
        };
        public static final BaseShader.Setter cameraUp = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.up);
            }
        };
        public static final BaseShader.Setter cameraNearFar = new BaseShader.GlobalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.near, baseShader.camera.far);
            }
        };
        public static final BaseShader.Setter worldTrans = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, renderable.worldTransform);
            }
        };
        public static final BaseShader.Setter viewWorldTrans = new BaseShader.LocalSetter(){
            final Matrix4 temp = new Matrix4();

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, this.temp.set(baseShader.camera.view).mul(renderable.worldTransform));
            }
        };
        public static final BaseShader.Setter projViewWorldTrans = new BaseShader.LocalSetter(){
            final Matrix4 temp = new Matrix4();

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, this.temp.set(baseShader.camera.combined).mul(renderable.worldTransform));
            }
        };
        public static final BaseShader.Setter normalMatrix = new BaseShader.LocalSetter(){
            private final Matrix3 tmpM = new Matrix3();

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, this.tmpM.set(renderable.worldTransform).inv().transpose());
            }
        };
        public static final BaseShader.Setter shininess = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, ((FloatAttribute)attributes.get((long)FloatAttribute.Shininess)).value);
            }
        };
        public static final BaseShader.Setter diffuseColor = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, ((ColorAttribute)attributes.get((long)ColorAttribute.Diffuse)).color);
            }
        };
        public static final BaseShader.Setter diffuseTexture = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                int n3 = baseShader.context.textureBinder.bind(((TextureAttribute)attributes.get((long)TextureAttribute.Diffuse)).textureDescription);
                baseShader.set(n2, n3);
            }
        };
        public static final BaseShader.Setter diffuseUVTransform = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute)attributes.get(TextureAttribute.Diffuse);
                baseShader.set(n2, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final BaseShader.Setter specularColor = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, ((ColorAttribute)attributes.get((long)ColorAttribute.Specular)).color);
            }
        };
        public static final BaseShader.Setter specularTexture = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                int n3 = baseShader.context.textureBinder.bind(((TextureAttribute)attributes.get((long)TextureAttribute.Specular)).textureDescription);
                baseShader.set(n2, n3);
            }
        };
        public static final BaseShader.Setter specularUVTransform = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute)attributes.get(TextureAttribute.Specular);
                baseShader.set(n2, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final BaseShader.Setter emissiveColor = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, ((ColorAttribute)attributes.get((long)ColorAttribute.Emissive)).color);
            }
        };
        public static final BaseShader.Setter emissiveTexture = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                int n3 = baseShader.context.textureBinder.bind(((TextureAttribute)attributes.get((long)TextureAttribute.Emissive)).textureDescription);
                baseShader.set(n2, n3);
            }
        };
        public static final BaseShader.Setter emissiveUVTransform = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute)attributes.get(TextureAttribute.Emissive);
                baseShader.set(n2, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final BaseShader.Setter reflectionColor = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, ((ColorAttribute)attributes.get((long)ColorAttribute.Reflection)).color);
            }
        };
        public static final BaseShader.Setter reflectionTexture = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                int n3 = baseShader.context.textureBinder.bind(((TextureAttribute)attributes.get((long)TextureAttribute.Reflection)).textureDescription);
                baseShader.set(n2, n3);
            }
        };
        public static final BaseShader.Setter reflectionUVTransform = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute)attributes.get(TextureAttribute.Reflection);
                baseShader.set(n2, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final BaseShader.Setter normalTexture = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                int n3 = baseShader.context.textureBinder.bind(((TextureAttribute)attributes.get((long)TextureAttribute.Normal)).textureDescription);
                baseShader.set(n2, n3);
            }
        };
        public static final BaseShader.Setter normalUVTransform = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute)attributes.get(TextureAttribute.Normal);
                baseShader.set(n2, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final BaseShader.Setter ambientTexture = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                int n3 = baseShader.context.textureBinder.bind(((TextureAttribute)attributes.get((long)TextureAttribute.Ambient)).textureDescription);
                baseShader.set(n2, n3);
            }
        };
        public static final BaseShader.Setter ambientUVTransform = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute)attributes.get(TextureAttribute.Ambient);
                baseShader.set(n2, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final BaseShader.Setter environmentCubemap = new BaseShader.LocalSetter(){

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                if (attributes.has(CubemapAttribute.EnvironmentMap)) {
                    baseShader.set(n2, baseShader.context.textureBinder.bind(((CubemapAttribute)attributes.get((long)CubemapAttribute.EnvironmentMap)).textureDescription));
                }
            }
        };

        public static class ACubemap
        extends BaseShader.LocalSetter {
            private static final float[] ones = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
            private final AmbientCubemap cacheAmbientCubemap = new AmbientCubemap();
            private static final Vector3 tmpV1 = new Vector3();
            public final int dirLightsOffset;
            public final int pointLightsOffset;

            public ACubemap(int n2, int n3) {
                this.dirLightsOffset = n2;
                this.pointLightsOffset = n3;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                if (renderable.environment == null) {
                    baseShader.program.setUniform3fv(baseShader.loc(n2), ones, 0, ones.length);
                } else {
                    int n3;
                    Array<BaseLight> array;
                    renderable.worldTransform.getTranslation(tmpV1);
                    if (attributes.has(ColorAttribute.AmbientLight)) {
                        this.cacheAmbientCubemap.set(((ColorAttribute)attributes.get((long)ColorAttribute.AmbientLight)).color);
                    }
                    if (attributes.has(DirectionalLightsAttribute.Type)) {
                        array = ((DirectionalLightsAttribute)attributes.get((long)DirectionalLightsAttribute.Type)).lights;
                        for (n3 = this.dirLightsOffset; n3 < array.size; ++n3) {
                            this.cacheAmbientCubemap.add(((DirectionalLight)array.get((int)n3)).color, ((DirectionalLight)array.get((int)n3)).direction);
                        }
                    }
                    if (attributes.has(PointLightsAttribute.Type)) {
                        array = ((PointLightsAttribute)attributes.get((long)PointLightsAttribute.Type)).lights;
                        for (n3 = this.pointLightsOffset; n3 < array.size; ++n3) {
                            this.cacheAmbientCubemap.add(((PointLight)array.get((int)n3)).color, ((PointLight)array.get((int)n3)).position, tmpV1, ((PointLight)array.get((int)n3)).intensity);
                        }
                    }
                    this.cacheAmbientCubemap.clamp();
                    baseShader.program.setUniform3fv(baseShader.loc(n2), this.cacheAmbientCubemap.data, 0, this.cacheAmbientCubemap.data.length);
                }
            }
        }

        public static class Bones
        extends BaseShader.LocalSetter {
            private static final Matrix4 idtMatrix = new Matrix4();
            public final float[] bones;

            public Bones(int n2) {
                this.bones = new float[n2 * 16];
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                for (int i2 = 0; i2 < this.bones.length; i2 += 16) {
                    int n3 = i2 / 16;
                    if (renderable.bones == null || n3 >= renderable.bones.length || renderable.bones[n3] == null) {
                        System.arraycopy(Bones.idtMatrix.val, 0, this.bones, i2, 16);
                        continue;
                    }
                    System.arraycopy(renderable.bones[n3].val, 0, this.bones, i2, 16);
                }
                baseShader.program.setUniformMatrix4fv(baseShader.loc(n2), this.bones, 0, this.bones.length);
            }
        }
    }

    public static class Inputs {
        public static final BaseShader.Uniform projTrans = new BaseShader.Uniform("u_projTrans");
        public static final BaseShader.Uniform viewTrans = new BaseShader.Uniform("u_viewTrans");
        public static final BaseShader.Uniform projViewTrans = new BaseShader.Uniform("u_projViewTrans");
        public static final BaseShader.Uniform cameraPosition = new BaseShader.Uniform("u_cameraPosition");
        public static final BaseShader.Uniform cameraDirection = new BaseShader.Uniform("u_cameraDirection");
        public static final BaseShader.Uniform cameraUp = new BaseShader.Uniform("u_cameraUp");
        public static final BaseShader.Uniform cameraNearFar = new BaseShader.Uniform("u_cameraNearFar");
        public static final BaseShader.Uniform worldTrans = new BaseShader.Uniform("u_worldTrans");
        public static final BaseShader.Uniform viewWorldTrans = new BaseShader.Uniform("u_viewWorldTrans");
        public static final BaseShader.Uniform projViewWorldTrans = new BaseShader.Uniform("u_projViewWorldTrans");
        public static final BaseShader.Uniform normalMatrix = new BaseShader.Uniform("u_normalMatrix");
        public static final BaseShader.Uniform bones = new BaseShader.Uniform("u_bones");
        public static final BaseShader.Uniform shininess = new BaseShader.Uniform("u_shininess", FloatAttribute.Shininess);
        public static final BaseShader.Uniform opacity = new BaseShader.Uniform("u_opacity", BlendingAttribute.Type);
        public static final BaseShader.Uniform diffuseColor = new BaseShader.Uniform("u_diffuseColor", ColorAttribute.Diffuse);
        public static final BaseShader.Uniform diffuseTexture = new BaseShader.Uniform("u_diffuseTexture", TextureAttribute.Diffuse);
        public static final BaseShader.Uniform diffuseUVTransform = new BaseShader.Uniform("u_diffuseUVTransform", TextureAttribute.Diffuse);
        public static final BaseShader.Uniform specularColor = new BaseShader.Uniform("u_specularColor", ColorAttribute.Specular);
        public static final BaseShader.Uniform specularTexture = new BaseShader.Uniform("u_specularTexture", TextureAttribute.Specular);
        public static final BaseShader.Uniform specularUVTransform = new BaseShader.Uniform("u_specularUVTransform", TextureAttribute.Specular);
        public static final BaseShader.Uniform emissiveColor = new BaseShader.Uniform("u_emissiveColor", ColorAttribute.Emissive);
        public static final BaseShader.Uniform emissiveTexture = new BaseShader.Uniform("u_emissiveTexture", TextureAttribute.Emissive);
        public static final BaseShader.Uniform emissiveUVTransform = new BaseShader.Uniform("u_emissiveUVTransform", TextureAttribute.Emissive);
        public static final BaseShader.Uniform reflectionColor = new BaseShader.Uniform("u_reflectionColor", ColorAttribute.Reflection);
        public static final BaseShader.Uniform reflectionTexture = new BaseShader.Uniform("u_reflectionTexture", TextureAttribute.Reflection);
        public static final BaseShader.Uniform reflectionUVTransform = new BaseShader.Uniform("u_reflectionUVTransform", TextureAttribute.Reflection);
        public static final BaseShader.Uniform normalTexture = new BaseShader.Uniform("u_normalTexture", TextureAttribute.Normal);
        public static final BaseShader.Uniform normalUVTransform = new BaseShader.Uniform("u_normalUVTransform", TextureAttribute.Normal);
        public static final BaseShader.Uniform ambientTexture = new BaseShader.Uniform("u_ambientTexture", TextureAttribute.Ambient);
        public static final BaseShader.Uniform ambientUVTransform = new BaseShader.Uniform("u_ambientUVTransform", TextureAttribute.Ambient);
        public static final BaseShader.Uniform alphaTest = new BaseShader.Uniform("u_alphaTest");
        public static final BaseShader.Uniform ambientCube = new BaseShader.Uniform("u_ambientCubemap");
        public static final BaseShader.Uniform dirLights = new BaseShader.Uniform("u_dirLights");
        public static final BaseShader.Uniform pointLights = new BaseShader.Uniform("u_pointLights");
        public static final BaseShader.Uniform spotLights = new BaseShader.Uniform("u_spotLights");
        public static final BaseShader.Uniform environmentCubemap = new BaseShader.Uniform("u_environmentCubemap");
    }

    public static class Config {
        public String vertexShader = null;
        public String fragmentShader = null;
        public int numDirectionalLights = 2;
        public int numPointLights = 5;
        public int numSpotLights = 0;
        public int numBones = 12;
        public boolean ignoreUnimplemented = true;
        public int defaultCullFace = -1;
        public int defaultDepthFunc = -1;

        public Config() {
        }

        public Config(String string, String string2) {
            this.vertexShader = string;
            this.fragmentShader = string2;
        }
    }
}

