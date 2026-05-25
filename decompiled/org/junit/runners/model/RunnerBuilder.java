/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class RunnerBuilder {
    private final Set<Class<?>> parents = new HashSet();

    public abstract Runner runnerForClass(Class<?> var1);

    public Runner safeRunnerForClass(Class<?> clazz) {
        try {
            return this.runnerForClass(clazz);
        }
        catch (Throwable throwable) {
            return new ErrorReportingRunner(clazz, throwable);
        }
    }

    Class<?> addParent(Class<?> clazz) {
        if (!this.parents.add(clazz)) {
            throw new InitializationError(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", clazz.getName()));
        }
        return clazz;
    }

    void removeParent(Class<?> clazz) {
        this.parents.remove(clazz);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List<Runner> runners(Class<?> clazz, Class<?>[] classArray) {
        this.addParent(clazz);
        try {
            List<Runner> list = this.runners(classArray);
            return list;
        }
        finally {
            this.removeParent(clazz);
        }
    }

    private List<Runner> runners(Class<?>[] classArray) {
        ArrayList<Runner> arrayList = new ArrayList<Runner>();
        for (Class<?> clazz : classArray) {
            Runner runner = this.safeRunnerForClass(clazz);
            if (runner == null) continue;
            arrayList.add(runner);
        }
        return arrayList;
    }
}

