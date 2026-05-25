/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.platform.FileMonitor;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class W32FileMonitor
extends FileMonitor {
    private static final Logger LOG = Logger.getLogger(W32FileMonitor.class.getName());
    private static final int BUFFER_SIZE = 4096;
    private Thread watcher;
    private WinNT.HANDLE port;
    private final Map<File, FileInfo> fileMap = new HashMap<File, FileInfo>();
    private final Map<WinNT.HANDLE, FileInfo> handleMap = new HashMap<WinNT.HANDLE, FileInfo>();
    private boolean disposing = false;
    private static int watcherThreadID;

    private void handleChanges(FileInfo fileInfo) {
        Kernel32 kernel32 = Kernel32.INSTANCE;
        WinNT.FILE_NOTIFY_INFORMATION fILE_NOTIFY_INFORMATION = fileInfo.info;
        fILE_NOTIFY_INFORMATION.read();
        do {
            FileMonitor.FileEvent fileEvent = null;
            File file = new File(fileInfo.file, fILE_NOTIFY_INFORMATION.getFilename());
            switch (fILE_NOTIFY_INFORMATION.Action) {
                case 0: {
                    break;
                }
                case 3: {
                    fileEvent = new FileMonitor.FileEvent(file, 4);
                    break;
                }
                case 1: {
                    fileEvent = new FileMonitor.FileEvent(file, 1);
                    break;
                }
                case 2: {
                    fileEvent = new FileMonitor.FileEvent(file, 2);
                    break;
                }
                case 4: {
                    fileEvent = new FileMonitor.FileEvent(file, 16);
                    break;
                }
                case 5: {
                    fileEvent = new FileMonitor.FileEvent(file, 32);
                    break;
                }
                default: {
                    LOG.log(Level.WARNING, "Unrecognized file action ''{0}''", fILE_NOTIFY_INFORMATION.Action);
                }
            }
            if (fileEvent == null) continue;
            this.notify(fileEvent);
        } while ((fILE_NOTIFY_INFORMATION = fILE_NOTIFY_INFORMATION.next()) != null);
        if (!fileInfo.file.exists()) {
            this.unwatch(fileInfo.file);
            return;
        }
        if (!kernel32.ReadDirectoryChangesW(fileInfo.handle, fileInfo.info, fileInfo.info.size(), fileInfo.recursive, fileInfo.notifyMask, fileInfo.infoLength, fileInfo.overlapped, null) && !this.disposing) {
            int n2 = kernel32.GetLastError();
            throw new IOException("ReadDirectoryChangesW failed on " + fileInfo.file + ": '" + Kernel32Util.formatMessageFromLastErrorCode(n2) + "' (" + n2 + ")");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FileInfo waitForChange() {
        IntByReference intByReference = new IntByReference();
        BaseTSD.ULONG_PTRByReference uLONG_PTRByReference = new BaseTSD.ULONG_PTRByReference();
        PointerByReference pointerByReference = new PointerByReference();
        if (!Kernel32.INSTANCE.GetQueuedCompletionStatus(this.port, intByReference, uLONG_PTRByReference, pointerByReference, -1)) {
            return null;
        }
        W32FileMonitor w32FileMonitor = this;
        synchronized (w32FileMonitor) {
            return this.handleMap.get(new WinNT.HANDLE(uLONG_PTRByReference.getValue().toPointer()));
        }
    }

    private int convertMask(int n2) {
        int n3 = 0;
        if ((n2 & 1) != 0) {
            n3 |= 0x40;
        }
        if ((n2 & 2) != 0) {
            n3 |= 3;
        }
        if ((n2 & 4) != 0) {
            n3 |= 0x10;
        }
        if ((n2 & 0x30) != 0) {
            n3 |= 3;
        }
        if ((n2 & 0x40) != 0) {
            n3 |= 8;
        }
        if ((n2 & 8) != 0) {
            n3 |= 0x20;
        }
        if ((n2 & 0x80) != 0) {
            n3 |= 4;
        }
        if ((n2 & 0x100) != 0) {
            n3 |= 0x100;
        }
        return n3;
    }

    @Override
    public synchronized void watch(File file, int n2, boolean bl2) {
        File file2 = file;
        if (!file2.isDirectory()) {
            bl2 = false;
            file2 = file.getParentFile();
        }
        while (file2 != null && !file2.exists()) {
            bl2 = true;
            file2 = file2.getParentFile();
        }
        if (file2 == null) {
            throw new FileNotFoundException("No ancestor found for " + file);
        }
        Kernel32 kernel32 = Kernel32.INSTANCE;
        int n3 = 7;
        int n4 = 0x42000000;
        WinNT.HANDLE hANDLE = kernel32.CreateFile(file.getAbsolutePath(), 1, n3, null, 3, n4, null);
        if (WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
            throw new IOException("Unable to open " + file + " (" + kernel32.GetLastError() + ")");
        }
        int n5 = this.convertMask(n2);
        FileInfo fileInfo = new FileInfo(file, hANDLE, n5, bl2);
        this.fileMap.put(file, fileInfo);
        this.handleMap.put(hANDLE, fileInfo);
        this.port = kernel32.CreateIoCompletionPort(hANDLE, this.port, hANDLE.getPointer(), 0);
        if (WinBase.INVALID_HANDLE_VALUE.equals(this.port)) {
            throw new IOException("Unable to create/use I/O Completion port for " + file + " (" + kernel32.GetLastError() + ")");
        }
        if (!kernel32.ReadDirectoryChangesW(hANDLE, fileInfo.info, fileInfo.info.size(), bl2, n5, fileInfo.infoLength, fileInfo.overlapped, null)) {
            int n6 = kernel32.GetLastError();
            throw new IOException("ReadDirectoryChangesW failed on " + fileInfo.file + ", handle " + hANDLE + ": '" + Kernel32Util.formatMessageFromLastErrorCode(n6) + "' (" + n6 + ")");
        }
        if (this.watcher == null) {
            this.watcher = new Thread("W32 File Monitor-" + watcherThreadID++){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    while (true) {
                        FileInfo fileInfo;
                        if ((fileInfo = W32FileMonitor.this.waitForChange()) == null) {
                            W32FileMonitor w32FileMonitor = W32FileMonitor.this;
                            synchronized (w32FileMonitor) {
                                if (W32FileMonitor.this.fileMap.isEmpty()) {
                                    W32FileMonitor.this.watcher = null;
                                    break;
                                }
                            }
                        }
                        try {
                            W32FileMonitor.this.handleChanges(fileInfo);
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                }
            };
            this.watcher.setDaemon(true);
            this.watcher.start();
        }
    }

    @Override
    public synchronized void unwatch(File file) {
        FileInfo fileInfo = this.fileMap.remove(file);
        if (fileInfo != null) {
            this.handleMap.remove(fileInfo.handle);
            Kernel32 kernel32 = Kernel32.INSTANCE;
            kernel32.CloseHandle(fileInfo.handle);
        }
    }

    @Override
    public synchronized void dispose() {
        this.disposing = true;
        int n2 = 0;
        Object object = this.fileMap.keySet().toArray();
        while (!this.fileMap.isEmpty()) {
            this.unwatch((File)object[n2++]);
        }
        object = Kernel32.INSTANCE;
        object.PostQueuedCompletionStatus(this.port, 0, null, null);
        object.CloseHandle(this.port);
        this.port = null;
        this.watcher = null;
    }

    class FileInfo {
        public final File file;
        public final WinNT.HANDLE handle;
        public final int notifyMask;
        public final boolean recursive;
        public final WinNT.FILE_NOTIFY_INFORMATION info = new WinNT.FILE_NOTIFY_INFORMATION(4096);
        public final IntByReference infoLength = new IntByReference();
        public final WinBase.OVERLAPPED overlapped = new WinBase.OVERLAPPED();

        public FileInfo(File file, WinNT.HANDLE hANDLE, int n2, boolean bl2) {
            this.file = file;
            this.handle = hANDLE;
            this.notifyMask = n2;
            this.recursive = bl2;
        }
    }
}

