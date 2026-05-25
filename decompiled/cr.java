/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.Locale;

public class cr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    protected az var_az_a;
    protected gz var_gz_a;
    protected cy var_cy_a = new cy();
    protected da var_da_a;
    protected final HitCircle var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    protected CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_a;
    protected db var_db_a;
    protected int var_int_a;
    protected PlayerAction var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.IDLE_SOUTH;
    protected Direction var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH;
    protected boolean var_boolean_a = false;
    protected boolean b;
    protected Rectangle var_com_badlogic_gdx_math_Rectangle_a;
    protected cv var_cv_a = cv.var_cv_a;
    protected azv var_azv_a = new azv(0L, true);
    protected boolean c = false;
    protected boolean d = false;
    protected boolean e = false;

    public cr(Engine engine, HitCircle hitCircle, gz gz2, CharacterClass characterClass, db db2, int n2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a = hitCircle;
        this.var_gz_a = gz2;
        this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
        this.var_db_a = db2;
        this.var_int_a = n2;
        this.var_com_badlogic_gdx_math_Rectangle_a = new Rectangle();
    }

    public void void_a() {
        this.var_com_badlogic_gdx_math_Rectangle_a.setPosition(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
    }

    public void a(CharacterClass characterClass, db db2, int n2) {
        if (characterClass != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
        }
        if (db2 != null) {
            this.var_db_a = db2;
        }
        if (n2 != -1) {
            this.var_int_a = n2;
        }
        this.var_cy_a.a(true);
        this.b = true;
    }

    public void a(boolean bl2) {
        boolean bl3 = this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.isLoaded("packed/models/" + this.var_com_arenaofkings_packets_misc_CharacterClass_a.toString().toLowerCase(Locale.US) + "/outfit_" + this.var_int_a + "/" + this.var_db_a.toString().toLowerCase(Locale.US) + "/full.atlas");
        boolean bl4 = this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.isLoaded("packed/models/" + this.var_com_arenaofkings_packets_misc_CharacterClass_a.toString().toLowerCase(Locale.US) + "/outfit_" + this.var_int_a + "/" + this.var_db_a.toString().toLowerCase(Locale.US) + "/idle.atlas");
        if (!(bl2 && bl3 && bl4 || !bl2 && bl4)) {
            return;
        }
        this.var_cy_a.a(true);
        if (bl2) {
            this.void_b();
        }
        this.void_c();
        this.void_d();
        this.b = false;
    }

    public void void_b() {
        Engine.a("AnimationManager.loadFullNoIdleSouthGFX() in " + (Object)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a) + " " + (Object)((Object)this.var_db_a) + " " + this.var_int_a);
        this.var_cy_a.a(this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a, this.var_com_arenaofkings_packets_misc_CharacterClass_a, this.var_db_a, this.var_int_a);
        Engine.a("AnimationManager.loadFullNoIdleSouthGFX() out");
    }

    public void void_c() {
        Engine.a("AnimationManager.loadIdleSouthGFX() in" + (Object)((Object)this.var_com_arenaofkings_packets_misc_CharacterClass_a) + " " + (Object)((Object)this.var_db_a) + " " + this.var_int_a);
        this.var_cy_a.b(this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a, this.var_com_arenaofkings_packets_misc_CharacterClass_a, this.var_db_a, this.var_int_a);
        this.var_com_badlogic_gdx_math_Rectangle_a.setSize(this.com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionWidth(), this.com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionHeight());
        Engine.a("AnimationManager.loadIdleSouthGFX() out");
    }

    public void void_d() {
        this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.IDLE_SOUTH;
        this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH;
        this.a(this.var_cy_a.a().get(PlayerAction.IDLE_SOUTH));
    }

    public void a(da da2) {
        if (da2 != null) {
            this.var_da_a = da2;
        }
    }

    public void a(float f2) {
        if (!(this.boolean_c() || this.boolean_d() || this.boolean_e())) {
            this.void_e();
        }
        if (PlayerAction.isCastRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) && (this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().azv_b().boolean_b() || this.var_gz_a.ui_a() == null)) {
            this.a(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
        }
        if (PlayerAction.isAttackRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) && (this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().azv_b().boolean_b() || this.var_gz_a.ui_a() == null)) {
            this.a(PlayerAction.attackRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
        }
        if (this.var_cv_a == cv.b) {
            if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.e) {
                this.a(this.var_cy_a.b().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.d) {
                this.a(this.var_cy_a.b().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.g && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.SpiritWolf) {
                this.a(this.var_cy_a.b().get(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.b && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.SpiritWolf) {
                this.a(this.var_cy_a.b().get(PlayerAction.getAction(cw.d, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            }
        } else if (this.var_cv_a == cv.c) {
            if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.e) {
                this.a(this.var_cy_a.c().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.d) {
                this.a(this.var_cy_a.c().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.var_cw_a) {
                this.a(this.var_cy_a.c().get(PlayerAction.getAction(cw.var_cw_a, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.f) {
                this.a(this.var_cy_a.c().get(PlayerAction.getAction(cw.f, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.g && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear) {
                this.a(this.var_cy_a.c().get(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.b && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear) {
                this.a(this.var_cy_a.c().get(PlayerAction.getAction(cw.d, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            }
        } else if (this.var_cv_a == cv.d) {
            if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.e) {
                this.a(this.var_cy_a.d().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.d) {
                this.a(this.var_cy_a.d().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.g) {
                this.a(this.var_cy_a.d().get(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.b) {
                this.a(this.var_cy_a.d().get(PlayerAction.getAction(cw.d, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            }
        } else if (this.var_cv_a == cv.var_cv_a) {
            this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
        }
    }

    private boolean boolean_c() {
        return this.var_az_a.boolean_b();
    }

    private boolean boolean_d() {
        return this.var_da_a != null && !this.var_da_a.boolean_b() && (PlayerAction.isAttackOrCast(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) || PlayerAction.isCastRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) || PlayerAction.isAttackRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
    }

    private boolean boolean_e() {
        return PlayerAction.isDeath(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
    }

    public void a(float f2, azi azi2) {
        if (this.c) {
            this.var_da_a.c(f2, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - 25.0f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY(), azi2);
        } else {
            this.var_da_a.b(f2, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY(), azi2);
        }
    }

    public Sprite com_badlogic_gdx_graphics_g2d_Sprite_a() {
        return this.var_cy_a.a().get(PlayerAction.IDLE_SOUTH).a().getKeyFrames()[0];
    }

    public void a(PlayerAction playerAction) {
        this.var_azv_a = new azv(50L, true);
        this.var_da_a.a().setFrameDuration(0.025f);
        if (PlayerAction.isAttackOrCast(playerAction) || PlayerAction.isAttackRun(playerAction) || PlayerAction.isCastRun(playerAction)) {
            if (this.var_cy_a.a(playerAction) != null) {
                this.a(this.var_cy_a.a(playerAction));
                this.var_da_a.a(0.0f);
                this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
                this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
                if (this.var_gz_a.ui_a() != null) {
                    if (this.var_gz_a.ui_a().hf_a().azv_b().long_a() < 500L) {
                        this.var_da_a.a().setFrameDuration(0.5f / (float)this.var_da_a.a().getKeyFrames().length);
                    } else {
                        this.var_da_a.a().setFrameDuration((float)this.var_gz_a.ui_a().hf_a().azv_b().long_a() / 1000.0f / (float)this.var_da_a.a().getKeyFrames().length);
                    }
                    Engine.a("setting frame");
                } else {
                    this.var_da_a.a().setFrameDuration(0.5f / (float)this.var_da_a.a().getKeyFrames().length);
                }
            }
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
        } else if (PlayerAction.isRun(playerAction)) {
            if (PlayerAction.isAttackOrCast(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)) {
                if (this.var_gz_a.ui_a() == null) {
                    Engine.a("cs is null");
                }
                if (this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().boolean_c()) {
                    this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
                    this.g();
                } else {
                    this.a(this.var_cy_a.a().get(playerAction));
                    this.var_da_a.a(0.0f);
                    this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
                    this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
                    this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
                    if (this.var_gz_a instanceof gu) {
                        ((gu)this.var_gz_a).void_b();
                    }
                }
            }
            if (PlayerAction.isCastRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) && !this.var_da_a.boolean_b()) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
                this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.getAction(cw.g, this.var_com_arenaofkings_packets_gameserver_data_Direction_a);
                this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
                return;
            }
            if (PlayerAction.isAttackRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) && !this.var_da_a.boolean_b()) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
                this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.getAction(cw.f, this.var_com_arenaofkings_packets_gameserver_data_Direction_a);
                this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
                return;
            }
            if (PlayerAction.isRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) || PlayerAction.isIdle(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) || this.var_da_a != null && this.var_da_a.boolean_b() && (PlayerAction.isAttackOrCast(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) || PlayerAction.isCastRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) || PlayerAction.isAttackRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))) {
                Engine.a("newAction 3. currentAction: " + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) + " newAction: " + (Object)((Object)playerAction));
                this.a(this.var_cy_a.a().get(playerAction));
                this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
                this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
            }
        } else if (PlayerAction.isDeath(playerAction)) {
            this.a(this.var_cy_a.a().get(playerAction));
            this.var_da_a.a(0.0f);
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.NORMAL);
        } else if (PlayerAction.isIdle(playerAction) && playerAction != this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) {
            this.a(this.var_cy_a.a().get(playerAction));
            this.var_da_a.a(0.0f);
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = PlayerAction.getDirection(playerAction);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
        }
        if (this.var_cv_a == cv.b) {
            if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.e) {
                this.a(this.var_cy_a.b().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.d) {
                this.a(this.var_cy_a.b().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.g && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.SpiritWolf) {
                this.a(this.var_cy_a.b().get(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.b && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.SpiritWolf) {
                this.a(this.var_cy_a.b().get(PlayerAction.getAction(cw.d, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            }
        } else if (this.var_cv_a == cv.c) {
            if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.e) {
                this.a(this.var_cy_a.c().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.d) {
                this.a(this.var_cy_a.c().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.var_cw_a) {
                this.a(this.var_cy_a.c().get(PlayerAction.getAction(cw.var_cw_a, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.f) {
                this.a(this.var_cy_a.c().get(PlayerAction.getAction(cw.f, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.g && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear) {
                this.a(this.var_cy_a.c().get(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.b && this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Bear) {
                this.a(this.var_cy_a.c().get(PlayerAction.getAction(cw.d, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            }
        } else if (this.var_cv_a == cv.d) {
            if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.e) {
                this.a(this.var_cy_a.d().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.d) {
                this.a(this.var_cy_a.d().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.g) {
                this.a(this.var_cy_a.d().get(PlayerAction.castRunToRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)));
            } else if (cw.a(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a) == cw.b) {
                this.a(this.var_cy_a.d().get(PlayerAction.getAction(cw.d, PlayerAction.getDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a))));
            }
        }
    }

    public void void_e() {
        if (this.var_azv_a.boolean_b()) {
            this.var_azv_a = new azv(50L, true);
            switch (this.var_com_arenaofkings_packets_gameserver_data_Direction_a) {
                case NORTH: {
                    this.a(PlayerAction.IDLE_NORTH);
                    break;
                }
                case EAST: {
                    this.a(PlayerAction.IDLE_EAST);
                    break;
                }
                case SOUTH: {
                    this.a(PlayerAction.IDLE_SOUTH);
                    break;
                }
                case WEST: {
                    this.a(PlayerAction.IDLE_WEST);
                    break;
                }
                case NORTH_EAST: {
                    this.a(PlayerAction.IDLE_NORTH_EAST);
                    break;
                }
                case NORTH_WEST: {
                    this.a(PlayerAction.IDLE_NORTH_WEST);
                    break;
                }
                case SOUTH_EAST: {
                    this.a(PlayerAction.IDLE_SOUTH_EAST);
                    break;
                }
                case SOUTH_WEST: {
                    this.a(PlayerAction.IDLE_SOUTH_WEST);
                    break;
                }
            }
        }
    }

    public cy cy_a() {
        return this.var_cy_a;
    }

    public da da_a() {
        return this.var_da_a;
    }

    public Direction com_arenaofkings_packets_gameserver_data_Direction_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_Direction_a;
    }

    public PlayerAction com_arenaofkings_packets_gameserver_data_PlayerAction_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a;
    }

    public boolean boolean_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_NORTH || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_EAST || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_SOUTH || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_WEST || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_NORTH_EAST || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_NORTH_WEST || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_SOUTH_EAST || this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a == PlayerAction.IDLE_SOUTH_WEST;
    }

    public void b(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public void a(az az2) {
        this.var_az_a = az2;
    }

    public void f() {
        if (PlayerAction.isAttackRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)) {
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.getAction(cw.var_cw_a, this.var_com_arenaofkings_packets_gameserver_data_Direction_a);
            float f2 = this.var_da_a.float_a();
            this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            this.var_da_a.a(f2);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
        } else if (PlayerAction.isCastRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)) {
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.getAction(cw.b, this.var_com_arenaofkings_packets_gameserver_data_Direction_a);
            float f3 = this.var_da_a.float_a();
            this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            this.var_da_a.a(f3);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
        }
    }

    public void g() {
        if (PlayerAction.isAttack(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)) {
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.getAction(cw.f, this.var_com_arenaofkings_packets_gameserver_data_Direction_a);
            float f2 = 0.0f;
            if (this.var_da_a != null) {
                f2 = this.var_da_a.float_a();
            }
            this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            this.var_da_a.a(f2);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
        } else if (PlayerAction.isCast(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a)) {
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.getAction(cw.g, this.var_com_arenaofkings_packets_gameserver_data_Direction_a);
            float f3 = 0.0f;
            if (this.var_da_a != null) {
                f3 = this.var_da_a.float_a();
            }
            this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            this.var_da_a.a(f3);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
        }
    }

    public void b(PlayerAction playerAction) {
        this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
    }

    public void a(Direction direction) {
        this.var_com_arenaofkings_packets_gameserver_data_Direction_a = direction;
        this.var_az_a.a(direction);
        this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.changeDirection(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a, direction);
        float f2 = 0.0f;
        if (this.var_da_a != null) {
            f2 = this.var_da_a.float_a();
        }
        this.a(this.var_cy_a.a().get(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
        if (this.var_da_a != null) {
            this.var_da_a.a(f2);
            this.var_da_a.a().setPlayMode(Animation.PlayMode.LOOP);
        }
    }

    public boolean boolean_b() {
        return this.b;
    }

    public void c(boolean bl2) {
        this.b = bl2;
    }

    public db db_a() {
        return this.var_db_a;
    }

    public Rectangle com_badlogic_gdx_math_Rectangle_a() {
        return this.var_com_badlogic_gdx_math_Rectangle_a;
    }

    public void a(cv cv2) {
        switch (cv2) {
            case var_cv_a: {
                this.var_cv_a = cv2;
                break;
            }
            case d: {
                this.var_cv_a = cv2;
                this.c = true;
                break;
            }
            case b: {
                this.d = true;
                if (this.c) {
                    this.var_cv_a = cv.d;
                    break;
                }
                this.var_cv_a = cv2;
                break;
            }
            case c: {
                this.e = true;
                this.var_cv_a = this.c ? cv.d : cv2;
            }
        }
    }

    public void b(cv cv2) {
        switch (cv2) {
            case var_cv_a: {
                this.var_cv_a = cv2;
                break;
            }
            case d: {
                this.var_cv_a = cv.var_cv_a;
                this.c = false;
                break;
            }
            case b: {
                this.d = false;
                if (this.c) {
                    this.var_cv_a = cv.d;
                    break;
                }
                if (this.e) {
                    this.var_cv_a = cv.c;
                    break;
                }
                this.var_cv_a = cv.var_cv_a;
                break;
            }
            case c: {
                this.e = false;
                if (this.c) {
                    this.var_cv_a = cv.d;
                    break;
                }
                if (this.d) {
                    this.var_cv_a = cv.b;
                    break;
                }
                this.var_cv_a = cv.var_cv_a;
                break;
            }
        }
    }

    public void h() {
        for (ObjectMap.Entry entry : this.var_cy_a.var_boolean_a) {
            if (PlayerAction.isDeath((PlayerAction)((Object)entry.key))) continue;
            for (Sprite sprite : ((da)entry.value).var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrames()) {
                sprite.setAlpha(0.4f);
            }
        }
    }

    public void i() {
        for (ObjectMap.Entry entry : this.var_cy_a.var_boolean_a) {
            if (PlayerAction.isDeath((PlayerAction)((Object)entry.key))) continue;
            for (Sprite sprite : ((da)entry.value).var_com_badlogic_gdx_graphics_g2d_Animation_com_badlogic_gdx_graphics_g2d_Sprite__a.getKeyFrames()) {
                sprite.setAlpha(1.0f);
            }
        }
    }
}

