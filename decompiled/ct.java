/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.Locale;

public class ct {
    private boolean var_boolean_a = new ObjectMap();
    private boolean b = false;
    protected final ObjectMap<CharacterClass, da> cfr_renamed_47;

    public void a(AssetManager assetManager, CharacterClass characterClass, db db2, int n2) {
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
                    this.a(CharacterClass.ASSASSIN, 30, textureAtlas, 0, 2);
                    break;
                }
                case CHAMPION: {
                    this.a(CharacterClass.CHAMPION, 30, textureAtlas, -52, -19);
                    break;
                }
                case ELDER: {
                    this.a(CharacterClass.ELDER, 30, textureAtlas, 20, 27);
                    break;
                }
                case PALADIN: {
                    this.a(CharacterClass.PALADIN, 30, textureAtlas, 0, 17);
                    break;
                }
                case LICH: {
                    this.a(CharacterClass.LICH, 30, textureAtlas, -2, -6);
                    break;
                }
                case SCHOLAR: {
                    this.a(CharacterClass.SCHOLAR, 30, textureAtlas, 54, 34);
                    break;
                }
                case NIHILIST: {
                    this.a(CharacterClass.NIHILIST, 30, textureAtlas, 6, 1);
                    break;
                }
                case MYSTIC: {
                    this.a(CharacterClass.MYSTIC, 31, textureAtlas, -1, -4);
                    break;
                }
                case RANGER: {
                    this.a(CharacterClass.RANGER, 31, textureAtlas, 0, -2);
                    break;
                }
                case WIZARD: {
                    this.a(CharacterClass.WIZARD, 30, textureAtlas, 4, -5);
                }
            }
        } else if (n2 == 2) {
            switch (characterClass) {
                case ASSASSIN: {
                    this.a(CharacterClass.ASSASSIN, 30, textureAtlas, -3, 12);
                    break;
                }
                case ELDER: {
                    this.a(CharacterClass.ELDER, 32, textureAtlas, -2, 15);
                    break;
                }
                case PALADIN: {
                    break;
                }
                case LICH: {
                    this.a(CharacterClass.LICH, 30, textureAtlas, -6, 13);
                    break;
                }
                case SCHOLAR: {
                    this.a(CharacterClass.SCHOLAR, 31, textureAtlas, -3, 12);
                    break;
                }
                case NIHILIST: {
                    this.a(CharacterClass.NIHILIST, 30, textureAtlas, -16, -17);
                    break;
                }
                case MYSTIC: {
                    this.a(CharacterClass.MYSTIC, 31, textureAtlas, 16, 5);
                    break;
                }
                case RANGER: {
                    this.a(CharacterClass.RANGER, 31, textureAtlas, 0, 0);
                    break;
                }
                case CHAMPION: 
                case WIZARD: {
                    this.a(CharacterClass.WIZARD, 31, textureAtlas, -45, 0);
                }
            }
        }
        Engine.a("PlayerSheetAnimations.loadIdleSouthGFX() out");
    }

    private void a(CharacterClass characterClass, int n2, TextureAtlas textureAtlas, int n3, int n4) {
        Engine.a("loadIdleSouth in");
        PlayerAction playerAction = PlayerAction.IDLE_SOUTH;
        Engine.a("playerAction: " + (Object)((Object)playerAction));
        if (this.var_boolean_a.get(characterClass) == null) {
            Object object;
            Sprite[] spriteArray = new Sprite[n2];
            int n5 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                object = textureAtlas.createSprite(cw.d.toString().toLowerCase(Locale.US), i2);
                this.a((Sprite)object);
                if (object != null) {
                    spriteArray[n5] = object;
                    ++n5;
                    continue;
                }
                Engine.a("[ERROR] Failed to loadIdleSouth: '" + (Object)((Object)characterClass) + "' index: " + i2);
            }
            Animation<Sprite> animation = new Animation<Sprite>(0.025f, spriteArray);
            animation.setPlayMode(Animation.PlayMode.LOOP);
            object = new da(animation, n3, n4);
            this.var_boolean_a.put(characterClass, object);
        }
        Engine.a("loadIdleSouth out");
    }

    private void a(Sprite sprite) {
        sprite.setScale(1.1f);
    }

    public da a(CharacterClass characterClass) {
        return (da)this.var_boolean_a.get(characterClass);
    }
}

