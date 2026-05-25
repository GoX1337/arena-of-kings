/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.shaders.DepthShader;
import com.badlogic.gdx.graphics.g3d.utils.BaseShaderProvider;

public class DepthShaderProvider
extends BaseShaderProvider {
    public final DepthShader.Config config;

    public DepthShaderProvider(DepthShader.Config config) {
        this.config = config == null ? new DepthShader.Config() : config;
    }

    public DepthShaderProvider(String string, String string2) {
        this(new DepthShader.Config(string, string2));
    }

    public DepthShaderProvider(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle.readString(), fileHandle2.readString());
    }

    public DepthShaderProvider() {
        this(null);
    }

    @Override
    protected Shader createShader(Renderable renderable) {
        return new DepthShader(renderable, this.config);
    }
}

