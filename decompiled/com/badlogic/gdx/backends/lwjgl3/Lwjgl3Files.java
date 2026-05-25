/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3FileHandle;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;

public final class Lwjgl3Files
implements Files {
    public static final String externalPath = System.getProperty("user.home") + File.separator;
    public static final String localPath = new File("").getAbsolutePath() + File.separator;

    @Override
    public FileHandle getFileHandle(String string, Files.FileType fileType) {
        return new Lwjgl3FileHandle(string, fileType);
    }

    @Override
    public FileHandle classpath(String string) {
        return new Lwjgl3FileHandle(string, Files.FileType.Classpath);
    }

    @Override
    public FileHandle internal(String string) {
        return new Lwjgl3FileHandle(string, Files.FileType.Internal);
    }

    @Override
    public FileHandle external(String string) {
        return new Lwjgl3FileHandle(string, Files.FileType.External);
    }

    @Override
    public FileHandle absolute(String string) {
        return new Lwjgl3FileHandle(string, Files.FileType.Absolute);
    }

    @Override
    public FileHandle local(String string) {
        return new Lwjgl3FileHandle(string, Files.FileType.Local);
    }

    @Override
    public String getExternalStoragePath() {
        return externalPath;
    }

    @Override
    public boolean isExternalStorageAvailable() {
        return true;
    }

    @Override
    public String getLocalStoragePath() {
        return localPath;
    }

    @Override
    public boolean isLocalStorageAvailable() {
        return true;
    }
}

