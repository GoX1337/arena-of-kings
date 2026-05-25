/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;

public class DistanceFieldFont
extends BitmapFont {
    private float distanceFieldSmoothing;

    public DistanceFieldFont(BitmapFont.BitmapFontData bitmapFontData, Array<TextureRegion> array, boolean bl2) {
        super(bitmapFontData, array, bl2);
    }

    public DistanceFieldFont(BitmapFont.BitmapFontData bitmapFontData, TextureRegion textureRegion, boolean bl2) {
        super(bitmapFontData, textureRegion, bl2);
    }

    public DistanceFieldFont(FileHandle fileHandle, boolean bl2) {
        super(fileHandle, bl2);
    }

    public DistanceFieldFont(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2, boolean bl3) {
        super(fileHandle, fileHandle2, bl2, bl3);
    }

    public DistanceFieldFont(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2) {
        super(fileHandle, fileHandle2, bl2);
    }

    public DistanceFieldFont(FileHandle fileHandle, TextureRegion textureRegion, boolean bl2) {
        super(fileHandle, textureRegion, bl2);
    }

    public DistanceFieldFont(FileHandle fileHandle, TextureRegion textureRegion) {
        super(fileHandle, textureRegion);
    }

    public DistanceFieldFont(FileHandle fileHandle) {
        super(fileHandle);
    }

    @Override
    protected void load(BitmapFont.BitmapFontData bitmapFontData) {
        super.load(bitmapFontData);
        Array<TextureRegion> array = this.getRegions();
        for (TextureRegion textureRegion : array) {
            textureRegion.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
    }

    @Override
    public BitmapFontCache newFontCache() {
        return new DistanceFieldFontCache(this, this.integer);
    }

    public float getDistanceFieldSmoothing() {
        return this.distanceFieldSmoothing;
    }

    public void setDistanceFieldSmoothing(float f2) {
        this.distanceFieldSmoothing = f2;
    }

    public static ShaderProgram createDistanceFieldShader() {
        String string = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tv_color = a_color;\n\tv_color.a = v_color.a * (255.0/254.0);\n\tv_texCoords = a_texCoord0;\n\tgl_Position =  u_projTrans * a_position;\n}\n";
        String string2 = "#ifdef GL_ES\n\tprecision mediump float;\n\tprecision mediump int;\n#endif\n\nuniform sampler2D u_texture;\nuniform float u_smoothing;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tif (u_smoothing > 0.0) {\n\t\tfloat smoothing = 0.25 / u_smoothing;\n\t\tfloat distance = texture2D(u_texture, v_texCoords).a;\n\t\tfloat alpha = smoothstep(0.5 - smoothing, 0.5 + smoothing, distance);\n\t\tgl_FragColor = vec4(v_color.rgb, alpha * v_color.a);\n\t} else {\n\t\tgl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n\t}\n}\n";
        ShaderProgram shaderProgram = new ShaderProgram(string, string2);
        if (!shaderProgram.isCompiled()) {
            throw new IllegalArgumentException("Error compiling distance field shader: " + shaderProgram.getLog());
        }
        return shaderProgram;
    }

    static class DistanceFieldFontCache
    extends BitmapFontCache {
        public DistanceFieldFontCache(DistanceFieldFont distanceFieldFont) {
            super(distanceFieldFont, distanceFieldFont.usesIntegerPositions());
        }

        public DistanceFieldFontCache(DistanceFieldFont distanceFieldFont, boolean bl2) {
            super(distanceFieldFont, bl2);
        }

        private float getSmoothingFactor() {
            DistanceFieldFont distanceFieldFont = (DistanceFieldFont)super.getFont();
            return distanceFieldFont.getDistanceFieldSmoothing() * distanceFieldFont.getScaleX();
        }

        private void setSmoothingUniform(Batch batch, float f2) {
            batch.flush();
            batch.getShader().setUniformf("u_smoothing", f2);
        }

        @Override
        public void draw(Batch batch) {
            this.setSmoothingUniform(batch, this.getSmoothingFactor());
            super.draw(batch);
            this.setSmoothingUniform(batch, 0.0f);
        }

        @Override
        public void draw(Batch batch, int n2, int n3) {
            this.setSmoothingUniform(batch, this.getSmoothingFactor());
            super.draw(batch, n2, n3);
            this.setSmoothingUniform(batch, 0.0f);
        }
    }
}

