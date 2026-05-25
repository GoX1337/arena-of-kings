/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;

public class RenderContext {
    public final TextureBinder textureBinder;
    private boolean blending;
    private int blendSFactor;
    private int blendDFactor;
    private int depthFunc;
    private float depthRangeNear;
    private float depthRangeFar;
    private boolean depthMask;
    private int cullFace;

    public RenderContext(TextureBinder textureBinder) {
        this.textureBinder = textureBinder;
    }

    public void begin() {
        Gdx.gl.glDisable(2929);
        this.depthFunc = 0;
        Gdx.gl.glDepthMask(true);
        this.depthMask = true;
        Gdx.gl.glDisable(3042);
        this.blending = false;
        Gdx.gl.glDisable(2884);
        this.blendDFactor = 0;
        this.blendSFactor = 0;
        this.cullFace = 0;
        this.textureBinder.begin();
    }

    public void end() {
        if (this.depthFunc != 0) {
            Gdx.gl.glDisable(2929);
        }
        if (!this.depthMask) {
            Gdx.gl.glDepthMask(true);
        }
        if (this.blending) {
            Gdx.gl.glDisable(3042);
        }
        if (this.cullFace > 0) {
            Gdx.gl.glDisable(2884);
        }
        this.textureBinder.end();
    }

    public void setDepthMask(boolean bl2) {
        if (this.depthMask != bl2) {
            this.depthMask = bl2;
            Gdx.gl.glDepthMask(this.depthMask);
        }
    }

    public void setDepthTest(int n2) {
        this.setDepthTest(n2, 0.0f, 1.0f);
    }

    public void setDepthTest(int n2, float f2, float f3) {
        boolean bl2;
        boolean bl3 = this.depthFunc != 0;
        boolean bl4 = bl2 = n2 != 0;
        if (this.depthFunc != n2) {
            this.depthFunc = n2;
            if (bl2) {
                Gdx.gl.glEnable(2929);
                Gdx.gl.glDepthFunc(n2);
            } else {
                Gdx.gl.glDisable(2929);
            }
        }
        if (bl2) {
            if (!bl3 || this.depthFunc != n2) {
                this.depthFunc = n2;
                Gdx.gl.glDepthFunc(this.depthFunc);
            }
            if (!bl3 || this.depthRangeNear != f2 || this.depthRangeFar != f3) {
                this.depthRangeNear = f2;
                this.depthRangeFar = f3;
                Gdx.gl.glDepthRangef(this.depthRangeNear, this.depthRangeFar);
            }
        }
    }

    public void setBlending(boolean bl2, int n2, int n3) {
        if (bl2 != this.blending) {
            this.blending = bl2;
            if (bl2) {
                Gdx.gl.glEnable(3042);
            } else {
                Gdx.gl.glDisable(3042);
            }
        }
        if (bl2 && (this.blendSFactor != n2 || this.blendDFactor != n3)) {
            Gdx.gl.glBlendFunc(n2, n3);
            this.blendSFactor = n2;
            this.blendDFactor = n3;
        }
    }

    public void setCullFace(int n2) {
        if (n2 != this.cullFace) {
            this.cullFace = n2;
            if (n2 == 1028 || n2 == 1029 || n2 == 1032) {
                Gdx.gl.glEnable(2884);
                Gdx.gl.glCullFace(n2);
            } else {
                Gdx.gl.glDisable(2884);
            }
        }
    }
}

