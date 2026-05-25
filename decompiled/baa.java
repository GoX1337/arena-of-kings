/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

public class baa {
    private final AssetManager var_com_badlogic_gdx_assets_AssetManager_a;
    public static float var_float_a;
    public static float b;
    private boolean var_boolean_a = false;
    private float c = 0.75f;

    public baa(AssetManager assetManager) {
        this.var_com_badlogic_gdx_assets_AssetManager_a = assetManager;
        Engine.b("new SoundManager()");
    }

    public void a(ajw ajw2) {
        if (this.var_boolean_a) {
            return;
        }
        if (ajw2 != null && this.var_com_badlogic_gdx_assets_AssetManager_a.contains(ajw2.a())) {
            System.out.println("Sound found and playing");
            ((Sound)this.var_com_badlogic_gdx_assets_AssetManager_a.get(ajw2.a())).play(0.15f);
        }
    }

    public void a(ajw ajw2, float f2, float f3, float f4) {
        if (this.var_boolean_a) {
            return;
        }
        System.out.println("Locational sound Volume: " + f4);
        HitCircle hitCircle = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a();
        float f5 = axp.float_a((double)f2, f3, hitCircle.getX(), hitCircle.getY());
        int n2 = 0;
        n2 = f2 > hitCircle.getX() ? 1 : -1;
        System.out.println("Distance: " + f5 + " L/R " + n2);
        if (f5 > 250.0f) {
            float f6 = 0.1f;
            float f7 = (float)n2 * (f6 * (f5 / 100.0f));
            System.out.println("Pre Pan: " + f7);
            if (f7 > 1.0f) {
                f7 = 1.0f;
            } else if (f7 < -1.0f) {
                f7 = -1.0f;
            }
            System.out.println("sensitivity: " + f6);
            if (this.var_boolean_a) {
                return;
            }
            if (ajw2 != null) {
                Sound sound = (Sound)this.var_com_badlogic_gdx_assets_AssetManager_a.get(ajw2.a());
                sound.play(f4, 1.0f, f7);
            } else {
                Engine.b("ERROR: playSound NULL: " + (Object)((Object)ajw2));
            }
        } else {
            this.a(ajw2, 1.1f * f4);
        }
    }

    public void a(ajw ajw2, float f2) {
        System.out.println("PLAY SOUNDa: " + (Object)((Object)ajw2) + " " + f2);
        if (this.var_boolean_a) {
            return;
        }
        if (ajw2 != null) {
            if (this.var_com_badlogic_gdx_assets_AssetManager_a.contains(ajw2.a())) {
                Sound sound = (Sound)this.var_com_badlogic_gdx_assets_AssetManager_a.get(ajw2.a());
                System.out.println("Play sound at volume: " + f2 * this.c);
                sound.play(f2 * this.c);
            }
        } else {
            Engine.b("ERROR: playSound NULL: " + (Object)((Object)ajw2));
        }
    }

    public void a(ajw ajw2, ItemRarity itemRarity) {
        System.out.println("PLAY SOUNDb: " + (Object)((Object)ajw2));
        if (this.var_boolean_a) {
            return;
        }
        if (ajw2 != null) {
            switch (itemRarity) {
                case COMMON: {
                    this.a(ajw2, 0.25f);
                    break;
                }
                case UNCOMMON: {
                    this.a(ajw2, 0.3f);
                    break;
                }
                case RARE: {
                    this.a(ajw2, 0.4f);
                    break;
                }
                case EPIC: {
                    this.a(ajw2, 0.55f);
                    break;
                }
                case LEGENDARY: {
                    this.a(ajw2, 1.0f);
                    break;
                }
                case UNIQUE: {
                    this.a(ajw2, 1.0f);
                    break;
                }
            }
            Engine.b("Playing sound: " + (Object)((Object)ajw2));
        } else {
            Engine.b("doesn't contain key: " + (Object)((Object)ajw2));
        }
    }

    public void a(float f2) {
        this.c = f2;
        System.out.println("global volume is: " + this.c);
    }

    static {
        var_float_a = 1.0f;
        b = 2.0f;
    }
}

