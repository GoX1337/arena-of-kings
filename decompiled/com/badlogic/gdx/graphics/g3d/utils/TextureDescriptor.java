/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture;

public class TextureDescriptor<T extends GLTexture>
implements Comparable<TextureDescriptor<T>> {
    public T texture = null;
    public Texture.TextureFilter minFilter;
    public Texture.TextureFilter magFilter;
    public Texture.TextureWrap uWrap;
    public Texture.TextureWrap vWrap;

    public TextureDescriptor(T t2, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        this.set(t2, textureFilter, textureFilter2, textureWrap, textureWrap2);
    }

    public TextureDescriptor(T t2) {
        this(t2, null, null, null, null);
    }

    public TextureDescriptor() {
    }

    public void set(T t2, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        this.texture = t2;
        this.minFilter = textureFilter;
        this.magFilter = textureFilter2;
        this.uWrap = textureWrap;
        this.vWrap = textureWrap2;
    }

    public <V extends T> void set(TextureDescriptor<V> textureDescriptor) {
        this.texture = textureDescriptor.texture;
        this.minFilter = textureDescriptor.minFilter;
        this.magFilter = textureDescriptor.magFilter;
        this.uWrap = textureDescriptor.uWrap;
        this.vWrap = textureDescriptor.vWrap;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextureDescriptor)) {
            return false;
        }
        TextureDescriptor textureDescriptor = (TextureDescriptor)object;
        return textureDescriptor.texture == this.texture && textureDescriptor.minFilter == this.minFilter && textureDescriptor.magFilter == this.magFilter && textureDescriptor.uWrap == this.uWrap && textureDescriptor.vWrap == this.vWrap;
    }

    public int hashCode() {
        long l2 = this.texture == null ? 0 : ((GLTexture)this.texture).glTarget;
        l2 = 811L * l2 + (long)(this.texture == null ? 0 : ((GLTexture)this.texture).getTextureObjectHandle());
        l2 = 811L * l2 + (long)(this.minFilter == null ? 0 : this.minFilter.getGLEnum());
        l2 = 811L * l2 + (long)(this.magFilter == null ? 0 : this.magFilter.getGLEnum());
        l2 = 811L * l2 + (long)(this.uWrap == null ? 0 : this.uWrap.getGLEnum());
        l2 = 811L * l2 + (long)(this.vWrap == null ? 0 : this.vWrap.getGLEnum());
        return (int)(l2 ^ l2 >> 32);
    }

    @Override
    public int compareTo(TextureDescriptor<T> textureDescriptor) {
        int n2;
        int n3;
        if (textureDescriptor == this) {
            return 0;
        }
        int n4 = this.texture == null ? 0 : ((GLTexture)this.texture).glTarget;
        int n5 = n3 = textureDescriptor.texture == null ? 0 : ((GLTexture)textureDescriptor.texture).glTarget;
        if (n4 != n3) {
            return n4 - n3;
        }
        int n6 = this.texture == null ? 0 : ((GLTexture)this.texture).getTextureObjectHandle();
        int n7 = n2 = textureDescriptor.texture == null ? 0 : ((GLTexture)textureDescriptor.texture).getTextureObjectHandle();
        if (n6 != n2) {
            return n6 - n2;
        }
        if (this.minFilter != textureDescriptor.minFilter) {
            return (this.minFilter == null ? 0 : this.minFilter.getGLEnum()) - (textureDescriptor.minFilter == null ? 0 : textureDescriptor.minFilter.getGLEnum());
        }
        if (this.magFilter != textureDescriptor.magFilter) {
            return (this.magFilter == null ? 0 : this.magFilter.getGLEnum()) - (textureDescriptor.magFilter == null ? 0 : textureDescriptor.magFilter.getGLEnum());
        }
        if (this.uWrap != textureDescriptor.uWrap) {
            return (this.uWrap == null ? 0 : this.uWrap.getGLEnum()) - (textureDescriptor.uWrap == null ? 0 : textureDescriptor.uWrap.getGLEnum());
        }
        if (this.vWrap != textureDescriptor.vWrap) {
            return (this.vWrap == null ? 0 : this.vWrap.getGLEnum()) - (textureDescriptor.vWrap == null ? 0 : textureDescriptor.vWrap.getGLEnum());
        }
        return 0;
    }
}

