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
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.BaseTmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.XmlReader;

public class AtlasTmxMapLoader
extends BaseTmxMapLoader<AtlasTiledMapLoaderParameters> {
    protected Array<Texture> trackedTextures = new Array();
    protected AtlasResolver atlasResolver;

    public AtlasTmxMapLoader() {
        super(new InternalFileHandleResolver());
    }

    public AtlasTmxMapLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public TiledMap load(String string) {
        return this.load(string, new AtlasTiledMapLoaderParameters());
    }

    public TiledMap load(String string, AtlasTiledMapLoaderParameters atlasTiledMapLoaderParameters) {
        FileHandle fileHandle = this.resolve(string);
        this.root = this.xml.parse(fileHandle);
        FileHandle fileHandle2 = this.getAtlasFileHandle(fileHandle);
        TextureAtlas textureAtlas = new TextureAtlas(fileHandle2);
        this.atlasResolver = new AtlasResolver.DirectAtlasResolver(textureAtlas);
        TiledMap tiledMap = this.loadTiledMap(fileHandle, atlasTiledMapLoaderParameters, this.atlasResolver);
        tiledMap.setOwnedResources(new Array<TextureAtlas>(new TextureAtlas[]{textureAtlas}));
        this.setTextureFilters(atlasTiledMapLoaderParameters.textureMinFilter, atlasTiledMapLoaderParameters.textureMagFilter);
        return tiledMap;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, AtlasTiledMapLoaderParameters atlasTiledMapLoaderParameters) {
        FileHandle fileHandle2 = this.getAtlasFileHandle(fileHandle);
        this.atlasResolver = new AtlasResolver.AssetManagerAtlasResolver(assetManager, fileHandle2.path());
        this.map = this.loadTiledMap(fileHandle, atlasTiledMapLoaderParameters, this.atlasResolver);
    }

    @Override
    public TiledMap loadSync(AssetManager assetManager, String string, FileHandle fileHandle, AtlasTiledMapLoaderParameters atlasTiledMapLoaderParameters) {
        if (atlasTiledMapLoaderParameters != null) {
            this.setTextureFilters(atlasTiledMapLoaderParameters.textureMinFilter, atlasTiledMapLoaderParameters.textureMagFilter);
        }
        return this.map;
    }

    @Override
    protected Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle fileHandle, TextureLoader.TextureParameter textureParameter) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        FileHandle fileHandle2 = this.getAtlasFileHandle(fileHandle);
        if (fileHandle2 != null) {
            array.add(new AssetDescriptor<TextureAtlas>(fileHandle2, TextureAtlas.class));
        }
        return array;
    }

    @Override
    protected void addStaticTiles(FileHandle fileHandle, ImageResolver imageResolver, TiledMapTileSet tiledMapTileSet, XmlReader.Element element, Array<XmlReader.Element> array, String string, int n2, int n3, int n4, int n5, int n6, String string2, int n7, int n8, String string3, int n9, int n10, FileHandle fileHandle2) {
        TextureAtlas textureAtlas = this.atlasResolver.getAtlas();
        String string4 = string;
        for (Texture texture : textureAtlas.getTextures()) {
            this.trackedTextures.add(texture);
        }
        MapProperties mapProperties = tiledMapTileSet.getProperties();
        mapProperties.put("imagesource", string3);
        mapProperties.put("imagewidth", n9);
        mapProperties.put("imageheight", n10);
        mapProperties.put("tilewidth", n3);
        mapProperties.put("tileheight", n4);
        mapProperties.put("margin", n6);
        mapProperties.put("spacing", n5);
        if (string3 != null && string3.length() > 0) {
            int n11 = n2 + n9 / n3 * (n10 / n4) - 1;
            for (TextureAtlas.AtlasRegion atlasRegion : textureAtlas.findRegions(string4)) {
                int n12;
                if (atlasRegion == null || (n12 = n2 + atlasRegion.index) < n2 || n12 > n11) continue;
                this.addStaticTiledMapTile(tiledMapTileSet, atlasRegion, n12, n7, n8);
            }
        }
        for (XmlReader.Element element2 : array) {
            XmlReader.Element element3;
            int n13 = n2 + element2.getIntAttribute("id", 0);
            TiledMapTile tiledMapTile = tiledMapTileSet.getTile(n13);
            if (tiledMapTile != null || (element3 = element2.getChildByName("image")) == null) continue;
            String string5 = element3.getAttribute("source");
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(string5 = string5.substring(0, string5.lastIndexOf(46)));
            if (atlasRegion == null) {
                throw new GdxRuntimeException("Tileset atlasRegion not found: " + string5);
            }
            this.addStaticTiledMapTile(tiledMapTileSet, atlasRegion, n13, n7, n8);
        }
    }

    protected FileHandle getAtlasFileHandle(FileHandle fileHandle) {
        XmlReader.Element element = this.root.getChildByName("properties");
        String string = null;
        if (element != null) {
            for (XmlReader.Element element2 : element.getChildrenByName("property")) {
                String string2 = element2.getAttribute("name");
                if (!string2.startsWith("atlas")) continue;
                string = element2.getAttribute("value");
                break;
            }
        }
        if (string == null) {
            throw new GdxRuntimeException("The map is missing the 'atlas' property");
        }
        FileHandle fileHandle2 = AtlasTmxMapLoader.getRelativeFileHandle(fileHandle, string);
        if (!fileHandle2.exists()) {
            throw new GdxRuntimeException("The 'atlas' file could not be found: '" + string + "'");
        }
        return fileHandle2;
    }

    protected void setTextureFilters(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        for (Texture texture : this.trackedTextures) {
            texture.setFilter(textureFilter, textureFilter2);
        }
        this.trackedTextures.clear();
    }

    protected static interface AtlasResolver
    extends ImageResolver {
        public TextureAtlas getAtlas();

        public static class AssetManagerAtlasResolver
        implements AtlasResolver {
            private final AssetManager assetManager;
            private final String atlasName;

            public AssetManagerAtlasResolver(AssetManager assetManager, String string) {
                this.assetManager = assetManager;
                this.atlasName = string;
            }

            @Override
            public TextureAtlas getAtlas() {
                return this.assetManager.get(this.atlasName, TextureAtlas.class);
            }

            @Override
            public TextureRegion getImage(String string) {
                return this.getAtlas().findRegion(string);
            }
        }

        public static class DirectAtlasResolver
        implements AtlasResolver {
            private final TextureAtlas atlas;

            public DirectAtlasResolver(TextureAtlas textureAtlas) {
                this.atlas = textureAtlas;
            }

            @Override
            public TextureAtlas getAtlas() {
                return this.atlas;
            }

            @Override
            public TextureRegion getImage(String string) {
                return this.atlas.findRegion(string);
            }
        }
    }

    public static class AtlasTiledMapLoaderParameters
    extends BaseTmxMapLoader.Parameters {
        public boolean forceTextureFilters = false;
    }
}

