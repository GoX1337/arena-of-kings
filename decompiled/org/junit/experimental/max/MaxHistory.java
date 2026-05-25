/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.experimental.max.CouldNotReadCoreException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MaxHistory
implements Serializable {
    private static final long serialVersionUID = 1L;
    public final Map<String, Long> fDurations = new HashMap<String, Long>();
    public final Map<String, Long> fFailureTimestamps = new HashMap<String, Long>();
    public final File fFolder;

    public static MaxHistory forFolder(File file) {
        try {
            if (file.exists()) {
                return MaxHistory.readHistory(file);
            }
        }
        catch (CouldNotReadCoreException couldNotReadCoreException) {
            couldNotReadCoreException.printStackTrace();
            file.delete();
        }
        return new MaxHistory(file);
    }

    private static MaxHistory readHistory(File file) {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        }
        catch (IOException iOException) {
            throw new CouldNotReadCoreException(iOException);
        }
        try {
            MaxHistory maxHistory = (MaxHistory)objectInputStream.readObject();
            return maxHistory;
        }
        catch (Exception exception) {
            throw new CouldNotReadCoreException(exception);
        }
        finally {
            try {
                objectInputStream.close();
            }
            catch (IOException iOException) {
                throw new CouldNotReadCoreException(iOException);
            }
        }
    }

    public MaxHistory(File file) {
        this.fFolder = file;
    }

    public File getFile() {
        return this.fFolder;
    }

    public void save() {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fFolder));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    Long getFailureTimestamp(Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    void putTestFailureTimestamp(Description description, long l2) {
        this.fFailureTimestamps.put(description.toString(), l2);
    }

    boolean isNewTest(Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    Long getTestDuration(Description description) {
        return this.fDurations.get(description.toString());
    }

    void putTestDuration(Description description, long l2) {
        this.fDurations.put(description.toString(), l2);
    }

    public a listener() {
        return new a(this);
    }

    public Comparator<Description> testComparator() {
        return new b();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    class b
    implements Comparator<Description> {
        private b() {
        }

        public int a(Description description, Description description2) {
            if (MaxHistory.this.isNewTest(description)) {
                return -1;
            }
            if (MaxHistory.this.isNewTest(description2)) {
                return 1;
            }
            int n2 = this.a(description2).compareTo(this.a(description));
            return n2 != 0 ? n2 : MaxHistory.this.getTestDuration(description).compareTo(MaxHistory.this.getTestDuration(description2));
        }

        private Long a(Description description) {
            Long l2 = MaxHistory.this.getFailureTimestamp(description);
            if (l2 == null) {
                return 0L;
            }
            return l2;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((Description)object, (Description)object2);
        }
    }

    final class a
    extends RunListener {
        private long var_long_a = (long)new HashMap();
        private Map<Description, Long> cfr_renamed_58;
        final /* synthetic */ MaxHistory var_org_junit_experimental_max_MaxHistory_a;

        private a(MaxHistory maxHistory) {
            this.var_org_junit_experimental_max_MaxHistory_a = maxHistory;
        }

        public void testStarted(Description description) {
            this.var_long_a.put(description, System.nanoTime());
        }

        public void testFinished(Description description) {
            long l2 = System.nanoTime();
            long l3 = (Long)this.var_long_a.get(description);
            this.var_org_junit_experimental_max_MaxHistory_a.putTestDuration(description, l2 - l3);
        }

        public void testFailure(Failure failure) {
            this.var_org_junit_experimental_max_MaxHistory_a.putTestFailureTimestamp(failure.getDescription(), this.var_long_a);
        }
    }
}

