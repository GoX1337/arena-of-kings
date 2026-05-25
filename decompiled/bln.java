/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.UUID;

public class bln
extends bko<UUID> {
    static final int[] a;

    public bln() {
        super(UUID.class);
    }

    @Override
    public Object b(bfs bfs2) {
        return new UUID(0L, 0L);
    }

    @Override
    protected UUID a(String string, bfs bfs2) {
        if (string.length() != 36) {
            if (string.length() == 24) {
                byte[] byArray = bcr.a().a(string);
                return this.a(byArray, bfs2);
            }
            return this.b(string, bfs2);
        }
        if (string.charAt(8) != '-' || string.charAt(13) != '-' || string.charAt(18) != '-' || string.charAt(23) != '-') {
            this.b(string, bfs2);
        }
        long l2 = this.a(string, 0, bfs2);
        long l3 = (long)this.b(string, 9, bfs2) << 16;
        long l4 = (l2 <<= 32) + (l3 |= (long)this.b(string, 14, bfs2));
        int n2 = this.b(string, 19, bfs2) << 16 | this.b(string, 24, bfs2);
        l2 = n2;
        l3 = this.a(string, 28, bfs2);
        l3 = l3 << 32 >>> 32;
        long l5 = (l2 <<= 32) | l3;
        return new UUID(l4, l5);
    }

    @Override
    protected UUID a(Object object, bfs bfs2) {
        if (object instanceof byte[]) {
            return this.a((byte[])object, bfs2);
        }
        return (UUID)super.a(object, bfs2);
    }

    private UUID b(String string, bfs bfs2) {
        return (UUID)bfs2.b(this.a(), string, "UUID has to be represented by standard 36-char representation", new Object[0]);
    }

    int a(String string, int n2, bfs bfs2) {
        return (this.c(string, n2, bfs2) << 24) + (this.c(string, n2 + 2, bfs2) << 16) + (this.c(string, n2 + 4, bfs2) << 8) + this.c(string, n2 + 6, bfs2);
    }

    int b(String string, int n2, bfs bfs2) {
        return (this.c(string, n2, bfs2) << 8) + this.c(string, n2 + 2, bfs2);
    }

    int c(String string, int n2, bfs bfs2) {
        int n3;
        char c2 = string.charAt(n2);
        char c3 = string.charAt(n2 + 1);
        if (c2 <= '\u007f' && c3 <= '\u007f' && (n3 = a[c2] << 4 | a[c3]) >= 0) {
            return n3;
        }
        if (c2 > '\u007f' || a[c2] < 0) {
            return this.a(string, n2, bfs2, c2);
        }
        return this.a(string, n2 + 1, bfs2, c3);
    }

    int a(String string, int n2, bfs bfs2, char c2) {
        throw bfs2.a(string, this.a(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", Character.valueOf(c2), Integer.toHexString(c2)));
    }

    private UUID a(byte[] byArray, bfs bfs2) {
        if (byArray.length != 16) {
            throw blr.a(bfs2.bdc_a(), "Can only construct UUIDs from byte[16]; got " + byArray.length + " bytes", byArray, this.a());
        }
        return new UUID(bln.long_a(byArray, 0), bln.long_a(byArray, 8));
    }

    private static long long_a(byte[] byArray, int n2) {
        long l2 = (long)bln.int_a(byArray, n2) << 32;
        long l3 = bln.int_a(byArray, n2 + 4);
        l3 = l3 << 32 >>> 32;
        return l2 | l3;
    }

    private static int int_a(byte[] byArray, int n2) {
        return byArray[n2] << 24 | (byArray[n2 + 1] & 0xFF) << 16 | (byArray[n2 + 2] & 0xFF) << 8 | byArray[n2 + 3] & 0xFF;
    }

    static {
        int n2;
        a = new int[127];
        Arrays.fill(a, -1);
        for (n2 = 0; n2 < 10; ++n2) {
            bln.a[48 + n2] = n2;
        }
        for (n2 = 0; n2 < 6; ++n2) {
            bln.a[97 + n2] = 10 + n2;
            bln.a[65 + n2] = 10 + n2;
        }
    }
}

