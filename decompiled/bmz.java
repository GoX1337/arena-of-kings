/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

class bmz {
    protected static final bmu[] var_bmu_arr_a;
    protected static final Annotation[] var_java_lang_annotation_Annotation_arr_a;
    protected final bfn var_bfn_a;

    protected bmz(bfn bfn2) {
        this.var_bfn_a = bfn2;
    }

    protected final bmt a(Annotation[] annotationArray) {
        bmt bmt2 = bmt.bmt_a();
        for (Annotation annotation : annotationArray) {
            bmt2 = bmt2.bmt_a(annotation);
            if (!this.var_bfn_a.a(annotation)) continue;
            bmt2 = this.a(bmt2, annotation);
        }
        return bmt2;
    }

    protected final bmt a(bmt bmt2, Annotation[] annotationArray) {
        for (Annotation annotation : annotationArray) {
            bmt2 = bmt2.bmt_a(annotation);
            if (!this.var_bfn_a.a(annotation)) continue;
            bmt2 = this.a(bmt2, annotation);
        }
        return bmt2;
    }

    protected final bmt a(bmt bmt2, Annotation annotation) {
        for (Annotation annotation2 : buk.java_lang_annotation_Annotation_arr_a(annotation.annotationType())) {
            if (bmz.a(annotation2)) continue;
            if (this.var_bfn_a.a(annotation2)) {
                if (bmt2.boolean_a(annotation2)) continue;
                bmt2 = bmt2.bmt_a(annotation2);
                bmt2 = this.a(bmt2, annotation2);
                continue;
            }
            bmt2 = bmt2.bmt_a(annotation2);
        }
        return bmt2;
    }

    protected final bmt b(bmt bmt2, Annotation[] annotationArray) {
        for (Annotation annotation : annotationArray) {
            if (bmt2.boolean_a(annotation)) continue;
            bmt2 = bmt2.bmt_a(annotation);
            if (!this.var_bfn_a.a(annotation)) continue;
            bmt2 = this.b(bmt2, annotation);
        }
        return bmt2;
    }

    protected final bmt b(bmt bmt2, Annotation annotation) {
        for (Annotation annotation2 : buk.java_lang_annotation_Annotation_arr_a(annotation.annotationType())) {
            if (bmz.a(annotation2) || bmt2.boolean_a(annotation2)) continue;
            bmt2 = bmt2.bmt_a(annotation2);
            if (!this.var_bfn_a.a(annotation2)) continue;
            bmt2 = this.a(bmt2, annotation2);
        }
        return bmt2;
    }

    protected static final boolean a(Annotation annotation) {
        return annotation instanceof Target || annotation instanceof Retention;
    }

    static bmu a() {
        return new bmu();
    }

    static bmu[] a(int n2) {
        if (n2 == 0) {
            return var_bmu_arr_a;
        }
        bmu[] bmuArray = new bmu[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bmuArray[i2] = bmz.a();
        }
        return bmuArray;
    }

    static {
        var_bmu_arr_a = new bmu[0];
        var_java_lang_annotation_Annotation_arr_a = new Annotation[0];
    }
}

