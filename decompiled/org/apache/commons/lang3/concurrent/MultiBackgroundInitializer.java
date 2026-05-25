/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.apache.commons.lang3.concurrent.ConcurrentException;

public class MultiBackgroundInitializer
extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    private final Map<String, BackgroundInitializer<?>> childInitializers = new HashMap();

    public MultiBackgroundInitializer() {
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addInitializer(String string, BackgroundInitializer<?> backgroundInitializer) {
        Validate.notNull(string, "name", new Object[0]);
        Validate.notNull(backgroundInitializer, "backgroundInitializer", new Object[0]);
        MultiBackgroundInitializer multiBackgroundInitializer = this;
        synchronized (multiBackgroundInitializer) {
            if (this.isStarted()) {
                throw new IllegalStateException("addInitializer() must not be called after start()!");
            }
            this.childInitializers.put(string, backgroundInitializer);
        }
    }

    @Override
    protected int getTaskCount() {
        int n2 = 1;
        for (BackgroundInitializer<?> backgroundInitializer : this.childInitializers.values()) {
            n2 += backgroundInitializer.getTaskCount();
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected MultiBackgroundInitializerResults initialize() {
        Object object3;
        HashMap hashMap;
        Object object2 = this;
        synchronized (object2) {
            hashMap = new HashMap(this.childInitializers);
        }
        object2 = this.getActiveExecutor();
        for (Object object3 : hashMap.values()) {
            if (((BackgroundInitializer)object3).getExternalExecutor() == null) {
                ((BackgroundInitializer)object3).setExternalExecutor((ExecutorService)object2);
            }
            ((BackgroundInitializer)object3).start();
        }
        HashMap hashMap2 = new HashMap();
        object3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), ((BackgroundInitializer)entry.getValue()).get());
            }
            catch (ConcurrentException concurrentException) {
                object3.put(entry.getKey(), concurrentException);
            }
        }
        return new MultiBackgroundInitializerResults(hashMap, hashMap2, (Map)object3);
    }

    public static class MultiBackgroundInitializerResults {
        private final Map<String, BackgroundInitializer<?>> initializers;
        private final Map<String, Object> resultObjects;
        private final Map<String, ConcurrentException> exceptions;

        private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }

        public BackgroundInitializer<?> getInitializer(String string) {
            return this.checkName(string);
        }

        public Object getResultObject(String string) {
            this.checkName(string);
            return this.resultObjects.get(string);
        }

        public boolean isException(String string) {
            this.checkName(string);
            return this.exceptions.containsKey(string);
        }

        public ConcurrentException getException(String string) {
            this.checkName(string);
            return this.exceptions.get(string);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.initializers.keySet());
        }

        public boolean isSuccessful() {
            return this.exceptions.isEmpty();
        }

        private BackgroundInitializer<?> checkName(String string) {
            BackgroundInitializer<?> backgroundInitializer = this.initializers.get(string);
            if (backgroundInitializer == null) {
                throw new NoSuchElementException("No child initializer with name " + string);
            }
            return backgroundInitializer;
        }
    }
}

