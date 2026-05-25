/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;

public class Window
extends Table {
    private static final Vector2 tmpPosition = new Vector2();
    private static final Vector2 tmpSize = new Vector2();
    private static final int MOVE = 32;
    private WindowStyle style;
    boolean isMovable = true;
    boolean isModal;
    boolean isResizable;
    int resizeBorder = 8;
    boolean keepWithinStage = true;
    Label titleLabel;
    Table titleTable;
    boolean drawTitleTable;
    protected int edge;
    protected boolean dragging;

    public Window(String string, Skin skin) {
        this(string, skin.get(WindowStyle.class));
        this.setSkin(skin);
    }

    public Window(String string, Skin skin, String string2) {
        this(string, skin.get(string2, WindowStyle.class));
        this.setSkin(skin);
    }

    public Window(String string, WindowStyle windowStyle) {
        if (string == null) {
            throw new IllegalArgumentException("title cannot be null.");
        }
        this.setTouchable(Touchable.enabled);
        this.setClip(true);
        this.titleLabel = this.newLabel(string, new Label.LabelStyle(windowStyle.titleFont, windowStyle.titleFontColor));
        this.titleLabel.setEllipsis(true);
        this.titleTable = new Table(){

            @Override
            public void draw(Batch batch, float f2) {
                if (Window.this.drawTitleTable) {
                    super.draw(batch, f2);
                }
            }
        };
        this.titleTable.add(this.titleLabel).expandX().fillX().minWidth(0.0f);
        this.addActor(this.titleTable);
        this.setStyle(windowStyle);
        this.setWidth(150.0f);
        this.setHeight(150.0f);
        this.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                Window.this.toFront();
                return false;
            }
        });
        this.addListener(new InputListener(){
            float startX;
            float startY;
            float lastX;
            float lastY;

            private void updateEdge(float f2, float f3) {
                float f4 = (float)Window.this.resizeBorder / 2.0f;
                float f5 = Window.this.getWidth();
                float f6 = Window.this.getHeight();
                float f7 = Window.this.getPadTop();
                float f8 = Window.this.getPadLeft();
                float f9 = Window.this.getPadBottom();
                float f10 = Window.this.getPadRight();
                float f11 = f8;
                float f12 = f5 - f10;
                float f13 = f9;
                Window.this.edge = 0;
                if (Window.this.isResizable && f2 >= f11 - f4 && f2 <= f12 + f4 && f3 >= f13 - f4) {
                    if (f2 < f11 + f4) {
                        Window.this.edge |= 8;
                    }
                    if (f2 > f12 - f4) {
                        Window.this.edge |= 0x10;
                    }
                    if (f3 < f13 + f4) {
                        Window.this.edge |= 4;
                    }
                    if (Window.this.edge != 0) {
                        f4 += 25.0f;
                    }
                    if (f2 < f11 + f4) {
                        Window.this.edge |= 8;
                    }
                    if (f2 > f12 - f4) {
                        Window.this.edge |= 0x10;
                    }
                    if (f3 < f13 + f4) {
                        Window.this.edge |= 4;
                    }
                }
                if (Window.this.isMovable && Window.this.edge == 0 && f3 <= f6 && f3 >= f6 - f7 && f2 >= f11 && f2 <= f12) {
                    Window.this.edge = 32;
                }
            }

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n3 == 0) {
                    this.updateEdge(f2, f3);
                    Window.this.dragging = Window.this.edge != 0;
                    this.startX = f2;
                    this.startY = f3;
                    this.lastX = f2 - Window.this.getWidth();
                    this.lastY = f3 - Window.this.getHeight();
                }
                return Window.this.edge != 0 || Window.this.isModal;
            }

            @Override
            public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                Window.this.dragging = false;
            }

            @Override
            public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
                float f4;
                boolean bl2;
                if (!Window.this.dragging) {
                    return;
                }
                float f5 = Window.this.getWidth();
                float f6 = Window.this.getHeight();
                float f7 = Window.this.getX();
                float f8 = Window.this.getY();
                float f9 = Window.this.getMinWidth();
                float f10 = Window.this.getMaxWidth();
                float f11 = Window.this.getMinHeight();
                float f12 = Window.this.getMaxHeight();
                Stage stage = Window.this.getStage();
                boolean bl3 = bl2 = Window.this.keepWithinStage && stage != null && Window.this.getParent() == stage.getRoot();
                if ((Window.this.edge & 0x20) != 0) {
                    f4 = f2 - this.startX;
                    float f13 = f3 - this.startY;
                    f7 += f4;
                    f8 += f13;
                }
                if ((Window.this.edge & 8) != 0) {
                    f4 = f2 - this.startX;
                    if (f5 - f4 < f9) {
                        f4 = -(f9 - f5);
                    }
                    if (bl2 && f7 + f4 < 0.0f) {
                        f4 = -f7;
                    }
                    f5 -= f4;
                    f7 += f4;
                }
                if ((Window.this.edge & 4) != 0) {
                    f4 = f3 - this.startY;
                    if (f6 - f4 < f11) {
                        f4 = -(f11 - f6);
                    }
                    if (bl2 && f8 + f4 < 0.0f) {
                        f4 = -f8;
                    }
                    f6 -= f4;
                    f8 += f4;
                }
                if ((Window.this.edge & 0x10) != 0) {
                    f4 = f2 - this.lastX - f5;
                    if (f5 + f4 < f9) {
                        f4 = f9 - f5;
                    }
                    if (bl2 && f7 + f5 + f4 > stage.getWidth()) {
                        f4 = stage.getWidth() - f7 - f5;
                    }
                    f5 += f4;
                }
                if ((Window.this.edge & 2) != 0) {
                    f4 = f3 - this.lastY - f6;
                    if (f6 + f4 < f11) {
                        f4 = f11 - f6;
                    }
                    if (bl2 && f8 + f6 + f4 > stage.getHeight()) {
                        f4 = stage.getHeight() - f8 - f6;
                    }
                    f6 += f4;
                }
                Window.this.setBounds(Math.round(f7), Math.round(f8), Math.round(f5), Math.round(f6));
            }

            @Override
            public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                this.updateEdge(f2, f3);
                return Window.this.isModal;
            }

            public boolean scrolled(InputEvent inputEvent, float f2, float f3, int n2) {
                return Window.this.isModal;
            }

            @Override
            public boolean keyDown(InputEvent inputEvent, int n2) {
                return Window.this.isModal;
            }

            @Override
            public boolean keyUp(InputEvent inputEvent, int n2) {
                return Window.this.isModal;
            }

            @Override
            public boolean keyTyped(InputEvent inputEvent, char c2) {
                return Window.this.isModal;
            }
        });
    }

    protected Label newLabel(String string, Label.LabelStyle labelStyle) {
        return new Label((CharSequence)string, labelStyle);
    }

    public void setStyle(WindowStyle windowStyle) {
        if (windowStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = windowStyle;
        this.setBackground(windowStyle.background);
        this.titleLabel.setStyle(new Label.LabelStyle(windowStyle.titleFont, windowStyle.titleFontColor));
        this.invalidateHierarchy();
    }

    public WindowStyle getStyle() {
        return this.style;
    }

    public void keepWithinStage() {
        if (!this.keepWithinStage) {
            return;
        }
        Stage stage = this.getStage();
        if (stage == null) {
            return;
        }
        Camera camera = stage.getCamera();
        if (camera instanceof OrthographicCamera) {
            OrthographicCamera orthographicCamera = (OrthographicCamera)camera;
            float f2 = stage.getWidth();
            float f3 = stage.getHeight();
            if (this.getX(16) - camera.position.x > f2 / 2.0f / orthographicCamera.zoom) {
                this.setPosition(camera.position.x + f2 / 2.0f / orthographicCamera.zoom, this.getY(16), 16);
            }
            if (this.getX(8) - camera.position.x < -f2 / 2.0f / orthographicCamera.zoom) {
                this.setPosition(camera.position.x - f2 / 2.0f / orthographicCamera.zoom, this.getY(8), 8);
            }
            if (this.getY(2) - camera.position.y > f3 / 2.0f / orthographicCamera.zoom) {
                this.setPosition(this.getX(2), camera.position.y + f3 / 2.0f / orthographicCamera.zoom, 2);
            }
            if (this.getY(4) - camera.position.y < -f3 / 2.0f / orthographicCamera.zoom) {
                this.setPosition(this.getX(4), camera.position.y - f3 / 2.0f / orthographicCamera.zoom, 4);
            }
        } else if (this.getParent() == stage.getRoot()) {
            float f4 = stage.getWidth();
            float f5 = stage.getHeight();
            if (this.getX() < 0.0f) {
                this.setX(0.0f);
            }
            if (this.getRight() > f4) {
                this.setX(f4 - this.getWidth());
            }
            if (this.getY() < 0.0f) {
                this.setY(0.0f);
            }
            if (this.getTop() > f5) {
                this.setY(f5 - this.getHeight());
            }
        }
    }

    @Override
    public void draw(Batch batch, float f2) {
        Stage stage = this.getStage();
        if (stage != null) {
            if (stage.getKeyboardFocus() == null) {
                stage.setKeyboardFocus(this);
            }
            this.keepWithinStage();
            if (this.style.stageBackground != null) {
                this.stageToLocalCoordinates(tmpPosition.set(0.0f, 0.0f));
                this.stageToLocalCoordinates(tmpSize.set(stage.getWidth(), stage.getHeight()));
                this.drawStageBackground(batch, f2, this.getX() + Window.tmpPosition.x, this.getY() + Window.tmpPosition.y, this.getX() + Window.tmpSize.x, this.getY() + Window.tmpSize.y);
            }
        }
        super.draw(batch, f2);
    }

    protected void drawStageBackground(Batch batch, float f2, float f3, float f4, float f5, float f6) {
        Color color = this.getColor();
        batch.setColor(color.r, color.g, color.b, color.a * f2);
        this.style.stageBackground.draw(batch, f3, f4, f5, f6);
    }

    @Override
    protected void drawBackground(Batch batch, float f2, float f3, float f4) {
        super.drawBackground(batch, f2, f3, f4);
        this.titleTable.getColor().a = this.getColor().a;
        float f5 = this.getPadTop();
        float f6 = this.getPadLeft();
        this.titleTable.setSize(this.getWidth() - f6 - this.getPadRight(), f5);
        this.titleTable.setPosition(f6, this.getHeight() - f5);
        this.drawTitleTable = true;
        this.titleTable.draw(batch, f2);
        this.drawTitleTable = false;
    }

    @Override
    @Null
    public Actor hit(float f2, float f3, boolean bl2) {
        if (!this.isVisible()) {
            return null;
        }
        Actor actor = super.hit(f2, f3, bl2);
        if (actor == null && this.isModal && (!bl2 || this.getTouchable() == Touchable.enabled)) {
            return this;
        }
        float f4 = this.getHeight();
        if (actor == null || actor == this) {
            return actor;
        }
        if (f3 <= f4 && f3 >= f4 - this.getPadTop() && f2 >= 0.0f && f2 <= this.getWidth()) {
            Actor actor2 = actor;
            while (actor2.getParent() != this) {
                actor2 = actor2.getParent();
            }
            if (this.getCell(actor2) != null) {
                return this;
            }
        }
        return actor;
    }

    public boolean isMovable() {
        return this.isMovable;
    }

    public void setMovable(boolean bl2) {
        this.isMovable = bl2;
    }

    public boolean isModal() {
        return this.isModal;
    }

    public void setModal(boolean bl2) {
        this.isModal = bl2;
    }

    public void setKeepWithinStage(boolean bl2) {
        this.keepWithinStage = bl2;
    }

    public boolean isResizable() {
        return this.isResizable;
    }

    public void setResizable(boolean bl2) {
        this.isResizable = bl2;
    }

    public void setResizeBorder(int n2) {
        this.resizeBorder = n2;
    }

    public boolean isDragging() {
        return this.dragging;
    }

    @Override
    public float getPrefWidth() {
        return Math.max(super.getPrefWidth(), this.titleTable.getPrefWidth() + this.getPadLeft() + this.getPadRight());
    }

    public Table getTitleTable() {
        return this.titleTable;
    }

    public Label getTitleLabel() {
        return this.titleLabel;
    }

    public static class WindowStyle {
        @Null
        public Drawable background;
        public BitmapFont titleFont;
        @Null
        public Color titleFontColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        @Null
        public Drawable stageBackground;

        public WindowStyle() {
        }

        public WindowStyle(BitmapFont bitmapFont, Color color, @Null Drawable drawable) {
            this.titleFont = bitmapFont;
            this.titleFontColor.set(color);
            this.background = drawable;
        }

        public WindowStyle(WindowStyle windowStyle) {
            this.background = windowStyle.background;
            this.titleFont = windowStyle.titleFont;
            if (windowStyle.titleFontColor != null) {
                this.titleFontColor = new Color(windowStyle.titleFontColor);
            }
            this.background = windowStyle.background;
        }
    }
}

