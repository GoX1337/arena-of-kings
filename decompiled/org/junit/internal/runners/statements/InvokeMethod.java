/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.statements;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class InvokeMethod
extends Statement {
    private final FrameworkMethod fTestMethod;
    private Object fTarget;

    public InvokeMethod(FrameworkMethod frameworkMethod, Object object) {
        this.fTestMethod = frameworkMethod;
        this.fTarget = object;
    }

    public void evaluate() {
        this.fTestMethod.invokeExplosively(this.fTarget, new Object[0]);
    }
}

