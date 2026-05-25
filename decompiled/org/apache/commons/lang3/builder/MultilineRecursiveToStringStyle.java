/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MultilineRecursiveToStringStyle
extends RecursiveToStringStyle {
    private static final long serialVersionUID = 1L;
    private static final int INDENT = 2;
    private int spaces = 2;

    public MultilineRecursiveToStringStyle() {
        this.resetIndent();
    }

    private void resetIndent() {
        this.setArrayStart("{" + System.lineSeparator() + this.spacer(this.spaces));
        this.setArraySeparator("," + System.lineSeparator() + this.spacer(this.spaces));
        this.setArrayEnd(System.lineSeparator() + this.spacer(this.spaces - 2) + "}");
        this.setContentStart("[" + System.lineSeparator() + this.spacer(this.spaces));
        this.setFieldSeparator("," + System.lineSeparator() + this.spacer(this.spaces));
        this.setContentEnd(System.lineSeparator() + this.spacer(this.spaces - 2) + "]");
    }

    private StringBuilder spacer(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    @Override
    public void appendDetail(StringBuffer stringBuffer, String string, Object object) {
        if (!ClassUtils.isPrimitiveWrapper(object.getClass()) && !String.class.equals(object.getClass()) && this.accept(object.getClass())) {
            this.spaces += 2;
            this.resetIndent();
            stringBuffer.append(ReflectionToStringBuilder.toString(object, this));
            this.spaces -= 2;
            this.resetIndent();
        } else {
            super.appendDetail(stringBuffer, string, object);
        }
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, Object[] objectArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, objectArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void reflectionAppendArrayDetail(StringBuffer stringBuffer, String string, Object object) {
        this.spaces += 2;
        this.resetIndent();
        super.reflectionAppendArrayDetail(stringBuffer, string, object);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, long[] lArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, lArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, int[] nArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, nArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, short[] sArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, sArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, byte[] byArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, byArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, char[] cArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, cArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, double[] dArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, dArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, float[] fArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, fArray);
        this.spaces -= 2;
        this.resetIndent();
    }

    @Override
    protected void appendDetail(StringBuffer stringBuffer, String string, boolean[] blArray) {
        this.spaces += 2;
        this.resetIndent();
        super.appendDetail(stringBuffer, string, blArray);
        this.spaces -= 2;
        this.resetIndent();
    }
}

