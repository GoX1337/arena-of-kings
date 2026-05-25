/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bip
extends bfy {
    private bjs var_bjs_a;
    private List<biq> var_java_util_List_biq__a;

    public bip(bdc bdc2, String string, bda bda2, bjs bjs2) {
        super((Closeable)bdc2, string, bda2);
        this.var_bjs_a = bjs2;
    }

    public bip(bdc bdc2, String string) {
        super(bdc2, string);
        this.var_bjs_a = new ArrayList();
    }

    @Override
    public bjs bjs_a() {
        return this.var_bjs_a;
    }

    public Object java_lang_Object_b() {
        return this.var_bjs_a.bck$a_a().var_java_lang_Object_a;
    }

    public void a(Object object, Class<?> clazz, bda bda2) {
        this.var_bjs_a.add(new biq(object, clazz, bda2));
    }

    @Override
    public String getMessage() {
        String string = super.getMessage();
        if (this.var_bjs_a == null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        Iterator iterator = this.var_bjs_a.iterator();
        while (iterator.hasNext()) {
            biq biq2 = (biq)iterator.next();
            stringBuilder.append(biq2.toString());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append('.');
        return stringBuilder.toString();
    }
}

