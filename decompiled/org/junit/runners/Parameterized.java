/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Parameterized
extends Suite {
    private final ArrayList<Runner> runners = new ArrayList();

    public Parameterized(Class<?> clazz) {
        super(clazz, Collections.<Runner>emptyList());
        List<Object[]> list = this.getParametersList(this.getTestClass());
        for (int i2 = 0; i2 < list.size(); ++i2) {
            this.runners.add(new a(this, this.getTestClass().getJavaClass(), list, i2));
        }
    }

    @Override
    protected List<Runner> getChildren() {
        return this.runners;
    }

    private List<Object[]> getParametersList(TestClass testClass) {
        return (List)this.getParametersMethod(testClass).invokeExplosively(null, new Object[0]);
    }

    private FrameworkMethod getParametersMethod(TestClass testClass) {
        List<FrameworkMethod> list = testClass.getAnnotatedMethods(Parameters.class);
        for (FrameworkMethod frameworkMethod : list) {
            int n2 = frameworkMethod.getMethod().getModifiers();
            if (!Modifier.isStatic(n2) || !Modifier.isPublic(n2)) continue;
            return frameworkMethod;
        }
        throw new Exception("No public static parameters method on class " + testClass.getName());
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    class a
    extends BlockJUnit4ClassRunner {
        private final int var_int_a;
        private final List<Object[]> var_java_util_List_java_lang_Object_arr__a;
        final /* synthetic */ Parameterized var_org_junit_runners_Parameterized_a;

        a(Parameterized parameterized, Class<?> clazz, List<Object[]> list, int n2) {
            this.var_org_junit_runners_Parameterized_a = parameterized;
            super(clazz);
            this.var_int_a = (int)list;
            this.var_int_a = n2;
        }

        @Override
        public Object createTest() {
            return this.getTestClass().getOnlyConstructor().newInstance(this.a());
        }

        private Object[] a() {
            try {
                return (Object[])this.var_int_a.get(this.var_int_a);
            }
            catch (ClassCastException classCastException) {
                throw new Exception(String.format("%s.%s() must return a Collection of arrays.", this.getTestClass().getName(), this.var_org_junit_runners_Parameterized_a.getParametersMethod(this.getTestClass()).getName()));
            }
        }

        @Override
        protected String getName() {
            return String.format("[%s]", this.var_int_a);
        }

        @Override
        protected String testName(FrameworkMethod frameworkMethod) {
            return String.format("%s[%s]", frameworkMethod.getName(), this.var_int_a);
        }

        @Override
        protected void validateZeroArgConstructor(List<Throwable> list) {
        }

        @Override
        protected Statement classBlock(RunNotifier runNotifier) {
            return this.childrenInvoker(runNotifier);
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    public static @interface Parameters {
    }
}

