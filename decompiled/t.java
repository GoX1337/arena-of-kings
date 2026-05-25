/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class t {
    public static boolean a(Class<?> clazz, Engine engine) {
        if (engine.axc_a() == null) {
            return false;
        }
        return engine.axc_a().getClass() == clazz;
    }
}

