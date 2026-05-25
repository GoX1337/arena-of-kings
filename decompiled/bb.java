/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.requests.input.JAVA_16_GFX_CL$61892;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_NORTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_NORTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_NORTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_SOUTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_SOUTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_SOUTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_NORTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_NORTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_NORTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_SOUTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_SOUTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_SOUTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_WEST;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class bb
extends az {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private r var_r_a;
    private StopWatch var_org_apache_commons_lang3_time_StopWatch_a = StopWatch.create();
    private float m = 0.0f;
    private float var_float_n = 0.0f;
    private float var_float_o = 0.0f;
    private float var_float_p = 0.0f;
    private float var_float_q = 0.0f;
    private boolean var_boolean_n = false;
    private final bp var_bp_a;
    private agb var_agb_a;
    private boolean var_boolean_o = false;
    private boolean var_boolean_p = false;
    private boolean var_boolean_q = false;
    private boolean r = false;
    float j = 0.0f;
    int b = 0;
    float k = 0.0f;
    float l = 0.0f;
    int c = 0;

    public bb(Engine engine, HitCircle hitCircle, cr cr2, EffectManager effectManager, CharacterClass characterClass) {
        super(hitCircle, cr2, effectManager, characterClass);
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_bp_a = new bp(this);
    }

    public void e(PlayerAction playerAction) {
        if (playerAction == PlayerAction.RUN_NORTH) {
            this.var_boolean_o = true;
        } else if (playerAction == PlayerAction.RUN_EAST) {
            this.var_boolean_q = true;
        } else if (playerAction == PlayerAction.RUN_WEST) {
            this.r = true;
        } else if (playerAction == PlayerAction.RUN_SOUTH) {
            this.var_boolean_p = true;
        }
    }

    public void f(PlayerAction playerAction) {
        if (playerAction == PlayerAction.RUN_NORTH) {
            this.var_boolean_o = false;
        } else if (playerAction == PlayerAction.RUN_EAST) {
            this.var_boolean_q = false;
        } else if (playerAction == PlayerAction.RUN_WEST) {
            this.r = false;
        } else if (playerAction == PlayerAction.RUN_SOUTH) {
            this.var_boolean_p = false;
        }
    }

    @Override
    public void c(PlayerAction playerAction) {
        if (playerAction == PlayerAction.RUN_NORTH) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_NORTH());
            }
        } else if (playerAction == PlayerAction.RUN_SOUTH) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.d = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_SOUTH());
            }
        } else if (playerAction == PlayerAction.RUN_EAST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.g = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_EAST());
            }
        } else if (playerAction == PlayerAction.RUN_WEST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.j = 1.0f;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_WEST());
            }
        } else if (playerAction == PlayerAction.RUN_SOUTH_EAST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.d = true;
            this.g = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_SOUTH_EAST());
            }
        } else if (playerAction == PlayerAction.RUN_SOUTH_WEST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.d = true;
            this.j = 1.0f;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_SOUTH_WEST());
            }
        } else if (playerAction == PlayerAction.RUN_NORTH_WEST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)true;
            this.j = 1.0f;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_NORTH_WEST());
            }
            Engine.a("action push: " + (boolean)this.var_com_arenaofkings_client_core_Engine_a + " " + (boolean)this.j);
        } else if (playerAction == PlayerAction.RUN_NORTH_EAST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)true;
            this.g = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_NORTH_EAST());
            }
        } else {
            return;
        }
        this.void_h();
    }

    public void a(PlayerAction playerAction, boolean bl2) {
        if (ay.ay_a().e() && !bl2 || ay.ay_a().gd_a().boolean_b()) {
            return;
        }
        if (playerAction == PlayerAction.RUN_NORTH) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_NORTH());
            }
        } else if (playerAction == PlayerAction.RUN_SOUTH) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.d = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_SOUTH());
            }
        } else if (playerAction == PlayerAction.RUN_EAST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.g = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_EAST());
            }
        } else if (playerAction == PlayerAction.RUN_WEST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.j = 1.0f;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_WEST());
            }
        } else if (playerAction == PlayerAction.RUN_SOUTH_EAST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.d = true;
            this.g = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_SOUTH_EAST());
            }
        } else if (playerAction == PlayerAction.RUN_SOUTH_WEST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.d = true;
            this.j = 1.0f;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_SOUTH_WEST());
            }
        } else if (playerAction == PlayerAction.RUN_NORTH_WEST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)true;
            this.j = 1.0f;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_NORTH_WEST());
            }
            Engine.a("action push: " + (boolean)this.var_com_arenaofkings_client_core_Engine_a + " " + (boolean)this.j);
        } else if (playerAction == PlayerAction.RUN_NORTH_EAST) {
            if (this.m != false) {
                this.void_i();
            }
            this.void_f();
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)true;
            this.g = true;
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_REQUEST_NORTH_EAST());
            }
        } else {
            return;
        }
        this.void_h();
    }

    private void void_h() {
        System.out.println("Updating moving");
        if (this.var_com_arenaofkings_client_core_Engine_a != false || this.d || this.g || this.j != false) {
            if (this.var_com_arenaofkings_client_core_Engine_a != false && !this.d && this.j == false && !this.g) {
                this.b = (int)Direction.NORTH;
            } else if (this.d && this.var_com_arenaofkings_client_core_Engine_a == false && this.j == false && !this.g) {
                this.b = (int)Direction.SOUTH;
            } else if (this.j != false && this.var_com_arenaofkings_client_core_Engine_a == false && !this.d && !this.g) {
                this.b = (int)Direction.WEST;
            } else if (this.g && this.var_com_arenaofkings_client_core_Engine_a == false && !this.d && this.j == false) {
                this.b = (int)Direction.EAST;
            } else if (this.var_com_arenaofkings_client_core_Engine_a != false && this.g && !this.d && this.j == false) {
                this.b = (int)Direction.NORTH_EAST;
            } else if (this.var_com_arenaofkings_client_core_Engine_a != false && !this.g && !this.d && this.j != false) {
                this.b = (int)Direction.NORTH_WEST;
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && !this.g && this.d && this.j != false) {
                this.b = (int)Direction.SOUTH_WEST;
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && this.g && this.d && this.j == false) {
                this.b = (int)Direction.SOUTH_EAST;
            }
            this.m = 1.0f;
            Engine.a("moving set to true");
        } else {
            this.m = 0.0f;
            Engine.a("moving set ot false");
        }
    }

    public boolean a(double d2, double d3) {
        boolean bl2;
        double d4;
        Engine.a("HitCircle: " + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + "," + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + "   Target: " + d2 + "," + d3);
        int n2 = 5;
        int n3 = 0;
        double d5 = axp.float_a((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d2, d3);
        double d6 = axp.double_a((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d2, d3);
        double d7 = axp.a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d6);
        if (d5 <= 2.0) {
            return true;
        }
        double d8 = Math.abs((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - d2);
        if (d8 > (d4 = Math.abs((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - d3))) {
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)d8;
            bl2 = true;
        } else {
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)d4;
            bl2 = false;
        }
        int n4 = (int)Math.floor(d5 / (double)n2);
        Vector2 vector2 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector22 = new Vector2((float)d2, (float)d3);
        int n5 = 0;
        while ((double)Math.abs(n5) < this.var_com_arenaofkings_client_core_Engine_a - 2.0) {
            double d9;
            double d10;
            n3 = n2;
            if (bl2) {
                n5 = (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() > d2 ? (n5 -= n3) : (n5 += n3);
                d10 = ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + (float)n5;
                d9 = d6 * d10 + d7;
            } else {
                n5 = (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() > d3 ? (n5 -= n3) : (n5 += n3);
                d9 = ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + (float)n5;
                d10 = d8 <= 1.0 ? (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() : (d9 - d7) / d6;
            }
            vector22.set((float)d10, (float)d9);
            for (MapObject mapObject : ((MapLayer)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getObjects()) {
                if (!(mapObject instanceof PolygonMapObject) || !Intersector.intersectSegmentPolygon(vector2, vector22, ((PolygonMapObject)mapObject).getPolygon())) continue;
                return false;
            }
        }
        return true;
    }

    public boolean b(double d2, double d3) {
        boolean bl2;
        double d4;
        Engine.a("HitCircle: " + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + "," + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + "   Target: " + d2 + "," + d3);
        int n2 = 5;
        int n3 = 0;
        double d5 = axp.float_a((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d2, d3);
        double d6 = axp.double_a((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d2, d3);
        double d7 = axp.a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d6);
        if (d5 <= 2.0) {
            return true;
        }
        double d8 = Math.abs((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - d2);
        if (d8 > (d4 = Math.abs((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - d3))) {
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)d8;
            bl2 = true;
        } else {
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)d4;
            bl2 = false;
        }
        int n4 = (int)Math.floor(d5 / (double)n2);
        Vector2 vector2 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector22 = new Vector2((float)d2, (float)d3);
        int n5 = 0;
        while ((double)Math.abs(n5) < this.var_com_arenaofkings_client_core_Engine_a - 2.0) {
            double d9;
            double d10;
            n3 = n2;
            if (bl2) {
                n5 = (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() > d2 ? (n5 -= n3) : (n5 += n3);
                d10 = ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + (float)n5;
                d9 = d6 * d10 + d7;
            } else {
                n5 = (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() > d3 ? (n5 -= n3) : (n5 += n3);
                d9 = ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + (float)n5;
                d10 = d8 <= 1.0 ? (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() : (d9 - d7) / d6;
            }
            vector22.set((float)d10, (float)d9);
            for (MapObject mapObject : ((MapLayer)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getObjects()) {
                if (!(mapObject instanceof PolygonMapObject) || !Intersector.intersectSegmentPolygon(vector2, vector22, ((PolygonMapObject)mapObject).getPolygon())) continue;
                return false;
            }
            if (!((double)(Math.abs(n5) + Math.abs(n3)) >= this.var_com_arenaofkings_client_core_Engine_a)) continue;
            for (MapObject mapObject : ((MapLayer)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getObjects()) {
                if (!(mapObject instanceof PolygonMapObject)) continue;
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(-24.0f, 0.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(48.0f, 0.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(-24.0f, 24.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(0.0f, -48.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(24.0f, 0.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(0.0f, 48.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(-48.0f, 0.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                if (Intersector.intersectSegmentPolygon(vector2, vector22 = vector22.add(0.0f, -48.0f), ((PolygonMapObject)mapObject).getPolygon())) {
                    return false;
                }
                vector22 = vector22.add(24.0f, 24.0f);
            }
        }
        return true;
    }

    public Vector3 a(double d2, double d3, SpellName spellName) {
        boolean bl2;
        double d4;
        Vector3 vector3 = new Vector3((int)d2, (int)d3, 0.0f);
        Engine.a("HitCircle: " + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + "," + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + "   Target: " + d2 + "," + d3);
        int n2 = 24;
        int n3 = 0;
        double d5 = axp.float_a((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d2, d3);
        double d6 = axp.double_a((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d2, d3);
        double d7 = axp.a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), d6);
        if (d5 <= 2.0) {
            return vector3;
        }
        double d8 = Math.abs((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - d2);
        if (d8 > (d4 = Math.abs((double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - d3))) {
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)d8;
            bl2 = true;
        } else {
            this.var_com_arenaofkings_client_core_Engine_a = (Engine)d4;
            bl2 = false;
        }
        int n4 = (int)Math.floor(d5 / (double)n2);
        Vector2 vector2 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector22 = new Vector2((float)d2, (float)d3);
        Vector2 vector23 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector24 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector25 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector26 = new Vector2(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        Vector2 vector27 = new Vector2((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), (int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
        boolean bl3 = false;
        boolean bl4 = false;
        while ((double)Math.abs(bl4 ? 1 : 0) < this.var_com_arenaofkings_client_core_Engine_a - 2.0) {
            double d9;
            double d10;
            n3 = n2;
            if (bl2) {
                bl4 = (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() > d2 ? (bl4 -= n3) : (bl4 += n3);
                d10 = ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + (float)bl4;
                d9 = d6 * d10 + d7;
            } else {
                bl4 = (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() > d3 ? (bl4 -= n3) : (bl4 += n3);
                d9 = ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + (float)bl4;
                d10 = d8 <= 1.0 ? (double)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() : (d9 - d7) / d6;
            }
            vector22.set((float)d10, (float)d9);
            for (Object object : ((MapLayer)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getObjects()) {
                if (!(object instanceof PolygonMapObject) || !Intersector.intersectSegmentPolygon(vector2, vector22, ((PolygonMapObject)object).getPolygon())) continue;
                vector3.z = 1.0f;
            }
            boolean bl5 = true;
            vector22.set((int)vector22.x, (int)vector22.y);
            if (vector22.x >= 50.0f && vector22.x <= 2950.0f && vector22.y >= 0.0f && vector22.y <= 1500.0f) {
                Object object;
                object = new Circle(new Vector2(vector22.x + (float)(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getRadius() / 2), vector22.y - (float)(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getRadius() / 2)), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getRadius() + 2);
                for (MapObject mapObject : ((MapLayer)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getObjects()) {
                    if (!(mapObject instanceof PolygonMapObject) || !bb.a(((PolygonMapObject)mapObject).getPolygon(), (Circle)object)) continue;
                    bl5 = false;
                    break;
                }
                if (bl5) {
                    vector27.set((int)vector22.x, (int)vector22.y);
                }
            } else {
                bl5 = false;
            }
            if (vector3.z == 1.0f) continue;
            vector26.set(vector25.x, vector25.y);
            vector25.set(vector24.x, vector24.y);
            vector24.set(vector23.x, vector23.y);
            vector23.set(vector22.x, vector22.y);
            vector3.set(vector26.x, vector26.y, vector3.z);
        }
        bl4 = true;
        Vector2 vector28 = new Vector2(vector22.x, vector22.y);
        if (this.a(vector22, bl2)) {
            System.out.println("NEW LEGAL DETERMINATION");
            bl4 = true;
        } else {
            System.out.println("NOT A VALID MOVE POS");
            bl4 = false;
        }
        System.out.println("Final determination of valid: " + bl4);
        Engine.b("Third: " + vector25.x + "," + vector25.y + " Second: " + vector24.x + "," + vector24.y + " Last: " + vector23.x + "," + vector23.y);
        Engine.b("Returning CP: " + vector3.x + "," + vector3.y);
        System.out.println("Ok, this is the actual destination: " + vector27.x + "," + vector27.y);
        if (vector3.z == 1.0f || !bl4) {
            if (spellName == SpellName.Teleport || spellName == SpellName.Blink) {
                return new Vector3(vector27, 0.0f);
            }
            return new Vector3(vector27, 1.0f);
        }
        return new Vector3((float)d2, (float)d3, 0.0f);
    }

    public void void_e() {
        this.void_f();
        this.m = 0.0f;
        this.var_float_n = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.var_com_arenaofkings_client_core_Engine_a = (Engine)0L;
        this.var_com_arenaofkings_client_core_Engine_a = (Engine)false;
        this.d = false;
        this.g = false;
        this.j = 0.0f;
        this.var_boolean_o = false;
        this.var_boolean_p = false;
        this.var_boolean_q = false;
        this.r = false;
    }

    public void void_f() {
        this.var_org_apache_commons_lang3_time_StopWatch_a.reset();
        this.var_org_apache_commons_lang3_time_StopWatch_a.start();
        this.var_float_o = 0.0f;
        this.var_float_p = 0.0f;
        this.i = 0.0f;
        this.h = 0.0f;
        this.var_com_arenaofkings_client_core_Engine_a = (Engine)0.0;
        this.b = (int)0.0;
        this.m = 0.0f;
    }

    @Override
    public void d(PlayerAction playerAction) {
        Engine.a("Holding N: " + this.var_boolean_o);
        Engine.a("Holding S: " + this.var_boolean_p);
        Engine.a("Holding E: " + this.var_boolean_q);
        Engine.a("Holding W: " + this.r);
        Engine.a("Release action: " + (Object)((Object)playerAction));
        switch (playerAction) {
            case RUN_NORTH: {
                if (this.var_boolean_o) {
                    return;
                }
                this.void_i();
                this.var_com_arenaofkings_client_core_Engine_a = (Engine)false;
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_NORTH());
                break;
            }
            case RUN_SOUTH: {
                if (this.var_boolean_p) {
                    return;
                }
                this.void_i();
                this.d = false;
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_SOUTH());
                break;
            }
            case RUN_EAST: {
                if (this.var_boolean_q) {
                    return;
                }
                this.void_i();
                this.g = false;
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_EAST());
                break;
            }
            case RUN_WEST: {
                if (this.r) {
                    return;
                }
                this.void_i();
                this.j = 0.0f;
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_WEST());
                break;
            }
            case RUN_SOUTH_EAST: {
                if (!this.var_boolean_p) {
                    this.d = false;
                }
                if (!this.var_boolean_q) {
                    this.g = false;
                }
                this.void_i();
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_SOUTH_EAST());
                break;
            }
            case RUN_SOUTH_WEST: {
                if (!this.var_boolean_p) {
                    this.d = false;
                }
                if (!this.r) {
                    this.j = 0.0f;
                }
                this.void_i();
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_SOUTH_WEST());
                break;
            }
            case RUN_NORTH_EAST: {
                if (!this.var_boolean_o) {
                    this.var_com_arenaofkings_client_core_Engine_a = (Engine)false;
                }
                if (!this.var_boolean_q) {
                    this.g = false;
                }
                this.void_i();
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_NORTH_EAST());
                break;
            }
            case RUN_NORTH_WEST: {
                if (!this.var_boolean_o) {
                    this.var_com_arenaofkings_client_core_Engine_a = (Engine)false;
                }
                if (!this.r) {
                    this.j = 0.0f;
                }
                this.void_i();
                this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(new MOVE_RELEASE_NORTH_WEST());
                break;
            }
            default: {
                this.void_h();
                return;
            }
        }
        Engine.a("going to update moving");
        this.void_h();
        if (this.m == false) {
            ((cr)((Object)this.var_com_arenaofkings_client_core_Engine_a)).f();
        }
        Engine.a("DETAILS moving: " + (boolean)this.m + " isTryingMoveNorth: " + (boolean)this.var_com_arenaofkings_client_core_Engine_a + " isTryingMoveSouth: " + this.d + " isTryingMoveEast: " + this.g + " isTryingMoveWest: " + (boolean)this.j);
        Engine.a("release out");
    }

    private void void_i() {
        if (!this.boolean_a() && this.var_com_arenaofkings_client_core_Engine_a > 0.0f) {
            boolean bl2;
            Engine.a("totalStepped: " + this.b);
            Engine.a("final frame PRE Stopwatch ran for: " + (float)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.NANOSECONDS) / 1.0E9f + "s. trueIntegrationTime= " + this.m + " integrateFinalFrame() remainder integration: " + this.var_float_q + " accumulatorTrimFINAL: " + this.h);
            Engine.a("integrateFinalFrame 1");
            this.i += (float)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.NANOSECONDS) / 1.0E9f - this.var_float_o;
            this.i += this.h;
            this.h = 0.0f;
            Engine.a("integrateFinalFrame 2");
            this.void_a();
            Engine.a("integrateFinalFrame 3");
            Vector2 vector2 = this.a((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a), this.i);
            Engine.a("integrateFinalFrame 4");
            int n2 = 0;
            double d2 = Math.abs(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - vector2.x);
            double d3 = Math.abs(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - vector2.y);
            Engine.a("integrateFinalFrame 5");
            if (d2 > d3) {
                n2 = (int)((double)n2 + d2);
                bl2 = true;
            } else {
                n2 = (int)((double)n2 + d3);
                bl2 = false;
            }
            Engine.a("integrateFinalFrame 6");
            int n3 = (int)Math.floor(n2);
            Engine.a("movement manager 1");
            if (n3 > 0) {
                int n4;
                boolean bl3 = true;
                if (!this.a(vector2, bl2)) {
                    bl3 = false;
                }
                if (bl3) {
                    for (n4 = 0; n4 < n3; ++n4) {
                        this.b += 1.0;
                        this.void_a();
                        Vector2 vector22 = this.a((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a), n4, bl2);
                        if (this.a(vector22, bl2)) continue;
                        this.h = 0.0f;
                        bl3 = false;
                        break;
                    }
                }
                Engine.a("movement manager 2");
                boolean bl4 = false;
                if (bl3) {
                    this.boolean_a(vector2);
                    this.i = 0.0f;
                    n4 = 0;
                } else {
                    float f2 = this.i / (float)n3;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        Vector2 vector23 = this.a((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a), f2);
                        if (this.a(vector23, bl2)) {
                            this.boolean_a(vector23);
                            this.i -= f2;
                        } else {
                            bl3 = false;
                            break;
                        }
                        bl4 = true;
                    }
                    n4 = 1;
                }
                Engine.a("movement manager 3");
                if (!bl3 && n4 != 0 && bl4) {
                    this.b((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a));
                } else {
                    Engine.a("IntegrateFinalFrame Legal: " + bl3 + " atCollisionObject: " + (n4 != 0) + " steppedToCollisionObject: " + bl4);
                }
                if (bl3 || !bl3 && n4 != 0 && bl4) {
                    this.void_j();
                }
                Engine.a("movement manager 4");
            }
        }
        Engine.a("movement manager 5");
        Engine.a("remaining steps: " + (double)this.var_com_arenaofkings_client_core_Engine_a);
        Engine.a("Stopwatch ran for: " + (float)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.NANOSECONDS) / 1.0E9f + "s. trueIntegrationTime= " + this.m + " integrateFinalFrame() remainder integration: " + this.var_float_q + " accumulatorTrimFINAL: " + this.h);
        this.void_f();
    }

    private void void_j() {
        Engine.a("sending my position");
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a() && (!ay.ay_a().a(false) || !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().isRooted() || ay.ay_a().e())) {
            Engine.a("s1");
            JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$61892 = new JAVA_16_GFX_CL$61892(this.var_bp_a.a(), (int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), (int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY(), (Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a));
            Engine.a("s2");
            Engine.a("s3");
            this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.a(jAVA_16_GFX_CL$61892);
        }
        Engine.a("sent my position");
    }

    @Override
    public void void_c() {
        this.var_float_p = (float)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.NANOSECONDS) / 1.0E9f;
        this.var_float_n = this.var_float_p - this.var_float_o;
        this.var_float_o = this.var_float_p;
        this.var_float_q = 0.0f;
        if ((this.var_com_arenaofkings_client_core_Engine_a != false || this.d || this.g || this.j != false) && !this.boolean_a() && this.var_com_arenaofkings_client_core_Engine_a > 0.0f) {
            boolean bl2;
            if (this.var_com_arenaofkings_client_core_Engine_a != false) {
                this.var_agb_a = this.var_com_arenaofkings_client_core_Engine_a.var_agc_a.a().get(InputIdentifier.MOVE_NORTH);
                this.b = this.var_agb_a != null ? (Gdx.input.isKeyPressed(this.var_agb_a.int_a()) ? 1 : 0) : 0;
            }
            if (this.d) {
                this.var_agb_a = this.var_com_arenaofkings_client_core_Engine_a.var_agc_a.a().get(InputIdentifier.MOVE_SOUTH);
                this.e = this.var_agb_a != null ? Gdx.input.isKeyPressed(this.var_agb_a.int_a()) : false;
            }
            if (this.g) {
                this.var_agb_a = this.var_com_arenaofkings_client_core_Engine_a.var_agc_a.a().get(InputIdentifier.MOVE_EAST);
                this.h = this.var_agb_a != null ? Gdx.input.isKeyPressed(this.var_agb_a.int_a()) : false;
            }
            if (this.j != false) {
                this.var_agb_a = this.var_com_arenaofkings_client_core_Engine_a.var_agc_a.a().get(InputIdentifier.MOVE_WEST);
                this.k = this.var_agb_a != null ? (Gdx.input.isKeyPressed(this.var_agb_a.int_a()) ? 1.0f : 0.0f) : 0.0f;
            }
            if (!Gdx.input.isButtonPressed(1)) {
                if (this.var_com_arenaofkings_client_core_Engine_a != this.b) {
                    this.var_com_arenaofkings_client_core_Engine_a = (Engine)this.b;
                    this.void_h();
                }
                if (this.d != this.e) {
                    this.d = this.e;
                    this.void_h();
                }
                if (this.g != this.h) {
                    this.g = this.h;
                    this.void_h();
                }
                if (this.j != this.k) {
                    this.j = this.k;
                    this.void_h();
                }
            }
            this.m += this.var_float_n;
            this.void_g();
            float f2 = this.var_float_n;
            Engine.a("simulate() accumulator: " + this.i + " frameTime: " + f2);
            this.i += f2;
            this.void_a();
            Vector2 vector2 = this.a((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a), this.i);
            int n2 = 0;
            double d2 = Math.abs(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - vector2.x);
            double d3 = Math.abs(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - vector2.y);
            if (d2 > d3) {
                n2 = (int)((double)n2 + d2);
                bl2 = true;
            } else {
                n2 = (int)((double)n2 + d3);
                bl2 = false;
            }
            int n3 = (int)Math.floor(n2);
            boolean bl3 = true;
            boolean bl4 = false;
            boolean bl5 = false;
            if (n3 > 0) {
                if (!this.a(vector2, bl2)) {
                    bl3 = false;
                }
                if (bl3) {
                    for (int i2 = 0; i2 < n3; ++i2) {
                        this.b += 1.0;
                        Vector2 vector22 = this.a((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a), i2, bl2);
                        if (this.a(vector22, bl2)) continue;
                        Engine.a("Determined that there is a collision on the path");
                        bl3 = false;
                        break;
                    }
                }
                if (bl3) {
                    this.boolean_a(vector2);
                    this.i = 0.0f;
                    bl4 = false;
                    Engine.a("Completely legal. Position set entirely and accumulator is now 0");
                } else {
                    float f3 = this.i / (float)n3;
                    Engine.a("start");
                    Engine.a("STARTED simulate() accumulator: " + this.i + " frameTime: " + f2 + " stepTime: " + f3 + " floorSteps: " + n3);
                    for (int i3 = 0; i3 < n3; ++i3) {
                        Vector2 vector23 = this.a((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a), f3);
                        Engine.a("Step #: " + i3 + "  new positionVector: " + vector23.x + "," + vector23.y);
                        if (this.a(vector23, bl2)) {
                            this.boolean_a(vector23);
                            this.i -= f3;
                            continue;
                        }
                        bl3 = false;
                        bl5 = true;
                        break;
                    }
                    Engine.a("stop");
                    bl4 = true;
                }
                if (!bl3 && bl4 && bl5) {
                    this.b((Direction)((Object)this.var_com_arenaofkings_client_core_Engine_a));
                } else {
                    Engine.a("didn't slide. Legal: " + bl3 + " atCollisionObject: " + bl4 + " steppedToCollisionObject: " + bl5);
                }
                if (bl3 || !bl3 && bl4 && bl5) {
                    this.void_j();
                } else {
                    Engine.a("didn't send it");
                }
            } else {
                Engine.a("floor steps not enough");
            }
        }
        if (!this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX(), ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY())) {
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 4.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 4.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 4, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 4.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 4.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 4.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 4, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 4.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 4.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 4.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 4, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 4.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 4.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 4.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 4, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 4.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 8.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 8.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 8, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 8.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 8.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 8.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 8, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 8.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 8.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 8.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 8, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 8.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 8.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 8.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 8, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 8.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 16.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 16.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 16, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 16.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 16.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 16.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 16, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 16.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 16.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 16.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 16, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 16.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 16.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 16.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 16, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 16.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 20.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 20.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 20, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 20.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 20.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 20.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 20, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() + 20.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 20.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 20.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + 20, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 20.0f);
                this.void_j();
                return;
            }
            if (this.boolean_a(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 20.0f, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 20.0f)) {
                ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition((int)((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - 20, ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - 20.0f);
                this.void_j();
                return;
            }
        }
    }

    private void b(Direction direction) {
        double d2;
        Engine.a("slide. Accumulator: " + this.i);
        bt bt2 = new bt(this.b(Direction.NORTH, this.i), Direction.NORTH);
        bt bt3 = new bt(this.b(Direction.SOUTH, this.i), Direction.SOUTH);
        bt bt4 = new bt(this.b(Direction.EAST, this.i), Direction.EAST);
        bt bt5 = new bt(this.b(Direction.WEST, this.i), Direction.WEST);
        bt bt6 = new bt(this.b(Direction.NORTH_EAST, this.i), Direction.NORTH_EAST);
        bt bt7 = new bt(this.b(Direction.NORTH_WEST, this.i), Direction.NORTH_WEST);
        bt bt8 = new bt(this.b(Direction.SOUTH_EAST, this.i), Direction.SOUTH_EAST);
        bt bt9 = new bt(this.b(Direction.SOUTH_WEST, this.i), Direction.SOUTH_WEST);
        bt bt10 = null;
        switch (direction) {
            case NORTH: {
                bt10 = this.a(bt4, 0, 1, bt5, 0, 1);
                break;
            }
            case SOUTH: {
                bt10 = this.a(bt4, 0, -1, bt5, 0, -1);
                break;
            }
            case EAST: {
                bt10 = this.a(bt2, 1, 0, bt3, 1, 0);
                break;
            }
            case WEST: {
                bt10 = this.a(bt2, -1, 0, bt3, -1, 0);
                break;
            }
            case NORTH_EAST: {
                bt10 = this.a(bt7, 1, 1, bt8, 1, 1);
                break;
            }
            case NORTH_WEST: {
                bt10 = this.a(bt6, -1, 1, bt9, -1, 1);
                break;
            }
            case SOUTH_EAST: {
                bt10 = this.a(bt6, 1, -1, bt9, 1, -1);
                break;
            }
            case SOUTH_WEST: {
                bt10 = this.a(bt7, -1, -1, bt8, -1, -1);
            }
        }
        if (bt10 == null) {
            return;
        }
        int n2 = 0;
        double d3 = Math.abs(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() - bt10.var_com_badlogic_gdx_math_Vector2_a.x);
        n2 = d3 > (d2 = (double)Math.abs(((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY() - bt10.var_com_badlogic_gdx_math_Vector2_a.y)) ? (int)((double)n2 + d3) : (int)((double)n2 + d2);
        int n3 = (int)Math.floor(n2);
        float f2 = this.i / (float)n3;
        Engine.a("slide integration");
        Engine.a("slide simulate() accumulator: " + this.i + " stepTime: " + f2 + " floorSteps: " + n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            Vector2 vector2 = this.a(bt10.var_com_arenaofkings_packets_gameserver_data_Direction_a, bt10.var_com_badlogic_gdx_math_Vector2_a, f2);
            Engine.a("Step #: " + i2 + "  new positionVector: " + vector2.x + "," + vector2.y);
            if (this.a(vector2, false)) {
                this.a(vector2, direction);
                this.i -= f2;
                continue;
            }
            Engine.a("slide break. Slid us all we could.");
            break;
        }
        Engine.a("slide stop. Accumulator: " + this.i + " HitCircle: " + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getX() + "," + ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getY());
    }

    private bt a(bt bt2, int n2, int n3, bt bt3, int n4, int n5) {
        Vector2 vector2 = new Vector2(bt2.var_com_badlogic_gdx_math_Vector2_a);
        vector2.add(n2, n3);
        Vector2 vector22 = new Vector2(bt3.var_com_badlogic_gdx_math_Vector2_a);
        vector22.add(n4, n3);
        boolean bl2 = this.a(vector2, false);
        boolean bl3 = this.a(vector22, false);
        if (bl2 && bl3 || !bl2 && !bl3) {
            this.i = 0.0f;
            return null;
        }
        if (bl2) {
            return bt2;
        }
        return bt3;
    }

    public void d(float f2) {
        ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setX(f2);
        this.var_r_a.position.x = f2;
    }

    public void e(float f2) {
        ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setY(f2);
        this.var_r_a.position.y = f2;
    }

    @Override
    public void void_a(Vector2 vector2) {
        ((HitCircle)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition(vector2.x, vector2.y);
        this.var_r_a.position.set(vector2, 0.0f);
    }

    @Override
    public void void_a(float f2, float f3) {
        super.void_a(f2, f3);
        this.var_r_a.position.x = f2;
        this.var_r_a.position.y = f3;
    }

    public void a(r r2) {
        this.var_r_a = r2;
    }

    public void b(boolean bl2) {
        this.var_boolean_n = bl2;
    }

    public bp bp_a() {
        return this.var_bp_a;
    }

    public boolean boolean_a(PlayerAction playerAction) {
        boolean bl2 = false;
        Engine.a("OUT returning moving: " + bl2 + " isTryingMoveNorth: " + (boolean)this.var_com_arenaofkings_client_core_Engine_a + " isTryingMoveSouth: " + this.d + " isTryingMoveEast: " + this.g + " isTryingMoveWest: " + (boolean)this.j);
        if (this.boolean_b()) {
            Engine.a("i'm moving");
            if (this.var_com_arenaofkings_client_core_Engine_a != false && !this.d && this.j == false && !this.g) {
                if (playerAction == PlayerAction.RUN_NORTH || playerAction == PlayerAction.ATTACK_RUN_NORTH || playerAction == PlayerAction.CAST_RUN_NORTH) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && this.d && this.j == false && !this.g) {
                if (playerAction == PlayerAction.RUN_SOUTH || playerAction == PlayerAction.ATTACK_RUN_SOUTH || playerAction == PlayerAction.CAST_RUN_SOUTH) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && !this.d && this.j == false && this.g) {
                if (playerAction == PlayerAction.RUN_EAST || playerAction == PlayerAction.ATTACK_RUN_EAST || playerAction == PlayerAction.CAST_RUN_EAST) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && !this.d && this.j != false && !this.g) {
                if (playerAction == PlayerAction.RUN_WEST || playerAction == PlayerAction.ATTACK_RUN_WEST || playerAction == PlayerAction.CAST_RUN_WEST) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a != false && !this.d && this.j == false && this.g) {
                if (playerAction == PlayerAction.RUN_NORTH_EAST || playerAction == PlayerAction.ATTACK_RUN_NORTH_EAST || playerAction == PlayerAction.CAST_RUN_NORTH_EAST) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a != false && !this.d && this.j != false && !this.g) {
                if (playerAction == PlayerAction.RUN_NORTH_WEST || playerAction == PlayerAction.ATTACK_RUN_NORTH_WEST || playerAction == PlayerAction.CAST_RUN_NORTH_WEST) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && this.d && this.j == false && this.g) {
                if (playerAction == PlayerAction.RUN_SOUTH_EAST || playerAction == PlayerAction.ATTACK_RUN_SOUTH_EAST || playerAction == PlayerAction.CAST_RUN_SOUTH_EAST) {
                    bl2 = true;
                }
            } else if (this.var_com_arenaofkings_client_core_Engine_a == false && this.d && this.j != false && !this.g && (playerAction == PlayerAction.RUN_SOUTH_WEST || playerAction == PlayerAction.ATTACK_RUN_SOUTH_WEST || playerAction == PlayerAction.CAST_RUN_SOUTH_WEST)) {
                bl2 = true;
            }
        }
        Engine.a("IN returning moving: " + bl2 + " isTryingMoveNorth: " + (boolean)this.var_com_arenaofkings_client_core_Engine_a + " isTryingMoveSouth: " + this.d + " isTryingMoveEast: " + this.g + " isTryingMoveWest: " + (boolean)this.j);
        return bl2;
    }

    public boolean boolean_g() {
        return this.var_boolean_q;
    }

    public boolean boolean_h() {
        return this.var_boolean_o;
    }

    public boolean boolean_i() {
        return this.var_boolean_p;
    }

    public boolean boolean_j() {
        return this.r;
    }

    public boolean k() {
        return this.var_boolean_q || this.var_boolean_o || this.r || this.var_boolean_p;
    }

    public void void_g() {
        Engine.a("ps returning moving: " + (boolean)this.m + " isTryingMoveNorth: " + (boolean)this.var_com_arenaofkings_client_core_Engine_a + " isTryingMoveSouth: " + this.d + " isTryingMoveEast: " + this.g + " isTryingMoveWest: " + (boolean)this.j);
    }
}

