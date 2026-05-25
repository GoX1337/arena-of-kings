/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.files;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileHandle {
    protected File file;
    protected Files.FileType type;

    protected FileHandle() {
    }

    public FileHandle(String string) {
        this.file = new File(string);
        this.type = Files.FileType.Absolute;
    }

    public FileHandle(File file) {
        this.file = file;
        this.type = Files.FileType.Absolute;
    }

    public FileHandle(String string, Files.FileType fileType) {
        this.type = fileType;
        this.file = new File(string);
    }

    public FileHandle(File file, Files.FileType fileType) {
        this.file = file;
        this.type = fileType;
    }

    public String path() {
        return this.file.getPath().replace('\\', '/');
    }

    public String name() {
        return this.file.getName();
    }

    public String extension() {
        String string = this.file.getName();
        int n2 = string.lastIndexOf(46);
        if (n2 == -1) {
            return "";
        }
        return string.substring(n2 + 1);
    }

    public String nameWithoutExtension() {
        String string = this.file.getName();
        int n2 = string.lastIndexOf(46);
        if (n2 == -1) {
            return string;
        }
        return string.substring(0, n2);
    }

    public String pathWithoutExtension() {
        String string = this.file.getPath().replace('\\', '/');
        int n2 = string.lastIndexOf(46);
        if (n2 == -1) {
            return string;
        }
        return string.substring(0, n2);
    }

    public Files.FileType type() {
        return this.type;
    }

    public File file() {
        if (this.type == Files.FileType.External) {
            return new File(Gdx.files.getExternalStoragePath(), this.file.getPath());
        }
        return this.file;
    }

    public InputStream read() {
        if (this.type == Files.FileType.Classpath || this.type == Files.FileType.Internal && !this.file().exists() || this.type == Files.FileType.Local && !this.file().exists()) {
            InputStream inputStream = FileHandle.class.getResourceAsStream("/" + this.file.getPath().replace('\\', '/'));
            if (inputStream == null) {
                throw new GdxRuntimeException("File not found: " + this.file + " (" + (Object)((Object)this.type) + ")");
            }
            return inputStream;
        }
        try {
            return new FileInputStream(this.file());
        }
        catch (Exception exception) {
            if (this.file().isDirectory()) {
                throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + (Object)((Object)this.type) + ")", exception);
            }
            throw new GdxRuntimeException("Error reading file: " + this.file + " (" + (Object)((Object)this.type) + ")", exception);
        }
    }

    public BufferedInputStream read(int n2) {
        return new BufferedInputStream(this.read(), n2);
    }

    public Reader reader() {
        return new InputStreamReader(this.read());
    }

    public Reader reader(String string) {
        InputStream inputStream = this.read();
        try {
            return new InputStreamReader(inputStream, string);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            StreamUtils.closeQuietly(inputStream);
            throw new GdxRuntimeException("Error reading file: " + this, unsupportedEncodingException);
        }
    }

    public BufferedReader reader(int n2) {
        return new BufferedReader(new InputStreamReader(this.read()), n2);
    }

    public BufferedReader reader(int n2, String string) {
        try {
            return new BufferedReader(new InputStreamReader(this.read(), string), n2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new GdxRuntimeException("Error reading file: " + this, unsupportedEncodingException);
        }
    }

    public String readString() {
        return this.readString(null);
    }

    public String readString(String string) {
        StringBuilder stringBuilder = new StringBuilder(this.estimateLength());
        InputStreamReader inputStreamReader = null;
        try {
            int n2;
            inputStreamReader = string == null ? new InputStreamReader(this.read()) : new InputStreamReader(this.read(), string);
            char[] cArray = new char[256];
            while ((n2 = inputStreamReader.read(cArray)) != -1) {
                stringBuilder.append(cArray, 0, n2);
            }
        }
        catch (IOException iOException) {
            try {
                throw new GdxRuntimeException("Error reading layout file: " + this, iOException);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(inputStreamReader);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(inputStreamReader);
        return stringBuilder.toString();
    }

    public byte[] readBytes() {
        InputStream inputStream = this.read();
        try {
            byte[] byArray = StreamUtils.copyStreamToByteArray(inputStream, this.estimateLength());
            return byArray;
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error reading file: " + this, iOException);
        }
        finally {
            StreamUtils.closeQuietly(inputStream);
        }
    }

    private int estimateLength() {
        int n2 = (int)this.length();
        return n2 != 0 ? n2 : 512;
    }

    public int readBytes(byte[] byArray, int n2, int n3) {
        InputStream inputStream = this.read();
        int n4 = 0;
        try {
            int n5;
            while ((n5 = inputStream.read(byArray, n2 + n4, n3 - n4)) > 0) {
                n4 += n5;
            }
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error reading file: " + this, iOException);
        }
        finally {
            StreamUtils.closeQuietly(inputStream);
        }
        return n4 - n2;
    }

    public ByteBuffer map() {
        return this.map(FileChannel.MapMode.READ_ONLY);
    }

    public ByteBuffer map(FileChannel.MapMode mapMode) {
        MappedByteBuffer mappedByteBuffer;
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot map a classpath file: " + this);
        }
        RandomAccessFile randomAccessFile = null;
        try {
            File file = this.file();
            randomAccessFile = new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            MappedByteBuffer mappedByteBuffer2 = fileChannel.map(mapMode, 0L, file.length());
            mappedByteBuffer2.order(ByteOrder.nativeOrder());
            mappedByteBuffer = mappedByteBuffer2;
        }
        catch (Exception exception) {
            try {
                throw new GdxRuntimeException("Error memory mapping file: " + this + " (" + (Object)((Object)this.type) + ")", exception);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(randomAccessFile);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(randomAccessFile);
        return mappedByteBuffer;
    }

    public OutputStream write(boolean bl2) {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot write to a classpath file: " + this.file);
        }
        if (this.type == Files.FileType.Internal) {
            throw new GdxRuntimeException("Cannot write to an internal file: " + this.file);
        }
        this.parent().mkdirs();
        try {
            return new FileOutputStream(this.file(), bl2);
        }
        catch (Exception exception) {
            if (this.file().isDirectory()) {
                throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + (Object)((Object)this.type) + ")", exception);
            }
            throw new GdxRuntimeException("Error writing file: " + this.file + " (" + (Object)((Object)this.type) + ")", exception);
        }
    }

    public OutputStream write(boolean bl2, int n2) {
        return new BufferedOutputStream(this.write(bl2), n2);
    }

    public void write(InputStream inputStream, boolean bl2) {
        OutputStream outputStream = null;
        try {
            outputStream = this.write(bl2);
            StreamUtils.copyStream(inputStream, outputStream);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error stream writing to file: " + this.file + " (" + (Object)((Object)this.type) + ")", exception);
        }
        finally {
            StreamUtils.closeQuietly(inputStream);
            StreamUtils.closeQuietly(outputStream);
        }
    }

    public Writer writer(boolean bl2) {
        return this.writer(bl2, null);
    }

    public Writer writer(boolean bl2, String string) {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot write to a classpath file: " + this.file);
        }
        if (this.type == Files.FileType.Internal) {
            throw new GdxRuntimeException("Cannot write to an internal file: " + this.file);
        }
        this.parent().mkdirs();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.file(), bl2);
            if (string == null) {
                return new OutputStreamWriter(fileOutputStream);
            }
            return new OutputStreamWriter((OutputStream)fileOutputStream, string);
        }
        catch (IOException iOException) {
            if (this.file().isDirectory()) {
                throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + (Object)((Object)this.type) + ")", iOException);
            }
            throw new GdxRuntimeException("Error writing file: " + this.file + " (" + (Object)((Object)this.type) + ")", iOException);
        }
    }

    public void writeString(String string, boolean bl2) {
        this.writeString(string, bl2, null);
    }

    public void writeString(String string, boolean bl2, String string2) {
        Writer writer = null;
        try {
            writer = this.writer(bl2, string2);
            writer.write(string);
        }
        catch (Exception exception) {
            try {
                throw new GdxRuntimeException("Error writing file: " + this.file + " (" + (Object)((Object)this.type) + ")", exception);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(writer);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(writer);
    }

    public void writeBytes(byte[] byArray, boolean bl2) {
        OutputStream outputStream = this.write(bl2);
        try {
            outputStream.write(byArray);
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error writing file: " + this.file + " (" + (Object)((Object)this.type) + ")", iOException);
        }
        finally {
            StreamUtils.closeQuietly(outputStream);
        }
    }

    public void writeBytes(byte[] byArray, int n2, int n3, boolean bl2) {
        OutputStream outputStream = this.write(bl2);
        try {
            outputStream.write(byArray, n2, n3);
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Error writing file: " + this.file + " (" + (Object)((Object)this.type) + ")", iOException);
        }
        finally {
            StreamUtils.closeQuietly(outputStream);
        }
    }

    public FileHandle[] list() {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        String[] stringArray = this.file().list();
        if (stringArray == null) {
            return new FileHandle[0];
        }
        FileHandle[] fileHandleArray = new FileHandle[stringArray.length];
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            fileHandleArray[i2] = this.child(stringArray[i2]);
        }
        return fileHandleArray;
    }

    public FileHandle[] list(FileFilter fileFilter) {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        File file = this.file();
        String[] stringArray = file.list();
        if (stringArray == null) {
            return new FileHandle[0];
        }
        FileHandle[] fileHandleArray = new FileHandle[stringArray.length];
        int n2 = 0;
        int n3 = stringArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            String string = stringArray[i2];
            FileHandle fileHandle = this.child(string);
            if (!fileFilter.accept(fileHandle.file())) continue;
            fileHandleArray[n2] = fileHandle;
            ++n2;
        }
        if (n2 < stringArray.length) {
            FileHandle[] fileHandleArray2 = new FileHandle[n2];
            System.arraycopy(fileHandleArray, 0, fileHandleArray2, 0, n2);
            fileHandleArray = fileHandleArray2;
        }
        return fileHandleArray;
    }

    public FileHandle[] list(FilenameFilter filenameFilter) {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        File file = this.file();
        String[] stringArray = file.list();
        if (stringArray == null) {
            return new FileHandle[0];
        }
        FileHandle[] fileHandleArray = new FileHandle[stringArray.length];
        int n2 = 0;
        int n3 = stringArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            String string = stringArray[i2];
            if (!filenameFilter.accept(file, string)) continue;
            fileHandleArray[n2] = this.child(string);
            ++n2;
        }
        if (n2 < stringArray.length) {
            FileHandle[] fileHandleArray2 = new FileHandle[n2];
            System.arraycopy(fileHandleArray, 0, fileHandleArray2, 0, n2);
            fileHandleArray = fileHandleArray2;
        }
        return fileHandleArray;
    }

    public FileHandle[] list(String string) {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        String[] stringArray = this.file().list();
        if (stringArray == null) {
            return new FileHandle[0];
        }
        FileHandle[] fileHandleArray = new FileHandle[stringArray.length];
        int n2 = 0;
        int n3 = stringArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            String string2 = stringArray[i2];
            if (!string2.endsWith(string)) continue;
            fileHandleArray[n2] = this.child(string2);
            ++n2;
        }
        if (n2 < stringArray.length) {
            FileHandle[] fileHandleArray2 = new FileHandle[n2];
            System.arraycopy(fileHandleArray, 0, fileHandleArray2, 0, n2);
            fileHandleArray = fileHandleArray2;
        }
        return fileHandleArray;
    }

    public boolean isDirectory() {
        if (this.type == Files.FileType.Classpath) {
            return false;
        }
        return this.file().isDirectory();
    }

    public FileHandle child(String string) {
        if (this.file.getPath().length() == 0) {
            return new FileHandle(new File(string), this.type);
        }
        return new FileHandle(new File(this.file, string), this.type);
    }

    public FileHandle sibling(String string) {
        if (this.file.getPath().length() == 0) {
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return new FileHandle(new File(this.file.getParent(), string), this.type);
    }

    public FileHandle parent() {
        File file = this.file.getParentFile();
        if (file == null) {
            file = this.type == Files.FileType.Absolute ? new File("/") : new File("");
        }
        return new FileHandle(file, this.type);
    }

    public void mkdirs() {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot mkdirs with a classpath file: " + this.file);
        }
        if (this.type == Files.FileType.Internal) {
            throw new GdxRuntimeException("Cannot mkdirs with an internal file: " + this.file);
        }
        this.file().mkdirs();
    }

    public boolean exists() {
        switch (this.type) {
            case Internal: {
                if (this.file().exists()) {
                    return true;
                }
            }
            case Classpath: {
                return FileHandle.class.getResource("/" + this.file.getPath().replace('\\', '/')) != null;
            }
        }
        return this.file().exists();
    }

    public boolean delete() {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file);
        }
        if (this.type == Files.FileType.Internal) {
            throw new GdxRuntimeException("Cannot delete an internal file: " + this.file);
        }
        return this.file().delete();
    }

    public boolean deleteDirectory() {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file);
        }
        if (this.type == Files.FileType.Internal) {
            throw new GdxRuntimeException("Cannot delete an internal file: " + this.file);
        }
        return FileHandle.deleteDirectory(this.file());
    }

    public void emptyDirectory() {
        this.emptyDirectory(false);
    }

    public void emptyDirectory(boolean bl2) {
        if (this.type == Files.FileType.Classpath) {
            throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file);
        }
        if (this.type == Files.FileType.Internal) {
            throw new GdxRuntimeException("Cannot delete an internal file: " + this.file);
        }
        FileHandle.emptyDirectory(this.file(), bl2);
    }

    public void copyTo(FileHandle fileHandle) {
        if (!this.isDirectory()) {
            if (fileHandle.isDirectory()) {
                fileHandle = fileHandle.child(this.name());
            }
            FileHandle.copyFile(this, fileHandle);
            return;
        }
        if (fileHandle.exists()) {
            if (!fileHandle.isDirectory()) {
                throw new GdxRuntimeException("Destination exists but is not a directory: " + fileHandle);
            }
        } else {
            fileHandle.mkdirs();
            if (!fileHandle.isDirectory()) {
                throw new GdxRuntimeException("Destination directory cannot be created: " + fileHandle);
            }
        }
        FileHandle.copyDirectory(this, fileHandle.child(this.name()));
    }

    public void moveTo(FileHandle fileHandle) {
        switch (this.type) {
            case Classpath: {
                throw new GdxRuntimeException("Cannot move a classpath file: " + this.file);
            }
            case Internal: {
                throw new GdxRuntimeException("Cannot move an internal file: " + this.file);
            }
            case Absolute: 
            case External: {
                if (!this.file().renameTo(fileHandle.file())) break;
                return;
            }
        }
        this.copyTo(fileHandle);
        this.delete();
        if (this.exists() && this.isDirectory()) {
            this.deleteDirectory();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long length() {
        if (this.type == Files.FileType.Classpath || this.type == Files.FileType.Internal && !this.file.exists()) {
            InputStream inputStream = this.read();
            try {
                long l2 = inputStream.available();
                return l2;
            }
            catch (Exception exception) {
            }
            finally {
                StreamUtils.closeQuietly(inputStream);
            }
            return 0L;
        }
        return this.file().length();
    }

    public long lastModified() {
        return this.file().lastModified();
    }

    public boolean equals(Object object) {
        if (!(object instanceof FileHandle)) {
            return false;
        }
        FileHandle fileHandle = (FileHandle)object;
        return this.type == fileHandle.type && this.path().equals(fileHandle.path());
    }

    public int hashCode() {
        int n2 = 1;
        n2 = n2 * 37 + this.type.hashCode();
        n2 = n2 * 67 + this.path().hashCode();
        return n2;
    }

    public String toString() {
        return this.file.getPath().replace('\\', '/');
    }

    public static FileHandle tempFile(String string) {
        try {
            return new FileHandle(File.createTempFile(string, null));
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Unable to create temp file.", iOException);
        }
    }

    public static FileHandle tempDirectory(String string) {
        try {
            File file = File.createTempFile(string, null);
            if (!file.delete()) {
                throw new IOException("Unable to delete temp file: " + file);
            }
            if (!file.mkdir()) {
                throw new IOException("Unable to create temp directory: " + file);
            }
            return new FileHandle(file);
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Unable to create temp file.", iOException);
        }
    }

    private static void emptyDirectory(File file, boolean bl2) {
        File[] fileArray;
        if (file.exists() && (fileArray = file.listFiles()) != null) {
            int n2 = fileArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!fileArray[i2].isDirectory()) {
                    fileArray[i2].delete();
                    continue;
                }
                if (bl2) {
                    FileHandle.emptyDirectory(fileArray[i2], true);
                    continue;
                }
                FileHandle.deleteDirectory(fileArray[i2]);
            }
        }
    }

    private static boolean deleteDirectory(File file) {
        FileHandle.emptyDirectory(file, false);
        return file.delete();
    }

    private static void copyFile(FileHandle fileHandle, FileHandle fileHandle2) {
        try {
            fileHandle2.write(fileHandle.read(), false);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error copying source file: " + fileHandle.file + " (" + (Object)((Object)fileHandle.type) + ")\nTo destination: " + fileHandle2.file + " (" + (Object)((Object)fileHandle2.type) + ")", exception);
        }
    }

    private static void copyDirectory(FileHandle fileHandle, FileHandle fileHandle2) {
        fileHandle2.mkdirs();
        for (FileHandle fileHandle3 : fileHandle.list()) {
            FileHandle fileHandle4 = fileHandle2.child(fileHandle3.name());
            if (fileHandle3.isDirectory()) {
                FileHandle.copyDirectory(fileHandle3, fileHandle4);
                continue;
            }
            FileHandle.copyFile(fileHandle3, fileHandle4);
        }
    }
}

