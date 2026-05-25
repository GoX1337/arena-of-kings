/*
 * Decompiled with CFR 0.152.
 */
public final class db
extends Enum<db> {
    public static final /* enum */ db var_db_a;
    public static final /* enum */ db b;
    private static final /* synthetic */ db[] var_db_arr_a;

    public static db[] values() {
        return (db[])var_db_arr_a.clone();
    }

    public static db valueOf(String string) {
        return Enum.valueOf(db.class, string);
    }

    static {
        var_db_a = new db();
        b = new db();
        var_db_arr_a = new db[]{var_db_a, b};
    }
}

