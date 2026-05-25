/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

public class EventCountCircuitBreaker
extends AbstractCircuitBreaker<Integer> {
    private static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP = EventCountCircuitBreaker.createStrategyMap();
    private final AtomicReference<CheckIntervalData> checkIntervalData = new AtomicReference<CheckIntervalData>(new CheckIntervalData(0, 0L));
    private final int openingThreshold;
    private final long openingInterval;
    private final int closingThreshold;
    private final long closingInterval;

    public EventCountCircuitBreaker(int n2, long l2, TimeUnit timeUnit, int n3, long l3, TimeUnit timeUnit2) {
        this.openingThreshold = n2;
        this.openingInterval = timeUnit.toNanos(l2);
        this.closingThreshold = n3;
        this.closingInterval = timeUnit2.toNanos(l3);
    }

    public EventCountCircuitBreaker(int n2, long l2, TimeUnit timeUnit, int n3) {
        this(n2, l2, timeUnit, n3, l2, timeUnit);
    }

    public EventCountCircuitBreaker(int n2, long l2, TimeUnit timeUnit) {
        this(n2, l2, timeUnit, n2);
    }

    public int getOpeningThreshold() {
        return this.openingThreshold;
    }

    public long getOpeningInterval() {
        return this.openingInterval;
    }

    public int getClosingThreshold() {
        return this.closingThreshold;
    }

    public long getClosingInterval() {
        return this.closingInterval;
    }

    @Override
    public boolean checkState() {
        return this.performStateCheck(0);
    }

    @Override
    public boolean incrementAndCheckState(Integer n2) {
        return this.performStateCheck(n2);
    }

    public boolean incrementAndCheckState() {
        return this.incrementAndCheckState(1);
    }

    @Override
    public void open() {
        super.open();
        this.checkIntervalData.set(new CheckIntervalData(0, this.nanoTime()));
    }

    @Override
    public void close() {
        super.close();
        this.checkIntervalData.set(new CheckIntervalData(0, this.nanoTime()));
    }

    private boolean performStateCheck(int n2) {
        long l2;
        AbstractCircuitBreaker.State state;
        CheckIntervalData checkIntervalData;
        CheckIntervalData checkIntervalData2;
        do {
            l2 = this.nanoTime();
            state = (AbstractCircuitBreaker.State)((Object)this.state.get());
        } while (!this.updateCheckIntervalData(checkIntervalData2 = this.checkIntervalData.get(), checkIntervalData = this.nextCheckIntervalData(n2, checkIntervalData2, state, l2)));
        if (EventCountCircuitBreaker.stateStrategy(state).isStateTransition(this, checkIntervalData2, checkIntervalData)) {
            state = state.oppositeState();
            this.changeStateAndStartNewCheckInterval(state);
        }
        return !EventCountCircuitBreaker.isOpen(state);
    }

    private boolean updateCheckIntervalData(CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
        return checkIntervalData == checkIntervalData2 || this.checkIntervalData.compareAndSet(checkIntervalData, checkIntervalData2);
    }

    private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State state) {
        this.changeState(state);
        this.checkIntervalData.set(new CheckIntervalData(0, this.nanoTime()));
    }

    private CheckIntervalData nextCheckIntervalData(int n2, CheckIntervalData checkIntervalData, AbstractCircuitBreaker.State state, long l2) {
        CheckIntervalData checkIntervalData2 = EventCountCircuitBreaker.stateStrategy(state).isCheckIntervalFinished(this, checkIntervalData, l2) ? new CheckIntervalData(n2, l2) : checkIntervalData.increment(n2);
        return checkIntervalData2;
    }

    long nanoTime() {
        return System.nanoTime();
    }

    private static StateStrategy stateStrategy(AbstractCircuitBreaker.State state) {
        return STRATEGY_MAP.get((Object)state);
    }

    private static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
        EnumMap<AbstractCircuitBreaker.State, StateStrategy> enumMap = new EnumMap<AbstractCircuitBreaker.State, StateStrategy>(AbstractCircuitBreaker.State.class);
        enumMap.put(AbstractCircuitBreaker.State.CLOSED, new StateStrategyClosed());
        enumMap.put(AbstractCircuitBreaker.State.OPEN, new StateStrategyOpen());
        return enumMap;
    }

    static class StateStrategyOpen
    extends StateStrategy {
        private StateStrategyOpen() {
        }

        @Override
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getCheckIntervalStart() != checkIntervalData.getCheckIntervalStart() && checkIntervalData.getEventCount() < eventCountCircuitBreaker.getClosingThreshold();
        }

        @Override
        protected long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getClosingInterval();
        }
    }

    static class StateStrategyClosed
    extends StateStrategy {
        private StateStrategyClosed() {
        }

        @Override
        public boolean isStateTransition(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, CheckIntervalData checkIntervalData2) {
            return checkIntervalData2.getEventCount() > eventCountCircuitBreaker.getOpeningThreshold();
        }

        @Override
        protected long fetchCheckInterval(EventCountCircuitBreaker eventCountCircuitBreaker) {
            return eventCountCircuitBreaker.getOpeningInterval();
        }
    }

    static abstract class StateStrategy {
        private StateStrategy() {
        }

        public boolean isCheckIntervalFinished(EventCountCircuitBreaker eventCountCircuitBreaker, CheckIntervalData checkIntervalData, long l2) {
            return l2 - checkIntervalData.getCheckIntervalStart() > this.fetchCheckInterval(eventCountCircuitBreaker);
        }

        public abstract boolean isStateTransition(EventCountCircuitBreaker var1, CheckIntervalData var2, CheckIntervalData var3);

        protected abstract long fetchCheckInterval(EventCountCircuitBreaker var1);
    }

    static class CheckIntervalData {
        private final int eventCount;
        private final long checkIntervalStart;

        CheckIntervalData(int n2, long l2) {
            this.eventCount = n2;
            this.checkIntervalStart = l2;
        }

        public int getEventCount() {
            return this.eventCount;
        }

        public long getCheckIntervalStart() {
            return this.checkIntervalStart;
        }

        public CheckIntervalData increment(int n2) {
            return n2 == 0 ? this : new CheckIntervalData(this.getEventCount() + n2, this.getCheckIntervalStart());
        }
    }
}

