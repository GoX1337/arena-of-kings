/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.CubemapLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.FacedCubemapData;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Map;

public class Cubemap
extends GLTexture {
    private static AssetManager assetManager;
    static final Map<Application, Array<Cubemap>> managedCubemaps;
    protected CubemapData data;

    public Cubemap(CubemapData cubemapData) {
        super(34067);
        this.data = cubemapData;
        this.load(cubemapData);
        if (cubemapData.isManaged()) {
            Cubemap.addManagedCubemap(Gdx.app, this);
        }
    }

    public Cubemap(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6) {
        this(fileHandle, fileHandle2, fileHandle3, fileHandle4, fileHandle5, fileHandle6, false);
    }

    public Cubemap(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6, boolean bl2) {
        this(TextureData.Factory.loadFromFile(fileHandle, bl2), TextureData.Factory.loadFromFile(fileHandle2, bl2), TextureData.Factory.loadFromFile(fileHandle3, bl2), TextureData.Factory.loadFromFile(fileHandle4, bl2), TextureData.Factory.loadFromFile(fileHandle5, bl2), TextureData.Factory.loadFromFile(fileHandle6, bl2));
    }

    public Cubemap(Pixmap pixmap, Pixmap pixmap2, Pixmap pixmap3, Pixmap pixmap4, Pixmap pixmap5, Pixmap pixmap6) {
        this(pixmap, pixmap2, pixmap3, pixmap4, pixmap5, pixmap6, false);
    }

    public Cubemap(Pixmap pixmap, Pixmap pixmap2, Pixmap pixmap3, Pixmap pixmap4, Pixmap pixmap5, Pixmap pixmap6, boolean bl2) {
        this(pixmap == null ? null : new PixmapTextureData(pixmap, null, bl2, false), pixmap2 == null ? null : new PixmapTextureData(pixmap2, null, bl2, false), pixmap3 == null ? null : new PixmapTextureData(pixmap3, null, bl2, false), pixmap4 == null ? null : new PixmapTextureData(pixmap4, null, bl2, false), pixmap5 == null ? null : new PixmapTextureData(pixmap5, null, bl2, false), pixmap6 == null ? null : new PixmapTextureData(pixmap6, null, bl2, false));
    }

    public Cubemap(int n2, int n3, int n4, Pixmap.Format format) {
        this(new PixmapTextureData(new Pixmap(n4, n3, format), null, false, true), new PixmapTextureData(new Pixmap(n4, n3, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n4, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n4, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n3, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n3, format), null, false, true));
    }

    public Cubemap(TextureData textureData, TextureData textureData2, TextureData textureData3, TextureData textureData4, TextureData textureData5, TextureData textureData6) {
        this(new FacedCubemapData(textureData, textureData2, textureData3, textureData4, textureData5, textureData6));
    }

    public void load(CubemapData cubemapData) {
        if (!cubemapData.isPrepared()) {
            cubemapData.prepare();
        }
        this.bind();
        this.unsafeSetFilter(this.minFilter, this.magFilter, true);
        this.unsafeSetWrap(this.uWrap, this.vWrap, true);
        this.unsafeSetAnisotropicFilter(this.anisotropicFilterLevel, true);
        cubemapData.consumeCubemapData();
        Gdx.gl.glBindTexture(this.glTarget, 0);
    }

    public CubemapData getCubemapData() {
        return this.data;
    }

    @Override
    public boolean isManaged() {
        return this.data.isManaged();
    }

    @Override
    protected void reload() {
        if (!this.isManaged()) {
            throw new GdxRuntimeException("Tried to reload an unmanaged Cubemap");
        }
        this.glHandle = Gdx.gl.glGenTexture();
        this.load(this.data);
    }

    @Override
    public int getWidth() {
        return this.data.getWidth();
    }

    @Override
    public int getHeight() {
        return this.data.getHeight();
    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public void dispose() {
        if (this.glHandle == 0) {
            return;
        }
        this.delete();
        if (this.data.isManaged() && managedCubemaps.get(Gdx.app) != null) {
            managedCubemaps.get(Gdx.app).removeValue(this, true);
        }
    }

    private static void addManagedCubemap(Application application, Cubemap cubemap) {
        Array<Cubemap> array = managedCubemaps.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(cubemap);
        managedCubemaps.put(application, array);
    }

    public static void clearAllCubemaps(Application application) {
        managedCubemaps.remove(application);
    }

    public static void invalidateAllCubemaps(Application application) {
        Array<Cubemap> array = managedCubemaps.get(application);
        if (array == null) {
            return;
        }
        if (assetManager == null) {
            for (int i2 = 0; i2 < array.size; ++i2) {
                Cubemap cubemap = array.get(i2);
                cubemap.reload();
            }
        } else {
            assetManager.finishLoading();
            Array<Cubemap> array2 = new Array<Cubemap>(array);
            for (Cubemap cubemap : array2) {
                String string = assetManager.getAssetFileName(cubemap);
                if (string == null) {
                    cubemap.reload();
                    continue;
                }
                final int n2 = assetManager.getReferenceCount(string);
                assetManager.setReferenceCount(string, 0);
                cubemap.glHandle = 0;
                CubemapLoader.CubemapParameter cubemapParameter = new CubemapLoader.CubemapParameter();
                cubemapParameter.cubemapData = cubemap.getCubemapData();
                cubemapParameter.minFilter = cubemap.getMinFilter();
                cubemapParameter.magFilter = cubemap.getMagFilter();
                cubemapParameter.wrapU = cubemap.getUWrap();
                cubemapParameter.wrapV = cubemap.getVWrap();
                cubemapParameter.cubemap = cubemap;
                cubemapParameter.loadedCallback = new AssetLoaderParameters.LoadedCallback(){

                    @Override
                    public void finishedLoading(AssetManager assetManager, String string, Class clazz) {
                        assetManager.setReferenceCount(string, n2);
                    }
                };
                assetManager.unload(string);
                cubemap.glHandle = Gdx.gl.glGenTexture();
                assetManager.load(string, Cubemap.class, cubemapParameter);
            }
            array.clear();
            array.addAll(array2);
        }
    }

    public static void setAssetManager(AssetManager assetManager) {
        Cubemap.assetManager = assetManager;
    }

    public static String getManagedStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Managed cubemap/app: { ");
        for (Application application : managedCubemaps.keySet()) {
            stringBuilder.append(Cubemap.managedCubemaps.get((Object)application).size);
            stringBuilder.append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int getNumManagedCubemaps() {
        return Cubemap.managedCubemaps.get((Object)Gdx.app).size;
    }

    static {
        managedCubemaps = new HashMap<Application, Array<Cubemap>>();
    }

    public static enum CubemapSide {
        PositiveX(0, 34069, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f),
        NegativeX(1, 34070, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f),
        PositiveY(2, 34071, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f),
        NegativeY(3, 34072, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f),
        PositiveZ(4, 34073, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f),
        NegativeZ(5, 34074, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f);

        public final int index;
        public final int glEnum;
        public final Vector3 up;
        public final Vector3 direction;

        private CubemapSide(int n3, int n4, float f2, float f3, float f4, float f5, float f6, float f7) {
            this.index = n3;
            this.glEnum = n4;
            this.up = new Vector3(f2, f3, f4);
            this.direction = new Vector3(f5, f6, f7);
        }

        public int getGLEnum() {
            return this.glEnum;
        }

        public Vector3 getUp(Vector3 vector3) {
            return vector3.set(this.up);
        }

        public Vector3 getDirection(Vector3 vector3) {
            return vector3.set(this.direction);
        }
    }
}

