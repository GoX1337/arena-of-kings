/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Null;

public abstract class Value {
    public static final Fixed zero = new Fixed(0.0f);
    public static Value minWidth = new Value(){

        @Override
        public float get(@Null Actor actor) {
            if (actor instanceof Layout) {
                return ((Layout)((Object)actor)).getMinWidth();
            }
            return actor == null ? 0.0f : actor.getWidth();
        }
    };
    public static Value minHeight = new Value(){

        @Override
        public float get(@Null Actor actor) {
            if (actor instanceof Layout) {
                return ((Layout)((Object)actor)).getMinHeight();
            }
            return actor == null ? 0.0f : actor.getHeight();
        }
    };
    public static Value prefWidth = new Value(){

        @Override
        public float get(@Null Actor actor) {
            if (actor instanceof Layout) {
                return ((Layout)((Object)actor)).getPrefWidth();
            }
            return actor == null ? 0.0f : actor.getWidth();
        }
    };
    public static Value prefHeight = new Value(){

        @Override
        public float get(@Null Actor actor) {
            if (actor instanceof Layout) {
                return ((Layout)((Object)actor)).getPrefHeight();
            }
            return actor == null ? 0.0f : actor.getHeight();
        }
    };
    public static Value maxWidth = new Value(){

        @Override
        public float get(@Null Actor actor) {
            if (actor instanceof Layout) {
                return ((Layout)((Object)actor)).getMaxWidth();
            }
            return actor == null ? 0.0f : actor.getWidth();
        }
    };
    public static Value maxHeight = new Value(){

        @Override
        public float get(@Null Actor actor) {
            if (actor instanceof Layout) {
                return ((Layout)((Object)actor)).getMaxHeight();
            }
            return actor == null ? 0.0f : actor.getHeight();
        }
    };

    public float get() {
        return this.get(null);
    }

    public abstract float get(@Null Actor var1);

    public static Value percentWidth(final float f2) {
        return new Value(){

            @Override
            public float get(@Null Actor actor) {
                return actor.getWidth() * f2;
            }
        };
    }

    public static Value percentHeight(final float f2) {
        return new Value(){

            @Override
            public float get(@Null Actor actor) {
                return actor.getHeight() * f2;
            }
        };
    }

    public static Value percentWidth(final float f2, final Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        return new Value(){

            @Override
            public float get(@Null Actor actor2) {
                return actor.getWidth() * f2;
            }
        };
    }

    public static Value percentHeight(final float f2, final Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        return new Value(){

            @Override
            public float get(@Null Actor actor2) {
                return actor.getHeight() * f2;
            }
        };
    }

    public static class Fixed
    extends Value {
        static final Fixed[] cache = new Fixed[111];
        private final float value;

        public Fixed(float f2) {
            this.value = f2;
        }

        @Override
        public float get(@Null Actor actor) {
            return this.value;
        }

        public String toString() {
            return Float.toString(this.value);
        }

        public static Fixed valueOf(float f2) {
            if (f2 == 0.0f) {
                return zero;
            }
            if (f2 >= -10.0f && f2 <= 100.0f && f2 == (float)((int)f2)) {
                Fixed fixed = cache[(int)f2 + 10];
                if (fixed == null) {
                    Fixed.cache[(int)f2 + 10] = fixed = new Fixed(f2);
                }
                return fixed;
            }
            return new Fixed(f2);
        }
    }
}

