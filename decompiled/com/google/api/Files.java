/*
 * Decompiled with CFR 0.152.
 */
package com.google.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Files {
    private Files() {
    }

    public static void write(File file, String string) {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(string);
        bufferedWriter.close();
    }

    public static String read(File file) {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((string = bufferedReader.readLine()) != null) {
            stringBuilder.append(string);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}

