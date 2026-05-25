/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StoreItemContent;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public abstract class abg
implements axr {
    protected StoreItemContent var_com_arenaofkings_packets_misc_StoreItemContent_a = new Array();
    protected String var_java_lang_String_a = "";
    protected String var_java_lang_String_b = "";
    protected String var_java_lang_String_c = "";
    protected String d = "";
    protected Array<axr> var_com_badlogic_gdx_utils_Array_axr__a;
    protected ayh var_ayh_a;
    protected azs var_azs_a;
    protected abe var_abe_a;
    protected yo var_yo_a;
    private int var_int_a;
    private int var_int_b;
    protected yt var_yt_a;
    private int var_int_c = 0;

    public abg(Engine engine, StoreItemContent storeItemContent, axm axm2, abe abe2, yo yo2, yt yt2, azs azs2) {
        this.var_com_arenaofkings_packets_misc_StoreItemContent_a = storeItemContent;
        this.var_abe_a = abe2;
        this.var_yo_a = yo2;
        this.var_yt_a = yt2;
        if (azs2 != null) {
            this.a(engine, axm2, azs2);
        }
    }

    public void a(Engine engine, axm axm2, azs azs2) {
        if (this.var_yo_a == yo.b) {
            switch (this.var_yt_a) {
                case var_yt_a: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_uncommon_large"));
                    break;
                }
                case c: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_epic_large"));
                    break;
                }
                case b: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_rare_large"));
                    break;
                }
                case d: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_legendary_large"));
                    break;
                }
                default: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_uncommon_large"));
                }
            }
            this.a((axr)this.var_ayh_a);
            this.var_int_a = 50;
            this.var_int_b = 30;
        }
        if (this.var_yo_a == yo.c) {
            switch (this.var_yt_a) {
                case var_yt_a: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_uncommon_small"));
                    break;
                }
                case c: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_epic_small"));
                    break;
                }
                case b: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_rare_small"));
                    break;
                }
                case d: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_legendary_small"));
                    break;
                }
                default: {
                    this.var_ayh_a = new ayh(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b).createSprite("item_frame_uncommon_small"));
                }
            }
            this.a((axr)this.var_ayh_a);
            this.var_int_a = 0;
            this.var_int_b = 0;
        }
        this.var_azs_a = azs2 == null ? new azx(engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.x, false, true) : azs2;
    }

    public void a(axr axr2) {
        ((Array)((Object)this.var_com_arenaofkings_packets_misc_StoreItemContent_a)).add(axr2);
    }

    public void a(Engine engine, ajw ajw2, axr axr2) {
        this.a(axr2);
    }

    public void a(azs azs2) {
        switch (this.var_yo_a) {
            case b: {
                switch (this.var_abe_a) {
                    case var_abe_a: {
                        azs2.a(780, 680);
                        break;
                    }
                    case var_abe_b: {
                        break;
                    }
                    case c: {
                        azs2.a(1185, 680);
                        break;
                    }
                    case d: {
                        if (this.var_yo_a == yo.b) {
                            azs2.a(780, 400);
                            break;
                        }
                        azs2.a(780, 460);
                        break;
                    }
                    case e: {
                        break;
                    }
                    case f: {
                        if (this.var_yo_a == yo.b) {
                            azs2.a(1185, 400);
                            break;
                        }
                        azs2.a(1185, 460);
                    }
                }
                break;
            }
            case c: {
                switch (this.var_abe_a) {
                    case var_abe_a: {
                        azs2.a(725, 670);
                        break;
                    }
                    case var_abe_b: {
                        azs2.a(1000, 670);
                        break;
                    }
                    case c: {
                        azs2.a(1275, 670);
                        break;
                    }
                    case d: {
                        azs2.a(725, 397);
                        break;
                    }
                    case e: {
                        azs2.a(1000, 397);
                        break;
                    }
                    case f: {
                        azs2.a(1275, 397);
                    }
                }
                break;
            }
            case var_yo_a: {
                break;
            }
        }
    }

    public void a(ayh ayh2) {
        switch (this.var_yo_a) {
            case b: {
                switch (this.var_abe_a) {
                    case var_abe_a: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(700.0f, 680.0f);
                        break;
                    }
                    case var_abe_b: {
                        break;
                    }
                    case c: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1105.0f, 680.0f);
                        break;
                    }
                    case d: {
                        if (this.var_yo_a == yo.b) {
                            ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(700.0f, 400.0f);
                            break;
                        }
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(700.0f, 460.0f);
                        break;
                    }
                    case e: {
                        break;
                    }
                    case f: {
                        if (this.var_yo_a == yo.b) {
                            ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1105.0f, 400.0f);
                            break;
                        }
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1105.0f, 460.0f);
                    }
                }
                break;
            }
            case c: {
                switch (this.var_abe_a) {
                    case var_abe_a: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(695.0f, 675.0f);
                        break;
                    }
                    case var_abe_b: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(970.0f, 675.0f);
                        break;
                    }
                    case c: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1245.0f, 675.0f);
                        break;
                    }
                    case d: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(695.0f, 405.0f);
                        break;
                    }
                    case e: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(970.0f, 405.0f);
                        break;
                    }
                    case f: {
                        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1245.0f, 405.0f);
                    }
                }
                break;
            }
            case var_yo_a: {
                break;
            }
        }
    }

    public void a(da da2) {
        int n2 = 0;
        int n3 = 0;
        if (this.var_yo_a == yo.c) {
            n2 = 45;
            n3 = 0;
        } else if (this.var_yo_a == yo.b) {
            n2 = 45;
            n3 = 0;
        }
        switch (this.var_yo_a) {
            case b: {
                switch (this.var_abe_a) {
                    case var_abe_a: {
                        da2.a((float)(680 + n2), 680 + n3);
                        break;
                    }
                    case c: {
                        da2.a((float)(1105 + n2), 680 + n3);
                        break;
                    }
                    case d: {
                        da2.a((float)(680 + n2), 405 + n3);
                        break;
                    }
                    case f: {
                        da2.a((float)(1105 + n2), 405 + n3);
                    }
                }
                break;
            }
            case c: {
                switch (this.var_abe_a) {
                    case var_abe_a: {
                        da2.a((float)(675 + n2), 715 + n3);
                        break;
                    }
                    case var_abe_b: {
                        da2.a((float)(950 + n2), 715 + n3);
                        break;
                    }
                    case c: {
                        da2.a((float)(1225 + n2), 715 + n3);
                        break;
                    }
                    case d: {
                        da2.a((float)(675 + n2), 460 + n3);
                        break;
                    }
                    case e: {
                        da2.a((float)(950 + n2), 460 + n3);
                        break;
                    }
                    case f: {
                        da2.a((float)(1225 + n2), 460 + n3);
                    }
                }
                break;
            }
            case var_yo_a: {
                break;
            }
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    public void a(float f2, Engine engine, int n2, int n3) {
        Iterator iterator = ((Array)((Object)this.var_com_arenaofkings_packets_misc_StoreItemContent_a)).iterator();
        while (iterator.hasNext()) {
            axr axr2;
            axr axr3 = (axr)iterator.next();
            if (axr3 instanceof ayh) {
                axr2 = (ayh)axr3;
                ((ayh)axr2).com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
                ((ayh)axr2).b(f2, engine);
                continue;
            }
            if (!(axr3 instanceof da)) continue;
            axr2 = (da)axr3;
            ((da)axr2).a((float)n2, n3);
            ((da)axr2).b(f2, engine);
        }
        axe cfr_ignored_0 = engine.var_axe_a;
        engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), axe.y, engine.var_axy_c.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 190), 1, 1);
        if (((Array)((Object)this.var_com_arenaofkings_packets_misc_StoreItemContent_a)).size > 1) {
            if (this.var_java_lang_String_b != "") {
                axe cfr_ignored_1 = engine.var_axe_a;
                engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 185), 1, 1);
            }
            if (this.var_java_lang_String_c != "") {
                axe cfr_ignored_2 = engine.var_axe_a;
                engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 160), 1, 1);
            }
        } else if (this.d == "") {
            if (this.var_java_lang_String_b != "") {
                axe cfr_ignored_3 = engine.var_axe_a;
                engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 160), 1, 1);
            }
            if (this.var_java_lang_String_c != "") {
                axe cfr_ignored_4 = engine.var_axe_a;
                engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 140), 1, 1);
            }
        } else {
            if (this.var_java_lang_String_b != "") {
                axe cfr_ignored_5 = engine.var_axe_a;
                engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 145), 1, 1);
            }
            if (this.var_java_lang_String_c != "") {
                axe cfr_ignored_6 = engine.var_axe_a;
                engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.x, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 145), 1, 1);
            }
            if (this.d != "") {
                axe cfr_ignored_7 = engine.var_axe_a;
                engine.a(this.d, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + this.var_int_a + 145), (float)(n3 + this.var_int_b + 105), 1, 1);
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        Iterator iterator = ((Array)((Object)this.var_com_arenaofkings_packets_misc_StoreItemContent_a)).iterator();
        while (iterator.hasNext()) {
            axr axr2;
            axr axr3 = (axr)iterator.next();
            if (axr3 instanceof ayh) {
                axr2 = (ayh)axr3;
                this.a((ayh)axr2);
                ((ayh)axr2).b(f2, engine);
                continue;
            }
            if (!(axr3 instanceof da)) continue;
            axr2 = (da)axr3;
            if (((da)axr2).boolean_a()) {
                this.a((da)axr2);
                ((da)axr2).b(f2, engine);
            }
            if (this.var_com_arenaofkings_packets_misc_StoreItemContent_a != abi.Q || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().cr_a().da_a() == null) continue;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().cr_a().da_a().b(f2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 182.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 60.0f, engine.var_azi_a);
        }
        if (this.var_azs_a != null) {
            this.a(this.var_azs_a);
            this.var_azs_a.a(f2, engine);
            this.var_azs_a.b(f2, engine);
        }
        if (this.var_yo_a == yo.b) {
            engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 250.0f, 1, 1);
            if (((Array)((Object)this.var_com_arenaofkings_packets_misc_StoreItemContent_a)).size > 1) {
                if (this.var_java_lang_String_b != "") {
                    engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 237.0f, 1, 1);
                }
                if (this.var_java_lang_String_c != "") {
                    engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 217.0f, 1, 1);
                }
            } else if (this.d == "") {
                if (this.var_java_lang_String_b != "") {
                    axe cfr_ignored_0 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 175.0f, 1, 1);
                }
                if (this.var_java_lang_String_c != "") {
                    axe cfr_ignored_1 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 155.0f, 1, 1);
                }
            } else {
                if (this.var_java_lang_String_b != "") {
                    axe cfr_ignored_2 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 175.0f, 1, 1);
                }
                if (this.var_java_lang_String_c != "") {
                    axe cfr_ignored_3 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.x, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 155.0f, 1, 1);
                }
                if (this.d != "") {
                    axe cfr_ignored_4 = engine.var_axe_a;
                    engine.a(this.d, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 190.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 135.0f, 1, 1);
                }
            }
        } else if (this.var_yo_a == yo.c) {
            engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 232.0f, 1, 1);
            if (((Array)((Object)this.var_com_arenaofkings_packets_misc_StoreItemContent_a)).size > 2) {
                if (this.var_java_lang_String_b != "") {
                    axe cfr_ignored_5 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 216.0f, 1, 1);
                }
                if (this.var_java_lang_String_c != "") {
                    axe cfr_ignored_6 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 196.0f, 1, 1);
                }
            } else if (this.d == "") {
                if (abe.a(this.var_abe_a) >= 3) {
                    this.var_int_c = -8;
                }
                if (this.var_java_lang_String_b != "") {
                    engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 94.0f + (float)this.var_int_c, 1, 1);
                }
                if (this.var_java_lang_String_c != "") {
                    engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 78.0f + (float)this.var_int_c, 1, 1);
                }
            } else {
                if (this.var_java_lang_String_b != "") {
                    axe cfr_ignored_7 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_b, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 186.0f, 1, 1);
                }
                if (this.var_java_lang_String_c != "") {
                    axe cfr_ignored_8 = engine.var_axe_a;
                    engine.a(this.var_java_lang_String_c, engine.var_axy_b.a(), axe.x, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 166.0f, 1, 1);
                }
                if (this.d != "") {
                    axe cfr_ignored_9 = engine.var_axe_a;
                    engine.a(this.d, engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, this.var_abe_a.var_float_a + (float)this.var_int_a + 145.0f, this.var_abe_a.var_float_b + (float)this.var_int_b + 146.0f, 1, 1);
                }
            }
        }
    }

    public void a(abe abe2) {
        this.var_abe_a = abe2;
    }
}

