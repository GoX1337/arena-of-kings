/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailablePredicate;

public class Streams {
    public static <O> FailableStream<O> stream(Collection<O> collection) {
        return Streams.stream(collection.stream());
    }

    public static <O> FailableStream<O> stream(Stream<O> stream) {
        return new FailableStream<O>(stream);
    }

    public static <O> Collector<O, ?, O[]> toArray(Class<O> clazz) {
        return new ArrayCollector<O>(clazz);
    }

    public static class FailableStream<O> {
        private Stream<O> stream;
        private boolean terminated;

        public FailableStream(Stream<O> stream) {
            this.stream = stream;
        }

        public boolean allMatch(FailablePredicate<O, ?> failablePredicate) {
            this.assertNotTerminated();
            return this.stream().allMatch(Failable.asPredicate(failablePredicate));
        }

        public boolean anyMatch(FailablePredicate<O, ?> failablePredicate) {
            this.assertNotTerminated();
            return this.stream().anyMatch(Failable.asPredicate(failablePredicate));
        }

        protected void assertNotTerminated() {
            if (this.terminated) {
                throw new IllegalStateException("This stream is already terminated.");
            }
        }

        public <A, R> R collect(Collector<? super O, A, R> collector) {
            this.makeTerminated();
            return this.stream().collect(collector);
        }

        public <A, R> R collect(Supplier<R> supplier, BiConsumer<R, ? super O> biConsumer, BiConsumer<R, R> biConsumer2) {
            this.makeTerminated();
            return this.stream().collect(supplier, biConsumer, biConsumer2);
        }

        public FailableStream<O> filter(FailablePredicate<O, ?> failablePredicate) {
            this.assertNotTerminated();
            this.stream = this.stream.filter(Failable.asPredicate(failablePredicate));
            return this;
        }

        public void forEach(FailableConsumer<O, ?> failableConsumer) {
            this.makeTerminated();
            this.stream().forEach(Failable.asConsumer(failableConsumer));
        }

        protected void makeTerminated() {
            this.assertNotTerminated();
            this.terminated = true;
        }

        public <R> FailableStream<R> map(FailableFunction<O, R, ?> failableFunction) {
            this.assertNotTerminated();
            return new FailableStream<R>(this.stream.map(Failable.asFunction(failableFunction)));
        }

        public O reduce(O o2, BinaryOperator<O> binaryOperator) {
            this.makeTerminated();
            return this.stream().reduce(o2, binaryOperator);
        }

        public Stream<O> stream() {
            return this.stream;
        }
    }

    public static class ArrayCollector<O>
    implements Collector<O, List<O>, O[]> {
        private static final Set<Collector.Characteristics> characteristics = Collections.emptySet();
        private final Class<O> elementType;

        public ArrayCollector(Class<O> clazz) {
            this.elementType = clazz;
        }

        @Override
        public BiConsumer<List<O>, O> accumulator() {
            return List::add;
        }

        @Override
        public Set<Collector.Characteristics> characteristics() {
            return characteristics;
        }

        @Override
        public BinaryOperator<List<O>> combiner() {
            return (list, list2) -> {
                list.addAll(list2);
                return list;
            };
        }

        @Override
        public Function<List<O>, O[]> finisher() {
            return list -> {
                Object[] objectArray = (Object[])Array.newInstance(this.elementType, list.size());
                return list.toArray(objectArray);
            };
        }

        @Override
        public Supplier<List<O>> supplier() {
            return ArrayList::new;
        }
    }
}

