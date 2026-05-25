/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class BaseShaderProvider
implements ShaderProvider {
    protected Array<Shader> shaders = new Array();

    @Override
    public Shader getShader(Renderable renderable) {
        Shader shader = renderable.shader;
        if (shader != null && shader.canRender(renderable)) {
            return shader;
        }
        for (Shader shader2 : this.shaders) {
            if (!shader2.canRender(renderable)) continue;
            return shader2;
        }
        Shader shader3 = this.createShader(renderable);
        if (!shader3.canRender(renderable)) {
            throw new GdxRuntimeException("unable to provide a shader for this renderable");
        }
        shader3.init();
        this.shaders.add(shader3);
        return shader3;
    }

    protected abstract Shader createShader(Renderable var1);

    @Override
    public void dispose() {
        for (Shader shader : this.shaders) {
            shader.dispose();
        }
        this.shaders.clear();
    }
}

