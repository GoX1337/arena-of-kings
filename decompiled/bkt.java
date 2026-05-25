/*
 * Decompiled with CFR 0.152.
 */
import java.util.AbstractMap;
import java.util.Map;

@bgp
public class bkt
extends bkg<Map.Entry<Object, Object>>
implements bib {
    protected final bgc var_bgc_a;
    protected final bfx<Object> var_bfx_java_lang_Object__a;
    protected final boc var_boc_a;

    public bkt(bfw bfw2, bgc bgc2, bfx<Object> bfx2, boc boc2) {
        super(bfw2);
        if (bfw2.int_a() != 2) {
            throw new IllegalArgumentException("Missing generic type information for " + bfw2);
        }
        this.var_bgc_a = bgc2;
        this.var_bgc_a = bfx2;
        this.var_boc_a = boc2;
    }

    protected bkt(bkt bkt2, bgc bgc2, bfx<Object> bfx2, boc boc2) {
        super(bkt2);
        this.var_bgc_a = bgc2;
        this.var_bgc_a = bfx2;
        this.var_boc_a = boc2;
    }

    protected bkt a(bgc bgc2, boc boc2, bfx<?> bfx2) {
        if (this.var_bgc_a == bgc2 && this.var_bgc_a == bfx2 && this.var_boc_a == boc2) {
            return this;
        }
        return new bkt(this, bgc2, bfx2, boc2);
    }

    @Override
    public btq a() {
        return btq.c;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        bgc bgc2 = this.var_bgc_a;
        if (bgc2 == null) {
            bgc2 = bfs2.a(((bfw)((Object)this.var_bgc_a)).a(0), bfp2);
        } else if (bgc2 instanceof bic) {
            bgc2 = ((bic)((Object)bgc2)).a(bfs2, bfp2);
        }
        bfx<Object> bfx2 = this.var_bgc_a;
        bfx2 = this.a(bfs2, bfp2, bfx2);
        bfw bfw2 = ((bfw)((Object)this.var_bgc_a)).a(1);
        bfx2 = bfx2 == null ? bfs2.a(bfw2, bfp2) : bfs2.b(bfx2, bfp2, bfw2);
        boc boc2 = this.var_boc_a;
        if (boc2 != null) {
            boc2 = boc2.a(bfp2);
        }
        return this.a(bgc2, boc2, bfx2);
    }

    @Override
    public bfx<Object> a() {
        return this.var_bgc_a;
    }

    @Override
    public Map.Entry<Object, Object> a(bdc bdc2, bfs bfs2) {
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_b) {
            bdf2 = bdc2.bdf_a();
        } else if (bdf2 != bdf.f && bdf2 != bdf.var_bdf_c) {
            if (bdf2 == bdf.var_bdf_d) {
                return (Map.Entry)this.e(bdc2, bfs2);
            }
            return (Map.Entry)bfs2.a(this.bfw_a(bfs2), bdc2);
        }
        if (bdf2 != bdf.f) {
            if (bdf2 == bdf.var_bdf_c) {
                return (Map.Entry)bfs2.a(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
            }
            return (Map.Entry)bfs2.a(this.a(), bdc2);
        }
        bgc bgc2 = this.var_bgc_a;
        bgc bgc3 = this.var_bgc_a;
        boc boc2 = this.var_boc_a;
        String string = bdc2.java_lang_String_d();
        Object object = bgc2.a(string, bfs2);
        Object object2 = null;
        bdf2 = bdc2.bdf_a();
        try {
            object2 = bdf2 == bdf.m ? (Object)((bfx)((Object)bgc3)).a(bfs2) : (boc2 == null ? (Object)((bfx)((Object)bgc3)).a(bdc2, bfs2) : ((bfx)((Object)bgc3)).a(bdc2, bfs2, boc2));
        }
        catch (Exception exception) {
            this.a(bfs2, exception, Map.Entry.class, string);
        }
        bdf2 = bdc2.bdf_a();
        if (bdf2 != bdf.var_bdf_c) {
            if (bdf2 == bdf.f) {
                bfs2.a(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", bdc2.java_lang_String_d());
            } else {
                bfs2.a(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + (Object)((Object)bdf2), new Object[0]);
            }
            return null;
        }
        return new AbstractMap.SimpleEntry<Object, Object>(object, object2);
    }

    @Override
    public Map.Entry<Object, Object> a(bdc bdc2, bfs bfs2, Map.Entry<Object, Object> entry) {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.java_lang_Object_a(bdc2, bfs2);
    }
}

