/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PlayerStatus;
import com.arenaofkings.packets.misc.RelationshipStatus;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import java.util.Locale;

public class ayq
implements axr,
Comparable<ayq> {
    private ayf var_ayf_a;
    private Table var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    private int var_int_a;
    protected String var_java_lang_String_a;
    protected String var_java_lang_String_b;
    protected PlayerStatus var_com_arenaofkings_packets_misc_PlayerStatus_a;
    protected RelationshipStatus var_com_arenaofkings_packets_misc_RelationshipStatus_a;
    protected String var_java_lang_String_c = "";
    protected String d = "";
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;

    public ayq(int n2, String string, String string2, PlayerStatus playerStatus, RelationshipStatus relationshipStatus, String string3) {
        this.var_int_a = n2;
        this.var_java_lang_String_a = string;
        this.var_java_lang_String_b = string2;
        this.var_com_arenaofkings_packets_misc_PlayerStatus_a = playerStatus;
        this.var_com_arenaofkings_packets_misc_RelationshipStatus_a = relationshipStatus;
        this.var_java_lang_String_c = string3;
    }

    public void a(float f2, Engine engine, axm axm2, int n2, int n3) {
        we we2;
        this.a(engine, false);
        this.var_ayf_a.a(f2, engine);
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a != null && t.a(we.class, engine) && (we2 = (we)engine.axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_ui_Table_a() == this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a) {
            this.var_ayf_a.b(true);
        }
        if (this.var_com_arenaofkings_packets_misc_RelationshipStatus_a == RelationshipStatus.PENDING) {
            if (this.var_ayh_a == null) {
                this.var_ayh_a = new ayh(n2, n3, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_box", true);
            }
            if (this.var_ayh_b == null) {
                this.var_ayh_b = new ayr(this, n2, n3, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_checkmark", true, engine);
            }
            if (this.var_ayh_c == null) {
                this.var_ayh_c = new ays(this, n2, n3, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "x_default", true);
            }
            this.var_ayh_a.a(f2, engine);
            this.var_ayh_b.a(f2, engine);
            this.var_ayh_c.a(f2, engine);
        }
        switch (this.var_com_arenaofkings_packets_misc_PlayerStatus_a) {
            case AVAILABLE: {
                if (!this.var_java_lang_String_c.toLowerCase(Locale.US).equals("online") && !this.var_java_lang_String_c.equals("")) break;
                this.var_java_lang_String_c = "Online";
                break;
            }
            case QUEUED: {
                if (!this.var_java_lang_String_c.toLowerCase(Locale.US).equals("in queue") && !this.var_java_lang_String_c.equals("")) break;
                this.var_java_lang_String_c = "In Queue";
                break;
            }
            case BUSY: {
                if (!this.var_java_lang_String_c.toLowerCase(Locale.US).equals("in game") && !this.var_java_lang_String_c.equals("")) break;
                this.var_java_lang_String_c = "In Game";
                break;
            }
            case OFFLINE: {
                if (!this.var_java_lang_String_c.toLowerCase(Locale.US).equals("offline") && !this.var_java_lang_String_c.equals("")) break;
                this.var_java_lang_String_c = "Offline";
            }
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
    }

    public void a(float f2, Engine engine, float f3, float f4, boolean bl2) {
        if (this.var_ayf_a != null) {
            this.var_ayf_a.a(1550.0f, f4 - 32.0f);
        }
        this.var_ayf_a.b(f2, engine);
        if (this.var_com_arenaofkings_packets_misc_RelationshipStatus_a == RelationshipStatus.PENDING) {
            engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.YELLOW, engine.var_axy_c.a(), Color.BLACK, f3 + 7.0f, f4 - 14.0f, 8, 1);
            if (!bl2) {
                engine.a("Friend Request!", engine.var_axy_c.a(), Color.YELLOW, engine.var_axy_c.a(), Color.BLACK, f3 + 146.0f, f4 - 14.0f, 8, 1);
            }
            this.var_ayh_a.b(f2, engine, (int)f3 + 272, (int)f4 - 39);
            this.var_ayh_c.b(f2, engine, (int)f3 + 279, (int)f4 - 34);
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f3 + 279.0f, f4 - 34.0f);
            this.var_ayh_a.b(f2, engine, (int)f3 + 302, (int)f4 - 39);
            this.var_ayh_b.b(f2, engine, (int)f3 + 302, (int)f4 - 38);
            this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f3 + 302.0f, f4 - 38.0f);
        } else {
            switch (this.var_com_arenaofkings_packets_misc_PlayerStatus_a) {
                case AVAILABLE: {
                    engine.a(this.var_java_lang_String_a + " (" + this.var_java_lang_String_b + ")", engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, f3 + 7.0f, f4 - 14.0f, 8, 1);
                    engine.a("Online", engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, f3 + 265.0f, f4 - 14.0f, 8, 1);
                    break;
                }
                case QUEUED: {
                    engine.a(this.var_java_lang_String_a + " (" + this.var_java_lang_String_b + ")", engine.var_axy_c.a(), Color.ORANGE, engine.var_axy_c.a(), Color.BLACK, f3 + 7.0f, f4 - 14.0f, 8, 1);
                    engine.a("In Queue", engine.var_axy_c.a(), Color.ORANGE, engine.var_axy_c.a(), Color.BLACK, f3 + 265.0f, f4 - 14.0f, 8, 1);
                    break;
                }
                case BUSY: {
                    engine.a(this.var_java_lang_String_a + " (" + this.var_java_lang_String_b + ")", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, f3 + 7.0f, f4 - 14.0f, 8, 1);
                    engine.a("In Game", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, f3 + 265.0f, f4 - 14.0f, 8, 1);
                    break;
                }
                case OFFLINE: {
                    engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.GRAY, engine.var_axy_c.a(), Color.BLACK, f3 + 7.0f, f4 - 14.0f, 8, 1);
                    engine.a("Offline", engine.var_axy_c.a(), Color.GRAY, engine.var_axy_c.a(), Color.BLACK, f3 + 265.0f, f4 - 14.0f, 8, 1);
                }
            }
        }
    }

    public void a(Engine engine, boolean bl2) {
        if (this.var_ayf_a == null || bl2) {
            TextureAtlas textureAtlas = null;
            if (t.a(we.class, engine)) {
                textureAtlas = engine.axc_a().axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
            } else if (t.a(agd.class, engine)) {
                textureAtlas = engine.axc_a().axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e);
            }
            this.var_ayh_a = new ayh(0, 0, textureAtlas, "mtx_box", true);
            this.var_ayh_b = new ayt(this, 0, 0, textureAtlas, "mtx_checkmark", true, engine);
            this.var_ayh_c = new ayu(this, 0, 0, textureAtlas, "x_default", true, engine);
            this.var_ayf_a = new ayv(this, 0, 0, textureAtlas, "social_backdrop", "social_backdrop_hovered", true, engine);
        }
    }

    public int int_a(ayq ayq2) {
        if (this.var_com_arenaofkings_packets_misc_RelationshipStatus_a.getCode() < ayq2.var_com_arenaofkings_packets_misc_RelationshipStatus_a.getCode()) {
            return -1;
        }
        if (this.var_com_arenaofkings_packets_misc_RelationshipStatus_a.getCode() == ayq2.var_com_arenaofkings_packets_misc_RelationshipStatus_a.getCode()) {
            if (this.var_com_arenaofkings_packets_misc_PlayerStatus_a.getCode() < ayq2.var_com_arenaofkings_packets_misc_PlayerStatus_a.getCode()) {
                return -1;
            }
            if (this.var_com_arenaofkings_packets_misc_RelationshipStatus_a == RelationshipStatus.PENDING) {
                return this.var_java_lang_String_a.toLowerCase(Locale.US).compareTo(ayq2.var_java_lang_String_a.toLowerCase(Locale.US));
            }
            if (this.var_com_arenaofkings_packets_misc_PlayerStatus_a == ayq2.var_com_arenaofkings_packets_misc_PlayerStatus_a) {
                return this.var_java_lang_String_a.toLowerCase(Locale.US).compareTo(ayq2.var_java_lang_String_a.toLowerCase(Locale.US));
            }
            if (this.var_com_arenaofkings_packets_misc_PlayerStatus_a.getCode() > ayq2.var_com_arenaofkings_packets_misc_PlayerStatus_a.getCode()) {
                return 1;
            }
        } else {
            return 1;
        }
        Engine.a("[PLAYERENTRY] Error compareTo returning equal");
        return -1;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ayq)) {
            return false;
        }
        ayq ayq2 = (ayq)object;
        return this.var_java_lang_String_a.equals(ayq2.var_java_lang_String_a);
    }

    public String a() {
        return this.var_java_lang_String_a;
    }

    public void a(String string) {
        this.var_java_lang_String_b = string;
    }

    public void a(RelationshipStatus relationshipStatus) {
        this.var_com_arenaofkings_packets_misc_RelationshipStatus_a = relationshipStatus;
    }

    public void a(int n2) {
        this.var_int_a = n2;
    }

    public void a(String string, PlayerStatus playerStatus, RelationshipStatus relationshipStatus) {
        this.var_java_lang_String_b = string;
        this.var_com_arenaofkings_packets_misc_PlayerStatus_a = playerStatus;
        this.var_com_arenaofkings_packets_misc_RelationshipStatus_a = relationshipStatus;
    }

    public String toString() {
        return "PlayerEntry [account_name=" + this.var_java_lang_String_a + ", character_name=" + this.var_java_lang_String_b + ", playerStatus=" + (Object)((Object)this.var_com_arenaofkings_packets_misc_PlayerStatus_a) + ", relationshipStatus=" + (Object)((Object)this.var_com_arenaofkings_packets_misc_RelationshipStatus_a) + ", statusMessage=" + this.var_java_lang_String_c + "]";
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.int_a((ayq)object);
    }

    static /* synthetic */ Table a(ayq ayq2, Table table) {
        ayq2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a = table;
        return ayq2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    static /* synthetic */ Table com_badlogic_gdx_scenes_scene2d_ui_Table_a(ayq ayq2) {
        return ayq2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    static /* synthetic */ int b(ayq ayq2) {
        return ayq2.var_int_a;
    }
}

