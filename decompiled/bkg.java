/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class bkg<T>
extends blc<T> {
    protected final bfw var_bfw_a;
    protected final bil var_bil_a;
    protected final boolean var_boolean_a;
    protected final Boolean var_java_lang_Boolean_a;

    protected bkg(bfw bfw2, bil bil2, Boolean bl2) {
        super(bfw2);
        this.var_bfw_a = bfw2;
        this.var_java_lang_Boolean_a = bl2;
        this.var_bil_a = bil2;
        this.var_boolean_a = bjj.a(bil2);
    }

    protected bkg(bfw bfw2) {
        this(bfw2, null, null);
    }

    protected bkg(bkg<?> bkg2) {
        this(bkg2, bkg2.var_bil_a, bkg2.var_java_lang_Boolean_a);
    }

    protected bkg(bkg<?> bkg2, bil bil2, Boolean bl2) {
        super(bkg2.var_bfw_a);
        this.var_bfw_a = bkg2.var_bfw_a;
        this.var_bil_a = bil2;
        this.var_java_lang_Boolean_a = bl2;
        this.var_boolean_a = bjj.a(bil2);
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.TRUE;
    }

    @Override
    public bio a(String string) {
        bfx<Object> bfx2 = this.a();
        if (bfx2 == null) {
            throw new IllegalArgumentException(String.format("Cannot handle managed/back reference '%s': type: container deserializer of type %s returned null for 'getContentDeserializer()'", string, this.getClass().getName()));
        }
        return bfx2.a(string);
    }

    @Override
    public abstract bfx<Object> a();

    @Override
    public buc buc_a() {
        return buc.c;
    }

    @Override
    public Object b(bfs bfs2) {
        bir bir2 = this.bir_a();
        if (bir2 == null || !bir2.i()) {
            bfw bfw2 = this.bfw_a();
            bfs2.b(bfw2, String.format("Cannot create empty instance of %s, no default Creator", bfw2));
        }
        try {
            return bir2.a(bfs2);
        }
        catch (IOException iOException) {
            return buk.a(bfs2, iOException);
        }
    }

    protected <BOGUS> BOGUS a(bfs bfs2, Throwable throwable, Object object, String string) {
        while (throwable instanceof InvocationTargetException && throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        buk.java_lang_Throwable_a(throwable);
        if (bfs2 != null && !bfs2.a(bfu.p)) {
            buk.java_lang_Throwable_b(throwable);
        }
        if (throwable instanceof IOException && !(throwable instanceof bfy)) {
            throw (IOException)throwable;
        }
        throw bfy.a(throwable, object, buk.a(string, "N/A"));
    }
}

