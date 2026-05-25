/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CameraInputController
extends GestureDetector {
    public int rotateButton = 0;
    public float rotateAngle = 360.0f;
    public int translateButton = 1;
    public float translateUnits = 10.0f;
    public int forwardButton = 2;
    public int activateKey = 0;
    protected boolean activatePressed;
    public boolean alwaysScroll = true;
    public float scrollFactor = -0.1f;
    public float pinchZoomFactor = 10.0f;
    public boolean autoUpdate = true;
    public Vector3 target = new Vector3();
    public boolean translateTarget = true;
    public boolean forwardTarget = true;
    public boolean scrollTarget = false;
    public int forwardKey = 51;
    protected boolean forwardPressed;
    public int backwardKey = 47;
    protected boolean backwardPressed;
    public int rotateRightKey = 29;
    protected boolean rotateRightPressed;
    public int rotateLeftKey = 32;
    protected boolean rotateLeftPressed;
    protected boolean controlsInverted;
    public Camera camera;
    protected int button = -1;
    private float startX;
    private float startY;
    private final Vector3 tmpV1 = new Vector3();
    private final Vector3 tmpV2 = new Vector3();
    protected final CameraGestureListener gestureListener;
    private int touched;
    private boolean multiTouch;

    protected CameraInputController(CameraGestureListener cameraGestureListener, Camera camera) {
        super(cameraGestureListener);
        this.gestureListener = cameraGestureListener;
        this.gestureListener.controller = this;
        this.camera = camera;
    }

    public CameraInputController(Camera camera) {
        this(new CameraGestureListener(), camera);
    }

    public void update() {
        if (this.rotateRightPressed || this.rotateLeftPressed || this.forwardPressed || this.backwardPressed) {
            float f2 = Gdx.graphics.getDeltaTime();
            if (this.rotateRightPressed) {
                this.camera.rotate(this.camera.up, -f2 * this.rotateAngle);
            }
            if (this.rotateLeftPressed) {
                this.camera.rotate(this.camera.up, f2 * this.rotateAngle);
            }
            if (this.forwardPressed) {
                this.camera.translate(this.tmpV1.set(this.camera.direction).scl(f2 * this.translateUnits));
                if (this.forwardTarget) {
                    this.target.add(this.tmpV1);
                }
            }
            if (this.backwardPressed) {
                this.camera.translate(this.tmpV1.set(this.camera.direction).scl(-f2 * this.translateUnits));
                if (this.forwardTarget) {
                    this.target.add(this.tmpV1);
                }
            }
            if (this.autoUpdate) {
                this.camera.update();
            }
        }
    }

    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        this.touched |= 1 << n4;
        boolean bl2 = this.multiTouch = !MathUtils.isPowerOfTwo(this.touched);
        if (this.multiTouch) {
            this.button = -1;
        } else if (this.button < 0 && (this.activateKey == 0 || this.activatePressed)) {
            this.startX = n2;
            this.startY = n3;
            this.button = n5;
        }
        return super.touchDown(n2, n3, n4, n5) || this.activateKey == 0 || this.activatePressed;
    }

    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        this.touched &= 0xFFFFFFFF ^ 1 << n4;
        boolean bl2 = this.multiTouch = !MathUtils.isPowerOfTwo(this.touched);
        if (n5 == this.button) {
            this.button = -1;
        }
        return super.touchUp(n2, n3, n4, n5) || this.activatePressed;
    }

    public void setInvertedControls(boolean bl2) {
        if (this.controlsInverted != bl2) {
            this.rotateAngle = -this.rotateAngle;
        }
        this.controlsInverted = bl2;
    }

    protected boolean process(float f2, float f3, int n2) {
        if (n2 == this.rotateButton) {
            this.tmpV1.set((Vector3)this.camera.direction).crs((Vector3)this.camera.up).y = 0.0f;
            this.camera.rotateAround(this.target, this.tmpV1.nor(), f3 * this.rotateAngle);
            this.camera.rotateAround(this.target, Vector3.Y, f2 * -this.rotateAngle);
        } else if (n2 == this.translateButton) {
            this.camera.translate(this.tmpV1.set(this.camera.direction).crs(this.camera.up).nor().scl(-f2 * this.translateUnits));
            this.camera.translate(this.tmpV2.set(this.camera.up).scl(-f3 * this.translateUnits));
            if (this.translateTarget) {
                this.target.add(this.tmpV1).add(this.tmpV2);
            }
        } else if (n2 == this.forwardButton) {
            this.camera.translate(this.tmpV1.set(this.camera.direction).scl(f3 * this.translateUnits));
            if (this.forwardTarget) {
                this.target.add(this.tmpV1);
            }
        }
        if (this.autoUpdate) {
            this.camera.update();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        boolean bl2 = super.touchDragged(n2, n3, n4);
        if (bl2 || this.button < 0) {
            return bl2;
        }
        float f2 = ((float)n2 - this.startX) / (float)Gdx.graphics.getWidth();
        float f3 = (this.startY - (float)n3) / (float)Gdx.graphics.getHeight();
        this.startX = n2;
        this.startY = n3;
        return this.process(f2, f3, this.button);
    }

    @Override
    public boolean scrolled(float f2, float f3) {
        return this.zoom(f3 * this.scrollFactor * this.translateUnits);
    }

    public boolean zoom(float f2) {
        if (!this.alwaysScroll && this.activateKey != 0 && !this.activatePressed) {
            return false;
        }
        this.camera.translate(this.tmpV1.set(this.camera.direction).scl(f2));
        if (this.scrollTarget) {
            this.target.add(this.tmpV1);
        }
        if (this.autoUpdate) {
            this.camera.update();
        }
        return true;
    }

    protected boolean pinchZoom(float f2) {
        return this.zoom(this.pinchZoomFactor * f2);
    }

    @Override
    public boolean keyDown(int n2) {
        if (n2 == this.activateKey) {
            this.activatePressed = true;
        }
        if (n2 == this.forwardKey) {
            this.forwardPressed = true;
        } else if (n2 == this.backwardKey) {
            this.backwardPressed = true;
        } else if (n2 == this.rotateRightKey) {
            this.rotateRightPressed = true;
        } else if (n2 == this.rotateLeftKey) {
            this.rotateLeftPressed = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int n2) {
        if (n2 == this.activateKey) {
            this.activatePressed = false;
            this.button = -1;
        }
        if (n2 == this.forwardKey) {
            this.forwardPressed = false;
        } else if (n2 == this.backwardKey) {
            this.backwardPressed = false;
        } else if (n2 == this.rotateRightKey) {
            this.rotateRightPressed = false;
        } else if (n2 == this.rotateLeftKey) {
            this.rotateLeftPressed = false;
        }
        return false;
    }

    protected static class CameraGestureListener
    extends GestureDetector.GestureAdapter {
        public CameraInputController controller;
        private float previousZoom;

        protected CameraGestureListener() {
        }

        @Override
        public boolean touchDown(float f2, float f3, int n2, int n3) {
            this.previousZoom = 0.0f;
            return false;
        }

        @Override
        public boolean tap(float f2, float f3, int n2, int n3) {
            return false;
        }

        @Override
        public boolean longPress(float f2, float f3) {
            return false;
        }

        @Override
        public boolean fling(float f2, float f3, int n2) {
            return false;
        }

        @Override
        public boolean pan(float f2, float f3, float f4, float f5) {
            return false;
        }

        @Override
        public boolean zoom(float f2, float f3) {
            float f4;
            float f5 = f3 - f2;
            float f6 = f5 - this.previousZoom;
            this.previousZoom = f5;
            float f7 = Gdx.graphics.getWidth();
            return this.controller.pinchZoom(f6 / (f7 > (f4 = (float)Gdx.graphics.getHeight()) ? f4 : f7));
        }

        @Override
        public boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
            return false;
        }
    }
}

