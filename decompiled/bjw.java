/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class bjw {
    protected final List<bio> a;

    public bjw() {
        this.a = new ArrayList<bio>();
    }

    protected bjw(List<bio> list) {
        this.a = list;
    }

    public void a(bio bio2) {
        this.a.add(bio2);
    }

    public bjw a(but but2) {
        ArrayList<bio> arrayList = new ArrayList<bio>(this.a.size());
        for (bio bio2 : this.a) {
            bfx bfx2;
            String string = but2.a(bio2.java_lang_String_a());
            bil bil2 = (bio2 = bio2.bio_a(string)).bil_a();
            if (bil2 != null && (bfx2 = ((bfx)bil2).a(but2)) != bil2) {
                bio2 = bio2.a(bfx2);
            }
            arrayList.add(bio2);
        }
        return new bjw(arrayList);
    }

    public Object a(bdc bdc2, bfs bfs2, Object object, bve bve2) {
        int n2 = this.a.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            bio bio2 = this.a.get(i2);
            bdc bdc3 = bve2.bdc_a();
            bdc3.bdf_a();
            bio2.void_a(bdc3, bfs2, object);
        }
        return object;
    }
}

