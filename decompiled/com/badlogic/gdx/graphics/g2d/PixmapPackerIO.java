/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import java.io.Writer;
import java.util.regex.Matcher;

public class PixmapPackerIO {
    public void save(FileHandle fileHandle, PixmapPacker pixmapPacker) {
        this.save(fileHandle, pixmapPacker, new SaveParameters());
    }

    public void save(FileHandle fileHandle, PixmapPacker pixmapPacker, SaveParameters saveParameters) {
        Writer writer = fileHandle.writer(false);
        int n2 = 0;
        for (PixmapPacker.Page page : pixmapPacker.pages) {
            if (page.rects.size <= 0) continue;
            FileHandle fileHandle2 = fileHandle.sibling(fileHandle.nameWithoutExtension() + "_" + ++n2 + saveParameters.format.getExtension());
            switch (saveParameters.format) {
                case CIM: {
                    PixmapIO.writeCIM(fileHandle2, page.image);
                    break;
                }
                case PNG: {
                    PixmapIO.writePNG(fileHandle2, page.image);
                }
            }
            writer.write("\n");
            writer.write(fileHandle2.name() + "\n");
            writer.write("size: " + page.image.getWidth() + "," + page.image.getHeight() + "\n");
            writer.write("format: " + pixmapPacker.pageFormat.name() + "\n");
            writer.write("filter: " + saveParameters.minFilter.name() + "," + saveParameters.magFilter.name() + "\n");
            writer.write("repeat: none\n");
            for (String string : page.rects.keys()) {
                Object object;
                int n3 = -1;
                String string2 = string;
                if (saveParameters.useIndexes && ((Matcher)(object = PixmapPacker.indexPattern.matcher(string2))).matches()) {
                    string2 = ((Matcher)object).group(1);
                    n3 = Integer.parseInt(((Matcher)object).group(2));
                }
                writer.write(string2 + "\n");
                object = (PixmapPacker.PixmapPackerRectangle)page.rects.get(string);
                writer.write("  rotate: false\n");
                writer.write("  xy: " + (int)((PixmapPacker.PixmapPackerRectangle)object).x + "," + (int)((PixmapPacker.PixmapPackerRectangle)object).y + "\n");
                writer.write("  size: " + (int)((PixmapPacker.PixmapPackerRectangle)object).width + "," + (int)((PixmapPacker.PixmapPackerRectangle)object).height + "\n");
                if (((PixmapPacker.PixmapPackerRectangle)object).splits != null) {
                    writer.write("  split: " + ((PixmapPacker.PixmapPackerRectangle)object).splits[0] + ", " + ((PixmapPacker.PixmapPackerRectangle)object).splits[1] + ", " + ((PixmapPacker.PixmapPackerRectangle)object).splits[2] + ", " + ((PixmapPacker.PixmapPackerRectangle)object).splits[3] + "\n");
                    if (((PixmapPacker.PixmapPackerRectangle)object).pads != null) {
                        writer.write("  pad: " + ((PixmapPacker.PixmapPackerRectangle)object).pads[0] + ", " + ((PixmapPacker.PixmapPackerRectangle)object).pads[1] + ", " + ((PixmapPacker.PixmapPackerRectangle)object).pads[2] + ", " + ((PixmapPacker.PixmapPackerRectangle)object).pads[3] + "\n");
                    }
                }
                writer.write("  orig: " + ((PixmapPacker.PixmapPackerRectangle)object).originalWidth + ", " + ((PixmapPacker.PixmapPackerRectangle)object).originalHeight + "\n");
                writer.write("  offset: " + ((PixmapPacker.PixmapPackerRectangle)object).offsetX + ", " + (int)((float)((PixmapPacker.PixmapPackerRectangle)object).originalHeight - ((PixmapPacker.PixmapPackerRectangle)object).height - (float)((PixmapPacker.PixmapPackerRectangle)object).offsetY) + "\n");
                writer.write("  index: " + n3 + "\n");
            }
        }
        writer.close();
    }

    public static class SaveParameters {
        public ImageFormat format = ImageFormat.PNG;
        public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
        public boolean useIndexes;
    }

    public static enum ImageFormat {
        CIM(".cim"),
        PNG(".png");

        private final String extension;

        public String getExtension() {
            return this.extension;
        }

        private ImageFormat(String string2) {
            this.extension = string2;
        }
    }
}

