/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DurationUtils;

public class ThreadUtils {
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();

    public static Thread findThreadById(long l2) {
        Collection<Thread> collection = ThreadUtils.findThreads(new ThreadIdPredicate(l2));
        return collection.isEmpty() ? null : collection.iterator().next();
    }

    public static Thread findThreadById(long l2, String string) {
        Validate.notNull(string, "threadGroupName", new Object[0]);
        Thread thread = ThreadUtils.findThreadById(l2);
        if (thread != null && thread.getThreadGroup() != null && thread.getThreadGroup().getName().equals(string)) {
            return thread;
        }
        return null;
    }

    public static Thread findThreadById(long l2, ThreadGroup threadGroup) {
        Validate.notNull(threadGroup, "threadGroup", new Object[0]);
        Thread thread = ThreadUtils.findThreadById(l2);
        if (thread != null && threadGroup.equals(thread.getThreadGroup())) {
            return thread;
        }
        return null;
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean bl2, ThreadGroupPredicate threadGroupPredicate) {
        ThreadGroup[] threadGroupArray;
        Validate.notNull(threadGroup, "group", new Object[0]);
        Validate.notNull(threadGroupPredicate, "predicate", new Object[0]);
        int n2 = threadGroup.activeGroupCount();
        while ((n2 = threadGroup.enumerate(threadGroupArray = new ThreadGroup[n2 + n2 / 2 + 1], bl2)) >= threadGroupArray.length) {
        }
        ArrayList<ThreadGroup> arrayList = new ArrayList<ThreadGroup>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!threadGroupPredicate.test(threadGroupArray[i2])) continue;
            arrayList.add(threadGroupArray[i2]);
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate threadGroupPredicate) {
        return ThreadUtils.findThreadGroups(ThreadUtils.getSystemThreadGroup(), true, threadGroupPredicate);
    }

    public static Collection<ThreadGroup> findThreadGroupsByName(String string) {
        return ThreadUtils.findThreadGroups(new NamePredicate(string));
    }

    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean bl2, ThreadPredicate threadPredicate) {
        Thread[] threadArray;
        Validate.notNull(threadGroup, "The group must not be null", new Object[0]);
        Validate.notNull(threadPredicate, "The predicate must not be null", new Object[0]);
        int n2 = threadGroup.activeCount();
        while ((n2 = threadGroup.enumerate(threadArray = new Thread[n2 + n2 / 2 + 1], bl2)) >= threadArray.length) {
        }
        ArrayList<Thread> arrayList = new ArrayList<Thread>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!threadPredicate.test(threadArray[i2])) continue;
            arrayList.add(threadArray[i2]);
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<Thread> findThreads(ThreadPredicate threadPredicate) {
        return ThreadUtils.findThreads(ThreadUtils.getSystemThreadGroup(), true, threadPredicate);
    }

    public static Collection<Thread> findThreadsByName(String string) {
        return ThreadUtils.findThreads(new NamePredicate(string));
    }

    public static Collection<Thread> findThreadsByName(String string, String string2) {
        Validate.notNull(string, "threadName", new Object[0]);
        Validate.notNull(string2, "threadGroupName", new Object[0]);
        Collection<ThreadGroup> collection = ThreadUtils.findThreadGroups(new NamePredicate(string2));
        if (collection.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<Thread> arrayList = new ArrayList<Thread>();
        NamePredicate namePredicate = new NamePredicate(string);
        for (ThreadGroup threadGroup : collection) {
            arrayList.addAll(ThreadUtils.findThreads(threadGroup, false, namePredicate));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<Thread> findThreadsByName(String string, ThreadGroup threadGroup) {
        return ThreadUtils.findThreads(threadGroup, false, new NamePredicate(string));
    }

    public static Collection<ThreadGroup> getAllThreadGroups() {
        return ThreadUtils.findThreadGroups(ALWAYS_TRUE_PREDICATE);
    }

    public static Collection<Thread> getAllThreads() {
        return ThreadUtils.findThreads(ALWAYS_TRUE_PREDICATE);
    }

    public static ThreadGroup getSystemThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    public static void join(Thread thread, Duration duration) {
        DurationUtils.accept(thread::join, duration);
    }

    public static void sleep(Duration duration) {
        DurationUtils.accept(Thread::sleep, duration);
    }

    @FunctionalInterface
    public static interface ThreadPredicate {
        public boolean test(Thread var1);
    }

    public static class ThreadIdPredicate
    implements ThreadPredicate {
        private final long threadId;

        public ThreadIdPredicate(long l2) {
            if (l2 <= 0L) {
                throw new IllegalArgumentException("The thread id must be greater than zero");
            }
            this.threadId = l2;
        }

        @Override
        public boolean test(Thread thread) {
            return thread != null && thread.getId() == this.threadId;
        }
    }

    @FunctionalInterface
    public static interface ThreadGroupPredicate {
        public boolean test(ThreadGroup var1);
    }

    public static class NamePredicate
    implements ThreadGroupPredicate,
    ThreadPredicate {
        private final String name;

        public NamePredicate(String string) {
            Validate.notNull(string, "name", new Object[0]);
            this.name = string;
        }

        @Override
        public boolean test(Thread thread) {
            return thread != null && thread.getName().equals(this.name);
        }

        @Override
        public boolean test(ThreadGroup threadGroup) {
            return threadGroup != null && threadGroup.getName().equals(this.name);
        }
    }

    static final class AlwaysTruePredicate
    implements ThreadGroupPredicate,
    ThreadPredicate {
        private AlwaysTruePredicate() {
        }

        @Override
        public boolean test(Thread thread) {
            return true;
        }

        @Override
        public boolean test(ThreadGroup threadGroup) {
            return true;
        }
    }
}

