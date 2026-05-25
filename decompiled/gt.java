/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class gt
extends gz {
    protected final Engine var_com_arenaofkings_client_core_Engine_a;
    private ui[] var_ui_arr_a = new ui[8];
    private int b;

    public gt(Engine engine, int n2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.b = n2;
    }

    public void b(String string, int n2) {
        Engine.a("Loading:\t[" + n2 + "] = " + string);
        this.var_com_arenaofkings_client_core_Engine_a.var_hg_a.a(this.var_ui_arr_a, string, n2);
        Engine.a("Loaded:\t[" + n2 + "] = " + string);
    }

    @Override
    public void a(String string, int n2) {
        Engine.a("going in");
        this.var_com_arenaofkings_client_core_Engine_a.var_hg_a.b(this.var_ui_arr_a, string, n2);
    }

    public void a(axm axm2) {
        Engine.a("in loadIconGFX()");
        Engine.a("Size: " + this.var_ui_arr_a.length);
        for (ui ui2 : this.var_ui_arr_a) {
            if (ui2 == null) continue;
            ui2.b(axm2);
        }
        Engine.a("out loadIconGFX()");
    }

    public void c(float f2, Engine engine) {
        int n2;
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null) continue;
            this.var_ui_arr_a[n2].a(f2, engine, this.b, n2, 56);
        }
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] != null) {
                this.var_ui_arr_a[n2].a(f2, engine, this.b, n2);
                continue;
            }
            Engine.a("null: " + n2);
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        int n2;
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            if (this.var_ui_arr_a[n2] == null) {
                Engine.a("Cloning in");
                engine.var_hg_a.a(this.var_ui_arr_a, this.var_ui_arr_a[n2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a().name(), n2 + 1);
            }
            if (!this.var_ui_arr_a[n2].hd_a().boolean_a()) {
                this.var_ui_arr_a[n2].hd_a().b(((we)engine.axc_a()).axm_a());
            }
            this.var_ui_arr_a[n2].a(f2, engine, this.b, n2 + 1, 0);
        }
        for (n2 = 0; n2 < this.var_ui_arr_a.length; ++n2) {
            this.var_ui_arr_a[n2].a(f2, engine, this.b, n2 + 1);
        }
    }

    public ui[] ui_arr_a() {
        return this.var_ui_arr_a;
    }

    public void void_a(int n2) {
        this.b = n2;
    }
}

