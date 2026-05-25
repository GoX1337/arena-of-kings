/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class aau
extends aan {
    private boolean a = false;

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
        Engine.a("XD");
        if (we2.wh_a().ya_a().boolean_b() && ((ayh)((Object)we2.wh_a().ya_a().azh_a().a)).boolean_a()) {
            Engine.a("XD2");
            if (f2 == 1.0f) {
                Engine.a("XD3");
                we2.wh_a().ya_a().azh_a().c();
                return true;
            }
            if (f2 == -1.0f) {
                Engine.a("XD4");
                we2.wh_a().ya_a().azh_a().d();
                return true;
            }
        }
        Engine.a("XD5");
        return false;
    }
}

