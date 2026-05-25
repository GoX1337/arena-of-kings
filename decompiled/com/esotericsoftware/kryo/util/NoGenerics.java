/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.util.Generics;
import java.lang.reflect.TypeVariable;

public final class NoGenerics
implements Generics {
    public static final Generics INSTANCE = new NoGenerics();

    private NoGenerics() {
    }

    @Override
    public void pushGenericType(Generics.GenericType genericType) {
    }

    @Override
    public void popGenericType() {
    }

    @Override
    public Generics.GenericType[] nextGenericTypes() {
        return null;
    }

    @Override
    public Class nextGenericClass() {
        return null;
    }

    @Override
    public int pushTypeVariables(Generics.GenericsHierarchy genericsHierarchy, Generics.GenericType[] genericTypeArray) {
        return 0;
    }

    @Override
    public void popTypeVariables(int n2) {
    }

    @Override
    public Class resolveTypeVariable(TypeVariable typeVariable) {
        return null;
    }

    @Override
    public int getGenericTypesSize() {
        return 0;
    }
}

