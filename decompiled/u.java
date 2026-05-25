/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.assets.AssetManager;

public class u
extends AssetManager {
    @Override
    public <T> void addAsset(String string, Class<T> clazz, T t2) {
        super.addAsset(string, clazz, t2);
    }

    public String toString() {
        String string = "AoKAssetManager.toString()\n";
        for (String string2 : this.getAssetNames()) {
            Engine.a("\tAsset: " + string2 + " is loaded. RefCounter: " + this.getReferenceCount(string2));
        }
        string = string + "\n";
        return string;
    }
}

