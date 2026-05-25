/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.reflectasm;

import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.Label;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.asm.Type;
import com.esotericsoftware.reflectasm.AccessClassLoader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class MethodAccess {
    private String[] methodNames;
    private Class[][] parameterTypes;
    private Class[] returnTypes;

    public abstract Object invoke(Object var1, int var2, Object ... var3);

    public Object invoke(Object object, String string, Class[] classArray, Object ... objectArray) {
        return this.invoke(object, this.getIndex(string, classArray), objectArray);
    }

    public Object invoke(Object object, String string, Object ... objectArray) {
        return this.invoke(object, this.getIndex(string, objectArray == null ? 0 : objectArray.length), objectArray);
    }

    public int getIndex(String string) {
        int n2 = this.methodNames.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.methodNames[i2].equals(string)) continue;
            return i2;
        }
        throw new IllegalArgumentException("Unable to find non-private method: " + string);
    }

    public int getIndex(String string, Class ... classArray) {
        int n2 = this.methodNames.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.methodNames[i2].equals(string) || !Arrays.equals(classArray, this.parameterTypes[i2])) continue;
            return i2;
        }
        throw new IllegalArgumentException("Unable to find non-private method: " + string + " " + Arrays.toString(classArray));
    }

    public int getIndex(String string, int n2) {
        int n3 = this.methodNames.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (!this.methodNames[i2].equals(string) || this.parameterTypes[i2].length != n2) continue;
            return i2;
        }
        throw new IllegalArgumentException("Unable to find non-private method: " + string + " with " + n2 + " params.");
    }

    public String[] getMethodNames() {
        return this.methodNames;
    }

    public Class[][] getParameterTypes() {
        return this.parameterTypes;
    }

    public Class[] getReturnTypes() {
        return this.returnTypes;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static MethodAccess get(Class clazz) {
        Class clazz2;
        Object object;
        boolean bl2 = clazz.isInterface();
        if (!bl2 && clazz.getSuperclass() == null && clazz != Object.class) {
            throw new IllegalArgumentException("The type must not be an interface, a primitive type, or void.");
        }
        ArrayList<Method> arrayList = new ArrayList<Method>();
        if (!bl2) {
            for (Class clazz3 = clazz; clazz3 != Object.class; clazz3 = clazz3.getSuperclass()) {
                MethodAccess.addDeclaredMethodsToList(clazz3, arrayList);
            }
        } else {
            MethodAccess.recursiveAddInterfaceMethodsToList(clazz, arrayList);
        }
        int n2 = arrayList.size();
        String[] stringArray = new String[n2];
        Class[][] classArrayArray = new Class[n2][];
        Class[] classArray = new Class[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            object = arrayList.get(i2);
            stringArray[i2] = ((Method)object).getName();
            classArrayArray[i2] = ((Method)object).getParameterTypes();
            classArray[i2] = ((Method)object).getReturnType();
        }
        String string = clazz.getName();
        object = string + "MethodAccess";
        if (((String)object).startsWith("java.")) {
            object = "reflectasm." + (String)object;
        }
        AccessClassLoader accessClassLoader = AccessClassLoader.get(clazz);
        Object object2 = accessClassLoader;
        synchronized (object2) {
            clazz2 = accessClassLoader.loadAccessClass((String)object);
            if (clazz2 == null) {
                Object[] objectArray;
                String string2 = ((String)object).replace('.', '/');
                String string3 = string.replace('.', '/');
                ClassWriter classWriter = new ClassWriter(1);
                classWriter.visit(196653, 33, string2, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null);
                methodVisitor.visitCode();
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitMethodInsn(183, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                methodVisitor.visitInsn(177);
                methodVisitor.visitMaxs(0, 0);
                methodVisitor.visitEnd();
                methodVisitor = classWriter.visitMethod(129, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                methodVisitor.visitCode();
                if (!arrayList.isEmpty()) {
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitTypeInsn(192, string3);
                    methodVisitor.visitVarInsn(58, 4);
                    methodVisitor.visitVarInsn(21, 2);
                    objectArray = new Label[n2];
                    for (int i3 = 0; i3 < n2; ++i3) {
                        objectArray[i3] = new Label();
                    }
                    Label label = new Label();
                    methodVisitor.visitTableSwitchInsn(0, objectArray.length - 1, label, (Label[])objectArray);
                    StringBuilder stringBuilder = new StringBuilder(128);
                    for (int i4 = 0; i4 < n2; ++i4) {
                        int n3;
                        methodVisitor.visitLabel(objectArray[i4]);
                        if (i4 == 0) {
                            methodVisitor.visitFrame(1, 1, new Object[]{string3}, 0, null);
                        } else {
                            methodVisitor.visitFrame(3, 0, null, 0, null);
                        }
                        methodVisitor.visitVarInsn(25, 4);
                        stringBuilder.setLength(0);
                        stringBuilder.append('(');
                        Class[] classArray2 = classArrayArray[i4];
                        Class clazz4 = classArray[i4];
                        for (n3 = 0; n3 < classArray2.length; ++n3) {
                            methodVisitor.visitVarInsn(25, 3);
                            methodVisitor.visitIntInsn(16, n3);
                            methodVisitor.visitInsn(50);
                            Type type = Type.getType(classArray2[n3]);
                            switch (type.getSort()) {
                                case 1: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Boolean");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
                                    break;
                                }
                                case 3: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Byte");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
                                    break;
                                }
                                case 2: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Character");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
                                    break;
                                }
                                case 4: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Short");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
                                    break;
                                }
                                case 5: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Integer");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
                                    break;
                                }
                                case 6: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Float");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
                                    break;
                                }
                                case 7: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Long");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
                                    break;
                                }
                                case 8: {
                                    methodVisitor.visitTypeInsn(192, "java/lang/Double");
                                    methodVisitor.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
                                    break;
                                }
                                case 9: {
                                    methodVisitor.visitTypeInsn(192, type.getDescriptor());
                                    break;
                                }
                                case 10: {
                                    methodVisitor.visitTypeInsn(192, type.getInternalName());
                                }
                            }
                            stringBuilder.append(type.getDescriptor());
                        }
                        stringBuilder.append(')');
                        stringBuilder.append(Type.getDescriptor(clazz4));
                        n3 = bl2 ? 185 : (Modifier.isStatic(arrayList.get(i4).getModifiers()) ? 184 : 182);
                        methodVisitor.visitMethodInsn(n3, string3, stringArray[i4], stringBuilder.toString());
                        switch (Type.getType(clazz4).getSort()) {
                            case 0: {
                                methodVisitor.visitInsn(1);
                                break;
                            }
                            case 1: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                                break;
                            }
                            case 3: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                                break;
                            }
                            case 2: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                                break;
                            }
                            case 4: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                                break;
                            }
                            case 5: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                break;
                            }
                            case 6: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                                break;
                            }
                            case 7: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                                break;
                            }
                            case 8: {
                                methodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                            }
                        }
                        methodVisitor.visitInsn(176);
                    }
                    methodVisitor.visitLabel(label);
                    methodVisitor.visitFrame(3, 0, null, 0, null);
                }
                methodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
                methodVisitor.visitInsn(89);
                methodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn("Method not found: ");
                methodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                methodVisitor.visitVarInsn(21, 2);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                methodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                methodVisitor.visitInsn(191);
                methodVisitor.visitMaxs(0, 0);
                methodVisitor.visitEnd();
                classWriter.visitEnd();
                objectArray = classWriter.toByteArray();
                clazz2 = accessClassLoader.defineAccessClass((String)object, (byte[])objectArray);
            }
        }
        try {
            object2 = (MethodAccess)clazz2.newInstance();
            ((MethodAccess)object2).methodNames = stringArray;
            ((MethodAccess)object2).parameterTypes = classArrayArray;
            ((MethodAccess)object2).returnTypes = classArray;
            return object2;
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Error constructing method access class: " + (String)object, throwable);
        }
    }

    private static void addDeclaredMethodsToList(Class clazz, ArrayList<Method> arrayList) {
        for (Method method : clazz.getDeclaredMethods()) {
            int n2 = method.getModifiers();
            if (Modifier.isPrivate(n2)) continue;
            arrayList.add(method);
        }
    }

    private static void recursiveAddInterfaceMethodsToList(Class clazz, ArrayList<Method> arrayList) {
        MethodAccess.addDeclaredMethodsToList(clazz, arrayList);
        for (Class<?> clazz2 : clazz.getInterfaces()) {
            MethodAccess.recursiveAddInterfaceMethodsToList(clazz2, arrayList);
        }
    }
}

