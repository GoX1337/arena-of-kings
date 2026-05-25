/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class ResolutionFileResolver
implements FileHandleResolver {
    protected final FileHandleResolver baseResolver;
    protected final Resolution[] descriptors;

    public ResolutionFileResolver(FileHandleResolver fileHandleResolver, Resolution ... resolutionArray) {
        if (resolutionArray.length == 0) {
            throw new IllegalArgumentException("At least one Resolution needs to be supplied.");
        }
        this.baseResolver = fileHandleResolver;
        this.descriptors = resolutionArray;
    }

    @Override
    public FileHandle resolve(String string) {
        Resolution resolution = ResolutionFileResolver.choose(this.descriptors);
        FileHandle fileHandle = new FileHandle(string);
        FileHandle fileHandle2 = this.baseResolver.resolve(this.resolve(fileHandle, resolution.folder));
        if (!fileHandle2.exists()) {
            fileHandle2 = this.baseResolver.resolve(string);
        }
        return fileHandle2;
    }

    protected String resolve(FileHandle fileHandle, String string) {
        String string2 = "";
        FileHandle fileHandle2 = fileHandle.parent();
        if (fileHandle2 != null && !fileHandle2.name().equals("")) {
            string2 = fileHandle2 + "/";
        }
        return string2 + string + "/" + fileHandle.name();
    }

    public static Resolution choose(Resolution ... resolutionArray) {
        int n2 = Gdx.graphics.getBackBufferWidth();
        int n3 = Gdx.graphics.getBackBufferHeight();
        Resolution resolution = resolutionArray[0];
        if (n2 < n3) {
            int n4 = resolutionArray.length;
            for (int i2 = 0; i2 < n4; ++i2) {
                Resolution resolution2 = resolutionArray[i2];
                if (n2 < resolution2.portraitWidth || resolution2.portraitWidth < resolution.portraitWidth || n3 < resolution2.portraitHeight || resolution2.portraitHeight < resolution.portraitHeight) continue;
                resolution = resolutionArray[i2];
            }
        } else {
            int n5 = resolutionArray.length;
            for (int i3 = 0; i3 < n5; ++i3) {
                Resolution resolution3 = resolutionArray[i3];
                if (n2 < resolution3.portraitHeight || resolution3.portraitHeight < resolution.portraitHeight || n3 < resolution3.portraitWidth || resolution3.portraitWidth < resolution.portraitWidth) continue;
                resolution = resolutionArray[i3];
            }
        }
        return resolution;
    }

    public static class Resolution {
        public final int portraitWidth;
        public final int portraitHeight;
        public final String folder;

        public Resolution(int n2, int n3, String string) {
            this.portraitWidth = n2;
            this.portraitHeight = n3;
            this.folder = string;
        }
    }
}

