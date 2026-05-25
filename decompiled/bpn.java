/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

final class bpn {
    private static final bnx var_bnx_a;
    private static final bgh var_bgh_a;
    private static final bgh b;
    private static final bgg var_bgg_a;

    public static String a(bfz bfz2) {
        try {
            return var_bgh_a.a(bfz2);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    static {
        var_bnx_a = new bnx();
        var_bgh_a = var_bnx_a.bgh_a();
        b = var_bnx_a.bgh_a().bgh_a();
        var_bgg_a = var_bnx_a.a(bfz.class);
    }
}

