/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ha
implements axr,
Comparable<ha> {
    protected SpellName var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
    protected hd var_hd_a;
    protected ayh var_ayh_a;
    private boolean var_boolean_a = false;

    public ha(Engine engine, TextureAtlas textureAtlas, SpellName spellName) {
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a = spellName;
        this.var_hd_a = engine.var_hg_a.ui_a(spellName).hd_a();
        if (!ay.ay_a().gd_a().a(spellName)) {
            this.var_ayh_a = new hb(this, textureAtlas.createSprite("Graylock"), true, spellName, engine);
        }
    }

    public void a(axm axm2) {
        this.var_hd_a.a(axm2);
    }

    public int int_a(ha ha2) {
        return SpellName.getFormattedName(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a).compareTo(SpellName.getFormattedName(ha2.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a));
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_boolean_a = ay.ay_a().gd_a().a(abi.ar);
        this.var_hd_a.d(f2, engine);
        if (this.var_boolean_a) {
            engine.a(SpellName.getFormattedName(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a), engine.var_axy_c.a(), axe.x, engine.var_axy_c.a(), Color.BLACK, this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 151.0f, this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 31.0f, 1, 1);
        } else if (!ay.ay_a().gd_a().a(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a)) {
            this.var_ayh_a.a(f2, engine);
            this.var_ayh_a.a(f2, engine.var_azi_a, (int)this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), (int)this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY(), 1.0f);
            engine.a(SpellName.getFormattedName(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a), engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 151.0f, this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 31.0f, 1, 1);
        } else {
            engine.a(SpellName.getFormattedName(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a), engine.var_axy_c.a(), axe.x, engine.var_axy_c.a(), Color.BLACK, this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 151.0f, this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 31.0f, 1, 1);
        }
    }

    public String toString() {
        return this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a.name();
    }

    public void a(int n2) {
        this.var_hd_a.a(1185, 818 - n2 * 57);
        if (this.var_ayh_a != null) {
            this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_hd_a.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), this.var_hd_a.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
        }
    }

    public hd a() {
        return this.var_hd_a;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.int_a((ha)object);
    }

    static /* synthetic */ boolean a(ha ha2, boolean bl2) {
        ha2.var_boolean_a = bl2;
        return ha2.var_boolean_a;
    }

    static /* synthetic */ boolean boolean_a(ha ha2) {
        return ha2.var_boolean_a;
    }
}

