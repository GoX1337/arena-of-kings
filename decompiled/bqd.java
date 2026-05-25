/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.List;

public class bqd {
    private static final bqb[] b = new bqb[0];
    protected final bfo var_bfo_a = Collections.emptyList();
    protected bgm var_bgm_a;
    protected List<bqb> var_java_util_List_bqb__a;
    protected bqb[] var_bqb_arr_a;
    protected bpx var_bpx_a;
    protected Object var_java_lang_Object_a;
    protected bmn var_bmn_a;
    protected brc var_brc_a;

    public bqd(bfo bfo2) {
        this.var_bfo_a = bfo2;
    }

    protected void a(bgm bgm2) {
        this.var_bgm_a = bgm2;
    }

    public void a(List<bqb> list) {
        this.var_bfo_a = list;
    }

    public void a(bqb[] bqbArray) {
        if (bqbArray != null && bqbArray.length != this.var_bfo_a.size()) {
            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", bqbArray.length, this.var_bfo_a.size()));
        }
        this.var_bqb_arr_a = bqbArray;
    }

    public void a(bpx bpx2) {
        this.var_bpx_a = bpx2;
    }

    public void a(Object object) {
        this.var_java_lang_Object_a = object;
    }

    public void a(bmn bmn2) {
        if (this.var_bmn_a != null) {
            throw new IllegalArgumentException("Multiple type ids specified with " + this.var_bmn_a + " and " + bmn2);
        }
        this.var_bmn_a = bmn2;
    }

    public void a(brc brc2) {
        this.var_brc_a = brc2;
    }

    public bfo bfo_a() {
        return this.var_bfo_a;
    }

    public List<bqb> a() {
        return this.var_bfo_a;
    }

    public bpx bpx_a() {
        return this.var_bpx_a;
    }

    public Object java_lang_Object_a() {
        return this.var_java_lang_Object_a;
    }

    public bmn bmn_a() {
        return this.var_bmn_a;
    }

    public brc brc_a() {
        return this.var_brc_a;
    }

    public bgb<?> a() {
        bqb[] bqbArray;
        if (this.var_bmn_a != null && this.var_bgm_a.a(bgd.n)) {
            this.var_bmn_a.a(this.var_bgm_a.a(bgd.o));
        }
        if (this.var_bpx_a != null) {
            this.var_bpx_a.a(this.var_bgm_a);
        }
        if (this.var_bfo_a == null || this.var_bfo_a.isEmpty()) {
            if (this.var_bpx_a == null && this.var_brc_a == null) {
                return null;
            }
            bqbArray = b;
        } else {
            bqbArray = this.var_bfo_a.toArray(new bqb[this.var_bfo_a.size()]);
            if (this.var_bgm_a.a(bgd.n)) {
                int n2 = bqbArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    bqbArray[i2].a(this.var_bgm_a);
                }
            }
        }
        if (this.var_bqb_arr_a != null && this.var_bqb_arr_a.length != this.var_bfo_a.size()) {
            throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", this.var_bfo_a.size(), this.var_bqb_arr_a.length));
        }
        return new bqc(this.var_bfo_a.bfw_a(), this, bqbArray, this.var_bqb_arr_a);
    }

    public bqc bqc_a() {
        return bqc.a(this.var_bfo_a.bfw_a(), this);
    }
}

