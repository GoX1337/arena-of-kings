/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ImmutableSerializer;
import com.esotericsoftware.kryo.util.Util;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class TimeSerializers {
    public static void addDefaultSerializers(Kryo kryo) {
        if (Util.isClassAvailable("java.time.Duration")) {
            kryo.addDefaultSerializer(Duration.class, DurationSerializer.class);
        }
        if (Util.isClassAvailable("java.time.Instant")) {
            kryo.addDefaultSerializer(Instant.class, InstantSerializer.class);
        }
        if (Util.isClassAvailable("java.time.LocalDate")) {
            kryo.addDefaultSerializer(LocalDate.class, LocalDateSerializer.class);
        }
        if (Util.isClassAvailable("java.time.LocalTime")) {
            kryo.addDefaultSerializer(LocalTime.class, LocalTimeSerializer.class);
        }
        if (Util.isClassAvailable("java.time.LocalDateTime")) {
            kryo.addDefaultSerializer(LocalDateTime.class, LocalDateTimeSerializer.class);
        }
        if (Util.isClassAvailable("java.time.ZoneOffset")) {
            kryo.addDefaultSerializer(ZoneOffset.class, ZoneOffsetSerializer.class);
        }
        if (Util.isClassAvailable("java.time.ZoneId")) {
            kryo.addDefaultSerializer(ZoneId.class, ZoneIdSerializer.class);
        }
        if (Util.isClassAvailable("java.time.OffsetTime")) {
            kryo.addDefaultSerializer(OffsetTime.class, OffsetTimeSerializer.class);
        }
        if (Util.isClassAvailable("java.time.OffsetDateTime")) {
            kryo.addDefaultSerializer(OffsetDateTime.class, OffsetDateTimeSerializer.class);
        }
        if (Util.isClassAvailable("java.time.ZonedDateTime")) {
            kryo.addDefaultSerializer(ZonedDateTime.class, ZonedDateTimeSerializer.class);
        }
        if (Util.isClassAvailable("java.time.Year")) {
            kryo.addDefaultSerializer(Year.class, YearSerializer.class);
        }
        if (Util.isClassAvailable("java.time.YearMonth")) {
            kryo.addDefaultSerializer(YearMonth.class, YearMonthSerializer.class);
        }
        if (Util.isClassAvailable("java.time.MonthDay")) {
            kryo.addDefaultSerializer(MonthDay.class, MonthDaySerializer.class);
        }
        if (Util.isClassAvailable("java.time.Period")) {
            kryo.addDefaultSerializer(Period.class, PeriodSerializer.class);
        }
    }

    public static class PeriodSerializer
    extends ImmutableSerializer<Period> {
        @Override
        public void write(Kryo kryo, Output output, Period period) {
            output.writeVarInt(period.getYears(), true);
            output.writeVarInt(period.getMonths(), true);
            output.writeVarInt(period.getDays(), true);
        }

        @Override
        public Period read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readInt(true);
            int n3 = input.readInt(true);
            int n4 = input.readInt(true);
            return Period.of(n2, n3, n4);
        }
    }

    public static class MonthDaySerializer
    extends ImmutableSerializer<MonthDay> {
        @Override
        public void write(Kryo kryo, Output output, MonthDay monthDay) {
            output.writeByte(monthDay.getMonthValue());
            output.writeByte(monthDay.getDayOfMonth());
        }

        @Override
        public MonthDay read(Kryo kryo, Input input, Class clazz) {
            byte by2 = input.readByte();
            byte by3 = input.readByte();
            return MonthDay.of(by2, (int)by3);
        }
    }

    public static class YearMonthSerializer
    extends ImmutableSerializer<YearMonth> {
        @Override
        public void write(Kryo kryo, Output output, YearMonth yearMonth) {
            output.writeVarInt(yearMonth.getYear(), true);
            output.writeByte(yearMonth.getMonthValue());
        }

        @Override
        public YearMonth read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readInt(true);
            byte by2 = input.readByte();
            return YearMonth.of(n2, by2);
        }
    }

    public static class YearSerializer
    extends ImmutableSerializer<Year> {
        @Override
        public void write(Kryo kryo, Output output, Year year) {
            output.writeVarInt(year.getValue(), true);
        }

        @Override
        public Year read(Kryo kryo, Input input, Class clazz) {
            return Year.of(input.readInt(true));
        }
    }

    public static class ZonedDateTimeSerializer
    extends ImmutableSerializer<ZonedDateTime> {
        @Override
        public void write(Kryo kryo, Output output, ZonedDateTime zonedDateTime) {
            LocalDateSerializer.write(output, zonedDateTime.toLocalDate());
            LocalTimeSerializer.write(output, zonedDateTime.toLocalTime());
            ZoneIdSerializer.write(output, zonedDateTime.getZone());
        }

        @Override
        public ZonedDateTime read(Kryo kryo, Input input, Class clazz) {
            LocalDate localDate = LocalDateSerializer.read(input);
            LocalTime localTime = LocalTimeSerializer.read(input);
            ZoneId zoneId = ZoneIdSerializer.read(input);
            return ZonedDateTime.of(localDate, localTime, zoneId);
        }
    }

    public static class OffsetDateTimeSerializer
    extends ImmutableSerializer<OffsetDateTime> {
        @Override
        public void write(Kryo kryo, Output output, OffsetDateTime offsetDateTime) {
            LocalDateSerializer.write(output, offsetDateTime.toLocalDate());
            LocalTimeSerializer.write(output, offsetDateTime.toLocalTime());
            ZoneOffsetSerializer.write(output, offsetDateTime.getOffset());
        }

        @Override
        public OffsetDateTime read(Kryo kryo, Input input, Class clazz) {
            LocalDate localDate = LocalDateSerializer.read(input);
            LocalTime localTime = LocalTimeSerializer.read(input);
            ZoneOffset zoneOffset = ZoneOffsetSerializer.read(input);
            return OffsetDateTime.of(localDate, localTime, zoneOffset);
        }
    }

    public static class OffsetTimeSerializer
    extends ImmutableSerializer<OffsetTime> {
        @Override
        public void write(Kryo kryo, Output output, OffsetTime offsetTime) {
            LocalTimeSerializer.write(output, offsetTime.toLocalTime());
            ZoneOffsetSerializer.write(output, offsetTime.getOffset());
        }

        @Override
        public OffsetTime read(Kryo kryo, Input input, Class clazz) {
            LocalTime localTime = LocalTimeSerializer.read(input);
            ZoneOffset zoneOffset = ZoneOffsetSerializer.read(input);
            return OffsetTime.of(localTime, zoneOffset);
        }
    }

    public static class ZoneIdSerializer
    extends ImmutableSerializer<ZoneId> {
        @Override
        public void write(Kryo kryo, Output output, ZoneId zoneId) {
            ZoneIdSerializer.write(output, zoneId);
        }

        static void write(Output output, ZoneId zoneId) {
            output.writeString(zoneId.getId());
        }

        @Override
        public ZoneId read(Kryo kryo, Input input, Class clazz) {
            return ZoneIdSerializer.read(input);
        }

        static ZoneId read(Input input) {
            String string = input.readString();
            return ZoneId.of(string);
        }
    }

    public static class ZoneOffsetSerializer
    extends ImmutableSerializer<ZoneOffset> {
        @Override
        public void write(Kryo kryo, Output output, ZoneOffset zoneOffset) {
            ZoneOffsetSerializer.write(output, zoneOffset);
        }

        static void write(Output output, ZoneOffset zoneOffset) {
            int n2 = zoneOffset.getTotalSeconds();
            int n3 = n2 % 900 == 0 ? n2 / 900 : 127;
            output.writeByte(n3);
            if (n3 == 127) {
                output.writeInt(n2);
            }
        }

        @Override
        public ZoneOffset read(Kryo kryo, Input input, Class clazz) {
            return ZoneOffsetSerializer.read(input);
        }

        static ZoneOffset read(Input input) {
            byte by2 = input.readByte();
            return by2 == 127 ? ZoneOffset.ofTotalSeconds(input.readInt()) : ZoneOffset.ofTotalSeconds(by2 * 900);
        }
    }

    public static class LocalTimeSerializer
    extends ImmutableSerializer<LocalTime> {
        @Override
        public void write(Kryo kryo, Output output, LocalTime localTime) {
            LocalTimeSerializer.write(output, localTime);
        }

        static void write(Output output, LocalTime localTime) {
            if (localTime.getNano() == 0) {
                if (localTime.getSecond() == 0) {
                    if (localTime.getMinute() == 0) {
                        output.writeByte(~localTime.getHour());
                    } else {
                        output.writeByte(localTime.getHour());
                        output.writeByte(~localTime.getMinute());
                    }
                } else {
                    output.writeByte(localTime.getHour());
                    output.writeByte(localTime.getMinute());
                    output.writeByte(~localTime.getSecond());
                }
            } else {
                output.writeByte(localTime.getHour());
                output.writeByte(localTime.getMinute());
                output.writeByte(localTime.getSecond());
                output.writeInt(localTime.getNano(), true);
            }
        }

        @Override
        public LocalTime read(Kryo kryo, Input input, Class clazz) {
            return LocalTimeSerializer.read(input);
        }

        static LocalTime read(Input input) {
            int n2 = input.readByte();
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            if (n2 < 0) {
                n2 ^= 0xFFFFFFFF;
            } else {
                n3 = input.readByte();
                if (n3 < 0) {
                    n3 ^= 0xFFFFFFFF;
                } else {
                    n4 = input.readByte();
                    if (n4 < 0) {
                        n4 ^= 0xFFFFFFFF;
                    } else {
                        n5 = input.readInt(true);
                    }
                }
            }
            return LocalTime.of(n2, n3, n4, n5);
        }
    }

    public static class LocalDateTimeSerializer
    extends ImmutableSerializer<LocalDateTime> {
        @Override
        public void write(Kryo kryo, Output output, LocalDateTime localDateTime) {
            LocalDateSerializer.write(output, localDateTime.toLocalDate());
            LocalTimeSerializer.write(output, localDateTime.toLocalTime());
        }

        @Override
        public LocalDateTime read(Kryo kryo, Input input, Class clazz) {
            LocalDate localDate = LocalDateSerializer.read(input);
            LocalTime localTime = LocalTimeSerializer.read(input);
            return LocalDateTime.of(localDate, localTime);
        }
    }

    public static class LocalDateSerializer
    extends ImmutableSerializer<LocalDate> {
        @Override
        public void write(Kryo kryo, Output output, LocalDate localDate) {
            LocalDateSerializer.write(output, localDate);
        }

        static void write(Output output, LocalDate localDate) {
            output.writeInt(localDate.getYear(), true);
            output.writeByte(localDate.getMonthValue());
            output.writeByte(localDate.getDayOfMonth());
        }

        @Override
        public LocalDate read(Kryo kryo, Input input, Class clazz) {
            return LocalDateSerializer.read(input);
        }

        static LocalDate read(Input input) {
            int n2 = input.readInt(true);
            byte by2 = input.readByte();
            byte by3 = input.readByte();
            return LocalDate.of(n2, by2, (int)by3);
        }
    }

    public static class InstantSerializer
    extends ImmutableSerializer<Instant> {
        @Override
        public void write(Kryo kryo, Output output, Instant instant) {
            output.writeVarLong(instant.getEpochSecond(), true);
            output.writeInt(instant.getNano(), true);
        }

        @Override
        public Instant read(Kryo kryo, Input input, Class clazz) {
            long l2 = input.readVarLong(true);
            int n2 = input.readInt(true);
            return Instant.ofEpochSecond(l2, n2);
        }
    }

    public static class DurationSerializer
    extends ImmutableSerializer<Duration> {
        @Override
        public void write(Kryo kryo, Output output, Duration duration) {
            output.writeLong(duration.getSeconds());
            output.writeInt(duration.getNano(), true);
        }

        @Override
        public Duration read(Kryo kryo, Input input, Class clazz) {
            long l2 = input.readLong();
            int n2 = input.readInt(true);
            return Duration.ofSeconds(l2, n2);
        }
    }
}

