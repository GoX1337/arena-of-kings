/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class TextureAtlas
implements Disposable {
    private final ObjectSet<Texture> textures = new ObjectSet(4);
    private final Array<AtlasRegion> regions = new Array();

    public TextureAtlas() {
    }

    public TextureAtlas(String string) {
        this(Gdx.files.internal(string));
    }

    public TextureAtlas(FileHandle fileHandle) {
        this(fileHandle, fileHandle.parent());
    }

    public TextureAtlas(FileHandle fileHandle, boolean bl2) {
        this(fileHandle, fileHandle.parent(), bl2);
    }

    public TextureAtlas(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle, fileHandle2, false);
    }

    public TextureAtlas(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2) {
        this(new TextureAtlasData(fileHandle, fileHandle2, bl2));
    }

    public TextureAtlas(TextureAtlasData textureAtlasData) {
        this.load(textureAtlasData);
    }

    public void load(TextureAtlasData textureAtlasData) {
        this.textures.ensureCapacity(textureAtlasData.pages.size);
        for (TextureAtlasData.Page object : textureAtlasData.pages) {
            if (object.texture == null) {
                object.texture = new Texture(object.textureFile, object.format, object.useMipMaps);
            }
            object.texture.setFilter(object.minFilter, object.magFilter);
            object.texture.setWrap(object.uWrap, object.vWrap);
            this.textures.add(object.texture);
        }
        this.regions.ensureCapacity(textureAtlasData.regions.size);
        for (TextureAtlasData.Region region : textureAtlasData.regions) {
            AtlasRegion atlasRegion = new AtlasRegion(region.page.texture, region.left, region.top, region.rotate ? region.height : region.width, region.rotate ? region.width : region.height);
            atlasRegion.index = region.index;
            atlasRegion.name = region.name;
            atlasRegion.offsetX = region.offsetX;
            atlasRegion.offsetY = region.offsetY;
            atlasRegion.originalHeight = region.originalHeight;
            atlasRegion.originalWidth = region.originalWidth;
            atlasRegion.rotate = region.rotate;
            atlasRegion.degrees = region.degrees;
            atlasRegion.names = region.names;
            atlasRegion.values = region.values;
            if (region.flip) {
                atlasRegion.flip(false, true);
            }
            this.regions.add(atlasRegion);
        }
    }

    public AtlasRegion addRegion(String string, Texture texture, int n2, int n3, int n4, int n5) {
        this.textures.add(texture);
        AtlasRegion atlasRegion = new AtlasRegion(texture, n2, n3, n4, n5);
        atlasRegion.name = string;
        this.regions.add(atlasRegion);
        return atlasRegion;
    }

    public AtlasRegion addRegion(String string, TextureRegion textureRegion) {
        this.textures.add(textureRegion.texture);
        AtlasRegion atlasRegion = new AtlasRegion(textureRegion);
        atlasRegion.name = string;
        this.regions.add(atlasRegion);
        return atlasRegion;
    }

    public Array<AtlasRegion> getRegions() {
        return this.regions;
    }

    @Null
    public AtlasRegion findRegion(String string) {
        int n2 = this.regions.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.regions.get((int)i2).name.equals(string)) continue;
            return this.regions.get(i2);
        }
        return null;
    }

    @Null
    public AtlasRegion findRegion(String string, int n2) {
        int n3 = this.regions.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            AtlasRegion atlasRegion = this.regions.get(i2);
            if (!atlasRegion.name.equals(string) || atlasRegion.index != n2) continue;
            return atlasRegion;
        }
        return null;
    }

    public Array<AtlasRegion> findRegions(String string) {
        Array<AtlasRegion> array = new Array<AtlasRegion>(AtlasRegion.class);
        int n2 = this.regions.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            AtlasRegion atlasRegion = this.regions.get(i2);
            if (!atlasRegion.name.equals(string)) continue;
            array.add(new AtlasRegion(atlasRegion));
        }
        return array;
    }

    public Array<Sprite> createSprites() {
        Array<Sprite> array = new Array<Sprite>(true, this.regions.size, Sprite.class);
        int n2 = this.regions.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            array.add(this.newSprite(this.regions.get(i2)));
        }
        return array;
    }

    @Null
    public Sprite createSprite(String string) {
        int n2 = this.regions.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.regions.get((int)i2).name.equals(string)) continue;
            return this.newSprite(this.regions.get(i2));
        }
        return null;
    }

    @Null
    public Sprite createSprite(String string, int n2) {
        int n3 = this.regions.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            AtlasRegion atlasRegion = this.regions.get(i2);
            if (atlasRegion.index != n2 || !atlasRegion.name.equals(string)) continue;
            return this.newSprite(this.regions.get(i2));
        }
        return null;
    }

    public Array<Sprite> createSprites(String string) {
        Array<Sprite> array = new Array<Sprite>(Sprite.class);
        int n2 = this.regions.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            AtlasRegion atlasRegion = this.regions.get(i2);
            if (!atlasRegion.name.equals(string)) continue;
            array.add(this.newSprite(atlasRegion));
        }
        return array;
    }

    private Sprite newSprite(AtlasRegion atlasRegion) {
        if (atlasRegion.packedWidth == atlasRegion.originalWidth && atlasRegion.packedHeight == atlasRegion.originalHeight) {
            if (atlasRegion.rotate) {
                Sprite sprite = new Sprite(atlasRegion);
                sprite.setBounds(0.0f, 0.0f, atlasRegion.getRegionHeight(), atlasRegion.getRegionWidth());
                sprite.rotate90(true);
                return sprite;
            }
            return new Sprite(atlasRegion);
        }
        return new AtlasSprite(atlasRegion);
    }

    @Null
    public NinePatch createPatch(String string) {
        int n2 = this.regions.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            AtlasRegion atlasRegion = this.regions.get(i2);
            if (!atlasRegion.name.equals(string)) continue;
            int[] nArray = atlasRegion.findValue("split");
            if (nArray == null) {
                throw new IllegalArgumentException("Region does not have ninepatch splits: " + string);
            }
            NinePatch ninePatch = new NinePatch((TextureRegion)atlasRegion, nArray[0], nArray[1], nArray[2], nArray[3]);
            int[] nArray2 = atlasRegion.findValue("pad");
            if (nArray2 != null) {
                ninePatch.setPadding(nArray2[0], nArray2[1], nArray2[2], nArray2[3]);
            }
            return ninePatch;
        }
        return null;
    }

    public ObjectSet<Texture> getTextures() {
        return this.textures;
    }

    @Override
    public void dispose() {
        for (Texture texture : this.textures) {
            texture.dispose();
        }
        this.textures.clear(0);
    }

    public static class AtlasSprite
    extends Sprite {
        final AtlasRegion region;
        float originalOffsetX;
        float originalOffsetY;

        public AtlasSprite(AtlasRegion atlasRegion) {
            this.region = new AtlasRegion(atlasRegion);
            this.originalOffsetX = atlasRegion.offsetX;
            this.originalOffsetY = atlasRegion.offsetY;
            this.setRegion(atlasRegion);
            this.setOrigin((float)atlasRegion.originalWidth / 2.0f, (float)atlasRegion.originalHeight / 2.0f);
            int n2 = atlasRegion.getRegionWidth();
            int n3 = atlasRegion.getRegionHeight();
            if (atlasRegion.rotate) {
                super.rotate90(true);
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, n3, n2);
            } else {
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, n2, n3);
            }
            this.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public AtlasSprite(AtlasSprite atlasSprite) {
            this.region = atlasSprite.region;
            this.originalOffsetX = atlasSprite.originalOffsetX;
            this.originalOffsetY = atlasSprite.originalOffsetY;
            this.set(atlasSprite);
        }

        @Override
        public void setPosition(float f2, float f3) {
            super.setPosition(f2 + this.region.offsetX, f3 + this.region.offsetY);
        }

        @Override
        public void setX(float f2) {
            super.setX(f2 + this.region.offsetX);
        }

        @Override
        public void setY(float f2) {
            super.setY(f2 + this.region.offsetY);
        }

        @Override
        public void setBounds(float f2, float f3, float f4, float f5) {
            float f6 = f4 / (float)this.region.originalWidth;
            float f7 = f5 / (float)this.region.originalHeight;
            this.region.offsetX = this.originalOffsetX * f6;
            this.region.offsetY = this.originalOffsetY * f7;
            int n2 = this.region.rotate ? this.region.packedHeight : this.region.packedWidth;
            int n3 = this.region.rotate ? this.region.packedWidth : this.region.packedHeight;
            super.setBounds(f2 + this.region.offsetX, f3 + this.region.offsetY, (float)n2 * f6, (float)n3 * f7);
        }

        @Override
        public void setSize(float f2, float f3) {
            this.setBounds(this.getX(), this.getY(), f2, f3);
        }

        @Override
        public void setOrigin(float f2, float f3) {
            super.setOrigin(f2 - this.region.offsetX, f3 - this.region.offsetY);
        }

        @Override
        public void setOriginCenter() {
            super.setOrigin(this.width / 2.0f - this.region.offsetX, this.height / 2.0f - this.region.offsetY);
        }

        @Override
        public void flip(boolean bl2, boolean bl3) {
            if (this.region.rotate) {
                super.flip(bl3, bl2);
            } else {
                super.flip(bl2, bl3);
            }
            float f2 = this.getOriginX();
            float f3 = this.getOriginY();
            float f4 = this.region.offsetX;
            float f5 = this.region.offsetY;
            float f6 = this.getWidthRatio();
            float f7 = this.getHeightRatio();
            this.region.offsetX = this.originalOffsetX;
            this.region.offsetY = this.originalOffsetY;
            this.region.flip(bl2, bl3);
            this.originalOffsetX = this.region.offsetX;
            this.originalOffsetY = this.region.offsetY;
            this.region.offsetX *= f6;
            this.region.offsetY *= f7;
            this.translate(this.region.offsetX - f4, this.region.offsetY - f5);
            this.setOrigin(f2, f3);
        }

        @Override
        public void rotate90(boolean bl2) {
            super.rotate90(bl2);
            float f2 = this.getOriginX();
            float f3 = this.getOriginY();
            float f4 = this.region.offsetX;
            float f5 = this.region.offsetY;
            float f6 = this.getWidthRatio();
            float f7 = this.getHeightRatio();
            if (bl2) {
                this.region.offsetX = f5;
                this.region.offsetY = (float)this.region.originalHeight * f7 - f4 - (float)this.region.packedWidth * f6;
            } else {
                this.region.offsetX = (float)this.region.originalWidth * f6 - f5 - (float)this.region.packedHeight * f7;
                this.region.offsetY = f4;
            }
            this.translate(this.region.offsetX - f4, this.region.offsetY - f5);
            this.setOrigin(f2, f3);
        }

        @Override
        public float getX() {
            return super.getX() - this.region.offsetX;
        }

        @Override
        public float getY() {
            return super.getY() - this.region.offsetY;
        }

        @Override
        public float getOriginX() {
            return super.getOriginX() + this.region.offsetX;
        }

        @Override
        public float getOriginY() {
            return super.getOriginY() + this.region.offsetY;
        }

        @Override
        public float getWidth() {
            return super.getWidth() / this.region.getRotatedPackedWidth() * (float)this.region.originalWidth;
        }

        @Override
        public float getHeight() {
            return super.getHeight() / this.region.getRotatedPackedHeight() * (float)this.region.originalHeight;
        }

        public float getWidthRatio() {
            return super.getWidth() / this.region.getRotatedPackedWidth();
        }

        public float getHeightRatio() {
            return super.getHeight() / this.region.getRotatedPackedHeight();
        }

        public AtlasRegion getAtlasRegion() {
            return this.region;
        }

        public String toString() {
            return this.region.toString();
        }
    }

    public static class AtlasRegion
    extends TextureRegion {
        public int index = -1;
        public String name;
        public float offsetX;
        public float offsetY;
        public int packedWidth;
        public int packedHeight;
        public int originalWidth;
        public int originalHeight;
        public boolean rotate;
        public int degrees;
        @Null
        public String[] names;
        @Null
        public int[][] values;

        public AtlasRegion(Texture texture, int n2, int n3, int n4, int n5) {
            super(texture, n2, n3, n4, n5);
            this.originalWidth = n4;
            this.originalHeight = n5;
            this.packedWidth = n4;
            this.packedHeight = n5;
        }

        public AtlasRegion(AtlasRegion atlasRegion) {
            this.setRegion(atlasRegion);
            this.index = atlasRegion.index;
            this.name = atlasRegion.name;
            this.offsetX = atlasRegion.offsetX;
            this.offsetY = atlasRegion.offsetY;
            this.packedWidth = atlasRegion.packedWidth;
            this.packedHeight = atlasRegion.packedHeight;
            this.originalWidth = atlasRegion.originalWidth;
            this.originalHeight = atlasRegion.originalHeight;
            this.rotate = atlasRegion.rotate;
            this.degrees = atlasRegion.degrees;
            this.names = atlasRegion.names;
            this.values = atlasRegion.values;
        }

        public AtlasRegion(TextureRegion textureRegion) {
            this.setRegion(textureRegion);
            this.packedWidth = textureRegion.getRegionWidth();
            this.packedHeight = textureRegion.getRegionHeight();
            this.originalWidth = this.packedWidth;
            this.originalHeight = this.packedHeight;
        }

        @Override
        public void flip(boolean bl2, boolean bl3) {
            super.flip(bl2, bl3);
            if (bl2) {
                this.offsetX = (float)this.originalWidth - this.offsetX - this.getRotatedPackedWidth();
            }
            if (bl3) {
                this.offsetY = (float)this.originalHeight - this.offsetY - this.getRotatedPackedHeight();
            }
        }

        public float getRotatedPackedWidth() {
            return this.rotate ? (float)this.packedHeight : (float)this.packedWidth;
        }

        public float getRotatedPackedHeight() {
            return this.rotate ? (float)this.packedWidth : (float)this.packedHeight;
        }

        @Null
        public int[] findValue(String string) {
            if (this.names != null) {
                int n2 = this.names.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!string.equals(this.names[i2])) continue;
                    return this.values[i2];
                }
            }
            return null;
        }

        public String toString() {
            return this.name;
        }
    }

    public static class TextureAtlasData {
        final Array<Page> pages = new Array();
        final Array<Region> regions = new Array();

        public TextureAtlasData() {
        }

        public TextureAtlasData(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2) {
            this.load(fileHandle, fileHandle2, bl2);
        }

        public void load(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2) {
            final String[] stringArray = new String[5];
            ObjectMap<String, Field<Page>> objectMap = new ObjectMap<String, Field<Page>>(15, 0.99f);
            objectMap.put("size", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.width = Integer.parseInt(stringArray[1]);
                    page.height = Integer.parseInt(stringArray[2]);
                }
            });
            objectMap.put("format", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.format = Pixmap.Format.valueOf(stringArray[1]);
                }
            });
            objectMap.put("filter", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.minFilter = Texture.TextureFilter.valueOf(stringArray[1]);
                    page.magFilter = Texture.TextureFilter.valueOf(stringArray[2]);
                    page.useMipMaps = page.minFilter.isMipMap();
                }
            });
            objectMap.put("repeat", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    if (stringArray[1].indexOf(120) != -1) {
                        page.uWrap = Texture.TextureWrap.Repeat;
                    }
                    if (stringArray[1].indexOf(121) != -1) {
                        page.vWrap = Texture.TextureWrap.Repeat;
                    }
                }
            });
            objectMap.put("pma", new Field<Page>(){

                @Override
                public void parse(Page page) {
                    page.pma = stringArray[1].equals("true");
                }
            });
            final boolean[] blArray = new boolean[]{false};
            ObjectMap<String, Field<Region>> objectMap2 = new ObjectMap<String, Field<Region>>(127, 0.99f);
            objectMap2.put("xy", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.left = Integer.parseInt(stringArray[1]);
                    region.top = Integer.parseInt(stringArray[2]);
                }
            });
            objectMap2.put("size", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.width = Integer.parseInt(stringArray[1]);
                    region.height = Integer.parseInt(stringArray[2]);
                }
            });
            objectMap2.put("bounds", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.left = Integer.parseInt(stringArray[1]);
                    region.top = Integer.parseInt(stringArray[2]);
                    region.width = Integer.parseInt(stringArray[3]);
                    region.height = Integer.parseInt(stringArray[4]);
                }
            });
            objectMap2.put("offset", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.offsetX = Integer.parseInt(stringArray[1]);
                    region.offsetY = Integer.parseInt(stringArray[2]);
                }
            });
            objectMap2.put("orig", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.originalWidth = Integer.parseInt(stringArray[1]);
                    region.originalHeight = Integer.parseInt(stringArray[2]);
                }
            });
            objectMap2.put("offsets", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.offsetX = Integer.parseInt(stringArray[1]);
                    region.offsetY = Integer.parseInt(stringArray[2]);
                    region.originalWidth = Integer.parseInt(stringArray[3]);
                    region.originalHeight = Integer.parseInt(stringArray[4]);
                }
            });
            objectMap2.put("rotate", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    String string = stringArray[1];
                    if (string.equals("true")) {
                        region.degrees = 90;
                    } else if (!string.equals("false")) {
                        region.degrees = Integer.parseInt(string);
                    }
                    region.rotate = region.degrees == 90;
                }
            });
            objectMap2.put("index", new Field<Region>(){

                @Override
                public void parse(Region region) {
                    region.index = Integer.parseInt(stringArray[1]);
                    if (region.index != -1) {
                        blArray[0] = true;
                    }
                }
            });
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 1024);
            try {
                String string = bufferedReader.readLine();
                while (string != null && string.trim().length() == 0) {
                    string = bufferedReader.readLine();
                }
                while (string != null && string.trim().length() != 0 && TextureAtlasData.readEntry(stringArray, string) != 0) {
                    string = bufferedReader.readLine();
                }
                Page page = null;
                Array<String> array = null;
                Array<int[]> array2 = null;
                while (string != null) {
                    int n2;
                    Object object;
                    if (string.trim().length() == 0) {
                        page = null;
                        string = bufferedReader.readLine();
                        continue;
                    }
                    if (page == null) {
                        page = new Page();
                        page.textureFile = fileHandle2.child(string);
                        while (TextureAtlasData.readEntry(stringArray, string = bufferedReader.readLine()) != 0) {
                            object = (Field)objectMap.get(stringArray[0]);
                            if (object == null) continue;
                            object.parse(page);
                        }
                        this.pages.add(page);
                        continue;
                    }
                    object = new Region();
                    ((Region)object).page = page;
                    ((Region)object).name = string.trim();
                    if (bl2) {
                        ((Region)object).flip = true;
                    }
                    while ((n2 = TextureAtlasData.readEntry(stringArray, string = bufferedReader.readLine())) != 0) {
                        Field field = (Field)objectMap2.get(stringArray[0]);
                        if (field != null) {
                            field.parse(object);
                            continue;
                        }
                        if (array == null) {
                            array = new Array<String>(8);
                            array2 = new Array<int[]>(8);
                        }
                        array.add(stringArray[0]);
                        int[] nArray = new int[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            try {
                                nArray[i2] = Integer.parseInt(stringArray[i2 + 1]);
                                continue;
                            }
                            catch (NumberFormatException numberFormatException) {
                                // empty catch block
                            }
                        }
                        array2.add(nArray);
                    }
                    if (((Region)object).originalWidth == 0 && ((Region)object).originalHeight == 0) {
                        ((Region)object).originalWidth = ((Region)object).width;
                        ((Region)object).originalHeight = ((Region)object).height;
                    }
                    if (array != null && array.size > 0) {
                        ((Region)object).names = array.toArray(String.class);
                        ((Region)object).values = array2.toArray(int[].class);
                        array.clear();
                        array2.clear();
                    }
                    this.regions.add((Region)object);
                }
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Error reading texture atlas file: " + fileHandle, exception);
            }
            finally {
                StreamUtils.closeQuietly(bufferedReader);
            }
            if (blArray[0]) {
                this.regions.sort(new Comparator<Region>(){

                    @Override
                    public int compare(Region region, Region region2) {
                        int n2;
                        int n3 = region.index;
                        if (n3 == -1) {
                            n3 = Integer.MAX_VALUE;
                        }
                        if ((n2 = region2.index) == -1) {
                            n2 = Integer.MAX_VALUE;
                        }
                        return n3 - n2;
                    }
                });
            }
        }

        public Array<Page> getPages() {
            return this.pages;
        }

        public Array<Region> getRegions() {
            return this.regions;
        }

        private static int readEntry(String[] stringArray, @Null String string) {
            if (string == null) {
                return 0;
            }
            if ((string = string.trim()).length() == 0) {
                return 0;
            }
            int n2 = string.indexOf(58);
            if (n2 == -1) {
                return 0;
            }
            stringArray[0] = string.substring(0, n2).trim();
            int n3 = 1;
            int n4 = n2 + 1;
            while (true) {
                int n5;
                if ((n5 = string.indexOf(44, n4)) == -1) {
                    stringArray[n3] = string.substring(n4).trim();
                    return n3;
                }
                stringArray[n3] = string.substring(n4, n5).trim();
                n4 = n5 + 1;
                if (n3 == 4) {
                    return 4;
                }
                ++n3;
            }
        }

        public static class Region {
            public Page page;
            public String name;
            public int left;
            public int top;
            public int width;
            public int height;
            public float offsetX;
            public float offsetY;
            public int originalWidth;
            public int originalHeight;
            public int degrees;
            public boolean rotate;
            public int index = -1;
            @Null
            public String[] names;
            @Null
            public int[][] values;
            public boolean flip;

            @Null
            public int[] findValue(String string) {
                if (this.names != null) {
                    int n2 = this.names.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (!string.equals(this.names[i2])) continue;
                        return this.values[i2];
                    }
                }
                return null;
            }
        }

        public static class Page {
            @Null
            public FileHandle textureFile;
            @Null
            public Texture texture;
            public float width;
            public float height;
            public boolean useMipMaps;
            public Pixmap.Format format = Pixmap.Format.RGBA8888;
            public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
            public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
            public Texture.TextureWrap uWrap = Texture.TextureWrap.ClampToEdge;
            public Texture.TextureWrap vWrap = Texture.TextureWrap.ClampToEdge;
            public boolean pma;
        }

        static interface Field<T> {
            public void parse(T var1);
        }
    }
}

