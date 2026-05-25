/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.misc.CharacterClass;

public class eg
extends el {
    public eg(Engine engine, String string, int n2, String string2, int n3, int n4, int n5, int n6, int n7) {
        super(CharacterClass.fromString(string2));
        this.a = string;
        this.a = CharacterClass.fromString(string2);
        this.d = n3;
        this.e = n2;
        this.a = new gs();
        this.a(this.a, n6, n7);
        Engine.b("Loaded enemy health: " + string + " " + n6);
        this.a = db.b;
        this.com_arenaofkings_packets_gameserver_data_HitCircle_a().setData(n4, n5, 16);
        this.a = new EffectManager(engine);
        this.a = new cr(engine, this.a, this.a, this.a, this.a, n3);
        this.a = new bq(this.a, this.a, this.a, this.a);
        this.a.setMovementManager(this.a);
        this.a.a(this.a);
        this.a(engine, false);
        this.void_c();
    }
}

