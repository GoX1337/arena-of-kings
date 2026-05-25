/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class ayo
extends azk<aym> {
    private aym var_aym_a = new Array();
    private ayh d;
    private ayh e;
    private ayh f;
    private final axm var_axm_a;

    public ayo(Engine engine, axm axm2, String string, String string2, String string3, int n2, int n3) {
        super(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), string, string2, string3, n2, n3);
        this.d = new ayh(723, 892, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_checkmark", true);
        this.e = new ayh(723, 892, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "Goldlock", true);
        this.e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
        this.f = new ayh(720, 892, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_box", true);
        this.var_axm_a = axm2;
        this.a(engine);
        Engine.a("created OutfitTable");
    }

    public void a(Engine engine) {
        ((Array)((Object)this.var_aym_a)).clear();
        Engine.a("OUTFIT NUM: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g());
        TextureAtlas textureAtlas = this.var_axm_a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                aym aym2 = this.a(engine, textureAtlas, abi.var_abi_a, 1);
                aym aym3 = this.a(engine, textureAtlas, abi.k, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym2);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym3);
                }
                this.b(aym2);
                this.b(aym3);
                break;
            }
            case CHAMPION: {
                aym aym4 = this.a(engine, textureAtlas, abi.b, 1);
                aym aym5 = this.a(engine, textureAtlas, abi.l, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym4);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym5);
                }
                this.b(aym4);
                this.b(aym5);
                break;
            }
            case ELDER: {
                aym aym6 = this.a(engine, textureAtlas, abi.c, 1);
                aym aym7 = this.a(engine, textureAtlas, abi.m, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym6);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym7);
                }
                this.b(aym6);
                this.b(aym7);
                break;
            }
            case PALADIN: {
                aym aym8 = this.a(engine, textureAtlas, abi.g, 1);
                aym aym9 = this.a(engine, textureAtlas, abi.r, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym8);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym9);
                }
                this.b(aym8);
                this.b(aym9);
                break;
            }
            case LICH: {
                aym aym10 = this.a(engine, textureAtlas, abi.d, 1);
                aym aym11 = this.a(engine, textureAtlas, abi.n, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym10);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym11);
                }
                this.b(aym10);
                this.b(aym11);
                break;
            }
            case SCHOLAR: {
                aym aym12 = this.a(engine, textureAtlas, abi.i, 1);
                aym aym13 = this.a(engine, textureAtlas, abi.t, 2);
                aym aym14 = this.a(engine, textureAtlas, abi.u, 3);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym12);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym13);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 3) {
                    this.a(aym14);
                }
                this.b(aym12);
                this.b(aym13);
                this.b(aym14);
                break;
            }
            case NIHILIST: {
                aym aym15 = this.a(engine, textureAtlas, abi.f, 1);
                aym aym16 = this.a(engine, textureAtlas, abi.q, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym15);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym16);
                }
                this.b(aym15);
                this.b(aym16);
                break;
            }
            case MYSTIC: {
                aym aym17 = this.a(engine, textureAtlas, abi.e, 1);
                aym aym18 = this.a(engine, textureAtlas, abi.p, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym17);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym18);
                }
                this.b(aym17);
                this.b(aym18);
                break;
            }
            case RANGER: {
                aym aym19 = this.a(engine, textureAtlas, abi.h, 1);
                aym aym20 = this.a(engine, textureAtlas, abi.s, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym19);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym20);
                }
                this.b(aym19);
                this.b(aym20);
                break;
            }
            case WIZARD: {
                aym aym21 = this.a(engine, textureAtlas, abi.j, 1);
                aym aym22 = this.a(engine, textureAtlas, abi.v, 2);
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 1) {
                    this.a(aym21);
                } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_g() == 2) {
                    this.a(aym22);
                }
                this.b(aym21);
                this.b(aym22);
                break;
            }
        }
    }

    private void a(aym aym2) {
        if (this.var_aym_a != null) {
            this.var_aym_a.a(false);
        }
        this.var_aym_a = aym2;
        aym2.a(true);
        this.d.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(683.0f, 892 - (aym2.int_a() + 1) * 25);
    }

    private aym a(Engine engine, TextureAtlas textureAtlas, abi abi2, int n2) {
        return new aym(engine, textureAtlas, abi2, n2);
    }

    private void b(aym aym2) {
        ((Array)((Object)this.var_aym_a)).add(aym2);
    }

    @Override
    public void b(float f2, Engine engine) {
        ((ayh)((Object)this.var_aym_a)).b(f2, engine);
        Iterator iterator = ((Array)((Object)this.var_aym_a)).iterator();
        while (iterator.hasNext()) {
            aym aym2 = (aym)iterator.next();
            aym2.b(f2, engine);
            boolean bl2 = aym2.int_a() >= this.b && aym2.int_a() <= this.var_aym_a;
            if (!bl2 || ay.ay_a().gd_a().a(aym2.abi_a())) continue;
            this.e.b(f2, engine, 679, 887 - (aym2.int_a() - this.b + 1) * 25);
        }
        if (this.var_aym_a != null) {
            this.d.b(f2, engine);
        }
    }

    public void a(int n2) {
        this.a((aym)((Array)((Object)this.var_aym_a)).get(n2 - 1));
    }
}

