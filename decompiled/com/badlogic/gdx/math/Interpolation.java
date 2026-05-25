/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;

public abstract class Interpolation {
    public static final Interpolation linear = new Interpolation(){

        @Override
        public float apply(float f2) {
            return f2;
        }
    };
    public static final Interpolation smooth = new Interpolation(){

        @Override
        public float apply(float f2) {
            return f2 * f2 * (3.0f - 2.0f * f2);
        }
    };
    public static final Interpolation smooth2 = new Interpolation(){

        @Override
        public float apply(float f2) {
            f2 = f2 * f2 * (3.0f - 2.0f * f2);
            return f2 * f2 * (3.0f - 2.0f * f2);
        }
    };
    public static final Interpolation smoother;
    public static final Interpolation fade;
    public static final Pow pow2;
    public static final PowIn pow2In;
    public static final PowIn slowFast;
    public static final PowOut pow2Out;
    public static final PowOut fastSlow;
    public static final Interpolation pow2InInverse;
    public static final Interpolation pow2OutInverse;
    public static final Pow pow3;
    public static final PowIn pow3In;
    public static final PowOut pow3Out;
    public static final Interpolation pow3InInverse;
    public static final Interpolation pow3OutInverse;
    public static final Pow pow4;
    public static final PowIn pow4In;
    public static final PowOut pow4Out;
    public static final Pow pow5;
    public static final PowIn pow5In;
    public static final PowOut pow5Out;
    public static final Interpolation sine;
    public static final Interpolation sineIn;
    public static final Interpolation sineOut;
    public static final Exp exp10;
    public static final ExpIn exp10In;
    public static final ExpOut exp10Out;
    public static final Exp exp5;
    public static final ExpIn exp5In;
    public static final ExpOut exp5Out;
    public static final Interpolation circle;
    public static final Interpolation circleIn;
    public static final Interpolation circleOut;
    public static final Elastic elastic;
    public static final ElasticIn elasticIn;
    public static final ElasticOut elasticOut;
    public static final Swing swing;
    public static final SwingIn swingIn;
    public static final SwingOut swingOut;
    public static final Bounce bounce;
    public static final BounceIn bounceIn;
    public static final BounceOut bounceOut;

    public abstract float apply(float var1);

    public float apply(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * this.apply(f4);
    }

    static {
        fade = smoother = new Interpolation(){

            @Override
            public float apply(float f2) {
                return f2 * f2 * f2 * (f2 * (f2 * 6.0f - 15.0f) + 10.0f);
            }
        };
        pow2 = new Pow(2);
        slowFast = pow2In = new PowIn(2);
        fastSlow = pow2Out = new PowOut(2);
        pow2InInverse = new Interpolation(){

            @Override
            public float apply(float f2) {
                if (f2 < 1.0E-6f) {
                    return 0.0f;
                }
                return (float)Math.sqrt(f2);
            }
        };
        pow2OutInverse = new Interpolation(){

            @Override
            public float apply(float f2) {
                if (f2 < 1.0E-6f) {
                    return 0.0f;
                }
                if (f2 > 1.0f) {
                    return 1.0f;
                }
                return 1.0f - (float)Math.sqrt(-(f2 - 1.0f));
            }
        };
        pow3 = new Pow(3);
        pow3In = new PowIn(3);
        pow3Out = new PowOut(3);
        pow3InInverse = new Interpolation(){

            @Override
            public float apply(float f2) {
                return (float)Math.cbrt(f2);
            }
        };
        pow3OutInverse = new Interpolation(){

            @Override
            public float apply(float f2) {
                return 1.0f - (float)Math.cbrt(-(f2 - 1.0f));
            }
        };
        pow4 = new Pow(4);
        pow4In = new PowIn(4);
        pow4Out = new PowOut(4);
        pow5 = new Pow(5);
        pow5In = new PowIn(5);
        pow5Out = new PowOut(5);
        sine = new Interpolation(){

            @Override
            public float apply(float f2) {
                return (1.0f - MathUtils.cos(f2 * (float)Math.PI)) / 2.0f;
            }
        };
        sineIn = new Interpolation(){

            @Override
            public float apply(float f2) {
                return 1.0f - MathUtils.cos(f2 * 1.5707964f);
            }
        };
        sineOut = new Interpolation(){

            @Override
            public float apply(float f2) {
                return MathUtils.sin(f2 * 1.5707964f);
            }
        };
        exp10 = new Exp(2.0f, 10.0f);
        exp10In = new ExpIn(2.0f, 10.0f);
        exp10Out = new ExpOut(2.0f, 10.0f);
        exp5 = new Exp(2.0f, 5.0f);
        exp5In = new ExpIn(2.0f, 5.0f);
        exp5Out = new ExpOut(2.0f, 5.0f);
        circle = new Interpolation(){

            @Override
            public float apply(float f2) {
                if (f2 <= 0.5f) {
                    return (1.0f - (float)Math.sqrt(1.0f - (f2 *= 2.0f) * f2)) / 2.0f;
                }
                f2 -= 1.0f;
                return ((float)Math.sqrt(1.0f - (f2 *= 2.0f) * f2) + 1.0f) / 2.0f;
            }
        };
        circleIn = new Interpolation(){

            @Override
            public float apply(float f2) {
                return 1.0f - (float)Math.sqrt(1.0f - f2 * f2);
            }
        };
        circleOut = new Interpolation(){

            @Override
            public float apply(float f2) {
                return (float)Math.sqrt(1.0f - (f2 -= 1.0f) * f2);
            }
        };
        elastic = new Elastic(2.0f, 10.0f, 7, 1.0f);
        elasticIn = new ElasticIn(2.0f, 10.0f, 6, 1.0f);
        elasticOut = new ElasticOut(2.0f, 10.0f, 7, 1.0f);
        swing = new Swing(1.5f);
        swingIn = new SwingIn(2.0f);
        swingOut = new SwingOut(2.0f);
        bounce = new Bounce(4);
        bounceIn = new BounceIn(4);
        bounceOut = new BounceOut(4);
    }

    public static class SwingIn
    extends Interpolation {
        private final float scale;

        public SwingIn(float f2) {
            this.scale = f2;
        }

        @Override
        public float apply(float f2) {
            return f2 * f2 * ((this.scale + 1.0f) * f2 - this.scale);
        }
    }

    public static class SwingOut
    extends Interpolation {
        private final float scale;

        public SwingOut(float f2) {
            this.scale = f2;
        }

        @Override
        public float apply(float f2) {
            return (f2 -= 1.0f) * f2 * ((this.scale + 1.0f) * f2 + this.scale) + 1.0f;
        }
    }

    public static class Swing
    extends Interpolation {
        private final float scale;

        public Swing(float f2) {
            this.scale = f2 * 2.0f;
        }

        @Override
        public float apply(float f2) {
            if (f2 <= 0.5f) {
                return (f2 *= 2.0f) * f2 * ((this.scale + 1.0f) * f2 - this.scale) / 2.0f;
            }
            f2 -= 1.0f;
            return (f2 *= 2.0f) * f2 * ((this.scale + 1.0f) * f2 + this.scale) / 2.0f + 1.0f;
        }
    }

    public static class BounceIn
    extends BounceOut {
        public BounceIn(float[] fArray, float[] fArray2) {
            super(fArray, fArray2);
        }

        public BounceIn(int n2) {
            super(n2);
        }

        @Override
        public float apply(float f2) {
            return 1.0f - super.apply(1.0f - f2);
        }
    }

    public static class BounceOut
    extends Interpolation {
        final float[] widths;
        final float[] heights;

        public BounceOut(float[] fArray, float[] fArray2) {
            if (fArray.length != fArray2.length) {
                throw new IllegalArgumentException("Must be the same number of widths and heights.");
            }
            this.widths = fArray;
            this.heights = fArray2;
        }

        public BounceOut(int n2) {
            if (n2 < 2 || n2 > 5) {
                throw new IllegalArgumentException("bounces cannot be < 2 or > 5: " + n2);
            }
            this.widths = new float[n2];
            this.heights = new float[n2];
            this.heights[0] = 1.0f;
            switch (n2) {
                case 2: {
                    this.widths[0] = 0.6f;
                    this.widths[1] = 0.4f;
                    this.heights[1] = 0.33f;
                    break;
                }
                case 3: {
                    this.widths[0] = 0.4f;
                    this.widths[1] = 0.4f;
                    this.widths[2] = 0.2f;
                    this.heights[1] = 0.33f;
                    this.heights[2] = 0.1f;
                    break;
                }
                case 4: {
                    this.widths[0] = 0.34f;
                    this.widths[1] = 0.34f;
                    this.widths[2] = 0.2f;
                    this.widths[3] = 0.15f;
                    this.heights[1] = 0.26f;
                    this.heights[2] = 0.11f;
                    this.heights[3] = 0.03f;
                    break;
                }
                case 5: {
                    this.widths[0] = 0.3f;
                    this.widths[1] = 0.3f;
                    this.widths[2] = 0.2f;
                    this.widths[3] = 0.1f;
                    this.widths[4] = 0.1f;
                    this.heights[1] = 0.45f;
                    this.heights[2] = 0.3f;
                    this.heights[3] = 0.15f;
                    this.heights[4] = 0.06f;
                }
            }
            this.widths[0] = this.widths[0] * 2.0f;
        }

        @Override
        public float apply(float f2) {
            if (f2 == 1.0f) {
                return 1.0f;
            }
            f2 += this.widths[0] / 2.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            int n2 = this.widths.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                f3 = this.widths[i2];
                if (f2 <= f3) {
                    f4 = this.heights[i2];
                    break;
                }
                f2 -= f3;
            }
            float f5 = 4.0f / f3 * f4 * (f2 /= f3);
            return 1.0f - (f5 - f5 * f2) * f3;
        }
    }

    public static class Bounce
    extends BounceOut {
        public Bounce(float[] fArray, float[] fArray2) {
            super(fArray, fArray2);
        }

        public Bounce(int n2) {
            super(n2);
        }

        private float out(float f2) {
            float f3 = f2 + this.widths[0] / 2.0f;
            if (f3 < this.widths[0]) {
                return f3 / (this.widths[0] / 2.0f) - 1.0f;
            }
            return super.apply(f2);
        }

        @Override
        public float apply(float f2) {
            if (f2 <= 0.5f) {
                return (1.0f - this.out(1.0f - f2 * 2.0f)) / 2.0f;
            }
            return this.out(f2 * 2.0f - 1.0f) / 2.0f + 0.5f;
        }
    }

    public static class ElasticOut
    extends Elastic {
        public ElasticOut(float f2, float f3, int n2, float f4) {
            super(f2, f3, n2, f4);
        }

        @Override
        public float apply(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            f2 = 1.0f - f2;
            return 1.0f - (float)Math.pow(this.value, this.power * (f2 - 1.0f)) * MathUtils.sin(f2 * this.bounces) * this.scale;
        }
    }

    public static class ElasticIn
    extends Elastic {
        public ElasticIn(float f2, float f3, int n2, float f4) {
            super(f2, f3, n2, f4);
        }

        @Override
        public float apply(float f2) {
            if ((double)f2 >= 0.99) {
                return 1.0f;
            }
            return (float)Math.pow(this.value, this.power * (f2 - 1.0f)) * MathUtils.sin(f2 * this.bounces) * this.scale;
        }
    }

    public static class Elastic
    extends Interpolation {
        final float value;
        final float power;
        final float scale;
        final float bounces;

        public Elastic(float f2, float f3, int n2, float f4) {
            this.value = f2;
            this.power = f3;
            this.scale = f4;
            this.bounces = (float)n2 * (float)Math.PI * (float)(n2 % 2 == 0 ? 1 : -1);
        }

        @Override
        public float apply(float f2) {
            if (f2 <= 0.5f) {
                return (float)Math.pow(this.value, this.power * ((f2 *= 2.0f) - 1.0f)) * MathUtils.sin(f2 * this.bounces) * this.scale / 2.0f;
            }
            f2 = 1.0f - f2;
            return 1.0f - (float)Math.pow(this.value, this.power * ((f2 *= 2.0f) - 1.0f)) * MathUtils.sin(f2 * this.bounces) * this.scale / 2.0f;
        }
    }

    public static class ExpOut
    extends Exp {
        public ExpOut(float f2, float f3) {
            super(f2, f3);
        }

        @Override
        public float apply(float f2) {
            return 1.0f - ((float)Math.pow(this.value, -this.power * f2) - this.min) * this.scale;
        }
    }

    public static class ExpIn
    extends Exp {
        public ExpIn(float f2, float f3) {
            super(f2, f3);
        }

        @Override
        public float apply(float f2) {
            return ((float)Math.pow(this.value, this.power * (f2 - 1.0f)) - this.min) * this.scale;
        }
    }

    public static class Exp
    extends Interpolation {
        final float value;
        final float power;
        final float min;
        final float scale;

        public Exp(float f2, float f3) {
            this.value = f2;
            this.power = f3;
            this.min = (float)Math.pow(f2, -f3);
            this.scale = 1.0f / (1.0f - this.min);
        }

        @Override
        public float apply(float f2) {
            if (f2 <= 0.5f) {
                return ((float)Math.pow(this.value, this.power * (f2 * 2.0f - 1.0f)) - this.min) * this.scale / 2.0f;
            }
            return (2.0f - ((float)Math.pow(this.value, -this.power * (f2 * 2.0f - 1.0f)) - this.min) * this.scale) / 2.0f;
        }
    }

    public static class PowOut
    extends Pow {
        public PowOut(int n2) {
            super(n2);
        }

        @Override
        public float apply(float f2) {
            return (float)Math.pow(f2 - 1.0f, this.power) * (float)(this.power % 2 == 0 ? -1 : 1) + 1.0f;
        }
    }

    public static class PowIn
    extends Pow {
        public PowIn(int n2) {
            super(n2);
        }

        @Override
        public float apply(float f2) {
            return (float)Math.pow(f2, this.power);
        }
    }

    public static class Pow
    extends Interpolation {
        final int power;

        public Pow(int n2) {
            this.power = n2;
        }

        @Override
        public float apply(float f2) {
            if (f2 <= 0.5f) {
                return (float)Math.pow(f2 * 2.0f, this.power) / 2.0f;
            }
            return (float)Math.pow((f2 - 1.0f) * 2.0f, this.power) / (float)(this.power % 2 == 0 ? -2 : 2) + 1.0f;
        }
    }
}

