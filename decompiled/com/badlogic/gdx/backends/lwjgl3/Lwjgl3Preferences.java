/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3FileHandle;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Lwjgl3Preferences
implements Preferences {
    private final Properties properties = new Properties();
    private final FileHandle file;

    public Lwjgl3Preferences(String string, String string2) {
        this(new Lwjgl3FileHandle(new File(string2, string), Files.FileType.External));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Lwjgl3Preferences(FileHandle fileHandle) {
        this.file = fileHandle;
        if (!fileHandle.exists()) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(fileHandle.read());
            this.properties.loadFromXML(bufferedInputStream);
        }
        catch (Throwable throwable) {
            try {
                throwable.printStackTrace();
            }
            catch (Throwable throwable2) {
                StreamUtils.closeQuietly(bufferedInputStream);
                throw throwable2;
            }
            StreamUtils.closeQuietly(bufferedInputStream);
        }
        StreamUtils.closeQuietly(bufferedInputStream);
    }

    @Override
    public Preferences putBoolean(String string, boolean bl2) {
        this.properties.put(string, Boolean.toString(bl2));
        return this;
    }

    @Override
    public Preferences putInteger(String string, int n2) {
        this.properties.put(string, Integer.toString(n2));
        return this;
    }

    @Override
    public Preferences putLong(String string, long l2) {
        this.properties.put(string, Long.toString(l2));
        return this;
    }

    @Override
    public Preferences putFloat(String string, float f2) {
        this.properties.put(string, Float.toString(f2));
        return this;
    }

    @Override
    public Preferences putString(String string, String string2) {
        this.properties.put(string, string2);
        return this;
    }

    @Override
    public Preferences put(Map<String, ?> map) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                this.putBoolean(entry.getKey(), (Boolean)entry.getValue());
            }
            if (entry.getValue() instanceof Integer) {
                this.putInteger(entry.getKey(), (Integer)entry.getValue());
            }
            if (entry.getValue() instanceof Long) {
                this.putLong(entry.getKey(), (Long)entry.getValue());
            }
            if (entry.getValue() instanceof String) {
                this.putString(entry.getKey(), (String)entry.getValue());
            }
            if (!(entry.getValue() instanceof Float)) continue;
            this.putFloat(entry.getKey(), ((Float)entry.getValue()).floatValue());
        }
        return this;
    }

    @Override
    public boolean getBoolean(String string) {
        return this.getBoolean(string, false);
    }

    @Override
    public int getInteger(String string) {
        return this.getInteger(string, 0);
    }

    @Override
    public long getLong(String string) {
        return this.getLong(string, 0L);
    }

    @Override
    public float getFloat(String string) {
        return this.getFloat(string, 0.0f);
    }

    @Override
    public String getString(String string) {
        return this.getString(string, "");
    }

    @Override
    public boolean getBoolean(String string, boolean bl2) {
        return Boolean.parseBoolean(this.properties.getProperty(string, Boolean.toString(bl2)));
    }

    @Override
    public int getInteger(String string, int n2) {
        return Integer.parseInt(this.properties.getProperty(string, Integer.toString(n2)));
    }

    @Override
    public long getLong(String string, long l2) {
        return Long.parseLong(this.properties.getProperty(string, Long.toString(l2)));
    }

    @Override
    public float getFloat(String string, float f2) {
        return Float.parseFloat(this.properties.getProperty(string, Float.toString(f2)));
    }

    @Override
    public String getString(String string, String string2) {
        return this.properties.getProperty(string, string2);
    }

    @Override
    public Map<String, ?> get() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Map.Entry<Object, Object> entry : this.properties.entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                hashMap.put((String)entry.getKey(), Boolean.parseBoolean((String)entry.getValue()));
            }
            if (entry.getValue() instanceof Integer) {
                hashMap.put((String)entry.getKey(), Integer.parseInt((String)entry.getValue()));
            }
            if (entry.getValue() instanceof Long) {
                hashMap.put((String)entry.getKey(), Long.parseLong((String)entry.getValue()));
            }
            if (entry.getValue() instanceof String) {
                hashMap.put((String)entry.getKey(), (String)entry.getValue());
            }
            if (!(entry.getValue() instanceof Float)) continue;
            hashMap.put((String)entry.getKey(), Float.valueOf(Float.parseFloat((String)entry.getValue())));
        }
        return hashMap;
    }

    @Override
    public boolean contains(String string) {
        return this.properties.containsKey(string);
    }

    @Override
    public void clear() {
        this.properties.clear();
    }

    @Override
    public void flush() {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(this.file.write(false));
            this.properties.storeToXML(bufferedOutputStream, null);
        }
        catch (Exception exception) {
            try {
                throw new GdxRuntimeException("Error writing preferences: " + this.file, exception);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(bufferedOutputStream);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(bufferedOutputStream);
    }

    @Override
    public void remove(String string) {
        this.properties.remove(string);
    }
}

