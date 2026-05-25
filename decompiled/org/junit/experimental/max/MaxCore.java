/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.max;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.experimental.max.MaxHistory;
import org.junit.internal.requests.SortingRequest;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MaxCore {
    public final MaxHistory fHistory;

    public static MaxCore forFolder(String string) {
        return MaxCore.storedLocally(new File(string));
    }

    public static MaxCore storedLocally(File file) {
        return new MaxCore(file);
    }

    public MaxCore(File file) {
        this.fHistory = MaxHistory.forFolder(file);
    }

    public Result run(Class<?> clazz) {
        return this.run(Request.aClass(clazz));
    }

    public Result run(Request request) {
        return this.run(request, new JUnitCore());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Result run(Request request, JUnitCore jUnitCore) {
        jUnitCore.addListener(this.fHistory.listener());
        try {
            Result result = jUnitCore.run(this.sortRequest(request).getRunner());
            return result;
        }
        finally {
            try {
                this.fHistory.save();
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public Request sortRequest(Request request) {
        if (request instanceof SortingRequest) {
            return request;
        }
        List<Description> list = this.findLeaves(request);
        Collections.sort(list, this.fHistory.testComparator());
        return this.constructLeafRequest(list);
    }

    public Request constructLeafRequest(List<Description> list) {
        ArrayList<Runner> arrayList = new ArrayList<Runner>();
        for (Description description : list) {
            arrayList.add(this.buildRunner(description));
        }
        return new bxx(this, arrayList);
    }

    public Runner buildRunner(Description description) {
        Class<?> clazz;
        if (description.toString().equals("TestSuite with 0 tests")) {
            try {
                return new Suite(null, (Class<?>[])new Class[0]);
            }
            catch (InitializationError initializationError) {
                initializationError.printStackTrace();
            }
        }
        if ((clazz = description.getTestClass()) == null) {
            throw new RuntimeException("Can't build a runner from description [" + description + "]");
        }
        String string = description.getMethodName();
        if (string == null) {
            return Request.aClass(clazz).getRunner();
        }
        return Request.method(clazz, string).getRunner();
    }

    public List<Description> sortedLeavesForTest(Request request) {
        return this.findLeaves(this.sortRequest(request));
    }

    public List<Description> findLeaves(Request request) {
        ArrayList<Description> arrayList = new ArrayList<Description>();
        this.findLeaves(request.getRunner().getDescription(), arrayList);
        return arrayList;
    }

    public void findLeaves(Description description, List<Description> list) {
        if (description.getChildren().isEmpty()) {
            list.add(description);
        } else {
            for (Description description2 : description.getChildren()) {
                this.findLeaves(description2, list);
            }
        }
    }
}

