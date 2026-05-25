/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ETC1 {
    public static int PKM_HEADER_SIZE = 16;
    public static int ETC1_RGB8_OES = 36196;

    private static int getPixelSize(Pixmap.Format format) {
        if (format == Pixmap.Format.RGB565) {
            return 2;
        }
        if (format == Pixmap.Format.RGB888) {
            return 3;
        }
        throw new GdxRuntimeException("Can only handle RGB565 or RGB888 images");
    }

    public static ETC1Data encodeImage(Pixmap pixmap) {
        int n2 = ETC1.getPixelSize(pixmap.getFormat());
        ByteBuffer byteBuffer = ETC1.encodeImage(pixmap.getPixels(), 0, pixmap.getWidth(), pixmap.getHeight(), n2);
        BufferUtils.newUnsafeByteBuffer(byteBuffer);
        return new ETC1Data(pixmap.getWidth(), pixmap.getHeight(), byteBuffer, 0);
    }

    public static ETC1Data encodeImagePKM(Pixmap pixmap) {
        int n2 = ETC1.getPixelSize(pixmap.getFormat());
        ByteBuffer byteBuffer = ETC1.encodeImagePKM(pixmap.getPixels(), 0, pixmap.getWidth(), pixmap.getHeight(), n2);
        BufferUtils.newUnsafeByteBuffer(byteBuffer);
        return new ETC1Data(pixmap.getWidth(), pixmap.getHeight(), byteBuffer, 16);
    }

    public static Pixmap decodeImage(ETC1Data eTC1Data, Pixmap.Format format) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (eTC1Data.hasPKMHeader()) {
            n2 = 16;
            n3 = ETC1.getWidthPKM(eTC1Data.compressedData, 0);
            n4 = ETC1.getHeightPKM(eTC1Data.compressedData, 0);
        } else {
            n2 = 0;
            n3 = eTC1Data.width;
            n4 = eTC1Data.height;
        }
        int n5 = ETC1.getPixelSize(format);
        Pixmap pixmap = new Pixmap(n3, n4, format);
        ETC1.decodeImage(eTC1Data.compressedData, n2, pixmap.getPixels(), 0, n3, n4, n5);
        return pixmap;
    }

    public static native int getCompressedDataSize(int var0, int var1);

    public static native void formatHeader(ByteBuffer var0, int var1, int var2, int var3);

    static native int getWidthPKM(ByteBuffer var0, int var1);

    static native int getHeightPKM(ByteBuffer var0, int var1);

    static native boolean isValidPKM(ByteBuffer var0, int var1);

    private static native void decodeImage(ByteBuffer var0, int var1, ByteBuffer var2, int var3, int var4, int var5, int var6);

    private static native ByteBuffer encodeImage(ByteBuffer var0, int var1, int var2, int var3, int var4);

    private static native ByteBuffer encodeImagePKM(ByteBuffer var0, int var1, int var2, int var3, int var4);

    public static final class ETC1Data
    implements Disposable {
        public final int width;
        public final int height;
        public final ByteBuffer compressedData;
        public final int dataOffset;

        public ETC1Data(int n2, int n3, ByteBuffer byteBuffer, int n4) {
            this.width = n2;
            this.height = n3;
            this.compressedData = byteBuffer;
            this.dataOffset = n4;
            this.checkNPOT();
        }

        public ETC1Data(FileHandle fileHandle) {
            byte[] byArray = new byte[10240];
            DataInputStream dataInputStream = null;
            try {
                dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(fileHandle.read())));
                int n2 = dataInputStream.readInt();
                this.compressedData = BufferUtils.newUnsafeByteBuffer(n2);
                int n3 = 0;
                while ((n3 = dataInputStream.read(byArray)) != -1) {
                    this.compressedData.put(byArray, 0, n3);
                }
                ((Buffer)this.compressedData).position(0);
                ((Buffer)this.compressedData).limit(this.compressedData.capacity());
            }
            catch (Exception exception) {
                try {
                    throw new GdxRuntimeException("Couldn't load pkm file '" + fileHandle + "'", exception);
                }
                catch (Throwable throwable) {
                    StreamUtils.closeQuietly(dataInputStream);
                    throw throwable;
                }
            }
            StreamUtils.closeQuietly(dataInputStream);
            this.width = ETC1.getWidthPKM(this.compressedData, 0);
            this.height = ETC1.getHeightPKM(this.compressedData, 0);
            this.dataOffset = PKM_HEADER_SIZE;
            ((Buffer)this.compressedData).position(this.dataOffset);
            this.checkNPOT();
        }

        private void checkNPOT() {
            if (!MathUtils.isPowerOfTwo(this.width) || !MathUtils.isPowerOfTwo(this.height)) {
                System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
            }
        }

        public boolean hasPKMHeader() {
            return this.dataOffset == 16;
        }

        public void write(FileHandle fileHandle) {
            DataOutputStream dataOutputStream = null;
            byte[] byArray = new byte[10240];
            ((Buffer)this.compressedData).position(0);
            ((Buffer)this.compressedData).limit(this.compressedData.capacity());
            try {
                int n2;
                dataOutputStream = new DataOutputStream(new GZIPOutputStream(fileHandle.write(false)));
                dataOutputStream.writeInt(this.compressedData.capacity());
                for (int i2 = 0; i2 != this.compressedData.capacity(); i2 += n2) {
                    n2 = Math.min(this.compressedData.remaining(), byArray.length);
                    this.compressedData.get(byArray, 0, n2);
                    dataOutputStream.write(byArray, 0, n2);
                }
            }
            catch (Exception exception) {
                try {
                    throw new GdxRuntimeException("Couldn't write PKM file to '" + fileHandle + "'", exception);
                }
                catch (Throwable throwable) {
                    StreamUtils.closeQuietly(dataOutputStream);
                    throw throwable;
                }
            }
            StreamUtils.closeQuietly(dataOutputStream);
            ((Buffer)this.compressedData).position(this.dataOffset);
            ((Buffer)this.compressedData).limit(this.compressedData.capacity());
        }

        @Override
        public void dispose() {
            BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
        }

        public String toString() {
            if (this.hasPKMHeader()) {
                return (ETC1.isValidPKM(this.compressedData, 0) ? "valid" : "invalid") + " pkm [" + ETC1.getWidthPKM(this.compressedData, 0) + "x" + ETC1.getHeightPKM(this.compressedData, 0) + "], compressed: " + (this.compressedData.capacity() - PKM_HEADER_SIZE);
            }
            return "raw [" + this.width + "x" + this.height + "], compressed: " + (this.compressedData.capacity() - PKM_HEADER_SIZE);
        }
    }
}

