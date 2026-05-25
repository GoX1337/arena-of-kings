/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.resources.Energy;
import com.arenaofkings.packets.gameserver.data.resources.Mana;
import com.arenaofkings.packets.gameserver.data.resources.Rage;
import com.arenaofkings.packets.gameserver.data.resources.Resource;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.badlogic.gdx.utils.Array;

public abstract class el {
    protected CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_a = new Array();
    protected String var_java_lang_String_a;
    protected int var_int_a;
    protected int var_int_b = (int)new Array();
    protected int var_int_c;
    protected int var_int_d = 1;
    protected db var_db_a;
    protected int var_int_e = 1;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n = 0;
    protected int o = 0;
    protected Array<ajw> var_com_badlogic_gdx_utils_Array_ajw__a;
    private Array<ajw> var_com_badlogic_gdx_utils_Array_ajw__b;
    private boolean var_boolean_e;
    protected dg var_dg_a;
    protected dg var_dg_b = new dg();
    protected de var_de_a = new de(dd.b);
    protected dg var_dg_c = new dg();
    protected double var_double_a;
    protected double var_double_b;
    protected Resource var_com_arenaofkings_packets_gameserver_data_resources_Resource_a;
    protected boolean var_boolean_a = true;
    protected boolean var_boolean_b = false;
    protected boolean var_boolean_c = false;
    protected gz var_gz_a;
    protected EffectManager var_com_arenaofkings_packets_gameserver_data_EffectManager_a;
    protected float var_float_a = 300.0f;
    protected ahs var_ahs_a;
    protected final HitCircle var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    protected cr var_cr_a;
    protected az var_az_a;
    protected bd var_bd_a;
    protected ajw var_ajw_a;
    protected ajw var_ajw_b;
    protected boolean var_boolean_d = false;
    protected aih var_aih_a = new aih(this);
    private Direction var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH;
    private float var_float_b = 0.0f;
    private float var_float_c = 0.0f;

    public el(CharacterClass characterClass) {
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a = new HitCircle();
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.setRadius(16);
        this.var_dg_a = new dg(characterClass, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1067.0, 1600.0, 1600.0, 0.0, 0.0, 0.0, 25.0, 10.0, 1600.0);
    }

    public void a(CharacterClass characterClass, int n2, int n3) {
        this.void_g();
        this.void_a();
        switch (characterClass) {
            case ASSASSIN: {
                this.b(n2, 10250);
                if (n3 == -1) {
                    this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = new Energy(100.0, 100.0);
                    break;
                }
                this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = new Energy(n3, n3);
                break;
            }
            case CHAMPION: {
                this.b(n2, 11750);
                if (n3 == -1) {
                    this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = new Rage(0.0, 100.0);
                    break;
                }
                this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = new Rage(0.0, n3);
                break;
            }
            case ELDER: {
                this.b(n2, 9750);
                this.a(n3, 4500);
                break;
            }
            case LICH: {
                this.b(n2, 9750);
                this.a(n3, 4500);
                break;
            }
            case MYSTIC: {
                this.b(n2, 9250);
                this.a(n3, 5000);
                break;
            }
            case NIHILIST: {
                this.b(n2, 10250);
                this.a(n3, 4750);
                break;
            }
            case PALADIN: {
                this.b(n2, 12000);
                this.a(n3, 4100);
                break;
            }
            case RANGER: {
                this.b(n2, 10500);
                if (n3 == -1) {
                    this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = new Energy(200.0, 200.0);
                    break;
                }
                this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = new Energy(n3, n3);
                break;
            }
            case SCHOLAR: {
                this.b(n2, 9500);
                this.a(n3, 5100);
                break;
            }
            case WIZARD: {
                this.b(n2, 9500);
                this.a(n3, 5650);
            }
        }
    }

    public void a(int n2, int n3) {
        this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a = n2 == -1 ? new Mana(n3, this.var_dg_c.dc_a(dw.class), this.var_dg_c.dc_a(dy.class)) : new Mana(n2, this.var_dg_c.dc_a(dw.class), this.var_dg_c.dc_a(dy.class), true);
    }

    public void b(int n2, int n3) {
        if (this instanceof eg) {
            this.b((double)n2);
            this.a((double)n2);
        }
        if (n2 == -1) {
            this.b(n3);
        } else {
            this.var_double_a = n2;
            this.var_double_b = n2;
        }
    }

    public void void_a() {
        this.var_dg_a.a(this.var_com_arenaofkings_packets_misc_CharacterClass_a);
        this.var_dg_a.a().get(di.class).void_a();
        this.var_dg_a.a().get(eb.class).void_a();
        this.var_dg_a.a().get(ds.class).void_a();
        this.var_dg_a.a().get(ee.class).void_a();
        Engine.b("calcAllAttributes 1");
        this.void_a(di.class);
        this.void_a(eb.class);
        this.void_a(ds.class);
        this.void_a(ee.class);
        Engine.b("calcAllAttributes 2");
        this.void_a(dj.class);
        Engine.b("calcAllAttributes 3");
        this.void_a(dk.class);
        this.void_a(dl.class);
        this.void_a(dm.class);
        this.void_a(dn.class);
        this.void_a(_do.class);
        this.void_a(dq.class);
        this.void_a(du.class);
        this.void_a(dv.class);
        this.void_a(dp.class);
        this.void_a(dw.class);
        this.void_a(dx.class);
        this.void_a(dy.class);
        this.void_a(ed.class);
        this.void_a(dt.class);
        this.void_a(dr.class);
        this.void_a(dz.class);
        Engine.b("calcAllAttributes out");
        Engine.b("Power value finalCalculated: " + this.int_b(dz.class));
    }

    private void void_g() {
        switch (this.var_com_arenaofkings_packets_misc_CharacterClass_a) {
            case RANGER: {
                this.var_dg_a.dc_a(dj.class).void_a(485.0);
                this.var_dg_a.dc_a(dv.class).void_a(330.0);
                break;
            }
            case ASSASSIN: {
                this.var_dg_a.dc_a(dj.class).void_a(485.0);
                this.var_dg_a.dc_a(dv.class).void_a(330.0);
                break;
            }
            case ELDER: {
                this.var_dg_a.dc_a(dj.class).void_a(485.0);
                this.var_dg_a.dc_a(dv.class).void_a(330.0);
                break;
            }
            case LICH: {
                this.var_dg_a.dc_a(dj.class).void_a(385.0);
                this.var_dg_a.dc_a(dv.class).void_a(380.0);
                break;
            }
            case SCHOLAR: {
                this.var_dg_a.dc_a(dj.class).void_a(385.0);
                this.var_dg_a.dc_a(dv.class).void_a(380.0);
                break;
            }
            case MYSTIC: {
                this.var_dg_a.dc_a(dj.class).void_a(385.0);
                this.var_dg_a.dc_a(dv.class).void_a(380.0);
                break;
            }
            case WIZARD: {
                this.var_dg_a.dc_a(dj.class).void_a(385.0);
                this.var_dg_a.dc_a(dv.class).void_a(380.0);
                break;
            }
            case PALADIN: {
                this.var_dg_a.dc_a(dj.class).void_a(660.0);
                this.var_dg_a.dc_a(dv.class).void_a(305.0);
                break;
            }
            case NIHILIST: {
                this.var_dg_a.dc_a(dj.class).void_a(485.0);
                this.var_dg_a.dc_a(dv.class).void_a(380.0);
                break;
            }
            case CHAMPION: {
                this.var_dg_a.dc_a(dj.class).void_a(585.0);
                this.var_dg_a.dc_a(dv.class).void_a(280.0);
            }
        }
    }

    public void void_a(Class<? extends dc> clazz) {
        Engine.b("calculateFinalAttribute in " + clazz.getName());
        Engine.b("1");
        dc dc2 = this.var_dg_c.dc_a(clazz);
        Engine.b("2");
        if (dc2 != null) {
            Engine.b("3");
            if (dc2 instanceof eb || dc2 instanceof di || dc2 instanceof ds || dc2 instanceof ee) {
                if (dc2 instanceof di) {
                    dc dc3;
                    Engine.b("Power calculation");
                    Engine.b("Agility calculated value: " + this.double_b(clazz) + " " + this.double_a(clazz));
                    dc2.void_a((this.double_a(clazz) + this.c(clazz)) * this.d(clazz));
                    dc2.void_a();
                    if (this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.ASSASSIN || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.CHAMPION || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.ELDER || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.RANGER) {
                        dc3 = this.var_dg_a.dc_a(dz.class);
                        dc3.b(dc2.double_a());
                        dc3.void_a();
                    }
                    dc3 = this.var_dg_a.dc_a(dj.class);
                    dc3.b(dc2.double_b() * 0.15);
                    dc dc4 = this.var_dg_a.dc_a(dm.class);
                    dc4.b(dc2.double_b() * 0.2);
                } else if (dc2 instanceof eb) {
                    dc dc5;
                    dc2.void_a((this.double_a(clazz) + this.c(clazz)) * this.d(clazz));
                    dc2.void_a();
                    if (this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.ASSASSIN || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.CHAMPION || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.LICH || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.NIHILIST || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.PALADIN || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.RANGER) {
                        dc5 = this.var_dg_a.dc_a(dz.class);
                        dc5.b(dc2.double_a());
                        dc5.void_a();
                    }
                    dc5 = this.var_dg_a.dc_a(dp.class);
                    dc5.b(dc2.double_b() * 2.0);
                } else if (dc2 instanceof ds) {
                    dc dc6;
                    dc2.void_a((this.double_a(clazz) + this.c(clazz)) * this.d(clazz));
                    dc2.void_a();
                    if (this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.LICH || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.MYSTIC || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.NIHILIST || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.SCHOLAR || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.WIZARD) {
                        dc6 = this.var_dg_a.dc_a(dz.class);
                        dc6.b(dc2.double_a());
                        dc6.void_a();
                    }
                    dc6 = this.var_dg_a.dc_a(dv.class);
                    dc6.b(dc2.double_b() * 0.1);
                    dc dc7 = this.var_dg_a.dc_a(dw.class);
                    dc7.b(dc2.double_b() * 1.0);
                    dc dc8 = this.var_dg_a.dc_a(dm.class);
                    dc8.b(dc2.double_b() * 0.2);
                } else if (dc2 instanceof ee) {
                    dc dc9;
                    dc2.void_a((this.double_a(clazz) + this.c(clazz)) * this.d(clazz));
                    dc2.void_a();
                    if (this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.ELDER || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.MYSTIC || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.PALADIN || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.SCHOLAR || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.WIZARD) {
                        dc9 = this.var_dg_a.dc_a(dz.class);
                        dc9.b(dc2.double_a());
                        dc9.void_a();
                    }
                    dc9 = this.var_dg_a.dc_a(dw.class);
                    dc9.b(dc2.double_b() * 2.0);
                    dc dc10 = this.var_dg_a.dc_a(dy.class);
                    dc10.b(dc2.double_b() * 0.1 / 5.0);
                }
            } else if (dc2 instanceof dw) {
                Engine.b("6");
                this.void_h();
                Engine.b("7");
            } else {
                Engine.b("8");
                dc2.void_a((this.double_a(clazz) + this.c(clazz)) * this.d(clazz));
                dc2.void_a();
                Engine.b("9");
            }
        }
        Engine.b("out");
    }

    private double double_a(Class<? extends dc> clazz) {
        return this.var_dg_a.double_a(clazz);
    }

    private double double_b(Class<? extends dc> clazz) {
        return this.var_dg_a.b(clazz);
    }

    private double c(Class<? extends dc> clazz) {
        return this.var_dg_b.double_a(clazz);
    }

    private double d(Class<? extends dc> clazz) {
        return this.var_de_a.a(clazz);
    }

    public int int_a(Class<? extends dc> clazz) {
        return (int)this.var_dg_c.double_a(clazz);
    }

    public int int_b(Class<? extends dc> clazz) {
        return (int)this.var_dg_c.b(clazz);
    }

    public float float_a(Class<? extends dc> clazz) {
        return (float)this.var_dg_c.b(clazz);
    }

    public double a(Class<? extends dc> clazz, double d2) {
        if (clazz == null) {
            return 0.0;
        }
        return (float)this.var_dg_c.dc_a(clazz).double_a(d2);
    }

    private void b(int n2) {
        dc dc2 = this.var_dg_c.dc_a(dp.class);
        if (dc2 != null) {
            dc2.void_a((this.double_a(dp.class) + this.c(dp.class)) * this.d(dp.class));
            dc2.void_a();
            this.var_double_b = (double)n2 + dc2.double_a();
            this.var_double_a = (double)n2 + dc2.double_a();
        }
    }

    private void void_h() {
        if (this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.ASSASSIN || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.CHAMPION || this.var_com_arenaofkings_packets_misc_CharacterClass_a == CharacterClass.RANGER) {
            return;
        }
        dc dc2 = this.var_dg_c.dc_a(dw.class);
        if (dc2 != null) {
            dc2.void_a((this.double_a(dw.class) + this.c(dw.class)) * this.d(dw.class));
            dc2.void_a();
            if (this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a != null) {
                ((Mana)this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a).setValues();
            }
        }
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public double double_a() {
        return this.var_double_a;
    }

    public Resource com_arenaofkings_packets_gameserver_data_resources_Resource_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a;
    }

    public HitCircle com_arenaofkings_packets_gameserver_data_HitCircle_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    }

    public cr cr_a() {
        return this.var_cr_a;
    }

    public void a(ahs ahs2) {
        this.var_ahs_a = ahs2;
    }

    public gz gz_a() {
        return this.var_gz_a;
    }

    public void a(gz gz2) {
        this.var_gz_a = gz2;
    }

    public int int_e() {
        return this.var_int_b;
    }

    public int int_f() {
        return this.n;
    }

    public double double_b() {
        return this.var_double_b;
    }

    public db db_a() {
        return this.var_db_a;
    }

    public CharacterClass com_arenaofkings_packets_misc_CharacterClass_a() {
        return this.var_com_arenaofkings_packets_misc_CharacterClass_a;
    }

    public void e(int n2) {
        this.var_int_a = n2;
    }

    public void f(int n2) {
        this.var_int_b = n2;
    }

    public void a(double d2) {
        this.var_double_a = d2;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
    }

    public void g(int n2) {
        this.var_int_d = n2;
    }

    public void b(double d2) {
        this.var_double_b = d2;
    }

    public void a(CharacterClass characterClass) {
        this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
    }

    public void void_b() {
        Engine.a("resetting lobby player dependencies. TEAM=" + (Object)((Object)this.var_db_a) + " OUTFIT=" + this.var_int_d + " JUSTLEFT: " + this.var_boolean_d);
        Engine.a("screenDep size: " + ((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).size);
        Engine.a("hehe 1");
        ((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).clear();
        if (!this.var_boolean_d) {
            this.void_j();
            this.var_boolean_e = true;
        }
        Engine.a("player dependencies have been set");
    }

    public void void_c() {
        Engine.a("resetting Play player dependencies. TEAM=" + (Object)((Object)this.var_db_a) + " OUTFIT=" + this.var_int_d + " JUSTLEFT: " + this.var_boolean_d);
        Engine.a("screenDep size pre: " + ((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).size);
        if (!this.var_boolean_d) {
            Engine.a("hehe 2");
            ((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).clear();
            this.void_j();
            this.void_d();
            this.void_i();
        }
        Engine.a("screenDep size post: " + ((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).size);
    }

    private void void_i() {
        switch (this.var_com_arenaofkings_packets_misc_CharacterClass_a) {
            case ASSASSIN: {
                this.var_ajw_a = ajw.jI;
                break;
            }
            case CHAMPION: {
                break;
            }
            case ELDER: {
                this.var_ajw_a = ajw.jJ;
                break;
            }
            case LICH: {
                this.var_ajw_a = ajw.jK;
                break;
            }
            case MYSTIC: {
                this.var_ajw_a = ajw.jL;
                break;
            }
            case NIHILIST: {
                this.var_ajw_a = ajw.jM;
                break;
            }
            case PALADIN: {
                this.var_ajw_a = ajw.jN;
                break;
            }
            case RANGER: {
                this.var_ajw_b = ajw.jO;
                this.var_ajw_a = ajw.jP;
                break;
            }
            case SCHOLAR: {
                this.var_ajw_a = ajw.jQ;
                break;
            }
            case WIZARD: {
                this.var_ajw_a = ajw.jR;
            }
        }
        if (this.var_ajw_b != null) {
            this.a(this.var_ajw_b);
        }
        if (this.var_ajw_a != null) {
            this.a(this.var_ajw_a);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void void_j() {
        block78: {
            Engine.a("in initIdleDependency()");
            Engine.a("character_class: " + (Object)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a) + " character_team: " + (Object)((Object)this.var_db_a) + " character_outfit: " + this.var_int_d);
            block0 : switch (this.var_com_arenaofkings_packets_misc_CharacterClass_a) {
                case ASSASSIN: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.D);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.H);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.F);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.J);
                        }
                    }
                    return;
                }
                case ELDER: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.L);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.P);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.N);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.R);
                        }
                    }
                    return;
                }
                case PALADIN: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.Z);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.ad);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.ab);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.af);
                        }
                    }
                    return;
                }
                case LICH: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.ah);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.al);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.ap);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aj);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.an);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.ar);
                        }
                    }
                    return;
                }
                case SCHOLAR: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.at);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.ax);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.aB);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.av);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.az);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.aD);
                        }
                    }
                    return;
                }
                case NIHILIST: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aF);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aJ);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aH);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aL);
                        }
                    }
                    return;
                }
                case MYSTIC: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aN);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aR);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aP);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aT);
                        }
                    }
                    return;
                }
                case RANGER: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aV);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aZ);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aX);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.bb);
                        }
                    }
                    return;
                }
                case CHAMPION: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bd);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.bh);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bf);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.bj);
                        }
                    }
                    return;
                }
                case WIZARD: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bl);
                                break block0;
                            }
                            if (this.var_int_d != 2) return;
                            this.a(ajw.bp);
                            break block78;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bn);
                                break block0;
                            }
                            if (this.var_int_d != 2) return;
                            this.a(ajw.br);
                        }
                    }
                }
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void void_d() {
        block78: {
            Engine.a("in initFullDependency()");
            Engine.a("character_class: " + (Object)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a) + " character_team: " + (Object)((Object)this.var_db_a) + " character_outfit: " + this.var_int_d);
            block0 : switch (this.var_com_arenaofkings_packets_misc_CharacterClass_a) {
                case ASSASSIN: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.C);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.G);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.E);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.I);
                        }
                    }
                    return;
                }
                case ELDER: {
                    this.a(ajw.V);
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.K);
                                this.a(ajw.S);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.O);
                            this.a(ajw.S);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.M);
                                this.a(ajw.T);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.Q);
                            this.a(ajw.T);
                        }
                    }
                    return;
                }
                case PALADIN: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.Y);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.ac);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aa);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.ae);
                        }
                    }
                    return;
                }
                case LICH: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.ag);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.ak);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.ao);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.ai);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.am);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.aq);
                        }
                    }
                    return;
                }
                case SCHOLAR: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.as);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.aw);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.aA);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.au);
                                return;
                            }
                            if (this.var_int_d == 2) {
                                this.a(ajw.ay);
                                return;
                            }
                            if (this.var_int_d != 3) break;
                            this.a(ajw.aC);
                        }
                    }
                    return;
                }
                case NIHILIST: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aE);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aI);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aG);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aK);
                        }
                    }
                    return;
                }
                case MYSTIC: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aM);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aQ);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aO);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aS);
                        }
                    }
                    return;
                }
                case RANGER: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aU);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.aY);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.aW);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.ba);
                        }
                    }
                    return;
                }
                case CHAMPION: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bc);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.bg);
                            return;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.be);
                                return;
                            }
                            if (this.var_int_d != 2) break;
                            this.a(ajw.bi);
                        }
                    }
                    return;
                }
                case WIZARD: {
                    switch (this.var_db_a) {
                        case b: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bk);
                                this.a(ajw.W);
                                break block0;
                            }
                            if (this.var_int_d != 2) return;
                            this.a(ajw.bo);
                            this.a(ajw.W);
                            break block78;
                        }
                        case var_db_a: {
                            if (this.var_int_d == 1) {
                                this.a(ajw.bm);
                                this.a(ajw.X);
                                break block0;
                            }
                            if (this.var_int_d != 2) return;
                            this.a(ajw.bq);
                            this.a(ajw.X);
                        }
                    }
                }
            }
        }
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public EffectManager com_arenaofkings_packets_gameserver_data_EffectManager_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a;
    }

    public aih aih_a() {
        return this.var_aih_a;
    }

    public ahs ahs_a() {
        return this.var_ahs_a;
    }

    public int int_g() {
        return this.var_int_d;
    }

    public Array<ajw> a() {
        return this.var_com_arenaofkings_packets_misc_CharacterClass_a;
    }

    public az az_a() {
        return this.var_az_a;
    }

    public void h(int n2) {
        if (this.var_int_b == 20) {
            return;
        }
        this.var_int_c += n2;
        if (eh.boolean_a(this.var_int_b, this.var_int_c)) {
            int n3 = eh.int_a(this.var_int_b, this.var_int_c);
            ++this.var_int_b;
            this.var_int_c = Math.abs(n3);
        }
    }

    public void a(Engine engine, boolean bl2) {
        this.var_bd_a = new bd(engine, this, this.var_cr_a, bl2);
    }

    public bd bd_a() {
        return this.var_bd_a;
    }

    public int int_h() {
        return this.var_int_e;
    }

    public void void_a(int n2) {
        this.var_int_e = n2;
    }

    public void void_e() {
        this.a(this.double_b());
    }

    public void void_f() {
        if (this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a instanceof Rage) {
            this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a.setCurrentValue(0.0);
        } else {
            this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a.setCurrentValue(this.var_com_arenaofkings_packets_gameserver_data_resources_Resource_a.getMaxValue());
        }
    }

    public ajw ajw_a() {
        return this.var_ajw_a;
    }

    public ajw ajw_b() {
        return this.var_ajw_b;
    }

    public abi abi_a() {
        return this.var_bd_a.abi_a();
    }

    public abi abi_b() {
        return this.var_bd_a.abi_b();
    }

    public abi abi_c() {
        return this.var_bd_a.abi_c();
    }

    public ProfileBackgrounds com_arenaofkings_packets_misc_ProfileBackgrounds_a() {
        return this.var_bd_a.com_arenaofkings_packets_misc_ProfileBackgrounds_a();
    }

    public void a(ProfileBackgrounds profileBackgrounds) {
        if (this.var_bd_a != null) {
            this.var_bd_a.a(profileBackgrounds);
        }
    }

    public void a(abi abi2, int n2) {
        if (abi2 != null) {
            this.var_bd_a.a(abi2, n2);
        } else {
            Engine.a("DIDN'T SET NULL PROFILE EFFECT " + abi2 + " " + n2);
        }
    }

    public void b(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void c(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public int int_i() {
        return this.f;
    }

    public void i(int n2) {
        this.f = n2;
    }

    public boolean boolean_b() {
        return this.var_boolean_b;
    }

    public boolean boolean_c() {
        return this.var_boolean_c;
    }

    public void a(ajw ajw2) {
        if (ajw2 != null) {
            if (!((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).contains(ajw2, true)) {
                ((Array)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a)).add(ajw2);
            }
            if (!this.var_int_b.contains(ajw2, true)) {
                this.var_int_b.add(ajw2);
            }
        } else {
            Engine.a("[ERROR] didn't add a null screen dependency");
        }
    }

    public void d(boolean bl2) {
        this.var_boolean_d = bl2;
    }

    public int int_j() {
        return this.g;
    }

    public void j(int n2) {
        this.g = n2;
    }

    public int k() {
        return this.h;
    }

    public void k(int n2) {
        this.h = n2;
    }

    public void l(int n2) {
        this.j = n2;
    }

    public void m(int n2) {
        this.i = n2;
    }

    public void n(int n2) {
        this.k = n2;
    }

    public void o(int n2) {
        this.l = n2;
    }

    public void p(int n2) {
        this.m = n2;
    }

    public int l() {
        return this.m;
    }

    public boolean boolean_d() {
        return this.k + this.l < 10;
    }
}

