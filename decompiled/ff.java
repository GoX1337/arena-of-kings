/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemRarity;

public class ff
extends fh {
    private ayg a = ItemRarity.COMMON;

    public ff(ItemLocation itemLocation, int n2) {
        super(itemLocation, n2);
        this.b = -1;
        this.a(itemLocation);
    }

    public void a(ItemLocation itemLocation) {
        switch (itemLocation) {
            case EQUIPPED: {
                break;
            }
            case GROUND: {
                break;
            }
            case INVENTORY: {
                this.a = new ayg(1554 + this.c % 6 * 57, 356 - (int)Math.floor(this.c / 6) * 57, 1611 + this.c % 6 * 57, 413 - (int)Math.floor(this.c / 6) * 57);
                break;
            }
            case STASH: {
                this.a = new ayg(1074 + this.c % 8 * 57, 852 - (int)Math.floor(this.c / 8) * 57, 1131 + this.c % 8 * 57, 909 - (int)Math.floor(this.c / 8) * 57);
                break;
            }
            case VENDOR: {
                break;
            }
            case TRADE: {
                this.a = new ayg(434 + this.c % 6 * 57, 359 - (int)Math.floor(this.c / 6) * 57, 491 + this.c % 6 * 57, 416 - (int)Math.floor(this.c / 6) * 57);
                break;
            }
        }
    }

    @Override
    public boolean boolean_a() {
        if (this.a == null) {
            return false;
        }
        return this.a.boolean_e();
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.a != null) {
            this.a.b(engine);
        }
    }

    @Override
    public void a(int n2) {
        super.a(n2);
        this.a((ItemLocation)((Object)this.a));
    }

    @Override
    public void a(int n2, ItemLocation itemLocation) {
        super.a(n2, itemLocation);
        this.a((ItemLocation)((Object)this.a));
    }
}

