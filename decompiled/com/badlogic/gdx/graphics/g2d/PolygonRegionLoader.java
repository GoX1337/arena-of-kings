/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.IOException;

public class PolygonRegionLoader
extends SynchronousAssetLoader<PolygonRegion, PolygonRegionParameters> {
    private PolygonRegionParameters defaultParameters = new PolygonRegionParameters();
    private EarClippingTriangulator triangulator = new EarClippingTriangulator();

    public PolygonRegionLoader() {
        this(new InternalFileHandleResolver());
    }

    public PolygonRegionLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public PolygonRegion load(AssetManager assetManager, String string, FileHandle fileHandle, PolygonRegionParameters polygonRegionParameters) {
        Texture texture = (Texture)assetManager.get(assetManager.getDependencies(string).first());
        return this.load(new TextureRegion(texture), fileHandle);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, PolygonRegionParameters polygonRegionParameters) {
        Object object;
        if (polygonRegionParameters == null) {
            polygonRegionParameters = this.defaultParameters;
        }
        String string2 = null;
        try {
            object = fileHandle.reader(polygonRegionParameters.readerBuffer);
            String string3 = ((BufferedReader)object).readLine();
            while (string3 != null) {
                if (string3.startsWith(polygonRegionParameters.texturePrefix)) {
                    string2 = string3.substring(polygonRegionParameters.texturePrefix.length());
                    break;
                }
                string3 = ((BufferedReader)object).readLine();
            }
            ((BufferedReader)object).close();
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error reading " + string, iOException);
        }
        if (string2 == null && polygonRegionParameters.textureExtensions != null) {
            for (String string4 : polygonRegionParameters.textureExtensions) {
                FileHandle fileHandle2 = fileHandle.sibling(fileHandle.nameWithoutExtension().concat("." + (String)string4));
                if (!fileHandle2.exists()) continue;
                string2 = fileHandle2.name();
            }
        }
        if (string2 != null) {
            object = new Array(1);
            ((Array)object).add(new AssetDescriptor<Texture>(fileHandle.sibling(string2), Texture.class));
            return object;
        }
        return null;
    }

    public PolygonRegion load(TextureRegion textureRegion, FileHandle fileHandle) {
        BufferedReader bufferedReader = fileHandle.reader(256);
        try {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (!string.startsWith("s")) continue;
                String[] stringArray = string.substring(1).trim().split(",");
                float[] fArray = new float[stringArray.length];
                int n2 = fArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    fArray[i2] = Float.parseFloat(stringArray[i2]);
                }
                PolygonRegion polygonRegion = new PolygonRegion(textureRegion, fArray, this.triangulator.computeTriangles(fArray).toArray());
                return polygonRegion;
            }
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error reading polygon shape file: " + fileHandle, iOException);
        }
        finally {
            StreamUtils.closeQuietly(bufferedReader);
        }
        throw new GdxRuntimeException("Polygon shape not found: " + fileHandle);
    }

    public static class PolygonRegionParameters
    extends AssetLoaderParameters<PolygonRegion> {
        public String texturePrefix = "i ";
        public int readerBuffer = 1024;
        public String[] textureExtensions = new String[]{"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
    }
}

