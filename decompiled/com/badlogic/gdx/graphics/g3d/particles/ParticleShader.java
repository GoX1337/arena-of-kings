/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParticleShader
extends BaseShader {
    private static String defaultVertexShader = null;
    private static String defaultFragmentShader = null;
    protected static long implementedFlags = BlendingAttribute.Type | TextureAttribute.Diffuse;
    static final Vector3 TMP_VECTOR3 = new Vector3();
    private Renderable renderable;
    private long materialMask;
    private long vertexMask;
    protected final Config config;
    private static final long optionalAttributes = IntAttribute.CullFace | DepthTestAttribute.Type;
    Material currentMaterial;

    public static String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public static String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public ParticleShader(Renderable renderable) {
        this(renderable, new Config());
    }

    public ParticleShader(Renderable renderable, Config config) {
        this(renderable, config, ParticleShader.createPrefix(renderable, config));
    }

    public ParticleShader(Renderable renderable, Config config, String string) {
        this(renderable, config, string, config.vertexShader != null ? config.vertexShader : ParticleShader.getDefaultVertexShader(), config.fragmentShader != null ? config.fragmentShader : ParticleShader.getDefaultFragmentShader());
    }

    public ParticleShader(Renderable renderable, Config config, String string, String string2, String string3) {
        this(renderable, config, new ShaderProgram(string + string2, string + string3));
    }

    public ParticleShader(Renderable renderable, Config config, ShaderProgram shaderProgram) {
        this.config = config;
        this.program = shaderProgram;
        this.renderable = renderable;
        this.materialMask = renderable.material.getMask() | optionalAttributes;
        this.vertexMask = renderable.meshPart.mesh.getVertexAttributes().getMask();
        if (!config.ignoreUnimplemented && (implementedFlags & this.materialMask) != this.materialMask) {
            throw new GdxRuntimeException("Some attributes not implemented yet (" + this.materialMask + ")");
        }
        this.register(DefaultShader.Inputs.viewTrans, DefaultShader.Setters.viewTrans);
        this.register(DefaultShader.Inputs.projViewTrans, DefaultShader.Setters.projViewTrans);
        this.register(DefaultShader.Inputs.projTrans, DefaultShader.Setters.projTrans);
        this.register(Inputs.screenWidth, Setters.screenWidth);
        this.register(DefaultShader.Inputs.cameraUp, Setters.cameraUp);
        this.register(Inputs.cameraRight, Setters.cameraRight);
        this.register(Inputs.cameraInvDirection, Setters.cameraInvDirection);
        this.register(DefaultShader.Inputs.cameraPosition, Setters.cameraPosition);
        this.register(DefaultShader.Inputs.diffuseTexture, DefaultShader.Setters.diffuseTexture);
    }

    @Override
    public void init() {
        ShaderProgram shaderProgram = this.program;
        this.program = null;
        this.init(shaderProgram, this.renderable);
        this.renderable = null;
    }

    public static String createPrefix(Renderable renderable, Config config) {
        String string = "";
        string = Gdx.app.getType() == Application.ApplicationType.Desktop ? string + "#version 120\n" : string + "#version 100\n";
        if (config.type == ParticleType.Billboard) {
            string = string + "#define billboard\n";
            if (config.align == AlignMode.Screen) {
                string = string + "#define screenFacing\n";
            } else if (config.align == AlignMode.ViewPoint) {
                string = string + "#define viewPointFacing\n";
            }
        }
        return string;
    }

    @Override
    public boolean canRender(Renderable renderable) {
        return this.materialMask == (renderable.material.getMask() | optionalAttributes) && this.vertexMask == renderable.meshPart.mesh.getVertexAttributes().getMask();
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
        return object instanceof ParticleShader && this.equals((ParticleShader)object);
    }

    public boolean equals(ParticleShader particleShader) {
        return particleShader == this;
    }

    @Override
    public void begin(Camera camera, RenderContext renderContext) {
        super.begin(camera, renderContext);
    }

    @Override
    public void render(Renderable renderable) {
        if (!renderable.material.has(BlendingAttribute.Type)) {
            this.context.setBlending(false, 770, 771);
        }
        this.bindMaterial(renderable);
        super.render(renderable);
    }

    @Override
    public void end() {
        this.currentMaterial = null;
        super.end();
    }

    protected void bindMaterial(Renderable renderable) {
        if (this.currentMaterial == renderable.material) {
            return;
        }
        int n2 = this.config.defaultCullFace == -1 ? 1029 : this.config.defaultCullFace;
        int n3 = this.config.defaultDepthFunc == -1 ? 515 : this.config.defaultDepthFunc;
        float f2 = 0.0f;
        float f3 = 1.0f;
        boolean bl2 = true;
        this.currentMaterial = renderable.material;
        for (Attribute attribute : this.currentMaterial) {
            long l2 = attribute.type;
            if (BlendingAttribute.is(l2)) {
                this.context.setBlending(true, ((BlendingAttribute)attribute).sourceFunction, ((BlendingAttribute)attribute).destFunction);
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

    @Override
    public void dispose() {
        this.program.dispose();
        super.dispose();
    }

    public int getDefaultCullFace() {
        return this.config.defaultCullFace == -1 ? 1029 : this.config.defaultCullFace;
    }

    public void setDefaultCullFace(int n2) {
        this.config.defaultCullFace = n2;
    }

    public int getDefaultDepthFunc() {
        return this.config.defaultDepthFunc == -1 ? 515 : this.config.defaultDepthFunc;
    }

    public void setDefaultDepthFunc(int n2) {
        this.config.defaultDepthFunc = n2;
    }

    public static class Setters {
        public static final BaseShader.Setter cameraRight = new BaseShader.Setter(){

            @Override
            public boolean isGlobal(BaseShader baseShader, int n2) {
                return true;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, TMP_VECTOR3.set(baseShader.camera.direction).crs(baseShader.camera.up).nor());
            }
        };
        public static final BaseShader.Setter cameraUp = new BaseShader.Setter(){

            @Override
            public boolean isGlobal(BaseShader baseShader, int n2) {
                return true;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, TMP_VECTOR3.set(baseShader.camera.up).nor());
            }
        };
        public static final BaseShader.Setter cameraInvDirection = new BaseShader.Setter(){

            @Override
            public boolean isGlobal(BaseShader baseShader, int n2) {
                return true;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, TMP_VECTOR3.set(-baseShader.camera.direction.x, -baseShader.camera.direction.y, -baseShader.camera.direction.z).nor());
            }
        };
        public static final BaseShader.Setter cameraPosition = new BaseShader.Setter(){

            @Override
            public boolean isGlobal(BaseShader baseShader, int n2) {
                return true;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, baseShader.camera.position);
            }
        };
        public static final BaseShader.Setter screenWidth = new BaseShader.Setter(){

            @Override
            public boolean isGlobal(BaseShader baseShader, int n2) {
                return true;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, (float)Gdx.graphics.getWidth());
            }
        };
        public static final BaseShader.Setter worldViewTrans = new BaseShader.Setter(){
            final Matrix4 temp = new Matrix4();

            @Override
            public boolean isGlobal(BaseShader baseShader, int n2) {
                return false;
            }

            @Override
            public void set(BaseShader baseShader, int n2, Renderable renderable, Attributes attributes) {
                baseShader.set(n2, this.temp.set(baseShader.camera.view).mul(renderable.worldTransform));
            }
        };
    }

    public static class Inputs {
        public static final BaseShader.Uniform cameraRight = new BaseShader.Uniform("u_cameraRight");
        public static final BaseShader.Uniform cameraInvDirection = new BaseShader.Uniform("u_cameraInvDirection");
        public static final BaseShader.Uniform screenWidth = new BaseShader.Uniform("u_screenWidth");
        public static final BaseShader.Uniform regionSize = new BaseShader.Uniform("u_regionSize");
    }

    public static class Config {
        public String vertexShader = null;
        public String fragmentShader = null;
        public boolean ignoreUnimplemented = true;
        public int defaultCullFace = -1;
        public int defaultDepthFunc = -1;
        public AlignMode align = AlignMode.Screen;
        public ParticleType type = ParticleType.Billboard;

        public Config() {
        }

        public Config(AlignMode alignMode, ParticleType particleType) {
            this.align = alignMode;
            this.type = particleType;
        }

        public Config(AlignMode alignMode) {
            this.align = alignMode;
        }

        public Config(ParticleType particleType) {
            this.type = particleType;
        }

        public Config(String string, String string2) {
            this.vertexShader = string;
            this.fragmentShader = string2;
        }
    }

    public static enum AlignMode {
        Screen,
        ViewPoint;

    }

    public static enum ParticleType {
        Billboard,
        Point;

    }
}

