/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

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
import org.apache.commons.lang3.Functions;

@Deprecated
public class Streams {
    public static <O> FailableStream<O> stream(Stream<O> stream) {
        return new FailableStream<O>(stream);
    }

    public static <O> FailableStream<O> stream(Collection<O> collection) {
        return Streams.stream(collection.stream());
    }

    public static <O> Collector<O, ?, O[]> toArray(Class<O> clazz) {
        return new ArrayCollector<O>(clazz);
    }

    @Deprecated
    public static class ArrayCollector<O>
    implements Collector<O, List<O>, O[]> {
        private static final Set<Collector.Characteristics> characteristics = Collections.emptySet();
        private final Class<O> elementType;

        public ArrayCollector(Class<O> clazz) {
            this.elementType = clazz;
        }

        @Override
        public Supplier<List<O>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<O>, O> accumulator() {
            return List::add;
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
        public Set<Collector.Characteristics> characteristics() {
            return characteristics;
        }
    }

    @Deprecated
    public static class FailableStream<O> {
        private Stream<O> stream;
        private boolean terminated;

        public FailableStream(Stream<O> stream) {
            this.stream = stream;
        }

        protected void assertNotTerminated() {
            if (this.terminated) {
                throw new IllegalStateException("This stream is already terminated.");
            }
        }

        protected void makeTerminated() {
            this.assertNotTerminated();
            this.terminated = true;
        }

        public FailableStream<O> filter(Functions.FailablePredicate<O, ?> failablePredicate) {
            this.assertNotTerminated();
            this.stream = this.stream.filter(Functions.asPredicate(failablePredicate));
            return this;
        }

        public void forEach(Functions.FailableConsumer<O, ?> failableConsumer) {
            this.makeTerminated();
            this.stream().forEach(Functions.asConsumer(failableConsumer));
        }

        public <A, R> R collect(Collector<? super O, A, R> collector) {
            this.makeTerminated();
            return this.stream().collect(collector);
        }

        public <A, R> R collect(Supplier<R> supplier, BiConsumer<R, ? super O> biConsumer, BiConsumer<R, R> biConsumer2) {
            this.makeTerminated();
            return this.stream().collect(supplier, biConsumer, biConsumer2);
        }

        public O reduce(O o2, BinaryOperator<O> binaryOperator) {
            this.makeTerminated();
            return this.stream().reduce(o2, binaryOperator);
        }

        public <R> FailableStream<R> map(Functions.FailableFunction<O, R, ?> failableFunction) {
            this.assertNotTerminated();
            return new FailableStream<R>(this.stream.map(Functions.asFunction(failableFunction)));
        }

        public Stream<O> stream() {
            return this.stream;
        }

        public boolean allMatch(Functions.FailablePredicate<O, ?> failablePredicate) {
            this.assertNotTerminated();
            return this.stream().allMatch(Functions.asPredicate(failablePredicate));
        }

        public boolean anyMatch(Functions.FailablePredicate<O, ?> failablePredicate) {
            this.assertNotTerminated();
            return this.stream().anyMatch(Functions.asPredicate(failablePredicate));
        }
    }
}

