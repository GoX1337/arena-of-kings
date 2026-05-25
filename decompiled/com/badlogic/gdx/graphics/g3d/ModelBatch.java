/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.DefaultRenderableSorter;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.DefaultTextureBinder;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.FlushablePool;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ModelBatch
implements Disposable {
    protected Camera camera;
    protected final RenderablePool renderablesPool = new RenderablePool();
    protected final Array<Renderable> renderables = new Array();
    protected final RenderContext context;
    private final boolean ownContext;
    protected final ShaderProvider shaderProvider;
    protected final RenderableSorter sorter;

    public ModelBatch(RenderContext renderContext, ShaderProvider shaderProvider, RenderableSorter renderableSorter) {
        this.sorter = renderableSorter == null ? new DefaultRenderableSorter() : renderableSorter;
        this.ownContext = renderContext == null;
        this.context = renderContext == null ? new RenderContext(new DefaultTextureBinder(1, 1)) : renderContext;
        this.shaderProvider = shaderProvider == null ? new DefaultShaderProvider() : shaderProvider;
    }

    public ModelBatch(RenderContext renderContext, ShaderProvider shaderProvider) {
        this(renderContext, shaderProvider, null);
    }

    public ModelBatch(RenderContext renderContext, RenderableSorter renderableSorter) {
        this(renderContext, null, renderableSorter);
    }

    public ModelBatch(RenderContext renderContext) {
        this(renderContext, null, null);
    }

    public ModelBatch(ShaderProvider shaderProvider, RenderableSorter renderableSorter) {
        this(null, shaderProvider, renderableSorter);
    }

    public ModelBatch(RenderableSorter renderableSorter) {
        this(null, null, renderableSorter);
    }

    public ModelBatch(ShaderProvider shaderProvider) {
        this(null, shaderProvider, null);
    }

    public ModelBatch(FileHandle fileHandle, FileHandle fileHandle2) {
        this(null, new DefaultShaderProvider(fileHandle, fileHandle2), null);
    }

    public ModelBatch(String string, String string2) {
        this(null, new DefaultShaderProvider(string, string2), null);
    }

    public ModelBatch() {
        this(null, null, null);
    }

    public void begin(Camera camera) {
        if (this.camera != null) {
            throw new GdxRuntimeException("Call end() first.");
        }
        this.camera = camera;
        if (this.ownContext) {
            this.context.begin();
        }
    }

    public void setCamera(Camera camera) {
        if (this.camera == null) {
            throw new GdxRuntimeException("Call begin() first.");
        }
        if (this.renderables.size > 0) {
            this.flush();
        }
        this.camera = camera;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public boolean ownsRenderContext() {
        return this.ownContext;
    }

    public RenderContext getRenderContext() {
        return this.context;
    }

    public ShaderProvider getShaderProvider() {
        return this.shaderProvider;
    }

    public RenderableSorter getRenderableSorter() {
        return this.sorter;
    }

    public void flush() {
        this.sorter.sort(this.camera, this.renderables);
        Shader shader = null;
        for (int i2 = 0; i2 < this.renderables.size; ++i2) {
            Renderable renderable = this.renderables.get(i2);
            if (shader != renderable.shader) {
                if (shader != null) {
                    shader.end();
                }
                shader = renderable.shader;
                shader.begin(this.camera, this.context);
            }
            shader.render(renderable);
        }
        if (shader != null) {
            shader.end();
        }
        this.renderablesPool.flush();
        this.renderables.clear();
    }

    public void end() {
        this.flush();
        if (this.ownContext) {
            this.context.end();
        }
        this.camera = null;
    }

    public void render(Renderable renderable) {
        renderable.shader = this.shaderProvider.getShader(renderable);
        this.renderables.add(renderable);
    }

    public void render(RenderableProvider renderableProvider) {
        int n2 = this.renderables.size;
        renderableProvider.getRenderables(this.renderables, this.renderablesPool);
        for (int i2 = n2; i2 < this.renderables.size; ++i2) {
            Renderable renderable = this.renderables.get(i2);
            renderable.shader = this.shaderProvider.getShader(renderable);
        }
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable) {
        for (RenderableProvider renderableProvider : iterable) {
            this.render(renderableProvider);
        }
    }

    public void render(RenderableProvider renderableProvider, Environment environment) {
        int n2 = this.renderables.size;
        renderableProvider.getRenderables(this.renderables, this.renderablesPool);
        for (int i2 = n2; i2 < this.renderables.size; ++i2) {
            Renderable renderable = this.renderables.get(i2);
            renderable.environment = environment;
            renderable.shader = this.shaderProvider.getShader(renderable);
        }
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable, Environment environment) {
        for (RenderableProvider renderableProvider : iterable) {
            this.render(renderableProvider, environment);
        }
    }

    public void render(RenderableProvider renderableProvider, Shader shader) {
        int n2 = this.renderables.size;
        renderableProvider.getRenderables(this.renderables, this.renderablesPool);
        for (int i2 = n2; i2 < this.renderables.size; ++i2) {
            Renderable renderable = this.renderables.get(i2);
            renderable.shader = shader;
            renderable.shader = this.shaderProvider.getShader(renderable);
        }
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable, Shader shader) {
        for (RenderableProvider renderableProvider : iterable) {
            this.render(renderableProvider, shader);
        }
    }

    public void render(RenderableProvider renderableProvider, Environment environment, Shader shader) {
        int n2 = this.renderables.size;
        renderableProvider.getRenderables(this.renderables, this.renderablesPool);
        for (int i2 = n2; i2 < this.renderables.size; ++i2) {
            Renderable renderable = this.renderables.get(i2);
            renderable.environment = environment;
            renderable.shader = shader;
            renderable.shader = this.shaderProvider.getShader(renderable);
        }
    }

    public <T extends RenderableProvider> void render(Iterable<T> iterable, Environment environment, Shader shader) {
        for (RenderableProvider renderableProvider : iterable) {
            this.render(renderableProvider, environment, shader);
        }
    }

    @Override
    public void dispose() {
        this.shaderProvider.dispose();
    }

    protected static class RenderablePool
    extends FlushablePool<Renderable> {
        protected RenderablePool() {
        }

        @Override
        protected Renderable newObject() {
            return new Renderable();
        }

        @Override
        public Renderable obtain() {
            Renderable renderable = (Renderable)super.obtain();
            renderable.environment = null;
            renderable.material = null;
            renderable.meshPart.set("", null, 0, 0, 0);
            renderable.shader = null;
            renderable.userData = null;
            return renderable;
        }
    }
}

