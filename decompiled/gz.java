/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.utils.Array;

public abstract class gz
implements axr {
    protected Array<ui> var_com_badlogic_gdx_utils_Array_ui__a = new Array();
    protected SpellBarState var_com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a;
    protected ui var_ui_a;
    protected Array<ui> var_com_badlogic_gdx_utils_Array_ui__b = new Array();
    protected fu var_fu_a;
    protected ui var_ui_b;
    int var_int_a = -1;
    boolean var_boolean_a = false;

    public gz() {
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a = SpellBarState.AVAILABLE;
        this.var_fu_a = new gc();
        this.var_ui_b = new hp();
    }

    public abstract void a(String var1, int var2);

    public ui ui_a() {
        return this.var_ui_a;
    }

    public boolean boolean_a(SpellName spellName) {
        if (this.var_com_badlogic_gdx_utils_Array_ui__b.size > 0) {
            for (int i2 = 0; i2 < this.var_com_badlogic_gdx_utils_Array_ui__b.size; ++i2) {
                if (this.var_com_badlogic_gdx_utils_Array_ui__b.get(i2).hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != spellName) continue;
                return true;
            }
        }
        return false;
    }

    public ui b(SpellName spellName) {
        if (this.var_com_badlogic_gdx_utils_Array_ui__b.size > 0) {
            for (int i2 = 0; i2 < this.var_com_badlogic_gdx_utils_Array_ui__b.size; ++i2) {
                if (this.var_com_badlogic_gdx_utils_Array_ui__b.get(i2).hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != spellName) continue;
                this.var_int_a = i2;
                this.var_boolean_a = true;
                break;
            }
            if (this.var_boolean_a) {
                this.var_boolean_a = false;
                return this.var_com_badlogic_gdx_utils_Array_ui__b.removeIndex(this.var_int_a);
            }
        }
        return null;
    }

    public Array<ui> a() {
        return this.var_com_badlogic_gdx_utils_Array_ui__b;
    }

    public SpellBarState com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a;
    }

    public void a(ui ui2) {
        if (ui2 == null) {
            Engine.a("just set a null spell");
        }
        this.var_ui_a = ui2;
    }

    public void a(SpellBarState spellBarState) {
        Engine.a("Setting spellbarstate: " + spellBarState.toString());
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a = spellBarState;
    }

    public fu fu_a() {
        return this.var_fu_a;
    }

    public ui ui_b() {
        return this.var_ui_b;
    }
}

