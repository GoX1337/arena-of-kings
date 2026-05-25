/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ImmediateModeRenderer20
implements ImmediateModeRenderer {
    private int primitiveType;
    private int vertexIdx;
    private int numSetTexCoords;
    private final int maxVertices;
    private int numVertices;
    private final Mesh mesh;
    private ShaderProgram shader;
    private boolean ownsShader;
    private final int numTexCoords;
    private final int vertexSize;
    private final int normalOffset;
    private final int colorOffset;
    private final int texCoordOffset;
    private final Matrix4 projModelView = new Matrix4();
    private final float[] vertices;
    private final String[] shaderUniformNames;

    public ImmediateModeRenderer20(boolean bl2, boolean bl3, int n2) {
        this(5000, bl2, bl3, n2, ImmediateModeRenderer20.createDefaultShader(bl2, bl3, n2));
        this.ownsShader = true;
    }

    public ImmediateModeRenderer20(int n2, boolean bl2, boolean bl3, int n3) {
        this(n2, bl2, bl3, n3, ImmediateModeRenderer20.createDefaultShader(bl2, bl3, n3));
        this.ownsShader = true;
    }

    public ImmediateModeRenderer20(int n2, boolean bl2, boolean bl3, int n3, ShaderProgram shaderProgram) {
        this.maxVertices = n2;
        this.numTexCoords = n3;
        this.shader = shaderProgram;
        VertexAttribute[] vertexAttributeArray = this.buildVertexAttributes(bl2, bl3, n3);
        this.mesh = new Mesh(false, n2, 0, vertexAttributeArray);
        this.vertices = new float[n2 * (this.mesh.getVertexAttributes().vertexSize / 4)];
        this.vertexSize = this.mesh.getVertexAttributes().vertexSize / 4;
        this.normalOffset = this.mesh.getVertexAttribute(8) != null ? this.mesh.getVertexAttribute((int)8).offset / 4 : 0;
        this.colorOffset = this.mesh.getVertexAttribute(4) != null ? this.mesh.getVertexAttribute((int)4).offset / 4 : 0;
        this.texCoordOffset = this.mesh.getVertexAttribute(16) != null ? this.mesh.getVertexAttribute((int)16).offset / 4 : 0;
        this.shaderUniformNames = new String[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            this.shaderUniformNames[i2] = "u_sampler" + i2;
        }
    }

    private VertexAttribute[] buildVertexAttributes(boolean bl2, boolean bl3, int n2) {
        Array<VertexAttribute> array = new Array<VertexAttribute>();
        array.add(new VertexAttribute(1, 3, "a_position"));
        if (bl2) {
            array.add(new VertexAttribute(8, 3, "a_normal"));
        }
        if (bl3) {
            array.add(new VertexAttribute(4, 4, "a_color"));
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            array.add(new VertexAttribute(16, 2, "a_texCoord" + i2));
        }
        VertexAttribute[] vertexAttributeArray = new VertexAttribute[array.size];
        for (int i3 = 0; i3 < array.size; ++i3) {
            vertexAttributeArray[i3] = (VertexAttribute)array.get(i3);
        }
        return vertexAttributeArray;
    }

    public void setShader(ShaderProgram shaderProgram) {
        if (this.ownsShader) {
            this.shader.dispose();
        }
        this.shader = shaderProgram;
        this.ownsShader = false;
    }

    public ShaderProgram getShader() {
        return this.shader;
    }

    @Override
    public void begin(Matrix4 matrix4, int n2) {
        this.projModelView.set(matrix4);
        this.primitiveType = n2;
    }

    @Override
    public void color(Color color) {
        this.vertices[this.vertexIdx + this.colorOffset] = color.toFloatBits();
    }

    @Override
    public void color(float f2, float f3, float f4, float f5) {
        this.vertices[this.vertexIdx + this.colorOffset] = Color.toFloatBits(f2, f3, f4, f5);
    }

    @Override
    public void color(float f2) {
        this.vertices[this.vertexIdx + this.colorOffset] = f2;
    }

    @Override
    public void texCoord(float f2, float f3) {
        int n2 = this.vertexIdx + this.texCoordOffset;
        this.vertices[n2 + this.numSetTexCoords] = f2;
        this.vertices[n2 + this.numSetTexCoords + 1] = f3;
        this.numSetTexCoords += 2;
    }

    @Override
    public void normal(float f2, float f3, float f4) {
        int n2 = this.vertexIdx + this.normalOffset;
        this.vertices[n2] = f2;
        this.vertices[n2 + 1] = f3;
        this.vertices[n2 + 2] = f4;
    }

    @Override
    public void vertex(float f2, float f3, float f4) {
        int n2 = this.vertexIdx;
        this.vertices[n2] = f2;
        this.vertices[n2 + 1] = f3;
        this.vertices[n2 + 2] = f4;
        this.numSetTexCoords = 0;
        this.vertexIdx += this.vertexSize;
        ++this.numVertices;
    }

    @Override
    public void flush() {
        if (this.numVertices == 0) {
            return;
        }
        this.shader.bind();
        this.shader.setUniformMatrix("u_projModelView", this.projModelView);
        for (int i2 = 0; i2 < this.numTexCoords; ++i2) {
            this.shader.setUniformi(this.shaderUniformNames[i2], i2);
        }
        this.mesh.setVertices(this.vertices, 0, this.vertexIdx);
        this.mesh.render(this.shader, this.primitiveType);
        this.numSetTexCoords = 0;
        this.vertexIdx = 0;
        this.numVertices = 0;
    }

    @Override
    public void end() {
        this.flush();
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }

    @Override
    public int getMaxVertices() {
        return this.maxVertices;
    }

    @Override
    public void dispose() {
        if (this.ownsShader && this.shader != null) {
            this.shader.dispose();
        }
        this.mesh.dispose();
    }

    private static String createVertexShader(boolean bl2, boolean bl3, int n2) {
        int n3;
        String string = "attribute vec4 a_position;\n" + (bl2 ? "attribute vec3 a_normal;\n" : "") + (bl3 ? "attribute vec4 a_color;\n" : "");
        for (n3 = 0; n3 < n2; ++n3) {
            string = string + "attribute vec2 a_texCoord" + n3 + ";\n";
        }
        string = string + "uniform mat4 u_projModelView;\n" + (bl3 ? "varying vec4 v_col;\n" : "");
        for (n3 = 0; n3 < n2; ++n3) {
            string = string + "varying vec2 v_tex" + n3 + ";\n";
        }
        string = string + "void main() {\n   gl_Position = u_projModelView * a_position;\n";
        if (bl3) {
            string = string + "   v_col = a_color;\n   v_col.a *= 255.0 / 254.0;\n";
        }
        for (n3 = 0; n3 < n2; ++n3) {
            string = string + "   v_tex" + n3 + " = " + "a_texCoord" + n3 + ";\n";
        }
        string = string + "   gl_PointSize = 1.0;\n}\n";
        return string;
    }

    private static String createFragmentShader(boolean bl2, boolean bl3, int n2) {
        int n3;
        String string = "#ifdef GL_ES\nprecision mediump float;\n#endif\n";
        if (bl3) {
            string = string + "varying vec4 v_col;\n";
        }
        for (n3 = 0; n3 < n2; ++n3) {
            string = string + "varying vec2 v_tex" + n3 + ";\n";
            string = string + "uniform sampler2D u_sampler" + n3 + ";\n";
        }
        string = string + "void main() {\n   gl_FragColor = " + (bl3 ? "v_col" : "vec4(1, 1, 1, 1)");
        if (n2 > 0) {
            string = string + " * ";
        }
        for (n3 = 0; n3 < n2; ++n3) {
            string = n3 == n2 - 1 ? string + " texture2D(u_sampler" + n3 + ",  v_tex" + n3 + ")" : string + " texture2D(u_sampler" + n3 + ",  v_tex" + n3 + ") *";
        }
        string = string + ";\n}";
        return string;
    }

    public static ShaderProgram createDefaultShader(boolean bl2, boolean bl3, int n2) {
        String string;
        String string2 = ImmediateModeRenderer20.createVertexShader(bl2, bl3, n2);
        ShaderProgram shaderProgram = new ShaderProgram(string2, string = ImmediateModeRenderer20.createFragmentShader(bl2, bl3, n2));
        if (!shaderProgram.isCompiled()) {
            throw new GdxRuntimeException("Error compiling shader: " + shaderProgram.getLog());
        }
        return shaderProgram;
    }
}

