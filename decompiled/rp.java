/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class rp
extends rc {
    public rp(Engine engine) {
        super(engine, EffectList.Sprint);
    }

    @Override
    protected void d() {
        this.a(0.25f, false);
    }

    @Override
    public void c() {
        super.c();
        this.a(0.25f, false);
    }
}

