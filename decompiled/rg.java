/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class rg
extends rc {
    public rg(Engine engine) {
        super(engine, EffectList.MurderousInstincts);
    }

    @Override
    public void c() {
        if (this.a == ay.ay_a()) {
            ay.ay_a().azv_a().a(true);
        }
    }

    @Override
    public void void_b() {
        if (this.a == ay.ay_a()) {
            ay.ay_a().azv_a().a(false);
        }
    }
}

