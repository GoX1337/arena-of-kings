/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import java.lang.reflect.Method;

abstract class VarArgsChecker {
    private VarArgsChecker() {
    }

    static VarArgsChecker create() {
        try {
            Method method = Method.class.getMethod("isVarArgs", new Class[0]);
            if (method != null) {
                return new RealVarArgsChecker();
            }
            return new NoVarArgsChecker();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return new NoVarArgsChecker();
        }
        catch (SecurityException securityException) {
            return new NoVarArgsChecker();
        }
    }

    abstract boolean isVarArgs(Method var1);

    abstract int fixedArgs(Method var1);

    static final class NoVarArgsChecker
    extends VarArgsChecker {
        private NoVarArgsChecker() {
        }

        @Override
        boolean isVarArgs(Method method) {
            return false;
        }

        @Override
        int fixedArgs(Method method) {
            return 0;
        }
    }

    static final class RealVarArgsChecker
    extends VarArgsChecker {
        private RealVarArgsChecker() {
        }

        @Override
        boolean isVarArgs(Method method) {
            return method.isVarArgs();
        }

        @Override
        int fixedArgs(Method method) {
            return method.isVarArgs() ? method.getParameterTypes().length - 1 : 0;
        }
    }
}

