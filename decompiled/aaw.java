/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class aaw
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
        yu yu2 = we2.wh_a().yu_a();
        if (yu2.boolean_b() && yu2.ayg_a().boolean_e()) {
            Engine.a("its hovered, pushin it");
            yu2.a(f2);
        }
        return false;
    }
}

