/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class rc
extends oo {
    public rc(Engine engine, EffectList effectList, String string, String string2, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        super(effectList, engine, ot.var_ot_a, string, string2, n2, f2, playMode, n3, n4, f3, f4);
    }

    public rc(Engine engine, EffectList effectList, String string, String string2, String string3, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        super(effectList, engine, ot.var_ot_a, string, string2, string3, n2, f2, playMode, n3, n4, f3, f4);
    }

    public rc(Engine engine, EffectList effectList) {
        super(effectList, engine, ot.var_ot_a);
    }

    public rc(Engine engine, EffectList effectList, String string) {
        super(effectList, engine, ot.var_ot_a, string);
    }

    public rc(Engine engine, EffectList effectList, EffectList effectList2) {
        super(effectList, engine, ot.var_ot_a, effectList2);
    }

    public void b(Color color) {
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

