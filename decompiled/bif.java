/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class bif
extends bfs
implements Serializable {
    protected transient LinkedHashMap<bck.a, bjs> cfr_renamed_20;
    private List<bcm> var_java_util_List_bcm__a;

    protected bif(bii bii2, bih bih2) {
        super(bii2, bih2);
    }

    protected bif(bif bif2, bfr bfr2, bdc bdc2, bfv bfv2) {
        super(bif2, bfr2, bdc2, bfv2);
    }

    protected bif(bif bif2, bfr bfr2) {
        super(bif2, bfr2);
    }

    @Override
    public bjs a(Object object, bck<?> bck2, bcm bcm2) {
        Object object2;
        Object object3;
        if (object == null) {
            return null;
        }
        bck.a a2 = bck2.a(object);
        if (this.cfr_renamed_20 == null) {
            this.cfr_renamed_20 = new LinkedHashMap();
        } else {
            object3 = this.cfr_renamed_20.get(a2);
            if (object3 != null) {
                return object3;
            }
        }
        object3 = null;
        if (this.cfr_renamed_20 == null) {
            this.cfr_renamed_20 = new ArrayList(8);
        } else {
            object2 = this.cfr_renamed_20.iterator();
            while (object2.hasNext()) {
                bcm bcm3 = (bcm)object2.next();
                if (!bcm3.a(bcm2)) continue;
                object3 = bcm3;
                break;
            }
        }
        if (object3 == null) {
            object3 = bcm2.a(this);
            this.cfr_renamed_20.add(object3);
        }
        object2 = this.a(a2);
        ((bjs)object2).a((bcm)object3);
        this.cfr_renamed_20.put(a2, (bjs)object2);
        return object2;
    }

    protected bjs a(bck.a a2) {
        return new bjs(a2);
    }

    public void void_a() {
        if (this.cfr_renamed_20 == null) {
            return;
        }
        if (!this.a(bfu.k)) {
            return;
        }
        bip bip2 = null;
        for (Map.Entry<bck.a, bjs> entry : this.cfr_renamed_20.entrySet()) {
            bjs bjs2 = entry.getValue();
            if (!bjs2.boolean_a() || this.a(bjs2)) continue;
            if (bip2 == null) {
                bip2 = new bip(this.bdc_a(), "Unresolved forward references for: ");
            }
            Object object = bjs2.bck$a_a().var_java_lang_Object_a;
            Object object2 = bjs2.java_lang_Object_a();
            while (object2.hasNext()) {
                bjs.a a2 = (bjs.a)object2.next();
                bip2.a(object, a2.a(), a2.a());
            }
        }
        if (bip2 != null) {
            throw bip2;
        }
    }

    protected boolean a(bjs bjs2) {
        return bjs2.a(this);
    }

    @Override
    public bfx<Object> a(bmg bmg2, Object object) {
        bfx bfx2;
        if (object == null) {
            return null;
        }
        if (object instanceof bfx) {
            bfx2 = (bfx)object;
        } else {
            if (!(object instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + object.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            Class clazz = (Class)object;
            if (clazz == bfx.a.class || buk.c(clazz)) {
                return null;
            }
            if (!bfx.class.isAssignableFrom(clazz)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<JsonDeserializer>");
            }
            bhl bhl2 = ((bhm)((Object)this.cfr_renamed_20)).bhl_a();
            bfx bfx3 = bfx2 = bhl2 == null ? null : bhl2.a((bfr)((Object)this.cfr_renamed_20), bmg2, (Class<?>)clazz);
            if (bfx2 == null) {
                bfx2 = (bfx)buk.a(clazz, ((bhm)((Object)this.cfr_renamed_20)).c());
            }
        }
        if (bfx2 instanceof bim) {
            ((bim)((Object)bfx2)).a(this);
        }
        return bfx2;
    }

    @Override
    public final bgc a(bmg bmg2, Object object) {
        bgc bgc2;
        if (object == null) {
            return null;
        }
        if (object instanceof bgc) {
            bgc2 = (bgc)object;
        } else {
            if (!(object instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + object.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            Class clazz = (Class)object;
            if (clazz == bgc.a.class || buk.c(clazz)) {
                return null;
            }
            if (!bgc.class.isAssignableFrom(clazz)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<KeyDeserializer>");
            }
            bhl bhl2 = ((bhm)((Object)this.cfr_renamed_20)).bhl_a();
            bgc bgc3 = bgc2 = bhl2 == null ? null : bhl2.a((bfr)((Object)this.cfr_renamed_20), bmg2, (Class<?>)clazz);
            if (bgc2 == null) {
                bgc2 = (bgc)buk.a(clazz, ((bhm)((Object)this.cfr_renamed_20)).c());
            }
        }
        if (bgc2 instanceof bim) {
            ((bim)((Object)bgc2)).a(this);
        }
        return bgc2;
    }

    public abstract bif a(bfr var1, bdc var2, bfv var3);

    public abstract bif a(bfr var1);

    public Object a(bdc bdc2, bfw bfw2, bfx<Object> bfx2, Object object) {
        if (((bfr)((Object)this.cfr_renamed_20)).boolean_a()) {
            return this.b(bdc2, bfw2, bfx2, object);
        }
        if (object == null) {
            return bfx2.a(bdc2, this);
        }
        return bfx2.a(bdc2, (bfs)this, object);
    }

    protected Object b(bdc bdc2, bfw bfw2, bfx<Object> bfx2, Object object) {
        String string;
        bgj bgj2 = ((bhn)((Object)this.cfr_renamed_20)).a(bfw2);
        String string2 = bgj2.java_lang_String_a();
        if (bdc2.bdf_c() != bdf.var_bdf_b) {
            this.a(bfw2, bdf.var_bdf_b, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", new Object[]{buk.b(string2), bdc2.bdf_c()});
        }
        if (bdc2.bdf_a() != bdf.f) {
            this.a(bfw2, bdf.f, "Current token not FIELD_NAME (to contain expected root name %s), but %s", new Object[]{buk.b(string2), bdc2.bdf_c()});
        }
        if (!string2.equals(string = bdc2.java_lang_String_d())) {
            this.a(bfw2, string, "Root name (%s) does not match expected (%s) for type %s", buk.b(string), buk.b(string2), buk.a(bfw2));
        }
        bdc2.bdf_a();
        Object object2 = object == null ? bfx2.a(bdc2, this) : bfx2.a(bdc2, (bfs)this, object);
        if (bdc2.bdf_a() != bdf.var_bdf_c) {
            this.a(bfw2, bdf.var_bdf_c, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", new Object[]{buk.b(string2), bdc2.bdf_c()});
        }
        return object2;
    }

    public static final class a
    extends bif {
        public a(bii bii2) {
            super(bii2, null);
        }

        private a(a a2, bfr bfr2, bdc bdc2, bfv bfv2) {
            super(a2, bfr2, bdc2, bfv2);
        }

        private a(a a2, bfr bfr2) {
            super(a2, bfr2);
        }

        @Override
        public bif a(bfr bfr2, bdc bdc2, bfv bfv2) {
            return new a(this, bfr2, bdc2, bfv2);
        }

        @Override
        public bif a(bfr bfr2) {
            return new a(this, bfr2);
        }
    }
}

