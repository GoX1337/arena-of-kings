/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.core.ext.GeneratorContext
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.TreeLogger$Type
 *  com.google.gwt.core.ext.UnableToCompleteException
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.JParameter
 *  com.google.gwt.core.ext.typeinfo.NotFoundException
 *  com.google.gwt.user.rebind.ClassSourceFileComposerFactory
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.Provider
 *  com.google.inject.Singleton
 *  com.google.inject.spi.InjectionPoint
 */
package com.google.gwt.inject.rebind;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.inject.rebind.BindingsProcessor;
import com.google.gwt.inject.rebind.GinScope;
import com.google.gwt.inject.rebind.GinjectorInterfaceType;
import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.Injectable;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.MemberCollector;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.spi.InjectionPoint;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Singleton
class GinjectorOutputter {
    private final TreeLogger logger;
    private final GeneratorContext ctx;
    private final BindingsProcessor bindingsProcessor;
    private final NameGenerator nameGenerator;
    private final MemberCollector constructorInjectCollector;
    private final MemberCollector memberInjectCollector;
    private final MemberCollector injectableCollector;
    private final SourceWriteUtil sourceWriteUtil;
    private final KeyUtil keyUtil;
    private final JClassType ginjectorInterface;
    private SourceWriter writer;
    private StringBuilder constructorBody = new StringBuilder();

    @Inject
    GinjectorOutputter(NameGenerator nameGenerator, TreeLogger treeLogger, Provider<MemberCollector> provider, @Injectable MemberCollector memberCollector, SourceWriteUtil sourceWriteUtil, final KeyUtil keyUtil, GeneratorContext generatorContext, BindingsProcessor bindingsProcessor, @GinjectorInterfaceType JClassType jClassType) {
        this.nameGenerator = nameGenerator;
        this.logger = treeLogger;
        this.injectableCollector = memberCollector;
        this.sourceWriteUtil = sourceWriteUtil;
        this.keyUtil = keyUtil;
        this.ctx = generatorContext;
        this.bindingsProcessor = bindingsProcessor;
        this.ginjectorInterface = jClassType;
        this.constructorInjectCollector = (MemberCollector)provider.get();
        this.constructorInjectCollector.setMethodFilter(new MemberCollector.MethodFilter(){

            public boolean accept(JMethod jMethod) {
                return jMethod.getParameters().length == 0;
            }
        });
        this.memberInjectCollector = (MemberCollector)provider.get();
        this.memberInjectCollector.setMethodFilter(new MemberCollector.MethodFilter(){

            public boolean accept(JMethod jMethod) {
                return keyUtil.isMemberInject(jMethod);
            }
        });
    }

    void output(String string, String string2, PrintWriter printWriter) {
        ClassSourceFileComposerFactory classSourceFileComposerFactory = new ClassSourceFileComposerFactory(string, string2);
        classSourceFileComposerFactory.addImplementedInterface(this.ginjectorInterface.getParameterizedQualifiedSourceName());
        classSourceFileComposerFactory.addImport(GWT.class.getCanonicalName());
        this.writer = classSourceFileComposerFactory.createSourceWriter(this.ctx, printWriter);
        this.outputInterfaceMethods();
        this.outputBindings();
        this.outputStaticInjections();
        this.outputMemberInjections();
        this.writeConstructor(string2);
        this.writer.commit(this.logger);
    }

    private void outputBindings() {
        for (Map.Entry<Key<?>, Binding> entry : this.bindingsProcessor.getBindings().entrySet()) {
            Key<?> key = entry.getKey();
            String string = this.sourceWriteUtil.getSourceName(key.getTypeLiteral());
            Binding binding = entry.getValue();
            String string2 = this.nameGenerator.getGetterMethodName(key);
            String string3 = this.nameGenerator.getCreatorMethodName(key);
            binding.writeCreatorMethods(this.writer, "private " + string + " " + string3 + "()");
            String string4 = this.nameGenerator.getSingletonFieldName(key);
            GinScope ginScope = this.bindingsProcessor.determineScope(key);
            switch (ginScope) {
                case EAGER_SINGLETON: {
                    this.constructorBody.append(string2).append("();\n");
                }
                case SINGLETON: {
                    this.writer.println("private " + string + " " + string4 + " = null;");
                    this.writer.println();
                    this.writer.println("private " + string + " " + string2 + "()" + " {");
                    this.writer.indent();
                    this.writer.println("if (" + string4 + " == null) {");
                    this.writer.indent();
                    this.writer.println(string4 + " = " + string3 + "();");
                    this.writer.outdent();
                    this.writer.println("}");
                    this.writer.println("return " + string4 + ";");
                    this.writer.outdent();
                    this.writer.println("}");
                    break;
                }
                case NO_SCOPE: {
                    this.sourceWriteUtil.writeMethod(this.writer, "private " + string + " " + string2 + "()", "return " + string3 + "();");
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            this.writer.println();
        }
    }

    private void outputInterfaceMethods() {
        StringBuilder stringBuilder;
        for (JMethod jMethod : this.constructorInjectCollector.getMethods(this.ginjectorInterface)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("return ").append(this.nameGenerator.getGetterMethodName(this.keyUtil.getKey(jMethod))).append("();");
            this.sourceWriteUtil.writeMethod(this.writer, jMethod.getReadableDeclaration(false, false, false, false, true), stringBuilder.toString());
        }
        for (JMethod jMethod : this.memberInjectCollector.getMethods(this.ginjectorInterface)) {
            stringBuilder = jMethod.getParameters()[0];
            String string = this.nameGenerator.getMemberInjectMethodName(this.keyUtil.getKey((JParameter)stringBuilder)) + "(" + stringBuilder.getName() + ");";
            this.sourceWriteUtil.writeMethod(this.writer, jMethod.getReadableDeclaration(false, false, false, false, true), string);
        }
    }

    private void outputStaticInjections() {
        boolean bl2 = false;
        for (Class<?> clazz : this.bindingsProcessor.getStaticInjectionRequests()) {
            String string = this.nameGenerator.convertToValidMemberName("injectStatic_" + clazz.getName());
            StringBuilder stringBuilder = new StringBuilder();
            for (InjectionPoint injectionPoint : InjectionPoint.forStaticMethodsAndFields(clazz)) {
                Member member = injectionPoint.getMember();
                if (member instanceof Method) {
                    try {
                        stringBuilder.append(this.sourceWriteUtil.createMethodCallWithInjection(this.writer, (JAbstractMethod)this.keyUtil.javaToGwtMethod((Method)member), null));
                    }
                    catch (NotFoundException notFoundException) {
                        bl2 = true;
                        this.logger.log(TreeLogger.Type.ERROR, notFoundException.getMessage(), (Throwable)notFoundException);
                    }
                    continue;
                }
                if (!(member instanceof Field)) continue;
                stringBuilder.append(this.sourceWriteUtil.createFieldInjection(this.writer, this.keyUtil.javaToGwtField((Field)member), null));
            }
            this.sourceWriteUtil.writeMethod(this.writer, "private void " + string + "()", stringBuilder.toString());
            this.constructorBody.append(string).append("();\n");
        }
        if (bl2) {
            throw new UnableToCompleteException();
        }
    }

    private void outputMemberInjections() {
        for (Key<?> key : this.bindingsProcessor.getMemberInjectRequests()) {
            this.sourceWriteUtil.appendMemberInjection(this.writer, key);
        }
    }

    private void writeConstructor(String string) {
        this.sourceWriteUtil.writeMethod(this.writer, "public " + string + "()", this.constructorBody.toString());
    }
}

