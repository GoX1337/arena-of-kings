/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.statements;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RunBefores
extends Statement {
    private final Statement fNext;
    private final Object fTarget;
    private final List<FrameworkMethod> fBefores;

    public RunBefores(Statement statement, List<FrameworkMethod> list, Object object) {
        this.fNext = statement;
        this.fBefores = list;
        this.fTarget = object;
    }

    @Override
    public void evaluate() {
        for (FrameworkMethod frameworkMethod : this.fBefores) {
            frameworkMethod.invokeExplosively(this.fTarget, new Object[0]);
        }
        this.fNext.evaluate();
    }
}

