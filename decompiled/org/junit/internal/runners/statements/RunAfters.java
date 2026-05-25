/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.statements;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.runners.model.MultipleFailureException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RunAfters
extends Statement {
    private final Statement fNext;
    private final Object fTarget;
    private final List<FrameworkMethod> fAfters;

    public RunAfters(Statement statement, List<FrameworkMethod> list, Object object) {
        this.fNext = statement;
        this.fAfters = list;
        this.fTarget = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void evaluate() {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        arrayList.clear();
        try {
            this.fNext.evaluate();
        }
        catch (Throwable throwable) {
            try {
                arrayList.add(throwable);
            }
            catch (Throwable throwable2) {
                for (FrameworkMethod frameworkMethod : this.fAfters) {
                    try {
                        frameworkMethod.invokeExplosively(this.fTarget, new Object[0]);
                    }
                    catch (Throwable throwable3) {
                        arrayList.add(throwable3);
                    }
                }
                throw throwable2;
            }
            for (FrameworkMethod frameworkMethod : this.fAfters) {
                try {
                    frameworkMethod.invokeExplosively(this.fTarget, new Object[0]);
                }
                catch (Throwable throwable4) {
                    arrayList.add(throwable4);
                }
            }
        }
        for (FrameworkMethod frameworkMethod : this.fAfters) {
            try {
                frameworkMethod.invokeExplosively(this.fTarget, new Object[0]);
            }
            catch (Throwable throwable) {
                arrayList.add(throwable);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == 1) {
            throw (Throwable)arrayList.get(0);
        }
        throw new MultipleFailureException(arrayList);
    }
}

