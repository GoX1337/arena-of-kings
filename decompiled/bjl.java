/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bjl
implements Serializable {
    protected final bfw var_bfw_a;
    public final bgj var_bgj_a;
    public final bck<?> var_bck____a;
    public final bcm var_bcm_a;
    protected final bfx<Object> var_bfx_java_lang_Object__a;
    public final bio var_bio_a;

    protected bjl(bfw bfw2, bgj bgj2, bck<?> bck2, bfx<?> bfx2, bio bio2, bcm bcm2) {
        this.var_bfw_a = bfw2;
        this.var_bgj_a = bgj2;
        this.var_bfw_a = bck2;
        this.var_bcm_a = bcm2;
        this.var_bfw_a = bfx2;
        this.var_bio_a = bio2;
    }

    public static bjl a(bfw bfw2, bgj bgj2, bck<?> bck2, bfx<?> bfx2, bio bio2, bcm bcm2) {
        return new bjl(bfw2, bgj2, bck2, bfx2, bio2, bcm2);
    }

    public bfx<Object> a() {
        return this.var_bfw_a;
    }

    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    public boolean boolean_a() {
        return ((bck)((Object)this.var_bfw_a)).a();
    }

    public boolean a(String string, bdc bdc2) {
        return ((bck)((Object)this.var_bfw_a)).a(string, bdc2);
    }

    public Object a(bdc bdc2, bfs bfs2) {
        return ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2);
    }
}

