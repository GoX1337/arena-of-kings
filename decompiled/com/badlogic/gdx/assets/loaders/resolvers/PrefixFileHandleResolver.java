/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class PrefixFileHandleResolver
implements FileHandleResolver {
    private String prefix;
    private FileHandleResolver baseResolver;

    public PrefixFileHandleResolver(FileHandleResolver fileHandleResolver, String string) {
        this.baseResolver = fileHandleResolver;
        this.prefix = string;
    }

    public void setBaseResolver(FileHandleResolver fileHandleResolver) {
        this.baseResolver = fileHandleResolver;
    }

    public FileHandleResolver getBaseResolver() {
        return this.baseResolver;
    }

    public void setPrefix(String string) {
        this.prefix = string;
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public FileHandle resolve(String string) {
        return this.baseResolver.resolve(this.prefix + string);
    }
}

