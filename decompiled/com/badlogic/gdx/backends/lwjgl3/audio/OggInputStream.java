/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.BufferUtils;

public class OggInputStream
extends InputStream {
    private static final int BUFFER_SIZE = 512;
    private int convsize = 2048;
    private byte[] convbuffer;
    private InputStream input;
    private bvz oggInfo = new bvz();
    private boolean endOfStream;
    private bvn syncState = new bvn();
    private bvm streamState = new bvm();
    private bvl page = new bvl();
    private bvk packet = new bvk();
    private bvq comment = new bvq();
    private bvs dspState = new bvs();
    private bvo vorbisBlock = new bvo(this.dspState);
    byte[] buffer;
    int bytes = 0;
    boolean bigEndian = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
    boolean endOfBitStream = true;
    boolean inited = false;
    private int readIndex;
    private ByteBuffer pcmBuffer;
    private int total;

    public OggInputStream(InputStream inputStream) {
        this(inputStream, null);
    }

    public OggInputStream(InputStream inputStream, OggInputStream oggInputStream) {
        if (oggInputStream == null) {
            this.convbuffer = new byte[this.convsize];
            this.pcmBuffer = BufferUtils.createByteBuffer(2048000);
        } else {
            this.convbuffer = oggInputStream.convbuffer;
            this.pcmBuffer = oggInputStream.pcmBuffer;
        }
        this.input = inputStream;
        try {
            this.total = inputStream.available();
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException(iOException);
        }
        this.init();
    }

    public int getLength() {
        return this.total;
    }

    public int getChannels() {
        return this.oggInfo.var_int_b;
    }

    public int getSampleRate() {
        return this.oggInfo.var_int_c;
    }

    private void init() {
        this.initVorbis();
        this.readPCM();
    }

    @Override
    public int available() {
        return this.endOfStream ? 0 : 1;
    }

    private void initVorbis() {
        this.syncState.void_a();
    }

    private boolean getPageAndPacket() {
        int n2 = this.syncState.a(512);
        if (n2 == -1) {
            return false;
        }
        this.buffer = this.syncState.var_byte_arr_a;
        if (this.buffer == null) {
            this.endOfStream = true;
            return false;
        }
        try {
            this.bytes = this.input.read(this.buffer, n2, 512);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Failure reading Vorbis.", exception);
        }
        this.syncState.b(this.bytes);
        if (this.syncState.b(this.page) != 1) {
            if (this.bytes < 512) {
                return false;
            }
            throw new GdxRuntimeException("Input does not appear to be an Ogg bitstream.");
        }
        this.streamState.a(this.page.e());
        this.oggInfo.a();
        this.comment.a();
        if (this.streamState.a(this.page) < 0) {
            throw new GdxRuntimeException("Error reading first page of Ogg bitstream.");
        }
        if (this.streamState.a(this.packet) != 1) {
            throw new GdxRuntimeException("Error reading initial header packet.");
        }
        if (this.oggInfo.a(this.comment, this.packet) < 0) {
            throw new GdxRuntimeException("Ogg bitstream does not contain Vorbis audio data.");
        }
        int n3 = 0;
        while (n3 < 2) {
            int n4;
            while (n3 < 2 && (n4 = this.syncState.b(this.page)) != 0) {
                if (n4 != 1) continue;
                this.streamState.a(this.page);
                while (n3 < 2 && (n4 = this.streamState.a(this.packet)) != 0) {
                    if (n4 == -1) {
                        throw new GdxRuntimeException("Corrupt secondary header.");
                    }
                    this.oggInfo.a(this.comment, this.packet);
                    ++n3;
                }
            }
            n2 = this.syncState.a(512);
            if (n2 == -1) {
                return false;
            }
            this.buffer = this.syncState.var_byte_arr_a;
            try {
                this.bytes = this.input.read(this.buffer, n2, 512);
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Failed to read Vorbis.", exception);
            }
            if (this.bytes == 0 && n3 < 2) {
                throw new GdxRuntimeException("End of file before finding all Vorbis headers.");
            }
            this.syncState.b(this.bytes);
        }
        this.convsize = 512 / this.oggInfo.var_int_b;
        this.dspState.a(this.oggInfo);
        this.vorbisBlock.a(this.dspState);
        return true;
    }

    private void readPCM() {
        boolean bl2 = false;
        while (true) {
            if (this.endOfBitStream) {
                if (!this.getPageAndPacket()) break;
                this.endOfBitStream = false;
            }
            if (!this.inited) {
                this.inited = true;
                return;
            }
            float[][][] fArrayArray = new float[1][][];
            int[] nArray = new int[this.oggInfo.var_int_b];
            while (!this.endOfBitStream) {
                int n2;
                while (!this.endOfBitStream && (n2 = this.syncState.b(this.page)) != 0) {
                    if (n2 == -1) {
                        Gdx.app.log("gdx-audio", "Error reading OGG: Corrupt or missing data in bitstream.");
                        continue;
                    }
                    this.streamState.a(this.page);
                    while ((n2 = this.streamState.a(this.packet)) != 0) {
                        int n3;
                        if (n2 == -1) continue;
                        if (this.vorbisBlock.a(this.packet) == 0) {
                            this.dspState.a(this.vorbisBlock);
                        }
                        while ((n3 = this.dspState.a(fArrayArray, nArray)) > 0) {
                            int n4;
                            float[][] fArray = fArrayArray[0];
                            int n5 = n3 < this.convsize ? n3 : this.convsize;
                            for (n4 = 0; n4 < this.oggInfo.var_int_b; ++n4) {
                                int n6 = n4 * 2;
                                int n7 = nArray[n4];
                                for (int i2 = 0; i2 < n5; ++i2) {
                                    int n8 = (int)((double)fArray[n4][n7 + i2] * 32767.0);
                                    if (n8 > Short.MAX_VALUE) {
                                        n8 = Short.MAX_VALUE;
                                    }
                                    if (n8 < Short.MIN_VALUE) {
                                        n8 = Short.MIN_VALUE;
                                    }
                                    if (n8 < 0) {
                                        n8 |= 0x8000;
                                    }
                                    if (this.bigEndian) {
                                        this.convbuffer[n6] = (byte)(n8 >>> 8);
                                        this.convbuffer[n6 + 1] = (byte)n8;
                                    } else {
                                        this.convbuffer[n6] = (byte)n8;
                                        this.convbuffer[n6 + 1] = (byte)(n8 >>> 8);
                                    }
                                    n6 += 2 * this.oggInfo.var_int_b;
                                }
                            }
                            n4 = 2 * this.oggInfo.var_int_b * n5;
                            if (n4 > this.pcmBuffer.remaining()) {
                                throw new GdxRuntimeException("Ogg block too big to be buffered: " + n4 + " :: " + this.pcmBuffer.remaining());
                            }
                            this.pcmBuffer.put(this.convbuffer, 0, n4);
                            bl2 = true;
                            this.dspState.a(n5);
                        }
                    }
                    if (this.page.d() != 0) {
                        this.endOfBitStream = true;
                    }
                    if (this.endOfBitStream || !bl2) continue;
                    return;
                }
                if (this.endOfBitStream) continue;
                this.bytes = 0;
                n2 = this.syncState.a(512);
                if (n2 >= 0) {
                    this.buffer = this.syncState.var_byte_arr_a;
                    try {
                        this.bytes = this.input.read(this.buffer, n2, 512);
                    }
                    catch (Exception exception) {
                        throw new GdxRuntimeException("Error during Vorbis decoding.", exception);
                    }
                } else {
                    this.bytes = 0;
                }
                this.syncState.b(this.bytes);
                if (this.bytes != 0) continue;
                this.endOfBitStream = true;
            }
            this.streamState.b();
            this.vorbisBlock.a();
            this.dspState.a();
            this.oggInfo.b();
        }
        this.syncState.int_a();
        this.endOfStream = true;
    }

    @Override
    public int read() {
        if (this.readIndex >= this.pcmBuffer.position()) {
            ((Buffer)this.pcmBuffer).clear();
            this.readPCM();
            this.readIndex = 0;
        }
        if (this.readIndex >= this.pcmBuffer.position()) {
            return -1;
        }
        int n2 = this.pcmBuffer.get(this.readIndex);
        if (n2 < 0) {
            n2 = 256 + n2;
        }
        ++this.readIndex;
        return n2;
    }

    public boolean atEnd() {
        return this.endOfStream && this.readIndex >= this.pcmBuffer.position();
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.read();
            if (n4 < 0) {
                if (i2 == 0) {
                    return -1;
                }
                return i2;
            }
            byArray[i2] = (byte)n4;
        }
        return n3;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public void close() {
        StreamUtils.closeQuietly(this.input);
    }
}

