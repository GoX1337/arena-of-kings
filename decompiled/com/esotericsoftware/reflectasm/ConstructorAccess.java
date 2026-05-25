/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.reflectasm;

import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.reflectasm.AccessClassLoader;
import com.esotericsoftware.reflectasm.PublicConstructorAccess;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class ConstructorAccess<T> {
    boolean isNonStaticMemberClass;

    public boolean isNonStaticMemberClass() {
        return this.isNonStaticMemberClass;
    }

    public abstract T newInstance();

    public abstract T newInstance(Object var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static <T> ConstructorAccess<T> get(Class<T> clazz) {
        Class clazz2;
        Class<?> clazz3 = clazz.getEnclosingClass();
        boolean bl2 = clazz3 != null && clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers());
        String string = clazz.getName();
        String string2 = string + "ConstructorAccess";
        if (string2.startsWith("java.")) {
            string2 = "reflectasm." + string2;
        }
        AccessClassLoader accessClassLoader = AccessClassLoader.get(clazz);
        Object object = accessClassLoader;
        synchronized (object) {
            clazz2 = accessClassLoader.loadAccessClass(string2);
            if (clazz2 == null) {
                String string3;
                String string4 = string2.replace('.', '/');
                String string5 = string.replace('.', '/');
                Constructor<T> constructor = null;
                int n2 = 0;
                if (!bl2) {
                    string3 = null;
                    try {
                        constructor = clazz.getDeclaredConstructor(null);
                        n2 = constructor.getModifiers();
                    }
                    catch (Exception exception) {
                        throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + clazz.getName(), exception);
                    }
                    if (Modifier.isPrivate(n2)) {
                        throw new RuntimeException("Class cannot be created (the no-arg constructor is private): " + clazz.getName());
                    }
                } else {
                    string3 = clazz3.getName().replace('.', '/');
                    try {
                        constructor = clazz.getDeclaredConstructor(clazz3);
                        n2 = constructor.getModifiers();
                    }
                    catch (Exception exception) {
                        throw new RuntimeException("Non-static member class cannot be created (missing enclosing class constructor): " + clazz.getName(), exception);
                    }
                    if (Modifier.isPrivate(n2)) {
                        throw new RuntimeException("Non-static member class cannot be created (the enclosing class constructor is private): " + clazz.getName());
                    }
                }
                String string6 = Modifier.isPublic(n2) ? "com/esotericsoftware/reflectasm/PublicConstructorAccess" : "com/esotericsoftware/reflectasm/ConstructorAccess";
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(196653, 33, string4, null, string6, null);
                ConstructorAccess.insertConstructor(classWriter, string6);
                ConstructorAccess.insertNewInstance(classWriter, string5);
                ConstructorAccess.insertNewInstanceInner(classWriter, string5, string3);
                classWriter.visitEnd();
                clazz2 = accessClassLoader.defineAccessClass(string2, classWriter.toByteArray());
            }
        }
        try {
            object = (ConstructorAccess)clazz2.newInstance();
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Exception constructing constructor access class: " + string2, throwable);
        }
        if (!(object instanceof PublicConstructorAccess) && !AccessClassLoader.areInSameRuntimeClassLoader(clazz, clazz2)) {
            throw new RuntimeException((!bl2 ? "Class cannot be created (the no-arg constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): " : "Non-static member class cannot be created (the enclosing class constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): ") + clazz.getName());
        }
        ((ConstructorAccess)object).isNonStaticMemberClass = bl2;
        return object;
    }

    private static void insertConstructor(ClassWriter classWriter, String string) {
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitMethodInsn(183, string, "<init>", "()V");
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();
    }

    static void insertNewInstance(ClassWriter classWriter, String string) {
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitTypeInsn(187, string);
        methodVisitor.visitInsn(89);
        methodVisitor.visitMethodInsn(183, string, "<init>", "()V");
        methodVisitor.visitInsn(176);
        methodVisitor.visitMaxs(2, 1);
        methodVisitor.visitEnd();
    }

    static void insertNewInstanceInner(ClassWriter classWriter, String string, String string2) {
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        methodVisitor.visitCode();
        if (string2 != null) {
            methodVisitor.visitTypeInsn(187, string);
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitTypeInsn(192, string2);
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor.visitInsn(87);
            methodVisitor.visitMethodInsn(183, string, "<init>", "(L" + string2 + ";)V");
            methodVisitor.visitInsn(176);
            methodVisitor.visitMaxs(4, 2);
        } else {
            methodVisitor.visitTypeInsn(187, "java/lang/UnsupportedOperationException");
            methodVisitor.visitInsn(89);
            methodVisitor.visitLdcInsn("Not an inner class.");
            methodVisitor.visitMethodInsn(183, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
            methodVisitor.visitInsn(191);
            methodVisitor.visitMaxs(3, 2);
        }
        methodVisitor.visitEnd();
    }
}

