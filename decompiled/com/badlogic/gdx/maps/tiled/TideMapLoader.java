/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TideMapLoader
extends SynchronousAssetLoader<TiledMap, Parameters> {
    private XmlReader xml = new XmlReader();
    private XmlReader.Element root;

    public TideMapLoader() {
        super(new InternalFileHandleResolver());
    }

    public TideMapLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public TiledMap load(String string) {
        try {
            FileHandle fileHandle = this.resolve(string);
            this.root = this.xml.parse(fileHandle);
            ObjectMap<String, Texture> objectMap = new ObjectMap<String, Texture>();
            for (FileHandle object2 : this.loadTileSheets(this.root, fileHandle)) {
                objectMap.put(object2.path(), new Texture(object2));
            }
            ImageResolver.DirectImageResolver directImageResolver = new ImageResolver.DirectImageResolver(objectMap);
            TiledMap tiledMap = this.loadMap(this.root, fileHandle, directImageResolver);
            tiledMap.setOwnedResources(objectMap.values().toArray());
            return tiledMap;
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + string + "'", iOException);
        }
    }

    @Override
    public TiledMap load(AssetManager assetManager, String string, FileHandle fileHandle, Parameters parameters) {
        try {
            return this.loadMap(this.root, fileHandle, new ImageResolver.AssetManagerImageResolver(assetManager));
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + string + "'", exception);
        }
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, Parameters parameters) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        try {
            this.root = this.xml.parse(fileHandle);
            for (FileHandle fileHandle2 : this.loadTileSheets(this.root, fileHandle)) {
                array.add(new AssetDescriptor<Texture>(fileHandle2.path(), Texture.class));
            }
            return array;
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + string + "'", iOException);
        }
    }

    private TiledMap loadMap(XmlReader.Element element, FileHandle fileHandle, ImageResolver imageResolver) {
        TiledMap tiledMap = new TiledMap();
        XmlReader.Element element2 = element.getChildByName("Properties");
        if (element2 != null) {
            this.loadProperties(tiledMap.getProperties(), element2);
        }
        XmlReader.Element element3 = element.getChildByName("TileSheets");
        for (XmlReader.Element object : element3.getChildrenByName("TileSheet")) {
            this.loadTileSheet(tiledMap, object, fileHandle, imageResolver);
        }
        XmlReader.Element element4 = element.getChildByName("Layers");
        for (XmlReader.Element element5 : element4.getChildrenByName("Layer")) {
            this.loadLayer(tiledMap, element5);
        }
        return tiledMap;
    }

    private Array<FileHandle> loadTileSheets(XmlReader.Element element, FileHandle fileHandle) {
        Array<FileHandle> array = new Array<FileHandle>();
        XmlReader.Element element2 = element.getChildByName("TileSheets");
        for (XmlReader.Element element3 : element2.getChildrenByName("TileSheet")) {
            XmlReader.Element element4 = element3.getChildByName("ImageSource");
            FileHandle fileHandle2 = TideMapLoader.getRelativeFileHandle(fileHandle, element4.getText());
            array.add(fileHandle2);
        }
        return array;
    }

    private void loadTileSheet(TiledMap tiledMap, XmlReader.Element element, FileHandle fileHandle, ImageResolver imageResolver) {
        if (element.getName().equals("TileSheet")) {
            String string = element.getAttribute("Id");
            String string2 = element.getChildByName("Description").getText();
            String string3 = element.getChildByName("ImageSource").getText();
            XmlReader.Element element2 = element.getChildByName("Alignment");
            String string4 = element2.getAttribute("SheetSize");
            String string5 = element2.getAttribute("TileSize");
            String string6 = element2.getAttribute("Margin");
            String string7 = element2.getAttribute("Spacing");
            String[] stringArray = string4.split(" x ");
            int n2 = Integer.parseInt(stringArray[0]);
            int n3 = Integer.parseInt(stringArray[1]);
            String[] stringArray2 = string5.split(" x ");
            int n4 = Integer.parseInt(stringArray2[0]);
            int n5 = Integer.parseInt(stringArray2[1]);
            String[] stringArray3 = string6.split(" x ");
            int n6 = Integer.parseInt(stringArray3[0]);
            int n7 = Integer.parseInt(stringArray3[1]);
            String[] stringArray4 = string6.split(" x ");
            int n8 = Integer.parseInt(stringArray4[0]);
            int n9 = Integer.parseInt(stringArray4[1]);
            FileHandle fileHandle2 = TideMapLoader.getRelativeFileHandle(fileHandle, string3);
            TextureRegion textureRegion = imageResolver.getImage(fileHandle2.path());
            TiledMapTileSets tiledMapTileSets = tiledMap.getTileSets();
            int n10 = 1;
            for (TiledMapTileSet tiledMapTileSet : tiledMapTileSets) {
                n10 += tiledMapTileSet.size();
            }
            TiledMapTileSet tiledMapTileSet = new TiledMapTileSet();
            tiledMapTileSet.setName(string);
            tiledMapTileSet.getProperties().put("firstgid", n10);
            int n11 = n10;
            int n12 = textureRegion.getRegionWidth() - n4;
            int n13 = textureRegion.getRegionHeight() - n5;
            for (int i2 = n7; i2 <= n13; i2 += n5 + n9) {
                for (int i3 = n6; i3 <= n12; i3 += n4 + n8) {
                    StaticTiledMapTile staticTiledMapTile = new StaticTiledMapTile(new TextureRegion(textureRegion, i3, i2, n4, n5));
                    staticTiledMapTile.setId(n11);
                    tiledMapTileSet.putTile(n11++, staticTiledMapTile);
                }
            }
            XmlReader.Element element3 = element.getChildByName("Properties");
            if (element3 != null) {
                this.loadProperties(tiledMapTileSet.getProperties(), element3);
            }
            tiledMapTileSets.addTileSet(tiledMapTileSet);
        }
    }

    private void loadLayer(TiledMap tiledMap, XmlReader.Element element) {
        if (element.getName().equals("Layer")) {
            String string = element.getAttribute("Id");
            String string2 = element.getAttribute("Visible");
            XmlReader.Element element2 = element.getChildByName("Dimensions");
            String string3 = element2.getAttribute("LayerSize");
            String string4 = element2.getAttribute("TileSize");
            String[] stringArray = string3.split(" x ");
            int n2 = Integer.parseInt(stringArray[0]);
            int n3 = Integer.parseInt(stringArray[1]);
            String[] stringArray2 = string4.split(" x ");
            int n4 = Integer.parseInt(stringArray2[0]);
            int n5 = Integer.parseInt(stringArray2[1]);
            TiledMapTileLayer tiledMapTileLayer = new TiledMapTileLayer(n2, n3, n4, n5);
            tiledMapTileLayer.setName(string);
            tiledMapTileLayer.setVisible(string2.equalsIgnoreCase("True"));
            XmlReader.Element element3 = element.getChildByName("TileArray");
            Array<XmlReader.Element> array = element3.getChildrenByName("Row");
            TiledMapTileSets tiledMapTileSets = tiledMap.getTileSets();
            TiledMapTileSet tiledMapTileSet = null;
            int n6 = 0;
            int n7 = array.size;
            for (int i2 = 0; i2 < n7; ++i2) {
                XmlReader.Element element4 = array.get(i2);
                int n8 = n7 - 1 - i2;
                int n9 = 0;
                int n10 = element4.getChildCount();
                for (int i3 = 0; i3 < n10; ++i3) {
                    XmlReader.Element element5 = element4.getChild(i3);
                    String string5 = element5.getName();
                    if (string5.equals("TileSheet")) {
                        tiledMapTileSet = tiledMapTileSets.getTileSet(element5.getAttribute("Ref"));
                        n6 = tiledMapTileSet.getProperties().get("firstgid", Integer.class);
                        continue;
                    }
                    if (string5.equals("Null")) {
                        n9 += element5.getIntAttribute("Count");
                        continue;
                    }
                    if (string5.equals("Static")) {
                        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                        cell.setTile(tiledMapTileSet.getTile(n6 + element5.getIntAttribute("Index")));
                        tiledMapTileLayer.setCell(n9++, n8, cell);
                        continue;
                    }
                    if (!string5.equals("Animated")) continue;
                    int n11 = element5.getInt("Interval");
                    XmlReader.Element element6 = element5.getChildByName("Frames");
                    Array<StaticTiledMapTile> array2 = new Array<StaticTiledMapTile>();
                    int n12 = element6.getChildCount();
                    for (int i4 = 0; i4 < n12; ++i4) {
                        XmlReader.Element element7 = element6.getChild(i4);
                        String string6 = element7.getName();
                        if (string6.equals("TileSheet")) {
                            tiledMapTileSet = tiledMapTileSets.getTileSet(element7.getAttribute("Ref"));
                            n6 = tiledMapTileSet.getProperties().get("firstgid", Integer.class);
                            continue;
                        }
                        if (!string6.equals("Static")) continue;
                        array2.add((StaticTiledMapTile)tiledMapTileSet.getTile(n6 + element7.getIntAttribute("Index")));
                    }
                    TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                    cell.setTile(new AnimatedTiledMapTile((float)n11 / 1000.0f, array2));
                    tiledMapTileLayer.setCell(n9++, n8, cell);
                }
            }
            XmlReader.Element element8 = element.getChildByName("Properties");
            if (element8 != null) {
                this.loadProperties(tiledMapTileLayer.getProperties(), element8);
            }
            tiledMap.getLayers().add(tiledMapTileLayer);
        }
    }

    private void loadProperties(MapProperties mapProperties, XmlReader.Element element) {
        if (element.getName().equals("Properties")) {
            for (XmlReader.Element element2 : element.getChildrenByName("Property")) {
                String string = element2.getAttribute("Key", null);
                String string2 = element2.getAttribute("Type", null);
                String string3 = element2.getText();
                if (string2.equals("Int32")) {
                    mapProperties.put(string, Integer.parseInt(string3));
                    continue;
                }
                if (string2.equals("String")) {
                    mapProperties.put(string, string3);
                    continue;
                }
                if (string2.equals("Boolean")) {
                    mapProperties.put(string, string3.equalsIgnoreCase("true"));
                    continue;
                }
                mapProperties.put(string, string3);
            }
        }
    }

    private static FileHandle getRelativeFileHandle(FileHandle fileHandle, String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, "\\/");
        FileHandle fileHandle2 = fileHandle.parent();
        while (stringTokenizer.hasMoreElements()) {
            String string2 = stringTokenizer.nextToken();
            if (string2.equals("..")) {
                fileHandle2 = fileHandle2.parent();
                continue;
            }
            fileHandle2 = fileHandle2.child(string2);
        }
        return fileHandle2;
    }

    public static class Parameters
    extends AssetLoaderParameters<TiledMap> {
    }
}

