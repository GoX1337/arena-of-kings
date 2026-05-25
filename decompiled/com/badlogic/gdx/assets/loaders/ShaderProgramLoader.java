/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;

public class ShaderProgramLoader
extends AsynchronousAssetLoader<ShaderProgram, ShaderProgramParameter> {
    private String vertexFileSuffix = ".vert";
    private String fragmentFileSuffix = ".frag";

    public ShaderProgramLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public ShaderProgramLoader(FileHandleResolver fileHandleResolver, String string, String string2) {
        super(fileHandleResolver);
        this.vertexFileSuffix = string;
        this.fragmentFileSuffix = string2;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, ShaderProgramParameter shaderProgramParameter) {
        return null;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, ShaderProgramParameter shaderProgramParameter) {
    }

    @Override
    public ShaderProgram loadSync(AssetManager assetManager, String string, FileHandle fileHandle, ShaderProgramParameter shaderProgramParameter) {
        String string2;
        String string3 = null;
        String string4 = null;
        if (shaderProgramParameter != null) {
            if (shaderProgramParameter.vertexFile != null) {
                string3 = shaderProgramParameter.vertexFile;
            }
            if (shaderProgramParameter.fragmentFile != null) {
                string4 = shaderProgramParameter.fragmentFile;
            }
        }
        if (string3 == null && string.endsWith(this.fragmentFileSuffix)) {
            string3 = string.substring(0, string.length() - this.fragmentFileSuffix.length()) + this.vertexFileSuffix;
        }
        if (string4 == null && string.endsWith(this.vertexFileSuffix)) {
            string4 = string.substring(0, string.length() - this.vertexFileSuffix.length()) + this.fragmentFileSuffix;
        }
        FileHandle fileHandle2 = string3 == null ? fileHandle : this.resolve(string3);
        FileHandle fileHandle3 = string4 == null ? fileHandle : this.resolve(string4);
        String string5 = fileHandle2.readString();
        String string6 = string2 = fileHandle2.equals(fileHandle3) ? string5 : fileHandle3.readString();
        if (shaderProgramParameter != null) {
            if (shaderProgramParameter.prependVertexCode != null) {
                string5 = shaderProgramParameter.prependVertexCode + string5;
            }
            if (shaderProgramParameter.prependFragmentCode != null) {
                string2 = shaderProgramParameter.prependFragmentCode + string2;
            }
        }
        ShaderProgram shaderProgram = new ShaderProgram(string5, string2);
        if ((shaderProgramParameter == null || shaderProgramParameter.logOnCompileFailure) && !shaderProgram.isCompiled()) {
            assetManager.getLogger().error("ShaderProgram " + string + " failed to compile:\n" + shaderProgram.getLog());
        }
        return shaderProgram;
    }

    public static class ShaderProgramParameter
    extends AssetLoaderParameters<ShaderProgram> {
        public String vertexFile;
        public String fragmentFile;
        public boolean logOnCompileFailure = true;
        public String prependVertexCode;
        public String prependFragmentCode;
    }
}

