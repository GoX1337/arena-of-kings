/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.util.GenericsUtil;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.Util;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public interface Generics {
    public void pushGenericType(GenericType var1);

    public void popGenericType();

    public GenericType[] nextGenericTypes();

    public Class nextGenericClass();

    public int pushTypeVariables(GenericsHierarchy var1, GenericType[] var2);

    public void popTypeVariables(int var1);

    public Class resolveTypeVariable(TypeVariable var1);

    public int getGenericTypesSize();

    public static class GenericType {
        Type type;
        GenericType[] arguments;

        public GenericType(Class clazz, Class clazz2, Type type) {
            this.initialize(clazz, clazz2, type);
        }

        private void initialize(Class clazz, Class clazz2, Type type) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType)type;
                Class clazz3 = (Class)parameterizedType.getRawType();
                this.type = clazz3;
                Type[] typeArray = parameterizedType.getActualTypeArguments();
                int n2 = typeArray.length;
                this.arguments = new GenericType[n2];
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.arguments[i2] = new GenericType(clazz, clazz2, typeArray[i2]);
                }
            } else if (type instanceof GenericArrayType) {
                int n3 = 1;
                while ((type = ((GenericArrayType)type).getGenericComponentType()) instanceof GenericArrayType) {
                    ++n3;
                }
                this.initialize(clazz, clazz2, type);
                Type type2 = GenericsUtil.resolveType(clazz, clazz2, type);
                if (type2 instanceof Class) {
                    this.type = n3 == 1 ? Array.newInstance((Class)type2, 0).getClass() : Array.newInstance((Class)type2, new int[n3]).getClass();
                }
            } else {
                this.type = GenericsUtil.resolveType(clazz, clazz2, type);
            }
        }

        public Class resolve(Generics generics) {
            if (this.type instanceof Class) {
                return (Class)this.type;
            }
            return generics.resolveTypeVariable((TypeVariable)this.type);
        }

        public Type getType() {
            return this.type;
        }

        public GenericType[] getTypeParameters() {
            return this.arguments;
        }

        public String toString() {
            int n2;
            StringBuilder stringBuilder = new StringBuilder(32);
            boolean bl2 = false;
            if (this.type instanceof Class) {
                Class clazz = (Class)this.type;
                bl2 = clazz.isArray();
                stringBuilder.append((bl2 ? Util.getElementClass(clazz) : clazz).getSimpleName());
                if (this.arguments != null) {
                    stringBuilder.append('<');
                    int n3 = this.arguments.length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        if (n2 > 0) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(this.arguments[n2].toString());
                    }
                    stringBuilder.append('>');
                }
            } else {
                stringBuilder.append(this.type.toString());
            }
            if (bl2) {
                n2 = Util.getDimensionCount((Class)this.type);
                for (int i2 = 0; i2 < n2; ++i2) {
                    stringBuilder.append("[]");
                }
            }
            return stringBuilder.toString();
        }
    }

    public static class GenericsHierarchy {
        final int total;
        final int rootTotal;
        final int[] counts;
        final TypeVariable[] parameters;

        public GenericsHierarchy(Class clazz) {
            IntArray intArray = new IntArray();
            ArrayList arrayList = new ArrayList();
            int n2 = 0;
            Class clazz2 = clazz;
            do {
                for (TypeVariable typeVariable : clazz2.getTypeParameters()) {
                    arrayList.add(typeVariable);
                    intArray.add(1);
                    Class clazz3 = clazz2;
                    block2: while (true) {
                        Type type = clazz3.getGenericSuperclass();
                        clazz3 = clazz3.getSuperclass();
                        if (!(type instanceof ParameterizedType)) break;
                        TypeVariable<Class<T>>[] typeVariableArray = clazz3.getTypeParameters();
                        Type[] typeArray = ((ParameterizedType)type).getActualTypeArguments();
                        int n3 = 0;
                        int n4 = typeArray.length;
                        while (true) {
                            if (n3 >= n4) continue block2;
                            Type type2 = typeArray[n3];
                            if (type2 == typeVariable) {
                                typeVariable = typeVariableArray[n3];
                                arrayList.add(typeVariable);
                                intArray.incr(intArray.size - 1, 1);
                            }
                            ++n3;
                        }
                        break;
                    }
                    n2 += intArray.peek();
                }
            } while ((clazz2 = clazz2.getSuperclass()) != null);
            this.total = n2;
            this.rootTotal = clazz.getTypeParameters().length;
            this.counts = intArray.toArray();
            this.parameters = arrayList.toArray(new TypeVariable[arrayList.size()]);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            int[] nArray = this.counts;
            TypeVariable[] typeVariableArray = this.parameters;
            int n2 = 0;
            for (int n3 : nArray) {
                int n4 = n2 + n3;
                while (n2 < n4) {
                    Object d2;
                    if (stringBuilder.length() > 1) {
                        stringBuilder.append(", ");
                    }
                    if ((d2 = typeVariableArray[n2].getGenericDeclaration()) instanceof Class) {
                        stringBuilder.append(((Class)d2).getSimpleName());
                    } else {
                        stringBuilder.append(d2);
                    }
                    stringBuilder.append('<');
                    stringBuilder.append(typeVariableArray[n2].getName());
                    stringBuilder.append('>');
                    ++n2;
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
}

