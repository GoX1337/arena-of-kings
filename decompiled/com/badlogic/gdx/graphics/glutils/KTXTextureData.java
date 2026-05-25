/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.ETC1;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.zip.GZIPInputStream;

public class KTXTextureData
implements CubemapData,
TextureData {
    private FileHandle file;
    private int glType;
    private int glTypeSize;
    private int glFormat;
    private int glInternalFormat;
    private int glBaseInternalFormat;
    private int pixelWidth = -1;
    private int pixelHeight = -1;
    private int pixelDepth = -1;
    private int numberOfArrayElements;
    private int numberOfFaces;
    private int numberOfMipmapLevels;
    private int imagePos;
    private ByteBuffer compressedData;
    private boolean useMipMaps;
    private static final int GL_TEXTURE_1D = 4660;
    private static final int GL_TEXTURE_3D = 4660;
    private static final int GL_TEXTURE_1D_ARRAY_EXT = 4660;
    private static final int GL_TEXTURE_2D_ARRAY_EXT = 4660;

    public KTXTextureData(FileHandle fileHandle, boolean bl2) {
        this.file = fileHandle;
        this.useMipMaps = bl2;
    }

    @Override
    public TextureData.TextureDataType getType() {
        return TextureData.TextureDataType.Custom;
    }

    @Override
    public boolean isPrepared() {
        return this.compressedData != null;
    }

    @Override
    public void prepare() {
        int n2;
        int n3;
        block25: {
            block24: {
                if (this.compressedData != null) {
                    throw new GdxRuntimeException("Already prepared");
                }
                if (this.file == null) {
                    throw new GdxRuntimeException("Need a file to load from");
                }
                if (!this.file.name().endsWith(".zktx")) break block24;
                byte[] byArray = new byte[10240];
                DataInputStream dataInputStream = null;
                try {
                    dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(this.file.read())));
                    n3 = dataInputStream.readInt();
                    this.compressedData = BufferUtils.newUnsafeByteBuffer(n3);
                    n2 = 0;
                    while ((n2 = dataInputStream.read(byArray)) != -1) {
                        this.compressedData.put(byArray, 0, n2);
                    }
                    ((Buffer)this.compressedData).position(0);
                    ((Buffer)this.compressedData).limit(this.compressedData.capacity());
                }
                catch (Exception exception) {
                    try {
                        throw new GdxRuntimeException("Couldn't load zktx file '" + this.file + "'", exception);
                    }
                    catch (Throwable throwable) {
                        StreamUtils.closeQuietly(dataInputStream);
                        throw throwable;
                    }
                }
                StreamUtils.closeQuietly(dataInputStream);
                break block25;
            }
            this.compressedData = ByteBuffer.wrap(this.file.readBytes());
        }
        if (this.compressedData.get() != -85) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 75) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 84) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 88) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 32) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 49) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 49) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != -69) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 13) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 10) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 26) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (this.compressedData.get() != 10) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        int n4 = this.compressedData.getInt();
        if (n4 != 67305985 && n4 != 16909060) {
            throw new GdxRuntimeException("Invalid KTX Header");
        }
        if (n4 != 67305985) {
            this.compressedData.order(this.compressedData.order() == ByteOrder.BIG_ENDIAN ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        }
        this.glType = this.compressedData.getInt();
        this.glTypeSize = this.compressedData.getInt();
        this.glFormat = this.compressedData.getInt();
        this.glInternalFormat = this.compressedData.getInt();
        this.glBaseInternalFormat = this.compressedData.getInt();
        this.pixelWidth = this.compressedData.getInt();
        this.pixelHeight = this.compressedData.getInt();
        this.pixelDepth = this.compressedData.getInt();
        this.numberOfArrayElements = this.compressedData.getInt();
        this.numberOfFaces = this.compressedData.getInt();
        this.numberOfMipmapLevels = this.compressedData.getInt();
        if (this.numberOfMipmapLevels == 0) {
            this.numberOfMipmapLevels = 1;
            this.useMipMaps = true;
        }
        int n5 = this.compressedData.getInt();
        this.imagePos = this.compressedData.position() + n5;
        if (!this.compressedData.isDirect()) {
            n3 = this.imagePos;
            for (n2 = 0; n2 < this.numberOfMipmapLevels; ++n2) {
                int n6 = this.compressedData.getInt(n3);
                int n7 = n6 + 3 & 0xFFFFFFFC;
                n3 += n7 * this.numberOfFaces + 4;
            }
            ((Buffer)this.compressedData).limit(n3);
            ((Buffer)this.compressedData).position(0);
            ByteBuffer byteBuffer = BufferUtils.newUnsafeByteBuffer(n3);
            byteBuffer.order(this.compressedData.order());
            byteBuffer.put(this.compressedData);
            this.compressedData = byteBuffer;
        }
    }

    @Override
    public void consumeCubemapData() {
        this.consumeCustomData(34067);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void consumeCustomData(int n2) {
        if (this.compressedData == null) {
            throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
        }
        IntBuffer intBuffer = BufferUtils.newIntBuffer(16);
        boolean bl2 = false;
        if (this.glType == 0 || this.glFormat == 0) {
            if (this.glType + this.glFormat != 0) {
                throw new GdxRuntimeException("either both or none of glType, glFormat must be zero");
            }
            bl2 = true;
        }
        int n3 = 1;
        int n4 = 4660;
        if (this.pixelHeight > 0) {
            n3 = 2;
            n4 = 3553;
        }
        if (this.pixelDepth > 0) {
            n3 = 3;
            n4 = 4660;
        }
        if (this.numberOfFaces == 6) {
            if (n3 != 2) throw new GdxRuntimeException("cube map needs 2D faces");
            n4 = 34067;
        } else if (this.numberOfFaces != 1) {
            throw new GdxRuntimeException("numberOfFaces must be either 1 or 6");
        }
        if (this.numberOfArrayElements > 0) {
            if (n4 == 4660) {
                n4 = 4660;
            } else {
                if (n4 != 3553) throw new GdxRuntimeException("No API for 3D and cube arrays yet");
                n4 = 4660;
            }
            ++n3;
        }
        if (n4 == 4660) {
            throw new GdxRuntimeException("Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
        }
        int n5 = -1;
        if (this.numberOfFaces == 6 && n2 != 34067) {
            if (34069 > n2 || n2 > 34074) {
                throw new GdxRuntimeException("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
            }
            n5 = n2 - 34069;
            n2 = 34069;
        } else if (this.numberOfFaces == 6 && n2 == 34067) {
            n2 = 34069;
        } else if (n2 != n4 && (34069 > n2 || n2 > 34074 || n2 != 3553)) {
            throw new GdxRuntimeException("Invalid target requested : 0x" + Integer.toHexString(n2) + ", expecting : 0x" + Integer.toHexString(n4));
        }
        Gdx.gl.glGetIntegerv(3317, intBuffer);
        int n6 = intBuffer.get(0);
        if (n6 != 4) {
            Gdx.gl.glPixelStorei(3317, 4);
        }
        int n7 = this.glInternalFormat;
        int n8 = this.glFormat;
        int n9 = this.imagePos;
        for (int i2 = 0; i2 < this.numberOfMipmapLevels; ++i2) {
            int n10 = Math.max(1, this.pixelWidth >> i2);
            int n11 = Math.max(1, this.pixelHeight >> i2);
            int n12 = Math.max(1, this.pixelDepth >> i2);
            ((Buffer)this.compressedData).position(n9);
            int n13 = this.compressedData.getInt();
            int n14 = n13 + 3 & 0xFFFFFFFC;
            n9 += 4;
            for (int i3 = 0; i3 < this.numberOfFaces; ++i3) {
                ((Buffer)this.compressedData).position(n9);
                n9 += n14;
                if (n5 != -1 && n5 != i3) continue;
                ByteBuffer byteBuffer = this.compressedData.slice();
                ((Buffer)byteBuffer).limit(n14);
                if (n3 == 1) continue;
                if (n3 == 2) {
                    if (this.numberOfArrayElements > 0) {
                        n11 = this.numberOfArrayElements;
                    }
                    if (bl2) {
                        if (n7 == ETC1.ETC1_RGB8_OES) {
                            if (!Gdx.graphics.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
                                ETC1.ETC1Data eTC1Data = new ETC1.ETC1Data(n10, n11, byteBuffer, 0);
                                Pixmap pixmap = ETC1.decodeImage(eTC1Data, Pixmap.Format.RGB888);
                                Gdx.gl.glTexImage2D(n2 + i3, i2, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
                                pixmap.dispose();
                                continue;
                            }
                            Gdx.gl.glCompressedTexImage2D(n2 + i3, i2, n7, n10, n11, 0, n13, byteBuffer);
                            continue;
                        }
                        Gdx.gl.glCompressedTexImage2D(n2 + i3, i2, n7, n10, n11, 0, n13, byteBuffer);
                        continue;
                    }
                    Gdx.gl.glTexImage2D(n2 + i3, i2, n7, n10, n11, 0, n8, this.glType, byteBuffer);
                    continue;
                }
                if (n3 != 3 || this.numberOfArrayElements <= 0) continue;
                n12 = this.numberOfArrayElements;
            }
        }
        if (n6 != 4) {
            Gdx.gl.glPixelStorei(3317, n6);
        }
        if (this.useMipMaps()) {
            Gdx.gl.glGenerateMipmap(n2);
        }
        this.disposePreparedData();
    }

    public void disposePreparedData() {
        if (this.compressedData != null) {
            BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
        }
        this.compressedData = null;
    }

    @Override
    public Pixmap consumePixmap() {
        throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override
    public boolean disposePixmap() {
        throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override
    public int getWidth() {
        return this.pixelWidth;
    }

    @Override
    public int getHeight() {
        return this.pixelHeight;
    }

    public int getNumberOfMipMapLevels() {
        return this.numberOfMipmapLevels;
    }

    public int getNumberOfFaces() {
        return this.numberOfFaces;
    }

    public int getGlInternalFormat() {
        return this.glInternalFormat;
    }

    public ByteBuffer getData(int n2, int n3) {
        int n4 = this.imagePos;
        for (int i2 = 0; i2 < this.numberOfMipmapLevels; ++i2) {
            int n5 = this.compressedData.getInt(n4);
            int n6 = n5 + 3 & 0xFFFFFFFC;
            n4 += 4;
            if (i2 == n2) {
                for (int i3 = 0; i3 < this.numberOfFaces; ++i3) {
                    if (i3 == n3) {
                        ((Buffer)this.compressedData).position(n4);
                        ByteBuffer byteBuffer = this.compressedData.slice();
                        ((Buffer)byteBuffer).limit(n6);
                        return byteBuffer;
                    }
                    n4 += n6;
                }
                continue;
            }
            n4 += n6 * this.numberOfFaces;
        }
        return null;
    }

    @Override
    public Pixmap.Format getFormat() {
        throw new GdxRuntimeException("This TextureData implementation directly handles texture formats.");
    }

    @Override
    public boolean useMipMaps() {
        return this.useMipMaps;
    }

    @Override
    public boolean isManaged() {
        return true;
    }
}

