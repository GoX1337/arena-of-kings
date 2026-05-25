/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapGroupLayer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.XmlReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public abstract class BaseTmxMapLoader<P extends Parameters>
extends AsynchronousAssetLoader<TiledMap, P> {
    protected static final int FLAG_FLIP_HORIZONTALLY = Integer.MIN_VALUE;
    protected static final int FLAG_FLIP_VERTICALLY = 0x40000000;
    protected static final int FLAG_FLIP_DIAGONALLY = 0x20000000;
    protected static final int MASK_CLEAR = -536870912;
    protected XmlReader xml = new XmlReader();
    protected XmlReader.Element root;
    protected boolean convertObjectToTileSpace;
    protected boolean flipY = true;
    protected int mapTileWidth;
    protected int mapTileHeight;
    protected int mapWidthInPixels;
    protected int mapHeightInPixels;
    protected TiledMap map;

    public BaseTmxMapLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, P p2) {
        this.root = this.xml.parse(fileHandle);
        TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
        if (p2 != null) {
            textureParameter.genMipMaps = ((Parameters)p2).generateMipMaps;
            textureParameter.minFilter = ((Parameters)p2).textureMinFilter;
            textureParameter.magFilter = ((Parameters)p2).textureMagFilter;
        }
        return this.getDependencyAssetDescriptors(fileHandle, textureParameter);
    }

    protected abstract Array<AssetDescriptor> getDependencyAssetDescriptors(FileHandle var1, TextureLoader.TextureParameter var2);

    protected TiledMap loadTiledMap(FileHandle fileHandle, P p2, ImageResolver imageResolver) {
        XmlReader.Element element;
        this.map = new TiledMap();
        if (p2 != null) {
            this.convertObjectToTileSpace = ((Parameters)p2).convertObjectToTileSpace;
            this.flipY = ((Parameters)p2).flipY;
        } else {
            this.convertObjectToTileSpace = false;
            this.flipY = true;
        }
        String string = this.root.getAttribute("orientation", null);
        int n2 = this.root.getIntAttribute("width", 0);
        int n3 = this.root.getIntAttribute("height", 0);
        int n4 = this.root.getIntAttribute("tilewidth", 0);
        int n5 = this.root.getIntAttribute("tileheight", 0);
        int n6 = this.root.getIntAttribute("hexsidelength", 0);
        String string2 = this.root.getAttribute("staggeraxis", null);
        String string3 = this.root.getAttribute("staggerindex", null);
        String string4 = this.root.getAttribute("backgroundcolor", null);
        MapProperties mapProperties = this.map.getProperties();
        if (string != null) {
            mapProperties.put("orientation", string);
        }
        mapProperties.put("width", n2);
        mapProperties.put("height", n3);
        mapProperties.put("tilewidth", n4);
        mapProperties.put("tileheight", n5);
        mapProperties.put("hexsidelength", n6);
        if (string2 != null) {
            mapProperties.put("staggeraxis", string2);
        }
        if (string3 != null) {
            mapProperties.put("staggerindex", string3);
        }
        if (string4 != null) {
            mapProperties.put("backgroundcolor", string4);
        }
        this.mapTileWidth = n4;
        this.mapTileHeight = n5;
        this.mapWidthInPixels = n2 * n4;
        this.mapHeightInPixels = n3 * n5;
        if (string != null && "staggered".equals(string) && n3 > 1) {
            this.mapWidthInPixels += n4 / 2;
            this.mapHeightInPixels = this.mapHeightInPixels / 2 + n5 / 2;
        }
        if ((element = this.root.getChildByName("properties")) != null) {
            this.loadProperties(this.map.getProperties(), element);
        }
        Array<XmlReader.Element> array = this.root.getChildrenByName("tileset");
        for (XmlReader.Element element2 : array) {
            this.loadTileSet(element2, fileHandle, imageResolver);
            this.root.removeChild(element2);
        }
        int n7 = this.root.getChildCount();
        for (int i2 = 0; i2 < n7; ++i2) {
            XmlReader.Element element3 = this.root.getChild(i2);
            this.loadLayer(this.map, this.map.getLayers(), element3, fileHandle, imageResolver);
        }
        return this.map;
    }

    protected void loadLayer(TiledMap tiledMap, MapLayers mapLayers, XmlReader.Element element, FileHandle fileHandle, ImageResolver imageResolver) {
        String string = element.getName();
        if (string.equals("group")) {
            this.loadLayerGroup(tiledMap, mapLayers, element, fileHandle, imageResolver);
        } else if (string.equals("layer")) {
            this.loadTileLayer(tiledMap, mapLayers, element);
        } else if (string.equals("objectgroup")) {
            this.loadObjectGroup(tiledMap, mapLayers, element);
        } else if (string.equals("imagelayer")) {
            this.loadImageLayer(tiledMap, mapLayers, element, fileHandle, imageResolver);
        }
    }

    protected void loadLayerGroup(TiledMap tiledMap, MapLayers mapLayers, XmlReader.Element element, FileHandle fileHandle, ImageResolver imageResolver) {
        if (element.getName().equals("group")) {
            MapGroupLayer mapGroupLayer = new MapGroupLayer();
            this.loadBasicLayerInfo(mapGroupLayer, element);
            XmlReader.Element element2 = element.getChildByName("properties");
            if (element2 != null) {
                this.loadProperties(mapGroupLayer.getProperties(), element2);
            }
            int n2 = element.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                XmlReader.Element element3 = element.getChild(i2);
                this.loadLayer(tiledMap, mapGroupLayer.getLayers(), element3, fileHandle, imageResolver);
            }
            for (MapLayer mapLayer : mapGroupLayer.getLayers()) {
                mapLayer.setParent(mapGroupLayer);
            }
            mapLayers.add(mapGroupLayer);
        }
    }

    protected void loadTileLayer(TiledMap tiledMap, MapLayers mapLayers, XmlReader.Element element) {
        if (element.getName().equals("layer")) {
            int n2 = element.getIntAttribute("width", 0);
            int n3 = element.getIntAttribute("height", 0);
            int n4 = tiledMap.getProperties().get("tilewidth", Integer.class);
            int n5 = tiledMap.getProperties().get("tileheight", Integer.class);
            TiledMapTileLayer tiledMapTileLayer = new TiledMapTileLayer(n2, n3, n4, n5);
            this.loadBasicLayerInfo(tiledMapTileLayer, element);
            int[] nArray = BaseTmxMapLoader.getTileIds(element, n2, n3);
            TiledMapTileSets tiledMapTileSets = tiledMap.getTileSets();
            for (int i2 = 0; i2 < n3; ++i2) {
                for (int i3 = 0; i3 < n2; ++i3) {
                    int n6 = nArray[i2 * n2 + i3];
                    boolean bl2 = (n6 & Integer.MIN_VALUE) != 0;
                    boolean bl3 = (n6 & 0x40000000) != 0;
                    boolean bl4 = (n6 & 0x20000000) != 0;
                    TiledMapTile tiledMapTile = tiledMapTileSets.getTile(n6 & 0x1FFFFFFF);
                    if (tiledMapTile == null) continue;
                    TiledMapTileLayer.Cell cell = this.createTileLayerCell(bl2, bl3, bl4);
                    cell.setTile(tiledMapTile);
                    tiledMapTileLayer.setCell(i3, this.flipY ? n3 - 1 - i2 : i2, cell);
                }
            }
            XmlReader.Element element2 = element.getChildByName("properties");
            if (element2 != null) {
                this.loadProperties(tiledMapTileLayer.getProperties(), element2);
            }
            mapLayers.add(tiledMapTileLayer);
        }
    }

    protected void loadObjectGroup(TiledMap tiledMap, MapLayers mapLayers, XmlReader.Element element) {
        if (element.getName().equals("objectgroup")) {
            MapLayer mapLayer = new MapLayer();
            this.loadBasicLayerInfo(mapLayer, element);
            XmlReader.Element element2 = element.getChildByName("properties");
            if (element2 != null) {
                this.loadProperties(mapLayer.getProperties(), element2);
            }
            for (XmlReader.Element element3 : element.getChildrenByName("object")) {
                this.loadObject(tiledMap, mapLayer, element3);
            }
            mapLayers.add(mapLayer);
        }
    }

    protected void loadImageLayer(TiledMap tiledMap, MapLayers mapLayers, XmlReader.Element element, FileHandle fileHandle, ImageResolver imageResolver) {
        if (element.getName().equals("imagelayer")) {
            Object object;
            Object object2;
            float f2 = 0.0f;
            float f3 = 0.0f;
            f2 = element.hasAttribute("offsetx") ? Float.parseFloat(element.getAttribute("offsetx", "0")) : Float.parseFloat(element.getAttribute("x", "0"));
            f3 = element.hasAttribute("offsety") ? Float.parseFloat(element.getAttribute("offsety", "0")) : Float.parseFloat(element.getAttribute("y", "0"));
            if (this.flipY) {
                f3 = (float)this.mapHeightInPixels - f3;
            }
            TextureRegion textureRegion = null;
            XmlReader.Element element2 = element.getChildByName("image");
            if (element2 != null) {
                object2 = element2.getAttribute("source");
                object = BaseTmxMapLoader.getRelativeFileHandle(fileHandle, (String)object2);
                textureRegion = imageResolver.getImage(((FileHandle)object).path());
                f3 -= (float)textureRegion.getRegionHeight();
            }
            object2 = new TiledMapImageLayer(textureRegion, f2, f3);
            this.loadBasicLayerInfo((MapLayer)object2, element);
            object = element.getChildByName("properties");
            if (object != null) {
                this.loadProperties(((MapLayer)object2).getProperties(), (XmlReader.Element)object);
            }
            mapLayers.add((MapLayer)object2);
        }
    }

    protected void loadBasicLayerInfo(MapLayer mapLayer, XmlReader.Element element) {
        String string = element.getAttribute("name", null);
        float f2 = Float.parseFloat(element.getAttribute("opacity", "1.0"));
        boolean bl2 = element.getIntAttribute("visible", 1) == 1;
        float f3 = element.getFloatAttribute("offsetx", 0.0f);
        float f4 = element.getFloatAttribute("offsety", 0.0f);
        mapLayer.setName(string);
        mapLayer.setOpacity(f2);
        mapLayer.setVisible(bl2);
        mapLayer.setOffsetX(f3);
        mapLayer.setOffsetY(f4);
    }

    protected void loadObject(TiledMap tiledMap, MapLayer mapLayer, XmlReader.Element element) {
        this.loadObject(tiledMap, mapLayer.getObjects(), element, this.mapHeightInPixels);
    }

    protected void loadObject(TiledMap tiledMap, TiledMapTile tiledMapTile, XmlReader.Element element) {
        this.loadObject(tiledMap, tiledMapTile.getObjects(), element, tiledMapTile.getTextureRegion().getRegionHeight());
    }

    protected void loadObject(TiledMap tiledMap, MapObjects mapObjects, XmlReader.Element element, float f2) {
        if (element.getName().equals("object")) {
            int n2;
            String string;
            Object object;
            Object object2;
            MapObject mapObject = null;
            float f3 = this.convertObjectToTileSpace ? 1.0f / (float)this.mapTileWidth : 1.0f;
            float f4 = this.convertObjectToTileSpace ? 1.0f / (float)this.mapTileHeight : 1.0f;
            float f5 = element.getFloatAttribute("x", 0.0f) * f3;
            float f6 = (this.flipY ? f2 - element.getFloatAttribute("y", 0.0f) : element.getFloatAttribute("y", 0.0f)) * f4;
            float f7 = element.getFloatAttribute("width", 0.0f) * f3;
            float f8 = element.getFloatAttribute("height", 0.0f) * f4;
            if (element.getChildCount() > 0) {
                Shape2D shape2D;
                float[] fArray;
                String[] stringArray;
                object2 = null;
                object2 = element.getChildByName("polygon");
                if (object2 != null) {
                    stringArray = ((XmlReader.Element)object2).getAttribute("points").split(" ");
                    fArray = new float[stringArray.length * 2];
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        object = stringArray[i2].split(",");
                        fArray[i2 * 2] = Float.parseFloat(object[0]) * f3;
                        fArray[i2 * 2 + 1] = Float.parseFloat(object[1]) * f4 * (float)(this.flipY ? -1 : 1);
                    }
                    shape2D = new Polygon(fArray);
                    ((Polygon)shape2D).setPosition(f5, f6);
                    mapObject = new PolygonMapObject((Polygon)shape2D);
                } else {
                    object2 = element.getChildByName("polyline");
                    if (object2 != null) {
                        stringArray = ((XmlReader.Element)object2).getAttribute("points").split(" ");
                        fArray = new float[stringArray.length * 2];
                        for (int i3 = 0; i3 < stringArray.length; ++i3) {
                            object = stringArray[i3].split(",");
                            fArray[i3 * 2] = Float.parseFloat(object[0]) * f3;
                            fArray[i3 * 2 + 1] = Float.parseFloat(object[1]) * f4 * (float)(this.flipY ? -1 : 1);
                        }
                        shape2D = new Polyline(fArray);
                        ((Polyline)shape2D).setPosition(f5, f6);
                        mapObject = new PolylineMapObject((Polyline)shape2D);
                    } else {
                        object2 = element.getChildByName("ellipse");
                        if (object2 != null) {
                            mapObject = new EllipseMapObject(f5, this.flipY ? f6 - f8 : f6, f7, f8);
                        }
                    }
                }
            }
            if (mapObject == null) {
                object2 = null;
                object2 = element.getAttribute("gid", null);
                if (object2 != null) {
                    int n3 = (int)Long.parseLong((String)object2);
                    boolean bl2 = (n3 & Integer.MIN_VALUE) != 0;
                    boolean bl3 = (n3 & 0x40000000) != 0;
                    object = tiledMap.getTileSets().getTile(n3 & 0x1FFFFFFF);
                    TiledMapTileMapObject tiledMapTileMapObject = new TiledMapTileMapObject((TiledMapTile)object, bl2, bl3);
                    TextureRegion textureRegion = tiledMapTileMapObject.getTextureRegion();
                    tiledMapTileMapObject.getProperties().put("gid", n3);
                    tiledMapTileMapObject.setX(f5);
                    tiledMapTileMapObject.setY(this.flipY ? f6 : f6 - f8);
                    float f9 = element.getFloatAttribute("width", textureRegion.getRegionWidth());
                    float f10 = element.getFloatAttribute("height", textureRegion.getRegionHeight());
                    tiledMapTileMapObject.setScaleX(f3 * (f9 / (float)textureRegion.getRegionWidth()));
                    tiledMapTileMapObject.setScaleY(f4 * (f10 / (float)textureRegion.getRegionHeight()));
                    tiledMapTileMapObject.setRotation(element.getFloatAttribute("rotation", 0.0f));
                    mapObject = tiledMapTileMapObject;
                } else {
                    mapObject = new RectangleMapObject(f5, this.flipY ? f6 - f8 : f6, f7, f8);
                }
            }
            mapObject.setName(element.getAttribute("name", null));
            object2 = element.getAttribute("rotation", null);
            if (object2 != null) {
                mapObject.getProperties().put("rotation", Float.valueOf(Float.parseFloat((String)object2)));
            }
            if ((string = element.getAttribute("type", null)) != null) {
                mapObject.getProperties().put("type", string);
            }
            if ((n2 = element.getIntAttribute("id", 0)) != 0) {
                mapObject.getProperties().put("id", n2);
            }
            mapObject.getProperties().put("x", Float.valueOf(f5));
            if (mapObject instanceof TiledMapTileMapObject) {
                mapObject.getProperties().put("y", Float.valueOf(f6));
            } else {
                mapObject.getProperties().put("y", Float.valueOf(this.flipY ? f6 - f8 : f6));
            }
            mapObject.getProperties().put("width", Float.valueOf(f7));
            mapObject.getProperties().put("height", Float.valueOf(f8));
            mapObject.setVisible(element.getIntAttribute("visible", 1) == 1);
            XmlReader.Element element2 = element.getChildByName("properties");
            if (element2 != null) {
                this.loadProperties(mapObject.getProperties(), element2);
            }
            mapObjects.add(mapObject);
        }
    }

    protected void loadProperties(MapProperties mapProperties, XmlReader.Element element) {
        if (element == null) {
            return;
        }
        if (element.getName().equals("properties")) {
            for (XmlReader.Element element2 : element.getChildrenByName("property")) {
                String string = element2.getAttribute("name", null);
                String string2 = element2.getAttribute("value", null);
                String string3 = element2.getAttribute("type", null);
                if (string2 == null) {
                    string2 = element2.getText();
                }
                Object object = this.castProperty(string, string2, string3);
                mapProperties.put(string, object);
            }
        }
    }

    protected Object castProperty(String string, String string2, String string3) {
        if (string3 == null) {
            return string2;
        }
        if (string3.equals("int")) {
            return Integer.valueOf(string2);
        }
        if (string3.equals("float")) {
            return Float.valueOf(string2);
        }
        if (string3.equals("bool")) {
            return Boolean.valueOf(string2);
        }
        if (string3.equals("color")) {
            String string4 = string2.substring(3);
            String string5 = string2.substring(1, 3);
            return Color.valueOf(string4 + string5);
        }
        throw new GdxRuntimeException("Wrong type given for property " + string + ", given : " + string3 + ", supported : string, bool, int, float, color");
    }

    protected TiledMapTileLayer.Cell createTileLayerCell(boolean bl2, boolean bl3, boolean bl4) {
        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        if (bl4) {
            if (bl2 && bl3) {
                cell.setFlipHorizontally(true);
                cell.setRotation(3);
            } else if (bl2) {
                cell.setRotation(3);
            } else if (bl3) {
                cell.setRotation(1);
            } else {
                cell.setFlipVertically(true);
                cell.setRotation(3);
            }
        } else {
            cell.setFlipHorizontally(bl2);
            cell.setFlipVertically(bl3);
        }
        return cell;
    }

    public static int[] getTileIds(XmlReader.Element element, int n2, int n3) {
        int[] nArray;
        block17: {
            String string;
            block18: {
                XmlReader.Element element2;
                block16: {
                    element2 = element.getChildByName("data");
                    string = element2.getAttribute("encoding", null);
                    if (string == null) {
                        throw new GdxRuntimeException("Unsupported encoding (XML) for TMX Layer Data");
                    }
                    nArray = new int[n2 * n3];
                    if (!string.equals("csv")) break block16;
                    String[] stringArray = element2.getText().split(",");
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        nArray[i2] = (int)Long.parseLong(stringArray[i2].trim());
                    }
                    break block17;
                }
                if (!string.equals("base64")) break block18;
                InputStream inputStream = null;
                try {
                    String string2 = element2.getAttribute("compression", null);
                    byte[] byArray = Base64Coder.decode(element2.getText());
                    if (string2 == null) {
                        inputStream = new ByteArrayInputStream(byArray);
                    } else if (string2.equals("gzip")) {
                        inputStream = new BufferedInputStream(new GZIPInputStream((InputStream)new ByteArrayInputStream(byArray), byArray.length));
                    } else if (string2.equals("zlib")) {
                        inputStream = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(byArray)));
                    } else {
                        throw new GdxRuntimeException("Unrecognised compression (" + string2 + ") for TMX Layer Data");
                    }
                    byte[] byArray2 = new byte[4];
                    for (int i3 = 0; i3 < n3; ++i3) {
                        for (int i4 = 0; i4 < n2; ++i4) {
                            int n4;
                            int n5;
                            for (n4 = inputStream.read(byArray2); n4 < byArray2.length && (n5 = inputStream.read(byArray2, n4, byArray2.length - n4)) != -1; n4 += n5) {
                            }
                            if (n4 != byArray2.length) {
                                throw new GdxRuntimeException("Error Reading TMX Layer Data: Premature end of tile data");
                            }
                            nArray[i3 * n2 + i4] = BaseTmxMapLoader.unsignedByteToInt(byArray2[0]) | BaseTmxMapLoader.unsignedByteToInt(byArray2[1]) << 8 | BaseTmxMapLoader.unsignedByteToInt(byArray2[2]) << 16 | BaseTmxMapLoader.unsignedByteToInt(byArray2[3]) << 24;
                        }
                    }
                }
                catch (IOException iOException) {
                    try {
                        throw new GdxRuntimeException("Error Reading TMX Layer Data - IOException: " + iOException.getMessage());
                    }
                    catch (Throwable throwable) {
                        StreamUtils.closeQuietly(inputStream);
                        throw throwable;
                    }
                }
                StreamUtils.closeQuietly(inputStream);
                break block17;
            }
            throw new GdxRuntimeException("Unrecognised encoding (" + string + ") for TMX Layer Data");
        }
        return nArray;
    }

    protected static int unsignedByteToInt(byte by2) {
        return by2 & 0xFF;
    }

    protected static FileHandle getRelativeFileHandle(FileHandle fileHandle, String string) {
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

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    protected void loadTileSet(XmlReader.Element var1_1, FileHandle var2_2, ImageResolver var3_3) {
        if (var1_1.getName().equals("tileset")) {
            var4_4 = var1_1.getIntAttribute("firstgid", 1);
            var5_5 = "";
            var6_6 = 0;
            var7_7 = 0;
            var8_8 = null;
            var9_9 = var1_1.getAttribute("source", null);
            if (var9_9 != null) {
                var10_10 = BaseTmxMapLoader.getRelativeFileHandle(var2_2, var9_9);
                try {
                    var1_1 = this.xml.parse((FileHandle)var10_10);
                    var11_11 = var1_1.getChildByName("image");
                    if (var11_11 == null) ** GOTO lbl27
                    var5_5 = var11_11.getAttribute("source");
                    var6_6 = var11_11.getIntAttribute("width", 0);
                    var7_7 = var11_11.getIntAttribute("height", 0);
                    var8_8 = BaseTmxMapLoader.getRelativeFileHandle((FileHandle)var10_10, var5_5);
                }
                catch (SerializationException var11_12) {
                    throw new GdxRuntimeException("Error parsing external tileset.");
                }
            } else {
                var10_10 = var1_1.getChildByName("image");
                if (var10_10 != null) {
                    var5_5 = var10_10.getAttribute("source");
                    var6_6 = var10_10.getIntAttribute("width", 0);
                    var7_7 = var10_10.getIntAttribute("height", 0);
                    var8_8 = BaseTmxMapLoader.getRelativeFileHandle(var2_2, var5_5);
                }
            }
lbl27:
            // 5 sources

            var10_10 = var1_1.get("name", null);
            var11_13 = var1_1.getIntAttribute("tilewidth", 0);
            var12_14 = var1_1.getIntAttribute("tileheight", 0);
            var13_15 = var1_1.getIntAttribute("spacing", 0);
            var14_16 = var1_1.getIntAttribute("margin", 0);
            var15_17 = var1_1.getChildByName("tileoffset");
            var16_18 = 0;
            var17_19 = 0;
            if (var15_17 != null) {
                var16_18 = var15_17.getIntAttribute("x", 0);
                var17_19 = var15_17.getIntAttribute("y", 0);
            }
            var18_20 = new TiledMapTileSet();
            var18_20.setName((String)var10_10);
            var19_21 = var18_20.getProperties();
            var20_22 = var1_1.getChildByName("properties");
            if (var20_22 != null) {
                this.loadProperties(var19_21, var20_22);
            }
            var19_21.put("firstgid", var4_4);
            var21_23 = var1_1.getChildrenByName("tile");
            this.addStaticTiles(var2_2, var3_3, var18_20, var1_1, var21_23, (String)var10_10, var4_4, var11_13, var12_14, var13_15, var14_16, var9_9, var16_18, var17_19, var5_5, var6_6, var7_7, var8_8);
            var22_24 = new Array<AnimatedTiledMapTile>();
            for (Object var24_26 : var21_23) {
                var25_27 = var24_26.getIntAttribute("id", 0);
                var26_28 = var18_20.getTile(var4_4 + var25_27);
                if (var26_28 == null) continue;
                var27_29 = this.createAnimatedTile(var18_20, var26_28, (XmlReader.Element)var24_26, var4_4);
                if (var27_29 != null) {
                    var22_24.add(var27_29);
                    var26_28 = var27_29;
                }
                this.addTileProperties(var26_28, (XmlReader.Element)var24_26);
                this.addTileObjectGroup(var26_28, (XmlReader.Element)var24_26);
            }
            for (Object var24_26 : var22_24) {
                var18_20.putTile(var24_26.getId(), (TiledMapTile)var24_26);
            }
            this.map.getTileSets().addTileSet(var18_20);
        }
    }

    protected abstract void addStaticTiles(FileHandle var1, ImageResolver var2, TiledMapTileSet var3, XmlReader.Element var4, Array<XmlReader.Element> var5, String var6, int var7, int var8, int var9, int var10, int var11, String var12, int var13, int var14, String var15, int var16, int var17, FileHandle var18);

    protected void addTileProperties(TiledMapTile tiledMapTile, XmlReader.Element element) {
        XmlReader.Element element2;
        String string;
        String string2;
        String string3 = element.getAttribute("terrain", null);
        if (string3 != null) {
            tiledMapTile.getProperties().put("terrain", string3);
        }
        if ((string2 = element.getAttribute("probability", null)) != null) {
            tiledMapTile.getProperties().put("probability", string2);
        }
        if ((string = element.getAttribute("type", null)) != null) {
            tiledMapTile.getProperties().put("type", string);
        }
        if ((element2 = element.getChildByName("properties")) != null) {
            this.loadProperties(tiledMapTile.getProperties(), element2);
        }
    }

    protected void addTileObjectGroup(TiledMapTile tiledMapTile, XmlReader.Element element) {
        XmlReader.Element element2 = element.getChildByName("objectgroup");
        if (element2 != null) {
            for (XmlReader.Element element3 : element2.getChildrenByName("object")) {
                this.loadObject(this.map, tiledMapTile, element3);
            }
        }
    }

    protected AnimatedTiledMapTile createAnimatedTile(TiledMapTileSet tiledMapTileSet, TiledMapTile tiledMapTile, XmlReader.Element element, int n2) {
        XmlReader.Element element2 = element.getChildByName("animation");
        if (element2 != null) {
            Array<StaticTiledMapTile> array = new Array<StaticTiledMapTile>();
            IntArray intArray = new IntArray();
            for (XmlReader.Element element3 : element2.getChildrenByName("frame")) {
                array.add((StaticTiledMapTile)tiledMapTileSet.getTile(n2 + element3.getIntAttribute("tileid")));
                intArray.add(element3.getIntAttribute("duration"));
            }
            AnimatedTiledMapTile animatedTiledMapTile = new AnimatedTiledMapTile(intArray, array);
            animatedTiledMapTile.setId(tiledMapTile.getId());
            return animatedTiledMapTile;
        }
        return null;
    }

    protected void addStaticTiledMapTile(TiledMapTileSet tiledMapTileSet, TextureRegion textureRegion, int n2, float f2, float f3) {
        StaticTiledMapTile staticTiledMapTile = new StaticTiledMapTile(textureRegion);
        staticTiledMapTile.setId(n2);
        staticTiledMapTile.setOffsetX(f2);
        staticTiledMapTile.setOffsetY(this.flipY ? -f3 : f3);
        tiledMapTileSet.putTile(n2, staticTiledMapTile);
    }

    public static class Parameters
    extends AssetLoaderParameters<TiledMap> {
        public boolean generateMipMaps = false;
        public Texture.TextureFilter textureMinFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter textureMagFilter = Texture.TextureFilter.Nearest;
        public boolean convertObjectToTileSpace = false;
        public boolean flipY = true;
    }
}

