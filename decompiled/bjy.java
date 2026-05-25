/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class bjy
extends bkf {
    public bjy(bfw bfw2, bfx<Object> bfx2, boc boc2, bir bir2) {
        super(bfw2, bfx2, boc2, bir2);
    }

    protected bjy(bfw bfw2, bfx<Object> bfx2, boc boc2, bir bir2, bfx<Object> bfx3, bil bil2, Boolean bl2) {
        super(bfw2, bfx2, boc2, bir2, bfx3, bil2, bl2);
    }

    @Override
    protected bjy a(bfx<?> bfx2, bfx<?> bfx3, boc boc2, bil bil2, Boolean bl2) {
        return new bjy(this.a, bfx3, boc2, this.a, bfx2, bil2, bl2);
    }

    @Override
    protected Collection<Object> a(bfs bfs2) {
        return null;
    }

    @Override
    protected Collection<Object> a(bdc bdc2, bfs bfs2, Collection<Object> collection) {
        if (collection == null) {
            collection = new ArrayList<Object>();
        }
        if ((collection = super.a(bdc2, bfs2, collection)).isEmpty()) {
            return new ArrayBlockingQueue<Object>(1, false);
        }
        return new ArrayBlockingQueue<Object>(collection.size(), false, collection);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.b(bdc2, bfs2);
    }
}

