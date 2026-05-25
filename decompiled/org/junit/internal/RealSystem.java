/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal;

import java.io.PrintStream;
import org.junit.internal.JUnitSystem;

public class RealSystem
implements JUnitSystem {
    public void exit(int n2) {
        System.exit(n2);
    }

    public PrintStream out() {
        return System.out;
    }
}

