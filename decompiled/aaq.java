/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class aaq
extends aam {
    public aaq(int n2) {
        super(n2);
    }

    @Override
    public boolean a(we we2) {
        if (((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).boolean_b() || we2.wh_a().aay_a().boolean_b() || we2.wh_a().zi_a().boolean_b() && we2.wh_a().zi_a().zu_a().boolean_a()) {
            return false;
        }
        if (!(we2.wh_a().wg_a().boolean_a() || we2.wh_a().zi_a().zu_a().boolean_b() || ay.ay_a().gd_a().ca_a().boolean_a())) {
            if (ay.ay_a().gd_a().cg_a().boolean_a() && ay.ay_a().gd_a().as_a().boolean_a()) {
                ay.ay_a().gd_a().cg_a().f();
            } else if (ay.ay_a().gd_a().cg_a().boolean_a()) {
                ay.ay_a().gd_a().cg_a().f();
            } else if (ay.ay_a().gd_a().as_a().boolean_a()) {
                ay.ay_a().gd_a().cg_a().e();
            } else {
                ay.ay_a().gd_a().as_a().e();
                ay.ay_a().gd_a().cg_a().e();
            }
        }
        return false;
    }

    @Override
    public boolean b(we we2) {
        return false;
    }
}

