/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.IntIntMap;

public abstract class BaseShader
implements Shader {
    private final Array<String> uniforms = new Array();
    private final Array<Validator> validators = new Array();
    private final Array<Setter> setters = new Array();
    private int[] locations;
    private final IntArray globalUniforms = new IntArray();
    private final IntArray localUniforms = new IntArray();
    private final IntIntMap attributes = new IntIntMap();
    public ShaderProgram program;
    public RenderContext context;
    public Camera camera;
    private Mesh currentMesh;
    private final IntArray tempArray = new IntArray();
    private Attributes combinedAttributes = new Attributes();

    public int register(String string, Validator validator, Setter setter) {
        if (this.locations != null) {
            throw new GdxRuntimeException("Cannot register an uniform after initialization");
        }
        int n2 = this.getUniformID(string);
        if (n2 >= 0) {
            this.validators.set(n2, validator);
            this.setters.set(n2, setter);
            return n2;
        }
        this.uniforms.add(string);
        this.validators.add(validator);
        this.setters.add(setter);
        return this.uniforms.size - 1;
    }

    public int register(String string, Validator validator) {
        return this.register(string, validator, null);
    }

    public int register(String string, Setter setter) {
        return this.register(string, null, setter);
    }

    public int register(String string) {
        return this.register(string, null, null);
    }

    public int register(Uniform uniform, Setter setter) {
        return this.register(uniform.alias, uniform, setter);
    }

    public int register(Uniform uniform) {
        return this.register(uniform, null);
    }

    public int getUniformID(String string) {
        int n2 = this.uniforms.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.uniforms.get(i2).equals(string)) continue;
            return i2;
        }
        return -1;
    }

    public String getUniformAlias(int n2) {
        return this.uniforms.get(n2);
    }

    public void init(ShaderProgram shaderProgram, Renderable renderable) {
        Object object;
        if (this.locations != null) {
            throw new GdxRuntimeException("Already initialized");
        }
        if (!shaderProgram.isCompiled()) {
            throw new GdxRuntimeException(shaderProgram.getLog());
        }
        this.program = shaderProgram;
        int n2 = this.uniforms.size;
        this.locations = new int[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = this.uniforms.get(i2);
            Validator validator = this.validators.get(i2);
            object = this.setters.get(i2);
            if (validator != null && !validator.validate(this, i2, renderable)) {
                this.locations[i2] = -1;
            } else {
                this.locations[i2] = shaderProgram.fetchUniformLocation(string, false);
                if (this.locations[i2] >= 0 && object != null) {
                    if (object.isGlobal(this, i2)) {
                        this.globalUniforms.add(i2);
                    } else {
                        this.localUniforms.add(i2);
                    }
                }
            }
            if (this.locations[i2] >= 0) continue;
            this.validators.set(i2, null);
            this.setters.set(i2, null);
        }
        if (renderable != null) {
            VertexAttributes vertexAttributes = renderable.meshPart.mesh.getVertexAttributes();
            int n3 = vertexAttributes.size();
            for (int i3 = 0; i3 < n3; ++i3) {
                object = vertexAttributes.get(i3);
                int n4 = shaderProgram.getAttributeLocation(((VertexAttribute)object).alias);
                if (n4 < 0) continue;
                this.attributes.put(((VertexAttribute)object).getKey(), n4);
            }
        }
    }

    @Override
    public void begin(Camera camera, RenderContext renderContext) {
        this.camera = camera;
        this.context = renderContext;
        this.program.bind();
        this.currentMesh = null;
        for (int i2 = 0; i2 < this.globalUniforms.size; ++i2) {
            int n2 = this.globalUniforms.get(i2);
            if (this.setters.get(n2) == null) continue;
            this.setters.get(n2).set(this, n2, null, null);
        }
    }

    private final int[] getAttributeLocations(VertexAttributes vertexAttributes) {
        this.tempArray.clear();
        int n2 = vertexAttributes.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.tempArray.add(this.attributes.get(vertexAttributes.get(i2).getKey(), -1));
        }
        this.tempArray.shrink();
        return this.tempArray.items;
    }

    @Override
    public void render(Renderable renderable) {
        if (renderable.worldTransform.det3x3() == 0.0f) {
            return;
        }
        this.combinedAttributes.clear();
        if (renderable.environment != null) {
            this.combinedAttributes.set(renderable.environment);
        }
        if (renderable.material != null) {
            this.combinedAttributes.set(renderable.material);
        }
        this.render(renderable, this.combinedAttributes);
    }

    public void render(Renderable renderable, Attributes attributes) {
        for (int i2 = 0; i2 < this.localUniforms.size; ++i2) {
            int n2 = this.localUniforms.get(i2);
            if (this.setters.get(n2) == null) continue;
            this.setters.get(n2).set(this, n2, renderable, attributes);
        }
        if (this.currentMesh != renderable.meshPart.mesh) {
            if (this.currentMesh != null) {
                this.currentMesh.unbind(this.program, this.tempArray.items);
            }
            this.currentMesh = renderable.meshPart.mesh;
            this.currentMesh.bind(this.program, this.getAttributeLocations(renderable.meshPart.mesh.getVertexAttributes()));
        }
        renderable.meshPart.render(this.program, false);
    }

    @Override
    public void end() {
        if (this.currentMesh != null) {
            this.currentMesh.unbind(this.program, this.tempArray.items);
            this.currentMesh = null;
        }
    }

    @Override
    public void dispose() {
        this.program = null;
        this.uniforms.clear();
        this.validators.clear();
        this.setters.clear();
        this.localUniforms.clear();
        this.globalUniforms.clear();
        this.locations = null;
    }

    public final boolean has(int n2) {
        return n2 >= 0 && n2 < this.locations.length && this.locations[n2] >= 0;
    }

    public final int loc(int n2) {
        return n2 >= 0 && n2 < this.locations.length ? this.locations[n2] : -1;
    }

    public final boolean set(int n2, Matrix4 matrix4) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformMatrix(this.locations[n2], matrix4);
        return true;
    }

    public final boolean set(int n2, Matrix3 matrix3) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformMatrix(this.locations[n2], matrix3);
        return true;
    }

    public final boolean set(int n2, Vector3 vector3) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], vector3);
        return true;
    }

    public final boolean set(int n2, Vector2 vector2) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], vector2);
        return true;
    }

    public final boolean set(int n2, Color color) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], color);
        return true;
    }

    public final boolean set(int n2, float f2) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], f2);
        return true;
    }

    public final boolean set(int n2, float f2, float f3) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], f2, f3);
        return true;
    }

    public final boolean set(int n2, float f2, float f3, float f4) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], f2, f3, f4);
        return true;
    }

    public final boolean set(int n2, float f2, float f3, float f4, float f5) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformf(this.locations[n2], f2, f3, f4, f5);
        return true;
    }

    public final boolean set(int n2, int n3) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformi(this.locations[n2], n3);
        return true;
    }

    public final boolean set(int n2, int n3, int n4) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformi(this.locations[n2], n3, n4);
        return true;
    }

    public final boolean set(int n2, int n3, int n4, int n5) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformi(this.locations[n2], n3, n4, n5);
        return true;
    }

    public final boolean set(int n2, int n3, int n4, int n5, int n6) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformi(this.locations[n2], n3, n4, n5, n6);
        return true;
    }

    public final boolean set(int n2, TextureDescriptor textureDescriptor) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformi(this.locations[n2], this.context.textureBinder.bind(textureDescriptor));
        return true;
    }

    public final boolean set(int n2, GLTexture gLTexture) {
        if (this.locations[n2] < 0) {
            return false;
        }
        this.program.setUniformi(this.locations[n2], this.context.textureBinder.bind(gLTexture));
        return true;
    }

    public static class Uniform
    implements Validator {
        public final String alias;
        public final long materialMask;
        public final long environmentMask;
        public final long overallMask;

        public Uniform(String string, long l2, long l3, long l4) {
            this.alias = string;
            this.materialMask = l2;
            this.environmentMask = l3;
            this.overallMask = l4;
        }

        public Uniform(String string, long l2, long l3) {
            this(string, l2, l3, 0L);
        }

        public Uniform(String string, long l2) {
            this(string, 0L, 0L, l2);
        }

        public Uniform(String string) {
            this(string, 0L, 0L);
        }

        @Override
        public boolean validate(BaseShader baseShader, int n2, Renderable renderable) {
            long l2 = renderable != null && renderable.material != null ? renderable.material.getMask() : 0L;
            long l3 = renderable != null && renderable.environment != null ? renderable.environment.getMask() : 0L;
            return (l2 & this.materialMask) == this.materialMask && (l3 & this.environmentMask) == this.environmentMask && ((l2 | l3) & this.overallMask) == this.overallMask;
        }
    }

    public static abstract class LocalSetter
    implements Setter {
        @Override
        public boolean isGlobal(BaseShader baseShader, int n2) {
            return false;
        }
    }

    public static abstract class GlobalSetter
    implements Setter {
        @Override
        public boolean isGlobal(BaseShader baseShader, int n2) {
            return true;
        }
    }

    public static interface Setter {
        public boolean isGlobal(BaseShader var1, int var2);

        public void set(BaseShader var1, int var2, Renderable var3, Attributes var4);
    }

    public static interface Validator {
        public boolean validate(BaseShader var1, int var2, Renderable var3);
    }
}

