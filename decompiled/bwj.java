/*
 * Decompiled with CFR 0.152.
 */
class bwj
extends bwh {
    bwj() {
    }

    @Override
    int a(bvo bvo2, Object object, float[][] fArray, int[] nArray, int n2) {
        int n3 = 0;
        for (n3 = 0; n3 < n2 && nArray[n3] == 0; ++n3) {
        }
        if (n3 == n2) {
            return 0;
        }
        return bwj.a(bvo2, object, fArray, n2);
    }
}

