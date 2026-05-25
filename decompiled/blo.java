/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@bgp
public class blo
extends blc<Object>
implements bib,
bim {
    protected static final Object[] var_java_lang_Object_arr_a;
    protected bfx<Object> var_bfx_java_lang_Object__a;
    protected bfx<Object> var_bfx_java_lang_Object__b;
    protected bfx<Object> c;
    protected bfx<Object> d;
    protected bfw var_bfw_a;
    protected bfw var_bfw_b;
    protected final boolean var_boolean_a;

    @Deprecated
    public blo() {
        this(null, null);
    }

    public blo(bfw bfw2, bfw bfw3) {
        super(Object.class);
        this.var_bfw_a = bfw2;
        this.var_bfw_b = bfw3;
        this.var_boolean_a = false;
    }

    protected blo(blo blo2, boolean bl2) {
        super(Object.class);
        this.var_java_lang_Object_arr_a = blo2.var_java_lang_Object_arr_a;
        this.var_bfx_java_lang_Object__b = blo2.var_bfx_java_lang_Object__b;
        this.c = blo2.c;
        this.d = blo2.d;
        this.var_bfw_a = blo2.var_bfw_a;
        this.var_bfw_b = blo2.var_bfw_b;
        this.var_boolean_a = bl2;
    }

    @Override
    public void a(bfs bfs2) {
        bfw bfw2 = bfs2.bfw_a(Object.class);
        bfw bfw3 = bfs2.bfw_a(String.class);
        btz btz2 = bfs2.btz_a();
        this.var_bfx_java_lang_Object__b = this.var_bfw_a == null ? this.a(this.a(bfs2, btz2.a(List.class, bfw2))) : this.a(bfs2, this.var_bfw_a);
        this.var_java_lang_Object_arr_a = this.var_bfw_b == null ? this.a(this.a(bfs2, btz2.a(Map.class, bfw3, bfw2))) : this.a(bfs2, this.var_bfw_b);
        this.c = this.a(this.a(bfs2, bfw3));
        this.d = this.a(this.a(bfs2, btz2.a((Type)((Object)Number.class))));
        bfw bfw4 = btz.bfw_a();
        this.var_java_lang_Object_arr_a = bfs2.b((bfx<?>)this.var_java_lang_Object_arr_a, null, bfw4);
        this.var_bfx_java_lang_Object__b = bfs2.b(this.var_bfx_java_lang_Object__b, null, bfw4);
        this.c = bfs2.b(this.c, null, bfw4);
        this.d = bfs2.b(this.d, null, bfw4);
    }

    protected bfx<Object> a(bfs bfs2, bfw bfw2) {
        return bfs2.a(bfw2);
    }

    protected bfx<Object> a(bfx<Object> bfx2) {
        return buk.boolean_a(bfx2) ? null : bfx2;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        boolean bl2;
        boolean bl3 = bl2 = bfp2 == null && Boolean.FALSE.equals(bfs2.bfr_a().java_lang_Boolean_a(Object.class));
        if (this.c == null && this.d == null && this.var_java_lang_Object_arr_a == null && this.var_bfx_java_lang_Object__b == null && this.getClass() == blo.class) {
            return blo$a.a(bl2);
        }
        if (bl2 != this.var_boolean_a) {
            return new blo(this, bl2);
        }
        return this;
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public btq btq_a() {
        return btq.e;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return null;
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
        switch (bdc2.int_a()) {
            case 1: 
            case 2: 
            case 5: {
                if (this.var_java_lang_Object_arr_a != null) {
                    return this.var_java_lang_Object_arr_a.a(bdc2, bfs2);
                }
                return this.c(bdc2, bfs2);
            }
            case 3: {
                if (bfs2.a(bfu.d)) {
                    return this.java_lang_Object_arr_a(bdc2, bfs2);
                }
                if (this.var_bfx_java_lang_Object__b != null) {
                    return this.var_bfx_java_lang_Object__b.a(bdc2, bfs2);
                }
                return this.b(bdc2, bfs2);
            }
            case 12: {
                return bdc2.java_lang_Object_a();
            }
            case 6: {
                if (this.c != null) {
                    return this.c.a(bdc2, bfs2);
                }
                return bdc2.java_lang_String_e();
            }
            case 7: {
                if (this.d != null) {
                    return this.d.a(bdc2, bfs2);
                }
                if (bfs2.a((int)var_bfx_java_lang_Object__b)) {
                    return this.t(bdc2, bfs2);
                }
                return bdc2.java_lang_Number_a();
            }
            case 8: {
                if (this.d != null) {
                    return this.d.a(bdc2, bfs2);
                }
                if (bfs2.a(bfu.var_bfu_a)) {
                    return bdc2.java_lang_Number_a();
                }
                return bdc2.java_lang_Number_a();
            }
            case 9: {
                return Boolean.TRUE;
            }
            case 10: {
                return Boolean.FALSE;
            }
            case 11: {
                return null;
            }
        }
        return bfs2.a(Object.class, bdc2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        switch (bdc2.int_a()) {
            case 1: 
            case 3: 
            case 5: {
                return boc2.d(bdc2, bfs2);
            }
            case 12: {
                return bdc2.java_lang_Object_a();
            }
            case 6: {
                if (this.c != null) {
                    return this.c.a(bdc2, bfs2);
                }
                return bdc2.java_lang_String_e();
            }
            case 7: {
                if (this.d != null) {
                    return this.d.a(bdc2, bfs2);
                }
                if (bfs2.a((int)var_bfx_java_lang_Object__b)) {
                    return this.t(bdc2, bfs2);
                }
                return bdc2.java_lang_Number_a();
            }
            case 8: {
                if (this.d != null) {
                    return this.d.a(bdc2, bfs2);
                }
                if (bfs2.a(bfu.var_bfu_a)) {
                    return bdc2.java_lang_Number_a();
                }
                return bdc2.java_lang_Number_a();
            }
            case 9: {
                return Boolean.TRUE;
            }
            case 10: {
                return Boolean.FALSE;
            }
            case 11: {
                return null;
            }
        }
        return bfs2.a(Object.class, bdc2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, Object object) {
        if (this.var_boolean_a) {
            return this.java_lang_Object_a(bdc2, bfs2);
        }
        switch (bdc2.int_a()) {
            case 1: 
            case 2: 
            case 5: {
                if (this.var_java_lang_Object_arr_a != null) {
                    return this.var_java_lang_Object_arr_a.a(bdc2, bfs2, object);
                }
                if (object instanceof Map) {
                    return this.a(bdc2, bfs2, (Map)object);
                }
                return this.c(bdc2, bfs2);
            }
            case 3: {
                if (this.var_bfx_java_lang_Object__b != null) {
                    return this.var_bfx_java_lang_Object__b.a(bdc2, bfs2, object);
                }
                if (object instanceof Collection) {
                    return this.a(bdc2, bfs2, (Collection)object);
                }
                if (bfs2.a(bfu.d)) {
                    return this.java_lang_Object_arr_a(bdc2, bfs2);
                }
                return this.b(bdc2, bfs2);
            }
            case 12: {
                return bdc2.java_lang_Object_a();
            }
            case 6: {
                if (this.c != null) {
                    return this.c.a(bdc2, bfs2, object);
                }
                return bdc2.java_lang_String_e();
            }
            case 7: {
                if (this.d != null) {
                    return this.d.a(bdc2, bfs2, object);
                }
                if (bfs2.a((int)var_bfx_java_lang_Object__b)) {
                    return this.t(bdc2, bfs2);
                }
                return bdc2.java_lang_Number_a();
            }
            case 8: {
                if (this.d != null) {
                    return this.d.a(bdc2, bfs2, object);
                }
                if (bfs2.a(bfu.var_bfu_a)) {
                    return bdc2.java_lang_Number_a();
                }
                return bdc2.java_lang_Number_a();
            }
            case 9: {
                return Boolean.TRUE;
            }
            case 10: {
                return Boolean.FALSE;
            }
            case 11: {
                return null;
            }
        }
        return this.java_lang_Object_a(bdc2, bfs2);
    }

    protected Object b(bdc bdc2, bfs bfs2) {
        if (bdc2.bdf_a() == bdf.var_bdf_e) {
            return new ArrayList(2);
        }
        Object object = this.java_lang_Object_a(bdc2, bfs2);
        if (bdc2.bdf_a() == bdf.var_bdf_e) {
            ArrayList<Object> arrayList = new ArrayList<Object>(2);
            arrayList.add(object);
            return arrayList;
        }
        Object object2 = this.java_lang_Object_a(bdc2, bfs2);
        if (bdc2.bdf_a() == bdf.var_bdf_e) {
            ArrayList<Object> arrayList = new ArrayList<Object>(2);
            arrayList.add(object);
            arrayList.add(object2);
            return arrayList;
        }
        buy buy2 = bfs2.buy_a();
        Object[] objectArray = buy2.java_lang_Object_arr_a();
        int n2 = 0;
        objectArray[n2++] = object;
        objectArray[n2++] = object2;
        int n3 = n2;
        do {
            object = this.java_lang_Object_a(bdc2, bfs2);
            ++n3;
            if (n2 >= objectArray.length) {
                objectArray = buy2.a(objectArray);
                n2 = 0;
            }
            objectArray[n2++] = object;
        } while (bdc2.bdf_a() != bdf.var_bdf_e);
        ArrayList<Object> arrayList = new ArrayList<Object>(n3);
        buy2.a(objectArray, n2, arrayList);
        return arrayList;
    }

    @Override
    protected Object a(bdc bdc2, bfs bfs2, Collection<Object> collection) {
        while (bdc2.bdf_a() != bdf.var_bdf_e) {
            collection.add(this.java_lang_Object_a(bdc2, bfs2));
        }
        return collection;
    }

    protected Object c(bdc bdc2, bfs bfs2) {
        String string;
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_b) {
            string = bdc2.java_lang_String_a();
        } else if (bdf2 == bdf.f) {
            string = bdc2.java_lang_String_d();
        } else {
            if (bdf2 != bdf.var_bdf_c) {
                return bfs2.a(this.a(), bdc2);
            }
            string = null;
        }
        if (string == null) {
            return new LinkedHashMap(2);
        }
        bdc2.bdf_a();
        Object object = this.java_lang_Object_a(bdc2, bfs2);
        String string2 = bdc2.java_lang_String_a();
        if (string2 == null) {
            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(2);
            linkedHashMap.put(string, object);
            return linkedHashMap;
        }
        bdc2.bdf_a();
        Object object2 = this.java_lang_Object_a(bdc2, bfs2);
        String string3 = bdc2.java_lang_String_a();
        if (string3 == null) {
            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(4);
            linkedHashMap.put(string, object);
            if (linkedHashMap.put(string2, object2) != null) {
                return this.a(bdc2, bfs2, linkedHashMap, string, object, object2, string3);
            }
            return linkedHashMap;
        }
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put(string, object);
        if (linkedHashMap.put(string2, object2) != null) {
            return this.a(bdc2, bfs2, linkedHashMap, string, object, object2, string3);
        }
        do {
            bdc2.bdf_a();
            Object object3 = this.java_lang_Object_a(bdc2, bfs2);
            Object object4 = linkedHashMap.put(string3, object3);
            if (object4 == null) continue;
            return this.a(bdc2, bfs2, linkedHashMap, string3, object4, object3, bdc2.java_lang_String_a());
        } while ((string3 = bdc2.java_lang_String_a()) != null);
        return linkedHashMap;
    }

    protected Object a(bdc bdc2, bfs bfs2, Map<String, Object> map, String string, Object object, Object object2, String string2) {
        boolean bl2 = bfs2.a(bdj.var_bdj_a);
        if (bl2) {
            this.a(map, string, object, object2);
        }
        while (string2 != null) {
            bdc2.bdf_a();
            object2 = this.java_lang_Object_a(bdc2, bfs2);
            object = map.put(string2, object2);
            if (object != null && bl2) {
                this.a(map, string, object, object2);
            }
            string2 = bdc2.java_lang_String_a();
        }
        return map;
    }

    private void a(Map<String, Object> map, String string, Object object, Object object2) {
        if (object instanceof List) {
            ((List)object).add(object2);
            map.put(string, object);
        } else {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            arrayList.add(object);
            arrayList.add(object2);
            map.put(string, arrayList);
        }
    }

    @Override
    protected Object[] java_lang_Object_arr_a(bdc bdc2, bfs bfs2) {
        if (bdc2.bdf_a() == bdf.var_bdf_e) {
            return var_java_lang_Object_arr_a;
        }
        buy buy2 = bfs2.buy_a();
        Object[] objectArray = buy2.java_lang_Object_arr_a();
        int n2 = 0;
        do {
            Object object = this.java_lang_Object_a(bdc2, bfs2);
            if (n2 >= objectArray.length) {
                objectArray = buy2.a(objectArray);
                n2 = 0;
            }
            objectArray[n2++] = object;
        } while (bdc2.bdf_a() != bdf.var_bdf_e);
        return buy2.b(objectArray, n2);
    }

    @Override
    protected Object a(bdc bdc2, bfs bfs2, Map<Object, Object> map) {
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_b) {
            bdf2 = bdc2.bdf_a();
        }
        if (bdf2 == bdf.var_bdf_c) {
            return map;
        }
        String string = bdc2.java_lang_String_d();
        do {
            bdc2.bdf_a();
            Object object = map.get(string);
            Object object2 = object != null ? this.a(bdc2, bfs2, object) : this.java_lang_Object_a(bdc2, bfs2);
            if (object2 == object) continue;
            map.put(string, object2);
        } while ((string = bdc2.java_lang_String_a()) != null);
        return map;
    }

    static {
        var_java_lang_Object_arr_a = new Object[0];
    }

    @bgp
    public static class a
    extends blc<Object> {
        public static final a var_blo$a_a;
        protected final boolean var_boolean_a;

        public a() {
            this(false);
        }

        protected a(boolean bl2) {
            super(Object.class);
            this.var_boolean_a = bl2;
        }

        public static a a(boolean bl2) {
            if (bl2) {
                return new a(true);
            }
            return var_blo$a_a;
        }

        @Override
        public btq a() {
            return btq.e;
        }

        @Override
        public Boolean a(bfr bfr2) {
            return this.var_boolean_a ? Boolean.FALSE : null;
        }

        @Override
        public Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
            switch (bdc2.int_a()) {
                case 1: {
                    bdf bdf2 = bdc2.bdf_a();
                    if (bdf2 == bdf.var_bdf_c) {
                        return new LinkedHashMap(2);
                    }
                }
                case 5: {
                    return this.c(bdc2, bfs2);
                }
                case 3: {
                    bdf bdf3 = bdc2.bdf_a();
                    if (bdf3 == bdf.var_bdf_e) {
                        if (bfs2.a(bfu.d)) {
                            return var_java_lang_Object_arr_a;
                        }
                        return new ArrayList(2);
                    }
                    if (bfs2.a(bfu.d)) {
                        return this.java_lang_Object_arr_a(bdc2, bfs2);
                    }
                    return this.b(bdc2, bfs2);
                }
                case 12: {
                    return bdc2.java_lang_Object_a();
                }
                case 6: {
                    return bdc2.java_lang_String_e();
                }
                case 7: {
                    if (bfs2.a(b)) {
                        return this.t(bdc2, bfs2);
                    }
                    return bdc2.java_lang_Number_a();
                }
                case 8: {
                    if (bfs2.a(bfu.var_bfu_a)) {
                        return bdc2.java_lang_Number_a();
                    }
                    return bdc2.java_lang_Number_a();
                }
                case 9: {
                    return Boolean.TRUE;
                }
                case 10: {
                    return Boolean.FALSE;
                }
                case 2: {
                    return new LinkedHashMap(2);
                }
                case 11: {
                    return null;
                }
            }
            return bfs2.a(Object.class, bdc2);
        }

        @Override
        public Object a(bdc bdc2, bfs bfs2, boc boc2) {
            switch (bdc2.int_a()) {
                case 1: 
                case 3: 
                case 5: {
                    return boc2.d(bdc2, bfs2);
                }
                case 6: {
                    return bdc2.java_lang_String_e();
                }
                case 7: {
                    if (bfs2.a(bfu.b)) {
                        return bdc2.java_lang_Number_a();
                    }
                    return bdc2.java_lang_Number_a();
                }
                case 8: {
                    if (bfs2.a(bfu.var_bfu_a)) {
                        return bdc2.java_lang_Number_a();
                    }
                    return bdc2.java_lang_Number_a();
                }
                case 9: {
                    return Boolean.TRUE;
                }
                case 10: {
                    return Boolean.FALSE;
                }
                case 12: {
                    return bdc2.java_lang_Object_a();
                }
                case 11: {
                    return null;
                }
            }
            return bfs2.a(Object.class, bdc2);
        }

        @Override
        public Object a(bdc bdc2, bfs bfs2, Object object) {
            if (this.var_boolean_a) {
                return this.java_lang_Object_a(bdc2, bfs2);
            }
            switch (bdc2.int_a()) {
                case 2: 
                case 4: {
                    return object;
                }
                case 1: {
                    Object object2 = bdc2.bdf_a();
                    if (object2 == bdf.var_bdf_c) {
                        return object;
                    }
                }
                case 5: {
                    if (!(object instanceof Map)) break;
                    Object object2 = (Map)object;
                    String string = bdc2.java_lang_String_d();
                    do {
                        bdc2.bdf_a();
                        Object v2 = object2.get(string);
                        Object object3 = v2 != null ? this.a(bdc2, bfs2, v2) : this.java_lang_Object_a(bdc2, bfs2);
                        if (object3 == v2) continue;
                        object2.put(string, object3);
                    } while ((string = bdc2.java_lang_String_a()) != null);
                    return object;
                }
                case 3: {
                    Object object4 = bdc2.bdf_a();
                    if (object4 == bdf.var_bdf_e) {
                        return object;
                    }
                    if (!(object instanceof Collection)) break;
                    object4 = (Collection)object;
                    do {
                        object4.add(this.java_lang_Object_a(bdc2, bfs2));
                    } while (bdc2.bdf_a() != bdf.var_bdf_e);
                    return object;
                }
            }
            return this.java_lang_Object_a(bdc2, bfs2);
        }

        protected Object b(bdc bdc2, bfs bfs2) {
            Object object = this.java_lang_Object_a(bdc2, bfs2);
            if (bdc2.bdf_a() == bdf.var_bdf_e) {
                ArrayList<Object> arrayList = new ArrayList<Object>(2);
                arrayList.add(object);
                return arrayList;
            }
            Object object2 = this.java_lang_Object_a(bdc2, bfs2);
            if (bdc2.bdf_a() == bdf.var_bdf_e) {
                ArrayList<Object> arrayList = new ArrayList<Object>(2);
                arrayList.add(object);
                arrayList.add(object2);
                return arrayList;
            }
            buy buy2 = bfs2.buy_a();
            Object[] objectArray = buy2.java_lang_Object_arr_a();
            int n2 = 0;
            objectArray[n2++] = object;
            objectArray[n2++] = object2;
            int n3 = n2;
            do {
                object = this.java_lang_Object_a(bdc2, bfs2);
                ++n3;
                if (n2 >= objectArray.length) {
                    objectArray = buy2.a(objectArray);
                    n2 = 0;
                }
                objectArray[n2++] = object;
            } while (bdc2.bdf_a() != bdf.var_bdf_e);
            ArrayList<Object> arrayList = new ArrayList<Object>(n3);
            buy2.a(objectArray, n2, arrayList);
            return arrayList;
        }

        @Override
        protected Object[] java_lang_Object_arr_a(bdc bdc2, bfs bfs2) {
            buy buy2 = bfs2.buy_a();
            Object[] objectArray = buy2.java_lang_Object_arr_a();
            int n2 = 0;
            do {
                Object object = this.java_lang_Object_a(bdc2, bfs2);
                if (n2 >= objectArray.length) {
                    objectArray = buy2.a(objectArray);
                    n2 = 0;
                }
                objectArray[n2++] = object;
            } while (bdc2.bdf_a() != bdf.var_bdf_e);
            return buy2.b(objectArray, n2);
        }

        protected Object c(bdc bdc2, bfs bfs2) {
            String string = bdc2.java_lang_String_e();
            bdc2.bdf_a();
            Object object = this.java_lang_Object_a(bdc2, bfs2);
            String string2 = bdc2.java_lang_String_a();
            if (string2 == null) {
                LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(2);
                linkedHashMap.put(string, object);
                return linkedHashMap;
            }
            bdc2.bdf_a();
            Object object2 = this.java_lang_Object_a(bdc2, bfs2);
            String string3 = bdc2.java_lang_String_a();
            if (string3 == null) {
                LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(4);
                linkedHashMap.put(string, object);
                if (linkedHashMap.put(string2, object2) != null) {
                    return this.a(bdc2, bfs2, linkedHashMap, string, object, object2, string3);
                }
                return linkedHashMap;
            }
            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
            linkedHashMap.put(string, object);
            if (linkedHashMap.put(string2, object2) != null) {
                return this.a(bdc2, bfs2, linkedHashMap, string, object, object2, string3);
            }
            do {
                bdc2.bdf_a();
                Object object3 = this.java_lang_Object_a(bdc2, bfs2);
                Object object4 = linkedHashMap.put(string3, object3);
                if (object4 == null) continue;
                return this.a(bdc2, bfs2, linkedHashMap, string3, object4, object3, bdc2.java_lang_String_a());
            } while ((string3 = bdc2.java_lang_String_a()) != null);
            return linkedHashMap;
        }

        protected Object a(bdc bdc2, bfs bfs2, Map<String, Object> map, String string, Object object, Object object2, String string2) {
            boolean bl2 = bfs2.a(bdj.var_bdj_a);
            if (bl2) {
                this.a(map, string, object, object2);
            }
            while (string2 != null) {
                bdc2.bdf_a();
                object2 = this.java_lang_Object_a(bdc2, bfs2);
                object = map.put(string2, object2);
                if (object != null && bl2) {
                    this.a(map, string2, object, object2);
                }
                string2 = bdc2.java_lang_String_a();
            }
            return map;
        }

        private void a(Map<String, Object> map, String string, Object object, Object object2) {
            if (object instanceof List) {
                ((List)object).add(object2);
                map.put(string, object);
            } else {
                ArrayList<Object> arrayList = new ArrayList<Object>();
                arrayList.add(object);
                arrayList.add(object2);
                map.put(string, arrayList);
            }
        }

        static {
            var_blo$a_a = new a();
        }
    }
}

