/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class bxl {
    protected List<bxj> var_java_util_List_bxj__a = new ArrayList<bxj>();
    protected List<bxj> b = new ArrayList<bxj>();
    protected List<bxk> c = new ArrayList<bxk>();
    protected int var_int_a = 0;
    private boolean var_boolean_a = false;

    public synchronized void a(bxh bxh2, Throwable throwable) {
        this.b.add(new bxj(bxh2, throwable));
        for (bxk bxk2 : this.a()) {
            bxk2.a(bxh2, throwable);
        }
    }

    public synchronized void a(bxh bxh2, bxf bxf2) {
        this.var_java_util_List_bxj__a.add(new bxj(bxh2, (Throwable)((Object)bxf2)));
        for (bxk bxk2 : this.a()) {
            bxk2.a(bxh2, bxf2);
        }
    }

    public synchronized void a(bxk bxk2) {
        this.c.add(bxk2);
    }

    private synchronized List<bxk> a() {
        ArrayList<bxk> arrayList = new ArrayList<bxk>();
        arrayList.addAll(this.c);
        return arrayList;
    }

    public void a(bxh bxh2) {
        for (bxk bxk2 : this.a()) {
            bxk2.void_a(bxh2);
        }
    }

    protected void a(bxi bxi2) {
        this.b(bxi2);
        bxm bxm2 = new bxm(this, bxi2);
        this.a((bxh)bxi2, bxm2);
        this.a((bxh)bxi2);
    }

    public void a(bxh bxh2, bxg bxg2) {
        try {
            bxg2.a();
        }
        catch (bxf bxf2) {
            this.a(bxh2, bxf2);
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
        catch (Throwable throwable) {
            this.a(bxh2, throwable);
        }
    }

    public synchronized boolean a() {
        return this.var_boolean_a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void b(bxh bxh2) {
        int n2 = bxh2.int_a();
        bxl bxl2 = this;
        synchronized (bxl2) {
            this.var_int_a += n2;
        }
        for (bxk bxk2 : this.a()) {
            bxk2.b(bxh2);
        }
    }
}

