/*
 * Decompiled with CFR 0.152.
 */
public class aar
extends aan {
    @Override
    public boolean a(we we2, int n2, int n3, int n4, int n5) {
        return false;
    }

    @Override
    public boolean b(we we2, int n2, int n3, int n4, int n5) {
        return false;
    }

    @Override
    public boolean a(we we2, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public boolean a(we we2, float f2) {
        System.out.println("Scrolled " + f2);
        if (we2.wh_a().wg_a().boolean_e()) {
            if (f2 == 1.0f) {
                System.out.println("xd uh oh " + f2);
                return true;
            }
            if (f2 == -1.0f) {
                return true;
            }
        }
        return false;
    }
}

