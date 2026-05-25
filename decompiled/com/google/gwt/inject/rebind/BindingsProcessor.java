/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.UnableToCompleteException
 *  com.google.gwt.core.ext.typeinfo.HasAnnotations
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JConstructor
 *  com.google.gwt.core.ext.typeinfo.JField
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.JPackage
 *  com.google.gwt.core.ext.typeinfo.JPrimitiveType
 *  com.google.gwt.core.ext.typeinfo.JType
 *  com.google.gwt.core.ext.typeinfo.NotFoundException
 *  com.google.inject.Binding
 *  com.google.inject.Guice
 *  com.google.inject.ImplementedBy
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.Module
 *  com.google.inject.ProvidedBy
 *  com.google.inject.Provider
 *  com.google.inject.Scope
 *  com.google.inject.Singleton
 *  com.google.inject.Stage
 *  com.google.inject.internal.ProviderMethod
 *  com.google.inject.spi.BindingScopingVisitor
 *  com.google.inject.spi.DefaultBindingTargetVisitor
 *  com.google.inject.spi.DefaultElementVisitor
 *  com.google.inject.spi.Element
 *  com.google.inject.spi.ElementVisitor
 *  com.google.inject.spi.Elements
 *  com.google.inject.spi.InjectionPoint
 *  com.google.inject.spi.InstanceBinding
 *  com.google.inject.spi.LinkedKeyBinding
 *  com.google.inject.spi.Message
 *  com.google.inject.spi.ProviderInstanceBinding
 *  com.google.inject.spi.ProviderKeyBinding
 *  com.google.inject.spi.ProviderLookup
 *  com.google.inject.spi.StaticInjectionRequest
 *  com.google.inject.spi.UntargettedBinding
 */
package com.google.gwt.inject.rebind;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.HasAnnotations;
import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JConstructor;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JPackage;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.rebind.GinScope;
import com.google.gwt.inject.rebind.GinjectorInterfaceType;
import com.google.gwt.inject.rebind.LieToGuiceModule;
import com.google.gwt.inject.rebind.adapter.GinModuleAdapter;
import com.google.gwt.inject.rebind.adapter.GwtDotCreateProvider;
import com.google.gwt.inject.rebind.binding.BindClassBinding;
import com.google.gwt.inject.rebind.binding.BindConstantBinding;
import com.google.gwt.inject.rebind.binding.BindProviderBinding;
import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.BindingIndex;
import com.google.gwt.inject.rebind.binding.CallConstructorBinding;
import com.google.gwt.inject.rebind.binding.CallGwtDotCreateBinding;
import com.google.gwt.inject.rebind.binding.GinjectorBinding;
import com.google.gwt.inject.rebind.binding.ImplicitProviderBinding;
import com.google.gwt.inject.rebind.binding.ProviderMethodBinding;
import com.google.gwt.inject.rebind.binding.RemoteServiceProxyBinding;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.MemberCollector;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.ProvidedBy;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.Singleton;
import com.google.inject.Stage;
import com.google.inject.internal.ProviderMethod;
import com.google.inject.spi.BindingScopingVisitor;
import com.google.inject.spi.DefaultBindingTargetVisitor;
import com.google.inject.spi.DefaultElementVisitor;
import com.google.inject.spi.Element;
import com.google.inject.spi.ElementVisitor;
import com.google.inject.spi.Elements;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.InstanceBinding;
import com.google.inject.spi.LinkedKeyBinding;
import com.google.inject.spi.Message;
import com.google.inject.spi.ProviderInstanceBinding;
import com.google.inject.spi.ProviderKeyBinding;
import com.google.inject.spi.ProviderLookup;
import com.google.inject.spi.StaticInjectionRequest;
import com.google.inject.spi.UntargettedBinding;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Singleton
class BindingsProcessor
implements BindingIndex {
    private static final JType[] ZERO_ARGS = new JType[0];
    private final TreeLogger logger;
    private final NameGenerator nameGenerator;
    private final Map<Key<?>, Binding> bindings = new HashMap();
    private final Map<Key<?>, GinScope> scopes = new HashMap();
    private final Set<Key<?>> unresolved = new HashSet();
    private final Set<Key<?>> unresolvedOptional = new HashSet();
    private final Set<Key<?>> memberInjectRequests = new HashSet();
    private final Set<Class<?>> staticInjectionRequests = new HashSet();
    private final MemberCollector completeCollector;
    private final Provider<CallGwtDotCreateBinding> callGwtDotCreateBindingProvider;
    private final Provider<RemoteServiceProxyBinding> remoteServiceProxyBindingProvider;
    private final Provider<CallConstructorBinding> callConstructorBinding;
    private final Provider<BindClassBinding> bindClassBindingProvider;
    private final Provider<BindProviderBinding> bindProviderBindingProvider;
    private final Provider<ImplicitProviderBinding> implicitProviderBindingProvider;
    private final Provider<ProviderMethodBinding> providerMethodBindingProvider;
    private final Provider<BindConstantBinding> bindConstantBindingProvider;
    private final Provider<GinjectorBinding> ginjectorBindingProvider;
    private final KeyUtil keyUtil;
    private final JClassType ginjectorInterface;
    private final LieToGuiceModule lieToGuiceModule;
    private boolean foundError = false;

    @Inject
    BindingsProcessor(NameGenerator nameGenerator, TreeLogger treeLogger, Provider<MemberCollector> provider, Provider<CallGwtDotCreateBinding> provider2, Provider<CallConstructorBinding> provider3, KeyUtil keyUtil, Provider<BindClassBinding> provider4, Provider<BindProviderBinding> provider5, Provider<ImplicitProviderBinding> provider6, @GinjectorInterfaceType JClassType jClassType, LieToGuiceModule lieToGuiceModule, Provider<BindConstantBinding> provider7, Provider<RemoteServiceProxyBinding> provider8, Provider<ProviderMethodBinding> provider9, Provider<GinjectorBinding> provider10) {
        this.nameGenerator = nameGenerator;
        this.logger = treeLogger;
        this.callGwtDotCreateBindingProvider = provider2;
        this.callConstructorBinding = provider3;
        this.bindClassBindingProvider = provider4;
        this.implicitProviderBindingProvider = provider6;
        this.bindProviderBindingProvider = provider5;
        this.keyUtil = keyUtil;
        this.ginjectorInterface = jClassType;
        this.lieToGuiceModule = lieToGuiceModule;
        this.remoteServiceProxyBindingProvider = provider8;
        this.bindConstantBindingProvider = provider7;
        this.providerMethodBindingProvider = provider9;
        this.ginjectorBindingProvider = provider10;
        this.completeCollector = (MemberCollector)provider.get();
        this.completeCollector.setMethodFilter(MemberCollector.ALL_METHOD_FILTER);
    }

    public void process() {
        this.validateMethods();
        this.addUnresolvedEntriesForInjectorInterface();
        List<Module> list = this.createModules();
        this.createBindingsForModules(list);
        this.createImplicitBindingsForUnresolved();
        this.validateModulesUsingGuice(list);
    }

    private void createImplicitBindingsForUnresolved() {
        while (!this.unresolved.isEmpty() || !this.unresolvedOptional.isEmpty()) {
            for (Key<?> key : new ArrayList(this.unresolved)) {
                this.createImplicitBindingForUnresolved(key, false);
            }
            for (Key<?> key : new ArrayList(this.unresolvedOptional)) {
                this.createImplicitBindingForUnresolved(key, true);
            }
            this.checkForError();
        }
    }

    private void createImplicitBindingForUnresolved(Key<?> key, boolean bl2) {
        Binding binding = this.createImplicitBinding(key, bl2);
        if (binding != null) {
            this.logger.log(TreeLogger.TRACE, "Implicit binding for " + key + ": " + binding);
            if (binding instanceof CallGwtDotCreateBinding || binding instanceof GinjectorBinding) {
                this.lieToGuiceModule.registerImplicitBinding(key);
            }
            this.addBinding(key, binding);
        } else if (bl2) {
            this.unresolvedOptional.remove(key);
        }
    }

    private void checkForError() {
        if (this.foundError) {
            throw new UnableToCompleteException();
        }
    }

    public Map<Key<?>, Binding> getBindings() {
        return this.bindings;
    }

    public Map<Key<?>, GinScope> getScopes() {
        return this.scopes;
    }

    public Set<Class<?>> getStaticInjectionRequests() {
        return this.staticInjectionRequests;
    }

    public Set<Key<?>> getMemberInjectRequests() {
        return this.memberInjectRequests;
    }

    public GinScope determineScope(Key<?> key) {
        GinScope ginScope = this.getScopes().get(key);
        if (ginScope == null) {
            Class<?> clazz = this.keyUtil.getRawType(key);
            ginScope = clazz.getAnnotation(Singleton.class) != null ? GinScope.SINGLETON : (RemoteServiceProxyBinding.isRemoteServiceProxy(this.keyUtil.getRawClassType(key)) ? GinScope.SINGLETON : GinScope.NO_SCOPE);
        }
        this.logger.log(TreeLogger.TRACE, "scope for " + key + ": " + (Object)((Object)ginScope));
        return ginScope;
    }

    @Override
    public boolean isBound(Key<?> key) {
        return this.bindings.containsKey(key);
    }

    private void validateMethods() {
        for (JMethod jMethod : this.completeCollector.getMethods(this.ginjectorInterface)) {
            if (jMethod.getParameters().length > 1) {
                this.logError("Injector methods cannot have more than one parameter,  found: " + jMethod.getReadableDeclaration());
            }
            if (jMethod.getParameters().length == 1) {
                if (jMethod.getParameters()[0].getType().isClassOrInterface() == null) {
                    this.logError("Injector method parameter types must be a class or interface, found: " + jMethod.getReadableDeclaration());
                }
                if (jMethod.getReturnType() == JPrimitiveType.VOID) continue;
                this.logError("Injector methods with a parameter must have a void return type, found: " + jMethod.getReadableDeclaration());
                continue;
            }
            if (jMethod.getReturnType() != JPrimitiveType.VOID) continue;
            this.logError("Injector methods with no parameters cannot return void");
        }
        this.checkForError();
    }

    private void addUnresolvedEntriesForInjectorInterface() {
        for (JMethod jMethod : this.completeCollector.getMethods(this.ginjectorInterface)) {
            this.nameGenerator.markAsUsed(jMethod.getName());
            Key<?> key = this.keyUtil.getKey(jMethod);
            this.logger.log(TreeLogger.TRACE, "Add unresolved key from injector interface: " + key);
            if (this.keyUtil.isMemberInject(jMethod)) {
                if (this.unresolved.contains(key)) continue;
                this.memberInjectRequests.add(key);
                RequiredKeys requiredKeys = this.keyUtil.getRequiredKeys(this.keyUtil.getClassType(key));
                this.unresolved.addAll(requiredKeys.getRequiredKeys());
                this.unresolvedOptional.addAll(requiredKeys.getOptionalKeys());
                continue;
            }
            this.unresolved.add(key);
        }
    }

    private void createBindingsForModules(List<Module> list) {
        List list2 = Elements.getElements(list);
        for (Element element : list2) {
            GuiceElementVisitor guiceElementVisitor = new GuiceElementVisitor();
            element.acceptVisitor((ElementVisitor)guiceElementVisitor);
            List<Message> list3 = guiceElementVisitor.getMessages();
            if (list3.isEmpty()) continue;
            for (Message message : list3) {
                this.logError(message.toString(), message.getCause());
            }
        }
        this.checkForError();
    }

    private List<Module> createModules() {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        this.populateModulesFromInjectorInterface(this.ginjectorInterface, arrayList);
        return arrayList;
    }

    private void validateModulesUsingGuice(List<Module> list) {
        try {
            ArrayList<LieToGuiceModule> arrayList = new ArrayList<LieToGuiceModule>(list.size() + 1);
            arrayList.add(this.lieToGuiceModule);
            arrayList.addAll(list);
            Guice.createInjector((Stage)Stage.TOOL, arrayList);
        }
        catch (Exception exception) {
            this.logError("Errors from Guice: " + exception.getMessage(), exception);
            throw new UnableToCompleteException();
        }
    }

    private void populateModulesFromInjectorInterface(JClassType jClassType, List<Module> list) {
        GinModules ginModules = (GinModules)jClassType.getAnnotation(GinModules.class);
        if (ginModules != null) {
            for (Class<? extends GinModule> clazz : ginModules.value()) {
                Module module = this.instantiateGModuleClass(clazz);
                if (module == null) continue;
                list.add(module);
            }
        }
        for (Class<? extends GinModule> clazz : jClassType.getImplementedInterfaces()) {
            this.populateModulesFromInjectorInterface((JClassType)clazz, list);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Module instantiateGModuleClass(Class<? extends GinModule> clazz) {
        Constructor<? extends GinModule> constructor = clazz.getDeclaredConstructor(new Class[0]);
        try {
            constructor.setAccessible(true);
            GinModuleAdapter ginModuleAdapter = new GinModuleAdapter(constructor.newInstance(new Object[0]));
            constructor.setAccessible(false);
            return ginModuleAdapter;
        }
        catch (Throwable throwable) {
            try {
                constructor.setAccessible(false);
                throw throwable;
            }
            catch (IllegalAccessException illegalAccessException) {
                this.logError("Error creating module: " + clazz, illegalAccessException);
            }
            catch (InstantiationException instantiationException) {
                this.logError("Error creating module: " + clazz, instantiationException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.logError("Error creating module: " + clazz, noSuchMethodException);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.logError("Error creating module: " + clazz, invocationTargetException);
            }
        }
        return null;
    }

    private Binding createImplicitBinding(Key<?> key, boolean bl2) {
        JClassType jClassType = this.keyUtil.getRawClassType(key);
        if (jClassType.equals((Object)this.ginjectorInterface)) {
            return (Binding)this.ginjectorBindingProvider.get();
        }
        if (this.isProviderKey(key)) {
            ImplicitProviderBinding implicitProviderBinding = (ImplicitProviderBinding)this.implicitProviderBindingProvider.get();
            implicitProviderBinding.setProviderKey(key);
            if (bl2) {
                return this.checkOptionalBindingAvailability(implicitProviderBinding);
            }
            return implicitProviderBinding;
        }
        if (BindConstantBinding.isConstantKey(key)) {
            if (!bl2) {
                this.logError("Binding requested for constant key " + key + " but no explicit binding was found.");
            }
            return null;
        }
        if (key.getAnnotation() != null || key.getAnnotationType() != null) {
            if (!bl2) {
                this.logError("No implementation bound for key " + key);
            }
            return null;
        }
        ImplementedBy implementedBy = (ImplementedBy)jClassType.getAnnotation(ImplementedBy.class);
        if (implementedBy != null) {
            return this.createImplementedByBinding(key, implementedBy, bl2);
        }
        ProvidedBy providedBy = (ProvidedBy)jClassType.getAnnotation(ProvidedBy.class);
        if (providedBy != null) {
            return this.createProvidedByBinding(key, providedBy, bl2);
        }
        JClassType jClassType2 = this.keyUtil.getClassType(key);
        if (jClassType2 != null) {
            return this.createImplicitBindingForClass(jClassType2, bl2, key);
        }
        if (!bl2) {
            this.logError("Class not found: " + key);
        }
        return null;
    }

    private Binding createImplicitBindingForClass(JClassType jClassType, boolean bl2, Key<?> key) {
        JConstructor jConstructor = this.getInjectConstructor(jClassType);
        if (jConstructor != null) {
            CallConstructorBinding callConstructorBinding = (CallConstructorBinding)this.callConstructorBinding.get();
            callConstructorBinding.setConstructor(jConstructor, key);
            return callConstructorBinding;
        }
        if (this.hasAccessibleZeroArgConstructor(jClassType)) {
            if (RemoteServiceProxyBinding.isRemoteServiceProxy(jClassType)) {
                RemoteServiceProxyBinding remoteServiceProxyBinding = (RemoteServiceProxyBinding)this.remoteServiceProxyBindingProvider.get();
                remoteServiceProxyBinding.setClassType(jClassType, key);
                return remoteServiceProxyBinding;
            }
            CallGwtDotCreateBinding callGwtDotCreateBinding = (CallGwtDotCreateBinding)this.callGwtDotCreateBindingProvider.get();
            callGwtDotCreateBinding.setClassType(jClassType, key);
            return callGwtDotCreateBinding;
        }
        if (!bl2) {
            this.logError("No @Inject or default constructor found for " + jClassType);
        }
        return null;
    }

    private boolean hasAccessibleZeroArgConstructor(JClassType jClassType) {
        if (jClassType.isInterface() != null) {
            return true;
        }
        JConstructor jConstructor = jClassType.findConstructor(ZERO_ARGS);
        return jConstructor != null && (!jConstructor.isPrivate() || jClassType.isPrivate());
    }

    private void addBinding(Key<?> key, Binding binding) {
        if (this.bindings.containsKey(key)) {
            this.logError("Double-bound: " + key + ". " + this.bindings.get(key) + ", " + binding);
            return;
        }
        JClassType jClassType = this.keyUtil.getRawClassType(key);
        if (jClassType != null && !this.isClassAccessibleFromGinjector(jClassType)) {
            this.logError("Can not inject an instance of an inaccessible class. Key=" + key);
            return;
        }
        this.bindings.put(key, binding);
        this.unresolved.remove(key);
        this.unresolvedOptional.remove(key);
        this.memberInjectRequests.remove(key);
        this.addRequiredKeys(key, binding.getRequiredKeys());
        this.logger.log(TreeLogger.TRACE, "bound " + key + " to " + binding);
    }

    private void addRequiredKeys(Key<?> key, RequiredKeys requiredKeys) {
        HashSet hashSet = new HashSet(requiredKeys.getOptionalKeys());
        hashSet.removeAll(this.bindings.keySet());
        if (!hashSet.isEmpty()) {
            this.logger.log(TreeLogger.TRACE, "Add optional unresolved as dep from binding to " + key + ": " + hashSet);
            this.unresolvedOptional.addAll(hashSet);
        }
        HashSet hashSet2 = new HashSet(requiredKeys.getRequiredKeys());
        hashSet2.removeAll(this.bindings.keySet());
        if (!hashSet2.isEmpty()) {
            this.logger.log(TreeLogger.TRACE, "Add unresolved as dep from binding to " + key + ": " + hashSet2);
            this.unresolved.addAll(hashSet2);
        }
    }

    private <T extends Binding> T checkOptionalBindingAvailability(T t2) {
        RequiredKeys requiredKeys = t2.getRequiredKeys();
        assert (requiredKeys.getOptionalKeys().isEmpty());
        HashSet hashSet = new HashSet(requiredKeys.getRequiredKeys());
        hashSet.removeAll(this.bindings.keySet());
        for (Key key : hashSet) {
            if (this.createImplicitBinding(key, true) != null) continue;
            return null;
        }
        return t2;
    }

    private BindClassBinding createImplementedByBinding(Key<?> key, ImplementedBy implementedBy, boolean bl2) {
        Class clazz = key.getTypeLiteral().getRawType();
        Class clazz2 = implementedBy.value();
        if (clazz2 == clazz) {
            this.logError("@ImplementedBy points to the same class it annotates: " + clazz);
            return null;
        }
        if (!clazz.isAssignableFrom(clazz2)) {
            this.logError(clazz2 + " doesn't extend " + clazz + " (while resolving @ImplementedBy)");
            return null;
        }
        BindClassBinding bindClassBinding = (BindClassBinding)this.bindClassBindingProvider.get();
        bindClassBinding.setBoundClassKey(Key.get((Class)clazz2));
        if (bl2) {
            return this.checkOptionalBindingAvailability(bindClassBinding);
        }
        return bindClassBinding;
    }

    private BindProviderBinding createProvidedByBinding(Key<?> key, ProvidedBy providedBy, boolean bl2) {
        Class clazz = key.getTypeLiteral().getRawType();
        Class clazz2 = providedBy.value();
        if (clazz2 == clazz) {
            this.logError("@ProvidedBy points to the same class it annotates: " + clazz);
            return null;
        }
        BindProviderBinding bindProviderBinding = (BindProviderBinding)this.bindProviderBindingProvider.get();
        bindProviderBinding.setProviderKey(Key.get((Class)clazz2));
        if (bl2) {
            return this.checkOptionalBindingAvailability(bindProviderBinding);
        }
        return bindProviderBinding;
    }

    private boolean isProviderKey(Key<?> key) {
        Type type = key.getTypeLiteral().getType();
        return type instanceof ParameterizedType && ((ParameterizedType)type).getRawType() == Provider.class;
    }

    private boolean isClassAccessibleFromGinjector(JClassType jClassType) {
        if (jClassType.isPublic()) {
            return true;
        }
        JPackage jPackage = jClassType.getPackage();
        if (jPackage == null) {
            return false;
        }
        JPackage jPackage2 = this.ginjectorInterface.getPackage();
        return jPackage2.isDefault() && jPackage.isDefault() || jPackage.getName().equals(jPackage2.getName());
    }

    private void logError(String string) {
        this.logError(string, null);
    }

    private void logError(String string, Throwable throwable) {
        this.logger.log(TreeLogger.ERROR, string, throwable);
        this.foundError = true;
    }

    private JConstructor getInjectConstructor(JClassType jClassType) {
        JConstructor[] jConstructorArray = jClassType.getConstructors();
        JConstructor jConstructor = null;
        for (JConstructor jConstructor2 : jConstructorArray) {
            if (jConstructor2.getAnnotation(Inject.class) == null) continue;
            if (jConstructor == null) {
                jConstructor = jConstructor2;
                continue;
            }
            this.logError("More than one @Inject constructor found for " + jClassType + "; " + jConstructor + ", " + jConstructor2);
            return null;
        }
        return jConstructor;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    class GuiceBindingVisitor<T>
    extends DefaultBindingTargetVisitor<T, Void>
    implements BindingScopingVisitor<Void> {
        private final Key<T> targetKey;
        private final List<Message> messages;

        public GuiceBindingVisitor(Key<T> key, List<Message> list) {
            this.targetKey = key;
            this.messages = list;
        }

        public Void visit(ProviderKeyBinding<? extends T> providerKeyBinding) {
            BindProviderBinding bindProviderBinding = (BindProviderBinding)BindingsProcessor.this.bindProviderBindingProvider.get();
            bindProviderBinding.setProviderKey(providerKeyBinding.getProviderKey());
            BindingsProcessor.this.addBinding(this.targetKey, bindProviderBinding);
            return null;
        }

        public Void visit(ProviderInstanceBinding<? extends T> providerInstanceBinding) {
            Provider provider = providerInstanceBinding.getProviderInstance();
            if (provider instanceof ProviderMethod) {
                ProviderMethodBinding providerMethodBinding = (ProviderMethodBinding)BindingsProcessor.this.providerMethodBindingProvider.get();
                try {
                    providerMethodBinding.setProviderMethod((ProviderMethod)provider);
                    BindingsProcessor.this.addBinding(this.targetKey, providerMethodBinding);
                }
                catch (UnableToCompleteException unableToCompleteException) {
                    this.messages.add(new Message(providerInstanceBinding.getSource(), "Error processing provider method"));
                }
                return null;
            }
            if (provider instanceof GwtDotCreateProvider) {
                this.addImplicitBinding();
                return null;
            }
            return (Void)super.visit(providerInstanceBinding);
        }

        public Void visit(LinkedKeyBinding<? extends T> linkedKeyBinding) {
            BindClassBinding bindClassBinding = (BindClassBinding)BindingsProcessor.this.bindClassBindingProvider.get();
            bindClassBinding.setBoundClassKey(linkedKeyBinding.getLinkedKey());
            BindingsProcessor.this.addBinding(this.targetKey, bindClassBinding);
            return null;
        }

        public Void visit(InstanceBinding<? extends T> instanceBinding) {
            Object object = instanceBinding.getInstance();
            if (BindConstantBinding.isConstantKey(this.targetKey)) {
                BindConstantBinding bindConstantBinding = (BindConstantBinding)BindingsProcessor.this.bindConstantBindingProvider.get();
                bindConstantBinding.setKeyAndInstance(this.targetKey, object);
                BindingsProcessor.this.addBinding(this.targetKey, bindConstantBinding);
            } else {
                this.messages.add(new Message(instanceBinding.getSource(), "Instance binding not supported; key=" + this.targetKey + " inst=" + object));
            }
            return null;
        }

        public Void visit(UntargettedBinding<? extends T> untargettedBinding) {
            this.addImplicitBinding();
            return null;
        }

        private void addImplicitBinding() {
            Binding binding = BindingsProcessor.this.createImplicitBinding(this.targetKey, false);
            if (binding != null) {
                BindingsProcessor.this.logger.log(TreeLogger.TRACE, "Implicit binding for " + this.targetKey + ": " + binding);
                BindingsProcessor.this.addBinding(this.targetKey, binding);
            }
        }

        protected Void visitOther(com.google.inject.Binding<? extends T> binding) {
            this.messages.add(new Message(binding.getSource(), "Unsupported binding provided for key: " + this.targetKey + ": " + binding));
            return null;
        }

        public Void visitEagerSingleton() {
            BindingsProcessor.this.scopes.put(this.targetKey, GinScope.EAGER_SINGLETON);
            return null;
        }

        public Void visitScope(Scope scope) {
            this.messages.add(new Message("Explicit scope unsupported: key=" + this.targetKey + " scope=" + scope));
            return null;
        }

        public Void visitScopeAnnotation(Class<? extends Annotation> clazz) {
            if (clazz == Singleton.class) {
                BindingsProcessor.this.scopes.put(this.targetKey, GinScope.SINGLETON);
            } else {
                this.messages.add(new Message("Unsupported scope annoation: key=" + this.targetKey + " scope=" + clazz));
            }
            return null;
        }

        public Void visitNoScoping() {
            BindingsProcessor.this.scopes.put(this.targetKey, GinScope.NO_SCOPE);
            return null;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    class GuiceElementVisitor
    extends DefaultElementVisitor<Void> {
        private final List<Message> messages = new ArrayList<Message>();

        private GuiceElementVisitor() {
        }

        public <T> Void visit(com.google.inject.Binding<T> binding) {
            GuiceBindingVisitor guiceBindingVisitor = new GuiceBindingVisitor(binding.getKey(), this.messages);
            binding.acceptTargetVisitor(guiceBindingVisitor);
            binding.acceptScopingVisitor(guiceBindingVisitor);
            return null;
        }

        public Void visit(Message message) {
            this.messages.add(message);
            return null;
        }

        public <T> Void visit(ProviderLookup<T> providerLookup) {
            return null;
        }

        protected Void visitOther(Element element) {
            this.visit(new Message(element.getSource(), "Ignoring unsupported Module element: " + element));
            return null;
        }

        public Void visit(StaticInjectionRequest staticInjectionRequest) {
            this.addStaticInjectionRequest(staticInjectionRequest);
            return null;
        }

        public List<Message> getMessages() {
            return this.messages;
        }

        private void addStaticInjectionRequest(StaticInjectionRequest staticInjectionRequest) {
            Class clazz = staticInjectionRequest.getType();
            BindingsProcessor.this.staticInjectionRequests.add(clazz);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (InjectionPoint injectionPoint : InjectionPoint.forStaticMethodsAndFields((Class)clazz)) {
                Object object;
                JMethod jMethod;
                Member member = injectionPoint.getMember();
                if (member instanceof Method) {
                    jMethod = null;
                    try {
                        jMethod = BindingsProcessor.this.keyUtil.javaToGwtMethod((Method)member);
                    }
                    catch (NotFoundException notFoundException) {
                        this.messages.add(new Message(new ArrayList(), "Could not resolve GWT method: " + member, (Throwable)notFoundException));
                        return;
                    }
                    object = BindingsProcessor.this.keyUtil.getRequiredKeys((JAbstractMethod)jMethod);
                    hashSet.addAll(((RequiredKeys)object).getRequiredKeys());
                    hashSet2.addAll(((RequiredKeys)object).getOptionalKeys());
                    continue;
                }
                if (!(member instanceof Field)) continue;
                jMethod = BindingsProcessor.this.keyUtil.javaToGwtField((Field)member);
                object = BindingsProcessor.this.keyUtil.getKey((JField)jMethod);
                if (BindingsProcessor.this.keyUtil.isOptional((HasAnnotations)jMethod)) {
                    hashSet2.add((Key<?>)object);
                    continue;
                }
                hashSet.add((Key<?>)object);
            }
            BindingsProcessor.this.addRequiredKeys(BindingsProcessor.this.keyUtil.getKey(clazz, new Annotation[0]), new RequiredKeys(hashSet, hashSet2));
        }
    }
}

