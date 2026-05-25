/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class ShapeRenderer
implements Disposable {
    private final ImmediateModeRenderer renderer;
    private boolean matrixDirty = false;
    private final Matrix4 projectionMatrix = new Matrix4();
    private final Matrix4 transformMatrix = new Matrix4();
    private final Matrix4 combinedMatrix = new Matrix4();
    private final Vector2 tmp = new Vector2();
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private ShapeType shapeType;
    private boolean autoShapeType;
    private float defaultRectLineWidth = 0.75f;

    public ShapeRenderer() {
        this(5000);
    }

    public ShapeRenderer(int n2) {
        this(n2, null);
    }

    public ShapeRenderer(int n2, ShaderProgram shaderProgram) {
        this.renderer = shaderProgram == null ? new ImmediateModeRenderer20(n2, false, true, 0) : new ImmediateModeRenderer20(n2, false, true, 0, shaderProgram);
        this.projectionMatrix.setToOrtho2D(0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.matrixDirty = true;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
    }

    public Color getColor() {
        return this.color;
    }

    public void updateMatrices() {
        this.matrixDirty = true;
    }

    public void setProjectionMatrix(Matrix4 matrix4) {
        this.projectionMatrix.set(matrix4);
        this.matrixDirty = true;
    }

    public Matrix4 getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public void setTransformMatrix(Matrix4 matrix4) {
        this.transformMatrix.set(matrix4);
        this.matrixDirty = true;
    }

    public Matrix4 getTransformMatrix() {
        return this.transformMatrix;
    }

    public void identity() {
        this.transformMatrix.idt();
        this.matrixDirty = true;
    }

    public void translate(float f2, float f3, float f4) {
        this.transformMatrix.translate(f2, f3, f4);
        this.matrixDirty = true;
    }

    public void rotate(float f2, float f3, float f4, float f5) {
        this.transformMatrix.rotate(f2, f3, f4, f5);
        this.matrixDirty = true;
    }

    public void scale(float f2, float f3, float f4) {
        this.transformMatrix.scale(f2, f3, f4);
        this.matrixDirty = true;
    }

    public void setAutoShapeType(boolean bl2) {
        this.autoShapeType = bl2;
    }

    public void begin() {
        if (!this.autoShapeType) {
            throw new IllegalStateException("autoShapeType must be true to use this method.");
        }
        this.begin(ShapeType.Line);
    }

    public void begin(ShapeType shapeType) {
        if (this.shapeType != null) {
            throw new IllegalStateException("Call end() before beginning a new shape batch.");
        }
        this.shapeType = shapeType;
        if (this.matrixDirty) {
            this.combinedMatrix.set(this.projectionMatrix);
            Matrix4.mul(this.combinedMatrix.val, this.transformMatrix.val);
            this.matrixDirty = false;
        }
        this.renderer.begin(this.combinedMatrix, this.shapeType.getGlType());
    }

    public void set(ShapeType shapeType) {
        if (this.shapeType == shapeType) {
            return;
        }
        if (this.shapeType == null) {
            throw new IllegalStateException("begin must be called first.");
        }
        if (!this.autoShapeType) {
            throw new IllegalStateException("autoShapeType must be enabled.");
        }
        this.end();
        this.begin(shapeType);
    }

    public void point(float f2, float f3, float f4) {
        if (this.shapeType == ShapeType.Line) {
            float f5 = this.defaultRectLineWidth * 0.5f;
            this.line(f2 - f5, f3 - f5, f4, f2 + f5, f3 + f5, f4);
            return;
        }
        if (this.shapeType == ShapeType.Filled) {
            float f6 = this.defaultRectLineWidth * 0.5f;
            this.box(f2 - f6, f3 - f6, f4 - f6, this.defaultRectLineWidth, this.defaultRectLineWidth, this.defaultRectLineWidth);
            return;
        }
        this.check(ShapeType.Point, null, 1);
        this.renderer.color(this.color);
        this.renderer.vertex(f2, f3, f4);
    }

    public final void line(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.line(f2, f3, f4, f5, f6, f7, this.color, this.color);
    }

    public final void line(Vector3 vector3, Vector3 vector32) {
        this.line(vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, this.color, this.color);
    }

    public final void line(float f2, float f3, float f4, float f5) {
        this.line(f2, f3, 0.0f, f4, f5, 0.0f, this.color, this.color);
    }

    public final void line(Vector2 vector2, Vector2 vector22) {
        this.line(vector2.x, vector2.y, 0.0f, vector22.x, vector22.y, 0.0f, this.color, this.color);
    }

    public final void line(float f2, float f3, float f4, float f5, Color color, Color color2) {
        this.line(f2, f3, 0.0f, f4, f5, 0.0f, color, color2);
    }

    public void line(float f2, float f3, float f4, float f5, float f6, float f7, Color color, Color color2) {
        if (this.shapeType == ShapeType.Filled) {
            this.rectLine(f2, f3, f5, f6, this.defaultRectLineWidth, color, color2);
            return;
        }
        this.check(ShapeType.Line, null, 2);
        this.renderer.color(color.r, color.g, color.b, color.a);
        this.renderer.vertex(f2, f3, f4);
        this.renderer.color(color2.r, color2.g, color2.b, color2.a);
        this.renderer.vertex(f5, f6, f7);
    }

    public void curve(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n2) {
        this.check(ShapeType.Line, null, n2 * 2 + 2);
        float f10 = this.color.toFloatBits();
        float f11 = 1.0f / (float)n2;
        float f12 = f11 * f11;
        float f13 = f11 * f11 * f11;
        float f14 = 3.0f * f11;
        float f15 = 3.0f * f12;
        float f16 = 6.0f * f12;
        float f17 = 6.0f * f13;
        float f18 = f2 - f4 * 2.0f + f6;
        float f19 = f3 - f5 * 2.0f + f7;
        float f20 = (f4 - f6) * 3.0f - f2 + f8;
        float f21 = (f5 - f7) * 3.0f - f3 + f9;
        float f22 = f2;
        float f23 = f3;
        float f24 = (f4 - f2) * f14 + f18 * f15 + f20 * f13;
        float f25 = (f5 - f3) * f14 + f19 * f15 + f21 * f13;
        float f26 = f18 * f16 + f20 * f17;
        float f27 = f19 * f16 + f21 * f17;
        float f28 = f20 * f17;
        float f29 = f21 * f17;
        while (n2-- > 0) {
            this.renderer.color(f10);
            this.renderer.vertex(f22, f23, 0.0f);
            f22 += f24;
            f23 += f25;
            f24 += f26;
            f25 += f27;
            f26 += f28;
            f27 += f29;
            this.renderer.color(f10);
            this.renderer.vertex(f22, f23, 0.0f);
        }
        this.renderer.color(f10);
        this.renderer.vertex(f22, f23, 0.0f);
        this.renderer.color(f10);
        this.renderer.vertex(f8, f9, 0.0f);
    }

    public void triangle(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.check(ShapeType.Line, ShapeType.Filled, 6);
        float f8 = this.color.toFloatBits();
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, 0.0f);
        } else {
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f6, f7, 0.0f);
        }
    }

    public void triangle(float f2, float f3, float f4, float f5, float f6, float f7, Color color, Color color2, Color color3) {
        this.check(ShapeType.Line, ShapeType.Filled, 6);
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f6, f7, 0.0f);
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
        } else {
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f4, f5, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f6, f7, 0.0f);
        }
    }

    public void rect(float f2, float f3, float f4, float f5) {
        this.check(ShapeType.Line, ShapeType.Filled, 8);
        float f6 = this.color.toFloatBits();
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3, 0.0f);
        } else {
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3 + f5, 0.0f);
            this.renderer.color(f6);
            this.renderer.vertex(f2, f3, 0.0f);
        }
    }

    public void rect(float f2, float f3, float f4, float f5, Color color, Color color2, Color color3, Color color4) {
        this.check(ShapeType.Line, ShapeType.Filled, 8);
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f2 + f4, f3, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f2 + f4, f3, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.b, color4.a);
            this.renderer.vertex(f2, f3 + f5, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.b, color4.a);
            this.renderer.vertex(f2, f3 + f5, 0.0f);
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
        } else {
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f2 + f4, f3, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f2 + f4, f3 + f5, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.b, color4.a);
            this.renderer.vertex(f2, f3 + f5, 0.0f);
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f2, f3, 0.0f);
        }
    }

    public void rect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.rect(f2, f3, f4, f5, f6, f7, f8, f9, f10, this.color, this.color, this.color, this.color);
    }

    public void rect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Color color, Color color2, Color color3, Color color4) {
        this.check(ShapeType.Line, ShapeType.Filled, 8);
        float f11 = MathUtils.cosDeg(f10);
        float f12 = MathUtils.sinDeg(f10);
        float f13 = -f4;
        float f14 = -f5;
        float f15 = f6 - f4;
        float f16 = f7 - f5;
        if (f8 != 1.0f || f9 != 1.0f) {
            f13 *= f8;
            f14 *= f9;
            f15 *= f8;
            f16 *= f9;
        }
        float f17 = f2 + f4;
        float f18 = f3 + f5;
        float f19 = f11 * f13 - f12 * f14 + f17;
        float f20 = f12 * f13 + f11 * f14 + f18;
        float f21 = f11 * f15 - f12 * f14 + f17;
        float f22 = f12 * f15 + f11 * f14 + f18;
        float f23 = f11 * f15 - f12 * f16 + f17;
        float f24 = f12 * f15 + f11 * f16 + f18;
        float f25 = f19 + (f23 - f21);
        float f26 = f24 - (f22 - f20);
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f19, f20, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f21, f22, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f21, f22, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f23, f24, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f23, f24, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.b, color4.a);
            this.renderer.vertex(f25, f26, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.b, color4.a);
            this.renderer.vertex(f25, f26, 0.0f);
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f19, f20, 0.0f);
        } else {
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f19, f20, 0.0f);
            this.renderer.color(color2.r, color2.g, color2.b, color2.a);
            this.renderer.vertex(f21, f22, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f23, f24, 0.0f);
            this.renderer.color(color3.r, color3.g, color3.b, color3.a);
            this.renderer.vertex(f23, f24, 0.0f);
            this.renderer.color(color4.r, color4.g, color4.b, color4.a);
            this.renderer.vertex(f25, f26, 0.0f);
            this.renderer.color(color.r, color.g, color.b, color.a);
            this.renderer.vertex(f19, f20, 0.0f);
        }
    }

    public void rectLine(float f2, float f3, float f4, float f5, float f6) {
        this.check(ShapeType.Line, ShapeType.Filled, 8);
        float f7 = this.color.toFloatBits();
        Vector2 vector2 = this.tmp.set(f5 - f3, f2 - f4).nor();
        float f8 = vector2.x * (f6 *= 0.5f);
        float f9 = vector2.y * f6;
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f8, f3 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f8, f3 - f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 + f8, f5 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 - f8, f5 - f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 + f8, f5 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f8, f3 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 - f8, f5 - f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f8, f3 - f9, 0.0f);
        } else {
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f8, f3 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f8, f3 - f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 + f8, f5 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 - f8, f5 - f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f4 + f8, f5 + f9, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f8, f3 - f9, 0.0f);
        }
    }

    public void rectLine(float f2, float f3, float f4, float f5, float f6, Color color, Color color2) {
        this.check(ShapeType.Line, ShapeType.Filled, 8);
        float f7 = color.toFloatBits();
        float f8 = color2.toFloatBits();
        Vector2 vector2 = this.tmp.set(f5 - f3, f2 - f4).nor();
        float f9 = vector2.x * (f6 *= 0.5f);
        float f10 = vector2.y * f6;
        if (this.shapeType == ShapeType.Line) {
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f9, f3 - f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 + f9, f5 + f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 - f9, f5 - f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 + f9, f5 + f10, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 - f9, f5 - f10, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f9, f3 - f10, 0.0f);
        } else {
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f9, f3 - f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 + f9, f5 + f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 - f9, f5 - f10, 0.0f);
            this.renderer.color(f8);
            this.renderer.vertex(f4 + f9, f5 + f10, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 - f9, f3 - f10, 0.0f);
        }
    }

    public void rectLine(Vector2 vector2, Vector2 vector22, float f2) {
        this.rectLine(vector2.x, vector2.y, vector22.x, vector22.y, f2);
    }

    public void box(float f2, float f3, float f4, float f5, float f6, float f7) {
        f7 = -f7;
        float f8 = this.color.toFloatBits();
        if (this.shapeType == ShapeType.Line) {
            this.check(ShapeType.Line, ShapeType.Filled, 24);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4 + f7);
        } else {
            this.check(ShapeType.Line, ShapeType.Filled, 36);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3 + f6, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f7);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f5, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
        }
    }

    public void x(float f2, float f3, float f4) {
        this.line(f2 - f4, f3 - f4, f2 + f4, f3 + f4);
        this.line(f2 - f4, f3 + f4, f2 + f4, f3 - f4);
    }

    public void x(Vector2 vector2, float f2) {
        this.x(vector2.x, vector2.y, f2);
    }

    public void arc(float f2, float f3, float f4, float f5, float f6) {
        this.arc(f2, f3, f4, f5, f6, Math.max(1, (int)(6.0f * (float)Math.cbrt(f4) * (f6 / 360.0f))));
    }

    public void arc(float f2, float f3, float f4, float f5, float f6, int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("segments must be > 0.");
        }
        float f7 = this.color.toFloatBits();
        float f8 = (float)Math.PI * 2 * (f6 / 360.0f) / (float)n2;
        float f9 = MathUtils.cos(f8);
        float f10 = MathUtils.sin(f8);
        float f11 = f4 * MathUtils.cos(f5 * ((float)Math.PI / 180));
        float f12 = f4 * MathUtils.sin(f5 * ((float)Math.PI / 180));
        if (this.shapeType == ShapeType.Line) {
            this.check(ShapeType.Line, ShapeType.Filled, n2 * 2 + 2);
            this.renderer.color(f7);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.renderer.color(f7);
                this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
                float f13 = f11;
                f11 = f9 * f11 - f10 * f12;
                f12 = f10 * f13 + f9 * f12;
                this.renderer.color(f7);
                this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
            }
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
        } else {
            this.check(ShapeType.Line, ShapeType.Filled, n2 * 3 + 3);
            for (int i3 = 0; i3 < n2; ++i3) {
                this.renderer.color(f7);
                this.renderer.vertex(f2, f3, 0.0f);
                this.renderer.color(f7);
                this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
                float f14 = f11;
                f11 = f9 * f11 - f10 * f12;
                f12 = f10 * f14 + f9 * f12;
                this.renderer.color(f7);
                this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
            }
            this.renderer.color(f7);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f7);
            this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
        }
        float f15 = f11;
        f11 = 0.0f;
        f12 = 0.0f;
        this.renderer.color(f7);
        this.renderer.vertex(f2 + f11, f3 + f12, 0.0f);
    }

    public void circle(float f2, float f3, float f4) {
        this.circle(f2, f3, f4, Math.max(1, (int)(6.0f * (float)Math.cbrt(f4))));
    }

    public void circle(float f2, float f3, float f4, int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("segments must be > 0.");
        }
        float f5 = this.color.toFloatBits();
        float f6 = (float)Math.PI * 2 / (float)n2;
        float f7 = MathUtils.cos(f6);
        float f8 = MathUtils.sin(f6);
        float f9 = f4;
        float f10 = 0.0f;
        if (this.shapeType == ShapeType.Line) {
            this.check(ShapeType.Line, ShapeType.Filled, n2 * 2 + 2);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.renderer.color(f5);
                this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
                float f11 = f9;
                f9 = f7 * f9 - f8 * f10;
                f10 = f8 * f11 + f7 * f10;
                this.renderer.color(f5);
                this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
            }
            this.renderer.color(f5);
            this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
        } else {
            this.check(ShapeType.Line, ShapeType.Filled, n2 * 3 + 3);
            --n2;
            for (int i3 = 0; i3 < n2; ++i3) {
                this.renderer.color(f5);
                this.renderer.vertex(f2, f3, 0.0f);
                this.renderer.color(f5);
                this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
                float f12 = f9;
                f9 = f7 * f9 - f8 * f10;
                f10 = f8 * f12 + f7 * f10;
                this.renderer.color(f5);
                this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
            }
            this.renderer.color(f5);
            this.renderer.vertex(f2, f3, 0.0f);
            this.renderer.color(f5);
            this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
        }
        float f13 = f9;
        f9 = f4;
        f10 = 0.0f;
        this.renderer.color(f5);
        this.renderer.vertex(f2 + f9, f3 + f10, 0.0f);
    }

    public void ellipse(float f2, float f3, float f4, float f5) {
        this.ellipse(f2, f3, f4, f5, Math.max(1, (int)(12.0f * (float)Math.cbrt(Math.max(f4 * 0.5f, f5 * 0.5f)))));
    }

    public void ellipse(float f2, float f3, float f4, float f5, int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("segments must be > 0.");
        }
        this.check(ShapeType.Line, ShapeType.Filled, n2 * 3);
        float f6 = this.color.toFloatBits();
        float f7 = (float)Math.PI * 2 / (float)n2;
        float f8 = f2 + f4 / 2.0f;
        float f9 = f3 + f5 / 2.0f;
        if (this.shapeType == ShapeType.Line) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.renderer.color(f6);
                this.renderer.vertex(f8 + f4 * 0.5f * MathUtils.cos((float)i2 * f7), f9 + f5 * 0.5f * MathUtils.sin((float)i2 * f7), 0.0f);
                this.renderer.color(f6);
                this.renderer.vertex(f8 + f4 * 0.5f * MathUtils.cos((float)(i2 + 1) * f7), f9 + f5 * 0.5f * MathUtils.sin((float)(i2 + 1) * f7), 0.0f);
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                this.renderer.color(f6);
                this.renderer.vertex(f8 + f4 * 0.5f * MathUtils.cos((float)i3 * f7), f9 + f5 * 0.5f * MathUtils.sin((float)i3 * f7), 0.0f);
                this.renderer.color(f6);
                this.renderer.vertex(f8, f9, 0.0f);
                this.renderer.color(f6);
                this.renderer.vertex(f8 + f4 * 0.5f * MathUtils.cos((float)(i3 + 1) * f7), f9 + f5 * 0.5f * MathUtils.sin((float)(i3 + 1) * f7), 0.0f);
            }
        }
    }

    public void ellipse(float f2, float f3, float f4, float f5, float f6) {
        this.ellipse(f2, f3, f4, f5, f6, Math.max(1, (int)(12.0f * (float)Math.cbrt(Math.max(f4 * 0.5f, f5 * 0.5f)))));
    }

    public void ellipse(float f2, float f3, float f4, float f5, float f6, int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("segments must be > 0.");
        }
        this.check(ShapeType.Line, ShapeType.Filled, n2 * 3);
        float f7 = this.color.toFloatBits();
        float f8 = (float)Math.PI * 2 / (float)n2;
        f6 = (float)Math.PI * f6 / 180.0f;
        float f9 = MathUtils.sin(f6);
        float f10 = MathUtils.cos(f6);
        float f11 = f2 + f4 / 2.0f;
        float f12 = f3 + f5 / 2.0f;
        float f13 = f4 * 0.5f;
        float f14 = 0.0f;
        if (this.shapeType == ShapeType.Line) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.renderer.color(f7);
                this.renderer.vertex(f11 + f10 * f13 - f9 * f14, f12 + f9 * f13 + f10 * f14, 0.0f);
                f13 = f4 * 0.5f * MathUtils.cos((float)(i2 + 1) * f8);
                f14 = f5 * 0.5f * MathUtils.sin((float)(i2 + 1) * f8);
                this.renderer.color(f7);
                this.renderer.vertex(f11 + f10 * f13 - f9 * f14, f12 + f9 * f13 + f10 * f14, 0.0f);
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                this.renderer.color(f7);
                this.renderer.vertex(f11 + f10 * f13 - f9 * f14, f12 + f9 * f13 + f10 * f14, 0.0f);
                this.renderer.color(f7);
                this.renderer.vertex(f11, f12, 0.0f);
                f13 = f4 * 0.5f * MathUtils.cos((float)(i3 + 1) * f8);
                f14 = f5 * 0.5f * MathUtils.sin((float)(i3 + 1) * f8);
                this.renderer.color(f7);
                this.renderer.vertex(f11 + f10 * f13 - f9 * f14, f12 + f9 * f13 + f10 * f14, 0.0f);
            }
        }
    }

    public void cone(float f2, float f3, float f4, float f5, float f6) {
        this.cone(f2, f3, f4, f5, f6, Math.max(1, (int)(4.0f * (float)Math.sqrt(f5))));
    }

    public void cone(float f2, float f3, float f4, float f5, float f6, int n2) {
        float f7;
        int n3;
        if (n2 <= 0) {
            throw new IllegalArgumentException("segments must be > 0.");
        }
        this.check(ShapeType.Line, ShapeType.Filled, n2 * 4 + 2);
        float f8 = this.color.toFloatBits();
        float f9 = (float)Math.PI * 2 / (float)n2;
        float f10 = MathUtils.cos(f9);
        float f11 = MathUtils.sin(f9);
        float f12 = f5;
        float f13 = 0.0f;
        if (this.shapeType == ShapeType.Line) {
            for (n3 = 0; n3 < n2; ++n3) {
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f12, f3 + f13, f4);
                this.renderer.color(f8);
                this.renderer.vertex(f2, f3, f4 + f6);
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f12, f3 + f13, f4);
                f7 = f12;
                f12 = f10 * f12 - f11 * f13;
                f13 = f11 * f7 + f10 * f13;
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f12, f3 + f13, f4);
            }
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f12, f3 + f13, f4);
        } else {
            --n2;
            for (n3 = 0; n3 < n2; ++n3) {
                this.renderer.color(f8);
                this.renderer.vertex(f2, f3, f4);
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f12, f3 + f13, f4);
                f7 = f12;
                float f14 = f13;
                f12 = f10 * f12 - f11 * f13;
                f13 = f11 * f7 + f10 * f13;
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f12, f3 + f13, f4);
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f7, f3 + f14, f4);
                this.renderer.color(f8);
                this.renderer.vertex(f2 + f12, f3 + f13, f4);
                this.renderer.color(f8);
                this.renderer.vertex(f2, f3, f4 + f6);
            }
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f12, f3 + f13, f4);
        }
        float f15 = f12;
        f7 = f13;
        f12 = f5;
        f13 = 0.0f;
        this.renderer.color(f8);
        this.renderer.vertex(f2 + f12, f3 + f13, f4);
        if (this.shapeType != ShapeType.Line) {
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f15, f3 + f7, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2 + f12, f3 + f13, f4);
            this.renderer.color(f8);
            this.renderer.vertex(f2, f3, f4 + f6);
        }
    }

    public void polygon(float[] fArray, int n2, int n3) {
        if (n3 < 6) {
            throw new IllegalArgumentException("Polygons must contain at least 3 points.");
        }
        if (n3 % 2 != 0) {
            throw new IllegalArgumentException("Polygons must have an even number of vertices.");
        }
        this.check(ShapeType.Line, null, n3);
        float f2 = this.color.toFloatBits();
        float f3 = fArray[0];
        float f4 = fArray[1];
        int n4 = n2 + n3;
        for (int i2 = n2; i2 < n4; i2 += 2) {
            float f5;
            float f6;
            float f7 = fArray[i2];
            float f8 = fArray[i2 + 1];
            if (i2 + 2 >= n3) {
                f6 = f3;
                f5 = f4;
            } else {
                f6 = fArray[i2 + 2];
                f5 = fArray[i2 + 3];
            }
            this.renderer.color(f2);
            this.renderer.vertex(f7, f8, 0.0f);
            this.renderer.color(f2);
            this.renderer.vertex(f6, f5, 0.0f);
        }
    }

    public void polygon(float[] fArray) {
        this.polygon(fArray, 0, fArray.length);
    }

    public void polyline(float[] fArray, int n2, int n3) {
        if (n3 < 4) {
            throw new IllegalArgumentException("Polylines must contain at least 2 points.");
        }
        if (n3 % 2 != 0) {
            throw new IllegalArgumentException("Polylines must have an even number of vertices.");
        }
        this.check(ShapeType.Line, null, n3);
        float f2 = this.color.toFloatBits();
        int n4 = n2 + n3 - 2;
        for (int i2 = n2; i2 < n4; i2 += 2) {
            float f3 = fArray[i2];
            float f4 = fArray[i2 + 1];
            float f5 = fArray[i2 + 2];
            float f6 = fArray[i2 + 3];
            this.renderer.color(f2);
            this.renderer.vertex(f3, f4, 0.0f);
            this.renderer.color(f2);
            this.renderer.vertex(f5, f6, 0.0f);
        }
    }

    public void polyline(float[] fArray) {
        this.polyline(fArray, 0, fArray.length);
    }

    protected final void check(ShapeType shapeType, ShapeType shapeType2, int n2) {
        if (this.shapeType == null) {
            throw new IllegalStateException("begin must be called first.");
        }
        if (this.shapeType != shapeType && this.shapeType != shapeType2) {
            if (!this.autoShapeType) {
                if (shapeType2 == null) {
                    throw new IllegalStateException("Must call begin(ShapeType." + (Object)((Object)shapeType) + ").");
                }
                throw new IllegalStateException("Must call begin(ShapeType." + (Object)((Object)shapeType) + ") or begin(ShapeType." + (Object)((Object)shapeType2) + ").");
            }
            this.end();
            this.begin(shapeType);
        } else if (this.matrixDirty) {
            ShapeType shapeType3 = this.shapeType;
            this.end();
            this.begin(shapeType3);
        } else if (this.renderer.getMaxVertices() - this.renderer.getNumVertices() < n2) {
            ShapeType shapeType4 = this.shapeType;
            this.end();
            this.begin(shapeType4);
        }
    }

    public void end() {
        this.renderer.end();
        this.shapeType = null;
    }

    public void flush() {
        ShapeType shapeType = this.shapeType;
        if (shapeType == null) {
            return;
        }
        this.end();
        this.begin(shapeType);
    }

    public ShapeType getCurrentType() {
        return this.shapeType;
    }

    public ImmediateModeRenderer getRenderer() {
        return this.renderer;
    }

    public boolean isDrawing() {
        return this.shapeType != null;
    }

    @Override
    public void dispose() {
        this.renderer.dispose();
    }

    public static enum ShapeType {
        Point(0),
        Line(1),
        Filled(4);

        private final int glType;

        private ShapeType(int n3) {
            this.glType = n3;
        }

        public int getGlType() {
            return this.glType;
        }
    }
}

