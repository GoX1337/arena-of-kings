/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class bok
extends boo {
    private final Map<String, Integer> b;
    private final Map<BitSet, String> c;

    public bok(bfw bfw2, boe boe2, bfw bfw3, bfr bfr2, Collection<bnz> collection) {
        super(bfw2, boe2, null, false, bfw3, null);
        this.b = new HashMap<String, Integer>();
        this.c = this.a(bfr2, collection);
    }

    public bok(bok bok2, bfp bfp2) {
        super(bok2, bfp2);
        this.b = bok2.b;
        this.c = bok2.c;
    }

    @Override
    public boc a(bfp bfp2) {
        return bfp2 == this.a ? this : new bok(this, bfp2);
    }

    protected Map<BitSet, String> a(bfr bfr2, Collection<bnz> collection) {
        boolean bl2 = bfr2.a(bgd.v);
        int n2 = 0;
        HashMap<BitSet, String> hashMap = new HashMap<BitSet, String>();
        for (bnz bnz2 : collection) {
            bfw bfw2 = bfr2.btz_a().a((Type)bnz2.a());
            List<bmx> list = bfr2.bfo_a(bfw2).a();
            BitSet bitSet = new BitSet(n2 + list.size());
            for (bmx bmx2 : list) {
                Integer n3;
                String string = bmx2.java_lang_String_a();
                if (bl2) {
                    string = string.toLowerCase();
                }
                if ((n3 = this.b.get(string)) == null) {
                    n3 = n2;
                    this.b.put(string, n2++);
                }
                bitSet.set(n3);
            }
            String string = hashMap.put(bitSet, bnz2.a().getName());
            if (string == null) continue;
            throw new IllegalStateException(String.format("Subtypes %s and %s have the same signature and cannot be uniquely deduced.", string, bnz2.a().getName()));
        }
        return hashMap;
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
        String string;
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_b) {
            bdf2 = bdc2.bdf_a();
        } else if (bdf2 != bdf.f) {
            return this.b(bdc2, bfs2, null, "Unexpected input");
        }
        LinkedList<BitSet> linkedList = new LinkedList<BitSet>(this.c.keySet());
        bve bve2 = new bve(bdc2, bfs2);
        boolean bl2 = bfs2.a(bgd.v);
        while (bdf2 == bdf.f) {
            string = bdc2.java_lang_String_d();
            if (bl2) {
                string = string.toLowerCase();
            }
            bve2.b(bdc2);
            Integer n2 = this.b.get(string);
            if (n2 != null) {
                bok.a(linkedList, n2);
                if (linkedList.size() == 1) {
                    return this.a(bdc2, bfs2, bve2, this.c.get(linkedList.get(0)));
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        string = String.format("Cannot deduce unique subtype of %s (%d candidates match)", buk.a(this.a), linkedList.size());
        return this.b(bdc2, bfs2, bve2, string);
    }

    private static void a(List<BitSet> list, int n2) {
        Iterator<BitSet> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().get(n2)) continue;
            iterator.remove();
        }
    }
}

