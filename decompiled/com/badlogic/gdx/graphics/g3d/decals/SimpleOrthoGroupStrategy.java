/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.GroupStrategy;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Sort;

public class SimpleOrthoGroupStrategy
implements GroupStrategy {
    private Comparator comparator = new Comparator();
    private static final int GROUP_OPAQUE = 0;
    private static final int GROUP_BLEND = 1;

    @Override
    public int decideGroup(Decal decal) {
        return decal.getMaterial().isOpaque() ? 0 : 1;
    }

    @Override
    public void beforeGroup(int n2, Array<Decal> array) {
        if (n2 == 1) {
            Sort.instance().sort(array, this.comparator);
            Gdx.gl.glEnable(3042);
            Gdx.gl.glDepthMask(false);
        }
    }

    @Override
    public void afterGroup(int n2) {
        if (n2 == 1) {
            Gdx.gl.glDepthMask(true);
            Gdx.gl.glDisable(3042);
        }
    }

    @Override
    public void beforeGroups() {
        Gdx.gl.glEnable(3553);
    }

    @Override
    public void afterGroups() {
        Gdx.gl.glDisable(3553);
    }

    @Override
    public ShaderProgram getGroupShader(int n2) {
        return null;
    }

    class Comparator
    implements java.util.Comparator<Decal> {
        Comparator() {
        }

        @Override
        public int compare(Decal decal, Decal decal2) {
            if (decal.getZ() == decal2.getZ()) {
                return 0;
            }
            return decal.getZ() - decal2.getZ() < 0.0f ? -1 : 1;
        }
    }
}

