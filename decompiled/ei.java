/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import java.util.ArrayList;

public class ei
extends el {
    public ei(Engine engine, String string, int n2, CharacterClass characterClass, int n3, ProfileBackgrounds profileBackgrounds, String string2, String string3, String string4, int n4, int n5, int n6, int n7, ArrayList<String> arrayList, int n8, int n9) {
        super(characterClass);
        this.a = string;
        this.a = characterClass;
        this.d = n3;
        this.e = n2;
        this.f = n4;
        this.g = n5;
        this.n = n6;
        this.b = n7;
        this.a = new gt(engine, n2);
        for (int i2 = 1; i2 <= arrayList.size(); ++i2) {
            ((gt)this.a).b(arrayList.get(i2 - 1), i2);
        }
        this.a(this.a, -1, -1);
        this.a = db.var_db_a;
        this.com_arenaofkings_packets_gameserver_data_HitCircle_a().setData(n8, n9, 16);
        this.a = new EffectManager(engine);
        this.a = new cr(engine, this.a, this.a, this.a, this.a, n3);
        this.a = new bq(this.a, this.a, this.a, this.a);
        this.a.setMovementManager(this.a);
        this.a.a(this.a);
        this.a(engine, false);
        this.a(profileBackgrounds);
        this.a(abi.valueOf(string2), 1);
        this.a(abi.valueOf(string3), 2);
        this.a(abi.valueOf(string4), 3);
        this.void_b();
    }

    public ei(Engine engine, String string, int n2, String string2, int n3, int n4, int n5, int n6, int n7) {
        super(CharacterClass.fromString(string2));
        this.a = string;
        this.a = CharacterClass.fromString(string2);
        this.d = n3;
        this.e = n2;
        this.a = new gs();
        this.a(this.a, n6, n7);
        this.a = db.var_db_a;
        this.com_arenaofkings_packets_gameserver_data_HitCircle_a().setData(n4, n5, 16);
        this.a = new EffectManager(engine);
        this.a = new cr(engine, this.a, this.a, this.a, this.a, n3);
        this.a = new bq(this.a, this.a, this.a, this.a);
        this.a.setMovementManager(this.a);
        this.a.a(this.a);
        this.a(engine, false);
        this.void_c();
    }

    @Override
    public void void_a(int n2) {
        super.void_a(n2);
        ((gt)this.a).void_a(n2);
    }
}

