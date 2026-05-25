/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class aap
extends aam {
    public aap(int n2) {
        super(n2);
    }

    @Override
    public boolean a(we we2) {
        if (((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).boolean_b() || we2.wh_a().zi_a().boolean_b()) {
            return false;
        }
        if (!we2.wh_a().wg_a().boolean_a() && !we2.wh_a().zi_a().zu_a().boolean_b()) {
            if (ay.ay_a().gd_a().as_a().boolean_a() && ay.ay_a().gd_a().bu_a().boolean_a()) {
                ay.ay_a().gd_a().as_a().f();
                ay.ay_a().gd_a().bu_a().d();
            } else if (ay.ay_a().gd_a().as_a().boolean_a() && ay.ay_a().gd_a().bu_a().a().size() == 0) {
                ay.ay_a().gd_a().as_a().f();
            } else if (ay.ay_a().gd_a().as_a().boolean_a()) {
                ay.ay_a().gd_a().bu_a().void_a();
            } else if (ay.ay_a().gd_a().bu_a().boolean_a()) {
                ay.ay_a().gd_a().as_a().void_d();
            } else {
                ay.ay_a().gd_a().as_a().void_d();
                ay.ay_a().gd_a().bu_a().void_b();
            }
        }
        return false;
    }

    @Override
    public boolean b(we we2) {
        return false;
    }
}

