/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class re
extends rc {
    public re(Engine engine) {
        super(engine, EffectList.Dash);
        this.a(ajw.bP);
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

