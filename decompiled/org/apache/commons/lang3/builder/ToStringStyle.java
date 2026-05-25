/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.builder;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class ToStringStyle
implements Serializable {
    private static final long serialVersionUID = -2587890625525655916L;
    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
    public static final ToStringStyle NO_CLASS_NAME_STYLE = new NoClassNameToStringStyle();
    public static final ToStringStyle JSON_STYLE = new JsonToStringStyle();
    private static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY = new ThreadLocal();
    private boolean useFieldNames = true;
    private boolean useClassName = true;
    private boolean useShortClassName;
    private boolean useIdentityHashCode = true;
    private String contentStart = "[";
    private String contentEnd = "]";
    private String fieldNameValueSeparator = "=";
    private boolean fieldSeparatorAtStart;
    private boolean fieldSeparatorAtEnd;
    private String fieldSeparator = ",";
    private String arrayStart = "{";
    private String arraySeparator = ",";
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private boolean defaultFullDetail = true;
    private String nullText = "<null>";
    private String sizeStartText = "<size=";
    private String sizeEndText = ">";
    private String summaryObjectStartText = "<";
    private String summaryObjectEndText = ">";

    static Map<Object, Object> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object object) {
        Map<Object, Object> map = ToStringStyle.getRegistry();
        return map != null && map.containsKey(object);
    }

    static void register(Object object) {
        if (object != null) {
            Map<Object, Object> map = ToStringStyle.getRegistry();
            if (map == null) {
                REGISTRY.set(new WeakHashMap());
            }
            ToStringStyle.getRegistry().put(object, null);
        }
    }

    static void unregister(Object object) {
        Map<Object, Object> map;
        if (object != null && (map = ToStringStyle.getRegistry()) != null) {
            map.remove(object);
            if (map.isEmpty()) {
                REGISTRY.remove();
            }
        }
    }

    public void appendSuper(StringBuffer stringBuffer, String string) {
        this.appendToString(stringBuffer, string);
    }

    public void appendToString(StringBuffer stringBuffer, String string) {
        int n2;
        int n3;
        if (string != null && (n3 = string.indexOf(this.contentStart) + this.contentStart.length()) != (n2 = string.lastIndexOf(this.contentEnd)) && n3 >= 0 && n2 >= 0) {
            if (this.fieldSeparatorAtStart) {
                this.removeLastFieldSeparator(stringBuffer);
            }
            stringBuffer.append(string, n3, n2);
            this.appendFieldSeparator(stringBuffer);
        }
    }

    public void appendStart(StringBuffer stringBuffer, Object object) {
        if (object != null) {
            this.appendClassName(stringBuffer, object);
            this.appendIdentityHashCode(stringBuffer, object);
            this.appendContentStart(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                this.appendFieldSeparator(stringBuffer);
            }
        }
    }

    public void appendEnd(StringBuffer stringBuffer, Object object) {
        if (!this.fieldSeparatorAtEnd) {
            this.removeLastFieldSeparator(stringBuffer);
        }
        this.appendContentEnd(stringBuffer);
        ToStringStyle.unregister(object);
    }

    protected void removeLastFieldSeparator(StringBuffer stringBuffer) {
        if (StringUtils.endsWith(stringBuffer, this.fieldSeparator)) {
            stringBuffer.setLength(stringBuffer.length() - this.fieldSeparator.length());
        }
    }

    public void append(StringBuffer stringBuffer, String string, Object object, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (object == null) {
            this.appendNullText(stringBuffer, string);
        } else {
            this.appendInternal(stringBuffer, string, object, this.isFullDetail(bl2));
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void appendInternal(StringBuffer stringBuffer, String string, Object object, boolean bl2) {
        if (ToStringStyle.isRegistered(object) && !(object instanceof Number) && !(object instanceof Boolean) && !(object instanceof Character)) {
            this.appendCyclicObject(stringBuffer, string, object);
            return;
        }
        ToStringStyle.register(object);
        try {
            if (object instanceof Collection) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (Collection)object);
                } else {
                    this.appendSummarySize(stringBuffer, string, ((Collection)object).size());
                }
            } else if (object instanceof Map) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (Map)object);
                } else {
                    this.appendSummarySize(stringBuffer, string, ((Map)object).size());
                }
            } else if (object instanceof long[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (long[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (long[])object);
                }
            } else if (object instanceof int[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (int[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (int[])object);
                }
            } else if (object instanceof short[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (short[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (short[])object);
                }
            } else if (object instanceof byte[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (byte[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (byte[])object);
                }
            } else if (object instanceof char[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (char[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (char[])object);
                }
            } else if (object instanceof double[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (double[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (double[])object);
                }
            } else if (object instanceof float[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (float[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (float[])object);
                }
            } else if (object instanceof boolean[]) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (boolean[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (boolean[])object);
                }
            } else if (object.getClass().isArray()) {
                if (bl2) {
                    this.appendDetail(stringBuffer, string, (Object[])object);
                } else {
                    this.appendSummary(stringBuffer, string, (Object[])object);
                }
            } else if (bl2) {
                this.appendDetail(stringBuffer, string, object);
            } else {
                this.appendSummary(stringBuffer, string, object);
            }
        }
        finally {
            ToStringStyle.unregister(object);
        }
    }

    protected void appendCyclicObject(StringBuffer stringBuffer, String string, Object object) {
        ObjectUtils.identityToString(stringBuffer, object);
    }

    public void appendDetail(StringBuffer stringBuffer, String string, Object object) {
        stringBuffer.append(object);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, Object object) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(this.getShortClassName(object.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    public void append(StringBuffer stringBuffer, String string, long l2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, l2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, long l2) {
        stringBuffer.append(l2);
    }

    public void append(StringBuffer stringBuffer, String string, int n2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, n2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, int n2) {
        stringBuffer.append(n2);
    }

    public void append(StringBuffer stringBuffer, String string, short s2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, s2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, short s2) {
        stringBuffer.append(s2);
    }

    public void append(StringBuffer stringBuffer, String string, byte by2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, by2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, byte by2) {
        stringBuffer.append(by2);
    }

    public void append(StringBuffer stringBuffer, String string, char c2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, c2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, char c2) {
        stringBuffer.append(c2);
    }

    public void append(StringBuffer stringBuffer, String string, double d2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, d2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, double d2) {
        stringBuffer.append(d2);
    }

    public void append(StringBuffer stringBuffer, String string, float f2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, f2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, float f2) {
        stringBuffer.append(f2);
    }

    public void append(StringBuffer stringBuffer, String string, boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        this.appendDetail(stringBuffer, string, bl2);
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, boolean bl2) {
        stringBuffer.append(bl2);
    }

    public void append(StringBuffer stringBuffer, String string, Object[] objectArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (objectArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, objectArray);
        } else {
            this.appendSummary(stringBuffer, string, objectArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, Object[] objectArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            this.appendDetail(stringBuffer, string, i2, object);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, int n2, Object object) {
        if (n2 > 0) {
            stringBuffer.append(this.arraySeparator);
        }
        if (object == null) {
            this.appendNullText(stringBuffer, string);
        } else {
            this.appendInternal(stringBuffer, string, object, this.arrayContentDetail);
        }
    }

    protected void reflectionAppendArrayDetail(StringBuffer stringBuffer, String string, Object object) {
        stringBuffer.append(this.arrayStart);
        int n2 = Array.getLength(object);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = Array.get(object, i2);
            this.appendDetail(stringBuffer, string, i2, object2);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, Object[] objectArray) {
        this.appendSummarySize(stringBuffer, string, objectArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, long[] lArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (lArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, lArray);
        } else {
            this.appendSummary(stringBuffer, string, lArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, long[] lArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, lArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, long[] lArray) {
        this.appendSummarySize(stringBuffer, string, lArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, int[] nArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (nArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, nArray);
        } else {
            this.appendSummary(stringBuffer, string, nArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, int[] nArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, nArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, int[] nArray) {
        this.appendSummarySize(stringBuffer, string, nArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, short[] sArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (sArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, sArray);
        } else {
            this.appendSummary(stringBuffer, string, sArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, short[] sArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, sArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, short[] sArray) {
        this.appendSummarySize(stringBuffer, string, sArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, byte[] byArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (byArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, byArray);
        } else {
            this.appendSummary(stringBuffer, string, byArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, byte[] byArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, byArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, byte[] byArray) {
        this.appendSummarySize(stringBuffer, string, byArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, char[] cArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (cArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, cArray);
        } else {
            this.appendSummary(stringBuffer, string, cArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, char[] cArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, cArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, char[] cArray) {
        this.appendSummarySize(stringBuffer, string, cArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, double[] dArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (dArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, dArray);
        } else {
            this.appendSummary(stringBuffer, string, dArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, double[] dArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, dArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, double[] dArray) {
        this.appendSummarySize(stringBuffer, string, dArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, float[] fArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (fArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, fArray);
        } else {
            this.appendSummary(stringBuffer, string, fArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, float[] fArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, fArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, float[] fArray) {
        this.appendSummarySize(stringBuffer, string, fArray.length);
    }

    public void append(StringBuffer stringBuffer, String string, boolean[] blArray, Boolean bl2) {
        this.appendFieldStart(stringBuffer, string);
        if (blArray == null) {
            this.appendNullText(stringBuffer, string);
        } else if (this.isFullDetail(bl2)) {
            this.appendDetail(stringBuffer, string, blArray);
        } else {
            this.appendSummary(stringBuffer, string, blArray);
        }
        this.appendFieldEnd(stringBuffer, string);
    }

    protected void appendDetail(StringBuffer stringBuffer, String string, boolean[] blArray) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            this.appendDetail(stringBuffer, string, blArray[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String string, boolean[] blArray) {
        this.appendSummarySize(stringBuffer, string, blArray.length);
    }

    protected void appendClassName(StringBuffer stringBuffer, Object object) {
        if (this.useClassName && object != null) {
            ToStringStyle.register(object);
            if (this.useShortClassName) {
                stringBuffer.append(this.getShortClassName(object.getClass()));
            } else {
                stringBuffer.append(object.getClass().getName());
            }
        }
    }

    protected void appendIdentityHashCode(StringBuffer stringBuffer, Object object) {
        if (this.isUseIdentityHashCode() && object != null) {
            ToStringStyle.register(object);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(object)));
        }
    }

    protected void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    protected void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    protected void appendNullText(StringBuffer stringBuffer, String string) {
        stringBuffer.append(this.nullText);
    }

    protected void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    protected void appendFieldStart(StringBuffer stringBuffer, String string) {
        if (this.useFieldNames && string != null) {
            stringBuffer.append(string);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    protected void appendFieldEnd(StringBuffer stringBuffer, String string) {
        this.appendFieldSeparator(stringBuffer);
    }

    protected void appendSummarySize(StringBuffer stringBuffer, String string, int n2) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(n2);
        stringBuffer.append(this.sizeEndText);
    }

    protected boolean isFullDetail(Boolean bl2) {
        if (bl2 == null) {
            return this.defaultFullDetail;
        }
        return bl2;
    }

    protected String getShortClassName(Class<?> clazz) {
        return ClassUtils.getShortClassName(clazz);
    }

    protected boolean isUseClassName() {
        return this.useClassName;
    }

    protected void setUseClassName(boolean bl2) {
        this.useClassName = bl2;
    }

    protected boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    protected void setUseShortClassName(boolean bl2) {
        this.useShortClassName = bl2;
    }

    protected boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    protected void setUseIdentityHashCode(boolean bl2) {
        this.useIdentityHashCode = bl2;
    }

    protected boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    protected void setUseFieldNames(boolean bl2) {
        this.useFieldNames = bl2;
    }

    protected boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    protected void setDefaultFullDetail(boolean bl2) {
        this.defaultFullDetail = bl2;
    }

    protected boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    protected void setArrayContentDetail(boolean bl2) {
        this.arrayContentDetail = bl2;
    }

    protected String getArrayStart() {
        return this.arrayStart;
    }

    protected void setArrayStart(String string) {
        if (string == null) {
            string = "";
        }
        this.arrayStart = string;
    }

    protected String getArrayEnd() {
        return this.arrayEnd;
    }

    protected void setArrayEnd(String string) {
        if (string == null) {
            string = "";
        }
        this.arrayEnd = string;
    }

    protected String getArraySeparator() {
        return this.arraySeparator;
    }

    protected void setArraySeparator(String string) {
        if (string == null) {
            string = "";
        }
        this.arraySeparator = string;
    }

    protected String getContentStart() {
        return this.contentStart;
    }

    protected void setContentStart(String string) {
        if (string == null) {
            string = "";
        }
        this.contentStart = string;
    }

    protected String getContentEnd() {
        return this.contentEnd;
    }

    protected void setContentEnd(String string) {
        if (string == null) {
            string = "";
        }
        this.contentEnd = string;
    }

    protected String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    protected void setFieldNameValueSeparator(String string) {
        if (string == null) {
            string = "";
        }
        this.fieldNameValueSeparator = string;
    }

    protected String getFieldSeparator() {
        return this.fieldSeparator;
    }

    protected void setFieldSeparator(String string) {
        if (string == null) {
            string = "";
        }
        this.fieldSeparator = string;
    }

    protected boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    protected void setFieldSeparatorAtStart(boolean bl2) {
        this.fieldSeparatorAtStart = bl2;
    }

    protected boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    protected void setFieldSeparatorAtEnd(boolean bl2) {
        this.fieldSeparatorAtEnd = bl2;
    }

    protected String getNullText() {
        return this.nullText;
    }

    protected void setNullText(String string) {
        if (string == null) {
            string = "";
        }
        this.nullText = string;
    }

    protected String getSizeStartText() {
        return this.sizeStartText;
    }

    protected void setSizeStartText(String string) {
        if (string == null) {
            string = "";
        }
        this.sizeStartText = string;
    }

    protected String getSizeEndText() {
        return this.sizeEndText;
    }

    protected void setSizeEndText(String string) {
        if (string == null) {
            string = "";
        }
        this.sizeEndText = string;
    }

    protected String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    protected void setSummaryObjectStartText(String string) {
        if (string == null) {
            string = "";
        }
        this.summaryObjectStartText = string;
    }

    protected String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    protected void setSummaryObjectEndText(String string) {
        if (string == null) {
            string = "";
        }
        this.summaryObjectEndText = string;
    }

    static final class JsonToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;
        private static final String FIELD_NAME_QUOTE = "\"";

        JsonToStringStyle() {
            this.setUseClassName(false);
            this.setUseIdentityHashCode(false);
            this.setContentStart("{");
            this.setContentEnd("}");
            this.setArrayStart("[");
            this.setArrayEnd("]");
            this.setFieldSeparator(",");
            this.setFieldNameValueSeparator(":");
            this.setNullText("null");
            this.setSummaryObjectStartText("\"<");
            this.setSummaryObjectEndText(">\"");
            this.setSizeStartText("\"<size=");
            this.setSizeEndText(">\"");
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, Object[] objectArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, objectArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, long[] lArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, lArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, int[] nArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, nArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, short[] sArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, sArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, byte[] byArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, byArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, char[] cArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, cArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, double[] dArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, dArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, float[] fArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, fArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, boolean[] blArray, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, blArray, bl2);
        }

        @Override
        public void append(StringBuffer stringBuffer, String string, Object object, Boolean bl2) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!this.isFullDetail(bl2)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, string, object, bl2);
        }

        @Override
        protected void appendDetail(StringBuffer stringBuffer, String string, char c2) {
            this.appendValueAsString(stringBuffer, String.valueOf(c2));
        }

        @Override
        protected void appendDetail(StringBuffer stringBuffer, String string, Object object) {
            if (object == null) {
                this.appendNullText(stringBuffer, string);
                return;
            }
            if (object instanceof String || object instanceof Character) {
                this.appendValueAsString(stringBuffer, object.toString());
                return;
            }
            if (object instanceof Number || object instanceof Boolean) {
                stringBuffer.append(object);
                return;
            }
            String string2 = object.toString();
            if (this.isJsonObject(string2) || this.isJsonArray(string2)) {
                stringBuffer.append(object);
                return;
            }
            this.appendDetail(stringBuffer, string, string2);
        }

        @Override
        protected void appendDetail(StringBuffer stringBuffer, String string, Collection<?> collection) {
            if (collection != null && !collection.isEmpty()) {
                stringBuffer.append(this.getArrayStart());
                int n2 = 0;
                for (Object obj : collection) {
                    this.appendDetail(stringBuffer, string, n2++, obj);
                }
                stringBuffer.append(this.getArrayEnd());
                return;
            }
            stringBuffer.append(collection);
        }

        @Override
        protected void appendDetail(StringBuffer stringBuffer, String string, Map<?, ?> map) {
            if (map != null && !map.isEmpty()) {
                stringBuffer.append(this.getContentStart());
                boolean bl2 = true;
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    String string2 = Objects.toString(entry.getKey(), null);
                    if (string2 == null) continue;
                    if (bl2) {
                        bl2 = false;
                    } else {
                        this.appendFieldEnd(stringBuffer, string2);
                    }
                    this.appendFieldStart(stringBuffer, string2);
                    Object obj = entry.getValue();
                    if (obj == null) {
                        this.appendNullText(stringBuffer, string2);
                        continue;
                    }
                    this.appendInternal(stringBuffer, string2, obj, true);
                }
                stringBuffer.append(this.getContentEnd());
                return;
            }
            stringBuffer.append(map);
        }

        private boolean isJsonArray(String string) {
            return string.startsWith(this.getArrayStart()) && string.endsWith(this.getArrayEnd());
        }

        private boolean isJsonObject(String string) {
            return string.startsWith(this.getContentStart()) && string.endsWith(this.getContentEnd());
        }

        private void appendValueAsString(StringBuffer stringBuffer, String string) {
            stringBuffer.append('\"').append(StringEscapeUtils.escapeJson(string)).append('\"');
        }

        @Override
        protected void appendFieldStart(StringBuffer stringBuffer, String string) {
            if (string == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.appendFieldStart(stringBuffer, FIELD_NAME_QUOTE + StringEscapeUtils.escapeJson(string) + FIELD_NAME_QUOTE);
        }

        private Object readResolve() {
            return JSON_STYLE;
        }
    }

    static final class NoClassNameToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;

        NoClassNameToStringStyle() {
            this.setUseClassName(false);
            this.setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return NO_CLASS_NAME_STYLE;
        }
    }

    static final class MultiLineToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;

        MultiLineToStringStyle() {
            this.setContentStart("[");
            this.setFieldSeparator(System.lineSeparator() + "  ");
            this.setFieldSeparatorAtStart(true);
            this.setContentEnd(System.lineSeparator() + "]");
        }

        private Object readResolve() {
            return MULTI_LINE_STYLE;
        }
    }

    static final class SimpleToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;

        SimpleToStringStyle() {
            this.setUseClassName(false);
            this.setUseIdentityHashCode(false);
            this.setUseFieldNames(false);
            this.setContentStart("");
            this.setContentEnd("");
        }

        private Object readResolve() {
            return SIMPLE_STYLE;
        }
    }

    static final class ShortPrefixToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;

        ShortPrefixToStringStyle() {
            this.setUseShortClassName(true);
            this.setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return SHORT_PREFIX_STYLE;
        }
    }

    static final class NoFieldNameToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;

        NoFieldNameToStringStyle() {
            this.setUseFieldNames(false);
        }

        private Object readResolve() {
            return NO_FIELD_NAMES_STYLE;
        }
    }

    static final class DefaultToStringStyle
    extends ToStringStyle {
        private static final long serialVersionUID = 1L;

        DefaultToStringStyle() {
        }

        private Object readResolve() {
            return DEFAULT_STYLE;
        }
    }
}

