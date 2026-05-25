/*
 * Decompiled with CFR 0.152.
 */
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class axu {
    static String var_java_lang_String_a;
    static String b;
    public static ShaderProgram var_com_badlogic_gdx_graphics_glutils_ShaderProgram_a;

    static {
        var_java_lang_String_a = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}";
        b = "#ifdef GL_ES\n    precision mediump float;\n#endif\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\n\nvoid main() {\n  vec4 c = v_color * texture2D(u_texture, v_texCoords);\n  float grey = (c.r + c.g + c.b) / 5.0;\n  gl_FragColor = vec4(c.r, grey, grey, c.a);\n}";
        var_com_badlogic_gdx_graphics_glutils_ShaderProgram_a = new axv(var_java_lang_String_a, b);
    }
}

