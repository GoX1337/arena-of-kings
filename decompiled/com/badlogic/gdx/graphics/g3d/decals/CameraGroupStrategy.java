/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalMaterial;
import com.badlogic.gdx.graphics.g3d.decals.GroupStrategy;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.Pool;
import java.util.Comparator;

public class CameraGroupStrategy
implements GroupStrategy,
Disposable {
    private static final int GROUP_OPAQUE = 0;
    private static final int GROUP_BLEND = 1;
    Pool<Array<Decal>> arrayPool = new Pool<Array<Decal>>(16){

        @Override
        protected Array<Decal> newObject() {
            return new Array<Decal>();
        }
    };
    Array<Array<Decal>> usedArrays = new Array();
    ObjectMap<DecalMaterial, Array<Decal>> materialGroups = new ObjectMap();
    Camera camera;
    ShaderProgram shader;
    private final Comparator<Decal> cameraSorter;

    public CameraGroupStrategy(Camera camera) {
        this.camera = camera;
        this.cameraSorter = new Comparator<Decal>(){

            @Override
            public int compare(Decal decal, Decal decal2) {
                float f2 = CameraGroupStrategy.this.camera.position.dst(decal.position);
                float f3 = CameraGroupStrategy.this.camera.position.dst(decal2.position);
                return (int)Math.signum(f3 - f2);
            }
        };
        this.createDefaultShader();
    }

    public CameraGroupStrategy(Camera camera, Comparator<Decal> comparator) {
        this.camera = camera;
        this.cameraSorter = comparator;
        this.createDefaultShader();
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return this.camera;
    }

    @Override
    public int decideGroup(Decal decal) {
        return decal.getMaterial().isOpaque() ? 0 : 1;
    }

    @Override
    public void beforeGroup(int n2, Array<Decal> array) {
        if (n2 == 1) {
            Gdx.gl.glEnable(3042);
            array.sort(this.cameraSorter);
        } else {
            int n3 = array.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                Decal decal = array.get(i2);
                Array<Decal> array2 = this.materialGroups.get(decal.material);
                if (array2 == null) {
                    array2 = this.arrayPool.obtain();
                    array2.clear();
                    this.usedArrays.add(array2);
                    this.materialGroups.put(decal.material, array2);
                }
                array2.add(decal);
            }
            array.clear();
            for (Array array3 : this.materialGroups.values()) {
                array.addAll(array3);
            }
            this.materialGroups.clear();
            this.arrayPool.freeAll(this.usedArrays);
            this.usedArrays.clear();
        }
    }

    @Override
    public void afterGroup(int n2) {
        if (n2 == 1) {
            Gdx.gl.glDisable(3042);
        }
    }

    @Override
    public void beforeGroups() {
        Gdx.gl.glEnable(2929);
        this.shader.bind();
        this.shader.setUniformMatrix("u_projectionViewMatrix", this.camera.combined);
        this.shader.setUniformi("u_texture", 0);
    }

    @Override
    public void afterGroups() {
        Gdx.gl.glDisable(2929);
    }

    private void createDefaultShader() {
        String string = "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n";
        String string2 = "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}";
        this.shader = new ShaderProgram(string, string2);
        if (!this.shader.isCompiled()) {
            throw new IllegalArgumentException("couldn't compile shader: " + this.shader.getLog());
        }
    }

    @Override
    public ShaderProgram getGroupShader(int n2) {
        return this.shader;
    }

    @Override
    public void dispose() {
        if (this.shader != null) {
            this.shader.dispose();
        }
    }
}

