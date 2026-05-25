/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.Generics;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class DefaultGenerics
implements Generics {
    private final Kryo kryo;
    private int genericTypesSize;
    private Generics.GenericType[] genericTypes = new Generics.GenericType[16];
    private int[] depths = new int[16];
    private int argumentsSize;
    private Type[] arguments = new Type[16];

    public DefaultGenerics(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override
    public void pushGenericType(Generics.GenericType genericType) {
        int n2 = this.genericTypesSize;
        if (n2 + 1 == this.genericTypes.length) {
            Generics.GenericType[] genericTypeArray = new Generics.GenericType[this.genericTypes.length << 1];
            System.arraycopy(this.genericTypes, 0, genericTypeArray, 0, n2);
            this.genericTypes = genericTypeArray;
            int[] nArray = new int[this.depths.length << 1];
            System.arraycopy(this.depths, 0, nArray, 0, n2);
            this.depths = nArray;
        }
        this.genericTypesSize = n2 + 1;
        this.genericTypes[n2] = genericType;
        this.depths[n2] = this.kryo.getDepth();
    }

    @Override
    public void popGenericType() {
        int n2 = this.genericTypesSize;
        if (n2 == 0) {
            return;
        }
        if (this.depths[--n2] < this.kryo.getDepth()) {
            return;
        }
        this.genericTypes[n2] = null;
        this.genericTypesSize = n2;
    }

    @Override
    public Generics.GenericType[] nextGenericTypes() {
        int n2 = this.genericTypesSize;
        if (n2 > 0) {
            Generics.GenericType genericType = this.genericTypes[--n2];
            if (genericType.arguments == null) {
                return null;
            }
            if (this.depths[n2] == this.kryo.getDepth() - 1) {
                this.pushGenericType(genericType.arguments[genericType.arguments.length - 1]);
                return genericType.arguments;
            }
        }
        return null;
    }

    @Override
    public Class nextGenericClass() {
        Generics.GenericType[] genericTypeArray = this.nextGenericTypes();
        if (genericTypeArray == null) {
            return null;
        }
        return genericTypeArray[0].resolve(this);
    }

    @Override
    public int pushTypeVariables(Generics.GenericsHierarchy genericsHierarchy, Generics.GenericType[] genericTypeArray) {
        Object[] objectArray;
        if (genericsHierarchy.total == 0 || genericsHierarchy.rootTotal > genericTypeArray.length) {
            return 0;
        }
        int n2 = this.argumentsSize;
        int n3 = n2 + genericsHierarchy.total;
        if (n3 > this.arguments.length) {
            objectArray = new Type[Math.max(n3, this.arguments.length << 1)];
            System.arraycopy(this.arguments, 0, objectArray, 0, n2);
            this.arguments = (Type[])objectArray;
        }
        objectArray = genericsHierarchy.counts;
        TypeVariable[] typeVariableArray = genericsHierarchy.parameters;
        int n4 = 0;
        int n5 = genericTypeArray.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            Generics.GenericType genericType = genericTypeArray[i2];
            Class clazz = genericType.resolve(this);
            if (clazz == null) continue;
            int n6 = objectArray[i2];
            if (genericType == null) {
                n4 += n6;
                continue;
            }
            int n7 = n4 + n6;
            while (n4 < n7) {
                this.arguments[this.argumentsSize] = typeVariableArray[n4];
                this.arguments[this.argumentsSize + 1] = clazz;
                this.argumentsSize += 2;
                ++n4;
            }
        }
        return this.argumentsSize - n2;
    }

    @Override
    public void popTypeVariables(int n2) {
        int n3;
        int n4 = this.argumentsSize;
        this.argumentsSize = n3 = n4 - n2;
        while (n3 < n4) {
            this.arguments[n3++] = null;
        }
    }

    @Override
    public Class resolveTypeVariable(TypeVariable typeVariable) {
        for (int i2 = this.argumentsSize - 2; i2 >= 0; i2 -= 2) {
            Type type = this.arguments[i2];
            if (type != typeVariable && !type.equals(typeVariable)) continue;
            return (Class)this.arguments[i2 + 1];
        }
        return null;
    }

    @Override
    public int getGenericTypesSize() {
        return this.genericTypesSize;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < this.argumentsSize; i2 += 2) {
            if (i2 != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(((TypeVariable)this.arguments[i2]).getName());
            stringBuilder.append("=");
            stringBuilder.append(((Class)this.arguments[i2 + 1]).getSimpleName());
        }
        return stringBuilder.toString();
    }
}

