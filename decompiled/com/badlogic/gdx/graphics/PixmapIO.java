/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.ByteArray;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class PixmapIO {
    public static void writeCIM(FileHandle fileHandle, Pixmap pixmap) {
        CIM.write(fileHandle, pixmap);
    }

    public static Pixmap readCIM(FileHandle fileHandle) {
        return CIM.read(fileHandle);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void writePNG(FileHandle fileHandle, Pixmap pixmap, int n2, boolean bl2) {
        try {
            PNG pNG = new PNG((int)((float)(pixmap.getWidth() * pixmap.getHeight()) * 1.5f));
            try {
                pNG.setFlipY(bl2);
                pNG.setCompression(n2);
                pNG.write(fileHandle, pixmap);
            }
            finally {
                pNG.dispose();
            }
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error writing PNG: " + fileHandle, iOException);
        }
    }

    public static void writePNG(FileHandle fileHandle, Pixmap pixmap) {
        PixmapIO.writePNG(fileHandle, pixmap, -1, false);
    }

    public static class PNG
    implements Disposable {
        private static final byte[] SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        private static final int IHDR = 1229472850;
        private static final int IDAT = 1229209940;
        private static final int IEND = 1229278788;
        private static final byte COLOR_ARGB = 6;
        private static final byte COMPRESSION_DEFLATE = 0;
        private static final byte FILTER_NONE = 0;
        private static final byte INTERLACE_NONE = 0;
        private static final byte PAETH = 4;
        private final ChunkBuffer buffer;
        private final Deflater deflater;
        private ByteArray lineOutBytes;
        private ByteArray curLineBytes;
        private ByteArray prevLineBytes;
        private boolean flipY = true;
        private int lastLineLen;

        public PNG() {
            this(16384);
        }

        public PNG(int n2) {
            this.buffer = new ChunkBuffer(n2);
            this.deflater = new Deflater();
        }

        public void setFlipY(boolean bl2) {
            this.flipY = bl2;
        }

        public void setCompression(int n2) {
            this.deflater.setLevel(n2);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void write(FileHandle fileHandle, Pixmap pixmap) {
            OutputStream outputStream = fileHandle.write(false);
            try {
                this.write(outputStream, pixmap);
            }
            finally {
                StreamUtils.closeQuietly(outputStream);
            }
        }

        public void write(OutputStream outputStream, Pixmap pixmap) {
            int n2;
            byte[] byArray;
            byte[] byArray2;
            byte[] byArray3;
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream((OutputStream)this.buffer, this.deflater);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(SIGNATURE);
            this.buffer.writeInt(1229472850);
            this.buffer.writeInt(pixmap.getWidth());
            this.buffer.writeInt(pixmap.getHeight());
            this.buffer.writeByte(8);
            this.buffer.writeByte(6);
            this.buffer.writeByte(0);
            this.buffer.writeByte(0);
            this.buffer.writeByte(0);
            this.buffer.endChunk(dataOutputStream);
            this.buffer.writeInt(1229209940);
            this.deflater.reset();
            int n3 = pixmap.getWidth() * 4;
            if (this.lineOutBytes == null) {
                this.lineOutBytes = new ByteArray(n3);
                byArray3 = this.lineOutBytes.items;
                this.curLineBytes = new ByteArray(n3);
                byArray2 = this.curLineBytes.items;
                this.prevLineBytes = new ByteArray(n3);
                byArray = this.prevLineBytes.items;
            } else {
                byArray3 = this.lineOutBytes.ensureCapacity(n3);
                byArray2 = this.curLineBytes.ensureCapacity(n3);
                byArray = this.prevLineBytes.ensureCapacity(n3);
                n2 = this.lastLineLen;
                for (int i2 = 0; i2 < n2; ++i2) {
                    byArray[i2] = 0;
                }
            }
            this.lastLineLen = n3;
            ByteBuffer byteBuffer = pixmap.getPixels();
            n2 = byteBuffer.position();
            boolean bl2 = pixmap.getFormat() == Pixmap.Format.RGBA8888;
            int n4 = pixmap.getHeight();
            for (int i3 = 0; i3 < n4; ++i3) {
                int n5;
                int n6;
                int n7;
                int n8;
                int n9 = n8 = this.flipY ? n4 - i3 - 1 : i3;
                if (bl2) {
                    ((Buffer)byteBuffer).position(n8 * n3);
                    byteBuffer.get(byArray2, 0, n3);
                } else {
                    n7 = 0;
                    for (n6 = 0; n6 < pixmap.getWidth(); ++n6) {
                        n5 = pixmap.getPixel(n6, n8);
                        byArray2[n7++] = (byte)(n5 >> 24 & 0xFF);
                        byArray2[n7++] = (byte)(n5 >> 16 & 0xFF);
                        byArray2[n7++] = (byte)(n5 >> 8 & 0xFF);
                        byArray2[n7++] = (byte)(n5 & 0xFF);
                    }
                }
                byArray3[0] = (byte)(byArray2[0] - byArray[0]);
                byArray3[1] = (byte)(byArray2[1] - byArray[1]);
                byArray3[2] = (byte)(byArray2[2] - byArray[2]);
                byArray3[3] = (byte)(byArray2[3] - byArray[3]);
                for (n6 = 4; n6 < n3; ++n6) {
                    int n10;
                    int n11;
                    n7 = byArray2[n6 - 4] & 0xFF;
                    n5 = byArray[n6] & 0xFF;
                    int n12 = byArray[n6 - 4] & 0xFF;
                    int n13 = n7 + n5 - n12;
                    int n14 = n13 - n7;
                    if (n14 < 0) {
                        n14 = -n14;
                    }
                    if ((n11 = n13 - n5) < 0) {
                        n11 = -n11;
                    }
                    if ((n10 = n13 - n12) < 0) {
                        n10 = -n10;
                    }
                    if (n14 <= n11 && n14 <= n10) {
                        n12 = n7;
                    } else if (n11 <= n10) {
                        n12 = n5;
                    }
                    byArray3[n6] = (byte)(byArray2[n6] - n12);
                }
                deflaterOutputStream.write(4);
                deflaterOutputStream.write(byArray3, 0, n3);
                byte[] byArray4 = byArray2;
                byArray2 = byArray;
                byArray = byArray4;
            }
            ((Buffer)byteBuffer).position(n2);
            deflaterOutputStream.finish();
            this.buffer.endChunk(dataOutputStream);
            this.buffer.writeInt(1229278788);
            this.buffer.endChunk(dataOutputStream);
            outputStream.flush();
        }

        @Override
        public void dispose() {
            this.deflater.end();
        }

        static class ChunkBuffer
        extends DataOutputStream {
            final ByteArrayOutputStream buffer;
            final CRC32 crc;

            ChunkBuffer(int n2) {
                this(new ByteArrayOutputStream(n2), new CRC32());
            }

            private ChunkBuffer(ByteArrayOutputStream byteArrayOutputStream, CRC32 cRC32) {
                super(new CheckedOutputStream(byteArrayOutputStream, cRC32));
                this.buffer = byteArrayOutputStream;
                this.crc = cRC32;
            }

            public void endChunk(DataOutputStream dataOutputStream) {
                this.flush();
                dataOutputStream.writeInt(this.buffer.size() - 4);
                this.buffer.writeTo(dataOutputStream);
                dataOutputStream.writeInt((int)this.crc.getValue());
                this.buffer.reset();
                this.crc.reset();
            }
        }
    }

    static class CIM {
        private static final int BUFFER_SIZE = 32000;
        private static final byte[] writeBuffer = new byte[32000];
        private static final byte[] readBuffer = new byte[32000];

        private CIM() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static void write(FileHandle fileHandle, Pixmap pixmap) {
            DataOutputStream dataOutputStream = null;
            try {
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileHandle.write(false));
                dataOutputStream = new DataOutputStream(deflaterOutputStream);
                dataOutputStream.writeInt(pixmap.getWidth());
                dataOutputStream.writeInt(pixmap.getHeight());
                dataOutputStream.writeInt(Pixmap.Format.toGdx2DPixmapFormat(pixmap.getFormat()));
                ByteBuffer byteBuffer = pixmap.getPixels();
                ((Buffer)byteBuffer).position(0);
                ((Buffer)byteBuffer).limit(byteBuffer.capacity());
                int n2 = byteBuffer.capacity() % 32000;
                int n3 = byteBuffer.capacity() / 32000;
                byte[] byArray = writeBuffer;
                synchronized (writeBuffer) {
                    for (int i2 = 0; i2 < n3; ++i2) {
                        byteBuffer.get(writeBuffer);
                        dataOutputStream.write(writeBuffer);
                    }
                    byteBuffer.get(writeBuffer, 0, n2);
                    dataOutputStream.write(writeBuffer, 0, n2);
                    // ** MonitorExit[var7_8] (shouldn't be in output)
                    ((Buffer)byteBuffer).position(0);
                    ((Buffer)byteBuffer).limit(byteBuffer.capacity());
                }
            }
            catch (Exception exception) {
                try {
                    throw new GdxRuntimeException("Couldn't write Pixmap to file '" + fileHandle + "'", exception);
                }
                catch (Throwable throwable) {
                    StreamUtils.closeQuietly(dataOutputStream);
                    throw throwable;
                }
            }
            {
                StreamUtils.closeQuietly(dataOutputStream);
                return;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static Pixmap read(FileHandle fileHandle) {
            Object object;
            DataInputStream dataInputStream = null;
            try {
                dataInputStream = new DataInputStream(new InflaterInputStream(new BufferedInputStream(fileHandle.read())));
                int n2 = dataInputStream.readInt();
                int n3 = dataInputStream.readInt();
                Pixmap.Format format = Pixmap.Format.fromGdx2DPixmapFormat(dataInputStream.readInt());
                Pixmap pixmap = new Pixmap(n2, n3, format);
                ByteBuffer byteBuffer = pixmap.getPixels();
                ((Buffer)byteBuffer).position(0);
                ((Buffer)byteBuffer).limit(byteBuffer.capacity());
                object = readBuffer;
                synchronized (readBuffer) {
                    int n4 = 0;
                    while ((n4 = dataInputStream.read(readBuffer)) > 0) {
                        byteBuffer.put(readBuffer, 0, n4);
                    }
                    // ** MonitorExit[var7_8 /* !! */ ] (shouldn't be in output)
                    ((Buffer)byteBuffer).position(0);
                    ((Buffer)byteBuffer).limit(byteBuffer.capacity());
                    object = pixmap;
                }
            }
            catch (Exception exception) {
                try {
                    throw new GdxRuntimeException("Couldn't read Pixmap from file '" + fileHandle + "'", exception);
                }
                catch (Throwable throwable) {
                    StreamUtils.closeQuietly(dataInputStream);
                    throw throwable;
                }
            }
            {
                StreamUtils.closeQuietly(dataInputStream);
                return object;
            }
        }
    }
}

