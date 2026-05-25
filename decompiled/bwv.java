/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintStream;

public class bwv
extends Exception {
    private Throwable a;

    public bwv(String string, Throwable throwable) {
        super(string);
        this.a = throwable;
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream printStream) {
        if (this.a == null) {
            super.printStackTrace(printStream);
        } else {
            this.a.printStackTrace();
        }
    }
}

