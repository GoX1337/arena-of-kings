/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.reflectasm;

import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.Label;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.asm.Type;
import com.esotericsoftware.reflectasm.AccessClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class FieldAccess {
    private String[] fieldNames;
    private Class[] fieldTypes;
    private Field[] fields;

    public int getIndex(String string) {
        int n2 = this.fieldNames.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.fieldNames[i2].equals(string)) continue;
            return i2;
        }
        throw new IllegalArgumentException("Unable to find non-private field: " + string);
    }

    public int getIndex(Field field) {
        int n2 = this.fields.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.fields[i2].equals(field)) continue;
            return i2;
        }
        throw new IllegalArgumentException("Unable to find non-private field: " + field);
    }

    public void set(Object object, String string, Object object2) {
        this.set(object, this.getIndex(string), object2);
    }

    public Object get(Object object, String string) {
        return this.get(object, this.getIndex(string));
    }

    public String[] getFieldNames() {
        return this.fieldNames;
    }

    public Class[] getFieldTypes() {
        return this.fieldTypes;
    }

    public int getFieldCount() {
        return this.fieldTypes.length;
    }

    public Field[] getFields() {
        return this.fields;
    }

    public void setFields(Field[] fieldArray) {
        this.fields = fieldArray;
    }

    public abstract void set(Object var1, int var2, Object var3);

    public abstract void setBoolean(Object var1, int var2, boolean var3);

    public abstract void setByte(Object var1, int var2, byte var3);

    public abstract void setShort(Object var1, int var2, short var3);

    public abstract void setInt(Object var1, int var2, int var3);

    public abstract void setLong(Object var1, int var2, long var3);

    public abstract void setDouble(Object var1, int var2, double var3);

    public abstract void setFloat(Object var1, int var2, float var3);

    public abstract void setChar(Object var1, int var2, char var3);

    public abstract Object get(Object var1, int var2);

    public abstract String getString(Object var1, int var2);

    public abstract char getChar(Object var1, int var2);

    public abstract boolean getBoolean(Object var1, int var2);

    public abstract byte getByte(Object var1, int var2);

    public abstract short getShort(Object var1, int var2);

    public abstract int getInt(Object var1, int var2);

    public abstract long getLong(Object var1, int var2);

    public abstract double getDouble(Object var1, int var2);

    public abstract float getFloat(Object var1, int var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static FieldAccess get(Class clazz) {
        Class clazz2;
        if (clazz.getSuperclass() == null) {
            throw new IllegalArgumentException("The type must not be the Object class, an interface, a primitive type, or void.");
        }
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Class clazz3 = clazz; clazz3 != Object.class; clazz3 = clazz3.getSuperclass()) {
            for (Field field : clazz3.getDeclaredFields()) {
                int n2 = field.getModifiers();
                if (Modifier.isStatic(n2) || Modifier.isPrivate(n2)) continue;
                arrayList.add(field);
            }
        }
        Object[] objectArray = new String[arrayList.size()];
        Class[] classArray = new Class[arrayList.size()];
        int n3 = objectArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            objectArray[i2] = ((Field)arrayList.get(i2)).getName();
            classArray[i2] = ((Field)arrayList.get(i2)).getType();
        }
        String string = clazz.getName();
        String string2 = string + "FieldAccess";
        if (string2.startsWith("java.")) {
            string2 = "reflectasm." + string2;
        }
        AccessClassLoader accessClassLoader = AccessClassLoader.get(clazz);
        Object object = accessClassLoader;
        synchronized (object) {
            clazz2 = accessClassLoader.loadAccessClass(string2);
            if (clazz2 == null) {
                String string3 = string2.replace('.', '/');
                String string4 = string.replace('.', '/');
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(196653, 33, string3, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
                FieldAccess.insertConstructor(classWriter);
                FieldAccess.insertGetObject(classWriter, string4, arrayList);
                FieldAccess.insertSetObject(classWriter, string4, arrayList);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.BOOLEAN_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.BOOLEAN_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.BYTE_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.BYTE_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.SHORT_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.SHORT_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.INT_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.INT_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.LONG_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.LONG_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.DOUBLE_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.DOUBLE_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.FLOAT_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.FLOAT_TYPE);
                FieldAccess.insertGetPrimitive(classWriter, string4, arrayList, Type.CHAR_TYPE);
                FieldAccess.insertSetPrimitive(classWriter, string4, arrayList, Type.CHAR_TYPE);
                FieldAccess.insertGetString(classWriter, string4, arrayList);
                classWriter.visitEnd();
                clazz2 = accessClassLoader.defineAccessClass(string2, classWriter.toByteArray());
            }
        }
        try {
            object = (FieldAccess)clazz2.newInstance();
            ((FieldAccess)object).fieldNames = objectArray;
            ((FieldAccess)object).fieldTypes = classArray;
            ((FieldAccess)object).fields = arrayList.toArray(new Field[arrayList.size()]);
            return object;
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Error constructing field access class: " + string2, throwable);
        }
    }

    private static void insertConstructor(ClassWriter classWriter) {
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitMethodInsn(183, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();
    }

    private static void insertSetObject(ClassWriter classWriter, String string, ArrayList<Field> arrayList) {
        int n2 = 6;
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(21, 2);
        if (!arrayList.isEmpty()) {
            --n2;
            Label[] labelArray = new Label[arrayList.size()];
            int n3 = labelArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                labelArray[i2] = new Label();
            }
            Label label = new Label();
            methodVisitor.visitTableSwitchInsn(0, labelArray.length - 1, label, labelArray);
            int n4 = labelArray.length;
            for (n3 = 0; n3 < n4; ++n3) {
                Field field = arrayList.get(n3);
                Type type = Type.getType(field.getType());
                methodVisitor.visitLabel(labelArray[n3]);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(192, string);
                methodVisitor.visitVarInsn(25, 3);
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
                methodVisitor.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), type.getDescriptor());
                methodVisitor.visitInsn(177);
            }
            methodVisitor.visitLabel(label);
            methodVisitor.visitFrame(3, 0, null, 0, null);
        }
        methodVisitor = FieldAccess.insertThrowExceptionForFieldNotFound(methodVisitor);
        methodVisitor.visitMaxs(n2, 4);
        methodVisitor.visitEnd();
    }

    private static void insertGetObject(ClassWriter classWriter, String string, ArrayList<Field> arrayList) {
        int n2 = 6;
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(21, 2);
        if (!arrayList.isEmpty()) {
            --n2;
            Label[] labelArray = new Label[arrayList.size()];
            int n3 = labelArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                labelArray[i2] = new Label();
            }
            Label label = new Label();
            methodVisitor.visitTableSwitchInsn(0, labelArray.length - 1, label, labelArray);
            int n4 = labelArray.length;
            for (n3 = 0; n3 < n4; ++n3) {
                Field field = arrayList.get(n3);
                methodVisitor.visitLabel(labelArray[n3]);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(192, string);
                methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), Type.getDescriptor(field.getType()));
                Type type = Type.getType(field.getType());
                switch (type.getSort()) {
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
        FieldAccess.insertThrowExceptionForFieldNotFound(methodVisitor);
        methodVisitor.visitMaxs(n2, 3);
        methodVisitor.visitEnd();
    }

    private static void insertGetString(ClassWriter classWriter, String string, ArrayList<Field> arrayList) {
        int n2 = 6;
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(21, 2);
        if (!arrayList.isEmpty()) {
            --n2;
            Label[] labelArray = new Label[arrayList.size()];
            Label label = new Label();
            boolean bl2 = false;
            int n3 = labelArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (arrayList.get(i2).getType().equals(String.class)) {
                    labelArray[i2] = new Label();
                    continue;
                }
                labelArray[i2] = label;
                bl2 = true;
            }
            Label label2 = new Label();
            methodVisitor.visitTableSwitchInsn(0, labelArray.length - 1, label2, labelArray);
            int n4 = labelArray.length;
            for (n3 = 0; n3 < n4; ++n3) {
                if (labelArray[n3].equals(label)) continue;
                Field field = arrayList.get(n3);
                methodVisitor.visitLabel(labelArray[n3]);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(192, string);
                methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), "Ljava/lang/String;");
                methodVisitor.visitInsn(176);
            }
            if (bl2) {
                methodVisitor.visitLabel(label);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                FieldAccess.insertThrowExceptionForFieldType(methodVisitor, "String");
            }
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(3, 0, null, 0, null);
        }
        FieldAccess.insertThrowExceptionForFieldNotFound(methodVisitor);
        methodVisitor.visitMaxs(n2, 3);
        methodVisitor.visitEnd();
    }

    private static void insertSetPrimitive(ClassWriter classWriter, String string, ArrayList<Field> arrayList, Type type) {
        int n2;
        String string2;
        int n3 = 6;
        int n4 = 4;
        String string3 = type.getDescriptor();
        switch (type.getSort()) {
            case 1: {
                string2 = "setBoolean";
                n2 = 21;
                break;
            }
            case 3: {
                string2 = "setByte";
                n2 = 21;
                break;
            }
            case 2: {
                string2 = "setChar";
                n2 = 21;
                break;
            }
            case 4: {
                string2 = "setShort";
                n2 = 21;
                break;
            }
            case 5: {
                string2 = "setInt";
                n2 = 21;
                break;
            }
            case 6: {
                string2 = "setFloat";
                n2 = 23;
                break;
            }
            case 7: {
                string2 = "setLong";
                n2 = 22;
                ++n4;
                break;
            }
            case 8: {
                string2 = "setDouble";
                n2 = 24;
                ++n4;
                break;
            }
            default: {
                string2 = "set";
                n2 = 25;
            }
        }
        MethodVisitor methodVisitor = classWriter.visitMethod(1, string2, "(Ljava/lang/Object;I" + string3 + ")V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(21, 2);
        if (!arrayList.isEmpty()) {
            --n3;
            Label[] labelArray = new Label[arrayList.size()];
            Label label = new Label();
            boolean bl2 = false;
            int n5 = labelArray.length;
            for (int i2 = 0; i2 < n5; ++i2) {
                if (Type.getType(arrayList.get(i2).getType()).equals(type)) {
                    labelArray[i2] = new Label();
                    continue;
                }
                labelArray[i2] = label;
                bl2 = true;
            }
            Label label2 = new Label();
            methodVisitor.visitTableSwitchInsn(0, labelArray.length - 1, label2, labelArray);
            int n6 = labelArray.length;
            for (n5 = 0; n5 < n6; ++n5) {
                if (labelArray[n5].equals(label)) continue;
                Field field = arrayList.get(n5);
                methodVisitor.visitLabel(labelArray[n5]);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(192, string);
                methodVisitor.visitVarInsn(n2, 3);
                methodVisitor.visitFieldInsn(181, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), string3);
                methodVisitor.visitInsn(177);
            }
            if (bl2) {
                methodVisitor.visitLabel(label);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                FieldAccess.insertThrowExceptionForFieldType(methodVisitor, type.getClassName());
            }
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(3, 0, null, 0, null);
        }
        methodVisitor = FieldAccess.insertThrowExceptionForFieldNotFound(methodVisitor);
        methodVisitor.visitMaxs(n3, n4);
        methodVisitor.visitEnd();
    }

    private static void insertGetPrimitive(ClassWriter classWriter, String string, ArrayList<Field> arrayList, Type type) {
        int n2;
        String string2;
        int n3 = 6;
        String string3 = type.getDescriptor();
        switch (type.getSort()) {
            case 1: {
                string2 = "getBoolean";
                n2 = 172;
                break;
            }
            case 3: {
                string2 = "getByte";
                n2 = 172;
                break;
            }
            case 2: {
                string2 = "getChar";
                n2 = 172;
                break;
            }
            case 4: {
                string2 = "getShort";
                n2 = 172;
                break;
            }
            case 5: {
                string2 = "getInt";
                n2 = 172;
                break;
            }
            case 6: {
                string2 = "getFloat";
                n2 = 174;
                break;
            }
            case 7: {
                string2 = "getLong";
                n2 = 173;
                break;
            }
            case 8: {
                string2 = "getDouble";
                n2 = 175;
                break;
            }
            default: {
                string2 = "get";
                n2 = 176;
            }
        }
        MethodVisitor methodVisitor = classWriter.visitMethod(1, string2, "(Ljava/lang/Object;I)" + string3, null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(21, 2);
        if (!arrayList.isEmpty()) {
            --n3;
            Label[] labelArray = new Label[arrayList.size()];
            Label label = new Label();
            boolean bl2 = false;
            int n4 = labelArray.length;
            for (int i2 = 0; i2 < n4; ++i2) {
                if (Type.getType(arrayList.get(i2).getType()).equals(type)) {
                    labelArray[i2] = new Label();
                    continue;
                }
                labelArray[i2] = label;
                bl2 = true;
            }
            Label label2 = new Label();
            methodVisitor.visitTableSwitchInsn(0, labelArray.length - 1, label2, labelArray);
            int n5 = labelArray.length;
            for (n4 = 0; n4 < n5; ++n4) {
                Field field = arrayList.get(n4);
                if (labelArray[n4].equals(label)) continue;
                methodVisitor.visitLabel(labelArray[n4]);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(192, string);
                methodVisitor.visitFieldInsn(180, field.getDeclaringClass().getName().replace('.', '/'), field.getName(), string3);
                methodVisitor.visitInsn(n2);
            }
            if (bl2) {
                methodVisitor.visitLabel(label);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                FieldAccess.insertThrowExceptionForFieldType(methodVisitor, type.getClassName());
            }
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(3, 0, null, 0, null);
        }
        methodVisitor = FieldAccess.insertThrowExceptionForFieldNotFound(methodVisitor);
        methodVisitor.visitMaxs(n3, 3);
        methodVisitor.visitEnd();
    }

    private static MethodVisitor insertThrowExceptionForFieldNotFound(MethodVisitor methodVisitor) {
        methodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
        methodVisitor.visitInsn(89);
        methodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("Field not found: ");
        methodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitVarInsn(21, 2);
        methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        methodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(191);
        return methodVisitor;
    }

    private static MethodVisitor insertThrowExceptionForFieldType(MethodVisitor methodVisitor, String string) {
        methodVisitor.visitTypeInsn(187, "java/lang/IllegalArgumentException");
        methodVisitor.visitInsn(89);
        methodVisitor.visitTypeInsn(187, "java/lang/StringBuilder");
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("Field not declared as " + string + ": ");
        methodVisitor.visitMethodInsn(183, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitVarInsn(21, 2);
        methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        methodVisitor.visitMethodInsn(183, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(191);
        return methodVisitor;
    }
}

