/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractSensors;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.tuples.Triplet;

@ThreadSafe
final class OpenBsdSensors
extends AbstractSensors {
    private final Supplier<Triplet<Double, int[], Double>> tempFanVolts = Memoizer.memoize(OpenBsdSensors::querySensors, Memoizer.defaultExpiration());

    OpenBsdSensors() {
    }

    @Override
    public double queryCpuTemperature() {
        return this.tempFanVolts.get().getA();
    }

    @Override
    public int[] queryFanSpeeds() {
        return this.tempFanVolts.get().getB();
    }

    @Override
    public double queryCpuVoltage() {
        return this.tempFanVolts.get().getC();
    }

    private static Triplet<Double, int[], Double> querySensors() {
        Object[] objectArray;
        double d2 = 0.0;
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        for (String string : ExecutingCommand.runNative("systat -ab sensors")) {
            objectArray = ParseUtil.whitespaces.split(string);
            if (objectArray.length <= 1) continue;
            if (objectArray[0].contains("cpu")) {
                if (objectArray[0].contains("temp0")) {
                    arrayList.add(ParseUtil.parseDoubleOrDefault(objectArray[1], Double.NaN));
                    continue;
                }
                if (!objectArray[0].contains("volt0")) continue;
                d2 = ParseUtil.parseDoubleOrDefault(objectArray[1], 0.0);
                continue;
            }
            if (objectArray[0].contains("temp0")) {
                arrayList2.add(ParseUtil.parseDoubleOrDefault(objectArray[1], Double.NaN));
                continue;
            }
            if (!objectArray[0].contains("fan")) continue;
            arrayList3.add(ParseUtil.parseIntOrDefault(objectArray[1], 0));
        }
        double d3 = arrayList.isEmpty() ? OpenBsdSensors.listAverage(arrayList2) : OpenBsdSensors.listAverage(arrayList);
        objectArray = new int[arrayList3.size()];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2] = (String)((Object)((Integer)arrayList3.get(i2)));
        }
        return new Triplet<Double, String[], Double>(d3, (String[])objectArray, d2);
    }

    private static double listAverage(List<Double> list) {
        double d2 = 0.0;
        int n2 = 0;
        for (Double d3 : list) {
            if (d3.isNaN()) continue;
            d2 += d3.doubleValue();
            ++n2;
        }
        return n2 > 0 ? d2 / (double)n2 : 0.0;
    }
}

