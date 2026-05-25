/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class MapLayer {
    private String name = "";
    private float opacity = 1.0f;
    private boolean visible = true;
    private float offsetX;
    private float offsetY;
    private float renderOffsetX;
    private float renderOffsetY;
    private boolean renderOffsetDirty = true;
    private MapLayer parent;
    private MapObjects objects = new MapObjects();
    private MapProperties properties = new MapProperties();

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public void setOpacity(float f2) {
        this.opacity = f2;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public void setOffsetX(float f2) {
        this.offsetX = f2;
        this.invalidateRenderOffset();
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public void setOffsetY(float f2) {
        this.offsetY = f2;
        this.invalidateRenderOffset();
    }

    public float getRenderOffsetX() {
        if (this.renderOffsetDirty) {
            this.calculateRenderOffsets();
        }
        return this.renderOffsetX;
    }

    public float getRenderOffsetY() {
        if (this.renderOffsetDirty) {
            this.calculateRenderOffsets();
        }
        return this.renderOffsetY;
    }

    public void invalidateRenderOffset() {
        this.renderOffsetDirty = true;
    }

    public MapLayer getParent() {
        return this.parent;
    }

    public void setParent(MapLayer mapLayer) {
        if (mapLayer == this) {
            throw new GdxRuntimeException("Can't set self as the parent");
        }
        this.parent = mapLayer;
    }

    public MapObjects getObjects() {
        return this.objects;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl2) {
        this.visible = bl2;
    }

    public MapProperties getProperties() {
        return this.properties;
    }

    protected void calculateRenderOffsets() {
        if (this.parent != null) {
            this.parent.calculateRenderOffsets();
            this.renderOffsetX = this.parent.getRenderOffsetX() + this.offsetX;
            this.renderOffsetY = this.parent.getRenderOffsetY() + this.offsetY;
        } else {
            this.renderOffsetX = this.offsetX;
            this.renderOffsetY = this.offsetY;
        }
        this.renderOffsetDirty = false;
    }
}

