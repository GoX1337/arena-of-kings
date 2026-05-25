/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.BaseJsonReader;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UBJsonReader
implements BaseJsonReader {
    public boolean oldFormat = true;

    @Override
    public JsonValue parse(InputStream inputStream) {
        JsonValue jsonValue;
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(inputStream);
            jsonValue = this.parse(dataInputStream);
        }
        catch (IOException iOException) {
            try {
                throw new SerializationException(iOException);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(dataInputStream);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(dataInputStream);
        return jsonValue;
    }

    @Override
    public JsonValue parse(FileHandle fileHandle) {
        try {
            return this.parse(fileHandle.read(8192));
        }
        catch (Exception exception) {
            throw new SerializationException("Error parsing file: " + fileHandle, exception);
        }
    }

    public JsonValue parse(DataInputStream dataInputStream) {
        try {
            JsonValue jsonValue = this.parse(dataInputStream, dataInputStream.readByte());
            return jsonValue;
        }
        finally {
            StreamUtils.closeQuietly(dataInputStream);
        }
    }

    protected JsonValue parse(DataInputStream dataInputStream, byte by2) {
        if (by2 == 91) {
            return this.parseArray(dataInputStream);
        }
        if (by2 == 123) {
            return this.parseObject(dataInputStream);
        }
        if (by2 == 90) {
            return new JsonValue(JsonValue.ValueType.nullValue);
        }
        if (by2 == 84) {
            return new JsonValue(true);
        }
        if (by2 == 70) {
            return new JsonValue(false);
        }
        if (by2 == 66) {
            return new JsonValue(this.readUChar(dataInputStream));
        }
        if (by2 == 85) {
            return new JsonValue(this.readUChar(dataInputStream));
        }
        if (by2 == 105) {
            return new JsonValue(this.oldFormat ? (long)dataInputStream.readShort() : (long)dataInputStream.readByte());
        }
        if (by2 == 73) {
            return new JsonValue(this.oldFormat ? (long)dataInputStream.readInt() : (long)dataInputStream.readShort());
        }
        if (by2 == 108) {
            return new JsonValue(dataInputStream.readInt());
        }
        if (by2 == 76) {
            return new JsonValue(dataInputStream.readLong());
        }
        if (by2 == 100) {
            return new JsonValue(dataInputStream.readFloat());
        }
        if (by2 == 68) {
            return new JsonValue(dataInputStream.readDouble());
        }
        if (by2 == 115 || by2 == 83) {
            return new JsonValue(this.parseString(dataInputStream, by2));
        }
        if (by2 == 97 || by2 == 65) {
            return this.parseData(dataInputStream, by2);
        }
        if (by2 == 67) {
            return new JsonValue(dataInputStream.readChar());
        }
        throw new GdxRuntimeException("Unrecognized data type");
    }

    protected JsonValue parseArray(DataInputStream dataInputStream) {
        JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
        byte by2 = dataInputStream.readByte();
        byte by3 = 0;
        if (by2 == 36) {
            by3 = dataInputStream.readByte();
            by2 = dataInputStream.readByte();
        }
        long l2 = -1L;
        if (by2 == 35) {
            l2 = this.parseSize(dataInputStream, false, -1L);
            if (l2 < 0L) {
                throw new GdxRuntimeException("Unrecognized data type");
            }
            if (l2 == 0L) {
                return jsonValue;
            }
            by2 = by3 == 0 ? dataInputStream.readByte() : by3;
        }
        JsonValue jsonValue2 = null;
        long l3 = 0L;
        while (dataInputStream.available() > 0 && by2 != 93) {
            JsonValue jsonValue3 = this.parse(dataInputStream, by2);
            jsonValue3.parent = jsonValue;
            if (jsonValue2 != null) {
                jsonValue3.prev = jsonValue2;
                jsonValue2.next = jsonValue3;
                ++jsonValue.size;
            } else {
                jsonValue.child = jsonValue3;
                jsonValue.size = 1;
            }
            jsonValue2 = jsonValue3;
            if (l2 > 0L && ++l3 >= l2) break;
            by2 = by3 == 0 ? dataInputStream.readByte() : by3;
        }
        return jsonValue;
    }

    protected JsonValue parseObject(DataInputStream dataInputStream) {
        JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
        byte by2 = dataInputStream.readByte();
        byte by3 = 0;
        if (by2 == 36) {
            by3 = dataInputStream.readByte();
            by2 = dataInputStream.readByte();
        }
        long l2 = -1L;
        if (by2 == 35) {
            l2 = this.parseSize(dataInputStream, false, -1L);
            if (l2 < 0L) {
                throw new GdxRuntimeException("Unrecognized data type");
            }
            if (l2 == 0L) {
                return jsonValue;
            }
            by2 = dataInputStream.readByte();
        }
        JsonValue jsonValue2 = null;
        long l3 = 0L;
        while (dataInputStream.available() > 0 && by2 != 125) {
            String string = this.parseString(dataInputStream, true, by2);
            JsonValue jsonValue3 = this.parse(dataInputStream, by3 == 0 ? dataInputStream.readByte() : by3);
            jsonValue3.setName(string);
            jsonValue3.parent = jsonValue;
            if (jsonValue2 != null) {
                jsonValue3.prev = jsonValue2;
                jsonValue2.next = jsonValue3;
                ++jsonValue.size;
            } else {
                jsonValue.child = jsonValue3;
                jsonValue.size = 1;
            }
            jsonValue2 = jsonValue3;
            if (l2 > 0L && ++l3 >= l2) break;
            by2 = dataInputStream.readByte();
        }
        return jsonValue;
    }

    protected JsonValue parseData(DataInputStream dataInputStream, byte by2) {
        byte by3 = dataInputStream.readByte();
        long l2 = by2 == 65 ? this.readUInt(dataInputStream) : (long)this.readUChar(dataInputStream);
        JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
        JsonValue jsonValue2 = null;
        for (long i2 = 0L; i2 < l2; ++i2) {
            JsonValue jsonValue3 = this.parse(dataInputStream, by3);
            jsonValue3.parent = jsonValue;
            if (jsonValue2 != null) {
                jsonValue2.next = jsonValue3;
                ++jsonValue.size;
            } else {
                jsonValue.child = jsonValue3;
                jsonValue.size = 1;
            }
            jsonValue2 = jsonValue3;
        }
        return jsonValue;
    }

    protected String parseString(DataInputStream dataInputStream, byte by2) {
        return this.parseString(dataInputStream, false, by2);
    }

    protected String parseString(DataInputStream dataInputStream, boolean bl2, byte by2) {
        long l2 = -1L;
        if (by2 == 83) {
            l2 = this.parseSize(dataInputStream, true, -1L);
        } else if (by2 == 115) {
            l2 = this.readUChar(dataInputStream);
        } else if (bl2) {
            l2 = this.parseSize(dataInputStream, by2, false, -1L);
        }
        if (l2 < 0L) {
            throw new GdxRuntimeException("Unrecognized data type, string expected");
        }
        return l2 > 0L ? this.readString(dataInputStream, l2) : "";
    }

    protected long parseSize(DataInputStream dataInputStream, boolean bl2, long l2) {
        return this.parseSize(dataInputStream, dataInputStream.readByte(), bl2, l2);
    }

    protected long parseSize(DataInputStream dataInputStream, byte by2, boolean bl2, long l2) {
        if (by2 == 105) {
            return this.readUChar(dataInputStream);
        }
        if (by2 == 73) {
            return this.readUShort(dataInputStream);
        }
        if (by2 == 108) {
            return this.readUInt(dataInputStream);
        }
        if (by2 == 76) {
            return dataInputStream.readLong();
        }
        if (bl2) {
            long l3 = (long)((short)by2 & 0xFF) << 24;
            l3 |= (long)((short)dataInputStream.readByte() & 0xFF) << 16;
            l3 |= (long)((short)dataInputStream.readByte() & 0xFF) << 8;
            return l3 |= (long)((short)dataInputStream.readByte() & 0xFF);
        }
        return l2;
    }

    protected short readUChar(DataInputStream dataInputStream) {
        return (short)((short)dataInputStream.readByte() & 0xFF);
    }

    protected int readUShort(DataInputStream dataInputStream) {
        return dataInputStream.readShort() & 0xFFFF;
    }

    protected long readUInt(DataInputStream dataInputStream) {
        return (long)dataInputStream.readInt() & 0xFFFFFFFFFFFFFFFFL;
    }

    protected String readString(DataInputStream dataInputStream, long l2) {
        byte[] byArray = new byte[(int)l2];
        dataInputStream.readFully(byArray);
        return new String(byArray, "UTF-8");
    }
}

