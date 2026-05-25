/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.math;

import java.math.BigInteger;
import org.apache.commons.lang3.Validate;

public final class Fraction
extends Number
implements Comparable<Fraction> {
    private static final long serialVersionUID = 65382027393090L;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    private final int numerator;
    private final int denominator;
    private transient int hashCode;
    private transient String toString;
    private transient String toProperString;

    private Fraction(int n2, int n3) {
        this.numerator = n2;
        this.denominator = n3;
    }

    public static Fraction getFraction(int n2, int n3) {
        if (n3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (n3 < 0) {
            if (n2 == Integer.MIN_VALUE || n3 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            n2 = -n2;
            n3 = -n3;
        }
        return new Fraction(n2, n3);
    }

    public static Fraction getFraction(int n2, int n3, int n4) {
        if (n4 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (n4 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        }
        if (n3 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        }
        long l2 = n2 < 0 ? (long)n2 * (long)n4 - (long)n3 : (long)n2 * (long)n4 + (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        }
        return new Fraction((int)l2, n4);
    }

    public static Fraction getReducedFraction(int n2, int n3) {
        if (n3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (n2 == 0) {
            return ZERO;
        }
        if (n3 == Integer.MIN_VALUE && (n2 & 1) == 0) {
            n2 /= 2;
            n3 /= 2;
        }
        if (n3 < 0) {
            if (n2 == Integer.MIN_VALUE || n3 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            n2 = -n2;
            n3 = -n3;
        }
        int n4 = Fraction.greatestCommonDivisor(n2, n3);
        return new Fraction(n2 /= n4, n3 /= n4);
    }

    public static Fraction getFraction(double d2) {
        double d3;
        int n2 = d2 < 0.0 ? -1 : 1;
        if ((d2 = Math.abs(d2)) > 2.147483647E9 || Double.isNaN(d2)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int n3 = (int)d2;
        d2 -= (double)n3;
        int n4 = 0;
        int n5 = 1;
        int n6 = 1;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = (int)d2;
        int n11 = 0;
        double d4 = 1.0;
        double d5 = 0.0;
        double d6 = d2 - (double)n10;
        double d7 = 0.0;
        double d8 = Double.MAX_VALUE;
        int n12 = 1;
        do {
            d3 = d8;
            n11 = (int)(d4 / d6);
            d5 = d6;
            d7 = d4 - (double)n11 * d6;
            n8 = n10 * n6 + n4;
            n9 = n10 * n7 + n5;
            double d9 = (double)n8 / (double)n9;
            d8 = Math.abs(d2 - d9);
            n10 = n11;
            d4 = d5;
            d6 = d7;
            n4 = n6;
            n5 = n7;
            n6 = n8;
            n7 = n9;
        } while (d3 > d8 && n9 <= 10000 && n9 > 0 && ++n12 < 25);
        if (n12 == 25) {
            throw new ArithmeticException("Unable to convert double to fraction");
        }
        return Fraction.getReducedFraction((n4 + n3 * n5) * n2, n5);
    }

    public static Fraction getFraction(String string) {
        Validate.notNull(string, "str", new Object[0]);
        int n2 = string.indexOf(46);
        if (n2 >= 0) {
            return Fraction.getFraction(Double.parseDouble(string));
        }
        n2 = string.indexOf(32);
        if (n2 > 0) {
            int n3 = Integer.parseInt(string.substring(0, n2));
            if ((n2 = (string = string.substring(n2 + 1)).indexOf(47)) < 0) {
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int n4 = Integer.parseInt(string.substring(0, n2));
            int n5 = Integer.parseInt(string.substring(n2 + 1));
            return Fraction.getFraction(n3, n4, n5);
        }
        n2 = string.indexOf(47);
        if (n2 < 0) {
            return Fraction.getFraction(Integer.parseInt(string), 1);
        }
        int n6 = Integer.parseInt(string.substring(0, n2));
        int n7 = Integer.parseInt(string.substring(n2 + 1));
        return Fraction.getFraction(n6, n7);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    @Override
    public int intValue() {
        return this.numerator / this.denominator;
    }

    @Override
    public long longValue() {
        return (long)this.numerator / (long)this.denominator;
    }

    @Override
    public float floatValue() {
        return (float)this.numerator / (float)this.denominator;
    }

    @Override
    public double doubleValue() {
        return (double)this.numerator / (double)this.denominator;
    }

    public Fraction reduce() {
        if (this.numerator == 0) {
            return this.equals(ZERO) ? this : ZERO;
        }
        int n2 = Fraction.greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
        if (n2 == 1) {
            return this;
        }
        return Fraction.getFraction(this.numerator / n2, this.denominator / n2);
    }

    public Fraction invert() {
        if (this.numerator == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        }
        if (this.numerator == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        }
        if (this.numerator < 0) {
            return new Fraction(-this.denominator, -this.numerator);
        }
        return new Fraction(this.denominator, this.numerator);
    }

    public Fraction negate() {
        if (this.numerator == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: too large to negate");
        }
        return new Fraction(-this.numerator, this.denominator);
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return this.negate();
    }

    public Fraction pow(int n2) {
        if (n2 == 1) {
            return this;
        }
        if (n2 == 0) {
            return ONE;
        }
        if (n2 < 0) {
            if (n2 == Integer.MIN_VALUE) {
                return this.invert().pow(2).pow(-(n2 / 2));
            }
            return this.invert().pow(-n2);
        }
        Fraction fraction = this.multiplyBy(this);
        if (n2 % 2 == 0) {
            return fraction.pow(n2 / 2);
        }
        return fraction.pow(n2 / 2).multiplyBy(this);
    }

    private static int greatestCommonDivisor(int n2, int n3) {
        int n4;
        int n5;
        if (n2 == 0 || n3 == 0) {
            if (n2 == Integer.MIN_VALUE || n3 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: gcd is 2^31");
            }
            return Math.abs(n2) + Math.abs(n3);
        }
        if (Math.abs(n2) == 1 || Math.abs(n3) == 1) {
            return 1;
        }
        if (n2 > 0) {
            n2 = -n2;
        }
        if (n3 > 0) {
            n3 = -n3;
        }
        for (n5 = 0; (n2 & 1) == 0 && (n3 & 1) == 0 && n5 < 31; ++n5) {
            n2 /= 2;
            n3 /= 2;
        }
        if (n5 == 31) {
            throw new ArithmeticException("overflow: gcd is 2^31");
        }
        int n6 = n4 = (n2 & 1) == 1 ? n3 : -(n2 / 2);
        while (true) {
            if ((n4 & 1) == 0) {
                n4 /= 2;
                continue;
            }
            if (n4 > 0) {
                n2 = -n4;
            } else {
                n3 = n4;
            }
            if ((n4 = (n3 - n2) / 2) == 0) break;
        }
        return -n2 * (1 << n5);
    }

    private static int mulAndCheck(int n2, int n3) {
        long l2 = (long)n2 * (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("overflow: mul");
        }
        return (int)l2;
    }

    private static int mulPosAndCheck(int n2, int n3) {
        long l2 = (long)n2 * (long)n3;
        if (l2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("overflow: mulPos");
        }
        return (int)l2;
    }

    private static int addAndCheck(int n2, int n3) {
        long l2 = (long)n2 + (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("overflow: add");
        }
        return (int)l2;
    }

    private static int subAndCheck(int n2, int n3) {
        long l2 = (long)n2 - (long)n3;
        if (l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("overflow: add");
        }
        return (int)l2;
    }

    public Fraction add(Fraction fraction) {
        return this.addSub(fraction, true);
    }

    public Fraction subtract(Fraction fraction) {
        return this.addSub(fraction, false);
    }

    private Fraction addSub(Fraction fraction, boolean bl2) {
        int n2;
        int n3;
        Validate.notNull(fraction, "fraction", new Object[0]);
        if (this.numerator == 0) {
            return bl2 ? fraction : fraction.negate();
        }
        if (fraction.numerator == 0) {
            return this;
        }
        int n4 = Fraction.greatestCommonDivisor(this.denominator, fraction.denominator);
        if (n4 == 1) {
            int n5 = Fraction.mulAndCheck(this.numerator, fraction.denominator);
            int n6 = Fraction.mulAndCheck(fraction.numerator, this.denominator);
            return new Fraction(bl2 ? Fraction.addAndCheck(n5, n6) : Fraction.subAndCheck(n5, n6), Fraction.mulPosAndCheck(this.denominator, fraction.denominator));
        }
        BigInteger bigInteger = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / n4));
        BigInteger bigInteger2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / n4));
        BigInteger bigInteger3 = bl2 ? bigInteger.add(bigInteger2) : bigInteger.subtract(bigInteger2);
        BigInteger bigInteger4 = bigInteger3.divide(BigInteger.valueOf(n3 = (n2 = bigInteger3.mod(BigInteger.valueOf(n4)).intValue()) == 0 ? n4 : Fraction.greatestCommonDivisor(n2, n4)));
        if (bigInteger4.bitLength() > 31) {
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
        return new Fraction(bigInteger4.intValue(), Fraction.mulPosAndCheck(this.denominator / n4, fraction.denominator / n3));
    }

    public Fraction multiplyBy(Fraction fraction) {
        Validate.notNull(fraction, "fraction", new Object[0]);
        if (this.numerator == 0 || fraction.numerator == 0) {
            return ZERO;
        }
        int n2 = Fraction.greatestCommonDivisor(this.numerator, fraction.denominator);
        int n3 = Fraction.greatestCommonDivisor(fraction.numerator, this.denominator);
        return Fraction.getReducedFraction(Fraction.mulAndCheck(this.numerator / n2, fraction.numerator / n3), Fraction.mulPosAndCheck(this.denominator / n3, fraction.denominator / n2));
    }

    public Fraction divideBy(Fraction fraction) {
        Validate.notNull(fraction, "fraction", new Object[0]);
        if (fraction.numerator == 0) {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        }
        return this.multiplyBy(fraction.invert());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction)object;
        return this.getNumerator() == fraction.getNumerator() && this.getDenominator() == fraction.getDenominator();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 37 * (629 + this.getNumerator()) + this.getDenominator();
        }
        return this.hashCode;
    }

    @Override
    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        if (this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
            return 0;
        }
        long l2 = (long)this.numerator * (long)fraction.denominator;
        long l3 = (long)fraction.numerator * (long)this.denominator;
        return Long.compare(l2, l3);
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = this.getNumerator() + "/" + this.getDenominator();
        }
        return this.toString;
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int n2;
            this.toProperString = this.numerator == 0 ? "0" : (this.numerator == this.denominator ? "1" : (this.numerator == -1 * this.denominator ? "-1" : ((this.numerator > 0 ? -this.numerator : this.numerator) < -this.denominator ? ((n2 = this.getProperNumerator()) == 0 ? Integer.toString(this.getProperWhole()) : this.getProperWhole() + " " + n2 + "/" + this.getDenominator()) : this.getNumerator() + "/" + this.getDenominator())));
        }
        return this.toProperString;
    }
}

