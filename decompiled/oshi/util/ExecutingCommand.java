/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import com.sun.jna.Platform;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class ExecutingCommand {
    private static final Logger LOG = LoggerFactory.getLogger(ExecutingCommand.class);
    private static final String[] DEFAULT_ENV = ExecutingCommand.getDefaultEnv();

    private ExecutingCommand() {
    }

    private static String[] getDefaultEnv() {
        if (Platform.isWindows()) {
            return new String[]{"LANGUAGE=C"};
        }
        return new String[]{"LC_ALL=C"};
    }

    public static List<String> runNative(String string) {
        String[] stringArray = string.split(" ");
        return ExecutingCommand.runNative(stringArray);
    }

    public static List<String> runNative(String[] stringArray) {
        return ExecutingCommand.runNative(stringArray, DEFAULT_ENV);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<String> runNative(String[] stringArray, String[] stringArray2) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(stringArray, stringArray2);
            List<String> list = ExecutingCommand.getProcessOutput(process, stringArray);
            return list;
        }
        catch (IOException | SecurityException exception) {
            LOG.trace("Couldn't run command {}: {}", (Object)Arrays.toString(stringArray), (Object)exception.getMessage());
        }
        finally {
            if (process != null) {
                if (Platform.isWindows() || Platform.isSolaris()) {
                    try {
                        process.getOutputStream().close();
                    }
                    catch (IOException iOException) {}
                    try {
                        process.getInputStream().close();
                    }
                    catch (IOException iOException) {}
                    try {
                        process.getErrorStream().close();
                    }
                    catch (IOException iOException) {}
                }
                process.destroy();
            }
        }
        return Collections.emptyList();
    }

    private static List<String> getProcessOutput(Process process, String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.defaultCharset()));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
            process.waitFor();
        }
        catch (IOException iOException) {
            LOG.trace("Problem reading output from {}: {}", (Object)Arrays.toString(stringArray), (Object)iOException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            LOG.trace("Interrupted while reading output from {}: {}", (Object)Arrays.toString(stringArray), (Object)interruptedException.getMessage());
            Thread.currentThread().interrupt();
        }
        return arrayList;
    }

    public static String getFirstAnswer(String string) {
        return ExecutingCommand.getAnswerAt(string, 0);
    }

    public static String getAnswerAt(String string, int n2) {
        List<String> list = ExecutingCommand.runNative(string);
        if (n2 >= 0 && n2 < list.size()) {
            return list.get(n2);
        }
        return "";
    }
}

