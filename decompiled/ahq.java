/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ahq
extends ahs {
    public ahq(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, br br2, gz gz2, EffectManager effectManager, HitCircle hitCircle, boolean bl2, gx gx2, CharacterClass characterClass, int n2) {
        super(engine, textureAtlas, textureAtlas2, br2, gz2, effectManager, hitCircle, bl2, gx2, characterClass, n2);
        switch (gx2) {
            case c: {
                this.b = new agv(textureAtlas, "v3_nameplate_mana_bar");
                break;
            }
            case e: {
                this.b = new agv(textureAtlas, "v3_nameplate_rage_bar");
                System.out.println("Made enemy RAGE");
                break;
            }
            case d: {
                this.b = new agv(textureAtlas, "v3_nameplate_energy_bar");
                System.out.println("Made enemy ENERGY");
            }
        }
    }
}

