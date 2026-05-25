/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.MapProperties;

public class MapObject {
    private String name = "";
    private float opacity = 1.0f;
    private boolean visible = true;
    private MapProperties properties = new MapProperties();
    private Color color = Color.WHITE.cpy();

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public void setOpacity(float f2) {
        this.opacity = f2;
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
}

