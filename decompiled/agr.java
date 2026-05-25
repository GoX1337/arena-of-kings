/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaName;
import com.arenaofkings.packets.misc.GameType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class agr
extends bac {
    private final Engine var_com_arenaofkings_client_core_Engine_a = new Array();
    private ajw var_ajw_a;
    protected ayh var_ayh_a;
    protected ArenaName var_com_arenaofkings_packets_misc_ArenaName_a;
    protected boolean var_boolean_a = false;
    private agq var_agq_a;
    private Array<axi> var_com_badlogic_gdx_utils_Array_axi__a;
    private Array<da> b = new Array();
    private Array<da> c = new Array();

    public agr(agp agp2, GameType gameType, axm axm2, Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_com_arenaofkings_packets_misc_ArenaName_a = agp2.var_com_arenaofkings_packets_misc_ArenaName_a;
        this.var_boolean_a = agp2.var_boolean_a;
        Engine.b("PLAY WORLD ARENA: " + (Object)((Object)this.var_com_arenaofkings_packets_misc_ArenaName_a) + " " + this.var_boolean_a);
        switch (this.var_com_arenaofkings_packets_misc_ArenaName_a) {
            case DARK: {
                Engine.b("dark1");
                if (this.var_boolean_a) {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.n), true);
                } else {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.m), true);
                }
                Engine.b("dark2");
                axi axi2 = new axi(636, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "bottom_fence", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi2);
                axi axi3 = new axi(0, 30, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "bottom_left_rocks", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi3);
                axi axi4 = new axi(2410, 30, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "bottom_right_rocks", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi4);
                axi axi5 = new axi(828, 912, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "top_left_column", 940, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi5);
                axi axi6 = new axi(726, 402, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "bottom_left_column", 490, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi6);
                axi axi7 = new axi(2055, 912, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "top_right_column", 927, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi7);
                axi axi8 = new axi(2139, 402, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.o), "bottom_right_column", 430, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi8);
                if (gameType == GameType.DARK_BOSS_BATTLE) {
                    this.c(1130, 775, axm2);
                    this.c(1700, 775, axm2);
                    this.c(1410, 900, axm2);
                    this.c(1250, 545, axm2);
                    this.c(1565, 545, axm2);
                } else if (gameType == GameType.TRAININGGROUND) {
                    this.d(1410, 1000, axm2);
                }
                engine.var_baa_a.a(ajw.kP, 0.3f);
                break;
            }
            case DESERT: {
                if (this.var_boolean_a) {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.r), true);
                } else {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.q), true);
                }
                TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.s);
                axi axi9 = new axi(468, 173, textureAtlas, "arena_bottom_left_tent", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi9);
                axi axi10 = new axi(2175, 169, textureAtlas, "arena_bottom_right_tent", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi10);
                axi axi11 = new axi(0, 0, textureAtlas, "arena_bottom_wall", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi11);
                axi axi12 = new axi(1697, 447, textureAtlas, "arena_bottom_column", 540, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi12);
                axi axi13 = new axi(1045, 906, textureAtlas, "arena_top_column", 952, true);
                axi13.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.15f);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi13);
                engine.var_baa_a.a(ajw.kU, 0.3f);
                break;
            }
            case FOREST: {
                if (this.var_boolean_a) {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.v), true);
                } else {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.u), true);
                }
                TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.w);
                axi axi14 = new axi(377, 288, textureAtlas, "bottom_left_column", 329, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi14);
                axi axi15 = new axi(709, 1116, textureAtlas, "top_left_column", 1127, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi15);
                axi axi16 = new axi(2132, 1107, textureAtlas, "top_right_column", 1121, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi16);
                axi axi17 = new axi(2500, 296, textureAtlas, "bottom_right_column", 340, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi17);
                axi axi18 = new axi(1383, 1122, textureAtlas, "top_rock", 1145, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi18);
                axi axi19 = new axi(1405, 164, textureAtlas, "bottom_rock", 298, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi19);
                axi axi20 = new axi(0, 0, textureAtlas, "bottom_wall", 2000, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi20);
                boolean bl2 = false;
                if (this.var_boolean_a) {
                    bl2 = true;
                }
                this.a(1283, 920, bl2, axm2, textureAtlas);
                this.a(1697, 920, bl2, axm2, textureAtlas);
                this.a(1277, 652, bl2, axm2, textureAtlas);
                this.a(1726, 652, bl2, axm2, textureAtlas);
                this.a(1438, 335, axm2);
                this.a(1418, 10, axm2);
                this.a(1404, 900, axm2);
                this.a(1393, 1280, axm2);
                engine.var_baa_a.a(ajw.kT, 0.3f);
                break;
            }
            case INDOOR: {
                if (this.var_boolean_a) {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.z), true);
                } else {
                    this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.y), true);
                }
                TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.A);
                axi axi21 = new axi(1441, 604, textureAtlas, "altar", 688, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi21);
                axi axi22 = new axi(390, 1041, textureAtlas, "left_phoenix", 1037, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi22);
                axi axi23 = new axi(2519, 1046, textureAtlas, "right_phoenix", 1038, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi23);
                this.b(76, 1206, axm2);
                this.b(160, 1340, axm2);
                this.b(2750, 1340, axm2);
                this.b(2828, 1203, axm2);
                engine.var_baa_a.a(ajw.kV, 0.3f);
                break;
            }
            case SNOWY: {
                this.a(0, 0, axm2.com_badlogic_gdx_graphics_Texture_a(ajw.j), true);
                ((TextureRegion)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                axi axi24 = new axi(0, 38, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.k), "fence", -1, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi24);
                axi axi25 = new axi(520, 1040, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.k), "left_statue", 1042, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi25);
                axi axi26 = new axi(2187, 1050, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.k), "right_statue", 1052, true);
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi26);
                engine.var_baa_a.a(ajw.kR, 0.3f);
                break;
            }
        }
        Engine.b("done loading playworld");
        ((TextureRegion)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.var_agq_a = new agq(axm2);
    }

    private void a(int n2, int n3, boolean bl2, axm axm2, TextureAtlas textureAtlas) {
        axi axi2 = new axi(n2, n3, textureAtlas, "torch", n3 + 5, true);
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(axi2);
        if (bl2) {
            da da2 = new da(ajw.bv, "Burning_on_tick", 24, 0.1f, -0.3f, Animation.PlayMode.LOOP, n2 - 19, n3 + 12);
            da2.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.bv));
            this.c.add(da2);
        }
    }

    private void a(int n2, int n3, axm axm2) {
        da da2 = new da(ajw.bA, "Poison_on_tick", 25, 0.1f, -0.3f, Animation.PlayMode.LOOP, n2 - 19, n3 + 12);
        da2.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.bA));
        this.c.add(da2);
    }

    private void b(int n2, int n3, axm axm2) {
        da da2 = new da(ajw.bv, "Burning_on_tick", 24, 0.1f, -0.3f, Animation.PlayMode.LOOP, n2 - 19, n3 + 12);
        da2.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.bv));
        da2.a(Color.NAVY);
        da da3 = new da(ajw.bv, "Burning_on_tick", 24, 0.125f, -0.3f, Animation.PlayMode.LOOP, n2 - 19, n3 + 12);
        da3.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.bv));
        this.c.add(da3);
        this.c.add(da2);
    }

    private void c(int n2, int n3, axm axm2) {
        da da2 = new da(ajw.hM, "Portal_on_tick", 6, 26, 0.1f, -0.3f, Animation.PlayMode.LOOP_PINGPONG, n2, n3);
        da2.a(Color.RED);
        da2.d(0.1f);
        da2.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.hM));
        this.c.add(da2);
    }

    private void d(int n2, int n3, axm axm2) {
        da da2 = new da(ajw.hM, "Portal_on_tick", 6, 26, 0.1f, -0.3f, Animation.PlayMode.LOOP_PINGPONG, n2, n3);
        da2.a(Color.SKY);
        da2.d(0.1f);
        da2.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.hM));
        this.c.add(da2);
    }

    public void a(Engine engine, ArenaName arenaName) {
        switch (arenaName) {
            case DARK: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jF.a(), ajw.jF.a());
                this.var_ajw_a = ajw.jF;
                break;
            }
            case DESERT: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jG.a(), ajw.jG.a());
                this.var_ajw_a = ajw.jG;
                break;
            }
            case FOREST: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jD.a(), ajw.jD.a());
                this.var_ajw_a = ajw.jD;
                break;
            }
            case INDOOR: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jH.a(), ajw.jH.a());
                this.var_ajw_a = ajw.jH;
                break;
            }
            case SNOWY: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jE.a(), ajw.jE.a());
                this.var_ajw_a = ajw.jE;
                break;
            }
        }
        engine.var_com_badlogic_gdx_assets_AssetManager_a.finishLoading();
        this.var_ayh_a = new ayh(new Sprite(engine.var_com_badlogic_gdx_assets_AssetManager_a.get(this.var_ajw_a.a(), Texture.class)), 0, 0, true);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    public Array<axi> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public Array<da> b() {
        return this.c;
    }

    public Array<da> c() {
        return this.c;
    }

    @Override
    public void d() {
        this.var_com_arenaofkings_client_core_Engine_a.b(this.var_ajw_a);
    }
}

