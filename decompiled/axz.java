/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_FRIEND_STATUS_UPDATE;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class axz
extends azl<ayq> {
    private ayh c;
    private azv var_azv_a = new azv(1000L, true);
    private boolean var_boolean_a = false;

    public axz() {
    }

    public axz(ArrayList<PUB_FRIEND_STATUS_UPDATE> arrayList) {
        int n2 = 0;
        for (PUB_FRIEND_STATUS_UPDATE pUB_FRIEND_STATUS_UPDATE : arrayList) {
            Engine.a(pUB_FRIEND_STATUS_UPDATE.toString());
            if (pUB_FRIEND_STATUS_UPDATE.account_name.equals("UNKNOWN")) continue;
            ((Array)((Object)this.var_azv_a)).add(new ayq(n2++, pUB_FRIEND_STATUS_UPDATE.account_name, pUB_FRIEND_STATUS_UPDATE.character_name, pUB_FRIEND_STATUS_UPDATE.playerStatus, pUB_FRIEND_STATUS_UPDATE.relationshipStatus, "Status Message"));
        }
        ((Array)((Object)this.var_azv_a)).sort();
        this.var_azv_a = (azv)10;
    }

    public void a(ayq ayq2) {
        ((Array)((Object)this.var_azv_a)).add(ayq2);
        ((Array)((Object)this.var_azv_a)).sort();
        int n2 = 0;
        Iterator iterator = ((Array)((Object)this.var_azv_a)).iterator();
        while (iterator.hasNext()) {
            ayq ayq3 = (ayq)iterator.next();
            ayq3.a(n2++);
        }
    }

    public void a(TextureAtlas textureAtlas, String string, String string2, String string3, int n2, int n3) {
        super.a(textureAtlas, string2, string3, n2, n3);
        this.c = new ayh(textureAtlas.createSprite(string));
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
    }

    /*
     * WARNING - void declaration
     */
    public void a(float f2, Engine engine, axm axm2) {
        this.var_boolean_a = this.var_azv_a.a(TimeUnit.SECONDS) % 2L == 0L;
        if (((Array)((Object)this.var_azv_a)).size <= 10) {
            this.var_azv_a = (azv)((Array)((Object)this.var_azv_a)).size;
        }
        if (this.var_azv_a >= 10) {
            reference var4_4 = this.var_azv_a - 10;
            int i3 = 0;
            for (int i2 = this.b; i2 < this.var_azv_a; ++i2) {
                if (i2 >= ((Array)((Object)this.var_azv_a)).size) {
                    return;
                }
                int n2 = i2 - var4_4;
                if (((Array)((Object)this.var_azv_a)).get(i2) != null) {
                    ((ayq)((Array)((Object)this.var_azv_a)).get(i2)).a(n2);
                    ((ayq)((Array)((Object)this.var_azv_a)).get(i2)).a(f2, engine, axm2, 1560, 295 - n2 * 28);
                    ((ayq)((Array)((Object)this.var_azv_a)).get(i2)).a(f2, engine, 1560.0f, (float)(295 - n2 * 28), this.var_boolean_a);
                }
                ++i3;
            }
        } else {
            boolean n4 = false;
            for (int i3 = this.b; i3 < ((Array)((Object)this.var_azv_a)).size; ++i3) {
                void var4_6;
                if (i3 >= ((Array)((Object)this.var_azv_a)).size) {
                    return;
                }
                if (((Array)((Object)this.var_azv_a)).get(i3) != null) {
                    ((ayq)((Array)((Object)this.var_azv_a)).get(i3)).a((int)var4_6);
                    ((ayq)((Array)((Object)this.var_azv_a)).get(i3)).a(f2, engine, axm2, 1560, 295 - var4_6 * 28);
                    ((ayq)((Array)((Object)this.var_azv_a)).get(i3)).a(f2, engine, 1560.0f, (float)(295 - var4_6 * 28), this.var_boolean_a);
                }
                ++var4_6;
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
    }

    public ayq a(String string) {
        Iterator iterator = ((Array)((Object)this.var_azv_a)).iterator();
        while (iterator.hasNext()) {
            ayq ayq2 = (ayq)iterator.next();
            if (!ayq2.var_java_lang_String_a.equals(string)) continue;
            return ayq2;
        }
        return null;
    }
}

