/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ArmorRequirement;
import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemArmorType;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemSlot;

public class fv
extends fh {
    private ItemArmorType a;

    public fv(ItemData itemData) {
        super(itemData);
        for (EquippableRequirement equippableRequirement : itemData.getRequirements()) {
            if (!(equippableRequirement instanceof ArmorRequirement)) continue;
            this.a = ((ArmorRequirement)equippableRequirement).getArmorType();
        }
        if (this.a == ItemSlot.BACK) {
            this.a = ItemArmorType.CLOTH;
        }
        switch (this.a) {
            case CLOTH: {
                this.a = ajw.ke;
                break;
            }
            case LEATHER: {
                this.a = ajw.kf;
                break;
            }
            case MISC: {
                break;
            }
            case PLATE: {
                this.a = ajw.kg;
                break;
            }
        }
    }

    @Override
    public void a(axm axm2, boolean bl2) {
        if (bl2 || this.a == null) {
            String string = this.a.name() + "_" + this.a.name() + "_T" + ((fp)((Object)this.a)).int_a();
            this.a = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), string, true);
            this.a = (ItemArmorType)true;
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

