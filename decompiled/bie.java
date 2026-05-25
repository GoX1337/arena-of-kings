/*
 * Decompiled with CFR 0.152.
 */
public class bie {
    protected final bgg[] a;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        int n2 = this.a.length;
        if (n2 > 0) {
            stringBuilder.append(this.a[0].bcw_b().java_lang_String_a());
            for (int i2 = 1; i2 < n2; ++i2) {
                stringBuilder.append(", ");
                stringBuilder.append(this.a[i2].bcw_b().java_lang_String_a());
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

