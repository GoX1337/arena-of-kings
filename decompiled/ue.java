/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ue
extends ui {
    protected ue(a a2) {
        Engine.a("building dynamic player spell");
        this.a = a2.var_hf_a;
        this.a = a2.var_da_a;
        this.a = a2.var_azo_a;
        this.a = a2.var_float_a;
        this.b = a2.var_boolean_a;
        this.b = a2.b;
        this.a = a2.var_hd_a;
        Engine.a("built dynamic player spell");
    }

    @Override
    public void a(float f2, Engine engine) {
        Engine.a("DynamicPlayerSpell update in");
        super.a(f2, engine);
        Engine.a("DynamicPlayerSpell update out");
    }

    @Override
    public void b(float f2, Engine engine) {
        Engine.a("DynamicPlayerSpell render in");
        super.b(f2, engine);
        Engine.a("DynamicPlayerSpell render out");
    }

    @Override
    public void a(float f2, Engine engine, boolean bl2) {
        Engine.a("DynamicPlayerSpell renderFront in");
        super.a(f2, engine, bl2);
        Engine.a("DynamicPlayerSpell renderFront out");
    }

    @Override
    public void c(float f2, Engine engine) {
        Engine.a("DynamicPlayerSpell renderBack in");
        super.c(f2, engine);
        Engine.a("DynamicPlayerSpell renderBack out");
    }

    @Override
    public br br_a() {
        return this.a;
    }

    public static class a {
        private hf var_hf_a;
        private hd var_hd_a;
        protected da var_da_a;
        protected azo var_azo_a;
        protected float var_float_a = -1.0f;
        protected boolean var_boolean_a;
        protected azo b;

        public a a(SpellName spellName, String string, long l2, long l3, gx gx2, int n2, int n3, long l4, uj uj2, uh uh2, uk uk2, LocationType locationType, boolean bl2, boolean bl3) {
            this.var_hf_a = new hf(spellName, l2, l3, gx2, n2, n3, l4, uh2, uk2, locationType, bl2, bl3);
            if (string.equals("")) {
                Engine.a("[WARN] Didn't load icon path: " + string);
                this.var_hd_a = new hd(this.var_hf_a, string);
            } else {
                Engine.a("\t -> Loading: " + string);
                this.var_hd_a = new hd(this.var_hf_a, string);
                Engine.a("Loaded spellIcon");
            }
            return this;
        }

        public a a(hf hf2, hd hd2, da da2, ajw ajw2) {
            this.var_hf_a = hf2;
            this.var_hd_a = hd2;
            this.var_da_a = da2;
            this.var_azo_a = new azo(ajw2);
            return this;
        }

        public a a(ajw ajw2, String string, int n2, float f2, Animation.PlayMode playMode, int n3, int n4) {
            this.var_da_a = new da(ajw2, string, n2, f2, 0.0f, playMode, n3, n4);
            return this;
        }

        public a a(Color color) {
            this.var_da_a.a(color);
            return this;
        }

        public a a(ajw ajw2) {
            this.var_azo_a = new azo(ajw2);
            return this;
        }

        public a a(float f2) {
            this.var_azo_a.a(f2);
            return this;
        }

        public a ue$a_a() {
            this.var_boolean_a = true;
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

        public a a(int n2) {
            this.var_hf_a.com_arenaofkings_packets_gameserver_data_HitCircle_a().setRadius(n2);
            return this;
        }

        public a a(String string, Object ... objectArray) {
            this.var_hf_a.a(azu.a(string, "%d", objectArray));
            return this;
        }

        public ui ui_a() {
            return new ue(this);
        }
    }
}

