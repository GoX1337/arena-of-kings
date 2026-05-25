/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.OrderedMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PixmapPacker
implements Disposable {
    boolean packToTexture;
    boolean disposed;
    int pageWidth;
    int pageHeight;
    Pixmap.Format pageFormat;
    int padding;
    boolean duplicateBorder;
    boolean stripWhitespaceX;
    boolean stripWhitespaceY;
    int alphaThreshold;
    Color transparentColor = new Color(0.0f, 0.0f, 0.0f, 0.0f);
    final Array<Page> pages = new Array();
    PackStrategy packStrategy;
    static Pattern indexPattern = Pattern.compile("(.+)_(\\d+)$");
    private Color c = new Color();

    public PixmapPacker(int n2, int n3, Pixmap.Format format, int n4, boolean bl2) {
        this(n2, n3, format, n4, bl2, false, false, new GuillotineStrategy());
    }

    public PixmapPacker(int n2, int n3, Pixmap.Format format, int n4, boolean bl2, PackStrategy packStrategy) {
        this(n2, n3, format, n4, bl2, false, false, packStrategy);
    }

    public PixmapPacker(int n2, int n3, Pixmap.Format format, int n4, boolean bl2, boolean bl3, boolean bl4, PackStrategy packStrategy) {
        this.pageWidth = n2;
        this.pageHeight = n3;
        this.pageFormat = format;
        this.padding = n4;
        this.duplicateBorder = bl2;
        this.stripWhitespaceX = bl3;
        this.stripWhitespaceY = bl4;
        this.packStrategy = packStrategy;
    }

    public void sort(Array<Pixmap> array) {
        this.packStrategy.sort(array);
    }

    public synchronized Rectangle pack(Pixmap pixmap) {
        return this.pack(null, pixmap);
    }

    public synchronized Rectangle pack(String string, Pixmap pixmap) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        PixmapPackerRectangle pixmapPackerRectangle;
        if (this.disposed) {
            return null;
        }
        if (string != null && this.getRect(string) != null) {
            throw new GdxRuntimeException("Pixmap has already been packed with name: " + string);
        }
        Pixmap pixmap2 = null;
        if (string != null && string.endsWith(".9")) {
            pixmapPackerRectangle = new PixmapPackerRectangle(0, 0, pixmap.getWidth() - 2, pixmap.getHeight() - 2);
            pixmap2 = new Pixmap(pixmap.getWidth() - 2, pixmap.getHeight() - 2, pixmap.getFormat());
            pixmap2.setBlending(Pixmap.Blending.None);
            pixmapPackerRectangle.splits = this.getSplits(pixmap);
            pixmapPackerRectangle.pads = this.getPads(pixmap, pixmapPackerRectangle.splits);
            pixmap2.drawPixmap(pixmap, 0, 0, 1, 1, pixmap.getWidth() - 1, pixmap.getHeight() - 1);
            pixmap = pixmap2;
            string = string.split("\\.")[0];
        } else if (this.stripWhitespaceX || this.stripWhitespaceY) {
            int n8;
            int n9 = pixmap.getWidth();
            n7 = pixmap.getHeight();
            n6 = 0;
            n5 = pixmap.getHeight();
            if (this.stripWhitespaceY) {
                block0: for (n4 = 0; n4 < pixmap.getHeight(); ++n4) {
                    for (n3 = 0; n3 < pixmap.getWidth(); ++n3) {
                        n2 = pixmap.getPixel(n3, n4);
                        n8 = n2 & 0xFF;
                        if (n8 > this.alphaThreshold) break block0;
                    }
                    ++n6;
                }
                n4 = pixmap.getHeight();
                block2: while (--n4 >= n6) {
                    for (n3 = 0; n3 < pixmap.getWidth(); ++n3) {
                        n2 = pixmap.getPixel(n3, n4);
                        n8 = n2 & 0xFF;
                        if (n8 > this.alphaThreshold) break block2;
                    }
                    --n5;
                }
            }
            n4 = 0;
            n3 = pixmap.getWidth();
            if (this.stripWhitespaceX) {
                int n10;
                int n11;
                block4: for (n2 = 0; n2 < pixmap.getWidth(); ++n2) {
                    for (n8 = n6; n8 < n5; ++n8) {
                        n11 = pixmap.getPixel(n2, n8);
                        n10 = n11 & 0xFF;
                        if (n10 > this.alphaThreshold) break block4;
                    }
                    ++n4;
                }
                n2 = pixmap.getWidth();
                block6: while (--n2 >= n4) {
                    for (n8 = n6; n8 < n5; ++n8) {
                        n11 = pixmap.getPixel(n2, n8);
                        n10 = n11 & 0xFF;
                        if (n10 > this.alphaThreshold) break block6;
                    }
                    --n3;
                }
            }
            n2 = n3 - n4;
            n8 = n5 - n6;
            pixmap2 = new Pixmap(n2, n8, pixmap.getFormat());
            pixmap2.setBlending(Pixmap.Blending.None);
            pixmap2.drawPixmap(pixmap, 0, 0, n4, n6, n2, n8);
            pixmap = pixmap2;
            pixmapPackerRectangle = new PixmapPackerRectangle(0, 0, n2, n8, n4, n6, n9, n7);
        } else {
            pixmapPackerRectangle = new PixmapPackerRectangle(0, 0, pixmap.getWidth(), pixmap.getHeight());
        }
        if (pixmapPackerRectangle.getWidth() > (float)this.pageWidth || pixmapPackerRectangle.getHeight() > (float)this.pageHeight) {
            if (string == null) {
                throw new GdxRuntimeException("Page size too small for pixmap.");
            }
            throw new GdxRuntimeException("Page size too small for pixmap: " + string);
        }
        Page page = this.packStrategy.pack(this, string, pixmapPackerRectangle);
        if (string != null) {
            page.rects.put(string, pixmapPackerRectangle);
            page.addedRects.add(string);
        }
        n7 = (int)pixmapPackerRectangle.x;
        n6 = (int)pixmapPackerRectangle.y;
        n5 = (int)pixmapPackerRectangle.width;
        n4 = (int)pixmapPackerRectangle.height;
        if (this.packToTexture && !this.duplicateBorder && page.texture != null && !page.dirty) {
            page.texture.bind();
            Gdx.gl.glTexSubImage2D(page.texture.glTarget, 0, n7, n6, n5, n4, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
        } else {
            page.dirty = true;
        }
        page.image.drawPixmap(pixmap, n7, n6);
        if (this.duplicateBorder) {
            n3 = pixmap.getWidth();
            n2 = pixmap.getHeight();
            page.image.drawPixmap(pixmap, 0, 0, 1, 1, n7 - 1, n6 - 1, 1, 1);
            page.image.drawPixmap(pixmap, n3 - 1, 0, 1, 1, n7 + n5, n6 - 1, 1, 1);
            page.image.drawPixmap(pixmap, 0, n2 - 1, 1, 1, n7 - 1, n6 + n4, 1, 1);
            page.image.drawPixmap(pixmap, n3 - 1, n2 - 1, 1, 1, n7 + n5, n6 + n4, 1, 1);
            page.image.drawPixmap(pixmap, 0, 0, n3, 1, n7, n6 - 1, n5, 1);
            page.image.drawPixmap(pixmap, 0, n2 - 1, n3, 1, n7, n6 + n4, n5, 1);
            page.image.drawPixmap(pixmap, 0, 0, 1, n2, n7 - 1, n6, 1, n4);
            page.image.drawPixmap(pixmap, n3 - 1, 0, 1, n2, n7 + n5, n6, 1, n4);
        }
        if (pixmap2 != null) {
            pixmap2.dispose();
        }
        return pixmapPackerRectangle;
    }

    public Array<Page> getPages() {
        return this.pages;
    }

    public synchronized Rectangle getRect(String string) {
        for (Page page : this.pages) {
            Rectangle rectangle = (Rectangle)page.rects.get(string);
            if (rectangle == null) continue;
            return rectangle;
        }
        return null;
    }

    public synchronized Page getPage(String string) {
        for (Page page : this.pages) {
            Rectangle rectangle = (Rectangle)page.rects.get(string);
            if (rectangle == null) continue;
            return page;
        }
        return null;
    }

    public synchronized int getPageIndex(String string) {
        for (int i2 = 0; i2 < this.pages.size; ++i2) {
            Rectangle rectangle = (Rectangle)this.pages.get((int)i2).rects.get(string);
            if (rectangle == null) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public synchronized void dispose() {
        for (Page page : this.pages) {
            if (page.texture != null) continue;
            page.image.dispose();
        }
        this.disposed = true;
    }

    public synchronized TextureAtlas generateTextureAtlas(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2) {
        TextureAtlas textureAtlas = new TextureAtlas();
        this.updateTextureAtlas(textureAtlas, textureFilter, textureFilter2, bl2);
        return textureAtlas;
    }

    public synchronized void updateTextureAtlas(TextureAtlas textureAtlas, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2) {
        this.updateTextureAtlas(textureAtlas, textureFilter, textureFilter2, bl2, true);
    }

    public synchronized void updateTextureAtlas(TextureAtlas textureAtlas, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2, boolean bl3) {
        this.updatePageTextures(textureFilter, textureFilter2, bl2);
        for (Page page : this.pages) {
            if (page.addedRects.size <= 0) continue;
            for (String string : page.addedRects) {
                Matcher matcher;
                PixmapPackerRectangle pixmapPackerRectangle = (PixmapPackerRectangle)page.rects.get(string);
                TextureAtlas.AtlasRegion atlasRegion = new TextureAtlas.AtlasRegion(page.texture, (int)pixmapPackerRectangle.x, (int)pixmapPackerRectangle.y, (int)pixmapPackerRectangle.width, (int)pixmapPackerRectangle.height);
                if (pixmapPackerRectangle.splits != null) {
                    atlasRegion.names = new String[]{"split", "pad"};
                    atlasRegion.values = new int[][]{pixmapPackerRectangle.splits, pixmapPackerRectangle.pads};
                }
                int n2 = -1;
                String string2 = string;
                if (bl3 && (matcher = indexPattern.matcher(string2)).matches()) {
                    string2 = matcher.group(1);
                    n2 = Integer.parseInt(matcher.group(2));
                }
                atlasRegion.name = string2;
                atlasRegion.index = n2;
                atlasRegion.offsetX = pixmapPackerRectangle.offsetX;
                atlasRegion.offsetY = (int)((float)pixmapPackerRectangle.originalHeight - pixmapPackerRectangle.height - (float)pixmapPackerRectangle.offsetY);
                atlasRegion.originalWidth = pixmapPackerRectangle.originalWidth;
                atlasRegion.originalHeight = pixmapPackerRectangle.originalHeight;
                textureAtlas.getRegions().add(atlasRegion);
            }
            page.addedRects.clear();
            textureAtlas.getTextures().add(page.texture);
        }
    }

    public synchronized void updateTextureRegions(Array<TextureRegion> array, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2) {
        this.updatePageTextures(textureFilter, textureFilter2, bl2);
        while (array.size < this.pages.size) {
            array.add(new TextureRegion(this.pages.get((int)array.size).texture));
        }
    }

    public synchronized void updatePageTextures(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2) {
        for (Page page : this.pages) {
            page.updateTexture(textureFilter, textureFilter2, bl2);
        }
    }

    public int getPageWidth() {
        return this.pageWidth;
    }

    public void setPageWidth(int n2) {
        this.pageWidth = n2;
    }

    public int getPageHeight() {
        return this.pageHeight;
    }

    public void setPageHeight(int n2) {
        this.pageHeight = n2;
    }

    public Pixmap.Format getPageFormat() {
        return this.pageFormat;
    }

    public void setPageFormat(Pixmap.Format format) {
        this.pageFormat = format;
    }

    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int n2) {
        this.padding = n2;
    }

    public boolean getDuplicateBorder() {
        return this.duplicateBorder;
    }

    public void setDuplicateBorder(boolean bl2) {
        this.duplicateBorder = bl2;
    }

    public boolean getPackToTexture() {
        return this.packToTexture;
    }

    public void setPackToTexture(boolean bl2) {
        this.packToTexture = bl2;
    }

    public Color getTransparentColor() {
        return this.transparentColor;
    }

    public void setTransparentColor(Color color) {
        this.transparentColor.set(color);
    }

    private int[] getSplits(Pixmap pixmap) {
        int n2 = this.getSplitPoint(pixmap, 1, 0, true, true);
        int n3 = this.getSplitPoint(pixmap, n2, 0, false, true);
        int n4 = this.getSplitPoint(pixmap, 0, 1, true, false);
        int n5 = this.getSplitPoint(pixmap, 0, n4, false, false);
        this.getSplitPoint(pixmap, n3 + 1, 0, true, true);
        this.getSplitPoint(pixmap, 0, n5 + 1, true, false);
        if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
            return null;
        }
        if (n2 != 0) {
            --n2;
            n3 = pixmap.getWidth() - 2 - (n3 - 1);
        } else {
            n3 = pixmap.getWidth() - 2;
        }
        n5 = n4 != 0 ? pixmap.getHeight() - 2 - (n5 - 1) : pixmap.getHeight() - 2;
        return new int[]{n2, n3, --n4, n5};
    }

    private int[] getPads(Pixmap pixmap, int[] nArray) {
        int n2 = pixmap.getHeight() - 1;
        int n3 = pixmap.getWidth() - 1;
        int n4 = this.getSplitPoint(pixmap, 1, n2, true, true);
        int n5 = this.getSplitPoint(pixmap, n3, 1, true, false);
        int n6 = 0;
        int n7 = 0;
        if (n4 != 0) {
            n6 = this.getSplitPoint(pixmap, n4 + 1, n2, false, true);
        }
        if (n5 != 0) {
            n7 = this.getSplitPoint(pixmap, n3, n5 + 1, false, false);
        }
        this.getSplitPoint(pixmap, n6 + 1, n2, true, true);
        this.getSplitPoint(pixmap, n3, n7 + 1, true, false);
        if (n4 == 0 && n6 == 0 && n5 == 0 && n7 == 0) {
            return null;
        }
        if (n4 == 0 && n6 == 0) {
            n4 = -1;
            n6 = -1;
        } else if (n4 > 0) {
            --n4;
            n6 = pixmap.getWidth() - 2 - (n6 - 1);
        } else {
            n6 = pixmap.getWidth() - 2;
        }
        if (n5 == 0 && n7 == 0) {
            n5 = -1;
            n7 = -1;
        } else {
            n7 = n5 > 0 ? pixmap.getHeight() - 2 - (n7 - 1) : pixmap.getHeight() - 2;
        }
        int[] nArray2 = new int[]{n4, n6, --n5, n7};
        if (nArray != null && Arrays.equals(nArray2, nArray)) {
            return null;
        }
        return nArray2;
    }

    private int getSplitPoint(Pixmap pixmap, int n2, int n3, boolean bl2, boolean bl3) {
        int[] nArray = new int[4];
        int n4 = bl3 ? pixmap.getWidth() : pixmap.getHeight();
        int n5 = bl2 ? 255 : 0;
        int n6 = n2;
        int n7 = n3;
        for (int i2 = bl3 ? n2 : n3; i2 != n4; ++i2) {
            if (bl3) {
                n6 = i2;
            } else {
                n7 = i2;
            }
            int n8 = pixmap.getPixel(n6, n7);
            this.c.set(n8);
            nArray[0] = (int)(this.c.r * 255.0f);
            nArray[1] = (int)(this.c.g * 255.0f);
            nArray[2] = (int)(this.c.b * 255.0f);
            nArray[3] = (int)(this.c.a * 255.0f);
            if (nArray[3] == n5) {
                return i2;
            }
            if (bl2 || nArray[0] == 0 && nArray[1] == 0 && nArray[2] == 0 && nArray[3] == 255) continue;
            System.out.println(n6 + "  " + n7 + " " + nArray + " ");
        }
        return 0;
    }

    public static class PixmapPackerRectangle
    extends Rectangle {
        int[] splits;
        int[] pads;
        int offsetX;
        int offsetY;
        int originalWidth;
        int originalHeight;

        PixmapPackerRectangle(int n2, int n3, int n4, int n5) {
            super(n2, n3, n4, n5);
            this.offsetX = 0;
            this.offsetY = 0;
            this.originalWidth = n4;
            this.originalHeight = n5;
        }

        PixmapPackerRectangle(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
            super(n2, n3, n4, n5);
            this.offsetX = n6;
            this.offsetY = n7;
            this.originalWidth = n8;
            this.originalHeight = n9;
        }
    }

    public static class SkylineStrategy
    implements PackStrategy {
        Comparator<Pixmap> comparator;

        @Override
        public void sort(Array<Pixmap> array) {
            if (this.comparator == null) {
                this.comparator = new Comparator<Pixmap>(){

                    @Override
                    public int compare(Pixmap pixmap, Pixmap pixmap2) {
                        return pixmap.getHeight() - pixmap2.getHeight();
                    }
                };
            }
            array.sort(this.comparator);
        }

        @Override
        public Page pack(PixmapPacker pixmapPacker, String string, Rectangle rectangle) {
            int n2 = pixmapPacker.padding;
            int n3 = pixmapPacker.pageWidth - n2 * 2;
            int n4 = pixmapPacker.pageHeight - n2 * 2;
            int n5 = (int)rectangle.width + n2;
            int n6 = (int)rectangle.height + n2;
            int n7 = pixmapPacker.pages.size;
            for (int i2 = 0; i2 < n7; ++i2) {
                SkylinePage skylinePage = (SkylinePage)pixmapPacker.pages.get(i2);
                SkylinePage.Row row = null;
                int n8 = skylinePage.rows.size - 1;
                for (int i3 = 0; i3 < n8; ++i3) {
                    SkylinePage.Row row2 = skylinePage.rows.get(i3);
                    if (row2.x + n5 >= n3 || row2.y + n6 >= n4 || n6 > row2.height || row != null && row2.height >= row.height) continue;
                    row = row2;
                }
                if (row == null) {
                    SkylinePage.Row row3 = skylinePage.rows.peek();
                    if (row3.y + n6 >= n4) continue;
                    if (row3.x + n5 < n3) {
                        row3.height = Math.max(row3.height, n6);
                        row = row3;
                    } else if (row3.y + row3.height + n6 < n4) {
                        row = new SkylinePage.Row();
                        row.y = row3.y + row3.height;
                        row.height = n6;
                        skylinePage.rows.add(row);
                    }
                }
                if (row == null) continue;
                rectangle.x = row.x;
                rectangle.y = row.y;
                row.x += n5;
                return skylinePage;
            }
            SkylinePage skylinePage = new SkylinePage(pixmapPacker);
            pixmapPacker.pages.add(skylinePage);
            SkylinePage.Row row = new SkylinePage.Row();
            row.x = n2 + n5;
            row.y = n2;
            row.height = n6;
            skylinePage.rows.add(row);
            rectangle.x = n2;
            rectangle.y = n2;
            return skylinePage;
        }

        static class SkylinePage
        extends Page {
            Array<Row> rows = new Array();

            public SkylinePage(PixmapPacker pixmapPacker) {
                super(pixmapPacker);
            }

            static class Row {
                int x;
                int y;
                int height;

                Row() {
                }
            }
        }
    }

    public static class GuillotineStrategy
    implements PackStrategy {
        Comparator<Pixmap> comparator;

        @Override
        public void sort(Array<Pixmap> array) {
            if (this.comparator == null) {
                this.comparator = new Comparator<Pixmap>(){

                    @Override
                    public int compare(Pixmap pixmap, Pixmap pixmap2) {
                        return Math.max(pixmap.getWidth(), pixmap.getHeight()) - Math.max(pixmap2.getWidth(), pixmap2.getHeight());
                    }
                };
            }
            array.sort(this.comparator);
        }

        @Override
        public Page pack(PixmapPacker pixmapPacker, String string, Rectangle rectangle) {
            GuillotinePage guillotinePage;
            if (pixmapPacker.pages.size == 0) {
                guillotinePage = new GuillotinePage(pixmapPacker);
                pixmapPacker.pages.add(guillotinePage);
            } else {
                guillotinePage = (GuillotinePage)pixmapPacker.pages.peek();
            }
            int n2 = pixmapPacker.padding;
            rectangle.width += (float)n2;
            rectangle.height += (float)n2;
            Node node = this.insert(guillotinePage.root, rectangle);
            if (node == null) {
                guillotinePage = new GuillotinePage(pixmapPacker);
                pixmapPacker.pages.add(guillotinePage);
                node = this.insert(guillotinePage.root, rectangle);
            }
            node.full = true;
            rectangle.set(node.rect.x, node.rect.y, node.rect.width - (float)n2, node.rect.height - (float)n2);
            return guillotinePage;
        }

        private Node insert(Node node, Rectangle rectangle) {
            if (!node.full && node.leftChild != null && node.rightChild != null) {
                Node node2 = this.insert(node.leftChild, rectangle);
                if (node2 == null) {
                    node2 = this.insert(node.rightChild, rectangle);
                }
                return node2;
            }
            if (node.full) {
                return null;
            }
            if (node.rect.width == rectangle.width && node.rect.height == rectangle.height) {
                return node;
            }
            if (node.rect.width < rectangle.width || node.rect.height < rectangle.height) {
                return null;
            }
            node.leftChild = new Node();
            node.rightChild = new Node();
            int n2 = (int)node.rect.width - (int)rectangle.width;
            int n3 = (int)node.rect.height - (int)rectangle.height;
            if (n2 > n3) {
                node.leftChild.rect.x = node.rect.x;
                node.leftChild.rect.y = node.rect.y;
                node.leftChild.rect.width = rectangle.width;
                node.leftChild.rect.height = node.rect.height;
                node.rightChild.rect.x = node.rect.x + rectangle.width;
                node.rightChild.rect.y = node.rect.y;
                node.rightChild.rect.width = node.rect.width - rectangle.width;
                node.rightChild.rect.height = node.rect.height;
            } else {
                node.leftChild.rect.x = node.rect.x;
                node.leftChild.rect.y = node.rect.y;
                node.leftChild.rect.width = node.rect.width;
                node.leftChild.rect.height = rectangle.height;
                node.rightChild.rect.x = node.rect.x;
                node.rightChild.rect.y = node.rect.y + rectangle.height;
                node.rightChild.rect.width = node.rect.width;
                node.rightChild.rect.height = node.rect.height - rectangle.height;
            }
            return this.insert(node.leftChild, rectangle);
        }

        static class GuillotinePage
        extends Page {
            Node root = new Node();

            public GuillotinePage(PixmapPacker pixmapPacker) {
                super(pixmapPacker);
                this.root.rect.x = pixmapPacker.padding;
                this.root.rect.y = pixmapPacker.padding;
                this.root.rect.width = pixmapPacker.pageWidth - pixmapPacker.padding * 2;
                this.root.rect.height = pixmapPacker.pageHeight - pixmapPacker.padding * 2;
            }
        }

        static final class Node {
            public Node leftChild;
            public Node rightChild;
            public final Rectangle rect = new Rectangle();
            public boolean full;

            Node() {
            }
        }
    }

    public static interface PackStrategy {
        public void sort(Array<Pixmap> var1);

        public Page pack(PixmapPacker var1, String var2, Rectangle var3);
    }

    public static class Page {
        OrderedMap<String, PixmapPackerRectangle> rects = new OrderedMap();
        Pixmap image;
        Texture texture;
        final Array<String> addedRects = new Array();
        boolean dirty;

        public Page(PixmapPacker pixmapPacker) {
            this.image = new Pixmap(pixmapPacker.pageWidth, pixmapPacker.pageHeight, pixmapPacker.pageFormat);
            this.image.setBlending(Pixmap.Blending.None);
            this.image.setColor(pixmapPacker.getTransparentColor());
            this.image.fill();
        }

        public Pixmap getPixmap() {
            return this.image;
        }

        public OrderedMap<String, PixmapPackerRectangle> getRects() {
            return this.rects;
        }

        public Texture getTexture() {
            return this.texture;
        }

        public boolean updateTexture(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2) {
            if (this.texture != null) {
                if (!this.dirty) {
                    return false;
                }
                this.texture.load(this.texture.getTextureData());
            } else {
                this.texture = new Texture(new PixmapTextureData(this.image, this.image.getFormat(), bl2, false, true)){

                    @Override
                    public void dispose() {
                        super.dispose();
                        Page.this.image.dispose();
                    }
                };
                this.texture.setFilter(textureFilter, textureFilter2);
            }
            this.dirty = false;
            return true;
        }
    }
}

