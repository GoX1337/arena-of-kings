/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class aao
extends aam {
    public aao(int n2) {
        super(n2);
    }

    @Override
    public boolean a(we we2) {
        we2.wh_a().wg_a().g();
        if (we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() == we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_TextField_a()) {
            if (we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_Table_a() != null && we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getActors().contains(we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_Table_a(), true)) {
                Engine.b("------------- key 1");
                we2.wh_a().b("confirm");
            } else if (we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_Dialog_c() != null && we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getActors().contains(we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_Dialog_c(), true)) {
                Engine.b("------------- key 2 ");
                we2.wh_a().a((Object)"confirm");
            } else if (we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_Dialog_b() != null && we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getActors().contains(we2.wh_a().com_badlogic_gdx_scenes_scene2d_ui_Dialog_b(), true)) {
                Engine.b("------------- key 4 ");
                we2.wh_a().c("confirm");
            }
        } else if (ay.ay_a().gd_a().ca_a() != null && we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() == ay.ay_a().gd_a().ca_a().com_badlogic_gdx_scenes_scene2d_ui_TextField_a()) {
            if (we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getActors().contains(ay.ay_a().gd_a().ca_a().com_badlogic_gdx_scenes_scene2d_ui_Dialog_a(), true)) {
                Engine.b("------------- key 3 ");
                ay.ay_a().gd_a().ca_a().a((Object)"confirm");
            }
            if (we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getActors().contains(ay.ay_a().gd_a().ca_a().com_badlogic_gdx_scenes_scene2d_ui_Dialog_a(), true)) {
                Engine.b("contains it");
            } else {
                Engine.b("doesn't contain it");
            }
        }
        return true;
    }

    @Override
    public boolean b(we we2) {
        return false;
    }
}

