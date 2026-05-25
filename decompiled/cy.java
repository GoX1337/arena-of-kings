/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.Locale;

public class cy {
    private boolean var_boolean_a = new ObjectMap();
    private boolean var_boolean_b = new ObjectMap();
    protected final ObjectMap<PlayerAction, da> cfr_renamed_48;
    protected final ObjectMap<PlayerAction, da> cfr_renamed_49;
    protected final ObjectMap<PlayerAction, da> c = new ObjectMap();
    protected ObjectMap<PlayerAction, da> d = new ObjectMap();

    public void a(AssetManager assetManager, CharacterClass characterClass, db db2, int n2) {
        Engine.b("LOADING: " + (Object)((Object)characterClass) + " " + n2);
        TextureAtlas textureAtlas = (TextureAtlas)assetManager.get("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/outfit_" + n2 + "/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
        if (n2 == 1) {
            switch (characterClass) {
                case ASSASSIN: {
                    this.c(cw.var_cw_a, 30, textureAtlas, 0, 0, true);
                    this.c(cw.f, 32, textureAtlas, 0, 0, true);
                    this.c(cw.b, 31, textureAtlas, 0, 0, true);
                    this.c(cw.g, 32, textureAtlas, 0, 0, true);
                    this.c(cw.c, 30, textureAtlas, 0, 0, true);
                    this.b(cw.d, 30, textureAtlas, 0, 9, true);
                    this.c(cw.e, 32, textureAtlas, -5, 0, true);
                    break;
                }
                case CHAMPION: {
                    this.c(cw.var_cw_a, 32, textureAtlas, -52, -19, true);
                    this.c(cw.f, 33, textureAtlas, -52, -19, true);
                    this.c(cw.b, 30, textureAtlas, -52, -19, true);
                    this.c(cw.g, 33, textureAtlas, -52, -19, true);
                    this.c(cw.c, 35, textureAtlas, -52, -19, true);
                    this.b(cw.d, 30, textureAtlas, -52, -19, true);
                    this.c(cw.e, 33, textureAtlas, -52, -19, true);
                    break;
                }
                case ELDER: {
                    this.c(cw.b, 31, textureAtlas, 20, 29, true);
                    this.c(cw.g, 32, textureAtlas, 20, 29, true);
                    this.c(cw.c, 36, textureAtlas, 20, 29, true);
                    this.b(cw.d, 30, textureAtlas, 20, 29, true);
                    this.c(cw.e, 32, textureAtlas, 20, 29, true);
                    TextureAtlas textureAtlas2 = (TextureAtlas)assetManager.get("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/wolf/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.var_boolean_b.clear();
                    Engine.a("WolfAtlas: packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/wolf/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.a(cw.e, 31, textureAtlas2, (ObjectMap<PlayerAction, da>)this.var_boolean_b, 52, 51, 0.033333335f, false);
                    this.a(cw.d, 30, textureAtlas2, (ObjectMap<PlayerAction, da>)this.var_boolean_b, 52, 51, 0.033333335f, false);
                    TextureAtlas textureAtlas3 = (TextureAtlas)assetManager.get("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/bear/full.atlas");
                    this.c.clear();
                    this.a(cw.var_cw_a, 32, textureAtlas3, this.c, -59, -35, 0.025f, true);
                    this.a(cw.f, 25, textureAtlas3, this.c, -59, -35, 0.025f, true);
                    this.a(cw.d, 27, textureAtlas3, this.c, -59, -35, 0.025f, true);
                    this.a(cw.c, 22, textureAtlas3, this.c, -59, -35, 0.025f, true);
                    this.a(cw.e, 25, textureAtlas3, this.c, -59, -35, 0.025f, true);
                    break;
                }
                case LICH: {
                    this.c(cw.b, 30, textureAtlas, -2, -3, true);
                    this.c(cw.g, 32, textureAtlas, -2, -3, true);
                    this.c(cw.c, 30, textureAtlas, -2, -3, true);
                    this.b(cw.d, 30, textureAtlas, -2, -3, true);
                    this.c(cw.e, 32, textureAtlas, -2, -3, true);
                    break;
                }
                case PALADIN: {
                    this.c(cw.var_cw_a, 35, textureAtlas, 0, 19, true);
                    this.c(cw.f, 33, textureAtlas, 0, 19, true);
                    this.c(cw.b, 31, textureAtlas, 0, 19, true);
                    this.c(cw.g, 33, textureAtlas, 0, 19, true);
                    this.c(cw.c, 36, textureAtlas, 0, 19, true);
                    this.b(cw.d, 30, textureAtlas, 0, 19, true);
                    this.c(cw.e, 33, textureAtlas, 0, 19, true);
                    break;
                }
                case MYSTIC: {
                    this.c(cw.b, 35, textureAtlas, -1, 4, true);
                    this.c(cw.g, 32, textureAtlas, -1, 4, true);
                    this.c(cw.c, 40, textureAtlas, -1, 4, true);
                    this.b(cw.d, 31, textureAtlas, -1, 4, true);
                    this.c(cw.e, 32, textureAtlas, -1, 4, true);
                    break;
                }
                case NIHILIST: {
                    this.c(cw.b, 30, textureAtlas, 9, 13, true);
                    this.c(cw.g, 32, textureAtlas, 9, 13, true);
                    this.c(cw.c, 31, textureAtlas, 9, 13, true);
                    this.b(cw.d, 30, textureAtlas, 9, 13, true);
                    this.c(cw.e, 32, textureAtlas, 9, 13, true);
                    break;
                }
                case RANGER: {
                    this.c(cw.var_cw_a, 41, textureAtlas, 0, 0, true);
                    this.c(cw.f, 33, textureAtlas, 0, 0, true);
                    this.c(cw.b, 40, textureAtlas, 0, 0, true);
                    this.c(cw.g, 32, textureAtlas, 0, 0, true);
                    this.c(cw.c, 35, textureAtlas, 0, 0, true);
                    this.b(cw.d, 31, textureAtlas, 0, 0, true);
                    this.c(cw.e, 32, textureAtlas, 0, 0, true);
                    break;
                }
                case SCHOLAR: {
                    this.c(cw.b, 31, textureAtlas, 57, 51, true);
                    this.c(cw.g, 32, textureAtlas, 57, 51, true);
                    this.c(cw.c, 31, textureAtlas, 57, 51, true);
                    this.b(cw.d, 30, textureAtlas, 57, 51, true);
                    this.c(cw.e, 32, textureAtlas, 57, 51, true);
                    break;
                }
                case WIZARD: {
                    this.c(cw.b, 29, textureAtlas, 4, -2, true);
                    this.c(cw.g, 32, textureAtlas, 4, -2, true);
                    this.c(cw.c, 27, textureAtlas, 4, -2, true);
                    this.b(cw.d, 30, textureAtlas, 4, -2, true);
                    this.c(cw.e, 32, textureAtlas, 4, -2, true);
                    TextureAtlas textureAtlas4 = (TextureAtlas)assetManager.get("packed/models/elder/sheep/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.d.clear();
                    Engine.a("SheepAtlas: packed/models/elder/sheep/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.a(cw.e, 21, textureAtlas4, 85, 81);
                    this.a(cw.d, 21, textureAtlas4, 85, 81);
                    break;
                }
            }
        } else if (n2 == 2) {
            switch (characterClass) {
                case ASSASSIN: {
                    this.c(cw.var_cw_a, 30, textureAtlas, -10, 18, true);
                    this.c(cw.f, 32, textureAtlas, -10, 18, true);
                    this.c(cw.b, 30, textureAtlas, -10, 18, true);
                    this.c(cw.g, 32, textureAtlas, -10, 18, true);
                    this.c(cw.c, 40, textureAtlas, -10, 18, true);
                    this.b(cw.d, 30, textureAtlas, -10, 18, true);
                    this.c(cw.e, 32, textureAtlas, -10, 18, true);
                    break;
                }
                case CHAMPION: {
                    this.c(cw.var_cw_a, 30, textureAtlas, -50, -18, true);
                    this.c(cw.f, 32, textureAtlas, -50, -18, true);
                    this.c(cw.b, 30, textureAtlas, -50, -18, true);
                    this.c(cw.g, 33, textureAtlas, -50, -18, true);
                    this.c(cw.c, 40, textureAtlas, -50, -18, true);
                    this.b(cw.d, 30, textureAtlas, -50, -18, true);
                    this.c(cw.e, 32, textureAtlas, -50, -18, true);
                    break;
                }
                case ELDER: {
                    this.c(cw.b, 29, textureAtlas, -100, -75, true);
                    this.c(cw.g, 32, textureAtlas, -100, -78, true);
                    this.c(cw.c, 30, textureAtlas, -100, -75, true);
                    this.b(cw.d, 32, textureAtlas, -100, -75, true);
                    this.c(cw.e, 32, textureAtlas, -100, -78, true);
                    TextureAtlas textureAtlas5 = (TextureAtlas)assetManager.get("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/wolf/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.var_boolean_b.clear();
                    Engine.a("WolfAtlas: packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/wolf/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.a(cw.e, 31, textureAtlas5, (ObjectMap<PlayerAction, da>)this.var_boolean_b, 52, 51, 0.033333335f, false);
                    this.a(cw.d, 30, textureAtlas5, (ObjectMap<PlayerAction, da>)this.var_boolean_b, 52, 51, 0.033333335f, false);
                    TextureAtlas textureAtlas6 = (TextureAtlas)assetManager.get("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/bear/full.atlas");
                    this.c.clear();
                    this.a(cw.var_cw_a, 32, textureAtlas6, this.c, -59, -35, 0.025f, true);
                    this.a(cw.f, 25, textureAtlas6, this.c, -59, -35, 0.025f, true);
                    this.a(cw.d, 27, textureAtlas6, this.c, -59, -35, 0.025f, true);
                    this.a(cw.c, 22, textureAtlas6, this.c, -59, -35, 0.025f, true);
                    this.a(cw.e, 25, textureAtlas6, this.c, -59, -35, 0.025f, true);
                    break;
                }
                case LICH: {
                    this.c(cw.b, 30, textureAtlas, -50, 17, true);
                    this.c(cw.g, 33, textureAtlas, -50, 17, true);
                    this.c(cw.c, 35, textureAtlas, -50, 17, true);
                    this.b(cw.d, 30, textureAtlas, -50, 17, true);
                    this.c(cw.e, 33, textureAtlas, -50, 17, true);
                    break;
                }
                case MYSTIC: {
                    this.c(cw.b, 30, textureAtlas, -57, 8, true);
                    this.c(cw.g, 33, textureAtlas, -57, 8, true);
                    this.c(cw.c, 36, textureAtlas, -57, 8, true);
                    this.b(cw.d, 31, textureAtlas, -57, 8, true);
                    this.c(cw.e, 33, textureAtlas, -57, 8, true);
                    break;
                }
                case NIHILIST: {
                    this.c(cw.b, 30, textureAtlas, -22, -9, true);
                    this.c(cw.g, 32, textureAtlas, -22, -9, true);
                    this.c(cw.c, 31, textureAtlas, -22, -9, true);
                    this.b(cw.d, 30, textureAtlas, -22, -9, true);
                    this.c(cw.e, 32, textureAtlas, -22, -9, true);
                    break;
                }
                case PALADIN: {
                    this.c(cw.var_cw_a, 27, textureAtlas, -20, 15, true);
                    this.c(cw.f, 33, textureAtlas, -20, 15, true);
                    this.c(cw.b, 34, textureAtlas, -20, 15, true);
                    this.c(cw.g, 33, textureAtlas, -20, 15, true);
                    this.c(cw.c, 30, textureAtlas, -20, 15, true);
                    this.b(cw.d, 31, textureAtlas, -20, 15, true);
                    this.c(cw.e, 33, textureAtlas, -20, 15, true);
                    break;
                }
                case RANGER: {
                    this.c(cw.var_cw_a, 41, textureAtlas, -11, 0, true);
                    this.c(cw.f, 33, textureAtlas, -11, 0, true);
                    this.c(cw.b, 40, textureAtlas, -11, 0, true);
                    this.c(cw.g, 32, textureAtlas, -11, 0, true);
                    this.c(cw.c, 36, textureAtlas, -11, 0, true);
                    this.b(cw.d, 31, textureAtlas, -11, 0, true);
                    this.c(cw.e, 33, textureAtlas, -11, 0, true);
                    break;
                }
                case SCHOLAR: {
                    this.c(cw.b, 31, textureAtlas, -12, 40, true);
                    this.c(cw.g, 32, textureAtlas, -12, 40, true);
                    this.c(cw.c, 31, textureAtlas, -12, 40, true);
                    this.b(cw.d, 31, textureAtlas, -12, 40, true);
                    this.c(cw.e, 32, textureAtlas, -12, 40, true);
                    break;
                }
                case WIZARD: {
                    this.c(cw.b, 31, textureAtlas, -45, 8, true);
                    this.c(cw.g, 33, textureAtlas, -45, 8, true);
                    this.c(cw.c, 35, textureAtlas, -45, 8, true);
                    this.b(cw.d, 31, textureAtlas, -45, 8, true);
                    this.c(cw.e, 33, textureAtlas, -45, 8, true);
                    TextureAtlas textureAtlas7 = (TextureAtlas)assetManager.get("packed/models/elder/sheep/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.d.clear();
                    Engine.a("SheepAtlas: packed/models/elder/sheep/" + db2.toString().toLowerCase(Locale.US) + "/full.atlas");
                    this.a(cw.e, 21, textureAtlas7, 85, 81);
                    this.a(cw.d, 21, textureAtlas7, 85, 81);
                    break;
                }
            }
        } else if (n2 == 3) {
            switch (characterClass) {
                case LICH: {
                    this.c(cw.b, 32, textureAtlas, -50, 17, true);
                    this.c(cw.g, 32, textureAtlas, -50, 17, true);
                    this.c(cw.c, 31, textureAtlas, -50, 17, true);
                    this.b(cw.d, 33, textureAtlas, -50, 17, true);
                    this.c(cw.e, 32, textureAtlas, -50, 17, true);
                    break;
                }
                case SCHOLAR: {
                    this.c(cw.b, 30, textureAtlas, -116, -2, false);
                    this.c(cw.g, 32, textureAtlas, -116, -2, false);
                    this.c(cw.c, 30, textureAtlas, -116, -2, false);
                    this.b(cw.d, 30, textureAtlas, -116, -2, false);
                    this.c(cw.e, 32, textureAtlas, -116, -2, false);
                }
            }
        }
        Engine.b("LOADED: " + (Object)((Object)characterClass) + " " + n2);
    }

    public void b(AssetManager assetManager, CharacterClass characterClass, db db2, int n2) {
        Engine.a("PlayerSheetAnimations.loadIdleSouthGFX() in");
        Engine.a("Attempting to load idle: " + (Object)((Object)characterClass) + " " + (Object)((Object)db2) + " " + n2);
        if (assetManager.isLoaded("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/outfit_" + n2 + "/" + db2.toString().toLowerCase(Locale.US) + "/idle.atlas")) {
            Engine.a("idle loaded");
        } else {
            Engine.a("idle not loaded");
        }
        TextureAtlas textureAtlas = (TextureAtlas)assetManager.get("packed/models/" + characterClass.toString().toLowerCase(Locale.US) + "/outfit_" + n2 + "/" + db2.toString().toLowerCase(Locale.US) + "/idle.atlas");
        Engine.a("lol2");
        if (n2 == 1) {
            switch (characterClass) {
                case ASSASSIN: {
                    this.a(cw.d, 30, textureAtlas, 0, 9, true);
                    break;
                }
                case CHAMPION: {
                    this.a(cw.d, 30, textureAtlas, -52, -19, true);
                    break;
                }
                case ELDER: {
                    this.a(cw.d, 30, textureAtlas, 20, 27, true);
                    break;
                }
                case LICH: {
                    this.a(cw.d, 30, textureAtlas, -2, -3, true);
                    break;
                }
                case MYSTIC: {
                    this.a(cw.d, 31, textureAtlas, -1, 4, true);
                    break;
                }
                case NIHILIST: {
                    this.a(cw.d, 30, textureAtlas, 9, 13, true);
                    break;
                }
                case PALADIN: {
                    this.a(cw.d, 30, textureAtlas, 0, 19, true);
                    break;
                }
                case RANGER: {
                    this.a(cw.d, 31, textureAtlas, 0, 0, true);
                    break;
                }
                case SCHOLAR: {
                    this.a(cw.d, 30, textureAtlas, 57, 51, true);
                    break;
                }
                case WIZARD: {
                    this.a(cw.d, 30, textureAtlas, 4, -2, true);
                }
            }
        } else if (n2 == 2) {
            switch (characterClass) {
                case ASSASSIN: {
                    this.a(cw.d, 30, textureAtlas, -10, 20, true);
                    break;
                }
                case CHAMPION: {
                    this.a(cw.d, 30, textureAtlas, -50, -18, true);
                    break;
                }
                case ELDER: {
                    this.a(cw.d, 32, textureAtlas, -100, -78, true);
                    break;
                }
                case LICH: {
                    this.a(cw.d, 30, textureAtlas, -50, 17, true);
                    break;
                }
                case MYSTIC: {
                    this.a(cw.d, 31, textureAtlas, -57, 8, true);
                    break;
                }
                case NIHILIST: {
                    this.a(cw.d, 30, textureAtlas, -19, -9, true);
                    break;
                }
                case PALADIN: {
                    this.a(cw.d, 31, textureAtlas, -20, 15, true);
                    break;
                }
                case RANGER: {
                    this.a(cw.d, 31, textureAtlas, -11, 0, true);
                    break;
                }
                case SCHOLAR: {
                    this.a(cw.d, 31, textureAtlas, -12, 40, true);
                    break;
                }
                case WIZARD: {
                    this.a(cw.d, 31, textureAtlas, -45, 8, true);
                }
            }
        } else if (n2 == 3) {
            switch (characterClass) {
                case LICH: {
                    this.a(cw.d, 33, textureAtlas, -50, 17, true);
                }
                case SCHOLAR: {
                    this.a(cw.d, 30, textureAtlas, -116, -2, false);
                }
            }
        }
        Engine.a("PlayerSheetAnimations.loadIdleSouthGFX() out");
    }

    public void a(boolean bl2) {
        this.var_boolean_a.remove(PlayerAction.ATTACK_NORTH);
        this.var_boolean_a.remove(PlayerAction.ATTACK_SOUTH);
        this.var_boolean_a.remove(PlayerAction.ATTACK_EAST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_WEST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_SOUTH_WEST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_NORTH);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_SOUTH);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_EAST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_WEST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.ATTACK_RUN_SOUTH_WEST);
        this.var_boolean_a.remove(PlayerAction.CAST_NORTH);
        this.var_boolean_a.remove(PlayerAction.CAST_SOUTH);
        this.var_boolean_a.remove(PlayerAction.CAST_EAST);
        this.var_boolean_a.remove(PlayerAction.CAST_WEST);
        this.var_boolean_a.remove(PlayerAction.CAST_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.CAST_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.CAST_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.CAST_SOUTH_WEST);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_NORTH);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_SOUTH);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_EAST);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_WEST);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.CAST_RUN_SOUTH_WEST);
        this.var_boolean_a.remove(PlayerAction.RUN_NORTH);
        this.var_boolean_a.remove(PlayerAction.RUN_SOUTH);
        this.var_boolean_a.remove(PlayerAction.RUN_EAST);
        this.var_boolean_a.remove(PlayerAction.RUN_WEST);
        this.var_boolean_a.remove(PlayerAction.RUN_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.RUN_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.RUN_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.RUN_SOUTH_WEST);
        this.var_boolean_a.remove(PlayerAction.IDLE_NORTH);
        if (bl2) {
            this.var_boolean_a.remove(PlayerAction.IDLE_SOUTH);
        }
        this.var_boolean_a.remove(PlayerAction.IDLE_EAST);
        this.var_boolean_a.remove(PlayerAction.IDLE_WEST);
        this.var_boolean_a.remove(PlayerAction.IDLE_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.IDLE_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.IDLE_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.IDLE_SOUTH_WEST);
        this.var_boolean_a.remove(PlayerAction.DEATH_NORTH);
        this.var_boolean_a.remove(PlayerAction.DEATH_SOUTH);
        this.var_boolean_a.remove(PlayerAction.DEATH_EAST);
        this.var_boolean_a.remove(PlayerAction.DEATH_WEST);
        this.var_boolean_a.remove(PlayerAction.DEATH_NORTH_EAST);
        this.var_boolean_a.remove(PlayerAction.DEATH_NORTH_WEST);
        this.var_boolean_a.remove(PlayerAction.DEATH_SOUTH_EAST);
        this.var_boolean_a.remove(PlayerAction.DEATH_SOUTH_WEST);
    }

    private void a(cw cw2, int n2, TextureAtlas textureAtlas, int n3, int n4, boolean bl2) {
        Engine.a("loadIdleSouth in");
        PlayerAction playerAction = PlayerAction.findAction(cw2, 0);
        Engine.a("playerAction: " + (Object)((Object)playerAction));
        Engine.a("Animations size " + this.var_boolean_a.size);
        if (this.var_boolean_a.get(playerAction) == null) {
            Sprite[] spriteArray = new Sprite[n2];
            int n5 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Sprite object = textureAtlas.createSprite(cw.d.toString().toLowerCase(Locale.US), i2);
                if (bl2) {
                    this.a(object);
                }
                if (object != null) {
                    spriteArray[n5] = object;
                    ++n5;
                    continue;
                }
                Engine.a("[ERROR] Failed to loadIdleSouth: '" + cw2.toString().toLowerCase(Locale.US) + "' index: " + i2);
            }
            Animation<Sprite> animation = new Animation<Sprite>(0.025f, spriteArray);
            for (Sprite sprite : animation.getKeyFrames()) {
                sprite.getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
            }
            animation.setPlayMode(Animation.PlayMode.LOOP);
            da da2 = new da(animation, n3, n4);
            this.var_boolean_a.put(playerAction, da2);
        } else {
            Engine.a("player action: " + (Object)((Object)playerAction) + " is null");
        }
        Engine.a("loadIdleSouth out");
    }

    private void a(Sprite sprite) {
        sprite.setScale(1.1f);
    }

    private void b(Sprite sprite) {
        sprite.setScale(1.3f);
    }

    private void c(Sprite sprite) {
        sprite.setScale(1.5f);
    }

    private void b(cw cw2, int n2, TextureAtlas textureAtlas, int n3, int n4, boolean bl2) {
        Engine.a("loadIdleNoSouth in");
        for (int i2 = 10000; i2 <= 70000; i2 += 10000) {
            PlayerAction playerAction = PlayerAction.findAction(cw2, i2);
            if (this.var_boolean_a.get(playerAction) == null) {
                Sprite[] spriteArray = new Sprite[n2];
                int n5 = 0;
                for (int i3 = 0; i3 < n2; ++i3) {
                    Sprite sprite = textureAtlas.createSprite(cw2.toString().toLowerCase(Locale.US), i2 + i3);
                    if (bl2) {
                        this.a(sprite);
                    }
                    if (sprite != null) {
                        spriteArray[n5] = sprite;
                        ++n5;
                        continue;
                    }
                    Engine.a("[ERROR] Failed to loadIdleNoSouth: '" + cw2.toString().toLowerCase(Locale.US) + "' index: " + i2 + i3);
                }
                Animation<Sprite> animation = new Animation<Sprite>(0.025f, spriteArray);
                for (Sprite sprite : animation.getKeyFrames()) {
                    sprite.getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
                }
                animation.setPlayMode(Animation.PlayMode.LOOP);
                da object = new da(animation, n3, n4);
                this.var_boolean_a.put(playerAction, object);
                continue;
            }
            Engine.a("animations are null for action: " + (Object)((Object)cw2));
        }
        Engine.a("loadIdleNoSouth out");
    }

    private void c(cw cw2, int n2, TextureAtlas textureAtlas, int n3, int n4, boolean bl2) {
        Engine.a("loadAction in: " + (Object)((Object)cw2));
        for (int i2 = 0; i2 <= 70000; i2 += 10000) {
            PlayerAction playerAction = PlayerAction.findAction(cw2, i2);
            if (this.var_boolean_a.get(playerAction) != null) continue;
            Sprite[] spriteArray = new Sprite[n2];
            int n5 = 0;
            for (int i3 = 0; i3 < n2; ++i3) {
                Sprite sprite = textureAtlas.createSprite(cw2.toString().toLowerCase(Locale.US), i2 + i3);
                if (bl2) {
                    this.a(sprite);
                }
                if (sprite != null) {
                    spriteArray[n5] = sprite;
                    ++n5;
                    continue;
                }
                Engine.a("[ERROR] Failed to loadAction: '" + cw2.toString().toLowerCase(Locale.US) + "' index: " + i3);
            }
            Animation<Sprite> animation = new Animation<Sprite>(0.025f, spriteArray);
            for (Sprite sprite : animation.getKeyFrames()) {
                sprite.getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
            }
            animation.setPlayMode(Animation.PlayMode.LOOP);
            da object = new da(animation, n3, n4);
            this.var_boolean_a.put(playerAction, object);
        }
        Engine.a("loadAction out");
    }

    private void a(cw cw2, int n2, TextureAtlas textureAtlas, ObjectMap<PlayerAction, da> objectMap, int n3, int n4, float f2, boolean bl2) {
        Engine.b("loadPetAction in");
        for (int i2 = 0; i2 <= 70000; i2 += 10000) {
            Object object;
            PlayerAction playerAction = PlayerAction.findAction(cw2, i2);
            if (objectMap.get(playerAction) != null) continue;
            Sprite[] spriteArray = new Sprite[n2];
            int n5 = 0;
            for (int i3 = 0; i3 < n2; ++i3) {
                object = textureAtlas.createSprite(cw2.toString().toLowerCase(Locale.US), i2 + i3);
                Engine.b("loadPetAction " + (Object)((Object)playerAction) + " " + i2 + " " + n5 + " " + i3);
                if (object != null) {
                    if (bl2) {
                        this.b((Sprite)object);
                    } else {
                        this.a((Sprite)object);
                    }
                    spriteArray[n5] = object;
                    ++n5;
                    continue;
                }
                Engine.b("[ERROR] Failed to loadWolfAction: '" + cw2.toString().toLowerCase(Locale.US) + "' index: " + i3);
            }
            Animation<Sprite> animation = new Animation<Sprite>(f2, spriteArray);
            for (Sprite sprite : animation.getKeyFrames()) {
                sprite.getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
            }
            animation.setPlayMode(Animation.PlayMode.LOOP);
            object = new da(animation, n3, n4);
            ((da)object).a(Color.RED);
            objectMap.put(playerAction, (da)object);
        }
        Engine.a("loadWolfAction out");
    }

    private void a(cw cw2, int n2, TextureAtlas textureAtlas, int n3, int n4) {
        Engine.a("loadSheepAction in");
        for (int i2 = 0; i2 <= 70000; i2 += 10000) {
            PlayerAction playerAction = PlayerAction.findAction(cw2, i2);
            if (this.d.get(playerAction) != null) continue;
            Sprite[] spriteArray = new Sprite[n2];
            int n5 = 0;
            for (int i3 = 0; i3 < n2; ++i3) {
                Sprite sprite = textureAtlas.createSprite(cw2.toString().toLowerCase(Locale.US), i2 + i3);
                this.c(sprite);
                if (sprite != null) {
                    spriteArray[n5] = sprite;
                    ++n5;
                    continue;
                }
                Engine.a("[ERROR] Failed to loadSheepAction: '" + cw2.toString().toLowerCase(Locale.US) + "' index: " + i3);
            }
            Animation<Sprite> animation = new Animation<Sprite>(0.016666668f, spriteArray);
            for (Sprite sprite : animation.getKeyFrames()) {
                sprite.getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
            }
            animation.setPlayMode(Animation.PlayMode.LOOP);
            da object = new da(animation, n3, n4);
            this.d.put(playerAction, object);
        }
        Engine.a("loadSheepAction out");
    }

    public ObjectMap<PlayerAction, da> a() {
        return this.var_boolean_a;
    }

    public ObjectMap<PlayerAction, da> b() {
        return this.var_boolean_b;
    }

    public ObjectMap<PlayerAction, da> c() {
        return this.c;
    }

    public ObjectMap<PlayerAction, da> d() {
        return this.d;
    }

    public da a(PlayerAction playerAction) {
        da da2 = (da)this.var_boolean_a.get(playerAction);
        if (da2 == null) {
            da2 = this.c.get(playerAction);
        }
        if (da2 == null) {
            da2 = (da)this.var_boolean_b.get(playerAction);
        }
        if (da2 == null) {
            da2 = this.d.get(playerAction);
        }
        return da2;
    }

    public void a(ObjectMap<PlayerAction, da> objectMap) {
        this.d = objectMap;
    }
}

