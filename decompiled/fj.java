/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class fj
implements axr {
    private fm var_fm_a;
    private int var_int_a;
    private da var_da_a;
    private azv var_azv_a;
    private boolean var_boolean_a = false;
    private boolean var_boolean_b = false;
    private boolean var_boolean_c = false;
    private int var_int_b = 0;
    private int var_int_c = 0;
    private final int var_int_d = 74;
    private final int e = 68;
    private ft var_ft_a;
    private ft var_ft_b;
    private ayg var_ayg_a;
    private String var_java_lang_String_a;
    private boolean var_boolean_d;

    public fj(Engine engine, fm fm2, String string, int n2, int n3, int n4) {
        this.var_fm_a = fm2;
        this.var_int_a = n2;
        this.var_java_lang_String_a = string;
        this.var_boolean_d = string.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a());
        this.var_fm_a.var_com_arenaofkings_packets_misc_items_ItemLocation_a = ItemLocation.GROUND;
        this.var_fm_a.e = n3;
        this.var_fm_a.f = n4;
        this.var_azv_a = new azv(525L, true);
        if (fm2.fp_a() != null) {
            this.var_int_b = azu.a(engine, engine.j, fm2.fp_a().java_lang_String_a()) + 8;
            this.var_int_c = azu.b(engine, engine.j, fm2.fp_a().java_lang_String_a()) + 4;
            this.var_ft_a = new ft(n3 + 74, n4 + 68);
            this.var_ft_b = new ft(n3 + 74 + this.var_int_b, n4 + 68 + this.var_int_c);
            this.var_ayg_a = new fk(this, this.var_ft_a.a - this.var_int_b / 2, this.var_ft_a.b, this.var_ft_b.a - this.var_int_b / 2, this.var_ft_b.b, n2, string, engine);
        }
        engine.var_baa_a.a(ajw.ka, 0.5f);
        if (fm2.com_arenaofkings_packets_misc_items_ItemRarity_a() != null) {
            switch (fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()) {
                case COMMON: {
                    this.var_da_a = new da(ajw.iX, "common_bag", 11, 0.05f, 0.0f, Animation.PlayMode.NORMAL, 0, 0);
                    break;
                }
                case EPIC: {
                    this.var_da_a = new da(ajw.ja, "epic_bag", 11, 0.05f, 0.0f, Animation.PlayMode.NORMAL, 0, 0);
                    break;
                }
                case LEGENDARY: {
                    this.var_da_a = new da(ajw.jb, "legendary_bag", 11, 0.05f, 0.0f, Animation.PlayMode.NORMAL, 0, 0);
                    break;
                }
                case RARE: {
                    this.var_da_a = new da(ajw.iZ, "rare_bag", 11, 0.05f, 0.0f, Animation.PlayMode.NORMAL, 0, 0);
                    break;
                }
                case UNCOMMON: {
                    this.var_da_a = new da(ajw.iY, "uncommon_bag", 11, 0.05f, 0.0f, Animation.PlayMode.NORMAL, 0, 0);
                    break;
                }
                case UNIQUE: {
                    this.var_da_a = new da(ajw.jb, "legendary_bag", 11, 0.05f, 0.0f, Animation.PlayMode.NORMAL, 0, 0);
                    break;
                }
                default: {
                    return;
                }
            }
            if (this.var_da_a != null) {
                this.var_da_a.a((float)n3, n4);
            }
            this.var_da_a.a(((agd)engine.axc_a()).axm_a(), false, false);
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_da_a != null) {
            this.var_da_a.b(f2, engine);
            this.var_ayg_a.b(engine);
            if (this.var_azv_a.boolean_b()) {
                if (!this.var_boolean_a) {
                    this.var_boolean_a = true;
                    this.var_boolean_c = true;
                    Engine.b("Play item drop sounds");
                    if (this.var_fm_a instanceof fh) {
                        Engine.b("sending sound: " + (Object)((Object)this.var_fm_a.ajw_a()));
                        engine.var_baa_a.a(this.var_fm_a.ajw_a(), this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a());
                    }
                    if (this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a() == ItemRarity.RARE) {
                        engine.var_baa_a.a(ajw.kq, this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a());
                    } else if (this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a() == ItemRarity.EPIC) {
                        engine.var_baa_a.a(ajw.kr, this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a());
                    } else if (this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a() == ItemRarity.LEGENDARY) {
                        engine.var_baa_a.a(ajw.ks, this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a());
                    }
                }
                if (!this.var_boolean_b || this.var_boolean_c) {
                    // empty if block
                }
            }
        }
    }

    public void c(float f2, Engine engine) {
        if (!this.var_boolean_a) {
            return;
        }
        if (!this.b()) {
            engine.var_axf_a.d(this.var_ft_a.a - this.var_int_b / 2, this.var_ft_a.b, this.var_int_b, this.var_int_c + 1, 10.0f);
        } else {
            engine.var_axf_a.a(this.boolean_a(), (float)(this.var_ft_a.a - this.var_int_b / 2), (float)this.var_ft_a.b, (float)this.var_int_b, (float)(this.var_int_c + 1), 10.0f);
        }
    }

    public void d(float f2, Engine engine) {
        if (!this.var_boolean_a) {
            return;
        }
        switch (this.var_fm_a.com_arenaofkings_packets_misc_items_ItemRarity_a()) {
            case COMMON: {
                if (this.var_boolean_d) {
                    engine.a("[RARITY_COMMON]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                    break;
                }
                engine.a("[RARITY_COMMON_FADED]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                break;
            }
            case UNCOMMON: {
                if (this.var_boolean_d) {
                    engine.a("[RARITY_UNCOMMON]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                    break;
                }
                engine.a("[RARITY_UNCOMMON_FADED]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                break;
            }
            case RARE: {
                if (this.var_boolean_d) {
                    engine.a("[RARITY_RARE]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                    break;
                }
                engine.a("[RARITY_RARE_FADED]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                break;
            }
            case EPIC: {
                if (this.var_boolean_d) {
                    engine.a("[RARITY_EPIC]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                    break;
                }
                engine.a("[RARITY_EPIC_FADED]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                break;
            }
            case LEGENDARY: {
                if (this.var_boolean_d) {
                    engine.a("[RARITY_LEGENDARY]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                    break;
                }
                engine.a("[RARITY_LEGENDARY_FADED]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                break;
            }
            case UNIQUE: {
                if (this.var_boolean_d) {
                    engine.a("[RARITY_ANCIENT]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                    break;
                }
                engine.a("[RARITY_ANCIENT_FADED]" + this.var_fm_a.fp_a().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ft_a.a, this.var_ft_a.b + (this.var_int_c - 2), 1);
                break;
            }
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_d && this.var_ayg_a.boolean_e();
    }

    public boolean b() {
        return this.var_boolean_d;
    }

    public fm fm_a() {
        return this.var_fm_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    static /* synthetic */ da da_a(fj fj2) {
        return fj2.var_da_a;
    }

    static /* synthetic */ azv azv_a(fj fj2) {
        return fj2.var_azv_a;
    }

    static /* synthetic */ boolean a(fj fj2, boolean bl2) {
        fj2.var_boolean_a = bl2;
        return fj2.var_boolean_a;
    }
}

