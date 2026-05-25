/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.BaseTmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;

public class TmxMapLoader
extends BaseTmxMapLoader<Parameters> {
    public TmxMapLoader() {
        super(new InternalFileHandleResolver());
    }

    public TmxMapLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public TiledMap load(String string) {
        return this.load(string, new Parameters());
    }

    public TiledMap load(String string, Parameters parameters) {
        FileHandle fileHandle = this.resolve(string);
        this.root = this.xml.parse(fileHandle);
        ObjectMap<String, Texture> objectMap = new ObjectMap<String, Texture>();
        Array<FileHandle> array = this.getDependencyFileHandles(fileHandle);
        for (FileHandle fileHandle2 : array) {
            Texture texture = new Texture(fileHandle2, parameters.generateMipMaps);
            texture.setFilter(parameters.textureMinFilter, parameters.textureMagFilter);
            objectMap.put(fileHandle2.path(), texture);
        }
        TiledMap tiledMap = this.loadTiledMap(fileHandle, parameters, new ImageResolver.DirectImageResolver(objectMap));
        tiledMap.setOwnedResources(objectMap.values().toArray());
        return tiledMap;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, Parameters parameters) {
        this.map = this.loadTiledMap(fileHandle, parameters, new ImageResolver.AssetManagerImageResolver(assetManager));
    }

    @Override
    public TiledMap loadSync(AssetManager assetManager, String string, FileHandle fileHandle, Parameters parameters) {
        return this.map;
    }

    @Override
    protected Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle fileHandle, TextureLoader.TextureParameter textureParameter) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        Array<FileHandle> array2 = this.getDependencyFileHandles(fileHandle);
        for (FileHandle fileHandle2 : array2) {
            array.add(new AssetDescriptor<Texture>(fileHandle2, Texture.class, textureParameter));
        }
        return array;
    }

    protected Array<FileHandle> getDependencyFileHandles(FileHandle fileHandle) {
        Object object;
        Object object2;
        Object object3;
        Array<FileHandle> array = new Array<FileHandle>();
        for (XmlReader.Element element : this.root.getChildrenByName("tileset")) {
            Object object4;
            object3 = element.getAttribute("source", null);
            if (object3 != null) {
                object2 = TmxMapLoader.getRelativeFileHandle(fileHandle, (String)object3);
                element = this.xml.parse((FileHandle)object2);
                object = element.getChildByName("image");
                if (object != null) {
                    String string = element.getChildByName("image").getAttribute("source");
                    FileHandle fileHandle2 = TmxMapLoader.getRelativeFileHandle((FileHandle)object2, string);
                    array.add(fileHandle2);
                    continue;
                }
                for (XmlReader.Element element2 : element.getChildrenByName("tile")) {
                    object4 = element2.getChildByName("image").getAttribute("source");
                    FileHandle fileHandle3 = TmxMapLoader.getRelativeFileHandle((FileHandle)object2, (String)object4);
                    array.add(fileHandle3);
                }
                continue;
            }
            object2 = element.getChildByName("image");
            if (object2 != null) {
                object = element.getChildByName("image").getAttribute("source");
                FileHandle fileHandle4 = TmxMapLoader.getRelativeFileHandle(fileHandle, (String)object);
                array.add(fileHandle4);
                continue;
            }
            for (XmlReader.Element element3 : element.getChildrenByName("tile")) {
                String string = element3.getChildByName("image").getAttribute("source");
                object4 = TmxMapLoader.getRelativeFileHandle(fileHandle, string);
                array.add((FileHandle)object4);
            }
        }
        for (XmlReader.Element element : this.root.getChildrenByName("imagelayer")) {
            object3 = element.getChildByName("image");
            object2 = ((XmlReader.Element)object3).getAttribute("source", null);
            if (object2 == null) continue;
            object = TmxMapLoader.getRelativeFileHandle(fileHandle, (String)object2);
            array.add((FileHandle)object);
        }
        return array;
    }

    @Override
    protected void addStaticTiles(FileHandle fileHandle, ImageResolver imageResolver, TiledMapTileSet tiledMapTileSet, XmlReader.Element element, Array<XmlReader.Element> array, String string, int n2, int n3, int n4, int n5, int n6, String string2, int n7, int n8, String string3, int n9, int n10, FileHandle fileHandle2) {
        MapProperties mapProperties = tiledMapTileSet.getProperties();
        if (fileHandle2 != null) {
            TextureRegion textureRegion = imageResolver.getImage(fileHandle2.path());
            mapProperties.put("imagesource", string3);
            mapProperties.put("imagewidth", n9);
            mapProperties.put("imageheight", n10);
            mapProperties.put("tilewidth", n3);
            mapProperties.put("tileheight", n4);
            mapProperties.put("margin", n6);
            mapProperties.put("spacing", n5);
            int n11 = textureRegion.getRegionWidth() - n3;
            int n12 = textureRegion.getRegionHeight() - n4;
            int n13 = n2;
            for (int i2 = n6; i2 <= n12; i2 += n4 + n5) {
                for (int i3 = n6; i3 <= n11; i3 += n3 + n5) {
                    TextureRegion textureRegion2 = new TextureRegion(textureRegion, i3, i2, n3, n4);
                    int n14 = n13++;
                    this.addStaticTiledMapTile(tiledMapTileSet, textureRegion2, n14, n7, n8);
                }
            }
        } else {
            for (XmlReader.Element element2 : array) {
                XmlReader.Element element3 = element2.getChildByName("image");
                if (element3 != null) {
                    string3 = element3.getAttribute("source");
                    fileHandle2 = string2 != null ? TmxMapLoader.getRelativeFileHandle(TmxMapLoader.getRelativeFileHandle(fileHandle, string2), string3) : TmxMapLoader.getRelativeFileHandle(fileHandle, string3);
                }
                TextureRegion textureRegion = imageResolver.getImage(fileHandle2.path());
                int n15 = n2 + element2.getIntAttribute("id");
                this.addStaticTiledMapTile(tiledMapTileSet, textureRegion, n15, n7, n8);
            }
        }
    }

    public static class Parameters
    extends BaseTmxMapLoader.Parameters {
    }
}

