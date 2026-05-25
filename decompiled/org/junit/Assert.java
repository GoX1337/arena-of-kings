/*
 * Decompiled with CFR 0.152.
 */
package org.junit;

import java.lang.reflect.Array;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.ComparisonFailure;
import org.junit.internal.ArrayComparisonFailure;
import org.junit.internal.InexactComparisonCriteria;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Assert {
    protected Assert() {
    }

    public static void assertTrue(String string, boolean bl2) {
        if (!bl2) {
            Assert.fail(string);
        }
    }

    public static void assertTrue(boolean bl2) {
        Assert.assertTrue(null, bl2);
    }

    public static void assertFalse(String string, boolean bl2) {
        Assert.assertTrue(string, !bl2);
    }

    public static void assertFalse(boolean bl2) {
        Assert.assertFalse(null, bl2);
    }

    public static void fail(String string) {
        throw new AssertionError((Object)(string == null ? "" : string));
    }

    public static void fail() {
        Assert.fail(null);
    }

    public static void assertEquals(String string, Object object, Object object2) {
        if (object == null && object2 == null) {
            return;
        }
        if (object != null && Assert.isEquals(object, object2)) {
            return;
        }
        if (object instanceof String && object2 instanceof String) {
            String string2 = string == null ? "" : string;
            throw new ComparisonFailure(string2, (String)object, (String)object2);
        }
        Assert.failNotEquals(string, object, object2);
    }

    private static boolean isEquals(Object object, Object object2) {
        return object.equals(object2);
    }

    public static void assertEquals(Object object, Object object2) {
        Assert.assertEquals(null, object, object2);
    }

    public static void assertArrayEquals(String string, Object[] objectArray, Object[] objectArray2) {
        Assert.internalArrayEquals(string, objectArray, objectArray2);
    }

    public static void assertArrayEquals(Object[] objectArray, Object[] objectArray2) {
        Assert.assertArrayEquals(null, objectArray, objectArray2);
    }

    public static void assertArrayEquals(String string, byte[] byArray, byte[] byArray2) {
        Assert.internalArrayEquals(string, byArray, byArray2);
    }

    public static void assertArrayEquals(byte[] byArray, byte[] byArray2) {
        Assert.assertArrayEquals(null, byArray, byArray2);
    }

    public static void assertArrayEquals(String string, char[] cArray, char[] cArray2) {
        Assert.internalArrayEquals(string, cArray, cArray2);
    }

    public static void assertArrayEquals(char[] cArray, char[] cArray2) {
        Assert.assertArrayEquals(null, cArray, cArray2);
    }

    public static void assertArrayEquals(String string, short[] sArray, short[] sArray2) {
        Assert.internalArrayEquals(string, sArray, sArray2);
    }

    public static void assertArrayEquals(short[] sArray, short[] sArray2) {
        Assert.assertArrayEquals(null, sArray, sArray2);
    }

    public static void assertArrayEquals(String string, int[] nArray, int[] nArray2) {
        Assert.internalArrayEquals(string, nArray, nArray2);
    }

    public static void assertArrayEquals(int[] nArray, int[] nArray2) {
        Assert.assertArrayEquals(null, nArray, nArray2);
    }

    public static void assertArrayEquals(String string, long[] lArray, long[] lArray2) {
        Assert.internalArrayEquals(string, lArray, lArray2);
    }

    public static void assertArrayEquals(long[] lArray, long[] lArray2) {
        Assert.assertArrayEquals(null, lArray, lArray2);
    }

    public static void assertArrayEquals(String string, double[] dArray, double[] dArray2, double d2) {
        new InexactComparisonCriteria(d2).internalArrayEquals(string, dArray, dArray2);
    }

    public static void assertArrayEquals(double[] dArray, double[] dArray2, double d2) {
        Assert.assertArrayEquals(null, dArray, dArray2, d2);
    }

    public static void assertArrayEquals(String string, float[] fArray, float[] fArray2, float f2) {
        new InexactComparisonCriteria(f2).internalArrayEquals(string, fArray, fArray2);
    }

    public static void assertArrayEquals(float[] fArray, float[] fArray2, float f2) {
        Assert.assertArrayEquals(null, fArray, fArray2, f2);
    }

    private static void internalArrayEquals(String string, Object object, Object object2) {
        if (object == object2) {
            return;
        }
        String string2 = string == null ? "" : string + ": ";
        int n2 = Assert.assertArraysAreSameLength(object, object2, string2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object3 = Array.get(object, i2);
            Object object4 = Array.get(object2, i2);
            if (Assert.isArray(object3) && Assert.isArray(object4)) {
                try {
                    Assert.internalArrayEquals(string, object3, object4);
                    continue;
                }
                catch (ArrayComparisonFailure arrayComparisonFailure) {
                    arrayComparisonFailure.addDimension(i2);
                    throw arrayComparisonFailure;
                }
            }
            try {
                Assert.assertEquals(object3, object4);
                continue;
            }
            catch (AssertionError assertionError) {
                throw new ArrayComparisonFailure(string2, assertionError, i2);
            }
        }
    }

    public static int assertArraysAreSameLength(Object object, Object object2, String string) {
        int n2;
        int n3;
        if (object == null) {
            Assert.fail(string + "expected array was null");
        }
        if (object2 == null) {
            Assert.fail(string + "actual array was null");
        }
        if ((n3 = Array.getLength(object2)) != (n2 = Array.getLength(object))) {
            Assert.fail(string + "array lengths differed, expected.length=" + n2 + " actual.length=" + n3);
        }
        return n2;
    }

    public static boolean isArray(Object object) {
        return object != null && object.getClass().isArray();
    }

    public static void assertEquals(String string, double d2, double d3, double d4) {
        if (Double.compare(d2, d3) == 0) {
            return;
        }
        if (!(Math.abs(d2 - d3) <= d4)) {
            Assert.failNotEquals(string, new Double(d2), new Double(d3));
        }
    }

    public static void assertEquals(long l2, long l3) {
        Assert.assertEquals(null, l2, l3);
    }

    public static void assertEquals(String string, long l2, long l3) {
        Assert.assertEquals(string, (Object)l2, (Object)l3);
    }

    @Deprecated
    public static void assertEquals(double d2, double d3) {
        Assert.assertEquals(null, d2, d3);
    }

    @Deprecated
    public static void assertEquals(String string, double d2, double d3) {
        Assert.fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertEquals(double d2, double d3, double d4) {
        Assert.assertEquals(null, d2, d3, d4);
    }

    public static void assertNotNull(String string, Object object) {
        Assert.assertTrue(string, object != null);
    }

    public static void assertNotNull(Object object) {
        Assert.assertNotNull(null, object);
    }

    public static void assertNull(String string, Object object) {
        Assert.assertTrue(string, object == null);
    }

    public static void assertNull(Object object) {
        Assert.assertNull(null, object);
    }

    public static void assertSame(String string, Object object, Object object2) {
        if (object == object2) {
            return;
        }
        Assert.failNotSame(string, object, object2);
    }

    public static void assertSame(Object object, Object object2) {
        Assert.assertSame(null, object, object2);
    }

    public static void assertNotSame(String string, Object object, Object object2) {
        if (object == object2) {
            Assert.failSame(string);
        }
    }

    public static void assertNotSame(Object object, Object object2) {
        Assert.assertNotSame(null, object, object2);
    }

    private static void failSame(String string) {
        String string2 = "";
        if (string != null) {
            string2 = string + " ";
        }
        Assert.fail(string2 + "expected not same");
    }

    private static void failNotSame(String string, Object object, Object object2) {
        String string2 = "";
        if (string != null) {
            string2 = string + " ";
        }
        Assert.fail(string2 + "expected same:<" + object + "> was not:<" + object2 + ">");
    }

    private static void failNotEquals(String string, Object object, Object object2) {
        Assert.fail(Assert.format(string, object, object2));
    }

    static String format(String string, Object object, Object object2) {
        String string2;
        String string3;
        String string4 = "";
        if (string != null && !string.equals("")) {
            string4 = string + " ";
        }
        if ((string3 = String.valueOf(object)).equals(string2 = String.valueOf(object2))) {
            return string4 + "expected: " + Assert.formatClassAndValue(object, string3) + " but was: " + Assert.formatClassAndValue(object2, string2);
        }
        return string4 + "expected:<" + string3 + "> but was:<" + string2 + ">";
    }

    private static String formatClassAndValue(Object object, String string) {
        String string2 = object == null ? "null" : object.getClass().getName();
        return string2 + "<" + string + ">";
    }

    @Deprecated
    public static void assertEquals(String string, Object[] objectArray, Object[] objectArray2) {
        Assert.assertArrayEquals(string, objectArray, objectArray2);
    }

    @Deprecated
    public static void assertEquals(Object[] objectArray, Object[] objectArray2) {
        Assert.assertArrayEquals(objectArray, objectArray2);
    }

    public static <T> void assertThat(T t2, Matcher<T> matcher) {
        Assert.assertThat("", t2, matcher);
    }

    public static <T> void assertThat(String string, T t2, Matcher<T> matcher) {
        if (!matcher.matches(t2)) {
            StringDescription stringDescription = new StringDescription();
            stringDescription.appendText(string);
            stringDescription.appendText("\nExpected: ");
            matcher.describeTo(stringDescription);
            stringDescription.appendText("\n     got: ").appendValue(t2).appendText("\n");
            throw new AssertionError((Object)((Object)stringDescription).toString());
        }
    }
}

