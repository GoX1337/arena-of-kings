/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class pw
extends pe {
    public pw(Engine engine) {
        super(engine, EffectList.Exhaustion);
    }

    @Override
    protected void d() {
        this.b(0.5f, true);
    }

    @Override
    public void c() {
        super.c();
        this.b(0.5f, true);
    }
}

