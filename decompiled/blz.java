/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.Path;

public class blz
extends bly {
    private final Class<?> a = Path.class;

    @Override
    public bfx<?> a(Class<?> clazz) {
        if (clazz == this.a) {
            return new bmc();
        }
        return null;
    }

    @Override
    public bgb<?> a(Class<?> clazz) {
        if (this.a.isAssignableFrom(clazz)) {
            return new bmd();
        }
        return null;
    }
}

