/*
 * Decompiled with CFR 0.152.
 */
class bwi
extends bwh {
    bwi() {
    }

    @Override
    int a(bvo bvo2, Object object, float[][] fArray, int[] nArray, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] == 0) continue;
            fArray[n3++] = fArray[i2];
        }
        if (n3 != 0) {
            return bwi.a(bvo2, object, fArray, n3, 1);
        }
        return 0;
    }
}

