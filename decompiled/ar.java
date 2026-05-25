/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.requests.input.JAVA_16_GFX_CL$61892;
import com.badlogic.gdx.utils.Array;

public class ar {
    private final az var_az_a = new Array();
    private final int var_int_a = 2;
    private final int var_int_b = (int)new Array();
    private final int c = 5;
    private Array<JAVA_16_GFX_CL$61892> var_com_badlogic_gdx_utils_Array_com_arenaofkings_packets_gameserver_requests_input_JAVA_16_GFX_CL$61892__a;
    private Array<JAVA_16_GFX_CL$61892> var_com_badlogic_gdx_utils_Array_com_arenaofkings_packets_gameserver_requests_input_JAVA_16_GFX_CL$61892__b;
    private int d = 1;
    private int e = 0;
    private boolean var_boolean_a = false;

    public ar(az az2) {
        this.var_az_a = az2;
        for (int i2 = 0; i2 < 2; ++i2) {
            ((Array)((Object)this.var_az_a)).add(new JAVA_16_GFX_CL$61892(-1, -1, -1));
        }
    }

    public void void_a() {
        this.var_az_a = new Array();
        this.var_int_b = (int)new Array();
        this.var_boolean_a = false;
        this.e = 0;
        for (int i2 = 0; i2 < 2; ++i2) {
            ((Array)((Object)this.var_az_a)).add(new JAVA_16_GFX_CL$61892(-1, -1, -1));
        }
    }

    public void void_b() {
        this.d();
        this.c();
        this.f();
        this.g();
        this.h();
    }

    private void c() {
        if (this.var_int_b.size == 0) {
            this.var_boolean_a = false;
        } else if (this.var_int_b.size >= 3) {
            this.var_boolean_a = true;
        }
        if ((this.boolean_a() && this.var_boolean_a || this.var_boolean_a && !this.boolean_b()) && this.var_int_b.size >= 2) {
            this.a((JAVA_16_GFX_CL$61892)this.var_int_b.get(0), (JAVA_16_GFX_CL$61892)this.var_int_b.get(1));
        }
    }

    private void a(JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$61892, JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$618922) {
        ((Array)((Object)this.var_az_a)).set(((Array)((Object)this.var_az_a)).size - 1, jAVA_16_GFX_CL$61892);
        ((Array)((Object)this.var_az_a)).set(0, jAVA_16_GFX_CL$618922);
        float f2 = (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(((Array)((Object)this.var_az_a)).size - 1)).$40() - ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(0)).$40()) / (float)(((Array)((Object)this.var_az_a)).size - 1);
        float f3 = (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(((Array)((Object)this.var_az_a)).size - 1)).$50() - ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(0)).$50()) / (float)(((Array)((Object)this.var_az_a)).size - 1);
        float f4 = ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(0)).$40();
        float f5 = ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(0)).$50();
        Direction direction = null;
        PlayerAction playerAction = null;
        for (int i2 = 1; i2 < ((Array)((Object)this.var_az_a)).size - 1; ++i2) {
            if (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gs() <= 0) {
                ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).setValues(0, (int)(f4 + f2 * (float)i2), (int)(f5 + f3 * (float)i2));
            }
            if (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gnd() != null) {
                direction = ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gnd();
            }
            if (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gnp() != null) {
                playerAction = ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gnp();
            }
            ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).$2ls(direction);
            ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).$2x(playerAction);
        }
    }

    private boolean boolean_a() {
        boolean bl2 = false;
        int n2 = 0;
        for (int i2 = 0; i2 < ((Array)((Object)this.var_az_a)).size; ++i2) {
            if (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gs() < 1) continue;
            ++n2;
        }
        if (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).peek()).gs() >= 1) {
            bl2 = true;
        }
        return n2 == 1 && bl2;
    }

    private void d() {
        if (this.var_int_b.size >= 5) {
            this.e();
            this.a((JAVA_16_GFX_CL$61892)this.var_int_b.get(this.var_int_b.size - 2), (JAVA_16_GFX_CL$61892)this.var_int_b.get(this.var_int_b.size - 1));
            this.var_int_b.clear();
        }
    }

    private void e() {
        for (int i2 = 0; i2 < ((Array)((Object)this.var_az_a)).size; ++i2) {
            ((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).setValues(-1, -1, -1);
        }
    }

    private void f() {
        JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$61892 = (JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).peek();
        if (jAVA_16_GFX_CL$61892.gs() >= 0) {
            this.var_az_a.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.setPosition(jAVA_16_GFX_CL$61892.$40(), jAVA_16_GFX_CL$61892.$50());
            this.var_az_a.a(true);
            if (jAVA_16_GFX_CL$61892.gnp() != null) {
                this.var_az_a.void_a(jAVA_16_GFX_CL$61892.gnp());
            }
            if (jAVA_16_GFX_CL$61892.gnd() != null) {
                this.var_az_a.a(jAVA_16_GFX_CL$61892.gnd());
            }
        } else {
            this.var_az_a.a(false);
        }
        if (jAVA_16_GFX_CL$61892.gs() >= 1 && !this.boolean_a()) {
            this.var_int_b.removeValue(jAVA_16_GFX_CL$61892, true);
        }
    }

    private void g() {
        for (int i2 = 0; i2 >= 0; --i2) {
            if (i2 == 0) {
                ((Array)((Object)this.var_az_a)).set(i2 + 1, (JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2));
                ((Array)((Object)this.var_az_a)).set(i2, new JAVA_16_GFX_CL$61892(-1, -1, -1));
                continue;
            }
            if (i2 == 0 && this.boolean_a()) {
                Engine.a("reachedTailWaypoint, not shifting");
                continue;
            }
            ((Array)((Object)this.var_az_a)).set(i2 + 1, (JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2));
        }
    }

    private void h() {
    }

    private boolean boolean_b() {
        boolean bl2 = false;
        for (int i2 = 0; i2 < ((Array)((Object)this.var_az_a)).size; ++i2) {
            if (((JAVA_16_GFX_CL$61892)((Array)((Object)this.var_az_a)).get(i2)).gs() == -1) continue;
            bl2 = true;
            break;
        }
        return bl2;
    }

    public void a(JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$61892) {
        jAVA_16_GFX_CL$61892.setSEQUENCE_NUMBER(this.d++);
        this.var_int_b.add(jAVA_16_GFX_CL$61892);
    }
}

