/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ClassRequirement;
import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemData;

public class ga
extends fh {
    protected CharacterClass a;

    public ga(ItemData itemData) {
        super(itemData);
        for (EquippableRequirement equippableRequirement : itemData.getRequirements()) {
            if (!(equippableRequirement instanceof ClassRequirement)) continue;
            this.a = ((ClassRequirement)equippableRequirement).getClassRequirement();
        }
        switch (this.a) {
            case ASSASSIN: {
                this.a = ajw.kj;
                break;
            }
            case CHAMPION: {
                this.a = ajw.km;
                break;
            }
            case ELDER: {
                this.a = ajw.kn;
                break;
            }
            case LICH: {
                this.a = ajw.ko;
                break;
            }
            case MYSTIC: {
                this.a = ajw.ko;
                break;
            }
            case NIHILIST: {
                this.a = ajw.kk;
                break;
            }
            case PALADIN: {
                this.a = ajw.kl;
                break;
            }
            case RANGER: {
                this.a = ajw.kh;
                break;
            }
            case SCHOLAR: {
                this.a = ajw.ki;
                break;
            }
            case WIZARD: {
                this.a = ajw.kn;
                break;
            }
        }
    }

    @Override
    public void a(axm axm2, boolean bl2) {
        if (bl2 || this.a == null) {
            String string = "WEAPON_" + (Object)((Object)((fp)((Object)this.a)).com_arenaofkings_packets_misc_CharacterClass_a()) + "_T" + ((fp)((Object)this.a)).int_a();
            this.a = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), string, true);
            this.a = (CharacterClass)true;
        }
        this.b(axm2, bl2);
        this.c(axm2, bl2);
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.a != null) {
            ((ayh)((Object)this.a)).a(f2, engine);
        }
        if (this.c != null) {
            this.c.a(f2, engine);
        }
    }
}

