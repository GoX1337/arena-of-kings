/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public class ul
extends ui {
    private boolean d = false;

    protected ul(a a2) {
        this.a = a2.var_gw_a;
        this.a = a2.var_da_a;
        this.b = a2.var_da_b;
        this.a = a2.var_azo_a;
        this.b = a2.var_boolean_a;
        this.b = a2.var_azo_b;
        this.a = a2.var_hd_a;
    }

    @Override
    public void a(float f2, Engine engine) {
        if (!((gw)this.a).boolean_a()) {
            br br2 = this.br_b();
            if (br2 != null) {
                HitCircle hitCircle = new HitCircle(this.a.float_d(), this.a.e(), 8);
                Vector3 vector3 = axp.a(f2, ((gw)this.a).long_a(), hitCircle, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a());
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().add(vector3.x, vector3.y, 0.0f);
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().z = vector3.z;
                if (axp.a(hitCircle, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a())) {
                    ((gw)this.a).b(true);
                }
            } else if (!this.a.a().isEmpty() && this.a.a().get(0) != null && this.a.a().get(0).getHitCircle() != null) {
                HitCircle hitCircle = new HitCircle(this.a.float_d(), this.a.e(), 8);
                Vector3 vector3 = axp.a(f2, ((gw)this.a).long_a(), hitCircle, this.a.a().get(0).getHitCircle());
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().add(vector3.x, vector3.y, 0.0f);
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().z = vector3.z;
                if (axp.a(hitCircle, this.a.a().get(0).getHitCircle())) {
                    ((gw)this.a).b(true);
                }
            }
        } else {
            if (this.br_b() != null) {
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().set(this.br_b().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.br_b().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), 0.0f);
            } else if (!this.a.a().isEmpty() && this.a.a().get(0) != null && this.a.a().get(0).getHitCircle() != null && !((gw)this.a).boolean_b()) {
                HitCircle hitCircle = new HitCircle(this.a.float_d(), this.a.e(), 8);
                Vector3 vector3 = axp.a(f2, ((gw)this.a).long_a(), hitCircle, this.a.a().get(0).getHitCircle());
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().add(vector3.x, vector3.y, 0.0f);
                ((gw)this.a).com_badlogic_gdx_math_Vector3_a().z = vector3.z;
                if (axp.a(hitCircle, this.a.a().get(0).getHitCircle())) {
                    ((gw)this.a).b(true);
                }
            }
            super.a(f2, engine);
        }
    }

    @Override
    public void a(axm axm2) {
        if (this.a != null && this.a.ajw_a() != null && !this.a.ajw_a().a().equals("")) {
            this.a.a(axm2, false, true);
            for (Sprite sprite : this.a.a().getKeyFrames()) {
                sprite.setOriginCenter();
                sprite.setColor(this.a.com_badlogic_gdx_graphics_Color_a());
            }
        }
        if (this.b != null && this.a.ajw_a() != null && !this.b.ajw_a().a().equals("")) {
            this.b.a(axm2, false, true);
            for (Sprite sprite : this.b.a().getKeyFrames()) {
                sprite.setOriginCenter();
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        super.b(f2, engine);
    }

    @Override
    public void c(float f2, Engine engine) {
        if (!((gw)this.a).boolean_a() && this.a != null) {
            this.a.d(f2, engine);
        } else if (this.b != null) {
            this.b.d(f2, engine);
        }
    }

    @Override
    public void a(float f2, Engine engine, boolean bl2) {
        if (!((gw)this.a).boolean_a() && this.a != null) {
            this.a.c(f2, engine);
        } else if (this.b != null) {
            this.b.c(f2, engine);
        }
    }

    @Override
    public br br_a() {
        return this.a;
    }

    public br br_b() {
        br br2 = null;
        if (!this.a.a().isEmpty()) {
            Target target = this.a.a().get(0).getTarget();
            if (target != null) {
                br2 = target.getPlayer();
            } else {
                Engine.a("[ERROR] targetPlayer is NULL, getTargetPlayer() returning NULL");
            }
        } else {
            Engine.a("[ERROR] TargetedProjectileSpell locations is empty, returning NULL");
        }
        return br2;
    }

    public void b(boolean bl2) {
        this.d = bl2;
        this.a(1.125f);
    }

    public static class a {
        private gw var_gw_a;
        private hd var_hd_a;
        protected da var_da_a;
        protected da var_da_b;
        protected azo var_azo_a;
        protected boolean var_boolean_a;
        protected azo var_azo_b;

        public a a(SpellName spellName, String string, long l2, long l3, gx gx2, int n2, int n3, long l4, long l5, uj uj2, uh uh2, uk uk2, LocationType locationType, boolean bl2, boolean bl3) {
            this.var_gw_a = new gw(spellName, l2, l3, gx2, n2, n3, l4, l5, uh2, uk2, locationType, bl2, bl3);
            if (spellName.toString().contains("TwistingShot")) {
                this.var_hd_a = new hd(this.var_gw_a, "HobblingArrow");
            } else {
                Engine.a("\t -> Loading: " + spellName.name() + " " + string);
                this.var_hd_a = new hd(this.var_gw_a, string);
            }
            return this;
        }

        public a a(ajw ajw2, String string, int n2, float f2, Animation.PlayMode playMode, int n3, int n4) {
            this.var_da_a = new da(ajw2, string, n2, f2, 0.0f, playMode, n3, n4);
            this.var_da_a.a(this.var_gw_a.com_badlogic_gdx_math_Vector3_a());
            return this;
        }

        public a b(ajw ajw2, String string, int n2, float f2, Animation.PlayMode playMode, int n3, int n4) {
            this.var_da_b = new da(ajw2, string, n2, f2, 0.0f, playMode, n3, n4);
            this.var_da_b.a(this.var_gw_a.com_badlogic_gdx_math_Vector3_a());
            return this;
        }

        public a a(ajw ajw2) {
            this.var_azo_a = new azo(ajw2);
            return this;
        }

        public a a(float f2) {
            if (this.var_azo_a != null) {
                this.var_azo_a.a(f2);
            }
            if (this.var_azo_b != null) {
                this.var_azo_b.a(f2);
            }
            return this;
        }

        public a b(ajw ajw2) {
            this.var_azo_b = new azo(ajw2);
            return this;
        }

        public a a(float f2, float f3) {
            this.var_da_a.c(f2);
            this.var_da_a.b(f3);
            return this;
        }

        public a b(float f2) {
            this.var_da_a.d(f2);
            return this;
        }

        public a a(Color color) {
            this.var_da_a.a(color);
            return this;
        }

        public a a(String string, Object ... objectArray) {
            this.var_gw_a.a(azu.a(string, "%d", objectArray));
            return this;
        }
    }
}

