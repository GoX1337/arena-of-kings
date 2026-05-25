/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.I18NBundle;
import java.util.Locale;

public class I18NBundleLoader
extends AsynchronousAssetLoader<I18NBundle, I18NBundleParameter> {
    I18NBundle bundle;

    public I18NBundleLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, I18NBundleParameter i18NBundleParameter) {
        String string2;
        Locale locale;
        this.bundle = null;
        if (i18NBundleParameter == null) {
            locale = Locale.getDefault();
            string2 = null;
        } else {
            locale = i18NBundleParameter.locale == null ? Locale.getDefault() : i18NBundleParameter.locale;
            string2 = i18NBundleParameter.encoding;
        }
        this.bundle = string2 == null ? I18NBundle.createBundle(fileHandle, locale) : I18NBundle.createBundle(fileHandle, locale, string2);
    }

    @Override
    public I18NBundle loadSync(AssetManager assetManager, String string, FileHandle fileHandle, I18NBundleParameter i18NBundleParameter) {
        I18NBundle i18NBundle = this.bundle;
        this.bundle = null;
        return i18NBundle;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, I18NBundleParameter i18NBundleParameter) {
        return null;
    }

    public static class I18NBundleParameter
    extends AssetLoaderParameters<I18NBundle> {
        public final Locale locale;
        public final String encoding;

        public I18NBundleParameter() {
            this(null, null);
        }

        public I18NBundleParameter(Locale locale) {
            this(locale, null);
        }

        public I18NBundleParameter(Locale locale, String string) {
            this.locale = locale;
            this.encoding = string;
        }
    }
}

