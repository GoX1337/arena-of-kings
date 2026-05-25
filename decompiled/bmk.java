/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class bmk
extends bmz {
    private final bns var_bns_a;
    private final boolean var_boolean_a;
    private bmj var_bmj_a;

    bmk(bfn bfn2, bns bns2, boolean bl2) {
        super(bfn2);
        this.var_bns_a = bns2;
        this.var_boolean_a = bl2;
    }

    public static bmh.a a(bfn bfn2, btz btz2, bns bns2, bfw bfw2, Class<?> clazz, boolean bl2) {
        return new bmk(bfn2, bns2, bl2 |= clazz != null).a(btz2, bfw2, clazz);
    }

    bmh.a a(btz btz2, bfw bfw2, Class<?> clazz) {
        List<bmj> list = this.a(bfw2, clazz);
        List<bmo> list2 = this.a(btz2, bfw2, clazz);
        if (this.var_boolean_a) {
            if (this.var_bmj_a != null && ((bfn)((Object)this.var_bns_a)).boolean_a(this.var_bmj_a)) {
                this.var_bmj_a = null;
            }
            int n2 = list.size();
            while (--n2 >= 0) {
                if (!((bfn)((Object)this.var_bns_a)).boolean_a(list.get(n2))) continue;
                list.remove(n2);
            }
            n2 = list2.size();
            while (--n2 >= 0) {
                if (!((bfn)((Object)this.var_bns_a)).boolean_a((bmn)list2.get(n2))) continue;
                list2.remove(n2);
            }
        }
        return new bmh.a(this.var_bmj_a, list, list2);
    }

    private List<bmj> a(bfw bfw2, Class<?> clazz) {
        int n2;
        int n3;
        Object object;
        buk.a a2 = null;
        ArrayList<buk.a> arrayList = null;
        if (!bfw2.g()) {
            object = buk.buk$a_arr_a(bfw2.a());
            Object object2 = object;
            n3 = ((buk.a[])object2).length;
            for (int i2 = 0; i2 < n3; ++i2) {
                buk.a a3 = object2[i2];
                if (!bmk.a(a3.a())) continue;
                if (a3.int_a() == 0) {
                    a2 = a3;
                    continue;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<buk.a>();
                }
                arrayList.add(a3);
            }
        }
        if (arrayList == null) {
            object = Collections.emptyList();
            if (a2 == null) {
                return object;
            }
            n2 = 0;
        } else {
            n2 = arrayList.size();
            object = new ArrayList(n2);
            for (n3 = 0; n3 < n2; ++n3) {
                object.add(null);
            }
        }
        if (clazz != null) {
            bne[] bneArray = null;
            block2: for (buk.a a4 : buk.buk$a_arr_a(clazz)) {
                if (a4.int_a() == 0) {
                    if (a2 == null) continue;
                    this.var_bmj_a = this.bmj_a(a2, a4);
                    a2 = null;
                    continue;
                }
                if (arrayList == null) continue;
                if (bneArray == null) {
                    bneArray = new bne[n2];
                    for (int i3 = 0; i3 < n2; ++i3) {
                        bneArray[i3] = new bne(((buk.a)arrayList.get(i3)).a());
                    }
                }
                bne bne2 = new bne(a4.a());
                for (int i4 = 0; i4 < n2; ++i4) {
                    if (!bne2.equals(bneArray[i4])) continue;
                    object.set(i4, this.b((buk.a)arrayList.get(i4), a4));
                    continue block2;
                }
            }
        }
        if (a2 != null) {
            this.var_bmj_a = this.bmj_a(a2, null);
        }
        for (int i5 = 0; i5 < n2; ++i5) {
            bmj bmj2 = (bmj)object.get(i5);
            if (bmj2 != null) continue;
            object.set(i5, this.b((buk.a)arrayList.get(i5), null));
        }
        return object;
    }

    private List<bmo> a(btz btz2, bfw bfw2, Class<?> clazz) {
        ArrayList<Method> arrayList = null;
        for (Method i2 : buk.java_lang_reflect_Method_arr_a(bfw2.a())) {
            if (!bmk.a(i2)) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<Method>();
            }
            arrayList.add(i2);
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        bns.b b2 = new bns.b(btz2);
        int n2 = arrayList.size();
        ArrayList<bmo> arrayList2 = new ArrayList<bmo>(n2);
        for (int bneArray = 0; bneArray < n2; ++bneArray) {
            arrayList2.add(null);
        }
        if (clazz != null) {
            bne[] i5 = null;
            block2: for (Method method : clazz.getDeclaredMethods()) {
                if (!bmk.a(method)) continue;
                if (i5 == null) {
                    i5 = new bne[n2];
                    for (int i2 = 0; i2 < n2; ++i2) {
                        i5[i2] = new bne((Method)arrayList.get(i2));
                    }
                }
                bne bne2 = new bne(method);
                for (int i3 = 0; i3 < n2; ++i3) {
                    if (!bne2.equals(i5[i3])) continue;
                    arrayList2.set(i3, this.a((Method)arrayList.get(i3), b2, method));
                    continue block2;
                }
            }
        }
        for (int i4 = 0; i4 < n2; ++i4) {
            bmo bmo2 = (bmo)arrayList2.get(i4);
            if (bmo2 != null) continue;
            Method method = (Method)arrayList.get(i4);
            bns bns2 = bnf.a(method, bfw2, btz2, b2);
            arrayList2.set(i4, this.a(method, bns2, null));
        }
        return arrayList2;
    }

    private static boolean a(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    protected bmj bmj_a(buk.a a2, buk.a a3) {
        return new bmj(this.var_bns_a, a2.a(), this.bmu_a(a2, a3), (bmu[])var_bns_a);
    }

    protected bmj b(buk.a a2, buk.a a3) {
        bmu[] bmuArray;
        int n2 = a2.int_a();
        if (this.var_bns_a == null) {
            return new bmj(this.var_bns_a, a2.a(), bmk.a(), bmk.a(n2));
        }
        if (n2 == 0) {
            return new bmj(this.var_bns_a, a2.a(), this.bmu_a(a2, a3), (bmu[])var_bns_a);
        }
        Annotation[][] annotationArray = a2.java_lang_annotation_Annotation_arr_arr_a();
        if (n2 != annotationArray.length) {
            bmuArray = null;
            Class<?> clazz = a2.a();
            if (buk.f(clazz) && n2 == annotationArray.length + 2) {
                Annotation[][] annotationArray2 = annotationArray;
                annotationArray = new Annotation[annotationArray2.length + 2][];
                System.arraycopy(annotationArray2, 0, annotationArray, 2, annotationArray2.length);
                bmuArray = this.a(annotationArray, (Annotation[][])null);
            } else if (clazz.isMemberClass() && n2 == annotationArray.length + 1) {
                Annotation[][] annotationArray3 = annotationArray;
                annotationArray = new Annotation[annotationArray3.length + 1][];
                System.arraycopy(annotationArray3, 0, annotationArray, 1, annotationArray3.length);
                annotationArray[0] = var_bns_a;
                bmuArray = this.a(annotationArray, (Annotation[][])null);
            }
            if (bmuArray == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", a2.a().getName(), n2, annotationArray.length));
            }
        } else {
            bmuArray = this.a(annotationArray, a3 == null ? (Annotation[][])null : a3.java_lang_annotation_Annotation_arr_arr_a());
        }
        return new bmj(this.var_bns_a, a2.a(), this.bmu_a(a2, a3), bmuArray);
    }

    protected bmo a(Method method, bns bns2, Method method2) {
        int n2 = method.getParameterTypes().length;
        if (this.var_bns_a == null) {
            return new bmo(bns2, method, bmk.a(), bmk.a(n2));
        }
        if (n2 == 0) {
            return new bmo(bns2, method, this.a(method, method2), (bmu[])var_bns_a);
        }
        return new bmo(bns2, method, this.a(method, method2), this.a(method.getParameterAnnotations(), method2 == null ? (Annotation[][])null : method2.getParameterAnnotations()));
    }

    private bmu[] a(Annotation[][] annotationArray, Annotation[][] annotationArray2) {
        if (this.var_boolean_a) {
            int n2 = annotationArray.length;
            bmu[] bmuArray = new bmu[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                bmt bmt2 = this.a(bmt.bmt_a(), annotationArray[i2]);
                if (annotationArray2 != null) {
                    bmt2 = this.a(bmt2, annotationArray2[i2]);
                }
                bmuArray[i2] = bmt2.bmu_a();
            }
            return bmuArray;
        }
        return var_bns_a;
    }

    private bmu bmu_a(buk.a a2, buk.a a3) {
        if (this.var_boolean_a) {
            bmt bmt2 = this.a(a2.java_lang_annotation_Annotation_arr_a());
            if (a3 != null) {
                bmt2 = this.a(bmt2, a3.java_lang_annotation_Annotation_arr_a());
            }
            return bmt2.bmu_a();
        }
        return bmk.a();
    }

    private final bmu a(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        bmt bmt2 = this.a(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            bmt2 = this.a(bmt2, annotatedElement2.getDeclaredAnnotations());
        }
        return bmt2.bmu_a();
    }

    private static boolean a(Constructor<?> constructor) {
        return !constructor.isSynthetic();
    }
}

