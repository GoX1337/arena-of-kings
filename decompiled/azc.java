/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class azc
implements axr,
Comparable<azc> {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private ayh var_ayh_a;
    private ayh b;
    private ProfileBackgrounds var_com_arenaofkings_packets_misc_ProfileBackgrounds_a;
    private int var_int_a;
    private boolean var_boolean_a = false;

    public azc(Engine engine, TextureAtlas textureAtlas, ProfileBackgrounds profileBackgrounds, int n2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_ayh_a = new ayh(414, 850 - n2 * 24, textureAtlas, "mtx_textlabel", true);
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GRAY);
        this.b = new azd(this, 683, 892, textureAtlas, "mtx_box", true, profileBackgrounds, engine);
        this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a = profileBackgrounds;
        this.var_int_a = n2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayh_a.a(f2, engine);
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(683.0f, 699 - this.var_int_a * 24);
        this.b.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_ayh_a.b(f2, engine);
        if (ay.ay_a().gd_a().a(this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a)) {
            engine.a(this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.getFormattedName(), engine.var_axy_c.a(), axe.x, engine.var_axy_c.a(), Color.BLACK, 428.0f, (float)(722 - this.var_int_a * 24), 8, 1);
        } else {
            engine.a(this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.getFormattedName(), engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 428.0f, (float)(722 - this.var_int_a * 24), 8, 1);
        }
        this.b.b(f2, engine);
    }

    public void a(int n2) {
        this.var_int_a = n2;
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(414.0f, 705 - n2 * 24);
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public ProfileBackgrounds com_arenaofkings_packets_misc_ProfileBackgrounds_a() {
        return this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a;
    }

    public int a(azc azc2) {
        return this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.name().compareTo(azc2.com_arenaofkings_packets_misc_ProfileBackgrounds_a().name());
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((azc)object);
    }
}

