/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.DecalMaterial;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;

public class Decal {
    private static final int VERTEX_SIZE = 6;
    public static final int SIZE = 24;
    private static Vector3 tmp = new Vector3();
    private static Vector3 tmp2 = new Vector3();
    public int value;
    protected float[] vertices = new float[24];
    protected Vector3 position = new Vector3();
    protected Quaternion rotation = new Quaternion();
    protected Vector2 scale = new Vector2(1.0f, 1.0f);
    protected Color color = new Color();
    public Vector2 transformationOffset = null;
    protected Vector2 dimensions = new Vector2();
    protected DecalMaterial material;
    protected boolean updated = false;
    static final Vector3 dir = new Vector3();
    public static final int X1 = 0;
    public static final int Y1 = 1;
    public static final int Z1 = 2;
    public static final int C1 = 3;
    public static final int U1 = 4;
    public static final int V1 = 5;
    public static final int X2 = 6;
    public static final int Y2 = 7;
    public static final int Z2 = 8;
    public static final int C2 = 9;
    public static final int U2 = 10;
    public static final int V2 = 11;
    public static final int X3 = 12;
    public static final int Y3 = 13;
    public static final int Z3 = 14;
    public static final int C3 = 15;
    public static final int U3 = 16;
    public static final int V3 = 17;
    public static final int X4 = 18;
    public static final int Y4 = 19;
    public static final int Z4 = 20;
    public static final int C4 = 21;
    public static final int U4 = 22;
    public static final int V4 = 23;
    protected static Quaternion rotator = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);

    public Decal() {
        this.material = new DecalMaterial();
    }

    public Decal(DecalMaterial decalMaterial) {
        this.material = decalMaterial;
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        float f6;
        this.color.set(f2, f3, f4, f5);
        int n2 = (int)(255.0f * f5) << 24 | (int)(255.0f * f4) << 16 | (int)(255.0f * f3) << 8 | (int)(255.0f * f2);
        this.vertices[3] = f6 = NumberUtils.intToFloatColor(n2);
        this.vertices[9] = f6;
        this.vertices[15] = f6;
        this.vertices[21] = f6;
    }

    public void setColor(Color color) {
        float f2;
        this.color.set(color);
        this.vertices[3] = f2 = color.toFloatBits();
        this.vertices[9] = f2;
        this.vertices[15] = f2;
        this.vertices[21] = f2;
    }

    public void setPackedColor(float f2) {
        Color.abgr8888ToColor(this.color, f2);
        this.vertices[3] = f2;
        this.vertices[9] = f2;
        this.vertices[15] = f2;
        this.vertices[21] = f2;
    }

    public void setRotationX(float f2) {
        this.rotation.set(Vector3.X, f2);
        this.updated = false;
    }

    public void setRotationY(float f2) {
        this.rotation.set(Vector3.Y, f2);
        this.updated = false;
    }

    public void setRotationZ(float f2) {
        this.rotation.set(Vector3.Z, f2);
        this.updated = false;
    }

    public void rotateX(float f2) {
        rotator.set(Vector3.X, f2);
        this.rotation.mul(rotator);
        this.updated = false;
    }

    public void rotateY(float f2) {
        rotator.set(Vector3.Y, f2);
        this.rotation.mul(rotator);
        this.updated = false;
    }

    public void rotateZ(float f2) {
        rotator.set(Vector3.Z, f2);
        this.rotation.mul(rotator);
        this.updated = false;
    }

    public void setRotation(float f2, float f3, float f4) {
        this.rotation.setEulerAngles(f2, f3, f4);
        this.updated = false;
    }

    public void setRotation(Vector3 vector3, Vector3 vector32) {
        tmp.set(vector32).crs(vector3).nor();
        tmp2.set(vector3).crs(tmp).nor();
        this.rotation.setFromAxes(Decal.tmp.x, Decal.tmp2.x, vector3.x, Decal.tmp.y, Decal.tmp2.y, vector3.y, Decal.tmp.z, Decal.tmp2.z, vector3.z);
        this.updated = false;
    }

    public void setRotation(Quaternion quaternion) {
        this.rotation.set(quaternion);
        this.updated = false;
    }

    public Quaternion getRotation() {
        return this.rotation;
    }

    public void translateX(float f2) {
        this.position.x += f2;
        this.updated = false;
    }

    public void setX(float f2) {
        this.position.x = f2;
        this.updated = false;
    }

    public float getX() {
        return this.position.x;
    }

    public void translateY(float f2) {
        this.position.y += f2;
        this.updated = false;
    }

    public void setY(float f2) {
        this.position.y = f2;
        this.updated = false;
    }

    public float getY() {
        return this.position.y;
    }

    public void translateZ(float f2) {
        this.position.z += f2;
        this.updated = false;
    }

    public void setZ(float f2) {
        this.position.z = f2;
        this.updated = false;
    }

    public float getZ() {
        return this.position.z;
    }

    public void translate(float f2, float f3, float f4) {
        this.position.add(f2, f3, f4);
        this.updated = false;
    }

    public void translate(Vector3 vector3) {
        this.position.add(vector3);
        this.updated = false;
    }

    public void setPosition(float f2, float f3, float f4) {
        this.position.set(f2, f3, f4);
        this.updated = false;
    }

    public void setPosition(Vector3 vector3) {
        this.position.set(vector3);
        this.updated = false;
    }

    public Color getColor() {
        return this.color;
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public void setScaleX(float f2) {
        this.scale.x = f2;
        this.updated = false;
    }

    public float getScaleX() {
        return this.scale.x;
    }

    public void setScaleY(float f2) {
        this.scale.y = f2;
        this.updated = false;
    }

    public float getScaleY() {
        return this.scale.y;
    }

    public void setScale(float f2, float f3) {
        this.scale.set(f2, f3);
        this.updated = false;
    }

    public void setScale(float f2) {
        this.scale.set(f2, f2);
        this.updated = false;
    }

    public void setWidth(float f2) {
        this.dimensions.x = f2;
        this.updated = false;
    }

    public float getWidth() {
        return this.dimensions.x;
    }

    public void setHeight(float f2) {
        this.dimensions.y = f2;
        this.updated = false;
    }

    public float getHeight() {
        return this.dimensions.y;
    }

    public void setDimensions(float f2, float f3) {
        this.dimensions.set(f2, f3);
        this.updated = false;
    }

    public float[] getVertices() {
        this.update();
        return this.vertices;
    }

    protected void update() {
        if (!this.updated) {
            this.resetVertices();
            this.transformVertices();
        }
    }

    protected void transformVertices() {
        float f2;
        float f3;
        if (this.transformationOffset != null) {
            f3 = -this.transformationOffset.x;
            f2 = -this.transformationOffset.y;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        float f4 = (this.vertices[0] + f3) * this.scale.x;
        float f5 = (this.vertices[1] + f2) * this.scale.y;
        float f6 = this.vertices[2];
        this.vertices[0] = this.rotation.w * f4 + this.rotation.y * f6 - this.rotation.z * f5;
        this.vertices[1] = this.rotation.w * f5 + this.rotation.z * f4 - this.rotation.x * f6;
        this.vertices[2] = this.rotation.w * f6 + this.rotation.x * f5 - this.rotation.y * f4;
        float f7 = -this.rotation.x * f4 - this.rotation.y * f5 - this.rotation.z * f6;
        this.rotation.conjugate();
        f4 = this.vertices[0];
        f5 = this.vertices[1];
        f6 = this.vertices[2];
        this.vertices[0] = f7 * this.rotation.x + f4 * this.rotation.w + f5 * this.rotation.z - f6 * this.rotation.y;
        this.vertices[1] = f7 * this.rotation.y + f5 * this.rotation.w + f6 * this.rotation.x - f4 * this.rotation.z;
        this.vertices[2] = f7 * this.rotation.z + f6 * this.rotation.w + f4 * this.rotation.y - f5 * this.rotation.x;
        this.rotation.conjugate();
        this.vertices[0] = this.vertices[0] + (this.position.x - f3);
        this.vertices[1] = this.vertices[1] + (this.position.y - f2);
        this.vertices[2] = this.vertices[2] + this.position.z;
        f4 = (this.vertices[6] + f3) * this.scale.x;
        f5 = (this.vertices[7] + f2) * this.scale.y;
        f6 = this.vertices[8];
        this.vertices[6] = this.rotation.w * f4 + this.rotation.y * f6 - this.rotation.z * f5;
        this.vertices[7] = this.rotation.w * f5 + this.rotation.z * f4 - this.rotation.x * f6;
        this.vertices[8] = this.rotation.w * f6 + this.rotation.x * f5 - this.rotation.y * f4;
        f7 = -this.rotation.x * f4 - this.rotation.y * f5 - this.rotation.z * f6;
        this.rotation.conjugate();
        f4 = this.vertices[6];
        f5 = this.vertices[7];
        f6 = this.vertices[8];
        this.vertices[6] = f7 * this.rotation.x + f4 * this.rotation.w + f5 * this.rotation.z - f6 * this.rotation.y;
        this.vertices[7] = f7 * this.rotation.y + f5 * this.rotation.w + f6 * this.rotation.x - f4 * this.rotation.z;
        this.vertices[8] = f7 * this.rotation.z + f6 * this.rotation.w + f4 * this.rotation.y - f5 * this.rotation.x;
        this.rotation.conjugate();
        this.vertices[6] = this.vertices[6] + (this.position.x - f3);
        this.vertices[7] = this.vertices[7] + (this.position.y - f2);
        this.vertices[8] = this.vertices[8] + this.position.z;
        f4 = (this.vertices[12] + f3) * this.scale.x;
        f5 = (this.vertices[13] + f2) * this.scale.y;
        f6 = this.vertices[14];
        this.vertices[12] = this.rotation.w * f4 + this.rotation.y * f6 - this.rotation.z * f5;
        this.vertices[13] = this.rotation.w * f5 + this.rotation.z * f4 - this.rotation.x * f6;
        this.vertices[14] = this.rotation.w * f6 + this.rotation.x * f5 - this.rotation.y * f4;
        f7 = -this.rotation.x * f4 - this.rotation.y * f5 - this.rotation.z * f6;
        this.rotation.conjugate();
        f4 = this.vertices[12];
        f5 = this.vertices[13];
        f6 = this.vertices[14];
        this.vertices[12] = f7 * this.rotation.x + f4 * this.rotation.w + f5 * this.rotation.z - f6 * this.rotation.y;
        this.vertices[13] = f7 * this.rotation.y + f5 * this.rotation.w + f6 * this.rotation.x - f4 * this.rotation.z;
        this.vertices[14] = f7 * this.rotation.z + f6 * this.rotation.w + f4 * this.rotation.y - f5 * this.rotation.x;
        this.rotation.conjugate();
        this.vertices[12] = this.vertices[12] + (this.position.x - f3);
        this.vertices[13] = this.vertices[13] + (this.position.y - f2);
        this.vertices[14] = this.vertices[14] + this.position.z;
        f4 = (this.vertices[18] + f3) * this.scale.x;
        f5 = (this.vertices[19] + f2) * this.scale.y;
        f6 = this.vertices[20];
        this.vertices[18] = this.rotation.w * f4 + this.rotation.y * f6 - this.rotation.z * f5;
        this.vertices[19] = this.rotation.w * f5 + this.rotation.z * f4 - this.rotation.x * f6;
        this.vertices[20] = this.rotation.w * f6 + this.rotation.x * f5 - this.rotation.y * f4;
        f7 = -this.rotation.x * f4 - this.rotation.y * f5 - this.rotation.z * f6;
        this.rotation.conjugate();
        f4 = this.vertices[18];
        f5 = this.vertices[19];
        f6 = this.vertices[20];
        this.vertices[18] = f7 * this.rotation.x + f4 * this.rotation.w + f5 * this.rotation.z - f6 * this.rotation.y;
        this.vertices[19] = f7 * this.rotation.y + f5 * this.rotation.w + f6 * this.rotation.x - f4 * this.rotation.z;
        this.vertices[20] = f7 * this.rotation.z + f6 * this.rotation.w + f4 * this.rotation.y - f5 * this.rotation.x;
        this.rotation.conjugate();
        this.vertices[18] = this.vertices[18] + (this.position.x - f3);
        this.vertices[19] = this.vertices[19] + (this.position.y - f2);
        this.vertices[20] = this.vertices[20] + this.position.z;
        this.updated = true;
    }

    protected void resetVertices() {
        float f2 = -this.dimensions.x / 2.0f;
        float f3 = f2 + this.dimensions.x;
        float f4 = this.dimensions.y / 2.0f;
        float f5 = f4 - this.dimensions.y;
        this.vertices[0] = f2;
        this.vertices[1] = f4;
        this.vertices[2] = 0.0f;
        this.vertices[6] = f3;
        this.vertices[7] = f4;
        this.vertices[8] = 0.0f;
        this.vertices[12] = f2;
        this.vertices[13] = f5;
        this.vertices[14] = 0.0f;
        this.vertices[18] = f3;
        this.vertices[19] = f5;
        this.vertices[20] = 0.0f;
        this.updated = false;
    }

    protected void updateUVs() {
        TextureRegion textureRegion = this.material.textureRegion;
        this.vertices[4] = textureRegion.getU();
        this.vertices[5] = textureRegion.getV();
        this.vertices[10] = textureRegion.getU2();
        this.vertices[11] = textureRegion.getV();
        this.vertices[16] = textureRegion.getU();
        this.vertices[17] = textureRegion.getV2();
        this.vertices[22] = textureRegion.getU2();
        this.vertices[23] = textureRegion.getV2();
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.material.textureRegion = textureRegion;
        this.updateUVs();
    }

    public TextureRegion getTextureRegion() {
        return this.material.textureRegion;
    }

    public void setBlending(int n2, int n3) {
        this.material.srcBlendFactor = n2;
        this.material.dstBlendFactor = n3;
    }

    public DecalMaterial getMaterial() {
        return this.material;
    }

    public void setMaterial(DecalMaterial decalMaterial) {
        this.material = decalMaterial;
    }

    public void lookAt(Vector3 vector3, Vector3 vector32) {
        dir.set(vector3).sub(this.position).nor();
        this.setRotation(dir, vector32);
    }

    public static Decal newDecal(TextureRegion textureRegion) {
        return Decal.newDecal(textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), textureRegion, -1, -1);
    }

    public static Decal newDecal(TextureRegion textureRegion, boolean bl2) {
        return Decal.newDecal(textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), textureRegion, bl2 ? 770 : -1, bl2 ? 771 : -1);
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion) {
        return Decal.newDecal(f2, f3, textureRegion, -1, -1);
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion, boolean bl2) {
        return Decal.newDecal(f2, f3, textureRegion, bl2 ? 770 : -1, bl2 ? 771 : -1);
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion, int n2, int n3) {
        Decal decal = new Decal();
        decal.setTextureRegion(textureRegion);
        decal.setBlending(n2, n3);
        decal.dimensions.x = f2;
        decal.dimensions.y = f3;
        decal.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return decal;
    }

    public static Decal newDecal(float f2, float f3, TextureRegion textureRegion, int n2, int n3, DecalMaterial decalMaterial) {
        Decal decal = new Decal(decalMaterial);
        decal.setTextureRegion(textureRegion);
        decal.setBlending(n2, n3);
        decal.dimensions.x = f2;
        decal.dimensions.y = f3;
        decal.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return decal;
    }
}

