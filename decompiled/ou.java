/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class ou
extends oo {
    public ou(Engine engine, EffectList effectList, ot ot2, String string, String string2, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        super(effectList, engine, ot2, string, string2, n2, f2, playMode, n3, n4, f3, f4);
    }

    public ou(Engine engine, EffectList effectList, String string, ot ot2, String string2, String string3, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        super(effectList, string, engine, ot2, string2, string3, n2, f2, playMode, n3, n4, f3, f4);
    }

    @Override
    public void a(Color color) {
        this.a.a(color);
    }

    @Override
    public void void_b() {
    }

    @Override
    public void c() {
    }

    @Override
    protected void d() {
    }
}

