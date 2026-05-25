/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public abstract class axm {
    private Array<ajw> var_com_badlogic_gdx_utils_Array_ajw__a;
    protected Engine var_com_arenaofkings_client_core_Engine_a;

    public axm(Engine engine, ayl ayl2) {
        System.out.println("AssetDependencies() in");
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_com_badlogic_gdx_utils_Array_ajw__a = new Array();
        System.out.println("AssetDependencies() in 1");
        this.a(ayl2);
        System.out.println("AssetDependencies() in 2");
        this.b(ayl2);
        System.out.println("AssetDependencies() in 3");
    }

    public abstract void a(ayl var1);

    public abstract void b(ayl var1);

    public TextureAtlas com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw ajw2) {
        TextureAtlas textureAtlas = null;
        for (ajw ajw3 : this.var_com_badlogic_gdx_utils_Array_ajw__a) {
            if (ajw3 != ajw2) continue;
            textureAtlas = (TextureAtlas)this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.get(ajw2.a());
            break;
        }
        if (textureAtlas == null) {
            Engine.b("[ERROR] Returning a null TextureAtlas for " + ajw2.toString() + " (hint) maybe you didn't include this ScreenDependency in your ____AssetDependency.java class?");
        }
        return textureAtlas;
    }

    public Texture com_badlogic_gdx_graphics_Texture_a(ajw ajw2) {
        Texture texture = null;
        for (ajw ajw3 : this.var_com_badlogic_gdx_utils_Array_ajw__a) {
            if (ajw3 != ajw2) continue;
            texture = this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.get(ajw2.a(), Texture.class);
            break;
        }
        if (texture == null) {
            Engine.a("[ERROR] Returning a null Texture for " + ajw2.toString() + "(hint) maybe you didn't include this ScreenDependency in your ____AssetDependency.java class?");
        }
        return texture;
    }

    public Disposable com_badlogic_gdx_utils_Disposable_a(ajw ajw2) {
        if (ajw2 == null) {
            return null;
        }
        Disposable disposable = null;
        for (ajw ajw3 : this.var_com_badlogic_gdx_utils_Array_ajw__a) {
            if (ajw3 != ajw2) continue;
            if (!this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.isLoaded(ajw2.a())) break;
            disposable = this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.get(ajw2.a(), ajw2.a());
            break;
        }
        if (disposable == null) {
            Engine.a("[ERROR] Returning a null Disposable for " + ajw2.toString());
        }
        return disposable;
    }

    public Array<ajw> a() {
        return this.var_com_badlogic_gdx_utils_Array_ajw__a;
    }

    public void void_a(ajw ajw2) {
        if (ajw2 != null && ajw2 != ajw.bs) {
            this.var_com_badlogic_gdx_utils_Array_ajw__a.add(ajw2);
        } else {
            Engine.a("[WARN] Dependency is undefined. Did not add " + ajw2.toString());
        }
    }

    public boolean boolean_a(ajw ajw2) {
        return this.var_com_badlogic_gdx_utils_Array_ajw__a.removeValue(ajw2, true);
    }

    public boolean b(ajw ajw2) {
        return this.var_com_badlogic_gdx_utils_Array_ajw__a.contains(ajw2, true);
    }

    public String toString() {
        String string = "\n";
        for (ajw ajw2 : this.var_com_badlogic_gdx_utils_Array_ajw__a) {
            string = string + ajw2.toString() + "\n";
        }
        return string;
    }
}

