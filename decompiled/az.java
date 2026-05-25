/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public abstract class az {
    protected TiledMap var_com_badlogic_gdx_maps_tiled_TiledMap_a = new Array();
    protected MapLayer var_com_badlogic_gdx_maps_MapLayer_a;
    protected final cr var_cr_a;
    protected final EffectManager var_com_arenaofkings_packets_gameserver_data_EffectManager_a;
    protected final HitCircle var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    protected boolean var_boolean_a = false;
    protected boolean var_boolean_b = false;
    protected boolean var_boolean_c = false;
    protected boolean var_boolean_d = false;
    protected boolean var_boolean_e = false;
    protected boolean var_boolean_f = false;
    protected boolean var_boolean_g = false;
    protected boolean var_boolean_h = false;
    protected boolean var_boolean_i = false;
    protected boolean var_boolean_j = false;
    protected boolean var_boolean_k = false;
    protected boolean var_boolean_l = false;
    protected boolean var_boolean_m = false;
    protected final CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_a;
    protected final int var_int_a;
    protected float var_float_a = 300.0f;
    protected Array<Object> var_com_badlogic_gdx_utils_Array_java_lang_Object__a;
    protected final float var_float_b = 0.0033333334f;
    protected final float var_float_c = 0.0057735024f;
    protected final float var_float_d = 0.004714045f;
    protected final float var_float_e = 0.0081649665f;
    protected Direction var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH;
    private StopWatch var_org_apache_commons_lang3_time_StopWatch_a = StopWatch.create();
    private float var_float_j = 0.0f;
    private float var_float_k = 0.0f;
    private float var_float_l = 0.0f;
    private float var_float_m = 0.0f;
    private float n = 0.0f;
    protected double var_double_a = 0.0;
    protected double var_double_b = 0.0;
    protected float var_float_f = 0.0f;
    protected float var_float_g = 0.0f;
    protected float var_float_h = 0.0f;
    protected float var_float_i = 0.0f;
    protected long var_long_a = 0L;
    protected Direction var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.SOUTH;
    private PlayerAction var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = PlayerAction.IDLE_SOUTH;
    private ar var_ar_a;

    public az(HitCircle hitCircle, cr cr2, EffectManager effectManager, CharacterClass characterClass) {
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a = hitCircle;
        this.var_cr_a = cr2;
        this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a = effectManager;
        this.var_ar_a = new ar(this);
        this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
        switch (characterClass) {
            case ASSASSIN: {
                this.var_int_a = 325;
                break;
            }
            case CHAMPION: {
                this.var_int_a = 315;
                break;
            }
            case ELDER: {
                this.var_int_a = 290;
                break;
            }
            case LICH: {
                this.var_int_a = 280;
                break;
            }
            case MYSTIC: {
                this.var_int_a = 290;
                break;
            }
            case NIHILIST: {
                this.var_int_a = 280;
                break;
            }
            case PALADIN: {
                this.var_int_a = 315;
                break;
            }
            case RANGER: {
                this.var_int_a = 280;
                break;
            }
            case SCHOLAR: {
                this.var_int_a = 280;
                break;
            }
            case WIZARD: {
                this.var_int_a = 280;
                break;
            }
            default: {
                this.var_int_a = 280;
            }
        }
    }

    protected boolean boolean_a(float f2, float f3) {
        return this.a(new Vector2(f2, f3), false);
    }

    protected boolean a(Vector2 vector2, boolean bl2) {
        boolean bl3 = true;
        if (vector2.x >= 50.0f && vector2.x <= 2950.0f && vector2.y >= 0.0f && vector2.y <= 1500.0f) {
            Circle circle = new Circle(new Vector2(vector2.x + (float)(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getRadius() / 2), vector2.y - (float)(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getRadius() / 2)), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getRadius() + 2);
            for (MapObject mapObject : this.var_com_badlogic_gdx_maps_MapLayer_a.getObjects()) {
                if (!(mapObject instanceof PolygonMapObject) || !az.a(((PolygonMapObject)mapObject).getPolygon(), circle)) continue;
                bl3 = false;
                break;
            }
        } else {
            bl3 = false;
        }
        return bl3;
    }

    public static boolean a(Polygon polygon, Circle circle) {
        float[] fArray = polygon.getTransformedVertices();
        Vector2 vector2 = new Vector2(circle.x, circle.y);
        float f2 = circle.radius * circle.radius;
        for (int i2 = 0; i2 < fArray.length; i2 += 2) {
            if (!(i2 == 0 ? Intersector.intersectSegmentCircle(new Vector2(fArray[fArray.length - 2], fArray[fArray.length - 1]), new Vector2(fArray[i2], fArray[i2 + 1]), vector2, f2) : Intersector.intersectSegmentCircle(new Vector2(fArray[i2 - 2], fArray[i2 - 1]), new Vector2(fArray[i2], fArray[i2 + 1]), vector2, f2))) continue;
            return true;
        }
        return polygon.contains(circle.x, circle.y);
    }

    protected void void_a() {
        if (this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_j && !this.var_boolean_g) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.NORTH;
        } else if (this.var_boolean_d && !this.var_boolean_a && !this.var_boolean_j && !this.var_boolean_g) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH;
        } else if (this.var_boolean_j && !this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_g) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.WEST;
        } else if (this.var_boolean_g && !this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_j) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.EAST;
        } else if (this.var_boolean_a && this.var_boolean_g && !this.var_boolean_d && !this.var_boolean_j) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.NORTH_EAST;
        } else if (this.var_boolean_a && !this.var_boolean_g && !this.var_boolean_d && this.var_boolean_j) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.NORTH_WEST;
        } else if (!this.var_boolean_a && !this.var_boolean_g && this.var_boolean_d && this.var_boolean_j) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH_WEST;
        } else if (!this.var_boolean_a && this.var_boolean_g && this.var_boolean_d && !this.var_boolean_j) {
            this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH_EAST;
        }
    }

    public void void_a(PlayerAction playerAction) {
        this.var_cr_a.a(playerAction);
    }

    public void b(PlayerAction playerAction) {
        this.void_b();
        this.c(playerAction);
    }

    public void c(PlayerAction playerAction) {
        if (playerAction == PlayerAction.RUN_NORTH) {
            this.void_f();
            this.var_boolean_a = true;
        } else if (playerAction == PlayerAction.RUN_SOUTH) {
            this.void_f();
            this.var_boolean_d = true;
        } else if (playerAction == PlayerAction.RUN_EAST) {
            this.void_f();
            this.var_boolean_g = true;
        } else if (playerAction == PlayerAction.RUN_WEST) {
            this.void_f();
            this.var_boolean_j = true;
        } else if (playerAction == PlayerAction.RUN_SOUTH_EAST) {
            this.void_f();
            this.var_boolean_d = true;
            this.var_boolean_g = true;
        } else if (playerAction == PlayerAction.RUN_SOUTH_WEST) {
            this.void_f();
            this.var_boolean_d = true;
            this.var_boolean_j = true;
        } else if (playerAction == PlayerAction.RUN_NORTH_WEST) {
            this.void_f();
            this.var_boolean_a = true;
            this.var_boolean_j = true;
        } else if (playerAction == PlayerAction.RUN_NORTH_EAST) {
            this.void_f();
            this.var_boolean_a = true;
            this.var_boolean_g = true;
        } else {
            return;
        }
        this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
        this.void_e();
    }

    private void void_e() {
        if (this.var_boolean_a || this.var_boolean_d || this.var_boolean_g || this.var_boolean_j) {
            if (this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_j && !this.var_boolean_g) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.NORTH;
            } else if (this.var_boolean_d && !this.var_boolean_a && !this.var_boolean_j && !this.var_boolean_g) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.SOUTH;
            } else if (this.var_boolean_j && !this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_g) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.WEST;
            } else if (this.var_boolean_g && !this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_j) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.EAST;
            } else if (this.var_boolean_a && this.var_boolean_g && !this.var_boolean_d && !this.var_boolean_j) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.NORTH_EAST;
            } else if (this.var_boolean_a && !this.var_boolean_g && !this.var_boolean_d && this.var_boolean_j) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.NORTH_WEST;
            } else if (!this.var_boolean_a && !this.var_boolean_g && this.var_boolean_d && this.var_boolean_j) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.SOUTH_WEST;
            } else if (!this.var_boolean_a && this.var_boolean_g && this.var_boolean_d && !this.var_boolean_j) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.SOUTH_EAST;
            }
            this.var_boolean_m = true;
        } else {
            this.var_boolean_m = false;
        }
    }

    public void d(PlayerAction playerAction) {
        switch (playerAction) {
            case RUN_NORTH: {
                this.var_boolean_a = false;
                break;
            }
            case RUN_SOUTH: {
                this.var_boolean_d = false;
                break;
            }
            case RUN_EAST: {
                this.var_boolean_g = false;
                break;
            }
            case RUN_WEST: {
                this.var_boolean_j = false;
                break;
            }
            case RUN_SOUTH_EAST: {
                this.var_boolean_d = false;
                this.var_boolean_g = false;
                break;
            }
            case RUN_SOUTH_WEST: {
                this.var_boolean_d = false;
                this.var_boolean_j = false;
                break;
            }
            case RUN_NORTH_EAST: {
                this.var_boolean_a = false;
                this.var_boolean_g = false;
                break;
            }
            case RUN_NORTH_WEST: {
                this.var_boolean_a = false;
                this.var_boolean_j = false;
                break;
            }
            default: {
                return;
            }
        }
        this.void_e();
    }

    public void void_b() {
        this.d(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
    }

    private void void_f() {
        this.var_org_apache_commons_lang3_time_StopWatch_a.reset();
        this.var_org_apache_commons_lang3_time_StopWatch_a.start();
        this.var_float_l = 0.0f;
        this.var_float_m = 0.0f;
        this.var_float_i = 0.0f;
        this.var_float_h = 0.0f;
        this.var_double_a = 0.0;
        this.var_double_b = 0.0;
        this.var_float_j = 0.0f;
    }

    public void void_c() {
        this.var_float_m = (float)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.NANOSECONDS) / 1.0E9f;
        this.var_float_k = this.var_float_m - this.var_float_l;
        this.var_float_l = this.var_float_m;
        this.n = 0.0f;
        if ((this.var_boolean_a || this.var_boolean_d || this.var_boolean_g || this.var_boolean_j) && !this.boolean_a()) {
            boolean bl2;
            this.var_float_j += this.var_float_k;
            float f2 = this.var_float_k;
            this.var_float_i += f2;
            this.void_a();
            Vector2 vector2 = this.a(this.var_com_arenaofkings_packets_gameserver_data_Direction_a, this.var_float_i);
            int n2 = 0;
            double d2 = Math.abs(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - vector2.x);
            double d3 = Math.abs(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - vector2.y);
            if (d2 > d3) {
                n2 = (int)((double)n2 + d2);
                bl2 = true;
            } else {
                n2 = (int)((double)n2 + d3);
                bl2 = false;
            }
            int n3 = (int)Math.floor(n2);
            if (n3 > 0) {
                boolean bl3 = true;
                if (!this.a(vector2, bl2)) {
                    bl3 = false;
                }
                if (bl3) {
                    for (int i2 = 0; i2 < n3; ++i2) {
                        this.var_double_b += 1.0;
                        this.void_a();
                        Vector2 vector22 = this.a(this.var_com_arenaofkings_packets_gameserver_data_Direction_a, i2, bl2);
                        if (this.a(vector22, bl2)) continue;
                        this.var_float_i = 0.0f;
                        this.var_float_h = 0.0f;
                        bl3 = false;
                        break;
                    }
                }
                if (bl3) {
                    this.boolean_a(vector2);
                    this.var_float_i = 0.0f;
                } else {
                    Vector2 vector23;
                    float f3 = this.var_float_i / (float)n3;
                    for (int i3 = 0; i3 < n3 && this.a(vector23 = this.a(this.var_com_arenaofkings_packets_gameserver_data_Direction_a, f3), bl2); ++i3) {
                        this.boolean_a(vector23);
                        this.var_float_i -= f3;
                    }
                }
            }
        }
    }

    protected void a(Vector2 vector2, Direction direction) {
        this.void_a(vector2);
    }

    protected boolean boolean_a(Vector2 vector2) {
        if (this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_j && !this.var_boolean_g) {
            this.a(Direction.NORTH, vector2);
            this.var_cr_a.a(PlayerAction.RUN_NORTH);
            return true;
        }
        if (this.var_boolean_d && !this.var_boolean_a && !this.var_boolean_j && !this.var_boolean_g) {
            this.a(Direction.SOUTH, vector2);
            this.var_cr_a.a(PlayerAction.RUN_SOUTH);
            return true;
        }
        if (this.var_boolean_j && !this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_g) {
            this.a(Direction.WEST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_WEST);
            return true;
        }
        if (this.var_boolean_g && !this.var_boolean_a && !this.var_boolean_d && !this.var_boolean_j) {
            this.a(Direction.EAST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_EAST);
            return true;
        }
        if (this.var_boolean_a && this.var_boolean_g && !this.var_boolean_d && !this.var_boolean_j) {
            this.a(Direction.NORTH_EAST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_NORTH_EAST);
            return true;
        }
        if (this.var_boolean_a && !this.var_boolean_g && !this.var_boolean_d && this.var_boolean_j) {
            this.a(Direction.NORTH_WEST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_NORTH_WEST);
            return true;
        }
        if (!this.var_boolean_a && !this.var_boolean_g && this.var_boolean_d && this.var_boolean_j) {
            this.a(Direction.SOUTH_WEST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_SOUTH_WEST);
            return true;
        }
        if (!this.var_boolean_a && this.var_boolean_g && this.var_boolean_d && !this.var_boolean_j) {
            this.a(Direction.SOUTH_EAST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_SOUTH_EAST);
            return true;
        }
        if (this.var_boolean_a && this.var_boolean_g && !this.var_boolean_d && this.var_boolean_j) {
            this.a(Direction.NORTH, vector2);
            this.var_cr_a.a(PlayerAction.RUN_NORTH);
            return true;
        }
        if (!this.var_boolean_a && this.var_boolean_g && this.var_boolean_d && this.var_boolean_j) {
            this.a(Direction.SOUTH, vector2);
            this.var_cr_a.a(PlayerAction.RUN_SOUTH);
            return true;
        }
        if (this.var_boolean_a && !this.var_boolean_g && this.var_boolean_d && this.var_boolean_j) {
            this.a(Direction.WEST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_WEST);
            return true;
        }
        if (this.var_boolean_a && this.var_boolean_g && this.var_boolean_d && !this.var_boolean_j) {
            this.a(Direction.EAST, vector2);
            this.var_cr_a.a(PlayerAction.RUN_EAST);
            return true;
        }
        Engine.a("ERROR didn't set a move!!!");
        return false;
    }

    public Vector2 a(Direction direction, int n2, boolean bl2) {
        Engine.a("legalityDirection: " + (Object)((Object)direction));
        Vector2 vector2 = null;
        switch (direction) {
            case NORTH: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + (float)(1 * n2));
                break;
            }
            case SOUTH: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - (float)(1 * n2));
                break;
            }
            case EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
                break;
            }
            case WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
                break;
            }
            case NORTH_EAST: {
                if (bl2) {
                    vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + (float)(1 * n2));
                    break;
                }
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + (float)(1 * n2));
                break;
            }
            case NORTH_WEST: {
                if (bl2) {
                    vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + (float)(1 * n2));
                    break;
                }
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + (float)(1 * n2));
                break;
            }
            case SOUTH_EAST: {
                if (bl2) {
                    vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - (float)(1 * n2));
                    break;
                }
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - (float)(1 * n2));
                break;
            }
            case SOUTH_WEST: {
                vector2 = bl2 ? new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - (float)(1 * n2)) : new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - (float)(1 * n2), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - (float)(1 * n2));
            }
        }
        return vector2;
    }

    public Vector2 a(Direction direction, float f2) {
        Engine.a("Pre X: " + this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + " Pre Y: " + this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + " deltaTime: " + f2 + " Direction: " + (Object)((Object)direction));
        Vector2 vector2 = null;
        switch (direction) {
            case NORTH: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + this.var_float_a * f2 / 1.7320508f);
                break;
            }
            case SOUTH: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - this.var_float_a * f2 / 1.7320508f);
                break;
            }
            case EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + this.var_float_a * f2, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
                break;
            }
            case WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_float_a * f2, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
                break;
            }
            case NORTH_EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case NORTH_WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case SOUTH_EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case SOUTH_WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - this.var_float_a * f2 / 2.4494898f);
            }
        }
        Engine.a("Returned vector x: " + vector2.x + " y: " + vector2.y);
        return vector2;
    }

    public Vector2 b(Direction direction, float f2) {
        Engine.a("Slide Pre X: " + this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + " Pre Y: " + this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + " deltaTime: " + f2 + " Direction: " + (Object)((Object)direction));
        Vector2 vector2 = null;
        switch (direction) {
            case NORTH: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + this.var_float_a * f2 / 1.7320508f);
                break;
            }
            case SOUTH: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX(), this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - this.var_float_a * f2 / 1.7320508f);
                break;
            }
            case EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + this.var_float_a * f2, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
                break;
            }
            case WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_float_a * f2, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY());
                break;
            }
            case NORTH_EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case NORTH_WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case SOUTH_EAST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() + this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case SOUTH_WEST: {
                vector2 = new Vector2(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_float_a * f2 / 1.4142135f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() - this.var_float_a * f2 / 2.4494898f);
            }
        }
        Engine.a("Returned vector x: " + vector2.x + " y: " + vector2.y);
        return vector2;
    }

    public Vector2 a(Direction direction, Vector2 vector2, float f2) {
        Engine.a("Pre X: " + vector2.x + " Pre Y: " + vector2.y + " deltaTime: " + f2 + " Direction: " + (Object)((Object)direction));
        Vector2 vector22 = null;
        switch (direction) {
            case NORTH: {
                vector22 = new Vector2(vector2.x, vector2.y + this.var_float_a * f2 / 1.7320508f);
                break;
            }
            case SOUTH: {
                vector22 = new Vector2(vector2.x, vector2.y - this.var_float_a * f2 / 1.7320508f);
                break;
            }
            case EAST: {
                vector22 = new Vector2(vector2.x + this.var_float_a * f2, vector2.y);
                break;
            }
            case WEST: {
                vector22 = new Vector2(vector2.x - this.var_float_a * f2, vector2.y);
                break;
            }
            case NORTH_EAST: {
                vector22 = new Vector2(vector2.x + this.var_float_a * f2 / 1.4142135f, vector2.y + this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case NORTH_WEST: {
                vector22 = new Vector2(vector2.x - this.var_float_a * f2 / 1.4142135f, vector2.y + this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case SOUTH_EAST: {
                vector22 = new Vector2(vector2.x + this.var_float_a * f2 / 1.4142135f, vector2.y - this.var_float_a * f2 / 2.4494898f);
                break;
            }
            case SOUTH_WEST: {
                vector22 = new Vector2(vector2.x - this.var_float_a * f2 / 1.4142135f, vector2.y - this.var_float_a * f2 / 2.4494898f);
            }
        }
        Engine.a("Returned vector x: " + vector22.x + " y: " + vector22.y);
        return vector22;
    }

    public void a(Direction direction, Vector2 vector2) {
        this.void_a(vector2);
    }

    public void a(float f2) {
        float f3 = this.var_int_a;
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a.getEffects()) {
            oo2.c(f2);
            f3 *= oo2.float_a();
        }
        this.var_float_a = f3;
    }

    public void void_d() {
        float f2 = this.var_int_a;
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a.getEffects()) {
            f2 *= oo2.float_a();
        }
        this.var_float_a = f2;
    }

    public void void_a(float f2, float f3) {
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.setX(f2);
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.setY(f3);
    }

    public void void_a(Vector2 vector2) {
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.setPosition(vector2.x, vector2.y);
    }

    protected boolean boolean_a() {
        if (this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a.isRooted()) {
            this.var_cr_a.void_e();
        }
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a.getEffects()) {
            if (oo2.getClass() != ud.class && oo2.getClass() != tx.class) continue;
            this.var_cr_a.void_e();
            return true;
        }
        return false;
    }

    public boolean boolean_b() {
        return this.var_boolean_m;
    }

    public boolean boolean_c() {
        return this.var_boolean_g;
    }

    public boolean boolean_d() {
        return this.var_boolean_a;
    }

    public boolean boolean_e() {
        return this.var_boolean_d;
    }

    public boolean boolean_f() {
        return this.var_boolean_j;
    }

    public void a(TiledMap tiledMap) {
        this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = tiledMap;
        this.var_com_badlogic_gdx_maps_MapLayer_a = tiledMap.getLayers().get("collision");
    }

    public float float_a() {
        return this.var_float_f;
    }

    public float float_b() {
        return this.var_float_g;
    }

    public void b(float f2) {
        this.var_float_f = f2;
    }

    public void c(float f2) {
        this.var_float_g = f2;
    }

    public void a(boolean bl2) {
        this.var_boolean_m = bl2;
    }

    public void a(Direction direction) {
        this.var_com_arenaofkings_packets_gameserver_data_Direction_b = direction;
    }

    public ar ar_a() {
        return this.var_ar_a;
    }

    public HitCircle com_arenaofkings_packets_gameserver_data_HitCircle_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    }
}

