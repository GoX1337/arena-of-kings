/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Map;

public class Texture
extends GLTexture {
    private static AssetManager assetManager;
    static final Map<Application, Array<Texture>> managedTextures;
    TextureData data;

    public Texture(String string) {
        this(Gdx.files.internal(string));
    }

    public Texture(FileHandle fileHandle) {
        this(fileHandle, null, false);
    }

    public Texture(FileHandle fileHandle, boolean bl2) {
        this(fileHandle, null, bl2);
    }

    public Texture(FileHandle fileHandle, Pixmap.Format format, boolean bl2) {
        this(TextureData.Factory.loadFromFile(fileHandle, format, bl2));
    }

    public Texture(Pixmap pixmap) {
        this(new PixmapTextureData(pixmap, null, false, false));
    }

    public Texture(Pixmap pixmap, boolean bl2) {
        this(new PixmapTextureData(pixmap, null, bl2, false));
    }

    public Texture(Pixmap pixmap, Pixmap.Format format, boolean bl2) {
        this(new PixmapTextureData(pixmap, format, bl2, false));
    }

    public Texture(int n2, int n3, Pixmap.Format format) {
        this(new PixmapTextureData(new Pixmap(n2, n3, format), null, false, true));
    }

    public Texture(TextureData textureData) {
        this(3553, Gdx.gl.glGenTexture(), textureData);
    }

    protected Texture(int n2, int n3, TextureData textureData) {
        super(n2, n3);
        this.load(textureData);
        if (textureData.isManaged()) {
            Texture.addManagedTexture(Gdx.app, this);
        }
    }

    public void load(TextureData textureData) {
        if (this.data != null && textureData.isManaged() != this.data.isManaged()) {
            throw new GdxRuntimeException("New data must have the same managed status as the old data");
        }
        this.data = textureData;
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        this.bind();
        Texture.uploadImageData(3553, textureData);
        this.unsafeSetFilter(this.minFilter, this.magFilter, true);
        this.unsafeSetWrap(this.uWrap, this.vWrap, true);
        this.unsafeSetAnisotropicFilter(this.anisotropicFilterLevel, true);
        Gdx.gl.glBindTexture(this.glTarget, 0);
    }

    @Override
    protected void reload() {
        if (!this.isManaged()) {
            throw new GdxRuntimeException("Tried to reload unmanaged Texture");
        }
        this.glHandle = Gdx.gl.glGenTexture();
        this.load(this.data);
    }

    public void draw(Pixmap pixmap, int n2, int n3) {
        if (this.data.isManaged()) {
            throw new GdxRuntimeException("can't draw to a managed texture");
        }
        this.bind();
        Gdx.gl.glTexSubImage2D(this.glTarget, 0, n2, n3, pixmap.getWidth(), pixmap.getHeight(), pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
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

    public TextureData getTextureData() {
        return this.data;
    }

    @Override
    public boolean isManaged() {
        return this.data.isManaged();
    }

    @Override
    public void dispose() {
        if (this.glHandle == 0) {
            return;
        }
        this.delete();
        if (this.data.isManaged() && managedTextures.get(Gdx.app) != null) {
            managedTextures.get(Gdx.app).removeValue(this, true);
        }
    }

    public String toString() {
        if (this.data instanceof FileTextureData) {
            return this.data.toString();
        }
        return super.toString();
    }

    private static void addManagedTexture(Application application, Texture texture) {
        Array<Texture> array = managedTextures.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(texture);
        managedTextures.put(application, array);
    }

    public static void clearAllTextures(Application application) {
        managedTextures.remove(application);
    }

    public static void invalidateAllTextures(Application application) {
        Array<Texture> array = managedTextures.get(application);
        if (array == null) {
            return;
        }
        if (assetManager == null) {
            for (int i2 = 0; i2 < array.size; ++i2) {
                Texture texture = array.get(i2);
                texture.reload();
            }
        } else {
            assetManager.finishLoading();
            Array<Texture> array2 = new Array<Texture>(array);
            for (Texture texture : array2) {
                String string = assetManager.getAssetFileName(texture);
                if (string == null) {
                    texture.reload();
                    continue;
                }
                final int n2 = assetManager.getReferenceCount(string);
                assetManager.setReferenceCount(string, 0);
                texture.glHandle = 0;
                TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
                textureParameter.textureData = texture.getTextureData();
                textureParameter.minFilter = texture.getMinFilter();
                textureParameter.magFilter = texture.getMagFilter();
                textureParameter.wrapU = texture.getUWrap();
                textureParameter.wrapV = texture.getVWrap();
                textureParameter.genMipMaps = texture.data.useMipMaps();
                textureParameter.texture = texture;
                textureParameter.loadedCallback = new AssetLoaderParameters.LoadedCallback(){

                    @Override
                    public void finishedLoading(AssetManager assetManager, String string, Class clazz) {
                        assetManager.setReferenceCount(string, n2);
                    }
                };
                assetManager.unload(string);
                texture.glHandle = Gdx.gl.glGenTexture();
                assetManager.load(string, Texture.class, textureParameter);
            }
            array.clear();
            array.addAll(array2);
        }
    }

    public static void setAssetManager(AssetManager assetManager) {
        Texture.assetManager = assetManager;
    }

    public static String getManagedStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Managed textures/app: { ");
        for (Application application : managedTextures.keySet()) {
            stringBuilder.append(Texture.managedTextures.get((Object)application).size);
            stringBuilder.append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int getNumManagedTextures() {
        return Texture.managedTextures.get((Object)Gdx.app).size;
    }

    static {
        managedTextures = new HashMap<Application, Array<Texture>>();
    }

    public static enum TextureWrap {
        MirroredRepeat(33648),
        ClampToEdge(33071),
        Repeat(10497);

        final int glEnum;

        private TextureWrap(int n3) {
            this.glEnum = n3;
        }

        public int getGLEnum() {
            return this.glEnum;
        }
    }

    public static enum TextureFilter {
        Nearest(9728),
        Linear(9729),
        MipMap(9987),
        MipMapNearestNearest(9984),
        MipMapLinearNearest(9985),
        MipMapNearestLinear(9986),
        MipMapLinearLinear(9987);

        final int glEnum;

        private TextureFilter(int n3) {
            this.glEnum = n3;
        }

        public boolean isMipMap() {
            return this.glEnum != 9728 && this.glEnum != 9729;
        }

        public int getGLEnum() {
            return this.glEnum;
        }
    }
}

