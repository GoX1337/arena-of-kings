/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DiffBuilder<T>
implements Builder<DiffResult<T>> {
    private final List<Diff<?>> diffs;
    private final boolean objectsTriviallyEqual;
    private final T left;
    private final T right;
    private final ToStringStyle style;

    public DiffBuilder(T t2, T t3, ToStringStyle toStringStyle, boolean bl2) {
        Validate.notNull(t2, "lhs", new Object[0]);
        Validate.notNull(t3, "rhs", new Object[0]);
        this.diffs = new ArrayList();
        this.left = t2;
        this.right = t3;
        this.style = toStringStyle;
        this.objectsTriviallyEqual = bl2 && (t2 == t3 || t2.equals(t3));
    }

    public DiffBuilder(T t2, T t3, ToStringStyle toStringStyle) {
        this(t2, t3, toStringStyle, true);
    }

    public DiffBuilder<T> append(String string, final boolean bl2, final boolean bl3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (bl2 != bl3) {
            this.diffs.add(new Diff<Boolean>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Boolean getLeft() {
                    return bl2;
                }

                @Override
                public Boolean getRight() {
                    return bl3;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final boolean[] blArray, final boolean[] blArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(blArray, blArray2)) {
            this.diffs.add(new Diff<Boolean[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Boolean[] getLeft() {
                    return ArrayUtils.toObject(blArray);
                }

                @Override
                public Boolean[] getRight() {
                    return ArrayUtils.toObject(blArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final byte by2, final byte by3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (by2 != by3) {
            this.diffs.add(new Diff<Byte>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Byte getLeft() {
                    return by2;
                }

                @Override
                public Byte getRight() {
                    return by3;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final byte[] byArray, final byte[] byArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(byArray, byArray2)) {
            this.diffs.add(new Diff<Byte[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Byte[] getLeft() {
                    return ArrayUtils.toObject(byArray);
                }

                @Override
                public Byte[] getRight() {
                    return ArrayUtils.toObject(byArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final char c2, final char c3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (c2 != c3) {
            this.diffs.add(new Diff<Character>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Character getLeft() {
                    return Character.valueOf(c2);
                }

                @Override
                public Character getRight() {
                    return Character.valueOf(c3);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final char[] cArray, final char[] cArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(cArray, cArray2)) {
            this.diffs.add(new Diff<Character[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Character[] getLeft() {
                    return ArrayUtils.toObject(cArray);
                }

                @Override
                public Character[] getRight() {
                    return ArrayUtils.toObject(cArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final double d2, final double d3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (Double.doubleToLongBits(d2) != Double.doubleToLongBits(d3)) {
            this.diffs.add(new Diff<Double>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Double getLeft() {
                    return d2;
                }

                @Override
                public Double getRight() {
                    return d3;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final double[] dArray, final double[] dArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(dArray, dArray2)) {
            this.diffs.add(new Diff<Double[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Double[] getLeft() {
                    return ArrayUtils.toObject(dArray);
                }

                @Override
                public Double[] getRight() {
                    return ArrayUtils.toObject(dArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final float f2, final float f3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (Float.floatToIntBits(f2) != Float.floatToIntBits(f3)) {
            this.diffs.add(new Diff<Float>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Float getLeft() {
                    return Float.valueOf(f2);
                }

                @Override
                public Float getRight() {
                    return Float.valueOf(f3);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final float[] fArray, final float[] fArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(fArray, fArray2)) {
            this.diffs.add(new Diff<Float[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Float[] getLeft() {
                    return ArrayUtils.toObject(fArray);
                }

                @Override
                public Float[] getRight() {
                    return ArrayUtils.toObject(fArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final int n2, final int n3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (n2 != n3) {
            this.diffs.add(new Diff<Integer>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Integer getLeft() {
                    return n2;
                }

                @Override
                public Integer getRight() {
                    return n3;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final int[] nArray, final int[] nArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(nArray, nArray2)) {
            this.diffs.add(new Diff<Integer[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Integer[] getLeft() {
                    return ArrayUtils.toObject(nArray);
                }

                @Override
                public Integer[] getRight() {
                    return ArrayUtils.toObject(nArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final long l2, final long l3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (l2 != l3) {
            this.diffs.add(new Diff<Long>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Long getLeft() {
                    return l2;
                }

                @Override
                public Long getRight() {
                    return l3;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final long[] lArray, final long[] lArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(lArray, lArray2)) {
            this.diffs.add(new Diff<Long[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Long[] getLeft() {
                    return ArrayUtils.toObject(lArray);
                }

                @Override
                public Long[] getRight() {
                    return ArrayUtils.toObject(lArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final short s2, final short s3) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (s2 != s3) {
            this.diffs.add(new Diff<Short>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Short getLeft() {
                    return s2;
                }

                @Override
                public Short getRight() {
                    return s3;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final short[] sArray, final short[] sArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(sArray, sArray2)) {
            this.diffs.add(new Diff<Short[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Short[] getLeft() {
                    return ArrayUtils.toObject(sArray);
                }

                @Override
                public Short[] getRight() {
                    return ArrayUtils.toObject(sArray2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, final Object object, final Object object2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (object == object2) {
            return this;
        }
        Object object3 = object != null ? object : object2;
        if (object3.getClass().isArray()) {
            if (object3 instanceof boolean[]) {
                return this.append(string, (boolean[])object, (boolean[])object2);
            }
            if (object3 instanceof byte[]) {
                return this.append(string, (byte[])object, (byte[])object2);
            }
            if (object3 instanceof char[]) {
                return this.append(string, (char[])object, (char[])object2);
            }
            if (object3 instanceof double[]) {
                return this.append(string, (double[])object, (double[])object2);
            }
            if (object3 instanceof float[]) {
                return this.append(string, (float[])object, (float[])object2);
            }
            if (object3 instanceof int[]) {
                return this.append(string, (int[])object, (int[])object2);
            }
            if (object3 instanceof long[]) {
                return this.append(string, (long[])object, (long[])object2);
            }
            if (object3 instanceof short[]) {
                return this.append(string, (short[])object, (short[])object2);
            }
            return this.append(string, (Object[])object, (Object[])object2);
        }
        if (object != null && object.equals(object2)) {
            return this;
        }
        this.diffs.add(new Diff<Object>(string){
            private static final long serialVersionUID = 1L;

            @Override
            public Object getLeft() {
                return object;
            }

            @Override
            public Object getRight() {
                return object2;
            }
        });
        return this;
    }

    public DiffBuilder<T> append(String string, final Object[] objectArray, final Object[] objectArray2) {
        this.validateFieldNameNotNull(string);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        if (!Arrays.equals(objectArray, objectArray2)) {
            this.diffs.add(new Diff<Object[]>(string){
                private static final long serialVersionUID = 1L;

                @Override
                public Object[] getLeft() {
                    return objectArray;
                }

                @Override
                public Object[] getRight() {
                    return objectArray2;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> append(String string, DiffResult<T> diffResult) {
        this.validateFieldNameNotNull(string);
        Validate.notNull(diffResult, "diffResult", new Object[0]);
        if (this.objectsTriviallyEqual) {
            return this;
        }
        for (Diff<?> diff : diffResult.getDiffs()) {
            this.append(string + "." + diff.getFieldName(), diff.getLeft(), diff.getRight());
        }
        return this;
    }

    @Override
    public DiffResult<T> build() {
        return new DiffResult<T>(this.left, this.right, this.diffs, this.style);
    }

    private void validateFieldNameNotNull(String string) {
        Validate.notNull(string, "fieldName", new Object[0]);
    }
}

