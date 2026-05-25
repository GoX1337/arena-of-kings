/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.math.Vector3;

public class gw
extends hf {
    protected long var_long_a;
    protected boolean var_boolean_a;
    protected Vector3 var_com_badlogic_gdx_math_Vector3_a;
    protected float var_float_a;
    protected float var_float_b;
    protected boolean var_boolean_b = false;

    public gw(SpellName spellName, long l2, long l3, gx gx2, int n2, int n3, long l4, long l5, uh uh2, uk uk2, LocationType locationType, boolean bl2, boolean bl3) {
        super(spellName, l2, l3, gx2, n2, n3, l5, uh2, uk2, locationType, bl2, bl3);
        this.var_long_a = l4;
        this.var_boolean_a = false;
        this.var_com_badlogic_gdx_math_Vector3_a = new Vector3();
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }

    public void a(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public Vector3 com_badlogic_gdx_math_Vector3_a() {
        return this.var_com_badlogic_gdx_math_Vector3_a;
    }

    public float float_a() {
        return this.var_float_a;
    }

    public float float_b() {
        return this.var_float_b;
    }

    public long long_a() {
        return this.var_long_a;
    }

    public boolean boolean_b() {
        return this.var_boolean_a;
    }

    public void a(float f2, float f3) {
        this.var_float_a = f2;
        this.var_float_b = f3;
    }

    public void b(boolean bl2) {
        Engine.b("collided = " + bl2);
        this.var_boolean_a = bl2;
    }
}

