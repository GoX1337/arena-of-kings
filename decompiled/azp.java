/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.graphics.Color;

public class azp
implements axr {
    private final axm var_axm_a;
    private boolean var_boolean_a = false;

    public azp(axm axm2) {
        this.var_axm_a = axm2;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_a) {
            int n2;
            for (n2 = 1; n2 < ay.ay_a().gu_a().ui_arr_a().length; ++n2) {
                if (!ay.ay_a().gu_a().ui_a(n2).hd_a().boolean_a()) {
                    ay.ay_a().gu_a().ui_a(n2).b(this.var_axm_a);
                }
                ay.ay_a().gu_a().ui_a(n2).a(f2, engine, n2);
            }
            for (n2 = 1; n2 < ay.ay_a().gu_a().ui_arr_a().length; ++n2) {
                if (!ay.ay_a().gu_a().ui_a(n2).hd_a().boolean_a()) {
                    ay.ay_a().gu_a().ui_a(n2).b(this.var_axm_a);
                }
                ay.ay_a().gu_a().ui_a(n2).c(f2, engine, n2);
            }
            for (n2 = 1; n2 < ay.ay_a().gu_a().ui_arr_a().length; ++n2) {
                if (engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)) == null || engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)).int_a() == 9999 || ay.ay_a().gu_a().ui_a(n2).hf_a().uk_a() == uk.b) continue;
                engine.a(agc.a(engine.var_agc_a.a().get(InputIdentifier.valueOf("ABILITY_" + n2)).int_a()), engine.var_axy_c.a(), axe.A, engine.var_axy_c.a(), Color.BLACK, (float)(1138 + n2 * 45), 441.0f, 1, 2);
            }
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public void a(boolean bl2) {
        Engine.a("setting book to visible");
        this.var_boolean_a = bl2;
        this.void_a();
    }

    public void void_a() {
        Engine.a("spellbar length: " + ay.ay_a().gu_a().ui_arr_a().length);
        for (int i2 = 1; i2 < ay.ay_a().gu_a().ui_arr_a().length; ++i2) {
            if (ay.ay_a().gu_a().ui_a(i2).hd_a().boolean_a()) {
                ay.ay_a().gu_a().ui_a(i2).hd_a().da_b().void_a();
                Engine.a("reset the glow on " + (Object)((Object)ay.ay_a().gu_a().ui_a(i2).hd_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
            }
            Engine.a("didn't reset it");
        }
    }
}

