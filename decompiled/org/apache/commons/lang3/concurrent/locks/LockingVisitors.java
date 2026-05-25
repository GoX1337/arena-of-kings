/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent.locks;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;

public class LockingVisitors {
    public static <O> ReadWriteLockVisitor<O> reentrantReadWriteLockVisitor(O o2) {
        return new ReadWriteLockVisitor<O>(o2, new ReentrantReadWriteLock());
    }

    public static <O> StampedLockVisitor<O> stampedLockVisitor(O o2) {
        return new StampedLockVisitor<O>(o2, new StampedLock());
    }

    public static class StampedLockVisitor<O>
    extends LockVisitor<O, StampedLock> {
        protected StampedLockVisitor(O o2, StampedLock stampedLock) {
            super(o2, stampedLock, stampedLock::asReadLock, stampedLock::asWriteLock);
        }
    }

    public static class ReadWriteLockVisitor<O>
    extends LockVisitor<O, ReadWriteLock> {
        protected ReadWriteLockVisitor(O o2, ReadWriteLock readWriteLock) {
            super(o2, readWriteLock, readWriteLock::readLock, readWriteLock::writeLock);
        }
    }

    public static class LockVisitor<O, L> {
        private final L lock;
        private final O object;
        private final Supplier<Lock> readLockSupplier;
        private final Supplier<Lock> writeLockSupplier;

        protected LockVisitor(O o2, L l2, Supplier<Lock> supplier, Supplier<Lock> supplier2) {
            this.object = Objects.requireNonNull(o2, "object");
            this.lock = Objects.requireNonNull(l2, "lock");
            this.readLockSupplier = Objects.requireNonNull(supplier, "readLockSupplier");
            this.writeLockSupplier = Objects.requireNonNull(supplier2, "writeLockSupplier");
        }

        public void acceptReadLocked(FailableConsumer<O, ?> failableConsumer) {
            this.lockAcceptUnlock(this.readLockSupplier, failableConsumer);
        }

        public void acceptWriteLocked(FailableConsumer<O, ?> failableConsumer) {
            this.lockAcceptUnlock(this.writeLockSupplier, failableConsumer);
        }

        public <T> T applyReadLocked(FailableFunction<O, T, ?> failableFunction) {
            return this.lockApplyUnlock(this.readLockSupplier, failableFunction);
        }

        public <T> T applyWriteLocked(FailableFunction<O, T, ?> failableFunction) {
            return this.lockApplyUnlock(this.writeLockSupplier, failableFunction);
        }

        public L getLock() {
            return this.lock;
        }

        public O getObject() {
            return this.object;
        }

        protected void lockAcceptUnlock(Supplier<Lock> supplier, FailableConsumer<O, ?> failableConsumer) {
            Lock lock = supplier.get();
            lock.lock();
            try {
                failableConsumer.accept(this.object);
            }
            catch (Throwable throwable) {
                throw Failable.rethrow(throwable);
            }
            finally {
                lock.unlock();
            }
        }

        protected <T> T lockApplyUnlock(Supplier<Lock> supplier, FailableFunction<O, T, ?> failableFunction) {
            Lock lock = supplier.get();
            lock.lock();
            try {
                T t2 = failableFunction.apply(this.object);
                return t2;
            }
            catch (Throwable throwable) {
                throw Failable.rethrow(throwable);
            }
            finally {
                lock.unlock();
            }
        }
    }
}

