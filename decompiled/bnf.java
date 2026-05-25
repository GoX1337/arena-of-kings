/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;

final class bnf {
    public static bns a(Method method, bfw bfw2, btz btz2, bns bns2) {
        bty bty2 = bnf.a(method, bfw2, bns2);
        return bty2 == null ? bns2 : new bns.a(btz2, bty2);
    }

    static bty a(Method method, bfw bfw2, bns bns2) {
        TypeVariable<Method>[] typeVariableArray = method.getTypeParameters();
        if (typeVariableArray.length == 0 || bfw2.bty_a().boolean_a()) {
            return null;
        }
        Type type = method.getGenericReturnType();
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType)type;
        if (!Objects.equals(bfw2.a(), parameterizedType.getRawType())) {
            return null;
        }
        Type[] typeArray = parameterizedType.getActualTypeArguments();
        ArrayList<String> arrayList = new ArrayList<String>(typeVariableArray.length);
        ArrayList<bfw> arrayList2 = new ArrayList<bfw>(typeVariableArray.length);
        for (int i2 = 0; i2 < typeArray.length; ++i2) {
            Type type2 = typeArray[i2];
            TypeVariable<?> typeVariable = bnf.a(type2);
            if (typeVariable == null) continue;
            String string = typeVariable.getName();
            if (string == null) {
                return null;
            }
            bfw bfw3 = bfw2.bty_a().a(i2);
            if (bfw3 == null) {
                return null;
            }
            TypeVariable<?> typeVariable2 = bnf.a(typeVariableArray, string);
            if (typeVariable2 == null) {
                return null;
            }
            if (!bnf.a(bns2, bfw3, typeVariable2.getBounds())) continue;
            int n2 = arrayList.indexOf(string);
            if (n2 != -1) {
                bfw bfw4 = arrayList2.get(n2);
                if (bfw3.equals(bfw4)) continue;
                boolean bl2 = bfw4.b((Class<?>)bfw3.a());
                boolean bl3 = bfw3.b((Class<?>)bfw4.a());
                if (!bl2 && !bl3) {
                    return null;
                }
                if (!(bl2 ^ bl3) || !bl3) continue;
                arrayList2.set(n2, bfw3);
                continue;
            }
            arrayList.add(string);
            arrayList2.add(bfw3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return bty.a(arrayList, arrayList2);
    }

    private static TypeVariable<?> a(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable)type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] typeArray = wildcardType.getUpperBounds();
            if (typeArray.length == 1) {
                return bnf.a(typeArray[0]);
            }
        }
        return null;
    }

    private static ParameterizedType a(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType)type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] typeArray = wildcardType.getUpperBounds();
            if (typeArray.length == 1) {
                return bnf.a(typeArray[0]);
            }
        }
        return null;
    }

    private static boolean a(bns bns2, bfw bfw2, Type[] typeArray) {
        for (Type type : typeArray) {
            if (bnf.a(bns2, bfw2, type)) continue;
            return false;
        }
        return true;
    }

    private static boolean a(bns bns2, bfw bfw2, Type type) {
        if (!bfw2.b((Class<?>)bns2.a(type).a())) {
            return false;
        }
        ParameterizedType parameterizedType = bnf.a(type);
        if (parameterizedType != null && Objects.equals(bfw2.a(), parameterizedType.getRawType())) {
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            bty bty2 = bfw2.bty_a();
            if (bty2.int_a() != typeArray.length) {
                return false;
            }
            for (int i2 = 0; i2 < bty2.int_a(); ++i2) {
                Type type2;
                bfw bfw3 = bty2.a(i2);
                if (bnf.a(bns2, bfw3, type2 = typeArray[i2])) continue;
                return false;
            }
        }
        return true;
    }

    private static TypeVariable<?> a(TypeVariable<?>[] typeVariableArray, String string) {
        if (typeVariableArray == null || string == null) {
            return null;
        }
        for (TypeVariable<?> typeVariable : typeVariableArray) {
            if (!string.equals(typeVariable.getName())) continue;
            return typeVariable;
        }
        return null;
    }
}

