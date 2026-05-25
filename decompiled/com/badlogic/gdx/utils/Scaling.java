/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Vector2;

public abstract class Scaling {
    protected static final Vector2 temp = new Vector2();
    public static final Scaling fit = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            float f6 = f5 / f4;
            float f7 = f3 / f2;
            float f8 = f6 > f7 ? f4 / f2 : f5 / f3;
            _1.temp.x = f2 * f8;
            _1.temp.y = f3 * f8;
            return temp;
        }
    };
    public static final Scaling contain = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            float f6;
            float f7 = f5 / f4;
            float f8 = f3 / f2;
            float f9 = f6 = f7 > f8 ? f4 / f2 : f5 / f3;
            if (f6 > 1.0f) {
                f6 = 1.0f;
            }
            _2.temp.x = f2 * f6;
            _2.temp.y = f3 * f6;
            return temp;
        }
    };
    public static final Scaling fill = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            float f6 = f5 / f4;
            float f7 = f3 / f2;
            float f8 = f6 < f7 ? f4 / f2 : f5 / f3;
            _3.temp.x = f2 * f8;
            _3.temp.y = f3 * f8;
            return temp;
        }
    };
    public static final Scaling fillX = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            float f6 = f4 / f2;
            _4.temp.x = f2 * f6;
            _4.temp.y = f3 * f6;
            return temp;
        }
    };
    public static final Scaling fillY = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            float f6 = f5 / f3;
            _5.temp.x = f2 * f6;
            _5.temp.y = f3 * f6;
            return temp;
        }
    };
    public static final Scaling stretch = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            _6.temp.x = f4;
            _6.temp.y = f5;
            return temp;
        }
    };
    public static final Scaling stretchX = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            _7.temp.x = f4;
            _7.temp.y = f3;
            return temp;
        }
    };
    public static final Scaling stretchY = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            _8.temp.x = f2;
            _8.temp.y = f5;
            return temp;
        }
    };
    public static final Scaling none = new Scaling(){

        @Override
        public Vector2 apply(float f2, float f3, float f4, float f5) {
            _9.temp.x = f2;
            _9.temp.y = f3;
            return temp;
        }
    };

    public abstract Vector2 apply(float var1, float var2, float var3, float var4);
}

