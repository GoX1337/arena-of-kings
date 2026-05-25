/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.GroupPlug;
import com.badlogic.gdx.graphics.g3d.decals.GroupStrategy;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;

public abstract class PluggableGroupStrategy
implements GroupStrategy {
    private IntMap<GroupPlug> plugs = new IntMap();

    @Override
    public void beforeGroup(int n2, Array<Decal> array) {
        this.plugs.get(n2).beforeGroup(array);
    }

    @Override
    public void afterGroup(int n2) {
        this.plugs.get(n2).afterGroup();
    }

    public void plugIn(GroupPlug groupPlug, int n2) {
        this.plugs.put(n2, groupPlug);
    }

    public GroupPlug unPlug(int n2) {
        return this.plugs.remove(n2);
    }
}

