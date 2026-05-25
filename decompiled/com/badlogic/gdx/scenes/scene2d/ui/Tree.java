/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;

public class Tree<N extends Node, V>
extends WidgetGroup {
    private static final Vector2 tmp = new Vector2();
    TreeStyle style;
    final Array<N> rootNodes = new Array();
    final Selection<N> selection = new Selection<N>(){

        @Override
        public void changed() {
            switch (this.size()) {
                case 0: {
                    Tree.this.rangeStart = null;
                    break;
                }
                case 1: {
                    Tree.this.rangeStart = (Node)this.first();
                }
            }
        }
    };
    float ySpacing = 4.0f;
    float iconSpacingLeft = 2.0f;
    float iconSpacingRight = 2.0f;
    float paddingLeft;
    float paddingRight;
    float indentSpacing;
    private float prefWidth;
    private float prefHeight;
    private boolean sizeInvalid = true;
    private N foundNode;
    private N overNode;
    N rangeStart;
    private ClickListener clickListener;

    public Tree(Skin skin) {
        this(skin.get(TreeStyle.class));
    }

    public Tree(Skin skin, String string) {
        this(skin.get(string, TreeStyle.class));
    }

    public Tree(TreeStyle treeStyle) {
        this.selection.setActor(this);
        this.selection.setMultiple(true);
        this.setStyle(treeStyle);
        this.initialize();
    }

    private void initialize() {
        this.clickListener = new ClickListener(){

            @Override
            public void clicked(InputEvent inputEvent, float f2, float f3) {
                Object n2 = Tree.this.getNodeAt(f3);
                if (n2 == null) {
                    return;
                }
                if (n2 != Tree.this.getNodeAt(this.getTouchDownY())) {
                    return;
                }
                if (Tree.this.selection.getMultiple() && Tree.this.selection.notEmpty() && UIUtils.shift()) {
                    float f4;
                    float f5;
                    if (Tree.this.rangeStart == null) {
                        Tree.this.rangeStart = n2;
                    }
                    Object n3 = Tree.this.rangeStart;
                    if (!UIUtils.ctrl()) {
                        Tree.this.selection.clear();
                    }
                    if ((f5 = ((Actor)((Node)n3).actor).getY()) > (f4 = ((Actor)((Node)n2).actor).getY())) {
                        Tree.this.selectNodes(Tree.this.rootNodes, f4, f5);
                    } else {
                        Tree.this.selectNodes(Tree.this.rootNodes, f5, f4);
                        Tree.this.selection.items().orderedItems().reverse();
                    }
                    Tree.this.selection.fireChangeEvent();
                    Tree.this.rangeStart = n3;
                    return;
                }
                if (!(((Node)n2).children.size <= 0 || Tree.this.selection.getMultiple() && UIUtils.ctrl())) {
                    float f6 = ((Actor)((Node)n2).actor).getX();
                    if (((Node)n2).icon != null) {
                        f6 -= Tree.this.iconSpacingRight + ((Node)n2).icon.getMinWidth();
                    }
                    if (f2 < f6) {
                        ((Node)n2).setExpanded(!((Node)n2).expanded);
                        return;
                    }
                }
                if (!((Node)n2).isSelectable()) {
                    return;
                }
                Tree.this.selection.choose(n2);
                if (!Tree.this.selection.isEmpty()) {
                    Tree.this.rangeStart = n2;
                }
            }

            @Override
            public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                Tree.this.setOverNode(Tree.this.getNodeAt(f3));
                return false;
            }

            @Override
            public void enter(InputEvent inputEvent, float f2, float f3, int n2, Actor actor) {
                super.enter(inputEvent, f2, f3, n2, actor);
                Tree.this.setOverNode(Tree.this.getNodeAt(f3));
            }

            @Override
            public void exit(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
                super.exit(inputEvent, f2, f3, n2, actor);
                if (actor == null || !actor.isDescendantOf(Tree.this)) {
                    Tree.this.setOverNode(null);
                }
            }
        };
        this.addListener(this.clickListener);
    }

    public void setStyle(TreeStyle treeStyle) {
        this.style = treeStyle;
        if (this.indentSpacing == 0.0f) {
            this.indentSpacing = this.plusMinusWidth();
        }
    }

    public void add(N n2) {
        this.insert(this.rootNodes.size, n2);
    }

    public void insert(int n2, N n3) {
        int n4;
        if (((Node)n3).parent != null) {
            ((Node)((Node)n3).parent).remove(n3);
            ((Node)n3).parent = null;
        } else {
            n4 = this.rootNodes.indexOf(n3, true);
            if (n4 != -1) {
                if (n4 == n2) {
                    return;
                }
                if (n4 < n2) {
                    --n2;
                }
                this.rootNodes.removeIndex(n4);
                int n5 = ((Actor)((Node)n3).actor).getZIndex();
                if (n5 != -1) {
                    ((Node)n3).removeFromTree(this, n5);
                }
            }
        }
        this.rootNodes.insert(n2, n3);
        if (n2 == 0) {
            n4 = 0;
        } else if (n2 < this.rootNodes.size - 1) {
            n4 = ((Actor)((Node)this.rootNodes.get((int)(n2 + 1))).actor).getZIndex();
        } else {
            Node node = (Node)this.rootNodes.get(n2 - 1);
            n4 = ((Actor)node.actor).getZIndex() + node.countActors();
        }
        ((Node)n3).addToTree(this, n4);
    }

    public void remove(N n2) {
        if (((Node)n2).parent != null) {
            ((Node)((Node)n2).parent).remove(n2);
            return;
        }
        if (!this.rootNodes.removeValue(n2, true)) {
            return;
        }
        int n3 = ((Actor)((Node)n2).actor).getZIndex();
        if (n3 != -1) {
            ((Node)n2).removeFromTree(this, n3);
        }
    }

    @Override
    public void clearChildren(boolean bl2) {
        super.clearChildren(bl2);
        this.setOverNode(null);
        this.rootNodes.clear();
        this.selection.clear();
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.sizeInvalid = true;
    }

    private float plusMinusWidth() {
        float f2 = Math.max(this.style.plus.getMinWidth(), this.style.minus.getMinWidth());
        if (this.style.plusOver != null) {
            f2 = Math.max(f2, this.style.plusOver.getMinWidth());
        }
        if (this.style.minusOver != null) {
            f2 = Math.max(f2, this.style.minusOver.getMinWidth());
        }
        return f2;
    }

    private void computeSize() {
        this.sizeInvalid = false;
        this.prefWidth = this.plusMinusWidth();
        this.prefHeight = 0.0f;
        this.computeSize(this.rootNodes, 0.0f, this.prefWidth);
        this.prefWidth += this.paddingLeft + this.paddingRight;
    }

    private void computeSize(Array<N> array, float f2, float f3) {
        float f4 = this.ySpacing;
        float f5 = this.iconSpacingLeft + this.iconSpacingRight;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = (Node)array.get(i2);
            float f6 = f2 + f3;
            Object a2 = node.actor;
            if (a2 instanceof Layout) {
                Layout layout = (Layout)a2;
                f6 += layout.getPrefWidth();
                node.height = layout.getPrefHeight();
            } else {
                f6 += ((Actor)a2).getWidth();
                node.height = ((Actor)a2).getHeight();
            }
            if (node.icon != null) {
                f6 += f5 + node.icon.getMinWidth();
                node.height = Math.max(node.height, node.icon.getMinHeight());
            }
            this.prefWidth = Math.max(this.prefWidth, f6);
            this.prefHeight += node.height + f4;
            if (!node.expanded) continue;
            this.computeSize(node.children, f2 + this.indentSpacing, f3);
        }
    }

    @Override
    public void layout() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        this.layout(this.rootNodes, this.paddingLeft, this.getHeight() - this.ySpacing / 2.0f, this.plusMinusWidth());
    }

    private float layout(Array<N> array, float f2, float f3, float f4) {
        float f5 = this.ySpacing;
        float f6 = this.iconSpacingLeft;
        float f7 = f6 + this.iconSpacingRight;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = (Node)array.get(i2);
            float f8 = f2 + f4;
            f8 = node.icon != null ? (f8 += f7 + node.icon.getMinWidth()) : (f8 += f6);
            if (node.actor instanceof Layout) {
                ((Layout)node.actor).pack();
            }
            ((Actor)node.actor).setPosition(f8, f3 -= node.getHeight());
            f3 -= f5;
            if (!node.expanded) continue;
            f3 = this.layout(node.children, f2 + this.indentSpacing, f3, f4);
        }
        return f3;
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.drawBackground(batch, f2);
        Color color = this.getColor();
        float f3 = color.a * f2;
        batch.setColor(color.r, color.g, color.b, f3);
        this.drawIcons(batch, color.r, color.g, color.b, f3, null, this.rootNodes, this.paddingLeft, this.plusMinusWidth());
        super.draw(batch, f2);
    }

    protected void drawBackground(Batch batch, float f2) {
        if (this.style.background != null) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * f2);
            this.style.background.draw(batch, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    protected float drawIcons(Batch batch, float f2, float f3, float f4, float f5, @Null N n2, Array<N> array, float f6, float f7) {
        Rectangle rectangle = this.getCullingArea();
        float f8 = 0.0f;
        float f9 = 0.0f;
        if (rectangle != null) {
            f8 = rectangle.y;
            f9 = f8 + rectangle.height;
        }
        TreeStyle treeStyle = this.style;
        float f10 = this.getX();
        float f11 = this.getY();
        float f12 = f10 + f6;
        float f13 = f12 + f7 + this.iconSpacingLeft;
        float f14 = 0.0f;
        int n3 = array.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            Node node = (Node)array.get(i2);
            Object a2 = node.actor;
            f14 = ((Actor)a2).getY();
            float f15 = node.height;
            if (rectangle == null || f14 + f15 >= f8 && f14 <= f9) {
                if (this.selection.contains(node) && treeStyle.selection != null) {
                    this.drawSelection(node, treeStyle.selection, batch, f10, f11 + f14 - this.ySpacing / 2.0f, this.getWidth(), f15 + this.ySpacing);
                } else if (node == this.overNode && treeStyle.over != null) {
                    this.drawOver(node, treeStyle.over, batch, f10, f11 + f14 - this.ySpacing / 2.0f, this.getWidth(), f15 + this.ySpacing);
                }
                if (node.icon != null) {
                    float f16 = f11 + f14 + (float)Math.round((f15 - node.icon.getMinHeight()) / 2.0f);
                    Color color = ((Actor)a2).getColor();
                    batch.setColor(color.r, color.g, color.b, color.a * f5);
                    this.drawIcon(node, node.icon, batch, f13, f16);
                    batch.setColor(f2, f3, f4, f5);
                }
                if (node.children.size > 0) {
                    Drawable drawable = this.getExpandIcon(node, f13);
                    float f17 = f11 + f14 + (float)Math.round((f15 - drawable.getMinHeight()) / 2.0f);
                    this.drawExpandIcon(node, drawable, batch, f12, f17);
                }
            } else if (f14 < f8) break;
            if (!node.expanded || node.children.size <= 0) continue;
            this.drawIcons(batch, f2, f3, f4, f5, node, node.children, f6 + this.indentSpacing, f7);
        }
        return f14;
    }

    protected void drawSelection(N n2, Drawable drawable, Batch batch, float f2, float f3, float f4, float f5) {
        drawable.draw(batch, f2, f3, f4, f5);
    }

    protected void drawOver(N n2, Drawable drawable, Batch batch, float f2, float f3, float f4, float f5) {
        drawable.draw(batch, f2, f3, f4, f5);
    }

    protected void drawExpandIcon(N n2, Drawable drawable, Batch batch, float f2, float f3) {
        drawable.draw(batch, f2, f3, drawable.getMinWidth(), drawable.getMinHeight());
    }

    protected void drawIcon(N n2, Drawable drawable, Batch batch, float f2, float f3) {
        drawable.draw(batch, f2, f3, drawable.getMinWidth(), drawable.getMinHeight());
    }

    protected Drawable getExpandIcon(N n2, float f2) {
        float f3;
        if (n2 == this.overNode && Gdx.app.getType() == Application.ApplicationType.Desktop && (!this.selection.getMultiple() || !UIUtils.ctrl() && !UIUtils.shift()) && (f3 = this.screenToLocalCoordinates((Vector2)Tree.tmp.set((float)((float)Gdx.input.getX()), (float)0.0f)).x + this.getX()) >= 0.0f && f3 < f2) {
            Drawable drawable;
            Drawable drawable2 = drawable = ((Node)n2).expanded ? this.style.minusOver : this.style.plusOver;
            if (drawable != null) {
                return drawable;
            }
        }
        return ((Node)n2).expanded ? this.style.minus : this.style.plus;
    }

    @Null
    public N getNodeAt(float f2) {
        this.foundNode = null;
        this.getNodeAt(this.rootNodes, f2, this.getHeight());
        try {
            N n2 = this.foundNode;
            return n2;
        }
        finally {
            this.foundNode = null;
        }
    }

    private float getNodeAt(Array<N> array, float f2, float f3) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = (Node)array.get(i2);
            float f4 = node.height;
            if (f2 >= (f3 -= node.getHeight() - f4) - f4 - this.ySpacing && f2 < f3) {
                this.foundNode = node;
                return -1.0f;
            }
            f3 -= f4 + this.ySpacing;
            if (!node.expanded || (f3 = this.getNodeAt(node.children, f2, f3)) != -1.0f) continue;
            return -1.0f;
        }
        return f3;
    }

    void selectNodes(Array<N> array, float f2, float f3) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = (Node)array.get(i2);
            if (((Actor)node.actor).getY() < f2) break;
            if (!node.isSelectable()) continue;
            if (((Actor)node.actor).getY() <= f3) {
                this.selection.add(node);
            }
            if (!node.expanded) continue;
            this.selectNodes(node.children, f2, f3);
        }
    }

    public Selection<N> getSelection() {
        return this.selection;
    }

    @Null
    public N getSelectedNode() {
        return (N)((Node)this.selection.first());
    }

    @Null
    public V getSelectedValue() {
        Node node = (Node)this.selection.first();
        return node == null ? null : (V)node.getValue();
    }

    public TreeStyle getStyle() {
        return this.style;
    }

    public Array<N> getRootNodes() {
        return this.rootNodes;
    }

    @Deprecated
    public Array<N> getNodes() {
        return this.rootNodes;
    }

    public void updateRootNodes() {
        int n2;
        int n3 = this.rootNodes.size;
        for (n2 = 0; n2 < n3; ++n2) {
            Node node = (Node)this.rootNodes.get(n2);
            int n4 = ((Actor)node.actor).getZIndex();
            if (n4 == -1) continue;
            node.removeFromTree(this, n4);
        }
        n3 = this.rootNodes.size;
        int n5 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            n5 += ((Node)this.rootNodes.get(n2)).addToTree(this, n5);
        }
    }

    @Null
    public N getOverNode() {
        return this.overNode;
    }

    @Null
    public V getOverValue() {
        if (this.overNode == null) {
            return null;
        }
        return ((Node)this.overNode).getValue();
    }

    public void setOverNode(@Null N n2) {
        this.overNode = n2;
    }

    public void setPadding(float f2) {
        this.paddingLeft = f2;
        this.paddingRight = f2;
    }

    public void setPadding(float f2, float f3) {
        this.paddingLeft = f2;
        this.paddingRight = f3;
    }

    public void setIndentSpacing(float f2) {
        this.indentSpacing = f2;
    }

    public float getIndentSpacing() {
        return this.indentSpacing;
    }

    public void setYSpacing(float f2) {
        this.ySpacing = f2;
    }

    public float getYSpacing() {
        return this.ySpacing;
    }

    public void setIconSpacing(float f2, float f3) {
        this.iconSpacingLeft = f2;
        this.iconSpacingRight = f3;
    }

    @Override
    public float getPrefWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefHeight;
    }

    public void findExpandedValues(Array<V> array) {
        Tree.findExpandedValues(this.rootNodes, array);
    }

    public void restoreExpandedValues(Array<V> array) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            N n3 = this.findNode(array.get(i2));
            if (n3 == null) continue;
            ((Node)n3).setExpanded(true);
            ((Node)n3).expandTo();
        }
    }

    static boolean findExpandedValues(Array<? extends Node> array, Array array2) {
        boolean bl2 = false;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = array.get(i2);
            if (!node.expanded || Tree.findExpandedValues(node.children, array2)) continue;
            array2.add(node.value);
        }
        return bl2;
    }

    @Null
    public N findNode(V v2) {
        if (v2 == null) {
            throw new IllegalArgumentException("value cannot be null.");
        }
        return (N)Tree.findNode(this.rootNodes, v2);
    }

    @Null
    static Node findNode(Array<? extends Node> array, Object object) {
        Node node;
        int n2;
        int n3 = array.size;
        for (n2 = 0; n2 < n3; ++n2) {
            node = array.get(n2);
            if (!object.equals(node.value)) continue;
            return node;
        }
        n3 = array.size;
        for (n2 = 0; n2 < n3; ++n2) {
            node = array.get(n2);
            Node node2 = Tree.findNode(node.children, object);
            if (node2 == null) continue;
            return node2;
        }
        return null;
    }

    public void collapseAll() {
        Tree.collapseAll(this.rootNodes);
    }

    static void collapseAll(Array<? extends Node> array) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = array.get(i2);
            node.setExpanded(false);
            Tree.collapseAll(node.children);
        }
    }

    public void expandAll() {
        Tree.expandAll(this.rootNodes);
    }

    static void expandAll(Array<? extends Node> array) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            array.get(i2).expandAll();
        }
    }

    public ClickListener getClickListener() {
        return this.clickListener;
    }

    public static class TreeStyle {
        public Drawable plus;
        public Drawable minus;
        @Null
        public Drawable plusOver;
        @Null
        public Drawable minusOver;
        @Null
        public Drawable over;
        @Null
        public Drawable selection;
        @Null
        public Drawable background;

        public TreeStyle() {
        }

        public TreeStyle(Drawable drawable, Drawable drawable2, @Null Drawable drawable3) {
            this.plus = drawable;
            this.minus = drawable2;
            this.selection = drawable3;
        }

        public TreeStyle(TreeStyle treeStyle) {
            this.plus = treeStyle.plus;
            this.minus = treeStyle.minus;
            this.plusOver = treeStyle.plusOver;
            this.minusOver = treeStyle.minusOver;
            this.over = treeStyle.over;
            this.selection = treeStyle.selection;
            this.background = treeStyle.background;
        }
    }

    public static abstract class Node<N extends Node, V, A extends Actor> {
        A actor;
        N parent;
        final Array<N> children = new Array(0);
        boolean selectable = true;
        boolean expanded;
        Drawable icon;
        float height;
        V value;

        public Node(A a2) {
            if (a2 == null) {
                throw new IllegalArgumentException("actor cannot be null.");
            }
            this.actor = a2;
        }

        public Node() {
        }

        public void setExpanded(boolean bl2) {
            if (bl2 == this.expanded) {
                return;
            }
            this.expanded = bl2;
            if (this.children.size == 0) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree == null) {
                return;
            }
            T[] TArray = this.children.items;
            int n2 = ((Actor)this.actor).getZIndex() + 1;
            if (bl2) {
                int n3 = this.children.size;
                for (int i2 = 0; i2 < n3; ++i2) {
                    n2 += ((Node)TArray[i2]).addToTree(tree, n2);
                }
            } else {
                int n4 = this.children.size;
                for (int i3 = 0; i3 < n4; ++i3) {
                    ((Node)TArray[i3]).removeFromTree(tree, n2);
                }
            }
        }

        protected int addToTree(Tree<N, V> tree, int n2) {
            tree.addActorAt(n2, (Actor)this.actor);
            if (!this.expanded) {
                return 1;
            }
            int n3 = n2 + 1;
            T[] TArray = this.children.items;
            int n4 = this.children.size;
            for (int i2 = 0; i2 < n4; ++i2) {
                n3 += ((Node)TArray[i2]).addToTree(tree, n3);
            }
            return n3 - n2;
        }

        protected void removeFromTree(Tree<N, V> tree, int n2) {
            Actor actor = tree.removeActorAt(n2, true);
            if (!this.expanded) {
                return;
            }
            T[] TArray = this.children.items;
            int n3 = this.children.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                ((Node)TArray[i2]).removeFromTree(tree, n2);
            }
        }

        public void add(N n2) {
            this.insert(this.children.size, n2);
        }

        public void addAll(Array<N> array) {
            int n2 = array.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.insert(this.children.size, (Node)array.get(i2));
            }
        }

        public void insert(int n2, N n3) {
            ((Node)n3).parent = this;
            this.children.insert(n2, n3);
            if (!this.expanded) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree != null) {
                int n4;
                if (n2 == 0) {
                    n4 = ((Actor)this.actor).getZIndex() + 1;
                } else if (n2 < this.children.size - 1) {
                    n4 = ((Actor)((Node)this.children.get((int)(n2 + 1))).actor).getZIndex();
                } else {
                    Node node = (Node)this.children.get(n2 - 1);
                    n4 = ((Actor)node.actor).getZIndex() + node.countActors();
                }
                ((Node)n3).addToTree(tree, n4);
            }
        }

        int countActors() {
            if (!this.expanded) {
                return 1;
            }
            int n2 = 1;
            T[] TArray = this.children.items;
            int n3 = this.children.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 += ((Node)TArray[i2]).countActors();
            }
            return n2;
        }

        public void remove() {
            Tree<Node, V> tree = this.getTree();
            if (tree != null) {
                tree.remove(this);
            } else if (this.parent != null) {
                this.parent.remove((Node)this);
            }
        }

        public void remove(N n2) {
            if (!this.children.removeValue(n2, true)) {
                return;
            }
            if (!this.expanded) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree != null) {
                ((Node)n2).removeFromTree(tree, ((Actor)((Node)n2).actor).getZIndex());
            }
        }

        public void clearChildren() {
            Tree<N, V> tree;
            if (this.expanded && (tree = this.getTree()) != null) {
                int n2 = ((Actor)this.actor).getZIndex() + 1;
                T[] TArray = this.children.items;
                int n3 = this.children.size;
                for (int i2 = 0; i2 < n3; ++i2) {
                    ((Node)TArray[i2]).removeFromTree(tree, n2);
                }
            }
            this.children.clear();
        }

        @Null
        public Tree<N, V> getTree() {
            Group group = ((Actor)this.actor).getParent();
            if (group instanceof Tree) {
                return (Tree)group;
            }
            return null;
        }

        public void setActor(A a2) {
            Tree<N, V> tree;
            if (this.actor != null && (tree = this.getTree()) != null) {
                int n2 = ((Actor)this.actor).getZIndex();
                tree.removeActorAt(n2, true);
                tree.addActorAt(n2, (Actor)a2);
            }
            this.actor = a2;
        }

        public A getActor() {
            return this.actor;
        }

        public boolean isExpanded() {
            return this.expanded;
        }

        public Array<N> getChildren() {
            return this.children;
        }

        public boolean hasChildren() {
            return this.children.size > 0;
        }

        public void updateChildren() {
            int n2;
            if (!this.expanded) {
                return;
            }
            Tree<N, V> tree = this.getTree();
            if (tree == null) {
                return;
            }
            T[] TArray = this.children.items;
            int n3 = this.children.size;
            int n4 = ((Actor)this.actor).getZIndex() + 1;
            for (n2 = 0; n2 < n3; ++n2) {
                ((Node)TArray[n2]).removeFromTree(tree, n4);
            }
            for (n2 = 0; n2 < n3; ++n2) {
                n4 += ((Node)TArray[n2]).addToTree(tree, n4);
            }
        }

        @Null
        public N getParent() {
            return this.parent;
        }

        public void setIcon(@Null Drawable drawable) {
            this.icon = drawable;
        }

        @Null
        public V getValue() {
            return this.value;
        }

        public void setValue(@Null V v2) {
            this.value = v2;
        }

        @Null
        public Drawable getIcon() {
            return this.icon;
        }

        public int getLevel() {
            int n2 = 0;
            Node<N, V, A> node = this;
            do {
                ++n2;
            } while ((node = node.getParent()) != null);
            return n2;
        }

        @Null
        public N findNode(V v2) {
            if (v2 == null) {
                throw new IllegalArgumentException("value cannot be null.");
            }
            if (v2.equals(this.value)) {
                return (N)this;
            }
            return (N)Tree.findNode(this.children, v2);
        }

        public void collapseAll() {
            this.setExpanded(false);
            Tree.collapseAll(this.children);
        }

        public void expandAll() {
            this.setExpanded(true);
            if (this.children.size > 0) {
                Tree.expandAll(this.children);
            }
        }

        public void expandTo() {
            N n2 = this.parent;
            while (n2 != null) {
                ((Node)n2).setExpanded(true);
                n2 = ((Node)n2).parent;
            }
        }

        public boolean isSelectable() {
            return this.selectable;
        }

        public void setSelectable(boolean bl2) {
            this.selectable = bl2;
        }

        public void findExpandedValues(Array<V> array) {
            if (this.expanded && !Tree.findExpandedValues(this.children, array)) {
                array.add(this.value);
            }
        }

        public void restoreExpandedValues(Array<V> array) {
            int n2 = array.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                N n3 = this.findNode(array.get(i2));
                if (n3 == null) continue;
                ((Node)n3).setExpanded(true);
                ((Node)n3).expandTo();
            }
        }

        public float getHeight() {
            return this.height;
        }

        public boolean isAscendantOf(N n2) {
            if (n2 == null) {
                throw new IllegalArgumentException("node cannot be null.");
            }
            N n3 = n2;
            do {
                if (n3 != this) continue;
                return true;
            } while ((n3 = ((Node)n3).parent) != null);
            return false;
        }

        public boolean isDescendantOf(N n2) {
            if (n2 == null) {
                throw new IllegalArgumentException("node cannot be null.");
            }
            Node<N, V, A> node = this;
            do {
                if (node != n2) continue;
                return true;
            } while ((node = node.parent) != null);
            return false;
        }
    }
}

