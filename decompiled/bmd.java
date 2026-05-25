/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.Path;

public class bmd
extends btd<Path> {
    public bmd() {
        super(Path.class);
    }

    @Override
    public void a(Path path, bcy bcy2, bgo bgo2) {
        bcy2.b(path.toUri().toString());
    }

    @Override
    public void a(Path path, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a((Object)path, Path.class, bdf.h));
        this.a(path, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }
}

