/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemData;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class d
extends Label {
    private Engine var_com_arenaofkings_client_core_Engine_a;
    private fm var_fm_a;
    private boolean var_boolean_a = false;
    public ayh var_ayh_a;

    public d(String string, Label.LabelStyle labelStyle, ItemData itemData, Engine engine) {
        super((CharSequence)string, labelStyle);
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        if (itemData != null) {
            switch (itemData.getItemSlot()) {
                case HEAD: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case SHOULDER: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case CHEST: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case HANDS: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case WRIST: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case LEGS: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case FEET: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case BACK: {
                    this.var_fm_a = new fv(itemData);
                    break;
                }
                case NECK: {
                    this.var_fm_a = new fy(itemData);
                    break;
                }
                case RING: {
                    this.var_fm_a = new fy(itemData);
                    break;
                }
                case TRINKET: {
                    this.var_fm_a = new fy(itemData);
                    break;
                }
                case WEAPON: {
                    this.var_fm_a = new ga(itemData);
                    break;
                }
                case CONSUMABLE: {
                    this.var_fm_a = new fx(itemData);
                    break;
                }
            }
        }
        if (this.var_fm_a != null) {
            this.addListener(new e(this, engine));
        }
    }

    @Override
    public void draw(Batch batch, float f2) {
        if (this.isVisible()) {
            super.draw(batch, f2);
            if (this.var_ayh_a != null) {
                if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                    this.var_ayh_a.a(batch, (int)this.getX() - 4, (int)this.getY() - 16, 1.0f);
                } else if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a) && !((agd)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).agn_a().i_a().boolean_c()) {
                    this.var_ayh_a.a(batch, (int)this.getX() - 4, (int)this.getY() - 16, ((agd)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).agn_a().i_a().float_a());
                }
            }
        }
    }

    @Override
    public boolean remove() {
        Engine.b("just removed: " + this.getText());
        return super.remove();
    }

    public fm fm_a() {
        return this.var_fm_a;
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    static /* synthetic */ fm a(d d2) {
        return d2.var_fm_a;
    }
}

