/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class bsf
extends btd<File> {
    public bsf() {
        super(File.class);
    }

    @Override
    public void a(File file, bcy bcy2, bgo bgo2) {
        bcy2.b(file.getAbsolutePath());
    }
}

