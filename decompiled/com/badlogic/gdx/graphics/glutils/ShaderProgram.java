/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class ShaderProgram
implements Disposable {
    public static final String POSITION_ATTRIBUTE = "a_position";
    public static final String NORMAL_ATTRIBUTE = "a_normal";
    public static final String COLOR_ATTRIBUTE = "a_color";
    public static final String TEXCOORD_ATTRIBUTE = "a_texCoord";
    public static final String TANGENT_ATTRIBUTE = "a_tangent";
    public static final String BINORMAL_ATTRIBUTE = "a_binormal";
    public static final String BONEWEIGHT_ATTRIBUTE = "a_boneWeight";
    public static boolean pedantic = true;
    public static String prependVertexCode = "";
    public static String prependFragmentCode = "";
    private static final ObjectMap<Application, Array<ShaderProgram>> shaders = new ObjectMap();
    private String log = "";
    private boolean isCompiled;
    private final ObjectIntMap<String> uniforms = new ObjectIntMap();
    private final ObjectIntMap<String> uniformTypes = new ObjectIntMap();
    private final ObjectIntMap<String> uniformSizes = new ObjectIntMap();
    private String[] uniformNames;
    private final ObjectIntMap<String> attributes = new ObjectIntMap();
    private final ObjectIntMap<String> attributeTypes = new ObjectIntMap();
    private final ObjectIntMap<String> attributeSizes = new ObjectIntMap();
    private String[] attributeNames;
    private int program;
    private int vertexShaderHandle;
    private int fragmentShaderHandle;
    private final FloatBuffer matrix;
    private final String vertexShaderSource;
    private final String fragmentShaderSource;
    private boolean invalidated;
    private int refCount = 0;
    static final IntBuffer intbuf = BufferUtils.newIntBuffer(1);
    IntBuffer params = BufferUtils.newIntBuffer(1);
    IntBuffer type = BufferUtils.newIntBuffer(1);

    public ShaderProgram(String string, String string2) {
        if (string == null) {
            throw new IllegalArgumentException("vertex shader must not be null");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("fragment shader must not be null");
        }
        if (prependVertexCode != null && prependVertexCode.length() > 0) {
            string = prependVertexCode + string;
        }
        if (prependFragmentCode != null && prependFragmentCode.length() > 0) {
            string2 = prependFragmentCode + string2;
        }
        this.vertexShaderSource = string;
        this.fragmentShaderSource = string2;
        this.matrix = BufferUtils.newFloatBuffer(16);
        this.compileShaders(string, string2);
        if (this.isCompiled()) {
            this.fetchAttributes();
            this.fetchUniforms();
            this.addManagedShader(Gdx.app, this);
        }
    }

    public ShaderProgram(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle.readString(), fileHandle2.readString());
    }

    private void compileShaders(String string, String string2) {
        this.vertexShaderHandle = this.loadShader(35633, string);
        this.fragmentShaderHandle = this.loadShader(35632, string2);
        if (this.vertexShaderHandle == -1 || this.fragmentShaderHandle == -1) {
            this.isCompiled = false;
            return;
        }
        this.program = this.linkProgram(this.createProgram());
        if (this.program == -1) {
            this.isCompiled = false;
            return;
        }
        this.isCompiled = true;
    }

    private int loadShader(int n2, String string) {
        GL20 gL20 = Gdx.gl20;
        IntBuffer intBuffer = BufferUtils.newIntBuffer(1);
        int n3 = gL20.glCreateShader(n2);
        if (n3 == 0) {
            return -1;
        }
        gL20.glShaderSource(n3, string);
        gL20.glCompileShader(n3);
        gL20.glGetShaderiv(n3, 35713, intBuffer);
        int n4 = intBuffer.get(0);
        if (n4 == 0) {
            String string2 = gL20.glGetShaderInfoLog(n3);
            this.log = this.log + (n2 == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
            this.log = this.log + string2;
            return -1;
        }
        return n3;
    }

    protected int createProgram() {
        GL20 gL20 = Gdx.gl20;
        int n2 = gL20.glCreateProgram();
        return n2 != 0 ? n2 : -1;
    }

    private int linkProgram(int n2) {
        GL20 gL20 = Gdx.gl20;
        if (n2 == -1) {
            return -1;
        }
        gL20.glAttachShader(n2, this.vertexShaderHandle);
        gL20.glAttachShader(n2, this.fragmentShaderHandle);
        gL20.glLinkProgram(n2);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4);
        byteBuffer.order(ByteOrder.nativeOrder());
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        gL20.glGetProgramiv(n2, 35714, intBuffer);
        int n3 = intBuffer.get(0);
        if (n3 == 0) {
            this.log = Gdx.gl20.glGetProgramInfoLog(n2);
            return -1;
        }
        return n2;
    }

    public String getLog() {
        if (this.isCompiled) {
            this.log = Gdx.gl20.glGetProgramInfoLog(this.program);
            return this.log;
        }
        return this.log;
    }

    public boolean isCompiled() {
        return this.isCompiled;
    }

    private int fetchAttributeLocation(String string) {
        GL20 gL20 = Gdx.gl20;
        int n2 = this.attributes.get(string, -2);
        if (n2 == -2) {
            n2 = gL20.glGetAttribLocation(this.program, string);
            this.attributes.put(string, n2);
        }
        return n2;
    }

    private int fetchUniformLocation(String string) {
        return this.fetchUniformLocation(string, pedantic);
    }

    public int fetchUniformLocation(String string, boolean bl2) {
        int n2 = this.uniforms.get(string, -2);
        if (n2 == -2) {
            n2 = Gdx.gl20.glGetUniformLocation(this.program, string);
            if (n2 == -1 && bl2) {
                if (this.isCompiled) {
                    throw new IllegalArgumentException("No uniform with name '" + string + "' in shader");
                }
                throw new IllegalStateException("An attempted fetch uniform from uncompiled shader \n" + this.getLog());
            }
            this.uniforms.put(string, n2);
        }
        return n2;
    }

    public void setUniformi(String string, int n2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n3 = this.fetchUniformLocation(string);
        gL20.glUniform1i(n3, n2);
    }

    public void setUniformi(int n2, int n3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform1i(n2, n3);
    }

    public void setUniformi(String string, int n2, int n3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n4 = this.fetchUniformLocation(string);
        gL20.glUniform2i(n4, n2, n3);
    }

    public void setUniformi(int n2, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform2i(n2, n3, n4);
    }

    public void setUniformi(String string, int n2, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n5 = this.fetchUniformLocation(string);
        gL20.glUniform3i(n5, n2, n3, n4);
    }

    public void setUniformi(int n2, int n3, int n4, int n5) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform3i(n2, n3, n4, n5);
    }

    public void setUniformi(String string, int n2, int n3, int n4, int n5) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n6 = this.fetchUniformLocation(string);
        gL20.glUniform4i(n6, n2, n3, n4, n5);
    }

    public void setUniformi(int n2, int n3, int n4, int n5, int n6) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform4i(n2, n3, n4, n5, n6);
    }

    public void setUniformf(String string, float f2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n2 = this.fetchUniformLocation(string);
        gL20.glUniform1f(n2, f2);
    }

    public void setUniformf(int n2, float f2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform1f(n2, f2);
    }

    public void setUniformf(String string, float f2, float f3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n2 = this.fetchUniformLocation(string);
        gL20.glUniform2f(n2, f2, f3);
    }

    public void setUniformf(int n2, float f2, float f3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform2f(n2, f2, f3);
    }

    public void setUniformf(String string, float f2, float f3, float f4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n2 = this.fetchUniformLocation(string);
        gL20.glUniform3f(n2, f2, f3, f4);
    }

    public void setUniformf(int n2, float f2, float f3, float f4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform3f(n2, f2, f3, f4);
    }

    public void setUniformf(String string, float f2, float f3, float f4, float f5) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n2 = this.fetchUniformLocation(string);
        gL20.glUniform4f(n2, f2, f3, f4, f5);
    }

    public void setUniformf(int n2, float f2, float f3, float f4, float f5) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform4f(n2, f2, f3, f4, f5);
    }

    public void setUniform1fv(String string, float[] fArray, int n2, int n3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n4 = this.fetchUniformLocation(string);
        gL20.glUniform1fv(n4, n3, fArray, n2);
    }

    public void setUniform1fv(int n2, float[] fArray, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform1fv(n2, n4, fArray, n3);
    }

    public void setUniform2fv(String string, float[] fArray, int n2, int n3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n4 = this.fetchUniformLocation(string);
        gL20.glUniform2fv(n4, n3 / 2, fArray, n2);
    }

    public void setUniform2fv(int n2, float[] fArray, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform2fv(n2, n4 / 2, fArray, n3);
    }

    public void setUniform3fv(String string, float[] fArray, int n2, int n3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n4 = this.fetchUniformLocation(string);
        gL20.glUniform3fv(n4, n3 / 3, fArray, n2);
    }

    public void setUniform3fv(int n2, float[] fArray, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform3fv(n2, n4 / 3, fArray, n3);
    }

    public void setUniform4fv(String string, float[] fArray, int n2, int n3) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n4 = this.fetchUniformLocation(string);
        gL20.glUniform4fv(n4, n3 / 4, fArray, n2);
    }

    public void setUniform4fv(int n2, float[] fArray, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniform4fv(n2, n4 / 4, fArray, n3);
    }

    public void setUniformMatrix(String string, Matrix4 matrix4) {
        this.setUniformMatrix(string, matrix4, false);
    }

    public void setUniformMatrix(String string, Matrix4 matrix4, boolean bl2) {
        this.setUniformMatrix(this.fetchUniformLocation(string), matrix4, bl2);
    }

    public void setUniformMatrix(int n2, Matrix4 matrix4) {
        this.setUniformMatrix(n2, matrix4, false);
    }

    public void setUniformMatrix(int n2, Matrix4 matrix4, boolean bl2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniformMatrix4fv(n2, 1, bl2, matrix4.val, 0);
    }

    public void setUniformMatrix(String string, Matrix3 matrix3) {
        this.setUniformMatrix(string, matrix3, false);
    }

    public void setUniformMatrix(String string, Matrix3 matrix3, boolean bl2) {
        this.setUniformMatrix(this.fetchUniformLocation(string), matrix3, bl2);
    }

    public void setUniformMatrix(int n2, Matrix3 matrix3) {
        this.setUniformMatrix(n2, matrix3, false);
    }

    public void setUniformMatrix(int n2, Matrix3 matrix3, boolean bl2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniformMatrix3fv(n2, 1, bl2, matrix3.val, 0);
    }

    public void setUniformMatrix3fv(String string, FloatBuffer floatBuffer, int n2, boolean bl2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        ((Buffer)floatBuffer).position(0);
        int n3 = this.fetchUniformLocation(string);
        gL20.glUniformMatrix3fv(n3, n2, bl2, floatBuffer);
    }

    public void setUniformMatrix4fv(String string, FloatBuffer floatBuffer, int n2, boolean bl2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        ((Buffer)floatBuffer).position(0);
        int n3 = this.fetchUniformLocation(string);
        gL20.glUniformMatrix4fv(n3, n2, bl2, floatBuffer);
    }

    public void setUniformMatrix4fv(int n2, float[] fArray, int n3, int n4) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUniformMatrix4fv(n2, n4 / 16, false, fArray, n3);
    }

    public void setUniformMatrix4fv(String string, float[] fArray, int n2, int n3) {
        this.setUniformMatrix4fv(this.fetchUniformLocation(string), fArray, n2, n3);
    }

    public void setUniformf(String string, Vector2 vector2) {
        this.setUniformf(string, vector2.x, vector2.y);
    }

    public void setUniformf(int n2, Vector2 vector2) {
        this.setUniformf(n2, vector2.x, vector2.y);
    }

    public void setUniformf(String string, Vector3 vector3) {
        this.setUniformf(string, vector3.x, vector3.y, vector3.z);
    }

    public void setUniformf(int n2, Vector3 vector3) {
        this.setUniformf(n2, vector3.x, vector3.y, vector3.z);
    }

    public void setUniformf(String string, Color color) {
        this.setUniformf(string, color.r, color.g, color.b, color.a);
    }

    public void setUniformf(int n2, Color color) {
        this.setUniformf(n2, color.r, color.g, color.b, color.a);
    }

    public void setVertexAttribute(String string, int n2, int n3, boolean bl2, int n4, Buffer buffer) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n5 = this.fetchAttributeLocation(string);
        if (n5 == -1) {
            return;
        }
        gL20.glVertexAttribPointer(n5, n2, n3, bl2, n4, buffer);
    }

    public void setVertexAttribute(int n2, int n3, int n4, boolean bl2, int n5, Buffer buffer) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, buffer);
    }

    public void setVertexAttribute(String string, int n2, int n3, boolean bl2, int n4, int n5) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n6 = this.fetchAttributeLocation(string);
        if (n6 == -1) {
            return;
        }
        gL20.glVertexAttribPointer(n6, n2, n3, bl2, n4, n5);
    }

    public void setVertexAttribute(int n2, int n3, int n4, boolean bl2, int n5, int n6) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glVertexAttribPointer(n2, n3, n4, bl2, n5, n6);
    }

    @Deprecated
    public void begin() {
        this.bind();
    }

    public void bind() {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glUseProgram(this.program);
    }

    @Deprecated
    public void end() {
    }

    @Override
    public void dispose() {
        GL20 gL20 = Gdx.gl20;
        gL20.glUseProgram(0);
        gL20.glDeleteShader(this.vertexShaderHandle);
        gL20.glDeleteShader(this.fragmentShaderHandle);
        gL20.glDeleteProgram(this.program);
        if (shaders.get(Gdx.app) != null) {
            shaders.get(Gdx.app).removeValue(this, true);
        }
    }

    public void disableVertexAttribute(String string) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n2 = this.fetchAttributeLocation(string);
        if (n2 == -1) {
            return;
        }
        gL20.glDisableVertexAttribArray(n2);
    }

    public void disableVertexAttribute(int n2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glDisableVertexAttribArray(n2);
    }

    public void enableVertexAttribute(String string) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        int n2 = this.fetchAttributeLocation(string);
        if (n2 == -1) {
            return;
        }
        gL20.glEnableVertexAttribArray(n2);
    }

    public void enableVertexAttribute(int n2) {
        GL20 gL20 = Gdx.gl20;
        this.checkManaged();
        gL20.glEnableVertexAttribArray(n2);
    }

    private void checkManaged() {
        if (this.invalidated) {
            this.compileShaders(this.vertexShaderSource, this.fragmentShaderSource);
            this.invalidated = false;
        }
    }

    private void addManagedShader(Application application, ShaderProgram shaderProgram) {
        Array<ShaderProgram> array = shaders.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(shaderProgram);
        shaders.put(application, array);
    }

    public static void invalidateAllShaderPrograms(Application application) {
        if (Gdx.gl20 == null) {
            return;
        }
        Array<ShaderProgram> array = shaders.get(application);
        if (array == null) {
            return;
        }
        for (int i2 = 0; i2 < array.size; ++i2) {
            array.get((int)i2).invalidated = true;
            array.get(i2).checkManaged();
        }
    }

    public static void clearAllShaderPrograms(Application application) {
        shaders.remove(application);
    }

    public static String getManagedStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = false;
        stringBuilder.append("Managed shaders/app: { ");
        for (Application application : shaders.keys()) {
            stringBuilder.append(ShaderProgram.shaders.get(application).size);
            stringBuilder.append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int getNumManagedShaderPrograms() {
        return ShaderProgram.shaders.get(Gdx.app).size;
    }

    public void setAttributef(String string, float f2, float f3, float f4, float f5) {
        GL20 gL20 = Gdx.gl20;
        int n2 = this.fetchAttributeLocation(string);
        gL20.glVertexAttrib4f(n2, f2, f3, f4, f5);
    }

    private void fetchUniforms() {
        ((Buffer)this.params).clear();
        Gdx.gl20.glGetProgramiv(this.program, 35718, this.params);
        int n2 = this.params.get(0);
        this.uniformNames = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            ((Buffer)this.params).clear();
            this.params.put(0, 1);
            ((Buffer)this.type).clear();
            String string = Gdx.gl20.glGetActiveUniform(this.program, i2, this.params, this.type);
            int n3 = Gdx.gl20.glGetUniformLocation(this.program, string);
            this.uniforms.put(string, n3);
            this.uniformTypes.put(string, this.type.get(0));
            this.uniformSizes.put(string, this.params.get(0));
            this.uniformNames[i2] = string;
        }
    }

    private void fetchAttributes() {
        ((Buffer)this.params).clear();
        Gdx.gl20.glGetProgramiv(this.program, 35721, this.params);
        int n2 = this.params.get(0);
        this.attributeNames = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            ((Buffer)this.params).clear();
            this.params.put(0, 1);
            ((Buffer)this.type).clear();
            String string = Gdx.gl20.glGetActiveAttrib(this.program, i2, this.params, this.type);
            int n3 = Gdx.gl20.glGetAttribLocation(this.program, string);
            this.attributes.put(string, n3);
            this.attributeTypes.put(string, this.type.get(0));
            this.attributeSizes.put(string, this.params.get(0));
            this.attributeNames[i2] = string;
        }
    }

    public boolean hasAttribute(String string) {
        return this.attributes.containsKey(string);
    }

    public int getAttributeType(String string) {
        return this.attributeTypes.get(string, 0);
    }

    public int getAttributeLocation(String string) {
        return this.attributes.get(string, -1);
    }

    public int getAttributeSize(String string) {
        return this.attributeSizes.get(string, 0);
    }

    public boolean hasUniform(String string) {
        return this.uniforms.containsKey(string);
    }

    public int getUniformType(String string) {
        return this.uniformTypes.get(string, 0);
    }

    public int getUniformLocation(String string) {
        return this.uniforms.get(string, -1);
    }

    public int getUniformSize(String string) {
        return this.uniformSizes.get(string, 0);
    }

    public String[] getAttributes() {
        return this.attributeNames;
    }

    public String[] getUniforms() {
        return this.uniformNames;
    }

    public String getVertexShaderSource() {
        return this.vertexShaderSource;
    }

    public String getFragmentShaderSource() {
        return this.fragmentShaderSource;
    }

    public int getHandle() {
        return this.program;
    }
}

