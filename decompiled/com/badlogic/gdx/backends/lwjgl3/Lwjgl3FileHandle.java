/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Files;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;

public final class Lwjgl3FileHandle
extends FileHandle {
    public Lwjgl3FileHandle(String string, Files.FileType fileType) {
        super(string, fileType);
    }

    public Lwjgl3FileHandle(File file, Files.FileType fileType) {
        super(file, fileType);
    }

    @Override
    public FileHandle child(String string) {
        if (this.file.getPath().length() == 0) {
            return new Lwjgl3FileHandle(new File(string), this.type);
        }
        return new Lwjgl3FileHandle(new File(this.file, string), this.type);
    }

    @Override
    public FileHandle sibling(String string) {
        if (this.file.getPath().length() == 0) {
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return new Lwjgl3FileHandle(new File(this.file.getParent(), string), this.type);
    }

    @Override
    public FileHandle parent() {
        File file = this.file.getParentFile();
        if (file == null) {
            file = this.type == Files.FileType.Absolute ? new File("/") : new File("");
        }
        return new Lwjgl3FileHandle(file, this.type);
    }

    @Override
    public File file() {
        if (this.type == Files.FileType.External) {
            return new File(Lwjgl3Files.externalPath, this.file.getPath());
        }
        if (this.type == Files.FileType.Local) {
            return new File(Lwjgl3Files.localPath, this.file.getPath());
        }
        return this.file;
    }
}

