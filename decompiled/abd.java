/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_KEYBIND_UPDATE;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ObjectMap;

public class abd
extends abc {
    protected final Engine var_com_arenaofkings_client_core_Engine_a = new ObjectMap();
    protected final agc var_agc_a;
    protected final axm var_axm_a;
    protected final Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    protected boolean var_boolean_a = true;
    protected ayh var_ayh_a;
    protected ayh var_ayh_b;
    protected ayh var_ayh_c;
    private ObjectMap<agb, aax> cfr_renamed_2;
    private aax var_aax_a;
    private aax var_aax_b;
    private aax var_aax_c;
    private aax d;
    private aax e;
    private aax f;
    private aax g;
    private aax h;
    private aax i;
    private aax j;
    private aax k;
    private aax l;
    private aax m;
    private aax n;
    private aax o;
    private aax p;
    private aax q;
    private aax r;
    private aax s;
    private aax t;
    private aax u;
    private aax v;
    private aax w;
    private aax x;

    public abd(Engine engine, axm axm2, Stage stage, boolean bl2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_agc_a = engine.var_agc_a;
        this.var_axm_a = axm2;
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = stage;
        this.var_boolean_a = bl2;
        this.a();
    }

    @Override
    protected void a() {
        int n2 = 18;
        int n3 = -13;
        TextureAtlas textureAtlas = this.var_axm_a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.var_ayh_a = new ayh(611 + n2, n3 + 770, textureAtlas, "hotkey_ability_backdrop", true);
        this.var_ayh_b = new ayh(611 + n2, n3 + 580, textureAtlas, "hotkey_movement_backdrop", true);
        this.var_ayh_c = new ayh(611 + n2, n3 + 390, textureAtlas, "hotkey_targeting_backdrop", true);
        this.var_aax_a = new aax(textureAtlas, 639 + n2, n3 + 800);
        this.var_aax_b = new aax(textureAtlas, 722 + n2, n3 + 800);
        this.var_aax_c = new aax(textureAtlas, 805 + n2, n3 + 800);
        this.d = new aax(textureAtlas, 888 + n2, n3 + 800);
        this.e = new aax(textureAtlas, 971 + n2, n3 + 800);
        this.f = new aax(textureAtlas, 1054 + n2, n3 + 800);
        this.g = new aax(textureAtlas, 1137 + n2, n3 + 800);
        this.h = new aax(textureAtlas, 1220 + n2, n3 + 800);
        this.i = new aax(textureAtlas, 1303 + n2, n3 + 800);
        this.k = new aax(textureAtlas, 636 + n2, n3 + 610);
        this.l = new aax(textureAtlas, 755 + n2, n3 + 610);
        this.n = new aax(textureAtlas, 871 + n2, n3 + 610);
        this.m = new aax(textureAtlas, 993 + n2, n3 + 610);
        this.w = new aax(textureAtlas, 1174 + n2, n3 + 610);
        this.x = new aax(textureAtlas, 1290 + n2, n3 + 610);
        this.j = new aax(textureAtlas, 1400 + n2, n3 + 610);
        this.o = new aax(textureAtlas, 636 + n2, n3 + 420);
        this.p = new aax(textureAtlas, 787 + n2, n3 + 420);
        this.q = new aax(textureAtlas, 923 + n2, n3 + 420);
        this.r = new aax(textureAtlas, 1010 + n2, n3 + 420);
        this.s = new aax(textureAtlas, 1100 + n2, n3 + 420);
        this.t = new aax(textureAtlas, 1204 + n2, n3 + 420);
        this.u = new aax(textureAtlas, 1305 + n2, n3 + 420);
        this.v = new aax(textureAtlas, 1405 + n2, n3 + 420);
        this.a(this.var_aax_a, InputIdentifier.BASIC);
        this.a(this.var_aax_b, InputIdentifier.ABILITY_1);
        this.a(this.var_aax_c, InputIdentifier.ABILITY_2);
        this.a(this.d, InputIdentifier.ABILITY_3);
        this.a(this.e, InputIdentifier.ABILITY_4);
        this.a(this.f, InputIdentifier.ABILITY_5);
        this.a(this.g, InputIdentifier.ABILITY_6);
        this.a(this.h, InputIdentifier.ABILITY_7);
        this.a(this.i, InputIdentifier.ABILITY_8);
        this.a(this.j, InputIdentifier.TRINKET_1);
        this.a(this.k, InputIdentifier.MOVE_NORTH);
        this.a(this.l, InputIdentifier.MOVE_SOUTH);
        this.a(this.n, InputIdentifier.MOVE_WEST);
        this.a(this.m, InputIdentifier.MOVE_EAST);
        this.a(this.w, InputIdentifier.SELF_INTERRUPT);
        this.a(this.x, InputIdentifier.MEDITATE);
        this.a(this.o, InputIdentifier.TARGET_TAB);
        this.a(this.p, InputIdentifier.TARGET_NEAREST_ENEMY);
        this.a(this.q, InputIdentifier.TARGET_SELF);
        this.a(this.r, InputIdentifier.TARGET_ALLY_2);
        this.a(this.s, InputIdentifier.TARGET_ALLY_3);
        this.a(this.t, InputIdentifier.TARGET_ENEMY_1);
        this.a(this.u, InputIdentifier.TARGET_ENEMY_2);
        this.a(this.v, InputIdentifier.TARGET_ENEMY_3);
    }

    public void a(aax aax2, InputIdentifier inputIdentifier) {
        if (this.var_agc_a.a().get(inputIdentifier) != null) {
            if (((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).containsKey(this.var_agc_a.a().get(inputIdentifier))) {
                ((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).remove(this.var_agc_a.a().get(inputIdentifier));
            }
            if (this.var_agc_a.a().get(inputIdentifier).int_a() != 0) {
                ((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(this.var_agc_a.a().get(inputIdentifier), aax2);
                aax2.var_com_arenaofkings_packets_misc_InputIdentifier_a = inputIdentifier;
                Engine.a("loaded keybind into map");
            }
        } else {
            Engine.a("loadKeybind(): " + (Object)((Object)inputIdentifier) + " not yet implemented");
        }
    }

    @Override
    public void a(float f2, Engine engine) {
        for (ObjectMap.Entry entry : ((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).entries()) {
            ((aax)entry.value).a(f2, engine);
        }
    }

    public boolean a(int n2) {
        boolean bl2 = false;
        if (n2 != 0) {
            for (ObjectMap.Entry entry : ((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).entries()) {
                if (bl2 || n2 == 111 || !((aax)entry.value).var_boolean_a) continue;
                this.a((aax)entry.value, ((aax)entry.value).var_com_arenaofkings_packets_misc_InputIdentifier_a);
                this.var_agc_a.a(n2, (agb)entry.key, ((aax)entry.value).var_com_arenaofkings_packets_misc_InputIdentifier_a);
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean b(int n2) {
        Engine.a("hi");
        if (this.var_boolean_a) {
            Engine.a("key pressed : " + n2);
            boolean bl2 = false;
            if (n2 != 0 && n2 != 37) {
                System.out.println("Valid key: " + n2);
                for (ObjectMap.Entry entry : ((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).entries()) {
                    if (!bl2 && n2 != 111) {
                        if (!((aax)entry.value).var_boolean_a) continue;
                        this.a((aax)entry.value, ((aax)entry.value).var_com_arenaofkings_packets_misc_InputIdentifier_a);
                        this.var_agc_a.a(n2, (agb)entry.key, ((aax)entry.value).var_com_arenaofkings_packets_misc_InputIdentifier_a);
                        this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(new PUB_KEYBIND_UPDATE(((aax)entry.value).var_com_arenaofkings_packets_misc_InputIdentifier_a, n2));
                        ((aax)entry.value).var_boolean_a = false;
                        bl2 = true;
                        continue;
                    }
                    ((aax)entry.value).var_boolean_a = false;
                }
            }
            return bl2;
        }
        return false;
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_a) {
            this.a(f2, engine);
            this.var_ayh_a.b(f2, engine);
            this.var_ayh_b.b(f2, engine);
            this.var_ayh_c.b(f2, engine);
            for (ObjectMap.Entry entry : ((ObjectMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).entries()) {
                ((aax)entry.value).a(f2, engine, ((agb)entry.key).int_a());
            }
        }
    }
}

