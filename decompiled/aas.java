/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class aas
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
        if (((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_com_badlogic_gdx_math_Vector3_a.x >= 1544.0f && ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_com_badlogic_gdx_math_Vector3_a.x <= 1920.0f && ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_com_badlogic_gdx_math_Vector3_a.y >= 0.0f && ((Engine)((Object)we2.var_com_badlogic_gdx_InputMultiplexer_a)).var_com_badlogic_gdx_math_Vector3_a.y <= 290.0f) {
            Engine.a("IN");
            if (f2 == 1.0f) {
                ay.ay_a().gd_a().axz_a().a();
                return true;
            }
            if (f2 == -1.0f) {
                ay.ay_a().gd_a().axz_a().b();
                return true;
            }
        }
        return false;
    }
}

