/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

public final class CheckIntrinsics {
    private CheckIntrinsics() {
    }

    public static int checkIndex(int n2, int n3) {
        if (n2 < 0 || n3 <= n2) {
            throw new IndexOutOfBoundsException();
        }
        return n2;
    }

    public static int checkFromToIndex(int n2, int n3, int n4) {
        if (n2 < 0 || n3 < n2 || n4 < n3) {
            throw new IndexOutOfBoundsException();
        }
        return n2;
    }

    public static int checkFromIndexSize(int n2, int n3, int n4) {
        if ((n4 | n2 | n3) < 0 || n4 - n2 < n3) {
            throw new IndexOutOfBoundsException();
        }
        return n2;
    }
}

